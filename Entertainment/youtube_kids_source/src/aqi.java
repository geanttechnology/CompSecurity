// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.nio.ByteBuffer;
import java.util.ArrayList;

final class aqi
    implements aqf
{

    private aqh a;

    aqi(aqh aqh1)
    {
        a = aqh1;
        super();
    }

    public final int a(int i)
    {
        aqh aqh1 = a;
        switch (i)
        {
        default:
            return 0;

        case 160: 
        case 174: 
        case 183: 
        case 187: 
        case 224: 
        case 225: 
        case 357149030: 
        case 374648427: 
        case 408125543: 
        case 440786851: 
        case 475249515: 
        case 524531317: 
            return 1;

        case 159: 
        case 176: 
        case 179: 
        case 186: 
        case 231: 
        case 241: 
        case 17029: 
        case 17143: 
        case 22186: 
        case 22203: 
        case 2807729: 
            return 2;

        case 134: 
        case 17026: 
            return 3;

        case 161: 
        case 163: 
        case 25506: 
            return 4;

        case 181: 
        case 17545: 
            return 5;
        }
    }

    public final void a(int i, double d)
    {
        aqh aqh1 = a;
        switch (i)
        {
        default:
            return;

        case 17545: 
            aqh1.h = aqh1.a((long)d);
            return;

        case 181: 
            aqh1.l = (int)d;
            return;
        }
    }

    public final void a(int i, long l)
    {
        aqh aqh1 = a;
        i;
        JVM INSTR lookupswitch 11: default 104
    //                   159: 230
    //                   176: 200
    //                   179: 238
    //                   186: 208
    //                   231: 263
    //                   241: 253
    //                   17029: 145
    //                   17143: 105
    //                   22186: 216
    //                   22203: 223
    //                   2807729: 193;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L3:
        break MISSING_BLOCK_LABEL_200;
_L5:
        break MISSING_BLOCK_LABEL_208;
_L10:
        break MISSING_BLOCK_LABEL_216;
_L11:
        break MISSING_BLOCK_LABEL_223;
_L2:
        break MISSING_BLOCK_LABEL_230;
_L4:
        break MISSING_BLOCK_LABEL_238;
_L7:
        break MISSING_BLOCK_LABEL_253;
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_263;
_L13:
        return;
_L9:
        if (l != 1L)
        {
            throw new aop((new StringBuilder(50)).append("EBMLReadVersion ").append(l).append(" not supported").toString());
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (l < 1L || l > 2L)
        {
            throw new aop((new StringBuilder(53)).append("DocTypeReadVersion ").append(l).append(" not supported").toString());
        }
        if (true) goto _L13; else goto _L12
_L12:
        aqh1.g = l;
        return;
        aqh1.i = (int)l;
        return;
        aqh1.j = (int)l;
        return;
        aqh1.o = l;
        return;
        aqh1.p = l;
        return;
        aqh1.k = (int)l;
        return;
        aqh1.w.a(aqh1.a(l));
        return;
        aqh1.x.a(l);
        return;
        aqh1.s = aqh1.a(l);
        return;
    }

    public final void a(int i, long l, int j, long l1)
    {
        aqh aqh1 = a;
        switch (i)
        {
        default:
            return;

        case 408125543: 
            if (aqh1.e != -1L || aqh1.f != -1L)
            {
                throw new aop("Multiple Segment elements not supported");
            } else
            {
                aqh1.e = (long)j + l;
                aqh1.f = (long)j + l + l1;
                return;
            }

        case 475249515: 
            aqh1.r = (long)j + l1;
            aqh1.w = new ath();
            aqh1.x = new ath();
            return;
        }
    }

    public final void a(int i, String s)
    {
        aqh aqh1 = a;
        i;
        JVM INSTR lookupswitch 2: default 32
    //                   134: 84
    //                   17026: 33;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        if (!"webm".equals(s))
        {
            throw new aop((new StringBuilder(String.valueOf(s).length() + 22)).append("DocType ").append(s).append(" not supported").toString());
        }
          goto _L1
_L2:
        if ("V_VP9".equals(s) || "A_OPUS".equals(s) || "A_VORBIS".equals(s))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            throw new aop((new StringBuilder(String.valueOf(s).length() + 22)).append("CodecID ").append(s).append(" not supported").toString());
        } else
        {
            aqh1.n = s;
            return;
        }
    }

    public final boolean a(int i, long l, int j, int k, asn asn)
    {
        aqh aqh1 = a;
        i;
        JVM INSTR lookupswitch 3: default 40
    //                   161: 42
    //                   163: 42
    //                   25506: 490;
           goto _L1 _L2 _L2 _L3
_L1:
        return true;
_L2:
        if (aqh1.c == null)
        {
            aqh1.d = aqh1.d | 0x20;
            return false;
        }
        aqh1.a.b(asn);
        aqh1.a.a(asn, aqh1.b, 3);
        long l1 = aqh1.a(aqh1.b[0] << 8 | aqh1.b[1] & 0xff);
        int i1;
        boolean flag;
        if (i == 161)
        {
            i = 1;
        } else
        if ((aqh1.b[2] & 0x80) == 128)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if ((aqh1.b[2] & 8) == 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i1 = (aqh1.b[2] & 6) >> 1;
        long l2;
        switch (i1)
        {
        default:
            throw new aop((new StringBuilder(37)).append("Lacing mode ").append(i1).append(" not supported").toString());

        case 0: // '\0'
            l2 = j;
            break;
        }
        long l3 = k;
        aqh1.t = aqh1.s + l1;
        Object obj = aqh1.c;
        if (i != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        obj.d = i;
        aqh1.c.f = flag;
        aqh1.c.e = l1 + aqh1.s;
        aqh1.c.c = (int)((l2 + l + l3) - aqh1.a.a());
        if (aqh1.c.b == null || aqh1.c.b.capacity() < aqh1.c.c)
        {
            aqh1.c.a(aqh1.c.c);
        }
        obj = aqh1.c.b;
        if (obj == null)
        {
            aqh1.a.a(asn, aqh1.c.c);
            aqh1.c.c = 0;
        } else
        {
            aqh1.a.a(asn, ((ByteBuffer) (obj)), aqh1.c.c);
        }
        aqh1.d = aqh1.d | 4;
        continue; /* Loop/switch isn't completed */
_L3:
        aqh1.m = new byte[k];
        aqh1.a.a(asn, aqh1.m, k);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void b(int i)
    {
        aqh aqh1;
        boolean flag;
        flag = false;
        aqh1 = a;
        i;
        JVM INSTR lookupswitch 4: default 52
    //                   174: 490
    //                   224: 384
    //                   225: 484
    //                   475249515: 53;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L5:
        if (aqh1.e == -1L)
        {
            throw new aop("Segment start/end offsets unknown");
        }
        if (aqh1.h == -1L)
        {
            throw new aop("Duration unknown");
        }
        if (aqh1.r == -1L)
        {
            throw new aop("Cues size unknown");
        }
        if (aqh1.w == null || aqh1.x == null || aqh1.w.a == 0 || aqh1.w.a != aqh1.x.a)
        {
            throw new aop("Invalid/missing cue points");
        }
        int k = aqh1.w.a;
        int ai[] = new int[k];
        long al[] = new long[k];
        long al1[] = new long[k];
        long al2[] = new long[k];
        i = 0;
        int j;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= k)
            {
                break;
            }
            al2[i] = aqh1.w.a(i);
            al[i] = aqh1.e + aqh1.x.a(i);
            i++;
        } while (true);
        for (; j < k - 1; j++)
        {
            ai[j] = (int)(al[j + 1] - al[j]);
            al1[j] = al2[j + 1] - al2[j];
        }

        ai[k - 1] = (int)(aqh1.f - al[k - 1]);
        al1[k - 1] = aqh1.h - al2[k - 1];
        aqh1.v = new apx((int)aqh1.r, ai, al, al1, al2);
        aqh1.w = null;
        aqh1.x = null;
        aqh1.d = aqh1.d | 0x10;
        return;
_L3:
        if (aqh1.i != -1 && aqh1.j != -1 && (aqh1.u == null || aqh1.u.c != aqh1.i || aqh1.u.d != aqh1.j))
        {
            aqh1.u = aon.a("video/x-vnd.on2.vp9", -1, aqh1.i, aqh1.j, 1.0F, null);
            aqh1.d = aqh1.d | 8;
            return;
        }
        if (aqh1.u == null)
        {
            throw new aop("Unable to build format");
        }
          goto _L1
_L4:
        aqh1.q = true;
        return;
_L2:
        if (!aqh1.q) goto _L1; else goto _L6
_L6:
        if (aqh1.k == -1 || aqh1.l == -1 || aqh1.u != null && aqh1.u.f == aqh1.k && aqh1.u.g == aqh1.l)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!"A_VORBIS".equals(aqh1.n)) goto _L8; else goto _L7
_L7:
        aqh1.u = aon.a("audio/vorbis", 8192, aqh1.k, aqh1.l, aqh1.e());
_L10:
        aqh1.d = aqh1.d | 8;
        return;
_L8:
        if ("A_OPUS".equals(aqh1.n))
        {
            ArrayList arraylist = new ArrayList(3);
            arraylist.add(aqh1.m);
            arraylist.add(ByteBuffer.allocate(64).putLong(aqh1.o).array());
            arraylist.add(ByteBuffer.allocate(64).putLong(aqh1.p).array());
            aqh1.u = aon.a("audio/opus", 5760, aqh1.k, aqh1.l, arraylist);
        }
        if (true) goto _L10; else goto _L9
_L9:
        if (aqh1.u != null) goto _L1; else goto _L11
_L11:
        throw new aop("Unable to build format");
    }
}
