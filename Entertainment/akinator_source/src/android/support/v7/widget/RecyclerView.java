// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            DefaultItemAnimator, RecyclerViewAccessibilityDelegate, ChildHelper, AdapterHelper

public class RecyclerView extends ViewGroup
{
    public static abstract class Adapter
    {

        private boolean mHasStableIds;
        private final AdapterDataObservable mObservable = new AdapterDataObservable();

        public final void bindViewHolder(ViewHolder viewholder, int i)
        {
            viewholder.mPosition = i;
            if (hasStableIds())
            {
                viewholder.mItemId = getItemId(i);
            }
            onBindViewHolder(viewholder, i);
            viewholder.setFlags(1, 519);
        }

        public final ViewHolder createViewHolder(ViewGroup viewgroup, int i)
        {
            viewgroup = onCreateViewHolder(viewgroup, i);
            viewgroup.mItemViewType = i;
            return viewgroup;
        }

        public abstract int getItemCount();

        public long getItemId(int i)
        {
            return -1L;
        }

        public int getItemViewType(int i)
        {
            return 0;
        }

        public final boolean hasObservers()
        {
            return mObservable.hasObservers();
        }

        public final boolean hasStableIds()
        {
            return mHasStableIds;
        }

        public final void notifyDataSetChanged()
        {
            mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int i)
        {
            mObservable.notifyItemRangeChanged(i, 1);
        }

        public final void notifyItemInserted(int i)
        {
            mObservable.notifyItemRangeInserted(i, 1);
        }

        public final void notifyItemMoved(int i, int j)
        {
            mObservable.notifyItemMoved(i, j);
        }

        public final void notifyItemRangeChanged(int i, int j)
        {
            mObservable.notifyItemRangeChanged(i, j);
        }

        public final void notifyItemRangeInserted(int i, int j)
        {
            mObservable.notifyItemRangeInserted(i, j);
        }

        public final void notifyItemRangeRemoved(int i, int j)
        {
            mObservable.notifyItemRangeRemoved(i, j);
        }

        public final void notifyItemRemoved(int i)
        {
            mObservable.notifyItemRangeRemoved(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerview)
        {
        }

        public abstract void onBindViewHolder(ViewHolder viewholder, int i);

        public abstract ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerview)
        {
        }

        public boolean onFailedToRecycleView(ViewHolder viewholder)
        {
            return false;
        }

        public void onViewAttachedToWindow(ViewHolder viewholder)
        {
        }

        public void onViewDetachedFromWindow(ViewHolder viewholder)
        {
        }

        public void onViewRecycled(ViewHolder viewholder)
        {
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterdataobserver)
        {
            mObservable.registerObserver(adapterdataobserver);
        }

        public void setHasStableIds(boolean flag)
        {
            if (hasObservers())
            {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            } else
            {
                mHasStableIds = flag;
                return;
            }
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterdataobserver)
        {
            mObservable.unregisterObserver(adapterdataobserver);
        }

        public Adapter()
        {
            mHasStableIds = false;
        }
    }

    static class AdapterDataObservable extends Observable
    {

        public boolean hasObservers()
        {
            return !mObservers.isEmpty();
        }

        public void notifyChanged()
        {
            for (int i = mObservers.size() - 1; i >= 0; i--)
            {
                ((AdapterDataObserver)mObservers.get(i)).onChanged();
            }

        }

        public void notifyItemMoved(int i, int j)
        {
            for (int k = mObservers.size() - 1; k >= 0; k--)
            {
                ((AdapterDataObserver)mObservers.get(k)).onItemRangeMoved(i, j, 1);
            }

        }

        public void notifyItemRangeChanged(int i, int j)
        {
            for (int k = mObservers.size() - 1; k >= 0; k--)
            {
                ((AdapterDataObserver)mObservers.get(k)).onItemRangeChanged(i, j);
            }

        }

        public void notifyItemRangeInserted(int i, int j)
        {
            for (int k = mObservers.size() - 1; k >= 0; k--)
            {
                ((AdapterDataObserver)mObservers.get(k)).onItemRangeInserted(i, j);
            }

        }

        public void notifyItemRangeRemoved(int i, int j)
        {
            for (int k = mObservers.size() - 1; k >= 0; k--)
            {
                ((AdapterDataObserver)mObservers.get(k)).onItemRangeRemoved(i, j);
            }

        }

        AdapterDataObservable()
        {
        }
    }

    public static abstract class AdapterDataObserver
    {

        public void onChanged()
        {
        }

        public void onItemRangeChanged(int i, int j)
        {
        }

        public void onItemRangeInserted(int i, int j)
        {
        }

        public void onItemRangeMoved(int i, int j, int k)
        {
        }

        public void onItemRangeRemoved(int i, int j)
        {
        }

        public AdapterDataObserver()
        {
        }
    }

    public static abstract class ItemAnimator
    {

        private long mAddDuration;
        private long mChangeDuration;
        private ArrayList mFinishedListeners;
        private ItemAnimatorListener mListener;
        private long mMoveDuration;
        private long mRemoveDuration;
        private boolean mSupportsChangeAnimations;

        public abstract boolean animateAdd(ViewHolder viewholder);

        public abstract boolean animateChange(ViewHolder viewholder, ViewHolder viewholder1, int i, int j, int k, int l);

        public abstract boolean animateMove(ViewHolder viewholder, int i, int j, int k, int l);

        public abstract boolean animateRemove(ViewHolder viewholder);

        public final void dispatchAddFinished(ViewHolder viewholder)
        {
            onAddFinished(viewholder);
            if (mListener != null)
            {
                mListener.onAddFinished(viewholder);
            }
        }

        public final void dispatchAddStarting(ViewHolder viewholder)
        {
            onAddStarting(viewholder);
        }

        public final void dispatchAnimationsFinished()
        {
            int j = mFinishedListeners.size();
            for (int i = 0; i < j; i++)
            {
                ((ItemAnimatorFinishedListener)mFinishedListeners.get(i)).onAnimationsFinished();
            }

            mFinishedListeners.clear();
        }

        public final void dispatchChangeFinished(ViewHolder viewholder, boolean flag)
        {
            onChangeFinished(viewholder, flag);
            if (mListener != null)
            {
                mListener.onChangeFinished(viewholder);
            }
        }

        public final void dispatchChangeStarting(ViewHolder viewholder, boolean flag)
        {
            onChangeStarting(viewholder, flag);
        }

        public final void dispatchMoveFinished(ViewHolder viewholder)
        {
            onMoveFinished(viewholder);
            if (mListener != null)
            {
                mListener.onMoveFinished(viewholder);
            }
        }

        public final void dispatchMoveStarting(ViewHolder viewholder)
        {
            onMoveStarting(viewholder);
        }

        public final void dispatchRemoveFinished(ViewHolder viewholder)
        {
            onRemoveFinished(viewholder);
            if (mListener != null)
            {
                mListener.onRemoveFinished(viewholder);
            }
        }

        public final void dispatchRemoveStarting(ViewHolder viewholder)
        {
            onRemoveStarting(viewholder);
        }

        public abstract void endAnimation(ViewHolder viewholder);

        public abstract void endAnimations();

        public long getAddDuration()
        {
            return mAddDuration;
        }

        public long getChangeDuration()
        {
            return mChangeDuration;
        }

        public long getMoveDuration()
        {
            return mMoveDuration;
        }

        public long getRemoveDuration()
        {
            return mRemoveDuration;
        }

        public boolean getSupportsChangeAnimations()
        {
            return mSupportsChangeAnimations;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(ItemAnimatorFinishedListener itemanimatorfinishedlistener)
        {
            boolean flag;
label0:
            {
                flag = isRunning();
                if (itemanimatorfinishedlistener != null)
                {
                    if (flag)
                    {
                        break label0;
                    }
                    itemanimatorfinishedlistener.onAnimationsFinished();
                }
                return flag;
            }
            mFinishedListeners.add(itemanimatorfinishedlistener);
            return flag;
        }

        public void onAddFinished(ViewHolder viewholder)
        {
        }

        public void onAddStarting(ViewHolder viewholder)
        {
        }

        public void onChangeFinished(ViewHolder viewholder, boolean flag)
        {
        }

        public void onChangeStarting(ViewHolder viewholder, boolean flag)
        {
        }

        public void onMoveFinished(ViewHolder viewholder)
        {
        }

        public void onMoveStarting(ViewHolder viewholder)
        {
        }

        public void onRemoveFinished(ViewHolder viewholder)
        {
        }

        public void onRemoveStarting(ViewHolder viewholder)
        {
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long l)
        {
            mAddDuration = l;
        }

        public void setChangeDuration(long l)
        {
            mChangeDuration = l;
        }

        void setListener(ItemAnimatorListener itemanimatorlistener)
        {
            mListener = itemanimatorlistener;
        }

        public void setMoveDuration(long l)
        {
            mMoveDuration = l;
        }

        public void setRemoveDuration(long l)
        {
            mRemoveDuration = l;
        }

        public void setSupportsChangeAnimations(boolean flag)
        {
            mSupportsChangeAnimations = flag;
        }

        public ItemAnimator()
        {
            mListener = null;
            mFinishedListeners = new ArrayList();
            mAddDuration = 120L;
            mRemoveDuration = 120L;
            mMoveDuration = 250L;
            mChangeDuration = 250L;
            mSupportsChangeAnimations = true;
        }
    }

    public static interface ItemAnimator.ItemAnimatorFinishedListener
    {

        public abstract void onAnimationsFinished();
    }

    static interface ItemAnimator.ItemAnimatorListener
    {

        public abstract void onAddFinished(ViewHolder viewholder);

        public abstract void onChangeFinished(ViewHolder viewholder);

        public abstract void onMoveFinished(ViewHolder viewholder);

        public abstract void onRemoveFinished(ViewHolder viewholder);
    }

    private class ItemAnimatorRestoreListener
        implements ItemAnimator.ItemAnimatorListener
    {

        final RecyclerView this$0;

        public void onAddFinished(ViewHolder viewholder)
        {
            viewholder.setIsRecyclable(true);
            if (!viewholder.shouldBeKeptAsChild())
            {
                removeAnimatingView(viewholder.itemView);
            }
        }

        public void onChangeFinished(ViewHolder viewholder)
        {
            viewholder.setIsRecyclable(true);
            if (viewholder.mShadowedHolder != null && viewholder.mShadowingHolder == null)
            {
                viewholder.mShadowedHolder = null;
                viewholder.setFlags(-65, viewholder.mFlags);
            }
            viewholder.mShadowingHolder = null;
            if (!viewholder.shouldBeKeptAsChild())
            {
                removeAnimatingView(viewholder.itemView);
            }
        }

        public void onMoveFinished(ViewHolder viewholder)
        {
            viewholder.setIsRecyclable(true);
            if (!viewholder.shouldBeKeptAsChild())
            {
                removeAnimatingView(viewholder.itemView);
            }
        }

        public void onRemoveFinished(ViewHolder viewholder)
        {
            viewholder.setIsRecyclable(true);
            if (!removeAnimatingView(viewholder.itemView) && viewholder.isTmpDetached())
            {
                removeDetachedView(viewholder.itemView, false);
            }
        }

        private ItemAnimatorRestoreListener()
        {
            this$0 = RecyclerView.this;
            super();
        }

    }

    public static abstract class ItemDecoration
    {

        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerview)
        {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, State state)
        {
            getItemOffsets(rect, ((LayoutParams)view.getLayoutParams()).getViewLayoutPosition(), recyclerview);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerview)
        {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerview, State state)
        {
            onDraw(canvas, recyclerview);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerview)
        {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerview, State state)
        {
            onDrawOver(canvas, recyclerview);
        }

        public ItemDecoration()
        {
        }
    }

    private static class ItemHolderInfo
    {

        int bottom;
        ViewHolder holder;
        int left;
        int right;
        int top;

        ItemHolderInfo(ViewHolder viewholder, int i, int j, int k, int l)
        {
            holder = viewholder;
            left = i;
            top = j;
            right = k;
            bottom = l;
        }
    }

    public static abstract class LayoutManager
    {

        ChildHelper mChildHelper;
        RecyclerView mRecyclerView;
        private boolean mRequestedSimpleAnimations;
        SmoothScroller mSmoothScroller;

        private void addViewInt(View view, int i, boolean flag)
        {
            ViewHolder viewholder;
            LayoutParams layoutparams;
            viewholder = RecyclerView.getChildViewHolderInt(view);
            if (flag || viewholder.isRemoved())
            {
                mRecyclerView.addToDisappearingList(view);
            } else
            {
                mRecyclerView.removeFromDisappearingList(view);
            }
            layoutparams = (LayoutParams)view.getLayoutParams();
            if (!viewholder.wasReturnedFromScrap() && !viewholder.isScrap()) goto _L2; else goto _L1
_L1:
            if (viewholder.isScrap())
            {
                viewholder.unScrap();
            } else
            {
                viewholder.clearReturnedFromScrapFlag();
            }
            mChildHelper.attachViewToParent(view, i, view.getLayoutParams(), false);
_L4:
            if (layoutparams.mPendingInvalidate)
            {
                viewholder.itemView.invalidate();
                layoutparams.mPendingInvalidate = false;
            }
            return;
_L2:
            if (view.getParent() == mRecyclerView)
            {
                int k = mChildHelper.indexOfChild(view);
                int j = i;
                if (i == -1)
                {
                    j = mChildHelper.getChildCount();
                }
                if (k == -1)
                {
                    throw new IllegalStateException((new StringBuilder()).append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:").append(mRecyclerView.indexOfChild(view)).toString());
                }
                if (k != j)
                {
                    mRecyclerView.mLayout.moveView(k, j);
                }
            } else
            {
                mChildHelper.addView(view, i, false);
                layoutparams.mInsetsDirty = true;
                if (mSmoothScroller != null && mSmoothScroller.isRunning())
                {
                    mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void detachViewInternal(int i, View view)
        {
            mChildHelper.detachViewFromParent(i);
        }

        public static int getChildMeasureSpec(int i, int j, int k, boolean flag)
        {
            int l;
            l = Math.max(0, i - j);
            j = 0;
            i = 0;
            if (!flag) goto _L2; else goto _L1
_L1:
            if (k >= 0)
            {
                j = k;
                i = 0x40000000;
            } else
            {
                j = 0;
                i = 0;
            }
_L4:
            return android.view.View.MeasureSpec.makeMeasureSpec(j, i);
_L2:
            if (k >= 0)
            {
                j = k;
                i = 0x40000000;
            } else
            if (k == -1)
            {
                j = l;
                i = 0x40000000;
            } else
            if (k == -2)
            {
                j = l;
                i = 0x80000000;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void onSmoothScrollerStopped(SmoothScroller smoothscroller)
        {
            if (mSmoothScroller == smoothscroller)
            {
                mSmoothScroller = null;
            }
        }

        private void scrapOrRecycleView(Recycler recycler, int i, View view)
        {
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder.shouldIgnore())
            {
                return;
            }
            if (viewholder.isInvalid() && !viewholder.isRemoved() && !viewholder.isChanged() && !mRecyclerView.mAdapter.hasStableIds())
            {
                removeViewAt(i);
                recycler.recycleViewHolderInternal(viewholder);
                return;
            } else
            {
                detachViewAt(i);
                recycler.scrapView(view);
                return;
            }
        }

        public void addDisappearingView(View view)
        {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i)
        {
            addViewInt(view, i, true);
        }

        public void addView(View view)
        {
            addView(view, -1);
        }

        public void addView(View view, int i)
        {
            addViewInt(view, i, false);
        }

        public void assertInLayoutOrScroll(String s)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.assertInLayoutOrScroll(s);
            }
        }

        public void assertNotInLayoutOrScroll(String s)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.assertNotInLayoutOrScroll(s);
            }
        }

        public void attachView(View view)
        {
            attachView(view, -1);
        }

        public void attachView(View view, int i)
        {
            attachView(view, i, (LayoutParams)view.getLayoutParams());
        }

        public void attachView(View view, int i, LayoutParams layoutparams)
        {
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder.isRemoved())
            {
                mRecyclerView.addToDisappearingList(view);
            } else
            {
                mRecyclerView.removeFromDisappearingList(view);
            }
            mChildHelper.attachViewToParent(view, i, layoutparams, viewholder.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect)
        {
            if (mRecyclerView == null)
            {
                rect.set(0, 0, 0, 0);
                return;
            } else
            {
                rect.set(mRecyclerView.getItemDecorInsetsForChild(view));
                return;
            }
        }

        public boolean canScrollHorizontally()
        {
            return false;
        }

        public boolean canScrollVertically()
        {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutparams)
        {
            return layoutparams != null;
        }

        public int computeHorizontalScrollExtent(State state)
        {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state)
        {
            return 0;
        }

        public int computeHorizontalScrollRange(State state)
        {
            return 0;
        }

        public int computeVerticalScrollExtent(State state)
        {
            return 0;
        }

        public int computeVerticalScrollOffset(State state)
        {
            return 0;
        }

        public int computeVerticalScrollRange(State state)
        {
            return 0;
        }

        public void detachAndScrapAttachedViews(Recycler recycler)
        {
            for (int i = getChildCount() - 1; i >= 0; i--)
            {
                scrapOrRecycleView(recycler, i, getChildAt(i));
            }

        }

        public void detachAndScrapView(View view, Recycler recycler)
        {
            scrapOrRecycleView(recycler, mChildHelper.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int i, Recycler recycler)
        {
            scrapOrRecycleView(recycler, i, getChildAt(i));
        }

        public void detachView(View view)
        {
            int i = mChildHelper.indexOfChild(view);
            if (i >= 0)
            {
                detachViewInternal(i, view);
            }
        }

        public void detachViewAt(int i)
        {
            detachViewInternal(i, getChildAt(i));
        }

        public void endAnimation(View view)
        {
            if (mRecyclerView.mItemAnimator != null)
            {
                mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findViewByPosition(int i)
        {
            int j;
            int k;
            k = getChildCount();
            j = 0;
_L3:
            View view;
            ViewHolder viewholder;
            if (j >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            view = getChildAt(j);
            viewholder = RecyclerView.getChildViewHolderInt(view);
              goto _L1
_L5:
            j++;
            if (true) goto _L3; else goto _L2
_L1:
            if (viewholder == null || viewholder.getLayoutPosition() != i || viewholder.shouldIgnore() || !mRecyclerView.mState.isPreLayout() && viewholder.isRemoved()) goto _L5; else goto _L4
_L4:
            return view;
_L2:
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeset)
        {
            return new LayoutParams(context, attributeset);
        }

        public LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            if (layoutparams instanceof LayoutParams)
            {
                return new LayoutParams((LayoutParams)layoutparams);
            }
            if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
            {
                return new LayoutParams((android.view.ViewGroup.MarginLayoutParams)layoutparams);
            } else
            {
                return new LayoutParams(layoutparams);
            }
        }

        public int getBottomDecorationHeight(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).mDecorInsets.bottom;
        }

        public View getChildAt(int i)
        {
            if (mChildHelper != null)
            {
                return mChildHelper.getChildAt(i);
            } else
            {
                return null;
            }
        }

        public int getChildCount()
        {
            if (mChildHelper != null)
            {
                return mChildHelper.getChildCount();
            } else
            {
                return 0;
            }
        }

        public boolean getClipToPadding()
        {
            return mRecyclerView != null && mRecyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state)
        {
            while (mRecyclerView == null || mRecyclerView.mAdapter == null || !canScrollHorizontally()) 
            {
                return 1;
            }
            return mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(View view)
        {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public int getDecoratedLeft(View view)
        {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view)
        {
            Rect rect = ((LayoutParams)view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view)
        {
            Rect rect = ((LayoutParams)view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view)
        {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view)
        {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild()
        {
            if (mRecyclerView != null) goto _L2; else goto _L1
_L1:
            View view = null;
_L4:
            return view;
_L2:
            View view1;
            view1 = mRecyclerView.getFocusedChild();
            if (view1 == null)
            {
                break; /* Loop/switch isn't completed */
            }
            view = view1;
            if (!mChildHelper.isHidden(view1)) goto _L4; else goto _L3
_L3:
            return null;
        }

        public int getHeight()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getHeight();
            } else
            {
                return 0;
            }
        }

        public int getItemCount()
        {
            Adapter adapter;
            if (mRecyclerView != null)
            {
                adapter = mRecyclerView.getAdapter();
            } else
            {
                adapter = null;
            }
            if (adapter != null)
            {
                return adapter.getItemCount();
            } else
            {
                return 0;
            }
        }

        public int getItemViewType(View view)
        {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection()
        {
            return ViewCompat.getLayoutDirection(mRecyclerView);
        }

        public int getLeftDecorationWidth(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).mDecorInsets.left;
        }

        public int getMinimumHeight()
        {
            return ViewCompat.getMinimumHeight(mRecyclerView);
        }

        public int getMinimumWidth()
        {
            return ViewCompat.getMinimumWidth(mRecyclerView);
        }

        public int getPaddingBottom()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingBottom();
            } else
            {
                return 0;
            }
        }

        public int getPaddingEnd()
        {
            if (mRecyclerView != null)
            {
                return ViewCompat.getPaddingEnd(mRecyclerView);
            } else
            {
                return 0;
            }
        }

        public int getPaddingLeft()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingLeft();
            } else
            {
                return 0;
            }
        }

        public int getPaddingRight()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingRight();
            } else
            {
                return 0;
            }
        }

