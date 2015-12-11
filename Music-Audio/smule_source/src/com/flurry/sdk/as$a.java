// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            gx, as

public class eam
    implements gx
{

    public as a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        }
        inputstream = new DataInputStream(inputstream) {

            final as.a a;

            public void close()
            {
            }

            
            {
                a = as.a.this;
                super(inputstream);
            }
        };
        as as1 = new as(null);
        as.a(as1, inputstream.readUTF());
        as.a(as1, inputstream.readBoolean());
        as.a(as1, inputstream.readLong());
        as.a(as1, new HashMap());
        short word1 = inputstream.readShort();
        for (short word0 = 0; word0 < word1; word0++)
        {
            as.d(as1).put(inputstream.readUTF(), inputstream.readUTF());
        }

        return as1;
    }

    public void a(OutputStream outputstream, as as1)
    {
        if (outputstream == null || as1 == null)
        {
            return;
        }
        outputstream = new DataOutputStream(outputstream) {

            final as.a a;

            public void close()
            {
            }

            
            {
                a = as.a.this;
                super(outputstream);
            }
        };
        outputstream.writeUTF(as.a(as1));
        outputstream.writeBoolean(as.b(as1));
        outputstream.writeLong(as.c(as1));
        outputstream.writeShort(as.d(as1).size());
        java.util.ntry ntry;
        for (as1 = as.d(as1).entrySet().iterator(); as1.hasNext(); outputstream.writeUTF((String)ntry.getValue()))
        {
            ntry = (java.util.ntry)as1.next();
            outputstream.writeUTF((String)ntry.getKey());
        }

        outputstream.flush();
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (as)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
