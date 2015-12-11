// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            PrefHelper, ServerResponse, BranchLinkData

class RemoteInterface
{

    public static final String BRANCH_KEY = "branch_key";
    private static final int DEFAULT_TIMEOUT = 3000;
    public static final int NO_BRANCH_KEY_STATUS = -1234;
    public static final int NO_CONNECTIVITY_STATUS = -1009;
    private static final String SDK_VERSION = "1.10.1";
    protected PrefHelper prefHelper_;

    public RemoteInterface()
    {
    }

    public RemoteInterface(Context context)
    {
        prefHelper_ = PrefHelper.getInstance(context);
    }

    private boolean addCommonParams(JSONObject jsonobject, int i)
    {
        String s1;
        String s = prefHelper_.getBranchKey();
        s1 = prefHelper_.getAppKey();
        jsonobject.put("sdk", "android1.10.1");
        jsonobject.put("retryNumber", i);
        if (s.equals("bnc_no_value"))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        jsonobject.put("branch_key", prefHelper_.getBranchKey());
        return true;
        if (s1.equals("bnc_no_value"))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        jsonobject.put("app_id", prefHelper_.getAppKey());
        return true;
        jsonobject;
        return false;
    }

    private String convertJSONtoString(JSONObject jsonobject)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray = jsonobject.names();
        if (jsonarray == null) goto _L2; else goto _L3
_L3:
        int i;
        boolean flag;
        int j;
        flag = true;
        j = jsonarray.length();
        i = 0;
_L9:
        if (i >= j) goto _L2; else goto _L4
_L4:
        String s;
        try
        {
            s = jsonarray.getString(i);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return null;
        }
        if (!flag) goto _L6; else goto _L5
_L5:
        stringbuilder.append("?");
        flag = false;
_L7:
        String s1 = jsonobject.getString(s);
        stringbuilder.append(s).append("=").append(s1);
        i++;
        continue; /* Loop/switch isn't completed */
_L6:
        stringbuilder.append("&");
        if (true) goto _L7; else goto _L2
_L2:
        return stringbuilder.toString();
        if (true) goto _L9; else goto _L8
_L8:
    }

    private ServerResponse make_restful_get(String s, String s1, int i, int j, boolean flag)
    {
        Object obj;
        HttpsURLConnection httpsurlconnection;
        Object obj1;
        Object obj2;
        Object obj3;
        int k;
        obj = new JSONObject();
        obj1 = null;
        obj2 = null;
        obj3 = null;
        httpsurlconnection = null;
        k = i;
        if (i <= 0)
        {
            k = 3000;
        }
        if (!addCommonParams(((JSONObject) (obj)), j)) goto _L2; else goto _L1
_L1:
        HttpsURLConnection httpsurlconnection1;
        HttpsURLConnection httpsurlconnection2;
        HttpsURLConnection httpsurlconnection3;
        String s2;
        s2 = (new StringBuilder()).append(s).append(convertJSONtoString(((JSONObject) (obj)))).toString();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = obj1;
        httpsurlconnection3 = obj2;
        obj = obj3;
        PrefHelper.Debug("BranchSDK", (new StringBuilder()).append("getting ").append(s2).toString());
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = obj1;
        httpsurlconnection3 = obj2;
        obj = obj3;
        httpsurlconnection = (HttpsURLConnection)HttpInstrumentation.openConnection((new URL(s2)).openConnection());
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = httpsurlconnection;
        httpsurlconnection3 = httpsurlconnection;
        obj = httpsurlconnection;
        httpsurlconnection.setConnectTimeout(k);
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = httpsurlconnection;
        httpsurlconnection3 = httpsurlconnection;
        obj = httpsurlconnection;
        httpsurlconnection.setReadTimeout(k);
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = httpsurlconnection;
        httpsurlconnection3 = httpsurlconnection;
        obj = httpsurlconnection;
        if (httpsurlconnection.getResponseCode() < 500) goto _L4; else goto _L3
_L3:
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = httpsurlconnection;
        httpsurlconnection3 = httpsurlconnection;
        obj = httpsurlconnection;
        i = prefHelper_.getRetryCount();
        if (j >= i) goto _L4; else goto _L5
_L5:
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = httpsurlconnection;
        httpsurlconnection3 = httpsurlconnection;
        obj = httpsurlconnection;
        Thread.sleep(prefHelper_.getRetryInterval());
_L10:
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = httpsurlconnection;
        httpsurlconnection3 = httpsurlconnection;
        obj = httpsurlconnection;
        s = make_restful_get(s, s1, k, j + 1, flag);
        s1 = s;
        s = s1;
        if (httpsurlconnection != null)
        {
            httpsurlconnection.disconnect();
            s = s1;
        }
_L7:
        return s;
_L2:
        return new ServerResponse(s1, -1234);
        InterruptedException interruptedexception;
        interruptedexception;
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = httpsurlconnection;
        httpsurlconnection3 = httpsurlconnection;
        obj = httpsurlconnection;
        interruptedexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        s;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_410;
        }
        obj = httpsurlconnection1;
        PrefHelper.Debug(getClass().getSimpleName(), (new StringBuilder()).append("Http connect exception: ").append(s.getMessage()).toString());
        obj = httpsurlconnection1;
        s1 = new ServerResponse(s1, -1009);
        s = s1;
        if (httpsurlconnection1 != null)
        {
            httpsurlconnection1.disconnect();
            return s1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = httpsurlconnection;
        httpsurlconnection3 = httpsurlconnection;
        obj = httpsurlconnection;
        if (httpsurlconnection.getResponseCode() == 200)
        {
            break; /* Loop/switch isn't completed */
        }
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = httpsurlconnection;
        httpsurlconnection3 = httpsurlconnection;
        obj = httpsurlconnection;
        if (httpsurlconnection.getErrorStream() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = httpsurlconnection;
        httpsurlconnection3 = httpsurlconnection;
        obj = httpsurlconnection;
        s = processEntityForJSON(httpsurlconnection.getErrorStream(), httpsurlconnection.getResponseCode(), s1, flag, null);
        s1 = s;
        s = s1;
        if (httpsurlconnection != null)
        {
            httpsurlconnection.disconnect();
            return s1;
        }
        if (true) goto _L7; else goto _L6
_L6:
        httpsurlconnection1 = httpsurlconnection;
        httpsurlconnection2 = httpsurlconnection;
        httpsurlconnection3 = httpsurlconnection;
        obj = httpsurlconnection;
        s = processEntityForJSON(httpsurlconnection.getInputStream(), httpsurlconnection.getResponseCode(), s1, flag, null);
        s1 = s;
        s = s1;
        if (httpsurlconnection != null)
        {
            httpsurlconnection.disconnect();
            return s1;
        }
          goto _L7
        s;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_635;
        }
        obj = httpsurlconnection2;
        PrefHelper.Debug(getClass().getSimpleName(), (new StringBuilder()).append("Http connect exception: ").append(s.getMessage()).toString());
        obj = httpsurlconnection2;
        s1 = new ServerResponse(s1, -1009);
        s = s1;
        if (httpsurlconnection2 != null)
        {
            httpsurlconnection2.disconnect();
            return s1;
        }
          goto _L7
        s;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_707;
        }
        obj = httpsurlconnection3;
        PrefHelper.Debug(getClass().getSimpleName(), (new StringBuilder()).append("IO exception: ").append(s.getMessage()).toString());
        obj = httpsurlconnection3;
        s1 = new ServerResponse(s1, 500);
        s = s1;
        if (httpsurlconnection3 == null) goto _L7; else goto _L8
