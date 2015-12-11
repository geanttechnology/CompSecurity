// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.a.a;

import com.shazam.b.e.a;
import com.shazam.f.j;

// Referenced classes of package com.shazam.a.a:
//            f

public final class e
    implements f
{

    public e()
    {
    }

    public final transient String a(String s, String as[])
    {
        if (com.shazam.b.e.a.a(s))
        {
            throw new j("urlTemplate must not be null or empty.");
        }
        if (as.length != 2)
        {
            throw new j("content must not be null, expecing 2 values");
        }
        String s1 = as[0];
        as = as[1];
        if (com.shazam.b.e.a.a(s1) || com.shazam.b.e.a.a(as))
        {
            throw new j("content must not be null");
        } else
        {
            return s.replaceAll("\\{inid\\}", s1).replaceAll("\\{tagid\\}", as);
        }
    }
}
