// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import co.vine.android.dragsort.DragSortWidget;
import java.util.ArrayList;

public class HorizontalListView extends AdapterView
{
    private class AdapterDataSetObserver extends DataSetObserver
    {

        final HorizontalListView this$0;

        public void onChanged()
        {
            mItemCount = mAdapter.getCount();
            mDataChanged = true;
            requestLayout();
        }

        public void onInvalidated()
        {
            mItemCount = 0;
            mDataChanged = true;
            requestLayout();
        }

        public AdapterDataSetObserver()
        {
            this$0 = HorizontalListView.this;
            super();
        }
    }

    private class CheckForLongPress
        implements Runnable
    {

        private int mOriginalAttachCount;
        final HorizontalListView this$0;

        public void rememberWindowAttachCount()
        {
            mOriginalAttachCount = getWindowAttachCount();
        }

        public void run()
        {
label0:
            {
                int i = mMotionPosition;
                View view = getChildAt(i - mFirstVisiblePos);
                if (view != null)
                {
                    int j = mMotionPosition;
                    long l = mAdapter.getItemId(mMotionPosition);
                    boolean flag1 = false;
                    boolean flag = flag1;
                    if (sameWindow())
                    {
                        flag = flag1;
                        if (!mDataChanged)
                        {
                            flag = performLongPress(view, j, l);
                        }
                    }
                    if (!flag)
                    {
                        break label0;
                    }
                    mTouchMode = -1;
                    setPressed(false);
                    view.setPressed(false);
                }
                return;
            }
            mTouchMode = 2;
        }

        public boolean sameWindow()
        {
            return hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount;
        }

        private CheckForLongPress()
        {
            this$0 = HorizontalListView.this;
            super();
        }

    }

    final class CheckForTap
        implements Runnable
    {

        final HorizontalListView this$0;

        public void run()
        {
            if (mTouchMode == 0)
            {
                mTouchMode = 1;
                View view = getChildAt(mMotionPosition - mFirstVisiblePos);
                if (view != null && !view.hasFocusable())
                {
                    if (!mDataChanged)
                    {
                        view.setPressed(true);
                        setPressed(true);
                        layoutChildren();
                        refreshDrawableState();
                        boolean flag = isLongClickable();
                        if (mSelector != null)
                        {
                            Drawable drawable = mSelector.getCurrent();
                            if (drawable != null && (drawable instanceof TransitionDrawable))
                            {
                                if (flag)
                                {
                                    ((TransitionDrawable)drawable).startTransition(mLongPressMillis);
                                } else
                                {
                                    ((TransitionDrawable)drawable).resetTransition();
                                }
                            }
                        }
                        if (flag)
                        {
                            if (mPendingCheckForLongPress == null)
                            {
                                mPendingCheckForLongPress = new CheckForLongPress();
                            }
                            mPendingCheckForLongPress.rememberWindowAttachCount();
                            postDelayed(mPendingCheckForLongPress, mLongPressMillis);
                        } else
                        {
                            mTouchMode = 2;
                        }
                        if (mSelector != null)
                        {
                            drawable = mSelector.getCurrent();
                            if (drawable != null && (drawable instanceof TransitionDrawable))
                            {
                                ((TransitionDrawable)drawable).resetTransition();
                            }
                        }
                    }
                    mTouchMode = 2;
                }
            }
        }

        CheckForTap()
        {
            this$0 = HorizontalListView.this;
            super();
        }
    }

    public static interface ChildWidthListener
    {

        public abstract void onChildWidthMeasured(int i);
    }

