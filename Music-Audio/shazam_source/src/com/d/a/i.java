// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.content.Context;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.d.a:
//            m, u, aj, a, 
//            s, w, ak, o, 
//            h, ai

final class i
{

    Context a;
    aj b;
    h c;
    volatile long d;
    volatile boolean e;
    private m f;
    private m g;
    private Map h;
    private Map i;
    private Map j;
    private Map k;

    i()
    {
        f = new m();
        g = new m();
        h = new HashMap();
        i = new HashMap();
        j = new HashMap();
        k = new HashMap();
    }

    private u a(byte byte0)
    {
        this;
        JVM INSTR monitorenter ;
        u u1 = (u)j.get(Byte.valueOf(byte0));
        this;
        JVM INSTR monitorexit ;
        return u1;
        Exception exception;
        exception;
        throw exception;
    }

    private void a(int l)
    {
        boolean flag;
        if (!h.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
        if (e)
        {
            b.a(l);
        }
    }

    private void a(DataInputStream datainputstream)
    {
        boolean flag = false;
        if (datainputstream.readUnsignedShort() != 2)
        {
            return;
        }
        d = datainputstream.readLong();
        int j2 = datainputstream.readUnsignedShort();
        f = new m();
        for (int l = 0; l < j2; l++)
        {
            long l3 = datainputstream.readLong();
            a a1 = new a();
            a1.a(datainputstream);
            f.a(Long.valueOf(l3), a1);
        }

        j2 = datainputstream.readUnsignedShort();
        g = new m();
        for (int i1 = 0; i1 < j2; i1++)
        {
            long l4 = datainputstream.readLong();
            s s1 = new s();
            if (datainputstream.readBoolean())
            {
                s1.a = datainputstream.readUTF();
            }
            if (datainputstream.readBoolean())
            {
                s1.b = datainputstream.readUTF();
            }
            s1.c = datainputstream.readInt();
            g.a(Long.valueOf(l4), s1);
        }

        j2 = datainputstream.readUnsignedShort();
        i = new HashMap(j2);
        for (int j1 = 0; j1 < j2; j1++)
        {
            String s2 = datainputstream.readUTF();
            w w1 = new w(datainputstream);
            i.put(s2, w1);
        }

        int k2 = datainputstream.readUnsignedShort();
        h = new HashMap(k2);
        for (int k1 = 0; k1 < k2; k1++)
        {
            String s3 = datainputstream.readUTF();
            int l2 = datainputstream.readUnsignedShort();
            ak aak[] = new ak[l2];
            for (j2 = 0; j2 < l2; j2++)
            {
                ak ak1 = new ak();
                ak1.a(datainputstream);
                aak[j2] = ak1;
            }

            h.put(s3, aak);
        }

        j2 = datainputstream.readUnsignedShort();
        j = new HashMap();
        for (int l1 = 0; l1 < j2; l1++)
        {
            byte byte0 = datainputstream.readByte();
            u u1 = new u();
            u1.a(datainputstream);
            u1.ag = datainputstream.readBoolean();
            if (u1.ag)
            {
                u1.b(datainputstream);
            }
            j.put(Byte.valueOf(byte0), u1);
        }

        j2 = datainputstream.readUnsignedShort();
        k = new HashMap(j2);
        for (int i2 = ((flag) ? 1 : 0); i2 < j2; i2++)
        {
            short word0 = datainputstream.readShort();
            long l5 = datainputstream.readLong();
            k.put(Short.valueOf(word0), Long.valueOf(l5));
        }

        d();
        (new StringBuilder("Cache read, num images: ")).append(f.a());
    }

    private void a(DataOutputStream dataoutputstream)
    {
        dataoutputstream.writeShort(2);
        dataoutputstream.writeLong(d);
        Object obj = f.b();
        dataoutputstream.writeShort(((List) (obj)).size());
        Object obj1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); dataoutputstream.write(((a) (obj1)).e))
        {
            obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
            dataoutputstream.writeLong(((Long)((java.util.Map.Entry) (obj1)).getKey()).longValue());
            obj1 = (a)((java.util.Map.Entry) (obj1)).getValue();
            dataoutputstream.writeLong(((a) (obj1)).a);
            dataoutputstream.writeInt(((a) (obj1)).b);
            dataoutputstream.writeInt(((a) (obj1)).c);
            dataoutputstream.writeUTF(((a) (obj1)).d);
            dataoutputstream.writeInt(((a) (obj1)).e.length);
        }

