// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmsp.client.sdk.oem.h;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class cb
    implements bn.b, bp.a, bp.d, bp.e, bp.f
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(bs bs1, byte abyte0[]);

        public abstract void a(String s1);

        public abstract void a(short word0, short word1);

        public abstract void b(String s1);
    }

    final class b
    {

        byte a[];
        Object b;

        public b(byte abyte0[], Object obj)
        {
            a = abyte0;
            b = obj;
        }
    }


    private static bm c = d.a(cb);
    private a A;
    private ce B;
    private cl C;
    private Queue D;
    private Queue E;
    protected byte a;
    public byte b[];
    private bq d;
    private int e;
    private bq f;
    private int g;
    private bq h;
    private String i;
    private short j;
    private Vector k;
    private boolean l;
    private Vector m;
    private bn n;
    private Object o;
    private bs p;
    private short q;
    private short r;
    private String s;
    private String t;
    private byte u[];
    private bp v;
    private String w;
    private int x;
    private short y;
    private short z;

    public cb(String s1, short word0, String s2, byte abyte0[], String s3, a a1, Vector vector, 
            bn bn1)
    {
        e = 30;
        g = 50;
        i = null;
        j = 0;
        l = false;
        m = null;
        n = null;
        p = null;
        q = 0;
        r = 9;
        s = "Not specified";
        t = "Not specified";
        u = null;
        v = null;
        w = "";
        C = null;
        D = new LinkedList();
        E = new LinkedList();
        i = s1;
        j = word0;
        s = s2;
        u = abyte0;
        t = s3;
        A = a1;
        if (vector != null)
        {
            k = vector;
        } else
        {
            k = new Vector();
        }
        n = bn1;
        if (c.b())
        {
            c.b((new StringBuilder("XMode() server: ")).append(s1).append(" port: ").append(word0).toString());
        }
        s1 = vector.elements();
        do
        {
            if (!s1.hasMoreElements())
            {
                break;
            }
            s2 = (cz)s1.nextElement();
            if (c.b())
            {
                c.b((new StringBuilder("XMode() ")).append(s2.d()).append(" : ").append(s2.a()).append(" = ").append(new String(s2.b())).toString());
            }
            if (s2.d() == cz.a.a)
            {
                if (s2.a().equals("IdleSessionTimeout"))
                {
                    int i1 = Integer.parseInt(new String(s2.b()));
                    if (i1 > 0)
                    {
                        g = i1;
                    }
                } else
                if (s2.a().equals("ConnectionTimeout"))
                {
                    e = Integer.parseInt(new String(s2.b()));
                } else
                if (s2.a().equals("SSL_Socket_Enable") || s2.a().equals("SSL_Cert_Summary") || s2.a().equals("SSL_Cert_Data") || s2.a().equals("SSL_SelfSigned_Cert"))
                {
                    if (s2.a().equals("SSL_Socket_Enable") && ((new String(s2.b())).equals("TRUE") || (new String(s2.b())).equals("true")))
                    {
                        l = true;
                    }
                    if (m == null)
                    {
                        m = new Vector();
                    }
                    m.addElement(s2);
                }
            }
        } while (true);
        a = 3;
    }

    static short a(cb cb1)
    {
        cb1.q = 3;
        return 3;
    }

    private void a(byte byte0, Object obj)
    {
        bn bn1 = n;
        obj = new bn.a(byte0, obj);
        Thread thread = Thread.currentThread();
        n.a();
        bn1.a(obj, this, thread);
_L1:
        return;
        obj;
        if (c.e())
        {
            c.e((new StringBuilder("XMode.sendCmdMsg() ")).append(((Exception) (obj)).getMessage()).toString());
            return;
        }
          goto _L1
    }

    private void a(bs bs1, byte abyte0[])
    {
        if (c.b())
        {
            c.b((new StringBuilder("XMode.parseXModeMsg() protocol: ")).append(bs1.a).append(" cmd: ").append(bs1.b).toString());
        }
        bs1.a;
        JVM INSTR lookupswitch 4: default 96
    //                   1: 730
    //                   2: 578
    //                   3: 135
    //                   15: 134;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        if (c.e())
        {
            c.e((new StringBuilder("XMode.parseXModeMsg() unknown protocol: ")).append(Integer.toHexString(bs1.a)).toString());
        }
_L11:
        return;
_L4:
        bs1.b;
        JVM INSTR lookupswitch 4: default 180
    //                   257: 192
    //                   258: 436
    //                   512: 455
    //                   768: 523;
           goto _L6 _L7 _L8 _L9 _L10
_L6:
        A.a(bs1, abyte0);
        return;
_L7:
        n.a(f);
        if (C != null)
        {
            C.a();
            C = null;
        }
        b = new byte[16];
        System.arraycopy(abyte0, 0, b, 0, 16);
        Object obj = n;
        byte abyte1[] = b;
        abyte1 = v;
        abyte1 = ((byte []) (o));
        abyte1 = b;
        if (B != null)
        {
            abyte1 = (ch)((cm)B).e();
            if (abyte1 != null)
            {
                abyte1.c();
            }
        }
        w = bm.b(b);
        abyte1 = c;
        String s1 = w;
        abyte1.f();
        if (c.b())
        {
            c.b((new StringBuilder("Received COP_Connected ")).append(w).toString());
        }
        a((byte)10, null);
        c.g();
        a("SocketOpened");
        h = new bq() {

            private cb a;

            public final void run()
            {
                cb.a(a);
                if (cb.c().e())
                {
                    cb.c().e((new StringBuilder("Session Idle for too long, longer than [")).append(cb.b(a)).append("] (initiated from XMode.parseCopConnected)").toString());
                }
                a.a = 2;
                cb.a(a, (byte)4, null);
_L1:
                return;
                Exception exception;
                exception;
                if (cb.c().e())
                {
                    cb.c().e((new StringBuilder("XMode.parseXModeMsg() ")).append(exception.getClass().getName()).append(" ").append(exception.getMessage()).toString());
                    return;
                }
                  goto _L1
            }

            
            {
                a = cb.this;
                super();
            }
        };
        n.a(h, g * 1000);
        continue; /* Loop/switch isn't completed */
        bs1;
        c.g();
        throw bs1;
_L8:
        x = bu.b(abyte0, 0);
        a((byte)8, null);
        continue; /* Loop/switch isn't completed */
_L9:
        if (h != null)
        {
            n.a(h);
        }
        r = bu.a(abyte0, 0);
        a = 2;
        q = 6;
        if (c.d())
        {
            c.d("XMode.parseXModeMsgCopDisconnect() Received COP DISCONNECT. ");
        }
        a((byte)4, null);
        continue; /* Loop/switch isn't completed */
_L10:
        short word0 = bu.a(abyte0, 0);
        bu.b(abyte0, 2);
        q = 7;
        r = word0;
        a = 2;
        if (c.e())
        {
            c.e("XMode.parseXModeMsgCopConnectFailed() COP CONNECT failure. ");
        }
        a((byte)4, null);
        if (true) goto _L6; else goto _L3
_L3:
        if (h != null && n.a(h))
        {
            h = new bq() {

                private cb a;

                public final void run()
                {
                    cb.a(a);
                    if (cb.c().e())
                    {
                        cb.c().e((new StringBuilder("Session Idle for too long, longer than [")).append(cb.b(a)).append("] (initiated from XMode.parseBcp)").toString());
                    }
                    a.a = 2;
                    cb.a(a, (byte)4, null);
_L1:
                    return;
                    Exception exception;
                    exception;
                    if (cb.c().e())
                    {
                        cb.c().e((new StringBuilder("XMode.parseXModeMsg() ")).append(exception.getClass().getName()).append(" ").append(exception.getMessage()).toString());
                        return;
                    }
                      goto _L1
                }

            
            {
                a = cb.this;
                super();
            }
            };
            n.a(h, g * 1000);
        }
        if (bs1.b == 2641)
        {
            int i1 = bu.b(abyte0, 17);
            short word1 = bu.a(abyte0, 21);
            bs1 = (ch)((cm)B).e();
            if (word1 == 0 || word1 == 1 || word1 == 3)
            {
                bs1.a(i1);
                return;
            }
            if (c.e())
            {
                c.e("XMode.parseXModeMsgBcpLogResponse() XMODE_BCP_LOG_WRITE_ERROR. ");
                return;
            }
        } else
        {
            A.a(bs1, abyte0);
            return;
        }
        if (true) goto _L11; else goto _L2
_L2:
        if (h != null && n.a(h))
        {
            h = new bq() {

                private cb a;

                public final void run()
                {
                    cb.a(a);
                    if (cb.c().e())
                    {
                        cb.c().e((new StringBuilder("Session Idle for too long, longer than [")).append(cb.b(a)).append("] (initiated from XMode.parseVap)").toString());
                    }
                    a.a = 2;
                    cb.a(a, (byte)4, null);
_L1:
                    return;
                    Exception exception;
                    exception;
                    if (cb.c().e())
                    {
                        cb.c().e((new StringBuilder("XMode.parseXModeMsg() ")).append(exception.getClass().getName()).append(" ").append(exception.getMessage()).toString());
                        return;
                    }
                      goto _L1
                }

            
            {
                a = cb.this;
                super();
            }
            };
            n.a(h, g * 1000);
        }
        A.a(bs1, abyte0);
        return;
    }

    static void a(cb cb1, byte byte0, Object obj)
    {
        cb1.a(byte0, obj);
    }

    private void a(String s1)
    {
        if (B != null)
        {
            B.a(s1).a();
        }
    }

    static int b(cb cb1)
    {
        return cb1.g;
    }

    static bm c()
    {
        return c;
    }

    static cl c(cb cb1)
    {
        return cb1.C;
    }

    static cl d(cb cb1)
    {
        cb1.C = null;
        return null;
    }

    public final void a()
    {
        if (c.b())
        {
            c.b((new StringBuilder("XMode.closeSocketCallback() ")).append(w).toString());
        }
        a = 3;
        if (d != null)
        {
            n.a(d);
            d = null;
        }
        if (h != null)
        {
            n.a(h);
            h = null;
        }
        if (o != null)
        {
            A.a(q, r);
        }
        if (B != null)
        {
            ch ch1 = (ch)((cm)B).e();
            if (ch1 != null)
            {
                ch1.a(q, r);
            }
        }
        o = null;
        v = null;
        b = null;
        w = "";
    }

    public final void a(int i1)
    {
        if (c.b())
        {
            c.b((new StringBuilder("XMode.startStreaming() audio id: ")).append(i1).toString());
        }
        if (a != 1)
        {
            return;
        } else
        {
            byte abyte0[] = new byte[6];
            bu.a(i1, abyte0, 0);
            bu.a(y, abyte0, 4);
            a(br.a((byte)1, (byte)18, (short)257, abyte0), 3, "SEND_VAP_RECORD_BEGIN");
            return;
        }
    }

    public final void a(bp.c c1, Object obj)
    {
        if (c.b())
        {
            c.b("XMode.openSocketCallback() ");
        }
        if (c1 != bp.c.a) goto _L2; else goto _L1
_L1:
        o = obj;
        if (a != 0) goto _L4; else goto _L3
_L3:
        if (B != null) goto _L6; else goto _L5
_L5:
        a((byte)7, null);
_L8:
        return;
_L6:
        a((byte)13, null);
        return;
_L4:
        a = 2;
        v.a(o);
        return;
_L2:
        if (c1 == bp.c.b)
        {
            if (c.e())
            {
                c.e("XMode.openSocketCallback() NETWORK_ERROR");
            }
            a = 3;
            q = 4;
            A.a(q, r);
            o = null;
            v = null;
            b = null;
            w = "";
            return;
        }
        if (c1 == bp.c.c)
        {
            q = 4;
            if (c.e())
            {
                c.e("XMode.openSocketCallback() NETWORK_MEMORY_ERROR");
                return;
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void a(bp.c c1, Object obj, int i1, int j1, Object obj1)
    {
        boolean flag1 = false;
        boolean flag = false;
        String s1 = (String)((b)obj1).b;
        if (c1 == bp.c.a && i1 == j1)
        {
            if (s1.equals("SEND_COP_CONNECT"))
            {
                a((byte)5, null);
            } else
            if (s1.equals("SEND_COP_DISCONNECT"))
            {
                v.a(obj);
            }
            a((byte)11, s1);
            D.remove(obj1);
            if (D.size() == 0 && E.size() > 0)
            {
                a((byte)14, null);
            }
        } else
        {
            if (c1 != bp.c.b)
            {
                continue;
            }
            if (q != 1 && q != 3)
            {
                q = 8;
                if (c.e())
                {
                    c.e("XMode.writeSocketCallback() NETWORK_ERROR");
                }
            }
            a((byte)12, s1);
            D.remove(obj1);
            if (D.size() == 0)
            {
                j1 = E.size();
                i1 = ((flag) ? 1 : 0);
                while (i1 < j1) 
                {
                    a((byte)12, ((b)E.remove()).b);
                    i1++;
                }
            }
        }
        do
        {
            do
            {
                do
                {
                    return;
                } while (c1 != bp.c.c);
                if (q != 1 && q != 3)
                {
                    q = 8;
                    if (c.e())
                    {
                        c.e("XMode.writeSocketCallback() NETWORK_MEMORY_ERROR");
                    }
                }
                a((byte)12, s1);
                D.remove(obj1);
            } while (D.size() != 0);
            j1 = E.size();
            i1 = ((flag1) ? 1 : 0);
            while (i1 < j1) 
            {
                a((byte)12, ((b)E.remove()).b);
                i1++;
            }
        } while (true);
    }

    public final void a(bp.c c1, Object obj, byte abyte0[], int i1, int j1, Object obj1)
    {
        obj1 = (String)obj1;
        if (c.b())
        {
            c.b("Read callback");
        }
        if (c.a())
        {
            c.a(abyte0);
        }
        if (c1 != bp.c.a) goto _L2; else goto _L1
_L1:
        if (!((String) (obj1)).equals("READ_XMODE_HEADER")) goto _L4; else goto _L3
_L3:
        if (j1 != 0) goto _L6; else goto _L5
_L5:
        d = new bq() {

            private cb a;

            public final void run()
            {
                cb.a(a, (byte)5, null);
_L1:
                return;
                Exception exception;
                exception;
                if (cb.c().e())
                {
                    cb.c().e((new StringBuilder("XMode.readSocketCallback() ")).append(exception.getClass().getName()).append(" ").append(exception.getMessage()).toString());
                    return;
                }
                  goto _L1
            }

            
            {
                a = cb.this;
                super();
            }
        };
        n.a(d, 20L);
_L8:
        return;
_L6:
        if (j1 == i1)
        {
            p = new bs(abyte0);
            if (p.c == 0)
            {
                a(p, ((byte []) (null)));
                a((byte)5, null);
                return;
            }
            if (p.c > 0x7d000 || p.c < 0)
            {
                v.b(obj);
                a((byte)5, null);
                return;
            } else
            {
                a((byte)6, null);
                return;
            }
        }
        if (c.e())
        {
            c.e((new StringBuilder("----***---- readSocketCallback fatal error in readSocketCallback NET_CONTEXT_READ_XMODE_HEADER bytesRead:[")).append(j1).append("] bufferLen:[").append(i1).append("]").toString());
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (((String) (obj1)).equals("READ_XMODE_PAYLOAD"))
        {
            if (j1 == 0)
            {
                if (c.b())
                {
                    c.b((new StringBuilder()).append(Integer.toHexString(p.b)).append(" payload not read bytesRead is 0").toString());
                }
                d = new bq() {

                    private cb a;

                    public final void run()
                    {
                        cb.a(a, (byte)6, null);
_L1:
                        return;
                        Exception exception;
                        exception;
                        if (cb.c().e())
                        {
                            cb.c().e((new StringBuilder("XMode.readSocketCallback() ")).append(exception.getClass().getName()).append(" ").append(exception.getMessage()).toString());
                            return;
                        }
                          goto _L1
                    }

            
            {
                a = cb.this;
                super();
            }
                };
                n.a(d, 20L);
                return;
            }
            if (j1 == i1)
            {
                if (p.c <= i1)
                {
                    a(p, abyte0);
                }
                a((byte)5, null);
                return;
            }
            if (c.e())
            {
                c.e((new StringBuilder("----***---- readSocketCallback fatal error in readSocketCallback NET_CONTEXT_READ_XMODE_PAYLOAD bytesRead:[")).append(j1).append("] bufferLen:[").append(i1).append("]").toString());
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (c1 == bp.c.b)
        {
            if (q != 1 && q != 3 && q != 6)
            {
                q = 8;
                if (c.e())
                {
                    c.e("XMode.readSocketCallback() NETWORK_ERROR");
                }
            }
            a((byte)4, null);
            return;
        }
        if (c1 == bp.c.c && q != 1 && q != 3)
        {
            q = 8;
            if (c.e())
            {
                c.e("XMode.readSocketCallback() NETWORK_MEMORY_ERROR");
                return;
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void a(ce ce1)
    {
        if (ce1 != null)
        {
            B = ce1.a("NMSPSocket").a();
        }
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (bn.a)obj;
        ((bn.a) (obj)).a;
        JVM INSTR tableswitch 1 14: default 80
    //                   1 81
    //                   2 852
    //                   3 131
    //                   4 914
    //                   5 736
    //                   6 780
    //                   7 240
    //                   8 960
    //                   9 1017
    //                   10 1078
    //                   11 1150
    //                   12 1169
    //                   13 1188
    //                   14 1238;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        return;
_L2:
        if (c.b())
        {
            c.b("XMode.handleMessage() CMD_CONNECT");
        }
        if (a == 0)
        {
            a((byte)3, null);
            return;
        } else
        {
            A.a(q, r);
            return;
        }
_L4:
        if (c.b())
        {
            c.b("XMode.handleMessage() CMD_OPEN_SOCKET");
        }
        if (a == 0)
        {
            v = new h(n);
            if (l)
            {
                v.a(i, j, m, this, this);
                return;
            } else
            {
                v.a(i, j, this, this);
                return;
            }
        } else
        {
            A.a(q, r);
            return;
        }
_L8:
        if (c.b())
        {
            c.b("XMode.handleMessage() CMD_COP_CONNECT");
        }
        if (a != 0) goto _L1; else goto _L16
_L16:
        boolean flag;
        obj = (String)((bn.a) (obj)).b;
        obj1 = (new StringBuilder("<?xml version=\"1.0\"?><cc><s></s><t>7</t><b>20091023</b><tsc>")).append(y).append("</tsc><fsc>").append(z).append("</fsc><nmaid>").append(s).append("</nmaid><uid>").append(t).append("</uid>");
        Enumeration enumeration;
        cz cz1;
        if (obj != null)
        {
            obj = (new StringBuilder("<rootlog>")).append(((String) (obj))).append("</rootlog>").toString();
        } else
        {
            obj = "";
        }
        obj = ((StringBuilder) (obj1)).append(((String) (obj))).toString();
        enumeration = k.elements();
        flag = false;
        if (!enumeration.hasMoreElements())
        {
            break; /* Loop/switch isn't completed */
        }
        cz1 = (cz)enumeration.nextElement();
        obj1 = obj;
        if (cz1.d() != cz.a.b)
        {
            break MISSING_BLOCK_LABEL_1267;
        }
        obj1 = new String(cz1.b());
        obj = (new StringBuilder()).append(((String) (obj))).append("<nmsp p=\"").append(cz1.a()).append("\" v=\"").append(bx.a(((String) (obj1)))).append("\"/>").toString();
        obj1 = obj;
        if (!cz1.a().equals("Ping_IntervalSecs"))
        {
            break MISSING_BLOCK_LABEL_1267;
        }
        flag = true;
_L19:
        if (cz1.d() == cz.a.c)
        {
            obj1 = new String(cz1.b());
            obj = (new StringBuilder()).append(((String) (obj))).append("<app p=\"").append(cz1.a()).append("\" v=\"").append(bx.a(((String) (obj1)))).append("\"/>").toString();
        }
        if (true) goto _L18; else goto _L17
_L18:
        break MISSING_BLOCK_LABEL_384;
_L17:
        obj1 = obj;
        if (!flag)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append("<nmsp p=\"Ping_IntervalSecs\" v=\"0\"/>").toString();
        }
        obj = (new StringBuilder()).append(((String) (obj1))).append("</cc>").toString().getBytes();
        int i1 = obj.length;
        int j1 = i1 + 4 + 1;
        obj1 = new byte[j1];
        bu.a(j1 - 4, ((byte []) (obj1)), 0);
        obj1[4] = 0;
        System.arraycopy(obj, 0, obj1, 5, i1);
        a(br.a((byte)3, (byte)23, (short)256, ((byte []) (obj1))), 3, "SEND_COP_CONNECT");
        f = new bq() {

            private cb a;

            public final void run()
            {
                if (cb.c().e())
                {
                    cb.c().e("XMode.handleSendCopConnect() COP CONNECT timed out. ");
                }
                if (cb.c(a) != null)
                {
                    cb.c(a).b();
                    cb.d(a);
                }
                cb.a(a, (byte)9, null);
_L1:
                return;
                Exception exception;
                exception;
                if (cb.c().e())
                {
                    cb.c().e((new StringBuilder("XMode.handleSendCopConnect() ")).append(exception.getClass().getName()).append(" ").append(exception.getMessage()).toString());
                    return;
                }
                  goto _L1
            }

            
            {
                a = cb.this;
                super();
            }
        };
        n.a(f, e * 1000);
        a = 1;
        A.a();
        return;
_L6:
        if (v != null && o != null)
        {
            obj = new byte[8];
            v.a(o, bp.b.a, ((byte []) (obj)), 8, this, "READ_XMODE_HEADER");
            return;
        }
          goto _L1
_L7:
        if (p.c > 0 && p.c <= 0x7d000)
        {
            obj = new byte[p.c];
            if (v != null && o != null)
            {
                v.a(o, bp.b.a, ((byte []) (obj)), obj.length, this, "READ_XMODE_PAYLOAD");
                return;
            }
        }
          goto _L1
_L3:
        if (c.b())
        {
            c.b("XMode.handleMessage() CMD_DISCONNECT");
        }
        obj = new byte[2];
        bu.a((short)0, ((byte []) (obj)), 0);
        obj = br.a((byte)3, (byte)23, (short)512, ((byte []) (obj)));
        v.b(o);
        a(((byte []) (obj)), 3, "SEND_COP_DISCONNECT");
        return;
_L5:
        if (c.b())
        {
            c.b("XMode.handleMessage() CMD_CLOSE_SOCKET");
        }
        if (v != null && o != null)
        {
            v.a(o);
            return;
        }
          goto _L1
_L9:
        if (c.b())
        {
            c.b("XMode.handleMessage() CMD_COP_PING_RESPONSE");
        }
        obj = new byte[8];
        bu.a(x, ((byte []) (obj)), 0);
        bu.a(0, ((byte []) (obj)), 4);
        a(br.a((byte)3, (byte)23, (short)259, ((byte []) (obj))), 3, "SEND_COP_PING_RESPONSE");
        return;
_L10:
        if (c.b())
        {
            c.b("XMode.handleMessage() CMD_COP_CONNECT_TIMED_OUT");
        }
        if (a == 1)
        {
            a = 2;
            q = 5;
            if (c.e())
            {
                c.e("XMode.handleCopConnectTimeout() COP CONNECT timed out. ");
            }
            a((byte)4, null);
            return;
        }
          goto _L1
_L11:
        if (c.b())
        {
            c.b("XMode.handleMessage() CMD_COP_CONFIRM");
        }
        obj = bo.b(u, b);
        obj1 = new byte[obj.length + 4];
        bu.a(obj.length, ((byte []) (obj1)), 0);
        System.arraycopy(obj, 0, obj1, 4, obj.length);
        a(br.a((byte)3, (byte)23, (short)262, ((byte []) (obj1))), 3, "SEND_COP_CONFIRM");
        return;
_L12:
        obj = (String)((bn.a) (obj)).b;
        A.a(((String) (obj)));
        return;
_L13:
        obj = (String)((bn.a) (obj)).b;
        A.b(((String) (obj)));
        return;
_L14:
        if (c.b())
        {
            c.b("XMode.handleMessage() CMD_GENERATE_COP_REF_ID");
        }
        C = cl.a((cm)((cm)B).f(), "NMSP_GATEWAY", new cl.a() {

            private cb a;

            public final void a(String s1)
            {
                cb.a(a, (byte)7, s1);
            }

            
            {
                a = cb.this;
                super();
            }
        });
        return;
_L15:
        if (c.b())
        {
            c.b("XMode.handleMessage() CMD_SEND_LOW_PRIORITY_MSG");
        }
        a(((byte []) (null)), 2, null);
        return;
        obj = obj1;
          goto _L19
    }

    public final void a(short word0, short word1)
    {
        if (c.b())
        {
            c.b((new StringBuilder("XMode.connect() codec: ")).append(word1).toString());
        }
        if (a != 1 && a != 0)
        {
            if (a == 2)
            {
                if (d != null)
                {
                    n.a(d);
                }
                if (h != null)
                {
                    n.a(h);
                }
                a("OpenSocket");
                o = null;
                v = null;
                b = null;
                w = "";
                y = word0;
                z = word1;
                a = 0;
                a((byte)1, null);
            } else
            if (a == 3)
            {
                a("OpenSocket");
                y = word0;
                z = word1;
                a = 0;
                a((byte)1, null);
                return;
            }
        }
    }

    public final void a(byte abyte0[], int i1)
    {
        if (c.b())
        {
            c.b((new StringBuilder("XMode.sendVapRecordMsg() audio id: ")).append(i1).toString());
        }
        if (a != 1)
        {
            return;
        } else
        {
            int j1 = abyte0.length;
            byte abyte1[] = new byte[j1 + 8];
            bu.a(i1, abyte1, 0);
            bu.a(j1, abyte1, 4);
            System.arraycopy(abyte0, 0, abyte1, 8, j1);
            a(br.a((byte)1, (byte)18, (short)513, abyte1), 3, "SEND_VAP_RECORD");
            return;
        }
    }

    public final void a(byte abyte0[], int i1, Object obj)
    {
        if (c.b())
        {
            c.b((new StringBuilder("XMode.sendXModeMsg() ")).append(obj).append(", buffer.length:").append(abyte0.length).toString());
        }
        if (h != null && n.a(h))
        {
            h = new bq() {

                private cb a;

                public final void run()
                {
                    cb.a(a);
                    if (cb.c().e())
                    {
                        cb.c().e((new StringBuilder("Session Idle for too long, longer than [")).append(cb.b(a)).append("] ()").toString());
                    }
                    a.a = 2;
                    cb.a(a, (byte)4, null);
_L1:
                    return;
                    Exception exception;
                    exception;
                    if (cb.c().e())
                    {
                        cb.c().e((new StringBuilder("XMode.sendXModeMsg() ")).append(exception.getClass().getName()).append(" ").append(exception.getMessage()).toString());
                        return;
                    }
                      goto _L1
                }

            
            {
                a = cb.this;
                super();
            }
            };
            n.a(h, g * 1000);
        }
        if (v == null || o == null) goto _L2; else goto _L1
_L1:
        if (i1 != 3 && i1 != 2 && (D.size() != 0 || E.size() != 0)) goto _L4; else goto _L3
_L3:
        if (i1 == 2)
        {
            obj = (b)E.remove();
            abyte0 = ((b) (obj)).a;
        } else
        {
            obj = new b(null, obj);
        }
        D.add(obj);
        v.a(o, abyte0, abyte0.length, this, obj);
_L6:
        return;
_L4:
        E.add(new b(abyte0, obj));
        return;
_L2:
        if (i1 == 1)
        {
            E.add(new b(abyte0, obj));
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void b()
    {
        if (c.b())
        {
            c.b((new StringBuilder("XMode.disconnect() state:")).append(a).append(", socket:").append(o).toString());
        }
        if (a != 3) goto _L2; else goto _L1
_L1:
        q = 1;
        A.a(q, r);
_L4:
        return;
_L2:
        if (a == 2) goto _L4; else goto _L3
_L3:
        if (a != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        a("CloseSocket");
        q = 1;
        a = 2;
        if (o == null) goto _L4; else goto _L5
_L5:
        v.a(o);
        return;
        if (a != 1) goto _L4; else goto _L6
_L6:
        a = 2;
        q = 1;
        a((byte)2, null);
        return;
    }

    public final void b(int i1)
    {
        if (c.b())
        {
            c.b((new StringBuilder("XMode.sendVapRecordEnd() audio id: ")).append(i1).toString());
        }
        if (a != 1)
        {
            return;
        } else
        {
            byte abyte0[] = new byte[4];
            bu.a(i1, abyte0, 0);
            a(br.a((byte)1, (byte)18, (short)256, abyte0), 3, "SEND_VAP_RECORD_END");
            return;
        }
    }

}
