// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.LineFormatter;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.impl.io:
//            AbstractMessageWriter

public class DefaultHttpRequestWriter extends AbstractMessageWriter
{

    public DefaultHttpRequestWriter(SessionOutputBuffer sessionoutputbuffer)
    {
        this(sessionoutputbuffer, null);
    }

    public DefaultHttpRequestWriter(SessionOutputBuffer sessionoutputbuffer, LineFormatter lineformatter)
    {
        super(sessionoutputbuffer, lineformatter);
    }

    protected volatile void writeHeadLine(HttpMessage httpmessage)
        throws IOException
    {
        writeHeadLine((HttpRequest)httpmessage);
    }

    protected void writeHeadLine(HttpRequest httprequest)
        throws IOException
    {
        lineFormatter.formatRequestLine(lineBuf, httprequest.getRequestLine());
        sessionBuffer.writeLine(lineBuf);
    }
}
