// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.Preconditions;
import com.mopub.common.event.Event;
import com.mopub.common.event.EventDetails;
import com.mopub.common.event.MoPubEvents;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import com.mopub.mobileads.VastManager;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.mobileads.VideoViewabilityTracker;
import com.mopub.mobileads.factories.VastManagerFactory;
import com.mopub.network.TrackingRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mopub.nativeads:
//            CustomEventNative, NativeErrorCode, VideoNativeAd, VisibilityTracker, 
//            MediaLayout, NativeVideoController, NativeImageHelper

public class MoPubCustomEventVideoNative extends CustomEventNative
{
    static class HeaderVisibilityStrategy
        implements NativeVideoController.VisibilityTrackingEvent.OnTrackedStrategy
    {

        private final WeakReference mMoPubVideoNativeAd;

        public void execute()
        {
            MoPubVideoNativeAd mopubvideonativead = (MoPubVideoNativeAd)mMoPubVideoNativeAd.get();
            if (mopubvideonativead != null)
            {
                mopubvideonativead.notifyAdImpressed();
            }
        }

        HeaderVisibilityStrategy(MoPubVideoNativeAd mopubvideonativead)
        {
            mMoPubVideoNativeAd = new WeakReference(mopubvideonativead);
        }
    }

    public static class MoPubVideoNativeAd extends VideoNativeAd
        implements com.mopub.mobileads.VastManager.VastManagerListener, NativeVideoController.NativeVideoProgressRunnable.ProgressListener, android.media.AudioManager.OnAudioFocusChangeListener
    {

        static final String PRIVACY_INFORMATION_CLICKTHROUGH_URL = "https://www.mopub.com/optout/";
        private final String mClickTrackingUrl;
        private final Context mContext;
        private final CustomEventNative.CustomEventNativeListener mCustomEventNativeListener;
        private boolean mEnded;
        private boolean mError;
        private final EventDetails mEventDetails;
        private final long mId;
        private final JSONObject mJsonObject;
        private int mLatestVideoControllerState;
        private boolean mLatestVisibility;
        private MediaLayout mMediaLayout;
        private boolean mMuted;
        private NativeVideoController mNativeVideoController;
        private final NativeVideoControllerFactory mNativeVideoControllerFactory;
        private boolean mNeedsPrepare;
        private boolean mNeedsSeek;
        private View mRootView;
        private final VastManager mVastManager;
        VastVideoConfig mVastVideoConfig;
        private final VideoResponseHeaders mVideoResponseHeaders;
        private VideoState mVideoState;
        private final VisibilityTracker mVideoVisibleTracking;

        private void addImpressionTrackers(Object obj)
            throws ClassCastException
        {
            if (!(obj instanceof JSONArray))
            {
                throw new ClassCastException("Expected impression trackers of type JSONArray.");
            }
            obj = (JSONArray)obj;
            int i = 0;
            while (i < ((JSONArray) (obj)).length()) 
            {
                try
                {
                    addImpressionTracker(((JSONArray) (obj)).getString(i));
                }
                catch (JSONException jsonexception)
                {
                    MoPubLog.d("Unable to parse impression trackers.");
                }
                i++;
            }
        }

        private void addInstanceVariable(Parameter parameter, Object obj)
            throws ClassCastException
        {
            Preconditions.checkNotNull(parameter);
            Preconditions.checkNotNull(obj);
            static class _cls1
            {

                static final int $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[];
                static final int $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[];

                static 
                {
                    $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState = new int[MoPubVideoNativeAd.VideoState.values().length];
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[MoPubVideoNativeAd.VideoState.FAILED_LOAD.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror15) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[MoPubVideoNativeAd.VideoState.CREATED.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror14) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[MoPubVideoNativeAd.VideoState.LOADING.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror13) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[MoPubVideoNativeAd.VideoState.BUFFERING.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror12) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[MoPubVideoNativeAd.VideoState.PAUSED.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror11) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[MoPubVideoNativeAd.VideoState.PLAYING.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[MoPubVideoNativeAd.VideoState.PLAYING_MUTED.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState[MoPubVideoNativeAd.VideoState.ENDED.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter = new int[MoPubVideoNativeAd.Parameter.values().length];
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[MoPubVideoNativeAd.Parameter.IMPRESSION_TRACKER.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[MoPubVideoNativeAd.Parameter.TITLE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[MoPubVideoNativeAd.Parameter.TEXT.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[MoPubVideoNativeAd.Parameter.IMAGE_URL.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[MoPubVideoNativeAd.Parameter.ICON_URL.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[MoPubVideoNativeAd.Parameter.CLICK_DESTINATION.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[MoPubVideoNativeAd.Parameter.CALL_TO_ACTION.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$mopub$nativeads$MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter[MoPubVideoNativeAd.Parameter.VAST_VIDEO.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd.Parameter[parameter.ordinal()];
            JVM INSTR tableswitch 1 8: default 196
        //                       1 90
        //                       2 131
        //                       3 140
        //                       4 149
        //                       5 158
        //                       6 167
        //                       7 176
        //                       8 185;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
            MoPubLog.d((new StringBuilder()).append("Unable to add JSON key to internal mapping: ").append(parameter.mName).toString());
            return;
_L2:
            try
            {
                addImpressionTrackers(obj);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            if (!parameter.mRequired)
            {
                MoPubLog.d((new StringBuilder()).append("Ignoring class cast exception for optional key: ").append(parameter.mName).toString());
                return;
            } else
            {
                throw obj;
            }
_L3:
            setTitle((String)obj);
            return;
_L4:
            setText((String)obj);
            return;
_L5:
            setMainImageUrl((String)obj);
            return;
_L6:
            setIconImageUrl((String)obj);
            return;
_L7:
            setClickDestinationUrl((String)obj);
            return;
_L8:
            setCallToAction((String)obj);
            return;
_L9:
            setVastVideo((String)obj);
            return;
        }

        private void cleanUpMediaLayout()
        {
            if (mMediaLayout != null)
            {
                mMediaLayout.setMode(MediaLayout.Mode.IMAGE);
                mMediaLayout.setSurfaceTextureListener(null);
                mMediaLayout.setPlayButtonClickListener(null);
                mMediaLayout.setMuteControlClickListener(null);
                mMediaLayout.setOnClickListener(null);
                mVideoVisibleTracking.removeView(mMediaLayout);
                mMediaLayout = null;
            }
        }

        private boolean containsRequiredKeys(JSONObject jsonobject)
        {
            Preconditions.checkNotNull(jsonobject);
            HashSet hashset = new HashSet();
            for (jsonobject = jsonobject.keys(); jsonobject.hasNext(); hashset.add(jsonobject.next())) { }
            return hashset.containsAll(Parameter.requiredKeys);
        }

        private List getAllImageUrls()
        {
            ArrayList arraylist = new ArrayList();
            if (getMainImageUrl() != null)
            {
                arraylist.add(getMainImageUrl());
            }
            if (getIconImageUrl() != null)
            {
                arraylist.add(getIconImageUrl());
            }
            arraylist.addAll(getExtrasImageUrls());
            return arraylist;
        }

        private List getExtrasImageUrls()
        {
            ArrayList arraylist = new ArrayList(getExtras().size());
            Iterator iterator = getExtras().entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (isImageKey((String)entry.getKey()) && (entry.getValue() instanceof String))
                {
                    arraylist.add((String)entry.getValue());
                }
            } while (true);
            return arraylist;
        }

        private boolean isImageKey(String s)
        {
            return s != null && s.toLowerCase(Locale.US).endsWith("image");
        }

        private void maybeChangeState()
        {
            VideoState videostate = mVideoState;
            if (!mError) goto _L2; else goto _L1
_L1:
            videostate = VideoState.FAILED_LOAD;
_L4:
            applyState(videostate);
            return;
_L2:
            if (mEnded)
            {
                videostate = VideoState.ENDED;
            } else
            if (mLatestVideoControllerState == 2 || mLatestVideoControllerState == 1)
            {
                videostate = VideoState.LOADING;
            } else
            if (mLatestVideoControllerState == 3)
            {
                videostate = VideoState.BUFFERING;
            } else
            if (mLatestVideoControllerState == 5)
            {
                mEnded = true;
                videostate = VideoState.ENDED;
            } else
            if (mLatestVideoControllerState == 4)
            {
                if (mLatestVisibility)
                {
                    if (mMuted)
                    {
                        videostate = VideoState.PLAYING_MUTED;
                    } else
                    {
                        videostate = VideoState.PLAYING;
                    }
                } else
                {
                    videostate = VideoState.PAUSED;
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void prepareToLeaveView()
        {
            mNeedsSeek = true;
            mNeedsPrepare = true;
            mNativeVideoController.setListener(null);
            mNativeVideoController.setOnAudioFocusChangeListener(null);
            mNativeVideoController.setProgressListener(null);
            mNativeVideoController.clear();
            applyState(VideoState.PAUSED, true);
        }

        void applyState(VideoState videostate)
        {
            applyState(videostate, false);
        }

        void applyState(VideoState videostate, boolean flag)
        {
            Preconditions.checkNotNull(videostate);
            if (mVideoState == videostate)
            {
                return;
            }
            _cls1..SwitchMap.com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd.VideoState[videostate.ordinal()];
            JVM INSTR tableswitch 1 8: default 68
        //                       1 74
        //                       2 147
        //                       3 147
        //                       4 168
        //                       5 189
        //                       6 222
        //                       7 295
        //                       8 368;
               goto _L1 _L2 _L3 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
            mVideoState = videostate;
            return;
_L2:
            mVastVideoConfig.handleError(mContext, null, 0);
            mNativeVideoController.setAppAudioEnabled(false);
            mMediaLayout.setMode(MediaLayout.Mode.IMAGE);
            if (mVideoState != VideoState.PLAYING && mVideoState != VideoState.PLAYING_MUTED)
            {
                MoPubEvents.log(Event.createEventFromDetails(com.mopub.common.event.BaseEvent.Name.ERROR_FAILED_TO_PLAY, com.mopub.common.event.BaseEvent.Category.NATIVE_VIDEO, com.mopub.common.event.BaseEvent.SamplingRate.NATIVE_VIDEO, mEventDetails));
            }
            continue; /* Loop/switch isn't completed */
_L3:
            mNativeVideoController.setPlayWhenReady(true);
            mMediaLayout.setMode(MediaLayout.Mode.LOADING);
            continue; /* Loop/switch isn't completed */
_L4:
            mNativeVideoController.setPlayWhenReady(true);
            mMediaLayout.setMode(MediaLayout.Mode.BUFFERING);
            continue; /* Loop/switch isn't completed */
_L5:
            if (!flag)
            {
                mNativeVideoController.setAppAudioEnabled(false);
            }
            mNativeVideoController.setPlayWhenReady(false);
            mMediaLayout.setMode(MediaLayout.Mode.PAUSED);
            continue; /* Loop/switch isn't completed */
_L6:
            if (mNeedsSeek)
            {
                mNeedsSeek = false;
                mNativeVideoController.seekTo(mNativeVideoController.getCurrentPosition());
            }
            mNativeVideoController.setPlayWhenReady(true);
            mNativeVideoController.setAudioEnabled(true);
            mNativeVideoController.setAppAudioEnabled(true);
            mMediaLayout.setMode(MediaLayout.Mode.PLAYING);
            mMediaLayout.setMuteState(MediaLayout.MuteState.UNMUTED);
            continue; /* Loop/switch isn't completed */
_L7:
            if (mNeedsSeek)
            {
                mNeedsSeek = false;
                mNativeVideoController.seekTo(mNativeVideoController.getCurrentPosition());
            }
            mNativeVideoController.setPlayWhenReady(true);
            mNativeVideoController.setAudioEnabled(false);
            mNativeVideoController.setAppAudioEnabled(false);
            mMediaLayout.setMode(MediaLayout.Mode.PLAYING);
            mMediaLayout.setMuteState(MediaLayout.MuteState.MUTED);
            continue; /* Loop/switch isn't completed */
_L8:
            if (mNativeVideoController.hasFinalFrame())
            {
                mMediaLayout.setMainImageDrawable(mNativeVideoController.getFinalFrame());
            }
            mVastVideoConfig.handleComplete(mContext, 0);
            mNativeVideoController.setAppAudioEnabled(false);
            mMediaLayout.setMode(MediaLayout.Mode.FINISHED);
            mMediaLayout.updateProgress(1000);
            if (true) goto _L1; else goto _L9
_L9:
        }

        public void clear(View view)
        {
            Preconditions.checkNotNull(view);
            mNativeVideoController.clear();
            cleanUpMediaLayout();
        }

        public void destroy()
        {
            cleanUpMediaLayout();
            mNativeVideoController.setPlayWhenReady(false);
            mNativeVideoController.release(this);
            NativeVideoController.remove(mId);
            mVideoVisibleTracking.destroy();
        }

        long getId()
        {
            return mId;
        }

        MediaLayout getMediaLayout()
        {
            return mMediaLayout;
        }

        VideoState getVideoState()
        {
            return mVideoState;
        }

        boolean hasEnded()
        {
            return mEnded;
        }

        boolean isMuted()
        {
            return mMuted;
        }

        void loadAd()
            throws IllegalArgumentException
        {
            if (!containsRequiredKeys(mJsonObject))
            {
                throw new IllegalArgumentException("JSONObject did not contain required keys.");
            }
            for (Iterator iterator = mJsonObject.keys(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                Parameter parameter = Parameter.from(s);
                if (parameter != null)
                {
                    try
                    {
                        addInstanceVariable(parameter, mJsonObject.opt(s));
                    }
                    catch (ClassCastException classcastexception)
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("JSONObject key (").append(s).append(") contained unexpected value.").toString());
                    }
                } else
                {
                    addExtra(s, mJsonObject.opt(s));
                }
            }

            setPrivacyInformationIconClickThroughUrl("https://www.mopub.com/optout/");
            NativeImageHelper.preCacheImages(mContext, getAllImageUrls(), new NativeImageHelper.ImageListener() {

                final MoPubVideoNativeAd this$0;

                public void onImagesCached()
                {
                    mVastManager.prepareVastVideoConfiguration(getVastVideo(), MoPubVideoNativeAd.this, mContext);
                }

                public void onImagesFailedToCache(NativeErrorCode nativeerrorcode)
                {
                    mCustomEventNativeListener.onNativeAdFailed(nativeerrorcode);
                }

            
            {
                this$0 = MoPubVideoNativeAd.this;
                super();
            }
            });
        }

        boolean needsPrepare()
        {
            return mNeedsPrepare;
        }

        boolean needsSeek()
        {
            return mNeedsSeek;
        }

        public void onAudioFocusChange(int i)
        {
            if (i == -1 || i == -2)
            {
                mMuted = true;
                maybeChangeState();
            } else
            {
                if (i == -3)
                {
                    mNativeVideoController.setAudioVolume(0.3F);
                    return;
                }
                if (i == 1)
                {
                    mNativeVideoController.setAudioVolume(1.0F);
                    maybeChangeState();
                    return;
                }
            }
        }

        public void onError(Exception exception)
        {
            MoPubLog.w("Error playing back video.", exception);
            mError = true;
            maybeChangeState();
        }

        public void onStateChanged(boolean flag, int i)
        {
            mLatestVideoControllerState = i;
            maybeChangeState();
        }

        public void onVastVideoConfigurationPrepared(VastVideoConfig vastvideoconfig)
        {
            if (vastvideoconfig == null)
            {
                mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.EMPTY_AD_RESPONSE);
                return;
            }
            ArrayList arraylist = new ArrayList();
            NativeVideoController.VisibilityTrackingEvent visibilitytrackingevent = new NativeVideoController.VisibilityTrackingEvent();
            visibilitytrackingevent.strategy = new HeaderVisibilityStrategy(this);
            visibilitytrackingevent.minimumPercentageVisible = mVideoResponseHeaders.getImpressionMinVisiblePercent();
            visibilitytrackingevent.totalRequiredPlayTimeMs = mVideoResponseHeaders.getImpressionVisibleMs();
            arraylist.add(visibilitytrackingevent);
            mVastVideoConfig = vastvideoconfig;
            vastvideoconfig = mVastVideoConfig.getVideoViewabilityTracker();
            if (vastvideoconfig != null)
            {
                NativeVideoController.VisibilityTrackingEvent visibilitytrackingevent1 = new NativeVideoController.VisibilityTrackingEvent();
                visibilitytrackingevent1.strategy = new PayloadVisibilityStrategy(mContext, vastvideoconfig.getTrackingUrl());
                visibilitytrackingevent1.minimumPercentageVisible = vastvideoconfig.getPercentViewable();
                visibilitytrackingevent1.totalRequiredPlayTimeMs = vastvideoconfig.getViewablePlaytimeMS();
                arraylist.add(visibilitytrackingevent1);
            }
            vastvideoconfig = new VastTracker(mClickTrackingUrl, false);
            mVastVideoConfig.addClickTrackers(new ArrayList(Arrays.asList(new VastTracker[] {
                vastvideoconfig
            })));
            mVastVideoConfig.setClickThroughUrl(getClickDestinationUrl());
            mNativeVideoController = mNativeVideoControllerFactory.createForId(mId, mContext, arraylist, mVastVideoConfig, mEventDetails);
            mCustomEventNativeListener.onNativeAdLoaded(this);
        }

        public void prepare(View view)
        {
            Preconditions.checkNotNull(view);
            mRootView = view;
            mRootView.setOnClickListener(new android.view.View.OnClickListener() {

                final MoPubVideoNativeAd this$0;

                public void onClick(View view)
                {
                    prepareToLeaveView();
                    mNativeVideoController.triggerImpressionTrackers();
                    mNativeVideoController.handleCtaClick(mContext);
                }

            
            {
                this$0 = MoPubVideoNativeAd.this;
                super();
            }
            });
        }

        public void render(MediaLayout medialayout)
        {
            Preconditions.checkNotNull(medialayout);
            mVideoVisibleTracking.addView(mRootView, medialayout, mVideoResponseHeaders.getPlayVisiblePercent(), mVideoResponseHeaders.getPauseVisiblePercent());
            mMediaLayout = medialayout;
            mMediaLayout.initForVideo();
            mMediaLayout.setSurfaceTextureListener(new android.view.TextureView.SurfaceTextureListener() {

                final MoPubVideoNativeAd this$0;

                public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i, int j)
                {
                    mNativeVideoController.setListener(MoPubVideoNativeAd.this);
                    mNativeVideoController.setOnAudioFocusChangeListener(MoPubVideoNativeAd.this);
                    mNativeVideoController.setProgressListener(MoPubVideoNativeAd.this);
                    mNativeVideoController.setTextureView(mMediaLayout.getTextureView());
                    mMediaLayout.resetProgress();
                    long l = mNativeVideoController.getDuration();
                    long l1 = mNativeVideoController.getCurrentPosition();
                    if (mLatestVideoControllerState == 5 || l > 0L && l - l1 < 750L)
                    {
                        mEnded = true;
                    }
                    if (mNeedsPrepare)
                    {
                        mNeedsPrepare = false;
                        mNativeVideoController.prepare(MoPubVideoNativeAd.this);
                    }
                    mNeedsSeek = true;
                    maybeChangeState();
                }

                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
                {
                    mNeedsPrepare = true;
                    mNativeVideoController.release(MoPubVideoNativeAd.this);
                    applyState(MoPubVideoNativeAd.VideoState.PAUSED);
                    return true;
                }

                public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i, int j)
                {
                }

                public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
                {
                }

            
            {
                this$0 = MoPubVideoNativeAd.this;
                super();
            }
            });
            mMediaLayout.setPlayButtonClickListener(new android.view.View.OnClickListener() {

                final MoPubVideoNativeAd this$0;

                public void onClick(View view)
                {
                    mMediaLayout.resetProgress();
                    mNativeVideoController.seekTo(0L);
                    mEnded = false;
                    mNeedsSeek = false;
                }

            
            {
                this$0 = MoPubVideoNativeAd.this;
                super();
            }
            });
            mMediaLayout.setMuteControlClickListener(new android.view.View.OnClickListener() {

                final MoPubVideoNativeAd this$0;

                public void onClick(View view)
                {
                    view = MoPubVideoNativeAd.this;
                    boolean flag;
                    if (!mMuted)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    view.mMuted = flag;
                    maybeChangeState();
                }

            
            {
                this$0 = MoPubVideoNativeAd.this;
                super();
            }
            });
            mMediaLayout.setOnClickListener(new android.view.View.OnClickListener() {

                final MoPubVideoNativeAd this$0;

                public void onClick(View view)
                {
                    prepareToLeaveView();
                    mNativeVideoController.triggerImpressionTrackers();
                    MraidVideoPlayerActivity.startNativeVideo(mContext, mId, mVastVideoConfig);
                }

            
            {
                this$0 = MoPubVideoNativeAd.this;
                super();
            }
            });
            if (mNativeVideoController.getPlaybackState() == 6)
            {
                mNativeVideoController.prepare(this);
            }
            applyState(VideoState.PAUSED);
        }

        void setLatestVisibility(boolean flag)
        {
            mLatestVisibility = flag;
        }

        void setMuted(boolean flag)
        {
            mMuted = flag;
        }

        public void updateProgress(int i)
        {
            mMediaLayout.updateProgress(i);
        }



/*
        static boolean access$002(MoPubVideoNativeAd mopubvideonativead, boolean flag)
        {
            mopubvideonativead.mLatestVisibility = flag;
            return flag;
        }

*/



/*
        static boolean access$1002(MoPubVideoNativeAd mopubvideonativead, boolean flag)
        {
            mopubvideonativead.mNeedsSeek = flag;
            return flag;
        }

*/



/*
        static boolean access$1102(MoPubVideoNativeAd mopubvideonativead, boolean flag)
        {
            mopubvideonativead.mMuted = flag;
            return flag;
        }

*/










/*
        static boolean access$802(MoPubVideoNativeAd mopubvideonativead, boolean flag)
        {
            mopubvideonativead.mEnded = flag;
            return flag;
        }

*/



/*
        static boolean access$902(MoPubVideoNativeAd mopubvideonativead, boolean flag)
        {
            mopubvideonativead.mNeedsPrepare = flag;
            return flag;
        }

*/

        public MoPubVideoNativeAd(Context context, JSONObject jsonobject, CustomEventNative.CustomEventNativeListener customeventnativelistener, VideoResponseHeaders videoresponseheaders, EventDetails eventdetails, String s)
        {
            this(context, jsonobject, customeventnativelistener, videoresponseheaders, new VisibilityTracker(context), new NativeVideoControllerFactory(), eventdetails, s, VastManagerFactory.create(context.getApplicationContext(), false));
        }

        MoPubVideoNativeAd(Context context, JSONObject jsonobject, CustomEventNative.CustomEventNativeListener customeventnativelistener, VideoResponseHeaders videoresponseheaders, VisibilityTracker visibilitytracker, NativeVideoControllerFactory nativevideocontrollerfactory, EventDetails eventdetails, 
                String s, VastManager vastmanager)
        {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(jsonobject);
            Preconditions.checkNotNull(customeventnativelistener);
            Preconditions.checkNotNull(videoresponseheaders);
            Preconditions.checkNotNull(visibilitytracker);
            Preconditions.checkNotNull(nativevideocontrollerfactory);
            Preconditions.checkNotNull(s);
            Preconditions.checkNotNull(vastmanager);
            mContext = context.getApplicationContext();
            mJsonObject = jsonobject;
            mCustomEventNativeListener = customeventnativelistener;
            mVideoResponseHeaders = videoresponseheaders;
            mNativeVideoControllerFactory = nativevideocontrollerfactory;
            mClickTrackingUrl = s;
            mEventDetails = eventdetails;
            mId = Utils.generateUniqueId();
            mNeedsSeek = true;
            mVideoState = VideoState.CREATED;
            mNeedsPrepare = true;
            mLatestVideoControllerState = 1;
            mMuted = true;
            mVideoVisibleTracking = visibilitytracker;
            mVideoVisibleTracking.setVisibilityTrackerListener(new _cls1());
            mVastManager = vastmanager;
        }
    }

    static final class MoPubVideoNativeAd.Parameter extends Enum
    {

        private static final MoPubVideoNativeAd.Parameter $VALUES[];
        public static final MoPubVideoNativeAd.Parameter CALL_TO_ACTION;
        public static final MoPubVideoNativeAd.Parameter CLICK_DESTINATION;
        public static final MoPubVideoNativeAd.Parameter CLICK_TRACKER;
        public static final MoPubVideoNativeAd.Parameter FALLBACK;
        public static final MoPubVideoNativeAd.Parameter ICON_URL;
        public static final MoPubVideoNativeAd.Parameter IMAGE_URL;
        public static final MoPubVideoNativeAd.Parameter IMPRESSION_TRACKER;
        public static final MoPubVideoNativeAd.Parameter TEXT;
        public static final MoPubVideoNativeAd.Parameter TITLE;
        public static final MoPubVideoNativeAd.Parameter VAST_VIDEO;
        static final Set requiredKeys;
        final String mName;
        final boolean mRequired;

        static MoPubVideoNativeAd.Parameter from(String s)
        {
            Preconditions.checkNotNull(s);
            MoPubVideoNativeAd.Parameter aparameter[] = values();
            int j = aparameter.length;
            for (int i = 0; i < j; i++)
            {
                MoPubVideoNativeAd.Parameter parameter = aparameter[i];
                if (parameter.mName.equals(s))
                {
                    return parameter;
                }
            }

            return null;
        }

        public static MoPubVideoNativeAd.Parameter valueOf(String s)
        {
            return (MoPubVideoNativeAd.Parameter)Enum.valueOf(com/mopub/nativeads/MoPubCustomEventVideoNative$MoPubVideoNativeAd$Parameter, s);
        }

        public static MoPubVideoNativeAd.Parameter[] values()
        {
            return (MoPubVideoNativeAd.Parameter[])$VALUES.clone();
        }

        static 
        {
            IMPRESSION_TRACKER = new MoPubVideoNativeAd.Parameter("IMPRESSION_TRACKER", 0, "imptracker", true);
            CLICK_TRACKER = new MoPubVideoNativeAd.Parameter("CLICK_TRACKER", 1, "clktracker", true);
            TITLE = new MoPubVideoNativeAd.Parameter("TITLE", 2, "title", false);
            TEXT = new MoPubVideoNativeAd.Parameter("TEXT", 3, "text", false);
            IMAGE_URL = new MoPubVideoNativeAd.Parameter("IMAGE_URL", 4, "mainimage", false);
            ICON_URL = new MoPubVideoNativeAd.Parameter("ICON_URL", 5, "iconimage", false);
            CLICK_DESTINATION = new MoPubVideoNativeAd.Parameter("CLICK_DESTINATION", 6, "clk", false);
            FALLBACK = new MoPubVideoNativeAd.Parameter("FALLBACK", 7, "fallback", false);
            CALL_TO_ACTION = new MoPubVideoNativeAd.Parameter("CALL_TO_ACTION", 8, "ctatext", false);
            VAST_VIDEO = new MoPubVideoNativeAd.Parameter("VAST_VIDEO", 9, "video", false);
            $VALUES = (new MoPubVideoNativeAd.Parameter[] {
                IMPRESSION_TRACKER, CLICK_TRACKER, TITLE, TEXT, IMAGE_URL, ICON_URL, CLICK_DESTINATION, FALLBACK, CALL_TO_ACTION, VAST_VIDEO
            });
            requiredKeys = new HashSet();
            MoPubVideoNativeAd.Parameter aparameter[] = values();
            int j = aparameter.length;
            for (int i = 0; i < j; i++)
            {
                MoPubVideoNativeAd.Parameter parameter = aparameter[i];
                if (parameter.mRequired)
                {
                    requiredKeys.add(parameter.mName);
                }
            }

        }

        private MoPubVideoNativeAd.Parameter(String s, int i, String s1, boolean flag)
        {
            super(s, i);
            Preconditions.checkNotNull(s1);
            mName = s1;
            mRequired = flag;
        }
    }

    public static final class MoPubVideoNativeAd.VideoState extends Enum
    {

        private static final MoPubVideoNativeAd.VideoState $VALUES[];
        public static final MoPubVideoNativeAd.VideoState BUFFERING;
        public static final MoPubVideoNativeAd.VideoState CREATED;
        public static final MoPubVideoNativeAd.VideoState ENDED;
        public static final MoPubVideoNativeAd.VideoState FAILED_LOAD;
        public static final MoPubVideoNativeAd.VideoState LOADING;
        public static final MoPubVideoNativeAd.VideoState PAUSED;
        public static final MoPubVideoNativeAd.VideoState PLAYING;
        public static final MoPubVideoNativeAd.VideoState PLAYING_MUTED;

        public static MoPubVideoNativeAd.VideoState valueOf(String s)
        {
            return (MoPubVideoNativeAd.VideoState)Enum.valueOf(com/mopub/nativeads/MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState, s);
        }

        public static MoPubVideoNativeAd.VideoState[] values()
        {
            return (MoPubVideoNativeAd.VideoState[])$VALUES.clone();
        }

        static 
        {
            CREATED = new MoPubVideoNativeAd.VideoState("CREATED", 0);
            LOADING = new MoPubVideoNativeAd.VideoState("LOADING", 1);
            BUFFERING = new MoPubVideoNativeAd.VideoState("BUFFERING", 2);
            PAUSED = new MoPubVideoNativeAd.VideoState("PAUSED", 3);
            PLAYING = new MoPubVideoNativeAd.VideoState("PLAYING", 4);
            PLAYING_MUTED = new MoPubVideoNativeAd.VideoState("PLAYING_MUTED", 5);
            ENDED = new MoPubVideoNativeAd.VideoState("ENDED", 6);
            FAILED_LOAD = new MoPubVideoNativeAd.VideoState("FAILED_LOAD", 7);
            $VALUES = (new MoPubVideoNativeAd.VideoState[] {
                CREATED, LOADING, BUFFERING, PAUSED, PLAYING, PLAYING_MUTED, ENDED, FAILED_LOAD
            });
        }

        private MoPubVideoNativeAd.VideoState(String s, int i)
        {
            super(s, i);
        }
    }

    static class NativeVideoControllerFactory
    {

        public NativeVideoController createForId(long l, Context context, List list, VastVideoConfig vastvideoconfig, EventDetails eventdetails)
        {
            return NativeVideoController.createForId(l, context, list, vastvideoconfig, eventdetails);
        }

        NativeVideoControllerFactory()
        {
        }
    }

    static class PayloadVisibilityStrategy
        implements NativeVideoController.VisibilityTrackingEvent.OnTrackedStrategy
    {

        private final Context mContext;
        private final String mUrl;

        public void execute()
        {
            TrackingRequest.makeTrackingHttpRequest(mUrl, mContext);
        }

        PayloadVisibilityStrategy(Context context, String s)
        {
            mContext = context.getApplicationContext();
            mUrl = s;
        }
    }

    static class VideoResponseHeaders
    {

        private boolean mHeadersAreValid;
        private int mImpressionMinVisiblePercent;
        private int mImpressionVisibleMs;
        private int mMaxBufferMs;
        private int mPauseVisiblePercent;
        private int mPlayVisiblePercent;

        int getImpressionMinVisiblePercent()
        {
            return mImpressionMinVisiblePercent;
        }

        int getImpressionVisibleMs()
        {
            return mImpressionVisibleMs;
        }

        int getMaxBufferMs()
        {
            return mMaxBufferMs;
        }

        int getPauseVisiblePercent()
        {
            return mPauseVisiblePercent;
        }

        int getPlayVisiblePercent()
        {
            return mPlayVisiblePercent;
        }

        boolean hasValidHeaders()
        {
            return mHeadersAreValid;
        }

        VideoResponseHeaders(Map map)
        {
            try
            {
                mPlayVisiblePercent = Integer.parseInt((String)map.get("Play-Visible-Percent"));
                mPauseVisiblePercent = Integer.parseInt((String)map.get("Pause-Visible-Percent"));
                mImpressionMinVisiblePercent = Integer.parseInt((String)map.get("Impression-Min-Visible-Percent"));
                mImpressionVisibleMs = Integer.parseInt((String)map.get("Impression-Visible-Ms"));
                mMaxBufferMs = Integer.parseInt((String)map.get("Max-Buffer-Ms"));
                mHeadersAreValid = true;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                mHeadersAreValid = false;
            }
        }
    }


    public MoPubCustomEventVideoNative()
    {
    }

    protected void loadNativeAd(Context context, CustomEventNative.CustomEventNativeListener customeventnativelistener, Map map, Map map1)
    {
        Object obj1 = map.get("com_mopub_native_json");
        if (!(obj1 instanceof JSONObject))
        {
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
            return;
        }
        Object obj = map.get("Event-Details");
        if (obj instanceof EventDetails)
        {
            obj = (EventDetails)obj;
        } else
        {
            obj = null;
        }
        map1 = new VideoResponseHeaders(map1);
        if (!map1.hasValidHeaders())
        {
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
            return;
        }
        map = ((Map) (map.get("Click-Tracking-Url")));
        if (!(map instanceof String) || TextUtils.isEmpty((String)map))
        {
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
            return;
        }
        map = (String)map;
        context = new MoPubVideoNativeAd(context, (JSONObject)obj1, customeventnativelistener, map1, ((EventDetails) (obj)), map);
        try
        {
            context.loadAd();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            customeventnativelistener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
        }
    }

    // Unreferenced inner class com/mopub/nativeads/MoPubCustomEventVideoNative$MoPubVideoNativeAd$1

/* anonymous class */
    class MoPubVideoNativeAd._cls1
        implements VisibilityTracker.VisibilityTrackerListener
    {

        final MoPubVideoNativeAd this$0;

        public void onVisibilityChanged(List list, List list1)
        {
            if (!list.isEmpty() && !mLatestVisibility)
            {
                mLatestVisibility = true;
                maybeChangeState();
            } else
            if (!list1.isEmpty() && mLatestVisibility)
            {
                mLatestVisibility = false;
                maybeChangeState();
                return;
            }
        }

            
            {
                this$0 = MoPubVideoNativeAd.this;
                super();
            }
    }

}
