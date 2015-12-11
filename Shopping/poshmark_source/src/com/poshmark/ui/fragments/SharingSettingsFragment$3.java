// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            SharingSettingsFragment, PinterestBoardSettingsFragment

class this._cls0
    implements android.view.gsFragment._cls3
{

    final SharingSettingsFragment this$0;

    public void onClick(View view)
    {
        if (PMApplicationSession.GetPMSession().getPinterestToken() != null)
        {
            getParentActivity().launchFragment(null, com/poshmark/ui/fragments/PinterestBoardSettingsFragment, null);
            return;
        } else
        {
            SharingSettingsFragment.access$400(SharingSettingsFragment.this);
            return;
        }
    }

    ment()
    {
        this$0 = SharingSettingsFragment.this;
        super();
    }
}
