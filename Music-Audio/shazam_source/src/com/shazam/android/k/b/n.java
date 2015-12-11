// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.b;

import android.content.Context;
import com.shazam.android.k.a.a;
import com.shazam.android.k.b;
import com.shazam.android.k.k;
import com.shazam.g.e;
import com.shazam.g.f;

public final class n
    implements e
{

    private final k a;
    private final Context b;
    private f c;

    public n(k k1, Context context)
    {
        a = k1;
        b = context;
    }

    public final void a()
    {
        try
        {
            b b1 = a.a(b);
            c.onDataFetched(b1.a);
            return;
        }
        catch (a a1)
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
