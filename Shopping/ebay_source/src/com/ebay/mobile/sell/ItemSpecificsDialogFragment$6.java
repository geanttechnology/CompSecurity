// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.EditText;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.data.ItemSpecific;

// Referenced classes of package com.ebay.mobile.sell:
//            ItemSpecificsDialogFragment

class val.specific
    implements android.content.r
{

    final ItemSpecificsDialogFragment this$0;
    final ItemSpecific val$specific;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        dialoginterface = ((EditText)getDialog().findViewById(0x7f100641)).getText().toString();
        mSpecificsDialogData mspecificsdialogdata = new mSpecificsDialogData(mSpecificsDialogAction.SAVE_CUSTOM);
        mspecificsdialogdata.customValue = dialoginterface;
        mspecificsdialogdata.specifics = val$specific;
        ContentSyncManager.notifyUpdate(mspecificsdialogdata, com/ebay/mobile/sell/ItemSpecificsSpokeFragment$ItemSpecificsDialogData.getName());
    }

    mSpecificsDialogAction()
    {
        this$0 = final_itemspecificsdialogfragment;
        val$specific = ItemSpecific.this;
        super();
    }
}
