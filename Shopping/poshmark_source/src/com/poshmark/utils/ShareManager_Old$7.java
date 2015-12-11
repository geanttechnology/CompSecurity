// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.data_model.models.inner_models.ShortUrl;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.utils:
//            ShareManager_Old

class ARE_TYPE
    implements PMApiResponseHandler
{

    final ShareManager_Old this$0;
    final ARE_TYPE val$shareType;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        ShareManager_Old.access$200(ShareManager_Old.this).hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            ShareManager_Old.access$502(ShareManager_Old.this, ((ShortUrl)pmapiresponse.data).short_url);
            if (val$shareType == ARE_TYPE.EMAIL_SHARE)
            {
                doEmailShare();
                return;
            }
            if (val$shareType == ARE_TYPE.SMS_SHARE)
            {
                doSMSShare();
                return;
            }
            if (val$shareType == ARE_TYPE.FB_MESSENGER_SHARE)
            {
                doFBMessengerShare();
                return;
            }
            if (val$shareType == ARE_TYPE.FB_DIALOG_SHARE)
            {
                doFbDialogShare();
                return;
            } else
            {
                showShareMessageEditor();
                return;
            }
        } else
        {
            ShareManager_Old.access$200(ShareManager_Old.this).showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionContext.SHARE_LISTING_TWITTER));
            return;
        }
    }

    ARE_TYPE()
    {
        this$0 = final_sharemanager_old;
        val$shareType = ARE_TYPE.this;
        super();
    }
}
