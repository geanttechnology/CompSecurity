// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvInterstitialActivity

class this._cls0
    implements Runnable
{

    final CvInterstitialActivity this$0;

    public void run()
    {
        if (getTimeOnScreeen() < 2000L)
        {
            return;
        }
        if (CvInterstitialActivity.access$000(CvInterstitialActivity.this) != null)
        {
            CvInterstitialActivity.access$000(CvInterstitialActivity.this).run();
        } else
        {
            finish();
        }
        CvInterstitialActivity.access$002(CvInterstitialActivity.this, null);
    }

    ()
    {
        this$0 = CvInterstitialActivity.this;
        super();
    }
}
