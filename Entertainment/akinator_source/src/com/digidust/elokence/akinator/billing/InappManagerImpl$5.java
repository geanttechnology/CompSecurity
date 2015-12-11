// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.billing;

import android.os.AsyncTask;
import com.android.vending.billing.IInAppBillingService;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;

// Referenced classes of package com.digidust.elokence.akinator.billing:
//            InappManagerImpl, InappPurchaseActivity

class val.token extends AsyncTask
{

    final InappManagerImpl this$0;
    final InappPurchaseActivity val$caller;
    final String val$sku;
    final String val$token;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        int i;
        char c;
        c = val$sku.charAt(val$sku.length() - 1);
        i = 0;
        c;
        JVM INSTR tableswitch 49 53: default 56
    //                   49 93
    //                   50 99
    //                   51 105
    //                   52 111
    //                   53 117;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_117;
_L7:
        try
        {
            if (mService.consumePurchase(3, val$caller.getPackageName(), val$token) == 0)
            {
                AkPlayerBelongingsFactory.sharedInstance().depositGeniz(i);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return null;
_L2:
        i = 45000;
          goto _L7
_L3:
        i = 0x1c138;
          goto _L7
_L4:
        i = 0x2f9b8;
          goto _L7
_L5:
        i = 0x4a768;
          goto _L7
        i = 0x704e0;
          goto _L7
    }

    ty()
    {
        this$0 = final_inappmanagerimpl;
        val$sku = s;
        val$caller = inapppurchaseactivity;
        val$token = String.this;
        super();
    }
}
