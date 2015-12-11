// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            hp

public final class hq extends Enum
{

    public static final hq a;
    public static final hq b;
    public static final hq c;
    public static final hq d;
    public static final hq e;
    public static final hq f;
    public static final hq g;
    public static final hq h;
    public static final hq i;
    public static final hq j;
    public static final hq k;
    public static final hq l;
    public static final hq m;
    private static final hq o[];
    private hp n;

    private hq(String s, int i1, hp hp1)
    {
        super(s, i1);
        n = hp1;
    }

    public static hq valueOf(String s)
    {
        return (hq)Enum.valueOf(jumiomobile/hq, s);
    }

    public static hq[] values()
    {
        return (hq[])o.clone();
    }

    public final hp a()
    {
        return n;
    }

    static 
    {
        a = new hq("MRP", 0, hp.d);
        b = new hq("MRV", 1, hp.d);
        c = new hq("TD1", 2, hp.b);
        d = new hq("TD2", 3, hp.c);
        e = new hq("CNIS", 4, hp.c);
        f = new hq("PDF417", 5, hp.b);
        g = new hq("STANDALONE_BARCODE", 6, hp.b);
        h = new hq("CSSN", 7, hp.b);
        i = new hq("PICTURE_LINEFIND", 8, hp.b);
        j = new hq("FACE", 9, hp.a);
        k = new hq("FACE_LIVENESS", 10, hp.a);
        l = new hq("MANUAL", 11, hp.a);
        m = new hq("TEMPLATEMATCHER", 12, hp.b);
        o = (new hq[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m
        });
    }
}
