// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class v extends Enum
{

    public static final v a;
    public static final v b;
    private static final v c[];

    private v(String s, int i)
    {
        super(s, i);
    }

    public static v valueOf(String s)
    {
        return (v)Enum.valueOf(jumiomobile/v, s);
    }

    public static v[] values()
    {
        return (v[])c.clone();
    }

    static 
    {
        a = new v("NATIVE", 0);
        b = new v("NONE", 1);
        c = (new v[] {
            a, b
        });
    }
}
