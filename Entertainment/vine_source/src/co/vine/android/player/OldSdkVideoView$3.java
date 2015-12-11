// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.widget.MediaController;

// Referenced classes of package co.vine.android.player:
//            OldSdkVideoView

class this._cls0
    implements android.media.aredListener
{

    final OldSdkVideoView this$0;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        int i;
        OldSdkVideoView.access$502(OldSdkVideoView.this, 2);
        OldSdkVideoView.access$602(OldSdkVideoView.this, OldSdkVideoView.access$702(OldSdkVideoView.this, OldSdkVideoView.access$802(OldSdkVideoView.this, true)));
        if (OldSdkVideoView.access$900(OldSdkVideoView.this) != null)
        {
            OldSdkVideoView.access$900(OldSdkVideoView.this).onPrepared(OldSdkVideoView.access$1000(OldSdkVideoView.this));
        }
        if (OldSdkVideoView.access$1100(OldSdkVideoView.this) != null)
        {
            OldSdkVideoView.access$1100(OldSdkVideoView.this).setEnabled(true);
        }
        OldSdkVideoView.access$302(OldSdkVideoView.this, mediaplayer.getVideoWidth());
        OldSdkVideoView.access$402(OldSdkVideoView.this, mediaplayer.getVideoHeight());
        i = OldSdkVideoView.access$1200(OldSdkVideoView.this);
        if (i != 0)
        {
            seekTo(i);
        }
        if (OldSdkVideoView.access$300(OldSdkVideoView.this) == 0 || OldSdkVideoView.access$400(OldSdkVideoView.this) == 0) goto _L2; else goto _L1
_L1:
        getHolder().setFixedSize(OldSdkVideoView.access$300(OldSdkVideoView.this), OldSdkVideoView.access$400(OldSdkVideoView.this));
        if (OldSdkVideoView.access$1300(OldSdkVideoView.this) != OldSdkVideoView.access$300(OldSdkVideoView.this) || OldSdkVideoView.access$1400(OldSdkVideoView.this) != OldSdkVideoView.access$400(OldSdkVideoView.this)) goto _L4; else goto _L3
_L3:
        if (OldSdkVideoView.access$1500(OldSdkVideoView.this) != 3) goto _L6; else goto _L5
_L5:
        start();
        if (OldSdkVideoView.access$1100(OldSdkVideoView.this) != null)
        {
            OldSdkVideoView.access$1100(OldSdkVideoView.this).show();
        }
_L4:
        return;
_L6:
        if (!isPlaying() && (i != 0 || getCurrentPosition() > 0) && OldSdkVideoView.access$1100(OldSdkVideoView.this) != null)
        {
            OldSdkVideoView.access$1100(OldSdkVideoView.this).show(0);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (OldSdkVideoView.access$1500(OldSdkVideoView.this) == 3)
        {
            start();
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    ner()
    {
        this$0 = OldSdkVideoView.this;
        super();
    }
}
