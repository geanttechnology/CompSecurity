// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;


// Referenced classes of package com.aviary.android.feather.common.utils:
//            Objects

public class Trio
{

    public final Object first;
    public final Object second;
    public final Object third;

    public Trio(Object obj, Object obj1, Object obj2)
    {
        first = obj;
        second = obj1;
        third = obj2;
    }

    public static Trio create(Object obj, Object obj1, Object obj2)
    {
        return new Trio(obj, obj1, obj2);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Trio)
        {
            if (Objects.equal(first, ((Trio) (obj = (Trio)obj)).first) && Objects.equal(second, ((Trio) (obj)).second) && Objects.equal(third, ((Trio) (obj)).third))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (first == null)
        {
            i = 0;
        } else
        {
            i = first.hashCode();
        }
        if (second == null)
        {
            j = 0;
        } else
        {
            j = second.hashCode();
        }
        if (third != null)
        {
            k = third.hashCode();
        }
        return i ^ j ^ k;
    }
}
