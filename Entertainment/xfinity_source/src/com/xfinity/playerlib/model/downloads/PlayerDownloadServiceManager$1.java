// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.downloads;

import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;

// Referenced classes of package com.xfinity.playerlib.model.downloads:
//            PlayerDownloadServiceManager

class val.video
    implements Runnable
{

    final PlayerDownloadServiceManager this$0;
    final VideoFacade val$video;

    public void run()
    {
        PlayerDownloadServiceManager.access$000(PlayerDownloadServiceManager.this).trackDownloadRequest(val$video);
    }

    ()
    {
        this$0 = final_playerdownloadservicemanager;
        val$video = VideoFacade.this;
        super();
    }
}
