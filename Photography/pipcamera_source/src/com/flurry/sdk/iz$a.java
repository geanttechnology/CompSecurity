// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            lb, iz

public class eam
    implements lb
{

    public iz a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        }
        inputstream = new DataInputStream(inputstream) {

            final iz.a a;

            public void close()
            {
            }

            
            {
                a = iz.a.this;
                super(inputstream);
            }
        };
        iz iz1 = new iz(null);
        int i = inputstream.readUnsignedShort();
        if (i > 0)
        {
            byte abyte0[] = new byte[i];
            inputstream.readFully(abyte0);
            iz1.a = abyte0;
        }
        return iz1;
    }

    public void a(OutputStream outputstream, iz iz1)
    {
        if (outputstream == null || iz1 == null)
        {
            return;
        }
        outputstream = new DataOutputStream(outputstream) {

            final iz.a a;

            public void close()
            {
            }

            
            {
                a = iz.a.this;
                super(outputstream);
            }
        };
        int i = 0;
        if (iz1.a != null)
        {
            i = iz1.a.length;
        }
        outputstream.writeShort(i);
        if (i > 0)
        {
            outputstream.write(iz1.a);
        }
        outputstream.flush();
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (iz)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