        public int getPaddingStart()
        {
            if (mRecyclerView != null)
            {
                return ViewCompat.getPaddingStart(mRecyclerView);
            } else
            {
                return 0;
            }
        }

        public int getPaddingTop()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getPaddingTop();
            } else
            {
                return 0;
            }
        }

        public int getPosition(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state)
        {
            while (mRecyclerView == null || mRecyclerView.mAdapter == null || !canScrollVertically()) 
            {
                return 1;
            }
            return mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state)
        {
            return 0;
        }

        public int getTopDecorationHeight(View view)
        {
            return ((LayoutParams)view.getLayoutParams()).mDecorInsets.top;
        }

        public int getWidth()
        {
            if (mRecyclerView != null)
            {
                return mRecyclerView.getWidth();
            } else
            {
                return 0;
            }
        }

        public boolean hasFocus()
        {
            return mRecyclerView != null && mRecyclerView.hasFocus();
        }

        public void ignoreView(View view)
        {
            if (view.getParent() != mRecyclerView || mRecyclerView.indexOfChild(view) == -1)
            {
                throw new IllegalArgumentException("View should be fully attached to be ignored");
            } else
            {
                view = RecyclerView.getChildViewHolderInt(view);
                view.addFlags(128);
                mRecyclerView.mState.onViewIgnored(view);
                return;
            }
        }

        public boolean isFocused()
        {
            return mRecyclerView != null && mRecyclerView.isFocused();
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state)
        {
            return false;
        }

        public boolean isSmoothScrolling()
        {
            return mSmoothScroller != null && mSmoothScroller.isRunning();
        }

        public void layoutDecorated(View view, int i, int j, int k, int l)
        {
            Rect rect = ((LayoutParams)view.getLayoutParams()).mDecorInsets;
            view.layout(rect.left + i, rect.top + j, k - rect.right, l - rect.bottom);
        }

        public void measureChild(View view, int i, int j)
        {
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            Rect rect = mRecyclerView.getItemDecorInsetsForChild(view);
            int k = rect.left;
            int l = rect.right;
            int i1 = rect.top;
            int j1 = rect.bottom;
            view.measure(getChildMeasureSpec(getWidth(), getPaddingLeft() + getPaddingRight() + (i + (k + l)), layoutparams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), getPaddingTop() + getPaddingBottom() + (j + (i1 + j1)), layoutparams.height, canScrollVertically()));
        }

        public void measureChildWithMargins(View view, int i, int j)
        {
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            Rect rect = mRecyclerView.getItemDecorInsetsForChild(view);
            int k = rect.left;
            int l = rect.right;
            int i1 = rect.top;
            int j1 = rect.bottom;
            view.measure(getChildMeasureSpec(getWidth(), getPaddingLeft() + getPaddingRight() + layoutparams.leftMargin + layoutparams.rightMargin + (i + (k + l)), layoutparams.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), getPaddingTop() + getPaddingBottom() + layoutparams.topMargin + layoutparams.bottomMargin + (j + (i1 + j1)), layoutparams.height, canScrollVertically()));
        }

        public void moveView(int i, int j)
        {
            View view = getChildAt(i);
            if (view == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Cannot move a child from non-existing index:").append(i).toString());
            } else
            {
                detachViewAt(i);
                attachView(view, j);
                return;
            }
        }

        public void offsetChildrenHorizontal(int i)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i)
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter1)
        {
        }

        public boolean onAddFocusables(RecyclerView recyclerview, ArrayList arraylist, int i, int j)
        {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerview)
        {
        }

        public void onDetachedFromWindow(RecyclerView recyclerview)
        {
        }

        public void onDetachedFromWindow(RecyclerView recyclerview, Recycler recycler)
        {
            onDetachedFromWindow(recyclerview);
        }

        public View onFocusSearchFailed(View view, int i, Recycler recycler, State state)
        {
            return null;
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityevent)
        {
            boolean flag1 = true;
            recycler = AccessibilityEventCompat.asRecord(accessibilityevent);
            if (mRecyclerView != null && recycler != null)
            {
                boolean flag = flag1;
                if (!ViewCompat.canScrollVertically(mRecyclerView, 1))
                {
                    flag = flag1;
                    if (!ViewCompat.canScrollVertically(mRecyclerView, -1))
                    {
                        flag = flag1;
                        if (!ViewCompat.canScrollHorizontally(mRecyclerView, -1))
                        {
                            if (ViewCompat.canScrollHorizontally(mRecyclerView, 1))
                            {
                                flag = flag1;
                            } else
                            {
                                flag = false;
                            }
                        }
                    }
                }
                recycler.setScrollable(flag);
                if (mRecyclerView.mAdapter != null)
                {
                    recycler.setItemCount(mRecyclerView.mAdapter.getItemCount());
                    return;
                }
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
        {
            onInitializeAccessibilityEvent(mRecyclerView.mRecycler, mRecyclerView.mState, accessibilityevent);
        }

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
        {
            onInitializeAccessibilityNodeInfo(mRecyclerView.mRecycler, mRecyclerView.mState, accessibilitynodeinfocompat);
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
        {
            accessibilitynodeinfocompat.setClassName(android/support/v7/widget/RecyclerView.getName());
            if (ViewCompat.canScrollVertically(mRecyclerView, -1) || ViewCompat.canScrollHorizontally(mRecyclerView, -1))
            {
                accessibilitynodeinfocompat.addAction(8192);
                accessibilitynodeinfocompat.setScrollable(true);
            }
            if (ViewCompat.canScrollVertically(mRecyclerView, 1) || ViewCompat.canScrollHorizontally(mRecyclerView, 1))
            {
                accessibilitynodeinfocompat.addAction(4096);
                accessibilitynodeinfocompat.setScrollable(true);
            }
            accessibilitynodeinfocompat.setCollectionInfo(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
        {
            int i;
            int j;
            if (canScrollVertically())
            {
                i = getPosition(view);
            } else
            {
                i = 0;
            }
            if (canScrollHorizontally())
            {
                j = getPosition(view);
            } else
            {
                j = 0;
            }
            accessibilitynodeinfocompat.setCollectionItemInfo(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, 1, false, false));
        }

        void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilitynodeinfocompat)
        {
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder != null && !viewholder.isRemoved())
            {
                onInitializeAccessibilityNodeInfoForItem(mRecyclerView.mRecycler, mRecyclerView.mState, view, accessibilitynodeinfocompat);
            }
        }

        public View onInterceptFocusSearch(View view, int i)
        {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerview, int i, int j)
        {
        }

        public void onItemsChanged(RecyclerView recyclerview)
        {
        }

        public void onItemsMoved(RecyclerView recyclerview, int i, int j, int k)
        {
        }

        public void onItemsRemoved(RecyclerView recyclerview, int i, int j)
        {
        }

        public void onItemsUpdated(RecyclerView recyclerview, int i, int j)
        {
        }

        public void onLayoutChildren(Recycler recycler, State state)
        {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onMeasure(Recycler recycler, State state, int i, int j)
        {
            mRecyclerView.defaultOnMeasure(i, j);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerview, State state, View view, View view1)
        {
            return onRequestChildFocus(recyclerview, view, view1);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerview, View view, View view1)
        {
            return isSmoothScrolling() || recyclerview.mRunningLayoutOrScroll;
        }

        public void onRestoreInstanceState(Parcelable parcelable)
        {
        }

        public Parcelable onSaveInstanceState()
        {
            return null;
        }

        public void onScrollStateChanged(int i)
        {
        }

        boolean performAccessibilityAction(int i, Bundle bundle)
        {
            return performAccessibilityAction(mRecyclerView.mRecycler, mRecyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityAction(Recycler recycler, State state, int i, Bundle bundle)
        {
            if (mRecyclerView != null) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            int l;
            boolean flag1;
            boolean flag2;
            flag1 = false;
            flag2 = false;
            boolean flag = false;
            l = 0;
            switch (i)
            {
            default:
                i = ((flag) ? 1 : 0);
                break;

            case 4096: 
                break MISSING_BLOCK_LABEL_141;

            case 8192: 
                break; /* Loop/switch isn't completed */
            }
_L4:
            if (i != 0 || l != 0)
            {
                mRecyclerView.scrollBy(l, i);
                return true;
            }
            if (true) goto _L1; else goto _L3
_L3:
            int j = ((flag1) ? 1 : 0);
            if (ViewCompat.canScrollVertically(mRecyclerView, -1))
            {
                j = -(getHeight() - getPaddingTop() - getPaddingBottom());
            }
            i = j;
            if (ViewCompat.canScrollHorizontally(mRecyclerView, -1))
            {
                l = -(getWidth() - getPaddingLeft() - getPaddingRight());
                i = j;
            }
              goto _L4
            int k = ((flag2) ? 1 : 0);
            if (ViewCompat.canScrollVertically(mRecyclerView, 1))
            {
                k = getHeight() - getPaddingTop() - getPaddingBottom();
            }
            i = k;
            if (ViewCompat.canScrollHorizontally(mRecyclerView, 1))
            {
                l = getWidth() - getPaddingLeft() - getPaddingRight();
                i = k;
            }
              goto _L4
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int i, Bundle bundle)
        {
            return false;
        }

        boolean performAccessibilityActionForItem(View view, int i, Bundle bundle)
        {
            return performAccessibilityActionForItem(mRecyclerView.mRecycler, mRecyclerView.mState, view, i, bundle);
        }

        public void removeAllViews()
        {
            for (int i = getChildCount() - 1; i >= 0; i--)
            {
                mChildHelper.removeViewAt(i);
            }

        }

        public void removeAndRecycleAllViews(Recycler recycler)
        {
            for (int i = getChildCount() - 1; i >= 0; i--)
            {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(i)).shouldIgnore())
                {
                    removeAndRecycleViewAt(i, recycler);
                }
            }

        }

        void removeAndRecycleScrapInt(Recycler recycler)
        {
            int j = recycler.getScrapCount();
            int i = 0;
            while (i < j) 
            {
                View view = recycler.getScrapViewAt(i);
                ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
                if (!viewholder.shouldIgnore())
                {
                    if (viewholder.isTmpDetached())
                    {
                        mRecyclerView.removeDetachedView(view, false);
                    }
                    recycler.quickRecycleScrapView(view);
                }
                i++;
            }
            recycler.clearScrap();
            if (j > 0)
            {
                mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, Recycler recycler)
        {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i, Recycler recycler)
        {
            View view = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(view);
        }

        public void removeDetachedView(View view)
        {
            mRecyclerView.removeDetachedView(view, false);
        }

        public void removeView(View view)
        {
            mChildHelper.removeView(view);
        }

        public void removeViewAt(int i)
        {
            if (getChildAt(i) != null)
            {
                mChildHelper.removeViewAt(i);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerview, View view, Rect rect, boolean flag)
        {
            int i = getPaddingLeft();
            int k = getPaddingTop();
            int j = getWidth();
            int l1 = getPaddingRight();
            int l = getHeight();
            int i1 = getPaddingBottom();
            int i2 = view.getLeft() + rect.left;
            int j1 = view.getTop() + rect.top;
            int j2 = rect.width();
            int k1 = rect.height();
            i = Math.min(0, i2 - i);
            k = Math.min(0, j1 - k);
            j = Math.max(0, (i2 + j2) - (j - l1));
            l = Math.max(0, (j1 + k1) - (l - i1));
            if (ViewCompat.getLayoutDirection(recyclerview) == 1)
            {
                if (j != 0)
                {
                    i = j;
                }
            } else
            if (i == 0)
            {
                i = j;
            }
            if (k != 0)
            {
                j = k;
            } else
            {
                j = l;
            }
            if (i != 0 || j != 0)
            {
                if (flag)
                {
                    recyclerview.scrollBy(i, j);
                } else
                {
                    recyclerview.smoothScrollBy(i, j);
                }
                return true;
            } else
            {
                return false;
            }
        }

        public void requestLayout()
        {
            if (mRecyclerView != null)
            {
                mRecyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout()
        {
            mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i, Recycler recycler, State state)
        {
            return 0;
        }

        public void scrollToPosition(int i)
        {
        }

        public int scrollVerticallyBy(int i, Recycler recycler, State state)
        {
            return 0;
        }

        public void setMeasuredDimension(int i, int j)
        {
            mRecyclerView.setMeasuredDimension(i, j);
        }

        void setRecyclerView(RecyclerView recyclerview)
        {
            if (recyclerview == null)
            {
                mRecyclerView = null;
                mChildHelper = null;
                return;
            } else
            {
                mRecyclerView = recyclerview;
                mChildHelper = recyclerview.mChildHelper;
                return;
            }
        }

        public void smoothScrollToPosition(RecyclerView recyclerview, State state, int i)
        {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller smoothscroller)
        {
            if (mSmoothScroller != null && smoothscroller != mSmoothScroller && mSmoothScroller.isRunning())
            {
                mSmoothScroller.stop();
            }
            mSmoothScroller = smoothscroller;
            mSmoothScroller.start(mRecyclerView, this);
        }

        public void stopIgnoringView(View view)
        {
            view = RecyclerView.getChildViewHolderInt(view);
            view.stopIgnoring();
            view.resetInternal();
            view.addFlags(4);
        }

        void stopSmoothScroller()
        {
            if (mSmoothScroller != null)
            {
                mSmoothScroller.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations()
        {
            return false;
        }



/*
        static boolean access$1702(LayoutManager layoutmanager, boolean flag)
        {
            layoutmanager.mRequestedSimpleAnimations = flag;
            return flag;
        }

*/


        public LayoutManager()
        {
            mRequestedSimpleAnimations = false;
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams
    {

        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public int getViewAdapterPosition()
        {
            return mViewHolder.getAdapterPosition();
        }

        public int getViewLayoutPosition()
        {
            return mViewHolder.getLayoutPosition();
        }

        public int getViewPosition()
        {
            return mViewHolder.getPosition();
        }

        public boolean isItemChanged()
        {
            return mViewHolder.isChanged();
        }

        public boolean isItemRemoved()
        {
            return mViewHolder.isRemoved();
        }

        public boolean isViewInvalid()
        {
            return mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate()
        {
            return mViewHolder.needsUpdate();
        }

        public LayoutParams(int i, int j)
        {
            super(i, j);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams layoutparams)
        {
            super(layoutparams);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
            mDecorInsets = new Rect();
            mInsetsDirty = true;
            mPendingInvalidate = false;
        }
    }

    public static interface OnItemTouchListener
    {

        public abstract boolean onInterceptTouchEvent(RecyclerView recyclerview, MotionEvent motionevent);

        public abstract void onTouchEvent(RecyclerView recyclerview, MotionEvent motionevent);
    }

    public static abstract class OnScrollListener
    {

        public void onScrollStateChanged(RecyclerView recyclerview, int i)
        {
        }

        public void onScrolled(RecyclerView recyclerview, int i, int j)
        {
        }

        public OnScrollListener()
        {
        }
    }

    public static class RecycledViewPool
    {

        private static final int DEFAULT_MAX_SCRAP = 5;
        private int mAttachCount;
        private SparseIntArray mMaxScrap;
        private SparseArray mScrap;

        private ArrayList getScrapHeapForType(int i)
        {
            ArrayList arraylist1 = (ArrayList)mScrap.get(i);
            ArrayList arraylist = arraylist1;
            if (arraylist1 == null)
            {
                ArrayList arraylist2 = new ArrayList();
                mScrap.put(i, arraylist2);
                arraylist = arraylist2;
                if (mMaxScrap.indexOfKey(i) < 0)
                {
                    mMaxScrap.put(i, 5);
                    arraylist = arraylist2;
                }
            }
            return arraylist;
        }

        void attach(Adapter adapter)
        {
            mAttachCount = mAttachCount + 1;
        }

        public void clear()
        {
            mScrap.clear();
        }

        void detach()
        {
            mAttachCount = mAttachCount - 1;
        }

        public ViewHolder getRecycledView(int i)
        {
            ArrayList arraylist = (ArrayList)mScrap.get(i);
            if (arraylist != null && !arraylist.isEmpty())
            {
                i = arraylist.size() - 1;
                ViewHolder viewholder = (ViewHolder)arraylist.get(i);
                arraylist.remove(i);
                return viewholder;
            } else
            {
                return null;
            }
        }

        void onAdapterChanged(Adapter adapter, Adapter adapter1, boolean flag)
        {
            if (adapter != null)
            {
                detach();
            }
            if (!flag && mAttachCount == 0)
            {
                clear();
            }
            if (adapter1 != null)
            {
                attach(adapter1);
            }
        }

        public void putRecycledView(ViewHolder viewholder)
        {
            int i = viewholder.getItemViewType();
            ArrayList arraylist = getScrapHeapForType(i);
            if (mMaxScrap.get(i) <= arraylist.size())
            {
                return;
            } else
            {
                viewholder.resetInternal();
                arraylist.add(viewholder);
                return;
            }
        }

        public void setMaxRecycledViews(int i, int j)
        {
            mMaxScrap.put(i, j);
            ArrayList arraylist = (ArrayList)mScrap.get(i);
            if (arraylist != null)
            {
                for (; arraylist.size() > j; arraylist.remove(arraylist.size() - 1)) { }
            }
        }

        int size()
        {
            int j = 0;
            for (int i = 0; i < mScrap.size();)
            {
                ArrayList arraylist = (ArrayList)mScrap.valueAt(i);
                int k = j;
                if (arraylist != null)
                {
                    k = j + arraylist.size();
                }
                i++;
                j = k;
            }

            return j;
        }

        public RecycledViewPool()
        {
            mScrap = new SparseArray();
            mMaxScrap = new SparseIntArray();
            mAttachCount = 0;
        }
    }

    public final class Recycler
    {

        private static final int DEFAULT_CACHE_SIZE = 2;
        final ArrayList mAttachedScrap = new ArrayList();
        final ArrayList mCachedViews = new ArrayList();
        private ArrayList mChangedScrap;
        private RecycledViewPool mRecyclerPool;
        private final List mUnmodifiableAttachedScrap;
        private ViewCacheExtension mViewCacheExtension;
        private int mViewCacheMax;
        final RecyclerView this$0;

        private void attachAccessibilityDelegate(View view)
        {
            if (mAccessibilityManager != null && mAccessibilityManager.isEnabled())
            {
                if (ViewCompat.getImportantForAccessibility(view) == 0)
                {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                if (!ViewCompat.hasAccessibilityDelegate(view))
                {
                    ViewCompat.setAccessibilityDelegate(view, mAccessibilityDelegate.getItemDelegate());
                }
            }
        }

        private void invalidateDisplayListInt(ViewHolder viewholder)
        {
            if (viewholder.itemView instanceof ViewGroup)
            {
                invalidateDisplayListInt((ViewGroup)viewholder.itemView, false);
            }
        }

        private void invalidateDisplayListInt(ViewGroup viewgroup, boolean flag)
        {
            for (int i = viewgroup.getChildCount() - 1; i >= 0; i--)
            {
                View view = viewgroup.getChildAt(i);
                if (view instanceof ViewGroup)
                {
                    invalidateDisplayListInt((ViewGroup)view, true);
                }
            }

            if (!flag)
            {
                return;
            }
            if (viewgroup.getVisibility() == 4)
            {
                viewgroup.setVisibility(0);
                viewgroup.setVisibility(4);
                return;
            } else
            {
                int j = viewgroup.getVisibility();
                viewgroup.setVisibility(4);
                viewgroup.setVisibility(j);
                return;
            }
        }

        void addViewHolderToRecycledViewPool(ViewHolder viewholder)
        {
            ViewCompat.setAccessibilityDelegate(viewholder.itemView, null);
            getRecycledViewPool().putRecycledView(viewholder);
            dispatchViewRecycled(viewholder);
        }

        public void bindViewToPosition(View view, int i)
        {
            boolean flag = true;
            ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder == null)
            {
                throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
            }
            int j = mAdapterHelper.findPositionOffset(i);
            if (j < 0 || j >= mAdapter.getItemCount())
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("Inconsistency detected. Invalid item position ").append(i).append("(offset:").append(j).append(").").append("state:").append(mState.getItemCount()).toString());
            }
            mAdapter.bindViewHolder(viewholder, j);
            attachAccessibilityDelegate(view);
            if (mState.isPreLayout())
            {
                viewholder.mPreLayoutPosition = i;
            }
            view = viewholder.itemView.getLayoutParams();
            if (view == null)
            {
                view = (LayoutParams)generateDefaultLayoutParams();
                viewholder.itemView.setLayoutParams(view);
            } else
            if (!checkLayoutParams(view))
            {
                view = (LayoutParams)generateLayoutParams(view);
                viewholder.itemView.setLayoutParams(view);
            } else
            {
                view = (LayoutParams)view;
            }
            view.mInsetsDirty = true;
            view.mViewHolder = viewholder;
            if (viewholder.itemView.getParent() != null)
            {
                flag = false;
            }
            view.mPendingInvalidate = flag;
        }

        public void clear()
        {
            mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        void clearOldPositions()
        {
            int l = mCachedViews.size();
            for (int i = 0; i < l; i++)
            {
                ((ViewHolder)mCachedViews.get(i)).clearOldPosition();
            }

            l = mAttachedScrap.size();
            for (int j = 0; j < l; j++)
            {
                ((ViewHolder)mAttachedScrap.get(j)).clearOldPosition();
            }

            if (mChangedScrap != null)
            {
                int i1 = mChangedScrap.size();
                for (int k = 0; k < i1; k++)
                {
                    ((ViewHolder)mChangedScrap.get(k)).clearOldPosition();
                }

            }
        }

        void clearScrap()
        {
            mAttachedScrap.clear();
        }

        public int convertPreLayoutPositionToPostLayout(int i)
        {
            if (i < 0 || i >= mState.getItemCount())
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("invalid position ").append(i).append(". State ").append("item count is ").append(mState.getItemCount()).toString());
            }
            if (!mState.isPreLayout())
            {
                return i;
            } else
            {
                return mAdapterHelper.findPositionOffset(i);
            }
        }

        void dispatchViewRecycled(ViewHolder viewholder)
        {
            if (mRecyclerListener != null)
            {
                mRecyclerListener.onViewRecycled(viewholder);
            }
            if (mAdapter != null)
            {
                mAdapter.onViewRecycled(viewholder);
            }
            if (mState != null)
            {
                mState.onViewRecycled(viewholder);
            }
        }

        ViewHolder getChangedScrapViewForPosition(int i)
        {
            int k;
label0:
            {
                if (mChangedScrap != null)
                {
                    k = mChangedScrap.size();
                    if (k != 0)
                    {
                        break label0;
                    }
                }
                return null;
            }
            for (int j = 0; j < k; j++)
            {
                ViewHolder viewholder = (ViewHolder)mChangedScrap.get(j);
                if (!viewholder.wasReturnedFromScrap() && viewholder.getLayoutPosition() == i)
                {
                    viewholder.addFlags(32);
                    return viewholder;
                }
            }

            if (mAdapter.hasStableIds())
            {
                i = mAdapterHelper.findPositionOffset(i);
                if (i > 0 && i < mAdapter.getItemCount())
                {
                    long l = mAdapter.getItemId(i);
                    for (i = 0; i < k; i++)
                    {
                        ViewHolder viewholder1 = (ViewHolder)mChangedScrap.get(i);
                        if (!viewholder1.wasReturnedFromScrap() && viewholder1.getItemId() == l)
                        {
                            viewholder1.addFlags(32);
                            return viewholder1;
                        }
                    }

                }
            }
            return null;
        }

        RecycledViewPool getRecycledViewPool()
        {
            if (mRecyclerPool == null)
            {
                mRecyclerPool = new RecycledViewPool();
            }
            return mRecyclerPool;
        }

        int getScrapCount()
        {
            return mAttachedScrap.size();
        }

        public List getScrapList()
        {
            return mUnmodifiableAttachedScrap;
        }

        View getScrapViewAt(int i)
        {
            return ((ViewHolder)mAttachedScrap.get(i)).itemView;
        }

        ViewHolder getScrapViewForId(long l, int i, boolean flag)
        {
            int j = mAttachedScrap.size() - 1;
_L5:
            if (j < 0) goto _L2; else goto _L1
_L1:
            ViewHolder viewholder1;
            viewholder1 = (ViewHolder)mAttachedScrap.get(j);
            if (viewholder1.getItemId() != l || viewholder1.wasReturnedFromScrap())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (i != viewholder1.getItemViewType()) goto _L4; else goto _L3
_L3:
            ViewHolder viewholder;
            viewholder1.addFlags(32);
            viewholder = viewholder1;
            if (viewholder1.isRemoved())
            {
                viewholder = viewholder1;
                if (!mState.isPreLayout())
                {
                    viewholder1.setFlags(2, 14);
                    viewholder = viewholder1;
                }
            }
_L8:
            return viewholder;
_L4:
            if (!flag)
            {
                mAttachedScrap.remove(j);
                removeDetachedView(viewholder1.itemView, false);
                quickRecycleScrapView(viewholder1.itemView);
            }
            j--;
              goto _L5
_L2:
            j = mCachedViews.size() - 1;
_L9:
            if (j < 0) goto _L7; else goto _L6
_L6:
label0:
            {
                ViewHolder viewholder2 = (ViewHolder)mCachedViews.get(j);
                if (viewholder2.getItemId() != l)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (i != viewholder2.getItemViewType())
                {
                    break label0;
                }
                viewholder = viewholder2;
                if (!flag)
                {
                    mCachedViews.remove(j);
                    return viewholder2;
                }
            }
              goto _L8
            if (!flag)
            {
                recycleCachedViewAt(j);
            }
            j--;
              goto _L9
_L7:
            return null;
              goto _L8
        }

        ViewHolder getScrapViewForPosition(int i, int j, boolean flag)
        {
            int k;
            int l;
            l = mAttachedScrap.size();
            k = 0;
_L10:
            if (k >= l) goto _L2; else goto _L1
_L1:
            Object obj = (ViewHolder)mAttachedScrap.get(k);
            if (((ViewHolder) (obj)).wasReturnedFromScrap() || ((ViewHolder) (obj)).getLayoutPosition() != i || ((ViewHolder) (obj)).isInvalid() || !mState.mInPreLayout && ((ViewHolder) (obj)).isRemoved()) goto _L4; else goto _L3
_L3:
            if (j == -1 || ((ViewHolder) (obj)).getItemViewType() == j) goto _L6; else goto _L5
_L5:
            Log.e("RecyclerView", (new StringBuilder()).append("Scrap view for position ").append(i).append(" isn't dirty but has").append(" wrong view type! (found ").append(((ViewHolder) (obj)).getItemViewType()).append(" but expected ").append(j).append(")").toString());
_L2:
            if (!flag)
            {
                obj = mChildHelper.findHiddenNonRemovedView(i, j);
                if (obj != null)
                {
                    mItemAnimator.endAnimation(getChildViewHolder(((View) (obj))));
                }
            }
            k = mCachedViews.size();
            j = 0;
_L8:
            if (j >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = (ViewHolder)mCachedViews.get(j);
            if (!((ViewHolder) (obj)).isInvalid() && ((ViewHolder) (obj)).getLayoutPosition() == i)
            {
                if (!flag)
                {
                    mCachedViews.remove(j);
                }
                return ((ViewHolder) (obj));
            }
            j++;
            continue; /* Loop/switch isn't completed */
_L6:
            ((ViewHolder) (obj)).addFlags(32);
            return ((ViewHolder) (obj));
_L4:
            k++;
            continue; /* Loop/switch isn't completed */
            if (true) goto _L8; else goto _L7
_L7:
            return null;
            if (true) goto _L10; else goto _L9
_L9:
        }

        public View getViewForPosition(int i)
        {
            return getViewForPosition(i, false);
        }

        View getViewForPosition(int i, boolean flag)
        {
            boolean flag3 = true;
            if (i < 0 || i >= mState.getItemCount())
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("Invalid item position ").append(i).append("(").append(i).append("). Item count:").append(mState.getItemCount()).toString());
            }
            boolean flag1 = false;
            ViewHolder viewholder = null;
            Object obj;
            int j;
            int k;
            if (mState.isPreLayout())
            {
                viewholder = getChangedScrapViewForPosition(i);
                if (viewholder != null)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            j = ((flag1) ? 1 : 0);
            obj = viewholder;
            if (viewholder == null)
            {
                viewholder = getScrapViewForPosition(i, -1, flag);
                j = ((flag1) ? 1 : 0);
                obj = viewholder;
                if (viewholder != null)
                {
                    if (!validateViewHolderForOffsetPosition(viewholder))
                    {
                        if (!flag)
                        {
                            viewholder.addFlags(4);
                            if (viewholder.isScrap())
                            {
                                removeDetachedView(viewholder.itemView, false);
                                viewholder.unScrap();
                            } else
                            if (viewholder.wasReturnedFromScrap())
                            {
                                viewholder.clearReturnedFromScrapFlag();
                            }
                            recycleViewHolderInternal(viewholder);
                        }
                        obj = null;
                        j = ((flag1) ? 1 : 0);
                    } else
                    {
                        j = 1;
                        obj = viewholder;
                    }
                }
            }
            k = j;
            viewholder = ((ViewHolder) (obj));
            if (obj == null)
            {
                int l = mAdapterHelper.findPositionOffset(i);
                if (l < 0 || l >= mAdapter.getItemCount())
                {
                    throw new IndexOutOfBoundsException((new StringBuilder()).append("Inconsistency detected. Invalid item position ").append(i).append("(offset:").append(l).append(").").append("state:").append(mState.getItemCount()).toString());
                }
                k = mAdapter.getItemViewType(l);
                flag1 = j;
                viewholder = ((ViewHolder) (obj));
                if (mAdapter.hasStableIds())
                {
                    obj = getScrapViewForId(mAdapter.getItemId(l), k, flag);
                    flag1 = j;
                    viewholder = ((ViewHolder) (obj));
                    if (obj != null)
                    {
                        obj.mPosition = l;
                        flag1 = true;
                        viewholder = ((ViewHolder) (obj));
                    }
                }
                obj = viewholder;
                if (viewholder == null)
                {
                    obj = viewholder;
                    if (mViewCacheExtension != null)
                    {
                        View view = mViewCacheExtension.getViewForPositionAndType(this, i, k);
                        obj = viewholder;
                        if (view != null)
                        {
                            viewholder = getChildViewHolder(view);
                            if (viewholder == null)
                            {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            }
                            obj = viewholder;
                            if (viewholder.shouldIgnore())
                            {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                            }
                        }
                    }
                }
                ViewHolder viewholder1 = ((ViewHolder) (obj));
                if (obj == null)
                {
                    obj = getRecycledViewPool().getRecycledView(mAdapter.getItemViewType(l));
                    viewholder1 = ((ViewHolder) (obj));
                    if (obj != null)
                    {
                        ((ViewHolder) (obj)).resetInternal();
                        viewholder1 = ((ViewHolder) (obj));
                        if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST)
                        {
                            invalidateDisplayListInt(((ViewHolder) (obj)));
                            viewholder1 = ((ViewHolder) (obj));
                        }
                    }
                }
                k = ((flag1) ? 1 : 0);
                viewholder = viewholder1;
                if (viewholder1 == null)
                {
                    viewholder = mAdapter.createViewHolder(RecyclerView.this, mAdapter.getItemViewType(l));
                    k = ((flag1) ? 1 : 0);
                }
            }
            j = 0;
            if (mState.isPreLayout() && viewholder.isBound())
            {
                viewholder.mPreLayoutPosition = i;
            } else
            if (!viewholder.isBound() || viewholder.needsUpdate() || viewholder.isInvalid())
            {
                j = mAdapterHelper.findPositionOffset(i);
                mAdapter.bindViewHolder(viewholder, j);
                attachAccessibilityDelegate(viewholder.itemView);
                boolean flag2 = true;
                j = ((flag2) ? 1 : 0);
                if (mState.isPreLayout())
                {
                    viewholder.mPreLayoutPosition = i;
                    j = ((flag2) ? 1 : 0);
                }
            }
            obj = viewholder.itemView.getLayoutParams();
            if (obj == null)
            {
                obj = (LayoutParams)generateDefaultLayoutParams();
                viewholder.itemView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            if (!checkLayoutParams(((android.view.ViewGroup.LayoutParams) (obj))))
            {
                obj = (LayoutParams)generateLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                viewholder.itemView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            {
                obj = (LayoutParams)obj;
            }
            obj.mViewHolder = viewholder;
            if (k != 0 && j != 0)
            {
                flag = flag3;
            } else
            {
                flag = false;
            }
            obj.mPendingInvalidate = flag;
            return viewholder.itemView;
        }

        void markItemDecorInsetsDirty()
        {
            int j = mCachedViews.size();
            for (int i = 0; i < j; i++)
            {
                LayoutParams layoutparams = (LayoutParams)((ViewHolder)mCachedViews.get(i)).itemView.getLayoutParams();
                if (layoutparams != null)
                {
                    layoutparams.mInsetsDirty = true;
                }
            }

        }

        void markKnownViewsInvalid()
        {
            if (mAdapter != null && mAdapter.hasStableIds())
            {
                int j = mCachedViews.size();
                for (int i = 0; i < j; i++)
                {
                    ViewHolder viewholder = (ViewHolder)mCachedViews.get(i);
                    if (viewholder != null)
                    {
                        viewholder.addFlags(6);
                    }
                }

            } else
            {
                recycleAndClearCachedViews();
            }
        }

        void offsetPositionRecordsForInsert(int i, int j)
        {
            int l = mCachedViews.size();
            for (int k = 0; k < l; k++)
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(k);
                if (viewholder != null && viewholder.getLayoutPosition() >= i)
                {
                    viewholder.offsetPosition(j, true);
                }
            }

        }

        void offsetPositionRecordsForMove(int i, int j)
        {
            int k;
            byte byte0;
            int l;
            int i1;
            int j1;
            if (i < j)
            {
                l = i;
                k = j;
                byte0 = -1;
            } else
            {
                l = j;
                k = i;
                byte0 = 1;
            }
            j1 = mCachedViews.size();
            i1 = 0;
            while (i1 < j1) 
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(i1);
                if (viewholder != null && viewholder.mPosition >= l && viewholder.mPosition <= k)
                {
                    if (viewholder.mPosition == i)
                    {
                        viewholder.offsetPosition(j - i, false);
                    } else
                    {
                        viewholder.offsetPosition(byte0, false);
                    }
                }
                i1++;
            }
        }

        void offsetPositionRecordsForRemove(int i, int j, boolean flag)
        {
            int k = mCachedViews.size() - 1;
            while (k >= 0) 
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(k);
                if (viewholder != null)
                {
                    if (viewholder.getLayoutPosition() >= i + j)
                    {
                        viewholder.offsetPosition(-j, flag);
                    } else
                    if (viewholder.getLayoutPosition() >= i)
                    {
                        recycleCachedViewAt(k);
                    }
                }
                k--;
            }
        }

        void onAdapterChanged(Adapter adapter, Adapter adapter1, boolean flag)
        {
            clear();
            getRecycledViewPool().onAdapterChanged(adapter, adapter1, flag);
        }

        void quickRecycleScrapView(View view)
        {
            view = RecyclerView.getChildViewHolderInt(view);
            view.mScrapContainer = null;
            view.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(view);
        }

        void recycleAndClearCachedViews()
        {
            for (int i = mCachedViews.size() - 1; i >= 0; i--)
            {
                recycleCachedViewAt(i);
            }

            mCachedViews.clear();
        }

        void recycleCachedViewAt(int i)
        {
            addViewHolderToRecycledViewPool((ViewHolder)mCachedViews.get(i));
            mCachedViews.remove(i);
        }

        public void recycleView(View view)
        {
            ViewHolder viewholder;
            viewholder = RecyclerView.getChildViewHolderInt(view);
            if (viewholder.isTmpDetached())
            {
                removeDetachedView(view, false);
            }
            if (!viewholder.isScrap()) goto _L2; else goto _L1
_L1:
            viewholder.unScrap();
_L4:
            recycleViewHolderInternal(viewholder);
            return;
_L2:
            if (viewholder.wasReturnedFromScrap())
            {
                viewholder.clearReturnedFromScrapFlag();
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        void recycleViewHolderInternal(ViewHolder viewholder)
        {
label0:
            {
label1:
                {
                    boolean flag2 = true;
                    if (viewholder.isScrap() || viewholder.itemView.getParent() != null)
                    {
                        StringBuilder stringbuilder = (new StringBuilder()).append("Scrapped or attached views may not be recycled. isScrap:").append(viewholder.isScrap()).append(" isAttached:");
                        if (viewholder.itemView.getParent() == null)
                        {
                            flag2 = false;
                        }
                        throw new IllegalArgumentException(stringbuilder.append(flag2).toString());
                    }
                    if (viewholder.isTmpDetached())
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("Tmp detached view should be removed from RecyclerView before it can be recycled: ").append(viewholder).toString());
                    }
                    if (viewholder.shouldIgnore())
                    {
                        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                    }
                    boolean flag;
                    boolean flag1;
                    if (mAdapter != null && viewholder.doesTransientStatePreventRecycling() && mAdapter.onFailedToRecycleView(viewholder))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag && !viewholder.isRecyclable())
                    {
                        break label0;
                    }
                    flag1 = false;
                    flag = flag1;
                    if (viewholder.isInvalid())
                    {
                        break label1;
                    }
                    if (!mState.mInPreLayout)
                    {
                        flag = flag1;
                        if (viewholder.isRemoved())
                        {
                            break label1;
                        }
                    }
                    flag = flag1;
                    if (!viewholder.isChanged())
                    {
                        int i = mCachedViews.size();
                        if (i == mViewCacheMax && i > 0)
                        {
                            recycleCachedViewAt(0);
                        }
                        flag = flag1;
                        if (i < mViewCacheMax)
                        {
                            mCachedViews.add(viewholder);
                            flag = true;
                        }
                    }
                }
                if (!flag)
                {
                    addViewHolderToRecycledViewPool(viewholder);
                }
            }
            mState.onViewRecycled(viewholder);
        }

        void recycleViewInternal(View view)
        {
            recycleViewHolderInternal(RecyclerView.getChildViewHolderInt(view));
        }

        void scrapView(View view)
        {
            view = RecyclerView.getChildViewHolderInt(view);
            view.setScrapContainer(this);
            if (!view.isChanged() || !supportsChangeAnimations())
            {
                if (view.isInvalid() && !view.isRemoved() && !mAdapter.hasStableIds())
                {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                } else
                {
                    mAttachedScrap.add(view);
                    return;
                }
            }
            if (mChangedScrap == null)
            {
                mChangedScrap = new ArrayList();
            }
            mChangedScrap.add(view);
        }

        void setAdapterPositionsAsUnknown()
        {
            int j = mCachedViews.size();
            for (int i = 0; i < j; i++)
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(i);
                if (viewholder != null)
                {
                    viewholder.addFlags(512);
                }
            }

        }

        void setRecycledViewPool(RecycledViewPool recycledviewpool)
        {
            if (mRecyclerPool != null)
            {
                mRecyclerPool.detach();
            }
            mRecyclerPool = recycledviewpool;
            if (recycledviewpool != null)
            {
                mRecyclerPool.attach(getAdapter());
            }
        }

        void setViewCacheExtension(ViewCacheExtension viewcacheextension)
        {
            mViewCacheExtension = viewcacheextension;
        }

        public void setViewCacheSize(int i)
        {
            mViewCacheMax = i;
            for (int j = mCachedViews.size() - 1; j >= 0 && mCachedViews.size() > i; j--)
            {
                recycleCachedViewAt(j);
            }

        }

        void unscrapView(ViewHolder viewholder)
        {
            if (!viewholder.isChanged() || !supportsChangeAnimations() || mChangedScrap == null)
            {
                mAttachedScrap.remove(viewholder);
            } else
            {
                mChangedScrap.remove(viewholder);
            }
            viewholder.mScrapContainer = null;
            viewholder.clearReturnedFromScrapFlag();
        }

        boolean validateViewHolderForOffsetPosition(ViewHolder viewholder)
        {
            if (!viewholder.isRemoved())
            {
                if (viewholder.mPosition < 0 || viewholder.mPosition >= mAdapter.getItemCount())
                {
                    throw new IndexOutOfBoundsException((new StringBuilder()).append("Inconsistency detected. Invalid view holder adapter position").append(viewholder).toString());
                }
                if (!mState.isPreLayout() && mAdapter.getItemViewType(viewholder.mPosition) != viewholder.getItemViewType())
                {
                    return false;
                }
                if (mAdapter.hasStableIds() && viewholder.getItemId() != mAdapter.getItemId(viewholder.mPosition))
                {
                    return false;
                }
            }
            return true;
        }

        void viewRangeUpdate(int i, int j)
        {
            int l = mCachedViews.size();
            int k = 0;
            while (k < l) 
            {
                ViewHolder viewholder = (ViewHolder)mCachedViews.get(k);
                if (viewholder != null)
                {
                    int i1 = viewholder.getLayoutPosition();
                    if (i1 >= i && i1 < i + j)
                    {
                        viewholder.addFlags(2);
                    }
                }
                k++;
            }
        }


        public Recycler()
        {
            this$0 = RecyclerView.this;
            super();
            mChangedScrap = null;
            mUnmodifiableAttachedScrap = Collections.unmodifiableList(mAttachedScrap);
            mViewCacheMax = 2;
        }
    }

    public static interface RecyclerListener
    {

        public abstract void onViewRecycled(ViewHolder viewholder);
    }

    private class RecyclerViewDataObserver extends AdapterDataObserver
    {

        final RecyclerView this$0;

        public void onChanged()
        {
            assertNotInLayoutOrScroll(null);
            if (mAdapter.hasStableIds())
            {
                mState.mStructureChanged = true;
                setDataSetChangedAfterLayout();
            } else
            {
                mState.mStructureChanged = true;
                setDataSetChangedAfterLayout();
            }
            if (!mAdapterHelper.hasPendingUpdates())
            {
                requestLayout();
            }
        }

        public void onItemRangeChanged(int i, int j)
        {
            assertNotInLayoutOrScroll(null);
            if (mAdapterHelper.onItemRangeChanged(i, j))
            {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeInserted(int i, int j)
        {
            assertNotInLayoutOrScroll(null);
            if (mAdapterHelper.onItemRangeInserted(i, j))
            {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeMoved(int i, int j, int k)
        {
            assertNotInLayoutOrScroll(null);
            if (mAdapterHelper.onItemRangeMoved(i, j, k))
            {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeRemoved(int i, int j)
        {
            assertNotInLayoutOrScroll(null);
            if (mAdapterHelper.onItemRangeRemoved(i, j))
            {
                triggerUpdateProcessor();
            }
        }

        void triggerUpdateProcessor()
        {
            if (mPostUpdatesOnAnimation && mHasFixedSize && mIsAttached)
            {
                ViewCompat.postOnAnimation(RecyclerView.this, mUpdateChildViewsRunnable);
                return;
            } else
            {
                mAdapterUpdateDuringMeasure = true;
                requestLayout();
                return;
            }
        }

        private RecyclerViewDataObserver()
        {
            this$0 = RecyclerView.this;
            super();
        }

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
        Parcelable mLayoutState;

        private void copyFrom(SavedState savedstate)
        {
            mLayoutState = savedstate.mLayoutState;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(mLayoutState, 0);
        }



        SavedState(Parcel parcel)
        {
            super(parcel);
            mLayoutState = parcel.readParcelable(android/support/v7/widget/RecyclerView$LayoutManager.getClassLoader());
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    public static abstract class SmoothScroller
    {

        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final Action mRecyclingAction = new Action(0, 0);
        private boolean mRunning;
        private int mTargetPosition;
        private View mTargetView;

        private void onAnimation(int i, int j)
        {
            if (!mRunning || mTargetPosition == -1)
            {
                stop();
            }
            mPendingInitialRun = false;
            if (mTargetView != null)
            {
                if (getChildPosition(mTargetView) == mTargetPosition)
                {
                    onTargetFound(mTargetView, mRecyclerView.mState, mRecyclingAction);
                    mRecyclingAction.runIfNecessary(mRecyclerView);
                    stop();
                } else
                {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    mTargetView = null;
                }
            }
            if (mRunning)
            {
                onSeekTargetStep(i, j, mRecyclerView.mState, mRecyclingAction);
                mRecyclingAction.runIfNecessary(mRecyclerView);
            }
        }

        public View findViewByPosition(int i)
        {
            return mRecyclerView.mLayout.findViewByPosition(i);
        }

        public int getChildCount()
        {
            return mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view)
        {
            return mRecyclerView.getChildLayoutPosition(view);
        }

        public LayoutManager getLayoutManager()
        {
            return mLayoutManager;
        }

        public int getTargetPosition()
        {
            return mTargetPosition;
        }

        public void instantScrollToPosition(int i)
        {
            mRecyclerView.scrollToPosition(i);
        }

        public boolean isPendingInitialRun()
        {
            return mPendingInitialRun;
        }

        public boolean isRunning()
        {
            return mRunning;
        }

        protected void normalize(PointF pointf)
        {
            double d = Math.sqrt(pointf.x * pointf.x + pointf.y * pointf.y);
            pointf.x = (float)((double)pointf.x / d);
            pointf.y = (float)((double)pointf.y / d);
        }

        protected void onChildAttachedToWindow(View view)
        {
            if (getChildPosition(view) == getTargetPosition())
            {
                mTargetView = view;
            }
        }

        protected abstract void onSeekTargetStep(int i, int j, State state, Action action);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, State state, Action action);

        public void setTargetPosition(int i)
        {
            mTargetPosition = i;
        }

        void start(RecyclerView recyclerview, LayoutManager layoutmanager)
        {
            mRecyclerView = recyclerview;
            mLayoutManager = layoutmanager;
            if (mTargetPosition == -1)
            {
                throw new IllegalArgumentException("Invalid target position");
            } else
            {
                mRecyclerView.mState.mTargetPosition = mTargetPosition;
                mRunning = true;
                mPendingInitialRun = true;
                mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                mRecyclerView.mViewFlinger.postOnAnimation();
                return;
            }
        }

        protected final void stop()
        {
            if (!mRunning)
            {
                return;
            } else
            {
                onStop();
                mRecyclerView.mState.mTargetPosition = -1;
                mTargetView = null;
                mTargetPosition = -1;
                mPendingInitialRun = false;
                mRunning = false;
                mLayoutManager.onSmoothScrollerStopped(this);
                mLayoutManager = null;
                mRecyclerView = null;
                return;
            }
        }


        public SmoothScroller()
        {
            mTargetPosition = -1;
        }
    }

    public static class SmoothScroller.Action
    {

        public static final int UNDEFINED_DURATION = 0x80000000;
        private boolean changed;
        private int consecutiveUpdates;
        private int mDuration;
        private int mDx;
        private int mDy;
        private Interpolator mInterpolator;

        private void runIfNecessary(RecyclerView recyclerview)
        {
            if (changed)
            {
                validate();
                if (mInterpolator == null)
                {
                    if (mDuration == 0x80000000)
                    {
                        recyclerview.mViewFlinger.smoothScrollBy(mDx, mDy);
                    } else
                    {
                        recyclerview.mViewFlinger.smoothScrollBy(mDx, mDy, mDuration);
                    }
                } else
                {
                    recyclerview.mViewFlinger.smoothScrollBy(mDx, mDy, mDuration, mInterpolator);
                }
                consecutiveUpdates = consecutiveUpdates + 1;
                if (consecutiveUpdates > 10)
                {
                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                changed = false;
                return;
            } else
            {
                consecutiveUpdates = 0;
                return;
            }
        }

        private void validate()
        {
            if (mInterpolator != null && mDuration < 1)
            {
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            }
            if (mDuration < 1)
            {
                throw new IllegalStateException("Scroll duration must be a positive number");
            } else
            {
                return;
            }
        }

        public int getDuration()
        {
            return mDuration;
        }

        public int getDx()
        {
            return mDx;
        }

        public int getDy()
        {
            return mDy;
        }

        public Interpolator getInterpolator()
        {
            return mInterpolator;
        }

        public void setDuration(int i)
        {
            changed = true;
            mDuration = i;
        }

        public void setDx(int i)
        {
            changed = true;
            mDx = i;
        }

        public void setDy(int i)
        {
            changed = true;
            mDy = i;
        }

        public void setInterpolator(Interpolator interpolator)
        {
            changed = true;
            mInterpolator = interpolator;
        }

        public void update(int i, int j, int k, Interpolator interpolator)
        {
            mDx = i;
            mDy = j;
            mDuration = k;
            mInterpolator = interpolator;
            changed = true;
        }


        public SmoothScroller.Action(int i, int j)
        {
            this(i, j, 0x80000000, null);
        }

        public SmoothScroller.Action(int i, int j, int k)
        {
            this(i, j, k, null);
        }

        public SmoothScroller.Action(int i, int j, int k, Interpolator interpolator)
        {
            changed = false;
            consecutiveUpdates = 0;
            mDx = i;
            mDy = j;
            mDuration = k;
            mInterpolator = interpolator;
        }
    }

    public static class State
    {

        private SparseArray mData;
        private int mDeletedInvisibleItemCountSincePreviousLayout;
        private boolean mInPreLayout;
        int mItemCount;
        ArrayMap mOldChangedHolders;
        ArrayMap mPostLayoutHolderMap;
        ArrayMap mPreLayoutHolderMap;
        private int mPreviousLayoutItemCount;
        private boolean mRunPredictiveAnimations;
        private boolean mRunSimpleAnimations;
        private boolean mStructureChanged;
        private int mTargetPosition;

        private void removeFrom(ArrayMap arraymap, ViewHolder viewholder)
        {
            int i = arraymap.size() - 1;
            do
            {
label0:
                {
                    if (i >= 0)
                    {
                        if (viewholder != arraymap.valueAt(i))
                        {
                            break label0;
                        }
                        arraymap.removeAt(i);
                    }
                    return;
                }
                i--;
            } while (true);
        }

        public boolean didStructureChange()
        {
            return mStructureChanged;
        }

        public Object get(int i)
        {
            if (mData == null)
            {
                return null;
            } else
            {
                return mData.get(i);
            }
        }

        public int getItemCount()
        {
            if (mInPreLayout)
            {
                return mPreviousLayoutItemCount - mDeletedInvisibleItemCountSincePreviousLayout;
            } else
            {
                return mItemCount;
            }
        }

        public int getTargetScrollPosition()
        {
            return mTargetPosition;
        }

        public boolean hasTargetScrollPosition()
        {
            return mTargetPosition != -1;
        }

        public boolean isPreLayout()
        {
            return mInPreLayout;
        }

        public void onViewIgnored(ViewHolder viewholder)
        {
            onViewRecycled(viewholder);
        }

        public void onViewRecycled(ViewHolder viewholder)
        {
            mPreLayoutHolderMap.remove(viewholder);
            mPostLayoutHolderMap.remove(viewholder);
            if (mOldChangedHolders != null)
            {
                removeFrom(mOldChangedHolders, viewholder);
            }
        }

        public void put(int i, Object obj)
        {
            if (mData == null)
            {
                mData = new SparseArray();
            }
            mData.put(i, obj);
        }

        public void remove(int i)
        {
            if (mData == null)
            {
                return;
            } else
            {
                mData.remove(i);
                return;
            }
        }

        State reset()
        {
            mTargetPosition = -1;
            if (mData != null)
            {
                mData.clear();
            }
            mItemCount = 0;
            mStructureChanged = false;
            return this;
        }

        public String toString()
        {
            return (new StringBuilder()).append("State{mTargetPosition=").append(mTargetPosition).append(", mPreLayoutHolderMap=").append(mPreLayoutHolderMap).append(", mPostLayoutHolderMap=").append(mPostLayoutHolderMap).append(", mData=").append(mData).append(", mItemCount=").append(mItemCount).append(", mPreviousLayoutItemCount=").append(mPreviousLayoutItemCount).append(", mDeletedInvisibleItemCountSincePreviousLayout=").append(mDeletedInvisibleItemCountSincePreviousLayout).append(", mStructureChanged=").append(mStructureChanged).append(", mInPreLayout=").append(mInPreLayout).append(", mRunSimpleAnimations=").append(mRunSimpleAnimations).append(", mRunPredictiveAnimations=").append(mRunPredictiveAnimations).append('}').toString();
        }

        public boolean willRunPredictiveAnimations()
        {
            return mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations()
        {
            return mRunSimpleAnimations;
        }


/*
        static int access$1002(State state, int i)
        {
            state.mDeletedInvisibleItemCountSincePreviousLayout = i;
            return i;
        }

*/


/*
        static int access$1012(State state, int i)
        {
            i = state.mDeletedInvisibleItemCountSincePreviousLayout + i;
            state.mDeletedInvisibleItemCountSincePreviousLayout = i;
            return i;
        }

*/



/*
        static boolean access$1202(State state, boolean flag)
        {
            state.mStructureChanged = flag;
            return flag;
        }

*/



/*
        static boolean access$1402(State state, boolean flag)
        {
            state.mRunPredictiveAnimations = flag;
            return flag;
        }

*/



/*
        static boolean access$1502(State state, boolean flag)
        {
            state.mInPreLayout = flag;
            return flag;
        }

*/



/*
        static boolean access$1602(State state, boolean flag)
        {
            state.mRunSimpleAnimations = flag;
            return flag;
        }

*/


/*
        static int access$1902(State state, int i)
        {
            state.mPreviousLayoutItemCount = i;
            return i;
        }

*/


/*
        static int access$4902(State state, int i)
        {
            state.mTargetPosition = i;
            return i;
        }

*/

        public State()
        {
            mTargetPosition = -1;
            mPreLayoutHolderMap = new ArrayMap();
            mPostLayoutHolderMap = new ArrayMap();
            mOldChangedHolders = new ArrayMap();
            mItemCount = 0;
            mPreviousLayoutItemCount = 0;
            mDeletedInvisibleItemCountSincePreviousLayout = 0;
            mStructureChanged = false;
            mInPreLayout = false;
            mRunSimpleAnimations = false;
            mRunPredictiveAnimations = false;
        }
    }

    public static abstract class ViewCacheExtension
    {

        public abstract View getViewForPositionAndType(Recycler recycler, int i, int j);

        public ViewCacheExtension()
        {
        }
    }

    private class ViewFlinger
        implements Runnable
    {

        private boolean mEatRunOnAnimationRequest;
        private Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        private boolean mReSchedulePostAnimationCallback;
        private ScrollerCompat mScroller;
        final RecyclerView this$0;

        private int computeScrollDuration(int i, int j, int k, int l)
        {
            int i1 = Math.abs(i);
            int j1 = Math.abs(j);
            float f;
            float f1;
            float f2;
            boolean flag;
            if (i1 > j1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k = (int)Math.sqrt(k * k + l * l);
            j = (int)Math.sqrt(i * i + j * j);
            if (flag)
            {
                i = getWidth();
            } else
            {
                i = getHeight();
            }
            l = i / 2;
            f2 = Math.min(1.0F, (1.0F * (float)j) / (float)i);
            f = l;
            f1 = l;
            f2 = distanceInfluenceForSnapDuration(f2);
            if (k > 0)
            {
                i = Math.round(1000F * Math.abs((f + f1 * f2) / (float)k)) * 4;
            } else
            {
                if (flag)
                {
                    j = i1;
                } else
                {
                    j = j1;
                }
                i = (int)(((float)j / (float)i + 1.0F) * 300F);
            }
            return Math.min(i, 2000);
        }

        private void disableRunOnAnimationRequests()
        {
            mReSchedulePostAnimationCallback = false;
            mEatRunOnAnimationRequest = true;
        }

        private float distanceInfluenceForSnapDuration(float f)
        {
            return (float)Math.sin((float)((double)(f - 0.5F) * 0.4712389167638204D));
        }

        private void enableRunOnAnimationRequests()
        {
            mEatRunOnAnimationRequest = false;
            if (mReSchedulePostAnimationCallback)
            {
                postOnAnimation();
            }
        }

        public void fling(int i, int j)
        {
            setScrollState(2);
            mLastFlingY = 0;
            mLastFlingX = 0;
            mScroller.fling(0, 0, i, j, 0x80000000, 0x7fffffff, 0x80000000, 0x7fffffff);
            postOnAnimation();
        }

        void postOnAnimation()
        {
            if (mEatRunOnAnimationRequest)
            {
                mReSchedulePostAnimationCallback = true;
                return;
            } else
            {
                removeCallbacks(this);
                ViewCompat.postOnAnimation(RecyclerView.this, this);
                return;
            }
        }

        public void run()
        {
            disableRunOnAnimationRequests();
            consumePendingUpdateOperations();
            ScrollerCompat scrollercompat = mScroller;
            SmoothScroller smoothscroller = mLayout.mSmoothScroller;
            if (scrollercompat.computeScrollOffset())
            {
                int l2 = scrollercompat.getCurrX();
                int i3 = scrollercompat.getCurrY();
                int j2 = l2 - mLastFlingX;
                int k2 = i3 - mLastFlingY;
                int k = 0;
                int i = 0;
                int j1 = 0;
                boolean flag = false;
                mLastFlingX = l2;
                mLastFlingY = i3;
                int l = 0;
                int j = 0;
                int i1 = 0;
                boolean flag1 = false;
                if (mAdapter != null)
                {
                    eatRequestLayout();
                    mRunningLayoutOrScroll = true;
                    if (j2 != 0)
                    {
                        i = mLayout.scrollHorizontallyBy(j2, mRecycler, mState);
                        j = j2 - i;
                    }
                    k = ((flag1) ? 1 : 0);
                    l = ((flag) ? 1 : 0);
                    if (k2 != 0)
                    {
                        l = mLayout.scrollVerticallyBy(k2, mRecycler, mState);
                        k = k2 - l;
                    }
                    if (supportsChangeAnimations())
                    {
                        j1 = mChildHelper.getChildCount();
                        for (i1 = 0; i1 < j1; i1++)
                        {
                            View view = mChildHelper.getChildAt(i1);
                            Object obj = getChildViewHolder(view);
                            if (obj == null || ((ViewHolder) (obj)).mShadowingHolder == null)
                            {
                                continue;
                            }
                            obj = ((ViewHolder) (obj)).mShadowingHolder.itemView;
                            int k1 = view.getLeft();
                            int i2 = view.getTop();
                            if (k1 != ((View) (obj)).getLeft() || i2 != ((View) (obj)).getTop())
                            {
                                ((View) (obj)).layout(k1, i2, ((View) (obj)).getWidth() + k1, ((View) (obj)).getHeight() + i2);
                            }
                        }

                    }
                    if (smoothscroller != null && !smoothscroller.isPendingInitialRun() && smoothscroller.isRunning())
                    {
                        i1 = mState.getItemCount();
                        if (i1 == 0)
                        {
                            smoothscroller.stop();
                        } else
                        if (smoothscroller.getTargetPosition() >= i1)
                        {
                            smoothscroller.setTargetPosition(i1 - 1);
                            smoothscroller.onAnimation(j2 - j, k2 - k);
                        } else
                        {
                            smoothscroller.onAnimation(j2 - j, k2 - k);
                        }
                    }
                    mRunningLayoutOrScroll = false;
                    resumeRequestLayout(false);
                    j1 = l;
                    i1 = k;
                    l = j;
                    k = i;
                }
                if (!mItemDecorations.isEmpty())
                {
                    invalidate();
                }
                if (ViewCompat.getOverScrollMode(RecyclerView.this) != 2)
                {
                    considerReleasingGlowsOnScroll(j2, k2);
                }
                if (l != 0 || i1 != 0)
                {
                    int l1 = (int)scrollercompat.getCurrVelocity();
                    i = 0;
                    if (l != l2)
                    {
                        if (l < 0)
                        {
                            i = -l1;
                        } else
                        if (l > 0)
                        {
                            i = l1;
                        } else
                        {
                            i = 0;
                        }
                    }
                    j = 0;
                    if (i1 != i3)
                    {
                        if (i1 < 0)
                        {
                            j = -l1;
                        } else
                        if (i1 > 0)
                        {
                            j = l1;
                        } else
                        {
                            j = 0;
                        }
                    }
                    if (ViewCompat.getOverScrollMode(RecyclerView.this) != 2)
                    {
                        absorbGlows(i, j);
                    }
                    if ((i != 0 || l == l2 || scrollercompat.getFinalX() == 0) && (j != 0 || i1 == i3 || scrollercompat.getFinalY() == 0))
                    {
                        scrollercompat.abortAnimation();
                    }
                }
                if (k != 0 || j1 != 0)
                {
                    notifyOnScrolled(k, j1);
                }
                if (!awakenScrollBars())
                {
                    invalidate();
                }
                if (k2 != 0 && mLayout.canScrollVertically() && j1 == k2)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (j2 != 0 && mLayout.canScrollHorizontally() && k == j2)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                if (j2 == 0 && k2 == 0 || j != 0 || i != 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (scrollercompat.isFinished() || i == 0)
                {
                    setScrollState(0);
                } else
                {
                    postOnAnimation();
                }
            }
            if (smoothscroller != null && smoothscroller.isPendingInitialRun())
            {
                smoothscroller.onAnimation(0, 0);
            }
            enableRunOnAnimationRequests();
        }

        public void smoothScrollBy(int i, int j)
        {
            smoothScrollBy(i, j, 0, 0);
        }

        public void smoothScrollBy(int i, int j, int k)
        {
            smoothScrollBy(i, j, k, RecyclerView.sQuinticInterpolator);
        }

        public void smoothScrollBy(int i, int j, int k, int l)
        {
            smoothScrollBy(i, j, computeScrollDuration(i, j, k, l));
        }

        public void smoothScrollBy(int i, int j, int k, Interpolator interpolator)
        {
            if (mInterpolator != interpolator)
            {
                mInterpolator = interpolator;
                mScroller = ScrollerCompat.create(getContext(), interpolator);
            }
            setScrollState(2);
            mLastFlingY = 0;
            mLastFlingX = 0;
            mScroller.startScroll(0, 0, i, j, k);
            postOnAnimation();
        }

        public void stop()
        {
            removeCallbacks(this);
            mScroller.abortAnimation();
        }

        public ViewFlinger()
        {
            this$0 = RecyclerView.this;
            super();
            mInterpolator = RecyclerView.sQuinticInterpolator;
            mEatRunOnAnimationRequest = false;
            mReSchedulePostAnimationCallback = false;
            mScroller = ScrollerCompat.create(getContext(), RecyclerView.sQuinticInterpolator);
        }
    }

    public static abstract class ViewHolder
    {

        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_BOUND = 1;
        static final int FLAG_CHANGED = 64;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        public final View itemView;
        private int mFlags;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        int mOldPosition;
        int mPosition;
        int mPreLayoutPosition;
        private Recycler mScrapContainer;
        ViewHolder mShadowedHolder;
        ViewHolder mShadowingHolder;

        private boolean doesTransientStatePreventRecycling()
        {
            return (mFlags & 0x10) == 0 && ViewCompat.hasTransientState(itemView);
        }

        private boolean shouldBeKeptAsChild()
        {
            return (mFlags & 0x10) != 0;
        }

        void addFlags(int i)
        {
            mFlags = mFlags | i;
        }

        void clearOldPosition()
        {
            mOldPosition = -1;
            mPreLayoutPosition = -1;
        }

        void clearReturnedFromScrapFlag()
        {
            mFlags = mFlags & 0xffffffdf;
        }

        void clearTmpDetachFlag()
        {
            mFlags = mFlags & 0xfffffeff;
        }

        void flagRemovedAndOffsetPosition(int i, int j, boolean flag)
        {
            addFlags(8);
            offsetPosition(j, flag);
            mPosition = i;
        }

        public final int getAdapterPosition()
        {
            ViewParent viewparent = itemView.getParent();
            if (!(viewparent instanceof RecyclerView))
            {
                return -1;
            } else
            {
                return ((RecyclerView)viewparent).getAdapterPositionFor(this);
            }
        }

        public final long getItemId()
        {
            return mItemId;
        }

        public final int getItemViewType()
        {
            return mItemViewType;
        }

        public final int getLayoutPosition()
        {
            if (mPreLayoutPosition == -1)
            {
                return mPosition;
            } else
            {
                return mPreLayoutPosition;
            }
        }

        public final int getOldPosition()
        {
            return mOldPosition;
        }

        public final int getPosition()
        {
            if (mPreLayoutPosition == -1)
            {
                return mPosition;
            } else
            {
                return mPreLayoutPosition;
            }
        }

        boolean hasAnyOfTheFlags(int i)
        {
            return (mFlags & i) != 0;
        }

        boolean isAdapterPositionUnknown()
        {
            return (mFlags & 0x200) != 0;
        }

        boolean isBound()
        {
            return (mFlags & 1) != 0;
        }

        boolean isChanged()
        {
            return (mFlags & 0x40) != 0;
        }

        boolean isInvalid()
        {
            return (mFlags & 4) != 0;
        }

        public final boolean isRecyclable()
        {
            return (mFlags & 0x10) == 0 && !ViewCompat.hasTransientState(itemView);
        }

        boolean isRemoved()
        {
            return (mFlags & 8) != 0;
        }

        boolean isScrap()
        {
            return mScrapContainer != null;
        }

        boolean isTmpDetached()
        {
            return (mFlags & 0x100) != 0;
        }

        boolean needsUpdate()
        {
            return (mFlags & 2) != 0;
        }

        void offsetPosition(int i, boolean flag)
        {
            if (mOldPosition == -1)
            {
                mOldPosition = mPosition;
            }
            if (mPreLayoutPosition == -1)
            {
                mPreLayoutPosition = mPosition;
            }
            if (flag)
            {
                mPreLayoutPosition = mPreLayoutPosition + i;
            }
            mPosition = mPosition + i;
            if (itemView.getLayoutParams() != null)
            {
                ((LayoutParams)itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        void resetInternal()
        {
            mFlags = 0;
            mPosition = -1;
            mOldPosition = -1;
            mItemId = -1L;
            mPreLayoutPosition = -1;
            mIsRecyclableCount = 0;
            mShadowedHolder = null;
            mShadowingHolder = null;
        }

        void saveOldPosition()
        {
            if (mOldPosition == -1)
            {
                mOldPosition = mPosition;
            }
        }

        void setFlags(int i, int j)
        {
            mFlags = mFlags & ~j | i & j;
        }

        public final void setIsRecyclable(boolean flag)
        {
            int i;
            if (flag)
            {
                i = mIsRecyclableCount - 1;
            } else
            {
                i = mIsRecyclableCount + 1;
            }
            mIsRecyclableCount = i;
            if (mIsRecyclableCount < 0)
            {
                mIsRecyclableCount = 0;
                Log.e("View", (new StringBuilder()).append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this).toString());
            } else
            {
                if (!flag && mIsRecyclableCount == 1)
                {
                    mFlags = mFlags | 0x10;
                    return;
                }
                if (flag && mIsRecyclableCount == 0)
                {
                    mFlags = mFlags & 0xffffffef;
                    return;
                }
            }
        }

        void setScrapContainer(Recycler recycler)
        {
            mScrapContainer = recycler;
        }

        boolean shouldIgnore()
        {
            return (mFlags & 0x80) != 0;
        }

        void stopIgnoring()
        {
            mFlags = mFlags & 0xffffff7f;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder((new StringBuilder()).append("ViewHolder{").append(Integer.toHexString(hashCode())).append(" position=").append(mPosition).append(" id=").append(mItemId).append(", oldPos=").append(mOldPosition).append(", pLpos:").append(mPreLayoutPosition).toString());
            if (isScrap())
            {
                stringbuilder.append(" scrap");
            }
            if (isInvalid())
            {
                stringbuilder.append(" invalid");
            }
            if (!isBound())
            {
                stringbuilder.append(" unbound");
            }
            if (needsUpdate())
            {
                stringbuilder.append(" update");
            }
            if (isRemoved())
            {
                stringbuilder.append(" removed");
            }
            if (shouldIgnore())
            {
                stringbuilder.append(" ignored");
            }
            if (isChanged())
            {
                stringbuilder.append(" changed");
            }
            if (isTmpDetached())
            {
                stringbuilder.append(" tmpDetached");
            }
            if (!isRecyclable())
            {
                stringbuilder.append((new StringBuilder()).append(" not recyclable(").append(mIsRecyclableCount).append(")").toString());
            }
            if (!isAdapterPositionUnknown())
            {
                stringbuilder.append("undefined adapter position");
            }
            if (itemView.getParent() == null)
            {
                stringbuilder.append(" no parent");
            }
            stringbuilder.append("}");
            return stringbuilder.toString();
        }

        void unScrap()
        {
            mScrapContainer.unscrapView(this);
        }

        boolean wasReturnedFromScrap()
        {
            return (mFlags & 0x20) != 0;
        }



/*
        static Recycler access$4102(ViewHolder viewholder, Recycler recycler)
        {
            viewholder.mScrapContainer = recycler;
            return recycler;
        }

*/



        public ViewHolder(View view)
        {
            mPosition = -1;
            mOldPosition = -1;
            mItemId = -1L;
            mItemViewType = -1;
            mPreLayoutPosition = -1;
            mShadowedHolder = null;
            mShadowingHolder = null;
            mIsRecyclableCount = 0;
            mScrapContainer = null;
            if (view == null)
            {
                throw new IllegalArgumentException("itemView may not be null");
            } else
            {
                itemView = view;
                return;
            }
        }
    }


    private static final boolean DEBUG = false;
    private static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1L;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int VERTICAL = 1;
    private static final Interpolator sQuinticInterpolator = new Interpolator() {

        public float getInterpolation(float f)
        {
            f--;
            return f * f * f * f * f + 1.0F;
        }

    };
    private RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private OnItemTouchListener mActiveOnItemTouchListener;
    private Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    private boolean mAdapterUpdateDuringMeasure;
    private EdgeEffectCompat mBottomGlow;
    ChildHelper mChildHelper;
    private boolean mClipToPadding;
    private boolean mDataSetHasChangedAfterLayout;
    final List mDisappearingViewsInLayoutPass;
    private boolean mEatRequestLayout;
    private boolean mFirstLayoutComplete;
    private boolean mHasFixedSize;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner = new Runnable() {

        final RecyclerView this$0;

        public void run()
        {
            if (mItemAnimator != null)
            {
                mItemAnimator.runPendingAnimations();
            }
            mPostedAnimatorRunner = false;
        }

            
            {
                this$0 = RecyclerView.this;
                super();
            }
    };
    private final ArrayList mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    private LayoutManager mLayout;
    private boolean mLayoutRequestEaten;
    private EdgeEffectCompat mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int mMinMaxLayoutPositions[];
    private final RecyclerViewDataObserver mObserver;
    private final ArrayList mOnItemTouchListeners;
    private SavedState mPendingSavedState;
    private final boolean mPostUpdatesOnAnimation;
    private boolean mPostedAnimatorRunner;
    final Recycler mRecycler;
    private RecyclerListener mRecyclerListener;
    private EdgeEffectCompat mRightGlow;
    private boolean mRunningLayoutOrScroll;
    private OnScrollListener mScrollListener;
    private int mScrollPointerId;
    private int mScrollState;
    final State mState;
    private final Rect mTempRect;
    private EdgeEffectCompat mTopGlow;
    private int mTouchSlop;
    private final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    private final ViewFlinger mViewFlinger;

    public RecyclerView(Context context)
    {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeset, int i)
    {
        boolean flag1 = false;
        super(context, attributeset, i);
        mObserver = new RecyclerViewDataObserver();
        mRecycler = new Recycler();
        mDisappearingViewsInLayoutPass = new ArrayList();
        mUpdateChildViewsRunnable = new Runnable() {

            final RecyclerView this$0;

            public void run()
            {
                if (mFirstLayoutComplete)
                {
                    if (mDataSetHasChangedAfterLayout)
                    {
                        dispatchLayout();
                        return;
                    }
                    if (mAdapterHelper.hasPendingUpdates())
                    {
                        eatRequestLayout();
                        mAdapterHelper.preProcess();
                        if (!mLayoutRequestEaten)
                        {
                            rebindUpdatedViewHolders();
                        }
                        resumeRequestLayout(true);
                        return;
                    }
                }
            }

            
            {
                this$0 = RecyclerView.this;
                super();
            }
        };
        mTempRect = new Rect();
        mItemDecorations = new ArrayList();
        mOnItemTouchListeners = new ArrayList();
        mDataSetHasChangedAfterLayout = false;
        mRunningLayoutOrScroll = false;
        mItemAnimator = new DefaultItemAnimator();
        mScrollState = 0;
        mScrollPointerId = -1;
        mViewFlinger = new ViewFlinger();
        mState = new State();
        mItemsAddedOrRemoved = false;
        mItemsChanged = false;
        mItemAnimatorListener = new ItemAnimatorRestoreListener();
        mPostedAnimatorRunner = false;
        mMinMaxLayoutPositions = new int[2];
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPostUpdatesOnAnimation = flag;
        context = ViewConfiguration.get(context);
        mTouchSlop = context.getScaledTouchSlop();
        mMinFlingVelocity = context.getScaledMinimumFlingVelocity();
        mMaxFlingVelocity = context.getScaledMaximumFlingVelocity();
        flag = flag1;
        if (ViewCompat.getOverScrollMode(this) == 2)
        {
            flag = true;
        }
        setWillNotDraw(flag);
        mItemAnimator.setListener(mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        if (ViewCompat.getImportantForAccessibility(this) == 0)
        {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        mAccessibilityManager = (AccessibilityManager)getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
    }

    private void addAnimatingView(ViewHolder viewholder)
    {
        View view = viewholder.itemView;
        boolean flag;
        if (view.getParent() == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mRecycler.unscrapView(getChildViewHolder(view));
        if (viewholder.isTmpDetached())
        {
            mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!flag)
        {
            mChildHelper.addView(view, true);
            return;
        } else
        {
            mChildHelper.hide(view);
            return;
        }
    }

    private void addToDisappearingList(View view)
    {
        if (!mDisappearingViewsInLayoutPass.contains(view))
        {
            mDisappearingViewsInLayoutPass.add(view);
        }
    }

    private void animateAppearance(ViewHolder viewholder, Rect rect, int i, int j)
    {
        View view = viewholder.itemView;
        if (rect != null && (rect.left != i || rect.top != j))
        {
            viewholder.setIsRecyclable(false);
            if (mItemAnimator.animateMove(viewholder, rect.left, rect.top, i, j))
            {
                postAnimationRunner();
            }
        } else
        {
            viewholder.setIsRecyclable(false);
            if (mItemAnimator.animateAdd(viewholder))
            {
                postAnimationRunner();
                return;
            }
        }
    }

    private void animateChange(ViewHolder viewholder, ViewHolder viewholder1)
    {
        viewholder.setIsRecyclable(false);
        addAnimatingView(viewholder);
        viewholder.mShadowedHolder = viewholder1;
        mRecycler.unscrapView(viewholder);
        int k = viewholder.itemView.getLeft();
        int l = viewholder.itemView.getTop();
        int i;
        int j;
        if (viewholder1 == null || viewholder1.shouldIgnore())
        {
            i = k;
            j = l;
        } else
        {
            i = viewholder1.itemView.getLeft();
            j = viewholder1.itemView.getTop();
            viewholder1.setIsRecyclable(false);
            viewholder1.mShadowingHolder = viewholder;
        }
        if (mItemAnimator.animateChange(viewholder, viewholder1, k, l, i, j))
        {
            postAnimationRunner();
        }
    }

    private void animateDisappearance(ItemHolderInfo itemholderinfo)
    {
        View view = itemholderinfo.holder.itemView;
        addAnimatingView(itemholderinfo.holder);
        int i = itemholderinfo.left;
        int j = itemholderinfo.top;
        int k = view.getLeft();
        int l = view.getTop();
        if (i != k || j != l)
        {
            itemholderinfo.holder.setIsRecyclable(false);
            view.layout(k, l, view.getWidth() + k, view.getHeight() + l);
            if (mItemAnimator.animateMove(itemholderinfo.holder, i, j, k, l))
            {
                postAnimationRunner();
            }
        } else
        {
            itemholderinfo.holder.setIsRecyclable(false);
            if (mItemAnimator.animateRemove(itemholderinfo.holder))
            {
                postAnimationRunner();
                return;
            }
        }
    }

    private void cancelTouch()
    {
        if (mVelocityTracker != null)
        {
            mVelocityTracker.clear();
        }
        releaseGlows();
        setScrollState(0);
    }

    private void considerReleasingGlowsOnScroll(int i, int j)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mLeftGlow != null)
        {
            flag = flag1;
            if (!mLeftGlow.isFinished())
            {
                flag = flag1;
                if (i > 0)
                {
                    flag = mLeftGlow.onRelease();
                }
            }
        }
        flag1 = flag;
        if (mRightGlow != null)
        {
            flag1 = flag;
            if (!mRightGlow.isFinished())
            {
                flag1 = flag;
                if (i < 0)
                {
                    flag1 = flag | mRightGlow.onRelease();
                }
            }
        }
        flag = flag1;
        if (mTopGlow != null)
        {
            flag = flag1;
            if (!mTopGlow.isFinished())
            {
                flag = flag1;
                if (j > 0)
                {
                    flag = flag1 | mTopGlow.onRelease();
                }
            }
        }
        flag1 = flag;
        if (mBottomGlow != null)
        {
            flag1 = flag;
            if (!mBottomGlow.isFinished())
            {
                flag1 = flag;
                if (j < 0)
                {
                    flag1 = flag | mBottomGlow.onRelease();
                }
            }
        }
        if (flag1)
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void consumePendingUpdateOperations()
    {
        mUpdateChildViewsRunnable.run();
    }

    private void defaultOnMeasure(int i, int j)
    {
        int l = android.view.View.MeasureSpec.getMode(i);
        int k = android.view.View.MeasureSpec.getMode(j);
        i = android.view.View.MeasureSpec.getSize(i);
        j = android.view.View.MeasureSpec.getSize(j);
        switch (l)
        {
        default:
            i = ViewCompat.getMinimumWidth(this);
            // fall through

        case -2147483648: 
        case 1073741824: 
            switch (k)
            {
            default:
                j = ViewCompat.getMinimumHeight(this);
                // fall through

            case -2147483648: 
            case 1073741824: 
                setMeasuredDimension(i, j);
                return;
            }
        }
    }

    private boolean didChildRangeChange(int i, int j)
    {
        int l;
        boolean flag1;
        flag1 = false;
        l = mChildHelper.getChildCount();
        if (l != 0) goto _L2; else goto _L1
_L1:
        boolean flag;
label0:
        {
            if (i == 0)
            {
                flag = flag1;
                if (j == 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
_L4:
        return flag;
_L2:
        int k = 0;
        do
        {
            flag = flag1;
            if (k >= l)
            {
                continue; /* Loop/switch isn't completed */
            }
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getChildAt(k));
            int i1;
            if (!viewholder.shouldIgnore())
            {
                if ((i1 = viewholder.getLayoutPosition()) < i || i1 > j)
                {
                    return true;
                }
            }
            k++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void dispatchChildAttached(View view)
    {
        if (mAdapter != null)
        {
            mAdapter.onViewAttachedToWindow(getChildViewHolderInt(view));
        }
        onChildAttachedToWindow(view);
    }

    private void dispatchChildDetached(View view)
    {
        if (mAdapter != null)
        {
            mAdapter.onViewDetachedFromWindow(getChildViewHolderInt(view));
        }
        onChildDetachedFromWindow(view);
    }

    private boolean dispatchOnItemTouch(MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (mActiveOnItemTouchListener == null) goto _L2; else goto _L1
_L1:
        if (i != 0) goto _L4; else goto _L3
_L3:
        mActiveOnItemTouchListener = null;
_L2:
        if (i == 0) goto _L6; else goto _L5
_L5:
        int j;
        j = mOnItemTouchListeners.size();
        i = 0;
_L11:
        OnItemTouchListener onitemtouchlistener;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        onitemtouchlistener = (OnItemTouchListener)mOnItemTouchListeners.get(i);
        if (!onitemtouchlistener.onInterceptTouchEvent(this, motionevent)) goto _L8; else goto _L7
_L7:
        mActiveOnItemTouchListener = onitemtouchlistener;
_L10:
        return true;
_L4:
        mActiveOnItemTouchListener.onTouchEvent(this, motionevent);
        if (i != 3 && i != 1) goto _L10; else goto _L9
_L9:
        mActiveOnItemTouchListener = null;
        return true;
_L8:
        i++;
        if (true) goto _L11; else goto _L6
_L6:
        return false;
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionevent)
    {
        int j = motionevent.getAction();
        if (j == 3 || j == 0)
        {
            mActiveOnItemTouchListener = null;
        }
        int k = mOnItemTouchListeners.size();
        for (int i = 0; i < k; i++)
        {
            OnItemTouchListener onitemtouchlistener = (OnItemTouchListener)mOnItemTouchListeners.get(i);
            if (onitemtouchlistener.onInterceptTouchEvent(this, motionevent) && j != 3)
            {
                mActiveOnItemTouchListener = onitemtouchlistener;
                return true;
            }
        }

        return false;
    }

    private void findMinMaxChildLayoutPositions(int ai[])
    {
        int k1 = mChildHelper.getChildCount();
        if (k1 == 0)
        {
            ai[0] = 0;
            ai[1] = 0;
            return;
        }
        int j = 0x7fffffff;
        int l = 0x80000000;
        int k = 0;
        while (k < k1) 
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getChildAt(k));
            int j1;
            if (viewholder.shouldIgnore())
            {
                j1 = j;
                j = l;
            } else
            {
                int i1 = viewholder.getLayoutPosition();
                int i = j;
                if (i1 < j)
                {
                    i = i1;
                }
                j = l;
                j1 = i;
                if (i1 > l)
                {
                    j = i1;
                    j1 = i;
                }
            }
            k++;
            l = j;
            j = j1;
        }
        ai[0] = j;
        ai[1] = l;
    }

    private int getAdapterPositionFor(ViewHolder viewholder)
    {
        if (viewholder.hasAnyOfTheFlags(520))
        {
            return -1;
        } else
        {
            return mAdapterHelper.applyPendingUpdatesToPosition(viewholder.mPosition);
        }
    }

    static ViewHolder getChildViewHolderInt(View view)
    {
        if (view == null)
        {
            return null;
        } else
        {
            return ((LayoutParams)view.getLayoutParams()).mViewHolder;
        }
    }

    private void initChildrenHelper()
    {
        mChildHelper = new ChildHelper(new ChildHelper.Callback() {

            final RecyclerView this$0;

            public void addView(View view, int i)
            {
                RecyclerView.this.addView(view, i);
                dispatchChildAttached(view);
            }

            public void attachViewToParent(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
            {
                ViewHolder viewholder = RecyclerView.getChildViewHolderInt(view);
                if (viewholder != null)
                {
                    if (!viewholder.isTmpDetached() && !viewholder.shouldIgnore())
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("Called attach on a child which is not detached: ").append(viewholder).toString());
                    }
                    viewholder.clearTmpDetachFlag();
                }
                RecyclerView.this.attachViewToParent(view, i, layoutparams);
            }

            public void detachViewFromParent(int i)
            {
                Object obj = getChildAt(i);
                if (obj != null)
                {
                    obj = RecyclerView.getChildViewHolderInt(((View) (obj)));
                    if (obj != null)
                    {
                        if (((ViewHolder) (obj)).isTmpDetached() && !((ViewHolder) (obj)).shouldIgnore())
                        {
                            throw new IllegalArgumentException((new StringBuilder()).append("called detach on an already detached child ").append(obj).toString());
                        }
                        ((ViewHolder) (obj)).addFlags(256);
                    }
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            public View getChildAt(int i)
            {
                return RecyclerView.this.getChildAt(i);
            }

            public int getChildCount()
            {
                return RecyclerView.this.getChildCount();
            }

            public ViewHolder getChildViewHolder(View view)
            {
                return RecyclerView.getChildViewHolderInt(view);
            }

            public int indexOfChild(View view)
            {
                return RecyclerView.this.indexOfChild(view);
            }

            public void removeAllViews()
            {
                int j = getChildCount();
                for (int i = 0; i < j; i++)
                {
                    dispatchChildDetached(getChildAt(i));
                }

                RecyclerView.this.removeAllViews();
            }

            public void removeViewAt(int i)
            {
                View view = RecyclerView.this.getChildAt(i);
                if (view != null)
                {
                    dispatchChildDetached(view);
                }
                RecyclerView.this.removeViewAt(i);
            }

            
            {
                this$0 = RecyclerView.this;
                super();
            }
        });
    }

    private void notifyOnScrolled(int i, int j)
    {
        onScrollChanged(0, 0, 0, 0);
        if (mScrollListener != null)
        {
            mScrollListener.onScrolled(this, i, j);
        }
    }

    private void onPointerUp(MotionEvent motionevent)
    {
        int i = MotionEventCompat.getActionIndex(motionevent);
        if (MotionEventCompat.getPointerId(motionevent, i) == mScrollPointerId)
        {
            int j;
            if (i == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            mScrollPointerId = MotionEventCompat.getPointerId(motionevent, i);
            j = (int)(MotionEventCompat.getX(motionevent, i) + 0.5F);
            mLastTouchX = j;
            mInitialTouchX = j;
            i = (int)(MotionEventCompat.getY(motionevent, i) + 0.5F);
            mLastTouchY = i;
            mInitialTouchY = i;
        }
    }

    private void postAnimationRunner()
    {
        if (!mPostedAnimatorRunner && mIsAttached)
        {
            ViewCompat.postOnAnimation(this, mItemAnimatorRunner);
            mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled()
    {
        return mItemAnimator != null && mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags()
    {
        boolean flag2 = true;
        if (mDataSetHasChangedAfterLayout)
        {
            mAdapterHelper.reset();
            markKnownViewsInvalid();
            mLayout.onItemsChanged(this);
        }
        State state;
        boolean flag;
        boolean flag1;
        if (mItemAnimator != null && mLayout.supportsPredictiveItemAnimations())
        {
            mAdapterHelper.preProcess();
        } else
        {
            mAdapterHelper.consumeUpdatesInOnePass();
        }
        if (mItemsAddedOrRemoved && !mItemsChanged || mItemsAddedOrRemoved || mItemsChanged && supportsChangeAnimations())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        state = mState;
        if (mFirstLayoutComplete && mItemAnimator != null && (mDataSetHasChangedAfterLayout || flag || mLayout.mRequestedSimpleAnimations) && (!mDataSetHasChangedAfterLayout || mAdapter.hasStableIds()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        state.mRunSimpleAnimations = flag1;
        state = mState;
        if (mState.mRunSimpleAnimations && flag && !mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled())
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        state.mRunPredictiveAnimations = flag1;
    }

    private void processDisappearingList(ArrayMap arraymap)
    {
        int j = mDisappearingViewsInLayoutPass.size();
        int i = 0;
        while (i < j) 
        {
            View view = (View)mDisappearingViewsInLayoutPass.get(i);
            ViewHolder viewholder = getChildViewHolderInt(view);
            ItemHolderInfo itemholderinfo = (ItemHolderInfo)mState.mPreLayoutHolderMap.remove(viewholder);
            if (!mState.isPreLayout())
            {
                mState.mPostLayoutHolderMap.remove(viewholder);
            }
            if (arraymap.remove(view) != null)
            {
                mLayout.removeAndRecycleView(view, mRecycler);
            } else
            if (itemholderinfo != null)
            {
                animateDisappearance(itemholderinfo);
            } else
            {
                animateDisappearance(new ItemHolderInfo(viewholder, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
            i++;
        }
        mDisappearingViewsInLayoutPass.clear();
    }

    private void pullGlows(int i, int j)
    {
        if (i < 0)
        {
            ensureLeftGlow();
            mLeftGlow.onPull((float)(-i) / (float)getWidth());
        } else
        if (i > 0)
        {
            ensureRightGlow();
            mRightGlow.onPull((float)i / (float)getWidth());
        }
        if (j < 0)
        {
            ensureTopGlow();
            mTopGlow.onPull((float)(-j) / (float)getHeight());
        } else
        if (j > 0)
        {
            ensureBottomGlow();
            mBottomGlow.onPull((float)j / (float)getHeight());
        }
        if (i != 0 || j != 0)
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void releaseGlows()
    {
        boolean flag1 = false;
        if (mLeftGlow != null)
        {
            flag1 = mLeftGlow.onRelease();
        }
        boolean flag = flag1;
        if (mTopGlow != null)
        {
            flag = flag1 | mTopGlow.onRelease();
        }
        flag1 = flag;
        if (mRightGlow != null)
        {
            flag1 = flag | mRightGlow.onRelease();
        }
        flag = flag1;
        if (mBottomGlow != null)
        {
            flag = flag1 | mBottomGlow.onRelease();
        }
        if (flag)
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private boolean removeAnimatingView(View view)
    {
        eatRequestLayout();
        boolean flag = mChildHelper.removeViewIfHidden(view);
        if (flag)
        {
            view = getChildViewHolderInt(view);
            mRecycler.unscrapView(view);
            mRecycler.recycleViewHolderInternal(view);
        }
        resumeRequestLayout(false);
        return flag;
    }

    private void removeFromDisappearingList(View view)
    {
        mDisappearingViewsInLayoutPass.remove(view);
    }

    private void setAdapterInternal(Adapter adapter, boolean flag, boolean flag1)
    {
        if (mAdapter != null)
        {
            mAdapter.unregisterAdapterDataObserver(mObserver);
            mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!flag || flag1)
        {
            if (mItemAnimator != null)
            {
                mItemAnimator.endAnimations();
            }
            if (mLayout != null)
            {
                mLayout.removeAndRecycleAllViews(mRecycler);
                mLayout.removeAndRecycleScrapInt(mRecycler);
            }
            mRecycler.clear();
        }
        mAdapterHelper.reset();
        Adapter adapter1 = mAdapter;
        mAdapter = adapter;
        if (adapter != null)
        {
            adapter.registerAdapterDataObserver(mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        if (mLayout != null)
        {
            mLayout.onAdapterChanged(adapter1, mAdapter);
        }
        mRecycler.onAdapterChanged(adapter1, mAdapter, flag);
        mState.mStructureChanged = true;
        markKnownViewsInvalid();
    }

    private void setDataSetChangedAfterLayout()
    {
        if (mDataSetHasChangedAfterLayout)
        {
            return;
        }
        mDataSetHasChangedAfterLayout = true;
        int j = mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < j; i++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (viewholder != null && !viewholder.shouldIgnore())
            {
                viewholder.addFlags(512);
            }
        }

        mRecycler.setAdapterPositionsAsUnknown();
    }

    private void setScrollState(int i)
    {
        if (i != mScrollState)
        {
            mScrollState = i;
            if (i != 2)
            {
                stopScrollersInternal();
            }
            if (mScrollListener != null)
            {
                mScrollListener.onScrollStateChanged(this, i);
            }
            if (mLayout != null)
            {
                mLayout.onScrollStateChanged(i);
                return;
            }
        }
    }

    private void stopScrollersInternal()
    {
        mViewFlinger.stop();
        if (mLayout != null)
        {
            mLayout.stopSmoothScroller();
        }
    }

    private boolean supportsChangeAnimations()
    {
        return mItemAnimator != null && mItemAnimator.getSupportsChangeAnimations();
    }

    void absorbGlows(int i, int j)
    {
        if (i < 0)
        {
            ensureLeftGlow();
            mLeftGlow.onAbsorb(-i);
        } else
        if (i > 0)
        {
            ensureRightGlow();
            mRightGlow.onAbsorb(i);
        }
        if (j < 0)
        {
            ensureTopGlow();
            mTopGlow.onAbsorb(-j);
        } else
        if (j > 0)
        {
            ensureBottomGlow();
            mBottomGlow.onAbsorb(j);
        }
        if (i != 0 || j != 0)
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void addFocusables(ArrayList arraylist, int i, int j)
    {
        if (!mLayout.onAddFocusables(this, arraylist, i, j))
        {
            super.addFocusables(arraylist, i, j);
        }
    }

    public void addItemDecoration(ItemDecoration itemdecoration)
    {
        addItemDecoration(itemdecoration, -1);
    }

    public void addItemDecoration(ItemDecoration itemdecoration, int i)
    {
        if (mLayout != null)
        {
            mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (mItemDecorations.isEmpty())
        {
            setWillNotDraw(false);
        }
        if (i < 0)
        {
            mItemDecorations.add(itemdecoration);
        } else
        {
            mItemDecorations.add(i, itemdecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnItemTouchListener(OnItemTouchListener onitemtouchlistener)
    {
        mOnItemTouchListeners.add(onitemtouchlistener);
    }

    void assertInLayoutOrScroll(String s)
    {
        if (!mRunningLayoutOrScroll)
        {
            if (s == null)
            {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            } else
            {
                throw new IllegalStateException(s);
            }
        } else
        {
            return;
        }
    }

    void assertNotInLayoutOrScroll(String s)
    {
        if (mRunningLayoutOrScroll)
        {
            if (s == null)
            {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
            } else
            {
                throw new IllegalStateException(s);
            }
        } else
        {
            return;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof LayoutParams) && mLayout.checkLayoutParams((LayoutParams)layoutparams);
    }

    void clearOldPositions()
    {
        int j = mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < j; i++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (!viewholder.shouldIgnore())
            {
                viewholder.clearOldPosition();
            }
        }

        mRecycler.clearOldPositions();
    }

    protected int computeHorizontalScrollExtent()
    {
        if (mLayout.canScrollHorizontally())
        {
            return mLayout.computeHorizontalScrollExtent(mState);
        } else
        {
            return 0;
        }
    }

    protected int computeHorizontalScrollOffset()
    {
        if (mLayout.canScrollHorizontally())
        {
            return mLayout.computeHorizontalScrollOffset(mState);
        } else
        {
            return 0;
        }
    }

    protected int computeHorizontalScrollRange()
    {
        if (mLayout.canScrollHorizontally())
        {
            return mLayout.computeHorizontalScrollRange(mState);
        } else
        {
            return 0;
        }
    }

    protected int computeVerticalScrollExtent()
    {
        if (mLayout.canScrollVertically())
        {
            return mLayout.computeVerticalScrollExtent(mState);
        } else
        {
            return 0;
        }
    }

    protected int computeVerticalScrollOffset()
    {
        if (mLayout.canScrollVertically())
        {
            return mLayout.computeVerticalScrollOffset(mState);
        } else
        {
            return 0;
        }
    }

    protected int computeVerticalScrollRange()
    {
        if (mLayout.canScrollVertically())
        {
            return mLayout.computeVerticalScrollRange(mState);
        } else
        {
            return 0;
        }
    }

    void dispatchLayout()
    {
        if (mAdapter != null) goto _L2; else goto _L1
_L1:
        Log.e("RecyclerView", "No adapter attached; skipping layout");
_L17:
        return;
_L2:
        Object obj;
        if (mLayout == null)
        {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        mDisappearingViewsInLayoutPass.clear();
        eatRequestLayout();
        mRunningLayoutOrScroll = true;
        processAdapterUpdatesAndSetAnimationFlags();
        State state = mState;
        if (mState.mRunSimpleAnimations && mItemsChanged && supportsChangeAnimations())
        {
            obj = new ArrayMap();
        } else
        {
            obj = null;
        }
        state.mOldChangedHolders = ((ArrayMap) (obj));
        mItemsChanged = false;
        mItemsAddedOrRemoved = false;
        obj = null;
        mState.mInPreLayout = mState.mRunPredictiveAnimations;
        mState.mItemCount = mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(mMinMaxLayoutPositions);
        if (mState.mRunSimpleAnimations)
        {
            mState.mPreLayoutHolderMap.clear();
            mState.mPostLayoutHolderMap.clear();
            int k1 = mChildHelper.getChildCount();
            int i = 0;
            while (i < k1) 
            {
                ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getChildAt(i));
                if (!viewholder.shouldIgnore() && (!viewholder.isInvalid() || mAdapter.hasStableIds()))
                {
                    View view = viewholder.itemView;
                    mState.mPreLayoutHolderMap.put(viewholder, new ItemHolderInfo(viewholder, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                }
                i++;
            }
        }
        if (!mState.mRunPredictiveAnimations) goto _L4; else goto _L3
_L3:
        Object obj1;
        int k;
        saveOldPositions();
        if (mState.mOldChangedHolders != null)
        {
            int l1 = mChildHelper.getChildCount();
            for (int j = 0; j < l1; j++)
            {
                obj = getChildViewHolderInt(mChildHelper.getChildAt(j));
                if (((ViewHolder) (obj)).isChanged() && !((ViewHolder) (obj)).isRemoved() && !((ViewHolder) (obj)).shouldIgnore())
                {
                    long l2 = getChangedHolderKey(((ViewHolder) (obj)));
                    mState.mOldChangedHolders.put(Long.valueOf(l2), obj);
                    mState.mPreLayoutHolderMap.remove(obj);
                }
            }

        }
        boolean flag2 = mState.mStructureChanged;
        mState.mStructureChanged = false;
        mLayout.onLayoutChildren(mRecycler, mState);
        mState.mStructureChanged = flag2;
        obj1 = new ArrayMap();
        k = 0;
_L6:
        boolean flag1;
        if (k >= mChildHelper.getChildCount())
        {
            break MISSING_BLOCK_LABEL_604;
        }
        flag1 = false;
        obj = mChildHelper.getChildAt(k);
        if (!getChildViewHolderInt(((View) (obj))).shouldIgnore())
        {
            break; /* Loop/switch isn't completed */
        }
_L7:
        k++;
        if (true) goto _L6; else goto _L5
_L5:
        int i2 = 0;
_L8:
label0:
        {
            boolean flag = flag1;
            if (i2 < mState.mPreLayoutHolderMap.size())
            {
                if (((ViewHolder)mState.mPreLayoutHolderMap.keyAt(i2)).itemView != obj)
                {
                    break label0;
                }
                flag = true;
            }
            if (!flag)
            {
                ((ArrayMap) (obj1)).put(obj, new Rect(((View) (obj)).getLeft(), ((View) (obj)).getTop(), ((View) (obj)).getRight(), ((View) (obj)).getBottom()));
            }
        }
          goto _L7
        i2++;
          goto _L8
        clearOldPositions();
        mAdapterHelper.consumePostponedUpdates();
_L12:
        mState.mItemCount = mAdapter.getItemCount();
        mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        mState.mInPreLayout = false;
        mLayout.onLayoutChildren(mRecycler, mState);
        mState.mStructureChanged = false;
        mPendingSavedState = null;
        obj = mState;
        int l;
        int j2;
        long l3;
        boolean flag3;
        if (mState.mRunSimpleAnimations && mItemAnimator != null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        obj.mRunSimpleAnimations = flag3;
        if (!mState.mRunSimpleAnimations) goto _L10; else goto _L9
_L4:
        clearOldPositions();
        mAdapterHelper.consumeUpdatesInOnePass();
        obj1 = obj;
        if (mState.mOldChangedHolders == null) goto _L12; else goto _L11
_L11:
        j2 = mChildHelper.getChildCount();
        l = 0;
_L14:
        obj1 = obj;
        if (l >= j2) goto _L12; else goto _L13
_L13:
        obj1 = getChildViewHolderInt(mChildHelper.getChildAt(l));
        if (((ViewHolder) (obj1)).isChanged() && !((ViewHolder) (obj1)).isRemoved() && !((ViewHolder) (obj1)).shouldIgnore())
        {
            l3 = getChangedHolderKey(((ViewHolder) (obj1)));
            mState.mOldChangedHolders.put(Long.valueOf(l3), obj1);
            mState.mPreLayoutHolderMap.remove(obj1);
        }
        l++;
          goto _L14
_L9:
        long l5;
        {
            if (mState.mOldChangedHolders != null)
            {
                obj = new ArrayMap();
            } else
            {
                obj = null;
            }
            j2 = mChildHelper.getChildCount();
            l = 0;
            while (l < j2) 
            {
                ViewHolder viewholder1 = getChildViewHolderInt(mChildHelper.getChildAt(l));
                if (!viewholder1.shouldIgnore())
                {
                    View view2 = viewholder1.itemView;
                    long l4 = getChangedHolderKey(viewholder1);
                    if (obj != null && mState.mOldChangedHolders.get(Long.valueOf(l4)) != null)
                    {
                        ((ArrayMap) (obj)).put(Long.valueOf(l4), viewholder1);
                    } else
                    {
                        mState.mPostLayoutHolderMap.put(viewholder1, new ItemHolderInfo(viewholder1, view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom()));
                    }
                }
                l++;
            }
            processDisappearingList(((ArrayMap) (obj1)));
            for (int i1 = mState.mPreLayoutHolderMap.size() - 1; i1 >= 0; i1--)
            {
                ViewHolder viewholder2 = (ViewHolder)mState.mPreLayoutHolderMap.keyAt(i1);
                if (!mState.mPostLayoutHolderMap.containsKey(viewholder2))
                {
                    ItemHolderInfo itemholderinfo = (ItemHolderInfo)mState.mPreLayoutHolderMap.valueAt(i1);
                    mState.mPreLayoutHolderMap.removeAt(i1);
                    View view3 = itemholderinfo.holder.itemView;
                    mRecycler.unscrapView(itemholderinfo.holder);
                    animateDisappearance(itemholderinfo);
                }
            }

            int j1 = mState.mPostLayoutHolderMap.size();
            if (j1 > 0)
            {
                j1--;
                while (j1 >= 0) 
                {
                    ViewHolder viewholder3 = (ViewHolder)mState.mPostLayoutHolderMap.keyAt(j1);
                    ItemHolderInfo itemholderinfo3 = (ItemHolderInfo)mState.mPostLayoutHolderMap.valueAt(j1);
                    if (mState.mPreLayoutHolderMap.isEmpty() || !mState.mPreLayoutHolderMap.containsKey(viewholder3))
                    {
                        mState.mPostLayoutHolderMap.removeAt(j1);
                        Rect rect;
                        if (obj1 != null)
                        {
                            rect = (Rect)((ArrayMap) (obj1)).get(viewholder3.itemView);
                        } else
                        {
                            rect = null;
                        }
                        animateAppearance(viewholder3, rect, itemholderinfo3.left, itemholderinfo3.top);
                    }
                    j1--;
                }
            }
            int k2 = mState.mPostLayoutHolderMap.size();
            for (j1 = 0; j1 < k2; j1++)
            {
                obj1 = (ViewHolder)mState.mPostLayoutHolderMap.keyAt(j1);
                ItemHolderInfo itemholderinfo1 = (ItemHolderInfo)mState.mPostLayoutHolderMap.valueAt(j1);
                ItemHolderInfo itemholderinfo2 = (ItemHolderInfo)mState.mPreLayoutHolderMap.get(obj1);
                if (itemholderinfo2 == null || itemholderinfo1 == null || itemholderinfo2.left == itemholderinfo1.left && itemholderinfo2.top == itemholderinfo1.top)
                {
                    continue;
                }
                ((ViewHolder) (obj1)).setIsRecyclable(false);
                if (mItemAnimator.animateMove(((ViewHolder) (obj1)), itemholderinfo2.left, itemholderinfo2.top, itemholderinfo1.left, itemholderinfo1.top))
                {
                    postAnimationRunner();
                }
            }

            View view1;
            if (mState.mOldChangedHolders != null)
            {
                j1 = mState.mOldChangedHolders.size();
            } else
            {
                j1 = 0;
            }
            j1--;
        }
        if (j1 < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        l5 = ((Long)mState.mOldChangedHolders.keyAt(j1)).longValue();
        obj1 = (ViewHolder)mState.mOldChangedHolders.get(Long.valueOf(l5));
        view1 = ((ViewHolder) (obj1)).itemView;
        if (!((ViewHolder) (obj1)).shouldIgnore() && mRecycler.mChangedScrap != null && mRecycler.mChangedScrap.contains(obj1))
        {
            animateChange(((ViewHolder) (obj1)), (ViewHolder)((ArrayMap) (obj)).get(Long.valueOf(l5)));
        }
        j1--;
        if (true) goto _L15; else goto _L10
_L15:
        break MISSING_BLOCK_LABEL_1456;
_L10:
        resumeRequestLayout(false);
        mLayout.removeAndRecycleScrapInt(mRecycler);
        mState.mPreviousLayoutItemCount = mState.mItemCount;
        mDataSetHasChangedAfterLayout = false;
        mState.mRunSimpleAnimations = false;
        mState.mRunPredictiveAnimations = false;
        mRunningLayoutOrScroll = false;
        mLayout.mRequestedSimpleAnimations = false;
        if (mRecycler.mChangedScrap != null)
        {
            mRecycler.mChangedScrap.clear();
        }
        mState.mOldChangedHolders = null;
        if (didChildRangeChange(mMinMaxLayoutPositions[0], mMinMaxLayoutPositions[1]))
        {
            notifyOnScrolled(0, 0);
            return;
        }
        if (true) goto _L17; else goto _L16
_L16:
    }

    public void draw(Canvas canvas)
    {
        boolean flag = true;
        super.draw(canvas);
        int k = mItemDecorations.size();
        for (int i = 0; i < k; i++)
        {
            ((ItemDecoration)mItemDecorations.get(i)).onDrawOver(canvas, this, mState);
        }

        int j = 0;
        k = j;
        if (mLeftGlow != null)
        {
            k = j;
            if (!mLeftGlow.isFinished())
            {
                int l = canvas.save();
                int i1;
                if (mClipToPadding)
                {
                    j = getPaddingBottom();
                } else
                {
                    j = 0;
                }
                canvas.rotate(270F);
                canvas.translate(-getHeight() + j, 0.0F);
                if (mLeftGlow != null && mLeftGlow.draw(canvas))
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
                canvas.restoreToCount(l);
            }
        }
        j = k;
        if (mTopGlow != null)
        {
            j = k;
            if (!mTopGlow.isFinished())
            {
                l = canvas.save();
                if (mClipToPadding)
                {
                    canvas.translate(getPaddingLeft(), getPaddingTop());
                }
                if (mTopGlow != null && mTopGlow.draw(canvas))
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                j = k | j;
                canvas.restoreToCount(l);
            }
        }
        k = j;
        if (mRightGlow != null)
        {
            k = j;
            if (!mRightGlow.isFinished())
            {
                l = canvas.save();
                i1 = getWidth();
                if (mClipToPadding)
                {
                    k = getPaddingTop();
                } else
                {
                    k = 0;
                }
                canvas.rotate(90F);
                canvas.translate(-k, -i1);
                if (mRightGlow != null && mRightGlow.draw(canvas))
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
                k = j | k;
                canvas.restoreToCount(l);
            }
        }
        j = k;
        if (mBottomGlow != null)
        {
            j = k;
            if (!mBottomGlow.isFinished())
            {
                l = canvas.save();
                canvas.rotate(180F);
                if (mClipToPadding)
                {
                    canvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
                } else
                {
                    canvas.translate(-getWidth(), -getHeight());
                }
                if (mBottomGlow != null && mBottomGlow.draw(canvas))
                {
                    j = ((flag) ? 1 : 0);
                } else
                {
                    j = 0;
                }
                j = k | j;
                canvas.restoreToCount(l);
            }
        }
        k = j;
        if (j == 0)
        {
            k = j;
            if (mItemAnimator != null)
            {
                k = j;
                if (mItemDecorations.size() > 0)
                {
                    k = j;
                    if (mItemAnimator.isRunning())
                    {
                        k = 1;
                    }
                }
            }
        }
        if (k != 0)
        {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void eatRequestLayout()
    {
        if (!mEatRequestLayout)
        {
            mEatRequestLayout = true;
            mLayoutRequestEaten = false;
        }
    }

    void ensureBottomGlow()
    {
        if (mBottomGlow != null)
        {
            return;
        }
        mBottomGlow = new EdgeEffectCompat(getContext());
        if (mClipToPadding)
        {
            mBottomGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    void ensureLeftGlow()
    {
        if (mLeftGlow != null)
        {
            return;
        }
        mLeftGlow = new EdgeEffectCompat(getContext());
        if (mClipToPadding)
        {
            mLeftGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    void ensureRightGlow()
    {
        if (mRightGlow != null)
        {
            return;
        }
        mRightGlow = new EdgeEffectCompat(getContext());
        if (mClipToPadding)
        {
            mRightGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    void ensureTopGlow()
    {
        if (mTopGlow != null)
        {
            return;
        }
        mTopGlow = new EdgeEffectCompat(getContext());
        if (mClipToPadding)
        {
            mTopGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    public View findChildViewUnder(float f, float f1)
    {
        for (int i = mChildHelper.getChildCount() - 1; i >= 0; i--)
        {
            View view = mChildHelper.getChildAt(i);
            float f2 = ViewCompat.getTranslationX(view);
            float f3 = ViewCompat.getTranslationY(view);
            if (f >= (float)view.getLeft() + f2 && f <= (float)view.getRight() + f2 && f1 >= (float)view.getTop() + f3 && f1 <= (float)view.getBottom() + f3)
            {
                return view;
            }
        }

        return null;
    }

    public ViewHolder findViewHolderForAdapterPosition(int i)
    {
        if (!mDataSetHasChangedAfterLayout) goto _L2; else goto _L1
_L1:
        ViewHolder viewholder = null;
_L6:
        return viewholder;
_L2:
        int j;
        int k;
        k = mChildHelper.getUnfilteredChildCount();
        j = 0;
_L7:
        if (j >= k) goto _L4; else goto _L3
_L3:
        ViewHolder viewholder1;
        viewholder1 = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
        if (viewholder1 == null || viewholder1.isRemoved())
        {
            continue; /* Loop/switch isn't completed */
        }
        viewholder = viewholder1;
        if (getAdapterPositionFor(viewholder1) == i) goto _L6; else goto _L5
_L5:
        j++;
          goto _L7
_L4:
        return null;
    }

    public ViewHolder findViewHolderForItemId(long l)
    {
        int j = mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < j; i++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (viewholder != null && viewholder.getItemId() == l)
            {
                return viewholder;
            }
        }

        return null;
    }

    public ViewHolder findViewHolderForLayoutPosition(int i)
    {
        return findViewHolderForPosition(i, false);
    }

    public ViewHolder findViewHolderForPosition(int i)
    {
        return findViewHolderForPosition(i, false);
    }

    ViewHolder findViewHolderForPosition(int i, boolean flag)
    {
        int k = mChildHelper.getUnfilteredChildCount();
        for (int j = 0; j < k; j++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(j));
            if (viewholder != null && !viewholder.isRemoved() && (flag ? viewholder.mPosition == i : viewholder.getLayoutPosition() == i))
            {
                return viewholder;
            }
        }

        return null;
    }

    public boolean fling(int i, int j)
    {
        if (mLayout != null) goto _L2; else goto _L1
_L1:
        Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
_L4:
        return false;
_L2:
        int k;
        boolean flag1;
label0:
        {
            boolean flag = mLayout.canScrollHorizontally();
            flag1 = mLayout.canScrollVertically();
            if (flag)
            {
                k = i;
                if (Math.abs(i) >= mMinFlingVelocity)
                {
                    break label0;
                }
            }
            k = 0;
        }
label1:
        {
            if (flag1)
            {
                i = j;
                if (Math.abs(j) >= mMinFlingVelocity)
                {
                    break label1;
                }
            }
            i = 0;
        }
        j = Math.max(-mMaxFlingVelocity, Math.min(k, mMaxFlingVelocity));
        i = Math.max(-mMaxFlingVelocity, Math.min(i, mMaxFlingVelocity));
        if (j != 0 || i != 0)
        {
            mViewFlinger.fling(j, i);
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View focusSearch(View view, int i)
    {
        View view1 = mLayout.onInterceptFocusSearch(view, i);
        if (view1 != null)
        {
            return view1;
        }
        View view2 = FocusFinder.getInstance().findNextFocus(this, view, i);
        view1 = view2;
        if (view2 == null)
        {
            view1 = view2;
            if (mAdapter != null)
            {
                view1 = view2;
                if (mLayout != null)
                {
                    eatRequestLayout();
                    view1 = mLayout.onFocusSearchFailed(view, i, mRecycler, mState);
                    resumeRequestLayout(false);
                }
            }
        }
        if (view1 != null)
        {
            return view1;
        } else
        {
            return super.focusSearch(view, i);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return mLayout.generateDefaultLayoutParams();
        }
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return mLayout.generateLayoutParams(getContext(), attributeset);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (mLayout == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return mLayout.generateLayoutParams(layoutparams);
        }
    }

    public Adapter getAdapter()
    {
        return mAdapter;
    }

    long getChangedHolderKey(ViewHolder viewholder)
    {
        if (mAdapter.hasStableIds())
        {
            return viewholder.getItemId();
        } else
        {
            return (long)viewholder.mPosition;
        }
    }

    public int getChildAdapterPosition(View view)
    {
        view = getChildViewHolderInt(view);
        if (view != null)
        {
            return view.getAdapterPosition();
        } else
        {
            return -1;
        }
    }

    public long getChildItemId(View view)
    {
        if (mAdapter != null && mAdapter.hasStableIds())
        {
            if ((view = getChildViewHolderInt(view)) != null)
            {
                return view.getItemId();
            }
        }
        return -1L;
    }

    public int getChildLayoutPosition(View view)
    {
        view = getChildViewHolderInt(view);
        if (view != null)
        {
            return view.getLayoutPosition();
        } else
        {
            return -1;
        }
    }

    public int getChildPosition(View view)
    {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(View view)
    {
        ViewParent viewparent = view.getParent();
        if (viewparent != null && viewparent != this)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("View ").append(view).append(" is not a direct child of ").append(this).toString());
        } else
        {
            return getChildViewHolderInt(view);
        }
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate()
    {
        return mAccessibilityDelegate;
    }

    public ItemAnimator getItemAnimator()
    {
        return mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view)
    {
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        if (!layoutparams.mInsetsDirty)
        {
            return layoutparams.mDecorInsets;
        }
        Rect rect = layoutparams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int j = mItemDecorations.size();
        for (int i = 0; i < j; i++)
        {
            mTempRect.set(0, 0, 0, 0);
            ((ItemDecoration)mItemDecorations.get(i)).getItemOffsets(mTempRect, view, this, mState);
            rect.left = rect.left + mTempRect.left;
            rect.top = rect.top + mTempRect.top;
            rect.right = rect.right + mTempRect.right;
            rect.bottom = rect.bottom + mTempRect.bottom;
        }

        layoutparams.mInsetsDirty = false;
        return rect;
    }

    public LayoutManager getLayoutManager()
    {
        return mLayout;
    }

    public RecycledViewPool getRecycledViewPool()
    {
        return mRecycler.getRecycledViewPool();
    }

    public int getScrollState()
    {
        return mScrollState;
    }

    public boolean hasFixedSize()
    {
        return mHasFixedSize;
    }

    void initAdapterManager()
    {
        mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() {

            final RecyclerView this$0;

            void dispatchUpdate(AdapterHelper.UpdateOp updateop)
            {
                switch (updateop.cmd)
                {
                default:
                    return;

                case 0: // '\0'
                    mLayout.onItemsAdded(RecyclerView.this, updateop.positionStart, updateop.itemCount);
                    return;

                case 1: // '\001'
                    mLayout.onItemsRemoved(RecyclerView.this, updateop.positionStart, updateop.itemCount);
                    return;

                case 2: // '\002'
                    mLayout.onItemsUpdated(RecyclerView.this, updateop.positionStart, updateop.itemCount);
                    return;

                case 3: // '\003'
                    mLayout.onItemsMoved(RecyclerView.this, updateop.positionStart, updateop.itemCount, 1);
                    break;
                }
            }

            public ViewHolder findViewHolder(int i)
            {
                return findViewHolderForPosition(i, true);
            }

            public void markViewHoldersUpdated(int i, int j)
            {
                viewRangeUpdate(i, j);
                mItemsChanged = true;
            }

            public void offsetPositionsForAdd(int i, int j)
            {
                offsetPositionRecordsForInsert(i, j);
                mItemsAddedOrRemoved = true;
            }

            public void offsetPositionsForMove(int i, int j)
            {
                offsetPositionRecordsForMove(i, j);
                mItemsAddedOrRemoved = true;
            }

            public void offsetPositionsForRemovingInvisible(int i, int j)
            {
                offsetPositionRecordsForRemove(i, j, true);
                mItemsAddedOrRemoved = true;
                i = ((LayoutManager) (this)).onItemsRemoved + i;
            }

            public void offsetPositionsForRemovingLaidOutOrNewView(int i, int j)
            {
                offsetPositionRecordsForRemove(i, j, false);
                mItemsAddedOrRemoved = true;
            }

            public void onDispatchFirstPass(AdapterHelper.UpdateOp updateop)
            {
                dispatchUpdate(updateop);
            }

            public void onDispatchSecondPass(AdapterHelper.UpdateOp updateop)
            {
                dispatchUpdate(updateop);
            }

            
            {
                this$0 = RecyclerView.this;
                super();
            }
        });
    }

    void invalidateGlows()
    {
        mBottomGlow = null;
        mTopGlow = null;
        mRightGlow = null;
        mLeftGlow = null;
    }

    public void invalidateItemDecorations()
    {
        if (mItemDecorations.size() == 0)
        {
            return;
        }
        if (mLayout != null)
        {
            mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    void markItemDecorInsetsDirty()
    {
        int j = mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < j; i++)
        {
            ((LayoutParams)mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
        }

        mRecycler.markItemDecorInsetsDirty();
    }

    void markKnownViewsInvalid()
    {
        int j = mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < j; i++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (viewholder != null && !viewholder.shouldIgnore())
            {
                viewholder.addFlags(6);
            }
        }

        markItemDecorInsetsDirty();
        mRecycler.markKnownViewsInvalid();
    }

    public void offsetChildrenHorizontal(int i)
    {
        int k = mChildHelper.getChildCount();
        for (int j = 0; j < k; j++)
        {
            mChildHelper.getChildAt(j).offsetLeftAndRight(i);
        }

    }

    public void offsetChildrenVertical(int i)
    {
        int k = mChildHelper.getChildCount();
        for (int j = 0; j < k; j++)
        {
            mChildHelper.getChildAt(j).offsetTopAndBottom(i);
        }

    }

    void offsetPositionRecordsForInsert(int i, int j)
    {
        int l = mChildHelper.getUnfilteredChildCount();
        for (int k = 0; k < l; k++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(k));
            if (viewholder != null && !viewholder.shouldIgnore() && viewholder.mPosition >= i)
            {
                viewholder.offsetPosition(j, false);
                mState.mStructureChanged = true;
            }
        }

        mRecycler.offsetPositionRecordsForInsert(i, j);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int i, int j)
    {
        int j1 = mChildHelper.getUnfilteredChildCount();
        int k;
        byte byte0;
        int l;
        int i1;
        if (i < j)
        {
            l = i;
            k = j;
            byte0 = -1;
        } else
        {
            l = j;
            k = i;
            byte0 = 1;
        }
        i1 = 0;
        while (i1 < j1) 
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i1));
            if (viewholder != null && viewholder.mPosition >= l && viewholder.mPosition <= k)
            {
                if (viewholder.mPosition == i)
                {
                    viewholder.offsetPosition(j - i, false);
                } else
                {
                    viewholder.offsetPosition(byte0, false);
                }
                mState.mStructureChanged = true;
            }
            i1++;
        }
        mRecycler.offsetPositionRecordsForMove(i, j);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i, int j, boolean flag)
    {
        int l = mChildHelper.getUnfilteredChildCount();
        int k = 0;
        while (k < l) 
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(k));
            if (viewholder != null && !viewholder.shouldIgnore())
            {
                if (viewholder.mPosition >= i + j)
                {
                    viewholder.offsetPosition(-j, flag);
                    mState.mStructureChanged = true;
                } else
                if (viewholder.mPosition >= i)
                {
                    viewholder.flagRemovedAndOffsetPosition(i - 1, -j, flag);
                    mState.mStructureChanged = true;
                }
            }
            k++;
        }
        mRecycler.offsetPositionRecordsForRemove(i, j, flag);
        requestLayout();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mIsAttached = true;
        mFirstLayoutComplete = false;
        if (mLayout != null)
        {
            mLayout.onAttachedToWindow(this);
        }
        mPostedAnimatorRunner = false;
    }

    public void onChildAttachedToWindow(View view)
    {
    }

    public void onChildDetachedFromWindow(View view)
    {
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mItemAnimator != null)
        {
            mItemAnimator.endAnimations();
        }
        mFirstLayoutComplete = false;
        stopScroll();
        mIsAttached = false;
        if (mLayout != null)
        {
            mLayout.onDetachedFromWindow(this, mRecycler);
        }
        removeCallbacks(mItemAnimatorRunner);
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int j = mItemDecorations.size();
        for (int i = 0; i < j; i++)
        {
            ((ItemDecoration)mItemDecorations.get(i)).onDraw(canvas, this, mState);
        }

    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i;
        int k;
        boolean flag;
        boolean flag1;
        if (dispatchOnItemTouchIntercept(motionevent))
        {
            cancelTouch();
            return true;
        }
        flag = mLayout.canScrollHorizontally();
        flag1 = mLayout.canScrollVertically();
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        k = MotionEventCompat.getActionMasked(motionevent);
        i = MotionEventCompat.getActionIndex(motionevent);
        k;
        JVM INSTR tableswitch 0 6: default 108
    //                   0 118
    //                   1 477
    //                   2 247
    //                   3 487
    //                   4 108
    //                   5 193
    //                   6 469;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_487;
_L8:
        return mScrollState == 1;
_L2:
        mScrollPointerId = MotionEventCompat.getPointerId(motionevent, 0);
        i = (int)(motionevent.getX() + 0.5F);
        mLastTouchX = i;
        mInitialTouchX = i;
        i = (int)(motionevent.getY() + 0.5F);
        mLastTouchY = i;
        mInitialTouchY = i;
        if (mScrollState == 2)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
            setScrollState(1);
        }
          goto _L8
_L6:
        mScrollPointerId = MotionEventCompat.getPointerId(motionevent, i);
        int l = (int)(MotionEventCompat.getX(motionevent, i) + 0.5F);
        mLastTouchX = l;
        mInitialTouchX = l;
        i = (int)(MotionEventCompat.getY(motionevent, i) + 0.5F);
        mLastTouchY = i;
        mInitialTouchY = i;
          goto _L8
_L4:
        int i1 = MotionEventCompat.findPointerIndex(motionevent, mScrollPointerId);
        if (i1 < 0)
        {
            Log.e("RecyclerView", (new StringBuilder()).append("Error processing scroll; pointer index for id ").append(mScrollPointerId).append(" not found. Did any MotionEvents get skipped?").toString());
            return false;
        }
        int j = (int)(MotionEventCompat.getX(motionevent, i1) + 0.5F);
        i1 = (int)(MotionEventCompat.getY(motionevent, i1) + 0.5F);
        if (mScrollState != 1)
        {
            int l1 = j - mInitialTouchX;
            int k1 = i1 - mInitialTouchY;
            i1 = 0;
            j = i1;
            if (flag)
            {
                j = i1;
                if (Math.abs(l1) > mTouchSlop)
                {
                    int j1 = mInitialTouchX;
                    int i2 = mTouchSlop;
                    if (l1 < 0)
                    {
                        j = -1;
                    } else
                    {
                        j = 1;
                    }
                    mLastTouchX = j * i2 + j1;
                    j = 1;
                }
            }
            j1 = j;
            if (flag1)
            {
                j1 = j;
                if (Math.abs(k1) > mTouchSlop)
                {
                    j1 = mInitialTouchY;
                    l1 = mTouchSlop;
                    if (k1 < 0)
                    {
                        j = -1;
                    } else
                    {
                        j = 1;
                    }
                    mLastTouchY = j * l1 + j1;
                    j1 = 1;
                }
            }
            if (j1 != 0)
            {
                setScrollState(1);
            }
        }
          goto _L8
_L7:
        onPointerUp(motionevent);
          goto _L8
_L3:
        mVelocityTracker.clear();
          goto _L8
        cancelTouch();
          goto _L8
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        eatRequestLayout();
        dispatchLayout();
        resumeRequestLayout(false);
        mFirstLayoutComplete = true;
    }

    protected void onMeasure(int i, int j)
    {
        if (mAdapterUpdateDuringMeasure)
        {
            eatRequestLayout();
            processAdapterUpdatesAndSetAnimationFlags();
            if (mState.mRunPredictiveAnimations)
            {
                mState.mInPreLayout = true;
            } else
            {
                mAdapterHelper.consumeUpdatesInOnePass();
                mState.mInPreLayout = false;
            }
            mAdapterUpdateDuringMeasure = false;
            resumeRequestLayout(false);
        }
        if (mAdapter != null)
        {
            mState.mItemCount = mAdapter.getItemCount();
        } else
        {
            mState.mItemCount = 0;
        }
        if (mLayout == null)
        {
            defaultOnMeasure(i, j);
        } else
        {
            mLayout.onMeasure(mRecycler, mState, i, j);
        }
        mState.mInPreLayout = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        mPendingSavedState = (SavedState)parcelable;
        super.onRestoreInstanceState(mPendingSavedState.getSuperState());
        if (mLayout != null && mPendingSavedState.mLayoutState != null)
        {
            mLayout.onRestoreInstanceState(mPendingSavedState.mLayoutState);
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (mPendingSavedState != null)
        {
            savedstate.copyFrom(mPendingSavedState);
            return savedstate;
        }
        if (mLayout != null)
        {
            savedstate.mLayoutState = mLayout.onSaveInstanceState();
            return savedstate;
        } else
        {
            savedstate.mLayoutState = null;
            return savedstate;
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (i != k || j != l)
        {
            invalidateGlows();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        int k;
        boolean flag1;
        boolean flag2;
        if (dispatchOnItemTouch(motionevent))
        {
            cancelTouch();
            return true;
        }
        flag1 = mLayout.canScrollHorizontally();
        flag2 = mLayout.canScrollVertically();
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        k = MotionEventCompat.getActionMasked(motionevent);
        i = MotionEventCompat.getActionIndex(motionevent);
        k;
        JVM INSTR tableswitch 0 6: default 112
    //                   0 114
    //                   1 586
    //                   2 235
    //                   3 689
    //                   4 112
    //                   5 172
    //                   6 578;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        return true;
_L2:
        mScrollPointerId = MotionEventCompat.getPointerId(motionevent, 0);
        i = (int)(motionevent.getX() + 0.5F);
        mLastTouchX = i;
        mInitialTouchX = i;
        i = (int)(motionevent.getY() + 0.5F);
        mLastTouchY = i;
        mInitialTouchY = i;
        continue; /* Loop/switch isn't completed */
_L6:
        mScrollPointerId = MotionEventCompat.getPointerId(motionevent, i);
        int l = (int)(MotionEventCompat.getX(motionevent, i) + 0.5F);
        mLastTouchX = l;
        mInitialTouchX = l;
        i = (int)(MotionEventCompat.getY(motionevent, i) + 0.5F);
        mLastTouchY = i;
        mInitialTouchY = i;
        continue; /* Loop/switch isn't completed */
_L4:
        int j = MotionEventCompat.findPointerIndex(motionevent, mScrollPointerId);
        if (j < 0)
        {
            Log.e("RecyclerView", (new StringBuilder()).append("Error processing scroll; pointer index for id ").append(mScrollPointerId).append(" not found. Did any MotionEvents get skipped?").toString());
            return false;
        }
        int k1 = (int)(MotionEventCompat.getX(motionevent, j) + 0.5F);
        int l1 = (int)(MotionEventCompat.getY(motionevent, j) + 0.5F);
        if (mScrollState != 1)
        {
            int k2 = k1 - mInitialTouchX;
            int i2 = l1 - mInitialTouchY;
            boolean flag = false;
            j = ((flag) ? 1 : 0);
            if (flag1)
            {
                j = ((flag) ? 1 : 0);
                if (Math.abs(k2) > mTouchSlop)
                {
                    int i1 = mInitialTouchX;
                    int j2 = mTouchSlop;
                    if (k2 < 0)
                    {
                        j = -1;
                    } else
                    {
                        j = 1;
                    }
                    mLastTouchX = j * j2 + i1;
                    j = 1;
                }
            }
            i1 = j;
            if (flag2)
            {
                i1 = j;
                if (Math.abs(i2) > mTouchSlop)
                {
                    i1 = mInitialTouchY;
                    j2 = mTouchSlop;
                    if (i2 < 0)
                    {
                        j = -1;
                    } else
                    {
                        j = 1;
                    }
                    mLastTouchY = j * j2 + i1;
                    i1 = 1;
                }
            }
            if (i1 != 0)
            {
                setScrollState(1);
            }
        }
        if (mScrollState == 1)
        {
            j = mLastTouchX;
            i1 = mLastTouchY;
            int j1;
            if (flag1)
            {
                j = -(k1 - j);
            } else
            {
                j = 0;
            }
            if (flag2)
            {
                j1 = -(l1 - i1);
            } else
            {
                j1 = 0;
            }
            if (scrollByInternal(j, j1))
            {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        mLastTouchX = k1;
        mLastTouchY = l1;
        continue; /* Loop/switch isn't completed */
_L7:
        onPointerUp(motionevent);
        continue; /* Loop/switch isn't completed */
_L3:
        mVelocityTracker.computeCurrentVelocity(1000, mMaxFlingVelocity);
        float f;
        float f1;
        if (flag1)
        {
            f = -VelocityTrackerCompat.getXVelocity(mVelocityTracker, mScrollPointerId);
        } else
        {
            f = 0.0F;
        }
        if (flag2)
        {
            f1 = -VelocityTrackerCompat.getYVelocity(mVelocityTracker, mScrollPointerId);
        } else
        {
            f1 = 0.0F;
        }
        if (f == 0.0F && f1 == 0.0F || !fling((int)f, (int)f1))
        {
            setScrollState(0);
        }
        mVelocityTracker.clear();
        releaseGlows();
        continue; /* Loop/switch isn't completed */
_L5:
        cancelTouch();
        if (true) goto _L1; else goto _L8
_L8:
    }

    void rebindUpdatedViewHolders()
    {
        int j = mChildHelper.getChildCount();
        int i = 0;
        while (i < j) 
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getChildAt(i));
            if (viewholder != null && !viewholder.shouldIgnore())
            {
                if (viewholder.isRemoved() || viewholder.isInvalid())
                {
                    requestLayout();
                } else
                if (viewholder.needsUpdate())
                {
                    int k = mAdapter.getItemViewType(viewholder.mPosition);
                    if (viewholder.getItemViewType() == k)
                    {
                        if (!viewholder.isChanged() || !supportsChangeAnimations())
                        {
                            mAdapter.bindViewHolder(viewholder, viewholder.mPosition);
                        } else
                        {
                            requestLayout();
                        }
                    } else
                    {
                        viewholder.addFlags(4);
                        requestLayout();
                    }
                }
            }
            i++;
        }
    }

    protected void removeDetachedView(View view, boolean flag)
    {
        ViewHolder viewholder = getChildViewHolderInt(view);
        if (viewholder != null)
        {
            if (viewholder.isTmpDetached())
            {
                viewholder.clearTmpDetachFlag();
            } else
            if (!viewholder.shouldIgnore())
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Called removeDetachedView with a view which is not flagged as tmp detached.").append(viewholder).toString());
            }
        }
        dispatchChildDetached(view);
        super.removeDetachedView(view, flag);
    }

    public void removeItemDecoration(ItemDecoration itemdecoration)
    {
        if (mLayout != null)
        {
            mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        mItemDecorations.remove(itemdecoration);
        if (mItemDecorations.isEmpty())
        {
            boolean flag;
            if (ViewCompat.getOverScrollMode(this) == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            setWillNotDraw(flag);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeOnItemTouchListener(OnItemTouchListener onitemtouchlistener)
    {
        mOnItemTouchListeners.remove(onitemtouchlistener);
        if (mActiveOnItemTouchListener == onitemtouchlistener)
        {
            mActiveOnItemTouchListener = null;
        }
    }

    public void requestChildFocus(View view, View view1)
    {
        boolean flag = false;
        if (!mLayout.onRequestChildFocus(this, mState, view, view1) && view1 != null)
        {
            mTempRect.set(0, 0, view1.getWidth(), view1.getHeight());
            offsetDescendantRectToMyCoords(view1, mTempRect);
            offsetRectIntoDescendantCoords(view, mTempRect);
            Rect rect = mTempRect;
            if (!mFirstLayoutComplete)
            {
                flag = true;
            }
            requestChildRectangleOnScreen(view, rect, flag);
        }
        super.requestChildFocus(view, view1);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag)
    {
        return mLayout.requestChildRectangleOnScreen(this, view, rect, flag);
    }

    public void requestLayout()
    {
        if (!mEatRequestLayout)
        {
            super.requestLayout();
            return;
        } else
        {
            mLayoutRequestEaten = true;
            return;
        }
    }

    void resumeRequestLayout(boolean flag)
    {
        if (mEatRequestLayout)
        {
            if (flag && mLayoutRequestEaten && mLayout != null && mAdapter != null)
            {
                dispatchLayout();
            }
            mEatRequestLayout = false;
            mLayoutRequestEaten = false;
        }
    }

    void saveOldPositions()
    {
        int j = mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < j; i++)
        {
            ViewHolder viewholder = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (!viewholder.shouldIgnore())
            {
                viewholder.saveOldPosition();
            }
        }

    }

    public void scrollBy(int i, int j)
    {
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else
        {
            boolean flag = mLayout.canScrollHorizontally();
            boolean flag1 = mLayout.canScrollVertically();
            if (flag || flag1)
            {
                if (!flag)
                {
                    i = 0;
                }
                if (!flag1)
                {
                    j = 0;
                }
                scrollByInternal(i, j);
                return;
            }
        }
    }

    boolean scrollByInternal(int i, int j)
    {
        int l = 0;
        boolean flag2 = false;
        int i1 = 0;
        boolean flag1 = false;
        int k = 0;
        boolean flag3 = false;
        int j1 = 0;
        boolean flag = false;
        consumePendingUpdateOperations();
        if (mAdapter != null)
        {
            eatRequestLayout();
            mRunningLayoutOrScroll = true;
            k = ((flag3) ? 1 : 0);
            l = ((flag2) ? 1 : 0);
            if (i != 0)
            {
                k = mLayout.scrollHorizontallyBy(i, mRecycler, mState);
                l = i - k;
            }
            i1 = ((flag1) ? 1 : 0);
            j1 = ((flag) ? 1 : 0);
            if (j != 0)
            {
                j1 = mLayout.scrollVerticallyBy(j, mRecycler, mState);
                i1 = j - j1;
            }
            if (supportsChangeAnimations())
            {
                int l1 = mChildHelper.getChildCount();
                int k1 = 0;
                while (k1 < l1) 
                {
                    View view = mChildHelper.getChildAt(k1);
                    Object obj = getChildViewHolder(view);
                    if (obj == null || ((ViewHolder) (obj)).mShadowingHolder == null)
                    {
                        continue;
                    }
                    obj = ((ViewHolder) (obj)).mShadowingHolder;
                    int i2;
                    int j2;
                    if (obj != null)
                    {
                        obj = ((ViewHolder) (obj)).itemView;
                    } else
                    {
                        obj = null;
                    }
                    if (obj == null)
                    {
                        continue;
                    }
                    i2 = view.getLeft();
                    j2 = view.getTop();
                    if (i2 != ((View) (obj)).getLeft() || j2 != ((View) (obj)).getTop())
                    {
                        ((View) (obj)).layout(i2, j2, ((View) (obj)).getWidth() + i2, ((View) (obj)).getHeight() + j2);
                    }
                    k1++;
                }
            }
            mRunningLayoutOrScroll = false;
            resumeRequestLayout(false);
        }
        if (!mItemDecorations.isEmpty())
        {
            invalidate();
        }
        if (ViewCompat.getOverScrollMode(this) != 2)
        {
            considerReleasingGlowsOnScroll(i, j);
            pullGlows(l, i1);
        }
        if (k != 0 || j1 != 0)
        {
            notifyOnScrolled(k, j1);
        }
        if (!awakenScrollBars())
        {
            invalidate();
        }
        return k != 0 || j1 != 0;
    }

    public void scrollTo(int i, int j)
    {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void scrollToPosition(int i)
    {
        stopScroll();
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        } else
        {
            mLayout.scrollToPosition(i);
            awakenScrollBars();
            return;
        }
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerviewaccessibilitydelegate)
    {
        mAccessibilityDelegate = recyclerviewaccessibilitydelegate;
        ViewCompat.setAccessibilityDelegate(this, mAccessibilityDelegate);
    }

    public void setAdapter(Adapter adapter)
    {
        setAdapterInternal(adapter, false, true);
        requestLayout();
    }

    public void setClipToPadding(boolean flag)
    {
        if (flag != mClipToPadding)
        {
            invalidateGlows();
        }
        mClipToPadding = flag;
        super.setClipToPadding(flag);
        if (mFirstLayoutComplete)
        {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean flag)
    {
        mHasFixedSize = flag;
    }

    public void setItemAnimator(ItemAnimator itemanimator)
    {
        if (mItemAnimator != null)
        {
            mItemAnimator.endAnimations();
            mItemAnimator.setListener(null);
        }
        mItemAnimator = itemanimator;
        if (mItemAnimator != null)
        {
            mItemAnimator.setListener(mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i)
    {
        mRecycler.setViewCacheSize(i);
    }

    public void setLayoutManager(LayoutManager layoutmanager)
    {
        if (layoutmanager == mLayout)
        {
            return;
        }
        if (mLayout != null)
        {
            if (mIsAttached)
            {
                mLayout.onDetachedFromWindow(this, mRecycler);
            }
            mLayout.setRecyclerView(null);
        }
        mRecycler.clear();
        mChildHelper.removeAllViewsUnfiltered();
        mLayout = layoutmanager;
        if (layoutmanager != null)
        {
            if (layoutmanager.mRecyclerView != null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("LayoutManager ").append(layoutmanager).append(" is already attached to a RecyclerView: ").append(layoutmanager.mRecyclerView).toString());
            }
            mLayout.setRecyclerView(this);
            if (mIsAttached)
            {
                mLayout.onAttachedToWindow(this);
            }
        }
        requestLayout();
    }

    public void setOnScrollListener(OnScrollListener onscrolllistener)
    {
        mScrollListener = onscrolllistener;
    }

    public void setRecycledViewPool(RecycledViewPool recycledviewpool)
    {
        mRecycler.setRecycledViewPool(recycledviewpool);
    }

    public void setRecyclerListener(RecyclerListener recyclerlistener)
    {
        mRecyclerListener = recyclerlistener;
    }

    public void setScrollingTouchSlop(int i)
    {
        ViewConfiguration viewconfiguration = ViewConfiguration.get(getContext());
        switch (i)
        {
        default:
            Log.w("RecyclerView", (new StringBuilder()).append("setScrollingTouchSlop(): bad argument constant ").append(i).append("; using default value").toString());
            // fall through

        case 0: // '\0'
            mTouchSlop = viewconfiguration.getScaledTouchSlop();
            return;

        case 1: // '\001'
            mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewconfiguration);
            break;
        }
    }

    public void setViewCacheExtension(ViewCacheExtension viewcacheextension)
    {
        mRecycler.setViewCacheExtension(viewcacheextension);
    }

    public void smoothScrollBy(int i, int j)
    {
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else
        {
            if (!mLayout.canScrollHorizontally())
            {
                i = 0;
            }
            if (!mLayout.canScrollVertically())
            {
                j = 0;
            }
            if (i != 0 || j != 0)
            {
                mViewFlinger.smoothScrollBy(i, j);
                return;
            }
        }
    }

    public void smoothScrollToPosition(int i)
    {
        if (mLayout == null)
        {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        } else
        {
            mLayout.smoothScrollToPosition(this, mState, i);
            return;
        }
    }

    public void stopScroll()
    {
        setScrollState(0);
        stopScrollersInternal();
    }

    public void swapAdapter(Adapter adapter, boolean flag)
    {
        setAdapterInternal(adapter, true, flag);
        setDataSetChangedAfterLayout();
        requestLayout();
    }

    void viewRangeUpdate(int i, int j)
    {
        int l = mChildHelper.getUnfilteredChildCount();
        int k = 0;
        do
        {
            if (k >= l)
            {
                break;
            }
            View view = mChildHelper.getUnfilteredChildAt(k);
            ViewHolder viewholder = getChildViewHolderInt(view);
            if (viewholder != null && !viewholder.shouldIgnore() && viewholder.mPosition >= i && viewholder.mPosition < i + j)
            {
                viewholder.addFlags(2);
                if (supportsChangeAnimations())
                {
                    viewholder.addFlags(64);
                }
                ((LayoutParams)view.getLayoutParams()).mInsetsDirty = true;
            }
            k++;
        } while (true);
        mRecycler.viewRangeUpdate(i, j);
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT == 19 || android.os.Build.VERSION.SDK_INT == 20)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        FORCE_INVALIDATE_DISPLAY_LIST = flag;
    }









/*
    static boolean access$2302(RecyclerView recyclerview, boolean flag)
    {
        recyclerview.mRunningLayoutOrScroll = flag;
        return flag;
    }

*/














/*
    static boolean access$3602(RecyclerView recyclerview, boolean flag)
    {
        recyclerview.mAdapterUpdateDuringMeasure = flag;
        return flag;
    }

*/













/*
    static boolean access$502(RecyclerView recyclerview, boolean flag)
    {
        recyclerview.mPostedAnimatorRunner = flag;
        return flag;
    }

*/





}
