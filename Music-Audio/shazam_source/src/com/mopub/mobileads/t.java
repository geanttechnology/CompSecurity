// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mopub.c.p;
import com.mopub.mobileads.a.d;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            n, s, u, e

public final class t
    implements n.a
{
    public static interface a
    {

        public abstract void b();

        public abstract void b(s s);

        public abstract void c();

        public abstract void d();

        public abstract void e();
    }

    private static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        private static final b c[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/mopub/mobileads/t$b, s);
        }

        public static b[] values()
        {
            return (b[])c.clone();
        }

        static 
        {
            a = new b("CUSTOM_EVENT_AD_READY", 0);
            b = new b("NOT_READY", 1);
            c = (new b[] {
                a, b
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }

    public final class c extends u
    {

        final t a;

        protected final void a()
        {
            com.mopub.common.c.a.b("Tracking impression for interstitial.");
            if (b != null)
            {
                Object obj = b;
                if (((e) (obj)).e != null)
                {
                    String s1 = ((e) (obj)).e.d;
                    obj = ((e) (obj)).b;
                    com.mopub.common.a.a.d d1 = com.mopub.common.a.a.d.b;
                    p.a(s1, ((Context) (obj)));
                }
            }
        }

        protected final void a(s s1)
        {
            if (a.c != null)
            {
                a.c.b(s1);
            }
        }

        protected final void a(String s1, Map map)
        {
            if (b != null)
            {
                if (TextUtils.isEmpty(s1))
                {
                    com.mopub.common.c.a.b("Couldn't invoke custom event because the server did not specify one.");
                    b(s.g);
                    return;
                }
                if (a.b != null)
                {
                    a.b.e();
                }
                com.mopub.common.c.a.b("Loading custom event interstitial adapter.");
                a.b = com.mopub.mobileads.a.d.a(a, s1, map, b.a, b.c());
                a.b.b = a;
                s1 = a.b;
                if (!((n) (s1)).a && ((n) (s1)).c != null && s1.f() > 0)
                {
                    ((n) (s1)).d.postDelayed(((n) (s1)).e, s1.f());
                    return;
                }
            }
        }

        public final com.mopub.common.a getAdFormat()
        {
            return com.mopub.common.a.b;
        }

        public c(Context context)
        {
            a = t.this;
            super(context);
            setAutorefreshEnabled(false);
        }
    }


    c a;
    n b;
    a c;
    Activity d;
    private String e;
    private b f;
    private boolean g;

    public t(Activity activity, String s)
    {
        d = activity;
        e = s;
        a = new c(d);
        a.setAdUnitId(e);
        f = b.b;
    }

    public final void a()
    {
        if (!g)
        {
            f = b.a;
            if (c != null)
            {
                c.b();
                return;
            }
        }
    }

    public final void a(s s)
    {
        if (g)
        {
            return;
        } else
        {
            f = b.b;
            a.b(s);
            return;
        }
    }

    public final void a(a a1)
    {
        c = a1;
    }

    public final void a(String s)
    {
        a.setKeywords(s);
    }

    public final void b()
    {
        if (!g)
        {
            a.a();
            if (c != null)
            {
                c.e();
                return;
            }
        }
    }

    public final void c()
    {
        if (!g)
        {
            a.d();
            if (c != null)
            {
                c.c();
                return;
            }
        }
    }

    public final void d()
    {
        if (!g)
        {
            f = b.b;
            if (c != null)
            {
                c.d();
                return;
            }
        }
    }

    public final void e()
    {
        f = b.b;
        if (b != null)
        {
            b.e();
            b = null;
        }
        g = false;
        a.b();
    }

    public final boolean f()
    {
        return f != b.b;
    }

    public final boolean g()
    {
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[b.values().length];
                try
                {
                    a[b.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1.a[f.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            return true;
        }
    }

    public final void h()
    {
        g = true;
        if (b != null)
        {
            b.e();
            b = null;
        }
        a.setBannerAdListener(null);
        a.c();
    }
}
