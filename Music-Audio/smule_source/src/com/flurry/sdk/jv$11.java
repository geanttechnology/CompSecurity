// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.net.URI;
import java.net.URISyntaxException;

// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            ih, jz

final class eption extends ir
{

    public URI a(jx jx1)
    {
        if (jx1.f() != jy.i) goto _L2; else goto _L1
_L1:
        jx1.j();
_L4:
        return null;
_L2:
        jx1 = jx1.h();
        if ("null".equals(jx1)) goto _L4; else goto _L3
_L3:
        jx1 = new URI(jx1);
        return jx1;
        jx1;
        throw new ih(jx1);
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (URI)obj);
    }

    public void a(jz jz1, URI uri)
    {
        if (uri == null)
        {
            uri = null;
        } else
        {
            uri = uri.toASCIIString();
        }
        jz1.b(uri);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    eption()
    {
    }
}
