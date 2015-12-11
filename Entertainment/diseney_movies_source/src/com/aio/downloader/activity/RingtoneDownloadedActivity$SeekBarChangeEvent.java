// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.media.MediaPlayer;
import android.widget.SeekBar;
import com.aio.downloader.utils.Player;

// Referenced classes of package com.aio.downloader.activity:
//            RingtoneDownloadedActivity

class this._cls0
    implements android.widget.rChangeEvent
{

    int progress;
    final RingtoneDownloadedActivity this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        progress = (RingtoneDownloadedActivity.access$3(RingtoneDownloadedActivity.this).mediaPlayer.getDuration() * i) / seekbar.getMax();
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        RingtoneDownloadedActivity.access$3(RingtoneDownloadedActivity.this).mediaPlayer.seekTo(progress);
    }

    ()
    {
        this$0 = RingtoneDownloadedActivity.this;
        super();
    }
}
