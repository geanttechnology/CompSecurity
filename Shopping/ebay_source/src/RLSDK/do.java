// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;

// Referenced classes of package RLSDK:
//            ah, aa, v, s, 
//            dr, dl, dp, dn, 
//            at, ar, ao, dq, 
//            r, ab

public final class do
{

    private final ah a;
    private ab b;

    public do(ah ah1)
    {
        a = ah1;
    }

    private float a(int i, int j, int k, int l)
    {
        boolean flag = false;
        float f1 = 1.0F;
        float f2 = b(i, j, k, l);
        k = i - (k - i);
        float f;
        if (k < 0)
        {
            f = (float)i / (float)(i - k);
            k = 0;
        } else
        if (k > a.a)
        {
            f = (float)(a.a - i) / (float)(k - i);
            k = a.a;
        } else
        {
            f = 1.0F;
        }
        l = (int)((float)j - f * (float)(l - j));
        if (l < 0)
        {
            f = (float)j / (float)(j - l);
            l = ((flag) ? 1 : 0);
        } else
        if (l > a.b)
        {
            f = (float)(a.b - j) / (float)(l - j);
            l = a.b;
        } else
        {
            f = f1;
        }
        f1 = i;
        return b(i, j, (int)(f * (float)(k - i) + f1), l) + f2;
    }

    private float a(aa aa1, aa aa2)
    {
        float f = a((int)aa1.a(), (int)aa1.b(), (int)aa2.a(), (int)aa2.b());
        float f1 = a((int)aa2.a(), (int)aa2.b(), (int)aa1.a(), (int)aa1.b());
        if (Float.isNaN(f))
        {
            return f1 / 7F;
        }
        if (Float.isNaN(f1))
        {
            return f / 7F;
        } else
        {
            return (f + f1) / 14F;
        }
    }

