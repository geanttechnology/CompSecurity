// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.util.Log;
import java.util.Formatter;
import java.util.Locale;

// Referenced classes of package com.gotv.crackle.views:
//            MidRollSeekBar

public class MediaControllerView extends RelativeLayout
    implements android.view.View.OnClickListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnPreparedListener
{
    public static interface ControllerListener
    {

        public abstract void doToggleFullscreen();

        public abstract void onAboutToSeekTo(int i);

        public abstract void onBuffer();

        public abstract void onBufferTooLong();

        public abstract void onPrepared();

        public abstract void onSeekDragging();

        public abstract boolean onSeekTo(int i);

        public abstract void onStopBuffering();

        public abstract void onStopDragging();

        public abstract void onVideoPlaybackPaused();

        public abstract void onVideoPlaybackStarted();

        public abstract void onVideoPlaybackStopped();

        public abstract void onVisibilityChanged(boolean flag);
    }

    private class ControlsHandler extends Handler
    {

        final MediaControllerView this$0;

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 0 1: default 28
        //                       0 29
        //                       1 57;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            updateControls();
            if (!MediaControllerView.mDragging)
            {
                sendMessageDelayed(obtainMessage(0), 1000L);
                return;
            }
              goto _L1
_L3:
            hideControls();
            return;
        }

        public void resetHideTimer()
        {
            resetHideTimer(5000);
        }

        public void resetHideTimer(int i)
        {
            mControllerHandler.removeMessages(1);
            mControllerHandler.sendEmptyMessageDelayed(1, i);
        }

        public void startUpdateLoop()
        {
            mControllerHandler.sendEmptyMessage(0);
        }

        public void startUpdateLoopDelayed(long l)
        {
            mControllerHandler.removeMessages(0);
            mControllerHandler.sendEmptyMessageDelayed(0, l);
        }

        public void stopUpdateLoop()
        {
            mControllerHandler.removeMessages(0);
        }

        private ControlsHandler()
        {
            this$0 = MediaControllerView.this;
            super();
        }

    }


    private static final int BUFFERING_MAX = 200;
    private static final int HIDE_CONTROLS = 1;
    private static final String TAG = "MediaControllerView";
    private static final int UPDATE_CONTROLS = 0;
    private static boolean mDragging;
    private int mBufferingCounter;
    private Runnable mBufferingDetectorRunnable;
    private Handler mBufferingHandler;
    private ImageButton mButtonPausePlay;
    private ControlsHandler mControllerHandler;
    private ControllerListener mControlsListner;
    public int mDurationInMilliSec;
    private StringBuilder mFormatBuilder;
    private Formatter mFormatter;
    private boolean mIsPaused;
    private int mOldPosition;
    private View mProgressView;
    private SeekBar mSeekBar;
    private android.widget.SeekBar.OnSeekBarChangeListener mSeekListener = new android.widget.SeekBar.OnSeekBarChangeListener() {

        int newposition;
        final MediaControllerView this$0;

        public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            if (flag)
            {
                newposition = i;
            }
        }

        public void onStartTrackingTouch(SeekBar seekbar)
        {
            MediaControllerView.mDragging = true;
            mControlsListner.onSeekDragging();
            mControllerHandler.stopUpdateLoop();
        }

        public void onStopTrackingTouch(SeekBar seekbar)
        {
            MediaControllerView.mDragging = false;
            mControlsListner.onAboutToSeekTo(newposition);
            seekTo(newposition);
            mControllerHandler.startUpdateLoopDelayed(3000L);
            updatePausePlayButton();
            mControlsListner.onStopDragging();
        }

            
            {
                this$0 = MediaControllerView.this;
                super();
            }
    };
    private boolean mSeekStarted;
    private int mSeekWhenPrepared;
    private boolean mShouldHoldAd;
    private boolean mStartOnPrepared;
    private TextView mTimePlayed;
    private TextView mTimeRemaining;
    private CrackleVideoHelper mVideoHelper;
    private TextView mVideoTitle;

    public MediaControllerView(Context context)
    {
        super(context);
        mButtonPausePlay = null;
        mSeekBar = null;
        mDurationInMilliSec = 0;
        mShouldHoldAd = false;
        mBufferingCounter = 0;
        mIsPaused = false;
        mBufferingHandler = new Handler();
        mBufferingDetectorRunnable = null;
        mOldPosition = 0;
        mControllerHandler = new ControlsHandler();
    }

    public MediaControllerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mButtonPausePlay = null;
        mSeekBar = null;
        mDurationInMilliSec = 0;
        mShouldHoldAd = false;
        mBufferingCounter = 0;
        mIsPaused = false;
        mBufferingHandler = new Handler();
        mBufferingDetectorRunnable = null;
        mOldPosition = 0;
        mControllerHandler = new ControlsHandler();
    }

    public MediaControllerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mButtonPausePlay = null;
        mSeekBar = null;
        mDurationInMilliSec = 0;
        mShouldHoldAd = false;
        mBufferingCounter = 0;
        mIsPaused = false;
        mBufferingHandler = new Handler();
        mBufferingDetectorRunnable = null;
        mOldPosition = 0;
        mControllerHandler = new ControlsHandler();
    }

    private void hideBuffering()
    {
        mProgressView.setVisibility(4);
        if (mBufferingCounter != 0 && mControlsListner != null)
        {
            mControlsListner.onStopBuffering();
        }
        if (mSeekStarted && mVideoHelper.isPlaying())
        {
            mControlsListner.onVideoPlaybackStarted();
            mSeekStarted = false;
        }
    }

    private void showBuffering()
    {
        mProgressView.setVisibility(0);
        if (mBufferingCounter == 0 && mControlsListner != null)
        {
            mControlsListner.onBuffer();
        }
    }

    private String stringForTime(int i)
    {
        int k = i / 1000;
        i = k % 60;
        int j = (k / 60) % 60;
        k /= 3600;
        mFormatBuilder.setLength(0);
        if (k > 0)
        {
            return mFormatter.format("%d:%02d:%02d", new Object[] {
                Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i)
            }).toString();
        } else
        {
            return mFormatter.format("%02d:%02d", new Object[] {
                Integer.valueOf(j), Integer.valueOf(i)
            }).toString();
        }
    }

    private int updateControls()
    {
        int j = mVideoHelper.getCurrentPosition();
        int i = 0;
        if (mDurationInMilliSec > 0)
        {
            i = mDurationInMilliSec - j;
        }
        mTimePlayed.setText(stringForTime(j));
        mTimeRemaining.setText(stringForTime(i));
        if (!mDragging && mSeekBar != null && mVideoHelper.isPlaying())
        {
            mSeekBar.setProgress(j);
        }
        return 0;
    }

    public int getCurrentPosition()
    {
        if (mSeekWhenPrepared > 0)
        {
            return mSeekWhenPrepared;
        } else
        {
            return mVideoHelper.getCurrentPosition();
        }
    }

    public void hideControls()
    {
        if (getVisibility() == 0)
        {
            setVisibility(4);
        }
        if (mControlsListner != null)
        {
            mControlsListner.onVisibilityChanged(false);
        }
    }

    public void ifNotPreparedDontStartPlayback()
    {
        mStartOnPrepared = false;
    }

    public void init(CrackleVideoHelper cracklevideohelper, View view)
    {
        mProgressView = view;
        reset();
        mFormatBuilder = new StringBuilder();
        mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
        mVideoHelper = cracklevideohelper;
        mVideoHelper.setOnPreparedListener(this);
        mTimePlayed = (TextView)findViewById(0x7f0a009d);
        mTimeRemaining = (TextView)findViewById(0x7f0a009f);
        mSeekBar = (MidRollSeekBar)findViewById(0x7f0a009e);
        mSeekBar.setOnSeekBarChangeListener(mSeekListener);
        mButtonPausePlay = (ImageButton)findViewById(0x7f0a009a);
        mButtonPausePlay.setOnClickListener(this);
        startBufferingDetector();
    }

    public boolean isBuffering()
    {
        if (mProgressView != null)
        {
            return mProgressView.isShown();
        } else
        {
            return false;
        }
    }

    public boolean isDragging()
    {
        return mDragging;
    }

    public boolean isPaused()
    {
        return mIsPaused;
    }

    public boolean isShowing()
    {
        return getVisibility() == 0;
    }

    public void onClick(View view)
    {
label0:
        {
            if (view.getId() == 0x7f0a009a && mVideoHelper.isVideoSetup())
            {
                if (!mVideoHelper.isPlaying())
                {
                    break label0;
                }
                pausePlayback(false);
            }
            return;
        }
        startPlayback();
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        mButtonPausePlay.setEnabled(false);
        stopPlayback(false);
        mControllerHandler.stopUpdateLoop();
    }

    public void onDestroy()
    {
        mControllerHandler.stopUpdateLoop();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && getVisibility() == 0)
        {
            hideControls();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        startBufferingDetector();
        mButtonPausePlay.setImageResource(0x7f02010d);
        mButtonPausePlay.setEnabled(true);
        if (mControlsListner != null)
        {
            mControlsListner.onPrepared();
        }
        if (mSeekWhenPrepared > 0)
        {
            seekTo(mSeekWhenPrepared);
        }
        if (mStartOnPrepared)
        {
            startPlayback();
        }
    }

    public void pausePlayback(boolean flag)
    {
        Log.d("MediaControllerView", "pausePlayback");
        mControllerHandler.stopUpdateLoop();
        mVideoHelper.pause();
        mIsPaused = true;
        mButtonPausePlay.setImageResource(0x7f02010d);
        if (mControlsListner != null)
        {
            mControlsListner.onVideoPlaybackPaused();
        }
        if (flag)
        {
            showBuffering();
        }
    }

    public void playVideo(String s, int i)
    {
        mDurationInMilliSec = (int)((long)i * 1000L);
        mStartOnPrepared = true;
        mVideoHelper.setVideoURI(Uri.parse(s));
        mButtonPausePlay.setEnabled(false);
        mVideoHelper.requestFocus();
        mSeekBar.setMax(mDurationInMilliSec);
        mControllerHandler.startUpdateLoop();
    }

    public void reset()
    {
    }

    public void seekTo(int i)
    {
        Log.d("MediaControllerView", (new StringBuilder()).append("doSeekTo : doSeek = ").append(false).toString());
        Log.d("MediaControllerView", (new StringBuilder()).append("doSeekTo : apply seekTo = ").append(i).toString());
        if (mVideoHelper.getDuration() > 0)
        {
            mVideoHelper.seekTo(i);
            mSeekStarted = true;
        } else
        {
            mSeekWhenPrepared = i;
        }
        if (mControlsListner != null)
        {
            mControlsListner.onSeekTo(i);
        }
    }

    public void setControllerListener(ControllerListener controllerlistener)
    {
        mControlsListner = controllerlistener;
    }

    public void setSecondaryProgress(int i)
    {
        if (mSeekBar != null)
        {
            mSeekBar.setSecondaryProgress(i);
        }
    }

    public void setTitle(String s)
    {
        mVideoTitle.setText(s);
    }

    public boolean shouldHoldAd()
    {
        return mShouldHoldAd || mProgressView.getVisibility() == 0 || !mVideoHelper.isPlaying();
    }

    public void showControls()
    {
        bringToFront();
        if (mVideoHelper.isVideoSetup() && mVideoHelper.getVisibility() == 0)
        {
            startAnimation(AnimationUtils.loadAnimation(getContext(), 0x10a0000));
            setVisibility(0);
            if (mControlsListner != null)
            {
                mControlsListner.onVisibilityChanged(true);
            }
        }
    }

    public void startBufferingDetector()
    {
        stopBufferingDetector();
        mBufferingDetectorRunnable = new Runnable() {

            final MediaControllerView this$0;

            public void run()
            {
                if (mVideoHelper.isVideoSetup())
                {
                    int i = mVideoHelper.getCurrentPosition();
                    if (mOldPosition == i && mVideoHelper.isPlaying())
                    {
                        showBuffering();
                        int i = ((access._cls902) (this)).access$902;
                        if (mBufferingCounter > 200)
                        {
                            mControlsListner.onBufferTooLong();
                            mBufferingCounter = 0;
                        }
                    } else
                    {
                        hideBuffering();
                        mBufferingCounter = 0;
                    }
                    mOldPosition = i;
                    if (mSeekWhenPrepared > 0)
                    {
                        showBuffering();
                        if (mVideoHelper.getDuration() > 0)
                        {
                            mVideoHelper.seekTo(mSeekWhenPrepared);
                            mSeekWhenPrepared = 0;
                            mSeekStarted = true;
                        }
                    }
                }
                if (mBufferingDetectorRunnable != null)
                {
                    mBufferingHandler.postDelayed(mBufferingDetectorRunnable, 600L);
                }
            }

            
            {
                this$0 = MediaControllerView.this;
                super();
            }
        };
        mBufferingHandler.postDelayed(mBufferingDetectorRunnable, 0L);
    }

    public void startPlayback()
    {
        Log.d("MediaControllerView", "startPlayback");
        mVideoHelper.start();
        updatePausePlayButton();
        mControllerHandler.startUpdateLoop();
        if (mControlsListner != null)
        {
            mControlsListner.onVideoPlaybackStarted();
        }
    }

    public void stopBufferingDetector()
    {
        if (mBufferingDetectorRunnable != null)
        {
            mBufferingHandler.removeCallbacks(mBufferingDetectorRunnable);
        }
    }

    public void stopPlayback(boolean flag)
    {
        Log.d("MediaControllerView", "stopPlayback");
        mControllerHandler.stopUpdateLoop();
        mIsPaused = false;
        mButtonPausePlay.post(new Runnable() {

            final MediaControllerView this$0;

            public void run()
            {
                mButtonPausePlay.setImageResource(0x7f02010d);
            }

            
            {
                this$0 = MediaControllerView.this;
                super();
            }
        });
        mVideoHelper.stopPlayback();
        if (mControlsListner != null)
        {
            mControlsListner.onVideoPlaybackStopped();
        }
        if (flag)
        {
            showBuffering();
        }
    }

    public void updatePausePlayButton()
    {
        if (mButtonPausePlay == null)
        {
            return;
        }
        if (mVideoHelper.isPlaying())
        {
            mButtonPausePlay.setImageResource(0x7f02010c);
            return;
        } else
        {
            mButtonPausePlay.setImageResource(0x7f02010d);
            return;
        }
    }



/*
    static boolean access$002(boolean flag)
    {
        mDragging = flag;
        return flag;
    }

*/










/*
    static int access$402(MediaControllerView mediacontrollerview, int i)
    {
        mediacontrollerview.mOldPosition = i;
        return i;
    }

*/




/*
    static int access$602(MediaControllerView mediacontrollerview, int i)
    {
        mediacontrollerview.mBufferingCounter = i;
        return i;
    }

*/


/*
    static int access$608(MediaControllerView mediacontrollerview)
    {
        int i = mediacontrollerview.mBufferingCounter;
        mediacontrollerview.mBufferingCounter = i + 1;
        return i;
    }

*/




/*
    static int access$802(MediaControllerView mediacontrollerview, int i)
    {
        mediacontrollerview.mSeekWhenPrepared = i;
        return i;
    }

*/


/*
    static boolean access$902(MediaControllerView mediacontrollerview, boolean flag)
    {
        mediacontrollerview.mSeekStarted = flag;
        return flag;
    }

*/
}
