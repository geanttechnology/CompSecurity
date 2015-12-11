// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.services.binders.BackgroundMusicBinder;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, SplashscreenActivity, PostHomeActivity

class this._cls0 extends Handler
{

    final AkActivity this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            AkLog.e("Akinator", "****** CLOSE!! ******");
            BackgroundMusicBinder.sharedInstance().doUnbindService();
            BackgroundSoundsBinder.sharedInstance().doUnbindService();
            message = new Intent(AkActivity.this, com/digidust/elokence/akinator/activities/SplashscreenActivity);
            message.setFlags(0x4000000);
            message.putExtra("closeApp", true);
            startActivity(message);
            finish();
            return;

        case 1: // '\001'
            AkLog.d("Akinator", "ERREUR TECHNIQUE!! -> BACK HOME");
            mHandler.removeMessages(message.what);
            goToHome();
            return;

        case 2: // '\002'
            AkLog.d("Akinator", "MSG_RESTART_GAME");
            message = new Intent(AkActivity.this, com/digidust/elokence/akinator/activities/PostHomeActivity);
            startActivity(message);
            overridePendingTransition(0x7f04001a, 0x7f04001b);
            finish();
            return;

        case 3: // '\003'
            AkLog.d("Akinator", "MSG_BACK_TO_SPLASHSCREEN");
            break;
        }
        message = new Intent(AkActivity.this, com/digidust/elokence/akinator/activities/SplashscreenActivity);
        message.setFlags(0x4000000);
        startActivity(message);
        overridePendingTransition(0x7f04001a, 0x7f04001b);
        finish();
    }

    ity()
    {
        this$0 = AkActivity.this;
        super();
    }
}
