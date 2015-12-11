// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.bestbuy.android.activities.browseproduct:
//            ProductAvailabilityFragment

class a
    implements android.content.r
{

    final String a;
    final ProductAvailabilityFragment b;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://www.bestbuy.com").append(a).toString()));
        b.startActivity(dialoginterface);
    }

    (ProductAvailabilityFragment productavailabilityfragment, String s)
    {
        b = productavailabilityfragment;
        a = s;
        super();
    }
}
