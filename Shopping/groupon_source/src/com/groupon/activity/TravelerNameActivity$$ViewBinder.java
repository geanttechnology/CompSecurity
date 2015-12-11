// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.groupon.view.UrlImageView;

// Referenced classes of package com.groupon.activity:
//            TravelerNameActivity, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (TravelerNameActivity)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, TravelerNameActivity travelernameactivity, Object obj)
    {
        super.bind(ewbinder, travelernameactivity, obj);
        travelernameactivity.dealImageView = (UrlImageView)ewbinder.lImageView((View)ewbinder.ew(obj, 0x7f100121, "field 'dealImageView'"), 0x7f100121, "field 'dealImageView'");
        travelernameactivity.titleView = (TextView)ewbinder.leView((View)ewbinder.ew(obj, 0x7f10007a, "field 'titleView'"), 0x7f10007a, "field 'titleView'");
        travelernameactivity.continueButton = (Button)ewbinder.tinueButton((View)ewbinder.ew(obj, 0x7f100102, "field 'continueButton'"), 0x7f100102, "field 'continueButton'");
        travelernameactivity.firstNameView = (EditText)ewbinder.stNameView((View)ewbinder.ew(obj, 0x7f100563, "field 'firstNameView'"), 0x7f100563, "field 'firstNameView'");
        travelernameactivity.lastNameView = (EditText)ewbinder.tNameView((View)ewbinder.ew(obj, 0x7f100564, "field 'lastNameView'"), 0x7f100564, "field 'lastNameView'");
        travelernameactivity.reservationDateText = (TextView)ewbinder.ervationDateText((View)ewbinder.ew(obj, 0x7f100565, "field 'reservationDateText'"), 0x7f100565, "field 'reservationDateText'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (TravelerNameActivity)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((TravelerNameActivity)grouponactivity);
    }

    public void unbind(TravelerNameActivity travelernameactivity)
    {
        super.d(travelernameactivity);
        travelernameactivity.dealImageView = null;
        travelernameactivity.titleView = null;
        travelernameactivity.continueButton = null;
        travelernameactivity.firstNameView = null;
        travelernameactivity.lastNameView = null;
        travelernameactivity.reservationDateText = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((TravelerNameActivity)obj);
    }

    public ()
    {
    }
}
