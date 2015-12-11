// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.util;

import com.gotv.crackle.ApplicationConstants;
import com.gotv.crackle.data.CacheManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.util:
//            HttpManager

public class NetworkUtil
{

    public NetworkUtil()
    {
    }

    public static String convertStreamToString(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        stringbuilder.append(s);
          goto _L1
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        return stringbuilder.toString();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        throw exception;
    }

    public static InputStream doPost(String s, Map map, String s1)
        throws JSONException, IOException, URISyntaxException
    {
        return doPost(s, map, null, s1);
    }

    public static InputStream doPost(String s, Map map, List list)
        throws JSONException, IOException, URISyntaxException
    {
        return doPost(s, map, list, null);
    }

    private static InputStream doPost(String s, Map map, List list, String s1)
        throws JSONException, IOException, URISyntaxException
    {
        s = new HttpPost(s);
        s.getParams().setParameter("http.protocol.cookie-policy", "rfc2109");
        if (list == null) goto _L2; else goto _L1
_L1:
        s.setEntity(new UrlEncodedFormEntity(list));
_L4:
        return executeRequest(s, map, 0);
_L2:
        if (s1 != null)
        {
            s.setEntity(new StringEntity(s1, "UTF-8"));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static InputStream executeRequest(HttpUriRequest httpurirequest)
        throws IOException, URISyntaxException
    {
        return executeRequest(httpurirequest, 0);
    }

    public static InputStream executeRequest(HttpUriRequest httpurirequest, int i)
        throws IOException, URISyntaxException
    {
        return executeRequest(httpurirequest, null, i);
    }

    public static InputStream executeRequest(HttpUriRequest httpurirequest, Map map)
        throws IOException, URISyntaxException
    {
        return executeRequest(httpurirequest, map, 0);
    }

    public static InputStream executeRequest(HttpUriRequest httpurirequest, Map map, int i)
        throws IOException, URISyntaxException
    {
        Object obj;
        obj = map;
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        obj = new HashMap();
        int j;
        ((Map) (obj)).put("User-Agent", ApplicationConstants.CUSTOM_USER_AGENT_STRING);
        obj = HttpManager.execute(httpurirequest, ((Map) (obj)));
        j = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        if (j == 404)
        {
            return null;
        }
          goto _L1
_L2:
        map = ((HttpResponse) (obj)).getFirstHeader("Location");
        httpurirequest = map;
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        httpurirequest = ((HttpResponse) (obj)).getFirstHeader("location");
        return executeRequest(((HttpUriRequest) (new HttpGet(URLDecoder.decode(httpurirequest.getValue(), "UTF-8")))), i);
_L3:
        httpurirequest = ((HttpResponse) (obj)).getEntity();
        if (httpurirequest == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        httpurirequest = httpurirequest.getContent();
        return httpurirequest;
        httpurirequest;
        if (i - 1 < 0)
        {
            throw httpurirequest;
        }
        break MISSING_BLOCK_LABEL_140;
        httpurirequest;
        if (i - 1 < 0)
        {
            throw httpurirequest;
        }
        return null;
_L1:
        if (j != 302 && j != 301) goto _L3; else goto _L2
    }

    public static JSONObject getJSONFromUrl(String s, Map map)
        throws JSONException, IOException, URISyntaxException
    {
        Object obj = map;
        if (map == null)
        {
            obj = new HashMap();
        }
        ((Map) (obj)).put("User-Agent", ApplicationConstants.CUSTOM_USER_AGENT_STRING);
        s = executeRequest(new HttpGet(s), ((Map) (obj)), 0);
        if (s != null)
        {
            return new JSONObject(convertStreamToString(s));
        } else
        {
            return new JSONObject();
        }
    }

    public static JSONObject getJSONFromUrlOrCache(String s, Map map)
        throws JSONException, IOException, URISyntaxException
    {
        Object obj = CacheManager.getJSONFromCache(s);
        if (obj != null)
        {
            return ((JSONObject) (obj));
        }
        obj = map;
        if (map == null)
        {
            obj = new HashMap();
        }
        ((Map) (obj)).put("User-Agent", ApplicationConstants.CUSTOM_USER_AGENT_STRING);
        map = executeRequest(new HttpGet(s), ((Map) (obj)), 0);
        if (map != null)
        {
            map = new JSONObject(convertStreamToString(map));
            CacheManager.addJSONToCache(s, map);
            return map;
        } else
        {
            return new JSONObject();
        }
    }

    public static String getStringFromUrl(String s)
        throws JSONException, IOException, URISyntaxException
    {
        return getStringFromUrl(s, null);
    }

    public static String getStringFromUrl(String s, Map map)
        throws JSONException, IOException, URISyntaxException
    {
        HttpGet httpget = new HttpGet(s);
        s = map;
        if (map == null)
        {
            s = new HashMap();
        }
        s.put("User-Agent", ApplicationConstants.CUSTOM_USER_AGENT_STRING);
        s = executeRequest(httpget, s, 0);
        if (s != null)
        {
            return convertStreamToString(s);
        } else
        {
            return null;
        }
    }
}
