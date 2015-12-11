// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class bmy extends WeakReference
{

    private final int a;

    public bmy(Object obj)
    {
        super(obj);
        a = obj.hashCode();
    }

    public final boolean equals(Object obj)
    {
        Object obj1 = get();
        if (obj1 != null && (obj instanceof Reference))
        {
            return obj1.equals(((Reference)obj).get());
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return a;
    }
}
