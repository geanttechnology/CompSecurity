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
//            kx, kw, in, ig

public class <init>
    implements kx
{

    kw a;

    public ig a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        }
        DataInputStream datainputstream = new DataInputStream(inputstream) {

            final ig.a a;

            public void close()
            {
            }

            
            {
                a = ig.a.this;
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
        in in1 = in.a(datainputstream.readInt());
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
        obj = new ig(((String) (obj)), l2, s2, l1, l, i1, in1, ((Map) (obj1)), j, j1, s);
        ig.a(((ig) (obj)), l3);
        ig.a(((ig) (obj)), flag);
        ((ig) (obj)).b(k);
        obj.a = (ArrayList)a.a(inputstream);
        ((ig) (obj)).o();
        return ((ig) (obj));
    }

    public void a(OutputStream outputstream, ig ig1)
    {
        if (outputstream == null || ig1 == null)
        {
            return;
        }
        DataOutputStream dataoutputstream = new DataOutputStream(outputstream) {

            final ig.a a;

            public void close()
            {
            }

            
            {
                a = ig.a.this;
                super(outputstream);
            }
        };
        Map map;
        if (ig.a(ig1) != null)
        {
            dataoutputstream.writeUTF(ig.a(ig1));
        } else
        {
            dataoutputstream.writeUTF("");
        }
        if (ig1.t() != null)
        {
            dataoutputstream.writeUTF(ig1.t());
        } else
        {
            dataoutputstream.writeUTF("");
        }
        dataoutputstream.writeLong(ig1.p());
        dataoutputstream.writeInt(ig1.r());
        dataoutputstream.writeLong(ig.b(ig1));
        dataoutputstream.writeInt(ig.c(ig1));
        dataoutputstream.writeInt(ig.d(ig1));
        dataoutputstream.writeInt(ig.e(ig1).a());
        map = ig.f(ig1);
        if (map != null)
        {
            dataoutputstream.writeInt(ig.f(ig1).size());
            String s;
            for (Iterator iterator = ig.f(ig1).keySet().iterator(); iterator.hasNext(); dataoutputstream.writeUTF((String)map.get(s)))
            {
                s = (String)iterator.next();
                dataoutputstream.writeUTF(s);
            }

        } else
        {
            dataoutputstream.writeInt(0);
        }
        dataoutputstream.writeLong(ig.g(ig1));
        dataoutputstream.writeInt(ig.h(ig1));
        dataoutputstream.writeInt(ig.i(ig1));
        if (ig.j(ig1) != null)
        {
            dataoutputstream.writeUTF(ig.j(ig1));
        } else
        {
            dataoutputstream.writeUTF("");
        }
        dataoutputstream.writeBoolean(ig.k(ig1));
        dataoutputstream.flush();
        a.a(outputstream, ig1.a);
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (ig)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public eam()
    {
        a = new kw(new <init>());
    }
}
