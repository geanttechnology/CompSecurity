// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import android.content.DialogInterface;
import com.xfinity.playerlib.bookmarks.Bookmark;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import java.util.Arrays;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            HistoryFragment, HistoryAdapter

class val.liveStreamBookmark
    implements android.content.ClickListener
{

    final HistoryFragment this$0;
    final LiveStreamBookmark val$liveStreamBookmark;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        HistoryFragment.access$100(HistoryFragment.this).removeHistoryItem(val$liveStreamBookmark);
        HistoryFragment.access$400(HistoryFragment.this).removeItems(Arrays.asList(new Bookmark[] {
            val$liveStreamBookmark
        }));
    }

    ()
    {
        this$0 = final_historyfragment;
        val$liveStreamBookmark = LiveStreamBookmark.this;
        super();
    }
}
