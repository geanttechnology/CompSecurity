// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;

// Referenced classes of package com.tencent.open.utils:
//            a, p

class b
{

    Properties a;
    byte b[];

    private b()
    {
        a = new Properties();
    }

    b(a._cls1 _pcls1)
    {
        this();
    }

    void a(byte abyte0[])
    {
        if (abyte0 != null)
        {
            ByteBuffer bytebuffer = ByteBuffer.wrap(abyte0);
            int i = com.tencent.open.utils.a.a().a().length;
            byte abyte1[] = new byte[i];
            bytebuffer.get(abyte1);
            if (!com.tencent.open.utils.a.a().equals(new p(abyte1)))
            {
                throw new ProtocolException((new StringBuilder()).append("unknow protocl [").append(Arrays.toString(abyte0)).append("]").toString());
            }
            if (abyte0.length - i > 2)
            {
                byte abyte2[] = new byte[2];
                bytebuffer.get(abyte2);
                int j = (new p(abyte2)).b();
                if (abyte0.length - i - 2 >= j)
                {
                    byte abyte3[] = new byte[j];
                    bytebuffer.get(abyte3);
                    a.load(new ByteArrayInputStream(abyte3));
                    i = abyte0.length - i - j - 2;
                    if (i > 0)
                    {
                        b = new byte[i];
                        bytebuffer.get(b);
                        return;
                    }
                }
            }
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("ApkExternalInfo [p=").append(a).append(", otherData=").append(Arrays.toString(b)).append("]").toString();
    }
}
