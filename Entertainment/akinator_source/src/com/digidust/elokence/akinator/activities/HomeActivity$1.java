// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.digidust.elokence.akinator.billing.AkInappManager;
import com.digidust.elokence.akinator.factories.AkAnalyticsFactory;
import com.digidust.elokence.akinator.factories.AkConfigFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity

class this._cls0
    implements android.content..OnClickListener
{

    final HomeActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (AkConfigFactory.sharedInstance().canPlay() == 0 && !AkConfigFactory.sharedInstance().isPrio())
        {
            disableAdOneTime();
            AkAnalyticsFactory.sharedInstance().logDebutAchatInApp(AkInappManager.getInstance().getSkuInappUltime());
            AkInappManager.getInstance().purchaseInapp(AkInappManager.getInstance().getSkuInappUltime(), HomeActivity.this);
        } else
        if (AkConfigFactory.sharedInstance().canPlay() == -1)
        {
            dialoginterface = new Message();
            dialoginterface.what = 0;
            mHandler.sendMessage(dialoginterface);
            return;
        }
    }

    ry()
    {
        this$0 = HomeActivity.this;
        super();
    }
}
