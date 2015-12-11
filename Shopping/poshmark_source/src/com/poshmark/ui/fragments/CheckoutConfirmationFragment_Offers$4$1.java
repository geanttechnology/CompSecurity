// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.PMOrder;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutConfirmationFragment_Offers

class this._cls1
    implements com.poshmark.ui.customviews.ssListener
{

    final  this$1;

    public void dialogDismissed()
    {
        ListingNotificationManager.getListingNotificationManager().fireListingEditedMessage(order.getOrderListingId());
        done(-1);
    }

    l.order()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4

/* anonymous class */
    class CheckoutConfirmationFragment_Offers._cls4
        implements PMApiResponseHandler
    {

        final CheckoutConfirmationFragment_Offers this$0;
        final PMOrder val$order;

        public void handleResponse(PMApiResponse pmapiresponse)
        {
label0:
            {
label1:
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        if (mode != CheckoutConfirmationFragment_Offers.MODE.EXISTING_OFFER)
                        {
                            break label1;
                        }
                        showAutoHideProgressDialogWithMessage(getString(0x7f0601dd), new CheckoutConfirmationFragment_Offers._cls4._cls1());
                    }
                    return;
                }
                showAutoHideProgressDialogWithMessage(getString(0x7f0601de), new CheckoutConfirmationFragment_Offers._cls4._cls2());
                return;
            }
            showError(new ActionErrorContext(pmapiresponse.apiError, null, getString(0x7f0600f4), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
        }

            
            {
                this$0 = final_checkoutconfirmationfragment_offers;
                order = PMOrder.this;
                super();
            }

        // Unreferenced inner class com/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4$2

/* anonymous class */
        class CheckoutConfirmationFragment_Offers._cls4._cls2
            implements com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener
        {

            final CheckoutConfirmationFragment_Offers._cls4 this$1;

            public void dialogDismissed()
            {
                ListingNotificationManager.getListingNotificationManager().fireListingEditedMessage(order.getOrderListingId());
                done(-1);
            }

                    
                    {
                        this$1 = CheckoutConfirmationFragment_Offers._cls4.this;
                        super();
                    }
        }

    }

}
