// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;

// Referenced classes of package com.groupon.activity:
//            GiftCodes

class this._cls0
    implements com.groupon.view.Mark.OnCheckedChangeListener
{

    final GiftCodes this$0;

    public void onCheckedChanged(View view, final boolean isChecked)
    {
        float f2 = 1.0F;
        float f;
        float f1;
        if (isChecked)
        {
            f = 0.0F;
        } else
        {
            f = 1.0F;
        }
        if (isChecked)
        {
            f1 = 1.0F;
        } else
        {
            f1 = 0.0F;
        }
        if (!isChecked)
        {
            codeContainer.setVisibility(0);
        }
        if (isChecked)
        {
            giftCardContainer.setVisibility(0);
        }
        codeContainer.animate().setDuration(200L).alpha(f).setInterpolator(new DecelerateInterpolator()).setListener(new AnimatorListenerAdapter() {

            final GiftCodes._cls3 this$1;
            final boolean val$isChecked;

            public void onAnimationEnd(Animator animator)
            {
                animator = codeContainer;
                byte byte0;
                if (isChecked)
                {
                    byte0 = 8;
                } else
                {
                    byte0 = 0;
                }
                animator.setVisibility(byte0);
            }

            
            {
                this$1 = GiftCodes._cls3.this;
                isChecked = flag;
                super();
            }
        });
        giftCardContainer.animate().setDuration(200L).alpha(f1).setInterpolator(new DecelerateInterpolator()).setListener(new AnimatorListenerAdapter() {

            final GiftCodes._cls3 this$1;
            final boolean val$isChecked;

            public void onAnimationEnd(Animator animator)
            {
                animator = giftCardContainer;
                int i;
                if (isChecked)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                animator.setVisibility(i);
            }

            
            {
                this$1 = GiftCodes._cls3.this;
                isChecked = flag;
                super();
            }
        });
        if (isChecked)
        {
            f = f2;
        } else
        {
            f = 0.0F;
        }
        pinContainer.animate().setDuration(200L).scaleY(f).setInterpolator(new DecelerateInterpolator());
        if (isChecked)
        {
            giftCardNumber.requestFocus();
            return;
        } else
        {
            code.requestFocus();
            return;
        }
    }

    rAdapter()
    {
        this$0 = GiftCodes.this;
        super();
    }
}
