// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.billing;

import android.os.AsyncTask;
import com.android.vending.billing.IInAppBillingService;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;

// Referenced classes of package com.digidust.elokence.akinator.billing:
//            InappManagerImpl, AkInappManager, InappPurchaseActivity

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
        String s;
        int k;
        avoid = "";
        for (int i = 0; i < skusInappFaces.length; i++)
        {
            if (val$sku.equals(skusInappFaces[i]))
            {
                avoid = AkInappManager.getInstance().nomsInappFaces[i];
            }
        }

        s = "";
        for (int j = 0; j < avoid.length();)
        {
            String s1 = s;
            if (Character.isDigit(avoid.charAt(j)))
            {
                s1 = (new StringBuilder()).append(s).append(avoid.charAt(j)).toString();
            }
            j++;
            s = s1;
        }

        k = 0;
        int l = Integer.parseInt(s);
        k = l;
_L1:
        try
        {
            if (mService.consumePurchase(3, val$caller.getPackageName(), val$token) == 0)
            {
                AkPlayerBelongingsFactory.sharedInstance().depositFaces(k);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return null;
        avoid;
          goto _L1
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
