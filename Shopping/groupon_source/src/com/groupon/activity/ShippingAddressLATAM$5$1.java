// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.groupon.models.shippingFields.ShippingSelectValue;
import com.groupon.util.Function1;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressLATAM

class val.shouldIgnore
    implements android.widget.dListener
{

    private boolean shouldIgnoreSet;
    final shouldIgnoreSet this$1;
    final boolean val$shouldIgnore;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (!shouldIgnoreSet)
        {
            adapterview = (ShippingSelectValue)ShippingAddressLATAM.access$1000(_fld0).getAdapter().getItem(i);
            ShippingAddressLATAM.access$1100(_fld0, ((ShippingSelectValue) (adapterview)).value);
        }
        shouldIgnoreSet = false;
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    l.locationCode()
    {
        this$1 = final_locationcode;
        val$shouldIgnore = Z.this;
        super();
        shouldIgnoreSet = val$shouldIgnore;
    }

    // Unreferenced inner class com/groupon/activity/ShippingAddressLATAM$5

/* anonymous class */
    class ShippingAddressLATAM._cls5
        implements Function1
    {

        final ShippingAddressLATAM this$0;
        final String val$locationCode;
        final String val$regionCode;

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((List)obj);
        }

        public void execute(List list)
            throws RuntimeException
        {
            ShippingAddressLATAM.access$800(ShippingAddressLATAM.this, list, regionCode, locationCode);
            boolean flag = ShippingAddressLATAM.access$900(ShippingAddressLATAM.this);
            if (ShippingAddressLATAM.access$1000(ShippingAddressLATAM.this).getVisibility() == 0)
            {
                ShippingAddressLATAM.access$1000(ShippingAddressLATAM.this).setOnItemSelectedListener(flag. new ShippingAddressLATAM._cls5._cls1());
            }
        }

            
            {
                this$0 = final_shippingaddresslatam;
                regionCode = s;
                locationCode = String.this;
                super();
            }
    }

}
