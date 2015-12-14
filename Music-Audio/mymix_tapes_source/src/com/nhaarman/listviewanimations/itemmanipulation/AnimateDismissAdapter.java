// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation;

import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.BaseAdapterDecorator;
import com.nhaarman.listviewanimations.util.AdapterViewUtil;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation:
//            OnDismissCallback

public class AnimateDismissAdapter extends BaseAdapterDecorator
{

    private final OnDismissCallback mCallback;

    public AnimateDismissAdapter(BaseAdapter baseadapter, OnDismissCallback ondismisscallback)
    {
        super(baseadapter);
        mCallback = ondismisscallback;
    }

    private Animator createAnimatorForView(final View view)
    {
        final android.view.ViewGroup.LayoutParams lp = view.getLayoutParams();
        ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
            view.getHeight(), 0
        });
        valueanimator.addListener(new AnimatorListenerAdapter() {

            final AnimateDismissAdapter this$0;
            final android.view.ViewGroup.LayoutParams val$lp;
            final View val$view;

            public void onAnimationEnd(Animator animator)
            {
                lp.height = 0;
                view.setLayoutParams(lp);
            }

            
            {
                this$0 = AnimateDismissAdapter.this;
                lp = layoutparams;
                view = view1;
                super();
            }
        });
        valueanimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

            final AnimateDismissAdapter this$0;
            final android.view.ViewGroup.LayoutParams val$lp;
            final View val$view;

            public void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                lp.height = ((Integer)valueanimator1.getAnimatedValue()).intValue();
                view.setLayoutParams(lp);
            }

            
            {
                this$0 = AnimateDismissAdapter.this;
                lp = layoutparams;
                view = view1;
                super();
            }
        });
        return valueanimator;
    }

    private List getVisibleViewsForPositions(Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < getAbsListView().getChildCount(); i++)
        {
            View view = getAbsListView().getChildAt(i);
            if (collection.contains(Integer.valueOf(AdapterViewUtil.getPositionForView(getAbsListView(), view))))
            {
                arraylist.add(view);
            }
        }

        return arraylist;
    }

    private void invokeCallback(Collection collection)
    {
        collection = new ArrayList(collection);
        Collections.sort(collection);
        int ai[] = new int[collection.size()];
        for (int i = 0; i < collection.size(); i++)
        {
            ai[i] = ((Integer)collection.get(collection.size() - 1 - i)).intValue();
        }

        mCallback.onDismiss(getAbsListView(), ai);
    }

    public void animateDismiss(int i)
    {
        animateDismiss(((Collection) (Arrays.asList(new Integer[] {
            Integer.valueOf(i)
        }))));
    }

    public void animateDismiss(final Collection positionsCopy)
    {
        positionsCopy = new ArrayList(positionsCopy);
        if (getAbsListView() == null)
        {
            throw new IllegalStateException("Call setAbsListView() on this AnimateDismissAdapter before calling setAdapter()!");
        }
        Object obj = getVisibleViewsForPositions(positionsCopy);
        if (!((List) (obj)).isEmpty())
        {
            ArrayList arraylist = new ArrayList();
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(createAnimatorForView((View)((Iterator) (obj)).next()))) { }
            obj = new AnimatorSet();
            Animator aanimator[] = new Animator[arraylist.size()];
            for (int i = 0; i < aanimator.length; i++)
            {
                aanimator[i] = (Animator)arraylist.get(i);
            }

            ((AnimatorSet) (obj)).playTogether(aanimator);
            ((AnimatorSet) (obj)).addListener(new AnimatorListenerAdapter() {

                final AnimateDismissAdapter this$0;
                final List val$positionsCopy;

                public void onAnimationEnd(Animator animator)
                {
                    invokeCallback(positionsCopy);
                }

            
            {
                this$0 = AnimateDismissAdapter.this;
                positionsCopy = list;
                super();
            }
            });
            ((AnimatorSet) (obj)).start();
            return;
        } else
        {
            invokeCallback(positionsCopy);
            return;
        }
    }

}
