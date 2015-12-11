// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.StringTokenizer;
import org.cybergarage.util.Debug;

// Referenced classes of package org.cybergarage.http:
//            HTTPPacket, HTTPSocket, ParameterList, Parameter, 
//            HTTPResponse, HTTP

public class HTTPRequest extends HTTPPacket
{

    private HTTPSocket httpSocket;
    private String method;
    private Socket postSocket;
    private String requestHost;
    private int requestPort;
    private String uri;

    public HTTPRequest()
    {
        method = null;
        uri = null;
        requestHost = "";
        requestPort = -1;
        httpSocket = null;
        postSocket = null;
        setVersion("1.0");
    }

    public HTTPRequest(InputStream inputstream)
    {
        super(inputstream);
        method = null;
        uri = null;
        requestHost = "";
        requestPort = -1;
        httpSocket = null;
        postSocket = null;
    }

    public HTTPRequest(HTTPSocket httpsocket)
    {
        this(httpsocket.getInputStream());
        setSocket(httpsocket);
    }

    public String getFirstLineString()
    {
        return (new StringBuilder(String.valueOf(getMethod()))).append(" ").append(getURI()).append(" ").append(getHTTPVersion()).append("\r\n").toString();
    }

    public String getHTTPVersion()
    {
        if (hasFirstLine())
        {
            return getFirstLineToken(2);
        } else
        {
            return (new StringBuilder("HTTP/")).append(super.getVersion()).toString();
        }
    }

