// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.net.Uri;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.mobileapptracker:
//            b

final class f
{

    private HttpClient a;

    public f()
    {
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeregistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 60000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 60000);
        a = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
    }

    public static String a(int i)
    {
        Object obj;
        Object obj1;
        obj = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj)), i);
        obj1 = new DefaultHttpClient(((org.apache.http.params.HttpParams) (obj)));
        Object obj2 = new android.net.Uri.Builder();
        android.net.Uri.Builder builder = ((android.net.Uri.Builder) (obj2)).scheme("https").authority((new StringBuilder()).append(b.c()).append(".deeplink.mobileapptracking.com").toString()).appendPath("v1").appendPath("link.txt").appendQueryParameter("platform", "android").appendQueryParameter("advertiser_id", b.c()).appendQueryParameter("ver", "3.8").appendQueryParameter("package_name", b.e());
        if (b.g() != null)
        {
            obj = b.g();
        } else
        {
            obj = b.i();
        }
        builder.appendQueryParameter("ad_id", ((String) (obj))).appendQueryParameter("user_agent", b.f());
        if (b.g() != null)
        {
            ((android.net.Uri.Builder) (obj2)).appendQueryParameter("google_ad_tracking_disabled", Integer.toString(b.h()));
        }
        obj = new HttpGet(((android.net.Uri.Builder) (obj2)).build().toString());
        ((HttpGet) (obj)).setHeader("X-MAT-Key", b.d());
        if (obj1 instanceof HttpClient)
        {
            break MISSING_BLOCK_LABEL_273;
        }
        obj = ((HttpClient) (obj1)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
_L2:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        if (((HttpResponse) (obj)).getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        obj = new BufferedReader(new InputStreamReader(((HttpResponse) (obj)).getEntity().getContent(), "UTF-8"));
        obj1 = new StringBuilder();
_L1:
        obj2 = ((BufferedReader) (obj)).readLine();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        try
        {
            ((StringBuilder) (obj1)).append(((String) (obj2)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return "";
        }
          goto _L1
        obj = HttpInstrumentation.execute((HttpClient)obj1, ((org.apache.http.client.methods.HttpUriRequest) (obj)));
          goto _L2
        ((BufferedReader) (obj)).close();
        obj = ((StringBuilder) (obj1)).toString();
        return ((String) (obj));
        return "";
    }

    public final JSONObject a(String s, JSONObject jsonobject, boolean flag)
    {
        if (jsonobject != null && jsonobject.length() != 0) goto _L2; else goto _L1
_L1:
        Object obj;
        jsonobject = a;
        obj = new HttpGet(s);
        if (jsonobject instanceof HttpClient) goto _L4; else goto _L3
_L3:
        jsonobject = jsonobject.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        s = jsonobject;
_L10:
        if (s == null) goto _L6; else goto _L5
_L5:
        StatusLine statusline;
        org.apache.http.Header header;
        statusline = s.getStatusLine();
        header = s.getFirstHeader("X-MAT-Responder");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        Log.d("MobileAppTracker", (new StringBuilder("Request completed with status ")).append(statusline.getStatusCode()).toString());
        jsonobject = new BufferedReader(new InputStreamReader(s.getEntity().getContent(), "UTF-8"));
        s = new StringBuilder();
_L9:
        obj = jsonobject.readLine();
        if (obj == null) goto _L8; else goto _L7
_L7:
        s.append(((String) (obj))).append("\n");
          goto _L9
        s;
        s.printStackTrace();
_L6:
        s = new JSONObject();
_L18:
        return s;
_L4:
        jsonobject = HttpInstrumentation.execute((HttpClient)jsonobject, ((org.apache.http.client.methods.HttpUriRequest) (obj)));
        s = jsonobject;
          goto _L10
        jsonobject;
        if (flag)
        {
            Log.d("MobileAppTracker", (new StringBuilder("Request error with URL ")).append(s).toString());
        }
        jsonobject.printStackTrace();
        s = null;
          goto _L10
_L2:
        if (jsonobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        jsonobject = jsonobject.toString();
_L11:
        jsonobject = new StringEntity(jsonobject, "UTF-8");
        jsonobject.setContentType("application/json");
        s = new HttpPost(s);
        s.setEntity(jsonobject);
        jsonobject = a;
        if (jsonobject instanceof HttpClient)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        s = jsonobject.execute(s);
          goto _L10
        jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L11
        try
        {
            s = HttpInstrumentation.execute((HttpClient)jsonobject, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = null;
        }
          goto _L10
_L8:
        jsonobject.close();
        jsonobject = new JSONObject();
        s = new JSONObject(new JSONTokener(s.toString()));
        if (!flag) goto _L13; else goto _L12
_L12:
        int i;
        Log.d("MobileAppTracker", (new StringBuilder("Server response: ")).append(s).toString());
        i = s.length();
        if (i <= 0) goto _L13; else goto _L14
_L14:
        if (!s.has("errors") || s.getJSONArray("errors").length() == 0) goto _L16; else goto _L15
_L15:
        jsonobject = s.getJSONArray("errors").getString(0);
        Log.d("MobileAppTracker", (new StringBuilder("Event was rejected by server with error: ")).append(jsonobject).toString());
_L13:
        if (statusline.getStatusCode() >= 200 && statusline.getStatusCode() <= 299) goto _L18; else goto _L17
_L17:
        if (statusline.getStatusCode() != 400 || header == null) goto _L6; else goto _L19
_L19:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_513;
        }
        Log.d("MobileAppTracker", "Request received 400 error from MAT server, won't be retried");
        return null;
_L16:
        if (!s.has("log_action") || s.getString("log_action").equals("null") || s.getString("log_action").equals("false") || s.getString("log_action").equals("true")) goto _L21; else goto _L20
_L20:
        jsonobject = s.getJSONObject("log_action");
        if (jsonobject.has("conversion"))
        {
            jsonobject = jsonobject.getJSONObject("conversion");
            if (jsonobject.has("status"))
            {
                if (!jsonobject.getString("status").equals("rejected"))
                {
                    break MISSING_BLOCK_LABEL_659;
                }
                jsonobject = jsonobject.getString("status_code");
                Log.d("MobileAppTracker", (new StringBuilder("Event was rejected by server: status code ")).append(jsonobject).toString());
            }
        }
          goto _L13
        Log.d("MobileAppTracker", "Event was accepted by server");
          goto _L13
_L21:
        if (!s.has("options")) goto _L13; else goto _L22
_L22:
        jsonobject = s.getJSONObject("options");
        if (jsonobject.has("conversion_status"))
        {
            jsonobject = jsonobject.getString("conversion_status");
            Log.d("MobileAppTracker", (new StringBuilder("Event was ")).append(jsonobject).append(" by server").toString());
        }
          goto _L13
        jsonobject;
        Log.d("MobileAppTracker", "Server response status could not be parsed");
        jsonobject.printStackTrace();
          goto _L13
        Exception exception;
        exception;
        s = jsonobject;
        jsonobject = exception;
_L23:
        jsonobject.printStackTrace();
          goto _L13
        jsonobject;
          goto _L23
    }
}
