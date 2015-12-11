// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.helpshift.i.k;
import com.helpshift.i.m;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.helpshift:
//            p, l

public final class HSService extends Service
{
    public class a extends Binder
    {

        final HSService a;

        public a()
        {
            a = HSService.this;
            super();
        }
    }


    private static m f = null;
    private l a;
    private Boolean b;
    private p c;
    private final IBinder d = new a();
    private Handler e;

    public HSService()
    {
        a = null;
        c = null;
        e = new Handler() {

            final HSService a;

            public void handleMessage(Message message)
            {
                if (HSService.a(a))
                {
                    if (!HSService.b(a).booleanValue() && HSService.b() != null)
                    {
                        HSService.b().a();
                    }
                    HSService.a(a, Boolean.valueOf(true));
                    message = k.a(a, HSService.b());
                    HSService.c(a).f(message, new Handler());
                    return;
                } else
                {
                    HSService.a(a, Boolean.valueOf(false));
                    a.stopSelf();
                    return;
                }
            }

            
            {
                a = HSService.this;
                super();
            }
        };
    }

    static Boolean a(HSService hsservice, Boolean boolean1)
    {
        hsservice.b = boolean1;
        return boolean1;
    }

    public static void a()
    {
        if (f != null)
        {
            f.a();
        }
    }

    static boolean a(HSService hsservice)
    {
        return hsservice.c();
    }

    static m b()
    {
        return f;
    }

    static Boolean b(HSService hsservice)
    {
        return hsservice.b;
    }

    static l c(HSService hsservice)
    {
        return hsservice.a;
    }

    private boolean c()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            if (c == null)
            {
                c = p.a();
            }
            p p1 = c;
            return p.b();
        }
        Object obj = ((ActivityManager)getSystemService("activity")).getRunningAppProcesses();
        if (obj == null)
        {
            return false;
        }
        String s = getPackageName();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
            if (runningappprocessinfo.importance == 100 && runningappprocessinfo.processName.equals(s))
            {
                return true;
            }
        }

        return false;
    }

    public IBinder onBind(Intent intent)
    {
        return d;
    }

    public void onDestroy()
    {
        if (f != null)
        {
            f.c();
            f = null;
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        if (a == null)
        {
            a = new l(this);
        }
        if (b == null)
        {
            b = Boolean.valueOf(true);
        }
        if (f == null)
        {
            f = new m(e, 5, Boolean.valueOf(true), this);
            f.b();
        }
        return 2;
    }

}
