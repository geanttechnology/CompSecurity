// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            gx, gs

public class eam
    implements gx
{

    public gs a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            inputstream = new DataInputStream(inputstream) {

                final gs.a a;

                public void close()
                {
                }

            
            {
                a = gs.a.this;
                super(inputstream);
            }
            };
            gs gs1 = new gs(null);
            gs.a(gs1, inputstream.readUTF());
            return gs1;
        }
    }

    public void a(OutputStream outputstream, gs gs1)
    {
        if (outputstream == null || gs1 == null)
        {
            return;
        } else
        {
            outputstream = new DataOutputStream(outputstream) {

                final gs.a a;

                public void close()
                {
                }

            
            {
                a = gs.a.this;
                super(outputstream);
            }
            };
            outputstream.writeUTF(gs.a(gs1));
            outputstream.flush();
            return;
        }
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (gs)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
