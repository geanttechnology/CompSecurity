// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import android.view.View;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            HistoryFragment

class this._cls0
    implements android.view.er
{

    final HistoryFragment this$0;

    public void onClick(View view)
    {
        view = (LiveStreamBookmark)view.getTag();
        HistoryFragment.access$700(HistoryFragment.this, view);
    }

    ()
    {
        this$0 = HistoryFragment.this;
        super();
    }
}
