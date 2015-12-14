// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.amazon.gallery.foundation.utils.messaging.InvalidateDataEvent;
import com.amazon.gallery.foundation.utils.messaging.ItemChangeEvent;
import com.amazon.gallery.framework.gallery.widget.AndroidGalleryBadgeableCoverView;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverViewProvider;
import com.amazon.gallery.framework.gallery.widget.MediaItemCursorAdapter;
import com.amazon.gallery.framework.gallery.widget.MosaicItemViewFactory;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.recyclerview.DefaultAspectRatioLookUp;
import com.amazon.gallery.framework.kindle.recyclerview.MosaicLayoutCache;
import com.amazon.gallery.framework.kindle.recyclerview.MosaicLayoutManager;
import com.amazon.gallery.framework.kindle.recyclerview.RecyclerAdapter;
import com.amazon.gallery.framework.kindle.widget.BadgeableItemViewFactory;
import com.amazon.gallery.thor.app.ui.cab.GalleryContextBar;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ViewFragment

public class MosaicFragment extends ViewFragment
{

    private int appBarHeight;
    private MosaicLayoutCache mosaicCache;
    private MosaicLayoutManager mosaicLayoutManager;

    public MosaicFragment()
    {
    }

    protected PointF computeScrollVectorForPosition(int i)
    {
        return mosaicLayoutManager.computeScrollVectorForPosition(i);
    }

    protected RecyclerAdapter createAdapter()
    {
        MosaicItemViewFactory mosaicitemviewfactory = new MosaicItemViewFactory(coverViewFactory, mosaicCache);
        BadgeableItemViewFactory badgeableitemviewfactory = new BadgeableItemViewFactory(mosaicitemviewfactory, mMediaItemBadgeChecker);
        badgeableitemviewfactory.setBadgeViewProvider(new GalleryBadgeableCoverViewProvider() {

            final MosaicFragment this$0;

            public GalleryBadgeableCoverView buildBadgeableCoverView(View view)
            {
                return new AndroidGalleryBadgeableCoverView(view);
            }

            
            {
                this$0 = MosaicFragment.this;
                super();
            }
        });
        return setupAdapter(mMediaItemCursorAdapter, mosaicitemviewfactory, badgeableitemviewfactory);
    }

    protected android.support.v7.widget.RecyclerView.LayoutManager createLayoutManager()
    {
        mosaicLayoutManager = new MosaicLayoutManager(getActivity(), 0, false, mosaicCache);
        return mosaicLayoutManager;
    }

    protected int getFirstCompletelyVisiblePosition()
    {
        return ((MosaicLayoutManager)mLayoutManager).findFirstCompletelyVisibleItemPosition();
    }

    public int getFirstVisiblePosition()
    {
        return ((MosaicLayoutManager)mLayoutManager).findFirstVisibleItemPosition();
    }

    protected int getLastVisiblePosition()
    {
        return ((MosaicLayoutManager)mLayoutManager).findLastVisibleItemPosition();
    }

    protected int getLayoutId()
    {
        return 0x7f0300ab;
    }

    protected int getMarginsForIndicators()
    {
        int j = super.getMarginsForIndicators();
        int i = j;
        if (!isInFullScreen())
        {
            i = j;
            if (!kindlePreferences.getBoolean("coldBootStatus", false))
            {
                i = j + appBarHeight;
            }
        }
        return i;
    }

    protected int getOffsetForPosition(int i)
    {
        View view = mLayoutManager.findViewByPosition(i);
        if (view == null)
        {
            return 0;
        } else
        {
            return view.getLeft() - mLayoutManager.getPaddingLeft();
        }
    }

    protected int getViewCacheSize()
    {
        return 6;
    }