    public String getHeader()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(getFirstLineString());
        stringbuffer.append(getHeaderString());
        return stringbuffer.toString();
    }

    public String getLocalAddress()
    {
        return getSocket().getLocalAddress();
    }

    public int getLocalPort()
    {
        return getSocket().getLocalPort();
    }

    public String getMethod()
    {
        if (method != null)
        {
            return method;
        } else
        {
            return getFirstLineToken(0);
        }
    }

    public ParameterList getParameterList()
    {
        ParameterList parameterlist;
        String s;
        parameterlist = new ParameterList();
        s = getURI();
        if (s != null) goto _L2; else goto _L1
_L1:
        int i;
        return parameterlist;
_L2:
        if ((i = s.indexOf('?')) >= 0)
        {
            while (i > 0) 
            {
                int k = s.indexOf('=', i + 1);
                String s1 = s.substring(i + 1, k);
                i = s.indexOf('&', k + 1);
                int j;
                if (i > 0)
                {
                    j = i;
                } else
                {
                    j = s.length();
                }
                parameterlist.add(new Parameter(s1, s.substring(k + 1, j)));
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public String getParameterValue(String s)
    {
        return getParameterList().getValue(s);
    }

    public String getRequestHost()
    {
        return requestHost;
    }

    public int getRequestPort()
    {
        return requestPort;
    }

    public HTTPSocket getSocket()
    {
        return httpSocket;
    }

    public String getURI()
    {
        if (uri != null)
        {
            return uri;
        } else
        {
            return getFirstLineToken(1);
        }
    }

    public boolean isGetRequest()
    {
        return isMethod("GET");
    }

    public boolean isHeadRequest()
    {
        return isMethod("HEAD");
    }

    public boolean isKeepAlive()
    {
        if (!isCloseConnection())
        {
            if (isKeepAliveConnection())
            {
                return true;
            }
            boolean flag;
            if (getHTTPVersion().indexOf("1.0") > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isMethod(String s)
    {
        String s1 = getMethod();
        if (s1 == null)
        {
            return false;
        } else
        {
            return s1.equalsIgnoreCase(s);
        }
    }

    public boolean isNotifyRequest()
    {
        return isMethod("NOTIFY");
    }

    public boolean isPostRequest()
    {
        return isMethod("POST");
    }

    public boolean isSOAPAction()
    {
        return hasHeader("SOAPACTION");
    }

    public boolean isSubscribeRequest()
    {
        return isMethod("SUBSCRIBE");
    }

    public boolean isUnsubscribeRequest()
    {
        return isMethod("UNSUBSCRIBE");
    }

    public boolean parseRequestLine(String s)
    {
        s = new StringTokenizer(s, " ");
        if (s.hasMoreTokens())
        {
            setMethod(s.nextToken());
            if (s.hasMoreTokens())
            {
                setURI(s.nextToken());
                if (s.hasMoreTokens())
                {
                    setVersion(s.nextToken());
                    return true;
                }
            }
        }
        return false;
    }

    public HTTPResponse post(String s, int i)
    {
        return post(s, i, false);
    }

    public HTTPResponse post(String s, int i, boolean flag)
    {
        String s1;
        InputStream inputstream;
        String s2;
        String s3;
        InputStream inputstream1;
        InputStream inputstream2;
        HTTPResponse httpresponse;
        httpresponse = new HTTPResponse();
        setHost(s);
        InputStream inputstream3;
        Object obj;
        Object obj1;
        PrintStream printstream;
        String s4;
        Object obj2;
        boolean flag1;
        boolean flag2;
        if (flag)
        {
            s1 = "Keep-Alive";
        } else
        {
            s1 = "close";
        }
        setConnection(s1);
        flag1 = isHeadRequest();
        s4 = null;
        obj2 = null;
        printstream = null;
        obj = null;
        obj1 = null;
        inputstream3 = null;
        inputstream1 = inputstream3;
        s2 = printstream;
        inputstream2 = obj;
        s3 = s4;
        inputstream = obj1;
        s1 = obj2;
        if (postSocket != null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        inputstream1 = inputstream3;
        s2 = printstream;
        inputstream2 = obj;
        s3 = s4;
        inputstream = obj1;
        s1 = obj2;
        postSocket = new Socket();
        inputstream1 = inputstream3;
        s2 = printstream;
        inputstream2 = obj;
        s3 = s4;
        inputstream = obj1;
        s1 = obj2;
        postSocket.connect(new InetSocketAddress(s, i), 0x13880);
        inputstream1 = inputstream3;
        s2 = printstream;
        inputstream2 = obj;
        s3 = s4;
        inputstream = obj1;
        s1 = obj2;
        s = postSocket.getOutputStream();
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        printstream = new PrintStream(s);
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        printstream.print(getHeader());
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        printstream.print("\r\n");
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        flag2 = isChunked();
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        s4 = getContentString();
        i = 0;
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_369;
        }
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        i = s4.length();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_498;
        }
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_437;
        }
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        printstream.print(Long.toHexString(i));
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        printstream.print("\r\n");
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        printstream.print(s4);
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_498;
        }
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        printstream.print("\r\n");
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_560;
        }
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        printstream.print("0");
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        printstream.print("\r\n");
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        printstream.flush();
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = obj;
        s3 = s;
        inputstream = obj1;
        s1 = s;
        inputstream3 = postSocket.getInputStream();
        inputstream1 = inputstream3;
        s2 = s;
        inputstream2 = inputstream3;
        s3 = s;
        inputstream = inputstream3;
        s1 = s;
        httpresponse.set(inputstream3, flag1);
        if (!flag)
        {
            Exception exception3;
            Exception exception4;
            try
            {
                inputstream3.close();
            }
            catch (Exception exception) { }
            if (inputstream3 != null)
            {
                try
                {
                    s.close();
                }
                catch (Exception exception1) { }
            }
            if (s != null)
            {
                try
                {
                    postSocket.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s) { }
            }
            postSocket = null;
        }
        return httpresponse;
        s;
        inputstream = inputstream1;
        s1 = s2;
        httpresponse.setStatusCode(500);
        inputstream = inputstream1;
        s1 = s2;
        Debug.warning(s);
        if (!flag)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            if (inputstream1 != null)
            {
                try
                {
                    s2.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s) { }
            }
            Exception exception2;
            if (s2 != null)
            {
                try
                {
                    postSocket.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s) { }
            }
            postSocket = null;
            return httpresponse;
        } else
        {
            break MISSING_BLOCK_LABEL_681;
        }
        s;
        inputstream = inputstream2;
        s1 = s3;
        httpresponse.setStatusCode(500);
        inputstream = inputstream2;
        s1 = s3;
        Debug.warning(s);
        if (!flag)
        {
            try
            {
                inputstream2.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            if (inputstream2 != null)
            {
                try
                {
                    s3.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s) { }
            }
            if (s3 != null)
            {
                try
                {
                    postSocket.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s) { }
            }
            postSocket = null;
            return httpresponse;
        } else
        {
            break MISSING_BLOCK_LABEL_681;
        }
        s;
        if (!flag)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception4) { }
            if (inputstream != null)
            {
                try
                {
                    s1.close();
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception3) { }
            }
            if (s1 != null)
            {
                try
                {
                    postSocket.close();
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception2) { }
            }
            postSocket = null;
        }
        throw s;
    }

    public boolean post(HTTPResponse httpresponse)
    {
        HTTPSocket httpsocket = getSocket();
        long l1 = 0L;
        long l2 = httpresponse.getContentLength();
        long l = l2;
        if (hasContentRange())
        {
            long l3 = getContentRangeFirstPosition();
            l1 = getContentRangeLastPosition();
            l = l1;
            if (l1 <= 0L)
            {
                l = l2 - 1L;
            }
            if (l3 > l2 || l > l2)
            {
                return returnResponse(416);
            }
            httpresponse.setContentRange(l3, l, l2);
            httpresponse.setStatusCode(206);
            l1 = l3;
            l = (l - l3) + 1L;
        }
        return httpsocket.post(httpresponse, l1, l, isHeadRequest());
    }

    public void print()
    {
        System.out.println(toString());
    }

    public boolean read()
    {
        return super.read(getSocket());
    }

    public boolean returnBadRequest()
    {
        return returnResponse(400);
    }

    public boolean returnOK()
    {
        return returnResponse(200);
    }

    public boolean returnResponse(int i)
    {
        HTTPResponse httpresponse = new HTTPResponse();
        httpresponse.setStatusCode(i);
        httpresponse.setContentLength(0L);
        return post(httpresponse);
    }

    public void set(HTTPRequest httprequest)
    {
        set(((HTTPPacket) (httprequest)));
        setSocket(httprequest.getSocket());
    }

    public void setMethod(String s)
    {
        method = s;
    }

    public void setRequestHost(String s)
    {
        requestHost = s;
    }

    public void setRequestPort(int i)
    {
        requestPort = i;
    }

    public void setSocket(HTTPSocket httpsocket)
    {
        httpSocket = httpsocket;
    }

    public void setURI(String s)
    {
        setURI(s, false);
    }

    public void setURI(String s, boolean flag)
    {
        uri = s;
        if (!flag)
        {
            return;
        } else
        {
            uri = HTTP.toRelativeURL(uri);
            return;
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(getHeader());
        stringbuffer.append("\r\n");
        stringbuffer.append(getContentString());
        return stringbuffer.toString();
    }
}
