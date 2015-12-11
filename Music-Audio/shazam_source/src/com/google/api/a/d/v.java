// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import java.util.Arrays;
import java.util.logging.Logger;

// Referenced classes of package com.google.api.a.d:
//            q, r, y

public abstract class v
{

    static final Logger a = Logger.getLogger(com/google/api/a/d/v.getName());
    private static final String b[];

    public v()
    {
    }

    public final q a(r r)
    {
        return new q(this, r);
    }

    public abstract y a(String s, String s1);

    public boolean a(String s)
    {
        return Arrays.binarySearch(b, s) >= 0;
    }

    static 
    {
        String as[] = new String[4];
        as[0] = "DELETE";
        as[1] = "GET";
        as[2] = "POST";
        as[3] = "PUT";
        b = as;
        Arrays.sort(as);
    }
}
