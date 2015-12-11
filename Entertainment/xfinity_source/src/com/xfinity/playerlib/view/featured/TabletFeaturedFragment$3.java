// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.view.View;
import com.xfinity.playerlib.bookmarks.Bookmark;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            TabletFeaturedFragment

class val.bookmark
    implements android.view.bletFeaturedFragment._cls3
{

    final TabletFeaturedFragment this$0;
    final Bookmark val$bookmark;

    public void onClick(View view)
    {
        view = (new com.xfinity.playerlib.view.programdetails.r((VideoBookmark)val$bookmark)).loadAsActivity(true).build().getIntent(view.getContext());
        startActivity(view);
    }

    Builder()
    {
        this$0 = final_tabletfeaturedfragment;
        val$bookmark = Bookmark.this;
        super();
    }
}
