// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

// Referenced classes of package com.groupon.activity:
//            IPay88Purchase, ECommercePurchase, GrouponActivity

public class er extends er
{

    public volatile void bind(butterknife.ewBinder ewbinder, ECommercePurchase ecommercepurchase, Object obj)
    {
        bind(ewbinder, (IPay88Purchase)ecommercepurchase, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (IPay88Purchase)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, IPay88Purchase ipay88purchase, Object obj)
    {
        super.bind(ewbinder, ipay88purchase, obj);
        ipay88purchase.paymentWebViewMaybank = (WebView)ewbinder.((View)ewbinder.iredView(obj, 0x7f1004a0, "field 'paymentWebViewMaybank'"), 0x7f1004a0, "field 'paymentWebViewMaybank'");
        ipay88purchase.maybankChildWebViewsContainer = (LinearLayout)ewbinder.((View)ewbinder.iredView(obj, 0x7f1004a1, "field 'maybankChildWebViewsContainer'"), 0x7f1004a1, "field 'maybankChildWebViewsContainer'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (IPay88Purchase)obj, obj1);
    }

    public volatile void unbind(ECommercePurchase ecommercepurchase)
    {
        unbind((IPay88Purchase)ecommercepurchase);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((IPay88Purchase)grouponactivity);
    }

    public void unbind(IPay88Purchase ipay88purchase)
    {
        super.unbind(ipay88purchase);
        ipay88purchase.paymentWebViewMaybank = null;
        ipay88purchase.maybankChildWebViewsContainer = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((IPay88Purchase)obj);
    }

    public er()
    {
    }
}
