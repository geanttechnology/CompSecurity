// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            ky, ix, iy, kz, 
//            ks, kt, ii

final class iw
{

    private final ky a;
    private int b;
    private final ks c;

    public iw(ks ks1)
    {
        a = new ky(new ix(this, ks1), new iy());
        c = kz.a(a);
    }

    static int a(iw iw1)
    {
        return iw1.b;
    }

    static int a(iw iw1, int i)
    {
        iw1.b = i;
        return i;
    }

    private kt b()
    {
        int i = c.f();
        return c.c(i);
    }

    public final List a(int i)
    {
        b = b + i;
        int j = c.f();
        if (j < 0)
        {
            throw new IOException((new StringBuilder("numberOfPairs < 0: ")).append(j).toString());
        }
        if (j > 1024)
        {
            throw new IOException((new StringBuilder("numberOfPairs > 1024: ")).append(j).toString());
        }
        ArrayList arraylist = new ArrayList(j);
        for (i = 0; i < j; i++)
        {
            kt kt1 = b().c();
            kt kt2 = b();
            if (kt1.b.length == 0)
            {
                throw new IOException("name.size == 0");
            }
            arraylist.add(new ii(kt1, kt2));
        }

        if (b > 0)
        {
            a.b();
            if (b != 0)
            {
                throw new IOException((new StringBuilder("compressedLimit > 0: ")).append(b).toString());
            }
        }
        return arraylist;
    }

    public final void a()
    {
        c.close();
    }
}
