// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.FBDPAHelper;

// Referenced classes of package com.poshmark.ui.fragments:
//            CommentFragment

class this._cls0
    implements PMApiResponseHandler
{

    final CommentFragment this$0;

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
                FBDPAHelper.trackComment(listingDetails);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "comment", null);
                pmapiresponse = (Comment)pmapiresponse.data;
                ListingNotificationManager.getListingNotificationManager().fireListingCommentMessage(listingId, pmapiresponse);
                finishActivity();
            }
            return;
        }
        String s = PMApplication.getContext().getString(0x7f0600d2);
        if (pmapiresponse.apiError.pmErrorType == PMErrorType.INSUFFICIENT_PRIVILEGES_ERROR)
        {
            s = "";
            if (listingDetails != null)
            {
                s = listingDetails.getUserName();
            }
            s = String.format(PMApplication.getContext().getString(0x7f0600d1), new Object[] {
                s
            });
            pmapiresponse = new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model..ActionContext.ADD_COMMENT, null, com.poshmark.ui.model..Severity.HIGH, null, s);
        } else
        {
            pmapiresponse = new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model..ActionContext.ADD_COMMENT, s, com.poshmark.ui.model..Severity.HIGH);
        }
        showError(pmapiresponse);
    }

    erity()
    {
        this$0 = CommentFragment.this;
        super();
    }
}
