// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.audiencemanager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.adobe.adms.audiencemanager:
//            ADMS_AudienceManager

private static class callback
    implements Runnable
{

    public llback callback;
    public HashMap data;

    public void run()
    {
        Object obj;
        obj = ADMS_AudienceManager.access$000(data);
        ADMS_AudienceManager.access$100("Audience Manager - request (%s)", new Object[] {
            obj
        });
        if (((String) (obj)).length() <= 0) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Exception exception2;
        Object obj6;
        DefaultHttpClient defaulthttpclient;
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        defaulthttpclient = new DefaultHttpClient();
        HttpResponse httpresponse;
        try
        {
            obj5 = new HttpGet(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ADMS_AudienceManager.access$200("Audience Manager - Error creating URL query string (%s)", new Object[] {
                ((Exception) (obj)).getLocalizedMessage()
            });
            return;
        }
        obj6 = null;
        obj = null;
        obj1 = null;
        exception2 = null;
        obj2 = obj;
        obj3 = obj1;
        obj4 = obj6;
        httpresponse = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj5)));
        obj2 = obj;
        obj3 = obj1;
        obj4 = obj6;
        if (httpresponse.getStatusLine().getStatusCode() != 200) goto _L4; else goto _L3
_L3:
        obj2 = obj;
        obj3 = obj1;
        obj4 = obj6;
        obj = httpresponse.getEntity().getContent();
        obj2 = obj;
        obj3 = obj1;
        obj4 = obj;
        obj1 = new BufferedReader(new InputStreamReader(((InputStream) (obj)), "UTF-8"));
_L7:
        obj2 = ((BufferedReader) (obj1)).readLine();
        if (obj2 == null) goto _L6; else goto _L5
_L5:
        stringbuilder.append(((String) (obj2)));
          goto _L7
        obj4;
_L12:
        obj2 = obj;
        obj3 = obj1;
        ADMS_AudienceManager.access$200("Audience Manager - Problem communicating with the server (%s)", new Object[] {
            ((Exception) (obj4)).getLocalizedMessage()
        });
        obj2 = obj;
        obj3 = obj1;
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        obj2 = obj;
        obj3 = obj1;
        callback.call(null);
        ((InputStream) (obj)).close();
        ((BufferedReader) (obj1)).close();
_L14:
        return;
_L4:
        obj2 = obj;
        obj3 = obj1;
        obj4 = obj6;
        ADMS_AudienceManager.access$200("Audience Manager - No response from server", new Object[0]);
        obj2 = obj;
        obj3 = obj1;
        obj4 = obj6;
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_311;
        }
        obj2 = obj;
        obj3 = obj1;
        obj4 = obj6;
        callback.call(null);
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
_L6:
        obj4 = new JSONObject(stringbuilder.toString());
        obj3 = ((JSONObject) (obj4)).getJSONArray("dests");
        int i;
        i = 0;
        obj2 = obj5;
_L10:
        if (i >= ((JSONArray) (obj3)).length()) goto _L9; else goto _L8
_L8:
        obj5 = ((JSONArray) (obj3)).getJSONObject(i).getString("c");
        ADMS_AudienceManager.access$100("Audience Manager - forwarding 'dests' request (%s)", new Object[] {
            obj5
        });
        if (obj5 == null)
        {
            break MISSING_BLOCK_LABEL_420;
        }
        if (((String) (obj5)).length() <= 0)
        {
            break MISSING_BLOCK_LABEL_420;
        }
        obj2 = new HttpGet(((String) (obj5)));
        defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj2)));
_L11:
        i++;
          goto _L10
        exception2;
        ADMS_AudienceManager.access$200("Audience Manager - Unable to send dests hit for url (%s), (%s)", new Object[] {
            obj5, exception2.getLocalizedMessage()
        });
          goto _L11
        obj2;
        obj3 = obj1;
        obj1 = obj2;
_L15:
        try
        {
            ((InputStream) (obj)).close();
            ((BufferedReader) (obj3)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        throw obj1;
_L9:
        ADMS_AudienceManager.access$300(((JSONObject) (obj4)).getString("uuid"));
        obj3 = ((JSONObject) (obj4)).getJSONArray("stuff");
        obj4 = new HashMap();
        i = 0;
_L16:
        if (i >= ((JSONArray) (obj3)).length())
        {
            break MISSING_BLOCK_LABEL_547;
        }
        obj2 = ((JSONArray) (obj3)).getJSONObject(i);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_664;
        }
        Exception exception;
        try
        {
            ((HashMap) (obj4)).put(((JSONObject) (obj2)).getString("cn"), ((JSONObject) (obj2)).getString("cv"));
            break MISSING_BLOCK_LABEL_664;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj4) { }
        finally
        {
            obj3 = obj1;
            obj1 = exception1;
        }
          goto _L12
        ADMS_AudienceManager.access$100("Audience Manager - response (%s)", new Object[] {
            obj4
        });
        ADMS_AudienceManager.access$400(((HashMap) (obj4)));
        if (callback != null)
        {
            callback.call(obj4);
        }
        try
        {
            ((InputStream) (obj)).close();
            ((BufferedReader) (obj1)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
_L2:
        ADMS_AudienceManager.access$200("Audience Manager - Unable to create URL object", new Object[0]);
        if (callback == null) goto _L14; else goto _L13
_L13:
        callback.call(null);
        return;
        obj1;
        obj = obj2;
          goto _L15
        obj;
        return;
        exception;
        obj = obj4;
        obj4 = exception;
        exception = exception2;
          goto _L12
        i++;
          goto _L16
    }

    public llback(HashMap hashmap, llback llback)
    {
        data = hashmap;
        callback = llback;
    }
}
