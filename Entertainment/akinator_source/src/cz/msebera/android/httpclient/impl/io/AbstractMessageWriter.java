// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.BasicLineFormatter;
import cz.msebera.android.httpclient.message.LineFormatter;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

public abstract class AbstractMessageWriter
    implements HttpMessageWriter
{

    protected final CharArrayBuffer lineBuf;
    protected final LineFormatter lineFormatter;
    protected final SessionOutputBuffer sessionBuffer;

    public AbstractMessageWriter(SessionOutputBuffer sessionoutputbuffer, LineFormatter lineformatter)
    {
        sessionBuffer = (SessionOutputBuffer)Args.notNull(sessionoutputbuffer, "Session input buffer");
        if (lineformatter == null)
        {
            lineformatter = BasicLineFormatter.INSTANCE;
        }
        lineFormatter = lineformatter;
        lineBuf = new CharArrayBuffer(128);
    }

    public AbstractMessageWriter(SessionOutputBuffer sessionoutputbuffer, LineFormatter lineformatter, HttpParams httpparams)
    {
        Args.notNull(sessionoutputbuffer, "Session input buffer");
        sessionBuffer = sessionoutputbuffer;
        lineBuf = new CharArrayBuffer(128);
        if (lineformatter == null)
        {
            lineformatter = BasicLineFormatter.INSTANCE;
        }
        lineFormatter = lineformatter;
    }

    public void write(HttpMessage httpmessage)
        throws IOException, HttpException
    {
        Args.notNull(httpmessage, "HTTP message");
        writeHeadLine(httpmessage);
        cz.msebera.android.httpclient.Header header;
        for (httpmessage = httpmessage.headerIterator(); httpmessage.hasNext(); sessionBuffer.writeLine(lineFormatter.formatHeader(lineBuf, header)))
        {
            header = httpmessage.nextHeader();
        }

        lineBuf.clear();
        sessionBuffer.writeLine(lineBuf);
    }

    protected abstract void writeHeadLine(HttpMessage httpmessage)
        throws IOException;
}
