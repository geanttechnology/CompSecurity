// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    private static final i j[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKResultPageEvent$Operation, s);
    }

    public static <init>[] values()
    {
        return (<init>[])j.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKResultPageEvent.Operation("Show", 0) {

            public String a()
            {
                return "show";
            }

        };
        b = new YMKResultPageEvent.Operation("Home", 1) {

            public String a()
            {
                return "home";
            }

        };
        c = new YMKResultPageEvent.Operation("Share", 2) {

            public String a()
            {
                return "share";
            }

        };
        d = new YMKResultPageEvent.Operation("Camera", 3) {

            public String a()
            {
                return "camera";
            }

        };
        e = new YMKResultPageEvent.Operation("YCP_Use", 4) {

            public String a()
            {
                return "ycp_use";
            }

        };
        f = new YMKResultPageEvent.Operation("YCP_Inatall", 5) {

            public String a()
            {
                return "ycp_install";
            }

        };
        g = new YMKResultPageEvent.Operation("B_A_Card", 6) {

            public String a()
            {
                return "b_a_card";
            }

        };
        h = new YMKResultPageEvent.Operation("YCN_Use", 7) {

            public String a()
            {
                return "ycn_use";
            }

        };
        i = new YMKResultPageEvent.Operation("YCN_Install", 8) {

            public String a()
            {
                return "ycn_install";
            }

        };
        j = (new j[] {
            a, b, c, d, e, f, g, h, i
        });
    }

    private _cls9(String s, int k)
    {
        super(s, k);
    }

    _cls9(String s, int k, _cls9 _pcls9)
    {
        this(s, k);
    }
}
