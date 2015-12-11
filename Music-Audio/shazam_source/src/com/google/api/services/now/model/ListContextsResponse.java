// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.h;
import com.google.api.a.g.l;
import java.util.List;

// Referenced classes of package com.google.api.services.now.model:
//            Context

public final class ListContextsResponse extends b
{

    private List contexts;
    private String nextPageToken;

    public ListContextsResponse()
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

    public final ListContextsResponse clone()
    {
        return (ListContextsResponse)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final List getContexts()
    {
        return contexts;
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

    public final ListContextsResponse set(String s, Object obj)
    {
        return (ListContextsResponse)super.set(s, obj);
    }

    public final ListContextsResponse setContexts(List list)
    {
        contexts = list;
        return this;
    }

    public final ListContextsResponse setNextPageToken(String s)
    {
        nextPageToken = s;
        return this;
    }

    static 
    {
        h.a(com/google/api/services/now/model/Context);
    }
}
