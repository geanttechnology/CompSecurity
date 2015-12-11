// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Message;
import java.util.concurrent.TimeUnit;

final class ro
    implements android.os.Handler.Callback
{

    private rl a;

    ro(rl rl1)
    {
        a = rl1;
        super();
    }

    public final boolean handleMessage(Message message)
    {
        boolean flag;
        flag = false;
        int i = message.what;
        bmo.e((new StringBuilder(24)).append("PlayerEvent: ").append(i).toString());
        message.what;
        JVM INSTR tableswitch 0 15: default 116
    //                   0 292
    //                   1 303
    //                   2 303
    //                   3 116
    //                   4 314
    //                   5 116
    //                   6 116
    //                   7 116
    //                   8 314
    //                   9 116
    //                   10 116
    //                   11 325
    //                   12 116
    //                   13 458
    //                   14 503
    //                   15 361;
           goto _L1 _L2 _L3 _L3 _L1 _L4 _L1 _L1 _L1 _L4 _L1 _L1 _L5 _L1 _L6 _L7 _L8
_L1:
        if (!a.m.c()) goto _L10; else goto _L9
_L9:
        message.what;
        JVM INSTR tableswitch 1 12: default 196
    //                   1 530
    //                   2 557
    //                   3 878
    //                   4 814
    //                   5 945
    //                   6 959
    //                   7 973
    //                   8 1164
    //                   9 2099
    //                   10 2150
    //                   11 196
    //                   12 2182;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L11 _L22
_L11:
        message.what;
        JVM INSTR tableswitch 2 10: default 252
    //                   2 2227
    //                   3 2227
    //                   4 2227
    //                   5 2227
    //                   6 2227
    //                   7 2227
    //                   8 2227
    //                   9 2227
    //                   10 2227;
           goto _L23 _L24 _L24 _L24 _L24 _L24 _L24 _L24 _L24 _L24
_L23:
        int j = ((flag) ? 1 : 0);
_L58:
        if (j != 0 && ctf.a(message.what) != -1)
        {
            a.p = message.what;
            a.r();
        }
_L10:
        return true;
_L2:
        a.l = 2;
          goto _L1
_L3:
        a.l = 3;
          goto _L1
_L4:
        a.l = 1;
          goto _L1
_L5:
        cjq cjq1 = (cjq)message.obj;
        a.f.a(cjq1);
        a.b.a.c(cjq1);
          goto _L1
_L8:
        Object obj = a.f;
        j = message.arg1;
        if (((rs) (obj)).l != null)
        {
            obj = ((rs) (obj)).l;
            if (j != ((ph) (obj)).e)
            {
                pp pp1 = ((ph) (obj)).c;
                String s = ((ph) (obj)).e();
                pp1.a("sur", (new StringBuilder(String.valueOf(s).length() + 12)).append(s).append(":").append(j).toString());
                obj.e = j;
            }
        }
          goto _L1
_L6:
        cyp cyp1 = a.b;
        ctm ctm1;
        boolean flag1;
        if (message.arg1 != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ctm1 = new ctm(flag1);
        cyp1.a.c(ctm1);
          goto _L1
_L7:
        cyp cyp2 = a.b;
        cia cia1 = (cia)message.obj;
        cyp2.a.c(cia1);
          goto _L1
_L12:
        a.a(a.o, a.j.a);
          goto _L11
_L13:
        Object obj1 = a.f;
        long l;
        if (a.m.a())
        {
            l = a.h;
        } else
        {
            l = a.g;
        }
        if (((rs) (obj1)).n != null)
        {
            pv pv1 = ((rs) (obj1)).n;
            if (pv1.t)
            {
                bmo.c((new StringBuilder(65)).append("Warning: unexpected playback play ").append(l).append(" surpressed").toString());
            } else
            {
                pv1.a(true);
                pv1.o = l;
                pv1.c();
            }
        }
        if (((rs) (obj1)).b != null)
        {
            ((rs) (obj1)).b.g();
        }
        if (((rs) (obj1)).l != null)
        {
            obj1 = ((rs) (obj1)).l;
            obj1.l = false;
            ((ph) (obj1)).a(po.f);
        }
        obj1 = a.n;
        ((rp) (obj1)).removeCallbacks(((rp) (obj1)).a);
        ((rp) (obj1)).post(((rp) (obj1)).a);
        if (a.b(ctt.e))
        {
            a.c(ctt.f);
            a.b.a(new cso());
        }
        if (a.b(ctt.h))
        {
            a.c(ctt.i);
            a.b.a(new cso());
        }
          goto _L11
_L15:
        rs rs1 = a.f;
        if (rs1.n != null)
        {
            rs1.n.a(false);
        }
        if (rs1.b != null)
        {
            rs1.b.h();
        }
        if (rs1.l != null)
        {
            rs1.l.c();
        }
        a.n.a();
          goto _L11
_L14:
        rs rs2 = a.f;
        if (rs2.n != null)
        {
            rs2.n.a(false);
        }
        if (rs2.b != null)
        {
            rs2.b.i();
        }
        if (rs2.l != null)
        {
            rs2.l.a(po.e);
        }
        a.a.b();
          goto _L11
_L16:
        a.f.a(true);
          goto _L11
_L17:
        a.f.a(false);
          goto _L11
_L18:
        Object obj2 = a.n;
        ((rp) (obj2)).a();
        j = ((rp) (obj2)).c.c.i();
        rl.a(((rp) (obj2)).c, j, j, 100);
        obj2 = a.f;
        if (((rs) (obj2)).n != null)
        {
            pv pv2 = ((rs) (obj2)).n;
            pv2.a(false);
            if (!pv2.q && pv2.j > 0)
            {
                pv2.e();
            }
            pv2.d();
            pv2.b(false);
        }
        if (((rs) (obj2)).b != null)
        {
            ((rs) (obj2)).b.j();
            ((rs) (obj2)).b.d();
        }
        if (((rs) (obj2)).g != null)
        {
            ((rs) (obj2)).g.a();
        }
        if (((rs) (obj2)).l != null)
        {
            ((rs) (obj2)).l.a();
        }
        if (((rs) (obj2)).p != null)
        {
            ((rs) (obj2)).p.a();
        }
        if (a.m.d())
        {
            rl.a(a, 1);
        } else
        {
            a.c(ctt.j);
        }
          goto _L11
_L19:
        cnd cnd1;
        cnd1 = (cnd)message.obj;
        Object obj3 = a.f;
        if (((rs) (obj3)).b != null)
        {
            ((rs) (obj3)).b.a(cnd1);
        }
        if (((rs) (obj3)).l != null)
        {
            obj3 = ((rs) (obj3)).l;
            StringBuilder stringbuilder = (new StringBuilder()).append(((ph) (obj3)).e()).append(":").append(cnd1.a).append(":").append(ph.a(cnd1.b));
            Object obj6 = cnd1.c;
            if (obj6 != null)
            {
                stringbuilder.append(":").append(cxd.a(obj6));
            }
            ((ph) (obj3)).c.a("error", stringbuilder.toString());
            if (cnd1.a())
            {
                ((ph) (obj3)).a(po.b);
                ((ph) (obj3)).c.a();
            }
        }
        a.b.a(cnd1);
        obj3 = a;
        String s1 = cnd1.a;
        if ((s1.equals("staleconfig") || s1.equals("net.timeout")) && ((rl) (obj3)).i != null && ((rl) (obj3)).i.d != null && ((rl) (obj3)).i.d.a(((rl) (obj3)).e.b() + TimeUnit.MILLISECONDS.convert(10L, TimeUnit.SECONDS)))
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (j != 0)
        {
            message = a.i.d;
            long l1 = a.e.b();
            ctl ctl1;
            if (!message.a(l1))
            {
                j = -1;
            } else
            {
                j = (int)TimeUnit.SECONDS.convert(l1 - ((bww) (message)).h, TimeUnit.MILLISECONDS);
            }
            message = a.b;
            ctl1 = new ctl(j);
            ((cyp) (message)).a.c(ctl1);
            return true;
        }
        if (!cnd1.a()) goto _L10; else goto _L25
_L25:
        if (!a.m.d()) goto _L27; else goto _L26
_L26:
        rl.a(a, 2);
_L30:
        a.n.a();
          goto _L11
_L27:
        Object obj4;
        String s2;
        s2 = cnd1.a;
        j = 0x7f0b0120;
        obj4 = csf.h;
        if (!s2.contains("net.nomobiledata")) goto _L29; else goto _L28
_L28:
        boolean flag2;
        j = 0x7f0b00ef;
        flag2 = true;
_L33:
        if (flag2 && a.m.e())
        {
            a.g = a.u();
        }
        a.a(new cse(((csf) (obj4)), flag2, a.d.getString(j)));
          goto _L30
_L29:
        if (!s2.contains("net.dns")) goto _L32; else goto _L31
_L31:
        flag2 = true;
        j = 0x7f0b0121;
          goto _L33
_L32:
        if (!s2.contains("net.connect")) goto _L35; else goto _L34
_L34:
        flag2 = true;
        j = 0x7f0b0121;
          goto _L33
_L35:
        if (!s2.contains("net.timeout") && !s2.contains("net.closed")) goto _L37; else goto _L36
_L36:
        j = 0x7f0b0122;
        flag2 = true;
          goto _L33
_L37:
        if (!s2.startsWith("fmt.unplayable")) goto _L39; else goto _L38
_L38:
        j = 0x7f0b0123;
        flag2 = false;
          goto _L33
_L39:
        if (!s2.startsWith("drm.missingapi")) goto _L41; else goto _L40
_L40:
        j = 0x7f0b0111;
        flag2 = false;
          goto _L33
_L41:
        if (!s2.startsWith("drm.auth") || !(cnd1.c instanceof Integer)) goto _L43; else goto _L42
_L42:
        int k;
        k = ((Integer)cnd1.c).intValue();
        obj4 = csf.f;
        k;
        JVM INSTR lookupswitch 13: default 1920
    //                   300: 1926
    //                   301: 1937
    //                   303: 1949
    //                   304: 1961
    //                   305: 1973
    //                   400: 1985
    //                   401: 1996
    //                   402: 2007
    //                   403: 2018
    //                   405: 2029
    //                   500: 2040
    //                   501: 2051
    //                   502: 2062;
           goto _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57
_L44:
        flag2 = true;
          goto _L33
_L45:
        j = 0x7f0b010d;
        flag2 = false;
          goto _L33
_L46:
        j = 0x7f0b0105;
        obj4 = csf.g;
          goto _L44
_L47:
        j = 0x7f0b010a;
        obj4 = csf.g;
          goto _L44
_L48:
        j = 0x7f0b010b;
        obj4 = csf.g;
          goto _L44
_L49:
        j = 0x7f0b010c;
        obj4 = csf.g;
          goto _L44
_L50:
        j = 0x7f0b0104;
        flag2 = false;
          goto _L33
_L51:
        j = 0x7f0b010e;
        flag2 = false;
          goto _L33
_L52:
        j = 0x7f0b0106;
        flag2 = false;
          goto _L33
_L53:
        j = 0x7f0b010f;
        flag2 = false;
          goto _L33
_L54:
        j = 0x7f0b0110;
        flag2 = false;
          goto _L33
_L55:
        j = 0x7f0b0107;
        flag2 = false;
          goto _L33
_L56:
        j = 0x7f0b0109;
        flag2 = false;
          goto _L33
_L57:
        j = 0x7f0b0108;
        flag2 = false;
          goto _L33
_L43:
        if (s2.startsWith("drm"))
        {
            obj4 = csf.f;
            j = 0x7f0b0120;
            flag2 = false;
        } else
        {
            j = 0x7f0b0120;
            flag2 = true;
        }
          goto _L33
_L20:
        obj4 = a.f;
        j = message.arg1;
        if (((rs) (obj4)).n != null)
        {
            ((rs) (obj4)).n.a(j);
        }
        if (((rs) (obj4)).l != null)
        {
            ((rs) (obj4)).l.a(po.g);
        }
          goto _L11
_L21:
        long l2 = a.a.b(message.arg1);
        a.n.b = l2;
          goto _L11
_L22:
        Object obj5 = a.f;
        j = message.arg1;
        if (((rs) (obj5)).l != null)
        {
            obj5 = ((rs) (obj5)).l;
            obj5.j = j + ((ph) (obj5)).j;
            ((ph) (obj5)).a(false);
        }
          goto _L11
_L24:
        j = 1;
          goto _L58
    }
}
