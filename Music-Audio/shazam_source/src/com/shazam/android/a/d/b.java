// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.d;

import android.os.Handler;
import android.support.v4.app.i;
import com.shazam.android.widget.feed.l;
import com.shazam.model.Factory;
import com.shazam.model.availability.GooglePlayAvailability;

// Referenced classes of package com.shazam.android.a.d:
//            c

public final class b
{

    private final l a;
    private final GooglePlayAvailability b;
    private final Factory c;
    private final Handler d;

    public b(l l, GooglePlayAvailability googleplayavailability, Factory factory, Handler handler)
    {
        a = l;
        b = googleplayavailability;
        c = factory;
        d = handler;
    }

    public final c a(i i)
    {
        return new c(i, a, (com.shazam.android.advert.g.b)c.create(i), b, d, com.shazam.i.b.n.b.J());
    }
}
