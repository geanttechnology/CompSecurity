// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.Comparator;

// Referenced classes of package a.a:
//            fm

final class .Object
    implements Comparator
{

    final fm a;

    public final volatile int compare(Object obj, Object obj1)
    {
        obj = (String)obj;
        obj1 = (String)obj1;
        if (obj == obj1)
        {
            return 0;
        }
        if (obj == null)
        {
            return -1;
        }
        if (obj1 == null)
        {
            return 1;
        } else
        {
            return String.CASE_INSENSITIVE_ORDER.compare(obj, obj1);
        }
    }

    .Object(fm fm1)
    {
        a = fm1;
        super();
    }
}
