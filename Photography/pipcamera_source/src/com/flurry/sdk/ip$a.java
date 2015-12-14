// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            lb, ip

public class eam
    implements lb
{

    public ip a(InputStream inputstream)
    {
        Object obj = null;
        if (inputstream == null)
        {
            inputstream = obj;
        } else
        {
            DataInputStream datainputstream = new DataInputStream(inputstream) {

                final ip.a a;

                public void close()
                {
                }

            
            {
                a = ip.a.this;
                super(inputstream);
            }
            };
            short word0 = datainputstream.readShort();
            inputstream = obj;
            if (word0 != 0)
            {
                ip ip1 = new ip();
                ip.a(ip1, new byte[word0]);
                datainputstream.readFully(ip.a(ip1));
                inputstream = ip1;
                if (datainputstream.readUnsignedShort() == 0)
                {
                    return ip1;
                }
            }
        }
        return inputstream;
    }

    public void a(OutputStream outputstream, ip ip1)
    {
        if (outputstream == null || ip1 == null)
        {
            return;
        } else
        {
            outputstream = new DataOutputStream(outputstream) {

                final ip.a a;

                public void close()
                {
                }

            
            {
                a = ip.a.this;
                super(outputstream);
            }
            };
            outputstream.writeShort(ip.a(ip1).length);
            outputstream.write(ip.a(ip1));
            outputstream.writeShort(0);
            outputstream.flush();
            return;
        }
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (ip)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
