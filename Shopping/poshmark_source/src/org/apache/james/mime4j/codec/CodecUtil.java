// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package org.apache.james.mime4j.codec:
//            Base64OutputStream, QuotedPrintableOutputStream

public class CodecUtil
{

    static final int DEFAULT_ENCODING_BUFFER_SIZE = 1024;

    public CodecUtil()
    {
    }

    public static void copy(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (-1 != i)
            {
                outputstream.write(abyte0, 0, i);
            } else
            {
                return;
            }
        } while (true);
    }

    public static void encodeBase64(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        outputstream = new Base64OutputStream(outputstream);
        copy(inputstream, outputstream);
        outputstream.close();
    }

    public static void encodeQuotedPrintable(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        outputstream = new QuotedPrintableOutputStream(outputstream, false);
        copy(inputstream, outputstream);
        outputstream.close();
    }

    public static void encodeQuotedPrintableBinary(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        outputstream = new QuotedPrintableOutputStream(outputstream, true);
        copy(inputstream, outputstream);
        outputstream.close();
    }

    public static OutputStream wrapBase64(OutputStream outputstream)
        throws IOException
    {
        return new Base64OutputStream(outputstream);
    }

    public static OutputStream wrapQuotedPrintable(OutputStream outputstream, boolean flag)
        throws IOException
    {
        return new QuotedPrintableOutputStream(outputstream, flag);
    }
}
