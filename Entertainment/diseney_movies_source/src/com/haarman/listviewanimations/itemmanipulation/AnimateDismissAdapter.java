// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.itemmanipulation;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.haarman.listviewanimations.BaseAdapterDecorator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

// Referenced classes of package com.haarman.listviewanimations.itemmanipulation:
//            OnDismissCallback

public class AnimateDismissAdapter extends BaseAdapterDecorator
{

    private OnDismissCallback mCallback;

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
        valueanimator.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

            final AnimateDismissAdapter this$0;
            private final android.view.ViewGroup.LayoutParams val$lp;
            private final View val$view;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                lp.height = 0;
                view.setLayoutParams(lp);
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
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
            private final android.view.ViewGroup.LayoutParams val$lp;
            private final View val$view;

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
        int i = 0;
        do
        {
            if (i >= getListView().getChildCount())
            {
                return arraylist;
            }
            View view = getListView().getChildAt(i);
            if (collection.contains(Integer.valueOf(getListView().getPositionForView(view))))
            {
                arraylist.add(view);
            }
            i++;
        } while (true);
    }

    private void invokeCallback(Collection collection)
    {
        collection = new ArrayList(collection);
        Collections.sort(collection);
        int ai[] = new int[collection.size()];
        int i = 0;
        do
        {
            if (i >= collection.size())
            {
                mCallback.onDismiss(getListView(), ai);
                return;
            }
            ai[i] = ((Integer)collection.get(collection.size() - 1 - i)).intValue();
            i++;
        } while (true);
    }

    public void animateDismiss(int i)
    {
        animateDismiss(((Collection) (Arrays.asList(new Integer[] {
            Integer.valueOf(i)
        }))));
    }

    public void animateDismiss(final Collection positionsCopy)
    {
        Object obj;
        positionsCopy = new ArrayList(positionsCopy);
        Assert.assertNotNull("Call setListView() on this AnimateDismissAdapter before calling setAdapter()!", getListView());
        obj = getVisibleViewsForPositions(positionsCopy);
        if (((List) (obj)).isEmpty()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        arraylist = new ArrayList();
        obj = ((List) (obj)).iterator();
_L7:
        if (((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
        Animator aanimator[];
        int i;
        obj = new AnimatorSet();
        aanimator = new Animator[arraylist.size()];
        i = 0;
_L5:
        if (i >= aanimator.length)
        {
            ((AnimatorSet) (obj)).playTogether(aanimator);
            ((AnimatorSet) (obj)).addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

                final AnimateDismissAdapter this$0;
                private final List val$positionsCopy;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    invokeCallback(positionsCopy);
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                this$0 = AnimateDismissAdapter.this;
                positionsCopy = list;
                super();
            }
            });
            ((AnimatorSet) (obj)).start();
            return;
        }
        aanimator[i] = (Animator)arraylist.get(i);
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        arraylist.add(createAnimatorForView((View)((Iterator) (obj)).next()));
        continue; /* Loop/switch isn't completed */
        if (true) goto _L5; else goto _L2
_L2:
        invokeCallback(positionsCopy);
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

}
