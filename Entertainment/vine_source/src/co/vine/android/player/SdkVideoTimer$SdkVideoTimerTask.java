// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.os.Handler;
import com.edisonwang.android.slog.SLog;
import java.util.TimerTask;

// Referenced classes of package co.vine.android.player:
//            SdkVideoTimer, SdkVideoView

private static class mController extends TimerTask
    implements Runnable
{

    private final Controller mController;
    private final Handler mHandler = new Handler();

    public void run()
    {
        SdkVideoView sdkvideoview;
        sdkvideoview = mController.getLastPlayer();
        if (sdkvideoview == null || !sdkvideoview.isInPlaybackState())
        {
            break MISSING_BLOCK_LABEL_79;
        }
        int i = sdkvideoview.getDuration();
        if (i < 0)
        {
            return;
        }
        if (sdkvideoview.getCurrentPosition() <= 0 || i - sdkvideoview.getCurrentPosition() >= 250)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        SLog.d("Restart.");
        mHandler.post(new Runnable() {

            final SdkVideoTimer.SdkVideoTimerTask this$0;

            public void run()
            {
                SdkVideoView sdkvideoview1 = mController.getLastPlayer();
                if (sdkvideoview1 != null && sdkvideoview1.getVisibility() != 0)
                {
                    sdkvideoview1.setVisibility(0);
                }
            }

            
            {
                this$0 = SdkVideoTimer.SdkVideoTimerTask.this;
                super();
            }
        });
        try
        {
            sdkvideoview.restart();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
        IllegalStateException illegalstateexception;
        illegalstateexception;
    }


    public Controller(Controller controller)
    {
        mController = controller;
    }
}
