package com.example.commonutil.module.json.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.commonutil.R;
import com.example.commonutil.base.AppBaseActivity;
import com.example.library.util.DoJson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestJsonOneActivity extends AppBaseActivity {
    private  String string = " {\"root\":\"[\"{\\\"one\\\":\\\"one\\\",\\\"two\\\":\\\"two\\\"," +
            "\\\"three\\\":\\\"three\\\"}\",\"{\\\"one\\\":\\\"one\\\",\\\"two\\\":\\\"two\\\"," +
            "\\\"three\\\":\\\"three\\\"}\",\"{\\\"one\\\":\\\"one\\\",\\\"two\\\":\\\\\\\"two\\\\\\\",\\\\\\\"three\\\\\\\":\\\\\\\"three\\\\\\\"}\\\"]\",\"message\":\"[\\\"{\\\\\\\"one\\\\\\\":\\\\\\\"one\\\\\\\",\\\\\\\"two\\\\\\\":\\\\\\\"two\\\\\\\",\\\\\\\"three\\\\\\\":\\\\\\\"three\\\\\\\"}\\\"]\"}";
    private String json="{\"org_tag\":\"1101191001\",\"userId\":\"111\",\"warn_list\":\"[{\\\"start_time\\\":\\\"05:00\\\",\\\"end_time\\\":\\\"07:00\\\",\\\"warn_type\\\":\\\"被盗抢,布控,假牌,套牌,在逃,临控,违法犯罪,涉恐,重性精神病,涉毒\\\"},{\\\"start_time\\\":\\\"00:00\\\",\\\"end_time\\\":\\\"01:00\\\",\\\"warn_type\\\":\\\"被盗抢,布控,假牌,套牌,在逃,临控\\\"}]\"}";
    private String str1 ="{\"1\":\"[\\\"one\\\",\\\"two\\\"]\",\"2\":\"[\\\"AA\\\",\\\"BB\\\"]\"}";
    TextView tv_json_one_one;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_one);

        initViews();
        bindData();
    }

    @Override
    public void initViews() {
        super.initViews();
        tv_json_one_one = findViewById(R.id.tv_json_one_one);
        tv_json_one_one.setText("");
        Log.d("abcd", "initViews: "+DoJson.StringToJsonString(string));
        Log.d("abcd", "initViews: "+DoJson.StringToJsonString(json));
        Log.d("abcd", "initViews: "+DoJson.StringToJsonString(str1));
    }

    @Override
    public void bindData() {
        super.bindData();
    }

    //解析
    private void get(String temp) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(temp);
            JSONArray jsonArray = jsonObject.getJSONArray("root");
            jsonArray = jsonObject.getJSONArray("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void set1() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject1 = new JSONObject();
        JSONArray jsonArray1 = new JSONArray();
        JSONObject jsonObject2 = new JSONObject();
        try {
            jsonObject.put("one", "parent");
            jsonObject.put("two", "sister");
            jsonArray.put(0,jsonObject.toString());
            jsonObject1.put("name","zhang san");
            jsonObject1.put("age",20);
            jsonObject1.put("relative",jsonArray.toString());
            jsonArray1.put(0,jsonObject1.toString());
            jsonObject2.put("root",jsonArray1.toString());
            Log.d("abcd", "set1: "+DoJson.StringToJsonString(jsonObject2.toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    //合并
    public void set() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("one", "one");
            jsonObject.put("two", "two");
            jsonObject.put("three", "three");
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(0, jsonObject.toString());
            jsonArray.put(1, jsonObject.toString());
            jsonArray.put(2, jsonObject.toString());
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put(jsonObject.toString());

            JSONObject jsonObject1 = new JSONObject();
            //            jsonObject1.put("message", jsonArray.toJSONObject(jsonArray));//转换的string中\少
            jsonObject1.put("root", jsonArray.toString());//转换的string中\多
            jsonObject1.put("message", jsonArray1.toString());
            get(DoJson.StringToJsonString(jsonObject1.toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
