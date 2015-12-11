// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.g;

import com.shazam.b.a.a;
import com.shazam.c.i;
import com.shazam.server.response.like.Like;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
    implements i
{

    private final a a;

    public b(a a1)
    {
        a = a1;
    }

    public final Object a(Object obj)
    {
        Object obj1 = (List)obj;
        obj = new ArrayList(((List) (obj1)).size());
        Like like;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(a.a(like)))
        {
            like = (Like)((Iterator) (obj1)).next();
        }

        return obj;
    }
}
