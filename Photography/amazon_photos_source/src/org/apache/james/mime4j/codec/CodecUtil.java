// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package org.apache.james.mime4j.codec:
//            Base64OutputStream, QuotedPrintableOutputStream

public class CodecUtil
{

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
