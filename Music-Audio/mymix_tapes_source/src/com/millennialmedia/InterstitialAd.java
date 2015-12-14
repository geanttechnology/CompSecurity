// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import android.content.Context;
import com.millennialmedia.internal.AdPlacement;
import com.millennialmedia.internal.AdPlacementMetadata;
import com.millennialmedia.internal.AdPlacementReporter;
import com.millennialmedia.internal.ErrorStatus;
import com.millennialmedia.internal.Handshake;
import com.millennialmedia.internal.PlayList;
import com.millennialmedia.internal.adadapters.InterstitialAdapter;
import com.millennialmedia.internal.playlistserver.PlayListServer;
import com.millennialmedia.internal.utils.ThreadUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.millennialmedia:
//            MMException, MMSDK, MMLog

public class InterstitialAd extends AdPlacement
{
    public static class DisplayOptions
    {

        public Integer enterAnimationId;
        public Integer exitAnimationId;
        public boolean immersive;

        public DisplayOptions setImmersive(boolean flag)
        {
            immersive = flag;
            return this;
        }

        public DisplayOptions setTransitionAnimation(int i, int j)
        {
            enterAnimationId = Integer.valueOf(i);
            exitAnimationId = Integer.valueOf(j);
            return this;
        }

        public DisplayOptions()
        {
        }
    }

    private static class ExpirationRunnable
        implements Runnable
    {

        WeakReference interstitialAdRef;
        WeakReference requestStateRef;

        public void run()
        {
            InterstitialAd interstitialad = (InterstitialAd)interstitialAdRef.get();
            if (interstitialad == null)
            {
                MMLog.e(InterstitialAd.TAG, "InterstitialAd instance has been destroyed, aborting expiration state change");
                return;
            }
            interstitialad.expirationRunnable = null;
            com.millennialmedia.internal.AdPlacement.RequestState requeststate = (com.millennialmedia.internal.AdPlacement.RequestState)requestStateRef.get();
            if (requeststate == null)
            {
                MMLog.e(InterstitialAd.TAG, "No valid RequestState is available, unable to trigger expired state change");
                return;
            } else
            {
                interstitialad.onExpired(requeststate);
                return;
            }
        }

        ExpirationRunnable(InterstitialAd interstitialad, com.millennialmedia.internal.AdPlacement.RequestState requeststate)
        {
            interstitialAdRef = new WeakReference(interstitialad);
            requestStateRef = new WeakReference(requeststate);
        }
    }

    public static class InterstitialAdMetadata extends AdPlacementMetadata
    {

        private static final String PLACEMENT_TYPE_INTERSTITIAL = "interstitial";

        public InterstitialAdMetadata()
        {
            super("interstitial");
        }
    }

    public static class InterstitialErrorStatus extends ErrorStatus
    {

        public static final int ALREADY_LOADED = 203;
        public static final int EXPIRED = 201;
        public static final int NOT_LOADED = 202;

        static 
        {
            errorCodes.put(Integer.valueOf(201), "EXPIRED");
            errorCodes.put(Integer.valueOf(202), "NOT_LOADED");
            errorCodes.put(Integer.valueOf(203), "ALREADY_LOADED");
        }

        public InterstitialErrorStatus(int i)
        {
            super(i);
        }

        public InterstitialErrorStatus(int i, String s)
        {
            super(i, s);
        }
    }

    public static interface InterstitialListener
    {

        public abstract void onAdLeftApplication(InterstitialAd interstitialad);

        public abstract void onClicked(InterstitialAd interstitialad);

        public abstract void onClosed(InterstitialAd interstitialad);

        public abstract void onExpired(InterstitialAd interstitialad);

        public abstract void onLoadFailed(InterstitialAd interstitialad, InterstitialErrorStatus interstitialerrorstatus);

        public abstract void onLoaded(InterstitialAd interstitialad);

        public abstract void onShowFailed(InterstitialAd interstitialad, InterstitialErrorStatus interstitialerrorstatus);

        public abstract void onShown(InterstitialAd interstitialad);
    }


