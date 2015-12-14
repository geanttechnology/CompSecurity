// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            kx, im

public class eam
    implements kx
{

    public im a(InputStream inputstream)
    {
        if (inputstream != null)
        {
            inputstream = new DataInputStream(inputstream) {

                final im.a a;

                public void close()
                {
                }

            
            {
                a = im.a.this;
                super(inputstream);
            }
            };
            short word0 = inputstream.readShort();
            if (word0 != 0)
            {
                im im1 = new im();
                im.a(im1, new byte[word0]);
                inputstream.readFully(im.a(im1));
                inputstream.readUnsignedShort();
                return im1;
            }
        }
        return null;
    }

    public void a(OutputStream outputstream, im im1)
    {
        if (outputstream == null || im1 == null)
        {
            return;
        } else
        {
            outputstream = new DataOutputStream(outputstream) {

                final im.a a;

                public void close()
                {
                }

            
            {
                a = im.a.this;
                super(outputstream);
            }
            };
            outputstream.writeShort(im.a(im1).length);
            outputstream.write(im.a(im1));
            outputstream.writeShort(0);
            outputstream.flush();
            return;
        }
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (im)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
