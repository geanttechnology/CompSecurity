// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final l a;
    public static final l b;
    public static final l c;
    public static final l d;
    public static final l e;
    public static final l f;
    public static final l g;
    public static final l h;
    public static final l i;
    public static final l j;
    public static final l k;
    public static final l l;
    private static final l m[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLiveCamEvent$Operation, s);
    }

    public static <init>[] values()
    {
        return (<init>[])m.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKLiveCamEvent.Operation("Show", 0) {

            public String a()
            {
                return "show";
            }

        };
        b = new YMKLiveCamEvent.Operation("LooksClick", 1) {

            public String a()
            {
                return "LooksClick";
            }

        };
        c = new YMKLiveCamEvent.Operation("LooksSlip", 2) {

            public String a()
            {
                return "LooksSlip";
            }

        };
        d = new YMKLiveCamEvent.Operation("FeatureClick", 3) {

            public String a()
            {
                return "FeatureClick";
            }

        };
        e = new YMKLiveCamEvent.Operation("FeatureSlip", 4) {

            public String a()
            {
                return "FeatureSlip";
            }

        };
        f = new YMKLiveCamEvent.Operation("Capture", 5) {

            public String a()
            {
                return "Capture";
            }

        };
        g = new YMKLiveCamEvent.Operation("Back", 6) {

            public String a()
            {
                return "Back";
            }

        };
        h = new YMKLiveCamEvent.Operation("Setting", 7) {

            public String a()
            {
                return "Setting";
            }

        };
        i = new YMKLiveCamEvent.Operation("ChangeCamera", 8) {

            public String a()
            {
                return "ChangeCamera";
            }

        };
        j = new YMKLiveCamEvent.Operation("HideEffects", 9) {

            public String a()
            {
                return "HideEffects";
            }

        };
        k = new YMKLiveCamEvent.Operation("Flash", 10) {

            public String a()
            {
                return "Flash";
            }

        };
        l = new YMKLiveCamEvent.Operation("MoreLooks", 11) {

            public String a()
            {
                return "more_looks";
            }

        };
        m = (new m[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l
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
