// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;

final class gc
    implements Comparator
{

    public static final gc a = new gc();

    private gc()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (iz)obj;
        obj1 = (iz)obj1;
        return ((iz) (obj)).c.compareTo(((iz) (obj1)).c);
    }

}
