// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import com.millennialmedia.internal.utils.ThreadUtils;

// Referenced classes of package com.millennialmedia.internal.video:
//            MMVideoView

private class <init>
    implements Runnable
{

    final MMVideoView this$0;

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        if (MMVideoView.access$500(MMVideoView.this) != 4)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        ThreadUtils.runOnWorkerThread(new Runnable() {

            final MMVideoView.ProgressRunnable this$1;

            public void run()
            {
                if (MMVideoView.access$700(this$0) != null)
                {
                    MMVideoView.access$700(this$0).onProgress(this$0, getCurrentPosition());
                }
                if (MMVideoView.access$900(this$0) != null)
                {
                    MMVideoView.access$900(this$0).onProgress(getCurrentPosition());
                }
                MMVideoView.access$1002(this$0, ThreadUtils.runOnWorkerThreadDelayed(new MMVideoView.ProgressRunnable(null), 100L));
            }

            
            {
                this$1 = MMVideoView.ProgressRunnable.this;
                super();
            }
        });
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        MMVideoView.access$1002(MMVideoView.this, null);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private _cls1.this._cls1()
    {
        this$0 = MMVideoView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
