// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.customviews.PMEditText;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfo;

// Referenced classes of package com.poshmark.ui.fragments:
//            ChangePasswordFragment

class this._cls1
    implements PMApiResponseHandler
{

    final tring this$1;

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
                pmapiresponse = (UserInfo)pmapiresponse.data;
                PMApplicationSession.GetPMSession().saveSession(pmapiresponse);
                getActivity().onBackPressed();
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ntext.UPDATE_PASSWORD, getString(0x7f0600ff)));
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/ChangePasswordFragment$2

/* anonymous class */
    class ChangePasswordFragment._cls2
        implements android.view.View.OnClickListener
    {

        final ChangePasswordFragment this$0;

        public void onClick(View view)
        {
            hideKeyboard();
            if (ChangePasswordFragment.access$100(ChangePasswordFragment.this))
            {
                showProgressDialogWithMessage(getString(0x7f0602b5));
                view = ChangePasswordFragment.access$200(ChangePasswordFragment.this).getText().toString();
                PMApi.postNewPassword(ChangePasswordFragment.access$300(ChangePasswordFragment.this).getText().toString(), view, new ChangePasswordFragment._cls2._cls1());
            }
        }

            
            {
                this$0 = ChangePasswordFragment.this;
                super();
            }
    }

}
