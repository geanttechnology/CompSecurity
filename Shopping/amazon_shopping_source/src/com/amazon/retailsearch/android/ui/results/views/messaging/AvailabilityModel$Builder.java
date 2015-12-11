// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.searchapp.retailsearch.model.Availability;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            AvailabilityModel

public static class 
{

    public AvailabilityModel build(Availability availability)
    {
        if (availability == null)
        {
            return null;
        } else
        {
            AvailabilityModel availabilitymodel = new AvailabilityModel();
            AvailabilityModel.access$000(availabilitymodel, availability.getLowStockMessage());
            AvailabilityModel.access$100(availabilitymodel, availability.getGeneralAvailability());
            return availabilitymodel;
        }
    }

    public ()
    {
    }
}
