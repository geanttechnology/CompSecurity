// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.ShareContentHelper;
import com.poshmark.utils.sharing.StateCompletionListener;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ServerShare

class this._cls1
    implements com.poshmark.ui.customviews..ProgressDialogAutoDismissListener
{

    final eManager this$1;

    public void dialogDismissed()
    {
        ServerShare.access$000(_fld0);
        listener.stateCompleted();
        shareManager.getFragment().getParentActivity().popTopFragment();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/utils/sharing/share_states/ServerShare$1

/* anonymous class */
    class ServerShare._cls1
        implements PMApiResponseHandler
    {

        final ServerShare this$0;

        public void handleResponse(PMApiResponse pmapiresponse)
        {
            if (!pmapiresponse.hasError())
            {
                shareManager.getFragment().getParentActivity().popTopFragment();
                shareManager.getFragment().showAutoHideProgressDialogWithMessage(PMApplication.getContext().getString(0x7f060259), new ServerShare._cls1._cls1());
                return;
            } else
            {
                shareManager.trackShareFailedEvent();
                shareManager.getFragment().showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING, ShareContentHelper.getSharingErrorString(shareManager.getShareMode())));
                return;
            }
        }

            
            {
                this$0 = ServerShare.this;
                super();
            }
    }

}
