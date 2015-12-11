// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.media.MediaPlayer;
import android.widget.SeekBar;
import com.aio.downloader.utils.Player;

// Referenced classes of package com.aio.downloader.fragments:
//            Ringtone_Recent_Fragment

class this._cls0
    implements android.widget.arChangeEvent
{

    int progress;
    final Ringtone_Recent_Fragment this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        try
        {
            progress = (Ringtone_Recent_Fragment.access$2(Ringtone_Recent_Fragment.this).mediaPlayer.getDuration() * i) / seekbar.getMax();
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
        Ringtone_Recent_Fragment.access$2(Ringtone_Recent_Fragment.this).mediaPlayer.seekTo(progress);
    }

    ()
    {
        this$0 = Ringtone_Recent_Fragment.this;
        super();
    }
}
