// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.groupon.view.DealCardCompact;

// Referenced classes of package com.groupon.activity:
//            DeliveryAddresses, GrouponActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, DeliveryAddresses deliveryaddresses, Object obj)
    {
        super.nd(ewbinder, deliveryaddresses, obj);
        deliveryaddresses.addAddressLabel = (TextView)ewbinder.AddressLabel((View)ewbinder.dView(obj, 0x7f10026a, "field 'addAddressLabel'"), 0x7f10026a, "field 'addAddressLabel'");
        deliveryaddresses.addressesContainer = (ViewGroup)ewbinder.ressesContainer((View)ewbinder.dView(obj, 0x7f10026c, "field 'addressesContainer'"), 0x7f10026c, "field 'addressesContainer'");
        deliveryaddresses.progressBar = (ProgressBar)ewbinder.gressBar((View)ewbinder.dView(obj, 0x7f10026d, "field 'progressBar'"), 0x7f10026d, "field 'progressBar'");
        deliveryaddresses.addAddressButton = (View)ewbinder.dView(obj, 0x7f100269, "field 'addAddressButton'");
        deliveryaddresses.addressesSection = (View)ewbinder.lView(obj, 0x7f10026b, null);
        deliveryaddresses.selectedLabel = (View)ewbinder.lView(obj, 0x7f10050e, null);
        deliveryaddresses.dealCardCompact = (DealCardCompact)ewbinder.lCardCompact((View)ewbinder.lView(obj, 0x7f1000d2, null), 0x7f1000d2, "field 'dealCardCompact'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (DeliveryAddresses)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (DeliveryAddresses)obj, obj1);
    }

    public void unbind(DeliveryAddresses deliveryaddresses)
    {
        super.bind(deliveryaddresses);
        deliveryaddresses.addAddressLabel = null;
        deliveryaddresses.addressesContainer = null;
        deliveryaddresses.progressBar = null;
        deliveryaddresses.addAddressButton = null;
        deliveryaddresses.addressesSection = null;
        deliveryaddresses.selectedLabel = null;
        deliveryaddresses.dealCardCompact = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((DeliveryAddresses)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((DeliveryAddresses)obj);
    }

    public ()
    {
    }
}
