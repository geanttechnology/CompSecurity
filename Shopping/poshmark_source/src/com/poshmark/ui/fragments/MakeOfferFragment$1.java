// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            MakeOfferFragment, MappPageFragment

class this._cls0
    implements android.view.
{

    final MakeOfferFragment this$0;

    public void onClick(View view)
    {
        view = new Bundle();
        view.putString("URL", "https://www.poshmark.com/mapp/offers_help");
        view.putString("ANALYTICS_PAGE_NAME", "offers_help_screen");
        ((PMActivity)getActivity()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/MappPageFragment, null);
    }

    ()
    {
        this$0 = MakeOfferFragment.this;
        super();
    }
}
