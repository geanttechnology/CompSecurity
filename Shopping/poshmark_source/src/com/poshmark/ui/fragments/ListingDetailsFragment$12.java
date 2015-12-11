// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.data_model.models.inner_models.SystemMessage;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsFragment, MappPageFragment

class ssage
    implements android.view.sFragment._cls12
{

    final ListingDetailsFragment this$0;
    final SystemMessage val$msg;

    public void onClick(View view)
    {
        view = new Bundle();
        view.putString("URL", val$msg.getDestinationUrl());
        ((PMActivity)getActivity()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/MappPageFragment, null);
    }

    ssage()
    {
        this$0 = final_listingdetailsfragment;
        val$msg = SystemMessage.this;
        super();
    }
}
