// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.os.Handler;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder, RecordSession

class this._cls0
    implements Runnable
{

    final VineRecorder this$0;

    public void run()
    {
        if (mSession != null && mSession.getConfig() != null && (double)mCurrentDuration < (double)mSession.getConfig().maxDuration * 0.94999999999999996D)
        {
            doOneFrame();
            mHandler.postDelayed(this, (long)VineRecorder.access$2100(VineRecorder.this));
        }
    }

    s.RecordConfig()
    {
        this$0 = VineRecorder.this;
        super();
    }
}
