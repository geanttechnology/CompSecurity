// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressEu, GrouponActivity, ShippingAddress

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (ShippingAddressEu)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, ShippingAddress shippingaddress, Object obj)
    {
        bind(ewbinder, (ShippingAddressEu)shippingaddress, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, ShippingAddressEu shippingaddresseu, Object obj)
    {
        super.nd(ewbinder, shippingaddresseu, obj);
        shippingaddresseu.SHIPPING_TITLE_MR = ewbinder.PPING_TITLE_MR(obj).getResources().getString(0x7f0803a5);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (ShippingAddressEu)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((ShippingAddressEu)grouponactivity);
    }

    public volatile void unbind(ShippingAddress shippingaddress)
    {
        unbind((ShippingAddressEu)shippingaddress);
    }

    public void unbind(ShippingAddressEu shippingaddresseu)
    {
        super.bind(shippingaddresseu);
    }

    public volatile void unbind(Object obj)
    {
        unbind((ShippingAddressEu)obj);
    }

    public ()
    {
    }
}
