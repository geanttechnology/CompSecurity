// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class bx
{

    private static final bm a = d.a(bx);

    public bx()
    {
    }

    public static String a(String s)
    {
        if (a.a())
        {
            a.a((new StringBuilder("Escaping XML reserved tokens (&, <, >, \" and ') of: ")).append(s).toString());
        }
        int i = 0;
        for (s = new StringBuffer(s); i < s.length();)
        {
            char c1 = s.charAt(i);
            if (c1 == '&')
            {
                i++;
                s.insert(i, "amp;");
                i += 4;
            } else
            if (c1 == '<')
            {
                s.deleteCharAt(i);
                s.insert(i, "&lt;");
                i += 4;
            } else
            if (c1 == '>')
            {
                s.deleteCharAt(i);
                s.insert(i, "&gt;");
                i += 4;
            } else
            if (c1 == '"')
            {
                s.deleteCharAt(i);
                s.insert(i, "&quot;");
                i += 6;
            } else
            if (c1 == '\'')
            {
                s.deleteCharAt(i);
                s.insert(i, "&apos;");
                i += 6;
            } else
            {
                i++;
            }
        }

        s = s.toString();
        if (a.a())
        {
            a.a((new StringBuilder("Final output: ")).append(s).toString());
        }
        return s;
    }

    public static boolean a()
    {
        return false;
    }

    public static boolean a(bi bi1)
    {
        short word0 = bi1.a();
        return word0 == bi.d.a() || word0 == bi.e.a() || word0 == bi.f.a() || word0 == bi.g.a();
    }

    public static boolean b()
    {
        return false;
    }

    public static boolean b(bi bi1)
    {
        short word0 = bi1.a();
        return word0 == bi.a.a() || word0 == bi.c.a() || word0 == bi.b.a();
    }

    public static bi c(bi bi1)
    {
        bi bi2;
        if (bi1 == bi.b || bi1 == bi.c)
        {
            bi2 = bi.a;
        } else
        if (bi1 == bi.e || bi1 == bi.f || bi1 == bi.h || bi1 == bi.g)
        {
            bi2 = bi.d;
        } else
        {
            bi2 = bi1;
        }
        if (a.c())
        {
            a.c((new StringBuilder("adjustCodecForBluetooth() ")).append(bi1.a()).append(" -> ").append(bi2.a()).toString());
        }
        return bi2;
    }

}
