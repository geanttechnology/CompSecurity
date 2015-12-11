// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.StateCompletionListener;
import com.poshmark.utils.view_holders.PinterestDialog;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            PinterestConnect

class val.dialog
    implements android.view.r
{

    final PinterestConnect this$0;
    final PinterestDialog val$dialog;
    final PMFragment val$fragment;

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131493474 2131493475: default 28
    //                   2131493474 36
    //                   2131493475 79;
           goto _L1 _L2 _L3
_L1:
        val$dialog.dismiss();
        return;
_L2:
        val$fragment.showProgressDialogWithMessage(val$fragment.getString(0x7f060190));
        ExtServiceConnectManager.getGlobalConnectManager().pinterestLink(shareManager.getFragment(), new ExtServiceConnectInterface() {

            final PinterestConnect._cls1 this$1;

            public void error(PMApiError pmapierror)
            {
                Analytics.getInstance().trackEvent(shareManager.getFragment().getViewNameForAnalytics(), "user", "connect_pinterest_failed", PMApplicationSession.GetPMSession().getUserId());
                listener.stateFailed();
            }

            public void success(int i, Bundle bundle)
            {
                fragment.hideProgressDialog();
                listener.stateCompleted();
            }

            
            {
                this$1 = PinterestConnect._cls1.this;
                super();
            }
        });
        continue; /* Loop/switch isn't completed */
_L3:
        listener.stateCompleted();
        if (true) goto _L1; else goto _L4
_L4:
    }

    _cls1.this._cls1()
    {
        this$0 = final_pinterestconnect;
        val$fragment = pmfragment;
        val$dialog = PinterestDialog.this;
        super();
    }
}
