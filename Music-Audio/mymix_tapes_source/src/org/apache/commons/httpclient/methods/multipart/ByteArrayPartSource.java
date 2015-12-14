// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods.multipart;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package org.apache.commons.httpclient.methods.multipart:
//            PartSource

public class ByteArrayPartSource
    implements PartSource
{

    private byte bytes[];
    private String fileName;

    public ByteArrayPartSource(String s, byte abyte0[])
    {
        fileName = s;
        bytes = abyte0;
    }

    public InputStream createInputStream()
        throws IOException
    {
        return new ByteArrayInputStream(bytes);
    }

    public String getFileName()
    {
        return fileName;
    }

    public long getLength()
    {
        return (long)bytes.length;
    }
}
