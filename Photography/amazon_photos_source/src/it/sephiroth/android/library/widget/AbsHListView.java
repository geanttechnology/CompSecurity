// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Adapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import it.sephiroth.android.library.util.ViewHelperFactory;
import it.sephiroth.android.library.util.v11.MultiChoiceModeListener;
import it.sephiroth.android.library.util.v11.MultiChoiceModeWrapper;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AdapterView, EdgeEffect, OverScroller

public abstract class AbsHListView extends AdapterView
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnTouchModeChangeListener
{
    public class AdapterDataSetObserver extends AdapterView.AdapterDataSetObserver
    {

        final AbsHListView this$0;

        public volatile void clearSavedState()
        {
            super.clearSavedState();
        }

        public void onChanged()
        {
            super.onChanged();
        }

        public void onInvalidated()
        {
            super.onInvalidated();
        }

        public AdapterDataSetObserver()
        {
            this$0 = AbsHListView.this;
            super(AbsHListView.this);
        }
    }

    private class CheckForKeyLongPress extends WindowRunnnable
        implements Runnable
    {

        final AbsHListView this$0;

        public void run()
        {
            if (isPressed() && mSelectedPosition >= 0)
            {
                int i = mSelectedPosition;
                int j = mFirstPosition;
                View view = getChildAt(i - j);
                if (!mDataChanged)
                {
                    boolean flag = false;
                    if (sameWindow())
                    {
                        flag = performLongPress(view, mSelectedPosition, mSelectedColId);
                    }
                    if (flag)
                    {
                        setPressed(false);
                        view.setPressed(false);
                    }
                } else
                {
                    setPressed(false);
                    if (view != null)
                    {
                        view.setPressed(false);
                        return;
                    }
                }
            }
        }

        private CheckForKeyLongPress()
        {
            this$0 = AbsHListView.this;
            super();
        }

    }

    private class CheckForLongPress extends WindowRunnnable
        implements Runnable
    {

        final AbsHListView this$0;

        public void run()
        {
label0:
            {
                int i = mMotionPosition;
                View view = getChildAt(i - mFirstPosition);
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

        private CheckForLongPress()
        {
            this$0 = AbsHListView.this;
            super();
        }

    }

    final class CheckForTap
        implements Runnable
    {

        final AbsHListView this$0;

        public void run()
        {
label0:
            {
label1:
                {
                    if (mTouchMode == 0)
                    {
                        mTouchMode = 1;
                        View view = getChildAt(mMotionPosition - mFirstPosition);
                        if (view != null && !view.hasFocusable())
                        {
                            mLayoutMode = 0;
                            if (mDataChanged)
                            {
                                break label0;
                            }
                            view.setPressed(true);
                            setPressed(true);
                            layoutChildren();
                            positionSelector(mMotionPosition, view);
                            refreshDrawableState();
                            int i = ViewConfiguration.getLongPressTimeout();
                            boolean flag = isLongClickable();
                            if (mSelector != null)
                            {
                                Drawable drawable = mSelector.getCurrent();
                                if (drawable != null && (drawable instanceof TransitionDrawable))
                                {
                                    if (flag)
                                    {
                                        ((TransitionDrawable)drawable).startTransition(i);
                                    } else
                                    {
                                        ((TransitionDrawable)drawable).resetTransition();
                                    }
                                }
                            }
                            if (!flag)
                            {
                                break label1;
                            }
                            if (mPendingCheckForLongPress == null)
                            {
                                mPendingCheckForLongPress = new CheckForLongPress();
                            }
                            mPendingCheckForLongPress.rememberWindowAttachCount();
                            postDelayed(mPendingCheckForLongPress, i);
                        }
                    }
                    return;
                }
                mTouchMode = 2;
                return;
            }
            mTouchMode = 2;
        }

        CheckForTap()
        {
            this$0 = AbsHListView.this;
            super();
        }
    }

    private class FlingRunnable
        implements Runnable
    {

        private static final int FLYWHEEL_TIMEOUT = 40;
        private final Runnable mCheckFlywheel = new _cls1();
        private int mLastFlingX;
        private final OverScroller mScroller;
        final AbsHListView this$0;

        void edgeReached(int i)
        {
            int j;
            mScroller.notifyHorizontalEdgeReached(getScrollX(), 0, mOverflingDistance);
            j = getOverScrollMode();
            if (j != 0 && (j != 1 || contentFits())) goto _L2; else goto _L1
_L1:
            mTouchMode = 6;
            int k = (int)mScroller.getCurrVelocity();
            if (i > 0)
            {
                mEdgeGlowTop.onAbsorb(k);
            } else
            {
                mEdgeGlowBottom.onAbsorb(k);
            }
_L4:
            invalidate();
            mViewHelper.postOnAnimation(this);
            return;
_L2:
            mTouchMode = -1;
            if (mPositionScroller != null)
            {
                mPositionScroller.stop();
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        void endFling()
        {
            mTouchMode = -1;
            removeCallbacks(this);
            removeCallbacks(mCheckFlywheel);
            reportScrollStateChange(0);
            clearScrollingCache();
            mScroller.abortAnimation();
            overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void flywheelTouch()
        {
            postDelayed(mCheckFlywheel, 40L);
        }

        public void run()
        {
            mTouchMode;
            JVM INSTR tableswitch 3 6: default 36
        //                       3 41
        //                       4 51
        //                       5 36
        //                       6 433;
               goto _L1 _L2 _L3 _L1 _L4
_L1:
            endFling();
_L5:
            return;
_L2:
            if (mScroller.isFinished())
            {
                continue; /* Loop/switch isn't completed */
            }
_L3:
            if (mDataChanged)
            {
                layoutChildren();
            }
            if (mItemCount == 0 || getChildCount() == 0)
            {
                endFling();
                return;
            }
            Object obj = mScroller;
            boolean flag2 = ((OverScroller) (obj)).computeScrollOffset();
            int l1 = ((OverScroller) (obj)).getCurrX();
            int i = mLastFlingX - l1;
            int k;
            boolean flag1;
            boolean flag3;
            if (i > 0)
            {
                mMotionPosition = mFirstPosition;
                obj = getChildAt(0);
                mMotionViewOriginalLeft = ((View) (obj)).getLeft();
                i = Math.min(getWidth() - getPaddingRight() - getPaddingLeft() - 1, i);
            } else
            {
                int l = getChildCount() - 1;
                mMotionPosition = mFirstPosition + l;
                View view = getChildAt(l);
                mMotionViewOriginalLeft = view.getLeft();
                i = Math.max(-(getWidth() - getPaddingRight() - getPaddingLeft() - 1), i);
            }
            obj = getChildAt(mMotionPosition - mFirstPosition);
            k = 0;
            if (obj != null)
            {
                k = ((View) (obj)).getLeft();
            }
            flag3 = trackMotionScroll(i, i);
            if (flag3 && i != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                if (obj != null)
                {
                    k = -(i - (((View) (obj)).getLeft() - k));
                    overScrollBy(k, 0, getScrollX(), 0, 0, 0, mOverflingDistance, 0, false);
                }
                if (flag2)
                {
                    edgeReached(i);
                    return;
                }
            } else
            if (flag2 && !flag1)
            {
                if (flag3)
                {
                    invalidate();
                }
                mLastFlingX = l1;
                mViewHelper.postOnAnimation(this);
                return;
            } else
            {
                endFling();
                return;
            }
            if (true) goto _L5; else goto _L4
_L4:
            OverScroller overscroller = mScroller;
            if (overscroller.computeScrollOffset())
            {
                int i1 = getScrollX();
                int j1 = overscroller.getCurrX();
                if (overScrollBy(j1 - i1, 0, i1, 0, 0, 0, mOverflingDistance, 0, false))
                {
                    int j;
                    boolean flag;
                    if (i1 <= 0 && j1 > 0)
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    if (i1 >= 0 && j1 < 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (j != 0 || flag)
                    {
                        int k1 = (int)overscroller.getCurrVelocity();
                        j = k1;
                        if (flag)
                        {
                            j = -k1;
                        }
                        overscroller.abortAnimation();
                        start(j);
                        return;
                    } else
                    {
                        startSpringback();
                        return;
                    }
                } else
                {
                    invalidate();
                    mViewHelper.postOnAnimation(this);
                    return;
                }
            } else
            {
                endFling();
                return;
            }
        }

        void start(int i)
        {
            int j;
            if (i < 0)
            {
                j = 0x7fffffff;
            } else
            {
                j = 0;
            }
            mLastFlingX = j;
            mScroller.setInterpolator(null);
            mScroller.fling(j, 0, i, 0, 0, 0x7fffffff, 0, 0x7fffffff);
            mTouchMode = 4;
            mViewHelper.postOnAnimation(this);
        }

        void startOverfling(int i)
        {
            mScroller.setInterpolator(null);
            mScroller.fling(getScrollX(), 0, i, 0, 0x80000000, 0x7fffffff, 0, 0, getWidth(), 0);
            mTouchMode = 6;
            invalidate();
            mViewHelper.postOnAnimation(this);
        }

        void startScroll(int i, int j, boolean flag)
        {
            Interpolator interpolator;
            OverScroller overscroller;
            int k;
            if (i < 0)
            {
                k = 0x7fffffff;
            } else
            {
                k = 0;
            }
            mLastFlingX = k;
            overscroller = mScroller;
            if (flag)
            {
                interpolator = AbsHListView.sLinearInterpolator;
            } else
            {
                interpolator = null;
            }
            overscroller.setInterpolator(interpolator);
            mScroller.startScroll(k, 0, i, 0, j);
            mTouchMode = 4;
            mViewHelper.postOnAnimation(this);
        }

        void startSpringback()
        {
            if (mScroller.springBack(getScrollX(), 0, 0, 0, 0, 0))
            {
                mTouchMode = 6;
                invalidate();
                mViewHelper.postOnAnimation(this);
                return;
            } else
            {
                mTouchMode = -1;
                reportScrollStateChange(0);
                return;
            }
        }


        FlingRunnable()
        {
            this$0 = AbsHListView.this;
            super();
            mScroller = new OverScroller(getContext());
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams
    {

        public boolean forceAdd;
        public long itemId;
        public boolean recycledHeaderFooter;
        public int scrappedFromPosition;
        public int viewType;

        public LayoutParams(int i, int j)
        {
            super(i, j);
            itemId = -1L;
        }

        public LayoutParams(int i, int j, int k)
        {
            super(i, j);
            itemId = -1L;
            viewType = k;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            itemId = -1L;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            itemId = -1L;
        }
    }

    class ListItemAccessibilityDelegate extends AccessibilityDelegateCompat
    {

        final AbsHListView this$0;

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
        {
            int i;
            super.onInitializeAccessibilityNodeInfo(view, accessibilitynodeinfocompat);
            i = getPositionForView(view);
            view = (ListAdapter)getAdapter();
            break MISSING_BLOCK_LABEL_26;
            if (i != -1 && view != null && isEnabled() && view.isEnabled(i))
            {
                if (i == getSelectedItemPosition())
                {
                    accessibilitynodeinfocompat.setSelected(true);
                    accessibilitynodeinfocompat.addAction(8);
                } else
                {
                    accessibilitynodeinfocompat.addAction(4);
                }
                if (isClickable())
                {
                    accessibilitynodeinfocompat.addAction(16);
                    accessibilitynodeinfocompat.setClickable(true);
                }
                if (isLongClickable())
                {
                    accessibilitynodeinfocompat.addAction(32);
                    accessibilitynodeinfocompat.setLongClickable(true);
                    return;
                }
            }
            return;
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle)
        {
            if (super.performAccessibilityAction(view, i, bundle))
            {
                return true;
            }
            int j = getPositionForView(view);
            bundle = (ListAdapter)getAdapter();
            if (j == -1 || bundle == null)
            {
                return false;
            }
            if (!isEnabled() || !bundle.isEnabled(j))
            {
                return false;
            }
            long l = getItemIdAtPosition(j);
            switch (i)
            {
            default:
                return false;

            case 8: // '\b'
                if (getSelectedItemPosition() == j)
                {
                    setSelection(-1);
                    return true;
                } else
                {
                    return false;
                }

            case 4: // '\004'
                if (getSelectedItemPosition() != j)
                {
                    setSelection(j);
                    return true;
                } else
                {
                    return false;
                }

            case 16: // '\020'
                if (isClickable())
                {
                    return performItemClick(view, j, l);
                } else
                {
                    return false;
                }

            case 32: // ' '
                break;
            }
            if (isLongClickable())
            {
                return performLongPress(view, j, l);
            } else
            {
                return false;
            }
        }

        ListItemAccessibilityDelegate()
        {
            this$0 = AbsHListView.this;
            super();
        }
    }

    public static interface OnScrollListener
    {

        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        public abstract void onScroll(AbsHListView abshlistview, int i, int j, int k);

        public abstract void onScrollStateChanged(AbsHListView abshlistview, int i);
    }

    private class PerformClick extends WindowRunnnable
        implements Runnable
    {

        int mClickMotionPosition;
        final AbsHListView this$0;

        public void run()
        {
            if (!mDataChanged)
            {
                ListAdapter listadapter = mAdapter;
                int i = mClickMotionPosition;
                if (listadapter != null && mItemCount > 0 && i != -1 && i < listadapter.getCount() && sameWindow())
                {
                    View view = getChildAt(i - mFirstPosition);
                    if (view != null)
                    {
                        performItemClick(view, i, listadapter.getItemId(i));
                        return;
                    }
                }
            }
        }

        private PerformClick()
        {
            this$0 = AbsHListView.this;
            super();
        }

    }

    public class PositionScroller
        implements Runnable
    {

        private static final int MOVE_DOWN_BOUND = 3;
        private static final int MOVE_DOWN_POS = 1;
        private static final int MOVE_OFFSET = 5;
        private static final int MOVE_UP_BOUND = 4;
        private static final int MOVE_UP_POS = 2;
        private static final int SCROLL_DURATION = 200;
        private int mBoundPos;
        private final int mExtraScroll;
        private int mLastSeenPos;
        private int mMode;
        private int mOffsetFromLeft;
        private int mScrollDuration;
        private int mTargetPos;
        final AbsHListView this$0;

        public void run()
        {
            int i2;
            int j2;
            j2 = getWidth();
            i2 = mFirstPosition;
            mMode;
            JVM INSTR tableswitch 1 5: default 56
        //                       1 57
        //                       2 389
        //                       3 214
        //                       4 509
        //                       5 675;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            return;
_L2:
            int i = getChildCount() - 1;
            i2 += i;
            if (i >= 0)
            {
                if (i2 == mLastSeenPos)
                {
                    mViewHelper.postOnAnimation(this);
                    return;
                }
                View view = getChildAt(i);
                int k2 = view.getWidth();
                int k3 = view.getLeft();
                if (i2 < mItemCount - 1)
                {
                    i = Math.max(mListPadding.right, mExtraScroll);
                } else
                {
                    i = mListPadding.right;
                }
                smoothScrollBy((k2 - (j2 - k3)) + i, mScrollDuration, true);
                mLastSeenPos = i2;
                if (i2 < mTargetPos)
                {
                    mViewHelper.postOnAnimation(this);
                    return;
                }
            }
            continue; /* Loop/switch isn't completed */
_L4:
            int j = getChildCount();
            if (i2 != mBoundPos && j > 1 && i2 + j < mItemCount)
            {
                int k = i2 + 1;
                if (k == mLastSeenPos)
                {
                    mViewHelper.postOnAnimation(this);
                    return;
                }
                View view1 = getChildAt(1);
                i2 = view1.getWidth();
                j2 = view1.getLeft();
                int l2 = Math.max(mListPadding.right, mExtraScroll);
                if (k < mBoundPos)
                {
                    smoothScrollBy(Math.max(0, (i2 + j2) - l2), mScrollDuration, true);
                    mLastSeenPos = k;
                    mViewHelper.postOnAnimation(this);
                    return;
                }
                if (j2 > l2)
                {
                    smoothScrollBy(j2 - l2, mScrollDuration, true);
                    return;
                }
            }
            if (true) goto _L1; else goto _L3
_L3:
            if (i2 == mLastSeenPos)
            {
                mViewHelper.postOnAnimation(this);
                return;
            }
            View view2 = getChildAt(0);
            if (view2 != null)
            {
                j2 = view2.getLeft();
                int l;
                if (i2 > 0)
                {
                    l = Math.max(mExtraScroll, mListPadding.left);
                } else
                {
                    l = mListPadding.left;
                }
                smoothScrollBy(j2 - l, mScrollDuration, true);
                mLastSeenPos = i2;
                if (i2 > mTargetPos)
                {
                    mViewHelper.postOnAnimation(this);
                    return;
                }
            }
            if (true)
            {
                continue; /* Loop/switch isn't completed */
            }
_L5:
            int i3 = getChildCount() - 2;
            if (i3 >= 0)
            {
                int i1 = i2 + i3;
                if (i1 == mLastSeenPos)
                {
                    mViewHelper.postOnAnimation(this);
                    return;
                }
                View view3 = getChildAt(i3);
                i2 = view3.getWidth();
                i3 = view3.getLeft();
                int l3 = Math.max(mListPadding.left, mExtraScroll);
                mLastSeenPos = i1;
                if (i1 > mBoundPos)
                {
                    smoothScrollBy(-(j2 - i3 - l3), mScrollDuration, true);
                    mViewHelper.postOnAnimation(this);
                    return;
                }
                i1 = j2 - l3;
                i2 = i3 + i2;
                if (i1 > i2)
                {
                    smoothScrollBy(-(i1 - i2), mScrollDuration, true);
                    return;
                }
            }
            if (true) goto _L1; else goto _L6
_L6:
            int j1;
            int j3;
            int i4;
            if (mLastSeenPos == i2)
            {
                mViewHelper.postOnAnimation(this);
                return;
            }
            mLastSeenPos = i2;
            j2 = getChildCount();
            j3 = mTargetPos;
            i4 = (i2 + j2) - 1;
            j1 = 0;
            if (j3 >= i2) goto _L8; else goto _L7
_L7:
            j1 = (i2 - j3) + 1;
_L10:
            float f;
            f = Math.min(Math.abs((float)j1 / (float)j2), 1.0F);
            if (j3 < i2)
            {
                j1 = (int)((float)(-getWidth()) * f);
                i2 = (int)((float)mScrollDuration * f);
                smoothScrollBy(j1, i2, true);
                mViewHelper.postOnAnimation(this);
                return;
            }
            break; /* Loop/switch isn't completed */
_L8:
            if (j3 > i4)
            {
                j1 = j3 - i4;
            }
            if (true) goto _L10; else goto _L9
_L9:
            if (j3 > i4)
            {
                int k1 = (int)((float)getWidth() * f);
                i2 = (int)((float)mScrollDuration * f);
                smoothScrollBy(k1, i2, true);
                mViewHelper.postOnAnimation(this);
                return;
            } else
            {
                int l1 = getChildAt(j3 - i2).getLeft() - mOffsetFromLeft;
                i2 = (int)((float)mScrollDuration * ((float)Math.abs(l1) / (float)getWidth()));
                smoothScrollBy(l1, i2, true);
                return;
            }
        }

        void scrollToVisible(int i, int j, int k)
        {
            int l;
            int i1;
            int j1;
            int k1;
label0:
            {
                k1 = mFirstPosition;
                int l1 = (k1 + getChildCount()) - 1;
                i1 = mListPadding.left;
                j1 = getWidth() - mListPadding.right;
                if (i < k1 || i > l1)
                {
                    Log.w("AbsListView", (new StringBuilder()).append("scrollToVisible called with targetPos ").append(i).append(" not visible [").append(k1).append(", ").append(l1).append("]").toString());
                }
                if (j >= k1)
                {
                    l = j;
                    if (j <= l1)
                    {
                        break label0;
                    }
                }
                l = -1;
            }
            View view = getChildAt(i - k1);
            j = view.getLeft();
            int i2 = view.getRight();
            i = 0;
            if (i2 > j1)
            {
                i = i2 - j1;
            }
            if (j < i1)
            {
                i = j - i1;
            }
            if (i == 0)
            {
                return;
            }
            j = i;
            if (l < 0) goto _L2; else goto _L1
_L1:
            View view1 = getChildAt(l - k1);
            l = view1.getLeft();
            j = view1.getRight();
            k1 = Math.abs(i);
            if (i >= 0 || j + k1 <= j1) goto _L4; else goto _L3
_L3:
            j = Math.max(0, j - j1);
_L2:
            smoothScrollBy(j, k);
            return;
_L4:
            j = i;
            if (i > 0)
            {
                j = i;
                if (l - k1 < i1)
                {
                    j = Math.min(0, l - i1);
                }
            }
            if (true) goto _L2; else goto _L5
_L5:
        }

        void start(int i)
        {
            stop();
            if (mDataChanged)
            {
                mPositionScrollAfterLayout = i. new Runnable() {

                    final PositionScroller this$1;
                    final int val$position;

                    public void run()
                    {
                        start(position);
                    }

            
            {
                this$1 = final_positionscroller;
                position = I.this;
                super();
            }
                };
            } else
            {
                int j = getChildCount();
                if (j != 0)
                {
                    int k = mFirstPosition;
                    int l = (k + j) - 1;
                    j = Math.max(0, Math.min(getCount() - 1, i));
                    if (j < k)
                    {
                        i = (k - j) + 1;
                        mMode = 2;
                    } else
                    if (j > l)
                    {
                        i = (j - l) + 1;
                        mMode = 1;
                    } else
                    {
                        scrollToVisible(j, -1, 200);
                        return;
                    }
                    if (i > 0)
                    {
                        mScrollDuration = 200 / i;
                    } else
                    {
                        mScrollDuration = 200;
                    }
                    mTargetPos = j;
                    mBoundPos = -1;
                    mLastSeenPos = -1;
                    mViewHelper.postOnAnimation(this);
                    return;
                }
            }
        }

        void start(final int position, int i)
        {
            stop();
            if (i != -1) goto _L2; else goto _L1
_L1:
            start(position);
_L4:
            return;
_L2:
            int k;
            if (mDataChanged)
            {
                mPositionScrollAfterLayout = i. new Runnable() {

                    final PositionScroller this$1;
                    final int val$boundPosition;
                    final int val$position;

                    public void run()
                    {
                        start(position, boundPosition);
                    }

            
            {
                this$1 = final_positionscroller;
                position = i;
                boundPosition = I.this;
                super();
            }
                };
                return;
            }
            k = getChildCount();
            if (k == 0) goto _L4; else goto _L3
_L3:
            int j;
            int l;
            j = mFirstPosition;
            l = (j + k) - 1;
            k = Math.max(0, Math.min(getCount() - 1, position));
            if (k >= j) goto _L6; else goto _L5
_L5:
            l -= i;
            if (l < 1) goto _L4; else goto _L7
_L7:
            position = (j - k) + 1;
            j = l - 1;
            if (j < position)
            {
                position = j;
                mMode = 4;
            } else
            {
                mMode = 2;
            }
_L9:
            if (position > 0)
            {
                mScrollDuration = 200 / position;
            } else
            {
                mScrollDuration = 200;
            }
            mTargetPos = k;
            mBoundPos = i;
            mLastSeenPos = -1;
            mViewHelper.postOnAnimation(this);
            return;
_L6:
            if (k <= l)
            {
                break MISSING_BLOCK_LABEL_234;
            }
            j = i - j;
            if (j < 1) goto _L4; else goto _L8
_L8:
            position = (k - l) + 1;
            j--;
            if (j < position)
            {
                position = j;
                mMode = 3;
            } else
            {
                mMode = 1;
            }
              goto _L9
            scrollToVisible(k, i, 200);
            return;
        }

        void startWithOffset(int i, int j)
        {
            startWithOffset(i, j, 200);
        }

        void startWithOffset(final int position, final int postOffset, int i)
        {
            stop();
            if (mDataChanged)
            {
                mPositionScrollAfterLayout = i. new Runnable() {

                    final PositionScroller this$1;
                    final int val$duration;
                    final int val$position;
                    final int val$postOffset;

                    public void run()
                    {
                        startWithOffset(position, postOffset, duration);
                    }

            
            {
                this$1 = final_positionscroller;
                position = i;
                postOffset = j;
                duration = I.this;
                super();
            }
                };
            } else
            {
                int j = getChildCount();
                if (j != 0)
                {
                    postOffset += getPaddingLeft();
                    mTargetPos = Math.max(0, Math.min(getCount() - 1, position));
                    mOffsetFromLeft = postOffset;
                    mBoundPos = -1;
                    mLastSeenPos = -1;
                    mMode = 5;
                    position = mFirstPosition;
                    int k = (position + j) - 1;
                    float f;
                    if (mTargetPos < position)
                    {
                        position -= mTargetPos;
                    } else
                    if (mTargetPos > k)
                    {
                        position = mTargetPos - k;
                    } else
                    {
                        position = getChildAt(mTargetPos - position).getLeft();
                        smoothScrollBy(position - postOffset, i, false);
                        return;
                    }
                    f = (float)position / (float)j;
                    if (f >= 1.0F)
                    {
                        i = (int)((float)i / f);
                    }
                    mScrollDuration = i;
                    mLastSeenPos = -1;
                    mViewHelper.postOnAnimation(this);
                    return;
                }
            }
        }

        public void stop()
        {
            removeCallbacks(this);
        }

        PositionScroller()
        {
            this$0 = AbsHListView.this;
            super();
            mExtraScroll = ViewConfiguration.get(getContext()).getScaledFadingEdgeLength();
        }
    }

    public class RecycleBin
    {

        private View mActiveViews[];
        private ArrayList mCurrentScrap;
        private int mFirstActivePosition;
        private RecyclerListener mRecyclerListener;
        private ArrayList mScrapViews[];
        private ArrayList mSkippedScrap;
        private SparseArrayCompat mTransientStateViews;
        private int mViewTypeCount;
        final AbsHListView this$0;

        private void pruneScrapViews()
        {
            int j1 = mActiveViews.length;
            int k1 = mViewTypeCount;
            ArrayList aarraylist[] = mScrapViews;
            for (int i = 0; i < k1; i++)
            {
                ArrayList arraylist = aarraylist[i];
                int l1 = arraylist.size();
                int i1 = 0;
                for (int k = l1 - 1; i1 < l1 - j1; k--)
                {
                    removeDetachedView((View)arraylist.remove(k), false);
                    i1++;
                }

            }

            if (mTransientStateViews != null)
            {
                int l;
                for (int j = 0; j < mTransientStateViews.size(); j = l + 1)
                {
                    l = j;
                    if (!((View)mTransientStateViews.valueAt(j)).hasTransientState())
                    {
                        mTransientStateViews.removeAt(j);
                        l = j - 1;
                    }
                }

            }
        }

        public void addScrapView(View view, int i)
        {
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if (layoutparams != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            int j;
            layoutparams.scrappedFromPosition = i;
            j = layoutparams.viewType;
            boolean flag;
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                flag = view.hasTransientState();
            } else
            {
                flag = false;
            }
            if (shouldRecycleViewType(j) && !flag)
            {
                break; /* Loop/switch isn't completed */
            }
            if (j != -2 || flag)
            {
                if (mSkippedScrap == null)
                {
                    mSkippedScrap = new ArrayList();
                }
                mSkippedScrap.add(view);
            }
            if (flag)
            {
                if (mTransientStateViews == null)
                {
                    mTransientStateViews = new SparseArrayCompat();
                }
                view.onStartTemporaryDetach();
                mTransientStateViews.put(i, view);
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
            view.onStartTemporaryDetach();
            if (mViewTypeCount == 1)
            {
                mCurrentScrap.add(view);
            } else
            {
                mScrapViews[j].add(view);
            }
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                view.setAccessibilityDelegate(null);
            }
            if (mRecyclerListener != null)
            {
                mRecyclerListener.onMovedToScrapHeap(view);
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        public void clear()
        {
            if (mViewTypeCount == 1)
            {
                ArrayList arraylist = mCurrentScrap;
                int k = arraylist.size();
                for (int i = 0; i < k; i++)
                {
                    removeDetachedView((View)arraylist.remove(k - 1 - i), false);
                }

            } else
            {
                int i1 = mViewTypeCount;
                for (int j = 0; j < i1; j++)
                {
                    ArrayList arraylist1 = mScrapViews[j];
                    int j1 = arraylist1.size();
                    for (int l = 0; l < j1; l++)
                    {
                        removeDetachedView((View)arraylist1.remove(j1 - 1 - l), false);
                    }

                }

            }
            if (mTransientStateViews != null)
            {
                mTransientStateViews.clear();
            }
        }

        void clearTransientStateViews()
        {
            if (mTransientStateViews != null)
            {
                mTransientStateViews.clear();
            }
        }

        public void fillActiveViews(int i, int j)
        {
            if (mActiveViews.length < i)
            {
                mActiveViews = new View[i];
            }
            mFirstActivePosition = j;
            View aview[] = mActiveViews;
            for (j = 0; j < i; j++)
            {
                View view = getChildAt(j);
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                if (layoutparams != null && layoutparams.viewType != -2)
                {
                    aview[j] = view;
                }
            }

        }

        public View getActiveView(int i)
        {
            i -= mFirstActivePosition;
            View aview[] = mActiveViews;
            if (i >= 0 && i < aview.length)
            {
                View view = aview[i];
                aview[i] = null;
                return view;
            } else
            {
                return null;
            }
        }

        View getScrapView(int i)
        {
            if (mViewTypeCount == 1)
            {
                return AbsHListView.retrieveFromScrap(mCurrentScrap, i);
            }
            int j = mAdapter.getItemViewType(i);
            if (j >= 0 && j < mScrapViews.length)
            {
                return AbsHListView.retrieveFromScrap(mScrapViews[j], i);
            } else
            {
                return null;
            }
        }

        View getTransientStateView(int i)
        {
            if (mTransientStateViews != null)
            {
                if ((i = mTransientStateViews.indexOfKey(i)) >= 0)
                {
                    View view = (View)mTransientStateViews.valueAt(i);
                    mTransientStateViews.removeAt(i);
                    return view;
                }
            }
            return null;
        }

        public void markChildrenDirty()
        {
            if (mViewTypeCount == 1)
            {
                ArrayList arraylist = mCurrentScrap;
                int l = arraylist.size();
                for (int i = 0; i < l; i++)
                {
                    ((View)arraylist.get(i)).forceLayout();
                }

            } else
            {
                int k1 = mViewTypeCount;
                for (int j = 0; j < k1; j++)
                {
                    ArrayList arraylist1 = mScrapViews[j];
                    int l1 = arraylist1.size();
                    for (int i1 = 0; i1 < l1; i1++)
                    {
                        ((View)arraylist1.get(i1)).forceLayout();
                    }

                }

            }
            if (mTransientStateViews != null)
            {
                int j1 = mTransientStateViews.size();
                for (int k = 0; k < j1; k++)
                {
                    ((View)mTransientStateViews.valueAt(k)).forceLayout();
                }

            }
        }

        void reclaimScrapViews(List list)
        {
            if (mViewTypeCount == 1)
            {
                list.addAll(mCurrentScrap);
            } else
            {
                int j = mViewTypeCount;
                ArrayList aarraylist[] = mScrapViews;
                int i = 0;
                while (i < j) 
                {
                    list.addAll(aarraylist[i]);
                    i++;
                }
            }
        }

        public void removeSkippedScrap()
        {
            if (mSkippedScrap == null)
            {
                return;
            }
            int j = mSkippedScrap.size();
            for (int i = 0; i < j; i++)
            {
                removeDetachedView((View)mSkippedScrap.get(i), false);
            }

            mSkippedScrap.clear();
        }

        public void scrapActiveViews()
        {
            View aview[] = mActiveViews;
            Object obj;
            boolean flag;
            boolean flag1;
            int i;
            if (mRecyclerListener != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mViewTypeCount > 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            obj = mCurrentScrap;
            i = aview.length - 1;
            while (i >= 0) 
            {
                View view = aview[i];
                Object obj1 = obj;
                if (view != null)
                {
                    obj1 = (LayoutParams)view.getLayoutParams();
                    int j = ((LayoutParams) (obj1)).viewType;
                    aview[i] = null;
                    boolean flag2;
                    if (android.os.Build.VERSION.SDK_INT >= 16)
                    {
                        flag2 = view.hasTransientState();
                    } else
                    {
                        flag2 = false;
                    }
                    if (!shouldRecycleViewType(j) || flag2)
                    {
                        if (j != -2 || flag2)
                        {
                            removeDetachedView(view, false);
                        }
                        obj1 = obj;
                        if (flag2)
                        {
                            if (mTransientStateViews == null)
                            {
                                mTransientStateViews = new SparseArrayCompat();
                            }
                            mTransientStateViews.put(mFirstActivePosition + i, view);
                            obj1 = obj;
                        }
                    } else
                    {
                        if (flag1)
                        {
                            obj = mScrapViews[j];
                        }
                        view.onStartTemporaryDetach();
                        obj1.scrappedFromPosition = mFirstActivePosition + i;
                        ((ArrayList) (obj)).add(view);
                        if (android.os.Build.VERSION.SDK_INT >= 14)
                        {
                            view.setAccessibilityDelegate(null);
                        }
                        obj1 = obj;
                        if (flag)
                        {
                            mRecyclerListener.onMovedToScrapHeap(view);
                            obj1 = obj;
                        }
                    }
                }
                i--;
                obj = obj1;
            }
            pruneScrapViews();
        }

        void setCacheColorHint(int i)
        {
            if (mViewTypeCount == 1)
            {
                ArrayList arraylist = mCurrentScrap;
                int i1 = arraylist.size();
                for (int j = 0; j < i1; j++)
                {
                    ((View)arraylist.get(j)).setDrawingCacheBackgroundColor(i);
                }

            } else
            {
                int l1 = mViewTypeCount;
                for (int k = 0; k < l1; k++)
                {
                    ArrayList arraylist1 = mScrapViews[k];
                    int i2 = arraylist1.size();
                    for (int j1 = 0; j1 < i2; j1++)
                    {
                        ((View)arraylist1.get(j1)).setDrawingCacheBackgroundColor(i);
                    }

                }

            }
            View aview[] = mActiveViews;
            int k1 = aview.length;
            for (int l = 0; l < k1; l++)
            {
                View view = aview[l];
                if (view != null)
                {
                    view.setDrawingCacheBackgroundColor(i);
                }
            }

        }

        public void setViewTypeCount(int i)
        {
            if (i < 1)
            {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList aarraylist[] = new ArrayList[i];
            for (int j = 0; j < i; j++)
            {
                aarraylist[j] = new ArrayList();
            }

            mViewTypeCount = i;
            mCurrentScrap = aarraylist[0];
            mScrapViews = aarraylist;
        }

        public boolean shouldRecycleViewType(int i)
        {
            return i >= 0;
        }



/*
        static RecyclerListener access$2202(RecycleBin recyclebin, RecyclerListener recyclerlistener)
        {
            recyclebin.mRecyclerListener = recyclerlistener;
            return recyclerlistener;
        }

*/

        public RecycleBin()
        {
            this$0 = AbsHListView.this;
            super();
            mActiveViews = new View[0];
        }
    }

    public static interface RecyclerListener
    {

        public abstract void onMovedToScrapHeap(View view);
    }

    static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        LongSparseArray checkIdState;
        SparseArrayCompat checkState;
        int checkedItemCount;
        String filter;
        long firstId;
        boolean inActionMode;
        int position;
        long selectedId;
        int viewLeft;
        int width;

        private SparseArrayCompat readSparseBooleanArray(Parcel parcel)
        {
            int i = parcel.readInt();
            if (i < 0)
            {
                return null;
            } else
            {
                SparseArrayCompat sparsearraycompat = new SparseArrayCompat(i);
                readSparseBooleanArrayInternal(sparsearraycompat, parcel, i);
                return sparsearraycompat;
            }
        }

        private void readSparseBooleanArrayInternal(SparseArrayCompat sparsearraycompat, Parcel parcel, int i)
        {
            while (i > 0) 
            {
                int j = parcel.readInt();
                boolean flag;
                if (parcel.readByte() == 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                sparsearraycompat.append(j, Boolean.valueOf(flag));
                i--;
            }
        }

        private LongSparseArray readSparseLongArray(Parcel parcel)
        {
            int i = parcel.readInt();
            if (i <= 0)
            {
                return null;
            } else
            {
                LongSparseArray longsparsearray = new LongSparseArray(i);
                readSparseLongArrayInternal(longsparsearray, parcel, i);
                return longsparsearray;
            }
        }

        private void readSparseLongArrayInternal(LongSparseArray longsparsearray, Parcel parcel, int i)
        {
            for (; i > 0; i--)
            {
                longsparsearray.put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
            }

        }

        private void writeSparseBooleanArray(SparseArrayCompat sparsearraycompat, Parcel parcel)
        {
            if (sparsearraycompat == null)
            {
                parcel.writeInt(-1);
            } else
            {
                int k = sparsearraycompat.size();
                parcel.writeInt(k);
                int i = 0;
                while (i < k) 
                {
                    parcel.writeInt(sparsearraycompat.keyAt(i));
                    int j;
                    if (((Boolean)sparsearraycompat.valueAt(i)).booleanValue())
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    parcel.writeByte((byte)j);
                    i++;
                }
            }
        }

        private void writeSparseLongArray(LongSparseArray longsparsearray, Parcel parcel)
        {
            int i;
            if (longsparsearray != null)
            {
                i = longsparsearray.size();
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            for (int j = 0; j < i; j++)
            {
                parcel.writeLong(longsparsearray.keyAt(j));
                parcel.writeInt(((Integer)longsparsearray.valueAt(j)).intValue());
            }

        }

        public String toString()
        {
            return (new StringBuilder()).append("AbsListView.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" selectedId=").append(selectedId).append(" firstId=").append(firstId).append(" viewLeft=").append(viewLeft).append(" position=").append(position).append(" width=").append(width).append(" filter=").append(filter).append(" checkState=").append(checkState).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeLong(selectedId);
            parcel.writeLong(firstId);
            parcel.writeInt(viewLeft);
            parcel.writeInt(position);
            parcel.writeInt(width);
            parcel.writeString(filter);
            if (inActionMode)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeByte((byte)i);
            parcel.writeInt(checkedItemCount);
            writeSparseBooleanArray(checkState, parcel);
            writeSparseLongArray(checkIdState, parcel);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            selectedId = parcel.readLong();
            firstId = parcel.readLong();
            viewLeft = parcel.readInt();
            position = parcel.readInt();
            width = parcel.readInt();
            filter = parcel.readString();
            boolean flag;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            inActionMode = flag;
            checkedItemCount = parcel.readInt();
            checkState = readSparseBooleanArray(parcel);
            checkIdState = readSparseLongArray(parcel);
        }


        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    public static interface SelectionBoundsAdjuster
    {

        public abstract void adjustListItemSelectionBounds(Rect rect);
    }

    private class WindowRunnnable
    {

        private int mOriginalAttachCount;
        final AbsHListView this$0;

        public void rememberWindowAttachCount()
        {
            mOriginalAttachCount = getWindowAttachCount();
        }

        public boolean sameWindow()
        {
            return hasWindowFocus() && getWindowAttachCount() == mOriginalAttachCount;
        }

        private WindowRunnnable()
        {
            this$0 = AbsHListView.this;
            super();
        }

    }


    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    private static final int INVALID_POINTER = -1;
    public static final int LAYOUT_FORCE_LEFT = 1;
    public static final int LAYOUT_FORCE_RIGHT = 3;
    public static final int LAYOUT_MOVE_SELECTION = 6;
    public static final int LAYOUT_NORMAL = 0;
    public static final int LAYOUT_SET_SELECTION = 2;
    public static final int LAYOUT_SPECIFIC = 4;
    public static final int LAYOUT_SYNC = 5;
    protected static final int OVERSCROLL_LIMIT_DIVISOR = 3;
    public static final int STATESET_NOTHING[] = {
        0
    };
    private static final String TAG = "AbsListView";
    public static final int TOUCH_MODE_DONE_WAITING = 2;
    public static final int TOUCH_MODE_DOWN = 0;
    public static final int TOUCH_MODE_FLING = 4;
    private static final int TOUCH_MODE_OFF = 1;
    private static final int TOUCH_MODE_ON = 0;
    public static final int TOUCH_MODE_OVERFLING = 6;
    public static final int TOUCH_MODE_OVERSCROLL = 5;
    public static final int TOUCH_MODE_REST = -1;
    public static final int TOUCH_MODE_SCROLL = 3;
    public static final int TOUCH_MODE_TAP = 1;
    private static final int TOUCH_MODE_UNKNOWN = -1;
    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    static final Interpolator sLinearInterpolator = new LinearInterpolator();
    private ListItemAccessibilityDelegate mAccessibilityDelegate;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    boolean mAdapterHasStableIds;
    private int mCacheColorHint;
    protected boolean mCachingActive;
    protected boolean mCachingStarted;
    protected SparseArrayCompat mCheckStates;
    LongSparseArray mCheckedIdStates;
    int mCheckedItemCount;
    public Object mChoiceActionMode;
    protected int mChoiceMode;
    private Runnable mClearScrollingCache;
    private android.view.ContextMenu.ContextMenuInfo mContextMenuInfo;
    protected AdapterDataSetObserver mDataSetObserver;
    private int mDirection;
    boolean mDrawSelectorOnTop;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    boolean mFastScrollEnabled;
    private int mFirstPositionDistanceGuess;
    private FlingRunnable mFlingRunnable;
    private boolean mForceTranscriptScroll;
    private int mGlowPaddingBottom;
    private int mGlowPaddingTop;
    protected int mHeightMeasureSpec;
    private float mHorizontalScrollFactor;
    protected boolean mIsAttached;
    private boolean mIsChildViewEnabled;
    protected final boolean mIsScrap[];
    private int mLastAccessibilityScrollEventFromIndex;
    private int mLastAccessibilityScrollEventToIndex;
    private int mLastHandledItemCount;
    private int mLastPositionDistanceGuess;
    private int mLastScrollState;
    private int mLastTouchMode;
    int mLastX;
    protected int mLayoutMode;
    protected Rect mListPadding;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    int mMotionCorrection;
    protected int mMotionPosition;
    int mMotionViewNewLeft;
    int mMotionViewOriginalLeft;
    int mMotionX;
    int mMotionY;
    Object mMultiChoiceModeCallback;
    private OnScrollListener mOnScrollListener;
    int mOverflingDistance;
    int mOverscrollDistance;
    protected int mOverscrollMax;
    private CheckForKeyLongPress mPendingCheckForKeyLongPress;
    private CheckForLongPress mPendingCheckForLongPress;
    private Runnable mPendingCheckForTap;
    private SavedState mPendingSync;
    private PerformClick mPerformClick;
    protected Runnable mPositionScrollAfterLayout;
    protected PositionScroller mPositionScroller;
    protected final RecycleBin mRecycler;
    protected int mResurrectToPosition;
    View mScrollLeft;
    View mScrollRight;
    boolean mScrollingCacheEnabled;
    protected int mSelectedLeft;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    Drawable mSelector;
    int mSelectorPosition;
    protected Rect mSelectorRect;
    private boolean mSmoothScrollbarEnabled;
    protected boolean mStackFromRight;
    private Rect mTouchFrame;
    protected int mTouchMode;
    private Runnable mTouchModeReset;
    private int mTouchSlop;
    private int mTranscriptMode;
    private float mVelocityScale;
    private VelocityTracker mVelocityTracker;
    it.sephiroth.android.library.util.ViewHelperFactory.ViewHelper mViewHelper;

    public AbsHListView(Context context)
    {
        super(context);
        mChoiceMode = 0;
        mLayoutMode = 0;
        mDrawSelectorOnTop = false;
        mSelectorPosition = -1;
        mSelectorRect = new Rect();
        mRecycler = new RecycleBin();
        mSelectionLeftPadding = 0;
        mSelectionTopPadding = 0;
        mSelectionRightPadding = 0;
        mSelectionBottomPadding = 0;
        mListPadding = new Rect();
        mHeightMeasureSpec = 0;
        mTouchMode = -1;
        mSelectedLeft = 0;
        mSmoothScrollbarEnabled = true;
        mResurrectToPosition = -1;
        mContextMenuInfo = null;
        mLastTouchMode = -1;
        mLastScrollState = 0;
        mVelocityScale = 1.0F;
        mIsScrap = new boolean[1];
        mActivePointerId = -1;
        mDirection = 0;
        initAbsListView();
    }

    public AbsHListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, it.sephiroth.android.library.R.attr.hlv_absHListViewStyle);
    }

    public AbsHListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mChoiceMode = 0;
        mLayoutMode = 0;
        mDrawSelectorOnTop = false;
        mSelectorPosition = -1;
        mSelectorRect = new Rect();
        mRecycler = new RecycleBin();
        mSelectionLeftPadding = 0;
        mSelectionTopPadding = 0;
        mSelectionRightPadding = 0;
        mSelectionBottomPadding = 0;
        mListPadding = new Rect();
        mHeightMeasureSpec = 0;
        mTouchMode = -1;
        mSelectedLeft = 0;
        mSmoothScrollbarEnabled = true;
        mResurrectToPosition = -1;
        mContextMenuInfo = null;
        mLastTouchMode = -1;
        mLastScrollState = 0;
        mVelocityScale = 1.0F;
        mIsScrap = new boolean[1];
        mActivePointerId = -1;
        mDirection = 0;
        initAbsListView();
        attributeset = context.getTheme().obtainStyledAttributes(attributeset, it.sephiroth.android.library.R.styleable.AbsHListView, i, 0);
        context = null;
        boolean flag = false;
        boolean flag3 = false;
        boolean flag1 = true;
        int k = 0;
        int j = 0;
        boolean flag2 = true;
        i = 0;
        if (attributeset != null)
        {
            context = attributeset.getDrawable(0);
            flag = attributeset.getBoolean(1, false);
            flag3 = attributeset.getBoolean(6, false);
            flag1 = attributeset.getBoolean(2, true);
            k = attributeset.getInt(7, 0);
            j = attributeset.getColor(3, 0);
            flag2 = attributeset.getBoolean(5, true);
            i = attributeset.getInt(4, 0);
            attributeset.recycle();
        }
        if (context != null)
        {
            setSelector(context);
        }
        mDrawSelectorOnTop = flag;
        setStackFromRight(flag3);
        setScrollingCacheEnabled(flag1);
        setTranscriptMode(k);
        setCacheColorHint(j);
        setSmoothScrollbarEnabled(flag2);
        setChoiceMode(i);
    }

    private void clearScrollingCache()
    {
        if (!mViewHelper.isHardwareAccelerated())
        {
            if (mClearScrollingCache == null)
            {
                mClearScrollingCache = new Runnable() {

                    final AbsHListView this$0;

                    public void run()
                    {
                        if (mCachingStarted)
                        {
                            AbsHListView abshlistview = AbsHListView.this;
                            mCachingActive = false;
                            abshlistview.mCachingStarted = false;
                            setChildrenDrawnWithCacheEnabled(false);
                            if ((getPersistentDrawingCache() & 2) == 0)
                            {
                                setChildrenDrawingCacheEnabled(false);
                            }
                            if (!isAlwaysDrawnWithCacheEnabled())
                            {
                                invalidate();
                            }
                        }
                    }

            
            {
                this$0 = AbsHListView.this;
                super();
            }
                };
            }
            post(mClearScrollingCache);
        }
    }

    private boolean contentFits()
    {
        int i = getChildCount();
        if (i != 0)
        {
            if (i != mItemCount)
            {
                return false;
            }
            if (getChildAt(0).getLeft() < mListPadding.left || getChildAt(i - 1).getRight() > getWidth() - mListPadding.right)
            {
                return false;
            }
        }
        return true;
    }

    private void createScrollingCache()
    {
        if (mScrollingCacheEnabled && !mCachingStarted && !mViewHelper.isHardwareAccelerated())
        {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            mCachingActive = true;
            mCachingStarted = true;
        }
    }

    private void drawSelector(Canvas canvas)
    {
        if (!mSelectorRect.isEmpty())
        {
            Drawable drawable = mSelector;
            drawable.setBounds(mSelectorRect);
            drawable.draw(canvas);
        }
    }

    private void finishGlows()
    {
        if (mEdgeGlowTop != null)
        {
            mEdgeGlowTop.finish();
            mEdgeGlowBottom.finish();
        }
    }

    public static int getDistance(Rect rect, Rect rect1, int i)
    {
        i;
        JVM INSTR lookupswitch 6: default 60
    //                   1: 242
    //                   2: 242
    //                   17: 164
    //                   33: 203
    //                   66: 71
    //                   130: 125;
           goto _L1 _L2 _L2 _L3 _L4 _L5 _L6
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
_L5:
        int j;
        int k;
        int l;
        k = rect.right;
        l = rect.top + rect.height() / 2;
        i = rect1.left;
        j = rect1.top + rect1.height() / 2;
_L8:
        i -= k;
        j -= l;
        return j * j + i * i;
_L6:
        k = rect.left + rect.width() / 2;
        l = rect.bottom;
        i = rect1.left + rect1.width() / 2;
        j = rect1.top;
        continue; /* Loop/switch isn't completed */
_L3:
        k = rect.left;
        l = rect.top + rect.height() / 2;
        i = rect1.right;
        j = rect1.top + rect1.height() / 2;
        continue; /* Loop/switch isn't completed */
_L4:
        k = rect.left + rect.width() / 2;
        l = rect.top;
        i = rect1.left + rect1.width() / 2;
        j = rect1.bottom;
        continue; /* Loop/switch isn't completed */
_L2:
        k = rect.right + rect.width() / 2;
        l = rect.top + rect.height() / 2;
        i = rect1.left + rect1.width() / 2;
        j = rect1.top + rect1.height() / 2;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void initAbsListView()
    {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(getContext());
        mTouchSlop = viewconfiguration.getScaledTouchSlop();
        mMinimumVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        mOverscrollDistance = viewconfiguration.getScaledOverscrollDistance();
        mOverflingDistance = viewconfiguration.getScaledOverflingDistance();
        mViewHelper = ViewHelperFactory.create(this);
    }

    private void initOrResetVelocityTracker()
    {
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
            return;
        } else
        {
            mVelocityTracker.clear();
            return;
        }
    }

    private void initVelocityTrackerIfNotExists()
    {
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionevent)
    {
        int i = (motionevent.getAction() & 0xff00) >> 8;
        if (motionevent.getPointerId(i) == mActivePointerId)
        {
            if (i == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            mMotionX = (int)motionevent.getX(i);
            mMotionY = (int)motionevent.getY(i);
            mMotionCorrection = 0;
            mActivePointerId = motionevent.getPointerId(i);
        }
    }

    private void positionSelector(int i, int j, int k, int l)
    {
        mSelectorRect.set(i - mSelectionLeftPadding, j - mSelectionTopPadding, mSelectionRightPadding + k, mSelectionBottomPadding + l);
    }

    private void recycleVelocityTracker()
    {
        if (mVelocityTracker != null)
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    static View retrieveFromScrap(ArrayList arraylist, int i)
    {
        int k = arraylist.size();
        if (k > 0)
        {
            for (int j = 0; j < k; j++)
            {
                View view = (View)arraylist.get(j);
                if (((LayoutParams)view.getLayoutParams()).scrappedFromPosition == i)
                {
                    arraylist.remove(j);
                    return view;
                }
            }

            return (View)arraylist.remove(k - 1);
        } else
        {
            return null;
        }
    }

    private void scrollIfNeeded(int i)
    {
        int j2 = i - mMotionX;
        int k1 = j2 - mMotionCorrection;
        int j;
        if (mLastX != 0x80000000)
        {
            j = i - mLastX;
        } else
        {
            j = k1;
        }
        if (mTouchMode == 3)
        {
            if (i != mLastX)
            {
                if (Math.abs(j2) > mTouchSlop)
                {
                    ViewParent viewparent = getParent();
                    if (viewparent != null)
                    {
                        viewparent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                View view;
                int k;
                int i1;
                boolean flag1;
                if (mMotionPosition >= 0)
                {
                    k = mMotionPosition - mFirstPosition;
                } else
                {
                    k = getChildCount() / 2;
                }
                i1 = 0;
                view = getChildAt(k);
                if (view != null)
                {
                    i1 = view.getLeft();
                }
                flag1 = false;
                if (j != 0)
                {
                    flag1 = trackMotionScroll(k1, j);
                }
                view = getChildAt(k);
                if (view != null)
                {
                    k = view.getLeft();
                    if (flag1)
                    {
                        j = -j - (k - i1);
                        overScrollBy(j, 0, getScrollX(), 0, 0, 0, mOverscrollDistance, 0, true);
                        if (Math.abs(mOverscrollDistance) == Math.abs(getScrollX()) && mVelocityTracker != null)
                        {
                            mVelocityTracker.clear();
                        }
                        k = getOverScrollMode();
                        if (k == 0 || k == 1 && !contentFits())
                        {
                            mDirection = 0;
                            mTouchMode = 5;
                            if (j2 > 0)
                            {
                                mEdgeGlowTop.onPull((float)j / (float)getWidth());
                                if (!mEdgeGlowBottom.isFinished())
                                {
                                    mEdgeGlowBottom.onRelease();
                                }
                                invalidate(mEdgeGlowTop.getBounds(false));
                            } else
                            if (j2 < 0)
                            {
                                mEdgeGlowBottom.onPull((float)j / (float)getWidth());
                                if (!mEdgeGlowTop.isFinished())
                                {
                                    mEdgeGlowTop.onRelease();
                                }
                                invalidate(mEdgeGlowBottom.getBounds(true));
                            }
                        }
                    }
                    mMotionX = i;
                }
                mLastX = i;
            }
        } else
        if (mTouchMode == 5 && i != mLastX)
        {
            int l1 = getScrollX();
            int k2 = l1 - j;
            int l;
            int j1;
            if (i > mLastX)
            {
                l = 1;
            } else
            {
                l = -1;
            }
            if (mDirection == 0)
            {
                mDirection = l;
            }
            j1 = -j;
            if (k2 < 0 && l1 >= 0 || k2 > 0 && l1 <= 0)
            {
                l1 = -l1;
                j1 = j + l1;
                j = l1;
            } else
            {
                boolean flag = false;
                j = j1;
                j1 = ((flag) ? 1 : 0);
            }
            if (j != 0)
            {
                overScrollBy(j, 0, getScrollX(), 0, 0, 0, mOverscrollDistance, 0, true);
                int i2 = getOverScrollMode();
                View view1;
                if (i2 == 0 || i2 == 1 && !contentFits())
                {
                    if (j2 > 0)
                    {
                        mEdgeGlowTop.onPull((float)j / (float)getWidth());
                        if (!mEdgeGlowBottom.isFinished())
                        {
                            mEdgeGlowBottom.onRelease();
                        }
                        invalidate(mEdgeGlowTop.getBounds(false));
                    } else
                    if (j2 < 0)
                    {
                        mEdgeGlowBottom.onPull((float)j / (float)getWidth());
                        if (!mEdgeGlowTop.isFinished())
                        {
                            mEdgeGlowTop.onRelease();
                        }
                        invalidate(mEdgeGlowBottom.getBounds(true));
                    }
                }
            }
            if (j1 != 0)
            {
                if (getScrollX() != 0)
                {
                    mViewHelper.setScrollX(0);
                    invalidateParentIfNeeded();
                }
                trackMotionScroll(j1, j1);
                mTouchMode = 3;
                j1 = findClosestMotionCol(i);
                mMotionCorrection = 0;
                view1 = getChildAt(j1 - mFirstPosition);
                if (view1 != null)
                {
                    j = view1.getLeft();
                } else
                {
                    j = 0;
                }
                mMotionViewOriginalLeft = j;
                mMotionX = i;
                mMotionPosition = j1;
            }
            mLastX = i;
            mDirection = l;
            return;
        }
    }

    private boolean startScrollIfNeeded(int i)
    {
        int k = i - mMotionX;
        int l = Math.abs(k);
        boolean flag;
        if (getScrollX() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || l > mTouchSlop)
        {
            createScrollingCache();
            Object obj;
            if (flag)
            {
                mTouchMode = 5;
                mMotionCorrection = 0;
            } else
            {
                mTouchMode = 3;
                int j;
                if (k > 0)
                {
                    j = mTouchSlop;
                } else
                {
                    j = -mTouchSlop;
                }
                mMotionCorrection = j;
            }
            obj = getHandler();
            if (obj != null)
            {
                ((Handler) (obj)).removeCallbacks(mPendingCheckForLongPress);
            }
            setPressed(false);
            obj = getChildAt(mMotionPosition - mFirstPosition);
            if (obj != null)
            {
                ((View) (obj)).setPressed(false);
            }
            reportScrollStateChange(1);
            obj = getParent();
            if (obj != null)
            {
                ((ViewParent) (obj)).requestDisallowInterceptTouchEvent(true);
            }
            scrollIfNeeded(i);
            return true;
        } else
        {
            return false;
        }
    }

    private void updateOnScreenCheckedViews()
    {
        int j = mFirstPosition;
        int k = getChildCount();
        boolean flag;
        int i;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = 0;
        while (i < k) 
        {
            View view = getChildAt(i);
            int l = j + i;
            if (view instanceof Checkable)
            {
                ((Checkable)view).setChecked(((Boolean)mCheckStates.get(l, Boolean.valueOf(false))).booleanValue());
            } else
            if (flag)
            {
                view.setActivated(((Boolean)mCheckStates.get(l, Boolean.valueOf(false))).booleanValue());
            }
            i++;
        }
    }

    private void useDefaultSelector()
    {
        setSelector(getResources().getDrawable(0x1080062));
    }

    public void addTouchables(ArrayList arraylist)
    {
        int j = getChildCount();
        int k = mFirstPosition;
        ListAdapter listadapter = mAdapter;
        if (listadapter != null)
        {
            int i = 0;
            while (i < j) 
            {
                View view = getChildAt(i);
                if (listadapter.isEnabled(k + i))
                {
                    arraylist.add(view);
                }
                view.addTouchables(arraylist);
                i++;
            }
        }
    }

    public boolean checkInputConnectionProxy(View view)
    {
        return false;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof LayoutParams;
    }

    public void clearChoices()
    {
        if (mCheckStates != null)
        {
            mCheckStates.clear();
        }
        if (mCheckedIdStates != null)
        {
            mCheckedIdStates.clear();
        }
        mCheckedItemCount = 0;
    }

    protected int computeHorizontalScrollExtent()
    {
        int k = getChildCount();
        if (k > 0)
        {
            if (mSmoothScrollbarEnabled)
            {
                int j = k * 100;
                View view = getChildAt(0);
                int l = view.getLeft();
                int i1 = view.getWidth();
                int i = j;
                if (i1 > 0)
                {
                    i = j + (l * 100) / i1;
                }
                view = getChildAt(k - 1);
                k = view.getRight();
                l = view.getWidth();
                j = i;
                if (l > 0)
                {
                    j = i - ((k - getWidth()) * 100) / l;
                }
                return j;
            } else
            {
                return 1;
            }
        } else
        {
            return 0;
        }
    }

    protected int computeHorizontalScrollOffset()
    {
        int l;
        int i1;
label0:
        {
            boolean flag = false;
            l = mFirstPosition;
            i1 = getChildCount();
            int i = ((flag) ? 1 : 0);
            if (l >= 0)
            {
                i = ((flag) ? 1 : 0);
                if (i1 > 0)
                {
                    if (!mSmoothScrollbarEnabled)
                    {
                        break label0;
                    }
                    View view = getChildAt(0);
                    i1 = view.getLeft();
                    int j1 = view.getWidth();
                    i = ((flag) ? 1 : 0);
                    if (j1 > 0)
                    {
                        i = Math.max((l * 100 - (i1 * 100) / j1) + (int)(((float)getScrollX() / (float)getWidth()) * (float)mItemCount * 100F), 0);
                    }
                }
            }
            return i;
        }
        int k = mItemCount;
        int j;
        if (l == 0)
        {
            j = 0;
        } else
        if (l + i1 == k)
        {
            j = k;
        } else
        {
            j = l + i1 / 2;
        }
        return (int)((float)l + (float)i1 * ((float)j / (float)k));
    }

    protected int computeHorizontalScrollRange()
    {
        if (mSmoothScrollbarEnabled)
        {
            int j = Math.max(mItemCount * 100, 0);
            int i = j;
            if (getScrollX() != 0)
            {
                i = j + Math.abs((int)(((float)getScrollX() / (float)getWidth()) * (float)mItemCount * 100F));
            }
            return i;
        } else
        {
            return mItemCount;
        }
    }

    void confirmCheckedPositionsById()
    {
        int i;
        boolean flag;
        mCheckStates.clear();
        flag = false;
        i = 0;
_L8:
        int j;
        boolean flag3;
        int k;
        int l;
        long l1;
        if (i >= mCheckedIdStates.size())
        {
            break MISSING_BLOCK_LABEL_280;
        }
        l1 = mCheckedIdStates.keyAt(i);
        k = ((Integer)mCheckedIdStates.valueAt(i)).intValue();
        if (l1 == mAdapter.getItemId(k))
        {
            break MISSING_BLOCK_LABEL_261;
        }
        j = Math.max(0, k - 20);
        l = Math.min(k + 20, mItemCount);
        flag3 = false;
_L5:
        boolean flag1 = flag3;
        if (j >= l) goto _L2; else goto _L1
_L1:
        if (l1 != mAdapter.getItemId(j)) goto _L4; else goto _L3
_L3:
        flag1 = true;
        mCheckStates.put(j, Boolean.valueOf(true));
        mCheckedIdStates.setValueAt(i, Integer.valueOf(j));
_L2:
        j = i;
        if (!flag1)
        {
            mCheckedIdStates.delete(l1);
            i--;
            mCheckedItemCount = mCheckedItemCount - 1;
            boolean flag2 = true;
            flag = flag2;
            j = i;
            if (android.os.Build.VERSION.SDK_INT > 11)
            {
                flag = flag2;
                j = i;
                if (mChoiceActionMode != null)
                {
                    flag = flag2;
                    j = i;
                    if (mMultiChoiceModeCallback != null)
                    {
                        ((MultiChoiceModeWrapper)mMultiChoiceModeCallback).onItemCheckedStateChanged((ActionMode)mChoiceActionMode, k, l1, false);
                        j = i;
                        flag = flag2;
                    }
                }
            }
        }
_L6:
        i = j + 1;
        continue; /* Loop/switch isn't completed */
_L4:
        j++;
          goto _L5
        mCheckStates.put(k, Boolean.valueOf(true));
        j = i;
          goto _L6
        if (flag && mChoiceActionMode != null && android.os.Build.VERSION.SDK_INT > 11)
        {
            ((ActionMode)mChoiceActionMode).invalidate();
        }
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    android.view.ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long l)
    {
        return new AdapterView.AdapterContextMenuInfo(view, i, l);
    }

    protected void dispatchDraw(Canvas canvas)
    {
        boolean flag = mDrawSelectorOnTop;
        if (!flag)
        {
            drawSelector(canvas);
        }
        super.dispatchDraw(canvas);
        if (flag)
        {
            drawSelector(canvas);
        }
    }

    protected void dispatchSetPressed(boolean flag)
    {
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (mEdgeGlowTop != null)
        {
            int i = getScrollX();
            if (!mEdgeGlowTop.isFinished())
            {
                int j = canvas.save();
                int l = mListPadding.top + mGlowPaddingTop;
                int j1 = mListPadding.bottom;
                int l1 = mGlowPaddingBottom;
                j1 = getHeight() - l - (j1 + l1);
                l1 = Math.min(0, mFirstPositionDistanceGuess + i);
                canvas.rotate(-90F);
                canvas.translate(-getHeight() + l, l1);
                mEdgeGlowTop.setSize(j1, j1);
                if (mEdgeGlowTop.draw(canvas))
                {
                    mEdgeGlowTop.setPosition(l1, l);
                    invalidate();
                }
                canvas.restoreToCount(j);
            }
            if (!mEdgeGlowBottom.isFinished())
            {
                int k = canvas.save();
                int i1 = mListPadding.left + mGlowPaddingTop;
                int k1 = mListPadding.right;
                int i2 = mGlowPaddingBottom;
                k1 = getHeight() - i1 - (k1 + i2);
                i = Math.max(getWidth(), mLastPositionDistanceGuess + i);
                canvas.rotate(90F);
                canvas.translate(-i1, -i);
                mEdgeGlowBottom.setSize(k1, k1);
                if (mEdgeGlowBottom.draw(canvas))
                {
                    invalidate();
                }
                canvas.restoreToCount(k);
            }
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        updateSelectorState();
    }

    protected abstract void fillGap(boolean flag);

    protected int findClosestMotionCol(int i)
    {
        int k = getChildCount();
        if (k == 0)
        {
            i = -1;
        } else
        {
            int j = findMotionCol(i);
            i = j;
            if (j == -1)
            {
                return (mFirstPosition + k) - 1;
            }
        }
        return i;
    }

    protected abstract int findMotionCol(int i);

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams(-2, -1, 0);
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

    public int getCacheColorHint()
    {
        return mCacheColorHint;
    }

    public int getCheckedItemCount()
    {
        return mCheckedItemCount;
    }

    public long[] getCheckedItemIds()
    {
        if (mChoiceMode != 0 && mCheckedIdStates != null && mAdapter != null) goto _L2; else goto _L1
_L1:
        long al[] = new long[0];
_L4:
        return al;
_L2:
        LongSparseArray longsparsearray = mCheckedIdStates;
        int j = longsparsearray.size();
        long al1[] = new long[j];
        int i = 0;
        do
        {
            al = al1;
            if (i >= j)
            {
                continue;
            }
            al1[i] = longsparsearray.keyAt(i);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int getCheckedItemPosition()
    {
        if (mChoiceMode == 1 && mCheckStates != null && mCheckStates.size() == 1)
        {
            return mCheckStates.keyAt(0);
        } else
        {
            return -1;
        }
    }

    public SparseArrayCompat getCheckedItemPositions()
    {
        if (mChoiceMode != 0)
        {
            return mCheckStates;
        } else
        {
            return null;
        }
    }

    public int getChoiceMode()
    {
        return mChoiceMode;
    }

    protected android.view.ContextMenu.ContextMenuInfo getContextMenuInfo()
    {
        return mContextMenuInfo;
    }

    public void getFocusedRect(Rect rect)
    {
        View view = getSelectedView();
        if (view != null && view.getParent() == this)
        {
            view.getFocusedRect(rect);
            offsetDescendantRectToMyCoords(view, rect);
            return;
        } else
        {
            super.getFocusedRect(rect);
            return;
        }
    }

    protected int getFooterViewsCount()
    {
        return 0;
    }

    protected int getHeaderViewsCount()
    {
        return 0;
    }

    protected float getHorizontalScrollFactor()
    {
label0:
        {
            if (mHorizontalScrollFactor == 0.0F)
            {
                TypedValue typedvalue = new TypedValue();
                if (!getContext().getTheme().resolveAttribute(it.sephiroth.android.library.R.attr.hlv_listPreferredItemWidth, typedvalue, true))
                {
                    break label0;
                }
                mHorizontalScrollFactor = typedvalue.getDimension(getContext().getResources().getDisplayMetrics());
            }
            return mHorizontalScrollFactor;
        }
        throw new IllegalStateException("Expected theme to define hlv_listPreferredItemWidth.");
    }

    protected int getHorizontalScrollbarHeight()
    {
        return super.getHorizontalScrollbarHeight();
    }

    protected float getLeftFadingEdgeStrength()
    {
        int i = getChildCount();
        float f = super.getLeftFadingEdgeStrength();
        if (i != 0)
        {
            if (mFirstPosition > 0)
            {
                return 1.0F;
            }
            int j = getChildAt(0).getLeft();
            float f1 = getHorizontalFadingEdgeLength();
            if (j < getPaddingLeft())
            {
                return (float)(-(j - getPaddingLeft())) / f1;
            }
        }
        return f;
    }

    public int getListPaddingBottom()
    {
        return mListPadding.bottom;
    }

    public int getListPaddingLeft()
    {
        return mListPadding.left;
    }

    public int getListPaddingRight()
    {
        return mListPadding.right;
    }

    public int getListPaddingTop()
    {
        return mListPadding.top;
    }

    protected float getRightFadingEdgeStrength()
    {
        int i = getChildCount();
        float f = super.getRightFadingEdgeStrength();
        if (i != 0)
        {
            if ((mFirstPosition + i) - 1 < mItemCount - 1)
            {
                return 1.0F;
            }
            i = getChildAt(i - 1).getRight();
            int j = getWidth();
            float f1 = getHorizontalFadingEdgeLength();
            if (i > j - getPaddingRight())
            {
                return (float)((i - j) + getPaddingRight()) / f1;
            }
        }
        return f;
    }

    public View getSelectedView()
    {
        if (mItemCount > 0 && mSelectedPosition >= 0)
        {
            return getChildAt(mSelectedPosition - mFirstPosition);
        } else
        {
            return null;
        }
    }

    public Drawable getSelector()
    {
        return mSelector;
    }

    public int getSolidColor()
    {
        return mCacheColorHint;
    }

    public int getTranscriptMode()
    {
        return mTranscriptMode;
    }

    protected void handleDataChanged()
    {
        byte byte0;
        int l1;
        int i2;
        byte0 = 3;
        l1 = mItemCount;
        i2 = mLastHandledItemCount;
        mLastHandledItemCount = mItemCount;
        if (mChoiceMode != 0 && mAdapter != null && mAdapter.hasStableIds())
        {
            confirmCheckedPositionsById();
        }
        mRecycler.clearTransientStateViews();
        if (l1 <= 0) goto _L2; else goto _L1
_L1:
        if (!mNeedSync) goto _L4; else goto _L3
_L3:
        mNeedSync = false;
        mPendingSync = null;
        if (mTranscriptMode != 2) goto _L6; else goto _L5
_L5:
        mLayoutMode = 3;
_L10:
        return;
_L6:
        if (mTranscriptMode == 1)
        {
            if (mForceTranscriptScroll)
            {
                mForceTranscriptScroll = false;
                mLayoutMode = 3;
                return;
            }
            int j2 = getChildCount();
            int j1 = getWidth() - getPaddingRight();
            View view = getChildAt(j2 - 1);
            int i;
            if (view != null)
            {
                i = view.getBottom();
            } else
            {
                i = j1;
            }
            if (mFirstPosition + j2 >= i2 && i <= j1)
            {
                mLayoutMode = 3;
                return;
            }
            awakenScrollBars();
        }
        mSyncMode;
        JVM INSTR tableswitch 0 1: default 216
    //                   0 266
    //                   1 354;
           goto _L4 _L7 _L8
_L4:
        int k1;
        if (isInTouchMode())
        {
            continue; /* Loop/switch isn't completed */
        }
        k1 = getSelectedItemPosition();
        int j = k1;
        if (k1 >= l1)
        {
            j = l1 - 1;
        }
        k1 = j;
        if (j < 0)
        {
            k1 = 0;
        }
        j = lookForSelectablePosition(k1, true);
        if (j >= 0)
        {
            setNextSelectedPositionInt(j);
            return;
        }
        break; /* Loop/switch isn't completed */
_L7:
        if (isInTouchMode())
        {
            mLayoutMode = 5;
            mSyncPosition = Math.min(Math.max(0, mSyncPosition), l1 - 1);
            return;
        }
        int k = findSyncPosition();
        if (k >= 0 && lookForSelectablePosition(k, true) == k)
        {
            mSyncPosition = k;
            if (mSyncWidth == (long)getWidth())
            {
                mLayoutMode = 5;
            } else
            {
                mLayoutMode = 2;
            }
            setNextSelectedPositionInt(k);
            return;
        }
        if (true) goto _L4; else goto _L9
_L8:
        mLayoutMode = 5;
        mSyncPosition = Math.min(Math.max(0, mSyncPosition), l1 - 1);
        return;
_L9:
        int l = lookForSelectablePosition(k1, false);
        if (l >= 0)
        {
            setNextSelectedPositionInt(l);
            return;
        }
        break; /* Loop/switch isn't completed */
        if (mResurrectToPosition >= 0) goto _L10; else goto _L2
_L2:
        int i1;
        if (mStackFromRight)
        {
            i1 = byte0;
        } else
        {
            i1 = 1;
        }
        mLayoutMode = i1;
        mSelectedPosition = -1;
        mSelectedColId = 0x8000000000000000L;
        mNextSelectedPosition = -1;
        mNextSelectedColId = 0x8000000000000000L;
        mNeedSync = false;
        mPendingSync = null;
        mSelectorPosition = -1;
        checkSelectionChanged();
        return;
    }

    protected void hideSelector()
    {
        if (mSelectedPosition != -1)
        {
            if (mLayoutMode != 4)
            {
                mResurrectToPosition = mSelectedPosition;
            }
            if (mNextSelectedPosition >= 0 && mNextSelectedPosition != mSelectedPosition)
            {
                mResurrectToPosition = mNextSelectedPosition;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            mSelectedLeft = 0;
        }
    }

    protected void invalidateParentIfNeeded()
    {
        if (mViewHelper.isHardwareAccelerated() && (getParent() instanceof View))
        {
            ((View)getParent()).invalidate();
        }
    }

    public void invalidateViews()
    {
        mDataChanged = true;
        rememberSyncState();
        requestLayout();
        invalidate();
    }

    protected void invokeOnItemScrollListener()
    {
        if (mOnScrollListener != null)
        {
            mOnScrollListener.onScroll(this, mFirstPosition, getChildCount(), mItemCount);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    public boolean isItemChecked(int i)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mChoiceMode != 0)
        {
            flag = flag1;
            if (mCheckStates != null)
            {
                flag = ((Boolean)mCheckStates.get(i, Boolean.valueOf(false))).booleanValue();
            }
        }
        return flag;
    }

    public boolean isScrollingCacheEnabled()
    {
        return mScrollingCacheEnabled;
    }

    public boolean isSmoothScrollbarEnabled()
    {
        return mSmoothScrollbarEnabled;
    }

    public boolean isStackFromRight()
    {
        return mStackFromRight;
    }

    public void jumpDrawablesToCurrentState()
    {
        super.jumpDrawablesToCurrentState();
        if (mSelector != null)
        {
            mSelector.jumpToCurrentState();
        }
    }

    protected void keyPressed()
    {
        if (isEnabled() && isClickable()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Drawable drawable;
        drawable = mSelector;
        Object obj = mSelectorRect;
        if (drawable == null || !isFocused() && !touchModeDrawsInPressedState() || ((Rect) (obj)).isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = getChildAt(mSelectedPosition - mFirstPosition);
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((View) (obj)).hasFocusable())
        {
            continue; /* Loop/switch isn't completed */
        }
        ((View) (obj)).setPressed(true);
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        setPressed(true);
        boolean flag = isLongClickable();
        drawable = drawable.getCurrent();
        if (drawable != null && (drawable instanceof TransitionDrawable))
        {
            if (flag)
            {
                ((TransitionDrawable)drawable).startTransition(ViewConfiguration.getLongPressTimeout());
            } else
            {
                ((TransitionDrawable)drawable).resetTransition();
            }
        }
        if (flag && !mDataChanged)
        {
            if (mPendingCheckForKeyLongPress == null)
            {
                mPendingCheckForKeyLongPress = new CheckForKeyLongPress();
            }
            mPendingCheckForKeyLongPress.rememberWindowAttachCount();
            postDelayed(mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void layoutChildren()
    {
    }

    protected View obtainView(int i, boolean aflag[])
    {
        Object obj;
        aflag[0] = false;
        obj = mRecycler.getTransientStateView(i);
        if (obj == null) goto _L2; else goto _L1
_L1:
        return ((View) (obj));
_L2:
        View view = mRecycler.getScrapView(i);
        if (view == null) goto _L4; else goto _L3
_L3:
        obj = mAdapter.getView(i, view, this);
        if (android.os.Build.VERSION.SDK_INT >= 16 && ((View) (obj)).getImportantForAccessibility() == 0)
        {
            ((View) (obj)).setImportantForAccessibility(1);
        }
        if (obj != view)
        {
            mRecycler.addScrapView(view, i);
            aflag = ((boolean []) (obj));
            if (mCacheColorHint != 0)
            {
                ((View) (obj)).setDrawingCacheBackgroundColor(mCacheColorHint);
                aflag = ((boolean []) (obj));
            }
        } else
        {
            aflag[0] = true;
            ((View) (obj)).onFinishTemporaryDetach();
            aflag = ((boolean []) (obj));
        }
_L5:
        if (mAdapterHasStableIds)
        {
            obj = aflag.getLayoutParams();
            if (obj == null)
            {
                obj = (LayoutParams)generateDefaultLayoutParams();
            } else
            if (!checkLayoutParams(((android.view.ViewGroup.LayoutParams) (obj))))
            {
                obj = (LayoutParams)generateLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            {
                obj = (LayoutParams)obj;
            }
            obj.itemId = mAdapter.getItemId(i);
            aflag.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        }
        obj = aflag;
        if (mAccessibilityManager.isEnabled())
        {
            obj = aflag;
            if (mAccessibilityDelegate == null)
            {
                mAccessibilityDelegate = new ListItemAccessibilityDelegate();
                return aflag;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
        obj = mAdapter.getView(i, null, this);
        if (android.os.Build.VERSION.SDK_INT >= 16 && ((View) (obj)).getImportantForAccessibility() == 0)
        {
            ((View) (obj)).setImportantForAccessibility(1);
        }
        aflag = ((boolean []) (obj));
        if (mCacheColorHint != 0)
        {
            ((View) (obj)).setDrawingCacheBackgroundColor(mCacheColorHint);
            aflag = ((boolean []) (obj));
        }
          goto _L5
    }

    public void offsetChildrenLeftAndRight(int i)
    {
        int k = getChildCount();
        for (int j = 0; j < k; j++)
        {
            getChildAt(j).offsetLeftAndRight(i);
        }

    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (mAdapter != null && mDataSetObserver == null)
        {
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
        }
        mIsAttached = true;
    }

    protected int[] onCreateDrawableState(int i)
    {
        if (!mIsChildViewEnabled) goto _L2; else goto _L1
_L1:
        int ai[] = super.onCreateDrawableState(i);
_L4:
        return ai;
_L2:
        int k = ENABLED_STATE_SET[0];
        int ai1[] = super.onCreateDrawableState(i + 1);
        byte byte0 = -1;
        i = ai1.length - 1;
        do
        {
label0:
            {
                int j = byte0;
                if (i >= 0)
                {
                    if (ai1[i] != k)
                    {
                        break label0;
                    }
                    j = i;
                }
                ai = ai1;
                if (j >= 0)
                {
                    System.arraycopy(ai1, j + 1, ai1, j, ai1.length - j - 1);
                    return ai1;
                }
            }
            if (true)
            {
                continue;
            }
            i--;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo)
    {
        return null;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mRecycler.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (mAdapter != null && mDataSetObserver != null)
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            mDataSetObserver = null;
        }
        if (mFlingRunnable != null)
        {
            removeCallbacks(mFlingRunnable);
        }
        if (mPositionScroller != null)
        {
            mPositionScroller.stop();
        }
        if (mClearScrollingCache != null)
        {
            removeCallbacks(mClearScrollingCache);
        }
        if (mPerformClick != null)
        {
            removeCallbacks(mPerformClick);
        }
        if (mTouchModeReset != null)
        {
            removeCallbacks(mTouchModeReset);
            mTouchModeReset = null;
        }
        mIsAttached = false;
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect)
    {
        super.onFocusChanged(flag, i, rect);
        if (flag && mSelectedPosition < 0 && !isInTouchMode())
        {
            if (!mIsAttached && mAdapter != null)
            {
                mDataChanged = true;
                mOldItemCount = mItemCount;
                mItemCount = mAdapter.getCount();
            }
            resurrectSelection();
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent)
    {
        if ((motionevent.getSource() & 2) == 0) goto _L2; else goto _L1
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 8 8: default 32
    //                   8 38;
           goto _L2 _L3
_L2:
        return super.onGenericMotionEvent(motionevent);
_L3:
        float f;
        int i;
        if (mTouchMode == -1 && (f = motionevent.getAxisValue(10)) != 0.0F && !trackMotionScroll(i = (int)(getHorizontalScrollFactor() * f), i))
        {
            return true;
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(it/sephiroth/android/library/widget/AbsHListView.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo)
    {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(it/sephiroth/android/library/widget/AbsHListView.getName());
        if (isEnabled())
        {
            if (getFirstVisiblePosition() > 0)
            {
                accessibilitynodeinfo.addAction(8192);
            }
            if (getLastVisiblePosition() < getCount() - 1)
            {
                accessibilitynodeinfo.addAction(4096);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i;
        i = motionevent.getAction();
        if (mPositionScroller != null)
        {
            mPositionScroller.stop();
        }
        if (mIsAttached) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        switch (i & 0xff)
        {
        case 4: // '\004'
        case 5: // '\005'
        default:
            return false;

        case 0: // '\0'
            int j = mTouchMode;
            if (j == 6 || j == 5)
            {
                mMotionCorrection = 0;
                return true;
            }
            int l = (int)motionevent.getX();
            int j1 = (int)motionevent.getY();
            mActivePointerId = motionevent.getPointerId(0);
            int k1 = findMotionCol(l);
            if (j != 4 && k1 >= 0)
            {
                mMotionViewOriginalLeft = getChildAt(k1 - mFirstPosition).getLeft();
                mMotionX = l;
                mMotionY = j1;
                mMotionPosition = k1;
                mTouchMode = 0;
                clearScrollingCache();
            }
            mLastX = 0x80000000;
            initOrResetVelocityTracker();
            mVelocityTracker.addMovement(motionevent);
            if (j == 4)
            {
                return true;
            }
            break;

        case 2: // '\002'
            int i1;
            switch (mTouchMode)
            {
            default:
                return false;

            case 0: // '\0'
                i1 = motionevent.findPointerIndex(mActivePointerId);
                break;
            }
            int k = i1;
            if (i1 == -1)
            {
                k = 0;
                mActivePointerId = motionevent.getPointerId(0);
            }
            k = (int)motionevent.getX(k);
            initVelocityTrackerIfNotExists();
            mVelocityTracker.addMovement(motionevent);
            if (startScrollIfNeeded(k))
            {
                return true;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            mTouchMode = -1;
            mActivePointerId = -1;
            recycleVelocityTracker();
            reportScrollStateChange(0);
            return false;

        case 6: // '\006'
            onSecondaryPointerUp(motionevent);
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        boolean flag = true;
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   23: 37
    //                   66: 37;
           goto _L1 _L2 _L2
_L1:
        flag = super.onKeyUp(i, keyevent);
_L4:
        return flag;
_L2:
        if (!isEnabled()) goto _L4; else goto _L3
_L3:
        if (isClickable() && isPressed() && mSelectedPosition >= 0 && mAdapter != null && mSelectedPosition < mAdapter.getCount())
        {
            keyevent = getChildAt(mSelectedPosition - mFirstPosition);
            if (keyevent != null)
            {
                performItemClick(keyevent, mSelectedPosition, mSelectedColId);
                keyevent.setPressed(false);
            }
            setPressed(false);
            return true;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        mInLayout = true;
        if (flag)
        {
            l = getChildCount();
            for (j = 0; j < l; j++)
            {
                getChildAt(j).forceLayout();
            }

            mRecycler.markChildrenDirty();
        }
        layoutChildren();
        mInLayout = false;
        mOverscrollMax = (k - i) / 3;
    }

    protected void onMeasure(int i, int j)
    {
        boolean flag = true;
        if (mSelector == null)
        {
            useDefaultSelector();
        }
        Rect rect = mListPadding;
        rect.left = mSelectionLeftPadding + getPaddingLeft();
        rect.top = mSelectionTopPadding + getPaddingTop();
        rect.right = mSelectionRightPadding + getPaddingRight();
        rect.bottom = mSelectionBottomPadding + getPaddingBottom();
        if (mTranscriptMode == 1)
        {
            int k = getChildCount();
            j = getWidth() - getPaddingRight();
            View view = getChildAt(k - 1);
            if (view != null)
            {
                i = view.getRight();
            } else
            {
                i = j;
            }
            if (mFirstPosition + k < mLastHandledItemCount || i > j)
            {
                flag = false;
            }
            mForceTranscriptScroll = flag;
        }
    }

    protected void onOverScrolled(int i, int j, boolean flag, boolean flag1)
    {
        if (getScrollX() != i)
        {
            onScrollChanged(i, getScrollY(), getScrollX(), getScrollY());
            mViewHelper.setScrollX(i);
            invalidateParentIfNeeded();
            awakenScrollBars();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        mDataChanged = true;
        mSyncWidth = ((SavedState) (parcelable)).width;
        if (((SavedState) (parcelable)).selectedId < 0L) goto _L2; else goto _L1
_L1:
        mNeedSync = true;
        mPendingSync = parcelable;
        mSyncColId = ((SavedState) (parcelable)).selectedId;
        mSyncPosition = ((SavedState) (parcelable)).position;
        mSpecificLeft = ((SavedState) (parcelable)).viewLeft;
        mSyncMode = 0;
_L4:
        if (((SavedState) (parcelable)).checkState != null)
        {
            mCheckStates = ((SavedState) (parcelable)).checkState;
        }
        if (((SavedState) (parcelable)).checkIdState != null)
        {
            mCheckedIdStates = ((SavedState) (parcelable)).checkIdState;
        }
        mCheckedItemCount = ((SavedState) (parcelable)).checkedItemCount;
        if (android.os.Build.VERSION.SDK_INT >= 11 && ((SavedState) (parcelable)).inActionMode && mChoiceMode == 3 && mMultiChoiceModeCallback != null)
        {
            mChoiceActionMode = startActionMode((MultiChoiceModeWrapper)mMultiChoiceModeCallback);
        }
        requestLayout();
        return;
_L2:
        if (((SavedState) (parcelable)).firstId >= 0L)
        {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            mSelectorPosition = -1;
            mNeedSync = true;
            mPendingSync = parcelable;
            mSyncColId = ((SavedState) (parcelable)).firstId;
            mSyncPosition = ((SavedState) (parcelable)).position;
            mSpecificLeft = ((SavedState) (parcelable)).viewLeft;
            mSyncMode = 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (mPendingSync != null)
        {
            savedstate.selectedId = mPendingSync.selectedId;
            savedstate.firstId = mPendingSync.firstId;
            savedstate.viewLeft = mPendingSync.viewLeft;
            savedstate.position = mPendingSync.position;
            savedstate.width = mPendingSync.width;
            savedstate.filter = mPendingSync.filter;
            savedstate.inActionMode = mPendingSync.inActionMode;
            savedstate.checkedItemCount = mPendingSync.checkedItemCount;
            savedstate.checkState = mPendingSync.checkState;
            savedstate.checkIdState = mPendingSync.checkIdState;
            return savedstate;
        }
        int i;
        long l1;
        boolean flag;
        if (getChildCount() > 0 && mItemCount > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        l1 = getSelectedItemId();
        savedstate.selectedId = l1;
        savedstate.width = getWidth();
        if (l1 >= 0L)
        {
            savedstate.viewLeft = mSelectedLeft;
            savedstate.position = getSelectedItemPosition();
            savedstate.firstId = -1L;
        } else
        if (i != 0 && mFirstPosition > 0)
        {
            savedstate.viewLeft = getChildAt(0).getLeft();
            int l = mFirstPosition;
            int j = l;
            if (l >= mItemCount)
            {
                j = mItemCount - 1;
            }
            savedstate.position = j;
            savedstate.firstId = mAdapter.getItemId(j);
        } else
        {
            savedstate.viewLeft = 0;
            savedstate.firstId = -1L;
            savedstate.position = 0;
        }
        savedstate.filter = null;
        if (android.os.Build.VERSION.SDK_INT >= 11 && mChoiceMode == 3 && mChoiceActionMode != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        savedstate.inActionMode = flag;
        if (mCheckStates != null)
        {
            try
            {
                savedstate.checkState = mCheckStates.clone();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((NoSuchMethodError) (obj)).printStackTrace();
                savedstate.checkState = new SparseArrayCompat();
            }
        }
        if (mCheckedIdStates != null)
        {
            Object obj = new LongSparseArray();
            int k = mCheckedIdStates.size();
            for (i = 0; i < k; i++)
            {
                ((LongSparseArray) (obj)).put(mCheckedIdStates.keyAt(i), mCheckedIdStates.valueAt(i));
            }

            savedstate.checkIdState = ((LongSparseArray) (obj));
        }
        savedstate.checkedItemCount = mCheckedItemCount;
        return savedstate;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        if (getChildCount() > 0)
        {
            mDataChanged = true;
            rememberSyncState();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        if (!isEnabled())
        {
            return isClickable() || isLongClickable();
        }
        if (mPositionScroller != null)
        {
            mPositionScroller.stop();
        }
        if (!mIsAttached)
        {
            return false;
        }
        i = motionevent.getAction();
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(motionevent);
        i & 0xff;
        JVM INSTR tableswitch 0 6: default 116
    //                   0 118
    //                   1 566
    //                   2 450
    //                   3 1423
    //                   4 116
    //                   5 1625
    //                   6 1564;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L24:
        return true;
_L2:
        mTouchMode;
        JVM INSTR tableswitch 6 6: default 140
    //                   6 330;
           goto _L8 _L9
_L8:
        int k1;
        int i3;
        int l3;
        mActivePointerId = motionevent.getPointerId(0);
        i3 = (int)motionevent.getX();
        l3 = (int)motionevent.getY();
        k1 = pointToPosition(i3, l3);
        i = k1;
        if (mDataChanged) goto _L11; else goto _L10
_L10:
        if (mTouchMode == 4 || k1 < 0 || !((ListAdapter)getAdapter()).isEnabled(k1)) goto _L13; else goto _L12
_L12:
        mTouchMode = 0;
        if (mPendingCheckForTap == null)
        {
            mPendingCheckForTap = new CheckForTap();
        }
        postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
        i = k1;
_L11:
        if (i >= 0)
        {
            mMotionViewOriginalLeft = getChildAt(i - mFirstPosition).getLeft();
        }
        mMotionX = i3;
        mMotionY = l3;
        mMotionPosition = i;
        mLastX = 0x80000000;
_L14:
        if (performButtonActionOnTouchDown(motionevent) && mTouchMode == 0)
        {
            removeCallbacks(mPendingCheckForTap);
        }
          goto _L1
_L9:
        mFlingRunnable.endFling();
        if (mPositionScroller != null)
        {
            mPositionScroller.stop();
        }
        mTouchMode = 5;
        mMotionY = (int)motionevent.getY();
        i = (int)motionevent.getX();
        mLastX = i;
        mMotionX = i;
        mMotionCorrection = 0;
        mActivePointerId = motionevent.getPointerId(0);
        mDirection = 0;
        if (true) goto _L14; else goto _L13
_L13:
        i = k1;
        if (mTouchMode == 4)
        {
            createScrollingCache();
            mTouchMode = 3;
            mMotionCorrection = 0;
            i = findMotionCol(i3);
            mFlingRunnable.flywheelTouch();
        }
        if (true) goto _L11; else goto _L4
_L4:
        int l1 = motionevent.findPointerIndex(mActivePointerId);
        int j = l1;
        if (l1 == -1)
        {
            j = 0;
            mActivePointerId = motionevent.getPointerId(0);
        }
        j = (int)motionevent.getX(j);
        if (mDataChanged)
        {
            layoutChildren();
        }
        switch (mTouchMode)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            startScrollIfNeeded(j);
            break;

        case 3: // '\003'
        case 5: // '\005'
            scrollIfNeeded(j);
            break;
        }
_L1:
        if (false)
        {
        }
        continue; /* Loop/switch isn't completed */
_L3:
        mTouchMode;
        JVM INSTR tableswitch 0 5: default 608
    //                   0 667
    //                   1 667
    //                   2 667
    //                   3 1045
    //                   4 608
    //                   5 1336;
           goto _L15 _L16 _L16 _L16 _L17 _L15 _L18
_L15:
        setPressed(false);
        if (mEdgeGlowTop != null)
        {
            mEdgeGlowTop.onRelease();
            mEdgeGlowBottom.onRelease();
        }
        invalidate();
        motionevent = getHandler();
        if (motionevent != null)
        {
            motionevent.removeCallbacks(mPendingCheckForLongPress);
        }
        recycleVelocityTracker();
        mActivePointerId = -1;
        continue; /* Loop/switch isn't completed */
_L16:
        int i2 = mMotionPosition;
        final View child = getChildAt(i2 - mFirstPosition);
        float f = motionevent.getX();
        boolean flag;
        if (f > (float)mListPadding.left && f < (float)(getWidth() - mListPadding.right))
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
            performClick.mClickMotionPosition = i2;
            performClick.rememberWindowAttachCount();
            mResurrectToPosition = i2;
            if (mTouchMode == 0 || mTouchMode == 1)
            {
                Handler handler = getHandler();
                if (handler != null)
                {
                    if (mTouchMode == 0)
                    {
                        motionevent = mPendingCheckForTap;
                    } else
                    {
                        motionevent = mPendingCheckForLongPress;
                    }
                    handler.removeCallbacks(motionevent);
                }
                mLayoutMode = 0;
                if (!mDataChanged && mAdapter.isEnabled(i2))
                {
                    mTouchMode = 1;
                    setSelectedPositionInt(mMotionPosition);
                    layoutChildren();
                    child.setPressed(true);
                    positionSelector(mMotionPosition, child);
                    setPressed(true);
                    if (mSelector != null)
                    {
                        motionevent = mSelector.getCurrent();
                        if (motionevent != null && (motionevent instanceof TransitionDrawable))
                        {
                            ((TransitionDrawable)motionevent).resetTransition();
                        }
                    }
                    if (mTouchModeReset != null)
                    {
                        removeCallbacks(mTouchModeReset);
                    }
                    mTouchModeReset = new Runnable() {

                        final AbsHListView this$0;
                        final View val$child;
                        final PerformClick val$performClick;

                        public void run()
                        {
                            mTouchMode = -1;
                            child.setPressed(false);
                            setPressed(false);
                            if (!mDataChanged)
                            {
                                performClick.run();
                            }
                        }

            
            {
                this$0 = AbsHListView.this;
                child = view;
                performClick = performclick;
                super();
            }
                    };
                    postDelayed(mTouchModeReset, ViewConfiguration.getPressedStateDuration());
                } else
                {
                    mTouchMode = -1;
                    updateSelectorState();
                }
                return true;
            }
            if (!mDataChanged && mAdapter.isEnabled(i2))
            {
                performClick.run();
            }
        }
        mTouchMode = -1;
        updateSelectorState();
        continue; /* Loop/switch isn't completed */
_L17:
        int k = getChildCount();
        if (k > 0)
        {
            int j2 = getChildAt(0).getLeft();
            int j3 = getChildAt(k - 1).getRight();
            int i4 = mListPadding.left;
            int j4 = getWidth() - mListPadding.right;
            if (mFirstPosition == 0 && j2 >= i4 && mFirstPosition + k < mItemCount && j3 <= getWidth() - j4)
            {
                mTouchMode = -1;
                reportScrollStateChange(0);
            } else
            {
                motionevent = mVelocityTracker;
                motionevent.computeCurrentVelocity(1000, mMaximumVelocity);
                int k4 = (int)(motionevent.getXVelocity(mActivePointerId) * mVelocityScale);
                if (Math.abs(k4) > mMinimumVelocity && (mFirstPosition != 0 || j2 != i4 - mOverscrollDistance) && (mFirstPosition + k != mItemCount || j3 != mOverscrollDistance + j4))
                {
                    if (mFlingRunnable == null)
                    {
                        mFlingRunnable = new FlingRunnable();
                    }
                    reportScrollStateChange(2);
                    mFlingRunnable.start(-k4);
                } else
                {
                    mTouchMode = -1;
                    reportScrollStateChange(0);
                    if (mFlingRunnable != null)
                    {
                        mFlingRunnable.endFling();
                    }
                    if (mPositionScroller != null)
                    {
                        mPositionScroller.stop();
                    }
                }
            }
        } else
        {
            mTouchMode = -1;
            reportScrollStateChange(0);
        }
        continue; /* Loop/switch isn't completed */
_L18:
        if (mFlingRunnable == null)
        {
            mFlingRunnable = new FlingRunnable();
        }
        motionevent = mVelocityTracker;
        motionevent.computeCurrentVelocity(1000, mMaximumVelocity);
        int l = (int)motionevent.getXVelocity(mActivePointerId);
        reportScrollStateChange(2);
        if (Math.abs(l) > mMinimumVelocity)
        {
            mFlingRunnable.startOverfling(-l);
        } else
        {
            mFlingRunnable.startSpringback();
        }
        if (true) goto _L15; else goto _L5
_L5:
        mTouchMode;
        JVM INSTR tableswitch 5 6: default 1448
    //                   5 1535
    //                   6 1506;
           goto _L19 _L20 _L21
_L21:
        break; /* Loop/switch isn't completed */
_L19:
        mTouchMode = -1;
        setPressed(false);
        motionevent = getChildAt(mMotionPosition - mFirstPosition);
        if (motionevent != null)
        {
            motionevent.setPressed(false);
        }
        clearScrollingCache();
        motionevent = getHandler();
        if (motionevent != null)
        {
            motionevent.removeCallbacks(mPendingCheckForLongPress);
        }
        recycleVelocityTracker();
_L22:
        if (mEdgeGlowTop != null)
        {
            mEdgeGlowTop.onRelease();
            mEdgeGlowBottom.onRelease();
        }
        mActivePointerId = -1;
        continue; /* Loop/switch isn't completed */
_L20:
        if (mFlingRunnable == null)
        {
            mFlingRunnable = new FlingRunnable();
        }
        mFlingRunnable.startSpringback();
        if (true) goto _L22; else goto _L7
_L7:
        onSecondaryPointerUp(motionevent);
        int i1 = mMotionX;
        int k2 = pointToPosition(i1, mMotionY);
        if (k2 >= 0)
        {
            mMotionViewOriginalLeft = getChildAt(k2 - mFirstPosition).getLeft();
            mMotionPosition = k2;
        }
        mLastX = i1;
        continue; /* Loop/switch isn't completed */
_L6:
        int k3 = motionevent.getActionIndex();
        int l2 = motionevent.getPointerId(k3);
        int j1 = (int)motionevent.getX(k3);
        k3 = (int)motionevent.getY(k3);
        mMotionCorrection = 0;
        mActivePointerId = l2;
        mMotionX = j1;
        mMotionY = k3;
        l2 = pointToPosition(j1, k3);
        if (l2 >= 0)
        {
            mMotionViewOriginalLeft = getChildAt(l2 - mFirstPosition).getLeft();
            mMotionPosition = l2;
        }
        mLastX = j1;
        if (true) goto _L24; else goto _L23
_L23:
    }

    public void onTouchModeChanged(boolean flag)
    {
        if (flag)
        {
            hideSelector();
            if (getWidth() > 0 && getChildCount() > 0)
            {
                layoutChildren();
            }
            updateSelectorState();
        } else
        {
            int i = mTouchMode;
            if (i == 5 || i == 6)
            {
                if (mFlingRunnable != null)
                {
                    mFlingRunnable.endFling();
                }
                if (mPositionScroller != null)
                {
                    mPositionScroller.stop();
                }
                if (getScrollX() != 0)
                {
                    mViewHelper.setScrollX(0);
                    finishGlows();
                    invalidate();
                    return;
                }
            }
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        int i;
        super.onWindowFocusChanged(flag);
        if (isInTouchMode())
        {
            i = 0;
        } else
        {
            i = 1;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        setChildrenDrawingCacheEnabled(false);
        if (mFlingRunnable != null)
        {
            removeCallbacks(mFlingRunnable);
            mFlingRunnable.endFling();
            if (mPositionScroller != null)
            {
                mPositionScroller.stop();
            }
            if (getScrollX() != 0)
            {
                mViewHelper.setScrollX(0);
                finishGlows();
                invalidate();
            }
        }
        if (i == 1)
        {
            mResurrectToPosition = mSelectedPosition;
        }
_L4:
        mLastTouchMode = i;
        return;
_L2:
        if (i != mLastTouchMode && mLastTouchMode != -1)
        {
            if (i == 1)
            {
                resurrectSelection();
            } else
            {
                hideSelector();
                mLayoutMode = 0;
                layoutChildren();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean performAccessibilityAction(int i, Bundle bundle)
    {
        if (super.performAccessibilityAction(i, bundle))
        {
            return true;
        }
        switch (i)
        {
        default:
            return false;

        case 4096: 
            if (isEnabled() && getLastVisiblePosition() < getCount() - 1)
            {
                smoothScrollBy(getWidth() - mListPadding.left - mListPadding.right, 200);
                return true;
            } else
            {
                return false;
            }

        case 8192: 
            break;
        }
        if (isEnabled() && mFirstPosition > 0)
        {
            smoothScrollBy(-(getWidth() - mListPadding.left - mListPadding.right), 200);
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean performButtonActionOnTouchDown(MotionEvent motionevent)
    {
        return android.os.Build.VERSION.SDK_INT >= 14 && (motionevent.getButtonState() & 2) != 0 && showContextMenu(motionevent.getX(), motionevent.getY(), motionevent.getMetaState());
    }

    public boolean performItemClick(View view, int i, long l)
    {
        boolean flag;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag4 = false;
        flag3 = true;
        flag2 = true;
        flag = true;
        if (mChoiceMode == 0) goto _L2; else goto _L1
_L1:
        boolean flag1;
        boolean flag5;
        flag5 = true;
        flag1 = false;
        if (mChoiceMode != 2 && (android.os.Build.VERSION.SDK_INT < 11 || mChoiceMode != 3 || mChoiceActionMode == null)) goto _L4; else goto _L3
_L3:
        if (!((Boolean)mCheckStates.get(i, Boolean.valueOf(false))).booleanValue())
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        mCheckStates.put(i, Boolean.valueOf(flag4));
        if (mCheckedIdStates != null && mAdapter.hasStableIds())
        {
            if (flag4)
            {
                mCheckedIdStates.put(mAdapter.getItemId(i), Integer.valueOf(i));
            } else
            {
                mCheckedIdStates.delete(mAdapter.getItemId(i));
            }
        }
        if (flag4)
        {
            mCheckedItemCount = mCheckedItemCount + 1;
        } else
        {
            mCheckedItemCount = mCheckedItemCount - 1;
        }
        if (mChoiceActionMode != null)
        {
            ((MultiChoiceModeWrapper)mMultiChoiceModeCallback).onItemCheckedStateChanged((ActionMode)mChoiceActionMode, i, l, flag4);
            flag = false;
        }
        flag1 = true;
_L6:
        flag2 = flag;
        flag4 = flag5;
        if (flag1)
        {
            updateOnScreenCheckedViews();
            flag4 = flag5;
            flag2 = flag;
        }
_L2:
        flag5 = flag4;
        if (flag2)
        {
            flag5 = flag4 | super.performItemClick(view, i, l);
        }
        return flag5;
_L4:
        flag = flag3;
        if (mChoiceMode != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!((Boolean)mCheckStates.get(i, Boolean.valueOf(false))).booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        mCheckStates.clear();
        mCheckStates.put(i, Boolean.valueOf(true));
        if (mCheckedIdStates != null && mAdapter.hasStableIds())
        {
            mCheckedIdStates.clear();
            mCheckedIdStates.put(mAdapter.getItemId(i), Integer.valueOf(i));
        }
        mCheckedItemCount = 1;
_L8:
        flag1 = true;
        flag = flag3;
        if (true) goto _L6; else goto _L5
_L5:
        if (mCheckStates.size() != 0 && ((Boolean)mCheckStates.valueAt(0)).booleanValue()) goto _L8; else goto _L7
_L7:
        mCheckedItemCount = 0;
          goto _L8
    }

    boolean performLongPress(View view, int i, long l)
    {
        boolean flag = true;
        boolean flag2;
        if (android.os.Build.VERSION.SDK_INT >= 11 && mChoiceMode == 3)
        {
            flag2 = flag;
            if (mChoiceActionMode == null)
            {
                view = startActionMode((MultiChoiceModeWrapper)mMultiChoiceModeCallback);
                mChoiceActionMode = view;
                flag2 = flag;
                if (view != null)
                {
                    setItemChecked(i, true);
                    performHapticFeedback(0);
                    flag2 = flag;
                }
            }
        } else
        {
            flag2 = false;
            if (mOnItemLongClickListener != null)
            {
                flag2 = mOnItemLongClickListener.onItemLongClick(this, view, i, l);
            }
            boolean flag1 = flag2;
            if (!flag2)
            {
                mContextMenuInfo = createContextMenuInfo(view, i, l);
                flag1 = super.showContextMenuForChild(this);
            }
            flag2 = flag1;
            if (flag1)
            {
                performHapticFeedback(0);
                return flag1;
            }
        }
        return flag2;
    }

    public long pointToColId(int i, int j)
    {
        i = pointToPosition(i, j);
        if (i >= 0)
        {
            return mAdapter.getItemId(i);
        } else
        {
            return 0x8000000000000000L;
        }
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
            View view = getChildAt(k);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            view.getHitRect(rect);
            if (rect.contains(i, j))
            {
                return mFirstPosition + k;
            }
        }

        return -1;
    }

    protected void positionSelector(int i, View view)
    {
        if (i != -1)
        {
            mSelectorPosition = i;
        }
        Rect rect = mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof SelectionBoundsAdjuster)
        {
            ((SelectionBoundsAdjuster)view).adjustListItemSelectionBounds(rect);
        }
        positionSelector(rect.left, rect.top, rect.right, rect.bottom);
        boolean flag = mIsChildViewEnabled;
        if (view.isEnabled() != flag)
        {
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mIsChildViewEnabled = flag;
            if (getSelectedItemPosition() != -1)
            {
                refreshDrawableState();
            }
        }
    }

    public void reclaimViews(List list)
    {
        int j = getChildCount();
        RecyclerListener recyclerlistener = mRecycler.mRecyclerListener;
        for (int i = 0; i < j; i++)
        {
            View view = getChildAt(i);
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            if (layoutparams == null || !mRecycler.shouldRecycleViewType(layoutparams.viewType))
            {
                continue;
            }
            list.add(view);
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                view.setAccessibilityDelegate(null);
            }
            if (recyclerlistener != null)
            {
                recyclerlistener.onMovedToScrapHeap(view);
            }
        }

        mRecycler.reclaimScrapViews(list);
        removeAllViewsInLayout();
    }

    protected int reconcileSelectedPosition()
    {
        int j = mSelectedPosition;
        int i = j;
        if (j < 0)
        {
            i = mResurrectToPosition;
        }
        return Math.min(Math.max(0, i), mItemCount - 1);
    }

    void reportScrollStateChange(int i)
    {
        if (i != mLastScrollState && mOnScrollListener != null)
        {
            mLastScrollState = i;
            mOnScrollListener.onScrollStateChanged(this, i);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        if (flag)
        {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(flag);
    }

    public void requestLayout()
    {
        if (!mBlockLayoutRequests && !mInLayout)
        {
            super.requestLayout();
        }
    }

    void requestLayoutIfNecessary()
    {
        if (getChildCount() > 0)
        {
            resetList();
            requestLayout();
            invalidate();
        }
    }

    protected void resetList()
    {
        removeAllViewsInLayout();
        mFirstPosition = 0;
        mDataChanged = false;
        mPositionScrollAfterLayout = null;
        mNeedSync = false;
        mPendingSync = null;
        mOldSelectedPosition = -1;
        mOldSelectedColId = 0x8000000000000000L;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        mSelectedLeft = 0;
        mSelectorPosition = -1;
        mSelectorRect.setEmpty();
        invalidate();
    }

    boolean resurrectSelection()
    {
        int i;
        int j;
        int k;
        int j1;
        int k1;
        int i2;
        int j2;
        boolean flag1;
        j2 = getChildCount();
        if (j2 <= 0)
        {
            return false;
        }
        k = 0;
        i = 0;
        k1 = mListPadding.left;
        j1 = getRight() - getLeft() - mListPadding.right;
        i2 = mFirstPosition;
        j = mResurrectToPosition;
        flag1 = true;
        if (j < i2 || j >= i2 + j2) goto _L2; else goto _L1
_L1:
        boolean flag;
        k = j;
        View view = getChildAt(k - mFirstPosition);
        i = view.getLeft();
        int l = view.getRight();
        if (i < k1)
        {
            i = k1 + getHorizontalFadingEdgeLength();
            j = k;
            flag = flag1;
        } else
        {
            flag = flag1;
            j = k;
            if (l > j1)
            {
                i = j1 - view.getMeasuredWidth() - getHorizontalFadingEdgeLength();
                flag = flag1;
                j = k;
            }
        }
_L3:
        mResurrectToPosition = -1;
        removeCallbacks(mFlingRunnable);
        if (mPositionScroller != null)
        {
            mPositionScroller.stop();
        }
        mTouchMode = -1;
        clearScrollingCache();
        mSpecificLeft = i;
        i = lookForSelectablePosition(j, flag);
        View view1;
        int i1;
        int l1;
        int k2;
        int l2;
        if (i >= i2 && i <= getLastVisiblePosition())
        {
            mLayoutMode = 4;
            updateSelectorState();
            setSelectionInt(i);
            invokeOnItemScrollListener();
        } else
        {
            i = -1;
        }
        reportScrollStateChange(0);
        return i >= 0;
_L2:
        if (j >= i2)
        {
            break MISSING_BLOCK_LABEL_366;
        }
        i1 = i2;
        j1 = 0;
        k = i;
_L4:
        flag = flag1;
        i = k;
        j = i1;
        if (j1 < j2)
        {
label0:
            {
                i = getChildAt(j1).getLeft();
                j = k1;
                if (j1 != 0)
                {
                    break label0;
                }
                l1 = i;
                if (i2 <= 0)
                {
                    j = k1;
                    k = l1;
                    if (i >= k1)
                    {
                        break label0;
                    }
                }
                j = k1 + getHorizontalFadingEdgeLength();
                k = l1;
            }
label1:
            {
                if (i < j)
                {
                    break label1;
                }
                j = i2 + j1;
                flag = flag1;
            }
        }
          goto _L3
        j1++;
        k1 = j;
          goto _L4
        k2 = mItemCount;
        flag1 = false;
        l1 = (i2 + j2) - 1;
        i1 = j2 - 1;
_L5:
        flag = flag1;
        i = k;
        j = l1;
        if (i1 >= 0)
        {
label2:
            {
                view1 = getChildAt(i1);
                i = view1.getLeft();
                l2 = view1.getRight();
                j = j1;
                if (i1 != j2 - 1)
                {
                    break label2;
                }
                k1 = i;
                if (i2 + j2 >= k2)
                {
                    j = j1;
                    k = k1;
                    if (l2 <= j1)
                    {
                        break label2;
                    }
                }
                j = j1 - getHorizontalFadingEdgeLength();
                k = k1;
            }
label3:
            {
                if (l2 > j)
                {
                    break label3;
                }
                j = i2 + i1;
                flag = flag1;
            }
        }
          goto _L3
        i1--;
        j1 = j;
          goto _L5
    }

    protected boolean resurrectSelectionIfNeeded()
    {
        if (mSelectedPosition < 0 && resurrectSelection())
        {
            updateSelectorState();
            return true;
        } else
        {
            return false;
        }
    }

    public void sendAccessibilityEvent(int i)
    {
        if (i == 4096)
        {
            int j = getFirstVisiblePosition();
            int k = getLastVisiblePosition();
            if (mLastAccessibilityScrollEventFromIndex == j && mLastAccessibilityScrollEventToIndex == k)
            {
                return;
            }
            mLastAccessibilityScrollEventFromIndex = j;
            mLastAccessibilityScrollEventToIndex = k;
        }
        super.sendAccessibilityEvent(i);
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (listadapter != null)
        {
            mAdapterHasStableIds = mAdapter.hasStableIds();
            if (mChoiceMode != 0 && mAdapterHasStableIds && mCheckedIdStates == null)
            {
                mCheckedIdStates = new LongSparseArray();
            }
        }
        if (mCheckStates != null)
        {
            mCheckStates.clear();
        }
        if (mCheckedIdStates != null)
        {
            mCheckedIdStates.clear();
        }
    }

    public void setCacheColorHint(int i)
    {
        if (i != mCacheColorHint)
        {
            mCacheColorHint = i;
            int k = getChildCount();
            for (int j = 0; j < k; j++)
            {
                getChildAt(j).setDrawingCacheBackgroundColor(i);
            }

            mRecycler.setCacheColorHint(i);
        }
    }

    public void setChoiceMode(int i)
    {
        mChoiceMode = i;
        if (android.os.Build.VERSION.SDK_INT >= 11 && mChoiceActionMode != null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                ((ActionMode)mChoiceActionMode).finish();
            }
            mChoiceActionMode = null;
        }
        if (mChoiceMode != 0)
        {
            if (mCheckStates == null)
            {
                mCheckStates = new SparseArrayCompat();
            }
            if (mCheckedIdStates == null && mAdapter != null && mAdapter.hasStableIds())
            {
                mCheckedIdStates = new LongSparseArray();
            }
            if (android.os.Build.VERSION.SDK_INT >= 11 && mChoiceMode == 3)
            {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean flag)
    {
        mDrawSelectorOnTop = flag;
    }

    public void setFriction(float f)
    {
        if (mFlingRunnable == null)
        {
            mFlingRunnable = new FlingRunnable();
        }
        mFlingRunnable.mScroller.setFriction(f);
    }

    public void setItemChecked(int i, boolean flag)
    {
        if (mChoiceMode != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (android.os.Build.VERSION.SDK_INT >= 11 && flag && mChoiceMode == 3 && mChoiceActionMode == null)
        {
            if (mMultiChoiceModeCallback == null || !((MultiChoiceModeWrapper)mMultiChoiceModeCallback).hasWrappedCallback())
            {
                throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
            }
            mChoiceActionMode = startActionMode((MultiChoiceModeWrapper)mMultiChoiceModeCallback);
        }
        if (mChoiceMode != 2 && (android.os.Build.VERSION.SDK_INT < 11 || mChoiceMode != 3))
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag2 = ((Boolean)mCheckStates.get(i, Boolean.valueOf(false))).booleanValue();
        mCheckStates.put(i, Boolean.valueOf(flag));
        if (mCheckedIdStates != null && mAdapter.hasStableIds())
        {
            if (flag)
            {
                mCheckedIdStates.put(mAdapter.getItemId(i), Integer.valueOf(i));
            } else
            {
                mCheckedIdStates.delete(mAdapter.getItemId(i));
            }
        }
        if (flag2 != flag)
        {
            if (flag)
            {
                mCheckedItemCount = mCheckedItemCount + 1;
            } else
            {
                mCheckedItemCount = mCheckedItemCount - 1;
            }
        }
        if (mChoiceActionMode != null)
        {
            long l = mAdapter.getItemId(i);
            ((MultiChoiceModeWrapper)mMultiChoiceModeCallback).onItemCheckedStateChanged((ActionMode)mChoiceActionMode, i, l, flag);
        }
_L4:
        if (!mInLayout && !mBlockLayoutRequests)
        {
            mDataChanged = true;
            rememberSyncState();
            requestLayout();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        boolean flag1;
        if (mCheckedIdStates != null && mAdapter.hasStableIds())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag || isItemChecked(i))
        {
            mCheckStates.clear();
            if (flag1)
            {
                mCheckedIdStates.clear();
            }
        }
        if (flag)
        {
            mCheckStates.put(i, Boolean.valueOf(true));
            if (flag1)
            {
                mCheckedIdStates.put(mAdapter.getItemId(i), Integer.valueOf(i));
            }
            mCheckedItemCount = 1;
        } else
        if (mCheckStates.size() == 0 || !((Boolean)mCheckStates.valueAt(0)).booleanValue())
        {
            mCheckedItemCount = 0;
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void setMultiChoiceModeListener(MultiChoiceModeListener multichoicemodelistener)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            if (mMultiChoiceModeCallback == null)
            {
                mMultiChoiceModeCallback = new MultiChoiceModeWrapper(this);
            }
            ((MultiChoiceModeWrapper)mMultiChoiceModeCallback).setWrapped(multichoicemodelistener);
            return;
        } else
        {
            Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
            return;
        }
    }

    public void setOnScrollListener(OnScrollListener onscrolllistener)
    {
        mOnScrollListener = onscrolllistener;
        invokeOnItemScrollListener();
    }

    public void setOverScrollEffectPadding(int i, int j)
    {
        mGlowPaddingTop = i;
        mGlowPaddingBottom = j;
    }

    public void setOverScrollMode(int i)
    {
        if (i != 2)
        {
            if (mEdgeGlowTop == null)
            {
                Context context = getContext();
                mEdgeGlowTop = new EdgeEffect(context, 1);
                mEdgeGlowBottom = new EdgeEffect(context, 1);
            }
        } else
        {
            mEdgeGlowTop = null;
            mEdgeGlowBottom = null;
        }
        super.setOverScrollMode(i);
    }

    public void setRecyclerListener(RecyclerListener recyclerlistener)
    {
        mRecycler.mRecyclerListener = recyclerlistener;
    }

    public void setScrollIndicators(View view, View view1)
    {
        mScrollLeft = view;
        mScrollRight = view1;
    }

    public void setScrollingCacheEnabled(boolean flag)
    {
        if (mScrollingCacheEnabled && !flag)
        {
            clearScrollingCache();
        }
        mScrollingCacheEnabled = flag;
    }

    public abstract void setSelectionInt(int i);

    public void setSelector(int i)
    {
        setSelector(getResources().getDrawable(i));
    }

    public void setSelector(Drawable drawable)
    {
        if (mSelector != null)
        {
            mSelector.setCallback(null);
            unscheduleDrawable(mSelector);
        }
        mSelector = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        mSelectionLeftPadding = rect.left;
        mSelectionTopPadding = rect.top;
        mSelectionRightPadding = rect.right;
        mSelectionBottomPadding = rect.bottom;
        drawable.setCallback(this);
        updateSelectorState();
    }

    public void setSmoothScrollbarEnabled(boolean flag)
    {
        mSmoothScrollbarEnabled = flag;
    }

    public void setStackFromRight(boolean flag)
    {
        if (mStackFromRight != flag)
        {
            mStackFromRight = flag;
            requestLayoutIfNecessary();
        }
    }

    public void setTranscriptMode(int i)
    {
        mTranscriptMode = i;
    }

    public void setVelocityScale(float f)
    {
        mVelocityScale = f;
    }

    protected void setVisibleRangeHint(int i, int j)
    {
    }

    protected boolean shouldShowSelector()
    {
        return hasFocus() && !isInTouchMode() || touchModeDrawsInPressedState();
    }

    public boolean showContextMenu(float f, float f1, int i)
    {
        int j = pointToPosition((int)f, (int)f1);
        if (j != -1)
        {
            long l = mAdapter.getItemId(j);
            View view = getChildAt(j - mFirstPosition);
            if (view != null)
            {
                mContextMenuInfo = createContextMenuInfo(view, j, l);
                return super.showContextMenuForChild(this);
            }
        }
        return showContextMenu(f, f1, i);
    }

    public boolean showContextMenuForChild(View view)
    {
        int i = getPositionForView(view);
        if (i >= 0)
        {
            long l = mAdapter.getItemId(i);
            boolean flag = false;
            if (mOnItemLongClickListener != null)
            {
                flag = mOnItemLongClickListener.onItemLongClick(this, view, i, l);
            }
            boolean flag1 = flag;
            if (!flag)
            {
                mContextMenuInfo = createContextMenuInfo(getChildAt(i - mFirstPosition), i, l);
                flag1 = super.showContextMenuForChild(view);
            }
            return flag1;
        } else
        {
            return false;
        }
    }

    public void smoothScrollBy(int i, int j)
    {
        smoothScrollBy(i, j, false);
    }

    public void smoothScrollBy(int i, int j, boolean flag)
    {
        if (mFlingRunnable == null)
        {
            mFlingRunnable = new FlingRunnable();
        }
        int k = mFirstPosition;
        int l = getChildCount();
        int i1 = getPaddingLeft();
        int j1 = getWidth();
        int k1 = getPaddingRight();
        if (i == 0 || mItemCount == 0 || l == 0 || k == 0 && getChildAt(0).getLeft() == i1 && i < 0 || k + l == mItemCount && getChildAt(l - 1).getRight() == j1 - k1 && i > 0)
        {
            mFlingRunnable.endFling();
            if (mPositionScroller != null)
            {
                mPositionScroller.stop();
            }
            return;
        } else
        {
            reportScrollStateChange(2);
            mFlingRunnable.startScroll(i, j, flag);
            return;
        }
    }

    protected void smoothScrollByOffset(int i)
    {
        int j = -1;
        if (i < 0)
        {
            j = getFirstVisiblePosition();
        } else
        if (i > 0)
        {
            j = getLastVisiblePosition();
        }
        if (j > -1)
        {
            View view = getChildAt(j - getFirstVisiblePosition());
            if (view != null)
            {
                Rect rect = new Rect();
                int k = j;
                if (view.getGlobalVisibleRect(rect))
                {
                    k = view.getWidth();
                    int l = view.getHeight();
                    float f = (float)(rect.width() * rect.height()) / (float)(k * l);
                    if (i < 0 && f < 0.75F)
                    {
                        k = j + 1;
                    } else
                    {
                        k = j;
                        if (i > 0)
                        {
                            k = j;
                            if (f < 0.75F)
                            {
                                k = j - 1;
                            }
                        }
                    }
                }
                smoothScrollToPosition(Math.max(0, Math.min(getCount(), k + i)));
            }
        }
    }

    public void smoothScrollToPosition(int i)
    {
        if (mPositionScroller == null)
        {
            mPositionScroller = new PositionScroller();
        }
        mPositionScroller.start(i);
    }

    public void smoothScrollToPosition(int i, int j)
    {
        if (mPositionScroller == null)
        {
            mPositionScroller = new PositionScroller();
        }
        mPositionScroller.start(i, j);
    }

    public void smoothScrollToPositionFromLeft(int i, int j)
    {
        if (mPositionScroller == null)
        {
            mPositionScroller = new PositionScroller();
        }
        mPositionScroller.startWithOffset(i, j);
    }

    public void smoothScrollToPositionFromLeft(int i, int j, int k)
    {
        if (mPositionScroller == null)
        {
            mPositionScroller = new PositionScroller();
        }
        mPositionScroller.startWithOffset(i, j, k);
    }

    boolean touchModeDrawsInPressedState()
    {
        switch (mTouchMode)
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
            return true;
        }
    }

    boolean trackMotionScroll(int i, int j)
    {
        Object obj;
        int j1;
        int k1;
        int l1;
        int l2;
        int i3;
        int j3;
        int k3;
        i3 = getChildCount();
        if (i3 == 0)
        {
            return true;
        }
        int i2 = getChildAt(0).getLeft();
        int j2 = getChildAt(i3 - 1).getRight();
        obj = mListPadding;
        int k2 = getWidth();
        int k = getWidth() - getPaddingRight() - getPaddingLeft();
        int i1;
        if (i < 0)
        {
            i1 = Math.max(-(k - 1), i);
        } else
        {
            i1 = Math.min(k - 1, i);
        }
        if (j < 0)
        {
            j1 = Math.max(-(k - 1), j);
        } else
        {
            j1 = Math.min(k - 1, j);
        }
        l2 = mFirstPosition;
        if (l2 == 0)
        {
            mFirstPositionDistanceGuess = i2 - ((Rect) (obj)).left;
        } else
        {
            mFirstPositionDistanceGuess = mFirstPositionDistanceGuess + j1;
        }
        if (l2 + i3 == mItemCount)
        {
            mLastPositionDistanceGuess = ((Rect) (obj)).right + j2;
        } else
        {
            mLastPositionDistanceGuess = mLastPositionDistanceGuess + j1;
        }
        if (l2 == 0 && i2 >= ((Rect) (obj)).left && j1 >= 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (l2 + i3 == mItemCount && j2 <= getWidth() - ((Rect) (obj)).right && j1 <= 0)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (i != 0 || j != 0)
        {
            return j1 != 0;
        }
        int l3;
        boolean flag;
        boolean flag1;
        if (j1 < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = isInTouchMode();
        if (flag1)
        {
            hideSelector();
        }
        j3 = getHeaderViewsCount();
        k3 = mItemCount - getFooterViewsCount();
        k1 = 0;
        k = 0;
        j = 0;
        i = 0;
        if (!flag) goto _L2; else goto _L1
_L1:
        l3 = -j1;
        j = 0;
_L7:
        k1 = i;
        l1 = k;
        if (j >= i3) goto _L4; else goto _L3
_L3:
        obj = getChildAt(j);
        if (((View) (obj)).getRight() < l3) goto _L6; else goto _L5
_L5:
        l1 = k;
        k1 = i;
_L4:
        mMotionViewNewLeft = mMotionViewOriginalLeft + i1;
        mBlockLayoutRequests = true;
        if (k1 > 0)
        {
            detachViewsFromParent(l1, k1);
            mRecycler.removeSkippedScrap();
        }
        if (!awakenScrollBars())
        {
            invalidate();
        }
        offsetChildrenLeftAndRight(j1);
        if (flag)
        {
            mFirstPosition = mFirstPosition + k1;
        }
        i = Math.abs(j1);
        if (0 - i2 < i || j2 - (k2 - 0) < i)
        {
            fillGap(flag);
        }
        int l;
        int i4;
        if (!flag1 && mSelectedPosition != -1)
        {
            i = mSelectedPosition - mFirstPosition;
            if (i >= 0 && i < getChildCount())
            {
                positionSelector(mSelectedPosition, getChildAt(i));
            }
        } else
        if (mSelectorPosition != -1)
        {
            i = mSelectorPosition - mFirstPosition;
            if (i >= 0 && i < getChildCount())
            {
                positionSelector(-1, getChildAt(i));
            }
        } else
        {
            mSelectorRect.setEmpty();
        }
        mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        return false;
_L6:
        i++;
        k1 = l2 + j;
        if (k1 >= j3 && k1 < k3)
        {
            mRecycler.addScrapView(((View) (obj)), k1);
        }
        j++;
          goto _L7
_L2:
        i4 = getWidth();
        i = i3 - 1;
        l = k1;
_L10:
        k1 = j;
        l1 = l;
        if (i < 0) goto _L4; else goto _L8
_L8:
        obj = getChildAt(i);
        k1 = j;
        l1 = l;
        if (((View) (obj)).getLeft() <= i4 - j1) goto _L4; else goto _L9
_L9:
        l = i;
        j++;
        k1 = l2 + i;
        if (k1 >= j3 && k1 < k3)
        {
            mRecycler.addScrapView(((View) (obj)), k1);
        }
        i--;
          goto _L10
    }

    protected void updateScrollIndicators()
    {
        boolean flag1 = false;
        int i;
        boolean flag;
        if (mScrollLeft != null)
        {
            if (mFirstPosition > 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            flag = i;
            if (i == 0)
            {
                flag = i;
                View view;
                int j;
                if (getChildCount() > 0)
                {
                    if (getChildAt(0).getLeft() < mListPadding.left)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
            }
            view = mScrollLeft;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (mScrollRight != null)
        {
            j = getChildCount();
            if (mFirstPosition + j < mItemCount)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            flag = i;
            if (i == 0)
            {
                flag = i;
                if (j > 0)
                {
                    if (getChildAt(j - 1).getRight() > getRight() - mListPadding.right)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
            }
            view = mScrollRight;
            if (flag)
            {
                i = ((flag1) ? 1 : 0);
            } else
            {
                i = 4;
            }
            view.setVisibility(i);
        }
    }

    void updateSelectorState()
    {
label0:
        {
            if (mSelector != null)
            {
                if (!shouldShowSelector())
                {
                    break label0;
                }
                mSelector.setState(getDrawableState());
            }
            return;
        }
        mSelector.setState(STATESET_NOTHING);
    }

    public boolean verifyDrawable(Drawable drawable)
    {
        return mSelector == drawable || super.verifyDrawable(drawable);
    }






















/*
    static CheckForLongPress access$502(AbsHListView abshlistview, CheckForLongPress checkforlongpress)
    {
        abshlistview.mPendingCheckForLongPress = checkforlongpress;
        return checkforlongpress;
    }

*/



    // Unreferenced inner class it/sephiroth/android/library/widget/AbsHListView$FlingRunnable$1

/* anonymous class */
    class FlingRunnable._cls1
        implements Runnable
    {

        final FlingRunnable this$1;

        public void run()
        {
            int i = mActivePointerId;
            VelocityTracker velocitytracker = mVelocityTracker;
            OverScroller overscroller = mScroller;
            if (velocitytracker == null || i == -1)
            {
                return;
            }
            velocitytracker.computeCurrentVelocity(1000, mMaximumVelocity);
            float f = -velocitytracker.getXVelocity(i);
            if (Math.abs(f) >= (float)mMinimumVelocity && overscroller.isScrollingInDirection(f, 0.0F))
            {
                postDelayed(this, 40L);
                return;
            } else
            {
                endFling();
                mTouchMode = 3;
                reportScrollStateChange(1);
                return;
            }
        }

            
            {
                this$1 = FlingRunnable.this;
                super();
            }
    }

}
