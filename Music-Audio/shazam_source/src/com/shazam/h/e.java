// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.shazam.h.c.a;
import com.shazam.h.c.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.h:
//            n

public final class e
{
    public static final class a
    {

        public int a;
        public int b;
        public boolean c;
        public boolean d;
        Map e;
        final List f = new ArrayList();
        public com.shazam.h.c.a g;
        public String h;

        public final a a(n n)
        {
            f.add(n);
            return this;
        }

        public final e a()
        {
            return new e(this, (byte)0);
        }

        public a()
        {
            e = new HashMap();
            g = new b();
        }
    }


    final int a;
    final int b;
    final boolean c;
    final List d;
    final com.shazam.h.c.a e;
    final String f;
    private final boolean g;
    private final Map h;

    private e(a a1)
    {
        a = a1.a;
        b = a1.b;
        g = a1.c;
        c = a1.d;
        h = a1.e;
        d = a1.f;
        e = a1.g;
        f = a1.h;
    }

    e(a a1, byte byte0)
    {
        this(a1);
    }
}
