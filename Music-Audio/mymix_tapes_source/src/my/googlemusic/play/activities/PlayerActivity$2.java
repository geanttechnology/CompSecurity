// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.widget.SeekBar;
import android.widget.TextView;
import my.googlemusic.play.interfaces.Player;

// Referenced classes of package my.googlemusic.play.activities:
//            PlayerActivity

class this._cls0
    implements android.widget.ChangeListener
{

    final PlayerActivity this$0;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        PlayerActivity.access$1000(PlayerActivity.this).time.setText(PlayerActivity.access$900(PlayerActivity.this, i));
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        if (PlayerActivity.access$000(PlayerActivity.this) != null)
        {
            PlayerActivity.access$000(PlayerActivity.this).seekTo(seekbar.getProgress());
        }
    }

    ewHolder()
    {
        this$0 = PlayerActivity.this;
        super();
    }
}
