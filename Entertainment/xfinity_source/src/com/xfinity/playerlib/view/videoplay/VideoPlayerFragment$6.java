// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls0
    implements android.view.ityChangeListener
{

    final VideoPlayerFragment this$0;

    public void onSystemUiVisibilityChange(int i)
    {
        if (VideoPlayerFragment.access$600(VideoPlayerFragment.this) != i)
        {
            if ((i & 4) == 0)
            {
                VideoPlayerFragment.access$500(VideoPlayerFragment.this).onScreenTouch();
            }
            VideoPlayerFragment.access$602(VideoPlayerFragment.this, i);
        }
    }

    eController()
    {
        this$0 = VideoPlayerFragment.this;
        super();
    }
}
