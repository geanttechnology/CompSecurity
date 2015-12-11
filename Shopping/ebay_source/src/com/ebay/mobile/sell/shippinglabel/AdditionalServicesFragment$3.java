// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.view.View;
import android.widget.RadioButton;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            AdditionalServicesFragment

class this._cls0
    implements android.view.nalServicesFragment._cls3
{

    final AdditionalServicesFragment this$0;

    public void onClick(View view)
    {
        if (selectedSigConf != null)
        {
            selectedSigConf.setChecked(false);
        }
        selectedSigConf = (RadioButton)view.findViewById(0x7f10075f);
        selectedSigConf.setChecked(true);
    }

    ()
    {
        this$0 = AdditionalServicesFragment.this;
        super();
    }
}
