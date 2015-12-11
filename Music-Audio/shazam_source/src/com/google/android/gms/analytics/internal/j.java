// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ii;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, ak, o, r, 
//            k

public final class j extends p
{
    public final class a
    {

        final long a;
        final j b;
        private final String c;

        private String e()
        {
            return (new StringBuilder()).append(c).append(":start").toString();
        }

        final void a()
        {
            long l = ((o) (b)).i.c.a();
            android.content.SharedPreferences.Editor editor = b.a.edit();
            editor.remove(c());
            editor.remove(d());
            editor.putLong(e(), l);
            editor.commit();
        }

        final long b()
        {
            return b.a.getLong(e(), 0L);
        }

        final String c()
        {
            return (new StringBuilder()).append(c).append(":count").toString();
        }

        final String d()
        {
            return (new StringBuilder()).append(c).append(":value").toString();
        }

        private a(String s, long l)
        {
            b = j.this;
            super();
            w.a(s);
            boolean flag;
            if (l > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w.b(flag);
            c = s;
            a = l;
        }

        a(String s, long l, byte byte0)
        {
            this(s, l);
        }
    }


    SharedPreferences a;
    final a b;
    private long c;
    private long d;

    protected j(r r1)
    {
        super(r1);
        d = -1L;
        b = new a("monitoring", ((Long)ak.P.a()).longValue(), (byte)0);
    }

    protected final void a()
    {
        a = super.i.a.getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final void a(String s)
    {
        r.i();
        o();
        android.content.SharedPreferences.Editor editor = a.edit();
        if (TextUtils.isEmpty(s))
        {
            editor.remove("installation_campaign");
        } else
        {
            editor.putString("installation_campaign", s);
        }
        if (!editor.commit())
        {
            e("Failed to commit campaign data");
        }
    }

    public final long b()
    {
        r.i();
        o();
        if (c == 0L)
        {
            long l = a.getLong("first_run", 0L);
            if (l != 0L)
            {
                c = l;
            } else
            {
                long l1 = super.i.c.a();
                android.content.SharedPreferences.Editor editor = a.edit();
                editor.putLong("first_run", l1);
                if (!editor.commit())
                {
                    e("Failed to commit first run time");
                }
                c = l1;
            }
        }
        return c;
    }

    public final k c()
    {
        return new k(super.i.c, b());
    }

    public final long d()
    {
        r.i();
        o();
        if (d == -1L)
        {
            d = a.getLong("last_dispatch", 0L);
        }
        return d;
    }

    public final void e()
    {
        r.i();
        o();
        long l = super.i.c.a();
        android.content.SharedPreferences.Editor editor = a.edit();
        editor.putLong("last_dispatch", l);
        editor.apply();
        d = l;
    }

    public final String f()
    {
        r.i();
        o();
        String s = a.getString("installation_campaign", null);
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return s;
        }
    }
}
