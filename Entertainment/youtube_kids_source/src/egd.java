// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class egd
{

    private final String a;
    private ege b;
    private ege c;
    private boolean d;

    public egd(String s)
    {
        b = new ege();
        c = b;
        d = false;
        a = (String)f.b(s);
    }

    public final egd a(String s, int i)
    {
        return a(s, String.valueOf(i));
    }

    public egd a(String s, Object obj)
    {
        ege ege1 = new ege();
        c.c = ege1;
        c = ege1;
        ege1.b = obj;
        ege1.a = (String)f.b(s);
        return this;
    }

    public final String toString()
    {
        String s = "";
        StringBuilder stringbuilder = (new StringBuilder(32)).append(a).append('{');
        for (ege ege1 = b.c; ege1 != null; ege1 = ege1.c)
        {
            stringbuilder.append(s);
            s = ", ";
            if (ege1.a != null)
            {
                stringbuilder.append(ege1.a).append('=');
            }
            stringbuilder.append(ege1.b);
        }

        return stringbuilder.append('}').toString();
    }
}
