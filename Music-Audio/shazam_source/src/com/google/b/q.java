// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;

import com.google.b.b.j;
import com.google.b.d.a;

// Referenced classes of package com.google.b:
//            p, l

public final class q
{

    public q()
    {
    }

    public static l a(a a1)
    {
        boolean flag;
        flag = a1.b;
        a1.b = true;
        l l = j.a(a1);
        a1.b = flag;
        return l;
        Object obj;
        obj;
        throw new p((new StringBuilder("Failed parsing JSON source: ")).append(a1).append(" to Json").toString(), ((Throwable) (obj)));
        obj;
        a1.b = flag;
        throw obj;
        obj;
        throw new p((new StringBuilder("Failed parsing JSON source: ")).append(a1).append(" to Json").toString(), ((Throwable) (obj)));
    }
}
