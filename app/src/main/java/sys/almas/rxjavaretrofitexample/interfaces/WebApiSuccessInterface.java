package sys.almas.rxjavaretrofitexample.interfaces;

public interface WebApiSuccessInterface<T>  extends WebApiErrorInterface{
    void onSuccessRetrieved(T data);
}
