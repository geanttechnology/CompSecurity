// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.RelativeLayout;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.ThreadUtils;
import java.io.IOException;

public class MMVideoView extends RelativeLayout
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnVideoSizeChangedListener, android.media.MediaPlayer.OnSeekCompleteListener
{
    private static class MMVideoViewInfo extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public MMVideoViewInfo createFromParcel(Parcel parcel)
            {
                return new MMVideoViewInfo(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public MMVideoViewInfo[] newArray(int i)
            {
                return new MMVideoViewInfo[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        int currentPosition;
        int currentState;
        boolean muted;
        int targetState;
        String uri;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeInt(currentState);
            parcel.writeInt(targetState);
            parcel.writeInt(currentPosition);
            if (muted)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            parcel.writeString(uri);
        }


        private MMVideoViewInfo(Parcel parcel)
        {
            boolean flag = true;
            super(parcel);
            currentState = parcel.readInt();
            targetState = parcel.readInt();
            currentPosition = parcel.readInt();
            if (parcel.readInt() != 1)
            {
                flag = false;
            }
            muted = flag;
            uri = parcel.readString();
        }


        public MMVideoViewInfo(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    public static interface MMVideoViewListener
    {

        public abstract void onBufferingUpdate(MMVideoView mmvideoview, int i);

        public abstract void onComplete(MMVideoView mmvideoview);

        public abstract void onError(MMVideoView mmvideoview);

        public abstract void onMuted(MMVideoView mmvideoview);

        public abstract void onPause(MMVideoView mmvideoview);

        public abstract void onPrepared(MMVideoView mmvideoview);

        public abstract void onProgress(MMVideoView mmvideoview, int i);

        public abstract void onReadyToStart(MMVideoView mmvideoview);

        public abstract void onSeek(MMVideoView mmvideoview);

        public abstract void onStart(MMVideoView mmvideoview);

        public abstract void onStop(MMVideoView mmvideoview);

        public abstract void onUnmuted(MMVideoView mmvideoview);
    }

    public static interface MediaController
    {

        public abstract void onComplete();

        public abstract void onMuted();

        public abstract void onPause();

        public abstract void onProgress(int i);

        public abstract void onStart();

        public abstract void onUnmuted();

        public abstract void setDuration(int i);
    }

    private class ProgressRunnable
        implements Runnable
    {

        final MMVideoView this$0;

        public void run()
        {
            this;
            JVM INSTR monitorenter ;
            if (currentState != 4)
            {
                break MISSING_BLOCK_LABEL_27;
            }
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final ProgressRunnable this$1;

                public void run()
                {
                    if (videoViewListener != null)
                    {
                        videoViewListener.onProgress(_fld0, getCurrentPosition());
                    }
                    if (mediaController != null)
                    {
                        mediaController.onProgress(getCurrentPosition());
                    }
                    progressRunnable = ThreadUtils.runOnWorkerThreadDelayed(new ProgressRunnable(), 100L);
                }

            
            {
                this$1 = ProgressRunnable.this;
                super();
            }
            });
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
            progressRunnable = null;
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private ProgressRunnable()
        {
            this$0 = MMVideoView.this;
            super();
        }

    }

    private class VideoSurfaceView extends SurfaceView
    {

        final MMVideoView this$0;

        protected void onMeasure(int i, int j)
        {
            int k;
            int l;
            int i1;
            int i2;
            i1 = getDefaultSize(videoWidth, i);
            i2 = getDefaultSize(videoHeight, j);
            k = i2;
            l = i1;
            if (videoWidth <= 0) goto _L2; else goto _L1
_L1:
            k = i2;
            l = i1;
            if (videoHeight <= 0) goto _L2; else goto _L3
_L3:
            int k2;
            int l2;
            k2 = android.view.View.MeasureSpec.getMode(i);
            i = android.view.View.MeasureSpec.getSize(i);
            l2 = android.view.View.MeasureSpec.getMode(j);
            j = android.view.View.MeasureSpec.getSize(j);
            if (k2 != 0x40000000 || l2 != 0x40000000) goto _L5; else goto _L4
_L4:
            if (videoWidth * j >= videoHeight * i) goto _L7; else goto _L6
_L6:
            l = (videoWidth * j) / videoHeight;
            k = j;
_L2:
            setMeasuredDimension(l, k);
            return;
_L7:
            k = j;
            l = i;
            if (videoWidth * j > videoHeight * i)
            {
                k = (videoHeight * i) / videoWidth;
                l = i;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (k2 == 0x40000000)
            {
                int j1 = (videoHeight * i) / videoWidth;
                k = j1;
                l = i;
                if (l2 == 0x80000000)
                {
                    k = j1;
                    l = i;
                    if (j1 > j)
                    {
                        k = j;
                        l = i;
                    }
                }
            } else
            if (l2 == 0x40000000)
            {
                int k1 = (videoWidth * j) / videoHeight;
                k = j;
                l = k1;
                if (k2 == 0x80000000)
                {
                    k = j;
                    l = k1;
                    if (k1 > i)
                    {
                        k = j;
                        l = i;
                    }
                }
            } else
            {
                k = videoWidth;
                l = videoHeight;
                int j2 = l;
                int l1 = k;
                if (l2 == 0x80000000)
                {
                    j2 = l;
                    l1 = k;
                    if (l > j)
                    {
                        l1 = (videoWidth * j) / videoHeight;
                        j2 = j;
                    }
                }
                k = j2;
                l = l1;
                if (k2 == 0x80000000)
                {
                    k = j2;
                    l = l1;
                    if (l1 > i)
                    {
                        k = (videoHeight * i) / videoWidth;
                        l = i;
                    }
                }
            }
            if (true) goto _L2; else goto _L8
_L8:
        }

        VideoSurfaceView(Context context)
        {
            this$0 = MMVideoView.this;
            super(context);
        }
    }


    private static final int COMPLETED = 6;
    private static final int ERROR = 7;
    private static final int IDLE = 0;
    private static final int PAUSED = 5;
    private static final int PLAYING = 4;
    private static final int PREPARED = 2;
    private static final int PREPARING = 1;
    private static final int PROGRESS_POLLING_INTERVAL = 100;
    private static final int READY_TO_PLAY = 3;
    private static final String TAG = com/millennialmedia/internal/video/MMVideoView.getSimpleName();
    private volatile int currentState;
    private MediaController mediaController;
    private MediaPlayer mediaPlayer;
    private boolean muted;
    private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable progressRunnable;
    private int seekToMilliseconds;
    private SurfaceHolder surfaceHolder;
    private android.view.SurfaceHolder.Callback surfaceHolderCallback;
    private VideoSurfaceView surfaceView;
    private volatile int targetState;
    private Uri uri;
    private int videoHeight;
    private MMVideoViewListener videoViewListener;
    private int videoWidth;

    public MMVideoView(Context context, boolean flag, boolean flag1, MMVideoViewListener mmvideoviewlistener)
    {
        super(new MutableContextWrapper(context));
        seekToMilliseconds = 0;
        currentState = 0;
        surfaceHolderCallback = new android.view.SurfaceHolder.Callback() {

            final MMVideoView this$0;

            public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
            {
                if (mediaPlayer != null && targetState == 4)
                {
                    start();
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceholder)
            {
                surfaceHolder = surfaceholder;
                if (mediaPlayer != null)
                {
                    mediaPlayer.setDisplay(surfaceHolder);
                }
                if (currentState == 2)
                {
                    setAudioFocus();
                    currentState = 3;
                    if (videoWidth != 0 && videoHeight != 0)
                    {
                        surfaceHolder.setFixedSize(videoWidth, videoHeight);
                    }
                    if (videoViewListener != null && targetState != 4)
                    {
                        ThreadUtils.runOnWorkerThread(new Runnable() {

                            final _cls1 this$1;

                            public void run()
                            {
                                videoViewListener.onReadyToStart(_fld0);
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    }
                    if (targetState == 4)
                    {
                        start();
                    }
                }
            }

            public void surfaceDestroyed(SurfaceHolder surfaceholder)
            {
                surfaceHolder = null;
                if (mediaPlayer != null)
                {
                    mediaPlayer.setDisplay(null);
                }
            }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
        };
        context = (MutableContextWrapper)getContext();
        muted = flag1;
        videoViewListener = mmvideoviewlistener;
        if (flag)
        {
            targetState = 4;
        }
        setBackgroundColor(getResources().getColor(0x106000c));
        surfaceView = new VideoSurfaceView(context);
        surfaceView.getHolder().addCallback(surfaceHolderCallback);
        surfaceView.getHolder().setType(3);
        context = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        context.addRule(13);
        addView(surfaceView, context);
    }

    private boolean isInPlaybackState()
    {
        return currentState != 0 && currentState != 1 && currentState != 2 && currentState != 7;
    }

    private void releaseAudioFocus()
    {
        ((AudioManager)getContext().getSystemService("audio")).abandonAudioFocus(null);
    }

    private void setAudioFocus()
    {
        AudioManager audiomanager = (AudioManager)getContext().getSystemService("audio");
        if (!muted)
        {
            audiomanager.requestAudioFocus(null, 3, 3);
            return;
        } else
        {
            audiomanager.abandonAudioFocus(null);
            return;
        }
    }

    public int getCurrentPosition()
    {
        if (isInPlaybackState())
        {
            return mediaPlayer.getCurrentPosition();
        } else
        {
            return -1;
        }
    }

    public int getDuration()
    {
        if (isInPlaybackState() || currentState == 2)
        {
            return mediaPlayer.getDuration();
        } else
        {
            return -1;
        }
    }

    public boolean isPlaying()
    {
        return isInPlaybackState() && mediaPlayer.isPlaying();
    }

    public void mute()
    {
        muted = true;
        mediaPlayer.setVolume(0.0F, 0.0F);
        setAudioFocus();
        if (videoViewListener != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    videoViewListener.onMuted(MMVideoView.this);
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
        if (mediaController != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    mediaController.onMuted();
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        setAudioFocus();
    }

    public void onBufferingUpdate(MediaPlayer mediaplayer, final int percent)
    {
        if (videoViewListener != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;
                final int val$percent;

                public void run()
                {
                    videoViewListener.onBufferingUpdate(MMVideoView.this, percent);
                }

            
            {
                this$0 = MMVideoView.this;
                percent = i;
                super();
            }
            });
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        currentState = 6;
        targetState = 6;
        if (progressRunnable != null)
        {
            progressRunnable.cancel();
            progressRunnable = null;
        }
        if (videoViewListener != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    videoViewListener.onProgress(MMVideoView.this, getDuration());
                    videoViewListener.onComplete(MMVideoView.this);
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
        if (mediaController != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    mediaController.onComplete();
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
    }

    protected void onDetachedFromWindow()
    {
        releaseAudioFocus();
        super.onDetachedFromWindow();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        currentState = 7;
        if (videoViewListener != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    videoViewListener.onError(MMVideoView.this);
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
        return true;
    }

    public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        return false;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        if (surfaceHolder == null) goto _L2; else goto _L1
_L1:
        setAudioFocus();
        currentState = 3;
        if (targetState != 4) goto _L4; else goto _L3
_L3:
        if (videoViewListener != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    videoViewListener.onPrepared(MMVideoView.this);
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
        start();
_L6:
        if (mediaController != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    mediaController.setDuration(getDuration());
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
        return;
_L4:
        if (videoViewListener != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    videoViewListener.onReadyToStart(MMVideoView.this);
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
        continue; /* Loop/switch isn't completed */
_L2:
        currentState = 2;
        if (videoViewListener != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    videoViewListener.onPrepared(MMVideoView.this);
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (MMVideoViewInfo)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        targetState = ((MMVideoViewInfo) (parcelable)).targetState;
        seekToMilliseconds = ((MMVideoViewInfo) (parcelable)).currentPosition;
        muted = ((MMVideoViewInfo) (parcelable)).muted;
        if (((MMVideoViewInfo) (parcelable)).currentState == 4 || ((MMVideoViewInfo) (parcelable)).targetState == 4)
        {
            start();
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        MMVideoViewInfo mmvideoviewinfo = new MMVideoViewInfo(super.onSaveInstanceState());
        mmvideoviewinfo.currentState = currentState;
        mmvideoviewinfo.targetState = targetState;
        mmvideoviewinfo.currentPosition = getCurrentPosition();
        mmvideoviewinfo.muted = muted;
        mmvideoviewinfo.uri = uri.toString();
        return mmvideoviewinfo;
    }

    public void onSeekComplete(MediaPlayer mediaplayer)
    {
        if (videoViewListener != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    videoViewListener.onSeek(MMVideoView.this);
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
        if (mediaController != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    mediaController.onProgress(getCurrentPosition());
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
    }

    public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
    {
        if (j != 0 && i != 0)
        {
            videoWidth = i;
            videoHeight = j;
            if (surfaceHolder != null)
            {
                surfaceHolder.setFixedSize(videoWidth, videoHeight);
                requestLayout();
            }
        }
    }

    public void pause()
    {
        if (isInPlaybackState() && mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
            if (videoViewListener != null)
            {
                ThreadUtils.runOnWorkerThread(new Runnable() {

                    final MMVideoView this$0;

                    public void run()
                    {
                        videoViewListener.onPause(MMVideoView.this);
                    }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
                });
            }
            if (mediaController != null)
            {
                ThreadUtils.runOnWorkerThread(new Runnable() {

                    final MMVideoView this$0;

                    public void run()
                    {
                        mediaController.onPause();
                    }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
                });
            }
            currentState = 5;
            targetState = 5;
        }
    }

    public void restart()
    {
        if (android.os.Build.VERSION.SDK_INT <= 21)
        {
            if (uri == null)
            {
                return;
            }
            setVideoURI(uri);
        } else
        {
            seekTo(0);
        }
        start();
    }

    public void seekTo(int i)
    {
        if (isInPlaybackState())
        {
            mediaPlayer.seekTo(i);
            seekToMilliseconds = 0;
            return;
        } else
        {
            seekToMilliseconds = i;
            return;
        }
    }

    public void setMediaController(MediaController mediacontroller)
    {
        mediaController = mediacontroller;
    }

    public void setVideoPath(String s)
    {
        setVideoURI(Uri.parse(s));
    }

    public void setVideoURI(Uri uri1)
    {
        uri = uri1;
        if (uri1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (progressRunnable != null)
        {
            synchronized (progressRunnable)
            {
                progressRunnable.cancel();
                currentState = 0;
            }
        }
        if (mediaPlayer != null)
        {
            mediaPlayer.setDisplay(null);
            mediaPlayer.reset();
            mediaPlayer.release();
            currentState = 0;
        }
        mediaPlayer = new MediaPlayer();
        if (surfaceHolder != null)
        {
            mediaPlayer.setDisplay(surfaceHolder);
        }
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.setOnSeekCompleteListener(this);
        mediaPlayer.setOnInfoListener(this);
        mediaPlayer.setOnVideoSizeChangedListener(this);
        try
        {
            mediaPlayer.setDataSource(getContext(), uri1, null);
            currentState = 1;
            mediaPlayer.prepareAsync();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri1)
        {
            MMLog.e(TAG, "An error occurred preparing the VideoPlayer.", uri1);
        }
        currentState = 7;
        targetState = 7;
        if (videoViewListener == null) goto _L1; else goto _L3
_L3:
        ThreadUtils.runOnWorkerThread(new Runnable() {

            final MMVideoView this$0;

            public void run()
            {
                videoViewListener.onError(MMVideoView.this);
            }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
        });
        return;
        uri1;
        scheduledrunnable;
        JVM INSTR monitorexit ;
        throw uri1;
    }

    public void setVideoViewListener(MMVideoViewListener mmvideoviewlistener)
    {
        videoViewListener = mmvideoviewlistener;
    }

    public void start()
    {
        if (isInPlaybackState() && currentState != 4)
        {
            if (muted)
            {
                mute();
            }
            if (seekToMilliseconds != 0)
            {
                mediaPlayer.seekTo(seekToMilliseconds);
                seekToMilliseconds = 0;
            }
            mediaPlayer.start();
            currentState = 4;
            targetState = 4;
            if (videoViewListener != null)
            {
                ThreadUtils.runOnWorkerThread(new Runnable() {

                    final MMVideoView this$0;

                    public void run()
                    {
                        videoViewListener.onStart(MMVideoView.this);
                    }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
                });
            }
            if (mediaController != null)
            {
                ThreadUtils.runOnWorkerThread(new Runnable() {

                    final MMVideoView this$0;

                    public void run()
                    {
                        mediaController.onStart();
                    }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
                });
            }
            if (progressRunnable != null)
            {
                progressRunnable.cancel();
            }
            progressRunnable = ThreadUtils.runOnWorkerThreadDelayed(new ProgressRunnable(), 100L);
            return;
        } else
        {
            targetState = 4;
            return;
        }
    }

    public void stop()
    {
        releaseAudioFocus();
        if (isInPlaybackState() && (mediaPlayer.isPlaying() || currentState == 5))
        {
            mediaPlayer.stop();
            if (videoViewListener != null)
            {
                ThreadUtils.runOnWorkerThread(new Runnable() {

                    final MMVideoView this$0;

                    public void run()
                    {
                        videoViewListener.onStop(MMVideoView.this);
                    }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
                });
            }
            currentState = 0;
            targetState = 0;
        }
    }

    public void unmute()
    {
        muted = false;
        mediaPlayer.setVolume(1.0F, 1.0F);
        setAudioFocus();
        if (videoViewListener != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    videoViewListener.onUnmuted(MMVideoView.this);
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
        if (mediaController != null)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final MMVideoView this$0;

                public void run()
                {
                    mediaController.onUnmuted();
                }

            
            {
                this$0 = MMVideoView.this;
                super();
            }
            });
        }
    }




/*
    static com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable access$1002(MMVideoView mmvideoview, com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable scheduledrunnable)
    {
        mmvideoview.progressRunnable = scheduledrunnable;
        return scheduledrunnable;
    }

*/




/*
    static SurfaceHolder access$302(MMVideoView mmvideoview, SurfaceHolder surfaceholder)
    {
        mmvideoview.surfaceHolder = surfaceholder;
        return surfaceholder;
    }

*/




/*
    static int access$502(MMVideoView mmvideoview, int i)
    {
        mmvideoview.currentState = i;
        return i;
    }

*/




}
