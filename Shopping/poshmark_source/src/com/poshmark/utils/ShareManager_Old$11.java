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

class val.message
    implements PMApiResponseHandler
{

    final ShareManager_Old this$0;
    final String val$message;
    final RE_TYPE val$type;

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
        com.poshmark.ui.model.ctionContext ctioncontext = com.poshmark.ui.model.ctionContext.SHARE_LISTING;
        switch (.SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[val$type.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            ctioncontext = com.poshmark.ui.model.ctionContext.SHARE_LISTING_FACEBOOK;
            if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
            {
                ShareManager_Old.access$800(ShareManager_Old.this, pmapiresponse, val$message);
                return;
            } else
            {
                ShareManager_Old.access$200(ShareManager_Old.this).showError(new ActionErrorContext(pmapiresponse.apiError, ctioncontext));
                return;
            }

        case 3: // '\003'
            ctioncontext = com.poshmark.ui.model.ctionContext.SHARE_LISTING_TWITTER;
            if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
            {
                ExtServiceConnectManager.getGlobalConnectManager().twUnlink();
            }
            ShareManager_Old.access$200(ShareManager_Old.this).showError(new ActionErrorContext(pmapiresponse.apiError, ctioncontext));
            return;

        case 2: // '\002'
            ctioncontext = com.poshmark.ui.model.ctionContext.SHARE_LISTING_TUMBLR;
            break;
        }
        if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
        {
            ExtServiceConnectManager.getGlobalConnectManager().tmUnlink();
        }
        ShareManager_Old.access$200(ShareManager_Old.this).showError(new ActionErrorContext(pmapiresponse.apiError, ctioncontext));
    }

    RE_TYPE()
    {
        this$0 = final_sharemanager_old;
        val$type = re_type;
        val$message = String.this;
        super();
    }
}
