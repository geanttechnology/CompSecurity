// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.g.e;
import com.shazam.g.f;
import com.shazam.h.j;

// Referenced classes of package com.shazam.android.an.b:
//            h

public final class y
    implements e
{

    private final h a;
    private final String b;
    private f c;

    public y(h h1, String s)
    {
        c = new com.shazam.g.f.a();
        a = h1;
        b = s;
    }

    public final void a()
    {
        try
        {
            c.onDataFetched(a.b(b));
            return;
        }
        catch (j j1)
        {
            c.onDataFailedToLoad();
        }
    }

    public final void a(f f1)
    {
        c = f1;
    }

    public final void b()
    {
        c = new com.shazam.g.f.a();
    }
}
