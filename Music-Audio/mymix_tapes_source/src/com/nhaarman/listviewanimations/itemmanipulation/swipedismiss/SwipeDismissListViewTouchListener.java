// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss;

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
import com.nhaarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.nhaarman.listviewanimations.util.AdapterViewUtil;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss:
//            SwipeOnTouchListener, SwipeOnScrollListener, DismissableManager

public class SwipeDismissListViewTouchListener
    implements SwipeOnTouchListener
{
    protected class PendingDismissData
        implements Comparable
    {

        public final int position;
        final SwipeDismissListViewTouchListener this$0;
        public final View view;

        public int compareTo(PendingDismissData pendingdismissdata)
        {
            return pendingdismissdata.position - position;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((PendingDismissData)obj);
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null)
                {
                    return false;
                }
                if (getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (PendingDismissData)obj;
                if (position != ((PendingDismissData) (obj)).position)
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return position + 31;
        }

        public PendingDismissData(int i, View view1)
        {
            this$0 = SwipeDismissListViewTouchListener.this;
            super();
            position = i;
            view = view1;
        }
    }


    private static final int MIN_FLING_VELOCITY_FACTOR = 16;
    protected long mAnimationTime;
    private final OnDismissCallback mCallback;
    private PendingDismissData mCurrentDismissData;
    private boolean mDisallowSwipe;
    private int mDismissAnimationRefCount;
    private DismissableManager mDismissableManager;
    private float mDownX;
    private float mDownY;
    private boolean mIsParentHorizontalScrollContainer;
    private final AbsListView mListView;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    protected List mPendingDismisses;
    private int mResIdOfTouchChild;
    private final int mSlop;
    private boolean mSwiping;
    private boolean mTouchChildTouched;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth;
    private int mVirtualListCount;

    public SwipeDismissListViewTouchListener(AbsListView abslistview, OnDismissCallback ondismisscallback, SwipeOnScrollListener swipeonscrolllistener)
    {
        mViewWidth = 1;
        mPendingDismisses = new ArrayList();
        mDismissAnimationRefCount = 0;
        mVirtualListCount = -1;
        ViewConfiguration viewconfiguration = ViewConfiguration.get(abslistview.getContext());
        mSlop = viewconfiguration.getScaledTouchSlop();
        mMinFlingVelocity = viewconfiguration.getScaledMinimumFlingVelocity() * 16;
        mMaxFlingVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        mAnimationTime = abslistview.getContext().getResources().getInteger(0x10e0000);
        mListView = abslistview;
        mCallback = ondismisscallback;
        swipeonscrolllistener.setTouchListener(this);
        mListView.setOnScrollListener(swipeonscrolllistener);
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

    private boolean handleCancelEvent(MotionEvent motionevent)
    {
        if (mVelocityTracker == null)
        {
            return false;
        }
        if (mCurrentDismissData != null && mSwiping)
        {
            ViewPropertyAnimator.animate(mCurrentDismissData.view).translationX(0.0F).alpha(1.0F).setDuration(mAnimationTime).setListener(null);
        }
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        mDownX = 0.0F;
        mDownY = 0.0F;
        mCurrentDismissData = null;
        mSwiping = false;
        return false;
    }

    private boolean handleDownEvent(MotionEvent motionevent)
    {
        Rect rect = new Rect();
        int k = mListView.getChildCount();
        int ai[] = new int[2];
        mListView.getLocationOnScreen(ai);
        int l = (int)motionevent.getRawX();
        int i1 = ai[0];
        int j1 = (int)motionevent.getRawY();
        int k1 = ai[1];
        View view = null;
        for (int i = 0; i < k && view == null; i++)
        {
            View view1 = mListView.getChildAt(i);
            view1.getHitRect(rect);
            if (rect.contains(l - i1, j1 - k1))
            {
                view = view1;
            }
        }

        if (view != null)
        {
            mDownX = motionevent.getRawX();
            mDownY = motionevent.getRawY();
            int j = AdapterViewUtil.getPositionForView(mListView, view);
            if (mDismissableManager != null)
            {
                long l1 = ((ListAdapter)mListView.getAdapter()).getItemId(j);
                if (!mDismissableManager.isDismissable(l1, j))
                {
                    return false;
                }
            }
            mCurrentDismissData = createPendingDismissData(j, view);
            if (mPendingDismisses.contains(mCurrentDismissData) || j >= mVirtualListCount)
            {
                mCurrentDismissData = null;
                return false;
            }
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
                view = view.findViewById(mResIdOfTouchChild);
                if (view != null && getChildViewRect(mListView, view).contains((int)motionevent.getX(), (int)motionevent.getY()))
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
            mVelocityTracker = VelocityTracker.obtain();
            mVelocityTracker.addMovement(motionevent);
        }
        return true;
    }

    private boolean handleMoveEvent(MotionEvent motionevent)
    {
        if (mVelocityTracker != null)
        {
            mVelocityTracker.addMovement(motionevent);
            float f = motionevent.getRawX() - mDownX;
            float f1 = motionevent.getRawY();
            float f2 = mDownY;
            if (mTouchChildTouched && !mDisallowSwipe && Math.abs(f) > (float)mSlop && Math.abs(f) > Math.abs(f1 - f2))
            {
                mSwiping = true;
                mListView.requestDisallowInterceptTouchEvent(true);
                MotionEvent motionevent1 = MotionEvent.obtain(motionevent);
                motionevent1.setAction(motionevent.getActionIndex() << 8 | 3);
                mListView.onTouchEvent(motionevent1);
            }
            if (mSwiping)
            {
                ViewHelper.setTranslationX(mCurrentDismissData.view, f);
                ViewHelper.setAlpha(mCurrentDismissData.view, Math.max(0.0F, Math.min(1.0F, 1.0F - (2.0F * Math.abs(f)) / (float)mViewWidth)));
                return true;
            }
        }
        return false;
    }

    private boolean handleUpEvent(final MotionEvent pendingDismissData)
    {
        if (mVelocityTracker == null)
        {
            return false;
        }
        float f = pendingDismissData.getRawX() - mDownX;
        mVelocityTracker.addMovement(pendingDismissData);
        mVelocityTracker.computeCurrentVelocity(1000);
        float f2 = Math.abs(mVelocityTracker.getXVelocity());
        float f3 = Math.abs(mVelocityTracker.getYVelocity());
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag;
        boolean flag1;
        if (Math.abs(f) > (float)(mViewWidth / 2))
        {
            flag1 = true;
            ViewPropertyAnimator viewpropertyanimator;
            if (f > 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag1 = flag2;
            flag = flag3;
            if ((float)mMinFlingVelocity <= f2)
            {
                flag1 = flag2;
                flag = flag3;
                if (f2 <= (float)mMaxFlingVelocity)
                {
                    flag1 = flag2;
                    flag = flag3;
                    if (f3 < f2)
                    {
                        flag1 = true;
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
        if (mSwiping)
        {
            if (flag1)
            {
                pendingDismissData = mCurrentDismissData;
                mDismissAnimationRefCount = mDismissAnimationRefCount + 1;
                viewpropertyanimator = ViewPropertyAnimator.animate(mCurrentDismissData.view);
                float f1;
                if (flag)
                {
                    f1 = mViewWidth;
                } else
                {
                    f1 = -mViewWidth;
                }
                viewpropertyanimator.translationX(f1).alpha(0.0F).setDuration(mAnimationTime).setListener(new AnimatorListenerAdapter() {

                    final SwipeDismissListViewTouchListener this$0;
                    final PendingDismissData val$pendingDismissData;

                    public void onAnimationEnd(Animator animator)
                    {
                        onDismiss(pendingDismissData);
                    }

            
            {
                this$0 = SwipeDismissListViewTouchListener.this;
                pendingDismissData = pendingdismissdata;
                super();
            }
                });
                mVirtualListCount = mVirtualListCount - 1;
                mPendingDismisses.add(mCurrentDismissData);
            } else
            {
                ViewPropertyAnimator.animate(mCurrentDismissData.view).translationX(0.0F).alpha(1.0F).setDuration(mAnimationTime).setListener(null);
            }
        }
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        mDownX = 0.0F;
        mDownY = 0.0F;
        mCurrentDismissData = null;
        mSwiping = false;
        return false;
    }

    public void allowSwipe()
    {
        mDisallowSwipe = false;
    }

    protected PendingDismissData createPendingDismissData(int i, View view)
    {
        return new PendingDismissData(i, view);
    }

    public void disallowSwipe()
    {
        mDisallowSwipe = true;
    }

    protected void finalizeDismiss()
    {
        mDismissAnimationRefCount = mDismissAnimationRefCount - 1;
        if (mDismissAnimationRefCount == 0)
        {
            Collections.sort(mPendingDismisses);
            int ai[] = new int[mPendingDismisses.size()];
            for (int i = mPendingDismisses.size() - 1; i >= 0; i--)
            {
                ai[i] = ((PendingDismissData)mPendingDismisses.get(i)).position;
            }

            mCallback.onDismiss(mListView, ai);
            recycleDismissedViewsItems(mPendingDismisses);
            mPendingDismisses.clear();
        }
    }

    public boolean isSwiping()
    {
        return mSwiping;
    }

    public void notifyDataSetChanged()
    {
        mVirtualListCount = ((ListAdapter)mListView.getAdapter()).getCount();
    }

    protected void onDismiss(PendingDismissData pendingdismissdata)
    {
        performDismiss(pendingdismissdata);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (mVirtualListCount == -1)
        {
            mVirtualListCount = ((ListAdapter)mListView.getAdapter()).getCount();
        }
        if (mViewWidth < 2)
        {
            mViewWidth = mListView.getWidth();
        }
        switch (motionevent.getActionMasked())
        {
        default:
            return false;

        case 0: // '\0'
            mDisallowSwipe = false;
            view.onTouchEvent(motionevent);
            return handleDownEvent(motionevent);

        case 2: // '\002'
            return handleMoveEvent(motionevent);

        case 3: // '\003'
            return handleCancelEvent(motionevent);

        case 1: // '\001'
            mDisallowSwipe = false;
            break;
        }
        mTouchChildTouched = false;
        return handleUpEvent(motionevent);
    }

    protected void performDismiss(final PendingDismissData data)
    {
        final android.view.ViewGroup.LayoutParams lp = data.view.getLayoutParams();
        ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
            data.view.getHeight(), 1
        }).setDuration(mAnimationTime);
        valueanimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

            final SwipeDismissListViewTouchListener this$0;
            final PendingDismissData val$data;
            final android.view.ViewGroup.LayoutParams val$lp;

            public void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                lp.height = ((Integer)valueanimator1.getAnimatedValue()).intValue();
                data.view.setLayoutParams(lp);
            }

            
            {
                this$0 = SwipeDismissListViewTouchListener.this;
                lp = layoutparams;
                data = pendingdismissdata;
                super();
            }
        });
        valueanimator.addListener(new AnimatorListenerAdapter() {

            final SwipeDismissListViewTouchListener this$0;

            public void onAnimationEnd(Animator animator)
            {
                finalizeDismiss();
            }

            
            {
                this$0 = SwipeDismissListViewTouchListener.this;
                super();
            }
        });
        valueanimator.start();
    }

    protected void recycleDismissedViewsItems(List list)
    {
        PendingDismissData pendingdismissdata;
        android.view.ViewGroup.LayoutParams layoutparams;
        for (list = list.iterator(); list.hasNext(); pendingdismissdata.view.setLayoutParams(layoutparams))
        {
            pendingdismissdata = (PendingDismissData)list.next();
            ViewHelper.setAlpha(pendingdismissdata.view, 1.0F);
            ViewHelper.setTranslationX(pendingdismissdata.view, 0.0F);
            layoutparams = pendingdismissdata.view.getLayoutParams();
            layoutparams.height = 0;
        }

    }

    public void setDismissableManager(DismissableManager dismissablemanager)
    {
        mDismissableManager = dismissablemanager;
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
}
