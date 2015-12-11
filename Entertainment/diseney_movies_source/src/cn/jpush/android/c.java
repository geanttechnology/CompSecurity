// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android;


public final class c extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;
    public static final c i;
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final c o;
    public static final c p;
    public static final c q;
    public static final c r;
    private static final c s[];
    private static final String z[];

    private c(String s1, int i1)
    {
        super(s1, i1);
    }

    public static c valueOf(String s1)
    {
        return (c)Enum.valueOf(cn/jpush/android/c, s1);
    }

    public static c[] values()
    {
        return (c[])s.clone();
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i1;
        as = new String[18];
        i1 = 0;
        obj1 = "3\031W(:0\021J96,\023@\"(4\023N.";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j1;
        int k1;
        int l1;
        int i2;
        byte byte2;
        int j2;
        ac = ((String) (obj1)).toCharArray();
        j1 = ac.length;
        i2 = 0;
        k1 = 0;
        byte2 = byte0;
        obj1 = ac;
        j2 = i1;
        as1 = ((String []) (obj));
        l1 = j1;
        if (j1 > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l1 = k1;
_L9:
        obj1 = obj;
        i2 = obj1[k1];
        l1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 1084
    //                   1 1091
    //                   2 1098
    //                   3 1105;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_1105;
_L3:
        byte0 = 105;
_L13:
label0:
        {
            obj1[k1] = (char)(byte0 ^ i2);
            l1++;
            if (j1 != 0)
            {
                break label0;
            }
            k1 = j1;
        }
        if (true) goto _L9; else goto _L8
        i2 = l1;
        l1 = j1;
        as1 = as2;
        j2 = i1;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i1 = j2;
        as2 = as1;
        j1 = l1;
        k1 = i2;
        if (l1 > i2) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j2] = ((String) (obj));
            i1 = 1;
            obj1 = "3\031W(:0\021J96(\007T56,\033J8";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j2] = ((String) (obj));
            i1 = 2;
            obj1 = "3\031W(:0\021J96(\007T566\027P";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j2] = ((String) (obj));
            i1 = 3;
            obj1 = "3\031W(:0\021J965\023_";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j2] = ((String) (obj));
            i1 = 4;
            obj1 = "3\031W(:0\021J960\023U)+=\023S";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j2] = ((String) (obj));
            i1 = 5;
            obj1 = "3\031W(:0\021J964\035@2<,";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j2] = ((String) (obj));
            i1 = 6;
            obj1 = "3\031W(:0\021J96<\027D>!9\034I8%1\026";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j2] = ((String) (obj));
            i1 = 7;
            obj1 = "3\031W(:0\021J96=\034F?%=\021O3'=\036N9";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j2] = ((String) (obj));
            i1 = 8;
            obj1 = "3\031W(:0\021J96<\027D>!9\034I8%1\0265";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j2] = ((String) (obj));
            i1 = 9;
            obj1 = "3\031W(:0\021J965\027T.(?\027";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j2] = ((String) (obj));
            i1 = 10;
            obj1 = "3\031W(:0\021J96?\027S>!9\034I8%1\0265";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j2] = ((String) (obj));
            i1 = 11;
            obj1 = "3\031W(:0\021J96-\034U8.;\032F3'=\033C";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j2] = ((String) (obj));
            i1 = 12;
            obj1 = "3\031W(:0\021J96*\027@";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j2] = ((String) (obj));
            i1 = 13;
            obj1 = "3\031W(:0\021J964\035@4'";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j2] = ((String) (obj));
            i1 = 14;
            obj1 = "3\031W(:0\rC8?1\021B)&3\027I\";=\002H/=";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[j2] = ((String) (obj));
            i1 = 15;
            obj1 = "3\031W(:0\021J96?\027S>!9\034I8%1\026";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[j2] = ((String) (obj));
            i1 = 16;
            obj1 = "3\031W(:0\021J96;\036N8',\001B3-5\001@";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[j2] = ((String) (obj));
            i1 = 17;
            obj1 = "3\031W(:0\021J965\027T.(?\027B9";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[j2] = ((String) (obj));
            z = as;
            a = new c(z[12], 0);
            b = new c(z[13], 1);
            c = new c(z[4], 2);
            d = new c(z[9], 3);
            e = new c(z[17], 4);
            f = new c(z[5], 5);
            g = new c(z[15], 6);
            h = new c(z[6], 7);
            i = new c(z[3], 8);
            j = new c(z[2], 9);
            k = new c(z[0], 10);
            l = new c(z[7], 11);
            m = new c(z[1], 12);
            n = new c(z[14], 13);
            o = new c(z[11], 14);
            p = new c(z[16], 15);
            q = new c(z[10], 16);
            r = new c(z[8], 17);
            s = (new c[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r
            });
            return;
        }
          goto _L12
_L8:
        byte0 = 120;
          goto _L13
_L5:
        byte0 = 82;
          goto _L13
_L6:
        byte0 = 7;
          goto _L13
        byte0 = 125;
          goto _L13
    }
}
