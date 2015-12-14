// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            lb, ie

public class eam
    implements lb
{

    public ie a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            inputstream = new DataInputStream(inputstream) {

                final ie.a a;

                public void close()
                {
                }

            
            {
                a = ie.a.this;
                super(inputstream);
            }
            };
            ie ie1 = new ie();
            ie.a(ie1, inputstream.readLong());
            ie.a(ie1, inputstream.readBoolean());
            ie.a(ie1, new byte[inputstream.readInt()]);
            inputstream.readFully(ie.c(ie1));
            return ie1;
        }
    }

    public void a(OutputStream outputstream, ie ie1)
    {
        if (outputstream == null || ie1 == null)
        {
            return;
        } else
        {
            outputstream = new DataOutputStream(outputstream) {

                final ie.a a;

                public void close()
                {
                }

            
            {
                a = ie.a.this;
                super(outputstream);
            }
            };
            outputstream.writeLong(ie.a(ie1));
            outputstream.writeBoolean(ie.b(ie1));
            outputstream.writeInt(ie.c(ie1).length);
            outputstream.write(ie.c(ie1));
            outputstream.flush();
            return;
        }
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (ie)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
