// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls0 extends BroadcastReceiver
{

    final VideoPlayerFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction()) && VideoPlayerFragment.access$500(VideoPlayerFragment.this) != null)
        {
            VideoPlayerFragment.access$500(VideoPlayerFragment.this).onHeadsetNoiseDetected();
        }
    }

    eController()
    {
        this$0 = VideoPlayerFragment.this;
        super();
    }
}
