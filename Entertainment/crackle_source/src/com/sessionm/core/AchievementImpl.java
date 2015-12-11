// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.util.Log;
import com.sessionm.api.AchievementData;
import com.sessionm.b.a;
import java.util.Date;
import java.util.Locale;

public class AchievementImpl
    implements AchievementData
{
    public static final class AchievementState extends Enum
    {

        public static final AchievementState G;
        public static final AchievementState H;
        public static final AchievementState I;
        public static final AchievementState J;
        private static final AchievementState K[];

        public static AchievementState valueOf(String s1)
        {
            return (AchievementState)Enum.valueOf(com/sessionm/core/AchievementImpl$AchievementState, s1);
        }

        public static AchievementState[] values()
        {
            return (AchievementState[])K.clone();
        }

        static 
        {
            G = new AchievementState("UNEARNED", 0);
            H = new AchievementState("UNCLAIMED", 1);
            I = new AchievementState("PRESENTED", 2);
            J = new AchievementState("CLAIMED", 3);
            K = (new AchievementState[] {
                G, H, I, J
            });
        }

        private AchievementState(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    public static final String A = "event_name";
    public static final String B = "preload_url";
    public static final String C = "last_earned_at";
    public static final int D = -1;
    public static final int E = -1;
    public static final String n = "achievement_id";
    public static final String o = "achievement_name";
    public static final String p = "ad";
    public static final String q = "unlocked_message";
    public static final String r = "points";
    public static final String s = "distance";
    public static final String t = "achievement_icon_url";
    public static final String u = "display";
    public static final String v = "next_ad_url";
    public static final String w = "delivered_url";
    public static final String x = "unclaimed_count";
    public static final String y = "custom";
    public static final String z = "nodisplay";
    private a a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private int g;
    private int h;
    private boolean i;
    private AchievementState j;
    private boolean k;
    private Date l;
    private boolean m;
    private String message;
    private String name;

    AchievementImpl(a a1)
    {
        b = a1.getString("achievement_id");
        a a2 = a1.x("ad");
        if (a2 != null)
        {
            name = a2.getString("achievement_name");
            message = a2.getString("unlocked_message");
            if (message == null || message.equals("null"))
            {
                message = "Achievement Unlocked!";
            }
            d = a2.getInt("points");
            e = a2.getString("achievement_icon_url");
        }
        i = "custom".equals(a1.getString("display"));
        m = "nodisplay".equals(a1.getString("display"));
        int i1;
        boolean flag;
        if (a1.has("distance"))
        {
            i1 = a1.getInt("distance");
        } else
        {
            i1 = -1;
        }
        g = i1;
        h = a1.getInt("unclaimed_count");
        c = a1.getString("event_name");
        f = a1.getString("preload_url");
        if (a1.has("last_earned_at"))
        {
            l = new Date(a1.getInt("last_earned_at") * 1000);
        }
        a = a1;
        j = AchievementState.G;
        if (g == 0 || h > 0)
        {
            a1 = AchievementState.H;
        } else
        {
            a1 = AchievementState.G;
        }
        if (g == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
        a(a1);
    }

    private void a(boolean flag)
    {
        k = flag;
    }

    public String a()
    {
        return b;
    }

    public void a(AchievementState achievementstate)
    {
        if (achievementstate != null && achievementstate.equals(j))
        {
            return;
        }
        static class _cls1
        {

            static final int F[];

            static 
            {
                F = new int[AchievementState.values().length];
                try
                {
                    F[AchievementState.J.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    F[AchievementState.H.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    F[AchievementState.I.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    F[AchievementState.G.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.F[achievementstate.ordinal()];
        JVM INSTR tableswitch 1 4: default 56
    //                   1 62
    //                   2 96
    //                   3 175
    //                   4 228;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        j = achievementstate;
        return;
_L2:
        if (!AchievementState.I.equals(j) && Log.isLoggable("SessionM.CA", 6))
        {
            Log.e("SessionM.CA", "Incorrect state transition. Cannot claim unpresented achievement.");
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if ((j == AchievementState.G && g > 0 && h <= 0 || (j == AchievementState.J || j == AchievementState.I) && g > 0 && !k) && Log.isLoggable("SessionM.CA", 6))
        {
            Log.e("SessionM.CA", "Incorrect state transition. Unclaimed achievements must be earned first.");
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!AchievementState.H.equals(j) && Log.isLoggable("SessionM.CA", 6))
        {
            Log.e("SessionM.CA", "Incorrect state transition. Presented achievements must be earned before being presented.");
        }
        if (h > 0 && g > 0)
        {
            h = -1;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (Log.isLoggable("SessionM.CA", 6))
        {
            Log.e("SessionM.CA", "Incorrect state transition. Should never go back to unearned.");
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    boolean a(int i1)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (g > 0)
        {
            int j1 = i1;
            if (i1 > g)
            {
                j1 = g;
            }
            g = g - j1;
            flag = flag1;
            if (g == 0)
            {
                flag = true;
                a(true);
                a(AchievementState.H);
            }
        }
        return flag;
    }

    public AchievementState b()
    {
        this;
        JVM INSTR monitorenter ;
        AchievementState achievementstate = j;
        this;
        JVM INSTR monitorexit ;
        return achievementstate;
        Exception exception;
        exception;
        throw exception;
    }

    boolean c()
    {
        return k;
    }

    boolean d()
    {
        return m;
    }

    a e()
    {
        return a;
    }

    String f()
    {
        return f;
    }

    public String getAchievementIconURL()
    {
        return e;
    }

    public String getAction()
    {
        return c;
    }

    public int getDistance()
    {
        return g;
    }

    public String getMessage()
    {
        return message;
    }

    public int getMpointValue()
    {
        return d;
    }

    public String getName()
    {
        return name;
    }

    public boolean isCustom()
    {
        return i;
    }

    boolean isValid()
    {
        return b != null && (m || i || !i && f != null);
    }

    public Date lastEarnedDate()
    {
        return l;
    }

    public String toString()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = String.format(Locale.US, "<Achievement id: %s name: %s distance: %d>", new Object[] {
            b, name, Integer.valueOf(g)
        });
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }
}
