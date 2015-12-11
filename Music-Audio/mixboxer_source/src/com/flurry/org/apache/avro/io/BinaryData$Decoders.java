// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;


// Referenced classes of package com.flurry.org.apache.avro.io:
//            BinaryData, BinaryDecoder

private static class ferAccessor
{

    private final Accessor b1;
    private final Accessor b2;
    private final BinaryDecoder d1 = new BinaryDecoder(new byte[0], 0, 0);
    private final BinaryDecoder d2 = new BinaryDecoder(new byte[0], 0, 0);

    public void set(byte abyte0[], int i, int j, byte abyte1[], int k, int l)
    {
        d1.configure(abyte0, i, j);
        d2.configure(abyte1, k, l);
    }





    public Accessor()
    {
        b1 = d1.getBufferAccessor();
        b2 = d2.getBufferAccessor();
    }
}
