// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            kt, gi, hm, lj, 
//            lk, kq

public final class hl
{

    public static final byte a[] = new byte[0];
    public static final String b[] = new String[0];
    public static final Charset c = Charset.forName("UTF-8");

    public static kt a(kt kt1)
    {
        try
        {
            kt1 = kt.a(MessageDigest.getInstance("SHA-1").digest(kt1.d()));
        }
        // Misplaced declaration of an exception variable
        catch (kt kt1)
        {
            throw new AssertionError(kt1);
        }
        return kt1;
    }

    public static String a(gi gi1)
    {
        if (gi1.h() != gi.a(gi1.c()))
        {
            return (new StringBuilder()).append(gi1.g()).append(":").append(gi1.h()).toString();
        } else
        {
            return gi1.g();
        }
    }

    public static List a(List list)
    {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static transient List a(Object aobj[])
    {
        return Collections.unmodifiableList(Arrays.asList((Object[])((Object []) (aobj)).clone()));
    }

    public static Map a(Map map)
    {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static ThreadFactory a(String s, boolean flag)
    {
        return new hm(s, flag);
    }

    public static void a(long l, long l1, long l2)
    {
        if ((0L | l2) < 0L || 0L > l || l < l2)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            return;
        }
    }

    public static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
        throw closeable;
        closeable;
    }

    public static void a(Closeable closeable, Closeable closeable1)
    {
        Object obj = null;
        closeable.close();
        closeable = obj;
_L4:
        closeable1.close();
        closeable1 = closeable;
_L2:
        if (closeable1 == null)
        {
            return;
        }
        break; /* Loop/switch isn't completed */
        Throwable throwable;
        throwable;
        closeable1 = closeable;
        if (closeable == null)
        {
            closeable1 = throwable;
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (closeable1 instanceof IOException)
        {
            throw (IOException)closeable1;
        }
        if (closeable1 instanceof RuntimeException)
        {
            throw (RuntimeException)closeable1;
        }
        if (closeable1 instanceof Error)
        {
            throw (Error)closeable1;
        } else
        {
            throw new AssertionError(closeable1);
        }
        closeable;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void a(Socket socket)
    {
        if (socket == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        socket.close();
_L1:
        return;
        socket;
        if (!a(((AssertionError) (socket))))
        {
            throw socket;
        }
          goto _L1
        socket;
        throw socket;
        socket;
    }

    public static boolean a(lj lj1, int i, TimeUnit timeunit)
    {
        long l;
        long l1;
        l1 = System.nanoTime();
        if (lj1.a().c_())
        {
            l = lj1.a().d_() - l1;
        } else
        {
            l = 0x7fffffffffffffffL;
        }
        lj1.a().a(Math.min(l, timeunit.toNanos(i)) + l1);
        try
        {
            for (timeunit = new kq(); lj1.a(timeunit, 2048L) != -1L; timeunit.n()) { }
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit)
        {
            if (l == 0x7fffffffffffffffL)
            {
                lj1.a().f();
            } else
            {
                lj1.a().a(l + l1);
            }
            return false;
        }
        finally
        {
            if (l != 0x7fffffffffffffffL) goto _L0; else goto _L0
        }
        if (l == 0x7fffffffffffffffL)
        {
            lj1.a().f();
        } else
        {
            lj1.a().a(l + l1);
        }
        return true;
        lj1.a().f();
_L2:
        throw timeunit;
        lj1.a().a(l + l1);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static boolean a(lj lj1, TimeUnit timeunit)
    {
        boolean flag;
        try
        {
            flag = a(lj1, 100, timeunit);
        }
        // Misplaced declaration of an exception variable
        catch (lj lj1)
        {
            return false;
        }
        return flag;
    }

    public static boolean a(AssertionError assertionerror)
    {
        return assertionerror.getCause() != null && assertionerror.getMessage() != null && assertionerror.getMessage().contains("getsockname failed");
    }

    public static boolean a(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static Object[] a(Class class1, Object aobj[], Object aobj1[])
    {
        ArrayList arraylist = new ArrayList();
        int k = aobj.length;
        int i = 0;
label0:
        do
        {
            if (i < k)
            {
                Object obj = aobj[i];
                int l = aobj1.length;
                int j = 0;
                do
                {
label1:
                    {
                        if (j < l)
                        {
                            Object obj1 = aobj1[j];
                            if (!obj.equals(obj1))
                            {
                                break label1;
                            }
                            arraylist.add(obj1);
                        }
                        i++;
                        continue label0;
                    }
                    j++;
                } while (true);
            }
            return arraylist.toArray((Object[])Array.newInstance(class1, arraylist.size()));
        } while (true);
    }

}
