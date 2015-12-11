// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import com.gotv.crackle.util.Log;

// Referenced classes of package com.gotv.crackle.views:
//            CrackleVideoView

class this._cls0
    implements android.media.SizeChangedListener
{

    final CrackleVideoView this$0;

    public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
    {
        CrackleVideoView.access$002(CrackleVideoView.this, mediaplayer.getVideoWidth());
        CrackleVideoView.access$102(CrackleVideoView.this, mediaplayer.getVideoHeight());
        Log.i(CrackleVideoView.access$200(CrackleVideoView.this), (new StringBuilder()).append("OnVideoSizeChangedListener ").append(CrackleVideoView.access$000(CrackleVideoView.this)).append("x").append(CrackleVideoView.access$100(CrackleVideoView.this)).toString());
        if (CrackleVideoView.access$000(CrackleVideoView.this) != 0 && CrackleVideoView.access$100(CrackleVideoView.this) != 0)
        {
            getHolder().setFixedSize(CrackleVideoView.access$000(CrackleVideoView.this), CrackleVideoView.access$100(CrackleVideoView.this));
        }
    }

    edListener()
    {
        this$0 = CrackleVideoView.this;
        super();
    }
}
