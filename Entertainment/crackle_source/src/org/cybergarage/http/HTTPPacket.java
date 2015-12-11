// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;
import org.cybergarage.net.HostInterface;
import org.cybergarage.util.Debug;
import org.cybergarage.util.StringUtil;

// Referenced classes of package org.cybergarage.http:
//            HTTPHeader, HTTPStatus, HTTP, HTTPSocket, 
//            Date

public class HTTPPacket
{

    private byte content[];
    private InputStream contentInput;
    private String firstLine;
    private Vector httpHeaderList;
    private String version;

    public HTTPPacket()
    {
        firstLine = "";
        httpHeaderList = new Vector();
        content = new byte[0];
        contentInput = null;
        setVersion("1.1");
        setContentInputStream(null);
    }

    public HTTPPacket(InputStream inputstream)
    {
        firstLine = "";
        httpHeaderList = new Vector();
        content = new byte[0];
        contentInput = null;
        setVersion("1.1");
        set(inputstream);
        setContentInputStream(null);
    }

    public HTTPPacket(HTTPPacket httppacket)
    {
        firstLine = "";
        httpHeaderList = new Vector();
        content = new byte[0];
        contentInput = null;
        setVersion("1.1");
        set(httppacket);
        setContentInputStream(null);
    }

    private String readLine(BufferedInputStream bufferedinputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1];
        int i;
        try
        {
            i = bufferedinputstream.read(abyte0);
            break MISSING_BLOCK_LABEL_19;
        }
        // Misplaced declaration of an exception variable
        catch (BufferedInputStream bufferedinputstream) { }
        // Misplaced declaration of an exception variable
        catch (BufferedInputStream bufferedinputstream)
        {
            Debug.warning(bufferedinputstream);
        }
_L2:
        return bytearrayoutputstream.toString();
_L3:
        if (i <= 0 || abyte0[0] == 10) goto _L2; else goto _L1
_L1:
        if (abyte0[0] == 13)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        bytearrayoutputstream.write(abyte0[0]);
        i = bufferedinputstream.read(abyte0);
          goto _L3
    }

    private void setFirstLine(String s)
    {
        firstLine = s;
    }

    public void addHeader(String s, String s1)
    {
        s = new HTTPHeader(s, s1);
        httpHeaderList.add(s);
    }

    public void addHeader(HTTPHeader httpheader)
    {
        httpHeaderList.add(httpheader);
    }

    public void clearHeaders()
    {
        httpHeaderList.clear();
        httpHeaderList = new Vector();
    }

    public String getCacheControl()
    {
        return getHeaderValue("Cache-Control");
    }

    public String getCharSet()
    {
        String s = getContentType();
        String s1;
        if (s == null)
        {
            s1 = "";
        } else
        {
            s = s.toLowerCase();
            int i = s.indexOf("charset");
            if (i < 0)
            {
                return "";
            }
            i = "charset".length() + i + 1;
            s1 = new String(s.getBytes(), i, s.length() - i);
            if (s1.length() < 0)
            {
                return "";
            }
            s = s1;
            if (s1.charAt(0) == '"')
            {
                s = s1.substring(1, s1.length() - 1);
            }
            if (s.length() < 0)
            {
                return "";
            }
            s1 = s;
            if (s.charAt(s.length() - 1) == '"')
            {
                return s.substring(0, s.length() - 1);
            }
        }
        return s1;
    }

    public String getConnection()
    {
        return getHeaderValue("Connection");
    }

    public byte[] getContent()
    {
        return content;
    }

    public InputStream getContentInputStream()
    {
        return contentInput;
    }

    public long getContentLength()
    {
        return getLongHeaderValue("Content-Length");
    }

    public long[] getContentRange()
    {
        long al[] = new long[3];
        al[2] = 0L;
        al[1] = 0L;
        al[0] = 0L;
        if (hasContentRange())
        {
            String s = getHeaderValue("Content-Range");
            Object obj = s;
            if (s.length() <= 0)
            {
                obj = getHeaderValue("Range");
            }
            if (((String) (obj)).length() > 0)
            {
                obj = new StringTokenizer(((String) (obj)), " =");
                if (((StringTokenizer) (obj)).hasMoreTokens())
                {
                    ((StringTokenizer) (obj)).nextToken(" ");
                    if (((StringTokenizer) (obj)).hasMoreTokens())
                    {
                        String s1 = ((StringTokenizer) (obj)).nextToken(" -");
                        try
                        {
                            al[0] = Long.parseLong(s1);
                        }
                        catch (NumberFormatException numberformatexception2) { }
                        if (((StringTokenizer) (obj)).hasMoreTokens())
                        {
                            String s2 = ((StringTokenizer) (obj)).nextToken("-/");
                            try
                            {
                                al[1] = Long.parseLong(s2);
                            }
                            catch (NumberFormatException numberformatexception1) { }
                            if (((StringTokenizer) (obj)).hasMoreTokens())
                            {
                                obj = ((StringTokenizer) (obj)).nextToken("/");
                                try
                                {
                                    al[2] = Long.parseLong(((String) (obj)));
                                }
                                catch (NumberFormatException numberformatexception)
                                {
                                    return al;
                                }
                                return al;
                            }
                        }
                    }
                }
            }
        }
        return al;
    }

    public long getContentRangeFirstPosition()
    {
        return getContentRange()[0];
    }

    public long getContentRangeInstanceLength()
    {
        return getContentRange()[2];
    }

    public long getContentRangeLastPosition()
    {
        return getContentRange()[1];
    }

    public String getContentString()
    {
        String s = getCharSet();
        if (s == null || s.length() <= 0)
        {
            return new String(content);
        }
        try
        {
            s = new String(content, s);
        }
        catch (Exception exception)
        {
            Debug.warning(exception);
            return new String(content);
        }
        return s;
    }

    public String getContentType()
    {
        return getHeaderValue("Content-Type");
    }

    public String getDate()
    {
        return getHeaderValue("Date");
    }

    protected String getFirstLine()
    {
        return firstLine;
    }

    protected String getFirstLineToken(int i)
    {
        StringTokenizer stringtokenizer = new StringTokenizer(firstLine, " ");
        String s = "";
        int j = 0;
        do
        {
            if (j > i)
            {
                return s;
            }
            if (!stringtokenizer.hasMoreTokens())
            {
                return "";
            }
            s = stringtokenizer.nextToken();
            j++;
        } while (true);
    }

    public HTTPHeader getHeader(int i)
    {
        return (HTTPHeader)httpHeaderList.get(i);
    }

    public HTTPHeader getHeader(String s)
    {
        int i;
        int j;
        j = getNHeaders();
        i = 0;
_L6:
        if (i < j) goto _L2; else goto _L1
_L1:
        HTTPHeader httpheader = null;
_L4:
        return httpheader;
_L2:
        HTTPHeader httpheader1;
        httpheader1 = getHeader(i);
        httpheader = httpheader1;
        if (httpheader1.getName().equalsIgnoreCase(s)) goto _L4; else goto _L3
_L3:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String getHeaderString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        int j = getNHeaders();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return stringbuffer.toString();
            }
            HTTPHeader httpheader = getHeader(i);
            stringbuffer.append((new StringBuilder(String.valueOf(httpheader.getName()))).append(": ").append(httpheader.getValue()).append("\r\n").toString());
            i++;
        } while (true);
    }

    public String getHeaderValue(String s)
    {
        s = getHeader(s);
        if (s == null)
        {
            return "";
        } else
        {
            return s.getValue();
        }
    }

    public String getHost()
    {
        return getHeaderValue("HOST");
    }

    public int getIntegerHeaderValue(String s)
    {
        s = getHeader(s);
        if (s == null)
        {
            return 0;
        } else
        {
            return StringUtil.toInteger(s.getValue());
        }
    }

    public long getLongHeaderValue(String s)
    {
        s = getHeader(s);
        if (s == null)
        {
            return 0L;
        } else
        {
            return StringUtil.toLong(s.getValue());
        }
    }

    public int getNHeaders()
    {
        return httpHeaderList.size();
    }

    public String getServer()
    {
        return getHeaderValue("Server");
    }

    public String getStringHeaderValue(String s)
    {
        return getStringHeaderValue(s, "\"", "\"");
    }

    public String getStringHeaderValue(String s, String s1, String s2)
    {
        String s3 = getHeaderValue(s);
        s = s3;
        if (s3.startsWith(s1))
        {
            s = s3.substring(1, s3.length());
        }
        s1 = s;
        if (s.endsWith(s2))
        {
            s1 = s.substring(0, s.length() - 1);
        }
        return s1;
    }

    public String getTransferEncoding()
    {
        return getHeaderValue("Transfer-Encoding");
    }

    public String getVersion()
    {
        return version;
    }

    public boolean hasConnection()
    {
        return hasHeader("Connection");
    }

    public boolean hasContent()
    {
        return content.length > 0;
    }

    public boolean hasContentInputStream()
    {
        return contentInput != null;
    }

    public boolean hasContentRange()
    {
        return hasHeader("Content-Range") || hasHeader("Range");
    }

    public boolean hasFirstLine()
    {
        return firstLine.length() > 0;
    }

    public boolean hasHeader(String s)
    {
        return getHeader(s) != null;
    }

    public boolean hasTransferEncoding()
    {
        return hasHeader("Transfer-Encoding");
    }

    public void init()
    {
        setFirstLine("");
        clearHeaders();
        setContent(new byte[0], false);
        setContentInputStream(null);
    }

    public boolean isChunked()
    {
        String s;
        if (hasTransferEncoding())
        {
            if ((s = getTransferEncoding()) != null)
            {
                return s.equalsIgnoreCase("Chunked");
            }
        }
        return false;
    }

    public boolean isCloseConnection()
    {
        String s;
        if (hasConnection())
        {
            if ((s = getConnection()) != null)
            {
                return s.equalsIgnoreCase("close");
            }
        }
        return false;
    }

    public boolean isKeepAliveConnection()
    {
        String s;
        if (hasConnection())
        {
            if ((s = getConnection()) != null)
            {
                return s.equalsIgnoreCase("Keep-Alive");
            }
        }
        return false;
    }

    public boolean read(HTTPSocket httpsocket)
    {
        init();
        return set(httpsocket);
    }

    protected void set(HTTPPacket httppacket)
    {
        setFirstLine(httppacket.getFirstLine());
        clearHeaders();
        int j = httppacket.getNHeaders();
        int i = 0;
        do
        {
            if (i >= j)
            {
                setContent(httppacket.getContent());
                return;
            }
            addHeader(httppacket.getHeader(i));
            i++;
        } while (true);
    }

    protected boolean set(InputStream inputstream)
    {
        return set(inputstream, false);
    }

    protected boolean set(InputStream inputstream, boolean flag)
    {
        BufferedInputStream bufferedinputstream;
        byte abyte0[];
        Exception exception;
        int i;
        int j;
        long l;
        long l1;
        long l2;
        long l3;
        try
        {
            bufferedinputstream = new BufferedInputStream(inputstream);
            inputstream = readLine(bufferedinputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            Debug.warning(inputstream);
            return false;
        }
        if (inputstream == null) goto _L2; else goto _L1
_L1:
        if (inputstream.length() > 0) goto _L3; else goto _L2
_L3:
        setFirstLine(inputstream);
        if ((new HTTPStatus(inputstream)).getStatusCode() != 100) goto _L5; else goto _L4
_L4:
        inputstream = readLine(bufferedinputstream);
_L17:
        if (inputstream == null) goto _L7; else goto _L6
_L6:
        if (inputstream.length() > 0) goto _L8; else goto _L7
_L7:
        inputstream = readLine(bufferedinputstream);
        if (inputstream == null) goto _L10; else goto _L9
_L9:
        if (inputstream.length() <= 0) goto _L10; else goto _L11
_L11:
        setFirstLine(inputstream);
_L5:
        inputstream = readLine(bufferedinputstream);
_L18:
        if (inputstream == null) goto _L13; else goto _L12
_L12:
        if (inputstream.length() > 0) goto _L14; else goto _L13
_L13:
        if (!flag) goto _L16; else goto _L15
_L15:
        setContent("", false);
        return true;
_L8:
        inputstream = new HTTPHeader(inputstream);
        if (inputstream.hasName())
        {
            setHeader(inputstream);
        }
        inputstream = readLine(bufferedinputstream);
          goto _L17
_L14:
        inputstream = new HTTPHeader(inputstream);
        if (inputstream.hasName())
        {
            setHeader(inputstream);
        }
        inputstream = readLine(bufferedinputstream);
          goto _L18
_L16:
        flag = isChunked();
        l = 0L;
        if (!flag) goto _L20; else goto _L19
_L19:
        inputstream = readLine(bufferedinputstream);
        if (inputstream == null) goto _L22; else goto _L21
_L21:
        l1 = Long.parseLong(inputstream.trim(), 16);
        l = l1;
_L25:
        inputstream = new ByteArrayOutputStream();
_L29:
        if (0L < l) goto _L24; else goto _L23
_L23:
        setContent(inputstream.toByteArray(), false);
        return true;
_L20:
        l = getContentLength();
          goto _L25
_L24:
        i = HTTP.getChunkSize();
        if (l > (long)i)
        {
            l1 = i;
        } else
        {
            l1 = l;
        }
        abyte0 = new byte[(int)l1];
        l1 = 0L;
          goto _L26
_L30:
        l1 = bufferedinputstream.skip((long)"\r\n".length() - l);
        if (l1 >= 0L) goto _L28; else goto _L27
_L27:
        try
        {
            abyte0 = readLine(bufferedinputstream);
            l = Long.parseLong(new String(abyte0.getBytes(), 0, abyte0.length() - 2), 16);
        }
        catch (Exception exception1)
        {
            l = 0L;
        }
          goto _L29
_L32:
        l3 = l - l1;
        l2 = l3;
        if ((long)i < l3)
        {
            l2 = i;
        }
        j = (int)l2;
        j = bufferedinputstream.read(abyte0, 0, j);
        if (j < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        inputstream.write(abyte0, 0, j);
        l1 += j;
        continue; /* Loop/switch isn't completed */
        exception;
        Debug.warning(exception);
        break; /* Loop/switch isn't completed */
_L28:
        l1 = l + l1;
        i = "\r\n".length();
        l = l1;
        if (l1 < (long)i) goto _L30; else goto _L27
_L34:
        l = 0L;
          goto _L29
        inputstream;
          goto _L25
_L2:
        return false;
_L10:
        return true;
_L22:
        l = 0L;
          goto _L25
_L26:
        if (l1 < l) goto _L32; else goto _L31
_L31:
        if (!flag) goto _L34; else goto _L33
_L33:
        l = 0L;
          goto _L30
    }

    protected boolean set(HTTPSocket httpsocket)
    {
        return set(httpsocket.getInputStream());
    }

    public void setCacheControl(int i)
    {
        setCacheControl("max-age", i);
    }

    public void setCacheControl(String s)
    {
        setHeader("Cache-Control", s);
    }

    public void setCacheControl(String s, int i)
    {
        setHeader("Cache-Control", (new StringBuilder(String.valueOf(s))).append("=").append(Integer.toString(i)).toString());
    }

    public void setConnection(String s)
    {
        setHeader("Connection", s);
    }

    public void setContent(String s)
    {
        setContent(s, true);
    }

    public void setContent(String s, boolean flag)
    {
        setContent(s.getBytes(), flag);
    }

    public void setContent(byte abyte0[])
    {
        setContent(abyte0, true);
    }

    public void setContent(byte abyte0[], boolean flag)
    {
        content = abyte0;
        if (flag)
        {
            setContentLength(abyte0.length);
        }
    }

    public void setContentInputStream(InputStream inputstream)
    {
        contentInput = inputstream;
    }

    public void setContentLength(long l)
    {
        setLongHeader("Content-Length", l);
    }

    public void setContentRange(long l, long l1, long l2)
    {
        StringBuilder stringbuilder = new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(""))).append("bytes ").toString()))).append(Long.toString(l)).append("-").toString()))).append(Long.toString(l1)).append("/").toString()));
        String s;
        if (0L < l2)
        {
            s = Long.toString(l2);
        } else
        {
            s = "*";
        }
        setHeader("Content-Range", stringbuilder.append(s).toString());
    }

    public void setContentType(String s)
    {
        setHeader("Content-Type", s);
    }

    public void setDate(Calendar calendar)
    {
        setHeader("Date", (new Date(calendar)).getDateString());
    }

    public void setHeader(String s, int i)
    {
        setHeader(s, Integer.toString(i));
    }

    public void setHeader(String s, long l)
    {
        setHeader(s, Long.toString(l));
    }

    public void setHeader(String s, String s1)
    {
        HTTPHeader httpheader = getHeader(s);
        if (httpheader != null)
        {
            httpheader.setValue(s1);
            return;
        } else
        {
            addHeader(s, s1);
            return;
        }
    }

    public void setHeader(HTTPHeader httpheader)
    {
        setHeader(httpheader.getName(), httpheader.getValue());
    }

    public void setHost(String s)
    {
        String s1 = s;
        if (HostInterface.isIPv6Address(s))
        {
            s1 = (new StringBuilder("[")).append(s).append("]").toString();
        }
        setHeader("HOST", s1);
    }

    public void setHost(String s, int i)
    {
        String s1 = s;
        if (HostInterface.isIPv6Address(s))
        {
            s1 = (new StringBuilder("[")).append(s).append("]").toString();
        }
        setHeader("HOST", (new StringBuilder(String.valueOf(s1))).append(":").append(Integer.toString(i)).toString());
    }

    public void setIntegerHeader(String s, int i)
    {
        setHeader(s, Integer.toString(i));
    }

    public void setLongHeader(String s, long l)
    {
        setHeader(s, Long.toString(l));
    }

    public void setServer(String s)
    {
        setHeader("Server", s);
    }

    public void setStringHeader(String s, String s1)
    {
        setStringHeader(s, s1, "\"", "\"");
    }

    public void setStringHeader(String s, String s1, String s2, String s3)
    {
        String s4 = s1;
        s1 = s4;
        if (!s4.startsWith(s2))
        {
            s1 = (new StringBuilder(String.valueOf(s2))).append(s4).toString();
        }
        s2 = s1;
        if (!s1.endsWith(s3))
        {
            s2 = (new StringBuilder(String.valueOf(s1))).append(s3).toString();
        }
        setHeader(s, s2);
    }

    public void setTransferEncoding(String s)
    {
        setHeader("Transfer-Encoding", s);
    }

    public void setVersion(String s)
    {
        version = s;
    }
}
