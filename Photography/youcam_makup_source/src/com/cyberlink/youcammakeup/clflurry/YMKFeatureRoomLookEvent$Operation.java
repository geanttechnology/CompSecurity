// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final j a;
    public static final j b;
    public static final j c;
    public static final j d;
    public static final j e;
    public static final j f;
    public static final j g;
    public static final j h;
    public static final j i;
    public static final j j;
    private static final j k[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKFeatureRoomLookEvent$Operation, s);
    }

    public static <init>[] values()
    {
        return (<init>[])k.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKFeatureRoomLookEvent.Operation("Show", 0) {

            public String a()
            {
                return "show";
            }

        };
        b = new YMKFeatureRoomLookEvent.Operation("Back", 1) {

            public String a()
            {
                return "back";
            }

        };
        c = new YMKFeatureRoomLookEvent.Operation("Apply", 2) {

            public String a()
            {
                return "apply";
            }

        };
        d = new YMKFeatureRoomLookEvent.Operation("FineTune", 3) {

            public String a()
            {
                return "finetune";
            }

        };
        e = new YMKFeatureRoomLookEvent.Operation("Compare", 4) {

            public String a()
            {
                return "compare";
            }

        };
        f = new YMKFeatureRoomLookEvent.Operation("Redo", 5) {

            public String a()
            {
                return "redo";
            }

        };
        g = new YMKFeatureRoomLookEvent.Operation("Undo", 6) {

            public String a()
            {
                return "undo";
            }

        };
        h = new YMKFeatureRoomLookEvent.Operation("Looksclick", 7) {

            public String a()
            {
                return "looksclick";
            }

        };
        i = new YMKFeatureRoomLookEvent.Operation("HowTo", 8) {

            public String a()
            {
                return "how_to";
            }

        };
        j = new YMKFeatureRoomLookEvent.Operation("More", 9) {

            public String a()
            {
                return "more";
            }

        };
        k = (new k[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }

    private _cls9(String s, int l)
    {
        super(s, l);
    }

    _cls9(String s, int l, _cls9 _pcls9)
    {
        this(s, l);
    }
}
