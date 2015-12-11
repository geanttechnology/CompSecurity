// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import com.tremorvideo.sdk.android.adapter.TremorAdapterCalls;
import com.tremorvideo.sdk.android.videoad.Playvideo;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.bv;
import com.tremorvideo.sdk.android.videoad.n;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.b:
//            c

public class com.tremorvideo.sdk.android.b.a extends com.tremorvideo.sdk.android.videoad.a
{
    class a extends TimerTask
    {

        final com.tremorvideo.sdk.android.b.a a;

        public void run()
        {
            a.b.cancel();
            a.b.purge();
            a.b = null;
            com.tremorvideo.sdk.android.b.a.a(a);
        }

        a()
        {
            a = com.tremorvideo.sdk.android.b.a.this;
            super();
        }
    }


    bv a;
    Timer b;
    private c e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private long j;
    private long k;

    public com.tremorvideo.sdk.android.b.a(com.tremorvideo.sdk.android.videoad.a a1, Activity activity, n n1)
    {
        super(a1, activity);
        g = false;
        i = false;
        j = -1L;
        k = -1L;
        e = n1.z();
        f = false;
        a = n1.q();
    }

    static void a(com.tremorvideo.sdk.android.b.a a1)
    {
        a1.p();
    }

    private void p()
    {
        this;
        JVM INSTR monitorenter ;
        com.tremorvideo.sdk.android.videoad.aw aw;
        if (f)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        f = true;
        aw = e.a(com.tremorvideo.sdk.android.videoad.aw.b.aa);
        if (aw == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        int l = d.a(aw);
        d.a(l);
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
            break MISSING_BLOCK_LABEL_47;
        }
        g = true;
        h = false;
        int l = d.a(e.a(com.tremorvideo.sdk.android.videoad.aw.b.Y));
        d.a(l);
        return;
        Exception exception;
        exception;
        ad.a(exception);
        d.a(this);
        return;
    }

    public void a(com.tremorvideo.sdk.android.videoad.aw.b b1)
    {
        b1 = e.a(b1);
        if (b1 != null)
        {
            int l = d.a(b1);
            d.a(l);
        }
    }

    public void a(com.tremorvideo.sdk.android.videoad.aw.b b1, String s)
    {
        this;
        JVM INSTR monitorenter ;
        a(b1);
        b1 = new Intent(c, com/tremorvideo/sdk/android/videoad/Playvideo);
        b1.putExtra("tremorVideoType", "webview");
        b1.putExtra("tremorVideoURL", s);
        c.startActivityForResult(b1, 3232);
        this;
        JVM INSTR monitorexit ;
        return;
        b1;
        throw b1;
    }

    public void a(com.tremorvideo.sdk.android.videoad.aw.b b1, String s, String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        a(b1);
        s = Double.valueOf(Double.parseDouble(s));
        s1 = Double.valueOf(Double.parseDouble(s1));
        if (s1.doubleValue() != 0.0D || s.doubleValue() != 0.0D) goto _L2; else goto _L1
_L1:
        b1 = "0,0";
_L8:
        b1 = (new StringBuilder()).append(b1).append("?z=20").toString();
        b1 = (new StringBuilder()).append(b1).append("&q=").append(s2).append("(").append(s2).append(")").toString();
        b1 = Uri.parse((new StringBuilder()).append("geo:").append(b1).toString());
        ad.a(com.tremorvideo.sdk.android.videoad.ad.d.b, (new StringBuilder()).append("Map URL: ").append(b1.toString()).toString());
        b1 = new Intent("android.intent.action.VIEW", b1);
        if (c.getPackageManager().resolveActivity(b1, 0) != null) goto _L4; else goto _L3
_L3:
        b1 = (new StringBuilder()).append("http://maps.google.com/?q=").append(s2).append("&ll=").append(s1).append(",").append(s).toString();
        s = new Intent(c, com/tremorvideo/sdk/android/videoad/Playvideo);
        s.putExtra("tremorVideoType", "webview");
        s.putExtra("tremorVideoURL", b1);
        c.startActivityForResult(s, 3232);
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        b1 = (new StringBuilder()).append("").append(s1).append(",").append(s).toString();
        continue; /* Loop/switch isn't completed */
_L4:
        c.startActivityForResult(b1, 11);
        TremorAdapterCalls.onLeaveApp();
        if (true) goto _L6; else goto _L5
_L5:
        b1;
        throw b1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void b()
    {
        if (b != null)
        {
            k = (GregorianCalendar.getInstance().getTimeInMillis() - j) + k;
            i = true;
            b.cancel();
            b.purge();
            b = null;
        }
        super.b();
    }

    public void c()
    {
        if (i && !((KeyguardManager)c.getSystemService("keyguard")).inKeyguardRestrictedInputMode())
        {
            long l = (long)e.a() - k;
            if (l > 0L)
            {
                b = new Timer();
                b.schedule(new a(), l);
                j = GregorianCalendar.getInstance().getTimeInMillis();
            }
            i = false;
        }
        super.c();
    }

    public void d()
    {
        if (!i) goto _L2; else goto _L1
_L1:
        super.d();
        Iterator iterator = ((ActivityManager)c.getSystemService("activity")).getRunningAppProcesses().iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
        if (runningappprocessinfo.pid != Process.myPid()) goto _L6; else goto _L5
_L5:
        int l = runningappprocessinfo.importance;
        if (l != 100) goto _L4; else goto _L7
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
        this;
        JVM INSTR monitorenter ;
        com.tremorvideo.sdk.android.videoad.aw aw;
        if (f)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        f = true;
        aw = e.a(com.tremorvideo.sdk.android.videoad.aw.b.aa);
        if (aw == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        int l = d.a(aw);
        d.a(l);
        d.a(this);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void f()
    {
        this;
        JVM INSTR monitorenter ;
        com.tremorvideo.sdk.android.videoad.aw aw;
        if (f)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        f = true;
        aw = e.a(com.tremorvideo.sdk.android.videoad.aw.b.Z);
        if (aw == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        int l = d.a(aw);
        d.a(l);
        d.a(this);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void g()
    {
        if (!h && e.a() > 0)
        {
            j = GregorianCalendar.getInstance().getTimeInMillis();
            k = 0L;
            b = new Timer();
            b.schedule(new a(), e.a());
            h = true;
        }
    }

    public void h()
    {
        h = true;
        if (b != null)
        {
            b.cancel();
            b.purge();
            b = null;
        }
    }

    public void i()
    {
        if (b != null)
        {
            b.cancel();
            b.purge();
            b = null;
        }
    }
}
