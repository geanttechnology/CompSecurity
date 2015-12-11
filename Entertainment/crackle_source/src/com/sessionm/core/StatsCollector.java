// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.sessionm.api.Activity;
import com.sessionm.b.a;
import com.sessionm.net.Request;
import org.json.JSONObject;

public class StatsCollector
{
    public static final class Stat extends Enum
    {

        private static final Stat dA[];
        public static final Stat de;
        public static final Stat df;
        public static final Stat dg;
        public static final Stat dh;
        public static final Stat di;
        public static final Stat dj;
        public static final Stat dk;
        public static final Stat dl;
        public static final Stat dm;
        public static final Stat dn;
        public static final Stat _flddo;
        public static final Stat dp;
        public static final Stat dq;
        public static final Stat dr;
        private StatType ds;
        private long dt;
        private long du;
        private long dv;
        private long dw;
        private String dx;
        private String dy;
        private String dz;

        static void a(Stat stat)
        {
            stat.reset();
        }

        private void ax()
        {
            du = du + 1L;
        }

        private String az()
        {
            return dx;
        }

        static String b(Stat stat)
        {
            return stat.az();
        }

        static void b(Stat stat, long l)
        {
            stat.c(l);
        }

        private void c(long l)
        {
            if (ds == StatType.dC)
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

        static void c(Stat stat)
        {
            stat.ax();
        }

        private void reset()
        {
            du = 0L;
            dt = 0L;
            dv = -1L;
            dw = -1L;
        }

        public static Stat valueOf(String s)
        {
            return (Stat)Enum.valueOf(com/sessionm/core/StatsCollector$Stat, s);
        }

        public static Stat[] values()
        {
            return (Stat[])dA.clone();
        }

        public StatType av()
        {
            return ds;
        }

        public String aw()
        {
            return dy;
        }

        public float ay()
        {
            if (ds == StatType.dC)
            {
                return (float)dt;
            }
            if (ds.equals(StatType.dB))
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
            de = new Stat("SESSION_START_STAT", 0, StatType.dB, com.sessionm.net.Request.Type.fj, "sst", "Session Start Request Time");
            df = new Stat("PORTAL_PRESENTATION_TIME", 1, StatType.dB, "portal presentation time", "ppt", "Portal Presentation Time");
            dg = new Stat("ACTION_STAT", 2, StatType.dB, com.sessionm.net.Request.Type.fk, "lart", "Log Action Time");
            dh = new Stat("SESSION_END_STAT", 3, StatType.dB, com.sessionm.net.Request.Type.fl, "sert", "Session End Request Time");
            di = new Stat("CONTENT_STAT", 4, StatType.dB, com.sessionm.net.Request.Type.fm, "crt", "Content Request Time");
            dj = new Stat("WEB_VIEW_LOAD_TIME", 5, StatType.dB, "webview load time", "wlt", "Web View Load Time");
            dk = new Stat("ACHIEVEMENT_PRESENTATION_TIME", 6, StatType.dB, "achievement presentation time", "apt", "Achievement Presentation Time");
            dl = new Stat("ACHIEVEMENT_PRELOAD_TIME", 7, StatType.dC, "preload", "alt", "Achievement Preload Time");
            dm = new Stat("WEB_VIEW_ERROR_COUNT", 8, StatType.dD, "webview error count", "wec", "Web View Error Count");
            dn = new Stat("SESSION_DURATION", 9, StatType.dC, "session duration", "sd", "Session Duration");
            _flddo = new Stat("REQUEST_SEND_COUNT_STAT", 10, StatType.dD, "request count", "rsc", "Request Send Count");
            dp = new Stat("REQUEST_SEND_FAILURE_COUNT", 11, StatType.dD, "request failure count", "rsfc", "Request Send Failure Count");
            dq = new Stat("REQUEST_ERROR_REPLY_COUNT", 12, StatType.dD, "request error reply count", "rerc", "Request Error Reply Count");
            dr = new Stat("DB_FAILURE_COUNT", 13, StatType.dD, "database failure count", "psf", "Persistent Store Failure");
            dA = (new Stat[] {
                de, df, dg, dh, di, dj, dk, dl, dm, dn, 
                _flddo, dp, dq, dr
            });
        }

        private Stat(String s, int k, StatType stattype, com.sessionm.net.Request.Type type, String s1, String s2)
        {
            this(s, k, stattype, type.toString(), s1, s2);
        }

        private Stat(String s, int k, StatType stattype, String s1, String s2, String s3)
        {
            super(s, k);
            dv = -1L;
            dw = -1L;
            ds = stattype;
            dx = s1;
            dy = s2;
            dz = s3;
        }
    }

    public static final class StatType extends Enum
    {

        public static final StatType dB;
        public static final StatType dC;
        public static final StatType dD;
        private static final StatType dE[];

        public static StatType valueOf(String s)
        {
            return (StatType)Enum.valueOf(com/sessionm/core/StatsCollector$StatType, s);
        }

        public static StatType[] values()
        {
            return (StatType[])dE.clone();
        }

        static 
        {
            dB = new StatType("AVERAGE", 0);
            dC = new StatType("VALUE", 1);
            dD = new StatType("COUNT", 2);
            dE = (new StatType[] {
                dB, dC, dD
            });
        }

        private StatType(String s, int k)
        {
            super(s, k);
        }
    }


    private static final String dd = "SessionMStatsPrefsFile";

    public StatsCollector()
    {
    }

    public static void a(Activity activity, long l)
    {
        if (activity.getActivityType() == com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT)
        {
            Stat.b(Stat.dk, l);
            return;
        } else
        {
            Stat.b(Stat.df, l);
            return;
        }
    }

    public static void a(Stat stat, long l)
    {
        if (stat.av().equals(StatType.dD))
        {
            Stat.c(stat);
            return;
        } else
        {
            Stat.b(stat, l);
            return;
        }
    }

    public static void b(Request request)
    {
        Stat astat[] = Stat.values();
        int l = astat.length;
        for (int k = 0; k < l; k++)
        {
            Stat stat = astat[k];
            if (request.aP().toString().equals(Stat.b(stat)))
            {
                a(stat, request.aU());
            }
            if (request.aQ() != null && request.getStatusCode() == 0)
            {
                a(Stat.dp, 1L);
            }
            if (request.getStatusCode() >= 400)
            {
                a(Stat.dq, 0L);
            }
        }

    }

    public static void i(Context context)
    {
        int k = 0;
        context = context.getSharedPreferences("SessionMStatsPrefsFile", 0).edit();
        a a1 = com.sessionm.b.a.aG();
        Stat astat[] = Stat.values();
        for (int l = astat.length; k < l; k++)
        {
            Stat stat = astat[k];
            a1.put(stat.aw(), stat.ay());
        }

        context.putString("SessionMStatsKey", a1.aI().toString());
        context.commit();
    }

    static a j(Context context)
    {
        context = context.getSharedPreferences("SessionMStatsPrefsFile", 0);
        String s = context.getString("SessionMStatsKey", "{}");
        context.edit().clear().commit();
        return com.sessionm.b.a.w(s);
    }

    public static void reset()
    {
        Stat astat[] = Stat.values();
        int l = astat.length;
        for (int k = 0; k < l; k++)
        {
            com.sessionm.core.Stat.a(astat[k]);
        }

    }
}
