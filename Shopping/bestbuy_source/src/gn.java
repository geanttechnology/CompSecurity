// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class gn extends Enum
{

    public static final gn a;
    public static final gn b;
    public static final gn c;
    private static final gn f[];
    public String d;
    public String e;

    private gn(String s, int i, String s1, String s2)
    {
        super(s, i);
        d = s1;
        e = s2;
    }

    public static gn a(String s)
    {
        return (gn)Enum.valueOf(gn, s);
    }

    static 
    {
        a = new gn("PROD", 0, "https://bbyoffer.appspot.com", "kEmhttwd7z7LR9O");
        b = new gn("QA", 1, "https://bbyoffer-int.appspot.com", "kEmhttwd7z7LR9O");
        c = new gn("CUSTOM", 2, "", "");
        f = (new gn[] {
            a, b, c
        });
    }
}
