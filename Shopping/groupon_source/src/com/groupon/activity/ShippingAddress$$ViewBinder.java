// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import com.groupon.view.DealCardCompact;
import com.groupon.view.GrouponCheckMark;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.activity:
//            ShippingAddress, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (ShippingAddress)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, ShippingAddress shippingaddress, Object obj)
    {
        super.bind(ewbinder, shippingaddress, obj);
        shippingaddress.submitButton = (SpinnerButton)ewbinder.mitButton((View)ewbinder.redView(obj, 0x7f100102, "field 'submitButton'"), 0x7f100102, "field 'submitButton'");
        shippingaddress.shippingAddressLayout = (LinearLayout)ewbinder.ppingAddressLayout((View)ewbinder.redView(obj, 0x7f1000ce, "field 'shippingAddressLayout'"), 0x7f1000ce, "field 'shippingAddressLayout'");
        shippingaddress.shippingState = (Spinner)ewbinder.ppingState((View)ewbinder.nalView(obj, 0x7f1000d0, null), 0x7f1000d0, "field 'shippingState'");
        shippingaddress.shippingCountry = (Spinner)ewbinder.ppingCountry((View)ewbinder.nalView(obj, 0x7f1000d1, null), 0x7f1000d1, "field 'shippingCountry'");
        shippingaddress.titleSpinner = (Spinner)ewbinder.leSpinner((View)ewbinder.nalView(obj, 0x7f1000cf, null), 0x7f1000cf, "field 'titleSpinner'");
        shippingaddress.shippingFirstName = (EditText)ewbinder.ppingFirstName((View)ewbinder.nalView(obj, 0x7f1000d5, null), 0x7f1000d5, "field 'shippingFirstName'");
        shippingaddress.shippingLastName = (EditText)ewbinder.ppingLastName((View)ewbinder.nalView(obj, 0x7f1000d6, null), 0x7f1000d6, "field 'shippingLastName'");
        shippingaddress.useBillingAsShippingCheckBox = (CheckBox)ewbinder.BillingAsShippingCheckBox((View)ewbinder.nalView(obj, 0x7f1000cd, null), 0x7f1000cd, "field 'useBillingAsShippingCheckBox'");
        shippingaddress.useBillingAsShippingContainer = (View)ewbinder.nalView(obj, 0x7f1000d3, null);
        shippingaddress.useBillingAsShippingCheckMark = (GrouponCheckMark)ewbinder.BillingAsShippingCheckMark((View)ewbinder.nalView(obj, 0x7f1000d4, null), 0x7f1000d4, "field 'useBillingAsShippingCheckMark'");
        shippingaddress.shippingScrollView = (ScrollView)ewbinder.ppingScrollView((View)ewbinder.redView(obj, 0x7f1000cc, "field 'shippingScrollView'"), 0x7f1000cc, "field 'shippingScrollView'");
        shippingaddress.secureConnectionView = (TextView)ewbinder.ureConnectionView((View)ewbinder.nalView(obj, 0x7f100111, null), 0x7f100111, "field 'secureConnectionView'");
        shippingaddress.dealCardCompact = (DealCardCompact)ewbinder.lCardCompact((View)ewbinder.nalView(obj, 0x7f1000d2, null), 0x7f1000d2, "field 'dealCardCompact'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (ShippingAddress)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((ShippingAddress)grouponactivity);
    }

    public void unbind(ShippingAddress shippingaddress)
    {
        super.unbind(shippingaddress);
        shippingaddress.submitButton = null;
        shippingaddress.shippingAddressLayout = null;
        shippingaddress.shippingState = null;
        shippingaddress.shippingCountry = null;
        shippingaddress.titleSpinner = null;
        shippingaddress.shippingFirstName = null;
        shippingaddress.shippingLastName = null;
        shippingaddress.useBillingAsShippingCheckBox = null;
        shippingaddress.useBillingAsShippingContainer = null;
        shippingaddress.useBillingAsShippingCheckMark = null;
        shippingaddress.shippingScrollView = null;
        shippingaddress.secureConnectionView = null;
        shippingaddress.dealCardCompact = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((ShippingAddress)obj);
    }

    public ()
    {
    }
}
