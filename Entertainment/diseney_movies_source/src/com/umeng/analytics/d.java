// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.onlineconfig.UmengOnlineConfigureListener;
import com.umeng.analytics.onlineconfig.a;
import java.util.HashMap;
import java.util.Map;
import u.aly.ac;
import u.aly.bj;
import u.aly.k;
import u.aly.m;
import u.aly.n;
import u.aly.t;
import u.aly.u;
import u.aly.v;
import u.aly.z;

// Referenced classes of package com.umeng.analytics:
//            c, AnalyticsConfig, e, f

public class d
    implements t
{

    private final a a = new a();
    private Context b;
    private c c;
    private m d;
    private z e;
    private v f;
    private n g;
    private k h;
    private boolean i;

    d()
    {
        b = null;
        d = new m();
        e = new z();
        f = new v();
        i = false;
        d.a(this);
    }

    static n a(d d1)
    {
        return d1.g;
    }

    static void a(d d1, Context context)
    {
        d1.g(context);
    }

    static void b(d d1, Context context)
    {
        d1.h(context);
    }

    private void f(Context context)
    {
        if (!i)
        {
            b = context.getApplicationContext();
            g = new n(b);
            h = k.a(b);
            i = true;
        }
    }

    private void g(Context context)
    {
        f.c(context);
        if (c != null)
        {
            c.a();
        }
    }

    private void h(Context context)
    {
        f.d(context);
        e.a(context);
        if (c != null)
        {
            c.b();
        }
        h.b();
    }

    public void a(int j)
    {
        AnalyticsConfig.mVerticalType = j;
    }

    void a(Context context)
    {
        if (context == null)
        {
            bj.b("MobclickAgent", "unexpected null context in onResume");
            return;
        }
        a.a(context);
        try
        {
            k.a(context).a(a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    void a(Context context, String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        }
        if (context == null)
        {
            bj.b("MobclickAgent", "unexpected null context in reportError");
            return;
        }
        try
        {
            if (!i)
            {
                f(context);
            }
            h.a((new ac(s)).a(false));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "", context);
        }
    }

    void a(Context context, String s, String s1)
    {
        try
        {
            if (!i)
            {
                f(context);
            }
            com.umeng.analytics.e.a(new f(s, s1) {

                final d a;
                private final String b;
                private final String c;

                public void a()
                {
                    com.umeng.analytics.d.a(a).a(b, c);
                }

            
            {
                a = d.this;
                b = s;
                c = s1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "", context);
        }
    }

    public void a(Context context, String s, String s1, long l, int j)
    {
        try
        {
            if (!i)
            {
                f(context);
            }
            g.a(s, s1, l, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "", context);
        }
    }

    public void a(Context context, String s, HashMap hashmap)
    {
        try
        {
            if (!i)
            {
                f(context);
            }
            g.a(s, hashmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "", context);
        }
    }

    void a(Context context, String s, HashMap hashmap, String s1)
    {
        try
        {
            if (!i)
            {
                f(context);
            }
            com.umeng.analytics.e.a(new f(s, hashmap, s1) {

                final d a;
                private final String b;
                private final HashMap c;
                private final String d;

                public void a()
                {
                    com.umeng.analytics.d.a(a).a(b, c, d);
                }

            
            {
                a = d.this;
                b = s;
                c = hashmap;
                d = s1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "", context);
        }
    }

    void a(Context context, String s, Map map, long l)
    {
        try
        {
            if (!i)
            {
                f(context);
            }
            g.a(s, map, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "", context);
        }
    }

    void a(Context context, Throwable throwable)
    {
        if (context == null || throwable == null)
        {
            return;
        }
        try
        {
            if (!i)
            {
                f(context);
            }
            h.a((new ac(throwable)).a(false));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "", context);
        }
    }

    public void a(c c1)
    {
        c = c1;
    }

    void a(UmengOnlineConfigureListener umengonlineconfigurelistener)
    {
        a.a(umengonlineconfigurelistener);
    }

    void a(String s)
    {
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        e.a(s);
        return;
        s;
        s.printStackTrace();
        return;
    }

    public void a(String s, String s1)
    {
        AnalyticsConfig.mWrapperType = s;
        AnalyticsConfig.mWrapperVersion = s1;
    }

    public void a(Throwable throwable)
    {
        try
        {
            e.a();
            if (b == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            bj.a("MobclickAgent", "Exception in onAppCrash", throwable);
            return;
        }
        if (throwable == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        if (h != null)
        {
            h.b(new ac(throwable));
        }
        h(b);
        u.a(b).edit().commit();
        com.umeng.analytics.e.a();
        return;
    }

    void b(Context context)
    {
        if (context == null)
        {
            bj.b("MobclickAgent", "unexpected null context in onResume");
            return;
        }
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN)
        {
            e.a(context.getClass().getName());
        }
        try
        {
            if (!i)
            {
                f(context);
            }
            com.umeng.analytics.e.a(new f(context) {

                final d a;
                private final Context b;

                public void a()
                {
                    com.umeng.analytics.d.a(a, b.getApplicationContext());
                }

            
            {
                a = d.this;
                b = context;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "Exception occurred in Mobclick.onResume(). ", context);
        }
    }

    void b(Context context, String s, String s1)
    {
        try
        {
            com.umeng.analytics.e.a(new f(s, s1) {

                final d a;
                private final String b;
                private final String c;

                public void a()
                {
                    com.umeng.analytics.d.a(a).b(b, c);
                }

            
            {
                a = d.this;
                b = s;
                c = s1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "", context);
        }
    }

    void b(String s)
    {
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        e.b(s);
        return;
        s;
        s.printStackTrace();
        return;
    }

    void c(Context context)
    {
        if (context == null)
        {
            bj.b("MobclickAgent", "unexpected null context in onPause");
            return;
        }
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN)
        {
            e.b(context.getClass().getName());
        }
        try
        {
            if (!i)
            {
                f(context);
            }
            com.umeng.analytics.e.a(new f(context) {

                final d a;
                private final Context b;

                public void a()
                {
                    d.b(a, b.getApplicationContext());
                }

            
            {
                a = d.this;
                b = context;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "Exception occurred in Mobclick.onRause(). ", context);
        }
    }

    void c(Context context, String s, String s1)
    {
        try
        {
            com.umeng.analytics.e.a(new f(s, s1) {

                final d a;
                private final String b;
                private final String c;

                public void a()
                {
                    com.umeng.analytics.d.a(a).c(b, c);
                }

            
            {
                a = d.this;
                b = s;
                c = s1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "", context);
        }
    }

    void d(Context context)
    {
        try
        {
            if (!i)
            {
                f(context);
            }
            h.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b("MobclickAgent", "", context);
        }
    }

    void e(Context context)
    {
        try
        {
            e.a();
            h(context);
            u.a(context).edit().commit();
            com.umeng.analytics.e.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }
}
