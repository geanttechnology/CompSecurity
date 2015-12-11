// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;


public final class k
{

    private static final String z[];
    private int a;
    private int b;
    private int c;
    private int d;
    private String e;
    private long f;
    private long g;

    public k()
    {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = "";
        f = 0L;
        g = 0L;
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = "";
        f = 0L;
        g = 0L;
    }

    public final int a()
    {
        return a;
    }

    public final void a(int i)
    {
        a = i;
    }

    public final void a(long l)
    {
        g = l;
    }

    public final void a(String s)
    {
        e = s;
    }

    public final int b()
    {
        return b;
    }

    public final void b(int i)
    {
        b = i;
    }

    public final void b(long l)
    {
        f = l;
    }

    public final int c()
    {
        return c;
    }

    public final void c(int i)
    {
        c = i;
    }

    public final String d()
    {
        return e;
    }

    public final void d(int i)
    {
        d = i;
    }

    public final long e()
    {
        return g;
    }

    public final long f()
    {
        return f;
    }

    public final String toString()
    {
        return (new StringBuilder(z[2])).append(a).append(z[0]).append(b).append(z[6]).append(c).append(z[4]).append(d).append(z[1]).append(e).append(z[5]).append(f).append(z[3]).append(g).append("]").toString();
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[7];
        i = 0;
        obj1 = "\1771f\003S0~\177\003xn";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int l;
        int i1;
        int j1;
        byte byte2;
        int k1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        j1 = 0;
        l = 0;
        byte2 = byte0;
        obj1 = ac;
        k1 = i;
        as1 = ((String []) (obj));
        i1 = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        i1 = l;
_L9:
        obj1 = obj;
        j1 = obj1[l];
        i1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 369
    //                   1 376
    //                   2 383
    //                   3 390;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_390;
_L3:
        byte0 = 12;
_L13:
label0:
        {
            obj1[l] = (char)(byte0 ^ j1);
            i1++;
            if (j != 0)
            {
                break label0;
            }
            l = j;
        }
        if (true) goto _L9; else goto _L8
        j1 = i1;
        i1 = j;
        as1 = as2;
        k1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = k1;
        as2 = as1;
        j = i1;
        l = j1;
        if (i1 > j1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[k1] = ((String) (obj));
            i = 1;
            obj1 = "\1771f\003S6i~\037mn";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[k1] = ((String) (obj));
            i = 2;
            obj1 = "\037~i\f`\035~~\004j:rk\031e<\177N/H2ekMW?\177U\004hn";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[k1] = ((String) (obj));
            i = 3;
            obj1 = "\1771f\003S2un2x:|oP";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[k1] = ((String) (obj));
            i = 4;
            obj1 = "\1771f\003S'hz\b1";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[k1] = ((String) (obj));
            i = 5;
            obj1 = "\1771f\003S'cc\nk6cU\031e>t7";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[k1] = ((String) (obj));
            i = 6;
            obj1 = "\1771f\003S!tg\002z6,";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[k1] = ((String) (obj));
            z = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 83;
          goto _L13
_L5:
        byte0 = 17;
          goto _L13
_L6:
        byte0 = 10;
          goto _L13
        byte0 = 109;
          goto _L13
    }
}
