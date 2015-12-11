// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            gx, at, as

public class a
    implements gx
{

    private final a a;

    public at a(InputStream inputstream)
    {
        Object obj = null;
        if (inputstream == null || a == null)
        {
            return null;
        }
        DataInputStream datainputstream = new DataInputStream(inputstream) {

            final at.a a;

            public void close()
            {
            }

            
            {
                a = at.a.this;
                super(inputstream);
            }
        };
        at at1 = new at(null);
        at.a(at1, datainputstream.readInt());
        at.a(at1, datainputstream.readLong());
        inputstream = datainputstream.readUTF();
        if (inputstream.equals(""))
        {
            inputstream = obj;
        }
        at.a(at1, inputstream);
        at.a(at1, new ArrayList());
        short word1 = datainputstream.readShort();
        for (short word0 = 0; word0 < word1; word0++)
        {
            at.d(at1).add(a.a(datainputstream));
        }

        return at1;
    }

    public void a(OutputStream outputstream, at at1)
    {
        if (outputstream == null || at1 == null || a == null)
        {
            return;
        }
        DataOutputStream dataoutputstream = new DataOutputStream(outputstream) {

            final at.a a;

            public void close()
            {
            }

            
            {
                a = at.a.this;
                super(outputstream);
            }
        };
        dataoutputstream.writeInt(at.a(at1));
        dataoutputstream.writeLong(at.b(at1));
        if (at.c(at1) == null)
        {
            outputstream = "";
        } else
        {
            outputstream = at.c(at1);
        }
        dataoutputstream.writeUTF(outputstream);
        dataoutputstream.writeShort(at.d(at1).size());
        for (outputstream = at.d(at1).iterator(); outputstream.hasNext(); a.a(dataoutputstream, at1))
        {
            at1 = (as)outputstream.next();
        }

        dataoutputstream.flush();
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (at)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam(eam eam)
    {
        a = eam;
    }
}
