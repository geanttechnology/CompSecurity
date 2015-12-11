// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.bestbuy.android.activities.stores:
//            StoreSearchMapFragment

class a
    implements android.content.stener
{

    final StoreSearchMapFragment a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        a.d.startActivityForResult(dialoginterface, 1000);
    }

    (StoreSearchMapFragment storesearchmapfragment)
    {
        a = storesearchmapfragment;
        super();
    }
}
