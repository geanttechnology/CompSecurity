// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Referenced classes of package com.offerup.android.g:
//            b, h

public final class g extends b
{

    private boolean a;

    public g()
    {
    }

    final String a()
    {
        if (a)
        {
            return "payments_makeoffer_cardonfileoffersentconfirmation";
        } else
        {
            return "payments_makeoffer_cardaddedconfirmation";
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f040084, viewgroup, false);
        getArguments().getBoolean("fromChat", false);
        a = getArguments().getBoolean("cardAlreadyOnFile", false);
        if (a)
        {
            viewgroup = layoutinflater.findViewById(0x7f1001ee);
            bundle = (TextView)layoutinflater.findViewById(0x7f1001e3);
            viewgroup.setVisibility(8);
            bundle.setText("Offer Sent");
        }
        layoutinflater.findViewById(0x7f1001ef).setOnClickListener(new h(this));
        return layoutinflater;
    }
}
