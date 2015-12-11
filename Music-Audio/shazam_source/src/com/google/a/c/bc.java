// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.io.Serializable;

// Referenced classes of package com.google.a.c:
//            aw

final class bc extends aw
    implements Serializable
{

    final aw a;

    bc(aw aw1)
    {
        a = (aw)g.a(aw1);
    }

    public final aw a()
    {
        return a;
    }

    public final int compare(Object obj, Object obj1)
    {
        return a.compare(obj1, obj);
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof bc)
        {
            obj = (bc)obj;
            return a.equals(((bc) (obj)).a);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return -a.hashCode();
    }

    public final String toString()
    {
        String s = String.valueOf(String.valueOf(a));
        return (new StringBuilder(s.length() + 10)).append(s).append(".reverse()").toString();
    }
}
