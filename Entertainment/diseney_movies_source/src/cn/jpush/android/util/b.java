// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;


final class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    private static final b f[];
    private static final String z[];

    private b(String s, int i)
    {
        super(s, i);
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(cn/jpush/android/util/b, s);
    }

    public static b[] values()
    {
        return (b[])f.clone();
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[5];
        i = 0;
        obj1 = "\037DB9~\036HP/{\tNY/n\023@F5m\tDR#";
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
    //                   0 439
    //                   1 446
    //                   2 452
    //                   3 459;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_459;
_L3:
        byte0 = 61;
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
            obj1 = "\037DB9~\036HP/{\tNY/x\003UQ\"s\032MG$r\t@S5";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "\037DB9~\036HP/{\tNY/n\002R";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "\037DB9~\036HP/{\tNY/s\036V";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "\037DB9~\036HP/{\tNY/n\036U@9s\034";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            z = as;
            a = new b(z[3], 0);
            b = new b(z[4], 1);
            c = new b(z[1], 2);
            d = new b(z[0], 3);
            e = new b(z[2], 4);
            f = (new b[] {
                a, b, c, d, e
            });
            return;
        }
          goto _L12
_L8:
        byte0 = 91;
          goto _L13
_L5:
        byte0 = 1;
          goto _L13
_L6:
        byte0 = 20;
          goto _L13
        byte0 = 112;
          goto _L13
    }
}
