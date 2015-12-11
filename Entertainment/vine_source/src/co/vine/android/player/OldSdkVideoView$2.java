// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;

// Referenced classes of package co.vine.android.player:
//            OldSdkVideoView

class this._cls0
    implements android.media.oSizeChangedListener
{

    final OldSdkVideoView this$0;

    public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
    {
        OldSdkVideoView.access$302(OldSdkVideoView.this, mediaplayer.getVideoWidth());
        OldSdkVideoView.access$402(OldSdkVideoView.this, mediaplayer.getVideoHeight());
        if (OldSdkVideoView.access$300(OldSdkVideoView.this) != 0 && OldSdkVideoView.access$400(OldSdkVideoView.this) != 0)
        {
            getHolder().setFixedSize(OldSdkVideoView.access$300(OldSdkVideoView.this), OldSdkVideoView.access$400(OldSdkVideoView.this));
            requestLayout();
        }
    }

    gedListener()
    {
        this$0 = OldSdkVideoView.this;
        super();
    }
}
