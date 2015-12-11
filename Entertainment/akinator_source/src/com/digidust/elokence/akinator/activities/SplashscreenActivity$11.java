// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import com.digidust.elokence.akinator.billing.AkInappManager;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SplashscreenActivity

class val.initOK
    implements Runnable
{

    final SplashscreenActivity this$0;
    final boolean val$initOK;

    public void run()
    {
        if (val$initOK)
        {
            AkInappManager.getInstance().requestInappDetailsUpdate();
            AkInappManager.getInstance().requestAllPurchases();
            return;
        } else
        {
    /* block-local class not found */
    class _cls1 {}

            runOnUiThread(new _cls1());
            return;
        }
    }

    _cls1()
    {
        this$0 = final_splashscreenactivity;
        val$initOK = Z.this;
        super();
    }
}
