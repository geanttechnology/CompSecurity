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
        class _cls2 extends DataInputStream
        {

            final ij.a a;

            public void close()
            {
            }

            _cls2(InputStream inputstream)
            {
                a = ij.a.this;
                super(inputstream);
            }
        }

        _cls2 _lcls2 = new _cls2(inputstream);
        Object obj1 = _lcls2.readUTF();
        Object obj = obj1;
        if (((String) (obj1)).equals(""))
        {
            obj = null;
        }
        String s2 = _lcls2.readUTF();
        long l1 = _lcls2.readLong();
        int k = _lcls2.readInt();
        long l2 = _lcls2.readLong();
        int l = _lcls2.readInt();
        int i1 = _lcls2.readInt();
        iq iq1 = iq.a(_lcls2.readInt());
        obj1 = null;
        int j1 = _lcls2.readInt();
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
                hashmap.put(_lcls2.readUTF(), _lcls2.readUTF());
                i++;
            } while (true);
        }
        long l3 = _lcls2.readLong();
        int j = _lcls2.readInt();
        j1 = _lcls2.readInt();
        String s1 = _lcls2.readUTF();
        String s = s1;
        if (s1.equals(""))
        {
            s = null;
        }
        boolean flag = _lcls2.readBoolean();
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
        class _cls1 extends DataOutputStream
        {

            final ij.a a;

            public void close()
            {
            }

            _cls1(OutputStream outputstream)
            {
                a = ij.a.this;
                super(outputstream);
            }
        }

        _cls1 _lcls1 = new _cls1(outputstream);
        Map map;
        if (ij.a(ij1) != null)
        {
            _lcls1.writeUTF(ij.a(ij1));
        } else
        {
            _lcls1.writeUTF("");
        }
        if (ij1.t() != null)
        {
            _lcls1.writeUTF(ij1.t());
        } else
        {
            _lcls1.writeUTF("");
        }
        _lcls1.writeLong(ij1.p());
        _lcls1.writeInt(ij1.r());
        _lcls1.writeLong(ij.b(ij1));
        _lcls1.writeInt(ij.c(ij1));
        _lcls1.writeInt(ij.d(ij1));
        _lcls1.writeInt(ij.e(ij1).a());
        map = ij.f(ij1);
        if (map != null)
        {
            _lcls1.writeInt(ij.f(ij1).size());
            String s;
            for (Iterator iterator = ij.f(ij1).keySet().iterator(); iterator.hasNext(); _lcls1.writeUTF((String)map.get(s)))
            {
                s = (String)iterator.next();
                _lcls1.writeUTF(s);
            }

        } else
        {
            _lcls1.writeInt(0);
        }
        _lcls1.writeLong(ij.g(ij1));
        _lcls1.writeInt(ij.h(ij1));
        _lcls1.writeInt(ij.i(ij1));
        if (ij.j(ij1) != null)
        {
            _lcls1.writeUTF(ij.j(ij1));
        } else
        {
            _lcls1.writeUTF("");
        }
        _lcls1.writeBoolean(ij.k(ij1));
        _lcls1.flush();
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

    public ()
    {
        a = new la(new <init>());
    }
}
