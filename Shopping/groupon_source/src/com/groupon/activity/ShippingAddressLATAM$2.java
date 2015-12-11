// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressLATAM

class this._cls0
    implements android.view.ner
{

    final ShippingAddressLATAM this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (!flag)
        {
            ShippingAddressLATAM.access$100(ShippingAddressLATAM.this, ShippingAddressLATAM.access$000(ShippingAddressLATAM.this).getText().toString());
        }
    }

    ()
    {
        this$0 = ShippingAddressLATAM.this;
        super();
    }
}
