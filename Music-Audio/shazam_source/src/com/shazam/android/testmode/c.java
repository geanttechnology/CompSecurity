// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.testmode;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import com.shazam.android.persistence.n.b;
import com.shazam.android.testmode.a.d;
import com.shazam.android.testmode.a.e;
import com.shazam.server.response.config.Provider;

// Referenced classes of package com.shazam.android.testmode:
//            e

public final class c
    implements com.shazam.android.testmode.e
{

    private final Context a;
    private final b b;
    private final d c;
    private final SharedPreferences d;

    public c(Context context, b b1, d d1)
    {
        a = context;
        b = b1;
        c = d1;
        d = context.getSharedPreferences("testmode", 0);
    }

    private String b(int i1)
    {
        return a.getString(i1);
    }

    private boolean o()
    {
        return d.getBoolean(b(0x7f090262), false);
    }

    public final int a(int i1)
    {
        return Integer.valueOf(d.getString(b(0x7f09025a), String.valueOf(i1))).intValue();
    }

    public final String a()
    {
        return d.getString(b(0x7f09025d), null);
    }

    public final String b()
    {
        String s = null;
        if (d.getBoolean(b(0x7f090278), false))
        {
            s = d.getString(b(0x7f090279), null);
        }
        return s;
    }

    public final String c()
    {
        String s = b(0x7f090192);
        return d.getString(b(0x7f090263), s);
    }

    public final String d()
    {
        String s = b(0x7f090191);
        return b.a("pk_auth_base", s);
    }

    public final String e()
    {
        String s = b(0x7f090190);
        return b.a("pk_amp_base", s);
    }

    public final boolean f()
    {
        return d.getBoolean(b(0x7f090259), false);
    }

    public final Provider g()
    {
        if (!o())
        {
            return null;
        } else
        {
            String s = d.getString(b(0x7f090256), null);
            return com.shazam.android.testmode.a.d.a(com.shazam.android.testmode.a.d.a.a, s).a();
        }
    }

    public final Provider h()
    {
        if (!o())
        {
            return null;
        } else
        {
            return com.shazam.android.testmode.a.d.a(com.shazam.android.testmode.a.d.a.b, null).a();
        }
    }

    public final Provider i()
    {
        if (!o())
        {
            return null;
        } else
        {
            return com.shazam.android.testmode.a.d.a(com.shazam.android.testmode.a.d.a.c, null).a();
        }
    }

    public final String j()
    {
        String s = b(0x7f09025c);
        return d.getString(s, "");
    }

    public final boolean k()
    {
        return d.getBoolean(b(0x7f090265), false);
    }

    public final void l()
    {
        if (d.getBoolean(b(0x7f090276), false))
        {
            StrictMode.enableDefaults();
        }
    }

    public final boolean m()
    {
        return d.getBoolean(b(0x7f090267), false);
    }

    public final boolean n()
    {
        return d.getBoolean(b(0x7f090264), false);
    }
}
