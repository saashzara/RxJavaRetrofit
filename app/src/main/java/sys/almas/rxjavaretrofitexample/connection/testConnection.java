package sys.almas.rxjavaretrofitexample.connection;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sys.almas.rxjavaretrofitexample.interfaces.WebApiSuccessInterface;
import sys.almas.rxjavaretrofitexample.base.MasterRetrofitConnection;
import sys.almas.rxjavaretrofitexample.model.SampleModel;

public class testConnection extends
        MasterRetrofitConnection<WebApiSuccessInterface<List<SampleModel>>> {

    /**
     * ***********************
     * @param param input
     * @return disposable
     */
    public Disposable getDataFromServer(String param) {

        Retrofit retrofit = initRetrofit(null);
        testConnection.Api interfaceApi = retrofit.create(testConnection.Api.class);

        return interfaceApi.getList(param)
                .observeOn(AndroidSchedulers.mainThread())
        .map(getSuccessMapper())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError);
    }

    private void handleResponse(List<SampleModel> response) {
        mWebApiListener.onSuccessRetrieved(response);
    }

    private interface Api {
        @GET("User/GetCommandsByUserName")
        Observable<List<SampleModel>> getList(@Query("username")String username);

//        @GET("users/{username}")
//         Observable<model> getUser(@Path("username") String username);


//        @POST("users/new")
//         Observable<model> createUser(@Body User user);


//        @Headers({"Cache-Control: max-age=640000", "User-Agent: My-App-Name"})
//        @GET("/some/endpoint")
//         Observable<model> createUser(@Body User user);


//        @Multipart
//        @POST("/some/endpoint")
//        Observable<model> someEndpoint(@Header("Cache-Control") int maxAge)
//


//        @POST("/posts")
//        @FormUrlEncoded
//        Observable<model> savePost(@Field("title") String title,
//                            @Field("body") String body,
//                            @Field("userId") long userId);

//        @DELETE("gists/{id}")
//        Observable<model> deleteGist(@Path("id") String id);
    }

}
