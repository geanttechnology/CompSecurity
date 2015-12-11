// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.b;

import com.shazam.b.a.a;
import com.shazam.server.response.artist.FootNote;
import java.util.Iterator;
import java.util.List;

public final class b
    implements a
{

    public final String a;

    public b(String s)
    {
        a = s;
    }

    public final Object a(Object obj)
    {
        Object obj1 = (List)obj;
        obj = new StringBuilder();
        FootNote footnote;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((StringBuilder) (obj)).append(a).append(footnote.title).append(": ").append(footnote.value))
        {
            footnote = (FootNote)((Iterator) (obj1)).next();
        }

        return ((StringBuilder) (obj)).toString();
    }
}
