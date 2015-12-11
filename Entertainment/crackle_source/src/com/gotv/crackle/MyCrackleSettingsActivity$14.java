// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.DialogInterface;
import android.widget.CheckBox;
import com.gotv.crackle.helpers.SharedPrefsManager;

// Referenced classes of package com.gotv.crackle:
//            MyCrackleSettingsActivity

class val.checkBox
    implements android.content.ner
{

    final MyCrackleSettingsActivity this$0;
    final CheckBox val$checkBox;
    final com.gotv.crackle.helpers.ntrol val$pc;

    public void onCancel(DialogInterface dialoginterface)
    {
        boolean flag1 = true;
        MyCrackleSettingsActivity.access$302(MyCrackleSettingsActivity.this, true);
        dialoginterface = val$pc;
        boolean flag;
        if (!val$checkBox.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SharedPrefsManager.setIsParentalLockEnabled(dialoginterface, flag);
        dialoginterface = val$checkBox;
        if (!val$checkBox.isChecked())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        dialoginterface.setChecked(flag);
    }

    rentalControl()
    {
        this$0 = final_mycracklesettingsactivity;
        val$pc = ntrol;
        val$checkBox = CheckBox.this;
        super();
    }
}
