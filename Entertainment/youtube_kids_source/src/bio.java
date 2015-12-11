// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

final class bio extends SoftReference
{

    private final Object a;

    public bio(Object obj, Object obj1, ReferenceQueue referencequeue)
    {
        super(obj1, referencequeue);
        a = obj;
    }

    static Object a(bio bio1)
    {
        return bio1.a;
    }
}