    protected boolean hasTimeline()
    {
        return false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        appBarHeight = getResources().getDimensionPixelSize(0x7f0a000d);
        mAdapter.setOnTouchListener(new android.view.View.OnTouchListener() {

            final MosaicFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getRawY() < (float)appBarHeight && mScreenModeManager.isFullScreen())
                {
                    exitFullScreen();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = MosaicFragment.this;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mosaicCache = new MosaicLayoutCache(getResources().getDisplayMetrics().widthPixels);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        mosaicCache.setAspectRatioLookUp(new DefaultAspectRatioLookUp((MediaItemCursorAdapter)mAdapter.getDelegateAdapter()));
        return layoutinflater;
    }

    public void onInvalidateDataEvent(InvalidateDataEvent invalidatedataevent)
    {
        onDataInvalidated(invalidatedataevent.isHardReset());
    }

    public void onItemChangeEvent(final ItemChangeEvent event)
    {
        if (mAdapter != null && getActivity() != null)
        {
            getActivity().runOnUiThread(new Runnable() {

                final MosaicFragment this$0;
                final ItemChangeEvent val$event;

                public void run()
                {
                    if (event.isSingleItemChange())
                    {
                        mAdapter.notifyItemChanged(event.getPosition());
                        return;
                    } else
                    {
                        mAdapter.notifyItemRangeChanged(0, mAdapter.getItemCount());
                        return;
                    }
                }

            
            {
                this$0 = MosaicFragment.this;
                event = itemchangeevent;
                super();
            }
            });
        }
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        mosaicCache.clearCache();
        super.onLoadFinished(loader, cursor);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        mRecyclerView.setOnScrollListener(new android.support.v7.widget.RecyclerView.OnScrollListener() {

            private boolean finished;
            private Handler handler;
            private Runnable hideRunnable;
            final MosaicFragment this$0;
            private final int visibleThreshold = 25;

            private boolean isOnEdge()
            {
                int i = ((MosaicLayoutManager)mLayoutManager).findFirstCompletelyVisibleItemPosition();
                int j = ((MosaicLayoutManager)mLayoutManager).findLastCompletelyVisibleItemPosition();
                return i == 0 || j == mAdapter.getItemCount() - 1;
            }

            public void onScrollStateChanged(RecyclerView recyclerview, int i)
            {
                if (!mContextBar.isContextBarActive()) goto _L2; else goto _L1
_L1:
                return;
_L2:
                int j = getActivity().getWindow().getDecorView().getSystemUiVisibility();
                onSystemUiVisibilityChange(j);
                switch (i)
                {
                default:
                    return;

                case 1: // '\001'
                case 2: // '\002'
                    continue; /* Loop/switch isn't completed */

                case 0: // '\0'
                    handler.removeCallbacks(hideRunnable);
                    if (isOnEdge())
                    {
                        exitFullScreen();
                    }
                    if (!finished)
                    {
                        finished = checkLoadMoreItems(mosaicLayoutManager);
                        return;
                    }
                    break;
                }
                continue; /* Loop/switch isn't completed */
                if (isOnEdge() || mScreenModeManager.isFullScreen()) goto _L1; else goto _L3
_L3:
                enterFullScreen();
                handler.removeCallbacks(hideRunnable);
                handler.postDelayed(hideRunnable, 250L);
                return;
                if (true) goto _L1; else goto _L4
_L4:
            }

            
            {
                this$0 = MosaicFragment.this;
                super();
                handler = new Handler();
                hideRunnable = new _cls1();
                finished = false;
            }
        });
    }

    protected void scrollToPositionWithOffset(int i, int j)
    {
        ((MosaicLayoutManager)mLayoutManager).scrollToPositionWithOffset(i, j);
    }



    // Unreferenced inner class com/amazon/gallery/framework/kindle/fragment/MosaicFragment$2$1

/* anonymous class */
    class _cls1
        implements Runnable
    {

        final _cls2 this$1;

        public void run()
        {
            enterFullScreen();
        }

            
            {
                this$1 = _cls2.this;
                super();
            }
    }

}
