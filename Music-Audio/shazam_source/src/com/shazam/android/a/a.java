// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a;

import android.content.res.Resources;
import android.support.v4.app.k;
import com.shazam.android.fragment.home.c;
import com.shazam.i.d.d;

// Referenced classes of package com.shazam.android.a:
//            c

public final class a extends com.shazam.android.a.c
{

    private final com.shazam.b.a.a d;

    public a(Resources resources, k k)
    {
        this(com.shazam.i.b.w.c.a.a(), com.shazam.i.d.d.e(), resources, k);
    }

    private a(c c1, com.shazam.b.a.a a1, Resources resources, k k)
    {
        super(c1, resources, k);
        d = a1;
    }

    public final int a(com.shazam.android.k.f.b.a a1)
    {
        a1 = (com.shazam.android.fragment.home.d)d.a(a1);
        return c.a(a1);
    }
}
