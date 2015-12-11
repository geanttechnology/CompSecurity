// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.models.country.Country;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.activity:
//            PurchaseEu

class this._cls1
    implements Function0
{

    final sOrdersCallInProgress this$1;

    public void execute()
    {
        purchaseButton.stopSpinning();
        setIsOrdersCallInProgress(false);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/PurchaseEu$1

/* anonymous class */
    class PurchaseEu._cls1
        implements android.view.View.OnClickListener
    {

        final PurchaseEu this$0;

        public void onClick(View view)
        {
            if (PurchaseEu.access$000(PurchaseEu.this).getCurrentCountry().isRussia())
            {
                PurchaseEu.access$100(PurchaseEu.this);
            } else
            if (!redirectToAddPaymentMethod() && !redirectToAddShippingAddress() && valid())
            {
                showProcessingFeedback(true);
                setIsOrdersCallInProgress(true);
                if (userManager.hasAcceptedLegalTerms())
                {
                    PurchaseEu.access$200(PurchaseEu.this);
                    return;
                } else
                {
                    userManager.acceptLegalTerms(new PurchaseEu._cls1._cls1(), new PurchaseEu._cls1._cls2(), new PurchaseEu._cls1._cls3());
                    return;
                }
            }
        }

            
            {
                this$0 = PurchaseEu.this;
                super();
            }

        // Unreferenced inner class com/groupon/activity/PurchaseEu$1$1

/* anonymous class */
        class PurchaseEu._cls1._cls1
            implements Function0
        {

            final PurchaseEu._cls1 this$1;

            public void execute()
            {
                PurchaseEu.access$200(this$0);
            }

                    
                    {
                        this$1 = PurchaseEu._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/groupon/activity/PurchaseEu$1$2

/* anonymous class */
        class PurchaseEu._cls1._cls2
            implements Function1
        {

            final PurchaseEu._cls1 this$1;

            public void execute(Exception exception)
            {
                hideProcessingFeedback();
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Exception)obj);
            }

                    
                    {
                        this$1 = PurchaseEu._cls1.this;
                        super();
                    }
        }

    }

}
