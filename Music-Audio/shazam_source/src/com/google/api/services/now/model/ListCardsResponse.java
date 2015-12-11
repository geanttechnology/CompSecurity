// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.h;
import com.google.api.a.g.l;
import java.util.List;

// Referenced classes of package com.google.api.services.now.model:
//            Card

public final class ListCardsResponse extends b
{

    private List cards;
    private String nextPageToken;

    public ListCardsResponse()
    {
    }

    public final volatile b clone()
    {
        return clone();
    }

    public final volatile l clone()
    {
        return clone();
    }

    public final ListCardsResponse clone()
    {
        return (ListCardsResponse)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final List getCards()
    {
        return cards;
    }

    public final String getNextPageToken()
    {
        return nextPageToken;
    }

    public final volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final ListCardsResponse set(String s, Object obj)
    {
        return (ListCardsResponse)super.set(s, obj);
    }

    public final ListCardsResponse setCards(List list)
    {
        cards = list;
        return this;
    }

    public final ListCardsResponse setNextPageToken(String s)
    {
        nextPageToken = s;
        return this;
    }

    static 
    {
        h.a(com/google/api/services/now/model/Card);
    }
}
