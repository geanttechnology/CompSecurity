// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.h:
//            y, k, r

public final class l
{
    public static final class a
    {

        public URL a;
        boolean b;
        public y c;
        final Map d = new HashMap();
        public k e;
        public String f;
        byte g[];

        public final a a(com.shazam.h.a.a a1)
        {
            try
            {
                b(a1);
            }
            // Misplaced declaration of an exception variable
            catch (com.shazam.h.a.a a1)
            {
                return this;
            }
            return this;
        }

        public final a a(r r1)
        {
            f = r1.f;
            return this;
        }

        public final a a(Map map)
        {
            d.clear();
            d.putAll(map);
            return this;
        }

        public final l a()
        {
            return new l(this, (byte)0);
        }

        public final a b(com.shazam.h.a.a a1)
        {
            g = a1.a();
            return this;
        }

        public a()
        {
            c = y.a;
            g = new byte[0];
        }
    }


    public URL a;
    boolean b;
    y c;
    Map d;
    k e;
    String f;
    byte g[];

    private l()
    {
    }

    private l(a a1)
    {
        a = a1.a;
        b = a1.b;
        c = a1.c;
        d = a1.d;
        e = a1.e;
        f = a1.f;
        g = a1.g;
    }

    l(a a1, byte byte0)
    {
        this(a1);
    }
}
