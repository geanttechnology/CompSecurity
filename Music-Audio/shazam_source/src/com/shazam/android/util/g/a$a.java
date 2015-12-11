// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.util.g;

import android.content.Context;
import android.location.Geocoder;
import java.util.Locale;
import java.util.concurrent.Callable;

// Referenced classes of package com.shazam.android.util.g:
//            a, c

private final class d
    implements Callable
{

    final a a;
    private final double b;
    private final double c;
    private final Context d;

    public final Object call()
    {
        return com.shazam.android.util.g.c.a(b, c, new Geocoder(d, Locale.getDefault()));
    }

    public (a a1, double d1, double d2, Context context)
    {
        a = a1;
        super();
        b = d1;
        c = d2;
        d = context;
    }
}
