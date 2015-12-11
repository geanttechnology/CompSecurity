// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;


public final class w
{

    private static final String z[];
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    public w()
    {
        a = "";
        b = "";
        c = "";
        d = "";
        e = "";
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        j = 0;
        k = 0;
    }

    public final String a()
    {
        return a;
    }

    public final void a(int l)
    {
        f = l;
    }

    public final void a(String s)
    {
        a = s;
    }

    public final String b()
    {
        return b;
    }

    public final void b(int l)
    {
        g = l;
    }

    public final void b(String s)
    {
        b = s;
    }

    public final String c()
    {
        return c;
    }

    public final void c(int l)
    {
        h = l;
    }

    public final void c(String s)
    {
        c = s;
    }

    public final String d()
    {
        return d;
    }

    public final void d(int l)
    {
        i = l;
    }

    public final void d(String s)
    {
        d = s;
    }

    public final String e()
    {
        return e;
    }

    public final void e(int l)
    {
        j = l;
    }

    public final void e(String s)
    {
        e = s;
    }

    public final int f()
    {
        return f;
    }

    public final void f(int l)
    {
        k = l;
    }

    public final int g()
    {
        return g;
    }

    public final int h()
    {
        return h;
    }

    public final int i()
    {
        return i;
    }

    public final int j()
    {
        return j;
    }

    public final int k()
    {
        return k;
    }

    public final String toString()
    {
        return (new StringBuilder(z[9])).append(a).append(z[5]).append(b).append(z[1]).append(c).append(z[10]).append(d).append(z[2]).append(e).append(z[8]).append(f).append(z[4]).append(g).append(z[7]).append(h).append(z[6]).append(i).append(z[3]).append(j).append(z[0]).append(k).append("]").toString();
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int l;
        as = new String[11];
        l = 0;
        obj1 = "\020.u0'RzInb\001";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int i1;
        int j1;
        int k1;
        int l1;
        byte byte2;
        int i2;
        ac = ((String) (obj1)).toCharArray();
        i1 = ac.length;
        l1 = 0;
        j1 = 0;
        byte2 = byte0;
        obj1 = ac;
        i2 = l;
        as1 = ((String []) (obj));
        k1 = i1;
        if (i1 > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        k1 = j1;
_L9:
        obj1 = obj;
        l1 = obj1[j1];
        k1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 469
    //                   1 476
    //                   2 483
    //                   3 490;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_490;
_L3:
        byte0 = 82;
_L13:
label0:
        {
            obj1[j1] = (char)(byte0 ^ l1);
            k1++;
            if (i1 != 0)
            {
                break label0;
            }
            j1 = i1;
        }
        if (true) goto _L9; else goto _L8
        l1 = k1;
        k1 = i1;
        as1 = as2;
        i2 = l;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        l = i2;
        as2 = as1;
        i1 = k1;
        j1 = l1;
        if (k1 > l1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[i2] = ((String) (obj));
            l = 1;
            obj1 = "\020.e+\r_ax1\rU~+";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[i2] = ((String) (obj));
            l = 2;
            obj1 = "\020.e+\rOac-1Y3";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[i2] = ((String) (obj));
            l = 3;
            obj1 = "\020.u0'RzIl\r\r>+";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[i2] = ((String) (obj));
            l = 4;
            obj1 = "\020.b0&]b+";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[i2] = ((String) (obj));
            l = 5;
            obj1 = "\020.e+\rRkbb";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[i2] = ((String) (obj));
            l = 6;
            obj1 = "\020.u0'RzIn\r\0173";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[i2] = ((String) (obj));
            l = 7;
            obj1 = "\020.u0'RzIno";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[i2] = ((String) (obj));
            l = 8;
            obj1 = "\020.p>;Pkrb";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[i2] = ((String) (obj));
            l = 9;
            obj1 = "ozw+;Oz\177<!xLR>&].M,&c}y-&\001";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[i2] = ((String) (obj));
            l = 10;
            obj1 = "\020.e+\rPau>>cjx,o";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[i2] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 60;
          goto _L13
_L5:
        byte0 = 14;
          goto _L13
_L6:
        byte0 = 22;
          goto _L13
        byte0 = 95;
          goto _L13
    }
}
