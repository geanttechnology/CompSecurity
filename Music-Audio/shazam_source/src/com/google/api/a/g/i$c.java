// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.api.a.g:
//            i, f, k

final class init> extends AbstractSet
{

    final i a;

    public final init> a()
    {
        return new <init>(a);
    }

    public final void clear()
    {
        String s;
        for (Iterator iterator1 = a.b.d.iterator(); iterator1.hasNext(); a.b.a(s).a(a.a, null))
        {
            s = (String)iterator1.next();
        }

    }

    public final boolean isEmpty()
    {
        for (Iterator iterator1 = a.b.d.iterator(); iterator1.hasNext();)
        {
            String s = (String)iterator1.next();
            if (a.b.a(s).a(a.a) != null)
            {
                return false;
            }
        }

        return true;
    }

    public final Iterator iterator()
    {
        return a();
    }

    public final int size()
    {
        Iterator iterator1 = a.b.d.iterator();
        int j = 0;
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            String s = (String)iterator1.next();
            if (a.b.a(s).a(a.a) != null)
            {
                j++;
            }
        } while (true);
        return j;
    }

    (i j)
    {
        a = j;
        super();
    }
}
