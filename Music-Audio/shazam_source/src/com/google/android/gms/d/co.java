// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.ads.internal.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            cn, cp, he

public final class co
    implements Iterable
{

    final List a = new LinkedList();

    public co()
    {
    }

    public static boolean a(he he)
    {
        he = b(he);
        if (he != null)
        {
            ((cn) (he)).b.a();
            return true;
        } else
        {
            return false;
        }
    }

    static cn b(he he)
    {
        for (Iterator iterator1 = p.r().iterator(); iterator1.hasNext();)
        {
            cn cn1 = (cn)iterator1.next();
            if (cn1.a == he)
            {
                return cn1;
            }
        }

        return null;
    }

    public final Iterator iterator()
    {
        return a.iterator();
    }
}
