// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;


// Referenced classes of package com.google.inject.spi:
//            InjectionPoint

static class b
{

    final Object a;
    final Object b;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (b)obj;
            if (!a.equals(((a) (obj)).a) || !b.equals(((b) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return a.hashCode() * 31 + b.hashCode();
    }

    public (Object obj, Object obj1)
    {
        a = obj;
        b = obj1;
    }
}
