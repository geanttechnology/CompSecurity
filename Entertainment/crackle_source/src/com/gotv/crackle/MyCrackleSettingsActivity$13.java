// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.gotv.crackle.dialogs.ParentalPinDialog;
import com.gotv.crackle.helpers.SharedPrefsManager;

// Referenced classes of package com.gotv.crackle:
//            MyCrackleSettingsActivity

class val.checkBox
    implements android.content.ener
{

    final MyCrackleSettingsActivity this$0;
    final CheckBox val$checkBox;
    final ParentalPinDialog val$dialog;
    final com.gotv.crackle.helpers.ntrol val$pc;

    public void onDismiss(DialogInterface dialoginterface)
    {
label0:
        {
label1:
            {
                if (val$dialog.getCode().length() == 4)
                {
                    if (!SharedPrefsManager.getIsParentalLockEnabled(val$pc))
                    {
                        break label0;
                    }
                    if (!SharedPrefsManager.getParentalLockCode().equalsIgnoreCase(val$dialog.getCode()))
                    {
                        break label1;
                    }
                    SharedPrefsManager.setIsParentalLockEnabled(val$pc, val$checkBox.isChecked());
                }
                return;
            }
            val$dialog.show();
            return;
        }
        SharedPrefsManager.setParentalLockCode(val$dialog.getCode());
        SharedPrefsManager.setIsParentalLockEnabled(val$pc, val$checkBox.isChecked());
    }

    rentalControl()
    {
        this$0 = final_mycracklesettingsactivity;
        val$dialog = parentalpindialog;
        val$pc = ntrol;
        val$checkBox = CheckBox.this;
        super();
    }
}
