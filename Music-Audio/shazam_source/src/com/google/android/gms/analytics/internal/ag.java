// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.d.ja;
import com.google.android.gms.d.jf;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, o, r, l

public final class ag extends p
{

    ag(r r1)
    {
        super(r1);
    }

    protected final void a()
    {
    }

    public final jf b()
    {
        o();
        DisplayMetrics displaymetrics = super.i.b().a.getResources().getDisplayMetrics();
        jf jf1 = new jf();
        jf1.a = l.a(Locale.getDefault());
        jf1.c = displaymetrics.widthPixels;
        jf1.d = displaymetrics.heightPixels;
        return jf1;
    }

    public final String c()
    {
        o();
        jf jf1 = b();
        return (new StringBuilder()).append(jf1.c).append("x").append(jf1.d).toString();
    }
}
