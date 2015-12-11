// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

// Referenced classes of package org.apache.james.mime4j.util:
//            ByteSequence, ByteArrayBuffer

public class ContentUtil
{

    private ContentUtil()
    {
    }

    public static String decode(Charset charset, ByteSequence bytesequence)
    {
        return decode(charset, bytesequence, 0, bytesequence.length());
    }

    public static String decode(Charset charset, ByteSequence bytesequence, int i, int j)
    {
        if (bytesequence == null)
        {
            return null;
        }
        Charset charset1 = charset;
        if (charset == null)
        {
            charset1 = Charset.defaultCharset();
        }
        if (bytesequence instanceof ByteArrayBuffer)
        {
            return decode(charset1, ((ByteArrayBuffer)bytesequence).buffer(), i, j);
        } else
        {
            return decode(charset1, bytesequence.toByteArray(), i, j);
        }
    }

    private static String decode(Charset charset, byte abyte0[], int i, int j)
    {
        return charset.decode(ByteBuffer.wrap(abyte0, i, j)).toString();
    }

    public static String decode(ByteSequence bytesequence)
    {
        if (bytesequence == null)
        {
            return null;
        } else
        {
            return decode(bytesequence, 0, bytesequence.length());
        }
    }

    public static String decode(ByteSequence bytesequence, int i, int j)
    {
        if (bytesequence == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder(j);
        for (int k = i; k < i + j; k++)
        {
            stringbuilder.append((char)(bytesequence.byteAt(k) & 0xff));
        }

        return stringbuilder.toString();
    }

    public static ByteSequence encode(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((ByteSequence) (obj));
_L2:
        ByteArrayBuffer bytearraybuffer = new ByteArrayBuffer(s.length());
        int i = 0;
        do
        {
            obj = bytearraybuffer;
            if (i >= s.length())
            {
                continue;
            }
            bytearraybuffer.append((byte)s.charAt(i));
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ByteSequence encode(Charset charset, String s)
    {
        if (s == null)
        {
            return null;
        }
        Charset charset1 = charset;
        if (charset == null)
        {
            charset1 = Charset.defaultCharset();
        }
        charset = charset1.encode(CharBuffer.wrap(s));
        s = new ByteArrayBuffer(charset.remaining());
        s.append(charset.array(), charset.position(), charset.remaining());
        return s;
    }
}
