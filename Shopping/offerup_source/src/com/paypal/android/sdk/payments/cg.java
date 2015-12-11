// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.widget.LinearLayout;
import com.paypal.android.sdk.el;
import com.paypal.android.sdk.ex;
import com.paypal.android.sdk.fa;
import com.paypal.android.sdk.fb;

// Referenced classes of package com.paypal.android.sdk.payments:
//            bd, ca, bh, br

final class cg
    implements bd
{

    private ca a;

    cg(ca ca1)
    {
        a = ca1;
        super();
    }

    public final void a(bh bh1)
    {
        a.dismissDialog(2);
        if (bh1.b.equals("invalid_nonce"))
        {
            a.c.h.setEnabled(false);
            br.a(a, ex.a(fa.aL), 4);
            return;
        } else
        {
            a.c.h.setEnabled(true);
            br.a(a, ex.a(bh1.b), 1);
            return;
        }
    }

    public final void a(Object obj)
    {
        if (obj instanceof el)
        {
            ca.a(a, (el)obj);
            return;
        } else
        {
            ca.b(a);
            return;
        }
    }
}
