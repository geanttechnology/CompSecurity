// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.cyberlink.beautycircle.controller.adapter.q;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.model.ProductPrice;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            PageProductsFragment

class a
    implements android.widget.Listener
{

    final PageProductsFragment a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (ProductPrice)adapterview.getItemAtPosition(i);
        if (a.h != null)
        {
            ((q)a.h).b = adapterview;
            a.h.clear();
            a.h.c();
        }
        ((TextView)a.getView().findViewById(j.product_btn_price_text)).setText(adapterview.toString());
        a.n();
    }

    (PageProductsFragment pageproductsfragment)
    {
        a = pageproductsfragment;
        super();
    }
}
