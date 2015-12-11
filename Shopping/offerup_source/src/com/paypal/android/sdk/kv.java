// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            lj, kq, lk

public abstract class kv
    implements lj
{

    private final lj a;

    public kv(lj lj1)
    {
        if (lj1 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            a = lj1;
            return;
        }
    }

    public long a(kq kq, long l)
    {
        return a.a(kq, l);
    }

    public final lk a()
    {
        return a.a();
    }

    public void close()
    {
        a.close();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(").append(a.toString()).append(")").toString();
    }
}
