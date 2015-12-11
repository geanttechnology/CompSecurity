// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.user.UserInfo;

// Referenced classes of package com.poshmark.ui.fragments:
//            SignInSignUpWallFragment, SignupFormFragment

class val.googleLoginBundle
    implements PMApiResponseHandler
{

    final SignInSignUpWallFragment this$0;
    final Bundle val$googleLoginBundle;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded())
        {
            hideProgressDialog();
            if (!pmapiresponse.hasError())
            {
                SignInSignUpWallFragment.access$100(SignInSignUpWallFragment.this, (UserInfo)pmapiresponse.data);
            } else
            if (pmapiresponse.apiError.pmError != null && pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_NOT_FOUND)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "gp_signup_flow_initiated", null);
                ((PMActivity)getActivity()).launchFragment(val$googleLoginBundle, com/poshmark/ui/fragments/SignupFormFragment, null);
                return;
            }
        }
    }

    ()
    {
        this$0 = final_signinsignupwallfragment;
        val$googleLoginBundle = Bundle.this;
        super();
    }
}
