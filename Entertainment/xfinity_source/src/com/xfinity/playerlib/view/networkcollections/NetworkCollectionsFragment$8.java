// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import android.view.View;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import it.sephiroth.android.library.widget.AdapterView;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            NetworkCollectionsFragment

class this._cls0
    implements it.sephiroth.android.library.widget.stener
{

    final NetworkCollectionsFragment this$0;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (DibicProgram)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i));
        bookmarkUtils.promptBookmarkDialog(NetworkCollectionsFragment.this, new VideoFavorite(adapterview.getMerlinId(), adapterview.getTitle(), adapterview.isAdult()));
        return true;
    }

    ()
    {
        this$0 = NetworkCollectionsFragment.this;
        super();
    }
}
