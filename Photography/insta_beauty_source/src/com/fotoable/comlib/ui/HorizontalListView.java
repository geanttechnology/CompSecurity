// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.ui;

import aam;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import yt;
import yu;
import yv;
import yw;
import yx;
import yy;
import yz;

public class HorizontalListView extends AdapterView
{

    private static final String BUNDLE_ID_CURRENT_X = "BUNDLE_ID_CURRENT_X";
    private static final String BUNDLE_ID_PARENT_STATE = "BUNDLE_ID_PARENT_STATE";
    private static final float FLING_DEFAULT_ABSORB_VELOCITY = 30F;
    private static final float FLING_FRICTION = 0.009F;
    private static final int INSERT_AT_END_OF_LIST = -1;
    private static final int INSERT_AT_START_OF_LIST = 0;
    public ListAdapter mAdapter;
    private DataSetObserver mAdapterDataObserver;
    private boolean mBlockTouchAction;
    private OnScrollStateChangedListener.ScrollState mCurrentScrollState;
    protected int mCurrentX;
    private int mCurrentlySelectedAdapterIndex;
    private boolean mDataChanged;
    private Runnable mDelayedLayout;
    private int mDisplayOffset;
    private Drawable mDivider;
    private int mDividerWidth;
    private EdgeEffectCompat mEdgeGlowLeft;
    private EdgeEffectCompat mEdgeGlowRight;
    protected Scroller mFlingTracker;
    private GestureDetector mGestureDetector;
    private final yw mGestureListener = new yw(this, null);
    private boolean mHasNotifiedRunningLowOnData;
    private int mHeightMeasureSpec;
    private boolean mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent;
    private int mLeftViewAdapterIndex;
    private int mMaxX;
    public int mNextX;
    private android.view.View.OnClickListener mOnClickListener;
    private OnScrollStateChangedListener mOnScrollStateChangedListener;
    private Rect mRect;
    private List mRemovedViewsCache;
    private Integer mRestoreX;
    private int mRightViewAdapterIndex;
    private yz mRunningOutOfDataListener;
    private int mRunningOutOfDataThreshold;
    private View mViewBeingTouched;

    public HorizontalListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFlingTracker = new Scroller(getContext());
        mRemovedViewsCache = new ArrayList();
        mDataChanged = false;
        mRect = new Rect();
        mViewBeingTouched = null;
        mDividerWidth = 0;
        mDivider = null;
        mRestoreX = null;
        mMaxX = 0x7fffffff;
        mRunningOutOfDataListener = null;
        mRunningOutOfDataThreshold = 0;
        mHasNotifiedRunningLowOnData = false;
        mOnScrollStateChangedListener = null;
        class OnScrollStateChangedListener.ScrollState extends Enum
        {

            private static final OnScrollStateChangedListener.ScrollState $VALUES[];
            public static final OnScrollStateChangedListener.ScrollState SCROLL_STATE_FLING;
            public static final OnScrollStateChangedListener.ScrollState SCROLL_STATE_IDLE;
            public static final OnScrollStateChangedListener.ScrollState SCROLL_STATE_TOUCH_SCROLL;

            public static OnScrollStateChangedListener.ScrollState valueOf(String s)
            {
                return (OnScrollStateChangedListener.ScrollState)Enum.valueOf(com/fotoable/comlib/ui/HorizontalListView$OnScrollStateChangedListener$ScrollState, s);
            }

            public static OnScrollStateChangedListener.ScrollState[] values()
            {
                return (OnScrollStateChangedListener.ScrollState[])$VALUES.clone();
            }

            static 
            {
                SCROLL_STATE_IDLE = new OnScrollStateChangedListener.ScrollState("SCROLL_STATE_IDLE", 0);
                SCROLL_STATE_TOUCH_SCROLL = new OnScrollStateChangedListener.ScrollState("SCROLL_STATE_TOUCH_SCROLL", 1);
                SCROLL_STATE_FLING = new OnScrollStateChangedListener.ScrollState("SCROLL_STATE_FLING", 2);
                $VALUES = (new OnScrollStateChangedListener.ScrollState[] {
                    SCROLL_STATE_IDLE, SCROLL_STATE_TOUCH_SCROLL, SCROLL_STATE_FLING
                });
            }

