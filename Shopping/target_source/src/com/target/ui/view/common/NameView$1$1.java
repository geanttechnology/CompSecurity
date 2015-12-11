// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import com.target.ui.a.b;
import com.target.ui.util.aj;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.common:
//            NameView

class er extends AnimatorListenerAdapter
{

    final s.lastName this$1;

    public void onAnimationStart(Animator animator)
    {
        NameView.c(_fld0).lastName.setEnabled(true);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/target/ui/view/common/NameView$1

/* anonymous class */
    class NameView._cls1
        implements android.view.ViewTreeObserver.OnPreDrawListener
    {

        final NameView this$0;

        public boolean onPreDraw()
        {
            NameView.c(NameView.this).root.getViewTreeObserver().removeOnPreDrawListener(this);
            int i = NameView.d(NameView.this) / 2;
            int j = NameView.c(NameView.this).lastNameWrapper.getPaddingLeft() / 2;
            b b1 = new b(NameView.c(NameView.this).firstNameWrapper, NameView.d(NameView.this), i - j);
            AnimatorSet animatorset = aj.b(NameView.c(NameView.this).lastNameWrapper);
            NameView.c(NameView.this).firstNameWrapper.startAnimation(b1);
            animatorset.addListener(new NameView._cls1._cls1());
            animatorset.start();
            return true;
        }

            
            {
                this$0 = NameView.this;
                super();
            }
    }

}
