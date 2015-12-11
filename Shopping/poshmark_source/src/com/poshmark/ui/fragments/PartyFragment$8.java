// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            PartyFragment, PartyInviteFragment

class this._cls0
    implements android.view.ener
{

    final PartyFragment this$0;

    public void onClick(View view)
    {
        view = new Bundle();
        view.putString("ID", PartyFragment.access$500(PartyFragment.this));
        ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/PartyInviteFragment, PartyFragment.access$400(PartyFragment.this));
    }

    ent()
    {
        this$0 = PartyFragment.this;
        super();
    }
}
