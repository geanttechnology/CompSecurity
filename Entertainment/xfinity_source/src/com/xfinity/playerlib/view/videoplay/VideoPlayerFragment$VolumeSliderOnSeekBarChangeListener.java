// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.media.AudioManager;
import android.widget.SeekBar;
import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;
import com.xfinity.playerlib.view.CustomStateImageView;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls0
    implements android.widget.SeekBarChangeListener
{

    private int startVolume;
    final VideoPlayerFragment this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        flag = false;
        if (!VideoPlayerFragment.access$5100(VideoPlayerFragment.this))
        {
            VideoPlayerFragment.access$200(VideoPlayerFragment.this).setStreamVolume(3, i, 0);
            if (VideoPlayerFragment.access$5300(VideoPlayerFragment.this))
            {
                seekbar = volumeIndicator;
                if (i > 0)
                {
                    flag = true;
                }
                seekbar.setAppearEnabled(flag);
            }
            return;
        } else
        {
            VideoPlayerFragment.access$5402(VideoPlayerFragment.this, seekbar.getProgress());
            return;
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        int i = seekbar.getProgress();
        VideoPlayerFragment.access$900(VideoPlayerFragment.this).Timeout();
        startVolume = i;
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        if (seekbar.getProgress() > startVolume && VideoPlayerFragment.access$5100(VideoPlayerFragment.this))
        {
            setMuteState(false);
        }
        VideoPlayerFragment.access$500(VideoPlayerFragment.this).onVolumeChanged();
    }

    ()
    {
        this$0 = VideoPlayerFragment.this;
        super();
    }
}
