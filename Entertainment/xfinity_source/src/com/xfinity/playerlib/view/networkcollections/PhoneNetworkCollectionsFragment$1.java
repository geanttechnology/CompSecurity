// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import android.view.View;
import com.xfinity.playerlib.model.tags.FeaturedShow;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            PhoneNetworkCollectionsFragment

class val.featuredShow
    implements android.view.honeNetworkCollectionsFragment._cls1
{

    final PhoneNetworkCollectionsFragment this$0;
    final FeaturedShow val$featuredShow;

    public void onClick(View view)
    {
        view = (new com.xfinity.playerlib.view.programdetails.t._cls1(val$featuredShow.getMerlinId())).featuredShow().getIntent(getActivity());
        startActivity(view);
    }

    ()
    {
        this$0 = final_phonenetworkcollectionsfragment;
        val$featuredShow = FeaturedShow.this;
        super();
    }
}
