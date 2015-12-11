// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WeddingAddressFragment

class a
    implements android.widget.dListener
{

    final WeddingAddressFragment a;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (!WeddingAddressFragment.a(a).getSelectedItem().toString().equals("Select a state"))
        {
            WeddingAddressFragment.a(a, true);
            if (WeddingAddressFragment.b(a) && WeddingAddressFragment.c(a) && WeddingAddressFragment.d(a) && WeddingAddressFragment.e(a) && WeddingAddressFragment.f(a) && WeddingAddressFragment.g(a) && WeddingAddressFragment.h(a))
            {
                WeddingAddressFragment.b(a, true);
                WeddingAddressFragment.c(a, true);
                return;
            } else
            {
                WeddingAddressFragment.b(a, false);
                WeddingAddressFragment.c(a, false);
                return;
            }
        } else
        {
            WeddingAddressFragment.a(a, false);
            WeddingAddressFragment.b(a, false);
            WeddingAddressFragment.c(a, false);
            return;
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        WeddingAddressFragment.a(a, false);
    }

    (WeddingAddressFragment weddingaddressfragment)
    {
        a = weddingaddressfragment;
        super();
    }
}
