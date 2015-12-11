// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.io.Serializable;
import java.util.Comparator;

// Referenced classes of package com.google.a.c:
//            aw

final class l extends aw
    implements Serializable
{

    final Comparator a;

    l(Comparator comparator)
    {
        a = (Comparator)g.a(comparator);
    }

    public final int compare(Object obj, Object obj1)
    {
        return a.compare(obj, obj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof l)
        {
            obj = (l)obj;
            return a.equals(((l) (obj)).a);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return a.hashCode();
    }

    public final String toString()
    {
        return a.toString();
    }
}
