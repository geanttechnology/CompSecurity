// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.util;


// Referenced classes of package com.shazam.android.util:
//            s, q

public final class i
    implements s
{

    private final s a;
    private String b;
    private long c;

    public i(s s1)
    {
        a = s1;
    }

    public final void a(q q1)
    {
        String s1 = q1.b.toString();
        long l = System.currentTimeMillis();
        if (s1.equals(b) && l - c < 2000L)
        {
            return;
        } else
        {
            b = s1;
            c = l;
            a.a(q1);
            return;
        }
    }
}
