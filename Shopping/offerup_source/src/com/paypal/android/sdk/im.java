// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.paypal.android.sdk:
//            kq, kt, ii, ik

final class im
{

    private final kq a;

    im(kq kq1)
    {
        a = kq1;
    }

    private void a(int i, int j)
    {
        if (i < j)
        {
            a.b(i | 0);
            return;
        }
        a.b(j | 0);
        for (i -= j; i >= 128; i >>>= 7)
        {
            a.b(i & 0x7f | 0x80);
        }

        a.b(i);
    }

    private void a(kt kt1)
    {
        a(kt1.b.length, 127);
        a.a(kt1);
    }

    final void a(List list)
    {
        int j = list.size();
        int i = 0;
        while (i < j) 
        {
            kt kt1 = ((ii)list.get(i)).h.c();
            Integer integer = (Integer)ik.b().get(kt1);
            if (integer != null)
            {
                a(integer.intValue() + 1, 15);
                a(((ii)list.get(i)).i);
            } else
            {
                a.b(0);
                a(kt1);
                a(((ii)list.get(i)).i);
            }
            i++;
        }
    }
}
