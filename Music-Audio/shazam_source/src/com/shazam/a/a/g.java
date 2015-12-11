// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.a.a;

import com.shazam.b.e.a;
import com.shazam.f.j;

// Referenced classes of package com.shazam.a.a:
//            f

public final class g
    implements f
{

    public g()
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
        } else
        {
            String s1 = as[0];
            as = as[1];
            return s.replaceAll("\\{toptracksid\\}", s1).replaceAll("\\{geonamesid\\}", as);
        }
    }
}