    protected static final String STATE_EXPIRED = "expired";
    protected static final String STATE_SHOWN = "shown";
    protected static final String STATE_SHOW_FAILED = "show_failed";
    private static final String TAG = com/millennialmedia/InterstitialAd.getSimpleName();
    private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable adAdapterRequestTimeoutRunnable;
    private Context context;
    private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable expirationRunnable;
    private InterstitialAdapter interstitialAdAdapter;
    private InterstitialListener interstitialListener;
    private com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable placementRequestTimeoutRunnable;

    private InterstitialAd(String s)
        throws MMException
    {
        super(s);
    }

    public static InterstitialAd createInstance(String s)
        throws MMException
    {
        if (!MMSDK.initialized)
        {
            throw new IllegalStateException("Unable to create instance, SDK must be initialized first");
        } else
        {
            return new InterstitialAd(s);
        }
    }

    private void loadAdAdapter(final com.millennialmedia.internal.AdPlacement.RequestState playListItemReporter)
    {
        final com.millennialmedia.internal.AdPlacement.RequestState localRequestState = playListItemReporter.copy();
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compareRequest(localRequestState) && (placementState.equals("play_list_loaded") || placementState.equals("ad_adapter_load_failed")))
        {
            break MISSING_BLOCK_LABEL_45;
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
            onLoadFailed(localRequestState);
            return;
        }
        break MISSING_BLOCK_LABEL_88;
        playListItemReporter;
        this;
        JVM INSTR monitorexit ;
        throw playListItemReporter;
        playListItemReporter = AdPlacementReporter.getPlayListItemReporter(playListItemReporter.getAdPlacementReporter());
        InterstitialAdapter interstitialadapter = (InterstitialAdapter)playList.getNextAdAdapter(this, playListItemReporter);
        if (interstitialadapter != null)
        {
            interstitialAdAdapter = interstitialadapter;
            localRequestState.getItemHash();
            currentRequestState = localRequestState;
            int i = interstitialadapter.requestTimeout;
            if (i > 0)
            {
                if (adAdapterRequestTimeoutRunnable != null)
                {
                    adAdapterRequestTimeoutRunnable.cancel();
                }
                adAdapterRequestTimeoutRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

                    final InterstitialAd this$0;
                    final com.millennialmedia.internal.AdPlacement.RequestState val$localRequestState;
                    final com.millennialmedia.internal.AdPlacementReporter.PlayListItemReporter val$playListItemReporter;

                    public void run()
                    {
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(InterstitialAd.TAG, "Ad adapter load timed out");
                        }
                        AdPlacementReporter.reportPlayListItem(localRequestState.getAdPlacementReporter(), playListItemReporter, -2);
                        onAdAdapterLoadFailed(localRequestState);
                    }

            
            {
                this$0 = InterstitialAd.this;
                localRequestState = requeststate;
                playListItemReporter = playlistitemreporter;
                super();
            }
                }, i);
            }
            interstitialadapter.init(context, new com.millennialmedia.internal.adadapters.InterstitialAdapter.InterstitialAdapterListener() {

                final InterstitialAd this$0;
                final com.millennialmedia.internal.AdPlacement.RequestState val$localRequestState;
                final com.millennialmedia.internal.AdPlacementReporter.PlayListItemReporter val$playListItemReporter;

                public void initFailed()
                {
                    AdPlacementReporter.reportPlayListItem(localRequestState.getAdPlacementReporter(), playListItemReporter, -3);
                    onAdAdapterLoadFailed(localRequestState);
                }

                public void initSucceeded()
                {
                    AdPlacementReporter.reportPlayListItem(localRequestState.getAdPlacementReporter(), playListItemReporter);
                    onLoadSucceeded(localRequestState);
                }

                public void onAdLeftApplication()
                {
                    InterstitialAd.this.onAdLeftApplication(localRequestState);
                }

                public void onClicked()
                {
                    InterstitialAd.this.onClicked(localRequestState);
                }

                public void onClosed()
                {
                    InterstitialAd.this.onClosed(localRequestState);
                }

                public void onExpired()
                {
                    InterstitialAd.this.onExpired(localRequestState);
                }

                public void showFailed(InterstitialErrorStatus interstitialerrorstatus)
                {
label0:
                    {
                        synchronized (InterstitialAd.this)
                        {
                            if (access$1100.compare(localRequestState))
                            {
                                break label0;
                            }
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(InterstitialAd.TAG, "show failed but load state is not valid");
                            }
                        }
                        return;
                    }
                    interstitialad;
                    JVM INSTR monitorexit ;
                    onShowFailed(interstitialerrorstatus);
                    return;
                    interstitialerrorstatus;
                    interstitialad;
                    JVM INSTR monitorexit ;
                    throw interstitialerrorstatus;
                }

                public void shown()
                {
                    onShown(localRequestState);
                }

            
            {
                this$0 = InterstitialAd.this;
                localRequestState = requeststate;
                playListItemReporter = playlistitemreporter;
                super();
            }
            });
            return;
        } else
        {
            AdPlacementReporter.reportPlayListItem(localRequestState.getAdPlacementReporter(), playListItemReporter);
            onAdAdapterLoadFailed(localRequestState);
            return;
        }
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
            MMLog.d(TAG, "onAdAdapterLoadFailed called but load state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (placementState.equals("loading_ad_adapter"))
        {
            break MISSING_BLOCK_LABEL_86;
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

    private void onAdLeftApplication(final com.millennialmedia.internal.AdPlacement.RequestState localInterstitialListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localInterstitialListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onAdLeftApplication called but load state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Ad left application");
        localInterstitialListener = interstitialListener;
        if (localInterstitialListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InterstitialAd this$0;
                final InterstitialListener val$localInterstitialListener;

                public void run()
                {
                    localInterstitialListener.onAdLeftApplication(InterstitialAd.this);
                }

            
            {
                this$0 = InterstitialAd.this;
                localInterstitialListener = interstitiallistener;
                super();
            }
            });
            return;
        } else
        {
            return;
        }
        localInterstitialListener;
        this;
        JVM INSTR monitorexit ;
        throw localInterstitialListener;
    }

    private void onClicked(final com.millennialmedia.internal.AdPlacement.RequestState localInterstitialListener)
    {
        MMLog.i(TAG, "Ad clicked");
        AdPlacementReporter.setClicked(localInterstitialListener.getAdPlacementReporter());
        localInterstitialListener = interstitialListener;
        if (localInterstitialListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InterstitialAd this$0;
                final InterstitialListener val$localInterstitialListener;

                public void run()
                {
                    localInterstitialListener.onClicked(InterstitialAd.this);
                }

            
            {
                this$0 = InterstitialAd.this;
                localInterstitialListener = interstitiallistener;
                super();
            }
            });
        }
    }

    private void onClosed(final com.millennialmedia.internal.AdPlacement.RequestState localInterstitialListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localInterstitialListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onClosed called but load state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        placementState = "idle";
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Ad closed");
        localInterstitialListener = interstitialListener;
        if (localInterstitialListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InterstitialAd this$0;
                final InterstitialListener val$localInterstitialListener;

                public void run()
                {
                    localInterstitialListener.onClosed(InterstitialAd.this);
                }

            
            {
                this$0 = InterstitialAd.this;
                localInterstitialListener = interstitiallistener;
                super();
            }
            });
            return;
        } else
        {
            return;
        }
        localInterstitialListener;
        this;
        JVM INSTR monitorexit ;
        throw localInterstitialListener;
    }

    private void onExpired(final com.millennialmedia.internal.AdPlacement.RequestState localInterstitialListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localInterstitialListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onExpired called but load state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (placementState.equals("loaded") || placementState.equals("show_failed"))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("onExpired called but placement state is not valid: ").append(placementState).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        localInterstitialListener;
        this;
        JVM INSTR monitorexit ;
        throw localInterstitialListener;
        placementState = "expired";
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Ad expired");
        localInterstitialListener = interstitialListener;
        if (localInterstitialListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InterstitialAd this$0;
                final InterstitialListener val$localInterstitialListener;

                public void run()
                {
                    localInterstitialListener.onExpired(InterstitialAd.this);
                }

            
            {
                this$0 = InterstitialAd.this;
                localInterstitialListener = interstitiallistener;
                super();
            }
            });
        }
        return;
    }

    private void onLoadFailed(final com.millennialmedia.internal.AdPlacement.RequestState localInterstitialListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compareRequest(localInterstitialListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onLoadFailed called but load state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (placementState.equals("loading_ad_adapter") || placementState.equals("loading_play_list"))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("onLoadFailed called but placement state is not valid: ").append(placementState).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        localInterstitialListener;
        this;
        JVM INSTR monitorexit ;
        throw localInterstitialListener;
        placementState = "load_failed";
        stopRequestTimeoutTimers();
        AdPlacementReporter.reportPlayList(localInterstitialListener.getAdPlacementReporter());
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Load failed");
        localInterstitialListener = interstitialListener;
        if (localInterstitialListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InterstitialAd this$0;
                final InterstitialListener val$localInterstitialListener;

                public void run()
                {
                    localInterstitialListener.onLoadFailed(InterstitialAd.this, new InterstitialErrorStatus(5));
                }

            
            {
                this$0 = InterstitialAd.this;
                localInterstitialListener = interstitiallistener;
                super();
            }
            });
        }
        return;
    }

    private void onLoadSucceeded(final com.millennialmedia.internal.AdPlacement.RequestState localInterstitialListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localInterstitialListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onLoadSucceeded called but load state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (placementState.equals("loading_ad_adapter"))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("onLoadSucceeded called but placement state is not valid: ").append(placementState).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        localInterstitialListener;
        this;
        JVM INSTR monitorexit ;
        throw localInterstitialListener;
        placementState = "loaded";
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Load succeeded");
        stopRequestTimeoutTimers();
        startExpirationTimer(localInterstitialListener);
        AdPlacementReporter.reportPlayList(localInterstitialListener.getAdPlacementReporter());
        localInterstitialListener = interstitialListener;
        if (localInterstitialListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InterstitialAd this$0;
                final InterstitialListener val$localInterstitialListener;

                public void run()
                {
                    localInterstitialListener.onLoaded(InterstitialAd.this);
                }

            
            {
                this$0 = InterstitialAd.this;
                localInterstitialListener = interstitiallistener;
                super();
            }
            });
        }
        return;
    }

    private void onShowFailed(final InterstitialErrorStatus errorStatus)
    {
        this;
        JVM INSTR monitorenter ;
        if (placementState == "loaded")
        {
            placementState = "show_failed";
        }
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Ad show failed");
        final InterstitialListener localInterstitialListener = interstitialListener;
        if (localInterstitialListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InterstitialAd this$0;
                final InterstitialErrorStatus val$errorStatus;
                final InterstitialListener val$localInterstitialListener;

                public void run()
                {
                    localInterstitialListener.onShowFailed(InterstitialAd.this, errorStatus);
                }

            
            {
                this$0 = InterstitialAd.this;
                localInterstitialListener = interstitiallistener;
                errorStatus = interstitialerrorstatus;
                super();
            }
            });
        }
        return;
        errorStatus;
        this;
        JVM INSTR monitorexit ;
        throw errorStatus;
    }

    private void onShown(final com.millennialmedia.internal.AdPlacement.RequestState localInterstitialListener)
    {
        this;
        JVM INSTR monitorenter ;
        if (currentRequestState.compare(localInterstitialListener))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "onShown called but load state is not valid");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        placementState = "shown";
        AdPlacementReporter.setDisplayed(localInterstitialListener.getAdPlacementReporter());
        this;
        JVM INSTR monitorexit ;
        MMLog.i(TAG, "Ad shown");
        localInterstitialListener = interstitialListener;
        if (localInterstitialListener != null)
        {
            ThreadUtils.runOffUiThread(new Runnable() {

                final InterstitialAd this$0;
                final InterstitialListener val$localInterstitialListener;

                public void run()
                {
                    localInterstitialListener.onShown(InterstitialAd.this);
                }

            
            {
                this$0 = InterstitialAd.this;
                localInterstitialListener = interstitiallistener;
                super();
            }
            });
            return;
        } else
        {
            return;
        }
        localInterstitialListener;
        this;
        JVM INSTR monitorexit ;
        throw localInterstitialListener;
    }

    private void startExpirationTimer(com.millennialmedia.internal.AdPlacement.RequestState requeststate)
    {
        stopExpirationTimer();
        int i = Handshake.getInterstitialExpirationDuration();
        if (i > 0)
        {
            expirationRunnable = ThreadUtils.runOnWorkerThreadDelayed(new ExpirationRunnable(this, requeststate), i);
        }
    }

    private void stopExpirationTimer()
    {
        if (expirationRunnable != null)
        {
            expirationRunnable.cancel();
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

    public boolean hasExpired()
    {
        return placementState.equals("expired");
    }

    public boolean isReady()
    {
        return placementState.equals("loaded");
    }

    public void load(Context context1, final InterstitialAdMetadata localRequestState)
    {
        MMLog.i(TAG, (new StringBuilder()).append("Loading playlist for placement ID: ").append(placementId).toString());
        context = context1;
        this;
        JVM INSTR monitorenter ;
        if (placementState.equals("idle") || placementState.equals("load_failed") || placementState.equals("expired") || placementState.equals("show_failed"))
        {
            break MISSING_BLOCK_LABEL_118;
        }
        MMLog.w(TAG, (new StringBuilder()).append("Unable to load interstitial ad, state is invalid: ").append(placementState).toString());
        this;
        JVM INSTR monitorexit ;
        return;
        placementState = "loading_play_list";
        this;
        JVM INSTR monitorexit ;
        playList = null;
        context1 = localRequestState;
        if (localRequestState == null)
        {
            context1 = new InterstitialAdMetadata();
        }
        localRequestState = getRequestState();
        if (placementRequestTimeoutRunnable != null)
        {
            placementRequestTimeoutRunnable.cancel();
        }
        placementRequestTimeoutRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

            final InterstitialAd this$0;
            final com.millennialmedia.internal.AdPlacement.RequestState val$localRequestState;

            public void run()
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(InterstitialAd.TAG, "Play list load timed out");
                }
                onLoadFailed(localRequestState);
            }

            
            {
                this$0 = InterstitialAd.this;
                localRequestState = requeststate;
                super();
            }
        }, Handshake.getInterstitialTimeout());
        PlayListServer.loadPlayList(context1.toMap(this), new com.millennialmedia.internal.playlistserver.PlayListServer.PlayListLoadListener() );
        return;
        context1;
        this;
        JVM INSTR monitorexit ;
        throw context1;
    }

    public void setListener(InterstitialListener interstitiallistener)
    {
        interstitialListener = interstitiallistener;
    }

    public void show(Context context1)
        throws MMException
    {
        show(context1, null);
    }

    public void show(Context context1, DisplayOptions displayoptions)
        throws MMException
    {
        String s;
        s = null;
        if (context1 == null)
        {
            throw new MMException("Unable to show interstitial, specified context cannot be null");
        }
        this;
        JVM INSTR monitorenter ;
        if (!placementState.equals("loaded"))
        {
            s = (new StringBuilder()).append("Unable to show interstitial ad, state is not valid: ").append(placementState).toString();
        }
        this;
        JVM INSTR monitorexit ;
        if (s != null)
        {
            onShowFailed(new InterstitialErrorStatus(4, s));
            return;
        } else
        {
            stopExpirationTimer();
            interstitialAdAdapter.show(context1, displayoptions);
            return;
        }
        context1;
        this;
        JVM INSTR monitorexit ;
        throw context1;
    }





/*
    static com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable access$102(InterstitialAd interstitialad, com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable scheduledrunnable)
    {
        interstitialad.expirationRunnable = scheduledrunnable;
        return scheduledrunnable;
    }

*/











/*
    static String access$502(InterstitialAd interstitialad, String s)
    {
        interstitialad.placementState = s;
        return s;
    }

*/


/*
    static PlayList access$602(InterstitialAd interstitialad, PlayList playlist)
    {
        interstitialad.playList = playlist;
        return playlist;
    }

*/


/*
    static com.millennialmedia.internal.AdPlacement.RequestState access$702(InterstitialAd interstitialad, com.millennialmedia.internal.AdPlacement.RequestState requeststate)
    {
        interstitialad.currentRequestState = requeststate;
        return requeststate;
    }

*/


}
