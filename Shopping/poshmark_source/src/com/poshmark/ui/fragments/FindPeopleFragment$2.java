// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.data_model.models.inner_models.UserReference;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            FindPeopleFragment, ClosetFragment

class this._cls0
    implements android.view.leFragment._cls2
{

    final FindPeopleFragment this$0;

    public void onClick(View view)
    {
        view = (UserReference)view.getTag();
        PMActivity pmactivity = (PMActivity)getActivity();
        if (pmactivity != null && pmactivity.isActivityInForeground())
        {
            Bundle bundle = new Bundle();
            bundle.putString("NAME", view.getUserName());
            ((PMActivity)getActivity()).launchFragment(bundle, com/poshmark/ui/fragments/ClosetFragment, null);
        }
    }

    rReference()
    {
        this$0 = FindPeopleFragment.this;
        super();
    }
}
