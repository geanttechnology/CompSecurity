// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma.a;

import java.util.Comparator;

// Referenced classes of package com.cyberlink.uma.a:
//            f, i

class a
    implements Comparator
{

    final f a;

    public int a(i j, i k)
    {
        return j.e - k.e;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((i)obj, (i)obj1);
    }

    (f f1)
    {
        a = f1;
        super();
    }
}
