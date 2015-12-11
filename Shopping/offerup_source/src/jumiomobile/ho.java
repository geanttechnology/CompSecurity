// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class ho extends Enum
{

    public static final ho a;
    public static final ho b;
    public static final ho c;
    private static final ho d[];

    private ho(String s, int i)
    {
        super(s, i);
    }

    public static ho valueOf(String s)
    {
        return (ho)Enum.valueOf(jumiomobile/ho, s);
    }

    public static ho[] values()
    {
        return (ho[])d.clone();
    }

    static 
    {
        a = new ho("EU", 0);
        b = new ho("US", 1);
        c = new ho("RAW", 2);
        d = (new ho[] {
            a, b, c
        });
    }
}
