// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.webkit.WebView;

// Referenced classes of package com.groupon.activity:
//            ECommercePurchase, GrouponActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, ECommercePurchase ecommercepurchase, Object obj)
    {
        super.nd(ewbinder, ecommercepurchase, obj);
        ecommercepurchase.paymentWebView = (WebView)ewbinder.mentWebView((View)ewbinder.dView(obj, 0x7f1002fb, "field 'paymentWebView'"), 0x7f1002fb, "field 'paymentWebView'");
        ecommercepurchase.LOADING = ewbinder.DING(obj).getResources().getString(0x7f080256);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (ECommercePurchase)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (ECommercePurchase)obj, obj1);
    }

    public void unbind(ECommercePurchase ecommercepurchase)
    {
        super.bind(ecommercepurchase);
        ecommercepurchase.paymentWebView = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((ECommercePurchase)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((ECommercePurchase)obj);
    }

    public ()
    {
    }
}
