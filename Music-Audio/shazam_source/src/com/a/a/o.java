// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;


// Referenced classes of package com.a.a:
//            t

public final class o
{
    public static interface a
    {

        public abstract void onErrorResponse(t t);
    }

    public static interface b
    {

        public abstract void onResponse(Object obj);
    }


    public final Object a;
    public final b.a b;
    public final t c;
    public boolean d;

    private o(t t)
    {
        d = false;
        a = null;
        b = null;
        c = t;
    }

    public o(Object obj, b.a a1)
    {
        d = false;
        a = obj;
        b = a1;
        c = null;
    }

    public static o a(t t)
    {
        return new o(t);
    }
}
