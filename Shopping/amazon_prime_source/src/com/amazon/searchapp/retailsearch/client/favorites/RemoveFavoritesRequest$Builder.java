// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.favorites;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.favorites:
//            RemoveFavoritesRequest

public static class 
{

    private String configuration;
    private List items;
    private String refTag;
    private String requestToken;

    public RemoveFavoritesRequest build()
    {
        return new RemoveFavoritesRequest(this, null);
    }

    public String getConfiguration()
    {
        return configuration;
    }

    public List getItems()
    {
        return items;
    }

    public String getRefTag()
    {
        return refTag;
    }

    public String getRequestToken()
    {
        return requestToken;
    }

    public requestToken setConfiguration(String s)
    {
        configuration = s;
        return this;
    }

    public configuration setItems(List list)
    {
        items = list;
        return this;
    }

    public items setRefTag(String s)
    {
        refTag = s;
        return this;
    }

    public refTag setRequestToken(String s)
    {
        requestToken = s;
        return this;
    }





    public ()
    {
    }
}
