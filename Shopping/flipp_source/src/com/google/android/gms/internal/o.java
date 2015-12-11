// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            er, p

public final class o
{

    public static final String a = er.a("emulator");
    public final Date b;
    public final int c;
    public final Set d;
    public final Location e;
    public final boolean f;
    final Map g;
    public final String h;
    final SearchAdRequest i;
    final int j;
    private final Set k;

    public o(p p1)
    {
        this(p1, null);
    }

    public o(p p1, SearchAdRequest searchadrequest)
    {
        b = p1.d;
        c = p1.e;
        d = Collections.unmodifiableSet(p1.a);
        e = p1.f;
        f = p1.g;
        g = Collections.unmodifiableMap(p1.b);
        h = p1.h;
        i = searchadrequest;
        j = p1.i;
        k = Collections.unmodifiableSet(p1.c);
    }

    public final NetworkExtras a(Class class1)
    {
        return (NetworkExtras)g.get(class1);
    }

    public final boolean a(Context context)
    {
        return k.contains(er.a(context));
    }

}
