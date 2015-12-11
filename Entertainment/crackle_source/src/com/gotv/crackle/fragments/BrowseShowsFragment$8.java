// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.widget.ProgressBar;

// Referenced classes of package com.gotv.crackle.fragments:
//            BrowseShowsFragment

class val.tag
    implements Runnable
{

    final BrowseShowsFragment this$0;
    final String val$tag;

    public void run()
    {
        BrowseShowsFragment.access$400(BrowseShowsFragment.this).setVisibility(4);
        if (val$tag == "ItemsListRequest-Featured" || val$tag == "ItemsListRequest-Popular" || val$tag == "ItemsListRequest-Recent" || val$tag == "BrowseAPI")
        {
            BrowseShowsFragment.access$500(BrowseShowsFragment.this);
        }
        if (val$tag == "GenreList")
        {
            BrowseShowsFragment.access$600(BrowseShowsFragment.this);
        }
    }

    ()
    {
        this$0 = final_browseshowsfragment;
        val$tag = String.this;
        super();
    }
}
