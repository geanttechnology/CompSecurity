// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            kx, ib

public class eam
    implements kx
{

    public ib a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            inputstream = new DataInputStream(inputstream) {

                final ib.a a;

                public void close()
                {
                }

            
            {
                a = ib.a.this;
                super(inputstream);
            }
            };
            ib ib1 = new ib();
            ib.a(ib1, inputstream.readLong());
            ib.a(ib1, inputstream.readBoolean());
            ib.a(ib1, new byte[inputstream.readInt()]);
            inputstream.readFully(ib.c(ib1));
            return ib1;
        }
    }

    public void a(OutputStream outputstream, ib ib1)
    {
        if (outputstream == null || ib1 == null)
        {
            return;
        } else
        {
            outputstream = new DataOutputStream(outputstream) {

                final ib.a a;

                public void close()
                {
                }

            
            {
                a = ib.a.this;
                super(outputstream);
            }
            };
            outputstream.writeLong(ib.a(ib1));
            outputstream.writeBoolean(ib.b(ib1));
            outputstream.writeInt(ib.c(ib1).length);
            outputstream.write(ib.c(ib1));
            outputstream.flush();
            return;
        }
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (ib)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
