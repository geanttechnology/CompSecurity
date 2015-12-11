// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ctk extends Enum
{

    public static final ctk a;
    public static final ctk b;
    public static final ctk c;
    public static final ctk d;
    public static final ctk e;
    public static final ctk f;
    private static final ctk g[];

    private ctk(String s, int i)
    {
        super(s, i);
    }

    public static ctk valueOf(String s)
    {
        return (ctk)Enum.valueOf(ctk, s);
    }

    public static ctk[] values()
    {
        return (ctk[])g.clone();
    }

    static 
    {
        a = new ctk("START", 0);
        b = new ctk("NEXT", 1);
        c = new ctk("PREVIOUS", 2);
        d = new ctk("AUTOPLAY", 3);
        e = new ctk("RETRY", 4);
        f = new ctk("JUMP", 5);
        g = (new ctk[] {
            a, b, c, d, e, f
        });
    }
}
