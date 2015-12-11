// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Calendar;

// Referenced classes of package org.cybergarage.http:
//            HTTPResponse, HTTP

public class HTTPSocket
{

    private InputStream sockIn;
    private OutputStream sockOut;
    private Socket socket;

    public HTTPSocket(Socket socket1)
    {
        socket = null;
        sockIn = null;
        sockOut = null;
        setSocket(socket1);
        open();
    }

    public HTTPSocket(HTTPSocket httpsocket)
    {
        socket = null;
        sockIn = null;
        sockOut = null;
        setSocket(httpsocket.getSocket());
        setInputStream(httpsocket.getInputStream());
        setOutputStream(httpsocket.getOutputStream());
    }

    private OutputStream getOutputStream()
    {
        return sockOut;
    }

    private boolean post(HTTPResponse httpresponse, InputStream inputstream, long l, long l1, boolean flag)
    {
        int i;
        int j;
        long l2;
        httpresponse.setDate(Calendar.getInstance());
        OutputStream outputstream = getOutputStream();
        try
        {
            httpresponse.setContentLength(l1);
            outputstream.write(httpresponse.getHeader().getBytes());
            outputstream.write("\r\n".getBytes());
        }
        // Misplaced declaration of an exception variable
        catch (HTTPResponse httpresponse)
        {
            return false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        outputstream.flush();
        return true;
        flag = httpresponse.isChunked();
        if (0L >= l)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        inputstream.skip(l);
        j = HTTP.getChunkSize();
        httpresponse = new byte[j];
        l2 = 0L;
        if ((long)j < l1)
        {
            l = j;
        } else
        {
            l = l1;
        }
        i = inputstream.read(httpresponse, 0, (int)l);
        l = l2;
          goto _L1
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        outputstream.write("0".getBytes());
        outputstream.write("\r\n".getBytes());
        outputstream.flush();
        return true;
_L6:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        outputstream.write(Long.toHexString(i).getBytes());
        outputstream.write("\r\n".getBytes());
        outputstream.write(httpresponse, 0, i);
        if (!flag) goto _L3; else goto _L2
_L2:
        outputstream.write("\r\n".getBytes());
          goto _L3
_L4:
        i = inputstream.read(httpresponse, 0, (int)l);
        l = l2;
        continue; /* Loop/switch isn't completed */
_L8:
        l = l1 - l2;
          goto _L4
_L1:
        if (i > 0 && l < l1) goto _L6; else goto _L5
_L3:
        l2 = l + (long)i;
        if ((long)j >= l1 - l2) goto _L8; else goto _L7
_L7:
        l = j;
          goto _L4
    }

    private boolean post(HTTPResponse httpresponse, byte abyte0[], long l, long l1, boolean flag)
    {
        httpresponse.setDate(Calendar.getInstance());
        OutputStream outputstream = getOutputStream();
        try
        {
            httpresponse.setContentLength(l1);
            outputstream.write(httpresponse.getHeader().getBytes());
            outputstream.write("\r\n".getBytes());
        }
        // Misplaced declaration of an exception variable
        catch (HTTPResponse httpresponse)
        {
            return false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        outputstream.flush();
        return true;
        flag = httpresponse.isChunked();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        outputstream.write(Long.toHexString(l1).getBytes());
        outputstream.write("\r\n".getBytes());
        outputstream.write(abyte0, (int)l, (int)l1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        outputstream.write("\r\n".getBytes());
        outputstream.write("0".getBytes());
        outputstream.write("\r\n".getBytes());
        outputstream.flush();
        return true;
    }

    private void setInputStream(InputStream inputstream)
    {
        sockIn = inputstream;
    }

    private void setOutputStream(OutputStream outputstream)
    {
        sockOut = outputstream;
    }

    private void setSocket(Socket socket1)
    {
        socket = socket1;
    }

    public boolean close()
    {
        try
        {
            if (sockIn != null)
            {
                sockIn.close();
            }
            if (sockOut != null)
            {
                sockOut.close();
            }
            getSocket().close();
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }

    public void finalize()
    {
        close();
    }

    public InputStream getInputStream()
    {
        return sockIn;
    }

    public String getLocalAddress()
    {
        return getSocket().getLocalAddress().getHostAddress();
    }

    public int getLocalPort()
    {
        return getSocket().getLocalPort();
    }

    public Socket getSocket()
    {
        return socket;
    }

    public boolean open()
    {
        Socket socket1 = getSocket();
        try
        {
            sockIn = socket1.getInputStream();
            sockOut = socket1.getOutputStream();
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }

    public boolean post(HTTPResponse httpresponse, long l, long l1, boolean flag)
    {
        if (httpresponse.hasContentInputStream())
        {
            return post(httpresponse, httpresponse.getContentInputStream(), l, l1, flag);
        } else
        {
            return post(httpresponse, httpresponse.getContent(), l, l1, flag);
        }
    }
}
