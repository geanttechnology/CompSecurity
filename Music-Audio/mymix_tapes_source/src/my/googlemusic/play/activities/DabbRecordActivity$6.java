// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.media.MediaPlayer;
import android.widget.ProgressBar;

// Referenced classes of package my.googlemusic.play.activities:
//            DabbRecordActivity

class this._cls0
    implements android.media.ionListener
{

    final DabbRecordActivity this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        DabbRecordActivity.access$400(DabbRecordActivity.this).recordingProgress.setProgress(DabbRecordActivity.access$1100(DabbRecordActivity.this));
        DabbRecordActivity.access$1202(DabbRecordActivity.this, System.currentTimeMillis());
        DabbRecordActivity.access$1300(DabbRecordActivity.this);
    }

    ewHolder()
    {
        this$0 = DabbRecordActivity.this;
        super();
    }
}
