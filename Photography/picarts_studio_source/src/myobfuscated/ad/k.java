// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ad;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package myobfuscated.ad:
//            m, j

final class k
    implements m
{

    private j a;

    private k(j j1)
    {
        a = j1;
        super();
    }

    k(j j1, byte byte0)
    {
        this(j1);
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
            j j1 = (j)((Iterator) (obj)).next();
            if (j1.c != null)
            {
                hashset.add(j1.c);
            }
        } while (true);
        return hashset;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(super.toString()).append("{fragment=").append(a).append("}").toString();
    }
}
