// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public final class aku extends Enum
{

    public static final aku a;
    public static final aku b;
    private static final aku d[];
    final int c;

    private aku(String s, int i, int j)
    {
        super(s, i);
        c = j;
    }

    static boolean a(int i)
    {
        return (a.c & i) == 0;
    }

    static boolean b(int i)
    {
        return (b.c & i) == 0;
    }

    public static aku valueOf(String s)
    {
        return (aku)Enum.valueOf(android/support/v7/aku, s);
    }

    public static aku[] values()
    {
        return (aku[])d.clone();
    }

    static 
    {
        a = new aku("NO_CACHE", 0, 1);
        b = new aku("NO_STORE", 1, 2);
        d = (new aku[] {
            a, b
        });
    }
}
