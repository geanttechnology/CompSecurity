// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public final class aoj extends Enum
{

    public static final aoj a;
    public static final aoj b;
    public static final aoj c;
    public static final aoj d;
    private static final aoj e[];

    private aoj(String s, int i)
    {
        super(s, i);
    }

    public static aoj valueOf(String s)
    {
        return (aoj)Enum.valueOf(android/support/v7/aoj, s);
    }

    public static aoj[] values()
    {
        return (aoj[])e.clone();
    }

    static 
    {
        a = new aoj("GET", 0);
        b = new aoj("POST", 1);
        c = new aoj("PUT", 2);
        d = new aoj("DELETE", 3);
        e = (new aoj[] {
            a, b, c, d
        });
    }
}
