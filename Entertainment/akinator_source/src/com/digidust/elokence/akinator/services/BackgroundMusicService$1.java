// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.services;

import com.digidust.elokence.akinator.activities.AkActivity;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.services.binders.BackgroundMusicBinder;
import java.util.TimerTask;

// Referenced classes of package com.digidust.elokence.akinator.services:
//            BackgroundMusicService

class this._cls0 extends TimerTask
{

    final BackgroundMusicService this$0;

    public void run()
    {
        if (AkActivity.nbActivities == 0)
        {
            int _tmp = BackgroundMusicService.access$008(BackgroundMusicService.this);
            pauseMusic();
        } else
        {
            BackgroundMusicService.access$002(BackgroundMusicService.this, 0);
            resumeMusic();
        }
        if (BackgroundMusicService.access$000(BackgroundMusicService.this) > 5)
        {
            stopMusic();
            BackgroundMusicService.access$100(BackgroundMusicService.this);
            if (BackgroundMusicService.access$200(BackgroundMusicService.this) != null)
            {
                BackgroundMusicService.access$200(BackgroundMusicService.this).doUnbindService();
            }
            stopSelf();
            AkLog.d("BackgroundMusicService", "BackgroundMusicService Stopped");
        }
    }

    nder()
    {
        this$0 = BackgroundMusicService.this;
        super();
    }
}
