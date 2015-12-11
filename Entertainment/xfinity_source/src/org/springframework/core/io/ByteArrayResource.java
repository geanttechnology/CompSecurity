// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.core.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

// Referenced classes of package org.springframework.core.io:
//            AbstractResource

public class ByteArrayResource extends AbstractResource
{

    private final byte byteArray[];
    private final String description;

    public ByteArrayResource(byte abyte0[])
    {
        this(abyte0, "resource loaded from byte array");
    }

    public ByteArrayResource(byte abyte0[], String s)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Byte array must not be null");
        }
        byteArray = abyte0;
        if (s == null)
        {
            s = "";
        }
        description = s;
    }

    public long contentLength()
    {
        return (long)byteArray.length;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof ByteArrayResource) && Arrays.equals(((ByteArrayResource)obj).byteArray, byteArray);
    }

    public String getDescription()
    {
        return description;
    }

    public InputStream getInputStream()
        throws IOException
    {
        return new ByteArrayInputStream(byteArray);
    }

    public int hashCode()
    {
        return [B.hashCode() * 29 * byteArray.length;
    }
}
