// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class val.time
    implements Runnable
{

    final val.time this$1;
    final String val$time;

    public void run()
    {
        if ((playingSong == null || playingSong.getSongSource() != 3 && playingSong.getSongSource() != 2) && val$time != null && !val$time.equals("undefined"))
        {
            currentTime = (int)Math.round(Double.valueOf(val$time).doubleValue());
            if (canUpdateSeekbar)
            {
                seekbar.setProgress((int)Math.round(Double.valueOf(val$time).doubleValue()));
                tvTimeStart.setText(MixerBoxUtils.getSongTime(String.valueOf((int)Math.round(Double.valueOf(val$time).doubleValue()))));
            }
            if (rlPanelTop.getVisibility() == 8)
            {
                rlPanelPopup.setVisibility(8);
                return;
            }
        }
    }

    ()
    {
        this$1 = final_;
        val$time = String.this;
        super();
    }
}
