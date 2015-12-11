// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct;

import android.content.DialogInterface;

// Referenced classes of package com.bestbuy.android.activities.browseproduct:
//            ProductAvailabilityFragment

class a
    implements android.content.r
{

    final ProductAvailabilityFragment a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }

    (ProductAvailabilityFragment productavailabilityfragment)
    {
        a = productavailabilityfragment;
        super();
    }
}
