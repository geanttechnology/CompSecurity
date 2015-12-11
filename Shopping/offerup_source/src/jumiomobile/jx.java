// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class jx extends Enum
{

    public static final jx a;
    public static final jx b;
    public static final jx c;
    public static final jx d;
    private static final jx e[];

    private jx(String s, int i)
    {
        super(s, i);
    }

    public static jx valueOf(String s)
    {
        return (jx)Enum.valueOf(jumiomobile/jx, s);
    }

    public static jx[] values()
    {
        return (jx[])e.clone();
    }

    static 
    {
        a = new jx("IDLE", 0);
        b = new jx("MISSING", 1);
        c = new jx("RUNNING", 2);
        d = new jx("FINISH", 3);
        e = (new jx[] {
            a, b, c, d
        });
    }
}
