// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.millennialmedia.internal.ActivityListenerManager;
import com.millennialmedia.internal.AdPlacement;
import com.millennialmedia.internal.AdPlacementMetadata;
import com.millennialmedia.internal.AdPlacementReporter;
import com.millennialmedia.internal.ErrorStatus;
import com.millennialmedia.internal.Handshake;
import com.millennialmedia.internal.PlayList;
import com.millennialmedia.internal.adadapters.InlineAdapter;
import com.millennialmedia.internal.playlistserver.PlayListServer;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import com.millennialmedia.internal.utils.ViewUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.millennialmedia:
//            MMException, MMSDK, MMLog

public class InlineAd extends AdPlacement
{
    public static class AdSize
    {

        public static final int AUTO_HEIGHT = 0;
        public static final int AUTO_WIDTH = 0;
        public static final AdSize BANNER = new AdSize(320, 50);
        public static final AdSize FULL_BANNER = new AdSize(468, 60);
        public static final AdSize LARGE_BANNER = new AdSize(320, 100);
        public static final AdSize LEADERBOARD = new AdSize(728, 90);
        public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250);
        public static final AdSize SMART_BANNER = new AdSize(0, 0);
        public final int height;
        public final int width;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                if (!(obj instanceof AdSize))
                {
                    return false;
                }
                obj = (AdSize)obj;
                if (width != ((AdSize) (obj)).width || height != ((AdSize) (obj)).height)
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return width * 31 + height;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Inline ad of size ").append(width).append(" by ").append(height).toString();
        }


        public AdSize(int i, int j)
        {
            if (i <= 0)
            {
                i = 0;
            }
            width = i;
            if (j <= 0)
            {
                j = 0;
            }
            height = j;
        }
    }

    static class ImpressionListener
    {

        volatile boolean impressionFound;
        volatile com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable impressionTimerRunnable;
        com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher viewabilityWatcher;

        protected void listen()
        {
            if (viewabilityWatcher == null)
            {
                return;
            } else
            {
                viewabilityWatcher.setMinViewabilityPercent(90);
                viewabilityWatcher.startWatching();
                return;
            }
        }

        ImpressionListener(InlineAd inlinead, View view)
        {
            impressionFound = false;
            viewabilityWatcher = new com.millennialmedia.internal.utils.ViewUtils.ViewabilityWatcher(view, inlinead. new _cls1());
        }
    }

    public static interface InlineAbortListener
    {

        public abstract void onAbortFailed(InlineAd inlinead);

        public abstract void onAborted(InlineAd inlinead);
    }

    public static class InlineAdMetadata extends AdPlacementMetadata
    {

        private static final String PLACEMENT_TYPE_INLINE = "inline";
        private AdSize adSize;

        public AdSize getAdSize()
        {
            return adSize;
        }

        public int getHeight(InlineAd inlinead)
        {
            if (adSize != null && adSize.height != 0)
            {
                return (int)TypedValue.applyDimension(1, adSize.height, EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics());
            } else
            {
                return inlinead.adContainer.getHeight();
            }
        }

        public int getWidth(InlineAd inlinead)
        {
            if (adSize != null && adSize.width != 0)
            {
                return (int)TypedValue.applyDimension(1, adSize.width, EnvironmentUtils.getApplicationContext().getResources().getDisplayMetrics());
            } else
            {
                return inlinead.adContainer.getWidth();
            }
        }

        public InlineAdMetadata setAdSize(AdSize adsize)
        {
            if (adsize == null)
            {
                MMLog.e(InlineAd.TAG, "Provided AdSize cannot be null");
                return this;
            } else
            {
                adSize = adsize;
                return this;
            }
        }

        public Map toMap(InlineAd inlinead)
        {
            Map map = super.toMap(inlinead);
            Utils.injectIfNotNull(map, "width", Integer.valueOf(getWidth(inlinead)));
            Utils.injectIfNotNull(map, "height", Integer.valueOf(getHeight(inlinead)));
            Utils.injectIfNotNull(map, "refreshRate", inlinead.refreshInterval);
            return map;
        }

        public InlineAdMetadata()
        {
            super("inline");
        }
    }

    public static class InlineErrorStatus extends ErrorStatus
    {

        public InlineErrorStatus(int i)
        {
            super(i);
        }

        public InlineErrorStatus(int i, String s)
        {
            super(i, s);
        }
    }

    public static interface InlineListener
    {

        public abstract void onAdLeftApplication(InlineAd inlinead);

        public abstract void onClicked(InlineAd inlinead);

        public abstract void onCollapsed(InlineAd inlinead);

        public abstract void onExpanded(InlineAd inlinead);

        public abstract void onRequestFailed(InlineAd inlinead, InlineErrorStatus inlineerrorstatus);

        public abstract void onRequestSucceeded(InlineAd inlinead);

        public abstract void onResize(InlineAd inlinead, int i, int j);

        public abstract void onResized(InlineAd inlinead, int i, int j, boolean flag);
    }

    private static class RefreshRunnable
        implements Runnable
    {

        WeakReference inlineAdRef;

        public void run()
        {
            InlineAd inlinead = (InlineAd)inlineAdRef.get();
            if (inlinead == null)
            {
                MMLog.e(InlineAd.TAG, "InlineAd instance has been destroyed, shutting down refresh behavior");
                return;
            }
            if (inlinead.refreshInterval == null || inlinead.refreshInterval.intValue() <= 0)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(InlineAd.TAG, "Inline refresh disabled, aborting refresh behavior");
                }
                inlinead.refreshRunnable = null;
                return;
            }
            android.app.Activity activity = ViewUtils.getActivityForView(inlinead.adContainer);
            if (activity == null)
            {
                MMLog.e(InlineAd.TAG, "Unable to find valid activity context for placement container, aborting refresh");
                return;
            }
            boolean flag;
            if (ActivityListenerManager.getLifecycleState(activity) == com.millennialmedia.internal.ActivityListenerManager.LifecycleState.RESUMED)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (inlinead.adContainer.isShown() && !inlinead.isResized && !inlinead.isExpanded && flag)
            {
                ThreadUtils.runOnWorkerThread(inlinead. new Runnable() {

                    final RefreshRunnable this$0;
                    final InlineAd val$inlineAd;

                    public void run()
                    {
                        inlineAd.loadPlayList();
                    }

            
            {
                this$0 = final_refreshrunnable;
                inlineAd = InlineAd.this;
                super();
            }
                });
            }
            inlinead.refreshRunnable = ThreadUtils.runOnWorkerThreadDelayed(this, inlinead.refreshInterval.intValue());
        }

        RefreshRunnable(InlineAd inlinead)
        {
            inlineAdRef = new WeakReference(inlinead);
        }
    }


    private static final int MIN_IMPRESSION_DISPLAY = 1000;
    protected static final String STATE_LOAD_ABORTED = "aborted";
    private static final String TAG = com/millennialmedia/InlineAd.getSimpleName();
    private volatile boolean aborting;
    private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable adAdapterRequestTimeoutRunnable;
    private ViewGroup adContainer;
    private volatile boolean hasRequested;
    private ImpressionListener impressionListener;
    private InlineAbortListener inlineAbortListener;
    private InlineAdMetadata inlineAdMetadata;
    private InlineListener inlineListener;
    private volatile boolean isExpanded;
    private volatile boolean isResized;
    private long lastRequestTime;
    private RelativeLayout mmAdContainer;
    private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable placementRequestTimeoutRunnable;
    private Integer refreshInterval;
    private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable refreshRunnable;

    private InlineAd(String s, ViewGroup viewgroup)
        throws MMException
    {
        super(s);
        hasRequested = false;
        isResized = false;
        isExpanded = false;
        aborting = false;
        adContainer = viewgroup;
    }

    public static InlineAd createInstance(String s, ViewGroup viewgroup)
        throws MMException
    {
        if (!MMSDK.initialized)
        {
            throw new IllegalStateException("Unable to create instance, SDK must be initialized first");
        }
        if (viewgroup == null)
        {
            throw new MMException("Unable to create instance, ad container cannot be null");
        }
        if (viewgroup.getContext() == null)
        {
            throw new MMException("Unable to create instance, ad container must have an associated context");
        } else
        {
            return new InlineAd(s, viewgroup);
        }
    }

    private boolean isLoading()
    {
        return !placementState.equals("idle") && !placementState.equals("load_failed") && !placementState.equals("loaded") && !placementState.equals("aborted");
    }

    private void loadAdAdapter(final com.millennialmedia.internal.AdPlacement.RequestState playListItemReporter)
    {
        final com.millennialmedia.internal.AdPlacement.RequestState localRequestState = playListItemReporter.copy();
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compareRequest(localRequestState) && (placementState.equals("play_list_loaded") || placementState.equals("ad_adapter_load_failed")))
        {
            break MISSING_BLOCK_LABEL_47;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        placementState = "loading_ad_adapter";
        this;
        JVM INSTR monitorexit ;
        if (!playList.hasNext())
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Unable to find ad adapter in play list");
            }
            onRequestFailed(localRequestState);
            return;
        }
        break MISSING_BLOCK_LABEL_92;
        playListItemReporter;
        this;
        JVM INSTR monitorexit ;
        throw playListItemReporter;
        if (aborting)
        {
            onAborted(playListItemReporter);
            return;
        }
        playListItemReporter = AdPlacementReporter.getPlayListItemReporter(playListItemReporter.getAdPlacementReporter());
        final InlineAdapter inlineAdAdapter = (InlineAdapter)playList.getNextAdAdapter(this, playListItemReporter);
        if (inlineAdAdapter != null)
        {
            localRequestState.getItemHash();
            currentRequestState = localRequestState;
            int i = inlineAdAdapter.requestTimeout;
            if (i > 0)
            {
                if (adAdapterRequestTimeoutRunnable != null)
                {
                    adAdapterRequestTimeoutRunnable.cancel();
                }
                adAdapterRequestTimeoutRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

                    final InlineAd this$0;
                    final com.millennialmedia.internal.AdPlacement.RequestState val$localRequestState;
                    final com.millennialmedia.internal.AdPlacementReporter.PlayListItemReporter val$playListItemReporter;

                    public void run()
                    {
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(InlineAd.TAG, "Ad adapter load timed out");
                        }
                        AdPlacementReporter.reportPlayListItem(localRequestState.getAdPlacementReporter(), playListItemReporter, -2);
                        onAdAdapterLoadFailed(localRequestState);
                    }

            
            {
                this$0 = InlineAd.this;
                localRequestState = requeststate;
                playListItemReporter = playlistitemreporter;
                super();
            }
                }, i);
            }
            inlineAdAdapter.init(adContainer.getContext(), new com.millennialmedia.internal.adadapters.InlineAdapter.InlineAdapterListener() );
            return;
        } else
        {
            AdPlacementReporter.reportPlayListItem(localRequestState.getAdPlacementReporter(), playListItemReporter);
            onAdAdapterLoadFailed(localRequestState);
            return;
        }
    }

    private void loadPlayList()
    {
        if (isResized || isExpanded)
        {
            MMLog.w(TAG, "Inline ad is resized or expanded, unable to request new ad");
            return;
        }
        if (System.currentTimeMillis() < lastRequestTime + (long)Handshake.getMinInlineRefreshRate())
        {
            MMLog.e(TAG, "Too soon since last inline ad request, unable to request ad");
            return;
        }
        this;
        JVM INSTR monitorenter ;
        if (!isLoading())
        {
            break MISSING_BLOCK_LABEL_67;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        aborting = false;
        inlineAbortListener = null;
        placementState = "loading_play_list";
        this;
        JVM INSTR monitorexit ;
        playList = null;
        lastRequestTime = System.currentTimeMillis();
        if (inlineAdMetadata == null)
        {
            inlineAdMetadata = new InlineAdMetadata();
        }
        final com.millennialmedia.internal.AdPlacement.RequestState localRequestState = getRequestState();
        if (placementRequestTimeoutRunnable != null)
        {
            placementRequestTimeoutRunnable.cancel();
        }
        placementRequestTimeoutRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

            final InlineAd this$0;
            final com.millennialmedia.internal.AdPlacement.RequestState val$localRequestState;

            public void run()
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(InlineAd.TAG, "Play list load timed out");
                }
                onRequestFailed(localRequestState);
            }

            
            {
                this$0 = InlineAd.this;
                localRequestState = requeststate;
                super();
            }
        }, Handshake.getInlineTimeout());
        PlayListServer.loadPlayList(inlineAdMetadata.toMap(this), new com.millennialmedia.internal.playlistserver.PlayListServer.PlayListLoadListener() );
        return;
    }

    private void onAbortFailed()
    {
        MMLog.i(TAG, "Ad abort failed");
        final InlineAbortListener localInlineAbortListener = inlineAbortListener;
        if (localInlineAbortListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InlineAd this$0;
                final InlineAbortListener val$localInlineAbortListener;

                public void run()
                {
                    localInlineAbortListener.onAbortFailed(InlineAd.this);
                }

            
            {
                this$0 = InlineAd.this;
                localInlineAbortListener = inlineabortlistener;
                super();
            }
            });
        }
    }

    private void onAborted(final com.millennialmedia.internal.AdPlacement.RequestState localInlineAbortListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localInlineAbortListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onAborted called but request state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (placementState.equals("loading_ad_adapter"))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("onAborted called but placement state is not valid: ").append(placementState).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        localInlineAbortListener;
        this;
        JVM INSTR monitorexit ;
        throw localInlineAbortListener;
        placementState = "aborted";
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Ad aborted");
        AdPlacementReporter.reportPlayList(localInlineAbortListener.getAdPlacementReporter());
        localInlineAbortListener = inlineAbortListener;
        if (localInlineAbortListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InlineAd this$0;
                final InlineAbortListener val$localInlineAbortListener;

                public void run()
                {
                    localInlineAbortListener.onAborted(InlineAd.this);
                }

            
            {
                this$0 = InlineAd.this;
                localInlineAbortListener = inlineabortlistener;
                super();
            }
            });
        }
        return;
    }

    private void onAdAdapterLoadFailed(com.millennialmedia.internal.AdPlacement.RequestState requeststate)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(requeststate))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onAdAdapterLoadFailed called but request state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (placementState.equals("loading_ad_adapter"))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("onAdAdapterLoadFailed called but placement state is not valid: ").append(placementState).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        requeststate;
        this;
        JVM INSTR monitorexit ;
        throw requeststate;
        placementState = "ad_adapter_load_failed";
        this;
        JVM INSTR monitorexit ;
        loadAdAdapter(requeststate);
        return;
    }

    private void onAdLeftApplication(final com.millennialmedia.internal.AdPlacement.RequestState localInlineListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localInlineListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onAdLeftApplication called but request state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Ad left application");
        localInlineListener = inlineListener;
        if (localInlineListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InlineAd this$0;
                final InlineListener val$localInlineListener;

                public void run()
                {
                    localInlineListener.onAdLeftApplication(InlineAd.this);
                }

            
            {
                this$0 = InlineAd.this;
                localInlineListener = inlinelistener;
                super();
            }
            });
            return;
        } else
        {
            return;
        }
        localInlineListener;
        this;
        JVM INSTR monitorexit ;
        throw localInlineListener;
    }

    private void onClicked(final com.millennialmedia.internal.AdPlacement.RequestState localInlineListener)
    {
        MMLog.i(TAG, "Ad clicked");
        AdPlacementReporter.setClicked(localInlineListener.getAdPlacementReporter());
        localInlineListener = inlineListener;
        if (localInlineListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InlineAd this$0;
                final InlineListener val$localInlineListener;

                public void run()
                {
                    localInlineListener.onClicked(InlineAd.this);
                }

            
            {
                this$0 = InlineAd.this;
                localInlineListener = inlinelistener;
                super();
            }
            });
        }
    }

    private void onCollapsed(final com.millennialmedia.internal.AdPlacement.RequestState localInlineListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localInlineListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onCollapsed called but request state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Ad collapsed");
        isExpanded = false;
        localInlineListener = inlineListener;
        if (localInlineListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InlineAd this$0;
                final InlineListener val$localInlineListener;

                public void run()
                {
                    localInlineListener.onCollapsed(InlineAd.this);
                }

            
            {
                this$0 = InlineAd.this;
                localInlineListener = inlinelistener;
                super();
            }
            });
            return;
        } else
        {
            return;
        }
        localInlineListener;
        this;
        JVM INSTR monitorexit ;
        throw localInlineListener;
    }

    private void onExpanded(final com.millennialmedia.internal.AdPlacement.RequestState localInlineListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localInlineListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onExpanded called but request state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Ad expanded");
        isExpanded = true;
        isResized = false;
        localInlineListener = inlineListener;
        if (localInlineListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InlineAd this$0;
                final InlineListener val$localInlineListener;

                public void run()
                {
                    localInlineListener.onExpanded(InlineAd.this);
                }

            
            {
                this$0 = InlineAd.this;
                localInlineListener = inlinelistener;
                super();
            }
            });
            return;
        } else
        {
            return;
        }
        localInlineListener;
        this;
        JVM INSTR monitorexit ;
        throw localInlineListener;
    }

    private void onRequestFailed(final com.millennialmedia.internal.AdPlacement.RequestState localInlineListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compareRequest(localInlineListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onRequestFailed called but request state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (placementState.equals("loading_ad_adapter") || placementState.equals("loading_play_list"))
        {
            break MISSING_BLOCK_LABEL_100;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("onRequestFailed called but placement state is not valid: ").append(placementState).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        localInlineListener;
        this;
        JVM INSTR monitorexit ;
        throw localInlineListener;
        placementState = "load_failed";
        MMLog.i(TAG, "Request failed");
        stopRequestTimeoutTimers();
        AdPlacementReporter.reportPlayList(localInlineListener.getAdPlacementReporter());
        this;
        JVM INSTR monitorexit ;
        localInlineListener = inlineListener;
        if (localInlineListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InlineAd this$0;
                final InlineListener val$localInlineListener;

                public void run()
                {
                    localInlineListener.onRequestFailed(InlineAd.this, new InlineErrorStatus(5));
                    if (aborting)
                    {
                        onAbortFailed();
                    }
                }

            
            {
                this$0 = InlineAd.this;
                localInlineListener = inlinelistener;
                super();
            }
            });
        }
        return;
    }

    private void onRequestSucceeded(final com.millennialmedia.internal.AdPlacement.RequestState localInlineListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localInlineListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onRequestSucceeded called but request state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (placementState.equals("loading_ad_adapter"))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("onRequestSucceeded called but placement state is not valid: ").append(placementState).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        localInlineListener;
        this;
        JVM INSTR monitorexit ;
        throw localInlineListener;
        placementState = "loaded";
        MMLog.i(TAG, "Request succeeded");
        stopRequestTimeoutTimers();
        AdPlacementReporter.reportPlayList(localInlineListener.getAdPlacementReporter());
        impressionListener = new ImpressionListener(this, mmAdContainer);
        impressionListener.listen();
        this;
        JVM INSTR monitorexit ;
        localInlineListener = inlineListener;
        if (localInlineListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InlineAd this$0;
                final InlineListener val$localInlineListener;

                public void run()
                {
                    localInlineListener.onRequestSucceeded(InlineAd.this);
                    if (aborting)
                    {
                        onAbortFailed();
                    }
                }

            
            {
                this$0 = InlineAd.this;
                localInlineListener = inlinelistener;
                super();
            }
            });
        }
        return;
    }

    private void onResize(final com.millennialmedia.internal.AdPlacement.RequestState localInlineListener, final int width, final int height)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localInlineListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onResize called but request state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Ad resizing");
        isResized = true;
        localInlineListener = inlineListener;
        if (localInlineListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InlineAd this$0;
                final int val$height;
                final InlineListener val$localInlineListener;
                final int val$width;

                public void run()
                {
                    localInlineListener.onResize(InlineAd.this, width, height);
                }

            
            {
                this$0 = InlineAd.this;
                localInlineListener = inlinelistener;
                width = i;
                height = j;
                super();
            }
            });
            return;
        } else
        {
            return;
        }
        localInlineListener;
        this;
        JVM INSTR monitorexit ;
        throw localInlineListener;
    }

    private void onResized(final com.millennialmedia.internal.AdPlacement.RequestState localInlineListener, final int width, final int height, final boolean isClosed)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localInlineListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onResized called but request state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, (new StringBuilder()).append("Ad resized, is closed: ").append(isClosed).toString());
        if (isClosed)
        {
            isResized = false;
        }
        localInlineListener = inlineListener;
        if (localInlineListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InlineAd this$0;
                final int val$height;
                final boolean val$isClosed;
                final InlineListener val$localInlineListener;
                final int val$width;

                public void run()
                {
                    localInlineListener.onResized(InlineAd.this, width, height, isClosed);
                }

            
            {
                this$0 = InlineAd.this;
                localInlineListener = inlinelistener;
                width = i;
                height = j;
                isClosed = flag;
                super();
            }
            });
            return;
        } else
        {
            return;
        }
        localInlineListener;
        this;
        JVM INSTR monitorexit ;
        throw localInlineListener;
    }

    private void startRefresh()
    {
        if (refreshRunnable != null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Refresh already active, canceling");
            }
            refreshRunnable.cancel();
        }
        if (refreshInterval == null || refreshInterval.intValue() == 0)
        {
            return;
        } else
        {
            refreshRunnable = ThreadUtils.runOnWorkerThreadDelayed(new RefreshRunnable(this), refreshInterval.intValue());
            return;
        }
    }

    private void stopRequestTimeoutTimers()
    {
        if (placementRequestTimeoutRunnable != null)
        {
            placementRequestTimeoutRunnable.cancel();
        }
        if (adAdapterRequestTimeoutRunnable != null)
        {
            adAdapterRequestTimeoutRunnable.cancel();
        }
    }

    public void abort(InlineAbortListener inlineabortlistener)
    {
        MMLog.i(TAG, (new StringBuilder()).append("Attempting to abort playlist request for placement ID: ").append(placementId).toString());
        inlineAbortListener = inlineabortlistener;
        this;
        JVM INSTR monitorenter ;
        if (!isLoading())
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Aborting playlist request for placement ID: ").append(placementId).toString());
        }
        aborting = true;
        this;
        JVM INSTR monitorexit ;
        return;
        this;
        JVM INSTR monitorexit ;
        onAbortFailed();
        return;
        inlineabortlistener;
        this;
        JVM INSTR monitorexit ;
        throw inlineabortlistener;
    }

    public void request(InlineAdMetadata inlineadmetadata)
    {
        MMLog.i(TAG, (new StringBuilder()).append("Requesting playlist for placement ID: ").append(placementId).toString());
        inlineAdMetadata = inlineadmetadata;
        hasRequested = true;
        loadPlayList();
        startRefresh();
    }

    public void setListener(InlineListener inlinelistener)
    {
        inlineListener = inlinelistener;
    }

    public void setRefreshInterval(int i)
    {
        int k = Handshake.getMinInlineRefreshRate();
        int j = i;
        if (i != 0)
        {
            j = i;
            if (i < k)
            {
                j = k;
            }
        }
        refreshInterval = Integer.valueOf(j);
        if (hasRequested)
        {
            startRefresh();
        }
    }






