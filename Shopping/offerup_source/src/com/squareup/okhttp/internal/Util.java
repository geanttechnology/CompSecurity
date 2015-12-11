// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import d.ab;
import d.ac;
import d.f;
import d.k;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
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

public final class Util
{

    public static final byte EMPTY_BYTE_ARRAY[] = new byte[0];
    public static final String EMPTY_STRING_ARRAY[] = new String[0];
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private Util()
    {
    }

    public static void checkOffsetAndCount(long l, long l1, long l2)
    {
        if ((l1 | l2) < 0L || l1 > l || l - l1 < l2)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            return;
        }
    }

    public static void closeAll(Closeable closeable, Closeable closeable1)
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

    public static void closeQuietly(Closeable closeable)
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

    public static void closeQuietly(ServerSocket serversocket)
    {
        if (serversocket == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        serversocket.close();
        return;
        serversocket;
        throw serversocket;
        serversocket;
    }

    public static void closeQuietly(Socket socket)
    {
        if (socket == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        socket.close();
        return;
        socket;
        throw socket;
        socket;
    }

    public static boolean discard(ab ab1, int i, TimeUnit timeunit)
    {
        boolean flag;
        try
        {
            flag = skipAll(ab1, i, timeunit);
        }
        // Misplaced declaration of an exception variable
        catch (ab ab1)
        {
            return false;
        }
        return flag;
    }

    public static boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static int getDefaultPort(String s)
    {
        if ("http".equals(s))
        {
            return 80;
        }
        return !"https".equals(s) ? -1 : 443;
    }

    private static int getEffectivePort(String s, int i)
    {
        if (i != -1)
        {
            return i;
        } else
        {
            return getDefaultPort(s);
        }
    }

    public static int getEffectivePort(URI uri)
    {
        return getEffectivePort(uri.getScheme(), uri.getPort());
    }

    public static int getEffectivePort(URL url)
    {
        return getEffectivePort(url.getProtocol(), url.getPort());
    }

    public static List immutableList(List list)
    {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static transient List immutableList(Object aobj[])
    {
        return Collections.unmodifiableList(Arrays.asList((Object[])((Object []) (aobj)).clone()));
    }

    public static Map immutableMap(Map map)
    {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    private static List intersect(Object aobj[], Object aobj1[])
    {
        ArrayList arraylist = new ArrayList();
        int l = aobj.length;
        int i = 0;
label0:
        do
        {
            if (i < l)
            {
                Object obj = aobj[i];
                int i1 = aobj1.length;
                int j = 0;
                do
                {
label1:
                    {
                        if (j < i1)
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
            return arraylist;
        } while (true);
    }

    public static Object[] intersect(Class class1, Object aobj[], Object aobj1[])
    {
        aobj = intersect(aobj, aobj1);
        return ((List) (aobj)).toArray((Object[])Array.newInstance(class1, ((List) (aobj)).size()));
    }

    public static String md5Hex(String s)
    {
        s = k.a(MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"))).c();
        return s;
        s;
_L2:
        throw new AssertionError(s);
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static k sha1(k k1)
    {
        try
        {
            k1 = k.a(MessageDigest.getInstance("SHA-1").digest(k1.f()));
        }
        // Misplaced declaration of an exception variable
        catch (k k1)
        {
            throw new AssertionError(k1);
        }
        return k1;
    }

    public static String shaBase64(String s)
    {
        s = k.a(MessageDigest.getInstance("SHA-1").digest(s.getBytes("UTF-8"))).b();
        return s;
        s;
_L2:
        throw new AssertionError(s);
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static boolean skipAll(ab ab1, int i, TimeUnit timeunit)
    {
        long l;
        long l1;
        l1 = System.nanoTime();
        if (ab1.timeout().hasDeadline())
        {
            l = ab1.timeout().deadlineNanoTime() - l1;
        } else
        {
            l = 0x7fffffffffffffffL;
        }
        ab1.timeout().deadlineNanoTime(Math.min(l, timeunit.toNanos(i)) + l1);
        try
        {
            for (timeunit = new f(); ab1.read(timeunit, 2048L) != -1L; timeunit.q()) { }
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit)
        {
            if (l == 0x7fffffffffffffffL)
            {
                ab1.timeout().clearDeadline();
            } else
            {
                ab1.timeout().deadlineNanoTime(l + l1);
            }
            return false;
        }
        finally
        {
            if (l != 0x7fffffffffffffffL) goto _L0; else goto _L0
        }
        if (l == 0x7fffffffffffffffL)
        {
            ab1.timeout().clearDeadline();
        } else
        {
            ab1.timeout().deadlineNanoTime(l + l1);
        }
        return true;
        ab1.timeout().clearDeadline();
_L2:
        throw timeunit;
        ab1.timeout().deadlineNanoTime(l + l1);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static ThreadFactory threadFactory(final String name, final boolean daemon)
    {
        return new _cls1();
    }


    private class _cls1
        implements ThreadFactory
    {

        final boolean val$daemon;
        final String val$name;

        public final Thread newThread(Runnable runnable)
        {
            runnable = new Thread(runnable, name);
            runnable.setDaemon(daemon);
            return runnable;
        }

        _cls1()
        {
            name = s;
            daemon = flag;
            super();
        }
    }

}
