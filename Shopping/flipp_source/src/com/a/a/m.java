// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.a.v;
import com.a.a.a.i;
import java.io.InputStream;
import java.net.CacheResponse;
import java.util.Map;

// Referenced classes of package com.a.a:
//            f, l

final class m extends CacheResponse
{

    private final l a;
    private final i b;
    private final InputStream c;

    public m(l l1, i i)
    {
        a = l1;
        b = i;
        c = f.a(i);
    }

    static i a(m m1)
    {
        return m1.b;
    }

    public final InputStream getBody()
    {
        return c;
    }

    public final Map getHeaders()
    {
        return a.d.a(true);
    }
}
