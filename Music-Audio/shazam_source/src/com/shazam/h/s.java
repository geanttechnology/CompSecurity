// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.shazam.j.b;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.h:
//            r

public final class s
{
    public static final class a
    {

        Map a;

        public final a a(r r, b b1)
        {
            a.put(r, b1);
            return this;
        }

        public final s a()
        {
            return new s(this, (byte)0);
        }

        public a()
        {
            a = new HashMap();
        }
    }


    private final Map a;

    private s(a a1)
    {
        a = a1.a;
    }

    s(a a1, byte byte0)
    {
        this(a1);
    }

    public final b a(r r)
    {
        return (b)a.get(r);
    }
}
