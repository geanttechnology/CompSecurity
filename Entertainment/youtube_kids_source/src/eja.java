// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;

final class eja
    implements Comparator
{

    private Comparator a;

    eja(Comparator comparator)
    {
        a = comparator;
        super();
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (java.util.Map.Entry)obj;
        obj1 = (java.util.Map.Entry)obj1;
        return a.compare(((java.util.Map.Entry) (obj)).getKey(), ((java.util.Map.Entry) (obj1)).getKey());
    }
}
