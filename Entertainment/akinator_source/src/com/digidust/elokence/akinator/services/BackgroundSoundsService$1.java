// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.services;

import com.digidust.elokence.akinator.activities.AkActivity;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import java.util.TimerTask;

// Referenced classes of package com.digidust.elokence.akinator.services:
//            BackgroundSoundsService

class this._cls0 extends TimerTask
{

    final BackgroundSoundsService this$0;

    public void run()
    {
        if (AkActivity.nbActivities == 0)
        {
            int _tmp = BackgroundSoundsService.access$008(BackgroundSoundsService.this);
        } else
        {
            BackgroundSoundsService.access$002(BackgroundSoundsService.this, 0);
        }
        if (BackgroundSoundsService.access$000(BackgroundSoundsService.this) > 10)
        {
            if (BackgroundSoundsService.access$100(BackgroundSoundsService.this) != null)
            {
                BackgroundSoundsService.access$100(BackgroundSoundsService.this).doUnbindService();
            }
            BackgroundSoundsService.access$200(BackgroundSoundsService.this).cancel();
            stopSelf();
            AkLog.w("Akinator", "BackgroundSoundsService Stopped");
        }
    }

    nder()
    {
        this$0 = BackgroundSoundsService.this;
        super();
    }
}
