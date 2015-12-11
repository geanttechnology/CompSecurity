// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            DetailFragment

class val.watchable
    implements Runnable
{

    final DetailFragment this$0;
    final ayPressedListener val$playPressedListener;
    final VideoFacade val$video;
    final Watchable val$watchable;

    public void run()
    {
        val$playPressedListener.onPlayOrResumePressed(val$video, val$watchable);
    }

    ayPressedListener()
    {
        this$0 = final_detailfragment;
        val$playPressedListener = aypressedlistener;
        val$video = videofacade;
        val$watchable = Watchable.this;
        super();
    }
}
