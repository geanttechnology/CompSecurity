// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import com.comcast.cim.cmasl.utils.provider.Provider;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchQuery

public class SearchQueryProvider
    implements Provider
{

    private final LoadingCache perUserQueryCache = CacheBuilder.newBuilder().build(new CacheLoader() {

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

            
            {
                this$0 = SearchQueryProvider.this;
                super();
            }
    });
    private final PlayNowUserManager userManager;

    public SearchQueryProvider(PlayNowUserManager playnowusermanager)
    {
        userManager = playnowusermanager;
        playnowusermanager.getUser();
    }

    public SearchQuery get()
    {
        PlayNowUser playnowuser = (PlayNowUser)userManager.getUser();
        if (playnowuser == null)
        {
            throw new IllegalStateException("This method should not be called while there is no user signed in");
        } else
        {
            return (SearchQuery)perUserQueryCache.getUnchecked(playnowuser);
        }
    }

    public volatile Object get()
    {
        return get();
    }
}
