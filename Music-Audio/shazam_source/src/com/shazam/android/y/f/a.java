// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.y.f;

import com.shazam.android.y.a.c;
import com.shazam.android.y.g.b;
import com.shazam.h.i;
import com.shazam.h.j;
import com.shazam.h.l;

// Referenced classes of package com.shazam.android.y.f:
//            b

public final class a
    implements com.shazam.android.y.f.b
{

    private final b a;
    private final i b;
    private final c c;

    public a(i k, b b1, c c1)
    {
        a = b1;
        b = k;
        c = c1;
    }

    public final boolean a(com.shazam.android.y.d.a a1)
    {
        boolean flag;
        try
        {
            l l1 = a1.b;
            com.shazam.h.o o = b.a(l1);
            flag = a.a(o);
            c.a(a1.a, l1.a, o);
        }
        // Misplaced declaration of an exception variable
        catch (com.shazam.android.y.d.a a1)
        {
            throw new com.shazam.android.y.c.c("Exception sending request", a1);
        }
        return flag;
    }
}
