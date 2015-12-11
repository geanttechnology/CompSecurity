// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.media.MediaPlayer;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.player:
//            OldSdkVideoView

class this._cls0
    implements android.media.aredListener
{

    final OldSdkVideoView this$0;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        SLog.d("Videoview prepared.");
        if (OldSdkVideoView.access$000(OldSdkVideoView.this))
        {
            mediaplayer.start();
        }
        mediaplayer.setLooping(OldSdkVideoView.access$100(OldSdkVideoView.this));
        if (OldSdkVideoView.access$200(OldSdkVideoView.this) != null)
        {
            OldSdkVideoView.access$200(OldSdkVideoView.this).onPrepared(OldSdkVideoView.this);
        }
    }

    .OnPreparedListener()
    {
        this$0 = OldSdkVideoView.this;
        super();
    }
}
