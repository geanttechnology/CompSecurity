// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class kd extends Enum
{

    public static final kd a;
    public static final kd b;
    public static final kd c;
    public static final kd d;
    private static final kd e[];

    private kd(String s, int i)
    {
        super(s, i);
    }

    public static kd valueOf(String s)
    {
        return (kd)Enum.valueOf(jumiomobile/kd, s);
    }

    public static kd[] values()
    {
        return (kd[])e.clone();
    }

    static 
    {
        a = new kd("NO_RESULT", 0);
        b = new kd("RESULT_TOO_FAR_AWAY", 1);
        c = new kd("RESULT_TOO_CLOSE", 2);
        d = new kd("NONE", 3);
        e = (new kd[] {
            a, b, c, d
        });
    }
}
