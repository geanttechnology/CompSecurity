// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Comparator;

// Referenced classes of package com.google.a.c:
//            l, au, bc

public abstract class aw
    implements Comparator
{

    public aw()
    {
    }

    public static aw a(Comparator comparator)
    {
        if (comparator instanceof aw)
        {
            return (aw)comparator;
        } else
        {
            return new l(comparator);
        }
    }

    public static aw b()
    {
        return au.a;
    }

    public aw a()
    {
        return new bc(this);
    }

    public abstract int compare(Object obj, Object obj1);
}
