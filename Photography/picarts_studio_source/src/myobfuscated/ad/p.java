// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ad;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package myobfuscated.ad:
//            m, o

final class p
    implements m
{

    private o a;

    private p(o o1)
    {
        a = o1;
        super();
    }

    p(o o1, byte byte0)
    {
        this(o1);
    }

    public final Set a()
    {
        Object obj = a.a();
        HashSet hashset = new HashSet(((Set) (obj)).size());
        obj = ((Set) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            o o1 = (o)((Iterator) (obj)).next();
            if (o1.c != null)
            {
                hashset.add(o1.c);
            }
        } while (true);
        return hashset;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(super.toString()).append("{fragment=").append(a).append("}").toString();
    }
}
