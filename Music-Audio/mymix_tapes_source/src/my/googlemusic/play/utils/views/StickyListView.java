// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nineoldandroids.view.ViewHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StickyListView extends ListView
    implements android.widget.AbsListView.OnScrollListener, android.view.View.OnClickListener
{

    static final boolean $assertionsDisabled;
    private static final int COLOR_NORMAL = Color.parseColor("#99FFFFFF");
    private static final int COLOR_SELECTED = -1;
    private ListAdapter mAdapter;
    private List mFadeList;
    private View mHeader;
    private int mLastPosition;
    private int mMaxPosition;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener mObserver;
    private float mParallaxSpeed;
    private View mParallaxView;
    private int mProgress;
    private android.widget.AbsListView.OnScrollListener mScrollListener;
    private View mSticky;
    private OnStickyTabListener mStickyTabListener;
    private TextView mTabSelected;
    private boolean mTreeView;
    private boolean mTreeViewAdapter;

    public StickyListView(Context context)
    {
        super(context);
        mFadeList = new ArrayList();
        mObserver = new _cls1();
    }

    public StickyListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFadeList = new ArrayList();
        mObserver = new _cls1();
    }

    public StickyListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mFadeList = new ArrayList();
        mObserver = new _cls1();
    }

    private int convertDpToPixels(Context context, float f)
    {
        return (int)TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    private void initAdapter()
    {
        mTreeViewAdapter = true;
        View view = getChildAt(0);
        if (view != null)
        {
            int i = -view.getTop();
            int j = getFirstVisiblePosition();
            int k = view.getHeight();
            super.setAdapter(mAdapter);
            scrollTo(0, i + j * k);
            setStickyPosition(mLastPosition);
            return;
        } else
        {
            super.setAdapter(mAdapter);
            return;
        }
    }

    private void setStickyPosition(int i)
    {
        mLastPosition = i;
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)mSticky.getLayoutParams();
        if (marginlayoutparams != null)
        {
            marginlayoutparams.setMargins(0, i, 0, 0);
            mSticky.setLayoutParams(marginlayoutparams);
        }
        if (mParallaxView != null)
        {
            int j = (int)((float)(mMaxPosition - i) * -mParallaxSpeed);
            if (j != mParallaxView.getTop())
            {
                android.view.ViewGroup.MarginLayoutParams marginlayoutparams1 = (android.view.ViewGroup.MarginLayoutParams)mParallaxView.getLayoutParams();
                if (marginlayoutparams1 != null)
                {
                    marginlayoutparams1.setMargins(0, j, 0, 0);
                    mParallaxView.setLayoutParams(marginlayoutparams1);
                }
            }
        }
        if (mFadeList.size() > 0)
        {
            i = (int)Math.ceil((1.0F - (float)i / (float)mMaxPosition) * 100F);
            if (mProgress != i)
            {
                mProgress = i;
                for (Iterator iterator = mFadeList.iterator(); iterator.hasNext(); ViewHelper.setAlpha((View)iterator.next(), (float)mProgress / 100F)) { }
            }
        }
    }

    private void setTabSelected(boolean flag)
    {
        Object obj = mTabSelected;
        int i;
        if (flag)
        {
            i = -1;
        } else
        {
            i = COLOR_NORMAL;
        }
        ((TextView) (obj)).setTextColor(i);
        obj = (View)mTabSelected.getTag();
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

    public void addFadeView(View view)
    {
        mFadeList.add(view);
    }

    public void addHeaderView(View view)
    {
        super.addHeaderView(view, this, false);
        mHeader = view;
    }

    public void addHeaderView(View view, Object obj, boolean flag)
    {
        throw new IllegalStateException("You should use only addHeaderView(View header).");
    }

    public void addParallaxView(View view, float f)
    {
        mParallaxView = view;
        mParallaxSpeed = f;
    }

    public void addStickyView(View view)
    {
        if (mHeader == null)
        {
            throw new IllegalStateException("You should call addView(View header) before to add a sticky.");
        }
        mSticky = view;
        view = mSticky.getViewTreeObserver();
        if (view != null)
        {
            view.addOnGlobalLayoutListener(mObserver);
        }
    }

    public void addStickyView(String as[], int i, int j, boolean flag, OnStickyTabListener onstickytablistener)
    {
        mStickyTabListener = onstickytablistener;
        Context context = getContext();
        if (!$assertionsDisabled && context == null)
        {
            throw new AssertionError();
        }
        onstickytablistener = new RelativeLayout(context);
        Object obj = new android.widget.RelativeLayout.LayoutParams(-1, convertDpToPixels(context, 48F));
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(6, getId());
        onstickytablistener.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = new View(context);
        ((View) (obj)).setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -1));
        ((View) (obj)).setBackgroundColor(i);
        onstickytablistener.addView(((View) (obj)));
        if (flag)
        {
            addFadeView(((View) (obj)));
        }
        obj = new LinearLayout(context);
        ((LinearLayout) (obj)).setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -1));
        onstickytablistener.addView(((View) (obj)));
        for (i = 0; i < as.length; i++)
        {
            RelativeLayout relativelayout = new RelativeLayout(context);
            relativelayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1, 1.0F));
            ((LinearLayout) (obj)).addView(relativelayout);
            View view = new View(context);
            Object obj1 = new android.widget.RelativeLayout.LayoutParams(-1, convertDpToPixels(context, 2.0F));
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12, -1);
            view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            view.setBackgroundColor(j);
            view.setVisibility(8);
            view.setTag(Integer.valueOf(i));
            relativelayout.addView(view);
            obj1 = new TextView(context);
            ((TextView) (obj1)).setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -1));
            ((TextView) (obj1)).setGravity(17);
            ((TextView) (obj1)).setText(as[i].toUpperCase());
            ((TextView) (obj1)).setTextColor(COLOR_NORMAL);
            ((TextView) (obj1)).setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf"));
            ((TextView) (obj1)).setTag(view);
            ((TextView) (obj1)).setOnClickListener(this);
            relativelayout.addView(((View) (obj1)));
            if (i == 0)
            {
                mTabSelected = ((TextView) (obj1));
                setTabSelected(true);
            }
        }

        as = (ViewGroup)getParent();
        if (as != null)
        {
            as.addView(onstickytablistener);
        }
        addStickyView(((View) (onstickytablistener)));
    }

    public void onClick(View view)
    {
        if (mTabSelected != (TextView)view)
        {
            setTabSelected(false);
            mTabSelected = (TextView)view;
            setTabSelected(true);
            setStickyPosition(mHeader.getHeight());
    /* block-local class not found */
    class OnStickyTabListener {}

            mStickyTabListener.onStickyTabSelected(((Integer)((View)mTabSelected.getTag()).getTag()).intValue());
        }
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        setStickyPosition(mHeader.getBottom());
_L4:
        if (mScrollListener != null)
        {
            mScrollListener.onScroll(abslistview, i, j, k);
        }
        return;
_L2:
        if (mSticky.getTop() != 0)
        {
            setStickyPosition(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (mScrollListener != null)
        {
            mScrollListener.onScrollStateChanged(abslistview, i);
        }
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        mAdapter = listadapter;
        if (mTreeView)
        {
            initAdapter();
        }
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        mScrollListener = onscrolllistener;
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/utils/views/StickyListView.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }





/*
    static int access$302(StickyListView stickylistview, int i)
    {
        stickylistview.mMaxPosition = i;
        return i;
    }

*/


/*
    static int access$402(StickyListView stickylistview, int i)
    {
        stickylistview.mProgress = i;
        return i;
    }

*/




/*
    static boolean access$702(StickyListView stickylistview, boolean flag)
    {
        stickylistview.mTreeView = flag;
        return flag;
    }

*/


    /* member class not found */
    class _cls1 {}

}
