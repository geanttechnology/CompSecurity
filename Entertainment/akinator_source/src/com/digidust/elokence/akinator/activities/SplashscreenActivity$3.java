// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import com.digidust.elokence.akinator.factories.AkApplication;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SplashscreenActivity

class this._cls0
    implements Runnable
{

    final SplashscreenActivity this$0;

    public void run()
    {
label0:
        {
            Object obj = new ArrayList();
            if (TraductionFactory.sharedInstance().createTraductionFactory(((ArrayList) (obj))) != 0)
            {
                break label0;
            }
            obj = ((ArrayList) (obj)).iterator();
            com.elokence.limuleapi.age age;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                age = (com.elokence.limuleapi.age)((Iterator) (obj)).next();
            } while (!age.getCode().equals(TraductionFactory.sharedInstance().getApplicationLanguage()));
            TraductionFactory.sharedInstance().setApplicationLanguage(age.getCode());
            AkApplication.setCoeffFont(Float.parseFloat(age.getFontCoeffAndroid()));
        }
    }

    ()
    {
        this$0 = SplashscreenActivity.this;
        super();
    }
}
