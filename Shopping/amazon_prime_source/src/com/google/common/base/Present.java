// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            Optional

final class Present extends Optional
{

    private final Object reference;

    Present(Object obj)
    {
        reference = obj;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Present)
        {
            obj = (Present)obj;
            return reference.equals(((Present) (obj)).reference);
        } else
        {
            return false;
        }
    }

    public Object get()
    {
        return reference;
    }

    public int hashCode()
    {
        return 0x598df91c + reference.hashCode();
    }

    public boolean isPresent()
    {
        return true;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Optional.of(").append(reference).append(")").toString();
    }
}
