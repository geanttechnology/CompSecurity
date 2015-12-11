// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;


// Referenced classes of package com.ebay.mobile.following:
//            EditFollowingFragment, FollowedSearchViewModel, BrowseFollowingSearchesFragmentAdapter

class val.setNotifyEnabled
    implements veSavedSearchesAsyncTask.Observer
{

    final EditFollowingFragment this$0;
    final FollowedSearchViewModel val$model;
    final boolean val$setNotifyEnabled;

    public void onSearchesSaved(boolean flag)
    {
        if (flag)
        {
            val$model.isNotifyEnabled = Boolean.valueOf(val$setNotifyEnabled);
            searchesAdapter.notifyDataSetChanged();
        }
    }

    ragmentAdapter()
    {
        this$0 = final_editfollowingfragment;
        val$model = followedsearchviewmodel;
        val$setNotifyEnabled = Z.this;
        super();
    }
}
