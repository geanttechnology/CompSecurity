// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            IAPDialogList, IAPDialogMain

class this._cls0 extends BroadcastReceiver
{

    final IAPDialogList this$0;

    public void onReceive(Context context, Intent intent)
    {
        IAPDialogList.logger.info("downloadMissingPacksCompletedReceiver");
        int i;
        if (context != null && intent != null)
        {
            context = intent.getStringExtra("packType");
            i = intent.getIntExtra("error", 0);
            break MISSING_BLOCK_LABEL_33;
        }
        do
        {
            return;
        } while (!isValidContext() || context == null || IAPDialogList.access$000(IAPDialogList.this) == null || IAPDialogList.access$000(IAPDialogList.this).getPackType() == null || !context.equals(IAPDialogList.access$000(IAPDialogList.this).getPackType().toCdsString()));
        runInventoryAsyncTask(i, IAPDialogList.access$100(IAPDialogList.this).mInventory);
    }

    PUpdater()
    {
        this$0 = IAPDialogList.this;
        super();
    }
}
