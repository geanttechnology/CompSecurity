// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.utils.premium.google.IabResult;
import my.googlemusic.play.utils.premium.google.Purchase;

// Referenced classes of package my.googlemusic.play.activities:
//            PremiumActivity

class this._cls0
    implements my.googlemusic.play.utils.premium.google.chaseFinishedListener
{

    final PremiumActivity this$0;

    public void onIabPurchaseFinished(IabResult iabresult, Purchase purchase)
    {
        if (PremiumActivity.access$100(PremiumActivity.this) == null)
        {
            return;
        }
        if (iabresult.isFailure())
        {
            PremiumActivity.access$200(PremiumActivity.this, (new StringBuilder()).append("Error purchasing: ").append(iabresult).toString());
            PremiumActivity.access$300(PremiumActivity.this, true);
            return;
        } else
        {
            PremiumActivity.access$200(PremiumActivity.this, "Upgrading to Premium Mixtapez...");
            PremiumActivity.access$400(PremiumActivity.this);
            return;
        }
    }

    ()
    {
        this$0 = PremiumActivity.this;
        super();
    }
}
