// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ad;

import com.shazam.android.ac.a;
import com.shazam.android.activities.f;
import com.shazam.o.q;

public final class d
    implements a
{

    private final long a;
    private boolean b;
    private final f c;

    public d(f f1, q q1)
    {
        b = true;
        c = f1;
        a = -q1.a();
    }

    public final void a()
    {
        b = true;
        c.a(a);
    }

    public final void d()
    {
        if (b)
        {
            c.a();
        }
        b = false;
    }
}
