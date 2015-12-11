// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

private class <init>
    implements Runnable
{

    final VideoPlayerFragment this$0;

    public void run()
    {
        speechTriggerPause();
        VideoPlayerFragment.access$1100(VideoPlayerFragment.this).getTalkDelegate().speak(com.xfinity.playerlib.);
    }

    private ()
    {
        this$0 = VideoPlayerFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
