// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.smule.android.c.w;
import com.smule.android.f.b;
import com.smule.android.f.h;
import com.smule.android.f.m;
import com.smule.android.f.p;
import com.smule.android.facebook.a;
import com.smule.android.facebook.c;
import com.smule.android.network.a.x;
import com.smule.android.network.core.NetworkResponseCallback;
import com.smule.android.network.core.o;
import java.util.concurrent.Future;

// Referenced classes of package com.smule.android.network.managers:
//            ax, av, aw, ay, 
//            at, au

public class UserManager
{

    private static m E = new m(8);
    protected static UserManager a;
    private static final String c = com/smule/android/network/managers/UserManager.getName();
    private String A;
    private b B;
    private int C;
    private int D;
    protected Context b;
    private long d;
    private long e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private ax p;
    private boolean q;
    private boolean r;
    private String s;
    private String t;
    private String u;
    private String v;
    private Long w;
    private int x;
    private String y;
    private String z;

    private UserManager()
    {
        d = 0L;
        e = 0L;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = false;
        r = false;
        s = null;
        t = null;
        u = null;
        v = null;
        w = Long.valueOf(0L);
        x = 0;
        C = 0;
        D = 0;
    }

    public static void a(Context context)
    {
        com/smule/android/network/managers/UserManager;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new UserManager();
            a.b = context.getApplicationContext();
            a.t();
        }
        com/smule/android/network/managers/UserManager;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private void a(String s1, String s2, long l1, String s3, long l2, 
            String s4, String s5, String s6, String s7, String s8, String s9, String s10, 
            ax ax1, String s11, String s12, Long long1, int i1, String s13, String s14, 
            b b1, String s15)
    {
        android.content.SharedPreferences.Editor editor = b.getSharedPreferences("user", 0).edit();
        if (!TextUtils.isEmpty(s2))
        {
            editor.putString("email", s2);
            g = s2;
        }
        if (!TextUtils.isEmpty(s4))
        {
            editor.putString("password", s4);
            h = s4;
        }
        if (l1 != 0L)
        {
            editor.putLong("account", l1);
            d = l1;
        }
        if (!TextUtils.isEmpty(s3))
        {
            editor.putString("picUrl", s3);
            i = s3;
        }
        if (!TextUtils.isEmpty(s1))
        {
            editor.putString("handle", s1);
            f = s1;
        }
        if (l2 != 0L)
        {
            editor.putLong("player", l2);
            e = l2;
        }
        if (!TextUtils.isEmpty(s5))
        {
            editor.putString("facebookId", s5);
            j = s5;
        }
        if (!TextUtils.isEmpty(s6))
        {
            editor.putString("googlePlusId", s6);
            k = s6;
        }
        if (!TextUtils.isEmpty(s7))
        {
            editor.putString("firstName", s7);
            l = s7;
        }
        if (!TextUtils.isEmpty(s8))
        {
            editor.putString("lastName", s8);
            m = s8;
        }
        if (!TextUtils.isEmpty(s9))
        {
            editor.putString("gender", s9);
            n = s9;
        }
        if (!TextUtils.isEmpty(s10))
        {
            editor.putString("birthday", s10);
            o = s10;
        }
        if (ax1 != null)
        {
            editor.putInt("login_type", ax1.ordinal());
            p = ax1;
        }
        if (!TextUtils.isEmpty(s14))
        {
            editor.putString("profileBlurb", s14);
            A = s14;
        }
        if (!TextUtils.isEmpty(s15))
        {
            editor.putString("FB_TOKEN_FOR_BUSINESS", s15);
            y = s15;
        }
        editor.putInt("LOGIN_COUNT", i1);
        x = i1;
        if (b1 != null)
        {
            editor.putInt("newsletterOptIn", b1.a());
            B = b1;
        }
        editor.putString("test_id", s11);
        s = s11;
        editor.putString("group_id", s12);
        t = s12;
        if (long1 != null && long1.longValue() != 0L)
        {
            editor.putLong("INSTALL_DATE", long1.longValue());
            w = long1;
        }
        if (!TextUtils.isEmpty(s13))
        {
            editor.putString("GPLUS_ACCESS_TOKEN", s13);
            z = s13;
        }
        com.smule.android.f.p.a(editor);
    }

