// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.swinginadapters;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.haarman.listviewanimations.BaseAdapterDecorator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import junit.framework.Assert;

public abstract class AnimationAdapter extends BaseAdapterDecorator
{
    private class AnimationInfo
    {

        public Animator animator;
        public int position;
        final AnimationAdapter this$0;

        public AnimationInfo(int i, Animator animator1)
        {
            this$0 = AnimationAdapter.this;
            super();
            position = i;
            animator = animator1;
        }
    }


    protected static final long DEFAULTANIMATIONDELAYMILLIS = 100L;
    protected static final long DEFAULTANIMATIONDURATIONMILLIS = 300L;
    private static final long INITIALDELAYMILLIS = 150L;
    private long mAnimationStartMillis;
    private SparseArray mAnimators;
    private boolean mHasParentAnimationAdapter;
    private int mLastAnimatedPosition;

    public AnimationAdapter(BaseAdapter baseadapter)
    {
        super(baseadapter);
        mAnimators = new SparseArray();
        mAnimationStartMillis = -1L;
        mLastAnimatedPosition = -1;
        if (baseadapter instanceof AnimationAdapter)
        {
            ((AnimationAdapter)baseadapter).setHasParentAnimationAdapter(true);
        }
    }

    private void animateView(int i, ViewGroup viewgroup, View view)
    {
        if (mAnimationStartMillis == -1L)
        {
            mAnimationStartMillis = System.currentTimeMillis();
        }
        hideView(view);
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
        mAnimators.put(view.hashCode(), new AnimationInfo(i, animatorset));
    }

    private void animateViewIfNecessary(int i, View view, ViewGroup viewgroup)
    {
        if (i > mLastAnimatedPosition && !mHasParentAnimationAdapter)
        {
            animateView(i, viewgroup, view);
            mLastAnimatedPosition = i;
        }
    }

    private long calculateAnimationDelay()
    {
        long l;
        if ((getListView().getLastVisiblePosition() - getListView().getFirstVisiblePosition()) + 1 < mLastAnimatedPosition)
        {
            l = getAnimationDelayMillis();
        } else
        {
            l = mLastAnimatedPosition + 1;
            long l1 = getAnimationDelayMillis();
            l = (mAnimationStartMillis + 150L + l * l1) - System.currentTimeMillis();
        }
        return Math.max(0L, l);
    }

    private Animator[] concatAnimators(Animator aanimator[], Animator aanimator1[], Animator animator)
    {
        Animator aanimator2[];
        int i;
        aanimator2 = new Animator[aanimator.length + aanimator1.length + 1];
        i = 0;
_L3:
        if (i < aanimator1.length) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        if (j >= aanimator.length)
        {
            aanimator2[aanimator2.length - 1] = animator;
            return aanimator2;
        }
        break MISSING_BLOCK_LABEL_62;
_L2:
        aanimator2[i] = aanimator1[i];
        i++;
          goto _L3
        aanimator2[i] = aanimator[j];
        i++;
        j++;
          goto _L4
    }

    private void hideView(View view)
    {
        view = ObjectAnimator.ofFloat(view, "alpha", new float[] {
            0.0F
        });
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.play(view);
        animatorset.setDuration(0L);
        animatorset.start();
    }

    protected abstract long getAnimationDelayMillis();

    protected abstract long getAnimationDurationMillis();

    public abstract Animator[] getAnimators(ViewGroup viewgroup, View view);

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (!mHasParentAnimationAdapter)
        {
            Assert.assertNotNull("Call setListView() on this AnimationAdapter before setAdapter()!", getListView());
            flag = flag1;
            if (view != null)
            {
                int j = view.hashCode();
                AnimationInfo animationinfo = (AnimationInfo)mAnimators.get(j);
                flag = flag1;
                if (animationinfo != null)
                {
                    if (animationinfo.position != i)
                    {
                        animationinfo.animator.end();
                        mAnimators.remove(j);
                        flag = flag1;
                    } else
                    {
                        flag = true;
                    }
                }
            }
        }
        view = super.getView(i, view, viewgroup);
        if (!mHasParentAnimationAdapter && !flag)
        {
            animateViewIfNecessary(i, view, viewgroup);
        }
        return view;
    }

    public void reset()
    {
        mAnimators.clear();
        mLastAnimatedPosition = -1;
        mAnimationStartMillis = -1L;
        if (getDecoratedBaseAdapter() instanceof AnimationAdapter)
        {
            ((AnimationAdapter)getDecoratedBaseAdapter()).reset();
        }
    }

    public void setHasParentAnimationAdapter(boolean flag)
    {
        mHasParentAnimationAdapter = flag;
    }
}
