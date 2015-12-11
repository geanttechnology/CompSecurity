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

class val.locationCode
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
        ShippingAddressLATAM.access$800(ShippingAddressLATAM.this, list, val$regionCode, val$locationCode);
        final boolean shouldIgnore = ShippingAddressLATAM.access$900(ShippingAddressLATAM.this);
        if (ShippingAddressLATAM.access$1000(ShippingAddressLATAM.this).getVisibility() == 0)
        {
            ShippingAddressLATAM.access$1000(ShippingAddressLATAM.this).setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

                private boolean shouldIgnoreSet;
                final ShippingAddressLATAM._cls5 this$1;
                final boolean val$shouldIgnore;

                public void onItemSelected(AdapterView adapterview, View view, int i, long l)
                {
                    if (!shouldIgnoreSet)
                    {
                        adapterview = (ShippingSelectValue)ShippingAddressLATAM.access$1000(this$0).getAdapter().getItem(i);
                        ShippingAddressLATAM.access$1100(this$0, ((ShippingSelectValue) (adapterview)).value);
                    }
                    shouldIgnoreSet = false;
                }

                public void onNothingSelected(AdapterView adapterview)
                {
                }

            
            {
                this$1 = ShippingAddressLATAM._cls5.this;
                shouldIgnore = flag;
                super();
                shouldIgnoreSet = shouldIgnore;
            }
            });
        }
    }

    _cls1.val.shouldIgnore()
    {
        this$0 = final_shippingaddresslatam;
        val$regionCode = s;
        val$locationCode = String.this;
        super();
    }
}
