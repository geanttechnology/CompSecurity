// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bgl extends Enum
{

    public static final bgl a;
    public static final bgl b;
    private static final bgl d[];
    final String c;

    private bgl(String s, int i, String s1)
    {
        super(s, i);
        c = s1;
    }

    public static bgl a(String s)
    {
        if (a.c.equals(s))
        {
            return a;
        }
        if (b.c.equals(s))
        {
            return b;
        } else
        {
            return null;
        }
    }

    public static bgl valueOf(String s)
    {
        return (bgl)Enum.valueOf(bgl, s);
    }

    public static bgl[] values()
    {
        return (bgl[])d.clone();
    }

    static 
    {
        a = new bgl("INSTREAM", 0, "1");
        b = new bgl("TRUEVIEW_INDISPLAY", 1, "2");
        d = (new bgl[] {
            a, b
        });
    }
}
