// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfoDetails;

// Referenced classes of package com.poshmark.ui.fragments:
//            EditProfileFormFragment

class this._cls0
    implements PMApiResponseHandler
{

    final EditProfileFormFragment this$0;

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
                userProfile = (UserInfoDetails)pmapiresponse.data;
                EditProfileFormFragment.access$000(EditProfileFormFragment.this);
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ontext.LOAD_USER_PROFILE, PMApplication.getContext().getString(0x7f0600eb)), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

            final EditProfileFormFragment._cls1 this$1;

            public void dialogDismissed()
            {
                ((PMContainerActivity)getActivity()).onBackPressed();
            }

            
            {
                this$1 = EditProfileFormFragment._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = EditProfileFormFragment.this;
        super();
    }
}
