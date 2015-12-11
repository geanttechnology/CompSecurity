// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


final class hf extends Enum
{

    public static final hf a;
    public static final hf b;
    public static final hf c;
    public static final hf d;
    private static final hf e[];

    private hf(String s, int i)
    {
        super(s, i);
    }

    public static hf valueOf(String s)
    {
        return (hf)Enum.valueOf(jumiomobile/hf, s);
    }

    public static hf[] values()
    {
        return (hf[])e.clone();
    }

    static 
    {
        a = new hf("PROPERTIES", 0);
        b = new hf("SCAN", 1);
        c = new hf("SUBMISSION", 2);
        d = new hf("UPLOAD", 3);
        e = (new hf[] {
            a, b, c, d
        });
    }
}
