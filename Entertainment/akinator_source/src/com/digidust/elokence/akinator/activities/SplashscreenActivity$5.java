// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import com.digidust.elokence.akinator.billing.AkInappManager;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SplashscreenActivity

class this._cls0
    implements Runnable
{

    final SplashscreenActivity this$0;

    public void run()
    {
        AkInappManager.getInstance().init();
    }

    ()
    {
        this$0 = SplashscreenActivity.this;
        super();
    }
}
