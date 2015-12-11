// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.webkit.URLUtil;
import com.tremorvideo.sdk.android.adapter.TremorAdapterCalls;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.aw;
import com.tremorvideo.sdk.android.videoad.bv;
import com.tremorvideo.sdk.android.videoad.n;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.a:
//            c

public class com.tremorvideo.sdk.android.a.a extends com.tremorvideo.sdk.android.videoad.a
{
    class a extends TimerTask
    {

        final com.tremorvideo.sdk.android.a.a a;

        public void run()
        {
            a.b.cancel();
            a.b.purge();
            a.b = null;
            com.tremorvideo.sdk.android.a.a.a(a);
        }

        a()
        {
            a = com.tremorvideo.sdk.android.a.a.this;
            super();
        }
    }


    bv a;
    Timer b;
    private c e;
    private boolean f;
    private boolean g;
    private boolean h;
    private long i;
    private long j;

    public com.tremorvideo.sdk.android.a.a(com.tremorvideo.sdk.android.videoad.a a1, Activity activity, n n1)
    {
        super(a1, activity);
        g = false;
        h = false;
        i = -1L;
        j = -1L;
        e = n1.y();
        f = false;
        a = n1.q();
    }

    static void a(com.tremorvideo.sdk.android.a.a a1)
    {
        a1.i();
    }

    private void a(String s, String s1)
    {
        s = e.a(com.tremorvideo.sdk.android.videoad.aw.b.U);
        if (s != null)
        {
            s.b("dealer_id", s1);
            s.b("click_uri", s1);
            d.a(s);
        }
        if (URLUtil.isValidUrl(s1))
        {
            s = c;
            s1 = new Intent("android.intent.action.VIEW", Uri.parse(s1));
            TremorAdapterCalls.onLeaveApp();
            s.startActivity(s1);
        }
        h();
    }

    private void g()
    {
        this;
        JVM INSTR monitorenter ;
        aw aw1;
        if (f)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        f = true;
        aw1 = e.a(com.tremorvideo.sdk.android.videoad.aw.b.V);
        if (aw1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        d.a(aw1);
        d.a(this);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void h()
    {
        this;
        JVM INSTR monitorenter ;
        aw aw1;
        if (f)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        f = true;
        aw1 = e.a(com.tremorvideo.sdk.android.videoad.aw.b.W);
        if (aw1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        d.a(aw1);
        d.a(this);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void i()
    {
        this;
        JVM INSTR monitorenter ;
        aw aw1;
        if (f)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        f = true;
        aw1 = e.a(com.tremorvideo.sdk.android.videoad.aw.b.V);
        if (aw1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        d.a(aw1);
        d.a(this);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a()
    {
        if (g)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        g = true;
        d.a(e.a(com.tremorvideo.sdk.android.videoad.aw.b.T));
        if (e.a() > 0)
        {
            i = GregorianCalendar.getInstance().getTimeInMillis();
            j = 0L;
            b = new Timer();
            b.schedule(new a(), e.a());
        }
        return;
        Exception exception;
        exception;
        ad.a(exception);
        d.a(this);
        return;
    }

    public void a(Map map)
    {
        Object obj = (String)map.get("event_type");
        obj = e.a(((String) (obj)));
        if (obj != null)
        {
            if (((aw) (obj)).a() == com.tremorvideo.sdk.android.videoad.aw.b.U)
            {
                a((String)map.get("dealer_id"), (String)map.get("click_url"));
            } else
            {
                if (((aw) (obj)).a() == com.tremorvideo.sdk.android.videoad.aw.b.V)
                {
                    g();
                    return;
                }
                if (((aw) (obj)).a() == com.tremorvideo.sdk.android.videoad.aw.b.W)
                {
                    h();
                    return;
                }
            }
        }
    }

    public void b()
    {
        if (b != null)
        {
            j = (GregorianCalendar.getInstance().getTimeInMillis() - i) + j;
            h = true;
            b.cancel();
            b.purge();
            b = null;
        }
        super.b();
    }

    public void c()
    {
        if (h && !((KeyguardManager)c.getSystemService("keyguard")).inKeyguardRestrictedInputMode())
        {
            long l = (long)e.a() - j;
            if (l > 0L)
            {
                b = new Timer();
                b.schedule(new a(), l);
                i = GregorianCalendar.getInstance().getTimeInMillis();
            }
            h = false;
        }
        super.c();
    }

    public void d()
    {
        if (!h) goto _L2; else goto _L1
_L1:
        super.d();
        Iterator iterator = ((ActivityManager)c.getSystemService("activity")).getRunningAppProcesses().iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
        if (runningappprocessinfo.pid != Process.myPid()) goto _L6; else goto _L5
_L5:
        int k = runningappprocessinfo.importance;
        if (k != 100) goto _L4; else goto _L7
_L7:
        boolean flag = true;
_L9:
        if (flag)
        {
            c();
        }
_L2:
        return;
        Exception exception;
        exception;
        ad.a(exception);
_L4:
        flag = false;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void e()
    {
        if (b != null)
        {
            b.cancel();
            b.purge();
            b = null;
        }
    }

    public void f()
    {
        if (b != null)
        {
            b.cancel();
            b.purge();
            b = null;
        }
    }
}
