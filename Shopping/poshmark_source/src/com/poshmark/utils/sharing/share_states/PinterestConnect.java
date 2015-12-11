// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.http.api.PMApiError;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.StateCompletionListener;
import com.poshmark.utils.view_holders.PinterestDialog;
import java.util.UUID;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareState

public class PinterestConnect extends ShareState
    implements PMNotificationListener
{

    public static UUID id = UUID.randomUUID();

    public PinterestConnect(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        super(statecompletionlistener, sharemanager);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.PINTEREST_FIRST_TIME_DIALOG_BACK", this);
    }

    private void deRegisterListeners()
    {
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    public void executeState()
    {
        Analytics.getInstance().trackEvent(shareManager.getFragment().getViewNameForAnalytics(), "user", "connect_pinterest_initiated", PMApplicationSession.GetPMSession().getUserId());
        boolean flag = PMApplicationSession.GetPMSession().isPinterestPreDialogShown();
        String s = PMApplicationSession.GetPMSession().getPinterestToken();
        if (FeatureManager.getGlobalFeatureManager().isPinterestButtonEnabled() && !flag && s == null)
        {
            final PMFragment fragment = shareManager.getFragment();
            final PinterestDialog dialog = new PinterestDialog();
            Analytics.getInstance().trackView("pre_connect_pinterest_dlg_screen");
            dialog.setCurrent_mode(com.poshmark.utils.view_holders.PinterestDialog.PINTEREST_DIALOG_MODE.PRE_CONN);
            dialog.setClickListener(new android.view.View.OnClickListener() {

                final PinterestConnect this$0;
                final PinterestDialog val$dialog;
                final PMFragment val$fragment;

                public void onClick(View view)
                {
                    view.getId();
                    JVM INSTR tableswitch 2131493474 2131493475: default 28
                //                               2131493474 36
                //                               2131493475 79;
                       goto _L1 _L2 _L3
_L1:
                    dialog.dismiss();
                    return;
_L2:
                    fragment.showProgressDialogWithMessage(fragment.getString(0x7f060190));
                    ExtServiceConnectManager.getGlobalConnectManager().pinterestLink(shareManager.getFragment(), new ExtServiceConnectInterface() {

                        final _cls1 this$1;

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
                this$1 = _cls1.this;
                super();
            }
                    });
                    continue; /* Loop/switch isn't completed */
_L3:
                    listener.stateCompleted();
                    if (true) goto _L1; else goto _L4
_L4:
                }

            
            {
                this$0 = PinterestConnect.this;
                fragment = pmfragment;
                dialog = pinterestdialog;
                super();
            }
            });
            dialog.show(fragment.getFragmentManager(), "pn");
            PMApplicationSession.GetPMSession().setPinterestPreDialogShownFlag(Boolean.valueOf(true));
            return;
        } else
        {
            listener.stateCompleted();
            return;
        }
    }

    public UUID getId()
    {
        return id;
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.PINTEREST_FIRST_TIME_DIALOG_BACK"))
        {
            deRegisterListeners();
            listener.stateFailed();
        }
    }

}
