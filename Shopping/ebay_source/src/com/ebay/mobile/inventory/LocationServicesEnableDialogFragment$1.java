// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.ebay.mobile.inventory:
//            LocationServicesEnableDialogFragment

class this._cls0
    implements android.content.ragment._cls1
{

    final LocationServicesEnableDialogFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        getActivity().startActivity(dialoginterface);
    }

    ()
    {
        this$0 = LocationServicesEnableDialogFragment.this;
        super();
    }
}
