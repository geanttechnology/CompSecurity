// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;


// Referenced classes of package com.sessionm.core:
//            StatsCollector

public static final class dz extends Enum
{

    private static final dr dA[];
    public static final dr de;
    public static final dr df;
    public static final dr dg;
    public static final dr dh;
    public static final dr di;
    public static final dr dj;
    public static final dr dk;
    public static final dr dl;
    public static final dr dm;
    public static final dr dn;
    public static final dr _flddo;
    public static final dr dp;
    public static final dr dq;
    public static final dr dr;
    private ype ds;
    private long dt;
    private long du;
    private long dv;
    private long dw;
    private String dx;
    private String dy;
    private String dz;

    static void a(dz dz1)
    {
        dz1.reset();
    }

    private void ax()
    {
        du = du + 1L;
    }

    private String az()
    {
        return dx;
    }

    static String b(dx dx1)
    {
        return dx1.az();
    }

    static void b(az az1, long l)
    {
        az1.c(l);
    }

    private void c(long l)
    {
        if (ds == ype.dC)
        {
            dt = l;
        } else
        {
            du = du + 1L;
            dt = dt + l;
            if (l > dw || dw == -1L)
            {
                dw = l;
            }
            if (l < dv || dv == -1L)
            {
                dv = l;
                return;
            }
        }
    }

    static void c(dv dv1)
    {
        dv1.ax();
    }

    private void reset()
    {
        du = 0L;
        dt = 0L;
        dv = -1L;
        dw = -1L;
    }

    public static dw valueOf(String s)
    {
        return (dw)Enum.valueOf(com/sessionm/core/StatsCollector$Stat, s);
    }

    public static dw[] values()
    {
        return (dw[])dA.clone();
    }

    public ype av()
    {
        return ds;
    }

    public String aw()
    {
        return dy;
    }

    public float ay()
    {
        if (ds == ype.dC)
        {
            return (float)dt;
        }
        if (ds.equals(ype.dB))
        {
            if (du == 0L)
            {
                return 0.0F;
            } else
            {
                return (float)dt / (float)du;
            }
        } else
        {
            return (float)dt;
        }
    }

    public long getCount()
    {
        return du;
    }

    public String getDisplayName()
    {
        return dz;
    }

    static 
    {
        de = new <init>("SESSION_START_STAT", 0, ype.dB, com.sessionm.net.Type.dB, "sst", "Session Start Request Time");
        df = new <init>("PORTAL_PRESENTATION_TIME", 1, ype.dB, "portal presentation time", "ppt", "Portal Presentation Time");
        dg = new <init>("ACTION_STAT", 2, ype.dB, com.sessionm.net.Type.dB, "lart", "Log Action Time");
        dh = new <init>("SESSION_END_STAT", 3, ype.dB, com.sessionm.net.Type.dB, "sert", "Session End Request Time");
        di = new <init>("CONTENT_STAT", 4, ype.dB, com.sessionm.net.Type.dB, "crt", "Content Request Time");
        dj = new <init>("WEB_VIEW_LOAD_TIME", 5, ype.dB, "webview load time", "wlt", "Web View Load Time");
        dk = new <init>("ACHIEVEMENT_PRESENTATION_TIME", 6, ype.dB, "achievement presentation time", "apt", "Achievement Presentation Time");
        dl = new <init>("ACHIEVEMENT_PRELOAD_TIME", 7, ype.dC, "preload", "alt", "Achievement Preload Time");
        dm = new <init>("WEB_VIEW_ERROR_COUNT", 8, ype.dD, "webview error count", "wec", "Web View Error Count");
        dn = new <init>("SESSION_DURATION", 9, ype.dC, "session duration", "sd", "Session Duration");
        _flddo = new <init>("REQUEST_SEND_COUNT_STAT", 10, ype.dD, "request count", "rsc", "Request Send Count");
        dp = new <init>("REQUEST_SEND_FAILURE_COUNT", 11, ype.dD, "request failure count", "rsfc", "Request Send Failure Count");
        dq = new <init>("REQUEST_ERROR_REPLY_COUNT", 12, ype.dD, "request error reply count", "rerc", "Request Error Reply Count");
        dr = new <init>("DB_FAILURE_COUNT", 13, ype.dD, "database failure count", "psf", "Persistent Store Failure");
        dA = (new dA[] {
            de, df, dg, dh, di, dj, dk, dl, dm, dn, 
            _flddo, dp, dq, dr
        });
    }

    private ype(String s, int i, ype ype, com.sessionm.net.Type type, String s1, String s2)
    {
        this(s, i, ype, type.g(), s1, s2);
    }

    private ype(String s, int i, ype ype, String s1, String s2, String s3)
    {
        super(s, i);
        dv = -1L;
        dw = -1L;
        ds = ype;
        dx = s1;
        dy = s2;
        dz = s3;
    }
}
