// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.temporal;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.widget.MediaController;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.renderers.temporal:
//            VideoAdView, VideoRenderer

class this._cls0
    implements android.media.PreparedListener
{

    final VideoAdView this$0;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        int i;
        VideoAdView.access$000(VideoAdView.this).debug("OnPrepared");
        VideoAdView.access$102(VideoAdView.this, 2);
        if (VideoAdView.access$500(VideoAdView.this))
        {
            VideoAdView.access$400(VideoAdView.this).onAdViewLoaded();
            return;
        }
        i = VideoAdView.access$600(VideoAdView.this);
        if (i != 0)
        {
            seekTo(i);
        }
        if (VideoAdView.access$300(VideoAdView.this) != null)
        {
            VideoAdView.access$300(VideoAdView.this).setEnabled(true);
        }
        VideoAdView.access$702(VideoAdView.this, mediaplayer.getVideoWidth());
        VideoAdView.access$802(VideoAdView.this, mediaplayer.getVideoHeight());
        VideoAdView.access$000(VideoAdView.this).debug((new StringBuilder()).append("videoWidth: ").append(VideoAdView.access$700(VideoAdView.this)).append(", videoHeight: ").append(VideoAdView.access$800(VideoAdView.this)).toString());
        if (VideoAdView.access$700(VideoAdView.this) == 0 || VideoAdView.access$800(VideoAdView.this) == 0) goto _L2; else goto _L1
_L1:
        getHolder().setFixedSize(VideoAdView.access$700(VideoAdView.this), VideoAdView.access$800(VideoAdView.this));
        if (VideoAdView.access$900(VideoAdView.this) != VideoAdView.access$700(VideoAdView.this) || VideoAdView.access$1000(VideoAdView.this) != VideoAdView.access$800(VideoAdView.this)) goto _L4; else goto _L3
_L3:
        if (VideoAdView.access$200(VideoAdView.this) != 3) goto _L6; else goto _L5
_L5:
        start();
        if (VideoAdView.access$300(VideoAdView.this) != null)
        {
            VideoAdView.access$300(VideoAdView.this).show();
        }
_L4:
        VideoAdView.access$400(VideoAdView.this).onAdViewMediaPrepared();
        return;
_L6:
        if (!isInPlaybackState() && !VideoAdView.access$1100(VideoAdView.this).isPlaying() && (i != 0 || getPlayheadTime() > 0.0D) && VideoAdView.access$300(VideoAdView.this) != null)
        {
            VideoAdView.access$300(VideoAdView.this).show(0);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (VideoAdView.access$200(VideoAdView.this) == 3)
        {
            start();
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    ()
    {
        this$0 = VideoAdView.this;
        super();
    }
}
