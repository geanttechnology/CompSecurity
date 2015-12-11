// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            FindPeopleFragment, MappPageFragment

class this._cls0
    implements android.view.leFragment._cls9
{

    final FindPeopleFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "load_contacts", null);
        view = new Bundle();
        view.putString("URL", "https://www.poshmark.com/mapp/find_people/contacts");
        ((PMActivity)getActivity()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/MappPageFragment, null);
    }

    ()
    {
        this$0 = FindPeopleFragment.this;
        super();
    }
}
