// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.ui.PMActivity;
import com.poshmark.user.UserInfoDetails;

// Referenced classes of package com.poshmark.ui.fragments:
//            ClosetFragment, UserListFragment

class this._cls0
    implements android.view.er
{

    final ClosetFragment this$0;

    public void onClick(View view)
    {
        if (ClosetFragment.access$100(ClosetFragment.this) != null)
        {
            view = new Bundle();
            view.putString("MODE", SER_LIST_MODE.PM_FOLLOWING_MODE.name());
            view.putString("ID", ClosetFragment.access$100(ClosetFragment.this).getPMUserId());
            view.putInt("DISPLAY_COUNT", ClosetFragment.access$100(ClosetFragment.this).getFollowingCount());
            PMActivity pmactivity = (PMActivity)getActivity();
            if (pmactivity != null && pmactivity.isActivityInForeground())
            {
                pmactivity.launchFragment(view, com/poshmark/ui/fragments/UserListFragment, null);
            }
        }
    }

    SER_LIST_MODE()
    {
        this$0 = ClosetFragment.this;
        super();
    }
}
