// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.view.View;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity, AwardsActivity

class this._cls0
    implements android.view.tener
{

    final HomeActivity this$0;

    public void onClick(View view)
    {
        BackgroundSoundsBinder.sharedInstance().playBip();
        disableAdOneTime();
        view = new Intent(HomeActivity.this, com/digidust/elokence/akinator/activities/AwardsActivity);
        startActivity(view);
    }

    dSoundsBinder()
    {
        this$0 = HomeActivity.this;
        super();
    }
}
