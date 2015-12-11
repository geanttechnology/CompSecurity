// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.d;

import java.util.Iterator;

public final class b
    implements Iterable
{

    private final Iterable a;

    private b(Iterable iterable)
    {
        a = iterable;
    }

    public static b a(Iterable iterable)
    {
        return new b(iterable);
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (b)obj;
        if (a == null) goto _L4; else goto _L3
_L3:
        if (a.equals(((b) (obj)).a)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((b) (obj)).a == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        if (a != null)
        {
            return a.hashCode();
        } else
        {
            return 0;
        }
    }

    public final Iterator iterator()
    {
        return a.iterator();
    }

    public final String toString()
    {
        return a.toString();
    }
}
