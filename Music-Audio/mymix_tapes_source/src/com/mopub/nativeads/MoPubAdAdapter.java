// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

// Referenced classes of package com.mopub.nativeads:
//            MoPubNativeAdPositioning, MoPubStreamAdPlacer, VisibilityTracker, MoPubNativeAdLoadedListener, 
//            RequestParameters, MoPubAdRenderer

public class MoPubAdAdapter extends BaseAdapter
{

    private MoPubNativeAdLoadedListener mAdLoadedListener;
    private final Adapter mOriginalAdapter;
    private final MoPubStreamAdPlacer mStreamAdPlacer;
    private final WeakHashMap mViewPositionMap;
    private final VisibilityTracker mVisibilityTracker;

    public MoPubAdAdapter(Context context, Adapter adapter)
    {
        this(context, adapter, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubAdAdapter(Context context, Adapter adapter, MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning)
    {
        this(new MoPubStreamAdPlacer(context, mopubclientpositioning), adapter, new VisibilityTracker(context));
    }

    public MoPubAdAdapter(Context context, Adapter adapter, MoPubNativeAdPositioning.MoPubServerPositioning mopubserverpositioning)
    {
        this(new MoPubStreamAdPlacer(context, mopubserverpositioning), adapter, new VisibilityTracker(context));
    }

    MoPubAdAdapter(MoPubStreamAdPlacer mopubstreamadplacer, Adapter adapter, VisibilityTracker visibilitytracker)
    {
        mOriginalAdapter = adapter;
        mStreamAdPlacer = mopubstreamadplacer;
        mViewPositionMap = new WeakHashMap();
        mVisibilityTracker = visibilitytracker;
        mVisibilityTracker.setVisibilityTrackerListener(new VisibilityTracker.VisibilityTrackerListener() {

            final MoPubAdAdapter this$0;

            public void onVisibilityChanged(List list, List list1)
            {
                handleVisibilityChange(list);
            }

            
            {
                this$0 = MoPubAdAdapter.this;
                super();
            }
        });
        mOriginalAdapter.registerDataSetObserver(new DataSetObserver() {

            final MoPubAdAdapter this$0;

            public void onChanged()
            {
                mStreamAdPlacer.setItemCount(mOriginalAdapter.getCount());
                notifyDataSetChanged();
            }

            public void onInvalidated()
            {
                notifyDataSetInvalidated();
            }

            
            {
                this$0 = MoPubAdAdapter.this;
                super();
            }
        });
        mStreamAdPlacer.setAdLoadedListener(new MoPubNativeAdLoadedListener() {

            final MoPubAdAdapter this$0;

            public void onAdLoaded(int i)
            {
                handleAdLoaded(i);
            }

            public void onAdRemoved(int i)
            {
                handleAdRemoved(i);
            }

            
            {
                this$0 = MoPubAdAdapter.this;
                super();
            }
        });
        mStreamAdPlacer.setItemCount(mOriginalAdapter.getCount());
    }

    private void handleVisibilityChange(List list)
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

    public boolean areAllItemsEnabled()
    {
        return (mOriginalAdapter instanceof ListAdapter) && ((ListAdapter)mOriginalAdapter).areAllItemsEnabled();
    }

    public void clearAds()
    {
        mStreamAdPlacer.clearAds();
    }

    public void destroy()
    {
        mStreamAdPlacer.destroy();
        mVisibilityTracker.destroy();
    }

    public int getAdjustedPosition(int i)
    {
        return mStreamAdPlacer.getAdjustedPosition(i);
    }

    public int getCount()
    {
        return mStreamAdPlacer.getAdjustedCount(mOriginalAdapter.getCount());
    }

    public Object getItem(int i)
    {
        Object obj = mStreamAdPlacer.getAdData(i);
        if (obj != null)
        {
            return obj;
        } else
        {
            return mOriginalAdapter.getItem(mStreamAdPlacer.getOriginalPosition(i));
        }
    }

    public long getItemId(int i)
    {
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
            return (mOriginalAdapter.getViewTypeCount() + j) - 1;
        } else
        {
            return mOriginalAdapter.getItemViewType(mStreamAdPlacer.getOriginalPosition(i));
        }
    }

    public int getOriginalPosition(int i)
    {
        return mStreamAdPlacer.getOriginalPosition(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = mStreamAdPlacer.getAdView(i, view, viewgroup);
        if (view1 != null)
        {
            view = view1;
        } else
        {
            view = mOriginalAdapter.getView(mStreamAdPlacer.getOriginalPosition(i), view, viewgroup);
        }
        mViewPositionMap.put(view, Integer.valueOf(i));
        mVisibilityTracker.addView(view, 0);
        return view;
    }

    public int getViewTypeCount()
    {
        return mOriginalAdapter.getViewTypeCount() + mStreamAdPlacer.getAdViewTypeCount();
    }

    void handleAdLoaded(int i)
    {
        if (mAdLoadedListener != null)
        {
            mAdLoadedListener.onAdLoaded(i);
        }
        notifyDataSetChanged();
    }

    void handleAdRemoved(int i)
    {
        if (mAdLoadedListener != null)
        {
            mAdLoadedListener.onAdRemoved(i);
        }
        notifyDataSetChanged();
    }

    public boolean hasStableIds()
    {
        return mOriginalAdapter.hasStableIds();
    }

    public void insertItem(int i)
    {
        mStreamAdPlacer.insertItem(i);
    }

    public boolean isAd(int i)
    {
        return mStreamAdPlacer.isAd(i);
    }

    public boolean isEmpty()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mOriginalAdapter.isEmpty())
        {
            flag = flag1;
            if (mStreamAdPlacer.getAdjustedCount(0) == 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isEnabled(int i)
    {
        return isAd(i) || (mOriginalAdapter instanceof ListAdapter) && ((ListAdapter)mOriginalAdapter).isEnabled(mStreamAdPlacer.getOriginalPosition(i));
    }

    public void loadAds(String s)
    {
        mStreamAdPlacer.loadAds(s);
    }

    public void loadAds(String s, RequestParameters requestparameters)
    {
        mStreamAdPlacer.loadAds(s, requestparameters);
    }

    public void refreshAds(ListView listview, String s)
    {
        refreshAds(listview, s, null);
    }

    public void refreshAds(ListView listview, String s, RequestParameters requestparameters)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(listview, "You called MoPubAdAdapter.refreshAds with a null ListView"))
        {
            return;
        }
        View view = listview.getChildAt(0);
        int i;
        int j;
        int l;
        if (view == null)
        {
            i = 0;
        } else
        {
            i = view.getTop();
        }
        l = listview.getFirstVisiblePosition();
        for (j = Math.max(l - 1, 0); mStreamAdPlacer.isAd(j) && j > 0; j--) { }
        int k;
        for (k = listview.getLastVisiblePosition(); mStreamAdPlacer.isAd(k) && k < getCount() - 1; k++) { }
        j = mStreamAdPlacer.getOriginalPosition(j);
        k = mStreamAdPlacer.getOriginalCount(k + 1);
        int i1 = mStreamAdPlacer.getOriginalCount(getCount());
        mStreamAdPlacer.removeAdsInRange(k, i1);
        j = mStreamAdPlacer.removeAdsInRange(0, j);
        if (j > 0)
        {
            listview.setSelectionFromTop(l - j, i);
        }
        loadAds(s, requestparameters);
    }

    public final void registerAdRenderer(MoPubAdRenderer mopubadrenderer)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(mopubadrenderer, "Tried to set a null ad renderer on the placer."))
        {
            return;
        } else
        {
            mStreamAdPlacer.registerAdRenderer(mopubadrenderer);
            return;
        }
    }

    public void removeItem(int i)
    {
        mStreamAdPlacer.removeItem(i);
    }

    public final void setAdLoadedListener(MoPubNativeAdLoadedListener mopubnativeadloadedlistener)
    {
        mAdLoadedListener = mopubnativeadloadedlistener;
    }

    public void setOnClickListener(ListView listview, final android.widget.AdapterView.OnItemClickListener listener)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(listview, "You called MoPubAdAdapter.setOnClickListener with a null ListView"))
        {
            return;
        }
        if (listener == null)
        {
            listview.setOnItemClickListener(null);
            return;
        } else
        {
            listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final MoPubAdAdapter this$0;
                final android.widget.AdapterView.OnItemClickListener val$listener;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    if (!mStreamAdPlacer.isAd(i))
                    {
                        listener.onItemClick(adapterview, view, mStreamAdPlacer.getOriginalPosition(i), l);
                    }
                }

            
            {
                this$0 = MoPubAdAdapter.this;
                listener = onitemclicklistener;
                super();
            }
            });
            return;
        }
    }

    public void setOnItemLongClickListener(ListView listview, final android.widget.AdapterView.OnItemLongClickListener listener)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(listview, "You called MoPubAdAdapter.setOnItemLongClickListener with a null ListView"))
        {
            return;
        }
        if (listener == null)
        {
            listview.setOnItemLongClickListener(null);
            return;
        } else
        {
            listview.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener() {

                final MoPubAdAdapter this$0;
                final android.widget.AdapterView.OnItemLongClickListener val$listener;

                public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
                {
                    return isAd(i) || listener.onItemLongClick(adapterview, view, mStreamAdPlacer.getOriginalPosition(i), l);
                }

            
            {
                this$0 = MoPubAdAdapter.this;
                listener = onitemlongclicklistener;
                super();
            }
            });
            return;
        }
    }

    public void setOnItemSelectedListener(ListView listview, final android.widget.AdapterView.OnItemSelectedListener listener)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(listview, "You called MoPubAdAdapter.setOnItemSelectedListener with a null ListView"))
        {
            return;
        }
        if (listener == null)
        {
            listview.setOnItemSelectedListener(null);
            return;
        } else
        {
            listview.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

                final MoPubAdAdapter this$0;
                final android.widget.AdapterView.OnItemSelectedListener val$listener;

                public void onItemSelected(AdapterView adapterview, View view, int i, long l)
                {
                    if (!isAd(i))
                    {
                        listener.onItemSelected(adapterview, view, mStreamAdPlacer.getOriginalPosition(i), l);
                    }
                }

                public void onNothingSelected(AdapterView adapterview)
                {
                    listener.onNothingSelected(adapterview);
                }

            
            {
                this$0 = MoPubAdAdapter.this;
                listener = onitemselectedlistener;
                super();
            }
            });
            return;
        }
    }

    public void setSelection(ListView listview, int i)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(listview, "You called MoPubAdAdapter.setSelection with a null ListView"))
        {
            return;
        } else
        {
            listview.setSelection(mStreamAdPlacer.getAdjustedPosition(i));
            return;
        }
    }

    public void smoothScrollToPosition(ListView listview, int i)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(listview, "You called MoPubAdAdapter.smoothScrollToPosition with a null ListView"))
        {
            return;
        } else
        {
            listview.smoothScrollToPosition(mStreamAdPlacer.getAdjustedPosition(i));
            return;
        }
    }



}
