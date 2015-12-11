// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import com.conviva.ConvivaContentInfo;
import com.conviva.LivePass;
import com.gotv.crackle.Application;
import com.gotv.crackle.VideoPlayerActivity;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CrackleVideoView extends SurfaceView
    implements android.widget.MediaController.MediaPlayerControl
{

    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private static final int STATE_RESUME = 7;
    private static final int STATE_SUSPEND = 6;
    private static final int STATE_SUSPEND_UNSUPPORTED = 8;
    private String TAG;
    private android.media.MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new android.media.MediaPlayer.OnBufferingUpdateListener() {

        final CrackleVideoView this$0;

        public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
        {
            mCurrentBufferPercentage = i;
        }

            
            {
                this$0 = CrackleVideoView.this;
                super();
            }
    };
    private boolean mCanPause;
    private boolean mCanSeekBack;
    private boolean mCanSeekForward;
    private android.media.MediaPlayer.OnCompletionListener mCompletionListener = new android.media.MediaPlayer.OnCompletionListener() {

        final CrackleVideoView this$0;

        public void onCompletion(MediaPlayer mediaplayer)
        {
            mCurrentState = 5;
            mTargetState = 5;
            if (mMediaController != null)
            {
                mMediaController.hide();
            }
            if (mOnCompletionListener != null)
            {
                mOnCompletionListener.onCompletion(mMediaPlayer);
            }
        }

            
            {
                this$0 = CrackleVideoView.this;
                super();
            }
    };
    private int mCurrentBufferPercentage;
    private int mCurrentState;
    private int mDuration;
    private android.media.MediaPlayer.OnErrorListener mErrorListener;
    private MediaController mMediaController;
    private MediaPlayer mMediaPlayer;
    private android.media.MediaPlayer.OnCompletionListener mOnCompletionListener;
    private android.media.MediaPlayer.OnPreparedListener mOnPreparedListener;
    android.media.MediaPlayer.OnPreparedListener mPreparedListener = new android.media.MediaPlayer.OnPreparedListener() {

        final CrackleVideoView this$0;

        public void onPrepared(MediaPlayer mediaplayer)
        {
            int i;
            Log.d(TAG, "onPrepared");
            mCurrentState = 2;
            mCanPause = mCanSeekBack = mCanSeekForward = true;
            if (mOnPreparedListener != null)
            {
                mOnPreparedListener.onPrepared(mMediaPlayer);
            }
            if (mMediaController != null)
            {
                mMediaController.setEnabled(true);
            }
            mVideoWidth = mediaplayer.getVideoWidth();
            mVideoHeight = mediaplayer.getVideoHeight();
            Log.i(TAG, (new StringBuilder()).append("OnPreparedListener ").append(mVideoWidth).append("x").append(mVideoHeight).toString());
            i = mSeekWhenPrepared;
            if (i != 0)
            {
                seekTo(i);
            }
            if (mVideoWidth == 0 || mVideoHeight == 0) goto _L2; else goto _L1
_L1:
            getHolder().setFixedSize(mVideoWidth, mVideoHeight);
            if (mSurfaceWidth != mVideoWidth || mSurfaceHeight != mVideoHeight) goto _L4; else goto _L3
_L3:
            if (mTargetState != 3) goto _L6; else goto _L5
_L5:
            start();
            if (mMediaController != null)
            {
                mMediaController.show();
            }
_L4:
            return;
_L6:
            if (!isPlaying() && (i != 0 || getCurrentPosition() > 0) && mMediaController != null)
            {
                mMediaController.show(0);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L2:
            if (mTargetState == 3)
            {
                start();
                return;
            }
            if (true) goto _L4; else goto _L7
_L7:
        }

            
            {
                this$0 = CrackleVideoView.this;
                super();
            }
    };
    android.view.SurfaceHolder.Callback mSHCallback = new android.view.SurfaceHolder.Callback() {

        final CrackleVideoView this$0;

        public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
        {
            mSurfaceWidth = j;
            mSurfaceHeight = k;
            if (mTargetState == 3)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (mVideoWidth == j && mVideoHeight == k)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (mMediaPlayer != null && i != 0 && j != 0)
            {
                if (mSeekWhenPrepared != 0)
                {
                    seekTo(mSeekWhenPrepared);
                }
                Log.d(TAG, "surfaceChanged : calling start");
                start();
                if (mMediaController != null)
                {
                    if (mMediaController.isShowing())
                    {
                        mMediaController.hide();
                    }
                    mMediaController.show();
                }
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceholder)
        {
            Log.d(TAG, (new StringBuilder()).append("surfaceCreated : state ").append(mCurrentState).append(" mMediaPlayer = ").append(mMediaPlayer).toString());
            mSurfaceHolder = surfaceholder;
            if (mMediaPlayer == null && mCurrentState == 0)
            {
                openVideo();
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceholder)
        {
            Log.d(TAG, (new StringBuilder()).append("surfaceDestroyed : state ").append(mCurrentState).toString());
            mSurfaceHolder = null;
            if (mMediaController != null)
            {
                mMediaController.hide();
            }
            if (mCurrentState != 6)
            {
                release(true);
            }
        }

            
            {
                this$0 = CrackleVideoView.this;
                super();
            }
    };
    private android.media.MediaPlayer.OnSeekCompleteListener mSeekListener;
    private int mSeekWhenPrepared;
    android.media.MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new android.media.MediaPlayer.OnVideoSizeChangedListener() {

        final CrackleVideoView this$0;

        public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
        {
            mVideoWidth = mediaplayer.getVideoWidth();
            mVideoHeight = mediaplayer.getVideoHeight();
            Log.i(TAG, (new StringBuilder()).append("OnVideoSizeChangedListener ").append(mVideoWidth).append("x").append(mVideoHeight).toString());
            if (mVideoWidth != 0 && mVideoHeight != 0)
            {
                getHolder().setFixedSize(mVideoWidth, mVideoHeight);
            }
        }

            
            {
                this$0 = CrackleVideoView.this;
                super();
            }
    };
    private int mSurfaceHeight;
    private SurfaceHolder mSurfaceHolder;
    private int mSurfaceWidth;
    private int mTargetState;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public CrackleVideoView(Context context)
    {
        super(context);
        TAG = "CrackleVideoView";
        mCurrentState = 0;
        mTargetState = 0;
        mSurfaceHolder = null;
        mMediaPlayer = null;
        initVideoView();
    }

    public CrackleVideoView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
        initVideoView();
    }

    public CrackleVideoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        TAG = "CrackleVideoView";
        mCurrentState = 0;
        mTargetState = 0;
        mSurfaceHolder = null;
        mMediaPlayer = null;
        initVideoView();
    }

    private void attachMediaController()
    {
        if (mMediaPlayer != null && mMediaController != null)
        {
            mMediaController.setMediaPlayer(this);
            Object obj;
            if (getParent() instanceof View)
            {
                obj = (View)getParent();
            } else
            {
                obj = this;
            }
            mMediaController.setAnchorView(((View) (obj)));
            mMediaController.setEnabled(isInPlaybackState());
        }
    }

    private void initVideoView()
    {
        mVideoWidth = 0;
        mVideoHeight = 0;
        getHolder().addCallback(mSHCallback);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        mCurrentState = 0;
        mTargetState = 0;
    }

    private boolean isInPlaybackState()
    {
        return mMediaPlayer != null && mCurrentState != -1 && mCurrentState != 0 && mCurrentState != 1;
    }

    private void openVideo()
    {
        if (mUri != null && mSurfaceHolder != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Log.d(TAG, (new StringBuilder()).append("Playing video URL: ").append(mUri).toString());
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        getContext().sendBroadcast(intent);
        release(false);
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setOnPreparedListener(mPreparedListener);
        mMediaPlayer.setOnVideoSizeChangedListener(mSizeChangedListener);
        mDuration = -1;
        mMediaPlayer.setOnCompletionListener(mCompletionListener);
        mMediaPlayer.setOnErrorListener(mErrorListener);
        mMediaPlayer.setOnSeekCompleteListener(mSeekListener);
        mMediaPlayer.setOnBufferingUpdateListener(mBufferingUpdateListener);
        mCurrentBufferPercentage = 0;
        mMediaPlayer.setDataSource(getContext(), mUri);
        mMediaPlayer.setDisplay(mSurfaceHolder);
        mMediaPlayer.setAudioStreamType(3);
        mMediaPlayer.setScreenOnWhilePlaying(true);
        mMediaPlayer.prepareAsync();
        mCurrentState = 1;
        attachMediaController();
        Object obj;
        try
        {
            if (VideoPlayerActivity.mConvivaSessionID < 0)
            {
                initializeConviva(VideoPlayerActivity.mConvivaMediaDetailsItem, VideoPlayerActivity.mConvivaMediaUrl);
                return;
            }
        }
        catch (Exception exception)
        {
            return;
        }
        LivePass.resumeMonitor(VideoPlayerActivity.mConvivaSessionID, mMediaPlayer);
        return;
        obj;
        Log.w(TAG, (new StringBuilder()).append("Unable to open content: ").append(mUri).toString(), ((Throwable) (obj)));
        mCurrentState = -1;
        mTargetState = -1;
        if (mErrorListener != null)
        {
            mErrorListener.onError(mMediaPlayer, 1, 0);
            return;
        }
        continue; /* Loop/switch isn't completed */
        obj;
        Log.w(TAG, (new StringBuilder()).append("Unable to open content: ").append(mUri).toString(), ((Throwable) (obj)));
        mCurrentState = -1;
        mTargetState = -1;
        if (mErrorListener != null)
        {
            mErrorListener.onError(mMediaPlayer, 1, 0);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void toggleMediaControlsVisiblity()
    {
        if (mMediaController.isShowing())
        {
            mMediaController.hide();
            return;
        } else
        {
            mMediaController.show();
            return;
        }
    }

    public boolean canPause()
    {
        return mCanPause;
    }

    public boolean canSeekBackward()
    {
        return mCanSeekBack;
    }

    public boolean canSeekForward()
    {
        return mCanSeekForward;
    }

    public int getAudioSessionId()
    {
        return 0;
    }

    public int getBufferPercentage()
    {
        if (mMediaPlayer != null)
        {
            return mCurrentBufferPercentage;
        } else
        {
            return 0;
        }
    }

    public int getCurrentPosition()
    {
        if (isInPlaybackState())
        {
            return mMediaPlayer.getCurrentPosition();
        } else
        {
            return 0;
        }
    }

    public int getDuration()
    {
        if (isInPlaybackState())
        {
            if (mDuration > 0)
            {
                return mDuration;
            } else
            {
                mDuration = mMediaPlayer.getDuration();
                return mDuration;
            }
        } else
        {
            mDuration = -1;
            return mDuration;
        }
    }

    public void initializeConviva(MediaDetailsItem mediadetailsitem, String s)
    {
        Log.d("Conviva start", "CONVIVA START");
        Object obj = (new StringBuilder()).append("[").append(mediadetailsitem.getID()).append("] ");
        String s1;
        if (mediadetailsitem.getShowName().isEmpty())
        {
            s1 = "";
        } else
        {
            s1 = (new StringBuilder()).append(mediadetailsitem.getShowName()).append(" : ").toString();
        }
        s1 = ((StringBuilder) (obj)).append(s1).append(mediadetailsitem.getTitle()).toString();
        obj = new HashMap();
        ((Map) (obj)).put("category", mediadetailsitem.getRootChannel());
        if (mediadetailsitem.getMediaType() != null)
        {
            ((Map) (obj)).put("contentType", mediadetailsitem.getMediaType());
        }
        ((Map) (obj)).put("adMode", "double");
        ((Map) (obj)).put("crackleDomain", "Android");
        ((Map) (obj)).put("definition", "Auto");
        ((Map) (obj)).put("externalSite", "Android");
        ((Map) (obj)).put("contentId", mediadetailsitem.getID());
        ((Map) (obj)).put("genre", mediadetailsitem.getGenre());
        ((Map) (obj)).put("playerVersion", Application.getInstalledVersion());
        ((Map) (obj)).put("rating", mediadetailsitem.getRating());
        if (!mediadetailsitem.getShowName().isEmpty())
        {
            ((Map) (obj)).put("show", mediadetailsitem.getShowName());
        }
        mediadetailsitem = new ConvivaContentInfo(s1, ((Map) (obj)));
        mediadetailsitem.defaultReportingCdnName = "OTHER";
        mediadetailsitem.streamUrl = s;
        mediadetailsitem.isLive = false;
        mediadetailsitem.playerName = "Sony Android";
        if (CrackleAccountManager.isLoggedIn())
        {
            mediadetailsitem.viewerId = CrackleAccountManager.getUserID();
        }
        mediadetailsitem.defaultReportingCdnName = "AKAMAI";
        try
        {
            VideoPlayerActivity.mConvivaSessionID = LivePass.createSession(mMediaPlayer, mediadetailsitem);
        }
        // Misplaced declaration of an exception variable
        catch (MediaDetailsItem mediadetailsitem) { }
        Log.d("Conviva Finish", "CONVIVA FINISH");
    }

    public boolean isPlaying()
    {
        return isInPlaybackState() && mMediaPlayer.isPlaying();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag;
        if (i != 4 && i != 24 && i != 25 && i != 82 && i != 5 && i != 6)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (isInPlaybackState() && flag && mMediaController != null)
        {
            if (i == 79 || i == 85)
            {
                if (mMediaPlayer.isPlaying())
                {
                    pause();
                    mMediaController.show();
                    return true;
                } else
                {
                    start();
                    mMediaController.hide();
                    return true;
                }
            }
            if (i == 86 && mMediaPlayer.isPlaying())
            {
                pause();
                mMediaController.show();
            } else
            {
                toggleMediaControlsVisiblity();
            }
        }
        return super.onKeyDown(i, keyevent);
    }

    protected void onMeasure(int i, int j)
    {
        int k = getDefaultSize(mVideoWidth, i);
        int l = getDefaultSize(mVideoHeight, j);
        Log.d(TAG, (new StringBuilder()).append("mVideoWidth/Height : ").append(mVideoWidth).append("x").append(mVideoHeight).toString());
        i = l;
        j = k;
        if (mVideoWidth > 0)
        {
            i = l;
            j = k;
            if (mVideoHeight > 0)
            {
                if (mVideoWidth * l > mVideoHeight * k)
                {
                    Log.i(TAG, "image too tall, correcting");
                    i = (mVideoHeight * k) / mVideoWidth;
                    j = k;
                } else
                if (mVideoWidth * l < mVideoHeight * k)
                {
                    Log.i(TAG, "image too wide, correcting");
                    j = (mVideoWidth * l) / mVideoHeight;
                    i = l;
                } else
                {
                    Log.i(TAG, (new StringBuilder()).append("aspect ratio is correct: ").append(k).append("/").append(l).append("=").append(mVideoWidth).append("/").append(mVideoHeight).toString());
                    i = l;
                    j = k;
                }
            }
        }
        Log.i(TAG, (new StringBuilder()).append("setting size: ").append(j).append('x').append(i).toString());
        setMeasuredDimension(j, i);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (isInPlaybackState() && mMediaController != null)
        {
            toggleMediaControlsVisiblity();
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionevent)
    {
        if (isInPlaybackState() && mMediaController != null)
        {
            toggleMediaControlsVisiblity();
        }
        return false;
    }

    public void pause()
    {
        Log.d(TAG, (new StringBuilder()).append("pause : isInPlaybackState = ").append(isInPlaybackState()).toString());
        if (isInPlaybackState() && mMediaPlayer.isPlaying())
        {
            mMediaPlayer.pause();
            mCurrentState = 4;
        }
        mTargetState = 4;
    }

    public void release(boolean flag)
    {
        Log.d(TAG, "release");
        if (mMediaPlayer != null)
        {
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
            mCurrentState = 0;
            if (flag)
            {
                mTargetState = 0;
            }
        }
    }

    public int resolveAdjustedSize(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getMode(j);
        j = android.view.View.MeasureSpec.getSize(j);
        switch (k)
        {
        default:
            return i;

        case 0: // '\0'
            return i;

        case -2147483648: 
            return Math.min(i, j);

        case 1073741824: 
            return j;
        }
    }

    public void resume()
    {
        if (mSurfaceHolder == null && mCurrentState == 6)
        {
            mTargetState = 7;
        } else
        {
            if (mMediaPlayer != null && mCurrentState == 6)
            {
                Log.w(TAG, "Unable to resume video");
                return;
            }
            if (mCurrentState == 8)
            {
                openVideo();
                return;
            }
        }
    }

    public void seekTo(int i)
    {
        if (isInPlaybackState())
        {
            mMediaPlayer.seekTo(i);
            mSeekWhenPrepared = 0;
            return;
        } else
        {
            mSeekWhenPrepared = i;
            return;
        }
    }

    public void setMediaController(MediaController mediacontroller)
    {
        if (mMediaController != null)
        {
            mMediaController.hide();
        }
        mMediaController = mediacontroller;
        attachMediaController();
    }

    public void setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener oncompletionlistener)
    {
        mOnCompletionListener = oncompletionlistener;
    }

    public void setOnErrorListener(android.media.MediaPlayer.OnErrorListener onerrorlistener)
    {
        mErrorListener = onerrorlistener;
    }

    public void setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener onpreparedlistener)
    {
        mOnPreparedListener = onpreparedlistener;
    }

    public void setOnSeekCompleteListener(android.media.MediaPlayer.OnSeekCompleteListener onseekcompletelistener)
    {
        mSeekListener = onseekcompletelistener;
    }

    public void setVideoPath(String s)
    {
        setVideoURI(Uri.parse(s));
    }

    public void setVideoURI(Uri uri)
    {
        setVideoURI(uri, null);
    }

    public void setVideoURI(Uri uri, Map map)
    {
        mUri = uri;
        mSeekWhenPrepared = 0;
        openVideo();
        requestLayout();
        invalidate();
    }

    public void start()
    {
        Log.d(TAG, (new StringBuilder()).append("start : isInPlaybackState = ").append(isInPlaybackState()).toString());
        if (isInPlaybackState())
        {
            mMediaPlayer.start();
            mCurrentState = 3;
        }
        mTargetState = 3;
    }

    public void stopPlayback()
    {
        if (mMediaPlayer != null)
        {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
            mCurrentState = 0;
            mTargetState = 0;
        }
    }

    public void suspend()
    {
        mCurrentState = 6;
    }



/*
    static int access$002(CrackleVideoView cracklevideoview, int i)
    {
        cracklevideoview.mVideoWidth = i;
        return i;
    }

*/




/*
    static int access$102(CrackleVideoView cracklevideoview, int i)
    {
        cracklevideoview.mVideoHeight = i;
        return i;
    }

*/



/*
    static int access$1102(CrackleVideoView cracklevideoview, int i)
    {
        cracklevideoview.mSurfaceWidth = i;
        return i;
    }

*/



/*
    static int access$1202(CrackleVideoView cracklevideoview, int i)
    {
        cracklevideoview.mSurfaceHeight = i;
        return i;
    }

*/



/*
    static int access$1302(CrackleVideoView cracklevideoview, int i)
    {
        cracklevideoview.mTargetState = i;
        return i;
    }

*/



/*
    static int access$1502(CrackleVideoView cracklevideoview, int i)
    {
        cracklevideoview.mCurrentBufferPercentage = i;
        return i;
    }

*/


/*
    static SurfaceHolder access$1602(CrackleVideoView cracklevideoview, SurfaceHolder surfaceholder)
    {
        cracklevideoview.mSurfaceHolder = surfaceholder;
        return surfaceholder;
    }

*/





/*
    static int access$302(CrackleVideoView cracklevideoview, int i)
    {
        cracklevideoview.mCurrentState = i;
        return i;
    }

*/


/*
    static boolean access$402(CrackleVideoView cracklevideoview, boolean flag)
    {
        cracklevideoview.mCanPause = flag;
        return flag;
    }

*/


/*
    static boolean access$502(CrackleVideoView cracklevideoview, boolean flag)
    {
        cracklevideoview.mCanSeekBack = flag;
        return flag;
    }

*/


/*
    static boolean access$602(CrackleVideoView cracklevideoview, boolean flag)
    {
        cracklevideoview.mCanSeekForward = flag;
        return flag;
    }

*/



}
