// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.internal;

import com.boldchat.visitor.api.json.JSONException;
import com.boldchat.visitor.api.json.JSONObject;
import com.boldchat.visitor.api.json.JSONTokener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

// Referenced classes of package com.boldchat.visitor.api.internal:
//            RequestUtil, ResultListener

public class RestAPIRequest
    implements Runnable
{

    private final long accountID;
    private final String apiAccessKey;
    private final ResultListener listener;
    private final String method;
    private final Map params;
    private String serverSet;
    private final int timeout;
    private final String userAgent;

    public RestAPIRequest(int i, long l, String s, String s1, String s2, String s3, 
            Map map, ResultListener resultlistener)
    {
        timeout = i;
        accountID = l;
        apiAccessKey = s;
        serverSet = s1;
        userAgent = s2;
        method = s3;
        params = map;
        listener = resultlistener;
    }

    public void run()
    {
        Object obj;
        Object obj1;
        char c;
        c = '\u7530';
        Iterator iterator;
        String s;
        String s1;
        if (serverSet != null && serverSet.length() > 0 && !serverSet.startsWith("-"))
        {
            serverSet = (new StringBuilder()).append("-").append(serverSet).toString();
        } else
        {
            serverSet = "";
        }
        obj = RequestUtil.getRequestURL(accountID, serverSet, method);
        obj1 = new StringBuilder();
        if (params != null && params.size() > 0)
        {
            for (iterator = params.keySet().iterator(); iterator.hasNext(); ((StringBuilder) (obj1)).append("&"))
            {
                s = (String)iterator.next();
                s1 = params.get(s).toString();
                ((StringBuilder) (obj1)).append(URLEncoder.encode(s, "UTF-8"));
                ((StringBuilder) (obj1)).append("=").append(URLEncoder.encode(s1, "UTF-8"));
            }

        }
          goto _L1
        obj;
        if (listener != null)
        {
            listener.failure(-102, "Response from server was not understood", null);
        }
_L8:
        return;
_L1:
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(((String) (obj)))).openConnection();
        if (timeout <= 0) goto _L3; else goto _L2
_L2:
        int i = timeout;
_L9:
        httpurlconnection.setConnectTimeout(i);
        i = c;
        if (timeout > 0)
        {
            i = timeout;
        }
        httpurlconnection.setReadTimeout(i);
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setRequestMethod("POST");
        if (userAgent != null) goto _L5; else goto _L4
_L4:
        obj = RequestUtil.getDefaultUserAgentString();
_L10:
        httpurlconnection.setRequestProperty("User-Agent", ((String) (obj)));
        httpurlconnection.setRequestProperty("Accept-Encoding", "gzip");
        httpurlconnection.setRequestProperty("Authorization", RequestUtil.getAuthorizationHeader(accountID, apiAccessKey));
        obj = new OutputStreamWriter(httpurlconnection.getOutputStream());
        ((OutputStreamWriter) (obj)).write(((StringBuilder) (obj1)).toString());
        ((OutputStreamWriter) (obj)).flush();
        ((OutputStreamWriter) (obj)).close();
        if (!"gzip".equals(httpurlconnection.getHeaderField("Content-Encoding"))) goto _L7; else goto _L6
_L6:
        obj = new GZIPInputStream(httpurlconnection.getInputStream());
_L11:
        obj1 = new JSONObject(new JSONTokener(((InputStream) (obj))));
        ((InputStream) (obj)).close();
        if (listener != null)
        {
            if ("success".equals(((JSONObject) (obj1)).optString("Status")))
            {
                listener.success(((JSONObject) (obj1)));
                return;
            }
            break MISSING_BLOCK_LABEL_485;
        }
          goto _L8
        obj;
        if (listener != null)
        {
            listener.failure(((IOException) (obj)));
            return;
        }
          goto _L8
_L3:
        i = 30000;
          goto _L9
_L5:
        obj = userAgent;
          goto _L10
_L7:
        obj = httpurlconnection.getInputStream();
          goto _L11
        listener.failure(((JSONObject) (obj1)).optInt("Code", -1), ((JSONObject) (obj1)).optString("Message"), ((JSONObject) (obj1)));
        return;
          goto _L9
    }
}
