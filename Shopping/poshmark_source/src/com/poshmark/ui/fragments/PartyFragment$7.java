// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.ui.PMContainerActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            PartyFragment, PartyShowroomListFragment

class this._cls0
    implements android.view.ener
{

    final PartyFragment this$0;

    public void onClick(View view)
    {
        ((PMContainerActivity)getActivity()).launchDialogFragmentForResult(null, com/poshmark/ui/fragments/PartyShowroomListFragment, PartyFragment.access$400(PartyFragment.this), PartyFragment.this, 1);
    }

    tFragment()
    {
        this$0 = PartyFragment.this;
        super();
    }
}
