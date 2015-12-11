// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.y;

import com.shazam.android.ae.m;
import com.shazam.android.y.c.b;
import com.shazam.android.y.d.a;
import com.shazam.android.y.e.d;
import com.shazam.android.y.g.c;

// Referenced classes of package com.shazam.android.y:
//            a, c

final class a
    implements Runnable
{

    final a a;
    final com.shazam.android.y.a b;

    public final void run()
    {
        try
        {
            c.a(a);
            b.b.a(a);
            b.a.a();
            return;
        }
        catch (b b1)
        {
            m.a(this, "Could not save request", b1);
        }
    }

    (com.shazam.android.y.a a1, a a2)
    {
        b = a1;
        a = a2;
        super();
    }
}
