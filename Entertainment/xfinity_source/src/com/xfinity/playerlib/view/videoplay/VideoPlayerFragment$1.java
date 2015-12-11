// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.media.AudioManager;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls0
    implements android.media.cusChangeListener
{

    final VideoPlayerFragment this$0;

    public void onAudioFocusChange(int i)
    {
        while (i == -2 || i == 1 || i != -1) 
        {
            return;
        }
        VideoPlayerFragment.access$200(VideoPlayerFragment.this).unregisterMediaButtonEventReceiver(VideoPlayerFragment.access$100(VideoPlayerFragment.this));
        VideoPlayerFragment.access$200(VideoPlayerFragment.this).abandonAudioFocus(VideoPlayerFragment.access$300(VideoPlayerFragment.this));
    }

    ()
    {
        this$0 = VideoPlayerFragment.this;
        super();
    }
}
