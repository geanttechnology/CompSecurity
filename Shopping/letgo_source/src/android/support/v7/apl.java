// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public final class apl extends Enum
{

    public static final apl a;
    public static final apl b;
    public static final apl c;
    private static final apl d[];

    private apl(String s, int i)
    {
        super(s, i);
    }

    public static apl valueOf(String s)
    {
        return (apl)Enum.valueOf(android/support/v7/apl, s);
    }

    public static apl[] values()
    {
        return (apl[])d.clone();
    }

    static 
    {
        a = new apl("USE_CACHE", 0);
        b = new apl("SKIP_CACHE_LOOKUP", 1);
        c = new apl("IGNORE_CACHE_EXPIRATION", 2);
        d = (new apl[] {
            a, b, c
        });
    }
}
