// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.media.MediaPlayer;
import android.widget.SeekBar;

// Referenced classes of package com.livemixtapes:
//            NowPlayingActivity, console, LMTService, MediaObserver

class this._cls0
    implements android.widget.geListener
{

    final NowPlayingActivity this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (!touchtracking || !flag)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        int j = Integer.parseInt(NowPlayingActivity.trackDuration);
        console.log(new Object[] {
            (new StringBuilder("SEEKING TO UPDATE: ")).append(i).toString()
        });
        console.log(new Object[] {
            (new StringBuilder("TRACK DURATION: ")).append(NowPlayingActivity.trackDuration).toString()
        });
        seekbar = Double.valueOf(Double.valueOf(Double.valueOf(Double.valueOf(i).doubleValue() * Double.valueOf(j).doubleValue()).doubleValue() / 100D).doubleValue() * 1000D);
        console.log(new Object[] {
            (new StringBuilder("SEEKING TO ")).append(seekbar.intValue()).toString()
        });
        LMTService.mPlayer.seekTo(seekbar.intValue());
        return;
        seekbar;
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        touchtracking = true;
        NowPlayingActivity.access$2().stop();
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        touchtracking = false;
        NowPlayingActivity.access$2().unstop();
    }

    Listener()
    {
        this$0 = NowPlayingActivity.this;
        super();
    }
}
