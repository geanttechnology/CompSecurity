// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.shazam.h.a.a;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.h:
//            l, y, r, k

public static final class g
{

    public URL a;
    boolean b;
    public y c;
    final Map d = new HashMap();
    public k e;
    public String f;
    byte g[];

    public final g a(a a1)
    {
        try
        {
            b(a1);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            return this;
        }
        return this;
    }

    public final b a(r r1)
    {
        f = r1.f;
        return this;
    }

    public final f a(Map map)
    {
        d.clear();
        d.putAll(map);
        return this;
    }

    public final l a()
    {
        return new l(this, (byte)0);
    }

    public final nit> b(a a1)
    {
        g = a1.a();
        return this;
    }

    public on()
    {
        c = com.shazam.h.y.a;
        g = new byte[0];
    }
}
