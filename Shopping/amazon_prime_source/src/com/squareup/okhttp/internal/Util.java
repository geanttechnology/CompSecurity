// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.okio.ByteString;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Source;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class Util
{

    public static final byte EMPTY_BYTE_ARRAY[];
    public static final InputStream EMPTY_INPUT_STREAM;
    public static final String EMPTY_STRING_ARRAY[] = new String[0];
    public static final List HTTP2_AND_HTTP_11;
    public static final List HTTP2_SPDY3_AND_HTTP;
    public static final List SPDY3_AND_HTTP11;
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
        throws IOException
    {
        Object obj = null;
        closeable.close();
        closeable = obj;
_L1:
        closeable1.close();
        closeable1 = closeable;
_L2:
        if (closeable1 == null)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_39;
        closeable;
          goto _L1
        Throwable throwable;
        throwable;
        closeable1 = closeable;
        if (closeable == null)
        {
            closeable1 = throwable;
        }
          goto _L2
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

    public static Protocol getProtocol(ByteString bytestring)
        throws IOException
    {
        if (bytestring != null) goto _L2; else goto _L1
_L1:
        Protocol protocol = Protocol.HTTP_11;
_L4:
        return protocol;
_L2:
        Protocol aprotocol[] = Protocol.values();
        int j = aprotocol.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                Protocol protocol1 = aprotocol[i];
                protocol = protocol1;
                if (protocol1.name.equals(bytestring))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IOException((new StringBuilder()).append("Unexpected protocol: ").append(bytestring.utf8()).toString());
    }

    public static List immutableList(List list)
    {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static List immutableList(Object aobj[])
    {
        return Collections.unmodifiableList(Arrays.asList((Object[])((Object []) (aobj)).clone()));
    }

    public static boolean skipAll(Source source, int i)
        throws IOException
    {
        long l = System.nanoTime();
        OkBuffer okbuffer = new OkBuffer();
        for (; TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l) < (long)i; okbuffer.clear())
        {
            if (source.read(okbuffer, 2048L) == -1L)
            {
                return true;
            }
        }

        return false;
    }

    public static ThreadFactory threadFactory(String s, boolean flag)
    {
        return new ThreadFactory(s, flag) {

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

    static 
    {
        EMPTY_BYTE_ARRAY = new byte[0];
        EMPTY_INPUT_STREAM = new ByteArrayInputStream(EMPTY_BYTE_ARRAY);
        HTTP2_SPDY3_AND_HTTP = immutableList(Arrays.asList(new Protocol[] {
            Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_11
        }));
        SPDY3_AND_HTTP11 = immutableList(Arrays.asList(new Protocol[] {
            Protocol.SPDY_3, Protocol.HTTP_11
        }));
        HTTP2_AND_HTTP_11 = immutableList(Arrays.asList(new Protocol[] {
            Protocol.HTTP_2, Protocol.HTTP_11
        }));
    }
}
