// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.optioncards;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

// Referenced classes of package com.groupon.view.optioncards:
//            OptionCardBaseView

public class A
    implements butterknife.View..ViewBinder
{

    public void bind(butterknife.View..ViewBinder viewbinder, OptionCardBaseView optioncardbaseview, Object obj)
    {
        optioncardbaseview.soldOutOrExpiredOverlay = (FrameLayout)viewbinder.soldOutOrExpiredOverlay((View)viewbinder.View(obj, 0x7f100195, "field 'soldOutOrExpiredOverlay'"), 0x7f100195, "field 'soldOutOrExpiredOverlay'");
        optioncardbaseview.title = (TextView)viewbinder.title((View)viewbinder.View(obj, 0x7f10007a, "field 'title'"), 0x7f10007a, "field 'title'");
        optioncardbaseview.price = (TextView)viewbinder.price((View)viewbinder.View(obj, 0x7f100192, "field 'price'"), 0x7f100192, "field 'price'");
        optioncardbaseview.urgencyPricingLabel = (TextView)viewbinder.urgencyPricingLabel((View)viewbinder.View(obj, 0x7f100193, "field 'urgencyPricingLabel'"), 0x7f100193, "field 'urgencyPricingLabel'");
        optioncardbaseview.discount = (TextView)viewbinder.discount((View)viewbinder.View(obj, 0x7f10018e, "field 'discount'"), 0x7f10018e, "field 'discount'");
        optioncardbaseview.bought = (TextView)viewbinder.bought((View)viewbinder.View(obj, 0x7f10018f, "field 'bought'"), 0x7f10018f, "field 'bought'");
    }

    public volatile void bind(butterknife.View..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (OptionCardBaseView)obj, obj1);
    }

    public void unbind(OptionCardBaseView optioncardbaseview)
    {
        optioncardbaseview.soldOutOrExpiredOverlay = null;
        optioncardbaseview.title = null;
        optioncardbaseview.price = null;
        optioncardbaseview.urgencyPricingLabel = null;
        optioncardbaseview.discount = null;
        optioncardbaseview.bought = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((OptionCardBaseView)obj);
    }

    public A()
    {
    }
}
