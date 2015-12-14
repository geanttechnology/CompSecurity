// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final n a;
    public static final n b;
    public static final n c;
    public static final n d;
    public static final n e;
    public static final n f;
    public static final n g;
    public static final n h;
    public static final n i;
    public static final n j;
    public static final n k;
    public static final n l;
    public static final n m;
    public static final n n;
    private static final n o[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLauncherEvent$TileType, s);
    }

    public static <init>[] values()
    {
        return (<init>[])o.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKLauncherEvent.TileType("Cam", 0) {

            public String a()
            {
                return "Cam";
            }

        };
        b = new YMKLauncherEvent.TileType("Natural", 1) {

            public String a()
            {
                return "Natural";
            }

        };
        c = new YMKLauncherEvent.TileType("Looks", 2) {

            public String a()
            {
                return "Looks";
            }

        };
        d = new YMKLauncherEvent.TileType("Costume", 3) {

            public String a()
            {
                return "Costume";
            }

        };
        e = new YMKLauncherEvent.TileType("YCP", 4) {

            public String a()
            {
                return "ycp";
            }

        };
        f = new YMKLauncherEvent.TileType("YCN", 5) {

            public String a()
            {
                return "ycn";
            }

        };
        g = new YMKLauncherEvent.TileType("Tips", 6) {

            public String a()
            {
                return "Tips";
            }

        };
        h = new YMKLauncherEvent.TileType("BC", 7) {

            public String a()
            {
                return "BC";
            }

        };
        i = new YMKLauncherEvent.TileType("Notice", 8) {

            public String a()
            {
                return "Notice";
            }

        };
        j = new YMKLauncherEvent.TileType("Recom", 9) {

            public String a()
            {
                return "Recom";
            }

        };
        k = new YMKLauncherEvent.TileType("Setting", 10) {

            public String a()
            {
                return "Setting";
            }

        };
        l = new YMKLauncherEvent.TileType("Banner", 11) {

            public String a()
            {
                return "Banner";
            }

        };
        m = new YMKLauncherEvent.TileType("Launcher", 12) {

            public String a()
            {
                return "Launcher";
            }

        };
        n = new YMKLauncherEvent.TileType("WeeklyStar", 13) {

            public String a()
            {
                return "weeklystar";
            }

        };
        o = (new o[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n
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
