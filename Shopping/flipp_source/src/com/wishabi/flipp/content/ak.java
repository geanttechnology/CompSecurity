// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import java.util.Comparator;

// Referenced classes of package com.wishabi.flipp.content:
//            al

final class ak
    implements Comparator
{

    ak()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (al)obj;
        obj1 = (al)obj1;
        if (((al) (obj)).b && !((al) (obj1)).b)
        {
            return 1;
        }
        if (!((al) (obj)).b && ((al) (obj1)).b)
        {
            return -1;
        } else
        {
            return ((al) (obj1)).a.compareToIgnoreCase(((al) (obj)).a);
        }
    }
}
