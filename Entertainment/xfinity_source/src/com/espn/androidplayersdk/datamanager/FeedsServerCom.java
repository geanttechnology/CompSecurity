// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.Context;
import com.espn.androidplayersdk.utilities.Utils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            FeedsCommListener, FeedsUpdateListener, EPSDKPrefs

class FeedsServerCom
{
    private class ThreadPerTaskExecutor
        implements Executor
    {

        final FeedsServerCom this$0;

        public void execute(Runnable runnable)
        {
            (new Thread(runnable)).start();
        }

        private ThreadPerTaskExecutor()
        {
            this$0 = FeedsServerCom.this;
            super();
        }

        ThreadPerTaskExecutor(ThreadPerTaskExecutor threadpertaskexecutor)
        {
            this();
        }
    }

    private class execTaskRunnable
        implements Runnable
    {

        private static final int SECOND_IN_MILLIS = 1000;
        int downloadType;
        int httpType;
        FeedsCommListener mListener;
        final FeedsServerCom this$0;
        String url;
        HashMap values;

        private JSONObject PostRequest(String s, String s1)
        {
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            Object obj10;
            Object obj11;
            Object obj12;
            obj8 = null;
            obj9 = null;
            obj11 = null;
            obj7 = null;
            obj4 = null;
            obj5 = null;
            obj12 = null;
            obj6 = null;
            obj10 = null;
            obj3 = null;
            obj = obj11;
            obj2 = obj12;
            HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
            obj = obj11;
            obj2 = obj12;
            httpurlconnection.setRequestMethod("POST");
            obj = obj11;
            obj2 = obj12;
            httpurlconnection.setConnectTimeout(30000);
            obj = obj11;
            obj2 = obj12;
            httpurlconnection.setDoOutput(true);
            obj = obj11;
            obj2 = obj12;
            httpurlconnection.setDoInput(true);
            obj = obj11;
            obj2 = obj12;
            httpurlconnection.setUseCaches(false);
            obj = obj11;
            obj2 = obj12;
            httpurlconnection.setAllowUserInteraction(false);
            obj = obj11;
            obj2 = obj12;
            httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            obj = obj11;
            obj2 = obj12;
            s = new DataOutputStream(httpurlconnection.getOutputStream());
            s.writeBytes(s1);
            s1 = obj10;
            if (httpurlconnection.getResponseCode() != 200) goto _L2; else goto _L1
_L1:
            s1 = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()), 8096);
            obj = "";
_L3:
            obj2 = s1.readLine();
            if (obj2 != null)
            {
                break MISSING_BLOCK_LABEL_264;
            }
            s1.close();
            if (((String) (obj)).length() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = new JSONObject(((String) (obj)));
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_254;
            }
            s1.close();
            if (s != null)
            {
                try
                {
                    s.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Utils.sdkLog("Error: ", 5, s);
                }
            }
            return ((JSONObject) (obj));
            obj = (new StringBuilder(String.valueOf(obj))).append(((String) (obj2))).toString();
            if (true) goto _L3; else goto _L2
            s1;
            s = obj7;
_L9:
            obj = s;
            obj2 = obj3;
            Utils.sdkLog("Error: ", 5, s1);
            if (obj3 == null)
            {
                break MISSING_BLOCK_LABEL_325;
            }
            ((BufferedReader) (obj3)).close();
            if (s != null)
            {
                try
                {
                    s.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Utils.sdkLog("Error: ", 5, s);
                }
            }
_L4:
            return null;
            s1;
            obj3 = obj4;
            s = obj8;
_L7:
            obj = s;
            obj2 = obj3;
            Utils.sdkLog("Error: ", 5, s1);
            if (obj3 == null)
            {
                break MISSING_BLOCK_LABEL_377;
            }
            ((BufferedReader) (obj3)).close();
            if (s != null)
            {
                try
                {
                    s.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Utils.sdkLog("Error: ", 5, s);
                }
            }
              goto _L4
            s1;
            obj3 = obj5;
            s = obj9;
_L6:
            obj = s;
            obj2 = obj3;
            Utils.sdkLog("Error: ", 5, s1);
            if (obj3 == null)
            {
                break MISSING_BLOCK_LABEL_430;
            }
            ((BufferedReader) (obj3)).close();
            if (s != null)
            {
                try
                {
                    s.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Utils.sdkLog("Error: ", 5, s);
                }
            }
              goto _L4
            s;
_L5:
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_463;
            }
            ((BufferedReader) (obj2)).close();
            if (obj != null)
            {
                try
                {
                    ((DataOutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    Utils.sdkLog("Error: ", 5, s1);
                }
            }
            throw s;
_L2:
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_492;
            }
            s1.close();
            if (s != null)
            {
                try
                {
                    s.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Utils.sdkLog("Error: ", 5, s);
                }
            }
              goto _L4
            s1;
            obj = s;
            obj2 = obj6;
            s = s1;
              goto _L5
            obj3;
            obj = s;
            obj2 = s1;
            s = ((String) (obj3));
              goto _L5
            s1;
            obj3 = obj5;
              goto _L6
            Object obj1;
            obj1;
            obj3 = s1;
            s1 = ((String) (obj1));
              goto _L6
            s1;
            obj3 = obj4;
              goto _L7
            obj1;
            obj3 = s1;
            s1 = ((String) (obj1));
              goto _L7
            s1;
            continue; /* Loop/switch isn't completed */
            obj1;
            obj3 = s1;
            s1 = ((String) (obj1));
            if (true) goto _L9; else goto _L8
_L8:
        }

        private JSONObject httpGetJson(String s)
        {
            DefaultHttpClient defaulthttpclient = initHttpClient(30);
            s = defaulthttpclient.execute(new HttpGet(s));
            if (s.getStatusLine().getStatusCode() == 200)
            {
                readHeaderForTTL(s);
                return new JSONObject(EntityUtils.toString(s.getEntity()));
            }
            Utils.sdkLog("Error: Failed to download JSON", 5, null);
            return null;
            s;
            Utils.sdkLog("Error: ", 5, s);
            return null;
            s;
            Utils.sdkLog("Error: ", 5, s);
            return null;
            s;
            Utils.sdkLog("Error: ", 5, s);
            return null;
            s;
            Utils.sdkLog("Error: ", 5, s);
            return null;
            s;
            throw s;
        }

        private HttpEntity httpGetXML(String s)
        {
            DefaultHttpClient defaulthttpclient = initHttpClient(30);
            try
            {
                s = defaulthttpclient.execute(new HttpGet(s));
                if (s.getStatusLine().getStatusCode() == 200)
                {
                    return s.getEntity();
                }
                Utils.sdkLog("Failed to download XML", 5, null);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Utils.sdkLog("Error: ", 5, s);
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Utils.sdkLog("Error: ", 5, s);
                return null;
            }
            return null;
        }

        private JSONObject httpsGetJson(String s)
        {
            String s1;
            String s2;
            String s3;
            String s4;
            String s5;
            Object obj;
            String s6;
            Object obj1;
            Object obj2;
            Object obj3;
            StringBuilder stringbuilder;
            DefaultHttpClient defaulthttpclient;
            stringbuilder = new StringBuilder();
            defaulthttpclient = initHttpClient(30);
            s6 = null;
            obj1 = null;
            obj2 = null;
            obj3 = null;
            obj = null;
            s2 = ((String) (obj));
            s3 = s6;
            s4 = obj1;
            s5 = obj2;
            s1 = obj3;
            s = new HttpGet(s);
            s2 = ((String) (obj));
            s3 = s6;
            s4 = obj1;
            s5 = obj2;
            s1 = obj3;
            if (EPSDKPrefs.getStartSessionCookie().trim().isEmpty())
            {
                break MISSING_BLOCK_LABEL_116;
            }
            s2 = ((String) (obj));
            s3 = s6;
            s4 = obj1;
            s5 = obj2;
            s1 = obj3;
            s.setHeader("cookie", EPSDKPrefs.getStartSessionCookie());
            s2 = ((String) (obj));
            s3 = s6;
            s4 = obj1;
            s5 = obj2;
            s1 = obj3;
            s = defaulthttpclient.execute(s);
            s2 = ((String) (obj));
            s3 = s6;
            s4 = obj1;
            s5 = obj2;
            s1 = obj3;
            if (s.getStatusLine().getStatusCode() != 200)
            {
                break MISSING_BLOCK_LABEL_201;
            }
            s2 = ((String) (obj));
            s3 = s6;
            s4 = obj1;
            s5 = obj2;
            s1 = obj3;
            readHeaderForTTL(s);
            s2 = ((String) (obj));
            s3 = s6;
            s4 = obj1;
            s5 = obj2;
            s1 = obj3;
            s = s.getEntity().getContent();
            s2 = s;
            s3 = s;
            s4 = s;
            s5 = s;
            s1 = s;
            obj = new BufferedReader(new InputStreamReader(s));
_L2:
            s2 = s;
            s3 = s;
            s4 = s;
            s5 = s;
            s1 = s;
            s6 = ((BufferedReader) (obj)).readLine();
            if (s6 != null)
            {
                break MISSING_BLOCK_LABEL_320;
            }
            s2 = s;
            s3 = s;
            s4 = s;
            s5 = s;
            s1 = s;
            obj = new JSONObject(stringbuilder.toString());
            Exception exception;
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Utils.sdkLog("Error: ", 5, s);
                return ((JSONObject) (obj));
            }
            return ((JSONObject) (obj));
            s2 = s;
            s3 = s;
            s4 = s;
            s5 = s;
            s1 = s;
            stringbuilder.append(s6);
            if (true) goto _L2; else goto _L1
