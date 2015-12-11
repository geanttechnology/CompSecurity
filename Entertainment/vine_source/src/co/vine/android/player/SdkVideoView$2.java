// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;

// Referenced classes of package co.vine.android.player:
//            SdkVideoView

class this._cls0
    implements Runnable
{

    final SdkVideoView this$0;

    public void run()
    {
        boolean flag1;
label0:
        {
            flag1 = false;
            synchronized (SdkVideoView.access$200())
            {
                SdkVideoView.access$302(SdkVideoView.this);
                if (SdkVideoView.access$400(SdkVideoView.this) != null)
                {
                    break label0;
                }
                Log.d(SdkVideoView.access$500(), "mUri  is not ready yet.");
            }
            return;
        }
        if (SdkVideoView.access$600(SdkVideoView.this) != null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        boolean flag = flag1;
        if (!SdkVideoView.access$700(SdkVideoView.this))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        flag = flag1;
        if (getVisibility() != 0)
        {
            flag = true;
        }
        Log.d(SdkVideoView.access$500(), (new StringBuilder()).append("Surface is not ready yet, will autoshow ? ").append(SdkVideoView.access$700(SdkVideoView.this)).append(" & ").append(getVisibility()).toString());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        setVisibility(0);
        ai;
        JVM INSTR monitorexit ;
        return;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
        Log.d(SdkVideoView.access$500(), (new StringBuilder()).append("Opening video: ").append(SdkVideoView.access$400(SdkVideoView.this)).toString());
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        SdkVideoView.access$800(SdkVideoView.this).sendBroadcast(intent);
        SdkVideoView.access$900(SdkVideoView.this, false);
        if (!SdkVideoView.access$1000())
        {
            break MISSING_BLOCK_LABEL_279;
        }
        SdkVideoView.access$1100(SdkVideoView.this);
        if (SdkVideoView.access$600(SdkVideoView.this).isValid())
        {
            SdkVideoView.access$1300(SdkVideoView.this).sendMessage(SdkVideoView.access$1200(SdkVideoView.this), MediaCodecVideoTrackRenderer.MSG_SET_SURFACE, SdkVideoView.access$600(SdkVideoView.this));
        }
_L2:
        SdkVideoView.access$1502(SdkVideoView.this, null);
        ai;
        JVM INSTR monitorexit ;
        return;
        SdkVideoView.access$1400(SdkVideoView.this);
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
        this$0 = SdkVideoView.this;
        super();
    }
}
