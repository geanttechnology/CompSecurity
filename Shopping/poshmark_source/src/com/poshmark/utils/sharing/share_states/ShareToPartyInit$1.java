// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import android.content.DialogInterface;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.fragments.PartyGuidelinesFragment;
import com.poshmark.utils.ShareManager;

// Referenced classes of package com.poshmark.utils.sharing.share_states:
//            ShareToPartyInit

class val.event
    implements android.content.lickListener
{

    final ShareToPartyInit this$0;
    final PartyEvent val$event;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ((PMContainerActivity)shareManager.getFragment().getActivity()).launchFragment(null, com/poshmark/ui/fragments/PartyGuidelinesFragment, val$event);
    }

    ()
    {
        this$0 = final_sharetopartyinit;
        val$event = PartyEvent.this;
        super();
    }
}
