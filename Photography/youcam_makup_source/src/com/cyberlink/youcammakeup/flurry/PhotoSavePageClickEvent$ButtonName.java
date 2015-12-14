// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;


public abstract class <init> extends Enum
{

    public static final p a;
    public static final p b;
    public static final p c;
    public static final p d;
    public static final p e;
    public static final p f;
    public static final p g;
    public static final p h;
    public static final p i;
    public static final p j;
    public static final p k;
    public static final p l;
    public static final p m;
    public static final p n;
    public static final p o;
    public static final p p;
    private static final p q[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/flurry/PhotoSavePageClickEvent$ButtonName, s);
    }

    public static <init>[] values()
    {
        return (<init>[])q.clone();
    }

    public abstract String a();

    static 
    {
        a = new PhotoSavePageClickEvent.ButtonName("Back", 0) {

            public String a()
            {
                return "Back";
            }

        };
        b = new PhotoSavePageClickEvent.ButtonName("Home", 1) {

            public String a()
            {
                return "Home";
            }

        };
        c = new PhotoSavePageClickEvent.ButtonName("MakeupCam", 2) {

            public String a()
            {
                return "Makeup Cam";
            }

        };
        d = new PhotoSavePageClickEvent.ButtonName("Library", 3) {

            public String a()
            {
                return "Library";
            }

        };
        e = new PhotoSavePageClickEvent.ButtonName("BeforeAndAfter", 4) {

            public String a()
            {
                return "Before And After";
            }

        };
        f = new PhotoSavePageClickEvent.ButtonName("PhotoEdit", 5) {

            public String a()
            {
                return "Photo Edit";
            }

        };
        g = new PhotoSavePageClickEvent.ButtonName("Collage", 6) {

            public String a()
            {
                return "Collage";
            }

        };
        h = new PhotoSavePageClickEvent.ButtonName("BeautyCircle", 7) {

            public String a()
            {
                return "Beauty Circle";
            }

        };
        i = new PhotoSavePageClickEvent.ButtonName("U", 8) {

            public String a()
            {
                return "U";
            }

        };
        j = new PhotoSavePageClickEvent.ButtonName("Facebook", 9) {

            public String a()
            {
                return "Facebook";
            }

        };
        k = new PhotoSavePageClickEvent.ButtonName("WhatsApp", 10) {

            public String a()
            {
                return "What's App";
            }

        };
        l = new PhotoSavePageClickEvent.ButtonName("Instagram", 11) {

            public String a()
            {
                return "Instagram";
            }

        };
        m = new PhotoSavePageClickEvent.ButtonName("WeChat", 12) {

            public String a()
            {
                return "WeChat";
            }

        };
        n = new PhotoSavePageClickEvent.ButtonName("WeChatMoment", 13) {

            public String a()
            {
                return "WeChatMoment";
            }

        };
        o = new PhotoSavePageClickEvent.ButtonName("Line", 14) {

            public String a()
            {
                return "Line";
            }

        };
        p = new PhotoSavePageClickEvent.ButtonName("More", 15) {

            public String a()
            {
                return "More";
            }

        };
        q = (new q[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p
        });
    }

    private _cls9(String s, int i1)
    {
        super(s, i1);
    }

    _cls9(String s, int i1, _cls9 _pcls9)
    {
        this(s, i1);
    }
}
