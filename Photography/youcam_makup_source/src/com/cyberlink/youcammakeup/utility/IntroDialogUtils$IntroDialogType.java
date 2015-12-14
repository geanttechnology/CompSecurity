// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;


public final class I extends Enum
{

    public static final O A;
    public static final O B;
    public static final O C;
    public static final O D;
    public static final O E;
    public static final O F;
    public static final O G;
    public static final O H;
    public static final O I;
    public static final O J;
    public static final O K;
    public static final O L;
    public static final O M;
    public static final O N;
    public static final O O;
    private static final O P[];
    public static final O a;
    public static final O b;
    public static final O c;
    public static final O d;
    public static final O e;
    public static final O f;
    public static final O g;
    public static final O h;
    public static final O i;
    public static final O j;
    public static final O k;
    public static final O l;
    public static final O m;
    public static final O n;
    public static final O o;
    public static final O p;
    public static final O q;
    public static final O r;
    public static final O s;
    public static final O t;
    public static final O u;
    public static final O v;
    public static final O w;
    public static final O x;
    public static final O y;
    public static final O z;

    public static I valueOf(String s1)
    {
        return (I)Enum.valueOf(com/cyberlink/youcammakeup/utility/IntroDialogUtils$IntroDialogType, s1);
    }

    public static I[] values()
    {
        return (I[])P.clone();
    }

    static 
    {
        a = new <init>("LOOKS", 0);
        b = new <init>("BLUSH", 1);
        c = new <init>("BLUSH_SKU", 2);
        d = new <init>("SKIN_TONER", 3);
        e = new <init>("SKIN_TONER_SKU", 4);
        f = new <init>("SHINE_REMOVAL", 5);
        g = new <init>("SKIN_SMOOTHENER", 6);
        h = new <init>("BLEMISH_REMOVAL", 7);
        i = new <init>("CONTOUR_NOSE", 8);
        j = new <init>("COUNTOUR_FACE", 9);
        k = new <init>("FACE_RESHAPER", 10);
        l = new <init>("FACE_RESHAPER_MANUAL", 11);
        m = new <init>("EYE_LINES", 12);
        n = new <init>("EYE_LINES_SKU", 13);
        o = new <init>("EYE_LASHES", 14);
        p = new <init>("EYE_LASHES_SKU", 15);
        q = new <init>("EYE_SHADOW", 16);
        r = new <init>("EYE_ENLARGER", 17);
        s = new <init>("EYE_SPARKLE", 18);
        t = new <init>("EYE_BAG_REMOVAL", 19);
        u = new <init>("RED_EYE_REMOVAL", 20);
        v = new <init>("EYE_BROW", 21);
        w = new <init>("EYE_BROW_SKU", 22);
        x = new <init>("EYE_CONTACT", 23);
        y = new <init>("EYE_CONTACT_SKU", 24);
        z = new <init>("DOUBLE_EYELID", 25);
        A = new <init>("LIP_STICK", 26);
        B = new <init>("LIP_STICK_SKU", 27);
        C = new <init>("TEETH_WHITENER", 28);
        D = new <init>("WIG", 29);
        E = new <init>("CAMERA_DETECT_HINT", 30);
        F = new <init>("CAMERA_GESTURE_HINT", 31);
        G = new <init>("CAMERA_LIVE_MAKEUP_HINT", 32);
        H = new <init>("EYE_WEAR", 33);
        I = new <init>("HAIR_BAND", 34);
        J = new <init>("NECKLACE", 35);
        K = new <init>("EARRINGS", 36);
        L = new <init>("HAIR_DYE", 37);
        M = new <init>("HAIR_DYE_BRUSH", 38);
        N = new <init>("FACE_ART", 39);
        O = new <init>("MUSTACHE", 40);
        P = (new P[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C, D, 
            E, F, G, H, I, J, K, L, M, N, 
            O
        });
    }

    private I(String s1, int i1)
    {
        super(s1, i1);
    }
}
