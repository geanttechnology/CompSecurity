// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.commons.codec;


// Referenced classes of package com.medialets.commons.codec:
//            Encoder, EncoderException

public interface BinaryEncoder
    extends Encoder
{

    public abstract byte[] encode(byte abyte0[])
        throws EncoderException;
}
