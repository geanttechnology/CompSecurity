// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.swinginadapters;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.nhaarman.listviewanimations.BaseAdapterDecorator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

public abstract class AnimationAdapter extends BaseAdapterDecorator
{

    private static final String ALPHA = "alpha";
    protected static final long DEFAULTANIMATIONDELAYMILLIS = 100L;
    protected static final long DEFAULTANIMATIONDURATIONMILLIS = 300L;
    private static final long INITIALDELAYMILLIS = 150L;
    private long mAnimationDelayMillis;
    private long mAnimationDurationMillis;
    private long mAnimationStartMillis;
    private final SparseArray mAnimators = new SparseArray();
    private int mFirstAnimatedPosition;
    private boolean mHasParentAnimationAdapter;
    private long mInitialDelayMillis;
    private int mLastAnimatedPosition;
    private boolean mShouldAnimate;

    public AnimationAdapter(BaseAdapter baseadapter)
    {
        super(baseadapter);
        mShouldAnimate = true;
        mInitialDelayMillis = 150L;
        mAnimationDelayMillis = 100L;
        mAnimationDurationMillis = 300L;
        mAnimationStartMillis = -1L;
        mFirstAnimatedPosition = -1;
        mLastAnimatedPosition = -1;
        if (baseadapter instanceof AnimationAdapter)
        {
            ((AnimationAdapter)baseadapter).setHasParentAnimationAdapter(true);
        }
    }

    private void animateView(ViewGroup viewgroup, View view)
    {
        if (mAnimationStartMillis == -1L)
        {
            mAnimationStartMillis = System.currentTimeMillis();
        }
        ViewHelper.setAlpha(view, 0.0F);
        Animator aanimator[];
        ObjectAnimator objectanimator;
        AnimatorSet animatorset;
        if (mDecoratedBaseAdapter instanceof AnimationAdapter)
        {
            aanimator = ((AnimationAdapter)mDecoratedBaseAdapter).getAnimators(viewgroup, view);
        } else
        {
            aanimator = new Animator[0];
        }
        viewgroup = getAnimators(viewgroup, view);
        objectanimator = ObjectAnimator.ofFloat(view, "alpha", new float[] {
            0.0F, 1.0F
        });
        animatorset = new AnimatorSet();
        animatorset.playTogether(concatAnimators(aanimator, viewgroup, objectanimator));
        animatorset.setStartDelay(calculateAnimationDelay());
        animatorset.setDuration(getAnimationDurationMillis());
        animatorset.start();
        mAnimators.put(view.hashCode(), animatorset);
    }

    private void animateViewIfNecessary(int i, View view, ViewGroup viewgroup)
    {
        boolean flag;
        if ((getAbsListView() instanceof GridView) && viewgroup.getHeight() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i > mLastAnimatedPosition && mShouldAnimate && !flag)
        {
            if (mFirstAnimatedPosition == -1)
            {
                mFirstAnimatedPosition = i;
            }
            animateView(viewgroup, view);
            mLastAnimatedPosition = i;
        }
    }

    private long calculateAnimationDelay()
    {
        long l;
        if ((getAbsListView().getLastVisiblePosition() - getAbsListView().getFirstVisiblePosition()) + 1 < mLastAnimatedPosition - mFirstAnimatedPosition)
        {
            long l1 = getAnimationDelayMillis();
            l = l1;
            if (getAbsListView() instanceof GridView)
            {
                l = l1;
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    l = getAnimationDelayMillis();
                    l = l1 + (long)((mLastAnimatedPosition + 1) % ((GridView)getAbsListView()).getNumColumns()) * l;
                }
            }
        } else
        {
            l = (mLastAnimatedPosition - mFirstAnimatedPosition) + 1;
            long l2 = getAnimationDelayMillis();
            l = (mAnimationStartMillis + getInitialDelayMillis() + l * l2) - System.currentTimeMillis();
        }
        return Math.max(0L, l);
    }

    private void cancelExistingAnimation(View view)
    {
        int i = view.hashCode();
        view = (Animator)mAnimators.get(i);
        if (view != null)
        {
            view.end();
            mAnimators.remove(i);
        }
    }

    private Animator[] concatAnimators(Animator aanimator[], Animator aanimator1[], Animator animator)
    {
        Animator aanimator2[] = new Animator[aanimator.length + aanimator1.length + 1];
        int i;
        for (i = 0; i < aanimator1.length; i++)
        {
            aanimator2[i] = aanimator1[i];
        }

        int k = aanimator.length;
        for (int j = 0; j < k; j++)
        {
            aanimator2[i] = aanimator[j];
            i++;
        }

        aanimator2[aanimator2.length - 1] = animator;
        return aanimator2;
    }

    protected long getAnimationDelayMillis()
    {
        return mAnimationDelayMillis;
    }

    protected long getAnimationDurationMillis()
    {
        return mAnimationDurationMillis;
    }

    public abstract Animator[] getAnimators(ViewGroup viewgroup, View view);

    protected long getInitialDelayMillis()
    {
        return mInitialDelayMillis;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (!mHasParentAnimationAdapter)
        {
            if (getAbsListView() == null)
            {
                throw new IllegalStateException("Call setListView() on this AnimationAdapter before setAdapter()!");
            }
            if (view != null)
            {
                cancelExistingAnimation(view);
            }
        }
        view = super.getView(i, view, viewgroup);
        if (!mHasParentAnimationAdapter)
        {
            animateViewIfNecessary(i, view, viewgroup);
        }
        return view;
    }

    public void reset()
    {
        mAnimators.clear();
        mFirstAnimatedPosition = -1;
        mLastAnimatedPosition = -1;
        mAnimationStartMillis = -1L;
        mShouldAnimate = true;
        if (getDecoratedBaseAdapter() instanceof AnimationAdapter)
        {
            ((AnimationAdapter)getDecoratedBaseAdapter()).reset();
        }
    }

    public void setAnimationDelayMillis(long l)
    {
        mAnimationDelayMillis = l;
    }

    public void setAnimationDurationMillis(long l)
    {
        mAnimationDurationMillis = l;
    }

    public void setHasParentAnimationAdapter(boolean flag)
    {
        mHasParentAnimationAdapter = flag;
    }

    public void setInitialDelayMillis(long l)
    {
        mInitialDelayMillis = l;
    }

    public void setShouldAnimate(boolean flag)
    {
        mShouldAnimate = flag;
    }

    public void setShouldAnimateFromPosition(int i)
    {
        mShouldAnimate = true;
        mFirstAnimatedPosition = i - 1;
        mLastAnimatedPosition = i - 1;
    }

    public void setShouldAnimateNotVisible()
    {
        if (getAbsListView() == null)
        {
            throw new IllegalStateException("Call setListView() on this AnimationAdapter before setShouldAnimateNotVisible()!");
        } else
        {
            mShouldAnimate = true;
            mFirstAnimatedPosition = getAbsListView().getLastVisiblePosition();
            mLastAnimatedPosition = getAbsListView().getLastVisiblePosition();
            return;
        }
    }
}
