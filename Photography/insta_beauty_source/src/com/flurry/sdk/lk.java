// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.location.Criteria;
import android.location.Location;

// Referenced classes of package com.flurry.sdk:
//            ll

public class lk extends ll
{

    public static final Integer a = Integer.valueOf(216);
    public static final Integer b = Integer.valueOf(6);
    public static final Integer c = Integer.valueOf(2);
    public static final Integer d = Integer.valueOf(0);
    public static final String e = null;
    public static final Boolean f = Boolean.valueOf(true);
    public static final Boolean g = Boolean.valueOf(true);
    public static final String h = null;
    public static final Boolean i = Boolean.valueOf(true);
    public static final Criteria j = null;
    public static final Location k = null;
    public static final Long l = Long.valueOf(10000L);
    public static final Boolean m = Boolean.valueOf(true);
    public static final Long n = null;
    public static final Byte o = Byte.valueOf((byte)-1);
    public static final Boolean p = Boolean.valueOf(false);
    public static final String q = null;
    public static final Boolean r = Boolean.valueOf(true);
    private static lk s;

    private lk()
    {
        c();
    }

    public static lk a()
    {
        com/flurry/sdk/lk;
        JVM INSTR monitorenter ;
        lk lk1;
        if (s == null)
        {
            s = new lk();
        }
        lk1 = s;
        com/flurry/sdk/lk;
        JVM INSTR monitorexit ;
        return lk1;
        Exception exception;
        exception;
        throw exception;
    }

    public static void b()
    {
        com/flurry/sdk/lk;
        JVM INSTR monitorenter ;
        if (s != null)
        {
            s.d();
        }
        s = null;
        com/flurry/sdk/lk;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void c()
    {
        a("AgentVersion", a);
        a("ReleaseMajorVersion", b);
        a("ReleaseMinorVersion", c);
        a("ReleasePatchVersion", d);
        a("ReleaseBetaVersion", "");
        a("VersionName", e);
        a("CaptureUncaughtExceptions", f);
        a("UseHttps", g);
        a("ReportUrl", h);
        a("ReportLocation", i);
        a("ExplicitLocation", k);
        a("ContinueSessionMillis", l);
        a("LogEvents", m);
        a("Age", n);
        a("Gender", o);
        a("UserId", "");
        a("ProtonEnabled", p);
        a("ProtonConfigUrl", q);
        a("analyticsEnabled", r);
    }

}
