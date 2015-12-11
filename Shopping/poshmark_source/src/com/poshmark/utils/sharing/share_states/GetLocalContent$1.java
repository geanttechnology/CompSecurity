// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.inner_models.ShortUrl;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.StateCompletionListener;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            GetLocalContent

class val.listingItem
    implements PMApiResponseHandler
{

    final GetLocalContent this$0;
    final ListingSummary val$listingItem;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        shareManager.getFragment().hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            val$listingItem.setShortURL(((ShortUrl)pmapiresponse.data).short_url);
            listener.stateCompleted();
            return;
        } else
        {
            shareManager.getFragment().showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model..ActionContext.SHARE_LISTING_TWITTER), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

                final GetLocalContent._cls1 this$1;

                public void dialogDismissed()
                {
                    listener.stateFailed();
                }

            
            {
                this$1 = GetLocalContent._cls1.this;
                super();
            }
            });
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = final_getlocalcontent;
        val$listingItem = ListingSummary.this;
        super();
    }
}
