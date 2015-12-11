// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.os.Bundle;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.http.api.PMApiError;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.StateCompletionListener;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            PinterestShare

class this._cls0
    implements ExtServiceConnectInterface
{

    final PinterestShare this$0;

    public void error(PMApiError pmapierror)
    {
        shareManager.trackExternalShareOnPM(ShareManager.EXTERNAL_SHARE_STATE_CANCELLED);
        listener.stateFailed();
    }

    public void success(int i, Bundle bundle)
    {
        shareManager.trackExternalShareOnPM(ShareManager.EXTERNAL_SHARE_STATE_SUCCESS);
        listener.stateCompleted();
    }

    ()
    {
        this$0 = PinterestShare.this;
        super();
    }
}
