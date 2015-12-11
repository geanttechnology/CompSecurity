// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            kq

public final class is
{
    public static interface a
    {

        public abstract void a(kq kq);
    }

    public static interface b
    {

        public abstract void a(Object obj);
    }


    public final Object a;
    public final z.a b;
    public final kq c;
    public boolean d;

    is(kq kq)
    {
        d = false;
        a = null;
        b = null;
        c = kq;
    }

    private is(Object obj, z.a a1)
    {
        d = false;
        a = obj;
        b = a1;
        c = null;
    }

    public static is a(Object obj, z.a a1)
    {
        return new is(obj, a1);
    }
}
