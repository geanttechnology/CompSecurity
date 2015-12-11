// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;

import java.io.Serializable;

// Referenced classes of package com.google.a.a:
//            i, f, a

public abstract class e
    implements Serializable
{

    e()
    {
    }

    public static e b(Object obj)
    {
        return new i(f.a(obj));
    }

    public static e c(Object obj)
    {
        if (obj == null)
        {
            return e();
        } else
        {
            return new i(obj);
        }
    }

    public static e e()
    {
        return com.google.a.a.a.a();
    }

    public abstract Object a(Object obj);

    public abstract boolean b();

    public abstract Object c();

    public abstract Object d();

    public abstract String toString();
}
