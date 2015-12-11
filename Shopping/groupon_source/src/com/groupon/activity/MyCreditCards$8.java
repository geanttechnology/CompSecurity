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

class val.cardView
    implements android.view.ener
{

    final MyCreditCards this$0;
    final CreditCardItemBase val$cardView;
    final ViewGroup val$container;
    final AbstractPaymentMethod val$paymentMethod;

    public void onClick(View view)
    {
        val$paymentMethod.saveToPrefs();
        if (MyCreditCards.access$100(MyCreditCards.this))
        {
            int i = 0;
            do
            {
label0:
                {
                    if (i < val$container.getChildCount())
                    {
                        view = val$container.getChildAt(i);
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
                    ((CreditCardItemNew)val$cardView).setChecked(true, new AnimatorListenerAdapter() {

                        final MyCreditCards._cls8 this$1;

                        public void onAnimationEnd(Animator animator)
                        {
                            MyCreditCards.access$300(this$0, paymentMethod);
                        }

            
            {
                this$1 = MyCreditCards._cls8.this;
                super();
            }
                    });
                    return;
                }
                i++;
            } while (true);
        } else
        {
            MyCreditCards.access$300(MyCreditCards.this, val$paymentMethod);
            return;
        }
    }

    ymentMethod()
    {
        this$0 = final_mycreditcards;
        val$paymentMethod = abstractpaymentmethod;
        val$container = viewgroup;
        val$cardView = CreditCardItemBase.this;
        super();
    }
}
