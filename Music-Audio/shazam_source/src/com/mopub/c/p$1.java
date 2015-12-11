// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import com.mopub.common.c.a;
import com.mopub.d.s;

// Referenced classes of package com.mopub.c:
//            p

static final class 
    implements 
{

    final  a = null;
    final String b;

    public final void a(s s)
    {
        com.mopub.common.c.a.b((new StringBuilder("Failed to hit tracking endpoint: ")).append(b).toString());
        if (a != null)
        {
            a.a(s);
        }
    }

    public final void a(String s)
    {
        com.mopub.common.c.a.b((new StringBuilder("Successfully hit tracking endpoint: ")).append(s).toString());
        if (a != null)
        {
            a.a(s);
        }
    }

    (String s)
    {
        b = s;
        super();
    }
}
