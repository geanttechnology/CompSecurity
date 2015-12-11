// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfoDetails;

// Referenced classes of package com.poshmark.ui.fragments:
//            UserSharesFragment

class this._cls0
    implements PMApiResponseHandler
{

    final UserSharesFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
label0:
        {
            if (isAdded())
            {
                if (pmapiresponse.hasError())
                {
                    break label0;
                }
                UserSharesFragment.access$002(UserSharesFragment.this, (UserInfoDetails)pmapiresponse.data);
                UserSharesFragment.access$200(UserSharesFragment.this, false);
                UserSharesFragment.access$300(UserSharesFragment.this);
                setupActionBar();
            }
            return;
        }
        hideProgressDialog();
        int i;
        if (pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_NOT_FOUND || pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_GONE)
        {
            i = 0x7f0600dd;
        } else
        {
            i = 0x7f0600eb;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.tionContext.LOAD_USER_PROFILE, getString(i)));
    }

    Context()
    {
        this$0 = UserSharesFragment.this;
        super();
    }
}
