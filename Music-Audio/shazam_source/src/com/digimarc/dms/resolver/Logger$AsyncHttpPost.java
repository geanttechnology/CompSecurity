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

// Referenced classes of package com.digimarc.dms.resolver:
//            Logger

private static class <init>
    implements Runnable
{

    public void run()
    {
        Object obj;
        Object obj2;
        Object obj3;
        obj = new Date();
        Logger.access$202(Logger.access$300().format(((Date) (obj))));
        obj2 = Build.MODEL;
        obj = new JSONObject();
        obj3 = new JSONObject();
        ((JSONObject) (obj)).put("device", obj2);
        ((JSONObject) (obj)).put("payload", Logger.access$400());
        ((JSONObject) (obj)).put("timestamp", Logger.access$200());
        ((JSONObject) (obj3)).put("resolvetime", Logger.access$500());
        ((JSONObject) (obj3)).put("templatedl", Logger.access$600());
        ((JSONObject) (obj3)).put("templateunzip", Logger.access$700());
        ((JSONObject) (obj3)).put("templateload", Logger.access$800());
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

    private ()
    {
    }

    ( )
    {
        this();
    }
}
