// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            lb, il, ik

public class eam
    implements lb
{

    public ik a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            Object obj = new DataInputStream(inputstream) {

                final ik.a a;

                public void close()
                {
                }

            
            {
                a = ik.a.this;
                super(inputstream);
            }
            };
            int i = ((DataInputStream) (obj)).readInt();
            long l = ((DataInputStream) (obj)).readLong();
            long l1 = ((DataInputStream) (obj)).readLong();
            boolean flag = ((DataInputStream) (obj)).readBoolean();
            int j = ((DataInputStream) (obj)).readInt();
            inputstream = il.a(((DataInputStream) (obj)).readInt());
            String s = ((DataInputStream) (obj)).readUTF();
            int k = ((DataInputStream) (obj)).readInt();
            long l2 = ((DataInputStream) (obj)).readLong();
            boolean flag1 = ((DataInputStream) (obj)).readBoolean();
            long l3 = ((DataInputStream) (obj)).readLong();
            obj = new ik(null, l, l1, i);
            obj.d = flag;
            obj.e = j;
            obj.f = inputstream;
            obj.g = s;
            obj.h = k;
            obj.i = l2;
            obj.j = flag1;
            obj.k = l3;
            return ((ik) (obj));
        }
    }

    public void a(OutputStream outputstream, ik ik1)
    {
        if (outputstream == null || ik1 == null)
        {
            return;
        }
        outputstream = new DataOutputStream(outputstream) {

            final ik.a a;

            public void close()
            {
            }

            
            {
                a = ik.a.this;
                super(outputstream);
            }
        };
        outputstream.writeInt(ik1.a);
        outputstream.writeLong(ik1.b);
        outputstream.writeLong(ik1.c);
        outputstream.writeBoolean(ik1.d);
        outputstream.writeInt(ik1.e);
        outputstream.writeInt(ik1.f.a());
        if (ik1.g != null)
        {
            outputstream.writeUTF(ik1.g);
        } else
        {
            outputstream.writeUTF("");
        }
        outputstream.writeInt(ik1.h);
        outputstream.writeLong(ik1.i);
        outputstream.writeBoolean(ik1.j);
        outputstream.writeLong(ik1.k);
        outputstream.flush();
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (ik)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
    }
}