    private ao a(dr dr1)
        throws v, s
    {
        float f;
        dp dp1;
        dp dp2;
        dp dp3;
        int i;
        dp1 = dr1.b();
        dp2 = dr1.c();
        dp3 = dr1.a();
        f = (a(((aa) (dp1)), ((aa) (dp2))) + a(((aa) (dp1)), ((aa) (dp3)))) / 2.0F;
        if (f < 1.0F)
        {
            throw v.a();
        }
        i = ((int)(aa.a(dp1, dp2) / f + 0.5F) + (int)(aa.a(dp1, dp3) / f + 0.5F) >> 1) + 7;
        i & 3;
        JVM INSTR tableswitch 0 3: default 116
    //                   0 321
    //                   1 116
    //                   2 330
    //                   3 339;
           goto _L1 _L2 _L1 _L3 _L4
_L1:
        int j;
        dr1 = dl.a(i);
        j = dr1.d();
        if (dr1.b().length <= 0) goto _L6; else goto _L5
_L5:
        int k;
        int l;
        float f2 = dp2.a();
        float f4 = dp1.a();
        float f6 = dp3.a();
        float f8 = dp2.b();
        float f10 = dp1.b();
        float f11 = dp3.b();
        float f12 = 1.0F - 3F / (float)(j - 7);
        float f13 = dp1.a();
        k = (int)((((f2 - f4) + f6) - dp1.a()) * f12 + f13);
        l = (int)(dp1.b() + f12 * (((f8 - f10) + f11) - dp1.b()));
        j = 4;
_L10:
        if (j > 16) goto _L6; else goto _L7
_L7:
        int l1 = (int)((float)j * f);
        int i1;
        int j1;
        i1 = Math.max(0, k - l1);
        j1 = Math.min(a.a - 1, k + l1);
        if ((float)(j1 - i1) >= 3F * f) goto _L9; else goto _L8
_L8:
        try
        {
            throw v.a();
        }
        // Misplaced declaration of an exception variable
        catch (dr dr1)
        {
            j <<= 1;
        }
          goto _L10
_L2:
        i++;
          goto _L1
_L3:
        i--;
          goto _L1
_L4:
        throw v.a();
_L9:
        int k1;
        k1 = Math.max(0, l - l1);
        l1 = Math.min(a.b - 1, l1 + l);
        if ((float)(l1 - k1) >= 3F * f)
        {
            break MISSING_BLOCK_LABEL_391;
        }
        throw v.a();
        dr1 = (new dn(a, i1, k1, j1 - i1, l1 - k1, f, b)).a();
_L12:
        float f1 = (float)i - 3.5F;
        float f3;
        float f5;
        float f7;
        float f9;
        at at1;
        ah ah1;
        if (dr1 != null)
        {
            f7 = dr1.a();
            f9 = dr1.b();
            f3 = f1 - 3F;
            f5 = f3;
        } else
        {
            f7 = (dp2.a() - dp1.a()) + dp3.a();
            f9 = (dp2.b() - dp1.b()) + dp3.b();
            f3 = f1;
            f5 = f1;
        }
        at1 = at.a(3.5F, 3.5F, f1, 3.5F, f3, f5, 3.5F, f1, dp1.a(), dp1.b(), dp2.a(), dp2.b(), f7, f9, dp3.a(), dp3.b());
        ah1 = a;
        ah1 = ar.a().a(ah1, i, i, at1);
        if (dr1 == null)
        {
            dr1 = new aa[3];
            dr1[0] = dp3;
            dr1[1] = dp1;
            dr1[2] = dp2;
        } else
        {
            aa aaa[] = new aa[4];
            aaa[0] = dp3;
            aaa[1] = dp1;
            aaa[2] = dp2;
            aaa[3] = dr1;
            dr1 = aaa;
        }
        return new ao(ah1, dr1);
_L6:
        dr1 = null;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private float b(int i, int j, int k, int l)
    {
        int i1;
        int j1;
        boolean flag;
        int k1;
        int l1;
        int i2;
        byte byte0;
        int j2;
        int k2;
        int l2;
        int i3;
        if (Math.abs(l - j) > Math.abs(k - i))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            l1 = l;
            k1 = k;
            i1 = j;
            l = i;
        } else
        {
            k1 = l;
            l = j;
            i1 = i;
            l1 = k;
        }
        l2 = Math.abs(l1 - i1);
        i3 = Math.abs(k1 - l);
        j = -l2;
        if (i1 < l1)
        {
            i2 = 1;
        } else
        {
            i2 = -1;
        }
        if (l < k1)
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        k = 0;
        i = i1;
        j1 = j >> 1;
        j = l;
        if (i == l1) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            j2 = j;
        } else
        {
            j2 = i;
        }
        if (flag)
        {
            k2 = i;
        } else
        {
            k2 = j;
        }
        if (k != 1) goto _L4; else goto _L3
_L3:
        if (a.a(j2, k2))
        {
            k++;
        }
_L6:
        if (k == 3)
        {
            k = i - i1;
            j -= l;
            i = k;
            if (i2 < 0)
            {
                i = k + 1;
            }
            return (float)Math.sqrt(i * i + j * j);
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!a.a(j2, k2))
        {
            k++;
        }
        if (true) goto _L6; else goto _L5
_L5:
        k2 = j1 + i3;
        j2 = j;
        j1 = k2;
        if (k2 > 0)
        {
            if (j == k1)
            {
                break; /* Loop/switch isn't completed */
            }
            j2 = j + byte0;
            j1 = k2 - l2;
        }
        i += i2;
        j = j2;
        break MISSING_BLOCK_LABEL_94;
_L2:
        i = l1 - i1;
        j = k1 - l;
        return (float)Math.sqrt(i * i + j * j);
    }

    public final ao a(Hashtable hashtable)
        throws v, s
    {
        ab ab1;
        if (hashtable == null)
        {
            ab1 = null;
        } else
        {
            ab1 = (ab)hashtable.get(r.h);
        }
        b = ab1;
        return a((new dq(a, b)).a(hashtable));
    }
}
