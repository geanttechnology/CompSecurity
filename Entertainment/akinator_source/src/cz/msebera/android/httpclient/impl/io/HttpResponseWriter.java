// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.LineFormatter;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.impl.io:
//            AbstractMessageWriter

public class HttpResponseWriter extends AbstractMessageWriter
{

    public HttpResponseWriter(SessionOutputBuffer sessionoutputbuffer, LineFormatter lineformatter, HttpParams httpparams)
    {
        super(sessionoutputbuffer, lineformatter, httpparams);
    }

    protected volatile void writeHeadLine(HttpMessage httpmessage)
        throws IOException
    {
        writeHeadLine((HttpResponse)httpmessage);
    }

    protected void writeHeadLine(HttpResponse httpresponse)
        throws IOException
    {
        lineFormatter.formatStatusLine(lineBuf, httpresponse.getStatusLine());
        sessionBuffer.writeLine(lineBuf);
    }
}
