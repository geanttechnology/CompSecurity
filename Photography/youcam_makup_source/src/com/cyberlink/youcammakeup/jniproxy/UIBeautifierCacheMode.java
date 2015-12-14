// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            n

public final class UIBeautifierCacheMode extends Enum
{

    public static final UIBeautifierCacheMode a;
    public static final UIBeautifierCacheMode b;
    public static final UIBeautifierCacheMode c;
    public static final UIBeautifierCacheMode d;
    public static final UIBeautifierCacheMode e;
    public static final UIBeautifierCacheMode f;
    public static final UIBeautifierCacheMode g;
    public static final UIBeautifierCacheMode h;
    public static final UIBeautifierCacheMode i;
    public static final UIBeautifierCacheMode j;
    public static final UIBeautifierCacheMode k;
    public static final UIBeautifierCacheMode l;
    public static final UIBeautifierCacheMode m;
    public static final UIBeautifierCacheMode n;
    public static final UIBeautifierCacheMode o;
    public static final UIBeautifierCacheMode p;
    public static final UIBeautifierCacheMode q;
    public static final UIBeautifierCacheMode r;
    public static final UIBeautifierCacheMode s;
    public static final UIBeautifierCacheMode t;
    public static final UIBeautifierCacheMode u;
    public static final UIBeautifierCacheMode v;
    public static final UIBeautifierCacheMode w;
    public static final UIBeautifierCacheMode x;
    public static final UIBeautifierCacheMode y;
    private static final UIBeautifierCacheMode z[];
    private final int swigValue = com.cyberlink.youcammakeup.jniproxy.n.a();

    private UIBeautifierCacheMode(String s1, int i1)
    {
        super(s1, i1);
    }

    public static UIBeautifierCacheMode valueOf(String s1)
    {
        return (UIBeautifierCacheMode)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/UIBeautifierCacheMode, s1);
    }

    public static UIBeautifierCacheMode[] values()
    {
        return (UIBeautifierCacheMode[])z.clone();
    }

    public final int a()
    {
        return swigValue;
    }

    static 
    {
        a = new UIBeautifierCacheMode("NONE", 0);
        b = new UIBeautifierCacheMode("EYE_WHITENING", 1);
        c = new UIBeautifierCacheMode("RED_EYE_REMOVAL", 2);
        d = new UIBeautifierCacheMode("BLUSH", 3);
        e = new UIBeautifierCacheMode("EYE_ENLARGEMENT", 4);
        f = new UIBeautifierCacheMode("EYE_SPARKLE", 5);
        g = new UIBeautifierCacheMode("EYE_BAG_REMOVAL", 6);
        h = new UIBeautifierCacheMode("FACE_THINNING", 7);
        i = new UIBeautifierCacheMode("TEETH_WHITENING", 8);
        j = new UIBeautifierCacheMode("SKIN_TONE", 9);
        k = new UIBeautifierCacheMode("SPOT_REMOVAL", 10);
        l = new UIBeautifierCacheMode("ANTI_SHINE", 11);
        m = new UIBeautifierCacheMode("SKIN_SMOOTH", 12);
        n = new UIBeautifierCacheMode("FACE_CONTOUR", 13);
        o = new UIBeautifierCacheMode("SKIN_WHITENING", 14);
        p = new UIBeautifierCacheMode("NOSE_ENHANCEMENT", 15);
        q = new UIBeautifierCacheMode("EYEBROW_MAKEUP", 16);
        r = new UIBeautifierCacheMode("EYE_MAKEUP", 17);
        s = new UIBeautifierCacheMode("LIPSTICK", 18);
        t = new UIBeautifierCacheMode("EYE_CONTACT", 19);
        u = new UIBeautifierCacheMode("WIG", 20);
        v = new UIBeautifierCacheMode("HAIR_DYE", 21);
        w = new UIBeautifierCacheMode("DOUBLE_EYELID", 22);
        x = new UIBeautifierCacheMode("FACE_ART", 23);
        y = new UIBeautifierCacheMode("FACE_WIDGET", 24);
        z = (new UIBeautifierCacheMode[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y
        });
    }
}
