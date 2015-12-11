// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.io;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpMessage;
import com.comcast.cim.httpcomponentsandroid.io.HttpMessageWriter;
import com.comcast.cim.httpcomponentsandroid.io.SessionOutputBuffer;
import com.comcast.cim.httpcomponentsandroid.message.BasicLineFormatter;
import com.comcast.cim.httpcomponentsandroid.message.LineFormatter;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.io.IOException;
import java.util.Iterator;

public abstract class AbstractMessageWriter
    implements HttpMessageWriter
{

    protected final CharArrayBuffer lineBuf = new CharArrayBuffer(128);
    protected final LineFormatter lineFormatter;
    protected final SessionOutputBuffer sessionBuffer;

    public AbstractMessageWriter(SessionOutputBuffer sessionoutputbuffer, LineFormatter lineformatter, HttpParams httpparams)
    {
        if (sessionoutputbuffer == null)
        {
            throw new IllegalArgumentException("Session input buffer may not be null");
        }
        sessionBuffer = sessionoutputbuffer;
        if (lineformatter == null)
        {
            lineformatter = BasicLineFormatter.DEFAULT;
        }
        lineFormatter = lineformatter;
    }

    public void write(HttpMessage httpmessage)
        throws IOException, HttpException
    {
        if (httpmessage == null)
        {
            throw new IllegalArgumentException("HTTP message may not be null");
        }
        writeHeadLine(httpmessage);
        Header header;
        for (httpmessage = httpmessage.headerIterator(); httpmessage.hasNext(); sessionBuffer.writeLine(lineFormatter.formatHeader(lineBuf, header)))
        {
            header = (Header)httpmessage.next();
        }

        lineBuf.clear();
        sessionBuffer.writeLine(lineBuf);
    }

    protected abstract void writeHeadLine(HttpMessage httpmessage)
        throws IOException;
}