_L1:
            s;
            s1 = s2;
            Utils.sdkLog("Error: ", 5, s);
            try
            {
                s2.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Utils.sdkLog("Error: ", 5, s);
                return null;
            }
            return null;
            s;
            s1 = s3;
            Utils.sdkLog("Error: ", 5, s);
            try
            {
                s3.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Utils.sdkLog("Error: ", 5, s);
                return null;
            }
            return null;
            s;
            s1 = s4;
            Utils.sdkLog("Error: ", 5, s);
            try
            {
                s4.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Utils.sdkLog("Error: ", 5, s);
                return null;
            }
            return null;
            s;
            s1 = s5;
            Utils.sdkLog("Error: ", 5, s);
            try
            {
                s5.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Utils.sdkLog("Error: ", 5, s);
                return null;
            }
            return null;
            s;
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                Utils.sdkLog("Error: ", 5, exception);
            }
            throw s;
        }

        private DefaultHttpClient initHttpClient(int i)
        {
            BasicHttpParams basichttpparams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basichttpparams, i * 1000);
            HttpConnectionParams.setSoTimeout(basichttpparams, i * 1000);
            return new DefaultHttpClient(basichttpparams);
        }

        private void readHeaderForTTL(HttpResponse httpresponse)
        {
            try
            {
                httpresponse = httpresponse.getHeaders("Cache-Control");
                if (httpresponse.length > 0)
                {
                    httpresponse = httpresponse[0].getElements();
                    values.put("ttl", httpresponse[0].getValue());
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (HttpResponse httpresponse)
            {
                Utils.sdkLog("Error Reading TTL: Setting default:  ", 5, httpresponse);
            }
            values.put("ttl", "");
        }

        public void run()
        {
            if (httpType != 1) goto _L2; else goto _L1
_L1:
            if (downloadType != 5) goto _L4; else goto _L3
_L3:
            JSONObject jsonobject = httpGetJson(url);
            if (mListener == null) goto _L6; else goto _L5
_L5:
            if (jsonobject == null) goto _L8; else goto _L7
_L7:
            mListener.update(jsonobject, url, values);
_L6:
            return;
_L8:
            mListener.handleError(1);
            return;
_L4:
            if (downloadType == 6)
            {
                HttpEntity httpentity = httpGetXML(url);
                if (mListener != null)
                {
                    if (httpentity != null)
                    {
                        mListener.update(httpentity, "XML");
                        return;
                    } else
                    {
                        mListener.handleError(1);
                        return;
                    }
                }
            }
            continue; /* Loop/switch isn't completed */
_L2:
            if (httpType != 2)
            {
                continue; /* Loop/switch isn't completed */
            }
            url = url.replace("https", "http");
            if (downloadType == 5)
            {
                JSONObject jsonobject1 = httpsGetJson(url);
                if (mListener != null)
                {
                    if (jsonobject1 != null)
                    {
                        mListener.update(jsonobject1, url, values);
                        return;
                    } else
                    {
                        mListener.handleError(1);
                        return;
                    }
                }
            }
            continue; /* Loop/switch isn't completed */
            if (httpType != 3 || downloadType != 5) goto _L6; else goto _L9
_L9:
            JSONObject jsonobject2 = PostRequest(url, values.get("POSTMSG").toString());
            if (mListener != null)
            {
                if (jsonobject2 != null)
                {
                    mListener.update(jsonobject2, url, values);
                    return;
                } else
                {
                    mListener.handleError(1);
                    return;
                }
            }
            if (true) goto _L6; else goto _L10
_L10:
        }

        execTaskRunnable(String s, int i, int j, FeedsCommListener feedscommlistener, HashMap hashmap)
        {
            this$0 = FeedsServerCom.this;
            super();
            url = s;
            httpType = i;
            downloadType = j;
            if (hashmap == null)
            {
                hashmap = new HashMap();
            }
            values = hashmap;
            if (feedscommlistener == null)
            {
                feedscommlistener = FeedsUpdateListener.intiListener();
            }
            mListener = feedscommlistener;
        }
    }


    public static final int GET_JSON = 5;
    public static final int GET_XML = 6;
    public static final int HTTPS_GET = 2;
    public static final int HTTP_GET = 1;
    public static final int HTTP_POST = 3;
    public static final int HTTP_PUT = 4;
    public static final String POST_MSG = "POSTMSG";
    Executor executor;
    Context mCtx;

    FeedsServerCom()
    {
    }

    protected void execTask(String s, int i, int j, FeedsCommListener feedscommlistener, HashMap hashmap)
    {
        initiExecutor();
        executor.execute(new execTaskRunnable(s, i, j, feedscommlistener, hashmap));
    }

    void initiExecutor()
    {
        try
        {
            if (executor == null)
            {
                executor = new ThreadPerTaskExecutor(null);
            }
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Error: ", 5, exception);
        }
    }
}
