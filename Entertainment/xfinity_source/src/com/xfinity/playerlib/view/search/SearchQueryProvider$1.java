// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import com.google.common.cache.CacheLoader;
import com.xfinity.playerlib.model.user.PlayNowUser;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchQueryProvider, SearchQuery

class this._cls0 extends CacheLoader
{

    final SearchQueryProvider this$0;

    public SearchQuery load(PlayNowUser playnowuser)
        throws Exception
    {
        return new SearchQuery();
    }

    public volatile Object load(Object obj)
        throws Exception
    {
        return load((PlayNowUser)obj);
    }

    ()
    {
        this$0 = SearchQueryProvider.this;
        super();
    }
}
