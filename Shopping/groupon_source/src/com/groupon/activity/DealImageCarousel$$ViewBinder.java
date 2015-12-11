// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.groupon.activity:
//            DealImageCarousel, GrouponActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, DealImageCarousel dealimagecarousel, Object obj)
    {
        super.nd(ewbinder, dealimagecarousel, obj);
        dealimagecarousel.dealImagePager = (ViewPager)ewbinder.lImagePager((View)ewbinder.dView(obj, 0x7f100267, "field 'dealImagePager'"), 0x7f100267, "field 'dealImagePager'");
        dealimagecarousel.DEAL_IMAGE_CAROUSEL_ACTION_BAR_TITLE = ewbinder.L_IMAGE_CAROUSEL_ACTION_BAR_TITLE(obj).getResources().getString(0x7f080127);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (DealImageCarousel)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (DealImageCarousel)obj, obj1);
    }

    public void unbind(DealImageCarousel dealimagecarousel)
    {
        super.bind(dealimagecarousel);
        dealimagecarousel.dealImagePager = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((DealImageCarousel)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((DealImageCarousel)obj);
    }

    public ()
    {
    }
}
