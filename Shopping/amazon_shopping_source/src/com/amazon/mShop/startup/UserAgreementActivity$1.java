// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.startup:
//            UserAgreementActivity

class val.checkBox
    implements android.content.istener
{

    final UserAgreementActivity this$0;
    final CheckBox val$checkBox;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (val$checkBox.isChecked())
        {
            com.amazon.mShop.platform.ance().getDataStore().putBoolean("appStartIndicationDialogNotRemindAgain", true);
        }
        endStartupTask("taskResultSucceed");
    }

    ()
    {
        this$0 = final_useragreementactivity;
        val$checkBox = CheckBox.this;
        super();
    }
}
