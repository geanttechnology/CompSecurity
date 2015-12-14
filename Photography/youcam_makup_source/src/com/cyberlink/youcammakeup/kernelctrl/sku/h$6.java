// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.sku;

import android.util.Pair;
import java.util.Comparator;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.sku:
//            h

class a
    implements Comparator
{

    final h a;

    public int a(Pair pair, Pair pair1)
    {
        return ((String)pair.first).compareTo((String)pair1.first);
    }

    public int compare(Object obj, Object obj1)
    {
        return a((Pair)obj, (Pair)obj1);
    }

    (h h1)
    {
        a = h1;
        super();
    }
}
