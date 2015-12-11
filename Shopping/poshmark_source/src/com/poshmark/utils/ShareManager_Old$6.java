// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.data_model.models.inner_models.ShortUrl;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.utils:
//            ShareManager_Old

class this._cls0
    implements PMApiResponseHandler
{

    final ShareManager_Old this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        ShareManager_Old.access$200(ShareManager_Old.this).hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            ShareManager_Old.access$400(ShareManager_Old.this).setShortURL(((ShortUrl)pmapiresponse.data).short_url);
            showShareMessageEditor();
            return;
        } else
        {
            ShareManager_Old.access$200(ShareManager_Old.this).showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionContext.SHARE_LISTING_TWITTER));
            return;
        }
    }

    xt.ActionContext()
    {
        this$0 = ShareManager_Old.this;
        super();
    }
}
