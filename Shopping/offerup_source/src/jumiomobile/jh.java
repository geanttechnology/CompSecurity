// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class jh extends Enum
{

    public static final jh a;
    public static final jh b;
    public static final jh c;
    private static final jh d[];

    private jh(String s, int i)
    {
        super(s, i);
    }

    public static jh valueOf(String s)
    {
        return (jh)Enum.valueOf(jumiomobile/jh, s);
    }

    public static jh[] values()
    {
        return (jh[])d.clone();
    }

    static 
    {
        a = new jh("SCANNING_NOT_TRACKING", 0);
        b = new jh("SCANNING_TRACKING", 1);
        c = new jh("EXTRACTION", 2);
        d = (new jh[] {
            a, b, c
        });
    }
}
