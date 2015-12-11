// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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

                final cd.a a;

                public void close()
                {
                }

            
            {
                a = cd.a.this;
                super(inputstream);
            }
            };
            cd cd1 = new cd(null);
            cd1.a(inputstream.readLong());
            cd1.a(inputstream.readBoolean());
            cd1.a(inputstream.readInt());
            cd1.b(inputstream.readUTF());
            cd1.c(inputstream.readUTF());
            cd.a(cd1, inputstream.readUTF());
            cd.b(cd1, inputstream.readUTF());
            cd.a(cd1, inputstream.readBoolean());
            return cd1;
        }
    }

    public void a(OutputStream outputstream, cd cd1)
    {
        if (outputstream == null || cd1 == null)
        {
            return;
        } else
        {
            outputstream = new DataOutputStream(outputstream) {

                final cd.a a;

                public void close()
                {
                }

            
            {
                a = cd.a.this;
                super(outputstream);
            }
            };
            outputstream.writeLong(cd1.d());
            outputstream.writeBoolean(cd1.e());
            outputstream.writeInt(cd1.f());
            outputstream.writeUTF(cd1.g());
            outputstream.writeUTF(cd1.h());
            outputstream.writeUTF(cd.a(cd1));
            outputstream.writeUTF(cd.b(cd1));
            outputstream.writeBoolean(cd.c(cd1));
            outputstream.flush();
            return;
        }
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
