// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.view.View;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment, PlayerPlatformMediaPlayer

class this._cls1
    implements android.view.nt.PlayerUIController._cls6
{

    final nTouch this$1;

    public void onClick(View view)
    {
        if (VideoPlayerFragment.access$1000(_fld0).isAccessibilityEnabled())
        {
            if (VideoPlayerFragment.access$500(_fld0).getMediaPlayer().getPlayerStatus() == PlayerStatus.PLAYING)
            {
                view = _fld0;
                boolean flag;
                if (!VideoPlayerFragment.access$2500(_fld0))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                VideoPlayerFragment.access$2502(view, flag);
                if (VideoPlayerFragment.access$2500(_fld0))
                {
                    cess._mth4100(this._cls1.this, false);
                    VideoPlayerFragment.access$1100(_fld0).getTalkDelegate().speak(com.xfinity.playerlib.ol_instructions_off);
                    return;
                } else
                {
                    deAllControls();
                    deInfoPanel();
                    VideoPlayerFragment.access$1100(_fld0).getTalkDelegate().speak(com.xfinity.playerlib.ol_instructions_on);
                    return;
                }
            } else
            {
                VideoPlayerFragment.access$1100(_fld0).getTalkDelegate().speak(com.xfinity.playerlib.ols_only_available_when_playing);
                return;
            }
        } else
        {
            VideoPlayerFragment.access$500(_fld0).onScreenTouch();
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
