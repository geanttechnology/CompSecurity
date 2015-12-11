// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.utils.OfferUpLocation;

// Referenced classes of package com.offerup.android.activities:
//            ChangePostLocationActivity

final class az
    implements Runnable
{

    private OfferUpLocation a;
    private ChangePostLocationActivity b;

    az(ChangePostLocationActivity changepostlocationactivity, OfferUpLocation offeruplocation)
    {
        b = changepostlocationactivity;
        a = offeruplocation;
        super();
    }

    public final void run()
    {
        if (a != null)
        {
            b.b(a);
            return;
        } else
        {
            b.g();
            return;
        }
    }
}
