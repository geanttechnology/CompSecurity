// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class bji
{

    final WeakReference a;
    final Class b;
    final bjh c;
    final int d;
    private final int e;

    bji(Object obj, Class class1, Object obj1, bjh bjh1)
    {
        b.a(obj);
        b.a(obj1);
        a = new WeakReference(obj);
        b = (Class)b.a(class1);
        c = (bjh)b.a(bjh1);
        e = Arrays.hashCode(new Object[] {
            obj, b, obj1, c
        });
        d = obj1.hashCode();
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof bji)
            {
                if (a.get() != ((bji) (obj = (bji)obj)).a.get() || !b.equals(((bji) (obj)).b) || d != ((bji) (obj)).d || c != ((bji) (obj)).c)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return e;
    }
}
