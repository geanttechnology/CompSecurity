// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.b.a;

import java.util.List;

// Referenced classes of package org.a.a.b.a:
//            c

public final class d
{

    public final c a;
    public List b;
    public Long c;
    public Long d;
    public final long e;
    public boolean f;

    public d(c c1, long l)
    {
        this(c1, l, (byte)0);
    }

    private d(c c1, long l, byte byte0)
    {
        if (c1 == null)
        {
            throw new IllegalArgumentException("message cannot be null");
        } else
        {
            e = l;
            a = c1;
            b = null;
            return;
        }
    }
}
