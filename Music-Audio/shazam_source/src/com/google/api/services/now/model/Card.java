// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;

// Referenced classes of package com.google.api.services.now.model:
//            CardContent, CardContexts

public final class Card extends b
{

    private String cardId;
    private CardContent content;
    private CardContexts contexts;

    public Card()
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

    public final Card clone()
    {
        return (Card)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final String getCardId()
    {
        return cardId;
    }

    public final CardContent getContent()
    {
        return content;
    }

    public final CardContexts getContexts()
    {
        return contexts;
    }

    public final volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final Card set(String s, Object obj)
    {
        return (Card)super.set(s, obj);
    }

    public final Card setCardId(String s)
    {
        cardId = s;
        return this;
    }

    public final Card setContent(CardContent cardcontent)
    {
        content = cardcontent;
        return this;
    }

    public final Card setContexts(CardContexts cardcontexts)
    {
        contexts = cardcontexts;
        return this;
    }
}
