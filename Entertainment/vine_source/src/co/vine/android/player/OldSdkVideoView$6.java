// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.media.MediaPlayer;
import android.widget.MediaController;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.player:
//            OldSdkVideoView

class this._cls0
    implements android.media.rListener
{

    final OldSdkVideoView this$0;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        SLog.d((new StringBuilder()).append("Error: ").append(i).append(",").append(j).toString());
        OldSdkVideoView.access$502(OldSdkVideoView.this, -1);
        OldSdkVideoView.access$1502(OldSdkVideoView.this, -1);
        if (OldSdkVideoView.access$1100(OldSdkVideoView.this) != null)
        {
            OldSdkVideoView.access$1100(OldSdkVideoView.this).hide();
        }
        if (OldSdkVideoView.access$1800(OldSdkVideoView.this) != null && OldSdkVideoView.access$1800(OldSdkVideoView.this).onError(OldSdkVideoView.this, i, j))
        {
            return true;
        } else
        {
            SLog.e("Cannot play this video.");
            return true;
        }
    }

    .OnErrorListener()
    {
        this$0 = OldSdkVideoView.this;
        super();
    }
}
