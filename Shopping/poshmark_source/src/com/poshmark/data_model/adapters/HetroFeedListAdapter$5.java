// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.os.Bundle;
import android.view.View;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.UserListFragment;

// Referenced classes of package com.poshmark.data_model.adapters:
//            HetroFeedListAdapter

class this._cls0
    implements android.view.roFeedListAdapter._cls5
{

    final HetroFeedListAdapter this$0;

    public void onClick(View view)
    {
        ListingSocial listingsocial = (ListingSocial)view.getTag();
        Bundle bundle = new Bundle();
        bundle.putString("MODE", com.poshmark.ui.fragments.IST_MODE.LIKES_MODE.name());
        bundle.putString("ID", listingsocial.getIdAsString());
        ((PMActivity)view.getContext()).launchFragment(bundle, com/poshmark/ui/fragments/UserListFragment, null);
    }

    E()
    {
        this$0 = HetroFeedListAdapter.this;
        super();
    }
}
