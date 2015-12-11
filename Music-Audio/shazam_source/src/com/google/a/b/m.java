// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

abstract class m extends Number
{
    static final class a
    {

        private static final Unsafe b;
        private static final long c;
        volatile long a;

        final boolean a(long l, long l1)
        {
            return b.compareAndSwapLong(this, c, l, l1);
        }

        static 
        {
            try
            {
                b = m.c();
                c = b.objectFieldOffset(com/google/a/b/m$a.getDeclaredField("value"));
            }
            catch (Exception exception)
            {
                throw new Error(exception);
            }
        }

        a(long l)
        {
            a = l;
        }
    }


    static final ThreadLocal a = new ThreadLocal();
    static final Random b = new Random();
    static final int c = Runtime.getRuntime().availableProcessors();
    private static final Unsafe g;
    private static final long h;
    private static final long i;
    volatile transient a d[];
    volatile transient long e;
    volatile transient int f;

    m()
    {
    }

    private static Unsafe a()
    {
        Unsafe unsafe;
        try
        {
            unsafe = Unsafe.getUnsafe();
        }
        catch (SecurityException securityexception)
        {
            Unsafe unsafe1;
            try
            {
                unsafe1 = (Unsafe)AccessController.doPrivileged(new PrivilegedExceptionAction() {

                    public final Object run()
                    {
                        Field afield[] = sun/misc/Unsafe.getDeclaredFields();
                        int k = afield.length;
                        for (int j = 0; j < k; j++)
                        {
                            Object obj = afield[j];
                            ((Field) (obj)).setAccessible(true);
                            obj = ((Field) (obj)).get(null);
                            if (sun/misc/Unsafe.isInstance(obj))
                            {
                                return (Unsafe)sun/misc/Unsafe.cast(obj);
                            }
                        }

                        throw new NoSuchFieldError("the Unsafe");
                    }

                });
            }
            catch (PrivilegedActionException privilegedactionexception)
            {
                throw new RuntimeException("Could not initialize intrinsics", privilegedactionexception.getCause());
            }
            return unsafe1;
        }
        return unsafe;
    }

    static Unsafe c()
    {
        return a();
    }

    abstract long a(long l, long l1);

    final boolean b()
    {
        return g.compareAndSwapInt(this, i, 0, 1);
    }

    final boolean b(long l, long l1)
    {
        return g.compareAndSwapLong(this, h, l, l1);
    }

    static 
    {
        try
        {
            g = a();
            h = g.objectFieldOffset(com/google/a/b/m.getDeclaredField("base"));
            i = g.objectFieldOffset(com/google/a/b/m.getDeclaredField("busy"));
        }
        catch (Exception exception)
        {
            throw new Error(exception);
        }
    }
}
