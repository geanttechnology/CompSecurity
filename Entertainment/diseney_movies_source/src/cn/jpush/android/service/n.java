// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.database.Cursor;
import cn.jpush.android.a;
import cn.jpush.android.data.u;
import cn.jpush.android.data.w;
import cn.jpush.android.util.ae;
import cn.jpush.android.util.x;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;

// Referenced classes of package cn.jpush.android.service:
//            PushService, PushProtocol

public final class n extends Thread
{

    private static final String z[];
    boolean a;
    final PushService b;
    private volatile boolean c;

    public n(PushService pushservice)
    {
        b = pushservice;
        super();
        c = false;
        a = true;
    }

    private int a()
    {
        Object obj;
        Object obj3;
        int j;
        int k;
        int j1;
        Object aobj[] = MessageDigest.getInstance(z[18]).digest(PushService.t.getBytes());
        obj = new StringBuilder(aobj.length * 2);
        k = aobj.length;
        for (int i = 0; i < k; i++)
        {
            byte byte0 = aobj[i];
            ((StringBuilder) (obj)).append(String.format(z[41], new Object[] {
                Byte.valueOf(byte0)
            }));
        }

        obj = ((StringBuilder) (obj)).toString();
        String.format(z[19], new Object[] {
            Long.valueOf(PushService.s), obj
        });
        x.c();
        aobj = z[22].split(z[33]);
        j = Integer.parseInt(aobj[0]);
        k = Integer.parseInt(aobj[1]);
        j1 = Integer.parseInt(aobj[2]);
        StringBuilder stringbuilder = new StringBuilder(a.f.length());
        stringbuilder.append(a.f);
        obj3 = stringbuilder.toString();
        if (b.v == 0) goto _L2; else goto _L1
_L1:
        Cursor cursor;
        String s;
        String s1;
        int k1;
        int l1;
        int i2;
        int j2;
        x.c();
        s = cn.jpush.android.util.a.w(b.getApplicationContext());
        byte abyte0[] = new byte[128];
        long l2 = System.currentTimeMillis();
        j2 = PushProtocol.LogPushWithBack(b.v, abyte0, PushService.s, ((String) (obj)), ((String) (obj3)), (j << 16) + (k << 8) + j1);
        s1 = (new StringBuilder()).append(s).append("_").append(j2).append("_").append(PushService.b()).append("_").append(cn.jpush.android.util.a.d()).toString();
        long l5 = System.currentTimeMillis();
        long l4 = l5 - l2;
        (new StringBuilder(z[14])).append(s1).append(z[38]).append(l5).append(z[16]).append(l2).append(z[20]).append(l4).toString();
        x.c();
        if (j2 == 0 || j2 == 9999)
        {
            j = cn.jpush.android.util.a.b(abyte0);
            j1 = cn.jpush.android.util.a.c(abyte0);
            (new StringBuilder(z[17])).append(j2).append(z[24]).append(j).append(z[31]).append(j1).toString();
            x.d();
            (new StringBuilder(z[15])).append(cn.jpush.android.service.PushService.a(abyte0, j1)).toString();
            x.d();
            if (j1 < 34)
            {
                x.e(z[2], (new StringBuilder(z[32])).append(j1).append(z[29]).toString());
            }
            int l = 0;
            for (j = 0; j < 2; j++)
            {
                l = (l << 8) + (abyte0[j + 20] & 0xff);
            }

            if (l == 0)
            {
                long l3 = 0L;
                for (j = 0; j < 4; j++)
                {
                    l3 = (l3 << 8) + (long)(abyte0[j + 22] & 0xff);
                }

                (new StringBuilder(z[25])).append(l3).toString();
                x.d();
                int i1 = 0;
                for (j = 0; j < 2; j++)
                {
                    i1 = (i1 << 8) + (abyte0[j + 26] & 0xff);
                }

                (new StringBuilder(z[35])).append(i1).toString();
                x.d();
                i1 = 0;
                byte byte1;
                for (j = 0; i1 < 2; j = (j << 8) + (byte1 & 0xff))
                {
                    byte1 = abyte0[i1 + 28];
                    i1++;
                }

                byte abyte1[] = new byte[j];
                for (i1 = 0; i1 < abyte1.length; i1++)
                {
                    abyte1[i1] = (byte)(abyte0[i1 + 30] & 0xff);
                }

                Object obj1 = new String(abyte1);
                (new StringBuilder(z[34])).append(((String) (obj1))).toString();
                x.d();
                i1 = j + 30;
                l3 = 0L;
                for (j = 0; j < 4; j++)
                {
                    l3 = (l3 << 8) + (long)(abyte0[i1 + j] & 0xff);
                }

                j = i1 + 4;
                boolean flag;
                boolean flag1;
                if (j == j1)
                {
                    x.d();
                } else
                {
                    (new StringBuilder(z[21])).append(j).append(z[26]).append(j1).toString();
                    x.d();
                }
                PushService.m = l3;
                PushService.n = System.currentTimeMillis() / 1000L;
                x.c(z[2], (new StringBuilder(z[43])).append(l3).toString());
                (new StringBuilder(z[42])).append(PushService.m).append(z[40]).append(PushService.n).toString();
                x.c();
                ae.b(b.getApplicationContext(), z[37], PushService.m);
                ae.b(b.getApplicationContext(), z[30], PushService.n);
            }
            j1 = 0;
        } else
        {
            j1 = 1;
            x.e(z[2], (new StringBuilder(z[28])).append(j2).toString());
            (new StringBuilder(z[23])).append(s1).toString();
            x.c();
        }
        x.d();
        k1 = 0;
        j = 0;
        l1 = 0;
        flag1 = false;
        flag = false;
        i2 = ((flag) ? 1 : 0);
        if (j1 == 0)
        {
            if (l4 <= 1000L)
            {
                j = 1;
            }
            i1 = ((flag1) ? 1 : 0);
            if (l4 > 1000L)
            {
                i1 = ((flag1) ? 1 : 0);
                if (l4 <= 3000L)
                {
                    i1 = 1;
                }
            }
            k1 = j;
            l1 = i1;
            i2 = ((flag) ? 1 : 0);
            if (l4 > 3000L)
            {
                i2 = 1;
                l1 = i1;
                k1 = j;
            }
        }
        obj3 = new u(b.getApplicationContext());
        if (obj3 == null) goto _L4; else goto _L3
_L3:
        ((u) (obj3)).a();
        if (!((u) (obj3)).a(s1)) goto _L6; else goto _L5
_L5:
        (new StringBuilder(z[36])).append(s1).append(z[39]).toString();
        x.d();
        cursor = null;
        obj1 = ((u) (obj3)).b(s1);
        cursor = ((Cursor) (obj1));
        if (cursor != null)
        {
            break MISSING_BLOCK_LABEL_1209;
        }
        x.e();
        obj1 = u.a(cursor);
        if (obj1 == null) goto _L8; else goto _L7
_L7:
        ((u) (obj3)).b(s1, s, PushService.b(), cn.jpush.android.util.a.d(), (new StringBuilder()).append(j2).toString(), j1 + ((w) (obj1)).f(), ((w) (obj1)).g() + 1, k1 + ((w) (obj1)).h(), l1 + ((w) (obj1)).i(), i2 + ((w) (obj1)).j(), ((w) (obj1)).k() + 0);
_L9:
        if (cursor != null)
        {
            cursor.close();
        }
_L10:
        ((u) (obj3)).b();
_L4:
        j = j2;
_L11:
        String.format(z[44], new Object[] {
            Integer.valueOf(j)
        });
        x.c();
        return j;
_L8:
        x.e();
          goto _L9
        Object obj2;
        obj2;
_L13:
        if (cursor != null)
        {
            cursor.close();
        }
          goto _L10
        obj2;
        cursor = null;
_L12:
        if (cursor != null)
        {
            cursor.close();
        }
        throw obj2;
_L6:
        (new StringBuilder(z[36])).append(s1).append(z[27]).toString();
        x.d();
        ((u) (obj3)).a(s1, s, PushService.b(), cn.jpush.android.util.a.d(), (new StringBuilder()).append(j2).toString(), j1, 1, k1, l1, i2, 0);
          goto _L10
_L2:
        j = -1;
          goto _L11
        obj2;
          goto _L12
        obj2;
          goto _L13
    }

