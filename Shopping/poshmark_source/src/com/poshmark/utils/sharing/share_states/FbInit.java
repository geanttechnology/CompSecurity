// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import com.poshmark.fb_tmblr_twitter.FBConnectCallback;
import com.poshmark.fb_tmblr_twitter.FBPermissionStates;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.http.api.PMApiError;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.StateCompletionListener;
import java.util.UUID;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareState

public class FbInit extends ShareState
{

    public static UUID id = UUID.randomUUID();

    public FbInit(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        super(statecompletionlistener, sharemanager);
    }

    public void executeState()
    {
        if (FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.PUBLISH_PERMISSION))
        {
            listener.stateCompleted();
            return;
        } else
        {
            FbHelper.getInstance().link(shareManager.getFragment(), 8, 8, new FBConnectCallback() {

                final FbInit this$0;

                public void error(PMApiError pmapierror)
                {
                    if (pmapierror != null)
                    {
                        FbHelper.showFBLinkError(pmapierror, shareManager.getFragment());
                    }
                    listener.stateFailed();
                }

                public void success(int i, String s, String s1)
                {
                    if ((i & 8) != 0)
                    {
                        listener.stateCompleted();
                    }
                }

            
            {
                this$0 = FbInit.this;
                super();
            }
            });
            return;
        }
    }

    public UUID getId()
    {
        return id;
    }

}
