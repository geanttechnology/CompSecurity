// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmsp.client.sdk.oem.b;
import java.io.ByteArrayOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class do
    implements bn.b, di, dn
{

    private static final bm g = d.a(do);
    private static long o = 1L;
    protected dm a;
    public Vector b;
    protected df c;
    protected int d;
    protected Object e;
    protected byte f;
    private dk h;
    private dn i;
    private bi j;
    private bi k;
    private byte l;
    private bn m;
    private Hashtable n;
    private long p;
    private Hashtable q;

    public do(dl dl1, dk dk, Vector vector)
    {
        d = 0;
        f = 0;
        c = dl1;
        a = dl1.h();
        h = dk;
        j = dl1.e();
        k = dl1.f();
        l = 5;
        m = dl1.c_();
        e = new Object();
        f = a.h();
        n = new Hashtable();
        q = new Hashtable();
        p = a.g();
        b = new Vector();
        if (vector != null)
        {
            for (int i1 = 0; i1 < vector.size(); i1++)
            {
                dl1 = ((cz)vector.elementAt(i1)).e();
                b.addElement(dl1);
            }

        }
    }

    private static cz.a a(String s)
    {
        if (s.equalsIgnoreCase("sdk"))
        {
            return cz.a.a;
        }
        if (s.equalsIgnoreCase("nmsp"))
        {
            return cz.a.b;
        }
        if (s.equalsIgnoreCase("app"))
        {
            return cz.a.c;
        }
        if (s.equalsIgnoreCase("nss"))
        {
            return cz.a.d;
        }
        if (s.equalsIgnoreCase("slog"))
        {
            return cz.a.e;
        }
        if (s.equalsIgnoreCase("nsslog"))
        {
            return cz.a.f;
        }
        if (s.equalsIgnoreCase("gwlog"))
        {
            return cz.a.g;
        }
        if (s.equalsIgnoreCase("svsp"))
        {
            return cz.a.h;
        }
        if (s.equalsIgnoreCase("sip"))
        {
            return cz.a.i;
        }
        if (s.equalsIgnoreCase("sdp"))
        {
            return cz.a.j;
        } else
        {
            return null;
        }
    }

    private void a(Vector vector, long l1)
    {
        Object obj;
        if (d != 2)
        {
            obj = h;
        }
        n.put(new Long(l1), new Byte((byte)2));
        q.put(new Long(l1), vector);
        obj = (new StringBuilder("<gp><rid>")).append(l1).append("</rid>").toString();
        for (int i1 = 0; i1 < vector.size();)
        {
            String s;
label0:
            {
                cz cz1 = (cz)vector.elementAt(i1);
                if (cz1.d() != cz.a.c && cz1.d() != cz.a.b && cz1.d() != cz.a.d)
                {
                    s = ((String) (obj));
                    if (cz1.d() != cz.a.h)
                    {
                        break label0;
                    }
                }
                s = (new StringBuilder()).append(((String) (obj))).append("<").append(cz1.d()).append(" p=\"").append(cz1.a()).append("\"/>").toString();
            }
            i1++;
            obj = s;
        }

        obj = (new StringBuilder()).append(((String) (obj))).append("</gp>").toString();
        vector = a;
        byte abyte0[] = ((String) (obj)).getBytes();
        byte byte0 = f;
        dn dn1 = i;
        vector.a((short)2583, "SEND_BCP_GET_PARAMS", abyte0, new byte[0], byte0, l1, dn1, false);
    }

    public static long i()
    {
        return 0L;
    }

    public void a()
        throws dj
    {
label0:
        {
            g.b((new StringBuilder("freeResource, disconnect timeout: ")).append(0).toString());
            synchronized (e)
            {
                if (d != 2)
                {
                    break label0;
                }
                d = 0;
                Object obj1 = new Integer(0);
                bn bn1 = m;
                obj1 = new bn.a((byte)3, obj1);
                Thread thread = Thread.currentThread();
                m.a();
                bn1.a(obj1, this, thread);
            }
            return;
        }
        g.e("ResourceException the resource was unloaded. ");
        throw new dj("the resource was unloaded. ");
    }

    public final void a(byte byte0, long l1, short word0, short word1, short word2)
    {
        g.b((new StringBuilder("onBcpResponse, TID: ")).append(byte0).append(", RID: ").append(l1).append(", status code: ").append(word0).append(" , request state: ").append(word1).append(", completion cause: ").append(word2).toString());
        if (word0 == 200) goto _L2; else goto _L1
_L1:
        Byte byte1 = (Byte)n.get(new Long(l1));
        if (byte1 == null) goto _L2; else goto _L3
_L3:
        byte1.byteValue();
        JVM INSTR tableswitch 1 2: default 128
    //                   1 129
    //                   2 152;
           goto _L2 _L4 _L5
_L2:
        return;
_L4:
        n.remove(new Long(l1));
        dk dk = h;
        return;
_L5:
        n.remove(new Long(l1));
        dk dk1 = h;
        return;
    }

    public final void a(byte byte0, long l1, short word0, byte abyte0[])
    {
        g.b((new StringBuilder("onBcpSetParamsComplete, TID: ")).append(byte0).append(", RID: ").append(l1).append(", status code: ").append(word0).toString());
        if (n.remove(new Long(l1)) == null)
        {
            g.d((new StringBuilder("onBcpSetParamsComplete, RID: ")).append(l1).append(" already removed!").toString());
            return;
        }
        Vector vector = new Vector();
        if (abyte0 != null)
        {
            abyte0 = new String(abyte0);
            if (abyte0.startsWith(";"))
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            do
            {
                int i1 = abyte0.indexOf(";", byte0);
                if (i1 == -1)
                {
                    break;
                }
                String s = abyte0.substring(byte0, i1);
                byte0 = s.indexOf(".");
                if (byte0 != -1)
                {
                    vector.addElement(new cz(s.substring(byte0 + 1), a(s.substring(0, byte0))));
                }
                byte0 = i1 + 1;
            } while (true);
            if (byte0 < abyte0.length())
            {
                abyte0 = abyte0.substring(byte0);
                byte0 = abyte0.indexOf(".");
                if (byte0 != -1)
                {
                    vector.addElement(new cz(abyte0.substring(byte0 + 1), a(abyte0.substring(0, byte0))));
                }
            }
        }
        if (word0 == 200 || word0 == 201)
        {
            abyte0 = h;
            return;
        } else
        {
            abyte0 = h;
            return;
        }
    }

    public void a(byte byte0, short word0)
    {
        g.b((new StringBuilder("onBcpEvent, TID: ")).append(byte0).append(", event code: ").append(word0).toString());
        if (d == 2)
        {
            d = 0;
            Object obj = n.keys();
            do
            {
                if (((Enumeration) (obj)).hasMoreElements())
                {
                    Object obj1 = (Long)((Enumeration) (obj)).nextElement();
                    switch (((Byte)n.remove(obj1)).byteValue())
                    {
                    case 1: // '\001'
                        obj1 = h;
                        break;

                    case 2: // '\002'
                        obj1 = h;
                        break;
                    }
                    continue;
                }
                obj = h;
                a.b(this);
                break;
            } while (true);
        }
    }

    public void a(byte byte0, byte abyte0[])
    {
    }

    protected final void a(dn dn1)
    {
        g.b("loadResource");
        if ((new b(b)).a())
        {
            j = bx.c(j);
            k = bx.c(k);
            ((dl)c).a(j);
            ((dl)c).b(k);
        }
        i = dn1;
        a.a(dn1);
        if (d != 0) goto _L2; else goto _L1
_L1:
        String s;
        long l1;
        if (a.f() != null)
        {
            d = 2;
        } else
        {
            a.a(j, k);
            d = 1;
        }
        l1 = h();
        s = (new StringBuilder("<lr><rid>")).append(l1).append("</rid>").toString();
        l;
        JVM INSTR tableswitch 1 5: default 176
    //                   1 246
    //                   2 270
    //                   3 294
    //                   4 318
    //                   5 222;
           goto _L3 _L4 _L5 _L6 _L7 _L2
_L3:
        s = (new StringBuilder()).append(s).append("</lr>").toString().getBytes();
        a.a((short)2599, "SEND_BCP_LOAD_RESOURCE", s, null, f, l1, dn1, false);
_L2:
        return;
_L4:
        s = (new StringBuilder()).append(s).append("<nr9><reco/></nr9>").toString();
        continue; /* Loop/switch isn't completed */
_L5:
        s = (new StringBuilder()).append(s).append("<nr9><tts/></nr9>").toString();
        continue; /* Loop/switch isn't completed */
_L6:
        s = (new StringBuilder()).append(s).append("<oper></oper>").toString();
        continue; /* Loop/switch isn't completed */
_L7:
        s = (new StringBuilder()).append(s).append("<dict>").toString();
        s = (new StringBuilder()).append(s).append("</dict>").toString();
        if (true) goto _L3; else goto _L8
_L8:
    }

    public void a(Object obj, Object obj1)
    {
        obj = (bn.a)obj;
        switch (((bn.a) (obj)).a)
        {
        default:
            return;

        case 1: // '\001'
            obj = ((Object) ((Object[])((bn.a) (obj)).b));
            obj1 = (Vector)obj[0];
            long l2 = ((Long)obj[1]).longValue();
            if (d != 2)
            {
                obj = h;
                return;
            }
            boolean flag = true;
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            byte abyte0[] = new byte[4];
            n.put(new Long(l2), new Byte((byte)1));
            obj = (new StringBuilder("<sp><rid>")).append(l2).append("</rid>").toString();
            int l1 = 1;
            int i1 = 0;
            while (i1 < ((Vector) (obj1)).size()) 
            {
                cz cz1 = (cz)((Vector) (obj1)).elementAt(i1);
                if (cz1.d() == cz.a.c || cz1.d() == cz.a.b || cz1.d() == cz.a.d)
                {
                    flag = false;
                    String s = new String(cz1.b());
                    obj = (new StringBuilder()).append(((String) (obj))).append("<").append(cz1.d()).append(" p=\"").append(cz1.a()).append("\" v=\"").append(bx.a(s)).append("\"/>").toString();
                } else
                {
                    if (cz1.d() == cz.a.h)
                    {
                        flag = false;
                    }
                    obj = (new StringBuilder()).append(((String) (obj))).append("<").append(cz1.d().toString()).append(" p=\"").append(cz1.a()).append("\" v=\"").append(l1).append("\"/>").toString();
                    byte abyte1[] = cz1.b();
                    bu.a(abyte1.length, abyte0, 0);
                    bytearrayoutputstream.write(abyte0, 0, 4);
                    bytearrayoutputstream.write(abyte1, 0, abyte1.length);
                    l1++;
                }
                i1++;
            }
            obj = (new StringBuilder()).append(((String) (obj))).append("</sp>").toString();
            a.a((short)2581, "SEND_BCP_SET_PARAMS", ((String) (obj)).getBytes(), bytearrayoutputstream.toByteArray(), f, l2, i, flag);
            try
            {
                bytearrayoutputstream.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }

        case 2: // '\002'
            obj = ((Object) ((Object[])((bn.a) (obj)).b));
            a((Vector)obj[0], ((Long)obj[1]).longValue());
            return;

        case 3: // '\003'
            int j1 = ((Integer)((bn.a) (obj)).b).intValue();
            a.a(f, j1, i);
            obj = h;
            return;

        case 4: // '\004'
            int k1 = ((Integer)((bn.a) (obj)).b).intValue();
            long l3 = h();
            obj = (new StringBuilder("<fr><rid>")).append(l3).append("</rid>").toString();
            obj = (new StringBuilder()).append(((String) (obj))).append("<n>1</n>").toString();
            obj = (new StringBuilder()).append(((String) (obj))).append("<resids>").toString();
            obj = (new StringBuilder()).append(((String) (obj))).append("<res1><id>").append(p).append("</id>").toString();
            obj = (new StringBuilder()).append(((String) (obj))).append("<timeout>").append(k1).append("<timeout></res1>").toString();
            obj = (new StringBuilder()).append(((String) (obj))).append("</resids>").toString();
            obj = (new StringBuilder()).append(((String) (obj))).append("</fr>").toString().getBytes();
            a.a((short)2608, "SEND_BCP_FREE_RESOURCE_ID", ((byte []) (obj)), null, f, l3, i, true);
            return;
        }
    }

    public void a(short word0)
    {
        if (g.b())
        {
            g.b((new StringBuilder("onSessionDisconnected, reason code: ")).append(word0).toString());
        }
        Enumeration enumeration = n.keys();
        do
        {
            if (enumeration.hasMoreElements())
            {
                Object obj1 = (Long)enumeration.nextElement();
                switch (((Byte)n.remove(obj1)).byteValue())
                {
                case 1: // '\001'
                    obj1 = h;
                    break;

                case 2: // '\002'
                    obj1 = h;
                    break;
                }
            } else
            {
                synchronized (e)
                {
                    dk dk;
                    if (d == 2)
                    {
                        dk = h;
                    }
                    d = 0;
                }
                return;
            }
        } while (true);
    }

    public void a(byte abyte0[])
    {
        if (g.b())
        {
            g.b((new StringBuilder("onSessionConnected, SID: ")).append(abyte0).toString());
        }
        synchronized (e)
        {
            d = 2;
        }
    }

    public final void b()
    {
        dk dk = h;
    }

    public final void b(byte byte0, long l1, short word0, byte abyte0[])
    {
        int i1 = 0;
        g.b((new StringBuilder("onBcpGetParamsComplete, TID: ")).append(byte0).append(", RID: ").append(l1).toString());
        if (n.remove(new Long(l1)) == null)
        {
            g.d((new StringBuilder("onBcpGetParamsComplete, RID: ")).append(l1).append(" already removed!").toString());
            q.remove(new Long(l1));
            return;
        }
        Vector vector = (Vector)q.remove(new Long(l1));
        if (vector == null)
        {
            g.e((new StringBuilder("Could not find the grammars associated with RID: ")).append(l1).toString());
            return;
        }
        abyte0 = new String(abyte0);
        if (abyte0.startsWith(";"))
        {
            byte0 = 1;
            i1 = 0;
        } else
        {
            boolean flag = false;
            byte0 = i1;
            i1 = ((flag) ? 1 : 0);
        }
        do
        {
            int j1 = abyte0.indexOf(";", byte0);
            if (j1 == -1)
            {
                break;
            }
            String s = abyte0.substring(byte0, j1);
            if (s.indexOf(":") == -1)
            {
                cz cz2 = (cz)vector.elementAt(i1);
                vector.setElementAt(new cz(cz2.a(), s.getBytes(), cz2.d()), i1);
            }
            i1++;
            byte0 = j1 + 1;
        } while (true);
        if (byte0 < abyte0.length())
        {
            abyte0 = abyte0.substring(byte0);
            if (abyte0.indexOf(":") == -1)
            {
                cz cz1 = (cz)vector.elementAt(i1);
                vector.setElementAt(new cz(cz1.a(), abyte0.getBytes(), cz1.d()), i1);
            }
        }
        if (word0 == 200 || word0 == 201)
        {
            abyte0 = h;
            return;
        } else
        {
            abyte0 = h;
            return;
        }
    }

    public void c()
    {
    }

    public void d()
    {
    }

    public void e()
    {
    }

    public void f()
    {
    }

    public final df g()
    {
        return c;
    }

    protected long h()
    {
        this;
        JVM INSTR monitorenter ;
        long l1;
        l1 = o;
        o = 1L + l1;
        if (o == 0x8000000000000000L)
        {
            o = 1L;
        }
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

}
