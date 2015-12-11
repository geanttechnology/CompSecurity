// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.content.Context;
import android.os.Bundle;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.StateCompletionListener;
import java.util.UUID;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareState

public class TumblrInit extends ShareState
{

    public static UUID id = UUID.randomUUID();

    public TumblrInit(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        super(statecompletionlistener, sharemanager);
    }

    public void executeState()
    {
        String s = PMApplicationSession.GetPMSession().getTumblrToken();
        boolean flag;
        if (shareManager.getFragment() != null && shareManager.getFragment().isAdded())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (s != null)
        {
            listener.stateCompleted();
            return;
        }
        if (flag)
        {
            shareManager.getFragment().showProgressDialogWithMessage(PMApplication.getContext().getString(0x7f060190));
        }
        ExtServiceConnectManager.getGlobalConnectManager().tumblrLink(shareManager.getFragment(), new ExtServiceConnectInterface() {

            final TumblrInit this$0;

            public void error(PMApiError pmapierror)
            {
                if (shareManager.getFragment().isAdded())
                {
                    shareManager.getFragment().hideProgressDialog();
                    shareManager.getFragment().showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.LINK_TUMBLR));
                }
                listener.stateFailed();
            }

            public void success(int i, Bundle bundle)
            {
                if (shareManager.getFragment().isAdded())
                {
                    shareManager.getFragment().hideProgressDialog();
                    listener.stateCompleted();
                }
            }

            
            {
                this$0 = TumblrInit.this;
                super();
            }
        });
    }

    public UUID getId()
    {
        return id;
    }

}
