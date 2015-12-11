// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.util.GrouponNavigationDrawerActivity;
import com.groupon.view.CouponMapSlice;
import com.groupon.view.UrlImageView;

// Referenced classes of package com.groupon.activity:
//            CouponDetails, GrouponFragmentActivity

public class y extends iewBinder
{

    public void bind(butterknife.ewBinder ewbinder, CouponDetails coupondetails, Object obj)
    {
        super.bind(ewbinder, coupondetails, obj);
        coupondetails.contentView = (View)ewbinder.uiredView(obj, 0x7f100132, "field 'contentView'");
        coupondetails.progress = (View)ewbinder.uiredView(obj, 0x7f10010b, "field 'progress'");
        coupondetails.headerTitle = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001c8, "field 'headerTitle'"), 0x7f1001c8, "field 'headerTitle'");
        coupondetails.headerImage = (UrlImageView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001df, "field 'headerImage'"), 0x7f1001df, "field 'headerImage'");
        coupondetails.headerSubtitle = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001c9, "field 'headerSubtitle'"), 0x7f1001c9, "field 'headerSubtitle'");
        coupondetails.exclusiveFlag = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001ca, "field 'exclusiveFlag'"), 0x7f1001ca, "field 'exclusiveFlag'");
        coupondetails.aboutTitle = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001c5, "field 'aboutTitle'"), 0x7f1001c5, "field 'aboutTitle'");
        coupondetails.aboutText = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001c6, "field 'aboutText'"), 0x7f1001c6, "field 'aboutText'");
        coupondetails.aboutDate = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001c7, "field 'aboutDate'"), 0x7f1001c7, "field 'aboutDate'");
        coupondetails.instructionTitle = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001cb, "field 'instructionTitle'"), 0x7f1001cb, "field 'instructionTitle'");
        coupondetails.instructionText = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001cc, "field 'instructionText'"), 0x7f1001cc, "field 'instructionText'");
        coupondetails.moreSection = (View)ewbinder.uiredView(obj, 0x7f1001be, "field 'moreSection'");
        coupondetails.moreSectionDivider = (View)ewbinder.uiredView(obj, 0x7f1001d2, "field 'moreSectionDivider'");
        coupondetails.moreSectionOnline = (View)ewbinder.uiredView(obj, 0x7f1001d3, "field 'moreSectionOnline'");
        coupondetails.moreSectionInstore = (View)ewbinder.uiredView(obj, 0x7f1001ce, "field 'moreSectionInstore'");
        coupondetails.moreTitle = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001cd, "field 'moreTitle'"), 0x7f1001cd, "field 'moreTitle'");
        coupondetails.instoreCount = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001d1, "field 'instoreCount'"), 0x7f1001d1, "field 'instoreCount'");
        coupondetails.onlineCount = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001d6, "field 'onlineCount'"), 0x7f1001d6, "field 'onlineCount'");
        coupondetails.dualBuyBar = (LinearLayout)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001c0, "field 'dualBuyBar'"), 0x7f1001c0, "field 'dualBuyBar'");
        coupondetails.singleBuyBar = (LinearLayout)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001bf, "field 'singleBuyBar'"), 0x7f1001bf, "field 'singleBuyBar'");
        coupondetails.buyBarButtonSingle = (Button)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001c1, "field 'buyBarButtonSingle'"), 0x7f1001c1, "field 'buyBarButtonSingle'");
        coupondetails.buyBarButtonDualOne = (Button)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001c2, "field 'buyBarButtonDualOne'"), 0x7f1001c2, "field 'buyBarButtonDualOne'");
        coupondetails.buyBarButtonDualTwo = (Button)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001c3, "field 'buyBarButtonDualTwo'"), 0x7f1001c3, "field 'buyBarButtonDualTwo'");
        coupondetails.couponMapSlice = (CouponMapSlice)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001bd, "field 'couponMapSlice'"), 0x7f1001bd, "field 'couponMapSlice'");
        coupondetails.coupon_about_section = (LinearLayout)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1001c4, "field 'coupon_about_section'"), 0x7f1001c4, "field 'coupon_about_section'");
        coupondetails.toolbarTitleText = (TextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f100562, "field 'toolbarTitleText'"), 0x7f100562, "field 'toolbarTitleText'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(ewbinder, (CouponDetails)grouponfragmentactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(ewbinder, (CouponDetails)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (CouponDetails)obj, obj1);
    }

    public void unbind(CouponDetails coupondetails)
    {
        super.unbind(coupondetails);
        coupondetails.contentView = null;
        coupondetails.progress = null;
        coupondetails.headerTitle = null;
        coupondetails.headerImage = null;
        coupondetails.headerSubtitle = null;
        coupondetails.exclusiveFlag = null;
        coupondetails.aboutTitle = null;
        coupondetails.aboutText = null;
        coupondetails.aboutDate = null;
        coupondetails.instructionTitle = null;
        coupondetails.instructionText = null;
        coupondetails.moreSection = null;
        coupondetails.moreSectionDivider = null;
        coupondetails.moreSectionOnline = null;
        coupondetails.moreSectionInstore = null;
        coupondetails.moreTitle = null;
        coupondetails.instoreCount = null;
        coupondetails.onlineCount = null;
        coupondetails.dualBuyBar = null;
        coupondetails.singleBuyBar = null;
        coupondetails.buyBarButtonSingle = null;
        coupondetails.buyBarButtonDualOne = null;
        coupondetails.buyBarButtonDualTwo = null;
        coupondetails.couponMapSlice = null;
        coupondetails.coupon_about_section = null;
        coupondetails.toolbarTitleText = null;
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((CouponDetails)grouponfragmentactivity);
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((CouponDetails)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((CouponDetails)obj);
    }

    public y()
    {
    }
}