    private class FlingRunnable
        implements Runnable
    {

        private int mLastFlingX;
        private int mScreenWidth;
        private final Scroller mScroller;
        final HorizontalListView this$0;

        public void run()
        {
            int i = getChildCount();
            if (mItemCount == 0 || i == 0)
            {
                stop();
                return;
            }
            Scroller scroller = mScroller;
            boolean flag = scroller.computeScrollOffset();
            int j = scroller.getCurrX();
            i = mLastFlingX - j;
            boolean flag1;
            if (i > 0)
            {
                i = Math.min(mScreenWidth, i);
            } else
            {
                i = Math.max(-mScreenWidth, i);
            }
            flag1 = scroll(i, i);
            if (flag)
            {
                if (flag1)
                {
                    mLastFlingX = j;
                    post(this);
                    return;
                }
                if (i > 0)
                {
                    i = getOverflowLeft();
                } else
                {
                    i = -getOverflowRight();
                }
                scroll(i, i);
                stop();
                return;
            } else
            {
                stop();
                return;
            }
        }

        public void start(int i)
        {
            if (i == 0)
            {
                return;
            }
            mTouchMode = 4;
            mScreenWidth = getWidth() - getPaddingLeft() - getPaddingRight() - 1;
            removeCallbacks(this);
            int j;
            if (i < 0)
            {
                j = 0x7fffffff;
            } else
            {
                j = 0;
            }
            mLastFlingX = j;
            mScroller.fling(j, 0, i, 0, 0, 0x7fffffff, 0, 0x7fffffff);
            post(this);
        }

        public void stop()
        {
            if (mTouchMode == 4)
            {
                mTouchMode = -1;
                removeCallbacks(this);
                if (!mScroller.isFinished())
                {
                    mScroller.abortAnimation();
                    invalidate();
                }
            }
        }

        public FlingRunnable()
        {
            this$0 = HorizontalListView.this;
            super();
            mScroller = new Scroller(getContext());
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams
    {

        public boolean recycled;
        public int recycledPosition;

        public LayoutParams(int i, int j)
        {
            super(i, j);
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
        }
    }

    public static interface OnScrollListener
    {

        public abstract void onScroll();
    }

    private class PerformClick
        implements Runnable
    {

        public int clickMotionPosition;
        private int mOriginalAttachCount;
        final HorizontalListView this$0;

        public void rememberWindowAttachCount()
        {
            mOriginalAttachCount = getWindowAttachCount();
        }

        public void run()
        {
            if (!mDataChanged)
            {
                ListAdapter listadapter = mAdapter;
                int i = clickMotionPosition;
                if (listadapter != null && mItemCount > 0 && i != -1 && i < listadapter.getCount() && sameWindow())
                {
                    View view = getChildAt(i - mFirstVisiblePos);
                    if (view != null)
                    {
                        performItemClick(view, i, listadapter.getItemId(i));
                        return;
                    }
                }
            }
        }

        public boolean sameWindow()
        {
            return hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount;
        }

        public PerformClick()
        {
            this$0 = HorizontalListView.this;
            super();
        }
    }

    private class Recycler
    {

        private View mActiveViews[];
        private int mFirstActivePos;
        private final ArrayList mRecycleViews = new ArrayList();
        final HorizontalListView this$0;

        private void pruneRecycleViews()
        {
            int k = mActiveViews.length;
            ArrayList arraylist = mRecycleViews;
            int l = arraylist.size();
            int j = l - 1;
            for (int i = 0; i < l - k; i++)
            {
                removeDetachedView((View)arraylist.remove(j), false);
                j--;
            }

        }

        public void addRecycleView(View view, int i)
        {
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if (layoutparams == null)
            {
                return;
            } else
            {
                layoutparams.recycledPosition = i;
                layoutparams.recycled = true;
                mRecycleViews.add(view);
                return;
            }
        }

        public void clear()
        {
            ArrayList arraylist = mRecycleViews;
            for (int i = arraylist.size() - 1; i >= 0; i--)
            {
                removeDetachedView((View)arraylist.remove(i), false);
            }

        }

        public void fillActiveViews(int i, int j)
        {
            View aview[];
label0:
            {
                View aview1[] = mActiveViews;
                if (aview1 != null)
                {
                    aview = aview1;
                    if (aview1.length >= j)
                    {
                        break label0;
                    }
                }
                mActiveViews = new View[j];
                aview = mActiveViews;
            }
            mFirstActivePos = i;
            for (i = 0; i < j; i++)
            {
                aview[i] = getChildAt(i);
            }

        }

        public View getActiveView(int i)
        {
            if (mActiveViews != null)
            {
                i -= mFirstActivePos;
                View aview[] = mActiveViews;
                if (i >= 0 && i < aview.length)
                {
                    View view = aview[i];
                    aview[i] = null;
                    return view;
                }
            }
            return null;
        }

        public void recycleActiveViews()
        {
            View aview[] = mActiveViews;
            if (aview == null)
            {
                return;
            }
            ArrayList arraylist = mRecycleViews;
            for (int i = aview.length - 1; i >= 0; i--)
            {
                View view = aview[i];
                if (view != null)
                {
                    LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                    aview[i] = null;
                    layoutparams.recycledPosition = mFirstActivePos + i;
                    arraylist.add(view);
                }
            }

            pruneRecycleViews();
        }

        public View removeRecycleView(int i)
        {
            ArrayList arraylist = mRecycleViews;
            if (arraylist.isEmpty())
            {
                return null;
            }
            int k = arraylist.size();
            for (int j = 0; j < k; j++)
            {
                View view = (View)arraylist.get(j);
                if (((LayoutParams)view.getLayoutParams()).recycledPosition == i)
                {
                    arraylist.remove(j);
                    return view;
                }
            }

            return (View)arraylist.remove(k - 1);
        }

        public Recycler()
        {
            this$0 = HorizontalListView.this;
            super();
        }
    }


    public static final int NO_POSITION = -1;
    private static final int TOUCH_MODE_DONE_WAITING = 2;
    private static final int TOUCH_MODE_DOWN = 0;
    private static final int TOUCH_MODE_FLING = 4;
    private static final int TOUCH_MODE_REST = -1;
    private static final int TOUCH_MODE_SCROLL = 3;
    private static final int TOUCH_MODE_TAP = 1;
    private ListAdapter mAdapter;
    private int mChildFillWidth;
    private ChildWidthListener mChildWidthListener;
    private boolean mClipToPadding;
    private boolean mDataChanged;
    private DataSetObserver mDataSetObserver;
    private Drawable mDivider;
    private Paint mDividerPaint;
    private int mDividerWidth;
    private int mDownPosition;
    private final int mEdgePadding;
    private final float mFillWidthHeightRatio;
    private boolean mFingerScrollEnabled;
    private int mFirstVisiblePos;
    private final FlingRunnable mFlingRunnable;
    private int mHeightMeasureSpec;
    private final boolean mIsRecycled[];
    private int mItemCount;
    private int mLastX;
    private int mLongPressMillis;
    private final int mMaximumFlingVelocity;
    private final int mMinimumFlingVelocity;
    private int mMotionPosition;
    private int mMotionX;
    private int mMotionY;
    private android.widget.AdapterView.OnItemLongClickListener mOnItemLongClickListener;
    private OnScrollListener mOnScrollListener;
    private CheckForLongPress mPendingCheckForLongPress;
    private CheckForTap mPendingCheckForTap;
    private PerformClick mPerformClick;
    private final Recycler mRecycler;
    private Drawable mSelector;
    private Rect mTouchFrame;
    private int mTouchMode;
    private Runnable mTouchModeReset;
    private final int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public HorizontalListView(Context context)
    {
        this(context, null);
    }

    public HorizontalListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, co.vine.android.shared.R.attr.horizontalListViewStyle);
    }

