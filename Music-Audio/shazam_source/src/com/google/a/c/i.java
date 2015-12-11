// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.c;
import com.google.a.a.g;
import java.io.Serializable;
import java.util.Arrays;

// Referenced classes of package com.google.a.c:
//            aw

public final class i extends aw
    implements Serializable
{

    final c a;
    final aw b;

    public i(c c1, aw aw1)
    {
        a = (c)g.a(c1);
        b = (aw)g.a(aw1);
    }

    public final int compare(Object obj, Object obj1)
    {
        return b.compare(a.a(obj), a.a(obj1));
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof i)
            {
                if (!a.equals(((i) (obj = (i)obj)).a) || !b.equals(((i) (obj)).b))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            a, b
        });
    }

    public final String toString()
    {
        String s = String.valueOf(String.valueOf(b));
        String s1 = String.valueOf(String.valueOf(a));
        return (new StringBuilder(s.length() + 13 + s1.length())).append(s).append(".onResultOf(").append(s1).append(")").toString();
    }
}
