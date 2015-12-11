// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.DialogInterface;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.fragments.PartyGuidelinesFragment;

// Referenced classes of package com.poshmark.utils:
//            ShareManager_Old

class ent
    implements android.content.lickListener
{

    final ShareManager_Old this$0;
    final PartyEvent val$event;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ((PMContainerActivity)ShareManager_Old.access$200(ShareManager_Old.this).getActivity()).launchFragment(null, com/poshmark/ui/fragments/PartyGuidelinesFragment, val$event);
    }

    ent()
    {
        this$0 = final_sharemanager_old;
        val$event = PartyEvent.this;
        super();
    }
}
