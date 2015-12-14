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

public class 
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
            class _cls2 extends DataInputStream
            {

                final ip.a a;

                public void close()
                {
                }

            _cls2(InputStream inputstream)
            {
                a = ip.a.this;
                super(inputstream);
            }
            }

            _cls2 _lcls2 = new _cls2(inputstream);
            short word0 = _lcls2.readShort();
            inputstream = obj;
            if (word0 != 0)
            {
                ip ip1 = new ip();
                ip.a(ip1, new byte[word0]);
                _lcls2.readFully(ip.a(ip1));
                inputstream = ip1;
                if (_lcls2.readUnsignedShort() == 0)
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
            class _cls1 extends DataOutputStream
            {

                final ip.a a;

                public void close()
                {
                }

            _cls1(OutputStream outputstream)
            {
                a = ip.a.this;
                super(outputstream);
            }
            }

            outputstream = new _cls1(outputstream);
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

    public ()
    {
    }
}
