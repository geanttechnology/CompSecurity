// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.g;

import com.shazam.b.e.a;

// Referenced classes of package com.shazam.android.j.g:
//            d

public final class f
{

    public final d a;

    public f(d d1)
    {
        a = d1;
    }

    public final String a()
    {
        int i = 0;
        Object obj = a.b();
        if (com.shazam.b.e.a.a(((String) (obj))))
        {
            return "IMSI not available";
        }
        int j = ((String) (obj)).length();
        obj = new StringBuilder(((String) (obj)).substring(0, 6));
        for (; i < j - 6; i++)
        {
            ((StringBuilder) (obj)).append("*");
        }

        return ((StringBuilder) (obj)).toString();
    }
}
