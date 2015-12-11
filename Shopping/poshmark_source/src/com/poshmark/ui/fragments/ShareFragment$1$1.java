// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.poshmark.data_model.models.Referral;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.ShareManager;

// Referenced classes of package com.poshmark.ui.fragments:
//            ShareFragment

class this._cls1
    implements com.poshmark.ui.customviews.rogressDialogAutoDismissListener
{

    final ckPressed this$1;

    public void dialogDismissed()
    {
        getActivity().onBackPressed();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/ShareFragment$1

/* anonymous class */
    class ShareFragment._cls1
        implements PMApiResponseHandler
    {

        final ShareFragment this$0;

        public void handleResponse(PMApiResponse pmapiresponse)
        {
label0:
            {
                if (isAdded())
                {
                    hideProgressDialog();
                    if (pmapiresponse.hasError())
                    {
                        break label0;
                    }
                    shareManager.setReferralData((Referral)pmapiresponse.data);
                    if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
                    {
                        referralMessageView.setText(shareManager.getReferralData().getProgram());
                        referralCodeView.setText(shareManager.getReferralData().getId());
                    }
                }
                return;
            }
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_REFERRAL_CODE, getString(0x7f0600ec)), new ShareFragment._cls1._cls1());
        }

            
            {
                this$0 = ShareFragment.this;
                super();
            }
    }

}
