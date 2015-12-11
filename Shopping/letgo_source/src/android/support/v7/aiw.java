// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public final class aiw extends Enum
{

    public static final aiw a;
    public static final aiw b;
    private static final aiw c[];

    private aiw(String s, int i)
    {
        super(s, i);
    }

    public static aiw valueOf(String s)
    {
        return (aiw)Enum.valueOf(android/support/v7/aiw, s);
    }

    public static aiw[] values()
    {
        return (aiw[])c.clone();
    }

    static 
    {
        a = new aiw("FIFO", 0);
        b = new aiw("LIFO", 1);
        c = (new aiw[] {
            a, b
        });
    }
}
