// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Predicate;
import com.google.android.exoplayer.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            HttpDataSource, DataSpec, TransferListener

public class DefaultHttpDataSource
    implements HttpDataSource
{

    private static final Pattern CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "HttpDataSource";
    private static final AtomicReference skipBufferReference = new AtomicReference();
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesSkipped;
    private long bytesToRead;
    private long bytesToSkip;
    private final int connectTimeoutMillis;
    private HttpURLConnection connection;
    private final Predicate contentTypePredicate;
    private DataSpec dataSpec;
    private InputStream inputStream;
    private final TransferListener listener;
    private boolean opened;
    private final int readTimeoutMillis;
    private final HashMap requestProperties;
    private final String userAgent;

    public DefaultHttpDataSource(String s, Predicate predicate)
    {
        this(s, predicate, null);
    }

    public DefaultHttpDataSource(String s, Predicate predicate, TransferListener transferlistener)
    {
        this(s, predicate, transferlistener, 8000, 8000);
    }

    public DefaultHttpDataSource(String s, Predicate predicate, TransferListener transferlistener, int i, int j)
    {
        this(s, predicate, transferlistener, i, j, false);
    }

    public DefaultHttpDataSource(String s, Predicate predicate, TransferListener transferlistener, int i, int j, boolean flag)
    {
        userAgent = Assertions.checkNotEmpty(s);
        contentTypePredicate = predicate;
        listener = transferlistener;
        requestProperties = new HashMap();
        connectTimeoutMillis = i;
        readTimeoutMillis = j;
        allowCrossProtocolRedirects = flag;
    }

    private void closeConnection()
    {
        if (connection != null)
        {
            connection.disconnect();
            connection = null;
        }
    }

    private static long getContentLength(HttpURLConnection httpurlconnection)
    {
        String s;
        long l;
        long l1;
        l1 = -1L;
        s = httpurlconnection.getHeaderField("Content-Length");
        l = l1;
        Matcher matcher;
        long l2;
        if (!TextUtils.isEmpty(s))
        {
            try
            {
                l = Long.parseLong(s);
            }
            catch (NumberFormatException numberformatexception1)
            {
                Log.e("HttpDataSource", (new StringBuilder()).append("Unexpected Content-Length [").append(s).append("]").toString());
                l = l1;
            }
        }
        httpurlconnection = httpurlconnection.getHeaderField("Content-Range");
        l1 = l;
        if (TextUtils.isEmpty(httpurlconnection)) goto _L2; else goto _L1
_L1:
        matcher = CONTENT_RANGE_HEADER.matcher(httpurlconnection);
        l1 = l;
        if (!matcher.find()) goto _L2; else goto _L3
_L3:
        long l3;
        try
        {
            l1 = Long.parseLong(matcher.group(2));
            l2 = Long.parseLong(matcher.group(1));
        }
        catch (NumberFormatException numberformatexception)
        {
            Log.e("HttpDataSource", (new StringBuilder()).append("Unexpected Content-Range [").append(httpurlconnection).append("]").toString());
            return l;
        }
        l3 = (l1 - l2) + 1L;
        if (l >= 0L) goto _L5; else goto _L4
_L4:
        l1 = l3;
_L2:
        return l1;
_L5:
        l1 = l;
        if (l == l3) goto _L2; else goto _L6
_L6:
        Log.w("HttpDataSource", (new StringBuilder()).append("Inconsistent headers [").append(s).append("] [").append(httpurlconnection).append("]").toString());
        l1 = Math.max(l, l3);
        return l1;
    }

    private static URL handleRedirect(URL url, String s)
        throws IOException
    {
        if (s == null)
        {
            throw new ProtocolException("Null location redirect");
        }
        url = new URL(url, s);
        s = url.getProtocol();
        if (!"https".equals(s) && !"http".equals(s))
        {
            throw new ProtocolException((new StringBuilder()).append("Unsupported protocol redirect: ").append(s).toString());
        } else
        {
            return url;
        }
    }

    private HttpURLConnection makeConnection(DataSpec dataspec)
        throws IOException
    {
        byte abyte0[];
        Object obj;
        long l;
        long l1;
        boolean flag;
        obj = new URL(dataspec.uri.toString());
        abyte0 = dataspec.postBody;
        l = dataspec.position;
        l1 = dataspec.length;
        if ((dataspec.flags & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (allowCrossProtocolRedirects) goto _L2; else goto _L1
_L1:
        obj = makeConnection(((URL) (obj)), abyte0, l, l1, flag, true);
_L4:
        return ((HttpURLConnection) (obj));
_L2:
        int i;
        i = 0;
        dataspec = ((DataSpec) (obj));
_L6:
        HttpURLConnection httpurlconnection;
        int j;
        j = i + 1;
        if (i > 20)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        httpurlconnection = makeConnection(((URL) (dataspec)), abyte0, l, l1, flag, false);
        i = httpurlconnection.getResponseCode();
        if (i == 300 || i == 301 || i == 302 || i == 303)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = httpurlconnection;
        if (abyte0 != null) goto _L4; else goto _L3
_L3:
        if (i == 307)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = httpurlconnection;
        if (i != 308) goto _L4; else goto _L5
_L5:
        abyte0 = null;
        String s = httpurlconnection.getHeaderField("Location");
        httpurlconnection.disconnect();
        dataspec = handleRedirect(dataspec, s);
        i = j;
          goto _L6
        throw new NoRouteToHostException((new StringBuilder()).append("Too many redirects: ").append(j).toString());
    }

    private HttpURLConnection makeConnection(URL url, byte abyte0[], long l, long l1, boolean flag, 
            boolean flag1)
        throws IOException
    {
        HttpURLConnection httpurlconnection;
        httpurlconnection = (HttpURLConnection)url.openConnection();
        httpurlconnection.setConnectTimeout(connectTimeoutMillis);
        httpurlconnection.setReadTimeout(readTimeoutMillis);
        url = requestProperties;
        url;
        JVM INSTR monitorenter ;
        java.util.Map.Entry entry;
        for (Iterator iterator = requestProperties.entrySet().iterator(); iterator.hasNext(); httpurlconnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break MISSING_BLOCK_LABEL_103;
        abyte0;
        url;
        JVM INSTR monitorexit ;
        throw abyte0;
        url;
        JVM INSTR monitorexit ;
        if (l != 0L || l1 != -1L)
        {
            String s = (new StringBuilder()).append("bytes=").append(l).append("-").toString();
            url = s;
            if (l1 != -1L)
            {
                url = (new StringBuilder()).append(s).append((l + l1) - 1L).toString();
            }
            httpurlconnection.setRequestProperty("Range", url);
        }
        httpurlconnection.setRequestProperty("User-Agent", userAgent);
        if (!flag)
        {
            httpurlconnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpurlconnection.setInstanceFollowRedirects(flag1);
        if (abyte0 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        httpurlconnection.setDoOutput(flag);
        if (abyte0 != null)
        {
            httpurlconnection.setFixedLengthStreamingMode(abyte0.length);
            httpurlconnection.connect();
            url = httpurlconnection.getOutputStream();
            url.write(abyte0);
            url.close();
            return httpurlconnection;
        } else
        {
            httpurlconnection.connect();
            return httpurlconnection;
        }
    }

    private int readInternal(byte abyte0[], int i, int j)
        throws IOException
    {
        if (bytesToRead != -1L)
        {
            j = (int)Math.min(j, bytesToRead - bytesRead);
        }
        if (j == 0)
        {
            i = -1;
        } else
        {
            j = inputStream.read(abyte0, i, j);
            if (j == -1)
            {
                if (bytesToRead != -1L && bytesToRead != bytesRead)
                {
                    throw new EOFException();
                } else
                {
                    return -1;
                }
            }
            bytesRead = bytesRead + (long)j;
            i = j;
            if (listener != null)
            {
                listener.onBytesTransferred(j);
                return j;
            }
        }
        return i;
    }

    private void skipInternal()
        throws IOException
    {
        if (bytesSkipped == bytesToSkip)
        {
            return;
        }
        byte abyte1[] = (byte[])skipBufferReference.getAndSet(null);
        byte abyte0[] = abyte1;
        if (abyte1 == null)
        {
            abyte0 = new byte[4096];
        }
        do
        {
            if (bytesSkipped == bytesToSkip)
            {
                break;
            }
            int i = (int)Math.min(bytesToSkip - bytesSkipped, abyte0.length);
            i = inputStream.read(abyte0, 0, i);
            if (Thread.interrupted())
            {
                throw new InterruptedIOException();
            }
            if (i == -1)
            {
                throw new EOFException();
            }
            bytesSkipped = bytesSkipped + (long)i;
            if (listener != null)
            {
                listener.onBytesTransferred(i);
            }
        } while (true);
        skipBufferReference.set(abyte0);
    }

    protected final long bytesRead()
    {
        return bytesRead;
    }

    protected final long bytesRemaining()
    {
        if (bytesToRead == -1L)
        {
            return bytesToRead;
        } else
        {
            return bytesToRead - bytesRead;
        }
    }

    protected final long bytesSkipped()
    {
        return bytesSkipped;
    }

    public void clearAllRequestProperties()
    {
        synchronized (requestProperties)
        {
            requestProperties.clear();
        }
        return;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clearRequestProperty(String s)
    {
        Assertions.checkNotNull(s);
        synchronized (requestProperties)
        {
            requestProperties.remove(s);
        }
        return;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void close()
        throws HttpDataSource.HttpDataSourceException
    {
        if (inputStream == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        Util.maybeTerminateInputStream(connection, bytesRemaining());
        inputStream.close();
        inputStream = null;
        closeConnection();
        if (opened)
        {
            opened = false;
            if (listener != null)
            {
                listener.onTransferEnd();
            }
        }
        return;
        Object obj;
        obj;
        throw new HttpDataSource.HttpDataSourceException(((IOException) (obj)), dataSpec);
        obj;
        inputStream = null;
        closeConnection();
        if (opened)
        {
            opened = false;
            if (listener != null)
            {
                listener.onTransferEnd();
            }
        }
        throw obj;
    }

    protected final HttpURLConnection getConnection()
    {
        return connection;
    }

    public Map getResponseHeaders()
    {
        if (connection == null)
        {
            return null;
        } else
        {
            return connection.getHeaderFields();
        }
    }

    public String getUri()
    {
        if (connection == null)
        {
            return null;
        } else
        {
            return connection.getURL().toString();
        }
    }

    public long open(DataSpec dataspec)
        throws HttpDataSource.HttpDataSourceException
    {
        long l2 = 0L;
        dataSpec = dataspec;
        bytesRead = 0L;
        bytesSkipped = 0L;
        int i;
        try
        {
            connection = makeConnection(dataspec);
        }
        catch (IOException ioexception)
        {
            throw new HttpDataSource.HttpDataSourceException((new StringBuilder()).append("Unable to connect to ").append(dataspec.uri.toString()).toString(), ioexception, dataspec);
        }
        try
        {
            i = connection.getResponseCode();
        }
        catch (IOException ioexception1)
        {
            closeConnection();
            throw new HttpDataSource.HttpDataSourceException((new StringBuilder()).append("Unable to connect to ").append(dataspec.uri.toString()).toString(), ioexception1, dataspec);
        }
        if (i < 200 || i > 299)
        {
            Map map = connection.getHeaderFields();
            closeConnection();
            throw new HttpDataSource.InvalidResponseCodeException(i, map, dataspec);
        }
        String s = connection.getContentType();
        if (contentTypePredicate != null && !contentTypePredicate.evaluate(s))
        {
            closeConnection();
            throw new HttpDataSource.InvalidContentTypeException(s, dataspec);
        }
        long l = l2;
        if (i == 200)
        {
            l = l2;
            if (dataspec.position != 0L)
            {
                l = dataspec.position;
            }
        }
        bytesToSkip = l;
        if ((dataspec.flags & 1) == 0)
        {
            long l1 = getContentLength(connection);
            if (dataspec.length != -1L)
            {
                l1 = dataspec.length;
            } else
            if (l1 != -1L)
            {
                l1 -= bytesToSkip;
            } else
            {
                l1 = -1L;
            }
            bytesToRead = l1;
        } else
        {
            bytesToRead = dataspec.length;
        }
        try
        {
            inputStream = connection.getInputStream();
        }
        catch (IOException ioexception2)
        {
            closeConnection();
            throw new HttpDataSource.HttpDataSourceException(ioexception2, dataspec);
        }
        opened = true;
        if (listener != null)
        {
            listener.onTransferStart();
        }
        return bytesToRead;
    }

    public int read(byte abyte0[], int i, int j)
        throws HttpDataSource.HttpDataSourceException
    {
        try
        {
            skipInternal();
            i = readInternal(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new HttpDataSource.HttpDataSourceException(abyte0, dataSpec);
        }
        return i;
    }

    public void setRequestProperty(String s, String s1)
    {
        Assertions.checkNotNull(s);
        Assertions.checkNotNull(s1);
        synchronized (requestProperties)
        {
            requestProperties.put(s, s1);
        }
        return;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

}
