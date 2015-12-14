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
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKSavingPageEvent$Source, s);
    }

    public static <init>[] values()
    {
        return (<init>[])h.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKSavingPageEvent.Source("LiveCam", 0) {

            public String a()
            {
                return "liveCam";
            }

        };
        b = new YMKSavingPageEvent.Source("LivePhoto", 1) {

            public String a()
            {
                return "livePhoto";
            }

        };
        c = new YMKSavingPageEvent.Source("Natural", 2) {

            public String a()
            {
                return "natural";
            }

        };
        d = new YMKSavingPageEvent.Source("Costume", 3) {

            public String a()
            {
                return "costume";
            }

        };
        e = new YMKSavingPageEvent.Source("ResultPageLib", 4) {

            public String a()
            {
                return "resultpageLib";
            }

        };
        f = new YMKSavingPageEvent.Source("StoreNatural", 5) {

            public String a()
            {
                return "store_natural";
            }

        };
        g = new YMKSavingPageEvent.Source("StoreCostume", 6) {

            public String a()
            {
                return "store_costume";
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
