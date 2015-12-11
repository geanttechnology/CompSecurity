// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            PartyShowroomListFragment, PartyInviteFragment

class this._cls0
    implements android.view.stFragment._cls3
{

    final PartyShowroomListFragment this$0;

    public void onClick(View view)
    {
        view = new Bundle();
        view.putString("ID", PartyShowroomListFragment.access$100(PartyShowroomListFragment.this).getId());
        ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/PartyInviteFragment, PartyShowroomListFragment.access$100(PartyShowroomListFragment.this));
        dismiss();
    }

    ()
    {
        this$0 = PartyShowroomListFragment.this;
        super();
    }
}
