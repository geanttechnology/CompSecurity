// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            gx, ae, an, ah

public class eam
    implements gx
{

    public ae a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            inputstream = new DataInputStream(inputstream) {

                final ae.a a;

                public void close()
                {
                }

            
            {
                a = ae.a.this;
                super(inputstream);
            }
            };
            ae ae1 = new ae(null);
            ae.a(ae1, inputstream.readUTF());
            ae.a(ae1, an.a(inputstream.readInt()));
            ae.a(ae1, inputstream.readLong());
            ae.b(ae1, inputstream.readLong());
            ae.a(ae1, ah.a(inputstream.readInt()));
            ae.c(ae1, inputstream.readLong());
            ae.d(ae1, inputstream.readLong());
            return ae1;
        }
    }

    public void a(OutputStream outputstream, ae ae1)
    {
        if (outputstream == null || ae1 == null)
        {
            return;
        } else
        {
            outputstream = new DataOutputStream(outputstream) {

                final ae.a a;

                public void close()
                {
                }

            
            {
                a = ae.a.this;
                super(outputstream);
            }
            };
            outputstream.writeUTF(ae.a(ae1));
            outputstream.writeInt(ae.b(ae1).a());
            outputstream.writeLong(ae.c(ae1));
            outputstream.writeLong(ae.d(ae1));
            outputstream.writeInt(ae.e(ae1).a());
            outputstream.writeLong(ae.f(ae1));
            outputstream.writeLong(ae.g(ae1));
            outputstream.flush();
            return;
        }
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (ae)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
