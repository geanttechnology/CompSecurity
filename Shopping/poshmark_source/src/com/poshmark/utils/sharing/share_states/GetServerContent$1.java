// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.ServerShareMessages;
import com.poshmark.utils.sharing.StateCompletionListener;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            GetServerContent

class this._cls0
    implements PMApiResponseHandler
{

    final GetServerContent this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        shareManager.getFragment().hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            shareManager.setShareContent((ServerShareMessages)pmapiresponse.data);
            listener.stateCompleted();
            return;
        } else
        {
            listener.stateFailed();
            return;
        }
    }

    ()
    {
        this$0 = GetServerContent.this;
        super();
    }
}
