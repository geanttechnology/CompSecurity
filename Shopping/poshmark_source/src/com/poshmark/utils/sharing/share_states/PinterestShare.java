// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.os.Bundle;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.fb_tmblr_twitter.PinterestHelper;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.PMShareContent;
import com.poshmark.utils.sharing.StateCompletionListener;
import java.util.UUID;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareState

public class PinterestShare extends ShareState
{

    public static UUID id = UUID.randomUUID();

    public PinterestShare(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        super(statecompletionlistener, sharemanager);
    }

    public void executeState()
    {
        shareManager.trackExternalShareOnPM(ShareManager.EXTERNAL_SHARE_STATE_INITIALED);
        android.support.v4.app.FragmentActivity fragmentactivity = shareManager.getFragment().getActivity();
        String s = shareManager.getShareContent().getShareDescription();
        String s1 = shareManager.getShareContent().getImageUrl();
        String s2 = shareManager.getShareContent().getShareUrl();
        PinterestHelper.getInstance().setData(s, s2, s1);
        PinterestHelper.getInstance().explicitShare(fragmentactivity, new ExtServiceConnectInterface() {

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

            
            {
                this$0 = PinterestShare.this;
                super();
            }
        });
    }

    public UUID getId()
    {
        return id;
    }

}
