// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.codec;


// Referenced classes of package com.parse.codec:
//            EncoderException

public interface Encoder
{

    public abstract Object encode(Object obj)
        throws EncoderException;
}
