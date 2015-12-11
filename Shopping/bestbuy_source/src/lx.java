// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class lx extends Enum
{

    public static final lx a;
    public static final lx b;
    public static final lx c;
    private static final lx d[];

    private lx(String s, int i)
    {
        super(s, i);
    }

    static 
    {
        a = new lx("PREVIEW", 0);
        b = new lx("SUCCESS", 1);
        c = new lx("DONE", 2);
        d = (new lx[] {
            a, b, c
        });
    }
}
