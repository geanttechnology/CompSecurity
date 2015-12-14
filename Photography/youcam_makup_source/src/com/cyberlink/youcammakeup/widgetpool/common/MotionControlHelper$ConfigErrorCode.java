// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;


public final class  extends Enum
{

    public static final D A;
    public static final D B;
    public static final D C;
    public static final D D;
    private static final D E[];
    public static final D a;
    public static final D b;
    public static final D c;
    public static final D d;
    public static final D e;
    public static final D f;
    public static final D g;
    public static final D h;
    public static final D i;
    public static final D j;
    public static final D k;
    public static final D l;
    public static final D m;
    public static final D n;
    public static final D o;
    public static final D p;
    public static final D q;
    public static final D r;
    public static final D s;
    public static final D t;
    public static final D u;
    public static final D v;
    public static final D w;
    public static final D x;
    public static final D y;
    public static final D z;

    public static  valueOf(String s1)
    {
        return ()Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/common/MotionControlHelper$ConfigErrorCode, s1);
    }

    public static [] values()
    {
        return ([])E.clone();
    }

    static 
    {
        a = new <init>("NONE", 0);
        b = new <init>("DUMP_CACHE_FAILED", 1);
        c = new <init>("CONTROL_SETTING_INVALID", 2);
        d = new <init>("EYESHADOW_SETTING_INVALID", 3);
        e = new <init>("EYECONTACT_SETTING_INVALID", 4);
        f = new <init>("EYEBROW_SETTING_INVALID", 5);
        g = new <init>("EYELASH_SETTING_INVALID", 6);
        h = new <init>("EYELASH_MASK_INVALID", 7);
        i = new <init>("EYELINE_SETTING_INVALID", 8);
        j = new <init>("EYELINE_MASK_INVALID", 9);
        k = new <init>("BLUSH_SETTING_INVALID", 10);
        l = new <init>("BLUSH_MASK_INVALID", 11);
        m = new <init>("DOUBLE_EYELID_SETTING_INVALID", 12);
        n = new <init>("DOUBLE_EYELID_MASK_INVALID", 13);
        o = new <init>("LIPSTICK_SETTING_INVALID", 14);
        p = new <init>("MOUTH_NOT_OPEN", 15);
        q = new <init>("SKIN_TONER_SETTING_INVALID", 16);
        r = new <init>("WIG_SETTING_INVALID", 17);
        s = new <init>("WIG_MASK_INVALID", 18);
        t = new <init>("EYEWEAR_SETTING_INVALID", 19);
        u = new <init>("EYEWEAR_MASK_INVALID", 20);
        v = new <init>("HAIRBAND_SETTING_INVALID", 21);
        w = new <init>("HAIRBAHD_MASK_INVALID", 22);
        x = new <init>("NECKLACE_SETTING_INVALID", 23);
        y = new <init>("NECKLACE_MASK_INVALID", 24);
        z = new <init>("EARRING_SETTING_INVALID", 25);
        A = new <init>("EARRING_MASK_INVALID", 26);
        B = new <init>("HAIRDYE_SETTING_INVALID", 27);
        C = new <init>("CONFIG_FACE_ART_ERROR", 28);
        D = new <init>("CONFIG_FACE_WIDGET_ERROR", 29);
        E = (new E[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C, D
        });
    }

    private (String s1, int i1)
    {
        super(s1, i1);
    }
}
