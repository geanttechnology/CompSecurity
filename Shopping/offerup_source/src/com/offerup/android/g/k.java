// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.b.a.a.g;
import com.offerup.android.c.a;
import com.offerup.android.utils.ax;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.g:
//            b, l, m, n, 
//            o

public final class k extends b
{

    Button a;
    ax b;
    private Button c;
    private View d;
    private boolean e;

    public k()
    {
    }

    final String a()
    {
        if (e)
        {
            return "payments_chat_promo";
        } else
        {
            return "payments_makeoffer_promo";
        }
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            b = (ax)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            g.a("BuyWithNoCardsFragment", classcastexception);
        }
        throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement OnHeadlineSelectedListener").toString());
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f040094, viewgroup, false);
        e = getArguments().getBoolean("fromChat", false);
        c = (Button)layoutinflater.findViewById(0x7f1001ef);
        a = (Button)layoutinflater.findViewById(0x7f10024c);
        d = layoutinflater.findViewById(0x7f10024d);
        if (e)
        {
            layoutinflater.findViewById(0x7f10023d).setVisibility(8);
            layoutinflater.findViewById(0x7f10023e).setVisibility(8);
            layoutinflater.findViewById(0x7f10024a).setVisibility(0);
        }
        c.setOnClickListener(new l(this));
        a.setOnClickListener(new m(this));
        d.setOnClickListener(new n(this));
        layoutinflater.findViewById(0x7f100249).setOnClickListener(new o(this));
        viewgroup = (TextView)layoutinflater.findViewById(0x7f10023d);
        if (StringUtils.isNotEmpty(a.offerSentText))
        {
            viewgroup.setText(a.offerSentText);
        } else
        {
            viewgroup.setVisibility(8);
        }
        if (!a.showCheckbox)
        {
            layoutinflater.findViewById(0x7f10023e).setVisibility(8);
        }
        viewgroup = (TextView)layoutinflater.findViewById(0x7f10023f);
        if (StringUtils.isNotEmpty(a.titlePaymentsPromoScreen))
        {
            viewgroup.setText(a.titlePaymentsPromoScreen);
        } else
        {
            viewgroup.setVisibility(8);
        }
        if (!a.showCreditCardsPaymentsPromoScreen)
        {
            layoutinflater.findViewById(0x7f100240).setVisibility(8);
        }
        viewgroup = (TextView)layoutinflater.findViewById(0x7f10024b);
        if (StringUtils.isNotEmpty(a.disclaimerPaymentsPromoScreen))
        {
            viewgroup.setText(a.disclaimerPaymentsPromoScreen);
        } else
        {
            viewgroup.setVisibility(8);
        }
        c.setText(a.addCardButtonTextPaymentsPromoScreen);
        if (StringUtils.isNotEmpty(a.exitButtonTextPaymentsPromoScreen))
        {
            a.setText(a.exitButtonTextPaymentsPromoScreen);
        } else
        {
            a.setVisibility(8);
        }
        if (StringUtils.isNotEmpty(a.line1BulletPaymentsPromoScreen))
        {
            layoutinflater.findViewById(0x7f100241).setVisibility(0);
            layoutinflater.findViewById(0x7f100242).setVisibility(0);
            ((TextView)layoutinflater.findViewById(0x7f100242)).setText(a.line1BulletPaymentsPromoScreen);
        } else
        {
            layoutinflater.findViewById(0x7f100241).setVisibility(8);
            layoutinflater.findViewById(0x7f100242).setVisibility(8);
        }
        if (StringUtils.isNotEmpty(a.line2BulletPaymentsPromoScreen))
        {
            layoutinflater.findViewById(0x7f100243).setVisibility(0);
            layoutinflater.findViewById(0x7f100244).setVisibility(0);
            ((TextView)layoutinflater.findViewById(0x7f100244)).setText(a.line2BulletPaymentsPromoScreen);
        } else
        {
            layoutinflater.findViewById(0x7f100243).setVisibility(8);
            layoutinflater.findViewById(0x7f100244).setVisibility(8);
        }
        if (StringUtils.isNotEmpty(a.line3BulletPaymentsPromoScreen))
        {
            layoutinflater.findViewById(0x7f100245).setVisibility(0);
            layoutinflater.findViewById(0x7f100246).setVisibility(0);
            ((TextView)layoutinflater.findViewById(0x7f100246)).setText(a.line3BulletPaymentsPromoScreen);
        } else
        {
            layoutinflater.findViewById(0x7f100245).setVisibility(8);
            layoutinflater.findViewById(0x7f100246).setVisibility(8);
        }
        if (StringUtils.isNotEmpty(a.line4BulletPaymentsPromoScreen))
        {
            layoutinflater.findViewById(0x7f100247).setVisibility(0);
            layoutinflater.findViewById(0x7f100248).setVisibility(0);
            ((TextView)layoutinflater.findViewById(0x7f100248)).setText(a.line4BulletPaymentsPromoScreen);
            return layoutinflater;
        } else
        {
            layoutinflater.findViewById(0x7f100247).setVisibility(8);
            layoutinflater.findViewById(0x7f100248).setVisibility(8);
            return layoutinflater;
        }
    }
}
