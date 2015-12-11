// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.tagmanager.protobuf:
//            CodedOutputStream

private static class byteBuffer extends OutputStream
{

    private final ByteBuffer byteBuffer;

    public void write(int i)
        throws IOException
    {
        byteBuffer.put((byte)i);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        byteBuffer.put(abyte0, i, j);
    }

    public (ByteBuffer bytebuffer)
    {
        byteBuffer = bytebuffer;
    }
}
