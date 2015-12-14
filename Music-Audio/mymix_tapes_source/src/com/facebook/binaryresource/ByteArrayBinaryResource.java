// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.binaryresource;

import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.facebook.binaryresource:
//            BinaryResource

public class ByteArrayBinaryResource
    implements BinaryResource
{

    private final byte mBytes[];

    public ByteArrayBinaryResource(byte abyte0[])
    {
        mBytes = (byte[])Preconditions.checkNotNull(abyte0);
    }

    public InputStream openStream()
        throws IOException
    {
        return new ByteArrayInputStream(mBytes);
    }

    public byte[] read()
    {
        return mBytes;
    }

    public long size()
    {
        return (long)mBytes.length;
    }
}
