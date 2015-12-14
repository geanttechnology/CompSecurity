// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.methods:
//            ExpectContinueMethod

public class MultipartPostMethod extends ExpectContinueMethod
{

    private static final Log LOG;
    public static final String MULTIPART_FORM_CONTENT_TYPE = "multipart/form-data";
    static Class class$org$apache$commons$httpclient$methods$MultipartPostMethod;
    private final List parameters;

    public MultipartPostMethod()
    {
        parameters = new ArrayList();
    }

    public MultipartPostMethod(String s)
    {
        super(s);
        parameters = new ArrayList();
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
        LOG.trace("enter EntityEnclosingMethod.addContentLengthRequestHeader(HttpState, HttpConnection)");
        if (getRequestHeader("Content-Length") == null)
        {
            addRequestHeader("Content-Length", String.valueOf(getRequestContentLength()));
        }
        removeRequestHeader("Transfer-Encoding");
    }

    protected void addContentTypeRequestHeader(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter EntityEnclosingMethod.addContentTypeRequestHeader(HttpState, HttpConnection)");
        if (!parameters.isEmpty())
        {
            httpstate = new StringBuffer("multipart/form-data");
            if (Part.getBoundary() != null)
            {
                httpstate.append("; boundary=");
                httpstate.append(Part.getBoundary());
            }
            setRequestHeader("Content-Type", httpstate.toString());
        }
    }

    public void addParameter(String s, File file)
        throws FileNotFoundException
    {
        LOG.trace("enter MultipartPostMethod.addParameter(String parameterName, File parameterFile)");
        s = new FilePart(s, file);
        parameters.add(s);
    }

    public void addParameter(String s, String s1)
    {
        LOG.trace("enter addParameter(String parameterName, String parameterValue)");
        s = new StringPart(s, s1);
        parameters.add(s);
    }

    public void addParameter(String s, String s1, File file)
        throws FileNotFoundException
    {
        LOG.trace("enter MultipartPostMethod.addParameter(String parameterName, String fileName, File parameterFile)");
        s = new FilePart(s, s1, file);
        parameters.add(s);
    }

    public void addPart(Part part)
    {
        LOG.trace("enter addPart(Part part)");
        parameters.add(part);
    }

    protected void addRequestHeaders(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter MultipartPostMethod.addRequestHeaders(HttpState state, HttpConnection conn)");
        super.addRequestHeaders(httpstate, httpconnection);
        addContentLengthRequestHeader(httpstate, httpconnection);
        addContentTypeRequestHeader(httpstate, httpconnection);
    }

    public String getName()
    {
        return "POST";
    }

    public Part[] getParts()
    {
        return (Part[])(Part[])parameters.toArray(new Part[parameters.size()]);
    }

    protected long getRequestContentLength()
        throws IOException
    {
        LOG.trace("enter MultipartPostMethod.getRequestContentLength()");
        return Part.getLengthOfParts(getParts());
    }

    protected boolean hasRequestContent()
    {
        return true;
    }

    public void recycle()
    {
        LOG.trace("enter MultipartPostMethod.recycle()");
        super.recycle();
        parameters.clear();
    }

    protected boolean writeRequestBody(HttpState httpstate, HttpConnection httpconnection)
        throws IOException, HttpException
    {
        LOG.trace("enter MultipartPostMethod.writeRequestBody(HttpState state, HttpConnection conn)");
        Part.sendParts(httpconnection.getRequestOutputStream(), getParts());
        return true;
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$methods$MultipartPostMethod == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.methods.MultipartPostMethod");
            class$org$apache$commons$httpclient$methods$MultipartPostMethod = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$methods$MultipartPostMethod;
        }
        LOG = LogFactory.getLog(class1);
    }
}
