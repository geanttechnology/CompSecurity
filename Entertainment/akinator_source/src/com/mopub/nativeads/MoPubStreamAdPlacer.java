// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

// Referenced classes of package com.mopub.nativeads:
//            MoPubNativeAdPositioning, NativeAdSource, ImpressionTracker, ClientPositioningSource, 
//            ServerPositioningSource, PlacementData, NativeResponse, NativeAdData, 
//            MoPubNativeAdLoadedListener, MoPubAdRenderer, PositioningSource, RequestParameters

public class MoPubStreamAdPlacer
{

    public static final int CONTENT_VIEW_TYPE = 0;
    private static final int DEFAULT_AD_VIEW_TYPE = -1;
    private static final MoPubNativeAdLoadedListener EMPTY_NATIVE_AD_LOADED_LISTENER = new MoPubNativeAdLoadedListener() {

        public void onAdLoaded(int i)
        {
        }

        public void onAdRemoved(int i)
        {
        }

    };
    private static final int MAX_VISIBLE_RANGE = 100;
    private static final int RANGE_BUFFER = 10;
    private int adViewType;
    private MoPubNativeAdLoadedListener mAdLoadedListener;
    private MoPubAdRenderer mAdRenderer;
    private final NativeAdSource mAdSource;
    private String mAdUnitId;
    private final Context mContext;
    private boolean mHasPlacedAds;
    private boolean mHasReceivedAds;
    private boolean mHasReceivedPositions;
    private final ImpressionTracker mImpressionTracker;
    private int mItemCount;
    private final WeakHashMap mNativeResponseMap;
    private boolean mNeedsPlacement;
    private PlacementData mPendingPlacementData;
    private PlacementData mPlacementData;
    private final Handler mPlacementHandler;
    private final Runnable mPlacementRunnable;
    private final PositioningSource mPositioningSource;
    private final HashMap mViewMap;
    private int mVisibleRangeEnd;
    private int mVisibleRangeStart;

