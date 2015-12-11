// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Comparator;

// Referenced classes of package android.support.v7:
//            anx

class a
    implements Comparator
{

    final anx a;

    public int a(a a1, a a2)
    {
        return (int)(a1.b - a2.b);
    }

    public int compare(Object obj, Object obj1)
    {
        return a((a)obj, (a)obj1);
    }

    (anx anx1)
    {
        a = anx1;
        super();
    }
}
