// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dp.framework;

import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.dp.framework:
//            CodecException

public interface StreamCodec
{

    public abstract String decodeAsciiString(InputStream inputstream, int i)
        throws CodecException;

    public abstract int decodeInt(InputStream inputstream)
        throws CodecException;

    public abstract void encodeAsciiString(String s, OutputStream outputstream)
        throws CodecException;

    public abstract void encodeInt(int i, OutputStream outputstream)
        throws CodecException;

    public abstract String getName();

    public abstract int getSizeOfDelimiter();

    public abstract int getSizeOfEncodedMaxInteger();
}
