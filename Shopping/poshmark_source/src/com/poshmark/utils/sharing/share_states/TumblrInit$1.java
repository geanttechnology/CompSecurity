// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.os.Bundle;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.StateCompletionListener;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            TumblrInit

class this._cls0
    implements ExtServiceConnectInterface
{

    final TumblrInit this$0;

    public void error(PMApiError pmapierror)
    {
        if (shareManager.getFragment().isAdded())
        {
            shareManager.getFragment().hideProgressDialog();
            shareManager.getFragment().showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ntext.ActionContext.LINK_TUMBLR));
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

    t()
    {
        this$0 = TumblrInit.this;
        super();
    }
}
