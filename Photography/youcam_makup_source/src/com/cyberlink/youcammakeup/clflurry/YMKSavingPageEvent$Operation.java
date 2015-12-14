// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


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
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKSavingPageEvent$Operation, s);
    }

    public static <init>[] values()
    {
        return (<init>[])q.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKSavingPageEvent.Operation("Back", 0) {

            public String a()
            {
                return "back";
            }

        };
        b = new YMKSavingPageEvent.Operation("SavePhoto", 1) {

            public String a()
            {
                return "savephoto";
            }

        };
        c = new YMKSavingPageEvent.Operation("Compare", 2) {

            public String a()
            {
                return "compare";
            }

        };
        d = new YMKSavingPageEvent.Operation("SaveMyLook", 3) {

            public String a()
            {
                return "saveMyLook";
            }

        };
        e = new YMKSavingPageEvent.Operation("Show", 4) {

            public String a()
            {
                return "show";
            }

        };
        f = new YMKSavingPageEvent.Operation("Detect", 5) {

            public String a()
            {
                return "detect";
            }

        };
        g = new YMKSavingPageEvent.Operation("Tab_Looks", 6) {

            public String a()
            {
                return "tab_looks";
            }

        };
        h = new YMKSavingPageEvent.Operation("Tab_FeatureRoom", 7) {

            public String a()
            {
                return "tab_featureroom";
            }

        };
        i = new YMKSavingPageEvent.Operation("Tab_Natural", 8) {

            public String a()
            {
                return "tab_natural";
            }

        };
        j = new YMKSavingPageEvent.Operation("Tab_Costume", 9) {

            public String a()
            {
                return "tab_costume";
            }

        };
        k = new YMKSavingPageEvent.Operation("FineTune", 10) {

            public String a()
            {
                return "finetune";
            }

        };
        l = new YMKSavingPageEvent.Operation("Redo", 11) {

            public String a()
            {
                return "redo";
            }

        };
        m = new YMKSavingPageEvent.Operation("Undo", 12) {

            public String a()
            {
                return "undo";
            }

        };
        n = new YMKSavingPageEvent.Operation("LooksClick", 13) {

            public String a()
            {
                return "looksclick";
            }

        };
        o = new YMKSavingPageEvent.Operation("HowTo", 14) {

            public String a()
            {
                return "how_to";
            }

        };
        p = new YMKSavingPageEvent.Operation("More", 15) {

            public String a()
            {
                return "more";
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
