// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.content.DialogInterface;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            EndCardState, VideoStateController

class val.nextWatchable
    implements android.content..OnClickListener
{

    final EndCardState this$0;
    final VideoFacade val$nextVideoFacade;
    final Watchable val$nextWatchable;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        stateController.setVideoAndWatchable(val$nextVideoFacade, val$nextWatchable);
        stateController.reset();
    }

    oller()
    {
        this$0 = final_endcardstate;
        val$nextVideoFacade = videofacade;
        val$nextWatchable = Watchable.this;
        super();
    }
}
