// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import com.poshmark.data_model.models.BrandShareMessageContainer;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.PMShareContent;
import com.poshmark.utils.sharing.StateCompletionListener;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            GetLocalContent

class this._cls1
    implements com.poshmark.ui.customviews.gressDialogAutoDismissListener
{

    final ed this$1;

    public void dialogDismissed()
    {
        listener.stateFailed();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/utils/sharing/share_states/GetLocalContent$3

/* anonymous class */
    class GetLocalContent._cls3
        implements PMApiResponseHandler
    {

        final GetLocalContent this$0;

        public void handleResponse(PMApiResponse pmapiresponse)
        {
            if (!pmapiresponse.hasError())
            {
                shareManager.getShareContent().setBrandShareMessages(((BrandShareMessageContainer)pmapiresponse.data).getBrandShareMessages());
                shareManager.getFragment().hideProgressDialog();
                listener.stateCompleted();
                return;
            } else
            {
                shareManager.getFragment().showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TWITTER), new GetLocalContent._cls3._cls1());
                return;
            }
        }

            
            {
                this$0 = GetLocalContent.this;
                super();
            }
    }

}
