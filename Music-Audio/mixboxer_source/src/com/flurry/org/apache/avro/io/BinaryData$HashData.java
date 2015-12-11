// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;


// Referenced classes of package com.flurry.org.apache.avro.io:
//            BinaryData, BinaryDecoder

private static class ferAccessor
{

    private final Accessor bytes;
    private final BinaryDecoder decoder = new BinaryDecoder(new byte[0], 0, 0);

    public void set(byte abyte0[], int i, int j)
    {
        decoder.configure(abyte0, i, j);
    }



    public Accessor()
    {
        bytes = decoder.getBufferAccessor();
    }
}
