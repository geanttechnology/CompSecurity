// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia.internal.video:
//            MMVideoView

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        MMVideoView.access$700(_fld0).onReadyToStart(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/video/MMVideoView$1

/* anonymous class */
    class MMVideoView._cls1
        implements android.view.SurfaceHolder.Callback
    {

        final MMVideoView this$0;

        public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
        {
            if (MMVideoView.access$400(MMVideoView.this) != null && MMVideoView.access$800(MMVideoView.this) == 4)
            {
                start();
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceholder)
        {
            MMVideoView.access$302(MMVideoView.this, surfaceholder);
            if (MMVideoView.access$400(MMVideoView.this) != null)
            {
                MMVideoView.access$400(MMVideoView.this).setDisplay(MMVideoView.access$300(MMVideoView.this));
            }
            if (MMVideoView.access$500(MMVideoView.this) == 2)
            {
                MMVideoView.access$600(MMVideoView.this);
                MMVideoView.access$502(MMVideoView.this, 3);
                if (MMVideoView.access$100(MMVideoView.this) != 0 && MMVideoView.access$200(MMVideoView.this) != 0)
                {
                    MMVideoView.access$300(MMVideoView.this).setFixedSize(MMVideoView.access$100(MMVideoView.this), MMVideoView.access$200(MMVideoView.this));
                }
                if (MMVideoView.access$700(MMVideoView.this) != null && MMVideoView.access$800(MMVideoView.this) != 4)
                {
                    ThreadUtils.runOnWorkerThread(new MMVideoView._cls1._cls1());
                }
                if (MMVideoView.access$800(MMVideoView.this) == 4)
                {
                    start();
                }
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceholder)
        {
            MMVideoView.access$302(MMVideoView.this, null);
            if (MMVideoView.access$400(MMVideoView.this) != null)
            {
                MMVideoView.access$400(MMVideoView.this).setDisplay(null);
            }
        }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
    }

}
