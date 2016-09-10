package com.xyc.hasee.robot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String mAskUrl = "http://op.juhe.cn/robot/index?info=%s&key=%s";
    private static final String mCodeTypeUrl = "http://op.juhe.cn/robot/code=%d&key=%s";

    private String askContent;
    private String TAG = "xyc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = String.format(mAskUrl, "2222", "3333");
        Log.d(TAG, "onCreate:url= " + url);
        //getResultDatas();
    }

    private void getResultDatas() {
        OkHttpClient mClient = new OkHttpClient();
        Request mRequest = new Request.Builder()
                .url(String.format(mAskUrl, askContent))
                .build();
        mClient.newCall(mRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonData = response.body().string();
                try {
                    JSONObject resultObj = new JSONObject(jsonData);
                    JSONObject result = resultObj.getJSONObject("result");
                    String code = result.getString("code");
                    String text = result.getString("text");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
