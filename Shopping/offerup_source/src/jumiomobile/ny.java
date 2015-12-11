// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class ny extends Enum
{

    public static final ny a;
    public static final ny b;
    public static final ny c;
    public static final ny d;
    public static final ny e;
    public static final ny f;
    public static final ny g;
    public static final ny h;
    public static final ny i;
    public static final ny j;
    private static final ny k[];

    private ny(String s, int l)
    {
        super(s, l);
    }

    public static ny valueOf(String s)
    {
        return (ny)Enum.valueOf(jumiomobile/ny, s);
    }

    public static ny[] values()
    {
        return (ny[])k.clone();
    }

    static 
    {
        a = new ny("BLACK", 0);
        b = new ny("BLUE", 1);
        c = new ny("BROWN", 2);
        d = new ny("GRAY", 3);
        e = new ny("GREEN", 4);
        f = new ny("HAZEL", 5);
        g = new ny("MAROON", 6);
        h = new ny("PINK", 7);
        i = new ny("DICHROMATIC", 8);
        j = new ny("UNKNOWN", 9);
        k = (new ny[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
