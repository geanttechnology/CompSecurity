// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.DismissableManager;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeOnTouchListener;
import com.nhaarman.listviewanimations.util.AdapterViewUtil;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo:
//            ContextualUndoView

public class ContextualUndoListViewTouchListener
    implements SwipeOnTouchListener
{
    public static interface Callback
    {

        public abstract void onListScrolled();

        public abstract void onViewSwiped(long l, int i);
    }


    private final long mAnimationTime;
    private final Callback mCallback;
    private boolean mDisallowSwipe;
    private DismissableManager mDismissableManager;
    private int mDownPosition;
    private View mDownView;
    private float mDownX;
    private float mDownY;
    private boolean mIsParentHorizontalScrollContainer;
    private final AbsListView mListView;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private boolean mPaused;
    private int mResIdOfTouchChild;
    private final int mSlop;
    private boolean mSwiping;
    private boolean mTouchChildTouched;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth;

    public ContextualUndoListViewTouchListener(AbsListView abslistview, Callback callback)
    {
        mViewWidth = 1;
        ViewConfiguration viewconfiguration = ViewConfiguration.get(abslistview.getContext());
        mSlop = viewconfiguration.getScaledTouchSlop();
        mMinFlingVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
        mMaxFlingVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        mAnimationTime = abslistview.getContext().getResources().getInteger(0x10e0000);
        mListView = abslistview;
        mCallback = callback;
    }

    private Rect getChildViewRect(View view, View view1)
    {
        Rect rect = new Rect(view1.getLeft(), view1.getTop(), view1.getRight(), view1.getBottom());
        Object obj = view1;
        if (view != view1)
        {
            while ((obj = (ViewGroup)((View) (obj)).getParent()) != view) 
            {
                rect.offset(((ViewGroup) (obj)).getLeft(), ((ViewGroup) (obj)).getTop());
            }
        }
        return rect;
    }

    private boolean handleDownEvent(View view, MotionEvent motionevent)
    {
label0:
        {
            mDisallowSwipe = false;
            if (mPaused)
            {
                return false;
            }
            Rect rect = new Rect();
            int j = mListView.getChildCount();
            int ai[] = new int[2];
            mListView.getLocationOnScreen(ai);
            int k = (int)motionevent.getRawX();
            int l = ai[0];
            int i1 = (int)motionevent.getRawY();
            int j1 = ai[1];
            int i = 0;
label1:
            do
            {
label2:
                {
                    if (i < j)
                    {
                        View view2 = mListView.getChildAt(i);
                        view2.getHitRect(rect);
                        if (!rect.contains(k - l, i1 - j1))
                        {
                            break label2;
                        }
                        mDownView = view2;
                    }
                    if (mDownView == null || !(mDownView instanceof ContextualUndoView))
                    {
                        break label0;
                    }
                    mDownX = motionevent.getRawX();
                    mDownY = motionevent.getRawY();
                    i = AdapterViewUtil.getPositionForView(mListView, mDownView);
                    if (mDismissableManager != null)
                    {
                        long l1 = ((ListAdapter)mListView.getAdapter()).getItemId(i);
                        if (!mDismissableManager.isDismissable(l1, i))
                        {
                            return false;
                        }
                    }
                    break label1;
                }
                i++;
            } while (true);
            boolean flag;
            if (!mIsParentHorizontalScrollContainer && mResIdOfTouchChild == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mTouchChildTouched = flag;
            if (mResIdOfTouchChild != 0)
            {
                mIsParentHorizontalScrollContainer = false;
                View view1 = mDownView.findViewById(mResIdOfTouchChild);
                if (view1 != null && getChildViewRect(mListView, view1).contains((int)motionevent.getX(), (int)motionevent.getY()))
                {
                    mTouchChildTouched = true;
                    mListView.requestDisallowInterceptTouchEvent(true);
                }
            }
            if (mIsParentHorizontalScrollContainer)
            {
                mTouchChildTouched = true;
                mListView.requestDisallowInterceptTouchEvent(true);
            }
            mDownY = motionevent.getRawY();
            mDownPosition = AdapterViewUtil.getPositionForView(mListView, mDownView);
            if (mTouchChildTouched)
            {
                mVelocityTracker = VelocityTracker.obtain();
                mVelocityTracker.addMovement(motionevent);
            } else
            {
                mVelocityTracker = null;
            }
        }
        view.onTouchEvent(motionevent);
        return true;
    }

    private boolean handleMoveEvent(View view, MotionEvent motionevent)
    {
        if (mVelocityTracker == null || mPaused)
        {
            return false;
        }
        mVelocityTracker.addMovement(motionevent);
        float f = motionevent.getRawX() - mDownX;
        float f1 = motionevent.getRawY();
        float f2 = mDownY;
        if (mTouchChildTouched && !mDisallowSwipe && Math.abs(f) > (float)mSlop && Math.abs(f) > Math.abs(f1 - f2))
        {
            mSwiping = true;
            mListView.requestDisallowInterceptTouchEvent(true);
            view = MotionEvent.obtain(motionevent);
            view.setAction(motionevent.getActionIndex() << 8 | 3);
            mListView.onTouchEvent(view);
            view.recycle();
        }
        if (mSwiping)
        {
            ViewHelper.setTranslationX(mDownView, f);
            ViewHelper.setAlpha(mDownView, Math.max(0.0F, Math.min(1.0F, 1.0F - (2.0F * Math.abs(f)) / (float)mViewWidth)));
            return true;
        } else
        {
            return false;
        }
    }

    private boolean handleUpCancelEvent(View view, MotionEvent motionevent)
    {
        mDisallowSwipe = false;
        if (mVelocityTracker == null)
        {
            return false;
        }
        float f = motionevent.getRawX() - mDownX;
        mVelocityTracker.addMovement(motionevent);
        mVelocityTracker.computeCurrentVelocity(1000);
        float f2 = Math.abs(mVelocityTracker.getXVelocity());
        float f3 = Math.abs(mVelocityTracker.getYVelocity());
        boolean flag1 = false;
        boolean flag2 = false;
        float f4 = Math.abs(f);
        boolean flag;
        final int downPosition;
        if (f4 > (float)(mViewWidth / 2))
        {
            downPosition = 1;
            final long itemId;
            if (f > 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            downPosition = ((flag1) ? 1 : 0);
            flag = flag2;
            if ((float)mMinFlingVelocity <= f2)
            {
                downPosition = ((flag1) ? 1 : 0);
                flag = flag2;
                if (f2 <= (float)mMaxFlingVelocity)
                {
                    downPosition = ((flag1) ? 1 : 0);
                    flag = flag2;
                    if (f3 < f2)
                    {
                        downPosition = ((flag1) ? 1 : 0);
                        flag = flag2;
                        if (f4 > (float)mSlop)
                        {
                            downPosition = 1;
                            if (mVelocityTracker.getXVelocity() > 0.0F)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                        }
                    }
                }
            }
        }
        if (downPosition != 0)
        {
            itemId = ((ContextualUndoView)mDownView).getItemId();
            downPosition = mDownPosition;
            view = ViewPropertyAnimator.animate(mDownView);
            float f1;
            if (flag)
            {
                f1 = mViewWidth;
            } else
            {
                f1 = -mViewWidth;
            }
            view.translationX(f1).alpha(0.0F).setDuration(mAnimationTime).setListener(new AnimatorListenerAdapter() {

                final ContextualUndoListViewTouchListener this$0;
                final int val$downPosition;
                final long val$itemId;

                public void onAnimationEnd(Animator animator)
                {
                    mCallback.onViewSwiped(itemId, downPosition);
                }

            
            {
                this$0 = ContextualUndoListViewTouchListener.this;
                itemId = l;
                downPosition = i;
                super();
            }
            });
        } else
        {
            ViewPropertyAnimator.animate(mDownView).translationX(0.0F).alpha(1.0F).setDuration(mAnimationTime).setListener(null);
        }
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        mDownX = 0.0F;
        mDownView = null;
        mDownPosition = -1;
        mSwiping = false;
        return false;
    }

    public boolean isSwiping()
    {
        return mSwiping;
    }

    public android.widget.AbsListView.OnScrollListener makeScrollListener()
    {
        return new android.widget.AbsListView.OnScrollListener() {

            final ContextualUndoListViewTouchListener this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
                abslistview = ContextualUndoListViewTouchListener.this;
                boolean flag;
                if (i != 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                abslistview.setEnabled(flag);
                if (mPaused)
                {
                    mCallback.onListScrolled();
                }
                if (i != 0)
                {
                    mDisallowSwipe = true;
                }
            }

            
            {
                this$0 = ContextualUndoListViewTouchListener.this;
                super();
            }
        };
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (mViewWidth < 2)
        {
            mViewWidth = mListView.getWidth();
        }
        switch (motionevent.getActionMasked())
        {
        default:
            return false;

        case 0: // '\0'
            return handleDownEvent(view, motionevent);

        case 2: // '\002'
            return handleMoveEvent(view, motionevent);

        case 1: // '\001'
        case 3: // '\003'
            return handleUpCancelEvent(view, motionevent);
        }
    }

    public void setDismissableManager(DismissableManager dismissablemanager)
    {
        mDismissableManager = dismissablemanager;
    }

    public void setEnabled(boolean flag)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPaused = flag;
    }

    void setIsParentHorizontalScrollContainer(boolean flag)
    {
        if (mResIdOfTouchChild == 0 && flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsParentHorizontalScrollContainer = flag;
    }

    void setTouchChild(int i)
    {
        mResIdOfTouchChild = i;
        if (i != 0)
        {
            setIsParentHorizontalScrollContainer(false);
        }
    }




/*
    static boolean access$202(ContextualUndoListViewTouchListener contextualundolistviewtouchlistener, boolean flag)
    {
        contextualundolistviewtouchlistener.mDisallowSwipe = flag;
        return flag;
    }

*/
}
