// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.view.SurfaceHolder;
import android.widget.MediaController;

// Referenced classes of package co.vine.android.player:
//            OldSdkVideoView

class this._cls0
    implements android.view.back
{

    final OldSdkVideoView this$0;

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        OldSdkVideoView.access$1302(OldSdkVideoView.this, j);
        OldSdkVideoView.access$1402(OldSdkVideoView.this, k);
        if (OldSdkVideoView.access$1500(OldSdkVideoView.this) == 3)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (OldSdkVideoView.access$300(OldSdkVideoView.this) == j && OldSdkVideoView.access$400(OldSdkVideoView.this) == k)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (OldSdkVideoView.access$1000(OldSdkVideoView.this) != null && i != 0 && j != 0)
        {
            if (OldSdkVideoView.access$1200(OldSdkVideoView.this) != 0)
            {
                seekTo(OldSdkVideoView.access$1200(OldSdkVideoView.this));
            }
            start();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        OldSdkVideoView.access$2002(OldSdkVideoView.this, surfaceholder);
        OldSdkVideoView.access$2100(OldSdkVideoView.this);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        OldSdkVideoView.access$2002(OldSdkVideoView.this, null);
        if (OldSdkVideoView.access$1100(OldSdkVideoView.this) != null)
        {
            OldSdkVideoView.access$1100(OldSdkVideoView.this).hide();
        }
        OldSdkVideoView.access$2200(OldSdkVideoView.this, true);
    }

    ()
    {
        this$0 = OldSdkVideoView.this;
        super();
    }
}