    public HorizontalListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mTouchMode = -1;
        mRecycler = new Recycler();
        mIsRecycled = new boolean[1];
        mFirstVisiblePos = 0;
        mMotionX = 0x80000000;
        mMotionY = 0x80000000;
        mFingerScrollEnabled = true;
        mLastX = 0x80000000;
        mFlingRunnable = new FlingRunnable();
        mLongPressMillis = ViewConfiguration.getLongPressTimeout();
        attributeset = context.obtainStyledAttributes(attributeset, co.vine.android.shared.R.styleable.HorizontalListView, i, 0);
        Drawable drawable = attributeset.getDrawable(0);
        if (drawable != null)
        {
            setDivider(drawable);
        }
        i = attributeset.getDimensionPixelSize(1, 0);
        if (i > 0)
        {
            setDividerWidth(i);
        }
        mEdgePadding = attributeset.getDimensionPixelSize(2, 0);
        mFillWidthHeightRatio = attributeset.getFloat(3, 0.0F);
        attributeset.recycle();
        context = ViewConfiguration.get(context);
        mTouchSlop = context.getScaledTouchSlop();
        mMinimumFlingVelocity = context.getScaledMinimumFlingVelocity();
        mMaximumFlingVelocity = context.getScaledMaximumFlingVelocity();
    }

    private View attachChild(int i, int j, int k, boolean flag)
    {
        if (!mDataChanged)
        {
            View view = mRecycler.getActiveView(i);
            if (view != null)
            {
                layoutChild(view, j, k, flag, true);
                return view;
            }
        }
        View view1 = obtainView(i, mIsRecycled);
        layoutChild(view1, j, k, flag, mIsRecycled[0]);
        return view1;
    }

    private void disallowParentIntercept(boolean flag)
    {
        ViewParent viewparent = getParent();
        if (viewparent != null)
        {
            viewparent.requestDisallowInterceptTouchEvent(flag);
        }
    }

    private void fillGap(boolean flag)
    {
        int k = getChildCount();
        if (flag)
        {
            int i;
            if (k > 0)
            {
                i = getChildAt(k - 1).getRight() + mDividerWidth;
            } else
            {
                i = getPaddingLeft();
            }
            fillRight(mFirstVisiblePos + k, i);
            return;
        }
        int j;
        if (k > 0)
        {
            j = getChildAt(0).getLeft() - mDividerWidth;
        } else
        {
            j = 0;
        }
        fillLeft(mFirstVisiblePos - 1, j);
    }

    private void fillLeft(int i, int j)
    {
        int k = getPaddingTop();
        for (int l = getPaddingLeft(); j > l && i >= 0; i--)
        {
            j = attachChild(i, j, k, false).getLeft() - mDividerWidth;
        }

        if (mItemCount > 0 && i == -1 && getOverflowLeft() < 0)
        {
            detachAllViewsFromParent();
            mFirstVisiblePos = 0;
            fillRight(0, getPaddingLeft());
            return;
        } else
        {
            mFirstVisiblePos = i + 1;
            return;
        }
    }

    private void fillRight(int i, int j)
    {
        int l = getPaddingTop();
        int k;
        for (k = getWidth() - getPaddingRight(); j < k && i < mItemCount; i++)
        {
            j = attachChild(i, j, l, true).getRight() + mDividerWidth;
        }

        j = mDividerWidth;
        if (mItemCount > 0 && i == mItemCount && getOverflowRight() < 0 && (mFirstVisiblePos > 0 || getOverflowLeft() > 0))
        {
            detachAllViewsFromParent();
            fillLeft(mItemCount - 1, k - mEdgePadding);
        }
    }

    private int getOverflowLeft()
    {
        return (getPaddingLeft() + mEdgePadding) - getChildAt(0).getLeft();
    }

    private int getOverflowRight()
    {
        int i = getWidth();
        int j = getPaddingRight();
        int k = mEdgePadding;
        return getChildAt(getChildCount() - 1).getRight() - (i - j - k);
    }

    private void layoutChild(View view, int i, int j, boolean flag, boolean flag1)
    {
        LayoutParams layoutparams1 = (LayoutParams)view.getLayoutParams();
        LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = (LayoutParams)generateDefaultLayoutParams();
            view.setLayoutParams(layoutparams);
        }
        byte byte0;
        int k;
        if (flag1)
        {
            int l;
            if (flag)
            {
                byte0 = -1;
            } else
            {
                byte0 = 0;
            }
            attachViewToParent(view, byte0, layoutparams);
        } else
        {
            if (flag)
            {
                byte0 = -1;
            } else
            {
                byte0 = 0;
            }
            addViewInLayout(view, byte0, layoutparams, true);
        }
        if (!flag1 || view.isLayoutRequested())
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        if (byte0 != 0)
        {
            l = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec, getPaddingTop() + getPaddingBottom(), layoutparams.height);
            if (mChildFillWidth > 0)
            {
                k = mChildFillWidth;
            } else
            {
                k = layoutparams.width;
            }
            if (k > 0)
            {
                k = android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000);
            } else
            {
                k = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(k, l);
        } else
        {
            cleanupLayoutState(view);
        }
        k = view.getMeasuredWidth();
        l = view.getMeasuredHeight();
        if (!flag)
        {
            i -= k;
        }
        if (byte0 != 0)
        {
            view.layout(i, j, i + k, j + l);
            return;
        } else
        {
            view.offsetLeftAndRight(i - view.getLeft());
            view.offsetTopAndBottom(j - view.getTop());
            return;
        }
    }

    private void measureChild(View view, int i)
    {
        LayoutParams layoutparams1 = (LayoutParams)view.getLayoutParams();
        LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = (LayoutParams)generateDefaultLayoutParams();
            view.setLayoutParams(layoutparams);
        }
        int j = ViewGroup.getChildMeasureSpec(i, getPaddingTop() + getPaddingBottom(), layoutparams.height);
        i = layoutparams.width;
        if (i > 0)
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        } else
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(i, j);
    }

    private View obtainView(int i, boolean aflag[])
    {
        View view = mRecycler.removeRecycleView(i);
        if (view != null)
        {
            View view1 = mAdapter.getView(i, view, this);
            if (view1 != view)
            {
                mRecycler.addRecycleView(view, i);
                return view1;
            } else
            {
                aflag[0] = true;
                return view1;
            }
        } else
        {
            return mAdapter.getView(i, null, this);
        }
    }

    private boolean performLongPress(View view, int i, long l)
    {
        boolean flag = false;
        if (mOnItemLongClickListener != null)
        {
            flag = mOnItemLongClickListener.onItemLongClick(this, view, i, l);
        }
        if (flag)
        {
            performHapticFeedback(0);
        }
        return flag;
    }

    private void recycleVelocityTracker()
    {
        mVelocityTracker.recycle();
        mVelocityTracker = null;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof LayoutParams;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        int k = mDividerWidth;
        boolean flag;
        if (k > 0 && mDivider != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            Rect rect = new Rect();
            rect.left = getPaddingLeft();
            rect.right = getWidth() - getPaddingRight();
            int l = getChildCount();
            int i1 = mFirstVisiblePos;
            ListAdapter listadapter = mAdapter;
            int j1 = getScrollX();
            Paint paint;
            boolean flag1;
            int i;
            int j;
            int k1;
            if (isOpaque() && !super.isOpaque())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1 && mDividerPaint == null)
            {
                mDividerPaint = new Paint();
            }
            paint = mDividerPaint;
            if (mClipToPadding)
            {
                i = getPaddingLeft();
                j = getPaddingRight();
            } else
            {
                i = 0;
                j = 0;
            }
            k1 = (getWidth() + j1) - j;
            j = 0;
            while (j < l) 
            {
                int l1 = getChildAt(j).getLeft();
                if (l1 > i)
                {
                    if (listadapter.isEnabled(i1 + j) && (j == l - 1 || listadapter.isEnabled(i1 + j + 1)))
                    {
                        rect.left = l1 - k;
                        rect.right = l1;
                        drawDivider(canvas, rect);
                    } else
                    if (flag1)
                    {
                        rect.left = l1 - k;
                        rect.right = l1;
                        canvas.drawRect(rect, paint);
                    }
                }
                j++;
            }
            if (l > 0 && j1 > 0 && flag)
            {
                rect.left = k1;
                rect.right = k1 + k;
                drawDivider(canvas, rect);
            }
        }
        super.dispatchDraw(canvas);
    }

    void drawDivider(Canvas canvas, Rect rect)
    {
        Drawable drawable = mDivider;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams(-2, -1);
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new LayoutParams(layoutparams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public ListAdapter getAdapter()
    {
        return mAdapter;
    }

    public int getDividerWidth()
    {
        return mDividerWidth;
    }

    public int getFirstVisiblePosition()
    {
        return mFirstVisiblePos;
    }

    public int getLastVisiblePosition()
    {
        return (mFirstVisiblePos + getChildCount()) - 1;
    }

    public View getSelectedView()
    {
        return null;
    }

    protected void layoutChildren()
    {
        boolean flag = mDataChanged;
        int j = mFirstVisiblePos;
        Recycler recycler = mRecycler;
        int k = getChildCount();
        View view = getChildAt(0);
        if (flag)
        {
            for (int i = 0; i < k; i++)
            {
                recycler.addRecycleView(getChildAt(i), j + i);
            }

        } else
        {
            recycler.fillActiveViews(j, k);
        }
        detachAllViewsFromParent();
        if (view == null)
        {
            fillRight(j, getPaddingLeft() + mEdgePadding);
        } else
        {
            fillRight(j, view.getLeft());
        }
        recycler.recycleActiveViews();
        mDataChanged = false;
    }

    final int measureWidthOfChildren(int i, int j, int k, int l, int i1)
    {
        Object obj = mAdapter;
        if (obj != null) goto _L2; else goto _L1
_L1:
        j = getPaddingLeft() + getPaddingRight();
_L4:
        return j;
_L2:
        int i2 = getPaddingLeft() + getPaddingRight();
        int l1 = 0;
        int j1 = k;
        if (k == -1)
        {
            j1 = ((ListAdapter) (obj)).getCount() - 1;
        }
        obj = mRecycler;
        boolean aflag[] = mIsRecycled;
        int k1 = j;
        k = i2;
        for (j = l1; k1 <= j1; j = l1)
        {
            View view = obtainView(k1, aflag);
            measureChild(view, i);
            ((Recycler) (obj)).addRecycleView(view, -1);
            k += view.getMeasuredWidth();
            if (k >= l)
            {
                if (i1 < 0 || k1 <= i1 || j <= 0 || k == l)
                {
                    return l;
                }
                continue; /* Loop/switch isn't completed */
            }
            l1 = j;
            if (i1 >= 0)
            {
                l1 = j;
                if (k1 >= i1)
                {
                    l1 = k;
                }
            }
            k1++;
        }

        return k;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mRecycler.clear();
        if (mPendingCheckForTap != null)
        {
            removeCallbacks(mPendingCheckForTap);
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        onLayoutCustom(flag);
    }

    protected void onLayoutCustom(boolean flag)
    {
        if (flag)
        {
            int j = getChildCount();
            for (int i = 0; i < j; i++)
            {
                getChildAt(i).forceLayout();
            }

        }
        layoutChildren();
    }

    protected void onMeasure(int i, int j)
    {
        int i1;
        int k1;
        k1 = android.view.View.MeasureSpec.getMode(i);
        int j1 = android.view.View.MeasureSpec.getMode(j);
        i1 = android.view.View.MeasureSpec.getSize(i);
        int l = android.view.View.MeasureSpec.getSize(j);
        int k;
        if (mAdapter == null)
        {
            i = 0;
        } else
        {
            i = mAdapter.getCount();
        }
        mItemCount = i;
        if (mItemCount > 0 && (k1 == 0 || j1 == 0))
        {
            View view = obtainView(0, mIsRecycled);
            measureChild(view, j);
            i = view.getMeasuredWidth();
            k = view.getMeasuredHeight();
            mRecycler.addRecycleView(view, -1);
        } else
        {
            i = getSuggestedMinimumWidth();
            k = getSuggestedMinimumHeight();
        }
        if (k1 != 0) goto _L2; else goto _L1
_L1:
        i = getPaddingLeft() + getPaddingRight() + i;
_L4:
        if (j1 == 0)
        {
            l = getPaddingTop() + getPaddingBottom() + k;
        }
        mChildFillWidth = 0;
        if (mFillWidthHeightRatio > 0.0F && mItemCount > 0)
        {
            k = mDividerWidth;
            i1 = mItemCount;
            k = (i - mEdgePadding * 2 - k * (i1 - 1)) / mItemCount;
            if (k >= l && (float)k <= mFillWidthHeightRatio * (float)l)
            {
                mChildFillWidth = k;
            }
        }
        if (mChildWidthListener != null)
        {
            mChildWidthListener.onChildWidthMeasured(mChildFillWidth);
        }
        setMeasuredDimension(i, l);
        mHeightMeasureSpec = j;
        return;
_L2:
        i = i1;
        if (k1 == 0x80000000)
        {
            i = measureWidthOfChildren(j, 0, -1, i1, -1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onTouchEvent(final MotionEvent child)
    {
        int i;
        int i1;
        int j1;
        if (mItemCount == 0)
        {
            return child.getX() >= 0.0F && child.getX() <= (float)getWidth() && child.getY() >= 0.0F && child.getY() <= (float)getHeight();
        }
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(child);
        i = child.getAction();
        i1 = (int)child.getX();
        j1 = (int)child.getY();
        i & 0xff;
        JVM INSTR tableswitch 0 3: default 132
    //                   0 134
    //                   1 260
    //                   2 707
    //                   3 955;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L2:
        int j = pointToPosition(i1, j1);
        mDownPosition = j;
        if (!mDataChanged && mTouchMode != 4 && j >= 0 && mAdapter.isEnabled(j))
        {
            mTouchMode = 0;
            if (mPendingCheckForTap == null)
            {
                mPendingCheckForTap = new CheckForTap();
            }
            postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
        }
        disallowParentIntercept(true);
        mFlingRunnable.stop();
        mMotionX = i1;
        mMotionY = j1;
        mLastX = 0x80000000;
        mMotionPosition = j;
        continue; /* Loop/switch isn't completed */
_L3:
        mTouchMode;
        JVM INSTR tableswitch 0 2: default 292
    //                   0 386
    //                   1 386
    //                   2 386;
           goto _L6 _L7 _L7 _L7
_L6:
        child = mVelocityTracker;
        child.computeCurrentVelocity(1000, mMaximumFlingVelocity);
        float f = child.getXVelocity();
        if (Math.abs(f) > (float)mMinimumFlingVelocity && mFingerScrollEnabled)
        {
            mFlingRunnable.start((int)(-f));
        }
_L8:
        child = getHandler();
        if (child != null)
        {
            child.removeCallbacks(mPendingCheckForLongPress);
        }
        recycleVelocityTracker();
        mMotionY = 0x80000000;
        mMotionX = 0x80000000;
        mLastX = 0x80000000;
        continue; /* Loop/switch isn't completed */
_L7:
        j1 = mMotionPosition;
        child = getChildAt(j1 - mFirstVisiblePos);
        boolean flag;
        if (i1 > getPaddingLeft() && i1 < getWidth() - getPaddingRight())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (child != null && !child.hasFocusable() && flag)
        {
            if (mTouchMode != 0)
            {
                child.setPressed(false);
            }
            if (mPerformClick == null)
            {
                mPerformClick = new PerformClick();
            }
            final PerformClick performClick = mPerformClick;
            performClick.clickMotionPosition = j1;
            performClick.rememberWindowAttachCount();
            if (mTouchMode == 0 || mTouchMode == 1)
            {
                Handler handler = getHandler();
                if (handler != null)
                {
                    handler.removeCallbacks(mPendingCheckForTap);
                }
                if (!mDataChanged && mAdapter.isEnabled(j1))
                {
                    mTouchMode = 1;
                    layoutChildren();
                    child.setPressed(true);
                    setPressed(true);
                    if (mSelector != null)
                    {
                        Drawable drawable = mSelector.getCurrent();
                        if (drawable != null && (drawable instanceof TransitionDrawable))
                        {
                            ((TransitionDrawable)drawable).resetTransition();
                        }
                    }
                    if (mTouchModeReset != null)
                    {
                        removeCallbacks(mTouchModeReset);
                    }
                    mTouchModeReset = new Runnable() {

                        final HorizontalListView this$0;
                        final View val$child;
                        final PerformClick val$performClick;

                        public void run()
                        {
                            mTouchMode = -1;
                            child.setPressed(false);
                            setPressed(false);
                            if (!mDataChanged && mMotionPosition == mDownPosition)
                            {
                                performClick.run();
                            }
                        }

            
            {
                this$0 = HorizontalListView.this;
                child = view;
                performClick = performclick;
                super();
            }
                    };
                    postDelayed(mTouchModeReset, ViewConfiguration.getPressedStateDuration());
                } else
                {
                    mTouchMode = -1;
                }
                return true;
            }
            if (!mDataChanged && mDownPosition == mMotionPosition && mAdapter.isEnabled(j1))
            {
                performClick.run();
            }
        }
        mTouchMode = -1;
        if (true) goto _L8; else goto _L4
_L4:
        if (mMotionX != 0x80000000)
        {
            if (getChildCount() == 0)
            {
                mTouchMode = -1;
                return super.onTouchEvent(child);
            }
            child = getHandler();
            if (child != null)
            {
                child.removeCallbacks(mPendingCheckForLongPress);
            }
            int k1 = i1 - mMotionX;
            if (mTouchMode != 3)
            {
                if (mFirstVisiblePos == 0 && getOverflowLeft() == 0 && k1 > 0 || getOverflowRight() == 0 && k1 < 0)
                {
                    disallowParentIntercept(false);
                    continue; /* Loop/switch isn't completed */
                }
                if (mMotionY != 0x80000000)
                {
                    int k = mMotionY;
                    if (mTouchSlop <= Math.abs(j1 - k))
                    {
                        disallowParentIntercept(false);
                        continue; /* Loop/switch isn't completed */
                    }
                }
                if (mTouchSlop > Math.abs(k1))
                {
                    continue; /* Loop/switch isn't completed */
                }
                mTouchMode = 3;
            }
            if (i1 == mLastX)
            {
                continue; /* Loop/switch isn't completed */
            }
            int l;
            if (k1 > 0)
            {
                l = k1 - mTouchSlop;
            } else
            {
                l = k1 + mTouchSlop;
            }
            if (mLastX != 0x80000000)
            {
                l = i1 - mLastX;
            }
            if (mFingerScrollEnabled)
            {
                scroll(k1, l);
            }
            mLastX = i1;
        }
        mMotionX = i1;
        mMotionY = j1;
        continue; /* Loop/switch isn't completed */
_L5:
        recycleVelocityTracker();
        mMotionX = 0x80000000;
        mMotionY = 0x80000000;
        mLastX = 0x80000000;
        mTouchMode = -1;
        if (true) goto _L1; else goto _L9
_L9:
    }

    public int pointToPosition(int i, int j)
    {
        Rect rect1 = mTouchFrame;
        Rect rect = rect1;
        if (rect1 == null)
        {
            mTouchFrame = new Rect();
            rect = mTouchFrame;
        }
        for (int k = getChildCount() - 1; k >= 0; k--)
        {
            getChildAt(k).getHitRect(rect);
            if (rect.contains(i, j))
            {
                return mFirstVisiblePos + k;
            }
        }

        return -1;
    }

    public boolean scroll(int i, int j)
    {
        View view;
        int k;
        int l;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        boolean flag1;
        boolean flag2;
        k2 = getChildCount();
        boolean flag;
        int l2;
        if (j < 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        l2 = getPaddingLeft();
        j2 = getWidth() - getPaddingRight();
        k = getChildAt(k2 - 1).getRight();
        l = getChildAt(0).getLeft();
        if (flag2)
        {
            j1 = getOverflowRight();
        } else
        {
            j1 = getOverflowLeft();
        }
        i2 = mFirstVisiblePos;
        if (flag2)
        {
            if (i2 + k2 < mItemCount || k + i >= j2 - mEdgePadding)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        } else
        if (i2 > 0 || l + i <= mEdgePadding + l2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1) goto _L2; else goto _L1
_L1:
        k1 = 0;
        flag = false;
        l = 0;
        k = 0;
        if (!flag2) goto _L4; else goto _L3
_L3:
        l = 0;
_L13:
        k1 = k;
        l1 = ((flag) ? 1 : 0);
        if (l >= k2) goto _L6; else goto _L5
_L5:
        view = getChildAt(l);
        if (view.getRight() + i < l2) goto _L8; else goto _L7
_L7:
        l1 = ((flag) ? 1 : 0);
        k1 = k;
          goto _L6
_L8:
        k++;
        mRecycler.addRecycleView(view, i2 + l);
        l++;
        continue; /* Loop/switch isn't completed */
_L4:
        k = k2 - 1;
        i1 = k1;
_L11:
        k1 = l;
        l1 = i1;
        if (k < 0) goto _L6; else goto _L9
_L9:
        view = getChildAt(k);
        k1 = l;
        l1 = i1;
        if (view.getLeft() + i <= j2) goto _L6; else goto _L10
_L10:
        i1 = k;
        l++;
        mRecycler.addRecycleView(view, i2 + k);
        k--;
          goto _L11
_L6:
        if (k1 > 0)
        {
            detachViewsFromParent(l1, k1);
            if (flag2)
            {
                mFirstVisiblePos = mFirstVisiblePos + k1;
            }
        }
        l = getChildCount();
        int i1;
        for (k = 0; k < l; k++)
        {
            getChildAt(k).offsetLeftAndRight(i);
        }

        invalidate();
        if (j1 < Math.abs(j))
        {
            fillGap(flag2);
        }
        if (mOnScrollListener != null)
        {
            mOnScrollListener.onScroll();
        }
_L2:
        return flag1;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
label0:
        {
            if (listadapter != mAdapter)
            {
                if (mDataSetObserver == null)
                {
                    mDataSetObserver = new AdapterDataSetObserver();
                }
                if (mAdapter != null)
                {
                    mAdapter.unregisterDataSetObserver(mDataSetObserver);
                }
                mAdapter = listadapter;
                if (listadapter == null)
                {
                    break label0;
                }
                listadapter.registerDataSetObserver(mDataSetObserver);
                mItemCount = listadapter.getCount();
            }
            return;
        }
        mItemCount = 0;
    }

    public void setChildWidthListener(ChildWidthListener childwidthlistener)
    {
        mChildWidthListener = childwidthlistener;
    }

    public void setClipToPadding(boolean flag)
    {
        super.setClipToPadding(flag);
        mClipToPadding = flag;
    }

    public void setDivider(Drawable drawable)
    {
        if (drawable != null)
        {
            mDividerWidth = drawable.getIntrinsicWidth();
        } else
        {
            mDividerWidth = 0;
        }
        mDivider = drawable;
        requestLayout();
        invalidate();
    }

    public void setDividerWidth(int i)
    {
        mDividerWidth = i;
        requestLayout();
        invalidate();
    }

    public void setFingerScrollEnabled(boolean flag)
    {
        mFingerScrollEnabled = flag;
    }

    public void setLongPressDuration(int i)
    {
        mLongPressMillis = i;
    }

    public void setOnItemLongClickListener(android.widget.AdapterView.OnItemLongClickListener onitemlongclicklistener)
    {
        mOnItemLongClickListener = onitemlongclicklistener;
    }

    public void setOnScrollListener(DragSortWidget dragsortwidget)
    {
        mOnScrollListener = dragsortwidget;
    }

    public void setPressed(boolean flag)
    {
        if (getParent() == null)
        {
            super.setPressed(flag);
        }
    }

    public void setSelection(int i)
    {
        mFirstVisiblePos = i;
        detachAllViewsFromParent();
        layoutChildren();
        invalidate();
    }



/*
    static int access$002(HorizontalListView horizontallistview, int i)
    {
        horizontallistview.mTouchMode = i;
        return i;
    }

*/




/*
    static boolean access$102(HorizontalListView horizontallistview, boolean flag)
    {
        horizontallistview.mDataChanged = flag;
        return flag;
    }

*/



/*
    static CheckForLongPress access$1102(HorizontalListView horizontallistview, CheckForLongPress checkforlongpress)
    {
        horizontallistview.mPendingCheckForLongPress = checkforlongpress;
        return checkforlongpress;
    }

*/












/*
    static int access$402(HorizontalListView horizontallistview, int i)
    {
        horizontallistview.mItemCount = i;
        return i;
    }

*/





}
