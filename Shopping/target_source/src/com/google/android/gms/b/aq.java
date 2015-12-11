// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import com.google.android.gms.ads.internal.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.google.android.gms.b:
//            ap, ar, cj

public class aq
    implements Iterable
{

    private final List a = new LinkedList();

    public aq()
    {
    }

    private ap c(cj cj)
    {
        for (Iterator iterator1 = com.google.android.gms.ads.internal.c.k().iterator(); iterator1.hasNext();)
        {
            ap ap1 = (ap)iterator1.next();
            if (ap1.a == cj)
            {
                return ap1;
            }
        }

        return null;
    }

    public void a(ap ap1)
    {
        a.add(ap1);
    }

    public boolean a(cj cj)
    {
        cj = c(cj);
        if (cj != null)
        {
            ((ap) (cj)).b.a();
            return true;
        } else
        {
            return false;
        }
    }

    public void b(ap ap1)
    {
        a.remove(ap1);
    }

    public boolean b(cj cj)
    {
        return c(cj) != null;
    }

    public Iterator iterator()
    {
        return a.iterator();
    }
}
