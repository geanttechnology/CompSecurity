// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfo;
import com.poshmark.utils.DeferredDeepLinkManager;
import com.poshmark.utils.FbDeferredDeepLinkManager;

// Referenced classes of package com.poshmark.ui.fragments:
//            EmailLoginFragment

class this._cls0
    implements PMApiResponseHandler
{

    final EmailLoginFragment this$0;

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
                FbDeferredDeepLinkManager.INSTANCE.markAsExpired();
                DeferredDeepLinkManager.INSTANCE.markAsExpired();
                pmapiresponse = (UserInfo)pmapiresponse.data;
                PMApplicationSession.GetPMSession().saveSession(pmapiresponse);
                PMNotificationManager.fireNotification("com.poshmark.intents.LOGIN_COMPLETE");
                Analytics.getInstance().trackEvent("email_login_screen", "user", "login", null);
                finishActivity();
            }
            return;
        }
        if (pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_UNAUTHORIZED)
        {
            showAlertMessage(null, PMApplication.getContext().getString(0x7f0600e0));
            return;
        } else
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.tionContext.USER_LOGIN, PMApplication.getContext().getString(0x7f0600ef), com.poshmark.ui.model.verity.HIGH));
            return;
        }
    }

    ty()
    {
        this$0 = EmailLoginFragment.this;
        super();
    }
}