    public final void run()
    {
        int i;
        (new StringBuilder(z[0])).append(getId()).toString();
        x.d();
        Object obj = b;
        PushService.c();
        try
        {
            if (b.v != 0)
            {
                x.e();
                b.v = PushProtocol.Close(b.v);
            }
        }
        catch (Exception exception)
        {
            x.c();
        }
        b.d();
        b.v = PushProtocol.InitConn();
        obj = PushService.h();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        int j;
        try
        {
            PushService.e(InetAddress.getByName(PushService.h()).getHostAddress());
            (new StringBuilder(z[12])).append(PushService.i()).append(z[10]).append(PushService.h()).toString();
            x.c();
        }
        catch (UnknownHostException unknownhostexception) { }
        (new StringBuilder(z[6])).append(PushService.i()).append(z[9]).append(PushService.j()).toString();
        x.c();
        i = PushProtocol.InitPush(b.v, PushService.i(), PushService.j());
        if (i != 0)
        {
            InterruptedException interruptedexception;
            try
            {
                (new StringBuilder(z[7])).append(getId()).toString();
                x.c();
                if (b.v != 0)
                {
                    x.e();
                    b.v = PushProtocol.Close(b.v);
                }
                b.f(0);
                return;
            }
            catch (Exception exception1)
            {
                x.h();
            }
            return;
        }
        String.format(z[3], new Object[] {
            Integer.valueOf(i)
        });
        x.c();
        if (!PushService.k())
        {
            PushService.e(PushService.c(b.getApplicationContext()));
        }
        if (!PushService.k() || PushService.s == 0L || PushService.t == null)
        {
            b.e();
        }
        if (PushService.s == 0L)
        {
            break MISSING_BLOCK_LABEL_725;
        }
        j = a();
        if (j != 0 && j != 9999) goto _L2; else goto _L1
_L1:
        x.b(z[2], (new StringBuilder(z[5])).append(cn.jpush.android.util.a.u(b.getApplicationContext())).toString());
        cn.jpush.android.service.PushService.a(b, 0);
        if (PushService.l())
        {
            cn.jpush.android.service.PushService.a(b);
        }
        try
        {
            b.g();
        }
        catch (Exception exception2) { }
        if (j != 9999)
        {
            break MISSING_BLOCK_LABEL_455;
        }
        PushService.b(b, 6000);
        b.a(1, z[8]);
        i = j;
_L7:
        if (c) goto _L4; else goto _L3
_L3:
        j = PushProtocol.RecvPush(b.v, b.w, 0x15180);
        String.format(z[1], new Object[] {
            Integer.valueOf(j)
        });
        x.c();
        if (j <= 0) goto _L6; else goto _L5
_L5:
        if (PushService.l())
        {
            cn.jpush.android.service.PushService.a(b);
        }
        b.e(j);
_L8:
        Thread.sleep(100L);
        i = j;
          goto _L7
        interruptedexception;
        x.h();
        i = j;
_L4:
        a = false;
        (new StringBuilder(z[13])).append(getId()).toString();
        x.b();
_L9:
        if (b.v != 0)
        {
            x.e();
            b.v = PushProtocol.Close(b.v);
        }
        b.f(i);
        return;
_L6:
        i = j;
        if (j != -994) goto _L4; else goto _L8
_L2:
        x.b(z[2], (new StringBuilder(z[11])).append(PushProtocol.GetEsg(b.v)).toString());
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_705;
        }
        b.f();
        i = j;
          goto _L9
        i = j;
        if (j >= 0) goto _L9; else goto _L10
_L10:
        cn.jpush.android.service.PushService.a(b, 0L);
        i = j;
          goto _L9
        x.b(z[2], (new StringBuilder(z[4])).append(getId()).toString());
          goto _L9
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[45];
        i = 0;
        obj1 = "i|.9\017\fq52\023Iq.5\022B2.4\017Is>\025\031\f/z";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int k;
        int l;
        int i1;
        byte byte2;
        int j1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        i1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac;
        j1 = i;
        as1 = ((String []) (obj));
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l = k;
_L9:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 1319
    //                   1 1326
    //                   2 1333
    //                   3 1340;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_1340;
_L3:
        byte0 = 125;
_L13:
label0:
        {
            obj1[k] = (char)(byte0 ^ i1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        i1 = l;
        l = j;
        as1 = as2;
        j1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = j1;
        as2 = as1;
        j = l;
        k = i1;
        if (l > i1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j1] = ((String) (obj));
            i = 1;
            obj1 = "~w9*@\tv";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "|g)4.I`,5\036I";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "e|3(@\tvP";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "`}=5\023\ft;5\021Ivv|\tD`?=\031evza]";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "`}=5\023\fa/?\036Iw>}]^w=5\016X`;(\024C|\023\030@";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            i = 6;
            obj1 = "e|3(][{.4]\0012";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j1] = ((String) (obj));
            i = 7;
            obj1 = "O`?=\tI2)3\036Gw.|\033M~39\031\fe3(\025\ff2.\030Mv\0238]\0212";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j1] = ((String) (obj));
            i = 8;
            obj1 = "O|t6\rYa2r\034Bv(3\024H<32\tI|.r>c\\\024\031>x[\025\022";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j1] = ((String) (obj));
            i = 9;
            obj1 = "\f\177\n3\017X2g|";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j1] = ((String) (obj));
            i = 10;
            obj1 = "\f2z|]\f\177\0223\016X(zqC\f";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j1] = ((String) (obj));
            i = 11;
            obj1 = "`}=5\023\ft;5\021Iv`|";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j1] = ((String) (obj));
            i = 12;
            obj1 = "h\\\tf]\001,z";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j1] = ((String) (obj));
            i = 13;
            obj1 = "ij3(]^w99\024Z{4;][z30\030\f~53\r\0002.4\017Is>\025\031\f/z";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j1] = ((String) (obj));
            i = 14;
            obj1 = "_}((\"Gw#|G\f";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[j1] = ((String) (obj));
            i = 15;
            obj1 = "@}=5\023ng<:\030^2g|";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[j1] = ((String) (obj));
            i = 16;
            obj1 = "\f?z";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[j1] = ((String) (obj));
            i = 17;
            obj1 = "^w.|@\f";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[j1] = ((String) (obj));
            i = 18;
            obj1 = "aVo";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[j1] = ((String) (obj));
            i = 19;
            obj1 = "`}=5\023\02627\025\031\f/zy\031\0002\n=\016_e5.\031\f\177>i]\0212\177/";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[j1] = ((String) (obj));
            i = 20;
            obj1 = "\f/z";
            byte0 = 19;
            obj = as;
            break;

        case 19: // '\023'
            as1[j1] = ((String) (obj));
            i = 21;
            obj1 = "\\s(/\030`w4|@\f";
            byte0 = 20;
            obj = as;
            break;

        case 20: // '\024'
            as1[j1] = ((String) (obj));
            i = 22;
            obj1 = "\035<mrL";
            byte0 = 21;
            obj = as;
            break;

        case 21: // '\025'
            as1[j1] = ((String) (obj));
            i = 23;
            obj1 = "@}=5\023\ft;5\021\f(z/\022^f\0057\030U2g|";
            byte0 = 22;
            obj = as;
            break;

        case 22: // '\026'
            as1[j1] = ((String) (obj));
            i = 24;
            obj1 = "\f2z?\022A\177;2\031\f/z";
            byte0 = 23;
            obj = as;
            break;

        case 23: // '\027'
            as1[j1] = ((String) (obj));
            i = 25;
            obj1 = "_{>|@\f";
            byte0 = 24;
            obj = as;
            break;

        case 24: // '\030'
            as1[j1] = ((String) (obj));
            i = 26;
            obj1 = "\f2z(\022Xs6\020\030B2g|";
            byte0 = 25;
            obj = as;
            break;

        case 25: // '\031'
            as1[j1] = ((String) (obj));
            i = 27;
            obj1 = "\f|5(]Ij3/\t_2`|\024Ba?.\t";
            byte0 = 26;
            obj = as;
            break;

        case 26: // '\032'
            as1[j1] = ((String) (obj));
            i = 28;
            obj1 = "@}=5\023\ft;5\021\f(z\020\022K{4a";
            byte0 = 27;
            obj = as;
            break;

        case 27: // '\033'
            as1[j1] = ((String) (obj));
            i = 29;
            obj1 = "\fq;2\023Cfz,\034^a?|\016I`,9\017x{79]";
            byte0 = 28;
            obj = as;
            break;

        case 28: // '\034'
            as1[j1] = ((String) (obj));
            i = 30;
            obj1 = "@}=5\023s`?,\022^f\005(\024Aw";
            byte0 = 29;
            obj = as;
            break;

        case 29: // '\035'
            as1[j1] = ((String) (obj));
            i = 31;
            obj1 = "\ff5(\022@^?2]\0212";
            byte0 = 30;
            obj = as;
            break;

        case 30: // '\036'
            as1[j1] = ((String) (obj));
            i = 32;
            obj1 = "@}=5\023\ft;5\021\f(z(\022X}6\020\030B2g|";
            byte0 = 31;
            obj = as;
            break;

        case 31: // '\037'
            as1[j1] = ((String) (obj));
            i = 33;
            obj1 = "p<";
            byte0 = 32;
            obj = as;
            break;

        case 32: // ' '
            as1[j1] = ((String) (obj));
            i = 34;
            obj1 = "_f(\027\030U2g|";
            byte0 = 33;
            obj = as;
            break;

        case 33: // '!'
            as1[j1] = ((String) (obj));
            i = 35;
            obj1 = "_d?.\016E}4|@\f";
            byte0 = 34;
            obj = as;
            break;

        case 34: // '"'
            as1[j1] = ((String) (obj));
            i = 36;
            obj1 = "_}((\"Gw#f";
            byte0 = 35;
            obj = as;
            break;

        case 35: // '#'
            as1[j1] = ((String) (obj));
            i = 37;
            obj1 = "@}=5\023sa?.\013I`\005(\024Aw";
            byte0 = 36;
            obj = as;
            break;

        case 36: // '$'
            as1[j1] = ((String) (obj));
            i = 38;
            obj1 = "\f2z|]\f2z|]\f~5;\024BM93\016X{79G\f";
            byte0 = 37;
            obj = as;
            break;

        case 37: // '%'
            as1[j1] = ((String) (obj));
            i = 39;
            obj1 = "\f{)|\030T{)(\016\f(z)\rHs.9";
            byte0 = 38;
            obj = as;
            break;

        case 38: // '&'
            as1[j1] = ((String) (obj));
            i = 40;
            obj1 = "\f2z|\017Ib5.\tx{79]\0212";
            byte0 = 39;
            obj = as;
            break;

        case 39: // '\''
            as1[j1] = ((String) (obj));
            i = 41;
            obj1 = "\t\"h\004";
            byte0 = 40;
            obj = as;
            break;

        case 40: // '('
            as1[j1] = ((String) (obj));
            i = 42;
            obj1 = "_w(*\030^F31\030\f/z";
            byte0 = 41;
            obj = as;
            break;

        case 41: // ')'
            as1[j1] = ((String) (obj));
            i = 43;
            obj1 = "_f31\030\f/z";
            byte0 = 42;
            obj = as;
            break;

        case 42: // '*'
            as1[j1] = ((String) (obj));
            i = 44;
            obj1 = "`}=5\023\0217>V";
            byte0 = 43;
            obj = as;
            break;

        case 43: // '+'
            as1[j1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 44;
          goto _L13
_L5:
        byte0 = 18;
          goto _L13
_L6:
        byte0 = 90;
          goto _L13
        byte0 = 92;
          goto _L13
    }
}
