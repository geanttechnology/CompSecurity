// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.shippingFields.RegionMX;
import com.groupon.util.Function1;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressLATAM

class this._cls0
    implements Function1
{

    final ShippingAddressLATAM this$0;

    public void execute(RegionMX regionmx)
    {
        ShippingAddressLATAM.access$200(ShippingAddressLATAM.this).setVisibility(8);
        String s = regionmx.stateName;
        if (Strings.notEmpty(s))
        {
            ShippingAddressLATAM.access$300(ShippingAddressLATAM.this).setVisibility(0);
            ShippingAddressLATAM.access$300(ShippingAddressLATAM.this).setText(s);
            ShippingAddressLATAM.access$300(ShippingAddressLATAM.this).setTag(regionmx.stateId);
        } else
        {
            ShippingAddressLATAM.access$300(ShippingAddressLATAM.this).setVisibility(8);
        }
        s = regionmx.name;
        if (Strings.notEmpty(s))
        {
            ShippingAddressLATAM.access$400(ShippingAddressLATAM.this).setVisibility(0);
            ShippingAddressLATAM.access$400(ShippingAddressLATAM.this).setText(s);
            ShippingAddressLATAM.access$400(ShippingAddressLATAM.this).setTag(regionmx.id);
        } else
        {
            ShippingAddressLATAM.access$400(ShippingAddressLATAM.this).setVisibility(8);
        }
        ShippingAddressLATAM.access$500(ShippingAddressLATAM.this).setVisibility(0);
        ShippingAddressLATAM.access$500(ShippingAddressLATAM.this).setAdapter(new ippingLocationsAdapter(ShippingAddressLATAM.this, regionmx.locationsForRegionMX));
        if (existingAddress != null)
        {
            int i = existingAddress.shipping_street_type;
            if (i > 0)
            {
                ShippingAddressLATAM.access$600(ShippingAddressLATAM.this).setSelection(i - 1);
            }
            regionmx = existingAddress.shipping_township;
            if (Strings.notEmpty(regionmx))
            {
                ShippingAddressLATAM.access$700(ShippingAddressLATAM.this, ShippingAddressLATAM.access$500(ShippingAddressLATAM.this), regionmx);
            }
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((RegionMX)obj);
    }

    wnAddress()
    {
        this$0 = ShippingAddressLATAM.this;
        super();
    }
}
