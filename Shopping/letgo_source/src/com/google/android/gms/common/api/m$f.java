// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.api:
//            m, o

private class c extends c
{

    final m a;
    private final ArrayList c;

    public void a()
    {
        Set set = m.d(a).f;
        if (set.isEmpty())
        {
            set = m.h(a);
        }
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((c)iterator.next()).zza(m.g(a), set)) { }
    }

    public (m m1, ArrayList arraylist)
    {
        a = m1;
        super(m1, null);
        c = arraylist;
    }
}
