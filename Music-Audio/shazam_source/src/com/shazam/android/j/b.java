// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j;

import com.shazam.android.ag.a;

// Referenced classes of package com.shazam.android.j:
//            o

public final class b
    implements o
{

    private final a a;

    public b(a a1)
    {
        a = a1;
    }

    public final String a(String s)
    {
        boolean flag;
        if (s == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return null;
        }
        com.shazam.android.ag.b b1 = a.c;
        String s1;
        if (com.shazam.b.e.a.c(a.d))
        {
            s1 = (new StringBuilder("-")).append(a.d).toString();
        } else
        {
            s1 = "";
        }
        return s.replace("{appversion}", (new StringBuilder()).append(b1.a).append(s1).toString());
    }
}
