// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.MediaController;

// Referenced classes of package com.gotv.crackle.views:
//            FanhattanVideoView

class this._cls0
    implements android.media.dListener
{

    final FanhattanVideoView this$0;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        int i;
        Log.i(FanhattanVideoView.access$000(FanhattanVideoView.this), "OnPrepared.");
        FanhattanVideoView.access$602(FanhattanVideoView.this, 2);
        FanhattanVideoView.access$702(FanhattanVideoView.this, FanhattanVideoView.access$802(FanhattanVideoView.this, true));
        if (FanhattanVideoView.access$900(FanhattanVideoView.this) != null)
        {
            FanhattanVideoView.access$900(FanhattanVideoView.this).setEnabled(true);
        }
        if (FanhattanVideoView.access$1000(FanhattanVideoView.this) != null)
        {
            FanhattanVideoView.access$1000(FanhattanVideoView.this).onPrepared(FanhattanVideoView.access$1100(FanhattanVideoView.this));
        }
        FanhattanVideoView.access$102(FanhattanVideoView.this, mediaplayer.getVideoWidth());
        FanhattanVideoView.access$202(FanhattanVideoView.this, mediaplayer.getVideoHeight());
        i = FanhattanVideoView.access$1200(FanhattanVideoView.this);
        if (i != 0)
        {
            seekTo(i);
        }
        if (FanhattanVideoView.access$100(FanhattanVideoView.this) == 0 || FanhattanVideoView.access$200(FanhattanVideoView.this) == 0) goto _L2; else goto _L1
_L1:
        FanhattanVideoView.access$1300(FanhattanVideoView.this).getHolder().setFixedSize(FanhattanVideoView.access$100(FanhattanVideoView.this), FanhattanVideoView.access$200(FanhattanVideoView.this));
        if (FanhattanVideoView.access$1400(FanhattanVideoView.this) != FanhattanVideoView.access$100(FanhattanVideoView.this) || FanhattanVideoView.access$1500(FanhattanVideoView.this) != FanhattanVideoView.access$200(FanhattanVideoView.this)) goto _L4; else goto _L3
_L3:
        if (FanhattanVideoView.access$1600(FanhattanVideoView.this) != 3) goto _L6; else goto _L5
_L5:
        start();
        if (FanhattanVideoView.access$900(FanhattanVideoView.this) == null);
_L4:
        return;
_L6:
        if (!isPlaying() && (i != 0 || getCurrentPosition() > 0) && FanhattanVideoView.access$900(FanhattanVideoView.this) != null)
        {
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (FanhattanVideoView.access$1600(FanhattanVideoView.this) == 3)
        {
            start();
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    ()
    {
        this$0 = FanhattanVideoView.this;
        super();
    }
}
