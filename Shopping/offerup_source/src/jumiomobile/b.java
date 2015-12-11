// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class b
{

    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    public static final b f;
    private static b g[];
    private static int h = 0;
    private final int i;
    private final String j;

    private b(String s)
    {
        j = s;
        int k = h;
        h = k + 1;
        i = k;
    }

    public final int a()
    {
        return i;
    }

    public final String toString()
    {
        return j;
    }

    static 
    {
        a = new b("PIXEL_FORMAT_RGB_8");
        b = new b("PIXEL_FORMAT_RGBA_8");
        c = new b("PIXEL_FORMAT_BGR_8");
        d = new b("PIXEL_FORMAT_BGRA_8");
        e = new b("PIXEL_FORMAT_YUV420_NV21");
        f = new b("PIXEL_FORMAT_GRAY");
        g = (new b[] {
            a, b, c, d, e, f
        });
    }
}
