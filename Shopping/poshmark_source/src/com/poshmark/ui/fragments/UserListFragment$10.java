// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.data_model.models.inner_models.UserReference;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            UserListFragment, ClosetFragment

class this._cls0
    implements android.view.
{

    final UserListFragment this$0;

    public void onClick(View view)
    {
        Object obj = (UserReference)view.getTag();
        view = new Bundle();
        view.putString("NAME", ((UserReference) (obj)).getUserName());
        obj = (PMActivity)getActivity();
        if (obj != null && ((PMActivity) (obj)).isActivityInForeground())
        {
            ((PMActivity) (obj)).launchFragment(view, com/poshmark/ui/fragments/ClosetFragment, null);
        }
    }

    erReference()
    {
        this$0 = UserListFragment.this;
        super();
    }
}
