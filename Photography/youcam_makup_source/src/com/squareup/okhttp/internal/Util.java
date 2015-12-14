// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.spdy.Header;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.d;
import okio.r;

public final class Util
{

    public static final byte EMPTY_BYTE_ARRAY[] = new byte[0];
    public static final String EMPTY_STRING_ARRAY[] = new String[0];
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
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

    public static void deleteContents(File file)
    {
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException((new StringBuilder()).append("not a readable directory: ").append(file).toString());
        }
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            file = afile[i];
            if (file.isDirectory())
            {
                deleteContents(file);
            }
            if (!file.delete())
            {
                throw new IOException((new StringBuilder()).append("failed to delete file: ").append(file).toString());
            }
        }

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

    public static String hash(String s)
    {
        try
        {
            s = ByteString.a(MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"))).c();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        return s;
    }

    public static transient List headerEntries(String as[])
    {
        ArrayList arraylist = new ArrayList(as.length / 2);
        for (int i = 0; i < as.length; i += 2)
        {
            arraylist.add(new Header(as[i], as[i + 1]));
        }

        return arraylist;
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

    public static List intersect(Collection collection, Collection collection1)
    {
        ArrayList arraylist = new ArrayList();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            Object obj = collection.next();
            if (collection1.contains(obj))
            {
                arraylist.add(obj);
            }
        } while (true);
        return Collections.unmodifiableList(arraylist);
    }

    public static ByteString sha1(ByteString bytestring)
    {
        try
        {
            bytestring = ByteString.a(MessageDigest.getInstance("SHA-1").digest(bytestring.f()));
        }
        // Misplaced declaration of an exception variable
        catch (ByteString bytestring)
        {
            throw new AssertionError(bytestring);
        }
        return bytestring;
    }

    public static boolean skipAll(r r1, int i)
    {
        long l = System.nanoTime();
        d d1 = new d();
        for (; TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l) < (long)i; d1.q())
        {
            if (r1.read(d1, 2048L) == -1L)
            {
                return true;
            }
        }

        return false;
    }

    public static ThreadFactory threadFactory(final String name, final boolean daemon)
    {
        return new ThreadFactory() {

            final boolean val$daemon;
            final String val$name;

            public Thread newThread(Runnable runnable)
            {
                runnable = new Thread(runnable, name);
                runnable.setDaemon(daemon);
                return runnable;
            }

            
            {
                name = s;
                daemon = flag;
                super();
            }
        };
    }

}
