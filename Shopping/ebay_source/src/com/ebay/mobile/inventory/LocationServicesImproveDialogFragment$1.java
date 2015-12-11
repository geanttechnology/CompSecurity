// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.widget.CompoundButton;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;

// Referenced classes of package com.ebay.mobile.inventory:
//            LocationServicesImproveDialogFragment

class this._cls0
    implements android.widget.Fragment._cls1
{

    final LocationServicesImproveDialogFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        compoundbutton = MyApp.getPrefs();
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        compoundbutton.setShowImproveLocationDialog(flag);
    }

    ()
    {
        this$0 = LocationServicesImproveDialogFragment.this;
        super();
    }
}
