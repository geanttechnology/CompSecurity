// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities;

import com.shazam.a.g;
import com.shazam.android.aspects.b.a.b;
import com.shazam.android.k.b.i;
import com.shazam.android.k.e.b.c;
import com.shazam.i.b.a.a;
import com.shazam.model.configuration.ProModeConfiguration;
import com.shazam.server.response.follow.FollowData;

public class FollowersCountActivityAspect extends b
{
    private class FollowersCountFetcherListener
        implements com.shazam.g.b
    {

        final FollowersCountActivityAspect this$0;

        public void onDataFailedToLoad()
        {
        }

        public void onDataFetched(Integer integer)
        {
            updateAccountWithFollowersCount(integer.intValue());
        }

        public volatile void onDataFetched(Object obj)
        {
            onDataFetched((Integer)obj);
        }

        public void onUnauthorized()
        {
            com.shazam.android.activities.b.b.b(activity);
        }

        private FollowersCountFetcherListener()
        {
            this$0 = FollowersCountActivityAspect.this;
            super();
        }

    }


    private final com.shazam.k.a accountRepository = a.a();
    private com.shazam.android.aspects.c.a.a activity;
    private final g networkClient = com.shazam.i.c.b.a();
    private final ProModeConfiguration proModeConfiguration = com.shazam.i.b.n.b.D();
    private final com.shazam.android.j.w.c socialConfiguration = com.shazam.i.b.n.b.E();

    public FollowersCountActivityAspect()
    {
    }

    private void updateAccountWithFollowersCount(int j)
    {
        Object obj = com.shazam.model.account.Account.Builder.a(accountRepository.a());
        obj.followersCount = j;
        obj = ((com.shazam.model.account.Account.Builder) (obj)).b();
        accountRepository.a(((com.shazam.model.account.Account) (obj)));
    }

    public void onStart(com.shazam.android.aspects.c.a.a a1)
    {
        activity = a1;
        String s = proModeConfiguration.b().key;
        if (proModeConfiguration.a() && s != null)
        {
            a1 = new com.shazam.android.k.b.a(a1.getSupportLoaderManager(), 10013, a1, new c(networkClient, socialConfiguration, s), i.b);
            a1.a(new FollowersCountFetcherListener());
            a1.a();
        }
    }


}
