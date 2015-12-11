// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.tapjoy:
//            TapjoyLog, TapjoyHttpURLResponse, TapjoyConnectCore, TapjoyUtil

public class TapjoyURLConnection
{

    public static final int TYPE_GET = 0;
    public static final int TYPE_POST = 1;

    public TapjoyURLConnection()
    {
    }

    public String getContentLength(String s)
    {
        try
        {
            s = s.replaceAll(" ", "%20");
            TapjoyLog.i("TapjoyURLConnection", (new StringBuilder("requestURL: ")).append(s).toString());
            s = (HttpURLConnection)(new URL(s)).openConnection();
            s.setConnectTimeout(15000);
            s.setReadTimeout(30000);
            s = s.getHeaderField("content-length");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            TapjoyLog.e("TapjoyURLConnection", (new StringBuilder("Exception: ")).append(s.toString()).toString());
            s = null;
        }
        TapjoyLog.i("TapjoyURLConnection", (new StringBuilder("content-length: ")).append(s).toString());
        return s;
    }

    public TapjoyHttpURLResponse getRedirectFromURL(String s)
    {
        return getResponseFromURL(s, "", 0, true, null, null, null);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String s)
    {
        return getResponseFromURL(s, "", 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String s, String s1)
    {
        return getResponseFromURL(s, s1, 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String s, String s1, int i)
    {
        return getResponseFromURL(s, s1, i, false, null, null, null);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String s, String s1, int i, boolean flag, Map map, String s2, String s3)
    {
        String s4;
        Object obj;
        Object obj1;
        TapjoyHttpURLResponse tapjoyhttpurlresponse;
        tapjoyhttpurlresponse = new TapjoyHttpURLResponse();
        obj1 = null;
        obj = null;
        s4 = obj1;
        s1 = (new StringBuilder()).append(s).append(s1).toString();
        s4 = obj1;
        Object obj2 = new StringBuilder("http ");
        if (i == 0)
        {
            s = "get";
        } else
        {
            s = "post";
        }
        s4 = obj1;
        TapjoyLog.i("TapjoyURLConnection", ((StringBuilder) (obj2)).append(s).append(": ").append(s1).toString());
        s4 = obj1;
        if (!TapjoyConnectCore.isUnitTestMode()) goto _L2; else goto _L1
_L1:
        s4 = obj1;
        s = new DefaultHttpClient();
        if (i != 1) goto _L4; else goto _L3
_L3:
        s4 = obj1;
        s1 = new HttpPost(s1);
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        s4 = obj1;
        s1.setHeader("Content-Type", s2);
        s4 = obj1;
        s1.setEntity(new StringEntity(s3, "UTF-8"));
        s4 = obj1;
        s = s.execute(s1);
_L8:
        s4 = obj1;
        tapjoyhttpurlresponse.statusCode = s.getStatusLine().getStatusCode();
        s4 = obj1;
        s1 = new HashMap();
        s4 = obj1;
        map = s.getAllHeaders();
        i = 0;
_L6:
        s4 = obj1;
        if (i >= map.length)
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = map[i];
        s4 = obj1;
        s3 = s2.getName();
        s4 = obj1;
        obj2 = new ArrayList();
        s4 = obj1;
        ((List) (obj2)).add(s2.getValue());
        s4 = obj1;
        s1.put(s3, obj2);
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        break; /* Loop/switch isn't completed */
_L4:
        s4 = obj1;
        s = s.execute(new HttpGet(s1));
        if (true) goto _L8; else goto _L7
_L7:
        s4 = obj1;
        tapjoyhttpurlresponse.headerFields = s1;
        s4 = obj1;
        s1 = new BufferedReader(new InputStreamReader(s.getEntity().getContent()));
        s = obj;
_L21:
        if (flag) goto _L10; else goto _L9
_L9:
        s4 = s;
        map = new StringBuilder();
_L12:
        s4 = s;
        s2 = s1.readLine();
        if (s2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s4 = s;
        map.append((new StringBuilder()).append(s2).append('\n').toString());
        if (true) goto _L12; else goto _L11
        s1;
        s = s4;
_L25:
        TapjoyLog.e("TapjoyURLConnection", (new StringBuilder("Exception: ")).append(s1.toString()).toString());
        if (s == null) goto _L14; else goto _L13
_L13:
        if (tapjoyhttpurlresponse.response != null) goto _L14; else goto _L15
_L15:
        s = new BufferedReader(new InputStreamReader(s.getErrorStream()));
        s1 = new StringBuilder();
_L18:
        map = s.readLine();
        if (map == null) goto _L17; else goto _L16
_L16:
        s1.append((new StringBuilder()).append(map).append('\n').toString());
          goto _L18
_L14:
        TapjoyLog.i("TapjoyURLConnection", "--------------------");
        TapjoyLog.i("TapjoyURLConnection", (new StringBuilder("response status: ")).append(tapjoyhttpurlresponse.statusCode).toString());
        TapjoyLog.i("TapjoyURLConnection", (new StringBuilder("response size: ")).append(tapjoyhttpurlresponse.contentLength).toString());
        TapjoyLog.v("TapjoyURLConnection", "response: ");
        TapjoyLog.v("TapjoyURLConnection", (new StringBuilder()).append(tapjoyhttpurlresponse.response).toString());
        if (tapjoyhttpurlresponse.redirectURL != null && tapjoyhttpurlresponse.redirectURL.length() > 0)
        {
            TapjoyLog.i("TapjoyURLConnection", (new StringBuilder("redirectURL: ")).append(tapjoyhttpurlresponse.redirectURL).toString());
        }
        TapjoyLog.i("TapjoyURLConnection", "--------------------");
        return tapjoyhttpurlresponse;
_L2:
        s4 = obj1;
        s = (HttpURLConnection)(new URL(s1)).openConnection();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_734;
        }
        s.setInstanceFollowRedirects(false);
        s.setConnectTimeout(15000);
        s.setReadTimeout(30000);
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_813;
        }
        for (s1 = map.entrySet().iterator(); s1.hasNext(); s.setRequestProperty((String)map.getKey(), (String)map.getValue()))
        {
            map = (java.util.Map.Entry)s1.next();
        }

        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_922;
        }
        s.setRequestMethod("POST");
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_922;
        }
        TapjoyLog.i("TapjoyURLConnection", (new StringBuilder("Content-Type: ")).append(s2).toString());
        TapjoyLog.i("TapjoyURLConnection", "Content:");
        TapjoyLog.i("TapjoyURLConnection", s3);
        s.setRequestProperty("Content-Type", s2);
        s.setRequestProperty("Connection", "close");
        s.setDoOutput(true);
        s.setFixedLengthStreamingMode(s3.length());
        s1 = new OutputStreamWriter(s.getOutputStream());
        s1.write(s3);
        s1.close();
        s.connect();
        tapjoyhttpurlresponse.statusCode = s.getResponseCode();
        tapjoyhttpurlresponse.headerFields = s.getHeaderFields();
        if (flag) goto _L20; else goto _L19
_L19:
        s1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
          goto _L21
_L11:
        s4 = s;
        tapjoyhttpurlresponse.response = map.toString();
_L10:
        s4 = s;
        if (tapjoyhttpurlresponse.statusCode != 302)
        {
            break MISSING_BLOCK_LABEL_1013;
        }
        s4 = s;
        tapjoyhttpurlresponse.redirectURL = s.getHeaderField("Location");
        s4 = s;
        map = s.getHeaderField("content-length");
        if (map == null) goto _L23; else goto _L22
_L22:
        tapjoyhttpurlresponse.contentLength = Integer.valueOf(map).intValue();
_L23:
        if (s1 == null) goto _L14; else goto _L24
_L24:
        s4 = s;
        s1.close();
          goto _L14
        map;
        s4 = s;
        TapjoyLog.e("TapjoyURLConnection", (new StringBuilder("Exception: ")).append(map.toString()).toString());
          goto _L23
_L17:
        try
        {
            tapjoyhttpurlresponse.response = s1.toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            TapjoyLog.e("TapjoyURLConnection", (new StringBuilder("Exception trying to get error code/content: ")).append(s.toString()).toString());
        }
          goto _L14
_L20:
        s1 = null;
          goto _L21
        s1;
          goto _L25
    }

    public TapjoyHttpURLResponse getResponseFromURL(String s, Map map)
    {
        return getResponseFromURL(s, TapjoyUtil.convertURLParams(map, false), 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String s, Map map, int i)
    {
        return getResponseFromURL(s, TapjoyUtil.convertURLParams(map, false), i);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String s, Map map, Map map1, String s1)
    {
        if (map != null)
        {
            map = TapjoyUtil.convertURLParams(map, false);
        } else
        {
            map = "";
        }
        return getResponseFromURL(s, ((String) (map)), 1, false, map1, "application/json;charset=utf-8", s1);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String s, Map map, Map map1, Map map2)
    {
        if (map != null)
        {
            map = TapjoyUtil.convertURLParams(map, false);
        } else
        {
            map = "";
        }
        return getResponseFromURL(s, ((String) (map)), 1, false, map1, "application/x-www-form-urlencoded", TapjoyUtil.convertURLParams(map2, false));
    }
}