    public static UserManager n()
    {
        return a;
    }

    public static String o()
    {
        return E.a();
    }

    private o y()
    {
        Object obj = null;
        if (p != com.smule.android.network.managers.ax.b) goto _L2; else goto _L1
_L1:
        o o1 = com.smule.android.network.a.x.a(g, h, e, true);
_L4:
        return o1;
_L2:
        if (p != com.smule.android.network.managers.ax.c)
        {
            break; /* Loop/switch isn't completed */
        }
        c c1 = com.smule.android.facebook.a.a().a(g, true);
        o1 = obj;
        if (c1 != null)
        {
            return com.smule.android.network.a.x.a(c1.b, c1.a.getToken(), null, null, c1.h, c1.i, c1.d, c1.e, c1.j, c1.k, h, e, Boolean.valueOf(true), c1.f);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (p == ax.d)
        {
            return com.smule.android.network.a.x.b(true, e);
        }
        o1 = obj;
        if (p == ax.e)
        {
            o1 = obj;
            if (z != null)
            {
                o1 = obj;
                if (k != null)
                {
                    return com.smule.android.network.a.x.a(k, z, g, n, o, l, m, h, e, Boolean.valueOf(true));
                }
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private void z()
    {
        this;
        JVM INSTR monitorenter ;
        if (a())
        {
            s();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public o a(c c1)
    {
        z();
        c1 = com.smule.android.network.a.x.a(c1.b, c1.a.getToken(), c1.c, c1.d, c1.e, c1.j, c1.k, c1.f);
        Log.i(c, (new StringBuilder()).append("connectWithFacebook response : ").append(((o) (c1)).h).toString());
        return c1;
    }

    public o a(String s1, String s2, String s3, b b1)
    {
        z();
        o o1 = com.smule.android.network.a.x.a(s1, s2, s3, b1);
        Log.i(c, (new StringBuilder()).append("userUpdate response : ").append(o1.h).toString());
        if (o1.a())
        {
            a(s1, s2, d, i, e, s3, null, null, null, null, n, o, null, s, t, null, x, null, null, b1, null);
            com.smule.android.f.h.a().a("PROFILE_UPDATED_EVENT", new Object[0]);
        }
        return o1;
    }

    public av a(boolean flag)
    {
        z();
        o o1 = com.smule.android.network.a.x.a(flag, c());
        av av1 = new av(o1);
        if (o1.a())
        {
            w.b = av1.f;
            C = av1.h;
            D = av1.i;
            a(null, null, 0L, null, av1.a, null, null, null, null, null, null, null, null, av1.c, av1.d, av1.e, av1.g, null, null, null, null);
            com.smule.android.f.h.a().a("USER_LOGGED_IN_EVENT", "LOGIN_TYPE_GUEST");
        }
        b(o1);
        return av1;
    }

    public aw a(c c1, String s1, String s2, boolean flag)
    {
        z();
        s1 = com.smule.android.network.a.x.a(c1.b, c1.a.getToken(), c1.c, s1, c1.h, c1.i, c1.d, c1.e, c1.j, c1.k, s2, e, Boolean.valueOf(flag), c1.f);
        Log.i(c, (new StringBuilder()).append("loginWithFacebook response : ").append(((o) (s1)).h).toString());
        aw aw1 = new aw(s1);
        if (s1.a())
        {
            w.b = aw1.j;
            C = aw1.m;
            D = aw1.n;
            a(aw1.e, aw1.d, aw1.c, aw1.f, aw1.b, s2, c1.b, null, null, null, c1.d, c1.e, com.smule.android.network.managers.ax.c, aw1.g, aw1.h, aw1.i, aw1.k, null, null, aw1.l, c1.f);
            s2 = com.smule.android.f.h.a();
            if (aw1.o.booleanValue())
            {
                c1 = "LOGIN_TYPE_NEW";
            } else
            {
                c1 = "LOGIN_TYPE_EXISTING";
            }
            s2.a("USER_LOGGED_IN_EVENT", c1);
        }
        b(s1);
        return aw1;
    }

    public aw a(String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            String s8, boolean flag)
    {
        z();
        s3 = com.smule.android.network.a.x.a(s1, s2, s3, s4, s5, s6, s7, s8, e, Boolean.valueOf(flag));
        Log.i(c, (new StringBuilder()).append("loginWithGooglePlus response : ").append(((o) (s3)).h).toString());
        aw aw1 = new aw(s3);
        if (s3.a())
        {
            w.b = aw1.j;
            C = aw1.m;
            D = aw1.n;
            a(aw1.e, aw1.d, aw1.c, aw1.f, aw1.b, s8, null, s1, s6, s7, s4, s5, ax.e, aw1.g, aw1.h, aw1.i, aw1.k, s2, null, aw1.l, null);
            s2 = com.smule.android.f.h.a();
            if (aw1.o.booleanValue())
            {
                s1 = "LOGIN_TYPE_NEW";
            } else
            {
                s1 = "LOGIN_TYPE_EXISTING";
            }
            s2.a("USER_LOGGED_IN_EVENT", s1);
        }
        b(s3);
        return aw1;
    }

    public ay a(String s1)
    {
        return a(s1, o());
    }

    public ay a(String s1, String s2)
    {
        z();
        o o1 = com.smule.android.network.a.x.a(s1, s2);
        ay ay1 = com.smule.android.network.managers.ay.a(o1);
        if (o1.a())
        {
            Log.i(c, o1.h);
            a(ay1.handle, s1, ay1.accountId, ay1.picUrl, ay1.playerId, s2, null, null, null, null, null, null, com.smule.android.network.managers.ax.b, ay1.testId, ay1.groupId, Long.valueOf(System.currentTimeMillis()), x, null, null, ay1.b, null);
            com.smule.android.f.h.a().a("USER_LOGGED_IN_EVENT", "LOGIN_TYPE_NEW");
        }
        b(o1);
        return ay1;
    }

    public Future a(AccountResponseCallback accountresponsecallback)
    {
        return com.smule.android.network.core.b.a(new Runnable(accountresponsecallback) {

            final AccountResponseCallback a;
            final UserManager b;

            public void run()
            {
                com.smule.android.network.core.a.a(a, b.u());
            }

            
            {
                b = UserManager.this;
                a = accountresponsecallback;
                super();
            }
        });
    }

    public Future a(LoginResponseCallback loginresponsecallback)
    {
        return com.smule.android.network.core.b.a(new Runnable(loginresponsecallback) {

            final LoginResponseCallback a;
            final UserManager b;

            public void run()
            {
                com.smule.android.network.core.a.a(a, b.v());
            }

            
            {
                b = UserManager.this;
                a = loginresponsecallback;
                super();
            }
        });
    }

    public Future a(String s1, NetworkResponseCallback networkresponsecallback)
    {
        return com.smule.android.network.core.b.a(new Runnable(networkresponsecallback, s1) {

            final NetworkResponseCallback a;
            final String b;
            final UserManager c;

            public void run()
            {
                com.smule.android.network.core.a.a(a, c.c(b));
            }

            
            {
                c = UserManager.this;
                a = networkresponsecallback;
                b = s1;
                super();
            }
        });
    }

    public Future a(String s1, AccountIconResponseCallback accounticonresponsecallback)
    {
        return com.smule.android.network.core.b.a(new Runnable(accounticonresponsecallback, s1) {

            final AccountIconResponseCallback a;
            final String b;
            final UserManager c;

            public void run()
            {
                com.smule.android.network.core.a.a(a, c.b(b));
            }

            
            {
                c = UserManager.this;
                a = accounticonresponsecallback;
                b = s1;
                super();
            }
        });
    }

    public void a(o o1)
    {
        o1 = o1.j;
        if (o1.has("picUrl"))
        {
            a(null, null, 0L, o1.get("picUrl").asText(), 0L, null, null, null, null, null, null, null, null, s, t, null, x, null, null, null, null);
        }
    }

    public void a(Long long1)
    {
        android.content.SharedPreferences.Editor editor = b.getSharedPreferences("user", 0).edit();
        if (long1 != null && long1.longValue() != 0L)
        {
            editor.putLong("INSTALL_DATE", long1.longValue());
            w = long1;
        }
        com.smule.android.f.p.a(editor);
    }

    public boolean a()
    {
        return !q;
    }

    public long b()
    {
        return d;
    }

    public at b(String s1)
    {
        return com.smule.android.network.managers.at.a(com.smule.android.network.a.x.a(s1));
    }

    public aw b(String s1, String s2)
    {
        z();
        s1 = com.smule.android.network.a.x.a(s1, s2, e, false);
        aw aw1 = new aw(s1);
        if (s1.a())
        {
            w.b = aw1.j;
            C = aw1.m;
            D = aw1.n;
            Log.i(c, ((o) (s1)).h);
            a(aw1.e, aw1.d, aw1.c, aw1.f, aw1.b, s2, null, null, null, null, null, null, com.smule.android.network.managers.ax.b, aw1.g, aw1.h, aw1.i, aw1.k, null, null, aw1.l, null);
            com.smule.android.f.h.a().a("USER_LOGGED_IN_EVENT", "LOGIN_TYPE_EXISTING");
        }
        b(((o) (s1)));
        return aw1;
    }

    public void b(o o1)
    {
        if (o1 != null && o1.a == com.smule.android.network.core.p.a) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (o1.b != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        o1 = com.smule.android.network.core.o.b(o1.j, "serverTime");
        long l1;
        if (o1 != null)
        {
            l1 = Long.valueOf(o1).longValue();
        } else
        {
            l1 = 0L;
        }
        o1 = Long.valueOf(l1);
        if (o1.longValue() <= 0L) goto _L1; else goto _L3
_L3:
        com.smule.android.c.w.a().a(1000L * o1.longValue());
        return;
        if (o1.b == 72) goto _L1; else goto _L4
_L4:
        com.smule.android.network.core.b.a(o1);
        return;
    }

    public long c()
    {
        return e;
    }

    public o c(String s1)
    {
        return com.smule.android.network.a.x.b(s1);
    }

    public String d()
    {
        return i;
    }

    public String e()
    {
        return f;
    }

    public String f()
    {
        return g;
    }

    public String g()
    {
        return h;
    }

    public boolean h()
    {
        return !TextUtils.isEmpty(f) && d != 0L;
    }

    public boolean i()
    {
        return f == null && e != 0L;
    }

    public Long j()
    {
        return w;
    }

    public int k()
    {
        long l1 = j().longValue() / 1000L;
        return (int)((Long.valueOf(System.currentTimeMillis() / 1000L).longValue() - Long.valueOf(l1).longValue()) / 0x15180L);
    }

    public int l()
    {
        return x;
    }

    public b m()
    {
        return B;
    }

    public aw p()
    {
        Object obj;
        z();
        aw aw1;
        try
        {
            obj = y();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(c, "doReLogin failed with an exception. Assuming a re-login failure.", ((Throwable) (obj)));
            obj = null;
        }
        aw1 = new aw(((o) (obj)));
        if (obj == null || !((o) (obj)).a()) goto _L2; else goto _L1
_L1:
        r = false;
        w.b = aw1.j;
        C = aw1.m;
        D = aw1.n;
        a(aw1.e, aw1.d, aw1.c, aw1.f, aw1.b, null, null, null, l, m, n, o, null, aw1.g, aw1.h, aw1.i, aw1.k, null, null, aw1.l, null);
        if (aw1.o.booleanValue())
        {
            com.smule.android.f.h.a().a("PROFILE_UPDATED_EVENT", new Object[0]);
        }
        com.smule.android.f.h.a().a("USER_RE_LOGGED_IN_EVENT", new Object[0]);
_L4:
        b(((o) (obj)));
        return aw1;
_L2:
        if (obj == null || ((o) (obj)).a == com.smule.android.network.core.p.a)
        {
            r = true;
            f = null;
            if (obj == null || ((o) (obj)).b == 69)
            {
                com.smule.android.f.h.a().a("AUTO_LOGIN_FAILED", new Object[0]);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public o q()
    {
        z();
        o o1 = com.smule.android.network.a.x.a();
        Log.i(c, (new StringBuilder()).append("connectWithFacebook response : ").append(o1.h).toString());
        return o1;
    }

    public o r()
    {
        z();
        k = null;
        z = null;
        com.smule.android.f.p.a(b.getSharedPreferences("user", 0).edit().remove("googlePlusId").remove("GPLUS_ACCESS_TOKEN"));
        o o1 = com.smule.android.network.a.x.b();
        Log.i(c, (new StringBuilder()).append("disconnectWithGooglePlus response : ").append(o1.h).toString());
        return o1;
    }

    public void s()
    {
        if (com.smule.android.network.a.x.c().a())
        {
            q = true;
            Log.i(c, "userInit succeeded");
            android.content.SharedPreferences.Editor editor = b.getSharedPreferences("user", 0).edit();
            editor.putBoolean("INIT_CALL_SUCCEEDED", true);
            com.smule.android.f.p.a(editor);
        }
    }

    protected void t()
    {
        SharedPreferences sharedpreferences = b.getSharedPreferences("user", 0);
        f = sharedpreferences.getString("handle", null);
        try
        {
            d = sharedpreferences.getLong("account", 0L);
        }
        catch (ClassCastException classcastexception)
        {
            d = Long.parseLong(sharedpreferences.getString("account", null));
        }
        try
        {
            e = sharedpreferences.getLong("player", 0L);
        }
        catch (ClassCastException classcastexception1)
        {
            try
            {
                e = sharedpreferences.getInt("player", 0);
            }
            catch (ClassCastException classcastexception2)
            {
                e = Long.parseLong(sharedpreferences.getString("player", null));
            }
        }
        g = sharedpreferences.getString("email", null);
        h = sharedpreferences.getString("password", null);
        p = ax.values()[sharedpreferences.getInt("login_type", 0)];
        j = sharedpreferences.getString("facebookId", null);
        k = sharedpreferences.getString("googlePlusId", null);
        l = sharedpreferences.getString("firstName", null);
        m = sharedpreferences.getString("lastName", null);
        n = sharedpreferences.getString("gender", null);
        o = sharedpreferences.getString("birthday", null);
        q = sharedpreferences.getBoolean("INIT_CALL_SUCCEEDED", false);
        i = sharedpreferences.getString("picUrl", null);
        s = sharedpreferences.getString("test_id", null);
        t = sharedpreferences.getString("group_id", null);
        u = sharedpreferences.getString("NUM_FOLLOWERS_KEY", null);
        v = sharedpreferences.getString("NUM_FOLLOWEES_KEY", null);
        w = Long.valueOf(sharedpreferences.getLong("INSTALL_DATE", 0L));
        x = sharedpreferences.getInt("LOGIN_COUNT", 0);
        z = sharedpreferences.getString("GPLUS_ACCESS_TOKEN", null);
        A = sharedpreferences.getString("profileBlurb", null);
        B = com.smule.android.f.b.a(sharedpreferences.getInt("newsletterOptIn", -1));
        y = sharedpreferences.getString("FB_TOKEN_FOR_BUSINESS", null);
    }

    public au u()
    {
        z();
        return com.smule.android.network.managers.au.a(com.smule.android.network.a.x.d());
    }

    public aw v()
    {
        z();
        o o1 = com.smule.android.network.a.x.b(false, 0L);
        aw aw1 = new aw(o1);
        if (o1.a())
        {
            w.b = aw1.j;
            C = aw1.m;
            D = aw1.n;
            a(aw1.e, aw1.d, aw1.c, aw1.f, aw1.b, null, null, null, null, null, null, null, ax.d, aw1.g, aw1.h, aw1.i, aw1.k, null, null, aw1.l, null);
            com.smule.android.f.h.a().a("USER_LOGGED_IN_EVENT", "LOGIN_TYPE_EXISTING");
        }
        b(o1);
        return aw1;
    }

    public String w()
    {
        return s;
    }

    public String x()
    {
        return t;
    }

}
