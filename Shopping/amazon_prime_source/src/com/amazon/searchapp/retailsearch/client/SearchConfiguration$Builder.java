// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.util.Map;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            SearchConfiguration, SearchRealm

public static final class 
{

    private String id;
    private SearchRealm realm;
    private Map realms;

    public SearchConfiguration build()
    {
        return new SearchConfiguration(this, null);
    }

    public String getId()
    {
        return id;
    }

    public SearchRealm getRealm()
    {
        return realm;
    }

    public Map getRealms()
    {
        return realms;
    }

    public realms setId(String s)
    {
        id = s;
        return this;
    }

    public id setRealm(SearchRealm searchrealm)
    {
        realm = searchrealm;
        return this;
    }

    public realm setRealms(Map map)
    {
        realms = map;
        return this;
    }




    public ()
    {
    }
}