    public MoPubStreamAdPlacer(Context context)
    {
        this(context, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubStreamAdPlacer(Context context, MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning)
    {
        this(context, new NativeAdSource(), new ImpressionTracker(context), ((PositioningSource) (new ClientPositioningSource(mopubclientpositioning))));
    }

    public MoPubStreamAdPlacer(Context context, MoPubNativeAdPositioning.MoPubServerPositioning mopubserverpositioning)
    {
        this(context, new NativeAdSource(), new ImpressionTracker(context), ((PositioningSource) (new ServerPositioningSource(context))));
    }

    MoPubStreamAdPlacer(Context context, NativeAdSource nativeadsource, ImpressionTracker impressiontracker, PositioningSource positioningsource)
    {
        adViewType = -1;
        mAdLoadedListener = EMPTY_NATIVE_AD_LOADED_LISTENER;
        Preconditions.checkNotNull(context, "context is not allowed to be null");
        Preconditions.checkNotNull(nativeadsource, "adSource is not allowed to be null");
        Preconditions.checkNotNull(impressiontracker, "impressionTracker is not allowed to be null");
        Preconditions.checkNotNull(positioningsource, "positioningSource is not allowed to be null");
        mContext = context;
        mImpressionTracker = impressiontracker;
        mPositioningSource = positioningsource;
        mAdSource = nativeadsource;
        mPlacementData = PlacementData.empty();
        mNativeResponseMap = new WeakHashMap();
        mViewMap = new HashMap();
        mPlacementHandler = new Handler();
        mPlacementRunnable = new Runnable() {

            final MoPubStreamAdPlacer this$0;

            public void run()
            {
                if (!mNeedsPlacement)
                {
                    return;
                } else
                {
                    placeAds();
                    mNeedsPlacement = false;
                    return;
                }
            }

            
            {
                this$0 = MoPubStreamAdPlacer.this;
                super();
            }
        };
        mVisibleRangeStart = 0;
        mVisibleRangeEnd = 0;
    }

    private void clearNativeResponse(View view)
    {
        if (view != null)
        {
            mImpressionTracker.removeView(view);
            NativeResponse nativeresponse = (NativeResponse)mNativeResponseMap.get(view);
            if (nativeresponse != null)
            {
                nativeresponse.clear(view);
                mNativeResponseMap.remove(view);
                mViewMap.remove(nativeresponse);
                return;
            }
        }
    }

    private NativeAdData createAdData(NativeResponse nativeresponse)
    {
        Preconditions.checkNotNull(mAdUnitId);
        Preconditions.checkNotNull(mAdRenderer);
        return new NativeAdData(mAdUnitId, mAdRenderer, nativeresponse);
    }

    private void notifyNeedsPlacement()
    {
        if (mNeedsPlacement)
        {
            return;
        } else
        {
            mNeedsPlacement = true;
            mPlacementHandler.post(mPlacementRunnable);
            return;
        }
    }

    private void placeAds()
    {
        if (!tryPlaceAdsInRange(mVisibleRangeStart, mVisibleRangeEnd))
        {
            return;
        } else
        {
            tryPlaceAdsInRange(mVisibleRangeEnd, mVisibleRangeEnd + 10);
            return;
        }
    }

    private void placeInitialAds(PlacementData placementdata)
    {
        removeAdsInRange(0, mItemCount);
        mPlacementData = placementdata;
        placeAds();
        mHasPlacedAds = true;
    }

    private void prepareNativeResponse(NativeResponse nativeresponse, View view)
    {
        mViewMap.put(nativeresponse, new WeakReference(view));
        mNativeResponseMap.put(view, nativeresponse);
        if (!nativeresponse.isOverridingImpressionTracker())
        {
            mImpressionTracker.addView(view, nativeresponse);
        }
        nativeresponse.prepare(view);
    }

    private boolean tryPlaceAd(int i)
    {
        Object obj = mAdSource.dequeueAd();
        if (obj == null)
        {
            return false;
        } else
        {
            obj = createAdData(((NativeResponse) (obj)));
            mPlacementData.placeAd(i, ((NativeAdData) (obj)));
            mItemCount = mItemCount + 1;
            mAdLoadedListener.onAdLoaded(i);
            return true;
        }
    }

    private boolean tryPlaceAdsInRange(int i, int j)
    {
        j--;
        do
        {
            if (i > j || i == -1 || i >= mItemCount)
            {
                return true;
            }
            int k = j;
            if (mPlacementData.shouldPlaceAd(i))
            {
                if (!tryPlaceAd(i))
                {
                    return false;
                }
                k = j + 1;
            }
            i = mPlacementData.nextInsertionPosition(i);
            j = k;
        } while (true);
    }

    public void bindAdView(NativeAdData nativeaddata, View view)
    {
        NativeResponse nativeresponse = nativeaddata.getAd();
        WeakReference weakreference = (WeakReference)mViewMap.get(nativeresponse);
        View view1 = null;
        if (weakreference != null)
        {
            view1 = (View)weakreference.get();
        }
        if (!view.equals(view1))
        {
            clearNativeResponse(view1);
            clearNativeResponse(view);
            prepareNativeResponse(nativeresponse, view);
            nativeaddata.getAdRenderer().renderAdView(view, nativeresponse);
        }
    }

    public void clearAds()
    {
        removeAdsInRange(0, mItemCount);
        mAdSource.clear();
    }

    public void destroy()
    {
        mPlacementHandler.removeMessages(0);
        mAdSource.clear();
        mImpressionTracker.destroy();
        mPlacementData.clearAds();
    }

    public Object getAdData(int i)
    {
        return mPlacementData.getPlacedAd(i);
    }

    public MoPubAdRenderer getAdRendererForViewType(int i)
    {
        if (i == adViewType)
        {
            return mAdRenderer;
        } else
        {
            return null;
        }
    }

    public View getAdView(int i, View view, ViewGroup viewgroup)
    {
        NativeAdData nativeaddata = mPlacementData.getPlacedAd(i);
        if (nativeaddata == null)
        {
            return null;
        }
        if (view == null)
        {
            view = nativeaddata.getAdRenderer().createAdView(mContext, viewgroup);
        }
        bindAdView(nativeaddata, view);
        return view;
    }

    public int getAdViewType(int i)
    {
        return !isAd(i) ? 0 : 1;
    }

    public int getAdViewTypeCount()
    {
        return 1;
    }

    public int getAdjustedCount(int i)
    {
        return mPlacementData.getAdjustedCount(i);
    }

    public int getAdjustedPosition(int i)
    {
        return mPlacementData.getAdjustedPosition(i);
    }

    public int getOriginalCount(int i)
    {
        return mPlacementData.getOriginalCount(i);
    }

    public int getOriginalPosition(int i)
    {
        return mPlacementData.getOriginalPosition(i);
    }

    void handleAdsAvailable()
    {
        if (mHasPlacedAds)
        {
            notifyNeedsPlacement();
            return;
        }
        if (mHasReceivedPositions)
        {
            placeInitialAds(mPendingPlacementData);
        }
        mHasReceivedAds = true;
    }

    void handlePositioningLoad(MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning)
    {
        mopubclientpositioning = PlacementData.fromAdPositioning(mopubclientpositioning);
        if (mHasReceivedAds)
        {
            placeInitialAds(mopubclientpositioning);
        } else
        {
            mPendingPlacementData = mopubclientpositioning;
        }
        mHasReceivedPositions = true;
    }

    public void insertItem(int i)
    {
        mPlacementData.insertItem(i);
    }

    public boolean isAd(int i)
    {
        return mPlacementData.isPlacedAd(i);
    }

    public void loadAds(String s)
    {
        loadAds(s, null);
    }

    public void loadAds(String s, RequestParameters requestparameters)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(s, "Cannot load ads with a null ad unit ID"))
        {
            return;
        }
        if (mAdRenderer == null)
        {
            MoPubLog.w("You must call registerAdRenderer before loading ads");
            return;
        } else
        {
            mAdUnitId = s;
            mHasPlacedAds = false;
            mHasReceivedPositions = false;
            mHasReceivedAds = false;
            mPositioningSource.loadPositions(s, new PositioningSource.PositioningListener() {

                final MoPubStreamAdPlacer this$0;

                public void onFailed()
                {
                    MoPubLog.d("Unable to show ads because ad positions could not be loaded from the MoPub ad server.");
                }

                public void onLoad(MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning)
                {
                    handlePositioningLoad(mopubclientpositioning);
                }

            
            {
                this$0 = MoPubStreamAdPlacer.this;
                super();
            }
            });
            mAdSource.setAdSourceListener(new NativeAdSource.AdSourceListener() {

                final MoPubStreamAdPlacer this$0;

                public void onAdsAvailable()
                {
                    handleAdsAvailable();
                }

            
            {
                this$0 = MoPubStreamAdPlacer.this;
                super();
            }
            });
            mAdSource.loadAds(mContext, s, requestparameters);
            return;
        }
    }

