// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.DialogInterface;
import android.content.Intent;
import com.digidust.elokence.akinator.services.binders.BackgroundMusicBinder;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity, SplashscreenActivity

class this._cls0
    implements android.content.OnClickListener
{

    final HomeActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            BackgroundMusicBinder.sharedInstance().doUnbindService();
            BackgroundSoundsBinder.sharedInstance().doUnbindService();
            dialoginterface = new Intent(HomeActivity.this, com/digidust/elokence/akinator/activities/SplashscreenActivity);
            dialoginterface.setFlags(0x4000000);
            dialoginterface.putExtra("closeApp", true);
            startActivity(dialoginterface);
            finish();
        } else
        if (i == -2)
        {
            dialoginterface.dismiss();
            return;
        }
    }

    vity()
    {
        this$0 = HomeActivity.this;
        super();
    }
}
