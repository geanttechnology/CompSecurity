// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.view.CreditCardItemBase;
import com.groupon.view.CreditCardItemNew;

// Referenced classes of package com.groupon.activity:
//            MyCreditCards

class er extends AnimatorListenerAdapter
{

    final l.paymentMethod this$1;

    public void onAnimationEnd(Animator animator)
    {
        MyCreditCards.access$300(_fld0, paymentMethod);
    }

    l.cardView()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/MyCreditCards$8

/* anonymous class */
    class MyCreditCards._cls8
        implements android.view.View.OnClickListener
    {

        final MyCreditCards this$0;
        final CreditCardItemBase val$cardView;
        final ViewGroup val$container;
        final AbstractPaymentMethod val$paymentMethod;

        public void onClick(View view)
        {
            paymentMethod.saveToPrefs();
            if (MyCreditCards.access$100(MyCreditCards.this))
            {
                int i = 0;
                do
                {
label0:
                    {
                        if (i < container.getChildCount())
                        {
                            view = container.getChildAt(i);
                            if (!(view instanceof CreditCardItemBase))
                            {
                                break label0;
                            }
                            view = (CreditCardItemBase)view;
                            if (!view.isChecked())
                            {
                                break label0;
                            }
                            view.setChecked(false);
                        }
                        ((CreditCardItemNew)cardView).setChecked(true, new MyCreditCards._cls8._cls1());
                        return;
                    }
                    i++;
                } while (true);
            } else
            {
                MyCreditCards.access$300(MyCreditCards.this, paymentMethod);
                return;
            }
        }

            
            {
                this$0 = final_mycreditcards;
                paymentMethod = abstractpaymentmethod;
                container = viewgroup;
                cardView = CreditCardItemBase.this;
                super();
            }
    }

}
