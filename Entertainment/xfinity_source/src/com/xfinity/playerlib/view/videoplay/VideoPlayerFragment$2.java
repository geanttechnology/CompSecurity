// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls0 extends BroadcastReceiver
{

    final VideoPlayerFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        VideoPlayerFragment.access$400().debug("@###CONNECTIVITY intent received");
        if (VideoPlayerFragment.access$500(VideoPlayerFragment.this) != null && VideoPlayerFragment.access$500(VideoPlayerFragment.this).getDownloadedFile() == null)
        {
            VideoPlayerFragment.access$500(VideoPlayerFragment.this).onConnectivityChanged();
        }
    }

    eController()
    {
        this$0 = VideoPlayerFragment.this;
        super();
    }
}
