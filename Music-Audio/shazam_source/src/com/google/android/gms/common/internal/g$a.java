// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.internal:
//            g, w

private static final class p extends g
{

    List p;

    public final g a(g g1)
    {
        ArrayList arraylist = new ArrayList(p);
        arraylist.add(w.a(g1));
        return new <init>(arraylist);
    }

    public final boolean a(char c)
    {
        for (Iterator iterator = p.iterator(); iterator.hasNext();)
        {
            if (((g)iterator.next()).a(c))
            {
                return true;
            }
        }

        return false;
    }

    (List list)
    {
        p = list;
    }
}
