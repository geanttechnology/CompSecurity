// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.ui.PMActivity;
import com.poshmark.user.UserInfoDetails;

// Referenced classes of package com.poshmark.ui.fragments:
//            UserSharesFragment, UserListFragment

class this._cls0
    implements android.view.esFragment._cls8
{

    final UserSharesFragment this$0;

    public void onClick(View view)
    {
        if (UserSharesFragment.access$000(UserSharesFragment.this) != null)
        {
            view = new Bundle();
            view.putString("MODE", _LIST_MODE.PM_FOLLOWING_MODE.name());
            view.putString("ID", UserSharesFragment.access$000(UserSharesFragment.this).getPMUserId());
            ((PMActivity)getActivity()).launchFragment(view, com/poshmark/ui/fragments/UserListFragment, null);
        }
    }

    _LIST_MODE()
    {
        this$0 = UserSharesFragment.this;
        super();
    }
}
