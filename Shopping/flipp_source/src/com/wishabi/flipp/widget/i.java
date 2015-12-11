// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import java.util.Comparator;

// Referenced classes of package com.wishabi.flipp.widget:
//            o

final class i
    implements Comparator
{

    i()
    {
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        obj = (o)obj;
        obj1 = (o)obj1;
        int j = ((o) (obj)).e;
        int k = ((o) (obj1)).e;
        if (j < k)
        {
            return -1;
        }
        return j != k ? 1 : 0;
    }
}
