// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.h;

import java.util.ArrayList;
import java.util.List;

public final class a
    implements com.shazam.b.a.a
{

    private final com.shazam.b.a.a a;

    public a(com.shazam.b.a.a a1)
    {
        a = a1;
    }

    public final Object a(Object obj)
    {
        obj = (com.shazam.server.response.lyricplay.Line[][])obj;
        ArrayList arraylist = new ArrayList(obj.length);
        int j = obj.length;
        for (int i = 0; i < j; i++)
        {
            Object obj1 = obj[i];
            arraylist.add(a.a(obj1[0]));
        }

        return arraylist;
    }
}
