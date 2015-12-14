// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;


public abstract class <init> extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    private static final f g[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/camera/LiveCategoryCtrl$LiveCategory, s);
    }

    public static <init>[] values()
    {
        return (<init>[])g.clone();
    }

    public abstract int a();

    static 
    {
        a = new LiveCategoryCtrl.LiveCategory("LOOKS", 0) {

            public int a()
            {
                return 0x7f070502;
            }

            public String toString()
            {
                return "LOOKS";
            }

        };
        b = new LiveCategoryCtrl.LiveCategory("EYE_LINER", 1) {

            public int a()
            {
                return 0x7f07033b;
            }

            public String toString()
            {
                return "EYE_LINER";
            }

        };
        c = new LiveCategoryCtrl.LiveCategory("EYELASHES", 2) {

            public int a()
            {
                return 0x7f07033a;
            }

            public String toString()
            {
                return "EYELASHES";
            }

        };
        d = new LiveCategoryCtrl.LiveCategory("EYE_SHADOW", 3) {

            public int a()
            {
                return 0x7f07033c;
            }

            public String toString()
            {
                return "EYE_SHADOW";
            }

        };
        e = new LiveCategoryCtrl.LiveCategory("LIP_COLOR", 4) {

            public int a()
            {
                return 0x7f070345;
            }

            public String toString()
            {
                return "LIP_COLOR";
            }

        };
        f = new LiveCategoryCtrl.LiveCategory("BLUSH", 5) {

            public int a()
            {
                return 0x7f070332;
            }

            public String toString()
            {
                return "BLUSH";
            }

        };
        g = (new g[] {
            a, b, c, d, e, f
        });
    }

    private _cls6(String s, int i)
    {
        super(s, i);
    }

    _cls6(String s, int i, _cls6 _pcls6)
    {
        this(s, i);
    }
}
