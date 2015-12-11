// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.io;

import com.comcast.cim.httpcomponentsandroid.HttpMessage;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.io.SessionOutputBuffer;
import com.comcast.cim.httpcomponentsandroid.message.LineFormatter;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.io:
//            AbstractMessageWriter

public class HttpResponseWriter extends AbstractMessageWriter
{

    protected void writeHeadLine(HttpMessage httpmessage)
        throws IOException
    {
        lineFormatter.formatStatusLine(lineBuf, ((HttpResponse)httpmessage).getStatusLine());
        sessionBuffer.writeLine(lineBuf);
    }
}