        obj = g.b();
        dataoutputstream.writeShort(((List) (obj)).size());
        obj = ((List) (obj)).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            Object obj2 = (java.util.Map.Entry)((Iterator) (obj)).next();
            dataoutputstream.writeLong(((Long)((java.util.Map.Entry) (obj2)).getKey()).longValue());
            obj2 = (s)((java.util.Map.Entry) (obj2)).getValue();
            boolean flag;
            if (((s) (obj2)).a != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            dataoutputstream.writeBoolean(flag);
            if (flag)
            {
                dataoutputstream.writeUTF(((s) (obj2)).a);
            }
            if (((s) (obj2)).b != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            dataoutputstream.writeBoolean(flag);
            if (flag)
            {
                dataoutputstream.writeUTF(((s) (obj2)).b);
            }
            dataoutputstream.writeInt(((s) (obj2)).c);
        }
        dataoutputstream.writeShort(i.size());
        Object obj3;
        for (obj = i.entrySet().iterator(); ((Iterator) (obj)).hasNext(); dataoutputstream.writeByte(((w) (obj3)).c))
        {
            obj3 = (java.util.Map.Entry)((Iterator) (obj)).next();
            dataoutputstream.writeUTF((String)((java.util.Map.Entry) (obj3)).getKey());
            obj3 = (w)((java.util.Map.Entry) (obj3)).getValue();
            dataoutputstream.writeUTF(((w) (obj3)).a);
            dataoutputstream.writeByte(((w) (obj3)).b);
        }

        dataoutputstream.writeShort(h.size());
        for (obj = h.entrySet().iterator(); ((Iterator) (obj)).hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            dataoutputstream.writeUTF((String)entry.getKey());
            ak aak[] = (ak[])entry.getValue();
            int l;
            int i1;
            if (aak == null)
            {
                l = 0;
            } else
            {
                l = aak.length;
            }
            dataoutputstream.writeShort(l);
            i1 = 0;
            while (i1 < l) 
            {
                ak ak1 = aak[i1];
                dataoutputstream.writeLong(ak1.a);
                dataoutputstream.writeLong(ak1.b);
                dataoutputstream.writeUTF(ak1.d);
                dataoutputstream.writeUTF(ak1.c);
                dataoutputstream.writeLong(ak1.e);
                dataoutputstream.writeLong(ak1.f.longValue());
                dataoutputstream.writeByte(ak1.g.length);
                dataoutputstream.write(ak1.g);
                i1++;
            }
        }

        dataoutputstream.writeShort(j.size());
        obj = j.entrySet().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj4 = (java.util.Map.Entry)((Iterator) (obj)).next();
            dataoutputstream.writeByte(((Byte)((java.util.Map.Entry) (obj4)).getKey()).byteValue());
            obj4 = (u)((java.util.Map.Entry) (obj4)).getValue();
            dataoutputstream.writeByte(((u) (obj4)).a);
            dataoutputstream.writeUTF(((u) (obj4)).b);
            dataoutputstream.writeLong(((u) (obj4)).c);
            dataoutputstream.writeLong(((u) (obj4)).d);
            dataoutputstream.writeUTF(((u) (obj4)).e);
            dataoutputstream.writeShort(((u) (obj4)).f);
            dataoutputstream.writeInt(((u) (obj4)).g);
            dataoutputstream.writeUTF(((u) (obj4)).h);
            dataoutputstream.writeShort(((u) (obj4)).i);
            dataoutputstream.writeInt(((u) (obj4)).j);
            dataoutputstream.writeUTF(((u) (obj4)).k);
            dataoutputstream.writeShort(((u) (obj4)).l);
            dataoutputstream.writeInt(((u) (obj4)).m);
            dataoutputstream.writeBoolean(((u) (obj4)).ag);
            if (((u) (obj4)).ag)
            {
                dataoutputstream.writeUTF(((u) (obj4)).n);
                dataoutputstream.writeShort(((u) (obj4)).o);
                dataoutputstream.writeInt(((u) (obj4)).p);
                dataoutputstream.writeUTF(((u) (obj4)).q);
                dataoutputstream.writeShort(((u) (obj4)).r);
                dataoutputstream.writeInt(((u) (obj4)).s);
                dataoutputstream.writeUTF(((u) (obj4)).t);
                dataoutputstream.writeShort(((u) (obj4)).u);
                dataoutputstream.writeInt(((u) (obj4)).v);
                dataoutputstream.writeInt(((u) (obj4)).w);
                dataoutputstream.writeInt(((u) (obj4)).x);
                dataoutputstream.writeInt(((u) (obj4)).y);
                dataoutputstream.writeInt(((u) (obj4)).z);
                dataoutputstream.writeInt(((u) (obj4)).A);
                dataoutputstream.writeInt(((u) (obj4)).B);
                dataoutputstream.writeInt(((u) (obj4)).C);
                dataoutputstream.writeInt(((u) (obj4)).D);
                dataoutputstream.writeInt(((u) (obj4)).E);
                dataoutputstream.writeInt(((u) (obj4)).F);
                dataoutputstream.writeInt(((u) (obj4)).G);
                dataoutputstream.writeInt(((u) (obj4)).H);
                dataoutputstream.writeInt(((u) (obj4)).I);
                dataoutputstream.writeInt(((u) (obj4)).J);
                dataoutputstream.writeInt(((u) (obj4)).K);
                dataoutputstream.writeInt(((u) (obj4)).L);
                dataoutputstream.writeInt(((u) (obj4)).M);
                dataoutputstream.writeInt(((u) (obj4)).N);
                dataoutputstream.writeInt(((u) (obj4)).O);
                dataoutputstream.writeInt(((u) (obj4)).P);
                dataoutputstream.writeInt(((u) (obj4)).Q);
                dataoutputstream.writeInt(((u) (obj4)).R);
                dataoutputstream.writeInt(((u) (obj4)).S);
                dataoutputstream.writeInt(((u) (obj4)).T);
                dataoutputstream.writeInt(((u) (obj4)).U);
                dataoutputstream.writeInt(((u) (obj4)).V);
                dataoutputstream.writeInt(((u) (obj4)).W);
                dataoutputstream.writeInt(((u) (obj4)).X);
                dataoutputstream.writeInt(((u) (obj4)).Y);
                dataoutputstream.writeInt(((u) (obj4)).Z);
                dataoutputstream.writeInt(((u) (obj4)).aa);
                dataoutputstream.writeInt(((u) (obj4)).ab);
                dataoutputstream.writeInt(((u) (obj4)).ac);
                dataoutputstream.writeInt(((u) (obj4)).ad);
                dataoutputstream.writeInt(((u) (obj4)).ae);
                dataoutputstream.writeInt(((u) (obj4)).af);
            }
        } while (true);
        dataoutputstream.writeShort(k.size());
        java.util.Map.Entry entry1;
        for (Iterator iterator = k.entrySet().iterator(); iterator.hasNext(); dataoutputstream.writeLong(((Long)entry1.getValue()).longValue()))
        {
            entry1 = (java.util.Map.Entry)iterator.next();
            dataoutputstream.writeShort(((Short)entry1.getKey()).shortValue());
        }

    }

    private static void a(File file)
    {
        if (!file.delete())
        {
            o.a("FlurryAgent", "Cannot delete cached ads");
        }
    }

    private s b(long l)
    {
        this;
        JVM INSTR monitorenter ;
        s s1 = (s)g.a(Long.valueOf(l));
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    private void d()
    {
        for (Iterator iterator = j.values().iterator(); iterator.hasNext(); iterator.next()) { }
        Iterator iterator1 = h.values().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            ak aak[] = (ak[])iterator1.next();
            if (aak != null)
            {
                int i1 = aak.length;
                int l = 0;
                while (l < i1) 
                {
                    ak ak1 = aak[l];
                    ak1.h = a(ak1.f.longValue());
                    if (ak1.h == null)
                    {
                        o.a("FlurryAgent", (new StringBuilder("Ad ")).append(ak1.d).append(" has no image").toString());
                    }
                    if (b(ak1.a) == null)
                    {
                        o.a("FlurryAgent", (new StringBuilder("Ad ")).append(ak1.d).append(" has no pricing").toString());
                    }
                    l++;
                }
            }
        } while (true);
        iterator1 = i.values().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            w w1 = (w)iterator1.next();
            w1.d = a(w1.c);
            if (w1.d == null)
            {
                (new StringBuilder("No ad theme found for ")).append(w1.c);
            }
        } while (true);
    }

    private String e()
    {
        return (new StringBuilder(".flurryappcircle.")).append(Integer.toString(c.a.hashCode(), 16)).toString();
    }

    final a a(long l)
    {
        this;
        JVM INSTR monitorenter ;
        a a1 = (a)f.a(Long.valueOf(l));
        this;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    final Set a()
    {
        this;
        JVM INSTR monitorenter ;
        Set set = f.c();
        this;
        JVM INSTR monitorexit ;
        return set;
        Exception exception;
        exception;
        throw exception;
    }

    final void a(Map map, Map map1, Map map2, Map map3, Map map4, Map map5)
    {
        this;
        JVM INSTR monitorenter ;
        d = System.currentTimeMillis();
        map3 = map3.entrySet().iterator();
        do
        {
            if (!map3.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map3.next();
            if (entry.getValue() != null)
            {
                f.a(entry.getKey(), entry.getValue());
            }
        } while (true);
        break MISSING_BLOCK_LABEL_84;
        map;
        throw map;
        map3 = map4.entrySet().iterator();
        do
        {
            if (!map3.hasNext())
            {
                break;
            }
            map4 = (java.util.Map.Entry)map3.next();
            if (map4.getValue() != null)
            {
                g.a(map4.getKey(), map4.getValue());
            }
        } while (true);
        if (map1 == null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        if (!map1.isEmpty())
        {
            i = map1;
        }
        if (map2 == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        if (!map2.isEmpty())
        {
            j = map2;
        }
        if (map5 == null)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        if (!map5.isEmpty())
        {
            k = map5;
        }
        h = new HashMap();
        map1 = map1.entrySet().iterator();
_L2:
        if (!map1.hasNext())
        {
            break MISSING_BLOCK_LABEL_343;
        }
        map4 = (java.util.Map.Entry)map1.next();
        map3 = (w)map4.getValue();
        map5 = (ak[])map.get(Byte.valueOf(((w) (map3)).b));
        if (map5 == null)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        h.put(map4.getKey(), map5);
        map4 = (u)map2.get(Byte.valueOf(((w) (map3)).c));
        if (map4 == null) goto _L2; else goto _L1
_L1:
        map3.d = map4;
          goto _L2
        d();
        a(202);
        this;
        JVM INSTR monitorexit ;
    }

    final ak[] a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ak aak[] = (ak[])h.get(s1);
        s1 = aak;
        if (aak != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        s1 = (ak[])h.get("");
        this;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        throw s1;
    }

    final w b(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        w w1 = (w)i.get(s1);
        s1 = w1;
        if (w1 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        s1 = (w)i.get("");
        this;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        throw s1;
    }

    final void b()
    {
        this;
        JVM INSTR monitorenter ;
        File file;
        boolean flag;
        file = a.getFileStreamPath(e());
        flag = file.exists();
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj = null;
        Object obj1 = new DataInputStream(new FileInputStream(file));
        obj = obj1;
        if (((DataInputStream) (obj1)).readUnsignedShort() != 46587) goto _L4; else goto _L3
_L3:
        obj = obj1;
        a(((DataInputStream) (obj1)));
        obj = obj1;
        a(201);
_L5:
        ai.a(((java.io.Closeable) (obj1)));
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        obj = obj1;
        a(file);
          goto _L5
        obj;
_L8:
        obj = obj1;
        a(file);
        ai.a(((java.io.Closeable) (obj1)));
          goto _L6
        obj;
        throw obj;
        obj1;
_L7:
        ai.a(((java.io.Closeable) (obj)));
        throw obj1;
_L2:
        (new StringBuilder("cache file does not exist, path=")).append(file.getAbsolutePath());
          goto _L6
        obj1;
          goto _L7
        Throwable throwable;
        throwable;
        obj1 = null;
          goto _L8
    }

    final void c()
    {
        Object obj1 = null;
        Object obj2 = null;
        this;
        JVM INSTR monitorenter ;
        Object obj = obj1;
        File file = a.getFileStreamPath(e());
        obj = obj1;
        File file1 = file.getParentFile();
        obj = obj1;
        if (file1.mkdirs()) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if (file1.exists()) goto _L2; else goto _L3
_L3:
        obj = obj1;
        o.a("FlurryAgent", (new StringBuilder("Unable to create persistent dir: ")).append(file1).toString());
        ai.a(null);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj = obj1;
        obj1 = new DataOutputStream(new FileOutputStream(file));
        ((DataOutputStream) (obj1)).writeShort(46587);
        a(((DataOutputStream) (obj1)));
        ai.a(((java.io.Closeable) (obj1)));
          goto _L4
        obj;
        throw obj;
        obj;
        obj1 = obj2;
        obj2 = obj;
_L6:
        obj = obj1;
        o.a("FlurryAgent", "", ((Throwable) (obj2)));
        ai.a(((java.io.Closeable) (obj1)));
          goto _L4
_L5:
        ai.a(((java.io.Closeable) (obj)));
        throw obj1;
        obj2;
        obj = obj1;
        obj1 = obj2;
          goto _L5
        obj2;
          goto _L6
        obj1;
          goto _L5
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{");
        stringbuilder.append((new StringBuilder("adImages (")).append(f.b().size()).append("),\n").toString());
        stringbuilder.append((new StringBuilder("adBlock (")).append(h.size()).append("):").toString()).append(",\n");
        java.util.Map.Entry entry;
        for (Iterator iterator = h.entrySet().iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder("\t")).append((String)entry.getKey()).append(": ").append(Arrays.toString((Object[])entry.getValue())).toString()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        stringbuilder.append((new StringBuilder("adHooks (")).append(i.size()).append("):").append(i).toString()).append(",\n");
        stringbuilder.append((new StringBuilder("adThemes (")).append(j.size()).append("):").append(j).toString()).append(",\n");
        stringbuilder.append((new StringBuilder("auxMap (")).append(k.size()).append("):").append(k).toString()).append(",\n");
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
