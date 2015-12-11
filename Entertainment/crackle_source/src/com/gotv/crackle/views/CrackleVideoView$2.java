// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.widget.MediaController;
import com.gotv.crackle.util.Log;

// Referenced classes of package com.gotv.crackle.views:
//            CrackleVideoView

class this._cls0
    implements android.media.redListener
{

    final CrackleVideoView this$0;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        int i;
        Log.d(CrackleVideoView.access$200(CrackleVideoView.this), "onPrepared");
        CrackleVideoView.access$302(CrackleVideoView.this, 2);
        CrackleVideoView.access$402(CrackleVideoView.this, CrackleVideoView.access$502(CrackleVideoView.this, CrackleVideoView.access$602(CrackleVideoView.this, true)));
        if (CrackleVideoView.access$700(CrackleVideoView.this) != null)
        {
            CrackleVideoView.access$700(CrackleVideoView.this).onPrepared(CrackleVideoView.access$800(CrackleVideoView.this));
        }
        if (CrackleVideoView.access$900(CrackleVideoView.this) != null)
        {
            CrackleVideoView.access$900(CrackleVideoView.this).setEnabled(true);
        }
        CrackleVideoView.access$002(CrackleVideoView.this, mediaplayer.getVideoWidth());
        CrackleVideoView.access$102(CrackleVideoView.this, mediaplayer.getVideoHeight());
        Log.i(CrackleVideoView.access$200(CrackleVideoView.this), (new StringBuilder()).append("OnPreparedListener ").append(CrackleVideoView.access$000(CrackleVideoView.this)).append("x").append(CrackleVideoView.access$100(CrackleVideoView.this)).toString());
        i = CrackleVideoView.access$1000(CrackleVideoView.this);
        if (i != 0)
        {
            seekTo(i);
        }
        if (CrackleVideoView.access$000(CrackleVideoView.this) == 0 || CrackleVideoView.access$100(CrackleVideoView.this) == 0) goto _L2; else goto _L1
_L1:
        getHolder().setFixedSize(CrackleVideoView.access$000(CrackleVideoView.this), CrackleVideoView.access$100(CrackleVideoView.this));
        if (CrackleVideoView.access$1100(CrackleVideoView.this) != CrackleVideoView.access$000(CrackleVideoView.this) || CrackleVideoView.access$1200(CrackleVideoView.this) != CrackleVideoView.access$100(CrackleVideoView.this)) goto _L4; else goto _L3
_L3:
        if (CrackleVideoView.access$1300(CrackleVideoView.this) != 3) goto _L6; else goto _L5
_L5:
        start();
        if (CrackleVideoView.access$900(CrackleVideoView.this) != null)
        {
            CrackleVideoView.access$900(CrackleVideoView.this).show();
        }
_L4:
        return;
_L6:
        if (!isPlaying() && (i != 0 || getCurrentPosition() > 0) && CrackleVideoView.access$900(CrackleVideoView.this) != null)
        {
            CrackleVideoView.access$900(CrackleVideoView.this).show(0);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (CrackleVideoView.access$1300(CrackleVideoView.this) == 3)
        {
            start();
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    er()
    {
        this$0 = CrackleVideoView.this;
        super();
    }
}
