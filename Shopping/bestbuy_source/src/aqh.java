// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;

final class aqh
{

    public final String a;
    public final Object b;

    aqh(String s, Object obj)
    {
        a = s;
        b = obj;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof aqh)
        {
            if (a.equals(((aqh) (obj = (aqh)obj)).a) && b.equals(((aqh) (obj)).b))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Integer[] {
            Integer.valueOf(a.hashCode()), Integer.valueOf(b.hashCode())
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append("Key: ").append(a).append(" value: ").append(b.toString()).toString();
    }
}
