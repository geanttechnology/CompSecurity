// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.itemmanipulation.contextualundo;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.haarman.listviewanimations.BaseAdapterDecorator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.haarman.listviewanimations.itemmanipulation.contextualundo:
//            ContextualUndoView, ContextualUndoListViewTouchListener

public class ContextualUndoAdapter extends BaseAdapterDecorator
    implements ContextualUndoListViewTouchListener.Callback
{
    public static interface DeleteItemCallback
    {

        public abstract void deleteItem(int i);
    }

    private class RecycleViewListener
        implements android.widget.AbsListView.RecyclerListener
    {

        final ContextualUndoAdapter this$0;

        public void onMovedToScrapHeap(View view)
        {
            view = (Animator)mActiveAnimators.get(view);
            if (view != null)
            {
                view.cancel();
            }
        }

        private RecycleViewListener()
        {
            this$0 = ContextualUndoAdapter.this;
            super();
        }

        RecycleViewListener(RecycleViewListener recycleviewlistener)
        {
            this();
        }
    }

    private class RemoveViewAnimatorListenerAdapter extends AnimatorListenerAdapter
    {

        private final View mDismissView;
        private final int mOriginalHeight;
        final ContextualUndoAdapter this$0;

        private void deleteCurrentItem()
        {
            ContextualUndoView contextualundoview = (ContextualUndoView)mDismissView;
            int i = getListView().getPositionForView(contextualundoview);
            mDeleteItemCallback.deleteItem(i);
        }

        private void restoreViewDimension(View view)
        {
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            layoutparams.height = mOriginalHeight;
            view.setLayoutParams(layoutparams);
        }

        public void onAnimationEnd(Animator animator)
        {
            mActiveAnimators.remove(mDismissView);
            restoreViewPosition(mDismissView);
            restoreViewDimension(mDismissView);
            deleteCurrentItem();
        }

        public RemoveViewAnimatorListenerAdapter(View view)
        {
            this$0 = ContextualUndoAdapter.this;
            super();
            mDismissView = view;
            mOriginalHeight = view.getHeight();
        }
    }

    private class RemoveViewAnimatorUpdateListener
        implements com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
    {

        private final View mDismissView;
        private final android.view.ViewGroup.LayoutParams mLayoutParams;
        final ContextualUndoAdapter this$0;

        public void onAnimationUpdate(ValueAnimator valueanimator)
        {
            mLayoutParams.height = ((Integer)valueanimator.getAnimatedValue()).intValue();
            mDismissView.setLayoutParams(mLayoutParams);
        }

        public RemoveViewAnimatorUpdateListener(View view)
        {
            this$0 = ContextualUndoAdapter.this;
            super();
            mDismissView = view;
            mLayoutParams = view.getLayoutParams();
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


    private Map mActiveAnimators;
    private final int mAnimationTime = 150;
    private long mCurrentRemovedId;
    private ContextualUndoView mCurrentRemovedView;
    private DeleteItemCallback mDeleteItemCallback;
    private final int mUndoActionId;
    private final int mUndoLayoutId;

    public ContextualUndoAdapter(BaseAdapter baseadapter, int i, int j)
    {
        super(baseadapter);
        mActiveAnimators = new ConcurrentHashMap();
        mUndoLayoutId = i;
        mUndoActionId = j;
        mCurrentRemovedId = -1L;
    }

    private void clearCurrentRemovedView()
    {
        mCurrentRemovedView = null;
        mCurrentRemovedId = -1L;
    }

    private void performRemoval()
    {
        ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
            mCurrentRemovedView.getHeight(), 1
        }).setDuration(150L);
        valueanimator.addListener(new RemoveViewAnimatorListenerAdapter(mCurrentRemovedView));
        valueanimator.addUpdateListener(new RemoveViewAnimatorUpdateListener(mCurrentRemovedView));
        valueanimator.start();
        mActiveAnimators.put(mCurrentRemovedView, valueanimator);
        clearCurrentRemovedView();
    }

    private void removePreviousContextualUndoIfPresent()
    {
        if (mCurrentRemovedView != null)
        {
            performRemoval();
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

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        ContextualUndoView contextualundoview = (ContextualUndoView)view;
        view = contextualundoview;
        if (contextualundoview == null)
        {
            view = new ContextualUndoView(viewgroup.getContext(), mUndoLayoutId);
            view.findViewById(mUndoActionId).setOnClickListener(new UndoListener(view));
        }
        view.updateContentView(super.getView(i, view.getContentView(), viewgroup));
        long l = getItemId(i);
        if (l == mCurrentRemovedId)
        {
            view.displayUndo();
            mCurrentRemovedView = view;
        } else
        {
            view.displayContentView();
        }
        view.setItemId(l);
        return view;
    }

    public void onListScrolled()
    {
        if (mCurrentRemovedView != null)
        {
            performRemoval();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        mCurrentRemovedId = ((Bundle)parcelable).getLong("mCurrentRemovedId", -1L);
    }

    public Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putLong("mCurrentRemovedId", mCurrentRemovedId);
        return bundle;
    }

    public void onViewSwiped(View view, int i)
    {
        view = (ContextualUndoView)view;
        if (view.isContentDisplayed())
        {
            restoreViewPosition(view);
            view.displayUndo();
            removePreviousContextualUndoIfPresent();
            setCurrentRemovedView(view);
        } else
        if (mCurrentRemovedView != null)
        {
            performRemoval();
            return;
        }
    }

    public void setDeleteItemCallback(DeleteItemCallback deleteitemcallback)
    {
        mDeleteItemCallback = deleteitemcallback;
    }

    public void setListView(ListView listview)
    {
        super.setListView(listview);
        ContextualUndoListViewTouchListener contextualundolistviewtouchlistener = new ContextualUndoListViewTouchListener(listview, this);
        listview.setOnTouchListener(contextualundolistviewtouchlistener);
        listview.setOnScrollListener(contextualundolistviewtouchlistener.makeScrollListener());
        listview.setRecyclerListener(new RecycleViewListener(null));
    }




}
