// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

// Referenced classes of package com.fotoable.ad:
//            FotoAdStrategy, FotoCustomReport

final class .Editor
    implements Runnable
{

    public void run()
    {
        Object obj;
        Object obj1;
        int i;
        try
        {
            Thread.sleep(5000L);
            if (FotoAdStrategy.access$200().get() == null)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            return;
        }
        if (!Locale.getDefault().getCountry().equalsIgnoreCase("cn"))
        {
            break MISSING_BLOCK_LABEL_251;
        }
        obj = (new StringBuilder()).append("http://api.fotoable.com/user/group/v1/?").append(FotoCustomReport.WTAppBaseParams((Context)FotoAdStrategy.access$200().get())).toString();
_L1:
        obj1 = new DefaultHttpClient();
        HttpConnectionParams.setSoTimeout(((HttpClient) (obj1)).getParams(), 5000);
        obj1 = ((HttpClient) (obj1)).execute(new HttpGet(((String) (obj))));
        Log.v("Mehtod_Get url:", ((String) (obj)));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        i = ((HttpResponse) (obj1)).getStatusLine().getStatusCode();
        obj = ((HttpResponse) (obj1)).getEntity();
        if (i != 200 || obj == null)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        obj = new JSONObject((new BufferedReader(new InputStreamReader(((HttpEntity) (obj)).getContent(), "UTF-8"))).readLine());
        if (((JSONObject) (obj)).getInt("status") != 1)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        obj = ((JSONObject) (obj)).getString("data");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        SharedPreferences sharedpreferences = ((Context)FotoAdStrategy.access$200().get()).getSharedPreferences("FotoAdStrategy", 0);
        sharedpreferences.edit().putString("usercategory", ((String) (obj)));
        sharedpreferences.edit().putLong("getucattime", (new Date()).getTime()).apply();
        return;
        obj = (new StringBuilder()).append("http://api.fotoable.com/user/group/v1/?").append(FotoCustomReport.WTAppBaseParams((Context)FotoAdStrategy.access$200().get())).toString();
          goto _L1
    }

    .Editor()
    {
    }
}
