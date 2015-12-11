// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.view.View;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.player:
//            HasVideoPlayerAdapter, SdkVideoView

public class OnListVideoClickListener
    implements android.view.View.OnClickListener
{

    private final HasVideoPlayerAdapter mAdapter;
    private int mPosition;

    public OnListVideoClickListener(HasVideoPlayerAdapter hasvideoplayeradapter)
    {
        mAdapter = hasvideoplayeradapter;
    }

    public int getPosition()
    {
        return mPosition;
    }

    public void onClick(View view)
    {
label0:
        {
label1:
            {
                view = mAdapter.getPlayer(mPosition, false);
                if (mAdapter.getLastPlayer() != view)
                {
                    mAdapter.pauseCurrentPlayer();
                }
                if (view == null || !view.hasStarted())
                {
                    break label0;
                }
                if (SLog.sLogsOn)
                {
                    view.onViewClicked();
                }
                if (mPosition == view.getPlayingPosition())
                {
                    if (!view.isPaused() && view.isPlaying())
                    {
                        break label1;
                    }
                    resume(view);
                }
                return;
            }
            view.pause();
            return;
        }
        mAdapter.play(mPosition);
    }

    protected void resume(SdkVideoView sdkvideoview)
    {
        sdkvideoview.resume();
    }

    public void setPosition(int i)
    {
        mPosition = i;
    }
}
