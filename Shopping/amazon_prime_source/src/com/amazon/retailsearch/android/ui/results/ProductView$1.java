// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.animation.Animator;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.amazon.retailsearch.android.ui.animations.AnimatableResultsImage;
import com.amazon.retailsearch.android.ui.results.layout.SearchLayout;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ProductView, ProductViewModel

class this._cls0
    implements android.view.er.OnPreDrawListener
{

    final ProductView this$0;

    public boolean onPreDraw()
    {
        imageView.getViewTreeObserver().removeOnPreDrawListener(this);
        int ai[] = ProductView.access$100(ProductView.this);
        int i = imageView.getWidth();
        int j = imageView.getHeight();
        AnimatableResultsImage animatableresultsimage = animationImage;
        android.animation.torListener torlistener = new android.animation.Animator.AnimatorListener() {

            final ProductView._cls1 this$1;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                imageView.setVisibility(0);
                animationImage.setVisibility(8);
                model.getSearchLayout().enableTouchEvents();
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
                model.getSearchLayout().disableTouchEvents();
            }

            
            {
                this$1 = ProductView._cls1.this;
                super();
            }
        };
        animatableresultsimage.animateToDestination(ai, new int[] {
            i, j
        }, torlistener);
        return true;
    }

    _cls1.this._cls1()
    {
        this$0 = ProductView.this;
        super();
    }
}
