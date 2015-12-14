// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;
import com.nuance.nmsp.client.sdk.oem.d;
import java.util.LinkedList;
import java.util.List;

public class ch
    implements bn.b, cb.a, cd
{

    private static final bm a = d.a(ch);
    private static byte l[] = new byte[16];
    private final String b;
    private final long c;
    private final List d = new LinkedList();
    private int e;
    private long f;
    private boolean g;
    private ce h;
    private bn i;
    private cb j;
    private int k;

    public ch(String s, long l1, int i1, String s1, String s2, String s3, 
            bn bn1, cb cb1)
    {
        e = 0;
        f = 0L;
        g = false;
        j = null;
        k = 1;
        b = s;
        c = l1;
        j = cb1;
        i = bn1;
        if (s1 == null || s1.length() == 0)
        {
            s = bo.b();
        } else
        {
            s = s1;
        }
        try
        {
            h = cl.a(s, "CLIENT", "2.0", i1, this, "CLIENT").a("UniqueID", s2).a("ApplicationID", s3).a("client_hardware_model", com.nuance.nmdp.speechkit.recognitionresult.b.h()).a("client_hardware_submodel", com.nuance.nmdp.speechkit.recognitionresult.b.i()).a("client_os_type", com.nuance.nmdp.speechkit.recognitionresult.b.j()).a("client_os_version", com.nuance.nmdp.speechkit.recognitionresult.b.k()).a("client_sdk_release", "NMSP 5.0 client SDK - build 009").a();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        s = i;
        s1 = new bn.a((byte)17, null);
        s2 = Thread.currentThread();
        i.a();
        s.a(s1, this, s2);
    }

    private void b(int i1)
    {
        do
        {
            if (d.size() <= 0)
            {
                break;
            }
            static final class _cls1
            {

                public int a;
                public byte b[];


            
            {
                this();
            }
            }

            _cls1 _lcls1 = (_cls1)d.get(0);
            if (i1 < _lcls1.a)
            {
                break;
            }
            f = f - (long)_lcls1.b.length;
            d.remove(0);
            e = e - 1;
            d();
        } while (true);
    }

    private void d()
    {
        if (g)
        {
            if (a.b())
            {
                a.b((new StringBuilder("trySendingLogs() _sessionConnected:")).append(g).append(", _outstandingEvents:").append(e).append(", _events.size()").append(d.size()).toString());
            }
            while (e < 5 && e < d.size()) 
            {
                Object obj = (_cls1)d.get(e);
                if (a.b())
                {
                    a.b((new StringBuilder("bcpLog, packet len [")).append(((_cls1) (obj)).b.length).append("]").toString());
                }
                bn bn1 = i;
                obj = new bn.a((byte)18, ((Object) (new Object[] {
                    obj
                })));
                Thread thread = Thread.currentThread();
                i.a();
                bn1.a(obj, this, thread);
                e = e + 1;
            }
        }
    }

    private void e()
    {
        d d1 = new d();
        if (b == null || !d1.a(b, bl.a.a)) goto _L2; else goto _L1
_L1:
        if (d1.b() <= 0x7fffffffL) goto _L4; else goto _L3
_L3:
        if (a.e())
        {
            a.e((new StringBuilder("calllog file too big (")).append(d1.b()).append(" > 2147483647").append(")!!!").toString());
        }
        d1.a();
_L6:
        return;
_L4:
        int j1;
        long l1;
        long l2;
        l2 = d1.b();
        l1 = 0L;
        j1 = d.size();
_L5:
        byte abyte0[];
        int i1;
        long l3;
        long l4;
        if (l1 >= l2)
        {
            break MISSING_BLOCK_LABEL_543;
        }
        abyte0 = new byte[1];
        if (d1.a(abyte0, abyte0.length) != abyte0.length)
        {
            i1 = 1;
        } else
        {
            l3 = abyte0.length;
            abyte0 = new byte[abyte0[0]];
            if (d1.a(abyte0, abyte0.length) != abyte0.length)
            {
                i1 = 1;
            } else
            {
label0:
                {
                    l4 = abyte0.length;
                    if (abyte0.length == 1)
                    {
                        i1 = abyte0[0] & 0xff;
                    } else
                    if (abyte0.length == 2)
                    {
                        i1 = abyte0[1];
                        i1 = (abyte0[0] & 0xff) + ((i1 & 0xff) << 8);
                    } else
                    if (abyte0.length == 3)
                    {
                        i1 = abyte0[2];
                        byte byte0 = abyte0[1];
                        i1 = (abyte0[0] & 0xff) + (((i1 & 0xff) << 16) + ((byte0 & 0xff) << 8));
                    } else
                    {
                        i1 = abyte0[3];
                        byte byte1 = abyte0[2];
                        byte byte2 = abyte0[1];
                        i1 = (abyte0[0] & 0xff) + (((i1 & 0xff) << 24) + ((byte1 & 0xff) << 16) + ((byte2 & 0xff) << 8));
                    }
                    abyte0 = new byte[i1];
                    if (d1.a(abyte0, abyte0.length) == abyte0.length)
                    {
                        break label0;
                    }
                    i1 = 1;
                }
            }
        }
_L7:
        d1.a();
        _cls1 _lcls1;
        if (i1 != 0)
        {
            d1.c();
            if (a.e())
            {
                a.e("handleLoadFile() failed!!!");
            }
        } else
        if (a.c())
        {
            a.c((new StringBuilder("handleLoadFile() ")).append(d.size() - j1).append(" events are loaded").toString());
        }
        f();
        return;
        _lcls1 = new _cls1((byte)0);
        _lcls1.b = abyte0;
        f = f + (long)abyte0.length;
        d.add(_lcls1);
        l1 = l1 + l3 + l4 + (long)abyte0.length;
          goto _L5
_L2:
        if (a.c())
        {
            a.c((new StringBuilder("handleLoadFile() cannot open + file:")).append(b).toString());
            return;
        }
          goto _L6
        i1 = 0;
          goto _L7
    }

    private void f()
    {
        if (f > c)
        {
            int i1 = d.size();
            byte abyte0[];
            for (; f > c; f = f - (long)abyte0.length)
            {
                abyte0 = (byte[])d.remove(0);
            }

            if (a.c())
            {
                a.c((new StringBuilder("trimEventsList() ")).append(i1 - d.size()).append(" events are removed due to size limit (").append(c).append(")").toString());
                return;
            }
        }
    }

    public final void a()
    {
        if (a.b())
        {
            a.b("socketOpened()");
        }
    }

    public final void a(int i1)
    {
        if (a.b())
        {
            a.b((new StringBuilder("bcpLogResponse requestId = ")).append(i1).toString());
        }
        bn bn1 = i;
        bn.a a1 = new bn.a((byte)19, ((Object) (new Object[] {
            new Integer(i1)
        })));
        Thread thread = Thread.currentThread();
        i.a();
        bn1.a(a1, this, thread);
    }

    public final void a(bs bs, byte abyte0[])
    {
    }

    public final void a(cm cm1, cl.a a1)
    {
        bn bn1 = i;
        cm1 = new bn.a((byte)20, ((Object) (new Object[] {
            cm1, a1
        })));
        a1 = Thread.currentThread();
        i.a();
        bn1.a(cm1, this, a1);
    }

    final void a(cm cm1, cl.b b1)
    {
        bn bn1 = i;
        cm1 = new bn.a((byte)16, ((Object) (new Object[] {
            cm1, b1
        })));
        b1 = Thread.currentThread();
        i.a();
        bn1.a(cm1, this, b1);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (bn.a)obj;
        ((bn.a) (obj)).a;
        JVM INSTR tableswitch 16 20: default 44
    //                   16 104
    //                   17 206
    //                   18 211
    //                   19 324
    //                   20 45;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L4:
        break MISSING_BLOCK_LABEL_211;
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_324;
_L7:
        return;
_L6:
        obj1 = ((Object) ((Object[])((bn.a) (obj)).b));
        obj = (cm)obj1[0];
        obj1 = (cl.a)obj1[1];
        ((cm) (obj)).c();
        if (obj1 != null)
        {
            if (obj instanceof cj)
            {
                ((cl.a) (obj1)).a(((cj)obj).b());
                return;
            } else
            {
                ((cl.a) (obj1)).a(null);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        obj = (cm)((Object[])((bn.a) (obj)).b)[0];
        obj1 = new _cls1((byte)0);
        obj1.b = ((cm) (obj)).g();
        if (f < c)
        {
            (new StringBuilder()).append(((cm) (obj)).b.b()).append(((cm) (obj)).d);
            d.add(obj1);
            long l1 = f;
            f = (long)((_cls1) (obj1)).b.length + l1;
            d();
            return;
        }
        if (true) goto _L7; else goto _L3
_L3:
        e();
        return;
        obj = (_cls1)((Object[])((bn.a) (obj)).b)[0];
        int i1 = k;
        k = i1 + 1;
        obj.a = i1;
        obj1 = new byte[((_cls1) (obj)).b.length + 25];
        obj1[0] = 0;
        bu.a(((_cls1) (obj)).a, ((byte []) (obj1)), 1);
        obj1 = br.a(((byte []) (obj1)), l);
        bu.a(((_cls1) (obj)).b.length, ((byte []) (obj1)), 21);
        System.arraycopy(((_cls1) (obj)).b, 0, obj1, 25, ((_cls1) (obj)).b.length);
        obj = br.a((byte)2, (byte)34, (short)2640, ((byte []) (obj1)));
        j.a(((byte []) (obj)), 1, "SEND_BCP_LOG");
        return;
        b(((Integer)((Object[])((bn.a) (obj)).b)[0]).intValue());
        return;
    }

    public final void a(String s)
    {
        if (s.startsWith("SEND_BCP_LOG") && a.b())
        {
            a.b((new StringBuilder("onMsgSent(")).append(s).append(")").toString());
        }
    }

    public final void a(short word0, short word1)
    {
        if (a.b())
        {
            a.b((new StringBuilder("socketClosed() reason [")).append(word0).append("] subReason [").append(word1).append("]").toString());
        }
        g = false;
    }

    public final ce b()
    {
        return h;
    }

    public final void b(String s)
    {
        if (s.startsWith("SEND_BCP_LOG"))
        {
            if (a.b())
            {
                a.b((new StringBuilder("onMsgNotSent(")).append(s).append(")").toString());
            }
            s = (_cls1)d.remove(0);
            f = f - (long)((_cls1) (s)).b.length;
            e = e - 1;
            d.add(e, s);
            d();
        }
    }

    public final cg c(String s)
        throws cc
    {
        if (a.b())
        {
            a.b((new StringBuilder("openSession(")).append(s).append(")").toString());
        }
        if (((ck)h).a != null)
        {
            throw new cc("Application session already opened.");
        } else
        {
            cj cj1 = (cj)cl.a((cm)h, "APP_REMOTEEVENT", null).a(new cl.b());
            s = cl.a(cj1, s);
            ((ck)h).a = cj1;
            return s;
        }
    }

    public final void c()
    {
        g = true;
        d();
    }

}
