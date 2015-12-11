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

class val.order
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
                    if (mode != DE.EXISTING_OFFER)
                    {
                        break label1;
                    }
                    showAutoHideProgressDialogWithMessage(getString(0x7f0601dd), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

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
                    });
                }
                return;
            }
            showAutoHideProgressDialogWithMessage(getString(0x7f0601de), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

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
            });
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, null, getString(0x7f0600f4), com.poshmark.ui.model.s.getString));
    }

    _cls2.this._cls1()
    {
        this$0 = final_checkoutconfirmationfragment_offers;
        val$order = PMOrder.this;
        super();
    }
}
