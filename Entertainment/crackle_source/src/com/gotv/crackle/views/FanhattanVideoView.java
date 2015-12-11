// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FanhattanVideoView extends FrameLayout
    implements android.widget.MediaController.MediaPlayerControl
{

    private static final int ON_INFO__SET_SURFACE = 1002;
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private String TAG;
    private float currentVolume;
    private SurfaceView mActiveView;
    private android.media.MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new android.media.MediaPlayer.OnBufferingUpdateListener() {

        final FanhattanVideoView this$0;

        public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
        {
            Log.i(TAG, (new StringBuilder()).append("OnBufferingUpdate called with percent: ").append(i).toString());
            mCurrentBufferPercentage = i;
            if (mOnBufferingUpdateListener != null)
            {
                mOnBufferingUpdateListener.onBufferingUpdate(mediaplayer, i);
            }
        }

            
            {
                this$0 = FanhattanVideoView.this;
                super();
            }
    };
    private boolean mCanPause;
    private boolean mCanSeekBack;
    private boolean mCanSeekForward;
    private android.media.MediaPlayer.OnCompletionListener mCompletionListener = new android.media.MediaPlayer.OnCompletionListener() {

        final FanhattanVideoView this$0;

        public void onCompletion(MediaPlayer mediaplayer)
        {
            Log.i(TAG, "OnCompletion.");
            mCurrentState = 5;
            mTargetState = 5;
            if (mMediaController != null)
            {
                mMediaController.hide();
            }
            mediaplayer = mOnCompletionListener;
            if (mediaplayer != null)
            {
                mediaplayer.onCompletion(mMediaPlayer);
            }
        }

            
            {
                this$0 = FanhattanVideoView.this;
                super();
            }
    };
    private int mCurrentBufferPercentage;
    private int mCurrentState;
    private int mDuration;
    private android.media.MediaPlayer.OnErrorListener mErrorListener = new android.media.MediaPlayer.OnErrorListener() {

        final FanhattanVideoView this$0;

        public boolean onError(MediaPlayer mediaplayer, int i, int j)
        {
            Log.d(TAG, (new StringBuilder()).append("Error: ").append(i).append(",").append(j).toString());
            mCurrentState = -1;
            mTargetState = -1;
            if (mMediaController != null)
            {
                mMediaController.hide();
            }
            while (mOnErrorListener != null && mOnErrorListener.onError(mMediaPlayer, i, j) || mOnCompletionListener == null) 
            {
                return true;
            }
            mOnCompletionListener.onCompletion(mMediaPlayer);
            return true;
        }

            
            {
                this$0 = FanhattanVideoView.this;
                super();
            }
    };
    private Map mHeaders;
    private android.media.MediaPlayer.OnInfoListener mInfoListener = new android.media.MediaPlayer.OnInfoListener() {

        final FanhattanVideoView this$0;

        public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
        {
            Log.i(TAG, (new StringBuilder()).append("OnInfo called with what/extra : ").append(i).append("/").append(j).toString());
            if (i == 1002)
            {
                setActiveSurface(j);
                return true;
            }
            if (mOnInfoListener != null)
            {
                return mOnInfoListener.onInfo(mediaplayer, i, j);
            } else
            {
                return false;
            }
        }

            
            {
                this$0 = FanhattanVideoView.this;
                super();
            }
    };
    private MediaController mMediaController;
    private MediaPlayer mMediaPlayer;
    private android.media.MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private android.media.MediaPlayer.OnCompletionListener mOnCompletionListener;
    private android.media.MediaPlayer.OnErrorListener mOnErrorListener;
    private android.media.MediaPlayer.OnInfoListener mOnInfoListener;
    private android.media.MediaPlayer.OnPreparedListener mOnPreparedListener;
    private android.media.MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private android.media.MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    android.media.MediaPlayer.OnPreparedListener mPreparedListener = new android.media.MediaPlayer.OnPreparedListener() {

        final FanhattanVideoView this$0;

        public void onPrepared(MediaPlayer mediaplayer)
        {
            int i;
            Log.i(TAG, "OnPrepared.");
            mCurrentState = 2;
            mCanPause = mCanSeekForward = true;
            if (mMediaController != null)
            {
                mMediaController.setEnabled(true);
            }
            if (mOnPreparedListener != null)
            {
                mOnPreparedListener.onPrepared(mMediaPlayer);
            }
            mVideoWidth = mediaplayer.getVideoWidth();
            mVideoHeight = mediaplayer.getVideoHeight();
            i = mSeekWhenPrepared;
            if (i != 0)
            {
                seekTo(i);
            }
            if (mVideoWidth == 0 || mVideoHeight == 0) goto _L2; else goto _L1
_L1:
            mActiveView.getHolder().setFixedSize(mVideoWidth, mVideoHeight);
            if (mSurfaceWidth != mVideoWidth || mSurfaceHeight != mVideoHeight) goto _L4; else goto _L3
_L3:
            if (mTargetState != 3) goto _L6; else goto _L5
_L5:
            start();
            if (mMediaController == null);
_L4:
            return;
_L6:
            if (!isPlaying() && (i != 0 || getCurrentPosition() > 0) && mMediaController != null)
            {
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
                this$0 = FanhattanVideoView.this;
                super();
            }
    };
    private SurfaceHolder mPrimarySurfaceHolder;
    android.view.SurfaceHolder.Callback mSHCallback = new android.view.SurfaceHolder.Callback() {

        final FanhattanVideoView this$0;

        public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
        {
            Log.i(TAG, "Surface has been changed.");
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
                start();
                if (mMediaController == null);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceholder)
        {
            Log.i(TAG, "Surface has been created.");
            this;
            JVM INSTR monitorenter ;
            if (surfaceholder == mSurfaceView1.getHolder())
            {
                mPrimarySurfaceHolder = surfaceholder;
            }
            if (surfaceholder == mSurfaceView2.getHolder())
            {
                mSecondarySurfaceHolder = surfaceholder;
            }
            if (mPrimarySurfaceHolder != null && mSecondarySurfaceHolder != null && mUri != null)
            {
                openVideo();
            }
            this;
            JVM INSTR monitorexit ;
            return;
            surfaceholder;
            this;
            JVM INSTR monitorexit ;
            throw surfaceholder;
        }

        public void surfaceDestroyed(SurfaceHolder surfaceholder)
        {
            Log.i(TAG, "Surface has been destroyed.");
            mUri = null;
            if (surfaceholder == mSurfaceView1.getHolder())
            {
                mPrimarySurfaceHolder = null;
            }
            if (surfaceholder == mSurfaceView2.getHolder())
            {
                mSecondarySurfaceHolder = null;
            }
            release(true);
        }

            
            {
                this$0 = FanhattanVideoView.this;
                super();
            }
    };
    private SurfaceHolder mSecondarySurfaceHolder;
    private android.media.MediaPlayer.OnSeekCompleteListener mSeekCompleteListener = new android.media.MediaPlayer.OnSeekCompleteListener() {

        final FanhattanVideoView this$0;

        public void onSeekComplete(MediaPlayer mediaplayer)
        {
            Log.i(TAG, "OnSeekComplete.");
            if (mOnSeekCompleteListener != null)
            {
                mOnSeekCompleteListener.onSeekComplete(mediaplayer);
            }
        }

            
            {
                this$0 = FanhattanVideoView.this;
                super();
            }
    };
    private int mSeekWhenPrepared;
    android.media.MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new android.media.MediaPlayer.OnVideoSizeChangedListener() {

        final FanhattanVideoView this$0;

        public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
        {
            Log.i(TAG, (new StringBuilder()).append("OnVideoSizeChanged to width/height: ").append(i).append("/").append(j).toString());
            mVideoWidth = mediaplayer.getVideoWidth() % 0x186a0;
            mVideoHeight = mediaplayer.getVideoHeight();
            Log.i(TAG, (new StringBuilder()).append("OnVideoSizeChanged to mVideoWidth/mVideoHeight: ").append(mVideoWidth).append("/").append(mVideoHeight).toString());
            i %= 0x186a0;
            int k = i / 0x186a0;
            Log.i(TAG, (new StringBuilder()).append("OnVideoSizeChanged viewIndex: ").append(k).toString());
            if (i != 0 && j != 0)
            {
                if (k == 0)
                {
                    mSurfaceView1.getHolder().setFixedSize(mVideoWidth, mVideoHeight);
                } else
                {
                    mSurfaceView2.getHolder().setFixedSize(mVideoWidth, mVideoHeight);
                }
            }
            if (mOnVideoSizeChangedListener != null)
            {
                mOnVideoSizeChangedListener.onVideoSizeChanged(mediaplayer, i, j);
            }
        }

            
            {
                this$0 = FanhattanVideoView.this;
                super();
            }
    };
    private int mSurfaceHeight;
    private SurfaceView mSurfaceView1;
    private SurfaceView mSurfaceView2;
    private int mSurfaceWidth;
    private int mTargetState;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;
    private boolean startCalled;

    public FanhattanVideoView(Context context)
    {
        super(context);
        TAG = "FanhattanVideoView";
        mCurrentState = 0;
        mTargetState = 0;
        mPrimarySurfaceHolder = null;
        mSecondarySurfaceHolder = null;
        mMediaPlayer = null;
        mOnBufferingUpdateListener = null;
        mOnCompletionListener = null;
        mOnErrorListener = null;
        mOnInfoListener = null;
        mOnPreparedListener = null;
        mOnSeekCompleteListener = null;
        mOnVideoSizeChangedListener = null;
        startCalled = false;
        currentVolume = 1.0F;
        initVideoViews();
    }

    public FanhattanVideoView(Context context, int i, int j)
    {
        super(context);
        TAG = "FanhattanVideoView";
        mCurrentState = 0;
        mTargetState = 0;
        mPrimarySurfaceHolder = null;
        mSecondarySurfaceHolder = null;
        mMediaPlayer = null;
        mOnBufferingUpdateListener = null;
        mOnCompletionListener = null;
        mOnErrorListener = null;
        mOnInfoListener = null;
        mOnPreparedListener = null;
        mOnSeekCompleteListener = null;
        mOnVideoSizeChangedListener = null;
        startCalled = false;
        currentVolume = 1.0F;
        mVideoWidth = i;
        mVideoHeight = j;
        initVideoViews();
    }

    public FanhattanVideoView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FanhattanVideoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        TAG = "FanhattanVideoView";
        mCurrentState = 0;
        mTargetState = 0;
        mPrimarySurfaceHolder = null;
        mSecondarySurfaceHolder = null;
        mMediaPlayer = null;
        mOnBufferingUpdateListener = null;
        mOnCompletionListener = null;
        mOnErrorListener = null;
        mOnInfoListener = null;
        mOnPreparedListener = null;
        mOnSeekCompleteListener = null;
        mOnVideoSizeChangedListener = null;
        startCalled = false;
        currentVolume = 1.0F;
        initVideoViews();
    }

    private void attachMediaController()
    {
        if (mMediaController != null)
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

    private static android.widget.FrameLayout.LayoutParams createLayoutParams()
    {
        return new android.widget.FrameLayout.LayoutParams(-1, -1);
    }

    public static String getCurrentStackTrace()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        int j = astacktraceelement.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(astacktraceelement[i]);
            stringbuilder.append("\n");
        }

        return stringbuilder.toString();
    }

    private void initVideoViews()
    {
        Log.d(TAG, (new StringBuilder()).append("Initializing VideoView : ").append(this).toString());
        mSurfaceView1 = new SurfaceView(getContext());
        mSurfaceView2 = new SurfaceView(getContext());
        mVideoWidth = 0;
        mVideoHeight = 0;
        mSurfaceView1.getHolder().addCallback(mSHCallback);
        mSurfaceView1.getHolder().setType(3);
        mSurfaceView2.getHolder().addCallback(mSHCallback);
        mSurfaceView2.getHolder().setType(3);
        mSurfaceView1.setLayoutParams(createLayoutParams());
        mSurfaceView2.setLayoutParams(createLayoutParams());
        addView(mSurfaceView2);
        addView(mSurfaceView1);
        setActiveSurface(0);
        mSurfaceView1.setFocusable(true);
        mSurfaceView1.setFocusableInTouchMode(true);
        mSurfaceView1.requestFocus();
        mCurrentState = 0;
        mTargetState = 0;
    }

    private boolean isInPlaybackState()
    {
        return mMediaPlayer != null && mCurrentState != -1 && mCurrentState != 0 && mCurrentState != 1;
    }

    private void mediaPlayerSetDisplays(MediaPlayer mediaplayer, SurfaceHolder surfaceholder, SurfaceHolder surfaceholder1)
    {
        boolean flag = false;
        mediaplayer.getClass().getMethod("setDisplays", new Class[] {
            android/view/SurfaceHolder, android/view/SurfaceHolder
        }).invoke(mediaplayer, new Object[] {
            surfaceholder, surfaceholder1
        });
        flag = true;
_L2:
        if (!flag)
        {
            Log.d(TAG, "Fallback compatibility mediaPlayer.setDisplay(surfaceHolder1)");
            mediaplayer.setDisplay(surfaceholder);
        }
        return;
        surfaceholder1;
        Log.e(TAG, surfaceholder1.toString(), surfaceholder1);
        continue; /* Loop/switch isn't completed */
        surfaceholder1;
        Log.e(TAG, surfaceholder1.toString(), surfaceholder1);
        continue; /* Loop/switch isn't completed */
        surfaceholder1;
        Log.e(TAG, surfaceholder1.toString(), surfaceholder1);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void openVideo()
    {
        if (mUri == null || mPrimarySurfaceHolder == null)
        {
            Log.w(TAG, String.format("Could not open video, mPrimarySurfaceHolder/mUri/this = %s/ %s/ %s.", new Object[] {
                mPrimarySurfaceHolder, mUri, this
            }));
            return;
        }
        release(false);
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setVolume(currentVolume, currentVolume);
        mMediaPlayer.setOnPreparedListener(mPreparedListener);
        mMediaPlayer.setOnVideoSizeChangedListener(mSizeChangedListener);
        mCurrentBufferPercentage = 0;
        mediaPlayerSetDisplays(mMediaPlayer, mSurfaceView1.getHolder(), mSurfaceView2.getHolder());
        mMediaPlayer.setAudioStreamType(3);
        mMediaPlayer.setScreenOnWhilePlaying(true);
        setInternalListeners();
        mDuration = -1;
        Log.i(TAG, (new StringBuilder()).append("Opening video with mUri = ").append(mUri.toString()).toString());
        if (mHeaders != null) goto _L2; else goto _L1
_L1:
        mMediaPlayer.setDataSource(getContext(), mUri);
_L3:
        IOException ioexception;
        mMediaPlayer.prepareAsync();
        mCurrentState = 1;
        return;
_L2:
        try
        {
            Log.d(TAG, "Using custom headers");
            String s;
            for (Iterator iterator = mHeaders.keySet().iterator(); iterator.hasNext(); Log.d(TAG, (new StringBuilder()).append(s).append(" : ").append((String)mHeaders.get(s)).toString()))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            Log.w(TAG, (new StringBuilder()).append("Unable to open content: ").append(mUri).toString(), ioexception);
            mCurrentState = -1;
            mTargetState = -1;
            mErrorListener.onError(mMediaPlayer, 1, 0);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.w(TAG, (new StringBuilder()).append("Unable to open content: ").append(mUri).toString(), illegalargumentexception);
            mCurrentState = -1;
            mTargetState = -1;
            mErrorListener.onError(mMediaPlayer, 1, 0);
            return;
        }
        mMediaPlayer.setDataSource(getContext(), mUri, mHeaders);
          goto _L3
    }

    private void release(boolean flag)
    {
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

    private void reopenVideo()
    {
        if (mMediaPlayer != null)
        {
            try
            {
                mediaPlayerSetDisplays(mMediaPlayer, null, null);
                mMediaPlayer.reset();
                mediaPlayerSetDisplays(mMediaPlayer, mSurfaceView1.getHolder(), mSurfaceView2.getHolder());
                mMediaPlayer.setDataSource(getContext(), mUri);
                mMediaPlayer.prepareAsync();
                mCurrentState = 1;
                return;
            }
            catch (IOException ioexception)
            {
                Log.w(TAG, (new StringBuilder()).append("Unable to open content: ").append(mUri).toString(), ioexception);
                mCurrentState = -1;
                mTargetState = -1;
                mErrorListener.onError(mMediaPlayer, 1, 0);
                return;
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.w(TAG, (new StringBuilder()).append("Unable to open content: ").append(mUri).toString(), illegalargumentexception);
            }
            mCurrentState = -1;
            mTargetState = -1;
            mErrorListener.onError(mMediaPlayer, 1, 0);
            return;
        } else
        {
            openVideo();
            return;
        }
    }

    private void setActiveSurface(int i)
    {
        Log.d(TAG, (new StringBuilder()).append("setActiveSurface : ").append(i).toString());
        SurfaceView surfaceview;
        if (i == 0)
        {
            mActiveView = mSurfaceView1;
            surfaceview = mSurfaceView2;
        } else
        if (i == 1)
        {
            mActiveView = mSurfaceView2;
            surfaceview = mSurfaceView1;
        } else
        {
            throw new RuntimeException("Unknown surface view index");
        }
        mActiveView.setY(0.0F);
        surfaceview.setY(2000F);
    }

    private void setInternalListeners()
    {
        mMediaPlayer.setOnBufferingUpdateListener(mBufferingUpdateListener);
        mMediaPlayer.setOnCompletionListener(mCompletionListener);
        mMediaPlayer.setOnErrorListener(mErrorListener);
        mMediaPlayer.setOnInfoListener(mInfoListener);
        mMediaPlayer.setOnPreparedListener(mPreparedListener);
        mMediaPlayer.setOnSeekCompleteListener(mSeekCompleteListener);
        mMediaPlayer.setOnVideoSizeChangedListener(mSizeChangedListener);
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
        int i = 0;
        if (isInPlaybackState())
        {
            try
            {
                i = mMediaPlayer.getCurrentPosition();
            }
            catch (IllegalStateException illegalstateexception)
            {
                return 0;
            }
        }
        return i;
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

    public boolean inActiveState()
    {
        return mCurrentState != -1 && mCurrentState != 0 && mCurrentState != 5;
    }

    public boolean isPlaying()
    {
        return isInPlaybackState() && mMediaPlayer.isPlaying();
    }

    public void onControllerHide()
    {
        if (mMediaController != null)
        {
            mMediaController.hide();
        }
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
        super.onMeasure(i, j);
        Log.d(TAG, (new StringBuilder()).append("onMeasure widthMeasureSpec : ").append(i).append(", heightMeasureSpec : ").append(j).toString());
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
        if (isInPlaybackState() && mMediaPlayer.isPlaying())
        {
            mMediaPlayer.pause();
            mCurrentState = 4;
        }
        mTargetState = 4;
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

    public void setHeaders(Map map)
    {
        mHeaders = map;
        Log.d(TAG, "Setting custom headers");
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

    public void setOnBufferingUpdateListener(android.media.MediaPlayer.OnBufferingUpdateListener onbufferingupdatelistener)
    {
        mOnBufferingUpdateListener = onbufferingupdatelistener;
    }

    public void setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener oncompletionlistener)
    {
        mOnCompletionListener = oncompletionlistener;
    }

    public void setOnErrorListener(android.media.MediaPlayer.OnErrorListener onerrorlistener)
    {
        mOnErrorListener = onerrorlistener;
    }

    public void setOnInfoListener(android.media.MediaPlayer.OnInfoListener oninfolistener)
    {
        mOnInfoListener = oninfolistener;
    }

    public void setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener onpreparedlistener)
    {
        mOnPreparedListener = onpreparedlistener;
    }

    public void setOnSeekCompleteListener(android.media.MediaPlayer.OnSeekCompleteListener onseekcompletelistener)
    {
        mOnSeekCompleteListener = onseekcompletelistener;
    }

    public void setOnVideoSizeChangedListener(android.media.MediaPlayer.OnVideoSizeChangedListener onvideosizechangedlistener)
    {
        mOnVideoSizeChangedListener = onvideosizechangedlistener;
    }

    public void setVideoPath(String s)
    {
        setVideoURI(Uri.parse(s));
    }

    public void setVideoURI(Uri uri)
    {
        Log.i(TAG, (new StringBuilder()).append("Setting mUri to : ").append(uri).toString());
        mSeekWhenPrepared = 0;
        requestLayout();
        invalidate();
        this;
        JVM INSTR monitorenter ;
        mUri = uri;
        if (mPrimarySurfaceHolder != null)
        {
            openVideo();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        uri;
        this;
        JVM INSTR monitorexit ;
        throw uri;
    }

    public void setVolume(float f)
    {
        currentVolume = f;
        if (mMediaPlayer != null)
        {
            mMediaPlayer.setVolume(f, f);
        }
    }

    public void setZOrderMediaOverlay(boolean flag)
    {
        mSurfaceView1.setZOrderMediaOverlay(flag);
        mSurfaceView2.setZOrderMediaOverlay(flag);
    }

    public void start()
    {
        if (isInPlaybackState())
        {
            mMediaPlayer.start();
            mCurrentState = 3;
        }
        mTargetState = 3;
        startCalled = true;
    }

    public void stopPlayback()
    {
        if (mMediaPlayer != null)
        {
            mMediaPlayer.stop();
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
            mCurrentState = 0;
            mTargetState = 0;
        }
    }





/*
    static int access$102(FanhattanVideoView fanhattanvideoview, int i)
    {
        fanhattanvideoview.mVideoWidth = i;
        return i;
    }

*/






/*
    static int access$1402(FanhattanVideoView fanhattanvideoview, int i)
    {
        fanhattanvideoview.mSurfaceWidth = i;
        return i;
    }

*/



/*
    static int access$1502(FanhattanVideoView fanhattanvideoview, int i)
    {
        fanhattanvideoview.mSurfaceHeight = i;
        return i;
    }

*/



/*
    static int access$1602(FanhattanVideoView fanhattanvideoview, int i)
    {
        fanhattanvideoview.mTargetState = i;
        return i;
    }

*/







/*
    static int access$202(FanhattanVideoView fanhattanvideoview, int i)
    {
        fanhattanvideoview.mVideoHeight = i;
        return i;
    }

*/



/*
    static int access$2202(FanhattanVideoView fanhattanvideoview, int i)
    {
        fanhattanvideoview.mCurrentBufferPercentage = i;
        return i;
    }

*/




/*
    static SurfaceHolder access$2402(FanhattanVideoView fanhattanvideoview, SurfaceHolder surfaceholder)
    {
        fanhattanvideoview.mPrimarySurfaceHolder = surfaceholder;
        return surfaceholder;
    }

*/



/*
    static SurfaceHolder access$2502(FanhattanVideoView fanhattanvideoview, SurfaceHolder surfaceholder)
    {
        fanhattanvideoview.mSecondarySurfaceHolder = surfaceholder;
        return surfaceholder;
    }

*/



/*
    static Uri access$2602(FanhattanVideoView fanhattanvideoview, Uri uri)
    {
        fanhattanvideoview.mUri = uri;
        return uri;
    }

*/







/*
    static int access$602(FanhattanVideoView fanhattanvideoview, int i)
    {
        fanhattanvideoview.mCurrentState = i;
        return i;
    }

*/


/*
    static boolean access$702(FanhattanVideoView fanhattanvideoview, boolean flag)
    {
        fanhattanvideoview.mCanPause = flag;
        return flag;
    }

*/


/*
    static boolean access$802(FanhattanVideoView fanhattanvideoview, boolean flag)
    {
        fanhattanvideoview.mCanSeekForward = flag;
        return flag;
    }

*/

}
