// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    private static final g h[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKAfterSavePhotoEvent$FeatureName, s);
    }

    public static <init>[] values()
    {
        return (<init>[])h.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKAfterSavePhotoEvent.FeatureName("U", 0) {

            public String a()
            {
                return "U";
            }

        };
        b = new YMKAfterSavePhotoEvent.FeatureName("YouCamPerfectEdit", 1) {

            public String a()
            {
                return "YouCam Perfect Edit";
            }

        };
        c = new YMKAfterSavePhotoEvent.FeatureName("YouCamPerfectCollage", 2) {

            public String a()
            {
                return "YouCam Perfect Collage";
            }

        };
        d = new YMKAfterSavePhotoEvent.FeatureName("BeautyCircle", 3) {

            public String a()
            {
                return "Beauty Circle";
            }

        };
        e = new YMKAfterSavePhotoEvent.FeatureName("Share", 4) {

            public String a()
            {
                return "Share";
            }

        };
        f = new YMKAfterSavePhotoEvent.FeatureName("Home", 5) {

            public String a()
            {
                return "Home";
            }

        };
        g = new YMKAfterSavePhotoEvent.FeatureName("Close", 6) {

            public String a()
            {
                return "Close";
            }

        };
        h = (new h[] {
            a, b, c, d, e, f, g
        });
    }

    private _cls7(String s, int i)
    {
        super(s, i);
    }

    _cls7(String s, int i, _cls7 _pcls7)
    {
        this(s, i);
    }
}
