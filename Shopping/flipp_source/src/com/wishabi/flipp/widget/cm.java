// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.util.SparseBooleanArray;
import com.wishabi.flipp.util.l;
import com.wishabi.flipp.util.m;
import com.wishabi.flipp.util.o;
import java.util.ArrayList;

// Referenced classes of package com.wishabi.flipp.widget:
//            cv, ct, ck, cr

final class cm
    implements cv
{

    final ck a;

    cm(ck ck1)
    {
        a = ck1;
        super();
    }

    public final void a(ct ct1)
    {
        int i = ct1.c();
        ct1 = a.c.d(i);
        int j = (int)((m) (ct1)).a;
        cr cr1;
        boolean flag;
        if (!a.d.get(j))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.d.put(j, flag);
        a.c(i);
        ct1 = a.c.a(((m) (ct1)).b);
        if (((o) (ct1)).a.isEmpty())
        {
            ct1 = null;
        } else
        {
            ct1 = (m)((o) (ct1)).a.get(0);
        }
        cr1 = (cr)((m) (ct1)).e;
        if (flag)
        {
            cr1.b = cr1.b + 1;
        } else
        {
            cr1.b = cr1.b - 1;
        }
        a.c(((m) (ct1)).c);
    }
}
