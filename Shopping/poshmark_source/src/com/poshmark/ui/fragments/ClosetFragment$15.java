// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            ClosetFragment, EditProfileFormFragment

class this._cls0
    implements android.view.er
{

    final ClosetFragment this$0;

    public void onClick(View view)
    {
        view = new Bundle();
        view.putInt("MODE", gment.PROFILE_MODE.PROFILE_MODE_EDIT.ordinal());
        ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/EditProfileFormFragment, null);
    }

    gment()
    {
        this$0 = ClosetFragment.this;
        super();
    }
}
