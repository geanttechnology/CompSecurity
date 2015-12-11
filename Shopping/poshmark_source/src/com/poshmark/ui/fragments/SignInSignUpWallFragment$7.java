// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.fb_tmblr_twitter.ExtServiceUserInfoInterface;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfo;
import com.poshmark.utils.DeferredDeepLinkManager;
import com.poshmark.utils.FbDeferredDeepLinkManager;

// Referenced classes of package com.poshmark.ui.fragments:
//            SignInSignUpWallFragment, SignupFormFragment

class this._cls0
    implements PMApiResponseHandler
{

    final SignInSignUpWallFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded())
        {
            hideProgressDialog();
            if (!pmapiresponse.hasError())
            {
                FbDeferredDeepLinkManager.INSTANCE.markAsExpired();
                DeferredDeepLinkManager.INSTANCE.markAsExpired();
                SignInSignUpWallFragment.access$100(SignInSignUpWallFragment.this, (UserInfo)pmapiresponse.data);
            } else
            if (pmapiresponse.apiError.pmError != null && pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_NOT_FOUND)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "facebook_signup_flow_initiated", null);
                showProgressDialogWithMessage(getString(0x7f060190));
                FbHelper.getInstance().getMe(new ExtServiceUserInfoInterface() {

                    final SignInSignUpWallFragment._cls7 this$1;

                    public void error(PMApiError pmapierror)
                    {
                        hideProgressDialog();
                        showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.USER_SIGNUP));
                    }

                    public void success(Bundle bundle)
                    {
                        hideProgressDialog();
                        PMActivity pmactivity = (PMActivity)getActivity();
                        if (pmactivity != null && pmactivity.isActivityInForeground())
                        {
                            pmactivity.launchFragment(bundle, com/poshmark/ui/fragments/SignupFormFragment, null);
                        }
                    }

            
            {
                this$1 = SignInSignUpWallFragment._cls7.this;
                super();
            }
                });
                return;
            }
        }
    }

    _cls1.this._cls1()
    {
        this$0 = SignInSignUpWallFragment.this;
        super();
    }
}
