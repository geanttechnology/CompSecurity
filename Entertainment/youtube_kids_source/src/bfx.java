// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

public final class bfx
{

    public final List a;

    public bfx(List list)
    {
        a = a.a((List)b.a(list));
    }

    public final boolean equals(Object obj)
    {
        if (obj == null || !getClass().equals(obj.getClass()))
        {
            return false;
        } else
        {
            obj = (bfx)obj;
            return a.equals(((bfx) (obj)).a);
        }
    }
}
