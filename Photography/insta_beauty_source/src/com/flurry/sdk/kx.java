// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            lb, lt

public class kx
    implements lb
{

    public kx()
    {
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (byte[])obj);
    }

    public void a(OutputStream outputstream, byte abyte0[])
    {
        if (outputstream == null || abyte0 == null)
        {
            return;
        } else
        {
            outputstream.write(abyte0, 0, abyte0.length);
            return;
        }
    }

    public byte[] a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            lt.a(inputstream, bytearrayoutputstream);
            return bytearrayoutputstream.toByteArray();
        }
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }
}
