// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.os.Handler;
import com.edisonwang.android.slog.SLog;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package co.vine.android.player:
//            SdkVideoView

public class SdkVideoTimer
{
    public static interface HasVideoPlayerViewController
    {

        public abstract SdkVideoView getLastPlayer();
    }

    private static class SdkVideoTimerTask extends TimerTask
        implements Runnable
    {

        private final HasVideoPlayerViewController mController;
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

                final SdkVideoTimerTask this$0;

                public void run()
                {
                    SdkVideoView sdkvideoview = mController.getLastPlayer();
                    if (sdkvideoview != null && sdkvideoview.getVisibility() != 0)
                    {
                        sdkvideoview.setVisibility(0);
                    }
                }

            
            {
                this$0 = SdkVideoTimerTask.this;
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


        public SdkVideoTimerTask(HasVideoPlayerViewController hasvideoplayerviewcontroller)
        {
            mController = hasvideoplayerviewcontroller;
        }
    }


    public static final int INTERVAL = 50;
    public static final int TAIL_CUT = 250;
    private final Timer mTimer = new Timer("VideoTimer");

    public SdkVideoTimer()
    {
    }

    public void release()
    {
        mTimer.cancel();
        mTimer.purge();
    }

    public void start(HasVideoPlayerViewController hasvideoplayerviewcontroller)
    {
        mTimer.schedule(new SdkVideoTimerTask(hasvideoplayerviewcontroller), 10L, 50L);
    }
}
