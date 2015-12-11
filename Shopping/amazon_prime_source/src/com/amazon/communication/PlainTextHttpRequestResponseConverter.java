// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.Message;
import com.amazon.dp.logger.DPLogger;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

// Referenced classes of package com.amazon.communication:
//            HttpRequestResponseConverterBase, ProtocolException, ByteBufferChain, ByteBufferChainMessageImpl, 
//            InputStreamMessageImpl

public class PlainTextHttpRequestResponseConverter extends HttpRequestResponseConverterBase
{

    public static final int DEFAULT_BYTE_BUFFER_CHAIN_MESSAGE_SIZE_CUT_OFF = 0x19000;
    private static final ProtocolVersion PROTOCOL_VERSION = new ProtocolVersion("HTTP", 1, 1);
    private static final PlainTextHttpRequestResponseConverter SINGLETON = new PlainTextHttpRequestResponseConverter();
    private static final DPLogger log = new DPLogger("TComm.PlainTextHttpRequestResponseConverter");
    private final int mByteBufferChainMessageSizeLimit;

    protected PlainTextHttpRequestResponseConverter()
    {
        this(0x19000);
    }

    protected PlainTextHttpRequestResponseConverter(int i)
    {
        mByteBufferChainMessageSizeLimit = i;
    }

    private void addEntityBodyToMessage(HttpMessage httpmessage, InputStream inputstream, int i)
        throws ProtocolException
    {
label0:
        {
            log.verbose("addEntityBodyToMessage", "beginning execution", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), "bodySize", Integer.valueOf(i)
            });
            if (i > 0)
            {
                inputstream = new InputStreamEntity(inputstream, i);
                if (!(httpmessage instanceof HttpResponse))
                {
                    break label0;
                }
                ((HttpResponse)httpmessage).setEntity(inputstream);
            }
            return;
        }
        if (httpmessage instanceof HttpEntityEnclosingRequest)
        {
            ((HttpEntityEnclosingRequest)httpmessage).setEntity(inputstream);
            return;
        } else
        {
            throw new ProtocolException("Message contains bytes for an entity body, but this HttpMessage type does not support entity bodies.");
        }
    }

    private void addHeadersToMessage(StringBuilder stringbuilder, HttpMessage httpmessage, InputStream inputstream)
        throws ProtocolException
    {
        String s = getNextLine(stringbuilder, inputstream);
        stringbuilder.setLength(0);
        String as[];
        for (; !isEndOfHeaders(s); log.verbose("addHeadersToMessage", "finished adding headers", new Object[] {
    "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), "name", as[0], "value", as[1]
}))
        {
            as = s.split(":", 2);
            if (as.length != 2)
            {
                throw new ProtocolException("Invalid message header format");
            }
            httpmessage.addHeader(as[0], as[1]);
            s = getNextLine(stringbuilder, inputstream);
            stringbuilder.setLength(0);
        }

    }

    private Message createMessageFromEntityBody(InputStream inputstream)
        throws IOException
    {
        ByteBufferChain bytebufferchain = new ByteBufferChain();
        int i = 0;
        boolean flag = false;
        do
        {
label0:
            {
                int j = ((flag) ? 1 : 0);
                byte abyte0[];
                if (i < mByteBufferChainMessageSizeLimit)
                {
                    abyte0 = new byte[1024];
                    j = inputstream.read(abyte0);
                    if (j != -1)
                    {
                        break label0;
                    }
                    j = 1;
                }
                if (j != 0)
                {
                    return new ByteBufferChainMessageImpl(bytebufferchain);
                } else
                {
                    return new InputStreamMessageImpl(bytebufferchain.getByteBufferList(), inputstream);
                }
            }
            bytebufferchain.append(ByteBuffer.wrap(abyte0, 0, j));
            i += j;
        } while (true);
    }

    private HttpRequestBase createRequestFromRequestLine(String s)
        throws ProtocolException
    {
        log.verbose("createRequestFromRequestLine", "beginning execution", new Object[] {
            "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), "requestLine", s
        });
        s = s.split(" ", 3);
        if (s.length != 3)
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid message header format: ").append(s.length).toString());
        }
        String s1 = s[2];
        if (!s1.equals("HTTP/1.1"))
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid protocol version: ").append(s1).toString());
        }
        s1 = s[0];
        s = s[1];
        if (s1.equals("PUT"))
        {
            return new HttpPut(s);
        }
        if (s1.equals("GET"))
        {
            return new HttpGet(s);
        }
        if (s1.equals("POST"))
        {
            return new HttpPost(s);
        }
        if (s1.equals("DELETE"))
        {
            return new HttpDelete(s);
        } else
        {
            throw new ProtocolException((new StringBuilder()).append("Unsupported request method at this time: ").append(s1).toString());
        }
    }

    private HttpResponse createResponseFromResponseLine(String s)
        throws ProtocolException
    {
        s = s.split(" ", 2);
        if (s.length != 2)
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid message header format: ").append(s.length).toString());
        }
        String s1 = s[0];
        if (!s1.equals("HTTP/1.1"))
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid protocol version: ").append(s1).toString());
        }
        s = s[1];
        if (s.length() != 3)
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid reason code: ").append(s).toString());
        }
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid reason code: ").append(s).toString());
        }
        log.verbose("createResponseFromResponseLine", "finished parsing responseLine", new Object[] {
            "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), "reasonCode", Integer.valueOf(i)
        });
        return new BasicHttpResponse(new BasicStatusLine(PROTOCOL_VERSION, i, null));
    }

    public static PlainTextHttpRequestResponseConverter getInstance()
    {
        return SINGLETON;
    }

    public static PlainTextHttpRequestResponseConverter getInstance(int i)
    {
        return new PlainTextHttpRequestResponseConverter(i);
    }

    private void validateMethod(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("request missing method");
        }
        if (!"PUT".equals(s) && !"GET".equals(s) && !"POST".equals(s) && !"DELETE".equals(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("unknown method '").append(s).append("'").toString());
        } else
        {
            return;
        }
    }

    private void validateProtocolVersion(ProtocolVersion protocolversion)
    {
        if (!protocolversion.getProtocol().equals("HTTP") || protocolversion.getMajor() != 1 || protocolversion.getMinor() != 1)
        {
            throw new IllegalArgumentException("Only HTTP/1.1 supported");
        } else
        {
            return;
        }
    }

    private void validateUri(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("request missing uri");
        } else
        {
            return;
        }
    }

    public HttpRequestBase convertMessageToRequest(Message message)
        throws ProtocolException
    {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(message.getPayload());
        log.verbose("convertMessageToRequest", "beginning execution", new Object[] {
            "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), "message.getPayloadSize", Integer.valueOf(message.getPayloadSize())
        });
        message = new StringBuilder();
        HttpRequestBase httprequestbase = createRequestFromRequestLine(getNextLine(message, bufferedinputstream));
        message.setLength(0);
        addHeadersToMessage(message, httprequestbase, bufferedinputstream);
        try
        {
            addEntityBodyToMessage(httprequestbase, bufferedinputstream, bufferedinputstream.available());
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            throw new ProtocolException(message);
        }
        return httprequestbase;
    }

    public HttpResponse convertMessageToResponse(Message message)
        throws ProtocolException
    {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(message.getPayload());
        log.verbose("convertMessageToResponse", "finished reading message payload", new Object[] {
            "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), "message.getPayloadSize", Integer.valueOf(message.getPayloadSize())
        });
        message = new StringBuilder();
        HttpResponse httpresponse = createResponseFromResponseLine(getNextLine(message, bufferedinputstream));
        message.setLength(0);
        addHeadersToMessage(message, httpresponse, bufferedinputstream);
        try
        {
            addEntityBodyToMessage(httpresponse, bufferedinputstream, bufferedinputstream.available());
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            throw new ProtocolException(message);
        }
        return httpresponse;
    }

    public Message convertRequestToMessage(HttpRequest httprequest)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        Object obj = new OutputStreamWriter(bytearrayoutputstream);
        Header aheader[];
        Header header;
        int i;
        int j;
        try
        {
            RequestLine requestline = httprequest.getRequestLine();
            String s = requestline.getMethod();
            validateMethod(s);
            ((OutputStreamWriter) (obj)).write(s);
            ((OutputStreamWriter) (obj)).write(" ");
            String s1 = requestline.getUri();
            validateUri(s1);
            ((OutputStreamWriter) (obj)).write(s1);
            ((OutputStreamWriter) (obj)).write(" ");
            validateProtocolVersion(requestline.getProtocolVersion());
            ((OutputStreamWriter) (obj)).write("HTTP/1.1");
            ((OutputStreamWriter) (obj)).write("\r\n");
            log.verbose("convertRequestToMessage", "finished reading method and uri", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), "method", s, "uri", s1
            });
            aheader = httprequest.getAllHeaders();
            j = aheader.length;
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequest httprequest)
        {
            throw new IllegalArgumentException("Malformed request object", httprequest);
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        header = aheader[i];
        ((OutputStreamWriter) (obj)).write(header.getName());
        ((OutputStreamWriter) (obj)).write(":");
        ((OutputStreamWriter) (obj)).write(header.getValue());
        ((OutputStreamWriter) (obj)).write("\r\n");
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_171;
_L1:
        ((OutputStreamWriter) (obj)).write("\r\n");
        ((OutputStreamWriter) (obj)).flush();
        aheader = null;
        obj = aheader;
        if (!(httprequest instanceof HttpEntityEnclosingRequest))
        {
            break MISSING_BLOCK_LABEL_273;
        }
        httprequest = ((HttpEntityEnclosingRequest)httprequest).getEntity();
        obj = aheader;
        if (httprequest == null)
        {
            break MISSING_BLOCK_LABEL_273;
        }
        obj = httprequest.getContent();
        httprequest = ByteBuffer.wrap(bytearrayoutputstream.toByteArray());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        obj = createMessageFromEntityBody(((InputStream) (obj)));
        ((Message) (obj)).prependPayload(httprequest);
        return ((Message) (obj));
        httprequest = new ByteBufferChainMessageImpl(httprequest);
        return httprequest;
    }

    public Message convertResponseToMessage(HttpResponse httpresponse)
        throws ProtocolException
    {
        log.verbose("convertResponseToMessage", "converting from HttpResponse to TComm message", new Object[] {
            "response.getStatusLine", httpresponse.getStatusLine()
        });
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(bytearrayoutputstream);
        Header aheader[];
        Header header;
        int i;
        int j;
        try
        {
            outputstreamwriter.write("HTTP/1.1");
            outputstreamwriter.write(" ");
            outputstreamwriter.write(Integer.toString(httpresponse.getStatusLine().getStatusCode()));
            outputstreamwriter.write("\r\n");
            aheader = httpresponse.getAllHeaders();
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            throw new IllegalArgumentException("Malformed response object", httpresponse);
        }
        if (aheader == null) goto _L2; else goto _L1
_L1:
        j = aheader.length;
        i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        header = aheader[i];
        outputstreamwriter.write(header.getName());
        outputstreamwriter.write(":");
        outputstreamwriter.write(header.getValue());
        outputstreamwriter.write("\r\n");
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        outputstreamwriter.write("\r\n");
        outputstreamwriter.flush();
        httpresponse = httpresponse.getEntity();
        if (httpresponse == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        httpresponse.writeTo(bytearrayoutputstream);
        return new ByteBufferChainMessageImpl(ByteBuffer.wrap(bytearrayoutputstream.toByteArray()));
    }

}
