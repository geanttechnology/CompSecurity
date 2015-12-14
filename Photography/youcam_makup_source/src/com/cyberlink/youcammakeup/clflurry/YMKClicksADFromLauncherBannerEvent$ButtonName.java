// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;


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
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/clflurry/YMKClicksADFromLauncherBannerEvent$ButtonName, s);
    }

    public static <init>[] values()
    {
        return (<init>[])g.clone();
    }

    public abstract String a();

    static 
    {
        a = new YMKClicksADFromLauncherBannerEvent.ButtonName("Cart", 0) {

            public String a()
            {
                return "Cart";
            }

        };
        b = new YMKClicksADFromLauncherBannerEvent.ButtonName("LearnMore", 1) {

            public String a()
            {
                return "LearnMore";
            }

        };
        c = new YMKClicksADFromLauncherBannerEvent.ButtonName("TryIt", 2) {

            public String a()
            {
                return "TryIt";
            }

        };
        d = new YMKClicksADFromLauncherBannerEvent.ButtonName("Back", 3) {

            public String a()
            {
                return "Back";
            }

        };
        e = new YMKClicksADFromLauncherBannerEvent.ButtonName("TakePhoto", 4) {

            public String a()
            {
                return "TakePhoto";
            }

        };
        f = new YMKClicksADFromLauncherBannerEvent.ButtonName("SelectPhoto", 5) {

            public String a()
            {
                return "SelectPhoto";
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
