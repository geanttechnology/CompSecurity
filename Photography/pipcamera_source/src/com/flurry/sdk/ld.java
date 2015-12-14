// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            lb, le

public class ld
    implements lb
{

    private final String a;
    private final int b;
    private final le c;

    public ld(String s, int i, le le1)
    {
        a = s;
        b = i;
        c = le1;
    }

    public void a(OutputStream outputstream, Object obj)
    {
        if (outputstream == null || c == null)
        {
            return;
        }
        outputstream = new DataOutputStream(outputstream) {

            final ld a;

            public void close()
            {
            }

            
            {
                a = ld.this;
                super(outputstream);
            }
        };
        outputstream.writeUTF(a);
        outputstream.writeInt(b);
        lb lb1 = c.a(b);
        if (lb1 == null)
        {
            throw new IOException((new StringBuilder()).append("No serializer for version: ").append(b).toString());
        } else
        {
            lb1.a(outputstream, obj);
            outputstream.flush();
            return;
        }
    }

    public Object b(InputStream inputstream)
    {
        if (inputstream == null || c == null)
        {
            return null;
        }
        inputstream = new DataInputStream(inputstream) {

            final ld a;

            public void close()
            {
            }

            
            {
                a = ld.this;
                super(inputstream);
            }
        };
        Object obj = inputstream.readUTF();
        if (!a.equals(obj))
        {
            throw new IOException((new StringBuilder()).append("Signature: ").append(((String) (obj))).append(" is invalid").toString());
        }
        int i = inputstream.readInt();
        obj = c.a(i);
        if (obj == null)
        {
            throw new IOException((new StringBuilder()).append("No serializer for version: ").append(i).toString());
        } else
        {
            return ((lb) (obj)).b(inputstream);
        }
    }
}
