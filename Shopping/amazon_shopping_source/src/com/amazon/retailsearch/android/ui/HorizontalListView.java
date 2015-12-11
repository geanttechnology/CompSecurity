// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            HeaderFooterListAdapter

public class HorizontalListView extends AdapterView
    implements android.view.View.OnFocusChangeListener
{
    private class AdapterDataSetObserver extends DataSetObserver
    {

        final HorizontalListView this$0;

        public void onChanged()
        {
            synchronized (HorizontalListView.this)
            {
                mDataChanged = true;
            }
            invalidate();
            requestLayout();
            mCanReceiveKeyEvent = false;
            return;
            exception;
            horizontallistview;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onInvalidated()
        {
            reset();
            invalidate();
            requestLayout();
            mCanReceiveKeyEvent = false;
        }

        private AdapterDataSetObserver()
        {
            this$0 = HorizontalListView.this;
            super();
        }

    }

    public class FixedViewInfo
    {

        public Object data;
        public boolean isSelectable;
        final HorizontalListView this$0;
        public View view;

        public FixedViewInfo()
        {
            this$0 = HorizontalListView.this;
            super();
        }
    }

    public static interface OnScrollListener
    {

        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        public abstract void onScroll(HorizontalListView horizontallistview, int i, int j, int k);

        public abstract void onScrollStateChanged(HorizontalListView horizontallistview, int i);
    }


    private static final int ID_VIEW_TYPE;
    private static final int PREVIEW_OFFSET = 20;
    private static final String VIEW_TYPE_FOOTER = "F";
    private static final String VIEW_TYPE_PRODUCT = "P";
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/HorizontalListView);
    private int itemWidth;
    protected ListAdapter mAdapter;
    private boolean mCanReceiveKeyEvent;
    private int mCurrentFocusPosition;
    protected int mCurrentX;
    private boolean mDataChanged;
    private DataSetObserver mDataObserver;
    private int mDisplayOffset;
    private Drawable mDivider;
    private int mDividerWidth;
    private ArrayList mFooterViewInfos;
    private GestureDetector mGesture;
    private Drawable mHighlightBackground;
    protected int mInitialPosition;
    private int mLastLeft;
    private int mLastRight;
    private int mLeftViewPosition;
    private int mMaxX;
    protected int mNextX;
    private Drawable mNormalBackground;
    private android.view.GestureDetector.OnGestureListener mOnGesture = new android.view.GestureDetector.SimpleOnGestureListener() {

        final HorizontalListView this$0;

        public boolean onDoubleTap(MotionEvent motionevent)
        {
            setHighlightItemToNormalBackground();
            return false;
        }

        public boolean onDown(MotionEvent motionevent)
        {
            return HorizontalListView.this.onDown(motionevent);
        }

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            setHighlightItemToNormalBackground();
            return HorizontalListView.this.onFling(motionevent, motionevent1, f, f1);
        }

        public void onLongPress(MotionEvent motionevent)
        {
            int j = getChildCount();
            int i = 0;
            do
            {
label0:
                {
                    if (i < j)
                    {
                        View view = getChildAt(i);
                        if (!isEventWithinView(motionevent, view))
                        {
                            break label0;
                        }
                        if (mOnItemLongClicked != null)
                        {
                            mOnItemLongClicked.onItemLongClick(HorizontalListView.this, view, mLeftViewPosition + 1 + i, mAdapter.getItemId(mLeftViewPosition + 1 + i));
                        }
                    }
                    return;
                }
                i++;
            } while (true);
        }

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            setHighlightItemToNormalBackground();
            synchronized (HorizontalListView.this)
            {
                motionevent1 = HorizontalListView.this;
                motionevent1.mNextX = ((HorizontalListView) (motionevent1)).mNextX + (int)f;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            requestLayout();
            invokeOnItemScrollListener();
            return true;
            motionevent1;
            motionevent;
            JVM INSTR monitorexit ;
            throw motionevent1;
        }

        public void onShowPress(MotionEvent motionevent)
        {
            setFocusedItemToHightLightBackground(motionevent);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            boolean flag1 = false;
            int i = 0;
            do
            {
label0:
                {
                    View view;
label1:
                    {
                        boolean flag = flag1;
                        if (i < getChildCount())
                        {
                            view = getChildAt(i);
                            if (!isEventWithinView(motionevent, view))
                            {
                                break label0;
                            }
                            if (mOnItemClicked == null)
                            {
                                break label1;
                            }
                            mOnItemClicked.onItemClick(HorizontalListView.this, view, mLeftViewPosition + 1 + i, mAdapter.getItemId(mLeftViewPosition + 1 + i));
                            flag = true;
                        }
                        return flag;
                    }
                    if (mOnItemSelected != null)
                    {
                        mOnItemSelected.onItemSelected(HorizontalListView.this, view, mLeftViewPosition + 1 + i, mAdapter.getItemId(mLeftViewPosition + 1 + i));
                        return true;
                    } else
                    {
                        return view.performClick();
                    }
                }
                i++;
            } while (true);
        }

        public boolean onSingleTapUp(MotionEvent motionevent)
        {
            setFocusedItemToHightLightBackground(motionevent);
            postDelayed(new Runnable() {

                final _cls2 this$1;

                public void run()
                {
                    setHighlightItemToNormalBackground();
                }

            
            {
                this$1 = _cls2.this;
                super();
            }
            }, 300L);
            return false;
        }

            
            {
                this$0 = HorizontalListView.this;
                super();
            }
    };
    private android.widget.AdapterView.OnItemClickListener mOnItemClicked;
    private android.widget.AdapterView.OnItemLongClickListener mOnItemLongClicked;
    private android.widget.AdapterView.OnItemSelectedListener mOnItemSelected;
    private Queue mRemovedViewQueue;
    private int mRightViewPosition;
    protected Scroller mScroller;
    private OnScrollListener onScrollListener;
    private int prevState;

    public HorizontalListView(Context context)
    {
        this(context, null);
    }

    public HorizontalListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mLeftViewPosition = -1;
        mRightViewPosition = 0;
        mLastLeft = -1;
        mLastRight = -1;
        mMaxX = 0x7fffffff;
        mDisplayOffset = 0;
        mRemovedViewQueue = new LinkedList();
        mDataChanged = false;
        mCurrentFocusPosition = 0;
        prevState = 0;
        itemWidth = 0;
        mFooterViewInfos = new ArrayList();
        mCanReceiveKeyEvent = true;
        mNormalBackground = getResources().getDrawable(com.amazon.retailsearch.R.color.transparent);
        mHighlightBackground = null;
        initView();
    }

    public HorizontalListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mLeftViewPosition = -1;
        mRightViewPosition = 0;
        mLastLeft = -1;
        mLastRight = -1;
        mMaxX = 0x7fffffff;
        mDisplayOffset = 0;
        mRemovedViewQueue = new LinkedList();
        mDataChanged = false;
        mCurrentFocusPosition = 0;
        prevState = 0;
        itemWidth = 0;
        mFooterViewInfos = new ArrayList();
        mCanReceiveKeyEvent = true;
    }

    private void addAndMeasureChild(View view, int i)
    {
        android.view.ViewGroup.LayoutParams layoutparams1 = view.getLayoutParams();
        android.view.ViewGroup.LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = new android.view.ViewGroup.LayoutParams(-1, -1);
        }
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(getHeight(), 0x80000000));
        addViewInLayout(view, i, layoutparams, true);
    }

    private int checkRight(int i, int j)
    {
        for (; i < getWidth() && j < mAdapter.getCount(); j++)
        {
            i += getViewWidth(j);
        }

        if (i < getWidth())
        {
            return getWidth() - i;
        } else
        {
            return 0;
        }
    }

    private int checkedDelta(int i, int j)
    {
        if (mLastLeft == -1)
        {
            mLastLeft = i;
            mLastRight = j;
        }
        if (mLastRight - mLastLeft == j - i)
        {
            return mCurrentX - mNextX;
        } else
        {
            int k = checkRight(getRightEdge(), mRightViewPosition);
            mLastLeft = i;
            mLastRight = j;
            return k;
        }
    }

    private void fillList(int i)
    {
        int j = mDisplayOffset;
        View view = getChildAt(getChildCount() - 1);
        if (view != null)
        {
            j = view.getRight();
        }
        fillListRight(j, i);
        j = 0;
        view = getChildAt(0);
        if (view != null)
        {
            j = view.getLeft();
        }
        fillListLeft(j, i);
    }

    private void fillListLeft(int i, int j)
    {
        while (i + j > 0 && mLeftViewPosition >= 0) 
        {
            View view = getViewFromAdapter(mLeftViewPosition);
            addAndMeasureChild(view, 0);
            i -= view.getMeasuredWidth();
            mLeftViewPosition = mLeftViewPosition - 1;
            mDisplayOffset = mDisplayOffset - view.getMeasuredWidth();
        }
        if (i + j > 0 && mLeftViewPosition == -1)
        {
            mDisplayOffset = -j;
        }
    }

    private void fillListRight(int i, int j)
    {
        while (i + j < getWidth() && mRightViewPosition < mAdapter.getCount()) 
        {
            if (i + j <= -getItemWidth())
            {
                mLeftViewPosition = mLeftViewPosition + 1;
                mDisplayOffset = mDisplayOffset + getItemWidth();
                i += getItemWidth();
            } else
            {
                View view = getViewFromAdapter(mRightViewPosition);
                addAndMeasureChild(view, -1);
                i += view.getMeasuredWidth();
            }
            mRightViewPosition = mRightViewPosition + 1;
        }
        if (mRightViewPosition == mAdapter.getCount() && i + j < getWidth())
        {
            mMaxX = (mCurrentX + i) - getWidth();
        }
        if (mMaxX < 0)
        {
            mMaxX = 0;
        }
    }

    private int getRightEdge()
    {
        int i = mDisplayOffset;
        View view = getChildAt(getChildCount() - 1);
        if (view != null)
        {
            i = view.getRight();
        }
        return i;
    }

    private int getViewWidth(int i)
    {
        View view = getViewFromAdapter(i);
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(getHeight(), 0x80000000));
        i = view.getMeasuredWidth();
        recycleView(view);
        return i;
    }

    private void initView()
    {
        this;
        JVM INSTR monitorenter ;
        mLeftViewPosition = -1;
        mRightViewPosition = 0;
        mDisplayOffset = 0;
        mLastLeft = -1;
        mLastRight = -1;
        mCurrentX = 0;
        mNextX = 0;
        mCurrentFocusPosition = 0;
        mMaxX = 0x7fffffff;
        mRemovedViewQueue.clear();
        mScroller = new Scroller(getContext());
        mGesture = new GestureDetector(getContext(), mOnGesture);
        setOnFocusChangeListener(this);
        setHorizontalScrollBarEnabled(true);
        setVerticalScrollBarEnabled(false);
        TypedArray typedarray = getContext().obtainStyledAttributes(com.amazon.retailsearch.R.styleable.ScrollableView);
        initializeScrollbars(typedarray);
        typedarray.recycle();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean isEventWithinView(MotionEvent motionevent, View view)
    {
        Rect rect = new Rect();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        int i = ai[0];
        int j = view.getWidth();
        int k = ai[1];
        rect.set(i, k, i + j, k + view.getHeight());
        return rect.contains((int)motionevent.getRawX(), (int)motionevent.getRawY());
    }

    private void positionItems(int i)
    {
        if (getChildCount() > 0)
        {
            int j;
            if (mInitialPosition != 0)
            {
                mDisplayOffset = 0;
            } else
            {
                mDisplayOffset = mDisplayOffset + i;
            }
            j = mDisplayOffset;
            for (i = 0; i < getChildCount(); i++)
            {
                View view = getChildAt(i);
                int k = view.getMeasuredWidth();
                view.layout(j, 0, j + k, view.getMeasuredHeight());
                j += k;
            }

        }
    }

    private void removeAllVisibleItems()
    {
        for (View view = getChildAt(0); view != null; view = getChildAt(0))
        {
            recycleView(view);
            removeViewInLayout(view);
        }

        mRightViewPosition = mLeftViewPosition + 1;
        mMaxX = 0x7fffffff;
    }

    private void removeNonVisibleItems(int i)
    {
        for (View view = getChildAt(0); view != null && view.getRight() + i <= 0; view = getChildAt(0))
        {
            mDisplayOffset = mDisplayOffset + view.getMeasuredWidth();
            recycleView(view);
            removeViewInLayout(view);
            mLeftViewPosition = mLeftViewPosition + 1;
        }

        for (View view1 = getChildAt(getChildCount() - 1); view1 != null && view1.getLeft() + i >= getWidth();)
        {
            recycleView(view1);
            removeViewInLayout(view1);
            mRightViewPosition = mRightViewPosition - 1;
            view1 = getChildAt(getChildCount() - 1);
            mMaxX = 0x7fffffff;
        }

    }

    private void reset()
    {
        this;
        JVM INSTR monitorenter ;
        initView();
        removeAllViewsInLayout();
        requestLayout();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void setFocusedItemToHightLightBackground(MotionEvent motionevent)
    {
        if (mHighlightBackground == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        if (i >= getChildCount()) goto _L2; else goto _L3
_L3:
        View view = getChildAt(i);
        if (!isEventWithinView(motionevent, view)) goto _L5; else goto _L4
_L4:
        view.setBackgroundDrawable(mHighlightBackground);
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void setHighlightItemToNormalBackground()
    {
        if (mHighlightBackground == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        if (i >= getChildCount()) goto _L2; else goto _L3
_L3:
        View view = getChildAt(i);
        if (!mHighlightBackground.equals(view.getBackground())) goto _L5; else goto _L4
_L4:
        view.setBackgroundDrawable(mNormalBackground);
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void addFooterView(View view, Object obj, boolean flag)
    {
        FixedViewInfo fixedviewinfo = new FixedViewInfo();
        fixedviewinfo.view = view;
        fixedviewinfo.data = obj;
        fixedviewinfo.isSelectable = flag;
        mFooterViewInfos.add(fixedviewinfo);
    }

    protected int computeHorizontalScrollExtent()
    {
        return getItemWidth();
    }

    protected int computeHorizontalScrollOffset()
    {
        return mCurrentX;
    }

    protected int computeHorizontalScrollRange()
    {
        return getItemWidth() * mAdapter.getCount();
    }

    protected void dispatchDraw(Canvas canvas)
    {
        int j = getChildCount();
        if (mDivider == null || j <= 1) goto _L2; else goto _L1
_L1:
        Rect rect;
        getChildAt(0);
        rect = new Rect();
        rect.top = getTop();
        rect.bottom = getBottom();
        int i = 1;
_L7:
        if (i >= j) goto _L2; else goto _L3
_L3:
        View view = getChildAt(i);
        if (!"F".equals(view.getTag(ID_VIEW_TYPE))) goto _L5; else goto _L4
_L5:
        int k = view.getLeft();
        rect.left = k - mDividerWidth;
        rect.right = k;
        mDivider.setBounds(rect);
        mDivider.draw(canvas);
          goto _L4
        Exception exception;
        exception;
        log.error("Could not draw the divider", exception);
_L2:
        super.dispatchDraw(canvas);
        return;
_L4:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        int i = 0;
        if (!mCanReceiveKeyEvent)
        {
            return true;
        }
        if (keyevent.getAction() == 0 && keyevent.getKeyCode() == 22)
        {
            if (mCurrentFocusPosition + 1 < getAdapter().getCount())
            {
                mCurrentFocusPosition = mCurrentFocusPosition + 1;
                if (mCurrentFocusPosition >= mRightViewPosition - 1)
                {
                    int j = getChildAt(getChildCount() - 1).getRight();
                    int l = ((View)getParent()).getWidth();
                    i = getAdapter().getCount();
                    if (j - l == 0)
                    {
                        keyevent = getViewFromAdapter(mCurrentFocusPosition);
                        keyevent.measure(android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(getHeight(), 0x80000000));
                        mNextX = mNextX + keyevent.getMeasuredWidth();
                    }
                    if (mCurrentFocusPosition == i - 1)
                    {
                        i = 0;
                    } else
                    {
                        i = 20;
                    }
                    mNextX = mNextX + ((j - l) + i);
                    requestLayout();
                    return true;
                }
            } else
            {
                return true;
            }
        } else
        if (keyevent.getAction() == 0 && keyevent.getKeyCode() == 21)
        {
            if (mCurrentFocusPosition - 1 >= 0)
            {
                mCurrentFocusPosition = mCurrentFocusPosition - 1;
                if (mCurrentFocusPosition == mLeftViewPosition + 1)
                {
                    int k = getChildAt(0).getLeft();
                    if (mCurrentFocusPosition != 0)
                    {
                        i = 20;
                    }
                    mNextX = mNextX + (k - i);
                    requestLayout();
                    return true;
                }
            } else
            {
                return true;
            }
        }
        return super.dispatchKeyEvent(keyevent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        boolean flag = super.dispatchTouchEvent(motionevent);
        if (motionevent.getAction() == 1)
        {
            setHighlightItemToNormalBackground();
        }
        return flag | mGesture.onTouchEvent(motionevent);
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public ListAdapter getAdapter()
    {
        return mAdapter;
    }

    public int getFirstVisiblePosition()
    {
        return mLeftViewPosition + 1;
    }

    protected int getItemWidth()
    {
        if (itemWidth == 0)
        {
            itemWidth = getViewWidth(0);
        }
        return itemWidth;
    }

    public int getLastVisiblePosition()
    {
        return mRightViewPosition + 1;
    }

    public View getSelectedView()
    {
        return null;
    }

    public View getViewFromAdapter(int i)
    {
        if (mAdapter.getCount() - i <= mFooterViewInfos.size())
        {
            View view = mAdapter.getView(i, null, this);
            view.setTag(ID_VIEW_TYPE, "F");
            return view;
        } else
        {
            View view1 = mAdapter.getView(i, (View)mRemovedViewQueue.poll(), this);
            view1.setTag(ID_VIEW_TYPE, "P");
            return view1;
        }
    }

    void invokeOnItemScrollListener()
    {
        if (onScrollListener != null && mAdapter != null)
        {
            onScrollListener.onScroll(this, getFirstVisiblePosition(), getChildCount(), mAdapter.getCount());
        }
    }

    protected boolean onDown(MotionEvent motionevent)
    {
        mScroller.forceFinished(true);
        return true;
    }

    protected boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        this;
        JVM INSTR monitorenter ;
        mScroller.fling(mNextX, 0, (int)(-f), 0, 0x80000000, 0x7fffffff, 0, 0);
        this;
        JVM INSTR monitorexit ;
        requestLayout();
        return true;
        motionevent;
        this;
        JVM INSTR monitorexit ;
        throw motionevent;
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (mCurrentFocusPosition < mLeftViewPosition + 1 || mCurrentFocusPosition > mRightViewPosition - 1) goto _L4; else goto _L3
_L3:
        int i;
        int l;
        int i1;
        view = getChildAt(mCurrentFocusPosition - (mLeftViewPosition + 1));
        i = view.getLeft();
        l = view.getRight();
        i1 = ((View)view.getParent()).getWidth();
        if (i <= 0 || l >= i1) goto _L6; else goto _L5
_L5:
        view.requestFocus();
_L2:
        return;
_L6:
        if (i <= 0)
        {
            if (mCurrentFocusPosition > 0)
            {
                i -= 20;
            }
            mNextX = mNextX + i;
            requestLayout();
            return;
        }
        if (l >= i1)
        {
            int j;
            if (mCurrentFocusPosition != getAdapter().getCount() - 1)
            {
                j = (l - i1) + 20;
            } else
            {
                j = l - i1;
            }
            mNextX = mNextX + j;
            requestLayout();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        int k = 0;
        while (k < getChildCount()) 
        {
            View view1 = getChildAt(k);
            if (view1.getLeft() >= 0)
            {
                if (view != view1)
                {
                    view1.requestFocus();
                }
                mCurrentFocusPosition = mLeftViewPosition + 1 + k;
                return;
            }
            k++;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        super.onLayout(flag, i, j, k, l);
        obj = mAdapter;
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Exception exception;
        if (getFocusedChild() != null)
        {
            j = ((flag1) ? 1 : 0);
        } else
        {
            j = 0;
        }
        if (mDataChanged)
        {
            removeAllVisibleItems();
            mDataChanged = false;
        }
        if (mInitialPosition != 0)
        {
            mNextX = mInitialPosition * getItemWidth();
        }
        if (mScroller.computeScrollOffset())
        {
            mNextX = mScroller.getCurrX();
        }
        if (mNextX <= 0)
        {
            mNextX = 0;
            mScroller.forceFinished(true);
        }
        if (mNextX >= mMaxX)
        {
            mNextX = mMaxX;
            mScroller.forceFinished(true);
        }
        i = checkedDelta(i, k);
        removeNonVisibleItems(i);
        fillList(i);
        positionItems(i);
        mCurrentX = mNextX;
        mInitialPosition = 0;
        obj = getChildAt(mCurrentFocusPosition - (mLeftViewPosition + 1));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        if (((View) (obj)).isInTouchMode() || j == 0)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        ((View) (obj)).requestFocus();
        mCanReceiveKeyEvent = true;
        if (mScroller.isFinished())
        {
            break; /* Loop/switch isn't completed */
        }
        post(new Runnable() {

            final HorizontalListView this$0;

            public void run()
            {
                requestLayout();
            }

            
            {
                this$0 = HorizontalListView.this;
                super();
            }
        });
        reportScrollStateChange(1);
_L4:
        awakenScrollBars();
        invalidate();
        if (true) goto _L1; else goto _L3
        exception;
        throw exception;
_L3:
        reportScrollStateChange(0);
          goto _L4
    }

    public boolean recycleView(View view)
    {
        if (view == null)
        {
            return false;
        }
        if ("F".equals(view.getTag(ID_VIEW_TYPE)))
        {
            return true;
        } else
        {
            view.forceLayout();
            return mRemovedViewQueue.offer(view);
        }
    }

    void reportScrollStateChange(int i)
    {
        if (i != prevState && onScrollListener != null)
        {
            prevState = i;
            onScrollListener.onScrollStateChanged(this, i);
        }
    }

    public void scrollTo(int i)
    {
        this;
        JVM INSTR monitorenter ;
        mScroller.startScroll(mNextX, 0, i - mNextX, 0);
        requestLayout();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (mAdapter != null && mDataObserver != null)
        {
            mAdapter.unregisterDataSetObserver(mDataObserver);
            mDataObserver = null;
        }
        if (listadapter == null)
        {
            return;
        }
        if (mFooterViewInfos.size() > 0)
        {
            mAdapter = new HeaderFooterListAdapter(null, mFooterViewInfos, listadapter);
        } else
        {
            mAdapter = listadapter;
        }
        mDataObserver = new AdapterDataSetObserver();
        mAdapter.registerDataSetObserver(mDataObserver);
        reset();
    }

    public void setDivider(Drawable drawable)
    {
        mDivider = drawable;
    }

    public void setDividerWidth(int i)
    {
        mDividerWidth = i;
    }

    public void setHighlightBackgroundResource(int i)
    {
        mHighlightBackground = getResources().getDrawable(i);
    }

    public void setHighlightBackgroundResource(Drawable drawable)
    {
        mHighlightBackground = drawable;
    }

    public void setNormalBackgroundResource(int i)
    {
        mNormalBackground = getResources().getDrawable(i);
    }

    public void setNormalBackgroundResource(Drawable drawable)
    {
        if (drawable != null)
        {
            mNormalBackground = drawable;
        }
    }

    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        mOnItemClicked = onitemclicklistener;
    }

    public void setOnItemLongClickListener(android.widget.AdapterView.OnItemLongClickListener onitemlongclicklistener)
    {
        mOnItemLongClicked = onitemlongclicklistener;
    }

    public void setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener onitemselectedlistener)
    {
        mOnItemSelected = onitemselectedlistener;
    }

    public void setOnScrollListener(OnScrollListener onscrolllistener)
    {
        onScrollListener = onscrolllistener;
    }

    public void setSelection(int i)
    {
        if (i > -1)
        {
            mInitialPosition = i;
            requestLayout();
        }
    }

    static 
    {
        ID_VIEW_TYPE = com.amazon.retailsearch.R.id.rs_horizontal_list_view_type;
    }


/*
    static boolean access$002(HorizontalListView horizontallistview, boolean flag)
    {
        horizontallistview.mDataChanged = flag;
        return flag;
    }

*/



/*
    static boolean access$102(HorizontalListView horizontallistview, boolean flag)
    {
        horizontallistview.mCanReceiveKeyEvent = flag;
        return flag;
    }

*/







}
