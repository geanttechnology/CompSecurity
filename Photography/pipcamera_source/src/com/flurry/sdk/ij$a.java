// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            lb, la, iq, ij

public class <init>
    implements lb
{

    la a;

    public ij a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        }
        DataInputStream datainputstream = new DataInputStream(inputstream) {

            final ij.a a;

            public void close()
            {
            }

            
            {
                a = ij.a.this;
                super(inputstream);
            }
        };
        Object obj1 = datainputstream.readUTF();
        Object obj = obj1;
        if (((String) (obj1)).equals(""))
        {
            obj = null;
        }
        String s2 = datainputstream.readUTF();
        long l1 = datainputstream.readLong();
        int k = datainputstream.readInt();
        long l2 = datainputstream.readLong();
        int l = datainputstream.readInt();
        int i1 = datainputstream.readInt();
        iq iq1 = iq.a(datainputstream.readInt());
        obj1 = null;
        int j1 = datainputstream.readInt();
        if (j1 != 0)
        {
            HashMap hashmap = new HashMap();
            int i = 0;
            do
            {
                obj1 = hashmap;
                if (i >= j1)
                {
                    break;
                }
                hashmap.put(datainputstream.readUTF(), datainputstream.readUTF());
                i++;
            } while (true);
        }
        long l3 = datainputstream.readLong();
        int j = datainputstream.readInt();
        j1 = datainputstream.readInt();
        String s1 = datainputstream.readUTF();
        String s = s1;
        if (s1.equals(""))
        {
            s = null;
        }
        boolean flag = datainputstream.readBoolean();
        obj = new ij(((String) (obj)), l2, s2, l1, l, i1, iq1, ((Map) (obj1)), j, j1, s);
        ij.a(((ij) (obj)), l3);
        ij.a(((ij) (obj)), flag);
        ((ij) (obj)).b(k);
        obj.a = (ArrayList)a.a(inputstream);
        ((ij) (obj)).o();
        return ((ij) (obj));
    }

    public void a(OutputStream outputstream, ij ij1)
    {
        if (outputstream == null || ij1 == null)
        {
            return;
        }
        DataOutputStream dataoutputstream = new DataOutputStream(outputstream) {

            final ij.a a;

            public void close()
            {
            }

            
            {
                a = ij.a.this;
                super(outputstream);
            }
        };
        Map map;
        if (ij.a(ij1) != null)
        {
            dataoutputstream.writeUTF(ij.a(ij1));
        } else
        {
            dataoutputstream.writeUTF("");
        }
        if (ij1.t() != null)
        {
            dataoutputstream.writeUTF(ij1.t());
        } else
        {
            dataoutputstream.writeUTF("");
        }
        dataoutputstream.writeLong(ij1.p());
        dataoutputstream.writeInt(ij1.r());
        dataoutputstream.writeLong(ij.b(ij1));
        dataoutputstream.writeInt(ij.c(ij1));
        dataoutputstream.writeInt(ij.d(ij1));
        dataoutputstream.writeInt(ij.e(ij1).a());
        map = ij.f(ij1);
        if (map != null)
        {
            dataoutputstream.writeInt(ij.f(ij1).size());
            String s;
            for (Iterator iterator = ij.f(ij1).keySet().iterator(); iterator.hasNext(); dataoutputstream.writeUTF((String)map.get(s)))
            {
                s = (String)iterator.next();
                dataoutputstream.writeUTF(s);
            }

        } else
        {
            dataoutputstream.writeInt(0);
        }
        dataoutputstream.writeLong(ij.g(ij1));
        dataoutputstream.writeInt(ij.h(ij1));
        dataoutputstream.writeInt(ij.i(ij1));
        if (ij.j(ij1) != null)
        {
            dataoutputstream.writeUTF(ij.j(ij1));
        } else
        {
            dataoutputstream.writeUTF("");
        }
        dataoutputstream.writeBoolean(ij.k(ij1));
        dataoutputstream.flush();
        a.a(outputstream, ij1.a);
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (ij)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
        a = new la(new <init>());
    }
}
