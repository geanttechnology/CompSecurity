// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SplashscreenActivity

class this._cls0
    implements Runnable
{

    final SplashscreenActivity this$0;

    public void run()
    {
        int i = getScreenWidth() / 2;
        boolean flag = AkConfigFactory.sharedInstance().isPrio();
        i = SessionFactory.sharedInstance().createSessionFactory(AkConfigFactory.sharedInstance().isChildProtectEnabled(), AkConfigFactory.sharedInstance().getPartnerId(isTablet()), Integer.parseInt(AkConfigFactory.sharedInstance().getMediaId()), AkConfigFactory.sharedInstance().getMediaFootprint(), TraductionFactory.sharedInstance().getApplicationLanguage(), 1, flag, flag, flag, (i * 16) / 9, i);
        if (i == 0)
        {
            int j = SessionFactory.sharedInstance().getRankingLimit();
            i = j;
            if (j < 500)
            {
                i = 500;
            }
            j = i;
            if (i > 10000)
            {
                j = 10000;
            }
            if (AkConfigFactory.sharedInstance().getMaxRanking() < 3)
            {
                AkConfigFactory.sharedInstance().setMaxRanking(j * 10);
            }
            AkConfigFactory.sharedInstance().setOriginalMaxRanking(j * 100);
            SplashscreenActivity.access$202(SplashscreenActivity.this, true);
            SplashscreenActivity.access$300(SplashscreenActivity.this);
            return;
        }
        if (i == 500 || i == 510)
        {
            if (i == 500)
            {
                AkConfigFactory.sharedInstance().setCanPlay(-1);
            } else
            {
                AkConfigFactory.sharedInstance().setCanPlay(0);
            }
            SplashscreenActivity.access$202(SplashscreenActivity.this, true);
            SplashscreenActivity.access$300(SplashscreenActivity.this);
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
        this$0 = SplashscreenActivity.this;
        super();
    }
}
