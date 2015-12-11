// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

// Referenced classes of package com.gotv.crackle.views:
//            FanhattanVideoView

class this._cls0
    implements android.view.k
{

    final FanhattanVideoView this$0;

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        Log.i(FanhattanVideoView.access$000(FanhattanVideoView.this), "Surface has been changed.");
        FanhattanVideoView.access$1402(FanhattanVideoView.this, j);
        FanhattanVideoView.access$1502(FanhattanVideoView.this, k);
        if (FanhattanVideoView.access$1600(FanhattanVideoView.this) == 3)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (FanhattanVideoView.access$100(FanhattanVideoView.this) == j && FanhattanVideoView.access$200(FanhattanVideoView.this) == k)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (FanhattanVideoView.access$1100(FanhattanVideoView.this) != null && i != 0 && j != 0)
        {
            if (FanhattanVideoView.access$1200(FanhattanVideoView.this) != 0)
            {
                seekTo(FanhattanVideoView.access$1200(FanhattanVideoView.this));
            }
            start();
            if (FanhattanVideoView.access$900(FanhattanVideoView.this) == null);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Log.i(FanhattanVideoView.access$000(FanhattanVideoView.this), "Surface has been created.");
        this;
        JVM INSTR monitorenter ;
        if (surfaceholder == FanhattanVideoView.access$300(FanhattanVideoView.this).getHolder())
        {
            FanhattanVideoView.access$2402(FanhattanVideoView.this, surfaceholder);
        }
        if (surfaceholder == FanhattanVideoView.access$400(FanhattanVideoView.this).getHolder())
        {
            FanhattanVideoView.access$2502(FanhattanVideoView.this, surfaceholder);
        }
        if (FanhattanVideoView.access$2400(FanhattanVideoView.this) != null && FanhattanVideoView.access$2500(FanhattanVideoView.this) != null && FanhattanVideoView.access$2600(FanhattanVideoView.this) != null)
        {
            FanhattanVideoView.access$2700(FanhattanVideoView.this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        surfaceholder;
        this;
        JVM INSTR monitorexit ;
        throw surfaceholder;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        Log.i(FanhattanVideoView.access$000(FanhattanVideoView.this), "Surface has been destroyed.");
        FanhattanVideoView.access$2602(FanhattanVideoView.this, null);
        if (surfaceholder == FanhattanVideoView.access$300(FanhattanVideoView.this).getHolder())
        {
            FanhattanVideoView.access$2402(FanhattanVideoView.this, null);
        }
        if (surfaceholder == FanhattanVideoView.access$400(FanhattanVideoView.this).getHolder())
        {
            FanhattanVideoView.access$2502(FanhattanVideoView.this, null);
        }
        FanhattanVideoView.access$2800(FanhattanVideoView.this, true);
    }

    ()
    {
        this$0 = FanhattanVideoView.this;
        super();
    }
}
