// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.services;

import android.content.Context;
import android.os.Handler;
import android.support.v7.aqo;
import android.support.v7.in;
import android.support.v7.is;
import android.text.TextUtils;
import com.abtnprojects.ambatana.models.UpdateAppModel;
import com.google.android.gms.gcm.a;
import com.google.android.gms.gcm.c;
import com.google.android.gms.gcm.e;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;

public class AppUpdateService extends c
{

    private static volatile String a;

    public AppUpdateService()
    {
    }

    public static void a(Context context)
    {
        aqo.a("scheduleRepeat", new Object[0]);
        try
        {
            a = is.d(context);
            if (a == null)
            {
                a = "http://cdn.letgo.com/config/android.json";
            }
            com.google.android.gms.gcm.PeriodicTask periodictask = (new com.google.android.gms.gcm.PeriodicTask.a()).a(com/abtnprojects/ambatana/services/AppUpdateService).a(0x15180L).b(30L).a("AppUpdateService").b(true).c(true).a(0).a(false).a();
            com.google.android.gms.gcm.a.a(context).a(periodictask);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aqo.b(context, "scheduleRepeat failed", new Object[0]);
        }
    }

    static void a(AppUpdateService appupdateservice, boolean flag, String s, int i)
    {
        appupdateservice.a(flag, s, i);
    }

    private void a(boolean flag, String s, int i)
    {
        aqo.a("onVerifyUpdatedEnded will save preference", new Object[0]);
        is.a(getApplicationContext(), flag);
        is.b(getApplicationContext(), s);
        is.a(getApplicationContext(), i);
    }

    public int a(e e)
    {
        String s1;
        aqo.a("onRunTask started", new Object[0]);
        String s = a;
        e = s;
        if (s == null)
        {
            e = "http://cdn.letgo.com/config/android.json";
        }
        aqo.a((new StringBuilder()).append("default url : ").append(e).toString(), new Object[0]);
        s1 = null;
        String s2;
        s2 = in.a(new URL(e));
        aqo.a((new StringBuilder()).append("jsonStringFromUrl ").append(s2).toString(), new Object[0]);
        Object obj = s1;
        if (!TextUtils.isEmpty(s2))
        {
            obj = JSONObjectInstrumentation.init(s2);
        }
_L1:
        obj = UpdateAppModel.fromJson(((org.json.JSONObject) (obj)));
        JSONException jsonexception;
        if (obj != null)
        {
            s1 = ((UpdateAppModel) (obj)).getFileUrl();
            aqo.a((new StringBuilder()).append("new url : ").append(e).toString(), new Object[0]);
            boolean flag = ((UpdateAppModel) (obj)).shouldUpdate(175);
            (new Handler(getMainLooper())).post(new Runnable(flag, s1, ((UpdateAppModel) (obj)).getTargetVersion()) {

                final boolean a;
                final String b;
                final int c;
                final AppUpdateService d;

                public void run()
                {
                    com.abtnprojects.ambatana.services.AppUpdateService.a(d, a, b, c);
                }

            
            {
                d = AppUpdateService.this;
                a = flag;
                b = s;
                c = i;
                super();
            }
            });
            aqo.a("onRunTask ending : success", new Object[0]);
            return 0;
        } else
        {
            aqo.a("onRunTask ending : failure!!!!!", new Object[0]);
            return 1;
        }
        jsonexception;
_L2:
        aqo.b(jsonexception, "onRunTask", new Object[0]);
        jsonexception = s1;
          goto _L1
        jsonexception;
          goto _L2
    }

    public void a()
    {
        super.a();
        a(((Context) (this)));
    }
}
