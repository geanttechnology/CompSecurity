// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            ank

public final class ang extends Enum
{

    public static final ang a;
    public static final ang b;
    public static final ang c;
    public static final ang d;
    private static final ang e[];

    private ang(String s, int i)
    {
        super(s, i);
    }

    static int a(ank ank1, Object obj)
    {
        if (obj instanceof ank)
        {
            obj = ((ank)obj).getPriority();
        } else
        {
            obj = b;
        }
        return ((ang) (obj)).ordinal() - ank1.getPriority().ordinal();
    }

    public static ang valueOf(String s)
    {
        return (ang)Enum.valueOf(android/support/v7/ang, s);
    }

    public static ang[] values()
    {
        return (ang[])e.clone();
    }

    static 
    {
        a = new ang("LOW", 0);
        b = new ang("NORMAL", 1);
        c = new ang("HIGH", 2);
        d = new ang("IMMEDIATE", 3);
        e = (new ang[] {
            a, b, c, d
        });
    }
}
