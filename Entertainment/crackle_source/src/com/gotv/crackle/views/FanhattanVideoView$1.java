// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

// Referenced classes of package com.gotv.crackle.views:
//            FanhattanVideoView

class this._cls0
    implements android.media.zeChangedListener
{

    final FanhattanVideoView this$0;

    public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
    {
        Log.i(FanhattanVideoView.access$000(FanhattanVideoView.this), (new StringBuilder()).append("OnVideoSizeChanged to width/height: ").append(i).append("/").append(j).toString());
        FanhattanVideoView.access$102(FanhattanVideoView.this, mediaplayer.getVideoWidth() % 0x186a0);
        FanhattanVideoView.access$202(FanhattanVideoView.this, mediaplayer.getVideoHeight());
        Log.i(FanhattanVideoView.access$000(FanhattanVideoView.this), (new StringBuilder()).append("OnVideoSizeChanged to mVideoWidth/mVideoHeight: ").append(FanhattanVideoView.access$100(FanhattanVideoView.this)).append("/").append(FanhattanVideoView.access$200(FanhattanVideoView.this)).toString());
        i %= 0x186a0;
        int k = i / 0x186a0;
        Log.i(FanhattanVideoView.access$000(FanhattanVideoView.this), (new StringBuilder()).append("OnVideoSizeChanged viewIndex: ").append(k).toString());
        if (i != 0 && j != 0)
        {
            if (k == 0)
            {
                FanhattanVideoView.access$300(FanhattanVideoView.this).getHolder().setFixedSize(FanhattanVideoView.access$100(FanhattanVideoView.this), FanhattanVideoView.access$200(FanhattanVideoView.this));
            } else
            {
                FanhattanVideoView.access$400(FanhattanVideoView.this).getHolder().setFixedSize(FanhattanVideoView.access$100(FanhattanVideoView.this), FanhattanVideoView.access$200(FanhattanVideoView.this));
            }
        }
        if (FanhattanVideoView.access$500(FanhattanVideoView.this) != null)
        {
            FanhattanVideoView.access$500(FanhattanVideoView.this).onVideoSizeChanged(mediaplayer, i, j);
        }
    }

    Listener()
    {
        this$0 = FanhattanVideoView.this;
        super();
    }
}
