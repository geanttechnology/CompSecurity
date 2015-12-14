// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            kx, ks

public class eam
    implements kx
{

    public ks a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            inputstream = new DataInputStream(inputstream) {

                final ks.a a;

                public void close()
                {
                }

            
            {
                a = ks.a.this;
                super(inputstream);
            }
            };
            ks ks1 = new ks(null);
            ks.a(ks1, inputstream.readUTF());
            return ks1;
        }
    }

    public void a(OutputStream outputstream, ks ks1)
    {
        if (outputstream == null || ks1 == null)
        {
            return;
        } else
        {
            outputstream = new DataOutputStream(outputstream) {

                final ks.a a;

                public void close()
                {
                }

            
            {
                a = ks.a.this;
                super(outputstream);
            }
            };
            outputstream.writeUTF(ks.a(ks1));
            outputstream.flush();
            return;
        }
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (ks)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
