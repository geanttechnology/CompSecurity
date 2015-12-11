// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.logging.MoPubLog;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

// Referenced classes of package com.mopub.nativeads:
//            MoPubNativeAdPositioning, MoPubStreamAdPlacer, VisibilityTracker, MoPubNativeAdLoadedListener, 
//            NativeAdData, MoPubRecyclerViewHolder, MoPubAdRenderer, MoPubNativeAdRenderer, 
//            RequestParameters, ViewBinder

public final class MoPubRecyclerAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    public static final class ContentChangeStrategy extends Enum
    {

        private static final ContentChangeStrategy $VALUES[];
        public static final ContentChangeStrategy INSERT_AT_END;
        public static final ContentChangeStrategy KEEP_ADS_FIXED;
        public static final ContentChangeStrategy MOVE_ALL_ADS_WITH_CONTENT;

        public static ContentChangeStrategy valueOf(String s)
        {
            return (ContentChangeStrategy)Enum.valueOf(com/mopub/nativeads/MoPubRecyclerAdapter$ContentChangeStrategy, s);
        }

        public static ContentChangeStrategy[] values()
        {
            return (ContentChangeStrategy[])$VALUES.clone();
        }

        static 
        {
            INSERT_AT_END = new ContentChangeStrategy("INSERT_AT_END", 0);
            MOVE_ALL_ADS_WITH_CONTENT = new ContentChangeStrategy("MOVE_ALL_ADS_WITH_CONTENT", 1);
            KEEP_ADS_FIXED = new ContentChangeStrategy("KEEP_ADS_FIXED", 2);
            $VALUES = (new ContentChangeStrategy[] {
                INSERT_AT_END, MOVE_ALL_ADS_WITH_CONTENT, KEEP_ADS_FIXED
            });
        }

        private ContentChangeStrategy(String s, int i)
        {
            super(s, i);
        }
    }


    static final int NATIVE_AD_VIEW_TYPE_BASE = -56;
    private MoPubNativeAdLoadedListener mAdLoadedListener;
    private final android.support.v7.widget.RecyclerView.AdapterDataObserver mAdapterDataObserver;
    private final android.support.v7.widget.RecyclerView.Adapter mOriginalAdapter;
    private RecyclerView mRecyclerView;
    private ContentChangeStrategy mStrategy;
    private final MoPubStreamAdPlacer mStreamAdPlacer;
    private final WeakHashMap mViewPositionMap;
    private final VisibilityTracker mVisibilityTracker;

    public MoPubRecyclerAdapter(Context context, android.support.v7.widget.RecyclerView.Adapter adapter)
    {
        this(context, adapter, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubRecyclerAdapter(Context context, android.support.v7.widget.RecyclerView.Adapter adapter, MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning)
    {
        this(new MoPubStreamAdPlacer(context, mopubclientpositioning), adapter, new VisibilityTracker(context));
    }

    public MoPubRecyclerAdapter(Context context, android.support.v7.widget.RecyclerView.Adapter adapter, MoPubNativeAdPositioning.MoPubServerPositioning mopubserverpositioning)
    {
        this(new MoPubStreamAdPlacer(context, mopubserverpositioning), adapter, new VisibilityTracker(context));
    }

    MoPubRecyclerAdapter(MoPubStreamAdPlacer mopubstreamadplacer, android.support.v7.widget.RecyclerView.Adapter adapter, VisibilityTracker visibilitytracker)
    {
        mStrategy = ContentChangeStrategy.INSERT_AT_END;
        mViewPositionMap = new WeakHashMap();
        mOriginalAdapter = adapter;
        mVisibilityTracker = visibilitytracker;
        mVisibilityTracker.setVisibilityTrackerListener(new VisibilityTracker.VisibilityTrackerListener() {

            final MoPubRecyclerAdapter this$0;

            public void onVisibilityChanged(List list, List list1)
            {
                handleVisibilityChanged(list, list1);
            }

            
            {
                this$0 = MoPubRecyclerAdapter.this;
                super();
            }
        });
        setHasStableIdsInternal(mOriginalAdapter.hasStableIds());
        mStreamAdPlacer = mopubstreamadplacer;
        mStreamAdPlacer.setAdLoadedListener(new MoPubNativeAdLoadedListener() {

            final MoPubRecyclerAdapter this$0;

            public void onAdLoaded(int i)
            {
                handleAdLoaded(i);
            }

            public void onAdRemoved(int i)
            {
                handleAdRemoved(i);
            }

            
            {
                this$0 = MoPubRecyclerAdapter.this;
                super();
            }
        });
        mStreamAdPlacer.setItemCount(mOriginalAdapter.getItemCount());
        mAdapterDataObserver = new android.support.v7.widget.RecyclerView.AdapterDataObserver() {

            final MoPubRecyclerAdapter this$0;

            public void onChanged()
            {
                mStreamAdPlacer.setItemCount(mOriginalAdapter.getItemCount());
                notifyDataSetChanged();
            }

            public void onItemRangeChanged(int i, int j)
            {
                j = mStreamAdPlacer.getAdjustedPosition((i + j) - 1);
                i = mStreamAdPlacer.getAdjustedPosition(i);
                notifyItemRangeChanged(i, (j - i) + 1);
            }

            public void onItemRangeInserted(int i, int j)
            {
                int i1 = mStreamAdPlacer.getAdjustedPosition(i);
                int k = mOriginalAdapter.getItemCount();
                mStreamAdPlacer.setItemCount(k);
                if (i + j >= k)
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
                if (ContentChangeStrategy.KEEP_ADS_FIXED == mStrategy || ContentChangeStrategy.INSERT_AT_END == mStrategy && k)
                {
                    notifyDataSetChanged();
                    return;
                }
                for (int l = 0; l < j; l++)
                {
                    mStreamAdPlacer.insertItem(i);
                }

                notifyItemRangeInserted(i1, j);
            }

            public void onItemRangeMoved(int i, int j, int k)
            {
                notifyDataSetChanged();
            }

            public void onItemRangeRemoved(int i, int j)
            {
                int l = mStreamAdPlacer.getAdjustedPosition(i);
                int i1 = mOriginalAdapter.getItemCount();
                mStreamAdPlacer.setItemCount(i1);
                boolean flag;
                if (i + j >= i1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (ContentChangeStrategy.KEEP_ADS_FIXED == mStrategy || ContentChangeStrategy.INSERT_AT_END == mStrategy && flag)
                {
                    notifyDataSetChanged();
                    return;
                }
                int j1 = mStreamAdPlacer.getAdjustedCount(i1 + j);
                for (int k = 0; k < j; k++)
                {
                    mStreamAdPlacer.removeItem(i);
                }

                i = j1 - mStreamAdPlacer.getAdjustedCount(i1);
                notifyItemRangeRemoved(l - (i - j), i);
            }

            
            {
                this$0 = MoPubRecyclerAdapter.this;
                super();
            }
        };
        mOriginalAdapter.registerAdapterDataObserver(mAdapterDataObserver);
    }

    public static int computeScrollOffset(LinearLayoutManager linearlayoutmanager, android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
        if (viewholder != null)
        {
            viewholder = viewholder.itemView;
            if (linearlayoutmanager.canScrollVertically())
            {
                if (linearlayoutmanager.getStackFromEnd())
                {
                    return viewholder.getBottom();
                } else
                {
                    return viewholder.getTop();
                }
            }
            if (linearlayoutmanager.canScrollHorizontally())
            {
                if (linearlayoutmanager.getStackFromEnd())
                {
                    return viewholder.getRight();
                } else
                {
                    return viewholder.getLeft();
                }
            }
        }
        return 0;
    }

    private void handleVisibilityChanged(List list, List list1)
    {
        int j = 0x7fffffff;
        int i = 0;
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            list1 = (View)list.next();
            list1 = (Integer)mViewPositionMap.get(list1);
            if (list1 != null)
            {
                j = Math.min(list1.intValue(), j);
                i = Math.max(list1.intValue(), i);
            }
        } while (true);
        mStreamAdPlacer.placeAdsInRange(j, i + 1);
    }

    private void setHasStableIdsInternal(boolean flag)
    {
        super.setHasStableIds(flag);
    }

    public void clearAds()
    {
        mStreamAdPlacer.clearAds();
    }

    public void destroy()
    {
        mOriginalAdapter.unregisterAdapterDataObserver(mAdapterDataObserver);
        mStreamAdPlacer.destroy();
        mVisibilityTracker.destroy();
    }

    public int getAdjustedPosition(int i)
    {
        return mStreamAdPlacer.getAdjustedPosition(i);
    }

    public int getItemCount()
    {
        return mStreamAdPlacer.getAdjustedCount(mOriginalAdapter.getItemCount());
    }

    public long getItemId(int i)
    {
        if (!mOriginalAdapter.hasStableIds())
        {
            return -1L;
        }
        Object obj = mStreamAdPlacer.getAdData(i);
        if (obj != null)
        {
            return (long)(-System.identityHashCode(obj));
        } else
        {
            return mOriginalAdapter.getItemId(mStreamAdPlacer.getOriginalPosition(i));
        }
    }

    public int getItemViewType(int i)
    {
        int j = mStreamAdPlacer.getAdViewType(i);
        if (j != 0)
        {
            return j - 56;
        } else
        {
            return mOriginalAdapter.getItemViewType(mStreamAdPlacer.getOriginalPosition(i));
        }
    }

    public int getOriginalPosition(int i)
    {
        return mStreamAdPlacer.getOriginalPosition(i);
    }

    void handleAdLoaded(int i)
    {
        if (mAdLoadedListener != null)
        {
            mAdLoadedListener.onAdLoaded(i);
        }
        notifyItemInserted(i);
    }

    void handleAdRemoved(int i)
    {
        if (mAdLoadedListener != null)
        {
            mAdLoadedListener.onAdRemoved(i);
        }
        notifyItemRemoved(i);
    }

    public boolean isAd(int i)
    {
        return mStreamAdPlacer.isAd(i);
    }

    public void loadAds(String s)
    {
        mStreamAdPlacer.loadAds(s);
    }

    public void loadAds(String s, RequestParameters requestparameters)
    {
        mStreamAdPlacer.loadAds(s, requestparameters);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerview)
    {
        super.onAttachedToRecyclerView(recyclerview);
        mRecyclerView = recyclerview;
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        Object obj = mStreamAdPlacer.getAdData(i);
        if (obj != null)
        {
            mStreamAdPlacer.bindAdView((NativeAdData)obj, viewholder.itemView);
            return;
        } else
        {
            mViewPositionMap.put(viewholder.itemView, Integer.valueOf(i));
            mVisibilityTracker.addView(viewholder.itemView, 0);
            mOriginalAdapter.onBindViewHolder(viewholder, mStreamAdPlacer.getOriginalPosition(i));
            return;
        }
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        if (i >= -56 && i <= mStreamAdPlacer.getAdViewTypeCount() - 56)
        {
            MoPubAdRenderer mopubadrenderer = mStreamAdPlacer.getAdRendererForViewType(i);
            if (mopubadrenderer == null)
            {
                MoPubLog.w("No view binder was registered for ads in MoPubRecyclerAdapter.");
                return null;
            } else
            {
                return new MoPubRecyclerViewHolder(mopubadrenderer.createAdView(viewgroup.getContext(), viewgroup));
            }
        } else
        {
            return mOriginalAdapter.onCreateViewHolder(viewgroup, i);
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerview)
    {
        super.onDetachedFromRecyclerView(recyclerview);
        mRecyclerView = null;
    }

    public boolean onFailedToRecycleView(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
        if (viewholder instanceof MoPubRecyclerViewHolder)
        {
            return super.onFailedToRecycleView(viewholder);
        } else
        {
            return mOriginalAdapter.onFailedToRecycleView(viewholder);
        }
    }

    public void onViewAttachedToWindow(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
        if (viewholder instanceof MoPubRecyclerViewHolder)
        {
            super.onViewAttachedToWindow(viewholder);
            return;
        } else
        {
            mOriginalAdapter.onViewAttachedToWindow(viewholder);
            return;
        }
    }

    public void onViewDetachedFromWindow(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
        if (viewholder instanceof MoPubRecyclerViewHolder)
        {
            super.onViewDetachedFromWindow(viewholder);
            return;
        } else
        {
            mOriginalAdapter.onViewDetachedFromWindow(viewholder);
            return;
        }
    }

    public void onViewRecycled(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
        if (viewholder instanceof MoPubRecyclerViewHolder)
        {
            super.onViewRecycled(viewholder);
            return;
        } else
        {
            mOriginalAdapter.onViewRecycled(viewholder);
            return;
        }
    }

    public void refreshAds(String s)
    {
        refreshAds(s, null);
    }

    public void refreshAds(String s, RequestParameters requestparameters)
    {
        if (mRecyclerView == null)
        {
            MoPubLog.w("This adapter is not attached to a RecyclerView and cannot be refreshed.");
            return;
        }
        Object obj = mRecyclerView.getLayoutManager();
        if (obj == null)
        {
            MoPubLog.w("Can't refresh ads when there is no layout manager on a RecyclerView.");
            return;
        }
        if (obj instanceof LinearLayoutManager)
        {
            obj = (LinearLayoutManager)obj;
            int k = ((LinearLayoutManager) (obj)).findFirstVisibleItemPosition();
            int l = computeScrollOffset(((LinearLayoutManager) (obj)), mRecyclerView.findViewHolderForLayoutPosition(k));
            int i;
            for (i = Math.max(0, k - 1); mStreamAdPlacer.isAd(i) && i > 0; i--) { }
            int i1 = getItemCount();
            int j;
            for (j = ((LinearLayoutManager) (obj)).findLastVisibleItemPosition(); mStreamAdPlacer.isAd(j) && j < i1 - 1; j++) { }
            i = mStreamAdPlacer.getOriginalPosition(i);
            j = mStreamAdPlacer.getOriginalPosition(j);
            i1 = mOriginalAdapter.getItemCount();
            mStreamAdPlacer.removeAdsInRange(j, i1);
            i = mStreamAdPlacer.removeAdsInRange(0, i);
            if (i > 0)
            {
                ((LinearLayoutManager) (obj)).scrollToPositionWithOffset(k - i, l);
            }
            loadAds(s, requestparameters);
            return;
        } else
        {
            MoPubLog.w("This LayoutManager can't be refreshed.");
            return;
        }
    }

    public void registerViewBinder(ViewBinder viewbinder)
    {
        mStreamAdPlacer.registerAdRenderer(new MoPubNativeAdRenderer(viewbinder), -55);
    }

    public void setAdLoadedListener(MoPubNativeAdLoadedListener mopubnativeadloadedlistener)
    {
        mAdLoadedListener = mopubnativeadloadedlistener;
    }

    public void setContentChangeStrategy(ContentChangeStrategy contentchangestrategy)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(contentchangestrategy))
        {
            return;
        } else
        {
            mStrategy = contentchangestrategy;
            return;
        }
    }

    public void setHasStableIds(boolean flag)
    {
        setHasStableIdsInternal(flag);
        mOriginalAdapter.unregisterAdapterDataObserver(mAdapterDataObserver);
        mOriginalAdapter.setHasStableIds(flag);
        mOriginalAdapter.registerAdapterDataObserver(mAdapterDataObserver);
    }




}
