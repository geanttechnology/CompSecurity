// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.eh;
import com.paypal.android.sdk.el;

// Referenced classes of package com.paypal.android.sdk.payments:
//            bd, bh

class d
{

    private bh a;
    private Object b;
    private bd c;

    d()
    {
    }

    private void b(bd bd1)
    {
        bd1.a(b);
        boolean flag;
        if (!(b instanceof eh) && !(b instanceof el))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = null;
        if (flag)
        {
            c = null;
        }
    }

    final void a()
    {
        if (b == null)
        {
            b = "success";
        }
        if (c != null)
        {
            b(c);
        }
    }

    final void a(bd bd1)
    {
        if (b != null)
        {
            b(bd1);
            return;
        }
        if (a != null)
        {
            bd1.a(a);
            a = null;
            c = null;
            return;
        } else
        {
            c = bd1;
            return;
        }
    }

    final void a(bh bh)
    {
        if (c != null)
        {
            c.a(bh);
            return;
        } else
        {
            a = bh;
            return;
        }
    }

    final void a(Object obj)
    {
        b = obj;
    }

    final void b()
    {
        c = null;
    }

    static 
    {
        com/paypal/android/sdk/payments/d.getSimpleName();
    }
}
