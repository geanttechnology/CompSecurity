// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import com.digidust.elokence.akinator.factories.AkApplication;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SplashscreenActivity

class this._cls0
    implements Runnable
{

    final SplashscreenActivity this$0;

    public void run()
    {
        int i;
label0:
        {
            Object obj = new ArrayList();
            if (TraductionFactory.sharedInstance().createTraductionFactory(((ArrayList) (obj))) == 0)
            {
                boolean flag1 = false;
                obj = ((ArrayList) (obj)).iterator();
                boolean flag;
                do
                {
                    flag = flag1;
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    com.elokence.limuleapi.age age = (com.elokence.limuleapi.age)((Iterator) (obj)).next();
                    if (!age.getCode().equals(Locale.getDefault().getLanguage()))
                    {
                        continue;
                    }
                    TraductionFactory.sharedInstance().setApplicationLanguage(age.getCode());
                    flag = true;
                    AkApplication.setCoeffFont(Float.parseFloat(age.getFontCoeffAndroid()));
                    break;
                } while (true);
                SplashscreenActivity.access$002(SplashscreenActivity.this, flag);
                if (!SplashscreenActivity.access$000(SplashscreenActivity.this))
                {
                    SplashscreenActivity.access$102(SplashscreenActivity.this, true);
                }
                i = getScreenWidth() / 2;
                flag = AkConfigFactory.sharedInstance().isPrio();
                SessionFactory sessionfactory = SessionFactory.sharedInstance();
                flag1 = AkConfigFactory.sharedInstance().isChildProtectEnabled();
                int j = AkConfigFactory.sharedInstance().getPartnerId(isTablet());
                int k = Integer.parseInt(AkConfigFactory.sharedInstance().getMediaId());
                String s = AkConfigFactory.sharedInstance().getMediaFootprint();
                if (SplashscreenActivity.access$000(SplashscreenActivity.this))
                {
                    obj = TraductionFactory.sharedInstance().getApplicationLanguage();
                } else
                {
                    obj = "en";
                }
                i = sessionfactory.createSessionFactory(flag1, j, k, s, ((String) (obj)), 1, flag, flag, flag, (i * 16) / 9, i);
                if (i != 0)
                {
                    break label0;
                }
                if (AkConfigFactory.sharedInstance().getMaxRanking() < 3)
                {
                    AkConfigFactory.sharedInstance().setMaxRanking(50000);
                }
                AkConfigFactory.sharedInstance().setOriginalMaxRanking(0x7a120);
                SplashscreenActivity.access$002(SplashscreenActivity.this, true);
                SplashscreenActivity.access$202(SplashscreenActivity.this, true);
                SplashscreenActivity.access$300(SplashscreenActivity.this);
            }
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
            SplashscreenActivity.access$002(SplashscreenActivity.this, true);
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
