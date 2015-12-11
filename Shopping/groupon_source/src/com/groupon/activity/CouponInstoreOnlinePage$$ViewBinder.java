// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import com.groupon.view.GrouponViewPager;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.activity:
//            CouponInstoreOnlinePage, GrouponActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, CouponInstoreOnlinePage couponinstoreonlinepage, Object obj)
    {
        super.(ewbinder, couponinstoreonlinepage, obj);
        couponinstoreonlinepage.viewPager = (GrouponViewPager)ewbinder.wPager((View)ewbinder.wPager(obj, 0x7f1000aa, "field 'viewPager'"), 0x7f1000aa, "field 'viewPager'");
        couponinstoreonlinepage.pagerSlidingTabStrip = (PagerSlidingTabStrip)ewbinder.erSlidingTabStrip((View)ewbinder.erSlidingTabStrip(obj, 0x7f1000a9, "field 'pagerSlidingTabStrip'"), 0x7f1000a9, "field 'pagerSlidingTabStrip'");
        couponinstoreonlinepage.toolbar = (Toolbar)ewbinder.lbar((View)ewbinder.lbar(obj, 0x7f100180, "field 'toolbar'"), 0x7f100180, "field 'toolbar'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (CouponInstoreOnlinePage)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (CouponInstoreOnlinePage)obj, obj1);
    }

    public void unbind(CouponInstoreOnlinePage couponinstoreonlinepage)
    {
        super.bind(couponinstoreonlinepage);
        couponinstoreonlinepage.viewPager = null;
        couponinstoreonlinepage.pagerSlidingTabStrip = null;
        couponinstoreonlinepage.toolbar = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((CouponInstoreOnlinePage)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((CouponInstoreOnlinePage)obj);
    }

    public ()
    {
    }
}
