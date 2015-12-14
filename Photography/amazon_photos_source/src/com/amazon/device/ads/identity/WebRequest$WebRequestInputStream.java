// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.device.ads.identity:
//            WebRequest

class decoratedStream extends InputStream
{

    private final InputStream decoratedStream;
    final WebRequest this$0;

    public void close()
        throws IOException
    {
        decoratedStream.close();
        if (WebRequest.access$000(WebRequest.this))
        {
            closeConnection();
        }
    }

    public int read()
        throws IOException
    {
        return decoratedStream.read();
    }

    public (InputStream inputstream)
    {
        this$0 = WebRequest.this;
        super();
        decoratedStream = inputstream;
    }
}
