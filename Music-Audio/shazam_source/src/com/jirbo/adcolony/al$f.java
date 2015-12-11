// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            al, aj

public static final class 
{

    ArrayList a;

    final  a(int i)
    {
        return ()a.get(i);
    }

    public final a a(String s)
    {
        for (int i = 0; i < a.size(); i++)
        {
            a a1 = ()a.get(i);
            if (a1.a.equals(s))
            {
                return a1;
            }
        }

        aj.a.a("No such zone: ").b(s);
        return null;
    }

    ()
    {
    }
}
