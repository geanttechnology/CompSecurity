// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;


// Referenced classes of package com.google.c.a.a:
//            j, i

public final class s extends j
{

    public s()
    {
    }

    protected final i a()
    {
        return i.i;
    }

    public final boolean a(String s1)
    {
        s1 = c(s1);
        if (s1.startsWith("WIFI:"))
        {
            s1 = j.a("S:", s1, false);
            if (s1 == null)
            {
                s1 = null;
            } else
            {
                s1 = s1[0];
            }
            if (s1 != null && !s1.isEmpty())
            {
                return true;
            }
        }
        return false;
    }
}
