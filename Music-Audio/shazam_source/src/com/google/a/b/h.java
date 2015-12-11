// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.a.k;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.google.a.b:
//            i, g

final class h
{
    private static final class a extends AtomicLong
        implements g
    {

        public final void a()
        {
            getAndIncrement();
        }

        public final void a(long l)
        {
            getAndAdd(l);
        }

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }


    private static final k a;

    public static g a()
    {
        return (g)a.a();
    }

    static 
    {
        k k1;
        try
        {
            new i();
            k1 = new k() {

                public final Object a()
                {
                    return new i();
                }

            };
        }
        catch (Throwable throwable)
        {
            throwable = new k() {

                public final Object a()
                {
                    return new a((byte)0);
                }

            };
        }
        a = k1;
    }
}
