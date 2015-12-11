// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.EditText;
import android.widget.Spinner;
import com.groupon.util.ReturningFunction1;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressLATAM

class this._cls0
    implements ReturningFunction1
{

    final ShippingAddressLATAM this$0;

    public Boolean execute(Exception exception)
        throws RuntimeException
    {
        ShippingAddressLATAM.access$1000(ShippingAddressLATAM.this).setVisibility(8);
        ShippingAddressLATAM.access$1200(ShippingAddressLATAM.this).setVisibility(0);
        ShippingAddressLATAM.access$1300(ShippingAddressLATAM.this).setVisibility(8);
        ShippingAddressLATAM.access$1400(ShippingAddressLATAM.this).setVisibility(0);
        if (Strings.notEmpty(ShippingAddressLATAM.access$1500(ShippingAddressLATAM.this)))
        {
            ShippingAddressLATAM.access$1400(ShippingAddressLATAM.this).setText(ShippingAddressLATAM.access$1500(ShippingAddressLATAM.this));
        }
        return Boolean.valueOf(false);
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    ()
    {
        this$0 = ShippingAddressLATAM.this;
        super();
    }
}
