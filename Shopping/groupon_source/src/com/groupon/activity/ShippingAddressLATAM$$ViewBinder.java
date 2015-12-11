// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressLATAM, GrouponActivity, ShippingAddress, ShippingAddressEu

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (ShippingAddressLATAM)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, ShippingAddress shippingaddress, Object obj)
    {
        bind(ewbinder, (ShippingAddressLATAM)shippingaddress, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, ShippingAddressEu shippingaddresseu, Object obj)
    {
        bind(ewbinder, (ShippingAddressLATAM)shippingaddresseu, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, ShippingAddressLATAM shippingaddresslatam, Object obj)
    {
        super.d(ewbinder, shippingaddresslatam, obj);
        ewbinder = ewbinder.bind(obj).getResources();
        shippingaddresslatam.ERROR_INVALID_POSTAL = ewbinder.getString(0x7f080181);
        shippingaddresslatam.ERROR_INVALID_LOCATION_CL = ewbinder.getString(0x7f08017a);
        shippingaddresslatam.ERROR_INVALID_LOCATION_CO = ewbinder.getString(0x7f08017b);
        shippingaddresslatam.ERROR_INVALID_LOCATION_MX = ewbinder.getString(0x7f08017c);
        shippingaddresslatam.ERROR_INVALID_REGION_CL = ewbinder.getString(0x7f080183);
        shippingaddresslatam.ERROR_INVALID_REGION_CO = ewbinder.getString(0x7f080184);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (ShippingAddressLATAM)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((ShippingAddressLATAM)grouponactivity);
    }

    public volatile void unbind(ShippingAddress shippingaddress)
    {
        unbind((ShippingAddressLATAM)shippingaddress);
    }

    public volatile void unbind(ShippingAddressEu shippingaddresseu)
    {
        unbind((ShippingAddressLATAM)shippingaddresseu);
    }

    public void unbind(ShippingAddressLATAM shippingaddresslatam)
    {
        super.ind(shippingaddresslatam);
    }

    public volatile void unbind(Object obj)
    {
        unbind((ShippingAddressLATAM)obj);
    }

    public ()
    {
    }
}
