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
//            HotelSearchCalendarActivity, GrouponFragmentActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(ewbinder, (HotelSearchCalendarActivity)grouponfragmentactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, HotelSearchCalendarActivity hotelsearchcalendaractivity, Object obj)
    {
        super.(ewbinder, hotelsearchcalendaractivity, obj);
        hotelsearchcalendaractivity.topBarTextView = (TextView)ewbinder.BarTextView((View)ewbinder.BarTextView(obj, 0x7f100108, "field 'topBarTextView'"), 0x7f100108, "field 'topBarTextView'");
        hotelsearchcalendaractivity.confirmSelectedDateBar = (ViewGroup)ewbinder.firmSelectedDateBar((View)ewbinder.firmSelectedDateBar(obj, 0x7f1000a0, "field 'confirmSelectedDateBar'"), 0x7f1000a0, "field 'confirmSelectedDateBar'");
        hotelsearchcalendaractivity.confirmSelectedButton = (Button)ewbinder.firmSelectedButton((View)ewbinder.firmSelectedButton(obj, 0x7f1003b5, "field 'confirmSelectedButton'"), 0x7f1003b5, "field 'confirmSelectedButton'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(ewbinder, (HotelSearchCalendarActivity)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (HotelSearchCalendarActivity)obj, obj1);
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((HotelSearchCalendarActivity)grouponfragmentactivity);
    }

    public void unbind(HotelSearchCalendarActivity hotelsearchcalendaractivity)
    {
        super.nd(hotelsearchcalendaractivity);
        hotelsearchcalendaractivity.topBarTextView = null;
        hotelsearchcalendaractivity.confirmSelectedDateBar = null;
        hotelsearchcalendaractivity.confirmSelectedButton = null;
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((HotelSearchCalendarActivity)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((HotelSearchCalendarActivity)obj);
    }

    public ()
    {
    }
}
