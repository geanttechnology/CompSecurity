// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.tags.OrderedTag;
import com.xfinity.playerlib.model.tags.Tag;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

class this._cls0
    implements gMatcher
{

    final SearchResultsFragment this$0;

    public boolean programMatchesTag(DibicProgram dibicprogram, OrderedTag orderedtag)
    {
        return dibicprogram.getGenres().contains(orderedtag);
    }

    public volatile boolean programMatchesTag(DibicProgram dibicprogram, Tag tag)
    {
        return programMatchesTag(dibicprogram, (OrderedTag)tag);
    }

    gMatcher()
    {
        this$0 = SearchResultsFragment.this;
        super();
    }
}