_L8:
        httpsurlconnection3.disconnect();
        return s1;
        s;
        if (obj != null)
        {
            ((HttpsURLConnection) (obj)).disconnect();
        }
        throw s;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private ServerResponse make_restful_post(JSONObject jsonobject, String s, String s1, int i, int j, boolean flag, BranchLinkData branchlinkdata)
    {
        Object obj;
        HttpURLConnection httpurlconnection;
        HttpURLConnection httpurlconnection1;
        HttpURLConnection httpurlconnection2;
        HttpURLConnection httpurlconnection3;
        OutputStreamWriter outputstreamwriter;
        Object obj1;
        Object obj2;
        int k;
        obj1 = null;
        httpurlconnection = null;
        outputstreamwriter = null;
        obj2 = null;
        k = i;
        if (i <= 0)
        {
            k = 3000;
        }
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        JSONObject jsonobject1 = new JSONObject();
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        Object obj3 = jsonobject.keys();
_L3:
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        if (!((Iterator) (obj3)).hasNext()) goto _L2; else goto _L1
_L1:
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        String s2 = (String)((Iterator) (obj3)).next();
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        jsonobject1.put(s2, jsonobject.get(s2));
          goto _L3
        JSONException jsonexception;
        jsonexception;
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        jsonexception.printStackTrace();
          goto _L3
        jsonobject;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        obj = httpurlconnection1;
        PrefHelper.Debug(getClass().getSimpleName(), (new StringBuilder()).append("Http connect exception: ").append(jsonobject.getMessage()).toString());
        obj = httpurlconnection1;
        s = new ServerResponse(s1, -1009);
        jsonobject = s;
        if (httpurlconnection1 != null)
        {
            httpurlconnection1.disconnect();
            jsonobject = s;
        }
_L5:
        return jsonobject;
_L2:
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        if (addCommonParams(jsonobject1, j))
        {
            break; /* Loop/switch isn't completed */
        }
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        jsonobject = new ServerResponse(s1, -1234);
        if (false)
        {
            throw new NullPointerException();
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (!flag) goto _L7; else goto _L6
_L6:
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        PrefHelper.Debug("BranchSDK", (new StringBuilder()).append("posting to ").append(s).toString());
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        obj3 = (new StringBuilder()).append("Post value = ");
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        if (jsonobject1 instanceof JSONObject) goto _L9; else goto _L8
_L8:
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        jsonobject = jsonobject1.toString(4);
_L12:
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        PrefHelper.Debug("BranchSDK", ((StringBuilder) (obj3)).append(jsonobject).toString());
_L7:
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        httpurlconnection = (HttpURLConnection)HttpInstrumentation.openConnection((new URL(s)).openConnection());
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        httpurlconnection.setConnectTimeout(k);
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        httpurlconnection.setReadTimeout(k);
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        httpurlconnection.setDoInput(true);
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        httpurlconnection.setDoOutput(true);
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        httpurlconnection.setRequestProperty("Content-Type", "application/json");
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        httpurlconnection.setRequestProperty("Accept", "application/json");
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        httpurlconnection.setRequestMethod("POST");
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        outputstreamwriter = new OutputStreamWriter(httpurlconnection.getOutputStream());
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        if (jsonobject1 instanceof JSONObject) goto _L11; else goto _L10
_L10:
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        jsonobject = jsonobject1.toString();
_L13:
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        outputstreamwriter.write(jsonobject);
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        outputstreamwriter.flush();
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        if (httpurlconnection.getResponseCode() < 500)
        {
            break; /* Loop/switch isn't completed */
        }
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        i = prefHelper_.getRetryCount();
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        Thread.sleep(prefHelper_.getRetryInterval());
_L14:
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        s = make_restful_post(jsonobject1, s, s1, k, j + 1, flag, branchlinkdata);
        jsonobject = s;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
            return s;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        httpurlconnection1 = obj2;
        httpurlconnection2 = obj1;
        httpurlconnection3 = httpurlconnection;
        obj = outputstreamwriter;
        jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject1, 4);
          goto _L12
_L11:
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject1);
          goto _L13
        jsonobject;
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        jsonobject.printStackTrace();
          goto _L14
        jsonobject;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_1058;
        }
        obj = httpurlconnection2;
        PrefHelper.Debug(getClass().getSimpleName(), (new StringBuilder()).append("Http connect exception: ").append(jsonobject.getMessage()).toString());
        obj = httpurlconnection2;
        s = new ServerResponse(s1, -1009);
        jsonobject = s;
        if (httpurlconnection2 != null)
        {
            httpurlconnection2.disconnect();
            return s;
        }
        if (true) goto _L5; else goto _L15
