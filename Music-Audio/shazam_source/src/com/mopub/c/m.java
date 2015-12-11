// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import com.mopub.d.i;
import com.mopub.d.j;
import com.mopub.d.s;

// Referenced classes of package com.mopub.c:
//            c

public final class m extends c
{

    public m()
    {
        this((byte)0);
    }

    private m(byte byte0)
    {
        c = 60000;
        e = 5;
        b = 2;
    }

    private void d()
    {
        a = (int)(Math.pow(b, d) * (double)c);
        d = d + 1;
    }

    public final void a(s s1)
    {
        if (!c())
        {
            throw s1;
        }
        if (s1 instanceof j)
        {
            d();
            return;
        }
        i k = s1.c;
        if (k != null && (k.a == 503 || k.a == 504))
        {
            d();
            return;
        } else
        {
            throw s1;
        }
    }
}
