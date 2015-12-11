// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.handler;

import tv.freewheel.utils.Scheduler;

// Referenced classes of package tv.freewheel.ad.handler:
//            VideoViewCallbackHandler

class this._cls0
    implements Runnable
{

    final VideoViewCallbackHandler this$0;

    public void run()
    {
        send(VideoViewCallbackHandler.access$000(VideoViewCallbackHandler.this).getLastRunDuration());
        int _tmp = VideoViewCallbackHandler.access$104(VideoViewCallbackHandler.this);
        if (VideoViewCallbackHandler.access$100(VideoViewCallbackHandler.this) == 8)
        {
            VideoViewCallbackHandler.access$102(VideoViewCallbackHandler.this, 7);
        }
        VideoViewCallbackHandler.access$000(VideoViewCallbackHandler.this).start(VideoViewCallbackHandler.access$200()[VideoViewCallbackHandler.access$100(VideoViewCallbackHandler.this)], false);
    }

    ()
    {
        this$0 = VideoViewCallbackHandler.this;
        super();
    }
}
