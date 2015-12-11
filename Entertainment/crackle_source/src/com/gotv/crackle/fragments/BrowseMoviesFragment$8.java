// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.widget.ProgressBar;

// Referenced classes of package com.gotv.crackle.fragments:
//            BrowseMoviesFragment

class val.tag
    implements Runnable
{

    final BrowseMoviesFragment this$0;
    final String val$tag;

    public void run()
    {
        BrowseMoviesFragment.access$400(BrowseMoviesFragment.this).setVisibility(4);
        if (val$tag == "ItemsListRequest-Featured" || val$tag == "ItemsListRequest-Popular" || val$tag == "ItemsListRequest-Recent" || val$tag == "BrowseAPI")
        {
            BrowseMoviesFragment.access$500(BrowseMoviesFragment.this);
        }
        if (val$tag == "GenreList")
        {
            BrowseMoviesFragment.access$600(BrowseMoviesFragment.this);
        }
    }

    ()
    {
        this$0 = final_browsemoviesfragment;
        val$tag = String.this;
        super();
    }
}