    public void moveItem(int i, int j)
    {
        mPlacementData.moveItem(i, j);
    }

    public void placeAdsInRange(int i, int j)
    {
        mVisibleRangeStart = i;
        mVisibleRangeEnd = Math.min(j, i + 100);
        notifyNeedsPlacement();
    }

    public void registerAdRenderer(MoPubAdRenderer mopubadrenderer)
    {
        registerAdRenderer(mopubadrenderer, -1);
    }

    public void registerAdRenderer(MoPubAdRenderer mopubadrenderer, int i)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(mopubadrenderer, "Cannot register a null adRenderer"))
        {
            return;
        } else
        {
            adViewType = i;
            mAdRenderer = mopubadrenderer;
            return;
        }
    }

    public int removeAdsInRange(int i, int j)
    {
        int ai[] = mPlacementData.getPlacedAdPositions();
        int k = mPlacementData.getAdjustedPosition(i);
        j = mPlacementData.getAdjustedPosition(j);
        ArrayList arraylist = new ArrayList();
        i = ai.length - 1;
        while (i >= 0) 
        {
            int l = ai[i];
            if (l >= k && l < j)
            {
                arraylist.add(Integer.valueOf(l));
                if (l < mVisibleRangeStart)
                {
                    mVisibleRangeStart = mVisibleRangeStart - 1;
                }
                mItemCount = mItemCount - 1;
            }
            i--;
        }
        i = mPlacementData.clearAdsInRange(k, j);
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); mAdLoadedListener.onAdRemoved(j))
        {
            j = ((Integer)iterator.next()).intValue();
        }

        return i;
    }

    public void removeItem(int i)
    {
        mPlacementData.removeItem(i);
    }

    public void setAdLoadedListener(MoPubNativeAdLoadedListener mopubnativeadloadedlistener)
    {
        MoPubNativeAdLoadedListener mopubnativeadloadedlistener1 = mopubnativeadloadedlistener;
        if (mopubnativeadloadedlistener == null)
        {
            mopubnativeadloadedlistener1 = EMPTY_NATIVE_AD_LOADED_LISTENER;
        }
        mAdLoadedListener = mopubnativeadloadedlistener1;
    }

    public void setItemCount(int i)
    {
        mItemCount = mPlacementData.getAdjustedCount(i);
        if (mHasPlacedAds)
        {
            notifyNeedsPlacement();
        }
    }




/*
    static boolean access$002(MoPubStreamAdPlacer mopubstreamadplacer, boolean flag)
    {
        mopubstreamadplacer.mNeedsPlacement = flag;
        return flag;
    }

*/

}
