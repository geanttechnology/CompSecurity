// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.media.MediaPlayer;
import android.widget.SeekBar;
import com.aio.downloader.utils.Player;

// Referenced classes of package com.aio.downloader.fragments:
//            RingtoneSearchFragment

class this._cls0
    implements android.widget.arChangeEvent
{

    int progress;
    final RingtoneSearchFragment this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        try
        {
            progress = (RingtoneSearchFragment.access$2(RingtoneSearchFragment.this).mediaPlayer.getDuration() * i) / seekbar.getMax();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SeekBar seekbar)
        {
            return;
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        RingtoneSearchFragment.access$2(RingtoneSearchFragment.this).mediaPlayer.seekTo(progress);
    }

    ()
    {
        this$0 = RingtoneSearchFragment.this;
        super();
    }
}