/*
    static String access$1102(InlineAd inlinead, String s)
    {
        inlinead.placementState = s;
        return s;
    }

*/


/*
    static PlayList access$1202(InlineAd inlinead, PlayList playlist)
    {
        inlinead.playList = playlist;
        return playlist;
    }

*/


/*
    static com.millennialmedia.internal.AdPlacement.RequestState access$1302(InlineAd inlinead, com.millennialmedia.internal.AdPlacement.RequestState requeststate)
    {
        inlinead.currentRequestState = requeststate;
        return requeststate;
    }

*/






/*
    static RelativeLayout access$1702(InlineAd inlinead, RelativeLayout relativelayout)
    {
        inlinead.mmAdContainer = relativelayout;
        return relativelayout;
    }

*/














/*
    static com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable access$402(InlineAd inlinead, com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable scheduledrunnable)
    {
        inlinead.refreshRunnable = scheduledrunnable;
        return scheduledrunnable;
    }

*/






    // Unreferenced inner class com/millennialmedia/InlineAd$4$1

/* anonymous class */
    class _cls1
        implements Runnable
    {

        final _cls4 this$1;

        public void run()
        {
            if (mmAdContainer != null)
            {
                adContainer.removeView(mmAdContainer);
            }
            mmAdContainer = new RelativeLayout(adContainer.getContext());
            adContainer.addView(mmAdContainer, new android.view.ViewGroup.LayoutParams(-1, -1));
            inlineAdAdapter.display(mmAdContainer, inlineAdMetadata.getWidth(_fld0), inlineAdMetadata.getHeight(_fld0));
        }

            
            {
                this$1 = _cls4.this;
                super();
            }
    }


    // Unreferenced inner class com/millennialmedia/InlineAd$ImpressionListener$1

/* anonymous class */
    class ImpressionListener._cls1
        implements com.millennialmedia.internal.utils.ViewUtils.ViewabilityListener
    {

        final ImpressionListener this$0;
        final InlineAd val$inlineAd;

        public void onViewableChanged(boolean flag)
        {
            ImpressionListener impressionlistener = ImpressionListener.this;
            impressionlistener;
            JVM INSTR monitorenter ;
            if (!flag) goto _L2; else goto _L1
_L1:
            if (impressionTimerRunnable != null || impressionFound) goto _L2; else goto _L3
_L3:
            impressionTimerRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() , 1000L);
_L5:
            impressionlistener;
            JVM INSTR monitorexit ;
            return;
_L2:
            if (flag) goto _L5; else goto _L4
_L4:
            if (impressionTimerRunnable == null) goto _L5; else goto _L6
_L6:
            impressionTimerRunnable.cancel();
            impressionTimerRunnable = null;
              goto _L5
            Exception exception;
            exception;
            impressionlistener;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                this$0 = final_impressionlistener;
                inlineAd = InlineAd.this;
                super();
            }
    }

}
