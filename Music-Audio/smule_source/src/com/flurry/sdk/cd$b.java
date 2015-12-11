// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            gx, cd

public class eam
    implements gx
{

    public cd a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            inputstream = new DataInputStream(inputstream) {

                final cd.b a;

                public void close()
                {
                }

            
            {
                a = cd.b.this;
                super(inputstream);
            }
            };
            cd cd1 = new cd(null);
            cd.a(cd1, inputstream.readUTF());
            cd.b(cd1, inputstream.readUTF());
            cd1.a(inputstream.readUTF());
            cd1.a(inputstream.readLong());
            cd.a(cd1, inputstream.readBoolean());
            cd1.a(inputstream.readBoolean());
            cd1.a(inputstream.readInt());
            return cd1;
        }
    }

    public void a(OutputStream outputstream, cd cd1)
    {
        throw new UnsupportedOperationException("Serialization not supported");
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (cd)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
