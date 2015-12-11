// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


final class mm extends Enum
{

    public static final mm a;
    public static final mm b;
    public static final mm c;
    public static final mm d;
    private static final mm e[];

    private mm(String s, int i)
    {
        super(s, i);
    }

    public static mm valueOf(String s)
    {
        return (mm)Enum.valueOf(jumiomobile/mm, s);
    }

    public static mm[] values()
    {
        return (mm[])e.clone();
    }

    static 
    {
        a = new mm("None", 0);
        b = new mm("Crop", 1);
        c = new mm("GetCloser", 2);
        d = new mm("Progress", 3);
        e = (new mm[] {
            a, b, c, d
        });
    }
}