_L15:
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        if (httpurlconnection.getResponseCode() == 200)
        {
            break; /* Loop/switch isn't completed */
        }
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        if (httpurlconnection.getErrorStream() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        s = processEntityForJSON(httpurlconnection.getErrorStream(), httpurlconnection.getResponseCode(), s1, flag, branchlinkdata);
        jsonobject = s;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
            return s;
        }
        if (true) goto _L5; else goto _L16
_L16:
        httpurlconnection1 = httpurlconnection;
        httpurlconnection2 = httpurlconnection;
        httpurlconnection3 = httpurlconnection;
        obj = httpurlconnection;
        s = processEntityForJSON(httpurlconnection.getInputStream(), httpurlconnection.getResponseCode(), s1, flag, branchlinkdata);
        jsonobject = s;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
            return s;
        }
          goto _L5
        jsonobject;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_1282;
        }
        obj = httpurlconnection3;
        PrefHelper.Debug(getClass().getSimpleName(), (new StringBuilder()).append("Exception: ").append(jsonobject.getMessage()).toString());
        obj = httpurlconnection3;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            break MISSING_BLOCK_LABEL_1318;
        }
        obj = httpurlconnection3;
        if (!(jsonobject instanceof NetworkOnMainThreadException))
        {
            break MISSING_BLOCK_LABEL_1318;
        }
        obj = httpurlconnection3;
        Log.i("BranchSDK", "Branch Error: Don't call our synchronous methods on the main thread!!!");
        obj = httpurlconnection3;
        s = new ServerResponse(s1, 500);
        jsonobject = s;
        if (httpurlconnection3 == null) goto _L5; else goto _L17
