// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.ProgressBar;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.activity:
//            DeliveryAddresses

class this._cls0
    implements ReturningFunction1
{

    final DeliveryAddresses this$0;

    public Boolean execute(Exception exception)
    {
        if (DeliveryAddresses.access$200(DeliveryAddresses.this).getCurrentCountry().isLATAMCompatible())
        {
            progressBar.setVisibility(8);
        }
        return null;
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    rrentCountryManager()
    {
        this$0 = DeliveryAddresses.this;
        super();
    }
}
