// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Pair;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;

public final class apz
    implements apw
{

    private static final byte a[] = {
        0, 0, 0, 1
    };
    private static final byte b[] = {
        -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 
        108, 66, 124, 100, -115, -12
    };
    private static final int c[] = {
        2, 1, 2, 3, 3, 4, 4, 5
    };
    private static final int d[] = {
        32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 
        192, 224, 256, 320, 384, 448, 512, 576, 640
    };
    private static final Set e;
    private static final Set f;
    private final int g;
    private final ati h;
    private final byte i[];
    private final Stack j;
    private final aqc k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private ati q;
    private int r;
    private int s;
    private int t;
    private int u;
    private final HashMap v;
    private apx w;
    private arm x;
    private apy y;

    public apz()
    {
        this(0);
    }

    private apz(int i1)
    {
        g = 0;
        l = 0;
        h = new ati(8);
        i = new byte[16];
        j = new Stack();
        k = new aqc();
        v = new HashMap();
    }

    private int a(asn asn1, int i1, aoq aoq1)
    {
        ByteBuffer bytebuffer;
label0:
        {
            byte abyte0[];
            byte abyte2[];
            Object obj;
            int j1;
            boolean flag;
            boolean flag1;
label1:
            {
                if (aoq1 == null)
                {
                    return 32;
                }
                aoq1.e = k.b(s) * 1000L;
                aoq1.d = 0;
                if (k.f[s])
                {
                    aoq1.d = aoq1.d | 1;
                    u = s;
                }
                if (aoq1.b == null || aoq1.b.capacity() < i1)
                {
                    aoq1.a(i1);
                }
                if (!k.g)
                {
                    break label0;
                }
                obj = k.j;
                aqb aqb1 = x.d[k.a];
                abyte2 = aqb1.c;
                flag = aqb1.a;
                j1 = aqb1.b;
                flag1 = k.h[s];
                byte abyte1[] = aoq1.a.a;
                if (abyte1 != null)
                {
                    abyte0 = abyte1;
                    if (abyte1.length == 16)
                    {
                        break label1;
                    }
                }
                abyte0 = new byte[16];
            }
            int ai[];
            int ai1[];
label2:
            {
                ((ati) (obj)).a(abyte0, 0, j1);
                int l1;
                if (flag1)
                {
                    j1 = ((ati) (obj)).b();
                } else
                {
                    j1 = 1;
                }
                ai1 = aoq1.a.d;
                if (ai1 != null)
                {
                    ai = ai1;
                    if (ai1.length >= j1)
                    {
                        break label2;
                    }
                }
                ai = new int[j1];
            }
            ai1 = aoq1.a.e;
            if (ai1 == null || ai1.length < j1)
            {
                ai1 = new int[j1];
            }
            if (flag1)
            {
                for (l1 = 0; l1 < j1; l1++)
                {
                    ai[l1] = ((ati) (obj)).b();
                    ai1[l1] = ((ati) (obj)).f();
                }

            } else
            {
                ai[0] = 0;
                ai1[0] = k.c[s];
            }
            obj = aoq1.a;
            int i2;
            if (flag)
            {
                i2 = 1;
            } else
            {
                i2 = 0;
            }
            obj.f = j1;
            obj.d = ai;
            obj.e = ai1;
            obj.b = abyte2;
            obj.a = abyte0;
            obj.c = i2;
            if (atp.a >= 16)
            {
                ((anf) (obj)).g.set(((anf) (obj)).f, ((anf) (obj)).d, ((anf) (obj)).e, ((anf) (obj)).b, ((anf) (obj)).a, ((anf) (obj)).c);
            }
            if (flag)
            {
                aoq1.d = aoq1.d | 2;
            }
        }
        bytebuffer = aoq1.b;
        if (bytebuffer == null)
        {
            asn1.a(i1);
            aoq1.c = 0;
        } else
        {
            asn1.a(bytebuffer, i1);
            if (x.a == 0x76696465)
            {
                int l2 = bytebuffer.position() - i1;
                int k2;
                for (int k1 = l2; k1 < l2 + i1; k1 = k2 + 4 + k1)
                {
                    bytebuffer.position(k1);
                    k2 = bytebuffer.get() & 0xff;
                    for (int j2 = 1; j2 < 4; j2++)
                    {
                        k2 = k2 << 8 | bytebuffer.get() & 0xff;
                    }

                    if (k2 < 0)
                    {
                        throw new IllegalArgumentException((new StringBuilder(29)).append("Top bit not zero: ").append(k2).toString());
                    }
                    bytebuffer.position(k1);
                    bytebuffer.put(a);
                }

                bytebuffer.position(l2 + i1);
            }
            aoq1.c = i1;
        }
        s = s + 1;
        a(3);
        return 4;
    }

    private static Pair a(ati ati1)
    {
        int i1 = 8;
        ati1.a(8);
        int j1 = b(ati1.d());
        byte byte0;
        boolean flag1;
        int k1;
        int l1;
        if (j1 == 0)
        {
            byte0 = 8;
        } else
        {
            byte0 = 16;
        }
        ati1.b(byte0);
        k1 = ati1.d();
        ati1.b(4);
        flag1 = true;
        l1 = ati1.b;
        byte0 = i1;
        if (j1 == 0)
        {
            byte0 = 4;
        }
        i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < byte0)
                {
                    if (ati1.a[l1 + i1] == -1)
                    {
                        break label0;
                    }
                    flag = false;
                }
                long l2;
                if (flag)
                {
                    ati1.b(byte0);
                    l2 = -1L;
                } else
                if (j1 == 0)
                {
                    l2 = ati1.c();
                } else
                {
                    l2 = ati1.g();
                }
                return Pair.create(Integer.valueOf(k1), Long.valueOf(l2));
            }
            i1++;
        } while (true);
    }

    private static Pair a(ati ati1, int i1, int j1, int k1)
    {
        Object obj;
        Object obj1;
        int l1;
        int i2;
        int j2;
        int l2;
        int k3;
        ati1.a(j1 + 8);
        ati1.b(16);
        j2 = ati1.b();
        k3 = ati1.b();
        ati1.b(4);
        l1 = ati.b(ati1.a, ati1.b, 2);
        ati1.b = ati1.b + 4;
        i2 = -1;
        obj = null;
        obj1 = null;
        l2 = ati1.b;
_L5:
        if (l2 - j1 >= k1) goto _L2; else goto _L1
_L1:
        int k2;
        int i3;
        int l3;
        ati1.a(l2);
        k2 = ati1.b;
        l3 = ati1.d();
        i3 = ati1.d();
        if (i1 != 0x6d703461 && i1 != 0x656e6361) goto _L4; else goto _L3
_L3:
        Object obj2;
        if (i3 == 0x65736473)
        {
            ati1.a(k2 + 8 + 4);
            ati1.b(1);
            for (l1 = ati1.a(); l1 > 127; l1 = ati1.a()) { }
            ati1.b(2);
            l1 = ati1.a();
            if ((l1 & 0x80) != 0)
            {
                ati1.b(2);
            }
            if ((l1 & 0x40) != 0)
            {
                ati1.b(ati1.b());
            }
            if ((l1 & 0x20) != 0)
            {
                ati1.b(2);
            }
            ati1.b(1);
            for (l1 = ati1.a(); l1 > 127; l1 = ati1.a()) { }
            ati1.b(13);
            ati1.b(1);
            j2 = ati1.a();
            for (l1 = j2 & 0x7f; j2 > 127; l1 = l1 << 8 | j2 & 0x7f)
            {
                j2 = ati1.a();
            }

            byte abyte0[] = new byte[l1];
            ati1.a(abyte0, 0, l1);
            obj = atg.a(abyte0);
            l1 = ((Integer)((Pair) (obj)).first).intValue();
            j2 = ((Integer)((Pair) (obj)).second).intValue();
            obj = obj1;
            obj1 = abyte0;
        } else
        {
            if (i3 != 0x73696e66)
            {
                break MISSING_BLOCK_LABEL_717;
            }
            aqb aqb1 = a(ati1, k2, l3);
            obj1 = obj;
            obj = aqb1;
        }
_L10:
        l2 += l3;
        obj2 = obj;
        obj = obj1;
        obj1 = obj2;
          goto _L5
_L4:
        if (i1 != 0x61632d33 || i3 != 0x64616333)
        {
            break MISSING_BLOCK_LABEL_597;
        }
        ati1.a(k2 + 8);
        (ati1.a() & 0xc0) >> 6;
        JVM INSTR tableswitch 0 2: default 464
    //                   0 507
    //                   1 581
    //                   2 589;
           goto _L6 _L7 _L8 _L9
_L9:
        break MISSING_BLOCK_LABEL_589;
_L6:
        obj1 = null;
_L11:
        if (obj1 != null)
        {
            l1 = ((aqa) (obj1)).b;
            j2 = ((aqa) (obj1)).a;
            i2 = ((aqa) (obj1)).c;
        }
        Object obj3 = null;
        obj1 = obj;
        obj = obj3;
          goto _L10
_L7:
        k2 = 48000;
_L12:
        int i4 = ati1.a();
        int j3 = c[(i4 & 0x38) >> 3];
        i3 = j3;
        if ((i4 & 4) != 0)
        {
            i3 = j3 + 1;
        }
        obj1 = new aqa(i3, k2, d[((i4 & 3) << 3) + (ati1.a() >> 5)]);
          goto _L11
_L8:
        k2 = 44100;
          goto _L12
        k2 = 32000;
          goto _L12
        if (i1 != 0x65632d33 || i3 != 0x64656333)
        {
            break MISSING_BLOCK_LABEL_717;
        }
        ati1.a(k2 + 8);
        l1 = 0;
        Object obj4 = null;
        obj1 = obj;
        obj = obj4;
          goto _L10
_L2:
        if (i1 == 0x61632d33)
        {
            ati1 = "audio/ac3";
        } else
        if (i1 == 0x65632d33)
        {
            ati1 = "audio/eac3";
        } else
        {
            ati1 = "audio/mp4a-latm";
        }
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = Collections.singletonList(obj);
        }
        return Pair.create(new aon(ati1, k3, -1, -1, -1F, j2, l1, i2, ((List) (obj))), obj1);
        Object obj5 = obj;
        obj = obj1;
        obj1 = obj5;
          goto _L10
    }

    private static aqb a(ati ati1, int i1, int j1)
    {
        Object obj;
        int k1;
        k1 = i1 + 8;
        obj = null;
_L2:
        int l1;
        int i2;
        if (k1 - i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        ati1.a(k1);
        i2 = ati1.d();
        l1 = ati1.d();
        if (l1 != 0x66726d61)
        {
            break; /* Loop/switch isn't completed */
        }
        ati1.d();
_L5:
        k1 += i2;
        if (true) goto _L2; else goto _L1
_L1:
        if (l1 != 0x7363686d) goto _L4; else goto _L3
_L3:
        ati1.b(4);
        ati1.d();
        ati1.d();
          goto _L5
_L4:
        if (l1 != 0x73636869) goto _L5; else goto _L6
_L6:
        l1 = k1 + 8;
_L7:
        int j2;
label0:
        {
            if (l1 - k1 >= i2)
            {
                break MISSING_BLOCK_LABEL_202;
            }
            ati1.a(l1);
            j2 = ati1.d();
            if (ati1.d() != 0x74656e63)
            {
                break label0;
            }
            ati1.b(4);
            l1 = ati1.d();
            boolean flag;
            if (l1 >> 8 == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = new byte[16];
            ati1.a(((byte []) (obj)), 0, 16);
            obj = new aqb(flag, l1 & 0xff, ((byte []) (obj)));
        }
          goto _L5
        l1 += j2;
          goto _L7
        obj = null;
          goto _L5
        return ((aqb) (obj));
    }

    private void a(int i1)
    {
        i1;
        JVM INSTR tableswitch 0 0: default 20
    //                   0 26;
           goto _L1 _L2
_L1:
        l = i1;
        return;
_L2:
        m = 0;
        if (j.isEmpty())
        {
            n = 0;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void a(ark ark1)
    {
        Object obj = ark1.b;
        int j1 = ((List) (obj)).size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            Object obj1 = (arj)((List) (obj)).get(i1);
            if (((arj) (obj1)).a == 0x70737368)
            {
                obj1 = ((arl)obj1).b;
                ((ati) (obj1)).a(12);
                UUID uuid = new UUID(((ati) (obj1)).e(), ((ati) (obj1)).e());
                int k1 = ((ati) (obj1)).d();
                byte abyte0[] = new byte[k1];
                ((ati) (obj1)).a(abyte0, 0, k1);
                v.put(uuid, abyte0);
            }
        }

        obj = ark1.b(0x6d766578).a(0x74726578).b;
        ((ati) (obj)).a(16);
        y = new apy(((ati) (obj)).f() - 1, ((ati) (obj)).f(), ((ati) (obj)).f(), ((ati) (obj)).d());
        obj = ark1.b(0x7472616b);
        ark1 = ((ark) (obj)).b(0x6d646961);
        ati ati1 = ark1.a(0x68646c72).b;
        ati1.a(16);
        j1 = ati1.d();
        byte byte0;
        int l1;
        long l2;
        boolean flag;
        if (j1 == 0x736f756e || j1 == 0x76696465 || j1 == 0x74657874)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        l1 = ((Integer)a(((ark) (obj)).a(0x746b6864).b).first).intValue();
        obj = ark1.a(0x6d646864).b;
        ((ati) (obj)).a(8);
        if (b(((ati) (obj)).d()) == 0)
        {
            byte0 = 8;
        } else
        {
            byte0 = 16;
        }
        ((ati) (obj)).b(byte0);
        l2 = ((ati) (obj)).c();
        ark1 = b(ark1.b(0x6d696e66).b(0x7374626c).a(0x73747364).b);
        x = new arm(l1, j1, l2, (aon)((Pair) (ark1)).first, (aqb[])((Pair) (ark1)).second);
    }

    private static void a(ati ati1, int i1, aqc aqc1)
    {
        ati1.a(i1 + 8);
        i1 = ati1.d() & 0xffffff;
        if ((i1 & 1) != 0)
        {
            throw new IllegalStateException("Overriding TrackEncryptionBox parameters is unsupported");
        }
        boolean flag;
        if ((i1 & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i1 = ati1.f();
        if (i1 != aqc1.b)
        {
            int j1 = aqc1.b;
            throw new IllegalStateException((new StringBuilder(41)).append("Length mismatch: ").append(i1).append(", ").append(j1).toString());
        } else
        {
            Arrays.fill(aqc1.h, 0, i1, flag);
            aqc1.a(ati1.a.length - ati1.b);
            ati1.a(aqc1.j.a, 0, aqc1.i);
            aqc1.j.a(0);
            aqc1.k = false;
            return;
        }
    }

    private static int b(int i1)
    {
        return i1 >> 24 & 0xff;
    }

    private static Pair b(ati ati1)
    {
        ati1.a(12);
        int l1 = ati1.d();
        Object obj = null;
        aqb aaqb[] = new aqb[l1];
        int i1 = 0;
        while (i1 < l1) 
        {
            int i2 = ati1.b;
            int j2 = ati1.d();
            int j1 = ati1.d();
            if (j1 == 0x61766331 || j1 == 0x61766333 || j1 == 0x656e6376)
            {
                ati1.a(i2 + 8);
                ati1.b(24);
                int k2 = ati1.b();
                int l2 = ati1.b();
                float f1 = 1.0F;
                ati1.b(50);
                Object obj1 = null;
                obj = null;
                j1 = ati1.b;
                while (j1 - i2 < j2) 
                {
                    ati1.a(j1);
                    int k1 = ati1.b;
                    int i3 = ati1.d();
                    int j3 = ati1.d();
                    if (j3 == 0x61766343)
                    {
                        ati1.a(k1 + 8 + 4);
                        if ((ati1.a() & 3) + 1 != 4)
                        {
                            throw new IllegalStateException();
                        }
                        obj1 = new ArrayList();
                        j3 = ati1.a();
                        for (k1 = 0; k1 < (j3 & 0x1f); k1++)
                        {
                            ((List) (obj1)).add(c(ati1));
                        }

                        j3 = ati1.a();
                        for (k1 = 0; k1 < j3; k1++)
                        {
                            ((List) (obj1)).add(c(ati1));
                        }

                    } else
                    if (j3 == 0x73696e66)
                    {
                        obj = a(ati1, k1, i3);
                    } else
                    if (j3 == 0x70617370)
                    {
                        ati1.a(k1 + 8);
                        k1 = ati1.f();
                        int k3 = ati1.f();
                        f1 = (float)k1 / (float)k3;
                    }
                    j1 += i3;
                }
                obj1 = Pair.create(aon.a("video/avc", -1, k2, l2, f1, ((List) (obj1))), obj);
                obj = (aon)((Pair) (obj1)).first;
                aaqb[i1] = (aqb)((Pair) (obj1)).second;
            } else
            if (j1 == 0x6d703461 || j1 == 0x656e6361 || j1 == 0x61632d33)
            {
                Pair pair = a(ati1, j1, i2, j2);
                obj = (aon)pair.first;
                aaqb[i1] = (aqb)pair.second;
            } else
            if (j1 == 0x54544d4c)
            {
                obj = new aon("application/ttml+xml", -1, -1, -1, -1F, -1, -1, -1, null);
            }
            ati1.a(i2 + j2);
            i1++;
        }
        return Pair.create(obj, aaqb);
    }

    private void b(ark ark1)
    {
        aqc aqc1 = k;
        aqc1.b = 0;
        aqc1.g = false;
        aqc1.k = false;
        Object obj = x;
        Object obj2 = y;
        aqc1 = k;
        int l3 = g;
        byte abyte0[] = i;
        ark1 = ark1.b(0x74726166);
        Object obj3;
        int ai[];
        int ai1[];
        long al[];
        boolean aflag1[];
        int i1;
        int l1;
        int k2;
        int i3;
        boolean flag;
        boolean flag1;
        boolean flag2;
        int i4;
        int l4;
        long l5;
        long l6;
        if (ark1.a(0x74666474) == null)
        {
            l5 = 0L;
        } else
        {
            obj3 = ark1.a(0x74666474).b;
            ((ati) (obj3)).a(8);
            if (b(((ati) (obj3)).d()) == 1)
            {
                l5 = ((ati) (obj3)).g();
            } else
            {
                l5 = ((ati) (obj3)).c();
            }
        }
        obj3 = ark1.a(0x74666864).b;
        ((ati) (obj3)).a(8);
        i3 = 0xffffff & ((ati) (obj3)).d();
        ((ati) (obj3)).b(4);
        if ((i3 & 1) != 0)
        {
            ((ati) (obj3)).b(8);
        }
        if ((i3 & 2) != 0)
        {
            i1 = ((ati) (obj3)).f() - 1;
        } else
        {
            i1 = ((apy) (obj2)).a;
        }
        if ((i3 & 8) != 0)
        {
            l1 = ((ati) (obj3)).f();
        } else
        {
            l1 = ((apy) (obj2)).b;
        }
        if ((i3 & 0x10) != 0)
        {
            k2 = ((ati) (obj3)).f();
        } else
        {
            k2 = ((apy) (obj2)).c;
        }
        if ((i3 & 0x20) != 0)
        {
            i3 = ((ati) (obj3)).f();
        } else
        {
            i3 = ((apy) (obj2)).d;
        }
        obj2 = new apy(i1, l1, k2, i3);
        aqc1.a = ((apy) (obj2)).a;
        obj3 = ark1.a(0x7472756e).b;
        ((ati) (obj3)).a(8);
        l1 = 0xffffff & ((ati) (obj3)).d();
        l4 = ((ati) (obj3)).f();
        if ((l1 & 1) != 0)
        {
            ((ati) (obj3)).b(4);
        }
        if ((l1 & 4) != 0)
        {
            k2 = 1;
        } else
        {
            k2 = 0;
        }
        i1 = ((apy) (obj2)).d;
        if (k2 != 0)
        {
            i1 = ((ati) (obj3)).f();
        }
        if ((l1 & 0x100) != 0)
        {
            i3 = 1;
        } else
        {
            i3 = 0;
        }
        if ((l1 & 0x200) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((l1 & 0x400) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if ((l1 & 0x800) != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        aqc1.b = l4;
        if (aqc1.c == null || aqc1.c.length < aqc1.b)
        {
            l1 = (l4 * 125) / 100;
            aqc1.c = new int[l1];
            aqc1.d = new int[l1];
            aqc1.e = new long[l1];
            aqc1.f = new boolean[l1];
            aqc1.h = new boolean[l1];
        }
        ai = aqc1.c;
        ai1 = aqc1.d;
        al = aqc1.e;
        aflag1 = aqc1.f;
        l6 = ((arm) (obj)).b;
        if (((arm) (obj)).a == 0x76696465 && (l3 & 1) == 1)
        {
            l3 = 1;
        } else
        {
            l3 = 0;
        }
        i4 = 0;
        while (i4 < l4) 
        {
            int j4;
            int k4;
            boolean flag3;
            if (i3 != 0)
            {
                j4 = ((ati) (obj3)).f();
            } else
            {
                j4 = ((apy) (obj2)).b;
            }
            if (flag)
            {
                k4 = ((ati) (obj3)).f();
            } else
            {
                k4 = ((apy) (obj2)).c;
            }
            if (i4 == 0 && k2 != 0)
            {
                l1 = i1;
            } else
            if (flag1)
            {
                l1 = ((ati) (obj3)).d();
            } else
            {
                l1 = ((apy) (obj2)).d;
            }
            if (flag2)
            {
                ai1[i4] = (int)((long)(((ati) (obj3)).d() * 1000) / l6);
            } else
            {
                ai1[i4] = 0;
            }
            al[i4] = (1000L * l5) / l6;
            ai[i4] = k4;
            if ((l1 >> 16 & 1) == 0 && (!l3 || i4 == 0))
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            aflag1[i4] = flag3;
            l5 += j4;
            i4++;
        }
        obj3 = ark1.a(0x7361697a);
        if (obj3 != null)
        {
            obj = ((arm) (obj)).d[((apy) (obj2)).a];
            obj2 = ((arl) (obj3)).b;
            int k3 = ((aqb) (obj)).b;
            ((ati) (obj2)).a(8);
            if ((((ati) (obj2)).d() & 0xffffff & 1) == 1)
            {
                ((ati) (obj2)).b(8);
            }
            int j1 = ((ati) (obj2)).a();
            int j3 = ((ati) (obj2)).f();
            if (j3 != aqc1.b)
            {
                j1 = aqc1.b;
                throw new IllegalStateException((new StringBuilder(41)).append("Length mismatch: ").append(j3).append(", ").append(j1).toString());
            }
            int l2;
            if (j1 == 0)
            {
                boolean aflag[] = aqc1.h;
                j1 = 0;
                int i2 = 0;
                do
                {
                    l2 = j1;
                    if (i2 >= j3)
                    {
                        break;
                    }
                    l2 = ((ati) (obj2)).a();
                    boolean flag4;
                    if (l2 > k3)
                    {
                        flag4 = true;
                    } else
                    {
                        flag4 = false;
                    }
                    aflag[i2] = flag4;
                    i2++;
                    j1 += l2;
                } while (true);
            } else
            {
                Object obj1;
                int j2;
                boolean flag5;
                if (j1 > k3)
                {
                    flag5 = true;
                } else
                {
                    flag5 = false;
                }
                Arrays.fill(aqc1.h, 0, j3, flag5);
                l2 = j1 * j3 + 0;
            }
            aqc1.a(l2);
        }
        obj1 = ark1.a(0x73656e63);
        if (obj1 != null)
        {
            a(((arl) (obj1)).b, 0, aqc1);
        }
        j2 = ark1.b.size();
        for (j1 = 0; j1 < j2; j1++)
        {
            obj1 = (arj)ark1.b.get(j1);
            if (((arj) (obj1)).a != 0x75756964)
            {
                continue;
            }
            obj1 = ((arl)obj1).b;
            ((ati) (obj1)).a(8);
            ((ati) (obj1)).a(abyte0, 0, 16);
            if (Arrays.equals(abyte0, b))
            {
                a(((ati) (obj1)), 16, aqc1);
            }
        }

        s = 0;
        u = 0;
        t = 0;
        if (r != 0)
        {
            for (int k1 = 0; k1 < k.b; k1++)
            {
                if (k.f[k1] && k.b(k1) <= (long)r)
                {
                    t = k1;
                }
            }

            r = 0;
        }
    }

    private static byte[] c(ati ati1)
    {
        int i1 = ati1.b();
        int j1 = ati1.b;
        ati1.b(i1);
        return atg.a(ati1.a, j1, i1);
    }

    public final int a(asn asn1, aoq aoq1)
    {
        int i1 = 0;
_L67:
        if ((i1 & 0x27) != 0) goto _L2; else goto _L1
_L1:
        l;
        JVM INSTR tableswitch 0 2: default 1131
    //                   0 65
    //                   1 345
    //                   2 891;
           goto _L3 _L4 _L5 _L6
_L3:
        if (s < k.b) goto _L8; else goto _L7
_L7:
        a(0);
        int j1 = 0;
          goto _L9
_L4:
        try
        {
            j1 = m;
            j1 = asn1.a(h.a, m, 8 - j1);
        }
        // Misplaced declaration of an exception variable
        catch (asn asn1)
        {
            throw new aop(asn1);
        }
        if (j1 != -1) goto _L11; else goto _L10
_L10:
        j1 = 2;
          goto _L12
_L11:
        n = n + j1;
        m = j1 + m;
        if (m == 8) goto _L14; else goto _L13
_L13:
        j1 = 1;
          goto _L12
_L14:
        h.a(0);
        p = h.d();
        o = h.d();
        if (o != 0x6d646174) goto _L16; else goto _L15
_L15:
        if (!k.k) goto _L18; else goto _L17
_L17:
        a(2);
          goto _L19
_L18:
        a(3);
          goto _L19
_L16:
        Object obj = Integer.valueOf(o);
        if (!e.contains(obj)) goto _L21; else goto _L20
_L20:
        if (!f.contains(obj)) goto _L23; else goto _L22
_L22:
        a(0);
        j.add(new ark(o, (n + p) - 8));
          goto _L24
_L23:
        q = new ati(p);
        System.arraycopy(h.a, 0, q.a, 0, 8);
        a(1);
          goto _L24
_L21:
        q = null;
        a(1);
          goto _L24
_L5:
        if (q == null) goto _L26; else goto _L25
_L25:
        j1 = asn1.a(q.a, m, p - m);
          goto _L27
_L26:
        j1 = asn1.a(p - m);
          goto _L27
_L69:
        n = n + j1;
        m = j1 + m;
        if (m == p) goto _L29; else goto _L28
_L28:
        j1 = 1;
          goto _L30
_L29:
        j1 = 0;
        if (q == null) goto _L32; else goto _L31
_L31:
        obj = new arl(o, q);
        if (j.isEmpty()) goto _L34; else goto _L33
_L33:
        ((ark)j.peek()).a(((arj) (obj)));
          goto _L35
_L32:
        if (j.isEmpty() || ((ark)j.peek()).c != n) goto _L37; else goto _L36
_L36:
        obj = (ark)j.pop();
        if (((ark) (obj)).a != 0x6d6f6f76) goto _L39; else goto _L38
_L38:
        a(((ark) (obj)));
        int k1 = 8;
          goto _L40
_L34:
        if (((arl) (obj)).a != 0x73696478) goto _L35; else goto _L41
_L41:
        long l6;
        obj = ((arl) (obj)).b;
        ((ati) (obj)).a(8);
        j1 = b(((ati) (obj)).d());
        ((ati) (obj)).b(4);
        l6 = ((ati) (obj)).c();
        if (j1 != 0) goto _L43; else goto _L42
_L42:
        long l2;
        long l3;
        l2 = ((ati) (obj)).c();
        l3 = ((ati) (obj)).c();
_L48:
        int ai[];
        long al[];
        long al1[];
        long al2[];
        long l5;
        ((ati) (obj)).b(2);
        k1 = ((ati) (obj)).b();
        ai = new int[k1];
        al = new long[k1];
        al1 = new long[k1];
        al2 = new long[k1];
        l5 = atp.a(l2, 0xf4240L, l6);
        long l4;
        j1 = 0;
        l4 = l2;
        l2 = l3;
        l3 = l5;
_L49:
        if (j1 >= k1) goto _L45; else goto _L44
_L44:
        int l1 = ((ati) (obj)).d();
        if ((0x80000000 & l1) == 0) goto _L47; else goto _L46
_L46:
        throw new IllegalStateException("Unhandled indirect reference");
_L43:
        l2 = ((ati) (obj)).g();
        l3 = ((ati) (obj)).g();
          goto _L48
_L47:
        l5 = ((ati) (obj)).c();
        ai[j1] = l1 & 0x7fffffff;
        al[j1] = l2;
        al2[j1] = l3;
        l4 += l5;
        l3 = atp.a(l4, 0xf4240L, l6);
        al1[j1] = l3 - al2[j1];
        ((ati) (obj)).b(4);
        l2 += ai[j1];
        j1++;
          goto _L49
_L45:
        w = new apx(((ati) (obj)).a.length, ai, al, al1, al2);
        j1 = 16;
          goto _L50
_L39:
        if (((ark) (obj)).a != 0x6d6f6f66) goto _L52; else goto _L51
_L51:
        b(((ark) (obj)));
          goto _L53
_L52:
        if (!j.isEmpty())
        {
            ((ark)j.peek()).a(((arj) (obj)));
        }
          goto _L53
_L37:
        a(0);
          goto _L30
_L6:
        obj = k;
        if (asn1.a() >= (long)((aqc) (obj)).i) goto _L55; else goto _L54
_L54:
        j1 = 0;
          goto _L56
_L55:
        asn1.a(((aqc) (obj)).j.a, 0, ((aqc) (obj)).i);
        ((aqc) (obj)).j.a(0);
        obj.k = false;
        j1 = 1;
          goto _L56
_L71:
        a(3);
        j1 = 0;
          goto _L57
_L8:
        k1 = k.c[s];
        if (asn1.a() >= (long)k1) goto _L59; else goto _L58
_L58:
        j1 = 1;
          goto _L9
_L59:
        if (s >= t) goto _L61; else goto _L60
_L60:
        if (!k.g) goto _L63; else goto _L62
_L62:
        boolean flag;
        obj = k.j;
        j1 = x.d[k.a].b;
        flag = k.h[s];
        ((ati) (obj)).b(j1);
        if (!flag) goto _L65; else goto _L64
_L64:
        j1 = ((ati) (obj)).b();
_L72:
        if (!flag) goto _L63; else goto _L66
_L66:
        ((ati) (obj)).b(j1 * 6);
_L63:
        asn1.a(k1);
        s = s + 1;
        a(3);
        j1 = 0;
          goto _L9
_L61:
        j1 = a(asn1, k1, aoq1);
          goto _L9
_L2:
        return i1;
_L9:
        i1 = j1 | i1;
          goto _L67
_L12:
        i1 = j1 | i1;
          goto _L67
_L19:
        j1 = 0;
          goto _L12
_L24:
        j1 = 0;
          goto _L12
_L27:
        if (j1 != -1) goto _L69; else goto _L68
_L68:
        j1 = 2;
_L30:
        i1 = j1 | i1;
          goto _L67
_L35:
        j1 = 0;
_L50:
        j1 |= 0;
          goto _L32
_L40:
        j1 |= k1;
          goto _L32
_L53:
        k1 = 0;
          goto _L40
_L56:
        if (j1 != 0) goto _L71; else goto _L70
_L70:
        j1 = 1;
_L57:
        i1 = j1 | i1;
          goto _L67
_L65:
        j1 = 1;
          goto _L72
    }

    public final apx a()
    {
        return w;
    }

    public final boolean a(long l1, boolean flag)
    {
        r = (int)(l1 / 1000L);
        if (flag)
        {
            aqc aqc1 = k;
            if (k.b > 0 && (long)r >= k.b(0) && (long)r <= k.b(k.b - 1))
            {
                int i1 = 0;
                int j1 = 0;
                int k1 = 0;
                while (i1 < k.b) 
                {
                    int i2 = j1;
                    if (k.b(i1) <= (long)r)
                    {
                        if (k.f[i1])
                        {
                            j1 = i1;
                        }
                        k1 = i1;
                        i2 = j1;
                    }
                    i1++;
                    j1 = i2;
                }
                if (j1 == u && k1 >= s)
                {
                    r = 0;
                    return false;
                }
            }
        }
        j.clear();
        a(0);
        return true;
    }

    public final boolean b()
    {
        return true;
    }

    public final aon c()
    {
        if (x == null)
        {
            return null;
        } else
        {
            return x.c;
        }
    }

    public final Map d()
    {
        if (v.isEmpty())
        {
            return null;
        } else
        {
            return v;
        }
    }

    static 
    {
        HashSet hashset = new HashSet();
        hashset.add(Integer.valueOf(0x61766331));
        hashset.add(Integer.valueOf(0x61766333));
        hashset.add(Integer.valueOf(0x65736473));
        hashset.add(Integer.valueOf(0x68646c72));
        hashset.add(Integer.valueOf(0x6d646174));
        hashset.add(Integer.valueOf(0x6d646864));
        hashset.add(Integer.valueOf(0x6d6f6f66));
        hashset.add(Integer.valueOf(0x6d6f6f76));
        hashset.add(Integer.valueOf(0x6d703461));
        hashset.add(Integer.valueOf(0x73696478));
        hashset.add(Integer.valueOf(0x73747364));
        hashset.add(Integer.valueOf(0x74666474));
        hashset.add(Integer.valueOf(0x74666864));
        hashset.add(Integer.valueOf(0x746b6864));
        hashset.add(Integer.valueOf(0x74726166));
        hashset.add(Integer.valueOf(0x7472616b));
        hashset.add(Integer.valueOf(0x74726578));
        hashset.add(Integer.valueOf(0x7472756e));
        hashset.add(Integer.valueOf(0x6d766578));
        hashset.add(Integer.valueOf(0x6d646961));
        hashset.add(Integer.valueOf(0x6d696e66));
        hashset.add(Integer.valueOf(0x7374626c));
        hashset.add(Integer.valueOf(0x70737368));
        hashset.add(Integer.valueOf(0x7361697a));
        hashset.add(Integer.valueOf(0x75756964));
        hashset.add(Integer.valueOf(0x73656e63));
        hashset.add(Integer.valueOf(0x70617370));
        e = Collections.unmodifiableSet(hashset);
        hashset = new HashSet();
        hashset.add(Integer.valueOf(0x6d6f6f76));
        hashset.add(Integer.valueOf(0x7472616b));
        hashset.add(Integer.valueOf(0x6d646961));
        hashset.add(Integer.valueOf(0x6d696e66));
        hashset.add(Integer.valueOf(0x7374626c));
        hashset.add(Integer.valueOf(0x61766343));
        hashset.add(Integer.valueOf(0x6d6f6f66));
        hashset.add(Integer.valueOf(0x74726166));
        hashset.add(Integer.valueOf(0x6d766578));
        f = Collections.unmodifiableSet(hashset);
    }
}
