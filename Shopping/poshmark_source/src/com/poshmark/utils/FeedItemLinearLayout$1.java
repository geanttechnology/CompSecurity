// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.os.Bundle;
import android.view.View;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.CommentFragment;

// Referenced classes of package com.poshmark.utils:
//            FeedItemLinearLayout

class this._cls0
    implements android.view.out._cls1
{

    final FeedItemLinearLayout this$0;

    public void onClick(View view)
    {
        ListingSocial listingsocial = (ListingSocial)view.getTag();
        view = (PMActivity)view.getContext();
        Bundle bundle = new Bundle();
        bundle.putString("ID", listingsocial.getIdAsString());
        view.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/CommentFragment, listingsocial);
    }

    al()
    {
        this$0 = FeedItemLinearLayout.this;
        super();
    }
}
