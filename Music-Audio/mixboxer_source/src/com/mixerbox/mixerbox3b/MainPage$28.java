// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.media.MediaPlayer;
import android.webkit.WebView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.services.MyService;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class state
    implements android.widget.ekBarChangeListener
{

    int state;
    final MainPage this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        tvTimeStart.setText(MixerBoxUtils.getSongTime(String.valueOf((int)Math.round(Double.valueOf(i).doubleValue()))));
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        MainPage.access$200(MainPage.this).removeMessages(1);
        canUpdateSeekbar = false;
        if (playingSong != null && (playingSong.getSongSource() == 3 || playingSong.getSongSource() == 2))
        {
            if (MyService.mediaPlayer.isPlaying())
            {
                state = 1;
            }
            MyService.mediaPlayer.pause();
        }
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        MainPage.access$200(MainPage.this).sendEmptyMessageDelayed(1, 4000L);
        canUpdateSeekbar = true;
        if (playingSong != null && playingSong.getSongSource() == 3 || playingPlaylist != null && playingPlaylist.getPlaylistType() == 8)
        {
            if (MyService.mediaPlayer != null)
            {
                MyService.mediaPlayer.seekTo(seekbar.getProgress() * 1000);
                if (state == 1)
                {
                    MyService.mediaPlayer.start();
                }
            }
            return;
        } else
        {
            wv.loadUrl((new StringBuilder()).append("javascript:seekTo(").append(seekbar.getProgress()).append(")").toString());
            return;
        }
    }

    listItem()
    {
        this$0 = MainPage.this;
        super();
        state = 0;
    }
}
