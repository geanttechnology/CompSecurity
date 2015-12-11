// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.extras;

import android.content.Context;
import android.media.MediaPlayer;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import java.util.HashMap;

public class SoundPullEventListener
    implements com.handmark.pulltorefresh.library.PullToRefreshBase.OnPullEventListener
{

    private final Context mContext;
    private MediaPlayer mCurrentMediaPlayer;
    private final HashMap mSoundMap = new HashMap();

    public SoundPullEventListener(Context context)
    {
        mContext = context;
    }

    private void playSound(int i)
    {
        if (mCurrentMediaPlayer != null)
        {
            mCurrentMediaPlayer.stop();
            mCurrentMediaPlayer.release();
        }
        mCurrentMediaPlayer = MediaPlayer.create(mContext, i);
        if (mCurrentMediaPlayer != null)
        {
            mCurrentMediaPlayer.start();
        }
    }

    public void addSoundEvent(com.handmark.pulltorefresh.library.PullToRefreshBase.State state, int i)
    {
        mSoundMap.put(state, Integer.valueOf(i));
    }

    public void clearSounds()
    {
        mSoundMap.clear();
    }

    public MediaPlayer getCurrentMediaPlayer()
    {
        return mCurrentMediaPlayer;
    }

    public final void onPullEvent(PullToRefreshBase pulltorefreshbase, com.handmark.pulltorefresh.library.PullToRefreshBase.State state, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode)
    {
        pulltorefreshbase = (Integer)mSoundMap.get(state);
        if (pulltorefreshbase != null)
        {
            playSound(pulltorefreshbase.intValue());
        }
    }
}
