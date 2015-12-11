// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.ebay.mobile.sell.util.ItemSpecificsValueProcessor;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.data.ItemSpecific;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.sell:
//            ItemSpecificsDialogFragment

class val.specifics
    implements android.content.r
{

    final ItemSpecificsDialogFragment this$0;
    final ItemSpecificsValueProcessor val$processor;
    final ItemSpecific val$specifics;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        getDialog().dismiss();
        if (((com.ebay.nautilus.domain.data.)val$processor.values.get(i)).custom)
        {
            dialoginterface = new ItemSpecificsDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("dialog_id", 1);
            bundle.putParcelable("specifics", val$specifics);
            dialoginterface.setArguments(bundle);
            dialoginterface.show(getFragmentManager(), "specificsDialog");
            return;
        } else
        {
            dialoginterface = new mSpecificsDialogData(mSpecificsDialogAction.SAVE_SINGLE);
            dialoginterface.which = i;
            dialoginterface.specifics = val$specifics;
            dialoginterface.processor = val$processor;
            ContentSyncManager.notifyUpdate(dialoginterface, com/ebay/mobile/sell/ItemSpecificsSpokeFragment$ItemSpecificsDialogData.getName());
            return;
        }
    }

    or()
    {
        this$0 = final_itemspecificsdialogfragment;
        val$processor = itemspecificsvalueprocessor;
        val$specifics = ItemSpecific.this;
        super();
    }
}
