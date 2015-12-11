// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Comparator;

// Referenced classes of package android.support.v7:
//            wa, wd

class a
    implements Comparator
{

    final wa a;

    public int a(wd wd1, wd wd2)
    {
        return wd1.getClass().getCanonicalName().compareTo(wd2.getClass().getCanonicalName());
    }

    public int compare(Object obj, Object obj1)
    {
        return a((wd)obj, (wd)obj1);
    }

    (wa wa1)
    {
        a = wa1;
        super();
    }
}
