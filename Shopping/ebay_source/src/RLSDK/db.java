// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            aa, ah, v, p, 
//            ao, ar

public final class db
{

    private static final int a[] = {
        8, 1, 1, 1, 1, 1, 1, 3
    };
    private static final int b[] = {
        3, 1, 1, 1, 1, 1, 1, 8
    };
    private static final int c[] = {
        7, 1, 1, 3, 1, 1, 1, 2, 1
    };
    private static final int d[] = {
        1, 2, 1, 1, 1, 3, 1, 1, 7
    };
    private final p e;

    public db(p p1)
    {
        e = p1;
    }

    private static void a(aa aaa[], boolean flag)
    {
        float f;
        float f2 = aaa[4].b() - aaa[6].b();
        f = f2;
        if (flag)
        {
            f = -f2;
        }
        if (f <= 2.0F) goto _L2; else goto _L1
_L1:
        f = aaa[4].a();
        float f3 = aaa[0].a();
        float f8 = aaa[6].a();
        float f12 = aaa[0].a();
        f = ((f - f3) * (aaa[6].b() - aaa[0].b())) / (f8 - f12);
        aaa[4] = new aa(aaa[4].a(), f + aaa[4].b());
_L8:
        float f4 = aaa[7].b() - aaa[5].b();
        f = f4;
        if (flag)
        {
            f = -f4;
        }
        if (f <= 2.0F) goto _L4; else goto _L3
_L3:
        f = aaa[5].a();
        float f5 = aaa[1].a();
        float f9 = aaa[7].a();
        float f13 = aaa[1].a();
        f = ((f - f5) * (aaa[7].b() - aaa[1].b())) / (f9 - f13);
        aaa[5] = new aa(aaa[5].a(), f + aaa[5].b());
_L6:
        return;
_L2:
        if (-f > 2.0F)
        {
            f = aaa[2].a();
            float f6 = aaa[6].a();
            float f10 = aaa[2].a();
            float f14 = aaa[4].a();
            f = ((f - f6) * (aaa[2].b() - aaa[4].b())) / (f10 - f14);
            aaa[6] = new aa(aaa[6].a(), aaa[6].b() - f);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (-f <= 2.0F) goto _L6; else goto _L5
_L5:
        float f1 = aaa[3].a();
        float f7 = aaa[7].a();
        float f11 = aaa[3].a();
        float f15 = aaa[5].a();
        f1 = ((f1 - f7) * (aaa[3].b() - aaa[5].b())) / (f11 - f15);
        aaa[7] = new aa(aaa[7].a(), aaa[7].b() - f1);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static int[] a(ah ah1, int i, int j, int k, boolean flag, int ai[])
    {
        int ai1[];
        int l;
        int j1;
        int k1;
        int i3;
        i3 = ai.length;
        ai1 = new int[i3];
        k1 = 0;
        j1 = i;
        l = i;
_L2:
        int i1;
        if (j1 >= i + k)
        {
            break MISSING_BLOCK_LABEL_394;
        }
        if (!(ah1.a(j1, j) ^ flag))
        {
            break; /* Loop/switch isn't completed */
        }
        ai1[k1] = ai1[k1] + 1;
        i1 = l;
_L7:
        j1++;
        l = i1;
        if (true) goto _L2; else goto _L1
_L1:
        int j2;
        int j3;
        if (k1 != i3 - 1)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        j3 = ai1.length;
        j2 = 0;
        int l1 = 0;
        int k2;
        for (i1 = 0; l1 < j3; i1 = k2 + i1)
        {
            k2 = ai1[l1];
            j2 += ai[l1];
            l1++;
        }

        if (i1 >= j2) goto _L4; else goto _L3
_L3:
        i1 = 0x7fffffff;
_L6:
        if (i1 < 107)
        {
            return (new int[] {
                l, j1
            });
        }
        break; /* Loop/switch isn't completed */
_L4:
        int k3 = (i1 << 8) / j2;
        j2 = 0;
        int i2 = 0;
        do
        {
            if (i2 >= j3)
            {
                break;
            }
            int l2 = ai1[i2] << 8;
            int l3 = ai[i2] * k3;
            if (l2 > l3)
            {
                l2 -= l3;
            } else
            {
                l2 = l3 - l2;
            }
            if (l2 > k3 * 204 >> 8)
            {
                i1 = 0x7fffffff;
                continue; /* Loop/switch isn't completed */
            }
            j2 += l2;
            i2++;
        } while (true);
        i1 = j2 / i1;
        if (true) goto _L6; else goto _L5
_L5:
        i1 = l + (ai1[0] + ai1[1]);
        for (l = 2; l < i3; l++)
        {
            ai1[l - 2] = ai1[l];
        }

        ai1[i3 - 2] = 0;
        ai1[i3 - 1] = 0;
        l = k1 - 1;
_L8:
        ai1[l] = 1;
        if (!flag)
        {
            flag = true;
            k1 = l;
        } else
        {
            flag = false;
            k1 = l;
        }
          goto _L7
        k1++;
        i1 = l;
        l = k1;
          goto _L8
        return null;
    }

    public final ao a()
        throws v
    {
        Object aobj1[];
        ah ah1;
        int i;
        int k;
        int l;
        ah1 = e.c();
        l = ah1.b;
        k = ah1.a;
        aobj1 = new aa[8];
        i = 0;
_L46:
        Object aobj[];
        if (i >= l)
        {
            break MISSING_BLOCK_LABEL_1071;
        }
        aobj = a(ah1, 0, i, k, false, a);
        if (aobj == null) goto _L2; else goto _L1
_L1:
        int j;
        aobj1[0] = new aa(aobj[0], i);
        aobj1[4] = new aa(aobj[1], i);
        j = 1;
_L56:
        i = j;
        if (j == 0) goto _L4; else goto _L3
_L3:
        i = l - 1;
_L47:
        if (i <= 0) goto _L6; else goto _L5
_L5:
        aobj = a(ah1, 0, i, k, false, a);
        if (aobj == null) goto _L8; else goto _L7
_L7:
        aobj1[1] = new aa(aobj[0], i);
        aobj1[5] = new aa(aobj[1], i);
        i = 1;
_L4:
        j = i;
        if (i == 0) goto _L10; else goto _L9
_L9:
        i = 0;
_L48:
        if (i >= l) goto _L12; else goto _L11
_L11:
        aobj = a(ah1, 0, i, k, false, c);
        if (aobj == null) goto _L14; else goto _L13
_L13:
        aobj1[2] = new aa(aobj[1], i);
        aobj1[6] = new aa(aobj[0], i);
        j = 1;
_L10:
        i = j;
        if (j == 0) goto _L16; else goto _L15
_L15:
        i = l - 1;
_L49:
        if (i <= 0) goto _L18; else goto _L17
_L17:
        aobj = a(ah1, 0, i, k, false, c);
        if (aobj == null) goto _L20; else goto _L19
_L19:
        aobj1[3] = new aa(aobj[1], i);
        aobj1[7] = new aa(aobj[0], i);
        i = 1;
_L16:
        if (i == 0)
        {
            aobj1 = null;
        }
        if (aobj1 != null) goto _L22; else goto _L21
_L21:
        k = ah1.b;
        l = ah1.a >> 1;
        aobj = new aa[8];
        i = k - 1;
_L50:
        if (i <= 0) goto _L24; else goto _L23
_L23:
        aobj1 = a(ah1, l, i, l, true, b);
        if (aobj1 == null) goto _L26; else goto _L25
_L25:
        aobj[0] = new aa((float)aobj1[1], i);
        aobj[4] = new aa((float)aobj1[0], i);
        j = 1;
_L55:
        i = j;
        if (j == 0) goto _L28; else goto _L27
_L27:
        i = 0;
_L51:
        if (i >= k) goto _L30; else goto _L29
_L29:
        aobj1 = a(ah1, l, i, l, true, b);
        if (aobj1 == null) goto _L32; else goto _L31
_L31:
        aobj[1] = new aa((float)aobj1[1], i);
        aobj[5] = new aa((float)aobj1[0], i);
        i = 1;
_L28:
        j = i;
        if (i == 0) goto _L34; else goto _L33
_L33:
        i = k - 1;
_L52:
        if (i <= 0) goto _L36; else goto _L35
_L35:
        aobj1 = a(ah1, 0, i, l, false, d);
        if (aobj1 == null) goto _L38; else goto _L37
_L37:
        aobj[2] = new aa((float)aobj1[0], i);
        aobj[6] = new aa((float)aobj1[1], i);
        j = 1;
_L34:
        if (j == 0) goto _L40; else goto _L39
_L39:
        i = 0;
_L53:
        if (i >= k) goto _L42; else goto _L41
_L41:
        aobj1 = a(ah1, 0, i, l, false, d);
        if (aobj1 == null) goto _L44; else goto _L43
_L43:
        aobj[3] = new aa((float)aobj1[0], i);
        aobj[7] = new aa((float)aobj1[1], i);
        i = 1;
_L54:
label0:
        {
            if (i == 0)
            {
                aobj = null;
            }
            aobj1 = aobj;
            if (aobj != null)
            {
                a(((aa []) (aobj)), true);
                break label0;
            }
        }
          goto _L45
_L2:
        i++;
          goto _L46
_L8:
        i--;
          goto _L47
_L14:
        i++;
          goto _L48
_L20:
        i--;
          goto _L49
_L26:
        i--;
          goto _L50
_L32:
        i++;
          goto _L51
_L38:
        i--;
          goto _L52
_L44:
        i++;
          goto _L53
_L22:
        a(((aa []) (aobj1)), false);
_L45:
        aobj = aobj1;
        if (aobj == null)
        {
            throw v.a();
        }
        float f = ((aa.a(aobj[0], aobj[4]) + aa.a(aobj[1], aobj[5])) / 34F + (aa.a(aobj[6], aobj[2]) + aa.a(aobj[7], aobj[3])) / 36F) / 2.0F;
        if (f < 1.0F)
        {
            throw v.a();
        }
        aa aa1 = aobj[4];
        aa aa3 = aobj[6];
        aa aa5 = aobj[5];
        aa aa7 = aobj[7];
        i = (int)(aa.a(aa1, aa3) / f + 0.5F);
        i = ((((int)(aa.a(aa5, aa7) / f + 0.5F) + i >> 1) + 8) / 17) * 17;
        if (i <= 0)
        {
            throw v.a();
        } else
        {
            aa aa2 = aobj[4];
            aa aa4 = aobj[5];
            aa aa6 = aobj[6];
            aa aa8 = aobj[7];
            return new ao(ar.a().a(ah1, i, i, 0.0F, 0.0F, i, 0.0F, i, i, 0.0F, i, aa2.a(), aa2.b(), aa6.a(), aa6.b(), aa8.a(), aa8.b(), aa4.a(), aa4.b()), new aa[] {
                aobj[4], aobj[5], aobj[6], aobj[7]
            });
        }
_L42:
        i = 0;
          goto _L54
_L40:
        i = j;
          goto _L54
_L36:
        j = 0;
          goto _L34
_L30:
        i = 0;
          goto _L28
_L24:
        j = 0;
          goto _L55
_L18:
        i = 0;
          goto _L16
_L12:
        j = 0;
          goto _L10
_L6:
        i = 0;
          goto _L4
        j = 0;
          goto _L56
    }

}
