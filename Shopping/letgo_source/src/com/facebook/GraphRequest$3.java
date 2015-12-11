// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.facebook:
//            GraphRequest, p, o

static final class b
    implements Runnable
{

    final ArrayList a;
    final o b;

    public void run()
    {
        Pair pair;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); (()pair.first).a((p)pair.second))
        {
            pair = (Pair)iterator.next();
        }

        for (Iterator iterator1 = b.e().iterator(); iterator1.hasNext(); ((b)iterator1.next()).b(b)) { }
    }

    (ArrayList arraylist, o o1)
    {
        a = arraylist;
        b = o1;
        super();
    }
}
