// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.view.View;
import java.util.HashSet;

// Referenced classes of package co.vine.android.player:
//            SensitiveImageClickListener, HasVideoPlayerAdapter, SdkVideoView

public class VideoSensitiveImageClickListener extends SensitiveImageClickListener
{

    private HasVideoPlayerAdapter mAdapter;

    public VideoSensitiveImageClickListener(HasVideoPlayerAdapter hasvideoplayeradapter, HashSet hashset)
    {
        super(hashset);
        mAdapter = hasvideoplayeradapter;
    }

    public void onClick(View view)
    {
        view = mAdapter.getPlayer(mPosition, false);
        if (mAdapter.getLastPlayer() != view)
        {
            mAdapter.pauseCurrentPlayer();
        }
        if (view != null && view.hasStarted())
        {
            if (mPosition == view.getPlayingPosition())
            {
                if (view.isPaused())
                {
                    view.resume();
                    return;
                } else
                {
                    view.pause();
                    return;
                }
            } else
            {
                mExplicitDismissed.add(Integer.valueOf(mPosition));
                mAdapter.playFile(mPosition, false);
                return;
            }
        } else
        {
            mExplicitDismissed.add(Integer.valueOf(mPosition));
            mAdapter.play(mPosition);
            return;
        }
    }
}