            private OnScrollStateChangedListener.ScrollState(String s, int i)
            {
                super(s, i);
            }
        }

        mCurrentScrollState = OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE;
        mBlockTouchAction = false;
        mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent = false;
        mAdapterDataObserver = new yu(this);
        mDelayedLayout = new yv(this);
        mEdgeGlowLeft = new EdgeEffectCompat(context);
        mEdgeGlowRight = new EdgeEffectCompat(context);
        mGestureDetector = new GestureDetector(context, mGestureListener);
        bindGestureDetector();
        initView();
        retrieveXmlConfiguration(context, attributeset);
        setWillNotDraw(false);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            yx.a(mFlingTracker, 0.009F);
        }
    }

    private void addAndMeasureChild(View view, int i)
    {
        addViewInLayout(view, i, getLayoutParams(view), true);
        measureChild(view);
    }

    private void bindGestureDetector()
    {
        setOnTouchListener(new yt(this));
    }

    private float determineFlingAbsorbVelocity()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return yy.a(mFlingTracker);
        } else
        {
            return 30F;
        }
    }

    private void determineIfLowOnData()
    {
        if (mRunningOutOfDataListener != null && mAdapter != null && mAdapter.getCount() - (mRightViewAdapterIndex + 1) < mRunningOutOfDataThreshold && !mHasNotifiedRunningLowOnData)
        {
            mHasNotifiedRunningLowOnData = true;
            mRunningOutOfDataListener.a();
        }
    }

    private boolean determineMaxX()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (isLastItemInAdapter(mRightViewAdapterIndex))
        {
            View view = getRightmostChild();
            flag = flag1;
            if (view != null)
            {
                int i = mMaxX;
                int j = mCurrentX;
                mMaxX = ((view.getRight() - getPaddingLeft()) + j) - getRenderWidth();
                if (mMaxX < 0)
                {
                    mMaxX = 0;
                }
                flag = flag1;
                if (mMaxX != i)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void drawDivider(Canvas canvas, Rect rect)
    {
        if (mDivider != null)
        {
            mDivider.setBounds(rect);
            mDivider.draw(canvas);
        }
    }

    private void drawDividers(Canvas canvas)
    {
        int j = getChildCount();
        Rect rect = mRect;
        mRect.top = getPaddingTop();
        mRect.bottom = mRect.top + getRenderHeight();
        for (int i = 0; i < j; i++)
        {
            if (i == j - 1 && isLastItemInAdapter(mRightViewAdapterIndex))
            {
                continue;
            }
            View view = getChildAt(i);
            rect.left = view.getRight();
            rect.right = view.getRight() + mDividerWidth;
            if (rect.left < getPaddingLeft())
            {
                rect.left = getPaddingLeft();
            }
            if (rect.right > getWidth() - getPaddingRight())
            {
                rect.right = getWidth() - getPaddingRight();
            }
            drawDivider(canvas, rect);
            if (i == 0 && view.getLeft() > getPaddingLeft())
            {
                rect.left = getPaddingLeft();
                rect.right = view.getLeft();
                drawDivider(canvas, rect);
            }
        }

    }

    private void drawEdgeGlow(Canvas canvas)
    {
        if (mEdgeGlowLeft != null && !mEdgeGlowLeft.isFinished() && isEdgeGlowEnabled())
        {
            int i = canvas.save();
            int k = getHeight();
            canvas.rotate(-90F, 0.0F, 0.0F);
            canvas.translate(-k + getPaddingBottom(), 0.0F);
            mEdgeGlowLeft.setSize(getRenderHeight(), getRenderWidth());
            if (mEdgeGlowLeft.draw(canvas))
            {
                invalidate();
            }
            canvas.restoreToCount(i);
        } else
        if (mEdgeGlowRight != null && !mEdgeGlowRight.isFinished() && isEdgeGlowEnabled())
        {
            int j = canvas.save();
            int l = getWidth();
            canvas.rotate(90F, 0.0F, 0.0F);
            canvas.translate(getPaddingTop(), -l);
            mEdgeGlowRight.setSize(getRenderHeight(), getRenderWidth());
            if (mEdgeGlowRight.draw(canvas))
            {
                invalidate();
            }
            canvas.restoreToCount(j);
            return;
        }
    }

    private void fillList(int i)
    {
        boolean flag = false;
        View view = getRightmostChild();
        int j;
        if (view != null)
        {
            j = view.getRight();
        } else
        {
            j = 0;
        }
        fillListRight(j, i);
        view = getLeftmostChild();
        j = ((flag) ? 1 : 0);
        if (view != null)
        {
            j = view.getLeft();
        }
        fillListLeft(j, i);
    }

    private void fillListLeft(int i, int j)
    {
        while ((i + j) - mDividerWidth > 0 && mLeftViewAdapterIndex >= 1) 
        {
            mLeftViewAdapterIndex = mLeftViewAdapterIndex - 1;
            View view = mAdapter.getView(mLeftViewAdapterIndex, getRecycledView(mLeftViewAdapterIndex), this);
            addAndMeasureChild(view, 0);
            int k;
            int l;
            if (mLeftViewAdapterIndex == 0)
            {
                k = view.getMeasuredWidth();
            } else
            {
                k = mDividerWidth + view.getMeasuredWidth();
            }
            k = i - k;
            l = mDisplayOffset;
            if (k + j == 0)
            {
                i = view.getMeasuredWidth();
            } else
            {
                i = mDividerWidth + view.getMeasuredWidth();
            }
            mDisplayOffset = l - i;
            i = k;
        }
    }

    private void fillListRight(int i, int j)
    {
        while (i + j + mDividerWidth < getWidth() && mRightViewAdapterIndex + 1 < mAdapter.getCount()) 
        {
            mRightViewAdapterIndex = mRightViewAdapterIndex + 1;
            if (mLeftViewAdapterIndex < 0)
            {
                mLeftViewAdapterIndex = mRightViewAdapterIndex;
            }
            View view = mAdapter.getView(mRightViewAdapterIndex, getRecycledView(mRightViewAdapterIndex), this);
            addAndMeasureChild(view, -1);
            int k;
            if (mRightViewAdapterIndex == 0)
            {
                k = 0;
            } else
            {
                k = mDividerWidth;
            }
            i += k + view.getMeasuredWidth();
            determineIfLowOnData();
        }
    }

    private View getChild(int i)
    {
        if (i >= mLeftViewAdapterIndex && i <= mRightViewAdapterIndex)
        {
            getChildAt(i - mLeftViewAdapterIndex);
        }
        return null;
    }

    private int getChildIndex(int i, int j)
    {
        int l = getChildCount();
        for (int k = 0; k < l; k++)
        {
            getChildAt(k).getHitRect(mRect);
            if (mRect.contains(i, j))
            {
                return k;
            }
        }

        return -1;
    }

    private android.view.ViewGroup.LayoutParams getLayoutParams(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        view = layoutparams;
        if (layoutparams == null)
        {
            view = new android.view.ViewGroup.LayoutParams(-2, -1);
        }
        return view;
    }

    private View getLeftmostChild()
    {
        return getChildAt(0);
    }

    private View getRecycledView(int i)
    {
        i = mAdapter.getItemViewType(i);
        if (isItemViewTypeValid(i))
        {
            return (View)((Queue)mRemovedViewsCache.get(i)).poll();
        } else
        {
            return null;
        }
    }

    private int getRenderHeight()
    {
        return getHeight() - getPaddingTop() - getPaddingBottom();
    }

    private int getRenderWidth()
    {
        return getWidth() - getPaddingLeft() - getPaddingRight();
    }

    private View getRightmostChild()
    {
        return getChildAt(getChildCount() - 1);
    }

    private void initView()
    {
        mLeftViewAdapterIndex = -1;
        mRightViewAdapterIndex = -1;
        mDisplayOffset = 0;
        mCurrentX = 0;
        mNextX = 0;
        mMaxX = 0x7fffffff;
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
    }

    private void initializeRecycledViewCache(int i)
    {
        mRemovedViewsCache.clear();
        for (int j = 0; j < i; j++)
        {
            mRemovedViewsCache.add(new LinkedList());
        }

    }

    private boolean isEdgeGlowEnabled()
    {
        while (mAdapter == null || mAdapter.isEmpty() || mMaxX <= 0) 
        {
            return false;
        }
        return true;
    }

    private boolean isItemViewTypeValid(int i)
    {
        return i < mRemovedViewsCache.size();
    }

    private boolean isLastItemInAdapter(int i)
    {
        return i == mAdapter.getCount() - 1;
    }

    private void measureChild(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams(view);
        int j = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec, getPaddingTop() + getPaddingBottom(), layoutparams.height);
        int i;
        if (layoutparams.width > 0)
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.width, 0x40000000);
        } else
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(i, j);
    }

    private void positionChildren(int i)
    {
        int k = getChildCount();
        if (k > 0)
        {
            mDisplayOffset = mDisplayOffset + i;
            int j = mDisplayOffset;
            for (i = 0; i < k; i++)
            {
                View view = getChildAt(i);
                int l = getPaddingLeft() + j;
                int i1 = getPaddingTop();
                view.layout(l, i1, view.getMeasuredWidth() + l, view.getMeasuredHeight() + i1);
                j += view.getMeasuredWidth() + mDividerWidth;
            }

        }
    }

    private void recycleView(int i, View view)
    {
        i = mAdapter.getItemViewType(i);
        if (isItemViewTypeValid(i))
        {
            ((Queue)mRemovedViewsCache.get(i)).offer(view);
        }
    }

    private void releaseEdgeGlow()
    {
        if (mEdgeGlowLeft != null)
        {
            mEdgeGlowLeft.onRelease();
        }
        if (mEdgeGlowRight != null)
        {
            mEdgeGlowRight.onRelease();
        }
    }

    private void removeNonVisibleChildren(int i)
    {
        View view = getLeftmostChild();
        while (view != null && view.getRight() + i <= 0) 
        {
            int k = mDisplayOffset;
            int j;
            if (isLastItemInAdapter(mLeftViewAdapterIndex))
            {
                j = view.getMeasuredWidth();
            } else
            {
                j = mDividerWidth + view.getMeasuredWidth();
            }
            mDisplayOffset = j + k;
            recycleView(mLeftViewAdapterIndex, view);
            removeViewInLayout(view);
            mLeftViewAdapterIndex = mLeftViewAdapterIndex + 1;
            view = getLeftmostChild();
        }
        for (View view1 = getRightmostChild(); view1 != null && view1.getLeft() + i >= getWidth(); view1 = getRightmostChild())
        {
            recycleView(mRightViewAdapterIndex, view1);
            removeViewInLayout(view1);
            mRightViewAdapterIndex = mRightViewAdapterIndex - 1;
        }

    }

    private void requestParentListViewToNotInterceptTouchEvents(Boolean boolean1)
    {
        if (mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent == boolean1.booleanValue()) goto _L2; else goto _L1
_L1:
        Object obj = this;
_L7:
        if (!(((View) (obj)).getParent() instanceof View)) goto _L2; else goto _L3
_L3:
        if (!(((View) (obj)).getParent() instanceof ListView) && !(((View) (obj)).getParent() instanceof ScrollView)) goto _L5; else goto _L4
_L4:
        ((View) (obj)).getParent().requestDisallowInterceptTouchEvent(boolean1.booleanValue());
        mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent = boolean1.booleanValue();
_L2:
        return;
_L5:
        obj = (View)((View) (obj)).getParent();
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void reset()
    {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    private void retrieveXmlConfiguration(Context context, AttributeSet attributeset)
    {
        if (attributeset != null)
        {
            context = context.obtainStyledAttributes(attributeset, aam.HorizontalListView);
            attributeset = context.getDrawable(aam.HorizontalListView_android_divider);
            if (attributeset != null)
            {
                setDivider(attributeset);
            }
            int i = context.getDimensionPixelSize(aam.HorizontalListView_dividerWidth, 0);
            if (i != 0)
            {
                setDividerWidth(i);
            }
            context.recycle();
        }
    }

    private void setCurrentScrollState(OnScrollStateChangedListener.ScrollState scrollstate)
    {
        if (mCurrentScrollState != scrollstate && mOnScrollStateChangedListener != null)
        {
            mOnScrollStateChangedListener.a(scrollstate);
        }
        mCurrentScrollState = scrollstate;
    }

    private void unpressTouchedChild()
    {
        if (mViewBeingTouched != null)
        {
            mViewBeingTouched.setPressed(false);
            refreshDrawableState();
            mViewBeingTouched = null;
        }
    }

    private void updateOverscrollAnimation(int i)
    {
        if (mEdgeGlowLeft != null && mEdgeGlowRight != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j;
        j = mCurrentX + i;
        if (mFlingTracker == null || mFlingTracker.isFinished())
        {
            if (j >= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = Math.abs(i);
            mEdgeGlowLeft.onPull((float)i / (float)getRenderWidth());
            if (!mEdgeGlowRight.isFinished())
            {
                mEdgeGlowRight.onRelease();
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (j <= mMaxX) goto _L1; else goto _L3
_L3:
        i = Math.abs(i);
        mEdgeGlowRight.onPull((float)i / (float)getRenderWidth());
        if (!mEdgeGlowLeft.isFinished())
        {
            mEdgeGlowLeft.onRelease();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        drawEdgeGlow(canvas);
    }

    protected void dispatchSetPressed(boolean flag)
    {
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public ListAdapter getAdapter()
    {
        return mAdapter;
    }

    public float getDisplayOffset()
    {
        return (float)mDisplayOffset;
    }

    public int getFirstVisiblePosition()
    {
        return mLeftViewAdapterIndex;
    }

    public int getLastVisiblePosition()
    {
        return mRightViewAdapterIndex;
    }

    protected float getLeftFadingEdgeStrength()
    {
        int i = getHorizontalFadingEdgeLength();
        if (mCurrentX == 0)
        {
            return 0.0F;
        }
        if (mCurrentX < i)
        {
            return (float)mCurrentX / (float)i;
        } else
        {
            return 1.0F;
        }
    }

    protected float getRightFadingEdgeStrength()
    {
        int i = getHorizontalFadingEdgeLength();
        if (mCurrentX == mMaxX)
        {
            return 0.0F;
        }
        if (mMaxX - mCurrentX < i)
        {
            return (float)(mMaxX - mCurrentX) / (float)i;
        } else
        {
            return 1.0F;
        }
    }

    public View getSelectedView()
    {
        return getChild(mCurrentlySelectedAdapterIndex);
    }

    public boolean onDown(MotionEvent motionevent)
    {
        boolean flag;
        if (!mFlingTracker.isFinished())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mBlockTouchAction = flag;
        mFlingTracker.forceFinished(true);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        unpressTouchedChild();
        if (!mBlockTouchAction)
        {
            int i = getChildIndex((int)motionevent.getX(), (int)motionevent.getY());
            if (i >= 0)
            {
                mViewBeingTouched = getChildAt(i);
                if (mViewBeingTouched != null)
                {
                    mViewBeingTouched.setPressed(true);
                    refreshDrawableState();
                }
            }
        }
        return true;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        drawDividers(canvas);
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        mFlingTracker.fling(mNextX, 0, (int)(-f), 0, 0, mMaxX, 0, 0);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
        return true;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (mAdapter != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        invalidate();
        if (mDataChanged)
        {
            int i1 = mCurrentX;
            initView();
            removeAllViewsInLayout();
            mNextX = i1;
            mDataChanged = false;
        }
        if (mRestoreX != null)
        {
            mNextX = mRestoreX.intValue();
            mRestoreX = null;
        }
        if (mFlingTracker.computeScrollOffset())
        {
            mNextX = mFlingTracker.getCurrX();
        }
        if (mNextX >= 0) goto _L4; else goto _L3
_L3:
        mNextX = 0;
        if (mEdgeGlowLeft.isFinished())
        {
            mEdgeGlowLeft.onAbsorb((int)determineFlingAbsorbVelocity());
        }
        mFlingTracker.forceFinished(true);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
_L6:
        int j1 = mCurrentX - mNextX;
        removeNonVisibleChildren(j1);
        fillList(j1);
        positionChildren(j1);
        mCurrentX = mNextX;
        if (determineMaxX())
        {
            onLayout(flag, i, j, k, l);
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (mNextX > mMaxX)
        {
            mNextX = mMaxX;
            if (mEdgeGlowRight.isFinished())
            {
                mEdgeGlowRight.onAbsorb((int)determineFlingAbsorbVelocity());
            }
            mFlingTracker.forceFinished(true);
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (mFlingTracker.isFinished())
        {
            if (mCurrentScrollState == OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING)
            {
                setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
                return;
            }
        } else
        {
            ViewCompat.postOnAnimation(this, mDelayedLayout);
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        mHeightMeasureSpec = j;
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (parcelable instanceof Bundle)
        {
            parcelable = (Bundle)parcelable;
            mRestoreX = Integer.valueOf(parcelable.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(parcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    public Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", mCurrentX);
        return bundle;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() != 1) goto _L2; else goto _L1
_L1:
        if (mFlingTracker == null || mFlingTracker.isFinished())
        {
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        }
        requestParentListViewToNotInterceptTouchEvents(Boolean.valueOf(false));
        releaseEdgeGlow();
_L4:
        return super.onTouchEvent(motionevent);
_L2:
        if (motionevent.getAction() == 3)
        {
            unpressTouchedChild();
            releaseEdgeGlow();
            requestParentListViewToNotInterceptTouchEvents(Boolean.valueOf(false));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void scrollByHorizolOffset(int i)
    {
        mFlingTracker.startScroll(mNextX, 0, i, 0);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
    }

    public void scrollTo(int i)
    {
        mFlingTracker.startScroll(mNextX, 0, i - mNextX, 0);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(mAdapterDataObserver);
        }
        if (listadapter != null)
        {
            mHasNotifiedRunningLowOnData = false;
            mAdapter = listadapter;
            mAdapter.registerDataSetObserver(mAdapterDataObserver);
        }
        initializeRecycledViewCache(mAdapter.getViewTypeCount());
        reset();
    }

    public void setDivider(Drawable drawable)
    {
        mDivider = drawable;
        if (drawable != null)
        {
            setDividerWidth(drawable.getIntrinsicWidth());
            return;
        } else
        {
            setDividerWidth(0);
            return;
        }
    }

    public void setDividerWidth(int i)
    {
        mDividerWidth = i;
        requestLayout();
        invalidate();
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        mOnClickListener = onclicklistener;
    }

    public void setOnScrollStateChangedListener(OnScrollStateChangedListener onscrollstatechangedlistener)
    {
        mOnScrollStateChangedListener = onscrollstatechangedlistener;
    }

    public void setRunningOutOfDataListener(yz yz1, int i)
    {
        mRunningOutOfDataListener = yz1;
        mRunningOutOfDataThreshold = i;
    }

    public void setSelection(int i)
    {
        mCurrentlySelectedAdapterIndex = i;
    }






/*
    public static boolean access$202(HorizontalListView horizontallistview, boolean flag)
    {
        horizontallistview.mDataChanged = flag;
        return flag;
    }

*/


/*
    public static boolean access$302(HorizontalListView horizontallistview, boolean flag)
    {
        horizontallistview.mHasNotifiedRunningLowOnData = flag;
        return flag;
    }

*/







    private class OnScrollStateChangedListener
    {

        public abstract void a(ScrollState scrollstate);
    }

}
