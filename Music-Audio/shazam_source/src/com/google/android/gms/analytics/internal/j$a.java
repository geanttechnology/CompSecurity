// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ii;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            j, o, r

public final class <init>
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
        android.content.edPreferences.Editor editor = b.a.edit();
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

    private (j j1, String s, long l)
    {
        b = j1;
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

    a(j j1, String s, long l, byte byte0)
    {
        this(j1, s, l);
    }
}
