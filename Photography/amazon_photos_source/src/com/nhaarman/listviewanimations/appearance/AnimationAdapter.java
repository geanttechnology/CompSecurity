// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.appearance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.BaseAdapterDecorator;
import com.nhaarman.listviewanimations.util.AnimatorUtil;
import com.nhaarman.listviewanimations.util.ListViewWrapper;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

// Referenced classes of package com.nhaarman.listviewanimations.appearance:
//            ViewAnimator

public abstract class AnimationAdapter extends BaseAdapterDecorator
{

    static final boolean $assertionsDisabled;
    private int mGridViewMeasuringPosition;
    private boolean mGridViewPossiblyMeasuring;
    private boolean mIsRootAdapter;
    private ViewAnimator mViewAnimator;

    protected AnimationAdapter(BaseAdapter baseadapter)
    {
        super(baseadapter);
        mGridViewPossiblyMeasuring = true;
        mGridViewMeasuringPosition = -1;
        mIsRootAdapter = true;
        if (baseadapter instanceof AnimationAdapter)
        {
            ((AnimationAdapter)baseadapter).setIsWrapped();
        }
    }

    private void animateViewIfNecessary(int i, View view, ViewGroup viewgroup)
    {
        if (!$assertionsDisabled && mViewAnimator == null)
        {
            throw new AssertionError();
        }
        Animator aanimator[];
        boolean flag;
        if (mGridViewPossiblyMeasuring && (mGridViewMeasuringPosition == -1 || mGridViewMeasuringPosition == i))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mGridViewPossiblyMeasuring = flag;
        if (mGridViewPossiblyMeasuring)
        {
            mGridViewMeasuringPosition = i;
            mViewAnimator.setLastAnimatedPosition(-1);
        }
        if (getDecoratedBaseAdapter() instanceof AnimationAdapter)
        {
            aanimator = ((AnimationAdapter)getDecoratedBaseAdapter()).getAnimators(viewgroup, view);
        } else
        {
            aanimator = new Animator[0];
        }
        viewgroup = AnimatorUtil.concatAnimators(aanimator, getAnimators(viewgroup, view), ObjectAnimator.ofFloat(view, "alpha", new float[] {
            0.0F, 1.0F
        }));
        mViewAnimator.animateViewIfNecessary(i, view, viewgroup);
    }

    private void setIsWrapped()
    {
        mIsRootAdapter = false;
    }

    public abstract Animator[] getAnimators(ViewGroup viewgroup, View view);

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (mIsRootAdapter)
        {
            if (getListViewWrapper() == null)
            {
                throw new IllegalStateException("Call setAbsListView() on this AnimationAdapter first!");
            }
            if (!$assertionsDisabled && mViewAnimator == null)
            {
                throw new AssertionError();
            }
            if (view != null)
            {
                mViewAnimator.cancelExistingAnimation(view);
            }
        }
        view = super.getView(i, view, viewgroup);
        if (mIsRootAdapter)
        {
            animateViewIfNecessary(i, view, viewgroup);
        }
        return view;
    }

    public void setListViewWrapper(ListViewWrapper listviewwrapper)
    {
        super.setListViewWrapper(listviewwrapper);
        mViewAnimator = new ViewAnimator(listviewwrapper);
    }

    static 
    {
        boolean flag;
        if (!com/nhaarman/listviewanimations/appearance/AnimationAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
