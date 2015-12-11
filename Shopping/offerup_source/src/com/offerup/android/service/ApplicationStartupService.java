// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.e.a;
import android.util.Log;
import com.b.a.a.g;
import com.b.a.a.j;

// Referenced classes of package com.offerup.android.service:
//            a, f, b

public class ApplicationStartupService extends IntentService
{

    private String a;
    private Handler b;
    private f c;
    private b d;
    private j e;

    public ApplicationStartupService()
    {
        super("ApplicationStartupService");
        a = "ApplicationStartupService";
        b = new Handler();
    }

    static j a(ApplicationStartupService applicationstartupservice)
    {
        return applicationstartupservice.e;
    }

    static void b(ApplicationStartupService applicationstartupservice)
    {
        if (android.support.v4.e.a.b(applicationstartupservice.getApplicationContext()))
        {
            android.support.v4.e.a.b(new com.offerup.android.service.a(applicationstartupservice));
        }
    }

    static String c(ApplicationStartupService applicationstartupservice)
    {
        return applicationstartupservice.a;
    }

    protected void onHandleIntent(Intent intent)
    {
        try
        {
            e = j.a();
            c = new f(this, getApplicationContext(), (byte)0);
            d = new b(this, getApplicationContext(), (byte)0);
            b.removeCallbacks(c);
            b.postDelayed(c, 1000L);
            b.removeCallbacks(d);
            b.postDelayed(d, 4000L);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            g.c(a, Log.getStackTraceString(intent));
        }
    }
}
