// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.ProgressBar;

// Referenced classes of package my.googlemusic.play.activities:
//            DabbRecordActivity

class this._cls0
    implements Runnable
{

    final DabbRecordActivity this$0;

    public void run()
    {
        if (DabbRecordActivity.access$300(DabbRecordActivity.this) != null && DabbRecordActivity.access$300(DabbRecordActivity.this).isPlaying())
        {
            DabbRecordActivity.access$400(DabbRecordActivity.this).recordingProgress.setProgress(DabbRecordActivity.access$300(DabbRecordActivity.this).getCurrentPosition());
        }
        DabbRecordActivity.access$500(DabbRecordActivity.this).postDelayed(this, 100L);
    }

    ewHolder()
    {
        this$0 = DabbRecordActivity.this;
        super();
    }
}
