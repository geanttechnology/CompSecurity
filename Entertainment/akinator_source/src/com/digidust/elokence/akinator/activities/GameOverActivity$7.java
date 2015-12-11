// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.view.View;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity

class this._cls0
    implements android.view.r
{

    final GameOverActivity this$0;

    public void onClick(View view)
    {
        AkConfigFactory.sharedInstance().setCanReShowAlert(true);
        BackgroundSoundsBinder.sharedInstance().playBip();
        AkSessionFactory.sharedInstance().setStepOfLastProp(0);
        GameOverActivity.access$100(GameOverActivity.this);
    }

    ndsBinder()
    {
        this$0 = GameOverActivity.this;
        super();
    }
}
