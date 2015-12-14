// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

// Referenced classes of package org.apache.james.mime4j.util:
//            ByteArrayBuffer, ByteSequence, CharsetUtil

public class ContentUtil
{

    public static String decode(Charset charset, ByteSequence bytesequence, int i, int j)
    {
        if (bytesequence instanceof ByteArrayBuffer)
        {
            return decode(charset, ((ByteArrayBuffer)bytesequence).buffer(), i, j);
        } else
        {
            return decode(charset, bytesequence.toByteArray(), i, j);
        }
    }

    private static String decode(Charset charset, byte abyte0[], int i, int j)
    {
        return charset.decode(ByteBuffer.wrap(abyte0, i, j)).toString();
    }

    public static String decode(ByteSequence bytesequence)
    {
        return decode(CharsetUtil.US_ASCII, bytesequence, 0, bytesequence.length());
    }

    public static ByteSequence encode(String s)
    {
        return encode(CharsetUtil.US_ASCII, s);
    }

    public static ByteSequence encode(Charset charset, String s)
    {
        charset = charset.encode(CharBuffer.wrap(s));
        s = new ByteArrayBuffer(charset.remaining());
        s.append(charset.array(), charset.position(), charset.remaining());
        return s;
    }
}
