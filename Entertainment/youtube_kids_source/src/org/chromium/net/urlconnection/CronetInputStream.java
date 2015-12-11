// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net.urlconnection;

import java.io.InputStream;
import java.nio.ByteBuffer;

// Referenced classes of package org.chromium.net.urlconnection:
//            CronetHttpURLConnection

class CronetInputStream extends InputStream
{

    boolean a;
    private final CronetHttpURLConnection b;
    private ByteBuffer c;

    public CronetInputStream(CronetHttpURLConnection cronethttpurlconnection)
    {
        b = cronethttpurlconnection;
    }

    public int read()
    {
        if (!a && (c == null || !c.hasRemaining()))
        {
            c = b.a();
        }
        if (c != null && c.hasRemaining())
        {
            return c.get() & 0xff;
        } else
        {
            return -1;
        }
    }
}
