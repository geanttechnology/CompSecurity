// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.BasicLineFormatter;
import cz.msebera.android.httpclient.message.LineFormatter;

// Referenced classes of package cz.msebera.android.httpclient.impl.io:
//            DefaultHttpResponseWriter

public class DefaultHttpResponseWriterFactory
    implements HttpMessageWriterFactory
{

    public static final DefaultHttpResponseWriterFactory INSTANCE = new DefaultHttpResponseWriterFactory();
    private final LineFormatter lineFormatter;

    public DefaultHttpResponseWriterFactory()
    {
        this(null);
    }

    public DefaultHttpResponseWriterFactory(LineFormatter lineformatter)
    {
        if (lineformatter == null)
        {
            lineformatter = BasicLineFormatter.INSTANCE;
        }
        lineFormatter = lineformatter;
    }

    public HttpMessageWriter create(SessionOutputBuffer sessionoutputbuffer)
    {
        return new DefaultHttpResponseWriter(sessionoutputbuffer, lineFormatter);
    }

}
