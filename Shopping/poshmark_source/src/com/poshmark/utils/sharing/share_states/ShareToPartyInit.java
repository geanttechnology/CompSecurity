// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.content.Context;
import android.content.DialogInterface;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.fragments.PartyGuidelinesFragment;
import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.PMShareContent;
import com.poshmark.utils.sharing.StateCompletionListener;
import java.util.UUID;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareState

public class ShareToPartyInit extends ShareState
{

    public static UUID id = UUID.randomUUID();

    public ShareToPartyInit(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        super(statecompletionlistener, sharemanager);
    }

    public void executeState()
    {
        com.poshmark.data_model.models.ListingSummary listingsummary = shareManager.getShareContent().getListing();
        final PartyEvent event = shareManager.getShareContent().getParty();
        if (!event.isListingEligibleForParty(listingsummary))
        {
            String s = String.format(new String(PMApplication.getContext().getString(0x7f060149)), new Object[] {
                event.getTitle()
            });
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(shareManager.getFragment().getActivity());
            builder.setIcon(0x1080027);
            builder.setTitle(PMApplication.getContext().getString(0x7f0600d0));
            builder.setMessage(s);
            builder.setPositiveButton(PMApplication.getContext().getString(0x7f0602be), new android.content.DialogInterface.OnClickListener() {

                final ShareToPartyInit this$0;
                final PartyEvent val$event;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    ((PMContainerActivity)shareManager.getFragment().getActivity()).launchFragment(null, com/poshmark/ui/fragments/PartyGuidelinesFragment, event);
                }

            
            {
                this$0 = ShareToPartyInit.this;
                event = partyevent;
                super();
            }
            });
            builder.setNegativeButton(PMApplication.getContext().getString(0x7f0601e1), null);
            builder.show();
            listener.stateFailed();
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

}
