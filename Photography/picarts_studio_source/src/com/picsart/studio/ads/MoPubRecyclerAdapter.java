// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.mopub.nativeads.MoPubNativeAdLoadedListener;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.nativeads.MoPubStreamAdPlacer;
import com.mopub.nativeads.NativeAdData;
import com.mopub.nativeads.NativeResponse;
import com.mopub.nativeads.VisibilityTracker;
import com.picsart.studio.utils.DynamicHeightImageView;
import com.socialin.android.NoProGuard;
import com.socialin.android.adapter.RecyclerViewAdapter;
import com.socialin.android.ads.SocialinAdManager;
import com.socialin.android.ads.c;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.d;
import com.socialin.android.util.Utils;
import com.socialin.android.util.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

// Referenced classes of package com.picsart.studio.ads:
//            g, e, f, d

public class MoPubRecyclerAdapter extends g
    implements NoProGuard
{

    private static final float AD_MAIN_IMAGE_RATIO = 0.5225F;
    private static final String TAG = (new StringBuilder()).append(com/picsart/studio/ads/MoPubRecyclerAdapter.getName()).append(" - ").toString();
    private com.picsart.studio.ads.e adInventoryUpdateReceiver;
    private int adsOffset;
    private String bannerAdUnitId;
    private HashMap bannerAdsMap;
    private com.socialin.android.apiv3.model.AppProps.AdType curAdType;
    private int extraX;
    private int extraY;
    private boolean isAdLoading;
    private boolean isCardType;
    private final RecyclerViewAdapter mOriginalAdapter;
    private MoPubStreamAdPlacer mStreamAdPlacer;
    private final WeakHashMap mViewPositionMap = new WeakHashMap();
    private final VisibilityTracker mVisibilityTracker;

    public MoPubRecyclerAdapter(Context context, RecyclerViewAdapter recyclerviewadapter)
    {
        super(context);
        isAdLoading = false;
        adsOffset = 0;
        bannerAdsMap = new HashMap();
        mOriginalAdapter = recyclerviewadapter;
        mStreamAdPlacer = new MoPubStreamAdPlacer(context, MoPubNativeAdPositioning.serverPositioning());
        setSupposedCount(10);
        mVisibilityTracker = new VisibilityTracker(context);
        adInventoryUpdateReceiver = new com.picsart.studio.ads.e(this, (byte)0);
        context.registerReceiver(adInventoryUpdateReceiver, new IntentFilter("update.adds.enabled.action"));
    }

    private void clearBannerAds()
    {
        for (Iterator iterator = bannerAdsMap.values().iterator(); iterator.hasNext(); ((c)iterator.next()).a()) { }
        bannerAdsMap.clear();
    }

    private void fillAdContent(com.picsart.studio.ads.f f1, NativeResponse nativeresponse)
    {
        (new f(context)).a(nativeresponse.getIconImageUrl(), f1.a, e.b(l.a), null);
        f1.d.setHeightRatio(0.52249997854232788D);
        nativeresponse.loadMainImage(f1.d);
        f1.b.setText(nativeresponse.getTitle());
        f1.c.setText("Sponsored");
        f1.e.setText(nativeresponse.getText());
        if (!TextUtils.isEmpty(nativeresponse.getCallToAction()))
        {
            f1.f.setVisibility(0);
            f1.f.setText(nativeresponse.getCallToAction());
            return;
        } else
        {
            f1.f.setVisibility(8);
            return;
        }
    }

    private String getString(int i)
    {
        return context.getString(i);
    }

    private void handleVisibilityChange(List list)
    {
        list = list.iterator();
        int j = 0x7fffffff;
        int i = 0;
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = (View)list.next();
            obj = (Integer)mViewPositionMap.get(obj);
            if (obj != null)
            {
                j = Math.min(((Integer) (obj)).intValue(), j);
                i = Math.max(((Integer) (obj)).intValue(), i);
            }
        } while (true);
        mStreamAdPlacer.placeAdsInRange(j, i + 1);
    }

    private void internalLoadAds()
    {
        final class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[com.socialin.android.apiv3.model.AppProps.TabAdType.values().length];
                try
                {
                    a[com.socialin.android.apiv3.model.AppProps.TabAdType.EXPLORE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.socialin.android.apiv3.model.AppProps.TabAdType.ARTISTS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.socialin.android.apiv3.model.AppProps.TabAdType.NETWORK.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.socialin.android.apiv3.model.AppProps.TabAdType.NOTIFICATIONS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3.a[curAdType.typeRef.ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 45
    //                   2 110
    //                   3 175
    //                   4 218;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if ("banner".equals(curAdType.name))
        {
            if (Utils.i(context))
            {
                loadBannerAds(getString(0x7f080947));
                return;
            } else
            {
                loadBannerAds(getString(0x7f080943));
                return;
            }
        } else
        {
            mStreamAdPlacer.loadAds(getString(0x7f080940));
            return;
        }
_L3:
        if ("banner".equals(curAdType.name))
        {
            if (Utils.i(context))
            {
                loadBannerAds(getString(0x7f080946));
                return;
            } else
            {
                loadBannerAds(getString(0x7f080942));
                return;
            }
        } else
        {
            mStreamAdPlacer.loadAds(getString(0x7f08093f));
            return;
        }
_L4:
        if ("banner".equals(curAdType.name))
        {
            loadBannerAds(getString(0x7f080944));
            return;
        } else
        {
            mStreamAdPlacer.loadAds(getString(0x7f080941));
            return;
        }
_L5:
        if ("banner".equals(curAdType.name))
        {
            loadBannerAds(getString(0x7f080945));
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    private void setupItemMarginsForTablet(View view)
    {
        if (!Utils.h(context) || !(view.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams))
        {
            return;
        }
        view = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        if (Utils.j(context))
        {
            int i = (int)(Utils.a(context.getResources().getConfiguration().screenWidthDp, context) * 0.33F * 0.5F);
            view.leftMargin = i;
            view.rightMargin = i;
            return;
        } else
        {
            int j = (int)context.getResources().getDimension(0x7f0b009c);
            view.leftMargin = j;
            view.rightMargin = j;
            return;
        }
    }

    private void setupMargins(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
        ((android.view.ViewGroup.MarginLayoutParams)viewholder.itemView.getLayoutParams()).setMargins(-extraX, -extraY, -extraX, -extraY);
        if (isCardType)
        {
            setupItemMarginsForTablet(viewholder.itemView);
        }
    }

    public void addAll(List list)
    {
        mOriginalAdapter.addAll(list);
        notifyDataSetChanged();
        mStreamAdPlacer.setItemCount(mOriginalAdapter.getItems().size());
    }

    public void clear()
    {
        mOriginalAdapter.clear();
        mStreamAdPlacer.removeAdsInRange(adsOffset, mStreamAdPlacer.getAdjustedCount(mOriginalAdapter.getItemCount() - adsOffset));
        notifyDataSetChanged();
    }

    public void clearAds()
    {
        mStreamAdPlacer.clearAds();
        mVisibilityTracker.setVisibilityTrackerListener(null);
        mStreamAdPlacer.setAdLoadedListener(null);
    }

    public void destroyAds()
    {
        clearBannerAds();
        if (adInventoryUpdateReceiver != null)
        {
            context.unregisterReceiver(adInventoryUpdateReceiver);
        }
        if (isAdLoading)
        {
            (new StringBuilder("MHandler: ")).append(mOriginalAdapter.toString()).append(" destroy");
            mViewPositionMap.clear();
            mStreamAdPlacer.destroy();
            mVisibilityTracker.destroy();
            isAdLoading = false;
        }
    }

    public Object getItem(int i)
    {
        if (mOriginalAdapter.getItems().size() == 0 || mStreamAdPlacer.getOriginalPosition(i - adsOffset) == -1)
        {
            return null;
        } else
        {
            return mOriginalAdapter.getItem(mStreamAdPlacer.getOriginalPosition(i - adsOffset) + adsOffset);
        }
    }

    public int getItemCount()
    {
        return mStreamAdPlacer.getAdjustedCount(mOriginalAdapter.getItemCount());
    }

    public int getItemViewType(int i)
    {
        if (mOriginalAdapter.getItems().size() == 0)
        {
            return -1;
        }
        if (adsOffset > i)
        {
            return mOriginalAdapter.getItemViewType(i);
        }
        if (mStreamAdPlacer.getAdViewType(i - adsOffset) == 0 && mStreamAdPlacer.getOriginalPosition(i - adsOffset) != -1 || curAdType == null)
        {
            return mOriginalAdapter.getItemViewType(mStreamAdPlacer.getOriginalPosition(i - adsOffset) + adsOffset);
        }
        return !"native".equals(curAdType.name) ? 0x7f100795 : 0x7f10005a;
    }

    public List getItems()
    {
        return mOriginalAdapter.getItems();
    }

    void handleAdLoaded(int i)
    {
        notifyItemInserted(i);
    }

    void handleAdRemoved(int i)
    {
        notifyItemRemoved(i);
    }

    public void init()
    {
        mVisibilityTracker.setVisibilityTrackerListener(new com.mopub.nativeads.VisibilityTracker.VisibilityTrackerListener() {

            private MoPubRecyclerAdapter a;

            public final void onVisibilityChanged(List list, List list1)
            {
                a.handleVisibilityChange(list);
            }

            
            {
                a = MoPubRecyclerAdapter.this;
                super();
            }
        });
        mStreamAdPlacer.setAdLoadedListener(new MoPubNativeAdLoadedListener() {

            private MoPubRecyclerAdapter a;

            public final void onAdLoaded(int i)
            {
                a.handleAdLoaded(a.adsOffset + i);
            }

            public final void onAdRemoved(int i)
            {
                a.handleAdRemoved(a.adsOffset + i);
            }

            
            {
                a = MoPubRecyclerAdapter.this;
                super();
            }
        });
        if (mOriginalAdapter.getItemCount() > 0)
        {
            mStreamAdPlacer.setItemCount(mOriginalAdapter.getItemCount());
            return;
        } else
        {
            setSupposedCount(10);
            return;
        }
    }

    public boolean isEmpty()
    {
        return mOriginalAdapter.isEmpty();
    }

    public void loadBannerAds(String s)
    {
        if (!s.equals(bannerAdUnitId))
        {
            refreshAdsForTablets();
        }
        bannerAdUnitId = s;
        if (isAdLoading || curAdType == null)
        {
            return;
        }
        isAdLoading = true;
        (new StringBuilder("MHandler: Banner ")).append(mOriginalAdapter.toString()).append(" load");
        s = new com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning();
        for (int i = 0; i < curAdType.fixedPositions.size(); i++)
        {
            s.addFixedPosition(((Integer)curAdType.fixedPositions.get(i)).intValue());
        }

        s.enableRepeatingPositions(curAdType.repeatCount);
        mStreamAdPlacer = new MoPubStreamAdPlacer(context, s);
        init();
        mStreamAdPlacer.loadPositions();
    }

    public void loadNativeAds(Bundle bundle)
    {
        if (!isAdLoading && curAdType != null && Inventory.isAdsEnabled())
        {
            init();
            (new StringBuilder("MHandler: ")).append(mOriginalAdapter.toString()).append(" load");
            if (mOriginalAdapter.getItemCount() != 0)
            {
                mStreamAdPlacer.setItemCount(mOriginalAdapter.getItemCount());
            }
            internalLoadAds();
            isAdLoading = true;
        }
    }

    public void notifyItemDataChanged(int i)
    {
        adsOffset = i;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        if (i == mStreamAdPlacer.getAdjustedCount(mOriginalAdapter.getItemCount()) - 1 && onScrolledToEndListener != null)
        {
            onScrolledToEndListener.a();
        }
        int j = getItemViewType(i);
        if (j == -1)
        {
            Log.e(TAG, (new StringBuilder("wrong type for position ")).append(i).toString());
        } else
        {
            if (j == 0x7f100795 && (viewholder instanceof com.picsart.studio.ads.d))
            {
                Object obj = (com.picsart.studio.ads.d)viewholder;
                ((com.picsart.studio.ads.d) (obj)).a.setVisibility(0);
                c c1 = (c)bannerAdsMap.get(Integer.valueOf(i));
                boolean flag1 = com.socialin.android.apiv3.model.AppProps.TabAdType.NOTIFICATIONS.equals(curAdType.typeRef);
                if (((com.picsart.studio.ads.d) (obj)).a.getChildCount() == 0 || c1 != null && !c1.b)
                {
                    bannerAdsMap.remove(Integer.valueOf(i));
                    ((com.picsart.studio.ads.d) (obj)).a.removeAllViews();
                    obj = ((com.picsart.studio.ads.d) (obj)).a;
                    Context context = this.context;
                    String s = bannerAdUnitId;
                    boolean flag;
                    if (!flag1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    obj = SocialinAdManager.a(((ViewGroup) (obj)), context, s, flag);
                    bannerAdsMap.put(Integer.valueOf(i), obj);
                    d.b(TAG, new Object[] {
                        "loading banner"
                    });
                }
                if (!flag1)
                {
                    setupMargins(viewholder);
                    return;
                } else
                {
                    ((android.view.ViewGroup.MarginLayoutParams)viewholder.itemView.getLayoutParams()).setMargins(-extraX, -extraY, -extraX, -extraY);
                    return;
                }
            }
            if (j == 0x7f10005a)
            {
                setupMargins(viewholder);
                Object obj1 = (NativeAdData)mStreamAdPlacer.getAdData(i - adsOffset);
                if (obj1 != null)
                {
                    obj1 = ((NativeAdData) (obj1)).getAd();
                    if ((viewholder instanceof com.picsart.studio.ads.f) && obj1 != null)
                    {
                        mStreamAdPlacer.trackImpression(((NativeResponse) (obj1)), viewholder.itemView);
                        fillAdContent((com.picsart.studio.ads.f)viewholder, ((NativeResponse) (obj1)));
                        return;
                    } else
                    {
                        (new StringBuilder("Should not happen for ")).append(i).append(" position");
                        return;
                    }
                }
            } else
            {
                mViewPositionMap.put(viewholder.itemView, Integer.valueOf(i));
                mVisibilityTracker.addView(viewholder.itemView, 0);
                i = mStreamAdPlacer.getOriginalPosition(i - adsOffset);
                int k = adsOffset;
                mOriginalAdapter.onBindViewHolder(viewholder, i + k);
                return;
            }
        }
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        if (i == 0x7f100795)
        {
            viewgroup = new com.picsart.studio.ads.d(LayoutInflater.from(context).inflate(0x7f03018d, viewgroup, false));
        } else
        {
            if (i == 0x7f10005a)
            {
                return new com.picsart.studio.ads.f(LayoutInflater.from(context).inflate(0x7f030169, viewgroup, false));
            }
            android.support.v7.widget.RecyclerView.ViewHolder viewholder = mOriginalAdapter.onCreateViewHolder(viewgroup, i);
            viewgroup = viewholder;
            if (viewholder == null)
            {
                return null;
            }
        }
        return viewgroup;
    }

    public void refreshAdsForTablets()
    {
        for (Iterator iterator = bannerAdsMap.values().iterator(); iterator.hasNext(); ((c)iterator.next()).a()) { }
    }

    public void remove(Object obj)
    {
        mOriginalAdapter.remove(obj);
    }

    public void setAdType(com.socialin.android.apiv3.model.AppProps.AdType adtype)
    {
        curAdType = adtype;
    }

    public void setAdapterConfigs(com.socialin.android.apiv3.model.AppProps.AdType adtype, Point point)
    {
        curAdType = adtype;
        boolean flag;
        if (adtype != null && (com.socialin.android.apiv3.model.AppProps.TabAdType.EXPLORE.equals(curAdType.typeRef) || com.socialin.android.apiv3.model.AppProps.TabAdType.ARTISTS.equals(curAdType.typeRef)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isCardType = flag;
        setExtraSpace(point.x, point.y);
    }

    public void setExtraSpace(int i, int j)
    {
        extraX = i;
        extraY = j;
    }

    public void setItems(List list)
    {
        mOriginalAdapter.setItems(list);
        if (Inventory.isAdsEnabled())
        {
            mStreamAdPlacer.setItemCount(mOriginalAdapter.getItemCount());
        } else
        {
            clearAds();
        }
        notifyDataSetChanged();
    }

    public void setOnScrollToEndListener(com.picsart.studio.view.e e1)
    {
        mOriginalAdapter.setOnScrollToEndListener(e1);
    }

    public void setSupposedCount(int i)
    {
        mStreamAdPlacer.setItemCount(i);
    }





/*
    static boolean access$302(MoPubRecyclerAdapter mopubrecycleradapter, boolean flag)
    {
        mopubrecycleradapter.isAdLoading = flag;
        return flag;
    }

*/


}
