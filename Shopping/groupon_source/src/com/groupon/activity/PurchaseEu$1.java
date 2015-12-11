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

class this._cls0
    implements android.view.istener
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
                userManager.acceptLegalTerms(new Function0() {

                    final PurchaseEu._cls1 this$1;

                    public void execute()
                    {
                        PurchaseEu.access$200(this$0);
                    }

            
            {
                this$1 = PurchaseEu._cls1.this;
                super();
            }
                }, new Function1() {

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
                }, new Function0() {

                    final PurchaseEu._cls1 this$1;

                    public void execute()
                    {
                        purchaseButton.stopSpinning();
                        setIsOrdersCallInProgress(false);
                    }

            
            {
                this$1 = PurchaseEu._cls1.this;
                super();
            }
                });
                return;
            }
        }
    }

    _cls3.this._cls1()
    {
        this$0 = PurchaseEu.this;
        super();
    }
}
