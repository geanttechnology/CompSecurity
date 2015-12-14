// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


public abstract class <init> extends Enum
{

    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    public static final k e;
    public static final k f;
    public static final k g;
    public static final k h;
    public static final k i;
    public static final k j;
    public static final k k;
    private static final k l[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKLauncherTileClicksEvent$LauncherTileName, s);
    }

    public static <init>[] values()
    {
        return (<init>[])l.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKLauncherTileClicksEvent.LauncherTileName("Camera", 0) {

            public String a()
            {
                return "Camera";
            }

        };
        b = new YMKLauncherTileClicksEvent.LauncherTileName("LiveMakeup", 1) {

            public String a()
            {
                return "Live Makeup";
            }

        };
        c = new YMKLauncherTileClicksEvent.LauncherTileName("NaturalMakeup", 2) {

            public String a()
            {
                return "Natural Makeup";
            }

        };
        d = new YMKLauncherTileClicksEvent.LauncherTileName("CostumeLooks", 3) {

            public String a()
            {
                return "Costume Looks";
            }

        };
        e = new YMKLauncherTileClicksEvent.LauncherTileName("BeautyCircle", 4) {

            public String a()
            {
                return "Beauty Circle";
            }

        };
        f = new YMKLauncherTileClicksEvent.LauncherTileName("Templates", 5) {

            public String a()
            {
                return "Templates";
            }

        };
        g = new YMKLauncherTileClicksEvent.LauncherTileName("MakeupTips", 6) {

            public String a()
            {
                return "Makeup Tips";
            }

        };
        h = new YMKLauncherTileClicksEvent.LauncherTileName("Setting", 7) {

            public String a()
            {
                return "Setting";
            }

        };
        i = new YMKLauncherTileClicksEvent.LauncherTileName("Notice", 8) {

            public String a()
            {
                return "Notice";
            }

        };
        j = new YMKLauncherTileClicksEvent.LauncherTileName("APPRecommend", 9) {

            public String a()
            {
                return "APP Recommend";
            }

        };
        k = new YMKLauncherTileClicksEvent.LauncherTileName("AD", 10) {

            public String a()
            {
                return "AD";
            }

        };
        l = (new l[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
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
