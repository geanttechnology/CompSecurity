// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.groupon.util.GrouponNavigationDrawerActivity;

// Referenced classes of package com.groupon.activity:
//            BookingDealCalendarActivity, GrouponFragmentActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, BookingDealCalendarActivity bookingdealcalendaractivity, Object obj)
    {
        super.(ewbinder, bookingdealcalendaractivity, obj);
        bookingdealcalendaractivity.progress = (View)ewbinder.gress(obj, 0x7f10010b, "field 'progress'");
        bookingdealcalendaractivity.topBarTextView = (TextView)ewbinder.BarTextView((View)ewbinder.BarTextView(obj, 0x7f100108, "field 'topBarTextView'"), 0x7f100108, "field 'topBarTextView'");
        bookingdealcalendaractivity.grouponPrice = (TextView)ewbinder.uponPrice((View)ewbinder.uponPrice(obj, 0x7f10010e, "field 'grouponPrice'"), 0x7f10010e, "field 'grouponPrice'");
        bookingdealcalendaractivity.originalPrice = (TextView)ewbinder.ginalPrice((View)ewbinder.ginalPrice(obj, 0x7f10010d, "field 'originalPrice'"), 0x7f10010d, "field 'originalPrice'");
        bookingdealcalendaractivity.availabilityButton = (Button)ewbinder.ilabilityButton((View)ewbinder.ilabilityButton(obj, 0x7f10010f, "field 'availabilityButton'"), 0x7f10010f, "field 'availabilityButton'");
        bookingdealcalendaractivity.priceBuyBar = (ViewGroup)ewbinder.ceBuyBar((View)ewbinder.ceBuyBar(obj, 0x7f1000a0, "field 'priceBuyBar'"), 0x7f1000a0, "field 'priceBuyBar'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(ewbinder, (BookingDealCalendarActivity)grouponfragmentactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(ewbinder, (BookingDealCalendarActivity)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (BookingDealCalendarActivity)obj, obj1);
    }

    public void unbind(BookingDealCalendarActivity bookingdealcalendaractivity)
    {
        super.nd(bookingdealcalendaractivity);
        bookingdealcalendaractivity.progress = null;
        bookingdealcalendaractivity.topBarTextView = null;
        bookingdealcalendaractivity.grouponPrice = null;
        bookingdealcalendaractivity.originalPrice = null;
        bookingdealcalendaractivity.availabilityButton = null;
        bookingdealcalendaractivity.priceBuyBar = null;
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((BookingDealCalendarActivity)grouponfragmentactivity);
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((BookingDealCalendarActivity)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((BookingDealCalendarActivity)obj);
    }

    public ()
    {
    }
}
