// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.BaseAdapterDecorator;
import com.nhaarman.listviewanimations.util.AdapterViewUtil;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo:
//            ContextualUndoView, ContextualUndoListViewTouchListener

public class ContextualUndoAdapter extends BaseAdapterDecorator
    implements ContextualUndoListViewTouchListener.Callback
{
    public static interface CountDownFormatter
    {

        public abstract String getCountDownString(long l);
    }

    private class CountDownRunnable
        implements Runnable
    {

        final ContextualUndoAdapter this$0;

        public void run()
        {
            long l = (long)mAutoDeleteDelayMillis - (System.currentTimeMillis() - mDismissStartMillis);
            if (mCountDownFormatter != null)
            {
                mCurrentRemovedView.updateCountDownTimer(mCountDownFormatter.getCountDownString(l));
            }
            if (l <= 0L)
            {
                performRemovalIfNecessary();
                return;
            } else
            {
                mHandler.postDelayed(this, Math.min(l, 1000L));
                return;
            }
        }

        private CountDownRunnable()
        {
            this$0 = ContextualUndoAdapter.this;
            super();
        }

    }

    public static interface DeleteItemCallback
    {

        public abstract void deleteItem(int i);
    }

    private class HierarchyChangeListener
        implements android.view.ViewGroup.OnHierarchyChangeListener
    {

        final ContextualUndoAdapter this$0;

        public void onChildViewAdded(View view, View view1)
        {
            view = ViewHolder.getViewHolder(view1);
            if (view != null && mCurrentRemovedId > 0L && ((ViewHolder) (view)).mItemId == mCurrentRemovedId)
            {
                mCurrentRemovedView = (ContextualUndoView)view1;
            }
        }

        public void onChildViewRemoved(View view, View view1)
        {
            view = ViewHolder.getViewHolder(view1);
            if (view != null && mCurrentRemovedId > 0L && ((ViewHolder) (view)).mItemId == mCurrentRemovedId)
            {
                mCurrentRemovedView = null;
            }
        }

        private HierarchyChangeListener()
        {
            this$0 = ContextualUndoAdapter.this;
            super();
        }

    }

    private class RemoveViewAnimatorListenerAdapter extends AnimatorListenerAdapter
    {

        private ContextualUndoView mDismissView;
        private final long mDismissViewId;
        private final int mOriginalHeight;
        final ContextualUndoAdapter this$0;

        private void deleteCurrentItem(View view)
        {
            int i = AdapterViewUtil.getPositionForView(getAbsListView(), view);
            mDeleteItemCallback.deleteItem(i);
        }

        private ContextualUndoView getViewBeingAnimated()
        {
            ContextualUndoView contextualundoview = getCurrentRemovedView(mDismissView, mDismissViewId);
            if (contextualundoview != mDismissView)
            {
                restoreViewPosition(mDismissView);
                restoreViewDimension(mDismissView);
                mDismissView = contextualundoview;
            }
            return mDismissView;
        }

        private void restoreViewDimension(View view)
        {
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            layoutparams.height = mOriginalHeight;
            view.setLayoutParams(layoutparams);
        }

        public void onAnimationEnd(Animator animator)
        {
            mDismissView = getViewBeingAnimated();
            if (mDismissView == null)
            {
                deleteItemGivenId(mDismissViewId);
                return;
            } else
            {
                restoreViewPosition(mDismissView);
                restoreViewDimension(mDismissView);
                deleteCurrentItem(mDismissView);
                return;
            }
        }



        public RemoveViewAnimatorListenerAdapter(ContextualUndoView contextualundoview, long l)
        {
            this$0 = ContextualUndoAdapter.this;
            super();
            mDismissView = contextualundoview;
            mDismissViewId = l;
            mOriginalHeight = contextualundoview.getHeight();
        }
    }

    private class RemoveViewAnimatorUpdateListener
        implements com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
    {

        private final android.view.ViewGroup.LayoutParams mLayoutParams;
        final RemoveViewAnimatorListenerAdapter mParentAdapter;
        final ContextualUndoAdapter this$0;

        public void onAnimationUpdate(ValueAnimator valueanimator)
        {
            ContextualUndoView contextualundoview = mParentAdapter.getViewBeingAnimated();
            if (contextualundoview != null)
            {
                mLayoutParams.height = ((Integer)valueanimator.getAnimatedValue()).intValue();
                contextualundoview.setLayoutParams(mLayoutParams);
            }
        }

        public RemoveViewAnimatorUpdateListener(RemoveViewAnimatorListenerAdapter removeviewanimatorlisteneradapter)
        {
            this$0 = ContextualUndoAdapter.this;
            super();
            mParentAdapter = removeviewanimatorlisteneradapter;
            mLayoutParams = removeviewanimatorlisteneradapter.mDismissView.getLayoutParams();
        }
    }

    private class UndoListener
        implements android.view.View.OnClickListener
    {

        private final ContextualUndoView mContextualUndoView;
        final ContextualUndoAdapter this$0;

        private void animateViewComingBack()
        {
            ViewPropertyAnimator.animate(mContextualUndoView).translationX(0.0F).setDuration(150L).setListener(null);
        }

        private void moveViewOffScreen()
        {
            ViewHelper.setTranslationX(mContextualUndoView, mContextualUndoView.getWidth());
        }

        public void onClick(View view)
        {
            clearCurrentRemovedView();
            mContextualUndoView.displayContentView();
            moveViewOffScreen();
            animateViewComingBack();
        }

        public UndoListener(ContextualUndoView contextualundoview)
        {
            this$0 = ContextualUndoAdapter.this;
            super();
            mContextualUndoView = contextualundoview;
        }
    }

    private static class ViewHolder
    {

        final ContextualUndoView mContextualUndoView;
        long mItemId;

        static ViewHolder getViewHolder(View view)
        {
            return (ViewHolder)view.getTag();
        }

        ViewHolder(ContextualUndoView contextualundoview)
        {
            mContextualUndoView = contextualundoview;
            mContextualUndoView.setTag(this);
        }
    }


    private static final int ANIMATION_DURATION = 150;
    private static final String EXTRA_ACTIVE_REMOVED_ID = "removedId";
    private static final String X = "x";
    private final int mAutoDeleteDelayMillis;
    private ContextualUndoListViewTouchListener mContextualUndoListViewTouchListener;
    private final CountDownFormatter mCountDownFormatter;
    private final CountDownRunnable mCountDownRunnable;
    private final int mCountDownTextViewResId;
    private long mCurrentRemovedId;
    private ContextualUndoView mCurrentRemovedView;
    private final DeleteItemCallback mDeleteItemCallback;
    private long mDismissStartMillis;
    private final Handler mHandler;
    private final int mUndoActionId;
    private final int mUndoLayoutId;

    public ContextualUndoAdapter(BaseAdapter baseadapter, int i, int j, int k, int l, DeleteItemCallback deleteitemcallback, CountDownFormatter countdownformatter)
    {
        super(baseadapter);
        mHandler = new Handler();
        mCountDownRunnable = new CountDownRunnable();
        mUndoLayoutId = i;
        mUndoActionId = j;
        mCurrentRemovedId = -1L;
        mAutoDeleteDelayMillis = k;
        mCountDownTextViewResId = l;
        mDeleteItemCallback = deleteitemcallback;
        mCountDownFormatter = countdownformatter;
    }

    public ContextualUndoAdapter(BaseAdapter baseadapter, int i, int j, int k, DeleteItemCallback deleteitemcallback)
    {
        this(baseadapter, i, j, k, -1, deleteitemcallback, null);
    }

    public ContextualUndoAdapter(BaseAdapter baseadapter, int i, int j, DeleteItemCallback deleteitemcallback)
    {
        this(baseadapter, i, j, -1, -1, deleteitemcallback, null);
    }

    private void clearCurrentRemovedView()
    {
        mCurrentRemovedView = null;
        mCurrentRemovedId = -1L;
        mHandler.removeCallbacks(mCountDownRunnable);
    }

    private void deleteItemGivenId(long l)
    {
        byte byte0 = -1;
        int k = getCount();
        int i = 0;
        do
        {
label0:
            {
                int j = byte0;
                if (i < k)
                {
                    if (getItemId(i) != l)
                    {
                        break label0;
                    }
                    j = i;
                }
                if (j >= 0)
                {
                    mDeleteItemCallback.deleteItem(j);
                }
                return;
            }
            i++;
        } while (true);
    }

    private ContextualUndoView getContextualUndoView(long l)
    {
        ContextualUndoView contextualundoview = null;
        AbsListView abslistview = getAbsListView();
        int j = abslistview.getChildCount();
        for (int i = 0; i < j;)
        {
            Object obj = abslistview.getChildAt(i);
            ContextualUndoView contextualundoview1 = contextualundoview;
            if (obj instanceof ContextualUndoView)
            {
                obj = (ContextualUndoView)obj;
                contextualundoview1 = contextualundoview;
                if (((ContextualUndoView) (obj)).getItemId() == l)
                {
                    contextualundoview1 = ((ContextualUndoView) (obj));
                }
            }
            i++;
            contextualundoview = contextualundoview1;
        }

        return contextualundoview;
    }

    private ContextualUndoView getCurrentRemovedView(ContextualUndoView contextualundoview, long l)
    {
        ContextualUndoView contextualundoview1;
label0:
        {
            if (contextualundoview != null && contextualundoview.getParent() != null && contextualundoview.getItemId() == l)
            {
                contextualundoview1 = contextualundoview;
                if (AdapterViewUtil.getPositionForView(getAbsListView(), contextualundoview) >= 0)
                {
                    break label0;
                }
            }
            contextualundoview1 = getContextualUndoView(l);
        }
        return contextualundoview1;
    }

    private void performRemovalIfNecessary()
    {
        if (mCurrentRemovedId == -1L)
        {
            return;
        }
        Object obj = getCurrentRemovedView(mCurrentRemovedView, mCurrentRemovedId);
        if (obj != null)
        {
            ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
                ((ContextualUndoView) (obj)).getHeight(), 1
            }).setDuration(150L);
            obj = new RemoveViewAnimatorListenerAdapter(((ContextualUndoView) (obj)), mCurrentRemovedId);
            RemoveViewAnimatorUpdateListener removeviewanimatorupdatelistener = new RemoveViewAnimatorUpdateListener(((RemoveViewAnimatorListenerAdapter) (obj)));
            valueanimator.addListener(((com.nineoldandroids.animation.Animator.AnimatorListener) (obj)));
            valueanimator.addUpdateListener(removeviewanimatorupdatelistener);
            valueanimator.start();
        } else
        {
            deleteItemGivenId(mCurrentRemovedId);
        }
        clearCurrentRemovedView();
    }

    private void removePreviousContextualUndoIfPresent()
    {
        if (mCurrentRemovedView != null)
        {
            performRemovalIfNecessary();
        }
    }

    private void restoreViewPosition(View view)
    {
        ViewHelper.setAlpha(view, 1.0F);
        ViewHelper.setTranslationX(view, 0.0F);
    }

    private void setCurrentRemovedView(ContextualUndoView contextualundoview)
    {
        mCurrentRemovedView = contextualundoview;
        mCurrentRemovedId = contextualundoview.getItemId();
    }

    private void startAutoDeleteTimer()
    {
        mHandler.removeCallbacks(mCountDownRunnable);
        if (mCountDownFormatter != null)
        {
            mCurrentRemovedView.updateCountDownTimer(mCountDownFormatter.getCountDownString(mAutoDeleteDelayMillis));
        }
        mDismissStartMillis = System.currentTimeMillis();
        mHandler.postDelayed(mCountDownRunnable, Math.min(1000, mAutoDeleteDelayMillis));
    }

    private void swipeView(final View view, final int dismissPosition)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, "x", new float[] {
            (float)view.getMeasuredWidth()
        });
        objectanimator.addListener(new AnimatorListenerAdapter() {

            final ContextualUndoAdapter this$0;
            final int val$dismissPosition;
            final View val$view;

            public void onAnimationEnd(Animator animator)
            {
                onViewSwiped(((ContextualUndoView)view).getItemId(), dismissPosition);
            }

            
            {
                this$0 = ContextualUndoAdapter.this;
                view = view1;
                dismissPosition = i;
                super();
            }
        });
        objectanimator.start();
    }

    public void animateRemovePendingItem()
    {
        removePreviousContextualUndoIfPresent();
    }

    public void cancelCountDown()
    {
        mHandler.removeCallbacks(mCountDownRunnable);
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        view = (ContextualUndoView)view;
        long l;
        if (view == null)
        {
            view = new ContextualUndoView(viewgroup.getContext(), mUndoLayoutId, mCountDownTextViewResId);
            view.findViewById(mUndoActionId).setOnClickListener(new UndoListener(view));
            viewgroup = new ViewHolder(view);
        } else
        {
            viewgroup = ViewHolder.getViewHolder(view);
        }
        view.updateContentView(super.getView(i, view.getContentView(), view));
        l = getItemId(i);
        viewgroup.mItemId = l;
        if (l == mCurrentRemovedId)
        {
            view.displayUndo();
            long l1 = mAutoDeleteDelayMillis;
            long l2 = System.currentTimeMillis();
            long l3 = mDismissStartMillis;
            if (mCountDownFormatter != null)
            {
                view.updateCountDownTimer(mCountDownFormatter.getCountDownString(l1 - (l2 - l3)));
            }
        } else
        {
            view.displayContentView();
        }
        view.setItemId(l);
        return view;
    }

    public void onListScrolled()
    {
        performRemovalIfNecessary();
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            mCurrentRemovedId = bundle.getLong("removedId", -1L);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putLong("removedId", mCurrentRemovedId);
    }

    public void onViewSwiped(long l, int i)
    {
        ContextualUndoView contextualundoview = getContextualUndoView(l);
        if (contextualundoview == null)
        {
            removePreviousContextualUndoIfPresent();
            mCurrentRemovedView = null;
            mCurrentRemovedId = l;
        } else
        if (contextualundoview.isContentDisplayed())
        {
            restoreViewPosition(contextualundoview);
            contextualundoview.displayUndo();
            removePreviousContextualUndoIfPresent();
            setCurrentRemovedView(contextualundoview);
            if (mAutoDeleteDelayMillis > 0)
            {
                startAutoDeleteTimer();
                return;
            }
        } else
        {
            performRemovalIfNecessary();
            return;
        }
    }

    public void removePendingItem()
    {
        if (mCurrentRemovedView != null || mCurrentRemovedId >= 0L)
        {
            (new RemoveViewAnimatorListenerAdapter(mCurrentRemovedView, mCurrentRemovedId)).onAnimationEnd(null);
            clearCurrentRemovedView();
        }
    }

    public void removePendingItem(boolean flag)
    {
        if (flag)
        {
            animateRemovePendingItem();
            return;
        } else
        {
            removePendingItem();
            return;
        }
    }

    public void setAbsListView(AbsListView abslistview)
    {
        super.setAbsListView(abslistview);
        mContextualUndoListViewTouchListener = new ContextualUndoListViewTouchListener(abslistview, this);
        mContextualUndoListViewTouchListener.setIsParentHorizontalScrollContainer(isParentHorizontalScrollContainer());
        mContextualUndoListViewTouchListener.setTouchChild(getTouchChild());
        abslistview.setOnTouchListener(mContextualUndoListViewTouchListener);
        abslistview.setOnScrollListener(mContextualUndoListViewTouchListener.makeScrollListener());
        abslistview.setOnHierarchyChangeListener(new HierarchyChangeListener());
    }

    public void setIsParentHorizontalScrollContainer(boolean flag)
    {
        super.setIsParentHorizontalScrollContainer(flag);
        if (mContextualUndoListViewTouchListener != null)
        {
            mContextualUndoListViewTouchListener.setIsParentHorizontalScrollContainer(flag);
        }
    }

    public void setTouchChild(int i)
    {
        super.setTouchChild(i);
        if (mContextualUndoListViewTouchListener != null)
        {
            mContextualUndoListViewTouchListener.setTouchChild(i);
        }
    }

    public void swipeViewAtPosition(int i)
    {
        mCurrentRemovedId = getItemId(i);
        for (int j = 0; j < getAbsListView().getChildCount(); j++)
        {
            AbsListView abslistview = getAbsListView();
            View view = abslistview.getChildAt(j);
            int k = AdapterViewUtil.getPositionForView(abslistview, view);
            if (k == i)
            {
                swipeView(view, k);
            }
        }

    }










/*
    static ContextualUndoView access$502(ContextualUndoAdapter contextualundoadapter, ContextualUndoView contextualundoview)
    {
        contextualundoadapter.mCurrentRemovedView = contextualundoview;
        return contextualundoview;
    }

*/




}
