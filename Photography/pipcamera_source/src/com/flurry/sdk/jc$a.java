// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            lb, jc, iz

public class eam
    implements lb
{

    public jc a(InputStream inputstream)
    {
        if (inputstream != null) goto _L2; else goto _L1
_L1:
        inputstream = null;
_L4:
        return inputstream;
_L2:
        DataInputStream datainputstream = new DataInputStream(inputstream) {

            final jc.a a;

            public void close()
            {
            }

            
            {
                a = jc.a.this;
                super(inputstream);
            }
        };
        jc jc1 = new jc();
        datainputstream.readUTF();
        datainputstream.readUTF();
        jc.a(jc1, datainputstream.readBoolean());
        jc.a(jc1, datainputstream.readLong());
        do
        {
            int i = datainputstream.readUnsignedShort();
            inputstream = jc1;
            if (i == 0)
            {
                continue;
            }
            inputstream = new byte[i];
            datainputstream.readFully(inputstream);
            inputstream = new iz(inputstream);
            jc.a(jc1).add(0, inputstream);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(OutputStream outputstream, jc jc1)
    {
        throw new UnsupportedOperationException("Serialization not supported");
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (jc)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
