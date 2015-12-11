// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package co.vine.android.network:
//            MultipartEntity

public static class mValue
    implements mValue
{

    private final byte mValue[];

    public InputStream getInputStream()
        throws IOException
    {
        return new ByteArrayInputStream(mValue);
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(mValue);
    }

    public (byte abyte0[])
    {
        mValue = abyte0;
    }
}
