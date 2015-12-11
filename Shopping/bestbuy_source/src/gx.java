// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class gx extends Enum
{

    public static final gx a;
    public static final gx b;
    public static final gx c;
    public static final gx d;
    private static final gx f[];
    private String e;

    private gx(String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }

    public String a()
    {
        return e;
    }

    static 
    {
        a = new gx("GET", 0, "GET");
        b = new gx("POST", 1, "POST");
        c = new gx("PUT", 2, "PUT");
        d = new gx("DELETE", 3, "DELETE");
        f = (new gx[] {
            a, b, c, d
        });
    }
}
