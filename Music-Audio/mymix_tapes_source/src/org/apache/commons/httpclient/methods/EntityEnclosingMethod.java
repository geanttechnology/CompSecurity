// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.ChunkedOutputStream;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpVersion;
import org.apache.commons.httpclient.ProtocolException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.methods:
//            ExpectContinueMethod, RequestEntity, ByteArrayRequestEntity, InputStreamRequestEntity, 
//            StringRequestEntity

public abstract class EntityEnclosingMethod extends ExpectContinueMethod
{

    public static final long CONTENT_LENGTH_AUTO = -2L;
    public static final long CONTENT_LENGTH_CHUNKED = -1L;
    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$methods$EntityEnclosingMethod;
    private boolean chunked;
    private int repeatCount;
    private long requestContentLength;
    private RequestEntity requestEntity;
    private InputStream requestStream;
    private String requestString;

    public EntityEnclosingMethod()
    {
        requestStream = null;
        requestString = null;
        repeatCount = 0;
        requestContentLength = -2L;
        chunked = false;
        setFollowRedirects(false);
    }

    public EntityEnclosingMethod(String s)
    {
        super(s);
        requestStream = null;
        requestString = null;
        repeatCount = 0;
        requestContentLength = -2L;
        chunked = false;
        setFollowRedirects(false);
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    protected void addContentLengthRequestHeader(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        long l;
label0:
        {
label1:
            {
                LOG.trace("enter EntityEnclosingMethod.addContentLengthRequestHeader(HttpState, HttpConnection)");
                if (getRequestHeader("content-length") == null && getRequestHeader("Transfer-Encoding") == null)
                {
                    l = getRequestContentLength();
                    if (l >= 0L)
                    {
                        break label0;
                    }
                    if (!getEffectiveVersion().greaterEquals(HttpVersion.HTTP_1_1))
                    {
                        break label1;
                    }
                    addRequestHeader("Transfer-Encoding", "chunked");
                }
                return;
            }
            throw new ProtocolException(getEffectiveVersion() + " does not support chunk encoding");
        }
        addRequestHeader("Content-Length", String.valueOf(l));
    }

    protected void addRequestHeaders(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter EntityEnclosingMethod.addRequestHeaders(HttpState, HttpConnection)");
        super.addRequestHeaders(httpstate, httpconnection);
        addContentLengthRequestHeader(httpstate, httpconnection);
        if (getRequestHeader("Content-Type") == null)
        {
            httpstate = getRequestEntity();
            if (httpstate != null && httpstate.getContentType() != null)
            {
                setRequestHeader("Content-Type", httpstate.getContentType());
            }
        }
    }

    protected void clearRequestBody()
    {
        LOG.trace("enter EntityEnclosingMethod.clearRequestBody()");
        requestStream = null;
        requestString = null;
        requestEntity = null;
    }

    protected byte[] generateRequestBody()
    {
        LOG.trace("enter EntityEnclosingMethod.renerateRequestBody()");
        return null;
    }

    protected RequestEntity generateRequestEntity()
    {
        byte abyte0[] = generateRequestBody();
        if (abyte0 == null) goto _L2; else goto _L1
_L1:
        requestEntity = new ByteArrayRequestEntity(abyte0);
_L4:
        return requestEntity;
_L2:
        if (requestStream != null)
        {
            requestEntity = new InputStreamRequestEntity(requestStream, requestContentLength);
            requestStream = null;
        } else
        if (requestString != null)
        {
            String s = getRequestCharSet();
            try
            {
                requestEntity = new StringRequestEntity(requestString, null, s);
            }
            catch (UnsupportedEncodingException unsupportedencodingexception1)
            {
                if (LOG.isWarnEnabled())
                {
                    LOG.warn(s + " not supported");
                }
                try
                {
                    requestEntity = new StringRequestEntity(requestString, null, null);
                }
                catch (UnsupportedEncodingException unsupportedencodingexception) { }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean getFollowRedirects()
    {
        return false;
    }

    public String getRequestCharSet()
    {
        if (getRequestHeader("Content-Type") == null)
        {
            if (requestEntity != null)
            {
                return getContentCharSet(new Header("Content-Type", requestEntity.getContentType()));
            } else
            {
                return super.getRequestCharSet();
            }
        } else
        {
            return super.getRequestCharSet();
        }
    }

    protected long getRequestContentLength()
    {
        LOG.trace("enter EntityEnclosingMethod.getRequestContentLength()");
        if (hasRequestContent())
        {
            if (chunked)
            {
                return -1L;
            }
            if (requestEntity == null)
            {
                requestEntity = generateRequestEntity();
            }
            if (requestEntity != null)
            {
                return requestEntity.getContentLength();
            }
        }
        return 0L;
    }

    public RequestEntity getRequestEntity()
    {
        return generateRequestEntity();
    }

    protected boolean hasRequestContent()
    {
        LOG.trace("enter EntityEnclosingMethod.hasRequestContent()");
        return requestEntity != null || requestStream != null || requestString != null;
    }

    public void recycle()
    {
        LOG.trace("enter EntityEnclosingMethod.recycle()");
        clearRequestBody();
        requestContentLength = -2L;
        repeatCount = 0;
        chunked = false;
        super.recycle();
    }

    public void setContentChunked(boolean flag)
    {
        chunked = flag;
    }

    public void setFollowRedirects(boolean flag)
    {
        if (flag)
        {
            throw new IllegalArgumentException("Entity enclosing requests cannot be redirected without user intervention");
        } else
        {
            super.setFollowRedirects(false);
            return;
        }
    }

    public void setRequestBody(InputStream inputstream)
    {
        LOG.trace("enter EntityEnclosingMethod.setRequestBody(InputStream)");
        clearRequestBody();
        requestStream = inputstream;
    }

    public void setRequestBody(String s)
    {
        LOG.trace("enter EntityEnclosingMethod.setRequestBody(String)");
        clearRequestBody();
        requestString = s;
    }

    public void setRequestContentLength(int i)
    {
        LOG.trace("enter EntityEnclosingMethod.setRequestContentLength(int)");
        requestContentLength = i;
    }

    public void setRequestContentLength(long l)
    {
        LOG.trace("enter EntityEnclosingMethod.setRequestContentLength(int)");
        requestContentLength = l;
    }

    public void setRequestEntity(RequestEntity requestentity)
    {
        clearRequestBody();
        requestEntity = requestentity;
    }

    protected boolean writeRequestBody(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter EntityEnclosingMethod.writeRequestBody(HttpState, HttpConnection)");
        if (!hasRequestContent())
        {
            LOG.debug("Request body has not been specified");
            return true;
        }
        if (requestEntity == null)
        {
            requestEntity = generateRequestEntity();
        }
        if (requestEntity == null)
        {
            LOG.debug("Request body is empty");
            return true;
        }
        long l = getRequestContentLength();
        if (repeatCount > 0 && !requestEntity.isRepeatable())
        {
            throw new ProtocolException("Unbuffered entity enclosing request can not be repeated.");
        }
        repeatCount = repeatCount + 1;
        httpconnection = httpconnection.getRequestOutputStream();
        httpstate = httpconnection;
        if (l < 0L)
        {
            httpstate = new ChunkedOutputStream(httpconnection);
        }
        requestEntity.writeRequest(httpstate);
        if (httpstate instanceof ChunkedOutputStream)
        {
            ((ChunkedOutputStream)httpstate).finish();
        }
        httpstate.flush();
        LOG.debug("Request body sent");
        return true;
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$methods$EntityEnclosingMethod == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.methods.EntityEnclosingMethod");
            class$org$apache$commons$httpclient$methods$EntityEnclosingMethod = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$methods$EntityEnclosingMethod;
        }
        LOG = LogFactory.getLog(class1);
    }
}
