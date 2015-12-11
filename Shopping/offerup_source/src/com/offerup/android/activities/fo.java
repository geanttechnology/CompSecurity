// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import android.widget.AdapterView;
import com.b.a.a.g;
import com.offerup.android.a.af;
import com.offerup.android.dto.PaymentMethod;

// Referenced classes of package com.offerup.android.activities:
//            PaymentMethodsActivity

final class fo
    implements android.widget.AdapterView.OnItemClickListener
{

    private PaymentMethodsActivity a;

    fo(PaymentMethodsActivity paymentmethodsactivity)
    {
        a = paymentmethodsactivity;
        super();
    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        try
        {
            a.k = a.j.a(i);
            if (a.l)
            {
                a.openContextMenu(view);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            g.a(a, adapterview);
            return;
        }
        if (a.k.isAndroidPay())
        {
            a.a();
            return;
        }
        a.finish();
        return;
    }
}
