// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Path;

// Referenced classes of package jumiomobile:
//            bu

public class bw
{

    public static Path a(String s)
    {
        float f;
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        bu bu1;
        Path path;
        int i;
        int k;
        k = s.length();
        bu1 = new bu(s, 0);
        bu1.a();
        path = new Path();
        f1 = 0.0F;
        f = 0.0F;
        f3 = 0.0F;
        f2 = 0.0F;
        i = 0;
        f5 = 0.0F;
        f4 = 0.0F;
_L18:
        if (bu1.a >= k) goto _L2; else goto _L1
_L1:
        char c = s.charAt(bu1.a);
        c;
        JVM INSTR tableswitch 43 57: default 148
    //                   43 374
    //                   44 148
    //                   45 374
    //                   46 148
    //                   47 148
    //                   48 374
    //                   49 374
    //                   50 374
    //                   51 374
    //                   52 374
    //                   53 374
    //                   54 374
    //                   55 374
    //                   56 374
    //                   57 374;
           goto _L3 _L4 _L3 _L4 _L3 _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4
_L3:
        bu1.c();
        i = c;
_L14:
        i;
        JVM INSTR lookupswitch 16: default 296
    //                   65: 1269
    //                   67: 987
    //                   72: 763
    //                   76: 638
    //                   77: 464
    //                   83: 1135
    //                   86: 873
    //                   90: 597
    //                   97: 1269
    //                   99: 987
    //                   104: 763
    //                   108: 638
    //                   109: 464
    //                   115: 1135
    //                   118: 873
    //                   122: 597;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L5:
        i = 0;
        float f6 = f1;
        float f17 = f;
        f1 = f4;
        f = f5;
        f5 = f2;
        f4 = f3;
        f3 = f17;
        f2 = f6;
_L16:
        if (i == 0)
        {
            f4 = f;
            f5 = f1;
        }
        bu1.a();
        float f7 = f4;
        float f18 = f5;
        i = c;
        f4 = f1;
        f5 = f;
        f1 = f2;
        f = f3;
        f3 = f7;
        f2 = f18;
        continue; /* Loop/switch isn't completed */
_L4:
        if (i == 'm' || i == 'M')
        {
            char c1 = (char)(i - 1);
            c = i;
            i = c1;
        } else
        {
            if (i != 'c' && i != 'C')
            {
                continue; /* Loop/switch isn't completed */
            }
            char c2 = i;
            c = i;
            i = c2;
        }
          goto _L14
        if (i != 'l' && i != 'L') goto _L3; else goto _L15
_L15:
        char c3 = i;
        c = i;
        i = c3;
          goto _L14
_L10:
        float f8 = bu1.e();
        float f35 = bu1.e();
        if (i == 'm')
        {
            path.rMoveTo(f8, f35);
            i = 0;
            float f19 = f3;
            float f29 = f2;
            float f40 = f5 + f35;
            float f42 = f4 + f8;
            f2 = f1 + f35;
            f3 = f + f8;
            f4 = f19;
            f5 = f29;
            f = f40;
            f1 = f42;
        } else
        {
            path.moveTo(f8, f35);
            i = 0;
            f5 = f35;
            f4 = f8;
            f = f35;
            f1 = f8;
            f8 = f3;
            float f20 = f2;
            f2 = f5;
            f3 = f4;
            f4 = f8;
            f5 = f20;
        }
          goto _L16
_L13:
        path.close();
        path.moveTo(f, f1);
        i = 1;
        f3 = f;
        f4 = f1;
        f5 = f;
        float f9 = f1;
        float f21 = f;
        f2 = f1;
        f = f9;
        f1 = f21;
          goto _L16
_L9:
        float f30 = bu1.e();
        float f36 = bu1.e();
        if (i == 'l')
        {
            path.rLineTo(f30, f36);
            i = 0;
            float f10 = f3;
            float f22 = f2;
            f36 = f5 + f36;
            f30 = f4 + f30;
            f2 = f1;
            f3 = f;
            f4 = f10;
            f5 = f22;
            f = f36;
            f1 = f30;
        } else
        {
            path.lineTo(f30, f36);
            i = 0;
            f4 = f1;
            f5 = f3;
            float f11 = f2;
            f1 = f30;
            float f23 = f36;
            f2 = f4;
            f3 = f;
            f4 = f5;
            f5 = f11;
            f = f23;
        }
          goto _L16
_L8:
        float f37 = bu1.e();
        if (i == 'h')
        {
            path.rLineTo(f37, 0.0F);
            i = 0;
            float f12 = f3;
            float f24 = f2;
            float f31 = f5;
            f37 = f4 + f37;
            f2 = f1;
            f3 = f;
            f4 = f12;
            f5 = f24;
            f = f31;
            f1 = f37;
        } else
        {
            path.lineTo(f37, f5);
            i = 0;
            float f25 = f1;
            f4 = f3;
            float f13 = f2;
            f1 = f37;
            float f32 = f5;
            f2 = f25;
            f3 = f;
            f5 = f13;
            f = f32;
        }
          goto _L16
_L12:
        float f33 = bu1.e();
        if (i == 'v')
        {
            path.rLineTo(0.0F, f33);
            i = 0;
            float f14 = f3;
            float f26 = f2;
            float f38 = f5 + f33;
            f33 = f4;
            f2 = f1;
            f3 = f;
            f4 = f14;
            f5 = f26;
            f = f38;
            f1 = f33;
        } else
        {
            path.lineTo(f4, f33);
            i = 0;
            f5 = f3;
            float f15 = f2;
            float f27 = f33;
            f33 = f4;
            f2 = f1;
            f3 = f;
            f4 = f5;
            f5 = f15;
            f = f27;
            f1 = f33;
        }
          goto _L16
_L7:
        float f39 = bu1.e();
        float f41 = bu1.e();
        float f43 = bu1.e();
        f3 = bu1.e();
        float f34 = bu1.e();
        f2 = bu1.e();
        float f16;
        float f28;
        float f44;
        float f45;
        int j;
        if (i == 'c')
        {
            f16 = f43 + f4;
            f28 = f34 + f4;
            f34 = f3 + f5;
            f2 += f5;
            f41 += f5;
            f39 += f4;
            f3 = f28;
            f4 = f34;
            f5 = f16;
            f28 = f41;
            f16 = f39;
        } else
        {
            f28 = f41;
            f16 = f39;
            f5 = f43;
            f4 = f3;
            f3 = f34;
        }
        path.cubicTo(f16, f28, f5, f4, f3, f2);
        i = 1;
        f16 = f1;
        f1 = f3;
        f28 = f2;
        f2 = f16;
        f3 = f;
        f = f28;
          goto _L16
_L11:
        j = 1;
        f45 = bu1.e();
        f43 = bu1.e();
        f44 = bu1.e();
        f41 = bu1.e();
        f39 = f45;
        f34 = f43;
        f28 = f44;
        f16 = f41;
        if (i == 's')
        {
            f39 = f45 + f4;
            f28 = f44 + f4;
            f34 = f43 + f5;
            f16 = f41 + f5;
        }
        path.cubicTo(f4 * 2.0F - f2, f5 * 2.0F - f3, f39, f34, f28, f16);
        f2 = f1;
        f5 = f39;
        f4 = f34;
        f1 = f28;
        f3 = f;
        f = f16;
        i = j;
          goto _L16
_L6:
        f34 = bu1.e();
        f39 = bu1.e();
        f41 = bu1.e();
        i = (int)bu1.e();
        j = (int)bu1.e();
        f16 = bu1.e();
        f28 = bu1.e();
        a(path, f4, f5, f16, f28, f34, f39, f41, i, j);
        i = 0;
        f4 = f1;
        f5 = f;
        f = f28;
        f1 = f16;
        f16 = f3;
        f28 = f2;
        f2 = f4;
        f3 = f5;
        f4 = f16;
        f5 = f28;
          goto _L16
_L2:
        return path;
        if (true) goto _L18; else goto _L17
_L17:
    }

    private static void a(Path path, float f, float f1, float f2, float f3, float f4, float f5, float f6, 
            int i, int j)
    {
    }
}
