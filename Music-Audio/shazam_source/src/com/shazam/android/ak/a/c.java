// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ak.a;

import com.shazam.a.b;
import com.shazam.android.j.g.e;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
    implements b
{

    private final e a;

    public c(e e1)
    {
        a = e1;
    }

    public final String a(String s, com.shazam.a.c c1)
    {
        s = s.replaceAll("\\{coverart_size\\}", a.b()).replaceAll("\\{icon_size\\}", a.a()).replaceAll("\\{type\\}", "track");
        for (Iterator iterator = c1.a.keySet().iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            s = s.replaceAll((new StringBuilder("\\{")).append(s1).append("\\}").toString(), (String)c1.a.get(s1));
        }

        return s;
    }
}
