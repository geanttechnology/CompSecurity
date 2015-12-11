// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.app.Activity;
import android.view.Window;
import android.widget.SeekBar;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;
import com.xfinity.playerlib.view.CustomStateImageView;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment, PlayerPlatformMediaPlayer

class this._cls0
    implements android.widget.SeekBarChangeListener
{

    final VideoPlayerFragment this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        seekbar = getActivity().getWindow().getAttributes();
        seekbar.OnSeekBarChangeListener = VideoPlayerFragment.access$5200(VideoPlayerFragment.this, i);
        getActivity().getWindow().setAttributes(seekbar);
        if (VideoPlayerFragment.access$5300(VideoPlayerFragment.this))
        {
            seekbar = brightnessIndicator;
            if (i > 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            seekbar.setAppearEnabled(flag);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        VideoPlayerFragment.access$900(VideoPlayerFragment.this).out();
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        ((PlayerUserSettings)VideoPlayerFragment.access$2700(VideoPlayerFragment.this).getUserSettings()).setBrightnessValue(seekbar.getProgress());
        if (VideoPlayerFragment.access$500(VideoPlayerFragment.this).getMediaPlayer().getPlayerStatus().equals(PlayerStatus.PLAYING))
        {
            VideoPlayerFragment.access$900(VideoPlayerFragment.this).ut();
        }
    }

    ()
    {
        this$0 = VideoPlayerFragment.this;
        super();
    }
}
