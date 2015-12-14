// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.widget.SeekBar;
import android.widget.TextView;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.model.Song;

// Referenced classes of package my.googlemusic.play.activities:
//            RadioActivity

class this._cls0
    implements android.widget.rChangeListener
{

    final RadioActivity this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        RadioActivity.access$700(RadioActivity.this).time.setText(RadioActivity.access$1200(RadioActivity.this, i));
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        if (RadioActivity.access$500(RadioActivity.this) != null && RadioActivity.access$500(RadioActivity.this).getCurrentSong().getId() != 0L)
        {
            RadioActivity.access$500(RadioActivity.this).seekTo(seekbar.getProgress());
        }
    }

    ewHolder()
    {
        this$0 = RadioActivity.this;
        super();
    }
}
