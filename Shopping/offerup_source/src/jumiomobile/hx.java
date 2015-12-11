// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.Map;
import java.util.TreeMap;

public final class hx extends Enum
{

    public static final hx a;
    public static final hx b;
    public static final hx c;
    public static final hx d;
    public static final hx e;
    public static final hx f;
    private static final Map h;
    private static final hx i[];
    private final int g;

    private hx(String s, int j, int k)
    {
        super(s, j);
        g = k;
    }

    public static hx a(int j)
    {
        return (hx)h.get(Integer.valueOf(j));
    }

    public static hx valueOf(String s)
    {
        return (hx)Enum.valueOf(jumiomobile/hx, s);
    }

    public static hx[] values()
    {
        return (hx[])i.clone();
    }

    static 
    {
        int j = 0;
        a = new hx("SUCCESS", 0, 1);
        b = new hx("FAIL", 1, 2);
        c = new hx("CAMERA_TOO_HIGH", 2, 4);
        d = new hx("QR_SUCCESS", 3, 8);
        e = new hx("PARTIAL_OBJECT", 4, 64);
        f = new hx("CAMERA_AT_ANGLE", 5, 128);
        i = (new hx[] {
            a, b, c, d, e, f
        });
        h = new TreeMap();
        for (; j < values().length; j++)
        {
            int k = values()[j].g;
            hx hx1 = values()[j];
            h.put(Integer.valueOf(k), hx1);
        }

    }
}
