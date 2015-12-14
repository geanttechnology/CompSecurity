// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Adapter;
import com.aviary.android.feather.common.log.LoggerFactory;
import java.util.List;
import java.util.Queue;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryAbsSpinner, VibrationWidget, ScrollerRunnable, VibrationHelper, 
//            AviaryAdapterView

public class AviaryGallery extends AviaryAbsSpinner
    implements android.view.GestureDetector.OnGestureListener, ScrollerRunnable.ScrollableView, VibrationWidget
{
    public static interface OnItemsScrollListener
    {

        public abstract void onScroll(AviaryAdapterView aviaryadapterview, View view, int i, long l);

        public abstract void onScrollFinished(AviaryAdapterView aviaryadapterview, View view, int i, long l);

        public abstract void onScrollStarted(AviaryAdapterView aviaryadapterview, View view, int i, long l);
    }

    private class ScrollCompletedSelectionNotifier
        implements Runnable
    {

        final AviaryGallery this$0;

        public void run()
        {
            if (mDataChanged)
            {
                if (getAdapter() != null)
                {
                    post(this);
                }
                return;
            } else
            {
                fireOnScrollCompleted();
                return;
            }
        }

        private ScrollCompletedSelectionNotifier()
        {
            this$0 = AviaryGallery.this;
            super();
        }

    }

    private class ScrollScrollSelectionNotifier
        implements Runnable
    {

        final AviaryGallery this$0;

        public void run()
        {
            if (mDataChanged)
            {
                if (getAdapter() != null)
                {
                    post(this);
                }
                return;
            } else
            {
                fireOnSelected();
                return;
            }
        }

        private ScrollScrollSelectionNotifier()
        {
            this$0 = AviaryGallery.this;
            super();
        }
    }


    private static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
    static com.aviary.android.feather.common.log.LoggerFactory.Logger logger = LoggerFactory.getLogger("AviaryGallery");
    private boolean isDown;
    private int mAnimationDuration;
    private boolean mAutoScrollToCenter;
    private boolean mAutoSelectChild;
    private int mCenter;
    private AviaryAdapterView.AdapterContextMenuInfo mContextMenuInfo;
    private int mDownTouchPosition;
    private EdgeEffectCompat mEdgeGlowLeft;
    private EdgeEffectCompat mEdgeGlowRight;
    private GestureDetector mGestureDetector;
    private int mGravity;
    private boolean mIsFirstScroll;
    private OnItemsScrollListener mItemsScrollListener;
    private int mLastMotionValue;
    private int mRealSelectedPosition;
    private boolean mReceivedInvokeKeyDown;
    ScrollCompletedSelectionNotifier mScrollCompletedNotifier;
    ScrollScrollSelectionNotifier mScrollScrollNotifier;
    private ScrollerRunnable mScroller;
    private boolean mShouldCallbackDuringFling;
    private boolean mShouldCallbackOnUnselectedItemClick;
    private boolean mSuppressSelectionChanged;
    private int mTouchSlop;
    private VibrationHelper mVibratorHelper;

    public AviaryGallery(Context context)
    {
        this(context, null);
    }

    public AviaryGallery(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, com.aviary.android.feather.sdk.R.attr.aviaryGalleryStyle);
    }

    public AviaryGallery(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mAutoSelectChild = false;
        mItemsScrollListener = null;
        mCenter = 0;
        mGravity = 16;
        mAutoScrollToCenter = true;
        mShouldCallbackDuringFling = false;
        mShouldCallbackOnUnselectedItemClick = true;
        mSuppressSelectionChanged = true;
        attributeset = context.getTheme().obtainStyledAttributes(attributeset, com.aviary.android.feather.sdk.R.styleable.AviaryGallery, i, 0);
        mAnimationDuration = attributeset.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryGallery_android_animationDuration, 400);
        attributeset.recycle();
        mGestureDetector = new GestureDetector(context, this);
        mGestureDetector.setIsLongpressEnabled(false);
        attributeset = ViewConfiguration.get(context);
        mTouchSlop = attributeset.getScaledTouchSlop();
        mScroller = new ScrollerRunnable(this, mAnimationDuration, attributeset.getScaledOverscrollDistance(), new DecelerateInterpolator(1.0F));
        mVibratorHelper = new VibrationHelper(context, true);
    }

    private int calculateTop(View view, boolean flag)
    {
        int i;
        int j;
        if (flag)
        {
            i = getMeasuredHeight();
        } else
        {
            i = getHeight();
        }
        if (flag)
        {
            j = view.getMeasuredHeight();
        } else
        {
            j = view.getHeight();
        }
        switch (mGravity)
        {
        default:
            return 0;

        case 48: // '0'
            return mSpinnerPadding.top;

        case 16: // '\020'
            int k = mSpinnerPadding.bottom;
            int l = mSpinnerPadding.top;
            return mSpinnerPadding.top + (i - k - l - j) / 2;

        case 80: // 'P'
            return i - mSpinnerPadding.bottom - j;
        }
    }

    private void detachOffScreenChildren(boolean flag)
    {
        int i;
        int j;
        int k;
        int l;
        int k1;
        l = getChildCount();
        k1 = mFirstPosition;
        k = 0;
        j = 0;
        i = 0;
        if (!flag) goto _L2; else goto _L1
_L1:
        j = 0;
_L6:
        if (j >= l) goto _L4; else goto _L3
_L3:
        View view = getChildAt(j);
        if (view.getRight() < 0) goto _L5; else goto _L4
_L4:
        int j1;
        l = 0;
        j1 = i;
_L8:
        detachViewsFromParent(l, j1);
        if (flag)
        {
            mFirstPosition = mFirstPosition + j1;
        }
        return;
_L5:
        i++;
        k = mAdapter.getItemViewType(k1 + j);
        ((Queue)mRecycleBin.get(k)).add(view);
        j++;
          goto _L6
_L2:
        int l1;
        l1 = getWidth();
        i = l - 1;
_L10:
        j1 = j;
        l = k;
        if (i < 0) goto _L8; else goto _L7
_L7:
        view = getChildAt(i);
        j1 = j;
        l = k;
        if (view.getLeft() <= l1) goto _L8; else goto _L9
_L9:
        k = i;
        j++;
        int i1 = mAdapter.getItemViewType(k1 + i);
        ((Queue)mRecycleBin.get(i1)).add(view);
        i--;
          goto _L10
    }

    private void dispatchPress(View view)
    {
        if (view != null)
        {
            view.setPressed(true);
        }
        setPressed(true);
    }

    private void dispatchUnpress()
    {
        logger.info("dispatchUnpress");
        setPressed(false);
    }

    private void drawEdges(Canvas canvas)
    {
        if (mEdgeGlowLeft != null)
        {
            if (!mEdgeGlowLeft.isFinished())
            {
                int i = canvas.save();
                int k = getHeight() - getPaddingTop() - getPaddingBottom();
                canvas.rotate(270F);
                canvas.translate(-k + getPaddingTop(), 0.0F);
                mEdgeGlowLeft.setSize(k, getWidth());
                if (mEdgeGlowLeft.draw(canvas))
                {
                    postInvalidate();
                }
                canvas.restoreToCount(i);
            }
            if (!mEdgeGlowRight.isFinished())
            {
                int j = canvas.save();
                int l = getWidth();
                int i1 = getHeight();
                int j1 = getPaddingTop();
                int k1 = getPaddingBottom();
                canvas.rotate(90F);
                canvas.translate(-getPaddingTop(), -l);
                mEdgeGlowRight.setSize(i1 - j1 - k1, l);
                if (mEdgeGlowRight.draw(canvas))
                {
                    postInvalidate();
                }
                canvas.restoreToCount(j);
            }
        }
    }

    private void fillToGalleryLeft()
    {
        View view = getChildAt(0);
        int i;
        int j;
        if (view != null)
        {
            i = mFirstPosition - 1;
            j = view.getLeft();
        } else
        {
            i = 0;
            j = getRight() - getLeft();
        }
        while (j > 0) 
        {
            View view1 = makeAndAddView(i, i - mSelectedPosition, j, false);
            mFirstPosition = i;
            j = view1.getLeft();
            i--;
        }
    }

    private void fillToGalleryRight()
    {
        int k = getRight();
        int l = getLeft();
        int i = getChildCount();
        View view = getChildAt(i - 1);
        int j;
        if (view != null)
        {
            j = mFirstPosition + i;
            i = view.getRight();
        } else
        {
            j = mItemCount - 1;
            mFirstPosition = j;
            i = 0;
        }
        while (i < k - l) 
        {
            i = makeAndAddView(j, j - mSelectedPosition, i, true).getRight();
            j++;
        }
    }

    private void fireOnScrollCompleted()
    {
        Log.i("View", "fireOnScrollCompleted");
        int i;
        if (mItemsScrollListener != null)
        {
            if ((i = getSelectedItemPosition()) >= 0 && i < mItemCount)
            {
                View view = getSelectedView();
                mItemsScrollListener.onScrollFinished(this, view, i, getAdapter().getItemId(i));
                return;
            }
        }
    }

    private void fireVibration()
    {
        mVibratorHelper.vibrate(10);
    }

    private int getCenterOfGallery()
    {
        return mCenter;
    }

    private static int getCenterOfView(View view)
    {
        return view.getLeft() + view.getWidth() / 2;
    }

    private boolean isOverScrolled()
    {
        if (getChildCount() >= 2 && (mSelectedPosition == 0 || mSelectedPosition == mItemCount - 1))
        {
            View view = getChildAt(mSelectedPosition - mFirstPosition);
            if (view != null)
            {
                int i = getCenterOfView(view);
                int j = getCenterOfGallery();
                if (mSelectedPosition == 0 && i > j)
                {
                    return true;
                }
                if (mSelectedPosition == mItemCount - 1 && i < j)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private View makeAndAddView(int i, int j, int k, boolean flag)
    {
        View view = null;
        int l = mAdapter.getItemViewType(i);
        if (!mDataChanged)
        {
            View view1 = (View)((Queue)mRecycleBin.get(l)).poll();
            view = view1;
            if (view1 != null)
            {
                view = mAdapter.getView(i, view1, this);
                setUpChild(view, j, k, flag);
            }
        }
        View view2 = view;
        if (view == null)
        {
            view2 = mAdapter.getView(i, null, this);
            setUpChild(view2, j, k, flag);
        }
        if (!mAutoSelectChild && view2 != null)
        {
            if (i == mRealSelectedPosition)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view2.setSelected(flag);
        }
        return view2;
    }

    private void offsetChildrenLeftAndRight(int i)
    {
        for (int j = getChildCount() - 1; j >= 0; j--)
        {
            getChildAt(j).offsetLeftAndRight(i);
        }

    }

    private void onFinishedMovement()
    {
        Log.i("View", "onFinishedMovement");
        if (isDown)
        {
            return;
        }
        if (mSuppressSelectionChanged)
        {
            mSuppressSelectionChanged = false;
            selectionChanged(mSelectedPosition, mSelectedPosition);
        }
        scrollCompleted();
        if (!mAutoSelectChild)
        {
            View view = getSelectedView();
            if (mRealSelectedPosition != mSelectedPosition)
            {
                View view1 = getChildAt(mRealSelectedPosition - mFirstPosition);
                if (view1 != null)
                {
                    view1.setSelected(false);
                }
            }
            mRealSelectedPosition = mSelectedPosition;
            if (view != null)
            {
                view.setSelected(true);
            }
        }
        invalidate();
    }

    private boolean scrollToChild(int i)
    {
        View view = getChildAt(i);
        if (view != null)
        {
            if (mItemsScrollListener != null)
            {
                i = getSelectedItemPosition();
                if (i >= 0)
                {
                    View view1 = getSelectedView();
                    mItemsScrollListener.onScrollStarted(this, view1, i, getAdapter().getItemId(i));
                }
            }
            i = getCenterOfGallery() - getCenterOfView(view);
            mScroller.startUsingDistance(0, -i);
            return i != 0;
        } else
        {
            return false;
        }
    }

    private void setSelectionToCenterChild()
    {
        View view = getChildAt(mSelectedPosition - mFirstPosition);
        if (view != null) goto _L2; else goto _L1
_L1:
        int k1;
        return;
_L2:
        int i;
        int j;
        int k;
        if (view.getLeft() <= (k1 = getCenterOfGallery()) && view.getRight() >= k1)
        {
            continue; /* Loop/switch isn't completed */
        }
        k = 0x7fffffff;
        j = 0;
        i = getChildCount() - 1;
_L4:
label0:
        {
            int l = j;
            if (i >= 0)
            {
                view = getChildAt(i);
                if (view.getLeft() > k1 || view.getRight() < k1)
                {
                    break label0;
                }
                l = i;
            }
            i = mFirstPosition + l;
            if (i != mSelectedPosition)
            {
                i = Math.min(Math.max(i, 0), mItemCount - 1);
                setSelectedPositionInt(i, true);
                setNextSelectedPositionInt(i);
                checkSelectionChanged();
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        int j1 = Math.min(Math.abs(view.getLeft() - k1), Math.abs(view.getRight() - k1));
        int i1 = k;
        if (j1 < k)
        {
            i1 = j1;
            j = i;
        }
        i--;
        k = i1;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void setUpChild(View view, int i, int j, boolean flag)
    {
        android.view.ViewGroup.LayoutParams layoutparams1 = view.getLayoutParams();
        android.view.ViewGroup.LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = generateDefaultLayoutParams();
        }
        byte byte0;
        if (flag)
        {
            byte0 = -1;
        } else
        {
            byte0 = 0;
        }
        addViewInLayout(view, byte0, layoutparams);
        if (mAutoSelectChild)
        {
            int l;
            int i1;
            boolean flag1;
            if (i == 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            view.setSelected(flag1);
        }
        i = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec, mPaddingTop + mPaddingBottom, layoutparams.height);
        view.measure(ViewGroup.getChildMeasureSpec(mWidthMeasureSpec, 0, layoutparams.width), i);
        l = calculateTop(view, true);
        i1 = view.getMeasuredHeight();
        i = view.getMeasuredWidth();
        if (flag)
        {
            i = j + i;
        } else
        {
            int k = j - i;
            i = j;
            j = k;
        }
        view.layout(j, l, i, l + i1);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof android.view.ViewGroup.LayoutParams;
    }

    protected int computeHorizontalScrollExtent()
    {
        return 1;
    }

    protected int computeHorizontalScrollOffset()
    {
        return mSelectedPosition;
    }

    protected int computeHorizontalScrollRange()
    {
        return mItemCount;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (getChildCount() > 0)
        {
            drawEdges(canvas);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return keyevent.dispatch(this, null, null);
    }

    protected void dispatchSetPressed(boolean flag)
    {
        logger.info("dispatchSetPressed: %b", new Object[] {
            Boolean.valueOf(flag)
        });
        if (!flag)
        {
            for (int i = getChildCount() - 1; i >= 0; i--)
            {
                getChildAt(i).setPressed(false);
            }

        }
    }

    public void dispatchSetSelected(boolean flag)
    {
    }

    protected void fireOnSelected()
    {
        Log.i("View", (new StringBuilder()).append("fireOnSelected: current: ").append(mSelectedPosition).append(", next: ").append(getSelectedItemPosition()).append(", inLayout: ").append(mInLayout).toString());
        if (mItemsScrollListener == null)
        {
            return;
        } else
        {
            View view = getSelectedView();
            int i = getSelectedItemPosition();
            mItemsScrollListener.onScroll(this, view, i, getAdapter().getItemId(i));
            return;
        }
    }

    public void forceChildLayout(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        int i = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec, getPaddingTop() + getPaddingBottom(), layoutparams.height);
        view.measure(ViewGroup.getChildMeasureSpec(mWidthMeasureSpec, getPaddingLeft() + getPaddingRight(), layoutparams.width), i);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new android.view.ViewGroup.LayoutParams(-2, -1);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new android.view.ViewGroup.LayoutParams(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new android.view.ViewGroup.LayoutParams(layoutparams);
    }

    public boolean getAutoSelectChild()
    {
        return mAutoSelectChild;
    }

    int getChildHeight(View view)
    {
        return view.getMeasuredHeight();
    }

    protected android.view.ContextMenu.ContextMenuInfo getContextMenuInfo()
    {
        return mContextMenuInfo;
    }

    public int getCurrentSelectedItemPosition()
    {
        if (!mAutoSelectChild)
        {
            return mRealSelectedPosition;
        } else
        {
            return mSelectedPosition;
        }
    }

    int getLimitedMotionScrollAmount(boolean flag, int i)
    {
        View view;
        int j;
        boolean flag1;
        flag1 = false;
        if (flag)
        {
            j = mItemCount - 1;
        } else
        {
            j = 0;
        }
        view = getChildAt(j - mFirstPosition);
        if (view != null) goto _L2; else goto _L1
_L1:
        j = i;
_L4:
        return j;
_L2:
        int k;
        int l;
        k = getCenterOfView(view);
        if (flag)
        {
            j = view.getWidth() / 2;
        } else
        {
            j = -view.getWidth() / 2;
        }
        k += j;
        l = getCenterOfGallery();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        j = ((flag1) ? 1 : 0);
        if (k <= l) goto _L4; else goto _L3
_L3:
        j = l - k;
        if (flag)
        {
            return Math.max(j, i);
        } else
        {
            return Math.min(j, i);
        }
        if (k >= l)
        {
            return 0;
        }
          goto _L3
    }

    public int getMaxX()
    {
        return 0x7fffffff;
    }

    public int getMinX()
    {
        return 0;
    }

    int getOverScrollDelta(int i)
    {
        View view;
        boolean flag;
        int j = 0;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            j = mItemCount - 1;
        }
        view = getChildAt(j - mFirstPosition);
        if (view != null) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        int k;
        int l;
        k = getCenterOfView(view);
        l = getCenterOfGallery();
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k - i >= l) goto _L1; else goto _L3
_L3:
        return k - l;
        if (k - i <= l) goto _L1; else goto _L4
_L4:
        return k - l;
    }

    public int getSelectedItemPosition()
    {
        return super.getSelectedItemPosition();
    }

    public boolean getVibrationEnabled()
    {
        return mVibratorHelper.enabled();
    }

    public void invalidateViews()
    {
        int j = getChildCount();
        int i = 0;
        while (i < j) 
        {
            View view = getChildAt(i);
            mAdapter.getView(mFirstPosition + i, view, this);
            if (!mAutoSelectChild)
            {
                boolean flag;
                if (mFirstPosition + i == mRealSelectedPosition)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setSelected(flag);
            }
            i++;
        }
    }

    void layout(int i, boolean flag, boolean flag1)
    {
        if (!flag1 && i == 0)
        {
            layoutChildren();
            return;
        }
        int j = getRight();
        int k = getLeft();
        Log.i("View", (new StringBuilder()).append("layout. delta: ").append(i).append(", animate: ").append(flag).append(", changed: ").append(flag1).append(", inLayout: ").append(mInLayout).toString());
        if (mDataChanged)
        {
            handleDataChanged();
        }
        if (mItemCount == 0)
        {
            resetList();
            return;
        }
        Log.d("View", (new StringBuilder()).append("mNextSelectedPosition: ").append(mNextSelectedPosition).toString());
        if (mNextSelectedPosition >= 0)
        {
            mRealSelectedPosition = mNextSelectedPosition;
            setSelectedPositionInt(mNextSelectedPosition, flag);
        }
        mFirstPosition = mSelectedPosition;
        if (getChildCount() == 0 || flag1 || i != 0)
        {
            recycleAllViews();
            emptySubRecycler();
            removeAllViewsInLayout();
            View view = makeAndAddView(mSelectedPosition, 0, 0, true);
            view.offsetLeftAndRight(((j - k) / 2 + 0) - view.getWidth() / 2);
            fillToGalleryRight();
            fillToGalleryLeft();
        }
        mDataChanged = false;
        mNeedSync = false;
        mSuppressSelectionChanged = false;
        setNextSelectedPositionInt(mSelectedPosition);
        checkSelectionChanged();
        mSuppressSelectionChanged = true;
        Log.d("View", "layout complete");
        postInvalidate();
    }

    public void layoutChildren()
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            View view = getChildAt(i);
            forceChildLayout(view, view.getLayoutParams());
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }

    }

    public boolean moveNext()
    {
        if (mItemCount > 0 && mSelectedPosition < mItemCount - 1)
        {
            scrollToChild((mSelectedPosition - mFirstPosition) + 1);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean movePrevious()
    {
        if (mItemCount > 0 && mSelectedPosition > 0)
        {
            scrollToChild(mSelectedPosition - mFirstPosition - 1);
            return true;
        } else
        {
            return false;
        }
    }

    void onCancel()
    {
        onUp();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeCallbacks(mScrollCompletedNotifier);
        removeCallbacks(mScrollScrollNotifier);
    }

    public boolean onDown(MotionEvent motionevent)
    {
        logger.info("onDown");
        isDown = true;
        mScroller.stop(false);
        mDownTouchPosition = pointToPosition((int)motionevent.getX(), (int)motionevent.getY());
        if (mDownTouchPosition >= 0 && mDownTouchPosition < mItemCount)
        {
            dispatchPress(getChildAt(mDownTouchPosition - mFirstPosition));
        }
        mIsFirstScroll = true;
        return true;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (!mShouldCallbackDuringFling)
        {
            mSuppressSelectionChanged = true;
        }
        int j = (int)(-f) / 2;
        int i;
        byte byte0;
        if (j < 0)
        {
            i = 0x7fffffff;
        } else
        {
            i = 0;
        }
        if (j < 0)
        {
            byte0 = -2;
        } else
        {
            byte0 = 2;
        }
        if (byte0 == getOverScrollDelta(byte0))
        {
            mScroller.startUsingVelocity(i, j);
            return true;
        } else
        {
            return false;
        }
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect)
    {
        super.onFocusChanged(flag, i, rect);
        rect = getChildAt(mSelectedPosition - mFirstPosition);
        if (flag && rect != null && mAutoSelectChild)
        {
            rect.setSelected(true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag = true;
        i;
        JVM INSTR lookupswitch 4: default 44
    //                   21: 48
    //                   22: 62
    //                   23: 76
    //                   66: 76;
           goto _L1 _L2 _L3 _L4 _L4
_L1:
        flag = false;
_L6:
        return flag;
_L2:
        if (!movePrevious()) goto _L6; else goto _L5
_L5:
        playSoundEffect(1);
        return true;
_L3:
        if (!moveNext()) goto _L6; else goto _L7
_L7:
        playSoundEffect(3);
        return true;
_L4:
        mReceivedInvokeKeyDown = true;
        if (true) goto _L1; else goto _L8
_L8:
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        switch (i)
        {
        default:
            return false;

        case 23: // '\027'
        case 66: // 'B'
            break;
        }
        if (mReceivedInvokeKeyDown && mItemCount > 0)
        {
            keyevent = getChildAt(mSelectedPosition - mFirstPosition);
            if (keyevent != null)
            {
                dispatchPress(keyevent);
                postDelayed(new Runnable() {

                    final AviaryGallery this$0;

                    public void run()
                    {
                        dispatchUnpress();
                    }

            
            {
                this$0 = AviaryGallery.this;
                super();
            }
                }, ViewConfiguration.getPressedStateDuration());
                performItemClick(keyevent, mSelectedPosition, mAdapter.getItemId(mSelectedPosition));
            }
        }
        mReceivedInvokeKeyDown = false;
        return true;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        Log.i("View", (new StringBuilder()).append("onLayout: ").append(flag).toString());
        super.onLayout(flag, i, j, k, l);
        mInLayout = true;
        layout(0, false, flag);
        mInLayout = false;
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    protected void onOverScrolled(int i, int j, boolean flag, boolean flag1)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        int k;
        getParent().requestDisallowInterceptTouchEvent(true);
        mSuppressSelectionChanged = false;
        f1 = f;
        if (mIsFirstScroll)
        {
            if (mItemsScrollListener != null)
            {
                int i = getSelectedItemPosition();
                if (i >= 0)
                {
                    motionevent = getSelectedView();
                    mItemsScrollListener.onScrollStarted(this, motionevent, i, getAdapter().getItemId(i));
                }
            }
            int j;
            if (f > 0.0F)
            {
                f1 = f - (float)mTouchSlop;
            } else
            {
                f1 = f + (float)mTouchSlop;
            }
        }
        k = (int)f1;
        j = getOverScrollDelta(k);
        trackMotionScroll(j);
        if (mEdgeGlowLeft == null) goto _L2; else goto _L1
_L1:
        if (k == j) goto _L4; else goto _L3
_L3:
        boolean flag;
        if (k > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        motionevent = getChildAt(0);
        if (motionevent != null)
        {
            f = motionevent.getWidth() * 2;
        } else
        {
            f = getWidth() / 2;
        }
        if (flag) goto _L6; else goto _L5
_L5:
        mEdgeGlowLeft.onPull((float)(-k) / f);
        if (!mEdgeGlowRight.isFinished())
        {
            mEdgeGlowRight.onRelease();
        }
_L4:
        if (!mEdgeGlowRight.isFinished() || !mEdgeGlowLeft.isFinished())
        {
            postInvalidate();
        }
_L2:
        mIsFirstScroll = false;
        return true;
_L6:
        mEdgeGlowRight.onPull((float)k / f);
        if (!mEdgeGlowLeft.isFinished())
        {
            mEdgeGlowLeft.onRelease();
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        logger.info("onSingleTapUp");
        if (mDownTouchPosition >= 0 && mDownTouchPosition < mItemCount && !scrollToChild(mDownTouchPosition - mFirstPosition))
        {
            if (mShouldCallbackOnUnselectedItemClick || mDownTouchPosition == mSelectedPosition)
            {
                performItemClick(getChildAt(mDownTouchPosition - mFirstPosition), mDownTouchPosition, mAdapter.getItemId(mDownTouchPosition));
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        mCenter = i / 2;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = mGestureDetector.onTouchEvent(motionevent);
        int i = motionevent.getAction();
        if (i == 1)
        {
            onUp();
        } else
        if (i == 3)
        {
            onCancel();
            return flag;
        }
        return flag;
    }

    void onUp()
    {
        logger.info("onUp");
        isDown = false;
        if (!mScroller.isFinished()) goto _L2; else goto _L1
_L1:
        scrollIntoSlots();
_L4:
        if (mEdgeGlowLeft != null)
        {
            mEdgeGlowLeft.onRelease();
            mEdgeGlowRight.onRelease();
        }
        dispatchUnpress();
        return;
_L2:
        if (isOverScrolled())
        {
            scrollIntoSlots();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void scrollCompleted()
    {
label0:
        {
            if (mItemsScrollListener != null)
            {
                if (!mInLayout && !mBlockLayoutRequests)
                {
                    break label0;
                }
                if (mScrollCompletedNotifier == null)
                {
                    mScrollCompletedNotifier = new ScrollCompletedSelectionNotifier();
                }
                post(mScrollCompletedNotifier);
            }
            return;
        }
        fireOnScrollCompleted();
    }

    public void scrollIntoSlots()
    {
        View view;
        if (getChildCount() != 0)
        {
            if (mAutoScrollToCenter)
            {
                if ((view = getChildAt(mSelectedPosition - mFirstPosition)) != null)
                {
                    int i = getCenterOfView(view);
                    i = getCenterOfGallery() - i;
                    if (i != 0)
                    {
                        mScroller.startUsingDistance(0, -i);
                        return;
                    } else
                    {
                        onFinishedMovement();
                        return;
                    }
                }
            } else
            {
                onFinishedMovement();
                return;
            }
        }
    }

    void selectionChanged(int i, int j)
    {
        if (mAutoSelectChild && i != j)
        {
            View view = getChildAt(i - mFirstPosition);
            View view1 = getChildAt(j - mFirstPosition);
            if (view1 != null)
            {
                view1.setSelected(true);
            }
            if (view != null && view != view1)
            {
                view.setSelected(false);
            }
        }
        if (!mSuppressSelectionChanged)
        {
            if (mItemsScrollListener != null && !mInLayout && !mBlockLayoutRequests)
            {
                fireOnSelected();
            }
            if (mSelectedPosition != -1 && isShown() && !isInTouchMode())
            {
                sendAccessibilityEvent(4);
            }
        }
        if (i != j && !mInLayout)
        {
            fireVibration();
        }
    }

    public void setAnimationDuration(int i)
    {
        mAnimationDuration = i;
    }

    public void setAutoScrollToCenter(boolean flag)
    {
        mAutoScrollToCenter = flag;
    }

    public void setAutoSelectChild(boolean flag)
    {
        mAutoSelectChild = flag;
    }

    public void setCallbackDuringFling(boolean flag)
    {
        mShouldCallbackDuringFling = flag;
    }

    public void setCallbackOnUnselectedItemClick(boolean flag)
    {
        mShouldCallbackOnUnselectedItemClick = flag;
    }

    public void setGravity(int i)
    {
        if (mGravity != i)
        {
            mGravity = i;
            requestLayout();
        }
    }

    public void setOnItemsScrollListener(OnItemsScrollListener onitemsscrolllistener)
    {
        mItemsScrollListener = onitemsscrolllistener;
    }

    public void setOverScrollMode(int i)
    {
        super.setOverScrollMode(i);
        if (i != 2)
        {
            if (mEdgeGlowLeft == null)
            {
                mEdgeGlowLeft = new EdgeEffectCompat(getContext());
                mEdgeGlowRight = new EdgeEffectCompat(getContext());
            }
            return;
        } else
        {
            mEdgeGlowLeft = null;
            mEdgeGlowRight = null;
            return;
        }
    }

    void setSelectedPositionInt(int i, boolean flag)
    {
        Log.i("View", (new StringBuilder()).append("setSelectedPositionInt: ").append(i).append(" from ").append(mSelectedPosition).toString());
        mOldSelectedPosition = mSelectedPosition;
        super.setSelectedPositionInt(i);
    }

    public void setVibrationEnabled(boolean flag)
    {
        mVibratorHelper.setEnabled(flag);
    }

    public void trackMotionScroll(int i)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k = mScroller.getLastFlingX() - i;
        int j;
        int l;
        if (i > 0)
        {
            mDownTouchPosition = mFirstPosition;
            Math.min((getWidth() + 0 + 0) - 1, i);
        } else
        {
            mDownTouchPosition = (mFirstPosition + getChildCount()) - 1;
            Math.max(-((getWidth() + 0 + 0) - 1), i);
        }
        if (getChildCount() == 0) goto _L1; else goto _L3
_L3:
        boolean flag;
        if (k < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = k;
        j = i;
        if (mScroller.isFinished()) goto _L5; else goto _L4
_L4:
        l = getLimitedMotionScrollAmount(flag, k);
        j = i;
        if (l == k) goto _L5; else goto _L6
_L6:
        if (flag) goto _L8; else goto _L7
_L7:
        if (mEdgeGlowLeft != null)
        {
            mEdgeGlowLeft.onAbsorb((int)mScroller.getCurrVelocity());
        }
_L10:
        j = l;
_L5:
        if (j != k)
        {
            mScroller.endFling(false);
            if (j == 0)
            {
                onFinishedMovement();
            }
        }
        offsetChildrenLeftAndRight(j);
        detachOffScreenChildren(flag);
        if (flag)
        {
            fillToGalleryRight();
        } else
        {
            fillToGalleryLeft();
        }
        setSelectionToCenterChild();
        onScrollChanged(0, 0, 0, 0);
        invalidate();
        return;
_L8:
        if (mEdgeGlowRight != null)
        {
            mEdgeGlowRight.onAbsorb((int)mScroller.getCurrVelocity());
        }
        if (true) goto _L10; else goto _L9
_L9:
    }



}
