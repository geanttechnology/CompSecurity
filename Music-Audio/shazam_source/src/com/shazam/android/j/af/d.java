// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.af;

import com.shazam.android.ay.a.h;
import com.shazam.android.ay.a.j;
import com.shazam.model.Provider;

// Referenced classes of package com.shazam.android.j.af:
//            c

public final class d
    implements c
{

    private final h a;
    private final Provider b;

    public d(h h1, Provider provider)
    {
        a = h1;
        b = provider;
    }

    public final void a()
    {
        j j1 = (j)b.a();
        if (j1 != j.b)
        {
            j1.a();
            a.a(j1);
        }
    }
}
