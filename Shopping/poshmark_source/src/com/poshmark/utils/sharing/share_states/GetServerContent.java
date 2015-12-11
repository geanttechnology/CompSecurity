// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.PMShareContent;
import com.poshmark.utils.sharing.ServerShareMessages;
import com.poshmark.utils.sharing.ShareContentHelper;
import com.poshmark.utils.sharing.StateCompletionListener;
import java.util.UUID;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareState

public class GetServerContent extends ShareState
{

    public static UUID id = UUID.randomUUID();

    public GetServerContent(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        super(statecompletionlistener, sharemanager);
    }

    public void executeState()
    {
        Object obj = shareManager.getShareMode();
        String s = shareManager.getExternalShareCode();
        obj = ShareContentHelper.prepareGetShareMessagesEndPoint(shareManager.getShareContent().getId(), s, ((com.poshmark.utils.ShareManager.SHARE_MODE) (obj)));
        if (shareManager.getFragment() != null && shareManager.getFragment().isAdded())
        {
            shareManager.getFragment().showProgressDialogWithMessage(PMApplication.getContext().getString(0x7f060190));
        }
        PMApi.getShareMessagesFromServer(((String) (obj)), new PMApiResponseHandler() {

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

            
            {
                this$0 = GetServerContent.this;
                super();
            }
        });
    }

    public UUID getId()
    {
        return id;
    }

}
