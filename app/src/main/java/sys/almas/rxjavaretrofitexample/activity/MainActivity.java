package sys.almas.rxjavaretrofitexample.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import sys.almas.rxjavaretrofitexample.R;
import sys.almas.rxjavaretrofitexample.interfaces.WebApiSuccessInterface;
import sys.almas.rxjavaretrofitexample.model.SampleModel;
import sys.almas.rxjavaretrofitexample.connection.testConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testConnection testClass=new testConnection();

        testClass.setWebApiListener(new WebApiSuccessInterface<List<SampleModel>>() {
            @Override
            public void onSuccessRetrieved(List<SampleModel> data) {
                Toast.makeText(MainActivity.this, "onSuccessRetrieved", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void errorInWebservice(String error) {
                Toast.makeText(MainActivity.this, "errorInWebservice", Toast.LENGTH_SHORT).show();

            }
        });

        testClass.getDataFromServer("tabasi.test.2");
    }
}
