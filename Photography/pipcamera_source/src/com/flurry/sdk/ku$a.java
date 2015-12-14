// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            lb, ku

public class eam
    implements lb
{

    public ku a(InputStream inputstream)
    {
        if (inputstream != null)
        {
            inputstream = new DataInputStream(inputstream) {

                final ku.a a;

                public void close()
                {
                }

            
            {
                a = ku.a.this;
                super(inputstream);
            }
            };
            ku ku1 = new ku(null);
            short word0 = inputstream.readShort();
            if (word0 != 0)
            {
                ku.a(ku1, new byte[word0]);
                inputstream.readFully(ku.a(ku1));
                if (inputstream.readUnsignedShort() != 0);
                return ku1;
            }
        }
        return null;
    }

    public void a(OutputStream outputstream, ku ku1)
    {
        if (outputstream == null || ku1 == null)
        {
            return;
        } else
        {
            outputstream = new DataOutputStream(outputstream) {

                final ku.a a;

                public void close()
                {
                }

            
            {
                a = ku.a.this;
                super(outputstream);
            }
            };
            outputstream.writeShort(ku.a(ku1).length);
            outputstream.write(ku.a(ku1));
            outputstream.writeShort(0);
            outputstream.flush();
            return;
        }
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (ku)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
