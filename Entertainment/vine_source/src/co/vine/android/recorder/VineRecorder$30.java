// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class s
    implements Runnable
{

    final VineRecorder this$0;
    final android.widget.ayoutParams val$bottomMaskParams;
    final android.widget.ayoutParams val$cameraViewParams;

    public void run()
    {
        View view = mCameraView;
        if (view != null)
        {
            SLog.d("Setting preview sizes to {} {}.", Integer.valueOf(val$cameraViewParams.width), Integer.valueOf(val$cameraViewParams.height));
            view.setLayoutParams(val$cameraViewParams);
        }
        view = mBottomMaskView;
        if (view != null)
        {
            view.setLayoutParams(val$bottomMaskParams);
        }
    }

    s()
    {
        this$0 = final_vinerecorder;
        val$cameraViewParams = ayoutparams;
        val$bottomMaskParams = android.widget.ayoutParams.this;
        super();
    }
}
