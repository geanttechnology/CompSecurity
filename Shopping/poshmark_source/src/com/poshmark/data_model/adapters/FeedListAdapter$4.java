// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.os.Bundle;
import android.view.View;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.ListingDetailsFragment;

// Referenced classes of package com.poshmark.data_model.adapters:
//            FeedListAdapter

class this._cls0
    implements android.view.er
{

    final FeedListAdapter this$0;

    public void onClick(View view)
    {
        ListingSocial listingsocial = (ListingSocial)view.getTag();
        Bundle bundle = new Bundle();
        bundle.putString("ID", listingsocial.getIdAsString());
        ((PMActivity)view.getContext()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ListingDetailsFragment, null);
    }

    ()
    {
        this$0 = FeedListAdapter.this;
        super();
    }
}
