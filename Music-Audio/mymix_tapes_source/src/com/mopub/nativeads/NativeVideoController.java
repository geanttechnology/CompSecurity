// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorSampleSource;
import com.google.android.exoplayer.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer.upstream.DefaultAllocator;
import com.mopub.common.Preconditions;
import com.mopub.common.event.Event;
import com.mopub.common.event.EventDetails;
import com.mopub.common.event.MoPubEvents;
import com.mopub.mobileads.RepeatingHandlerRunnable;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.network.TrackingRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.mopub.nativeads:
//            HttpDiskCompositeDataSource

public class NativeVideoController
    implements com.google.android.exoplayer.ExoPlayer.Listener, android.media.AudioManager.OnAudioFocusChangeListener
{
    static class ExoPlayerFactory
    {

        public ExoPlayer newInstance(int i, int j, int k)
        {
            return com.google.android.exoplayer.ExoPlayer.Factory.newInstance(i, j, k);
        }

        ExoPlayerFactory()
        {
        }
    }

    public static interface Listener
    {

        public abstract void onError(Exception exception);

        public abstract void onStateChanged(boolean flag, int i);
    }

    static class NativeVideoProgressRunnable extends RepeatingHandlerRunnable
    {

        private final Context mContext;
        private long mCurrentPosition;
        private long mDuration;
        private ExoPlayer mExoPlayer;
        private ProgressListener mProgressListener;
        private TextureView mTextureView;
        private final VastVideoConfig mVastVideoConfig;
        private final VisibilityTracker.VisibilityChecker mVisibilityChecker;
        private final List mVisibilityTrackingEvents;

        void checkImpressionTrackers(boolean flag)
        {
            Iterator iterator = mVisibilityTrackingEvents.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                VisibilityTrackingEvent visibilitytrackingevent = (VisibilityTrackingEvent)iterator.next();
                if (!visibilitytrackingevent.isTracked && (flag || mVisibilityChecker.isVisible(mTextureView, mTextureView, visibilitytrackingevent.minimumPercentageVisible)))
                {
                    visibilitytrackingevent.totalQualifiedPlayCounter = (int)((long)visibilitytrackingevent.totalQualifiedPlayCounter + mUpdateIntervalMillis);
                    if (flag || visibilitytrackingevent.totalQualifiedPlayCounter >= visibilitytrackingevent.totalRequiredPlayTimeMs)
                    {
                        visibilitytrackingevent.strategy.execute();
                        visibilitytrackingevent.isTracked = true;
                    }
                }
            } while (true);
        }

        public void doWork()
        {
            if (mExoPlayer != null && mExoPlayer.getPlayWhenReady())
            {
                mCurrentPosition = mExoPlayer.getCurrentPosition();
                mDuration = mExoPlayer.getDuration();
                if (mDuration > 0L)
                {
                    checkImpressionTrackers(false);
                    if (mProgressListener != null)
                    {
                        float f = (float)mCurrentPosition / (float)mDuration;
                        mProgressListener.updateProgress((int)(f * 1000F));
                    }
                    Object obj = mVastVideoConfig.getUntriggeredTrackersBefore((int)mCurrentPosition, (int)mDuration);
                    if (!((List) (obj)).isEmpty())
                    {
                        ArrayList arraylist = new ArrayList();
                        obj = ((List) (obj)).iterator();
                        do
                        {
                            if (!((Iterator) (obj)).hasNext())
                            {
                                break;
                            }
                            VastTracker vasttracker = (VastTracker)((Iterator) (obj)).next();
                            if (!vasttracker.isTracked())
                            {
                                arraylist.add(vasttracker.getTrackingUrl());
                                vasttracker.setTracked();
                            }
                        } while (true);
                        TrackingRequest.makeTrackingHttpRequest(arraylist, mContext);
                        return;
                    }
                }
            }
        }

        long getCurrentPosition()
        {
            return mCurrentPosition;
        }

        long getDuration()
        {
            return mDuration;
        }

        void seekTo(long l)
        {
            mCurrentPosition = l;
        }

        void setExoPlayer(ExoPlayer exoplayer)
        {
            mExoPlayer = exoplayer;
        }

        void setProgressListener(ProgressListener progresslistener)
        {
            mProgressListener = progresslistener;
        }

        void setTextureView(TextureView textureview)
        {
            mTextureView = textureview;
        }

        void setUpdateIntervalMillis(long l)
        {
            mUpdateIntervalMillis = l;
        }

        NativeVideoProgressRunnable(Context context, Handler handler, List list, VastVideoConfig vastvideoconfig)
        {
            this(context, handler, list, new VisibilityTracker.VisibilityChecker(), vastvideoconfig);
        }

        NativeVideoProgressRunnable(Context context, Handler handler, List list, VisibilityTracker.VisibilityChecker visibilitychecker, VastVideoConfig vastvideoconfig)
        {
            super(handler);
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(handler);
            Preconditions.checkNotNull(list);
            Preconditions.checkNotNull(vastvideoconfig);
            mContext = context.getApplicationContext();
            mVisibilityTrackingEvents = list;
            mVisibilityChecker = visibilitychecker;
            mVastVideoConfig = vastvideoconfig;
            mDuration = -1L;
        }
    }

    public static interface NativeVideoProgressRunnable.ProgressListener
    {

        public abstract void updateProgress(int i);
    }

    static class VisibilityTrackingEvent
    {

        boolean isTracked;
        int minimumPercentageVisible;
        OnTrackedStrategy strategy;
        int totalQualifiedPlayCounter;
        int totalRequiredPlayTimeMs;

        VisibilityTrackingEvent()
        {
        }
    }

    static interface VisibilityTrackingEvent.OnTrackedStrategy
    {

        public abstract void execute();
    }


    private static final int BUFFER_SEGMENT_COUNT = 32;
    private static final int BUFFER_SEGMENT_SIZE = 0x10000;
    public static final long RESUME_FINISHED_THRESHOLD = 750L;
    public static final int STATE_BUFFERING = 3;
    public static final int STATE_CLEARED = 6;
    public static final int STATE_ENDED = 5;
    public static final int STATE_IDLE = 1;
    public static final int STATE_PREPARING = 2;
    public static final int STATE_READY = 4;
    private static final Map sManagerMap = new HashMap(4);
    private boolean mAppAudioEnabled;
    private boolean mAudioEnabled;
    private AudioManager mAudioManager;
    private MediaCodecAudioTrackRenderer mAudioTrackRenderer;
    private final Context mContext;
    private EventDetails mEventDetails;
    private volatile ExoPlayer mExoPlayer;
    private final ExoPlayerFactory mExoPlayerFactory;
    private boolean mExoPlayerStateStartedFromIdle;
    private BitmapDrawable mFinalFrame;
    private final Handler mHandler;
    private Listener mListener;
    private NativeVideoProgressRunnable mNativeVideoProgressRunnable;
    private android.media.AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;
    private WeakReference mOwnerRef;
    private boolean mPlayWhenReady;
    private int mPreviousExoPlayerState;
    private Surface mSurface;
    private TextureView mTextureView;
    private VastVideoConfig mVastVideoConfig;
    private MediaCodecVideoTrackRenderer mVideoTrackRenderer;

    private NativeVideoController(Context context, VastVideoConfig vastvideoconfig, NativeVideoProgressRunnable nativevideoprogressrunnable, ExoPlayerFactory exoplayerfactory, EventDetails eventdetails, AudioManager audiomanager)
    {
        mPreviousExoPlayerState = 1;
        mExoPlayerStateStartedFromIdle = true;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastvideoconfig);
        Preconditions.checkNotNull(exoplayerfactory);
        Preconditions.checkNotNull(audiomanager);
        mContext = context.getApplicationContext();
        mHandler = new Handler(Looper.getMainLooper());
        mVastVideoConfig = vastvideoconfig;
        mNativeVideoProgressRunnable = nativevideoprogressrunnable;
        mExoPlayerFactory = exoplayerfactory;
        mEventDetails = eventdetails;
        mAudioManager = audiomanager;
    }

    private NativeVideoController(Context context, List list, VastVideoConfig vastvideoconfig, EventDetails eventdetails)
    {
        this(context, vastvideoconfig, new NativeVideoProgressRunnable(context, new Handler(Looper.getMainLooper()), list, vastvideoconfig), new ExoPlayerFactory(), eventdetails, (AudioManager)context.getSystemService("audio"));
    }

    private void clearExistingPlayer()
    {
        if (mExoPlayer == null)
        {
            return;
        } else
        {
            setExoSurface(null);
            mExoPlayer.stop();
            mExoPlayer.release();
            mExoPlayer = null;
            mNativeVideoProgressRunnable.setExoPlayer(null);
            return;
        }
    }

    public static NativeVideoController createForId(long l, Context context, VastVideoConfig vastvideoconfig, NativeVideoProgressRunnable nativevideoprogressrunnable, ExoPlayerFactory exoplayerfactory, EventDetails eventdetails, AudioManager audiomanager)
    {
        context = new NativeVideoController(context, vastvideoconfig, nativevideoprogressrunnable, exoplayerfactory, eventdetails, audiomanager);
        sManagerMap.put(Long.valueOf(l), context);
        return context;
    }

    public static NativeVideoController createForId(long l, Context context, List list, VastVideoConfig vastvideoconfig, EventDetails eventdetails)
    {
        context = new NativeVideoController(context, list, vastvideoconfig, eventdetails);
        sManagerMap.put(Long.valueOf(l), context);
        return context;
    }

    public static NativeVideoController getForId(long l)
    {
        return (NativeVideoController)sManagerMap.get(Long.valueOf(l));
    }

    private void preparePlayer()
    {
        if (mExoPlayer == null)
        {
            mExoPlayer = mExoPlayerFactory.newInstance(2, 1000, 5000);
            mNativeVideoProgressRunnable.setExoPlayer(mExoPlayer);
            mExoPlayer.addListener(this);
            Object obj = new DefaultAllocator(0x10000);
            Mp4Extractor mp4extractor = new Mp4Extractor();
            HttpDiskCompositeDataSource httpdiskcompositedatasource = new HttpDiskCompositeDataSource(mContext, "exo_demo", mEventDetails);
            obj = new ExtractorSampleSource(Uri.parse(mVastVideoConfig.getNetworkMediaFileUrl()), httpdiskcompositedatasource, ((com.google.android.exoplayer.upstream.Allocator) (obj)), 0x200000, new Extractor[] {
                mp4extractor
            });
            mVideoTrackRenderer = new MediaCodecVideoTrackRenderer(((com.google.android.exoplayer.SampleSource) (obj)), 2, 0L, mHandler, null, 10);
            mAudioTrackRenderer = new MediaCodecAudioTrackRenderer(((com.google.android.exoplayer.SampleSource) (obj)));
            mExoPlayer.prepare(new TrackRenderer[] {
                mAudioTrackRenderer, mVideoTrackRenderer
            });
        }
        setExoAudio();
        setExoPlayWhenReady();
    }

    public static NativeVideoController remove(long l)
    {
        return (NativeVideoController)sManagerMap.remove(Long.valueOf(l));
    }

    private void setExoAudio()
    {
        float f;
        if (mAudioEnabled)
        {
            f = 1.0F;
        } else
        {
            f = 0.0F;
        }
        setExoAudio(f);
    }

    private void setExoAudio(float f)
    {
        boolean flag;
        if (f >= 0.0F && f <= 1.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (mExoPlayer == null)
        {
            return;
        } else
        {
            mExoPlayer.sendMessage(mAudioTrackRenderer, 1, Float.valueOf(f));
            return;
        }
    }

    private void setExoPlayWhenReady()
    {
        if (mExoPlayer == null)
        {
            return;
        } else
        {
            mExoPlayer.setPlayWhenReady(mPlayWhenReady);
            startProgressRunnable(mExoPlayer.getPlayWhenReady(), mExoPlayer.getPlaybackState());
            return;
        }
    }

    private void setExoSurface(Surface surface)
    {
        if (mExoPlayer == null)
        {
            return;
        } else
        {
            mExoPlayer.sendMessage(mVideoTrackRenderer, 1, surface);
            return;
        }
    }

    static void setForId(long l, NativeVideoController nativevideocontroller)
    {
        sManagerMap.put(Long.valueOf(l), nativevideocontroller);
    }

    private void startProgressRunnable(boolean flag, int i)
    {
        if (flag && i == 4)
        {
            mNativeVideoProgressRunnable.startRepeating(50L);
            return;
        } else
        {
            mNativeVideoProgressRunnable.stop();
            return;
        }
    }

    public void clear()
    {
        setPlayWhenReady(false);
        mSurface = null;
        clearExistingPlayer();
    }

    public long getCurrentPosition()
    {
        return mNativeVideoProgressRunnable.getCurrentPosition();
    }

    public long getDuration()
    {
        return mNativeVideoProgressRunnable.getDuration();
    }

    public Drawable getFinalFrame()
    {
        return mFinalFrame;
    }

    public int getPlaybackState()
    {
        if (mExoPlayer == null)
        {
            return 6;
        } else
        {
            return mExoPlayer.getPlaybackState();
        }
    }

    public void handleCtaClick(Context context)
    {
        triggerImpressionTrackers();
        mVastVideoConfig.handleClickWithoutResult(context, 0);
    }

    public boolean hasFinalFrame()
    {
        return mFinalFrame != null;
    }

    public void onAudioFocusChange(int i)
    {
        if (mOnAudioFocusChangeListener == null)
        {
            return;
        } else
        {
            mOnAudioFocusChangeListener.onAudioFocusChange(i);
            return;
        }
    }

    public void onPlayWhenReadyCommitted()
    {
    }

    public void onPlayerError(ExoPlaybackException exoplaybackexception)
    {
        if (mListener == null)
        {
            return;
        } else
        {
            MoPubEvents.log(Event.createEventFromDetails(com.mopub.common.event.BaseEvent.Name.ERROR_DURING_PLAYBACK, com.mopub.common.event.BaseEvent.Category.NATIVE_VIDEO, com.mopub.common.event.BaseEvent.SamplingRate.NATIVE_VIDEO, mEventDetails));
            mListener.onError(exoplaybackexception);
            return;
        }
    }

    public void onPlayerStateChanged(boolean flag, int i)
    {
        startProgressRunnable(flag, i);
        if (i == 5 && mFinalFrame == null)
        {
            mFinalFrame = new BitmapDrawable(mContext.getResources(), mTextureView.getBitmap());
        }
        if (mPreviousExoPlayerState == 4 && i == 3)
        {
            MoPubEvents.log(Event.createEventFromDetails(com.mopub.common.event.BaseEvent.Name.DOWNLOAD_BUFFERING, com.mopub.common.event.BaseEvent.Category.NATIVE_VIDEO, com.mopub.common.event.BaseEvent.SamplingRate.NATIVE_VIDEO, mEventDetails));
        }
        if (mExoPlayerStateStartedFromIdle && mPreviousExoPlayerState == 3 && i == 4)
        {
            MoPubEvents.log(Event.createEventFromDetails(com.mopub.common.event.BaseEvent.Name.DOWNLOAD_VIDEO_READY, com.mopub.common.event.BaseEvent.Category.NATIVE_VIDEO, com.mopub.common.event.BaseEvent.SamplingRate.NATIVE_VIDEO, mEventDetails));
        }
        mPreviousExoPlayerState = i;
        if (i != 4) goto _L2; else goto _L1
_L1:
        mExoPlayerStateStartedFromIdle = false;
_L4:
        if (mListener != null)
        {
            mListener.onStateChanged(flag, i);
        }
        return;
_L2:
        if (i == 1)
        {
            mExoPlayerStateStartedFromIdle = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void prepare(Object obj)
    {
        Preconditions.checkNotNull(obj);
        mOwnerRef = new WeakReference(obj);
        clearExistingPlayer();
        preparePlayer();
        setExoSurface(mSurface);
    }

    public void release(Object obj)
    {
        Preconditions.checkNotNull(obj);
        Object obj1;
        if (mOwnerRef == null)
        {
            obj1 = null;
        } else
        {
            obj1 = mOwnerRef.get();
        }
        if (obj1 == obj)
        {
            clearExistingPlayer();
        }
    }

    public void seekTo(long l)
    {
        if (mExoPlayer == null)
        {
            return;
        } else
        {
            mExoPlayer.seekTo(l);
            mNativeVideoProgressRunnable.seekTo(l);
            return;
        }
    }

    public void setAppAudioEnabled(boolean flag)
    {
        if (mAppAudioEnabled == flag)
        {
            return;
        }
        mAppAudioEnabled = flag;
        if (mAppAudioEnabled)
        {
            mAudioManager.requestAudioFocus(this, 3, 1);
            return;
        } else
        {
            mAudioManager.abandonAudioFocus(this);
            return;
        }
    }

    public void setAudioEnabled(boolean flag)
    {
        mAudioEnabled = flag;
        setExoAudio();
    }

    public void setAudioVolume(float f)
    {
        if (!mAudioEnabled)
        {
            return;
        } else
        {
            setExoAudio(f);
            return;
        }
    }

    public void setListener(Listener listener)
    {
        mListener = listener;
    }

    public void setOnAudioFocusChangeListener(android.media.AudioManager.OnAudioFocusChangeListener onaudiofocuschangelistener)
    {
        mOnAudioFocusChangeListener = onaudiofocuschangelistener;
    }

    public void setPlayWhenReady(boolean flag)
    {
        if (mPlayWhenReady == flag)
        {
            return;
        } else
        {
            mPlayWhenReady = flag;
            setExoPlayWhenReady();
            return;
        }
    }

    public void setProgressListener(NativeVideoProgressRunnable.ProgressListener progresslistener)
    {
        mNativeVideoProgressRunnable.setProgressListener(progresslistener);
    }

    public void setTextureView(TextureView textureview)
    {
        Preconditions.checkNotNull(textureview);
        mSurface = new Surface(textureview.getSurfaceTexture());
        mTextureView = textureview;
        mNativeVideoProgressRunnable.setTextureView(mTextureView);
        setExoSurface(mSurface);
    }

    void triggerImpressionTrackers()
    {
        mNativeVideoProgressRunnable.checkImpressionTrackers(true);
    }

}
