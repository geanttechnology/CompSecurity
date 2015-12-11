// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public abstract class afj extends Enum
{

    public static final afj a;
    public static final afj b;
    private static final afj c[];

    private afj(String s, int i)
    {
        super(s, i);
    }


    public static afj valueOf(String s)
    {
        return (afj)Enum.valueOf(android/support/v7/afj, s);
    }

    public static afj[] values()
    {
        return (afj[])c.clone();
    }

    static 
    {
        a = new afj("DEFAULT", 0) {

        };
        b = new afj("STRING", 1) {

        };
        c = (new afj[] {
            a, b
        });
    }
}
