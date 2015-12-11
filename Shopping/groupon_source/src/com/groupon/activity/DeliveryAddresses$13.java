// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.groupon.util.Function0;

// Referenced classes of package com.groupon.activity:
//            DeliveryAddresses

class this._cls0
    implements Function0
{

    final DeliveryAddresses this$0;

    public void execute()
        throws RuntimeException
    {
        byte byte0 = 8;
        progressBar.setVisibility(8);
        if (addressesContainer.getChildCount() > 0)
        {
            byte0 = 0;
        }
        if (addressesSection != null)
        {
            addressesSection.setVisibility(byte0);
        }
        addressesContainer.setVisibility(byte0);
    }

    ()
    {
        this$0 = DeliveryAddresses.this;
        super();
    }
}
