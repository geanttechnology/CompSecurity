// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.m;
import com.google.b.x;
import java.net.URI;
import java.net.URISyntaxException;

// Referenced classes of package com.google.b.b.a:
//            m

static final class ption extends x
{

    private static URI b(a a1)
    {
        if (a1.f() != b.i) goto _L2; else goto _L1
_L1:
        a1.k();
_L4:
        return null;
_L2:
        a1 = a1.i();
        if ("null".equals(a1)) goto _L4; else goto _L3
_L3:
        a1 = new URI(a1);
        return a1;
        a1;
        throw new m(a1);
    }

    public final Object a(a a1)
    {
        return b(a1);
    }

    public final void a(c c1, Object obj)
    {
        obj = (URI)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((URI) (obj)).toASCIIString();
        }
        c1.b(((String) (obj)));
    }

    ption()
    {
    }
}
