// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshAdapterViewBase, LoadingLayoutProxy

public class PullToRefreshListView extends PullToRefreshAdapterViewBase
{

    private LoadingLayout mFooterLoadingView;
    private LoadingLayout mHeaderLoadingView;
    private boolean mListViewExtrasEnabled;
    private FrameLayout mLvFooterLoadingFrame;

    public PullToRefreshListView(Context context)
    {
        super(context);
    }

    public PullToRefreshListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode)
    {
        super(context, mode);
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationstyle)
    {
        super(context, mode, animationstyle);
    }

    protected ListView createListView(Context context, AttributeSet attributeset)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            return new InternalListViewSDK9(context, attributeset);
        } else
        {
            return new InternalListView(context, attributeset);
        }
    }

    protected LoadingLayoutProxy createLoadingLayoutProxy(boolean flag, boolean flag1)
    {
        LoadingLayoutProxy loadinglayoutproxy = super.createLoadingLayoutProxy(flag, flag1);
        if (mListViewExtrasEnabled)
        {
            PullToRefreshBase.Mode mode = getMode();
            if (flag && mode.showHeaderLoadingLayout())
            {
                loadinglayoutproxy.addLayout(mHeaderLoadingView);
            }
            if (flag1 && mode.showFooterLoadingLayout())
            {
                loadinglayoutproxy.addLayout(mFooterLoadingView);
            }
        }
        return loadinglayoutproxy;
    }

    protected volatile View createRefreshableView(Context context, AttributeSet attributeset)
    {
        return createRefreshableView(context, attributeset);
    }

    protected ListView createRefreshableView(Context context, AttributeSet attributeset)
    {
        context = createListView(context, attributeset);
        context.setId(0x102000a);
        return context;
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
    {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    protected void handleStyledAttributes(TypedArray typedarray)
    {
        super.handleStyledAttributes(typedarray);
        mListViewExtrasEnabled = typedarray.getBoolean(14, true);
        if (mListViewExtrasEnabled)
        {
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -2, 1);
            FrameLayout framelayout = new FrameLayout(getContext());
            mHeaderLoadingView = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START, typedarray);
            mHeaderLoadingView.setVisibility(8);
            framelayout.addView(mHeaderLoadingView, layoutparams);
            ((ListView)mRefreshableView).addHeaderView(framelayout, null, false);
            mLvFooterLoadingFrame = new FrameLayout(getContext());
            mFooterLoadingView = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END, typedarray);
            mFooterLoadingView.setVisibility(8);
            mLvFooterLoadingFrame.addView(mFooterLoadingView, layoutparams);
            if (!typedarray.hasValue(13))
            {
                setScrollingWhileRefreshingEnabled(true);
            }
        }
    }

    protected void onRefreshing(boolean flag)
    {
        Object obj = ((ListView)mRefreshableView).getAdapter();
        if (mListViewExtrasEnabled && getShowViewWhileRefreshing() && obj != null && !((ListAdapter) (obj)).isEmpty()) goto _L2; else goto _L1
_L1:
        super.onRefreshing(flag);
_L4:
        return;
_L2:
        LoadingLayout loadinglayout;
        LoadingLayout loadinglayout1;
        int i;
        int j;
        super.onRefreshing(false);
        switch (_cls1..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Mode[getCurrentMode().ordinal()])
        {
        default:
            obj = getHeaderLayout();
            loadinglayout = mHeaderLoadingView;
            loadinglayout1 = mFooterLoadingView;
            i = getScrollY() + getHeaderSize();
            j = 0;
            break;

        case 1: // '\001'
        case 2: // '\002'
            break; /* Loop/switch isn't completed */
        }
_L5:
        ((LoadingLayout) (obj)).reset();
        ((LoadingLayout) (obj)).hideAllViews();
        loadinglayout1.setVisibility(8);
        loadinglayout.setVisibility(0);
        loadinglayout.refreshing();
        if (flag)
        {
            disableLoadingLayoutVisibilityChanges();
            setHeaderScroll(i);
            ((ListView)mRefreshableView).setSelection(j);
            smoothScrollTo(0);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj = getFooterLayout();
        loadinglayout = mFooterLoadingView;
        loadinglayout1 = mHeaderLoadingView;
        j = ((ListView)mRefreshableView).getCount() - 1;
        i = getScrollY() - getFooterSize();
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected void onReset()
    {
        boolean flag;
        int i;
        i = 0;
        flag = true;
        if (!mListViewExtrasEnabled)
        {
            super.onReset();
            return;
        }
        _cls1..SwitchMap.com.handmark.pulltorefresh.library.PullToRefreshBase.Mode[getCurrentMode().ordinal()];
        JVM INSTR tableswitch 1 2: default 52
    //                   1 142
    //                   2 142;
           goto _L1 _L2 _L2
_L1:
        LoadingLayout loadinglayout1 = getHeaderLayout();
        LoadingLayout loadinglayout = mHeaderLoadingView;
        int j = -getHeaderSize();
        if (Math.abs(((ListView)mRefreshableView).getFirstVisiblePosition() + 0) > 1)
        {
            flag = false;
        }
_L4:
        if (loadinglayout.getVisibility() == 0)
        {
            loadinglayout1.showInvisibleViews();
            loadinglayout.setVisibility(8);
            if (flag && getState() != PullToRefreshBase.State.MANUAL_REFRESHING)
            {
                ((ListView)mRefreshableView).setSelection(i);
                setHeaderScroll(j);
            }
        }
        super.onReset();
        return;
_L2:
        loadinglayout1 = getFooterLayout();
        loadinglayout = mFooterLoadingView;
        i = ((ListView)mRefreshableView).getCount() - 1;
        j = getFooterSize();
        if (Math.abs(((ListView)mRefreshableView).getLastVisiblePosition() - i) <= 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }


    private class InternalListViewSDK9 extends InternalListView
    {
        private class InternalListView extends ListView
            implements EmptyViewMethodAccessor
        {

            private boolean mAddedLvFooter;
            final PullToRefreshListView this$0;

            protected void dispatchDraw(Canvas canvas)
            {
                try
                {
                    super.dispatchDraw(canvas);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Canvas canvas)
                {
                    canvas.printStackTrace();
                }
            }

            public boolean dispatchTouchEvent(MotionEvent motionevent)
            {
                boolean flag;
                try
                {
                    flag = super.dispatchTouchEvent(motionevent);
                }
                // Misplaced declaration of an exception variable
                catch (MotionEvent motionevent)
                {
                    motionevent.printStackTrace();
                    return false;
                }
                return flag;
            }

            public volatile void setAdapter(Adapter adapter)
            {
                setAdapter((ListAdapter)adapter);
            }

            public void setAdapter(ListAdapter listadapter)
            {
                if (mLvFooterLoadingFrame != null && !mAddedLvFooter)
                {
                    addFooterView(mLvFooterLoadingFrame, null, false);
                    mAddedLvFooter = true;
                }
                super.setAdapter(listadapter);
            }

            public void setEmptyView(View view)
            {
                PullToRefreshListView.this.setEmptyView(view);
            }

            public void setEmptyViewInternal(View view)
            {
                super.setEmptyView(view);
            }

            public InternalListView(Context context, AttributeSet attributeset)
            {
                this$0 = PullToRefreshListView.this;
                super(context, attributeset);
                mAddedLvFooter = false;
            }
        }


        final PullToRefreshListView this$0;

        protected final boolean overScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
                int l1, boolean flag)
        {
            boolean flag1 = super.overScrollBy(i, j, k, l, i1, j1, k1, l1, flag);
            OverscrollHelper.overScrollBy(PullToRefreshListView.this, i, k, j, l, flag);
            return flag1;
        }

        public InternalListViewSDK9(Context context, AttributeSet attributeset)
        {
            this$0 = PullToRefreshListView.this;
            super(context, attributeset);
        }
    }


    private class _cls1
    {

        static final int $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[];

        static 
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode = new int[PullToRefreshBase.Mode.values().length];
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
