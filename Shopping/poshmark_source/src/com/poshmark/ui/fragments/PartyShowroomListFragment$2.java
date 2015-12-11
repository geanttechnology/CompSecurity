// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            PartyShowroomListFragment, ClosetFragment

class val.hostUserId
    implements android.view.stFragment._cls2
{

    final PartyShowroomListFragment this$0;
    final String val$hostUserId;

    public void onClick(View view)
    {
        view = new Bundle();
        view.putString("NAME", val$hostUserId);
        ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/ClosetFragment, null);
        dismiss();
    }

    ()
    {
        this$0 = final_partyshowroomlistfragment;
        val$hostUserId = String.this;
        super();
    }
}
