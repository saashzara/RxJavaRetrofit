package sys.almas.rxjavaretrofitexample.base;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.json.JSONObject;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sys.almas.rxjavaretrofitexample.interfaces.WebApiErrorInterface;
 import sys.almas.rxjavaretrofitexample.model.BaseServerResponse;

public class MasterRetrofitConnection<T extends WebApiErrorInterface> {
    public T mWebApiListener;
    public static final String BASE_URL = "https://46.4.72.48/";
    private static Retrofit retrofit = null;

    protected static OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
                                                                 String authType) throws CertificateException {
                        }

                        @Override public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
                                                                 String authType) throws CertificateException {
                        }

                        @Override public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[] {};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public static Retrofit initRetrofit(@Nullable OkHttpClient.Builder client) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
  if (client==null)
      client= getUnsafeOkHttpClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit;
    }





    public void onFailure(Call call, Throwable t) {
        sendError("error onFailure");
    }

    protected void sendError(String message) {
        if (mWebApiListener != null) mWebApiListener.errorInWebservice(message);
    }

    @NonNull
    protected <K extends Object> Function<K, K> getSuccessMapper() {
        return t -> {
            if (t instanceof BaseServerResponse) {
                throwErrorIfUnsuccessful((BaseServerResponse) t);
            }
            return t;
        };
    }

    protected void throwErrorIfUnsuccessful(BaseServerResponse response) {
//        if (!response.isSuccess()) {
//            throw Exceptions.propagate(new WebServiceError(response.getMessage(), response));
//        }
    }



    protected RequestBody makeRequestBody(JSONObject object) {
         RequestBody body =
                RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                        object.toString());
        return body;
    }

    public final void handleError(Throwable error) {
        error.printStackTrace();
        if (error.getCause() != null  ) {
//            sendError(error.getCause().getMessage());
        } else if (error instanceof SocketTimeoutException) {
//            sendError(getString(R.string.message_webservice_error_network));
        } else if (error instanceof UnknownHostException) {
//            sendError("اینترنت قطع است.");
        }else if(error instanceof NullPointerException) {
//            sendError("NullPointerException");
        } else {
//            sendError("مشکل در ارتباط با سرور");
        }
    }


    public void setWebApiListener(T listener) {
        this.mWebApiListener = listener;
    }



}
