// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.network;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.d;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.inmobi.commons.core.network:
//            NetworkRequest, c, NetworkError

class b
{

    private static final String a = com/inmobi/commons/core/network/b.getName();
    private NetworkRequest b;
    private HttpURLConnection c;

    public b(NetworkRequest networkrequest)
    {
        b = networkrequest;
    }

    private HttpURLConnection a(String s)
        throws IOException
    {
        s = (HttpURLConnection)(new URL(s)).openConnection();
        a(((HttpURLConnection) (s)));
        return s;
    }

    private void a(Closeable closeable)
        throws IOException
    {
        if (closeable != null)
        {
            closeable.close();
        }
    }

    private void a(HttpURLConnection httpurlconnection)
        throws ProtocolException
    {
        httpurlconnection.setConnectTimeout(b.n());
        httpurlconnection.setReadTimeout(b.o());
        httpurlconnection.setUseCaches(false);
        if (b.i() != null)
        {
            String s;
            for (Iterator iterator = b.i().keySet().iterator(); iterator.hasNext(); httpurlconnection.setRequestProperty(s, (String)b.i().get(s)))
            {
                s = (String)iterator.next();
            }

        }
        NetworkRequest.RequestType requesttype = b.m();
        httpurlconnection.setRequestMethod(requesttype.toString());
        if (requesttype != NetworkRequest.RequestType.GET)
        {
            httpurlconnection.setDoOutput(true);
            httpurlconnection.setDoInput(true);
        }
    }

    private String b()
    {
        String s1 = b.h();
        String s = s1;
        if (!s1.contains("?"))
        {
            s = (new StringBuilder()).append(s1).append("?").toString();
        }
        return (new StringBuilder()).append(s).append(b.j()).toString();
    }

    private void b(String s)
        throws IOException
    {
        c.setRequestProperty("Content-Length", Integer.toString(s.length()));
        c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
        bufferedwriter.write(s);
        a(bufferedwriter);
        return;
        s;
        bufferedwriter = null;
_L2:
        a(bufferedwriter);
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private c c()
    {
        Object obj1;
        Object obj2;
        c c1;
        c1 = new c(b);
        obj1 = null;
        obj2 = null;
        int i;
        i = c.getResponseCode();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append(b.h()).append("Response code: ").append(i).toString());
        if (i != 200) goto _L2; else goto _L1
_L1:
        if (!b.g() || (long)c.getContentLength() <= b.f()) goto _L4; else goto _L3
_L3:
        c1.a(new NetworkError(NetworkError.ErrorCode.RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT, "Response size greater than specified max response size"));
        Object obj = obj2;
_L14:
        NetworkError.ErrorCode errorcode;
        try
        {
            c.disconnect();
            a(((Closeable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            c1.a(new NetworkError(NetworkError.ErrorCode.HTTP_GATEWAY_TIMEOUT, NetworkError.ErrorCode.HTTP_GATEWAY_TIMEOUT.toString()));
            ((SocketTimeoutException) (obj)).printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            c1.a(new NetworkError(NetworkError.ErrorCode.NETWORK_IO_ERROR, NetworkError.ErrorCode.NETWORK_IO_ERROR.toString()));
            ((IOException) (obj)).printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            c1.a(new NetworkError(NetworkError.ErrorCode.OUT_OF_MEMORY_ERROR, NetworkError.ErrorCode.OUT_OF_MEMORY_ERROR.toString()));
            ((OutOfMemoryError) (obj)).printStackTrace();
        }
        if (!b.p()) goto _L6; else goto _L5
_L5:
        obj = b.e(c1.b());
        if (obj != null) goto _L8; else goto _L7
_L7:
        c1.a(new NetworkError(NetworkError.ErrorCode.INVALID_ENCRYPTED_RESPONSE_RECEIVED, "Unable to decrypt the server response."));
_L6:
        return c1;
_L4:
        obj = new BufferedReader(new InputStreamReader(c.getInputStream(), "UTF-8"));
        obj1 = new StringBuilder();
_L11:
        obj2 = ((BufferedReader) (obj)).readLine();
        if (obj2 == null) goto _L10; else goto _L9
_L9:
        ((StringBuilder) (obj1)).append(((String) (obj2))).append("\n");
          goto _L11
        obj2;
        obj1 = obj;
        obj = obj2;
_L12:
        c.disconnect();
        a(((Closeable) (obj1)));
        throw obj;
_L10:
        c1.a(((StringBuilder) (obj1)).toString());
        c1.a(c.getHeaderFields());
        continue; /* Loop/switch isn't completed */
_L2:
        errorcode = NetworkError.ErrorCode.fromValue(i);
        obj = errorcode;
        if (errorcode != null)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        obj = NetworkError.ErrorCode.UNKNOWN_ERROR;
        c1.a(new NetworkError(((NetworkError.ErrorCode) (obj)), (new StringBuilder()).append("HTTP:").append(i).toString()));
        c1.a(c.getHeaderFields());
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L12; else goto _L8
_L8:
        c1.a(((String) (obj)));
        return c1;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        illegalargumentexception.printStackTrace();
        c1.a(new NetworkError(NetworkError.ErrorCode.INVALID_ENCRYPTED_RESPONSE_RECEIVED, "Unable to decrypt the server response."));
        return c1;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public c a()
    {
        b.a();
        if (d.a())
        {
            Object obj;
            try
            {
                obj = b();
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Url: ").append(((String) (obj))).toString());
                c = a(((String) (obj)));
                if (!b.l())
                {
                    c.setInstanceFollowRedirects(false);
                }
                if (b.m() == NetworkRequest.RequestType.POST)
                {
                    b(b.k());
                }
                obj = c();
            }
            catch (IOException ioexception)
            {
                c c2 = new c(b);
                c2.a(new NetworkError(NetworkError.ErrorCode.NETWORK_IO_ERROR, ioexception.getLocalizedMessage()));
                ioexception.printStackTrace();
                return c2;
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                c c3 = new c(b);
                c3.a(new NetworkError(NetworkError.ErrorCode.HTTP_BAD_REQUEST, (new StringBuilder()).append("The URL is malformed:").append(NetworkError.ErrorCode.HTTP_BAD_REQUEST.toString()).toString()));
                illegalargumentexception.printStackTrace();
                return c3;
            }
            return ((c) (obj));
        } else
        {
            c c1 = new c(b);
            c1.a(new NetworkError(NetworkError.ErrorCode.NETWORK_UNAVAILABLE_ERROR, "Network unavailable."));
            return c1;
        }
    }

}
