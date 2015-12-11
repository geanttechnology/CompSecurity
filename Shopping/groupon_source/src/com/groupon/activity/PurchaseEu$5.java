// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.CheckBox;
import com.groupon.models.error.GrouponException;
import com.groupon.models.nst.NewsletterClickExtraInfo;
import com.groupon.models.order.Order;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DialogManager;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.activity:
//            PurchaseEu, Purchase

class val.quantity
    implements Function1
{

    final PurchaseEu this$0;
    final int val$quantity;

    public void execute(Order order)
        throws RuntimeException
    {
        if (isCityDealCountry && isNewsletterOptInEnabled && newsletterOptin.getVisibility() == 0)
        {
            Logger logger = PurchaseEu.this.logger;
            String s1 = com/groupon/activity/Purchase.getSimpleName();
            com.groupon.tracking.mobile.EncodedNSTField encodednstfield = Logger.NULL_NST_FIELD;
            String s;
            if (newsletterOptin.isChecked())
            {
                s = "opt-in";
            } else
            {
                s = "opt-out";
            }
            logger.logClick("", "newsletter_opt_check", s1, encodednstfield, new NewsletterClickExtraInfo("newsletter", s));
        }
        setIsOrdersCallInProgress(false);
        if (PurchaseEu.access$900(PurchaseEu.this, order))
        {
            currentPaymentMethod.completePayment(order, val$quantity);
            return;
        }
        try
        {
            validateSuccess(order);
            PurchaseEu.access$400(PurchaseEu.this, order);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Order order)
        {
            dialogManager.showAlertDialog(order, null);
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Order)obj);
    }

    ception()
    {
        this$0 = final_purchaseeu;
        val$quantity = I.this;
        super();
    }
}
