// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Dialog;
import android.content.DialogInterface;
import com.ebay.mobile.sell.util.ItemSpecificsValueProcessor;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.data.ItemSpecific;

// Referenced classes of package com.ebay.mobile.sell:
//            ItemSpecificsDialogFragment

class val.checkedSpecificOptions
    implements android.content.r
{

    final ItemSpecificsDialogFragment this$0;
    final boolean val$checkedSpecificOptions[];
    final ItemSpecificsValueProcessor val$processor;
    final ItemSpecific val$specifics;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        getDialog().dismiss();
        dialoginterface = new mSpecificsDialogData(mSpecificsDialogAction.SAVE_MULTIPLE);
        dialoginterface.specifics = val$specifics;
        dialoginterface.processor = val$processor;
        dialoginterface.checkedSpecificOptions = val$checkedSpecificOptions;
        ContentSyncManager.notifyUpdate(dialoginterface, com/ebay/mobile/sell/ItemSpecificsSpokeFragment$ItemSpecificsDialogData.getName());
    }

    or()
    {
        this$0 = final_itemspecificsdialogfragment;
        val$specifics = itemspecific;
        val$processor = itemspecificsvalueprocessor;
        val$checkedSpecificOptions = _5B_Z.this;
        super();
    }
}
