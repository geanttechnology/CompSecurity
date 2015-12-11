// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.plpstoreavailability;

import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.bestbuy.android.activities.plpstoreavailability:
//            PLPStoreSelectionActivity

class a
    implements android.content.ner
{

    final PLPStoreSelectionActivity a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        a.startActivityForResult(dialoginterface, 1000);
    }

    (PLPStoreSelectionActivity plpstoreselectionactivity)
    {
        a = plpstoreselectionactivity;
        super();
    }
}
