// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import com.ijsbrandslob.appirater.Appirater;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerActivity

class this._cls0
    implements Runnable
{

    final VideoPlayerActivity this$0;

    public void run()
    {
        VideoPlayerActivity.access$000(VideoPlayerActivity.this).userDidSignificantEvent(false, VideoPlayerActivity.this);
    }

    ()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
