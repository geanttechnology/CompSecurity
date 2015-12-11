// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.view.SurfaceHolder;
import android.widget.MediaController;
import com.gotv.crackle.util.Log;

// Referenced classes of package com.gotv.crackle.views:
//            CrackleVideoView

class this._cls0
    implements android.view.ack
{

    final CrackleVideoView this$0;

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        CrackleVideoView.access$1102(CrackleVideoView.this, j);
        CrackleVideoView.access$1202(CrackleVideoView.this, k);
        if (CrackleVideoView.access$1300(CrackleVideoView.this) == 3)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (CrackleVideoView.access$000(CrackleVideoView.this) == j && CrackleVideoView.access$100(CrackleVideoView.this) == k)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (CrackleVideoView.access$800(CrackleVideoView.this) != null && i != 0 && j != 0)
        {
            if (CrackleVideoView.access$1000(CrackleVideoView.this) != 0)
            {
                seekTo(CrackleVideoView.access$1000(CrackleVideoView.this));
            }
            Log.d(CrackleVideoView.access$200(CrackleVideoView.this), "surfaceChanged : calling start");
            start();
            if (CrackleVideoView.access$900(CrackleVideoView.this) != null)
            {
                if (CrackleVideoView.access$900(CrackleVideoView.this).isShowing())
                {
                    CrackleVideoView.access$900(CrackleVideoView.this).hide();
                }
                CrackleVideoView.access$900(CrackleVideoView.this).show();
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Log.d(CrackleVideoView.access$200(CrackleVideoView.this), (new StringBuilder()).append("surfaceCreated : state ").append(CrackleVideoView.access$300(CrackleVideoView.this)).append(" mMediaPlayer = ").append(CrackleVideoView.access$800(CrackleVideoView.this)).toString());
        CrackleVideoView.access$1602(CrackleVideoView.this, surfaceholder);
        if (CrackleVideoView.access$800(CrackleVideoView.this) == null && CrackleVideoView.access$300(CrackleVideoView.this) == 0)
        {
            CrackleVideoView.access$1700(CrackleVideoView.this);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        Log.d(CrackleVideoView.access$200(CrackleVideoView.this), (new StringBuilder()).append("surfaceDestroyed : state ").append(CrackleVideoView.access$300(CrackleVideoView.this)).toString());
        CrackleVideoView.access$1602(CrackleVideoView.this, null);
        if (CrackleVideoView.access$900(CrackleVideoView.this) != null)
        {
            CrackleVideoView.access$900(CrackleVideoView.this).hide();
        }
        if (CrackleVideoView.access$300(CrackleVideoView.this) != 6)
        {
            release(true);
        }
    }

    ()
    {
        this$0 = CrackleVideoView.this;
        super();
    }
}
