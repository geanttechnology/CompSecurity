// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.os.Build;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

class Logger
{
    private static class AsyncHttpPost
        implements Runnable
    {

        public void run()
        {
            Object obj;
            Object obj2;
            Object obj3;
            obj = new Date();
            Logger.mDatetime = Logger.dateFormat.format(((Date) (obj)));
            obj2 = Build.MODEL;
            obj = new JSONObject();
            obj3 = new JSONObject();
            ((JSONObject) (obj)).put("device", obj2);
            ((JSONObject) (obj)).put("payload", Logger.mPayload);
            ((JSONObject) (obj)).put("timestamp", Logger.mDatetime);
            ((JSONObject) (obj3)).put("resolvetime", Logger.mResolveTime);
            ((JSONObject) (obj3)).put("templatedl", Logger.mTemplateDL);
            ((JSONObject) (obj3)).put("templateunzip", Logger.mTemplateUnzip);
            ((JSONObject) (obj3)).put("templateload", Logger.mTemplateLoad);
            ((JSONObject) (obj)).put("metrics", obj3);
            obj2 = new DefaultHttpClient();
            obj3 = new HttpPost("https://logs.loggly.com/inputs/e2fbb150-5d53-48c7-b065-de7b252a5eb5");
            ((HttpPost) (obj3)).setEntity(new StringEntity(((JSONObject) (obj)).toString()));
            ((HttpPost) (obj3)).setHeader("Content-type", "application/json");
            ((HttpClient) (obj2)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj3)));
_L1:
            Logger.resetResults();
            return;
            Object obj1;
            obj1;
            ((UnsupportedEncodingException) (obj1)).printStackTrace();
              goto _L1
            obj1;
            ((JSONException) (obj1)).printStackTrace();
            Logger.resetResults();
            return;
            obj1;
            ((ClientProtocolException) (obj1)).printStackTrace();
              goto _L1
            obj1;
            Logger.resetResults();
            throw obj1;
            obj1;
            ((IOException) (obj1)).printStackTrace();
              goto _L1
        }

        private AsyncHttpPost()
        {
        }

    }

    private static class LoggerHolder
    {

        public static final Logger INSTANCE = new Logger();


        private LoggerHolder()
        {
        }
    }


    private static final String TAG = "DiscoverResolverLogger";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private static String mDatetime;
    private static boolean mMeasurementInProcess = false;
    private static long mPayload = 0L;
    private static long mResolveTime = 0L;
    private static long mStartTime = 0L;
    private static long mTemplateDL = 0L;
    private static long mTemplateLoad = 0L;
    private static long mTemplateUnzip = 0L;
    private static final String mURL = "https://logs.loggly.com/inputs/e2fbb150-5d53-48c7-b065-de7b252a5eb5";

    private Logger()
    {
    }


    static Logger getInstance()
    {
        return LoggerHolder.INSTANCE;
    }

    static void resetResults()
    {
        mResolveTime = 0L;
        mTemplateDL = 0L;
        mTemplateUnzip = 0L;
        mTemplateLoad = 0L;
    }

    void endResolve()
    {
        mResolveTime = System.currentTimeMillis() - mStartTime;
        (new StringBuilder("Resolve time: ")).append(mResolveTime).append(" ms");
    }

    void endTemplateDL()
    {
        mTemplateDL = System.currentTimeMillis() - mStartTime;
        (new StringBuilder("Template DL time: ")).append(mTemplateDL).append(" ms");
    }

    void endTemplateLoad()
    {
        mTemplateLoad = System.currentTimeMillis() - mStartTime;
        (new StringBuilder("Template load time: ")).append(mTemplateLoad).append(" ms");
    }

    void endTemplateUnzip()
    {
        mTemplateUnzip = System.currentTimeMillis() - mStartTime;
        (new StringBuilder("Template unzip time: ")).append(mTemplateUnzip).append(" ms");
    }

    void setPayload(long l)
    {
        mPayload = l;
    }

    void startResolve()
    {
        mStartTime = System.currentTimeMillis();
        mMeasurementInProcess = true;
    }

    void startTemplateDL()
    {
        mStartTime = System.currentTimeMillis();
    }

    void startTemplateLoad()
    {
        mStartTime = System.currentTimeMillis();
    }

    void startTemplateUnzip()
    {
        mStartTime = System.currentTimeMillis();
    }

    void uploadResults()
    {
        if (mMeasurementInProcess)
        {
            uploadResults(mPayload);
            mMeasurementInProcess = false;
        }
    }

    void uploadResults(long l)
    {
        mPayload = l;
        (new Thread(new AsyncHttpPost())).start();
    }

    static 
    {
        mMeasurementInProcess = false;
    }



/*
    static String access$202(String s)
    {
        mDatetime = s;
        return s;
    }

*/






}
