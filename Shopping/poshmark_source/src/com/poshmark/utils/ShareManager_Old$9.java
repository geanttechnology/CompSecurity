// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.utils:
//            ShareManager_Old

class val.defaultMessage
    implements PMApiResponseHandler
{

    final ShareManager_Old this$0;
    final String val$defaultMessage;
    final String val$message;
    final ARE_TYPE val$type;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        ShareManager_Old.access$200(ShareManager_Old.this).hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            ShareManager_Old.access$600(ShareManager_Old.this);
            ShareManager_Old.access$200(ShareManager_Old.this).showAutoHideProgressDialogWithMessage(ShareManager_Old.access$300(ShareManager_Old.this).getString(0x7f060259), dismissListener);
            ((PMContainerActivity)ShareManager_Old.access$300(ShareManager_Old.this)).popTopFragment();
            return;
        }
        ShareManager_Old.access$700(ShareManager_Old.this);
        Object obj = com.poshmark.ui.model.ActionContext.SHARE_LISTING;
        switch (..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[val$type.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
            {
                ShareManager_Old sharemanager_old = ShareManager_Old.this;
                if (val$message.length() == 0)
                {
                    obj = val$defaultMessage;
                } else
                {
                    obj = val$message;
                }
                ShareManager_Old.access$800(sharemanager_old, pmapiresponse, ((String) (obj)));
                return;
            } else
            {
                ShareManager_Old.access$200(ShareManager_Old.this).showError(new ActionErrorContext(pmapiresponse.apiError, ((com.poshmark.ui.model.ActionContext) (obj))));
                return;
            }

        case 3: // '\003'
            obj = com.poshmark.ui.model.ActionContext.SHARE_LISTING_TWITTER;
            if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
            {
                ExtServiceConnectManager.getGlobalConnectManager().twUnlink();
            }
            ShareManager_Old.access$200(ShareManager_Old.this).showError(new ActionErrorContext(pmapiresponse.apiError, ((com.poshmark.ui.model.ActionContext) (obj))));
            return;

        case 2: // '\002'
            obj = com.poshmark.ui.model.ActionContext.SHARE_LISTING_TUMBLR;
            break;
        }
        if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
        {
            ExtServiceConnectManager.getGlobalConnectManager().tmUnlink();
        }
        ShareManager_Old.access$200(ShareManager_Old.this).showError(new ActionErrorContext(pmapiresponse.apiError, ((com.poshmark.ui.model.ActionContext) (obj))));
    }

    ARE_TYPE()
    {
        this$0 = final_sharemanager_old;
        val$type = are_type;
        val$message = s;
        val$defaultMessage = String.this;
        super();
    }
}
