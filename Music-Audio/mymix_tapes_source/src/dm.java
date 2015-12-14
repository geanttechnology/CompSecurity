// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
import java.util.Vector;

public class dm
    implements bn.b, cb.a
{

    private static final bm a = d.a(dm);
    private static byte m[] = new byte[16];
    private static int p = 1;
    private static String v[] = {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
        "A", "B", "C", "D", "E", "F"
    };
    private Hashtable b;
    private Hashtable c;
    private Hashtable d;
    private cb e;
    private String f;
    private short g;
    private Vector h;
    private bn i;
    private dh j;
    private Vector k;
    private byte l[];
    private bi n;
    private bi o;
    private boolean q;
    private di r;
    private long s;
    private byte t;
    private ce u;

    public dm(String s1, short word0, String s2, byte abyte0[], String s3, Vector vector, bn bn1, 
            dh dh1)
    {
        l = null;
        q = false;
        s = 1L;
        t = 1;
        f = s1;
        g = word0;
        i = bn1;
        j = dh1;
        r = null;
        k = new Vector();
        b = new Hashtable();
        c = new Hashtable();
        d = new Hashtable();
        h = new Vector();
        e = new cb(f, g, s2, abyte0, s3, this, vector, bn1);
    }

    public static String a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return "";
        }
        StringBuffer stringbuffer = new StringBuffer();
        for (int i1 = 0; i1 < 16; i1++)
        {
            byte byte1 = abyte0[i1];
            byte byte0 = (byte)((byte)((byte)(byte1 & 0xf0) >>> 4) & 0xf);
            byte1 &= 0xf;
            stringbuffer.append((new StringBuilder()).append(v[byte0]).append(v[byte1]).toString());
            if (i1 == 3 || i1 == 5 || i1 == 7 || i1 == 9)
            {
                stringbuffer.append("-");
            }
        }

        return stringbuffer.toString().toLowerCase();
    }

    private void a(byte byte0, Object obj)
    {
        bn bn1 = i;
        obj = new bn.a(byte0, obj);
        Thread thread = Thread.currentThread();
        i.a();
        bn1.a(obj, this, thread);
    }

    private void b(byte abyte0[])
    {
        byte byte0 = abyte0[16];
        short word0 = bu.a(abyte0, 17);
        for (int i1 = 0; i1 < h.size(); i1++)
        {
            ((dn)h.elementAt(i1)).a(byte0, word0);
        }

    }

    private void c(String s1)
    {
        if (u != null)
        {
            cg cg1 = u.a(s1);
            if (s1.compareTo("ConnectionEstablished") == 0)
            {
                try
                {
                    cg1.a("SessionID", a(l));
                }
                // Misplaced declaration of an exception variable
                catch (String s1) { }
            }
            cg1.a();
        }
    }

    private void c(byte abyte0[])
    {
        int i2 = bu.b(abyte0, 0);
        if (c.size() != 0)
        {
            cx cx1 = (cx)c.get(new Integer(i2));
            if (cx1 == null)
            {
                a.e((new StringBuilder("Could not find the audio sink associated with AID: ")).append(i2).toString());
                return;
            }
            int k1 = bu.b(abyte0, 4);
            int i1 = 8;
            int l1 = i1;
            int j1 = k1;
            if (bx.b(o))
            {
                for (j1 = k1; (abyte0[i1] & 0x80) > 0; j1--)
                {
                    i1++;
                }

                l1 = i1 + 1;
                j1--;
            }
            if (j1 > 0 && j1 <= abyte0.length - l1)
            {
                try
                {
                    cx1.a(abyte0, l1, j1, false);
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    a.e(abyte0.getMessage());
                }
            }
            if (d.size() != 0)
            {
                abyte0 = (dn)d.get(new Integer(i2));
                if (abyte0 == null)
                {
                    a.e((new StringBuilder("parseXModeMsgVapPlay:: Could not find the session listener associated with AID: ")).append(i2).toString());
                    return;
                } else
                {
                    abyte0.e();
                    return;
                }
            }
        }
    }

    public static void d()
    {
    }

    private void k()
    {
        do
        {
            if (k.isEmpty())
            {
                break;
            }
            bn.a a1 = (bn.a)k.firstElement();
            k.removeElementAt(0);
            switch (a1.a)
            {
            case 1: // '\001'
                a((byte)1, a1.b);
                break;

            case 2: // '\002'
                a((byte)2, a1.b);
                break;

            case 4: // '\004'
                a((byte)4, a1.b);
                break;

            case 5: // '\005'
                a((byte)5, a1.b);
                break;

            case 6: // '\006'
                a((byte)6, a1.b);
                break;

            case 7: // '\007'
                a((byte)7, a1.b);
                break;

            case 8: // '\b'
                a((byte)8, a1.b);
                break;
            }
        } while (true);
    }

    public final void a()
    {
    }

    public final void a(byte byte0, int i1, dn dn1)
    {
        a.b((new StringBuilder("freeResource, TID: ")).append(byte0).append(", disconnect timeout: ").append(i1).toString());
        h.removeElement(dn1);
        dn1 = ((dn) (new Object[2]));
        dn1[0] = new Byte(byte0);
        dn1[1] = new Integer(i1);
        if (l != null && k.isEmpty())
        {
            a((byte)4, dn1);
            return;
        } else
        {
            k.addElement(new bn.a((byte)4, dn1));
            return;
        }
    }

    public final void a(int i1)
    {
        if (a.b())
        {
            a.b((new StringBuilder("vapRecordBegin, AID: ")).append(i1).toString());
        }
        Integer integer = new Integer(i1);
        if (l != null && k.isEmpty())
        {
            a((byte)5, integer);
            return;
        } else
        {
            k.addElement(new bn.a((byte)5, integer));
            return;
        }
    }

    public final void a(int i1, cx cx1, dn dn1)
    {
        c.put(new Integer(i1), cx1);
        d.put(new Integer(i1), dn1);
    }

    public final void a(bi bi1, bi bi2)
    {
        if (a.b())
        {
            a.b("connect()");
        }
        c("Connect");
        n = bi1;
        o = bi2;
        a((byte)1, null);
    }

    public final void a(bs bs1, byte abyte0[])
    {
        if (a.b())
        {
            a.b((new StringBuilder("xmodeMsgCallback, protocol: ")).append(bs1.a).append(", command: ").append(bs1.b).toString());
        }
        bs1.a;
        JVM INSTR tableswitch 1 3: default 80
    //                   1 952
    //                   2 273
    //                   3 90;
           goto _L1 _L2 _L3 _L4
_L1:
        a.e("Unknown Xmode protocol");
_L5:
        return;
_L4:
        switch (bs1.b)
        {
        default:
            return;

        case 257: 
            l = e.b;
            if (a.b())
            {
                a.b((new StringBuilder("connected(")).append(a(l)).append(") called on ").append(j).toString());
            }
            c("ConnectionEstablished");
            bs1 = j;
            abyte0 = a(l);
            di di = r;
            bs1.a(abyte0);
            for (int i1 = 0; i1 < h.size(); i1++)
            {
                ((dn)h.elementAt(i1)).a(l);
            }

            k();
            return;

        case 512: 
        case 768: 
            break;
        }
        if (true) goto _L5; else goto _L3
_L3:
        byte byte3;
        int k2;
        switch (bs1.b)
        {
        default:
            a.e("Unknown BCP command");
            return;

        case 2578: 
            break;

        case 2579: 
            long l3 = bu.b(abyte0, 17);
            bu.a(abyte0, 21);
            int j1 = bu.b(abyte0, 23);
            if (j1 > 0 && j1 <= abyte0.length - 27)
            {
                System.arraycopy(abyte0, 27, new byte[j1], 0, j1);
            }
            b.remove(new Long(l3));
            return;

        case 2580: 
            long l4 = bu.b(abyte0, 17);
            bu.a(abyte0, 21);
            int k1 = bu.b(abyte0, 23);
            if (k1 > 0 && k1 <= abyte0.length - 27)
            {
                System.arraycopy(abyte0, 27, new byte[k1], 0, k1);
            }
            b.get(new Long(l4));
            return;

        case 2584: 
            Object obj = null;
            byte byte0 = abyte0[16];
            int l1 = bu.b(abyte0, 17);
            short word0 = bu.a(abyte0, 21);
            int j3 = bu.b(abyte0, 23);
            bs1 = obj;
            if (j3 > 0)
            {
                bs1 = obj;
                if (j3 <= abyte0.length - 27)
                {
                    bs1 = new byte[j3];
                    System.arraycopy(abyte0, 27, bs1, 0, j3);
                }
            }
            abyte0 = (dn)b.remove(new Long(l1));
            if (abyte0 != null)
            {
                abyte0.b(byte0, l1, word0, bs1);
                return;
            }
            break;

        case 2582: 
            Object obj1 = null;
            byte byte1 = abyte0[16];
            int i2 = bu.b(abyte0, 17);
            short word1 = bu.a(abyte0, 21);
            int k3 = bu.b(abyte0, 23);
            bs1 = obj1;
            if (k3 > 0)
            {
                bs1 = obj1;
                if (k3 <= abyte0.length - 27)
                {
                    bs1 = new byte[k3];
                    System.arraycopy(abyte0, 27, bs1, 0, k3);
                }
            }
            abyte0 = (dn)b.remove(new Long(i2));
            if (abyte0 != null)
            {
                abyte0.a(byte1, i2, word1, bs1);
                return;
            }
            break;

        case 2577: 
            long l5 = bu.b(abyte0, 17);
            bu.b(abyte0, 21);
            bu.a(abyte0, 25);
            b.remove(new Long(l5));
            return;

        case 2600: 
            b(abyte0);
            return;

        case 2576: 
            byte byte2 = abyte0[16];
            int j2 = bu.b(abyte0, 17);
            short word2 = bu.a(abyte0, 21);
            short word3 = bu.a(abyte0, 23);
            short word4 = bu.a(abyte0, 25);
            bs1 = (dn)b.get(new Long(j2));
            if (bs1 != null)
            {
                bs1.a(byte2, j2, word2, word3, word4);
                if (word2 != 200)
                {
                    b.remove(new Long(j2));
                    return;
                }
            }
            break;

        case 2585: 
            byte3 = abyte0[16];
            k2 = bu.b(abyte0, 21);
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L5; else goto _L6
_L6:
        if (k2 <= 0 || k2 > abyte0.length - 25) goto _L5; else goto _L7
_L7:
        bs1 = new byte[k2];
        System.arraycopy(abyte0, 25, bs1, 0, k2);
        abyte0 = (dn)b.get(new Long(0L));
        if (abyte0 == null) goto _L5; else goto _L8
_L8:
        abyte0.a(byte3, bs1);
        return;
_L2:
        switch (bs1.b)
        {
        default:
            return;

        case 512: 
            c(abyte0);
            return;

        case 528: 
            int l2 = bu.b(abyte0, 0);
            if (d.size() != 0)
            {
                bs1 = (dn)d.get(new Integer(l2));
                if (bs1 == null)
                {
                    a.e((new StringBuilder("parseVapPlayBegin:: Could not find the session listener associated with AID: ")).append(l2).toString());
                    return;
                } else
                {
                    bs1.d();
                    return;
                }
            }
            break;

        case 1024: 
            int i3 = bu.b(abyte0, 0);
            if (c.size() != 0)
            {
                bs1 = (cx)c.remove(new Integer(i3));
                if (bs1 == null)
                {
                    a.e((new StringBuilder("Could not find the audio sink associated with AID: ")).append(i3).toString());
                    return;
                }
                try
                {
                    bs1.a(null, 0, 0, true);
                }
                // Misplaced declaration of an exception variable
                catch (bs bs1)
                {
                    a.e(bs1.getMessage());
                }
                bs1 = (dn)d.remove(new Integer(i3));
                if (bs1 == null)
                {
                    a.e((new StringBuilder("parseXModeMsgVapPlayEnd:: Could not find the session listener associated with AID: ")).append(i3).toString());
                    return;
                } else
                {
                    bs1.f();
                    return;
                }
            }
            break;
        }
        if (true) goto _L5; else goto _L9
_L9:
    }

    public final void a(ce ce1)
    {
        u = ce1.a("NMSPSession").a();
        e.a(u);
    }

    public final void a(di di)
    {
        r = di;
    }

    public final void a(dn dn1)
    {
        if (!h.contains(dn1))
        {
            h.addElement(dn1);
        }
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (bn.a)obj;
        ((bn.a) (obj)).a;
        JVM INSTR tableswitch 1 8: default 56
    //                   1 66
    //                   2 88
    //                   3 96
    //                   4 109
    //                   5 193
    //                   6 222
    //                   7 307
    //                   8 336;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        a.e("Unknown command");
_L11:
        return;
_L2:
        e.a(n.a(), o.a());
        return;
_L3:
        e.b();
        return;
_L4:
        q = true;
        e.b();
        return;
_L5:
        if (l == null) goto _L11; else goto _L10
_L10:
        obj = ((Object) ((Object[])((bn.a) (obj)).b));
        byte byte0 = ((Byte)obj[0]).byteValue();
        int i1 = ((Integer)obj[1]).intValue();
        obj = new byte[5];
        obj[0] = byte0;
        bu.a(i1, ((byte []) (obj)), 1);
        obj = br.a((byte)2, (byte)34, (short)2601, br.a(((byte []) (obj)), l));
        e.a(((byte []) (obj)), 3, "SEND_BCP_FREE_RESOURCE");
        return;
_L6:
        if (l == null) goto _L11; else goto _L12
_L12:
        int j1 = ((Integer)((bn.a) (obj)).b).intValue();
        e.a(j1);
        return;
_L7:
        if (l == null) goto _L11; else goto _L13
_L13:
        obj = ((Object) ((Object[])((bn.a) (obj)).b));
        obj1 = (byte[])obj[0];
        int j2 = ((Integer)obj[1]).intValue();
        for (int k1 = 0; k1 < h.size(); k1++)
        {
            ((dn)h.elementAt(k1)).c();
        }

        e.a(((byte []) (obj1)), j2);
        return;
_L8:
        if (l == null) goto _L11; else goto _L14
_L14:
        int l1 = ((Integer)((bn.a) (obj)).b).intValue();
        e.b(l1);
        return;
_L9:
        if (l == null) goto _L11; else goto _L15
_L15:
        short word0;
        dn dn1;
        Object aobj[] = (Object[])((bn.a) (obj)).b;
        word0 = ((Short)aobj[0]).shortValue();
        obj1 = (String)aobj[1];
        obj = (byte[])aobj[2];
        byte abyte0[] = (byte[])aobj[3];
        byte byte1 = ((Byte)aobj[4]).byteValue();
        long l2 = ((Long)aobj[5]).longValue();
        dn1 = (dn)aobj[6];
        boolean flag = ((Boolean)aobj[7]).booleanValue();
        b.put(new Long(l2), dn1);
        int k2 = obj.length + 5;
        int i2 = k2;
        if (word0 == 2585)
        {
            i2 = k2 + 4;
        }
        aobj = new byte[i2];
        aobj[0] = byte1;
        i2 = 1;
        if (word0 == 2585)
        {
            bu.a((int)l2, ((byte []) (aobj)), 1);
            i2 = 5;
        }
        bu.a(obj.length, ((byte []) (aobj)), i2);
        System.arraycopy(obj, 0, ((Object) (aobj)), i2 + 4, obj.length);
        ByteArrayOutputStream bytearrayoutputstream;
        if (l != null)
        {
            obj = l;
        } else
        {
            obj = m;
        }
        obj = br.a(((byte []) (aobj)), ((byte []) (obj)));
        bytearrayoutputstream = new ByteArrayOutputStream();
        bytearrayoutputstream.write(((byte []) (obj)), 0, obj.length);
        if (abyte0 != null)
        {
            bytearrayoutputstream.write(abyte0, 0, abyte0.length);
        }
        obj = br.a((byte)2, (byte)34, word0, bytearrayoutputstream.toByteArray());
        e.a(((byte []) (obj)), 3, obj1);
        if (!flag) goto _L11; else goto _L16
_L16:
        if (word0 != 2581)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (dn1 == null) goto _L11; else goto _L17
_L17:
        dn1.a(byte1, l2, (short)200, null);
        return;
        if (word0 != 2608 || dn1 == null) goto _L11; else goto _L18
_L18:
        h.removeElement(dn1);
        dn1.b();
        return;
    }

    public final void a(String s1)
    {
    }

    public final void a(short word0, String s1, byte abyte0[], byte abyte1[], byte byte0, long l1, 
            dn dn1, boolean flag)
    {
        if (a.b())
        {
            a.b((new StringBuilder("postBcpMessage, BCP: ")).append(word0).append(", TID: ").append(byte0).append(", RID: ").append(l1).toString());
        }
        Object aobj[] = new Object[8];
        aobj[0] = new Short(word0);
        aobj[1] = s1;
        aobj[2] = abyte0;
        aobj[3] = abyte1;
        aobj[4] = new Byte(byte0);
        aobj[5] = new Long(l1);
        aobj[6] = dn1;
        aobj[7] = new Boolean(flag);
        if (l != null && k.isEmpty())
        {
            a((byte)8, ((Object) (aobj)));
            return;
        } else
        {
            k.addElement(new bn.a((byte)8, ((Object) (aobj))));
            return;
        }
    }

    public final void a(short word0, short word1)
    {
        if (a.b())
        {
            a.b((new StringBuilder("socketClosed, reason: ")).append(word0).toString());
        }
        if (a.b())
        {
            a.b((new StringBuilder("socketClosed() sessionListeners.size():")).append(h.size()).toString());
        }
        for (int i1 = 0; i1 < h.size(); i1++)
        {
            ((dn)h.elementAt(i1)).a(word0);
        }

        if (!k.isEmpty())
        {
            k.removeAllElements();
        }
        h.removeAllElements();
        if (word0 != 4 && word0 != 5) goto _L2; else goto _L1
_L1:
        dh dh1 = j;
        di di = r;
        dh1.a((short)9);
_L4:
        if (word0 == 1 && q)
        {
            i.c();
            j.a();
        }
        l = null;
        return;
_L2:
        if (word0 == 7)
        {
            dh dh2 = j;
            di di1 = r;
            dh2.a(word1);
        } else
        if (word0 == 8 && l == null)
        {
            dh dh3 = j;
            di di2 = r;
            dh3.a((short)9);
        } else
        if (l != null)
        {
            dh dh4 = j;
            di di3 = r;
            dh4.b(word1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(byte abyte0[], int i1)
    {
        if (a.b())
        {
            a.b((new StringBuilder("vapRecord, AID: ")).append(i1).toString());
        }
        Object aobj[] = new Object[2];
        aobj[0] = abyte0;
        aobj[1] = new Integer(i1);
        if (l != null && k.isEmpty())
        {
            a((byte)6, ((Object) (aobj)));
            return;
        } else
        {
            k.addElement(new bn.a((byte)6, ((Object) (aobj))));
            return;
        }
    }

    public final cb b()
    {
        return e;
    }

    public final void b(int i1)
    {
        if (a.b())
        {
            a.b((new StringBuilder("vapRecordEnd, AID: ")).append(i1).toString());
        }
        Integer integer = new Integer(i1);
        if (l != null && k.isEmpty())
        {
            a((byte)7, integer);
            return;
        } else
        {
            k.addElement(new bn.a((byte)7, integer));
            return;
        }
    }

    public final void b(dn dn1)
    {
        h.removeElement(dn1);
    }

    public final void b(String s1)
    {
    }

    public final int c()
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        i1 = p;
        p = i1 + 1;
        if (p == 0x80000000)
        {
            p = 1;
        }
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void e()
    {
        if (a.b())
        {
            a.b("disconnectAndShutdown");
        }
        a((byte)3, null);
    }

    public final byte[] f()
    {
        return l;
    }

    public final long g()
    {
        long l1 = s;
        s = l1 + 1L;
        if (s == 0x8000000000000000L)
        {
            s = 1L;
        }
        return l1;
    }

    public final byte h()
    {
        byte byte0 = t;
        t = (byte)(byte0 + 1);
        if (t == -128)
        {
            t = 1;
        }
        return byte0;
    }

    public final bi i()
    {
        return n;
    }

    public final ce j()
    {
        return u;
    }

}
