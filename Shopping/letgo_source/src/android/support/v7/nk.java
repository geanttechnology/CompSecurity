// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            nj

public class nk
{

    private final Collection a = new ArrayList();
    private final Collection b = new ArrayList();
    private final Collection c = new ArrayList();

    public nk()
    {
    }

    public List a()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)((nj)iterator.next()).c();
            if (s != null)
            {
                arraylist.add(s);
            }
        } while (true);
        return arraylist;
    }

    public void a(nj nj1)
    {
        a.add(nj1);
    }

    public void b(nj nj1)
    {
        b.add(nj1);
    }

    public void c(nj nj1)
    {
        c.add(nj1);
    }
}
