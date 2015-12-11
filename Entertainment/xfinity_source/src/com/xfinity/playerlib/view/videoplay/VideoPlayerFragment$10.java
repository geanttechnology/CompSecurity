// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.view.View;
import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls0
    implements android.view..VideoPlayerFragment._cls10
{

    final VideoPlayerFragment this$0;

    public void onClick(View view)
    {
        if (VideoPlayerFragment.access$800(VideoPlayerFragment.this) == yGuideType.INFO)
        {
            VideoPlayerFragment.access$500(VideoPlayerFragment.this).onBackButton();
            return;
        } else
        {
            VideoPlayerFragment.access$500(VideoPlayerFragment.this).onBabyGuideButton();
            return;
        }
    }

    Controller()
    {
        this$0 = VideoPlayerFragment.this;
        super();
    }
}
