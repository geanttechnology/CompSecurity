// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;

import java.io.Serializable;
import java.util.Collection;

// Referenced classes of package com.google.a.a:
//            h, i, g

private static final class n
    implements h, Serializable
{

    private final Collection a;

    public final boolean a(Object obj)
    {
        boolean flag;
        try
        {
            flag = a.contains(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        return flag;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof n.contains)
        {
            obj = (n.contains)obj;
            return a.equals(((n.equals) (obj)).a);
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
        String s = String.valueOf(String.valueOf(a));
        return (new StringBuilder(s.length() + 15)).append("Predicates.in(").append(s).append(")").toString();
    }

    private n(Collection collection)
    {
        a = (Collection)g.a(collection);
    }

    n(Collection collection, byte byte0)
    {
        this(collection);
    }
}
