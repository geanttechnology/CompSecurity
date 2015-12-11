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

class ARE_TYPE
    implements PMApiResponseHandler
{

    final ShareManager_Old this$0;
    final ARE_TYPE val$type;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        com.poshmark.ui.model.ActionContext actioncontext;
        ShareManager_Old.access$200(ShareManager_Old.this).hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            ShareManager_Old.access$200(ShareManager_Old.this).showAutoHideProgressDialogWithMessage(ShareManager_Old.access$300(ShareManager_Old.this).getString(0x7f060259), dismissListener);
            ((PMContainerActivity)ShareManager_Old.access$300(ShareManager_Old.this)).popTopFragment();
            return;
        }
        actioncontext = com.poshmark.ui.model.ActionContext.SHARE_LISTING;
        ..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[val$type.ordinal()];
        JVM INSTR tableswitch 1 3: default 100
    //                   1 123
    //                   2 183
    //                   3 153;
           goto _L1 _L2 _L3 _L4
_L1:
        ShareManager_Old.access$200(ShareManager_Old.this).showError(new ActionErrorContext(pmapiresponse.apiError, actioncontext));
        return;
_L2:
        com.poshmark.ui.model.ActionContext actioncontext1 = com.poshmark.ui.model.ActionContext.SHARE_LISTING_FACEBOOK;
        actioncontext = actioncontext1;
        if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
        {
            ExtServiceConnectManager.getGlobalConnectManager().fbUnlink();
            actioncontext = actioncontext1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        com.poshmark.ui.model.ActionContext actioncontext2 = com.poshmark.ui.model.ActionContext.SHARE_LISTING_TWITTER;
        actioncontext = actioncontext2;
        if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
        {
            ExtServiceConnectManager.getGlobalConnectManager().twUnlink();
            actioncontext = actioncontext2;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        com.poshmark.ui.model.ActionContext actioncontext3 = com.poshmark.ui.model.ActionContext.SHARE_LISTING_TUMBLR;
        actioncontext = actioncontext3;
        if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
        {
            ExtServiceConnectManager.getGlobalConnectManager().tmUnlink();
            actioncontext = actioncontext3;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    ARE_TYPE()
    {
        this$0 = final_sharemanager_old;
        val$type = ARE_TYPE.this;
        super();
    }
}
