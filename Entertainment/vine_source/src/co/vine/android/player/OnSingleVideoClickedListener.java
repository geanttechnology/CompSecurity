// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.view.View;
import com.edisonwang.android.slog.SLog;
import java.lang.ref.WeakReference;

// Referenced classes of package co.vine.android.player:
//            VideoViewInterface

public class OnSingleVideoClickedListener
    implements android.view.View.OnClickListener
{

    private int mState;
    private final WeakReference mViewPlayer;

    public OnSingleVideoClickedListener(VideoViewInterface videoviewinterface)
    {
        mViewPlayer = new WeakReference(videoviewinterface);
    }

    public void onClick()
    {
        VideoViewInterface videoviewinterface = (VideoViewInterface)mViewPlayer.get();
        if (videoviewinterface != null && videoviewinterface.hasStarted())
        {
            SLog.d("Change player state.");
            if (videoviewinterface.isPaused())
            {
                videoviewinterface.resume();
                mState = 1;
                return;
            } else
            {
                videoviewinterface.pause();
                mState = 0;
                return;
            }
        } else
        {
            SLog.d("Ignore because it is not in playing state.");
            mState = -1;
            return;
        }
    }

    public void onClick(View view)
    {
        onClick();
    }
}
