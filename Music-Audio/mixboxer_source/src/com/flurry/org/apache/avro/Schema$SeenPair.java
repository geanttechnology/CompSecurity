// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;


// Referenced classes of package com.flurry.org.apache.avro:
//            Schema

private static class <init>
{

    private Object s1;
    private Object s2;

    public boolean equals(Object obj)
    {
        return s1 == ((s1)obj).s1 && s2 == ((s2)obj).s2;
    }

    public int hashCode()
    {
        return System.identityHashCode(s1) + System.identityHashCode(s2);
    }

    private (Object obj, Object obj1)
    {
        s1 = obj;
        s2 = obj1;
    }

    s2(Object obj, Object obj1, s2 s2_1)
    {
        this(obj, obj1);
    }
}
