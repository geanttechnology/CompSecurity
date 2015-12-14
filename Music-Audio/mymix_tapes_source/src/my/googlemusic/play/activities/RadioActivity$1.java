// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageButton;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.interfaces.Server;

// Referenced classes of package my.googlemusic.play.activities:
//            RadioActivity

class this._cls0 extends BroadcastReceiver
{

    final RadioActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("EXTRAS");
        if (context != null)
        {
            if (context.equals("MUSIC PREPARED"))
            {
                RadioActivity.access$000(RadioActivity.this);
            } else
            {
                if (context.equals("MUSIC BUFFERING"))
                {
                    RadioActivity.access$100(RadioActivity.this, Integer.valueOf(intent.getStringExtra("EXTRAS ADDITIONAL")).intValue());
                    return;
                }
                if (context.equals("MUSIC CHANGED"))
                {
                    RadioActivity.access$200(RadioActivity.this);
                    return;
                }
                if (context.equals("MUSIC PLAYING"))
                {
                    RadioActivity.access$300(RadioActivity.this);
                    return;
                }
                if (context.equals("MUSIC PAUSED"))
                {
                    RadioActivity.access$400(RadioActivity.this);
                    return;
                }
                if (context.equals("DOWNLOAD FINISHED") && RadioActivity.access$500(RadioActivity.this) != null && RadioActivity.access$600(RadioActivity.this).isDownloadFinished(RadioActivity.access$500(RadioActivity.this).getCurrentSong()))
                {
                    RadioActivity.access$700(RadioActivity.this).download.setImageResource(0x7f02008e);
                    return;
                }
            }
        }
    }

    ewHolder()
    {
        this$0 = RadioActivity.this;
        super();
    }
}
