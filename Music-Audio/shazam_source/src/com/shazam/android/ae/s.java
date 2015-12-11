// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import java.util.Map;

// Referenced classes of package com.shazam.android.ae:
//            p, l, n

public final class s
    implements p
{

    private final Map b;

    public s(Map map)
    {
        b = map;
    }

    public final void a(n n, String s1, String s2)
    {
        ((l)b.get(n)).a(s1, s2);
    }

    public final void a(n n, String s1, String s2, Throwable throwable)
    {
        ((l)b.get(n)).a(s1, s2, throwable);
    }

    public final transient void a(n n, String s1, Throwable throwable, String s2, Object aobj[])
    {
        ((l)b.get(n)).a(s1, String.format(s2, aobj), throwable);
    }
}