_L17:
        httpurlconnection3.disconnect();
        return s;
        jsonobject;
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw jsonobject;
    }

    private ServerResponse processEntityForJSON(InputStream inputstream, int i, String s, boolean flag, BranchLinkData branchlinkdata)
    {
        s = new ServerResponse(s, i, branchlinkdata);
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        inputstream = (new BufferedReader(new InputStreamReader(inputstream))).readLine();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        PrefHelper.Debug("BranchSDK", (new StringBuilder()).append("returned ").append(inputstream).toString());
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        s.setPost(JSONObjectInstrumentation.init(inputstream));
_L2:
        return s;
        branchlinkdata;
        s.setPost(JSONArrayInstrumentation.init(inputstream));
        return s;
        inputstream;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        PrefHelper.Debug(getClass().getSimpleName(), (new StringBuilder()).append("JSON exception: ").append(inputstream.getMessage()).toString());
        return s;
        inputstream;
        if (flag)
        {
            PrefHelper.Debug(getClass().getSimpleName(), (new StringBuilder()).append("IO exception: ").append(inputstream.getMessage()).toString());
            return s;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public ServerResponse make_restful_get(String s, String s1, int i)
    {
        return make_restful_get(s, s1, i, 0, true);
    }

    public ServerResponse make_restful_post(JSONObject jsonobject, String s, String s1, int i)
    {
        return make_restful_post(jsonobject, s, s1, i, 0, true, null);
    }

    public ServerResponse make_restful_post(JSONObject jsonobject, String s, String s1, int i, BranchLinkData branchlinkdata)
    {
        return make_restful_post(jsonobject, s, s1, i, 0, true, branchlinkdata);
    }

    public ServerResponse make_restful_post(JSONObject jsonobject, String s, String s1, int i, boolean flag)
    {
        return make_restful_post(jsonobject, s, s1, i, 0, flag, null);
    }
}
