// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

// Referenced classes of package cz.msebera.android.httpclient.client.entity:
//            DeflateInputStream

static class closed extends InflaterInputStream
{

    private boolean closed;

    public void close()
        throws IOException
    {
        if (closed)
        {
            return;
        } else
        {
            closed = true;
            inf.end();
            super.close();
            return;
        }
    }

    public (InputStream inputstream, Inflater inflater)
    {
        super(inputstream, inflater);
        closed = false;
    }
}
