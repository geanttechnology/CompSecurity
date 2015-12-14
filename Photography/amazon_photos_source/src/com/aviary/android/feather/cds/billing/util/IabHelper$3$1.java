// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds.billing.util;

import android.os.Handler;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.cds.billing.util:
//            Inventory, IabResult, IabHelper, IabException

class val.invF
    implements Runnable
{

    final val.invF this$1;
    final Inventory val$invF;
    final IabResult val$resultF;

    public void run()
    {
        listener.onQueryInventoryFinished(val$resultF, val$invF);
    }

    l.handler()
    {
        this$1 = final_handler;
        val$resultF = iabresult;
        val$invF = Inventory.this;
        super();
    }

    // Unreferenced inner class com/aviary/android/feather/cds/billing/util/IabHelper$3

/* anonymous class */
    class IabHelper._cls3
        implements Runnable
    {

        final IabHelper this$0;
        final Handler val$handler;
        final IabHelper.QueryInventoryFinishedListener val$listener;
        final List val$moreSkus;
        final boolean val$querySkuDetails;
        final List val$subSkus;

        public void run()
        {
            Inventory inventory;
            final IabResult resultF;
            resultF = new IabResult(0, "Inventory refresh successful.");
            inventory = null;
            Inventory inventory1 = queryInventory(querySkuDetails, moreSkus, subSkus);
            inventory = inventory1;
_L2:
            flagEndAsync();
            if (!mDisposed && listener != null)
            {
                handler.post(inventory. new IabHelper._cls3._cls1());
            }
            return;
            IabException iabexception;
            iabexception;
            iabexception = iabexception.getResult();
            if (true) goto _L2; else goto _L1
_L1:
        }

            
            {
                this$0 = final_iabhelper;
                querySkuDetails = flag;
                moreSkus = list;
                subSkus = list1;
                listener = queryinventoryfinishedlistener;
                handler = Handler.this;
                super();
            }
    }

}
