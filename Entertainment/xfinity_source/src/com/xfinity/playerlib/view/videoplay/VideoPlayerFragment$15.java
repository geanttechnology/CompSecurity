// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.view.View;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls0
    implements android.view..VideoPlayerFragment._cls15
{

    final VideoPlayerFragment this$0;

    public void onClick(View view)
    {
        VideoPlayerFragment.access$500(VideoPlayerFragment.this).onPauseButton();
        if (VideoPlayerFragment.access$1000(VideoPlayerFragment.this).isAccessibilityEnabled())
        {
            VideoPlayerFragment.access$1100(VideoPlayerFragment.this).getTalkDelegate().speak(com.xfinity.playerlib.ption_pause_selected);
            VideoPlayerFragment.access$1200(VideoPlayerFragment.this, com.xfinity.playerlib.ption_toggle_controls_are_visible);
        }
    }

    ener()
    {
        this$0 = VideoPlayerFragment.this;
        super();
    }
}
