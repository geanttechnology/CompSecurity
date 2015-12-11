// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;

// Referenced classes of package co.vine.android.recorder:
//            InlineVineRecorder

class val.cameraViewParams
    implements Runnable
{

    final InlineVineRecorder this$0;
    final android.widget.Params val$cameraViewParams;
    final android.widget.Params val$topMaskParams;

    public void run()
    {
        View view = mTopMaskView;
        if (view != null)
        {
            view.setLayoutParams(val$topMaskParams);
        }
        view = mCameraView;
        if (view != null)
        {
            view.setLayoutParams(val$cameraViewParams);
        }
    }

    ()
    {
        this$0 = final_inlinevinerecorder;
        val$topMaskParams = params;
        val$cameraViewParams = android.widget.Params.this;
        super();
    }
}
