// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import android.content.DialogInterface;
import android.os.Bundle;
import com.poshmark.data_model.models.PMOfferInfo;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.CheckoutConfirmationFragment_Offers;
import com.poshmark.ui.fragments.MappPageFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.OfferFlowHandler;

// Referenced classes of package com.poshmark.webcommands:
//            WebCommandsManager, WebCommand

class val.command
    implements com.poshmark.utils.er._cls12
{

    final WebCommandsManager this$0;
    final WebCommand val$command;
    final String val$offerId;

    public void runOnUIThread(Object obj)
    {
        fragment.showProgressDialogWithMessage(fragment.getString(0x7f060191));
        PMApi.getOffer(val$offerId, null, new PMApiResponseHandler() {

            final WebCommandsManager._cls12 this$1;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (fragment.isAdded())
                    {
                        fragment.hideProgressDialog();
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        pmapiresponse = new OfferFlowHandler(fragment, (PMOfferInfo)pmapiresponse.data);
                        Bundle bundle = new Bundle();
                        bundle.putInt("CHECKOUT_FORM_MODE", com.poshmark.ui.fragments.CheckoutFormFragment.CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS.ordinal());
                        parentActivity.launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers, pmapiresponse, fragment, command.commandHashCode());
                    }
                    return;
                }
                pmapiresponse = new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SUBMIT_ORDER, fragment.getString(0x7f0600f4), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH);
                fragment.showAlertMessage(fragment.getString(0x7f0600d0), ((ActionErrorContext) (pmapiresponse)).message, new android.content.DialogInterface.OnDismissListener() {

                    final _cls1 this$2;

                    public void onDismiss(DialogInterface dialoginterface)
                    {
                        fragment.reload();
                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$1 = WebCommandsManager._cls12.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_webcommandsmanager;
        val$offerId = s;
        val$command = WebCommand.this;
        super();
    }
}
