// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner;


public class <init> extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/banner/GetPromotionBannerResponse$PromotionBanner$Scheme, s);
    }

    public static <init>[] values()
    {
        return (<init>[])d.clone();
    }

    static 
    {
        a = new GetPromotionBannerResponse.PromotionBanner.Scheme("UNKNOWN", 0) {

            public String toString()
            {
                return "[unknown]";
            }

        };
        b = new GetPromotionBannerResponse.PromotionBanner.Scheme("YMK", 1) {

            public String toString()
            {
                return "ymk://";
            }

        };
        c = new GetPromotionBannerResponse.PromotionBanner.Scheme("HTTP", 2) {

            public String toString()
            {
                return "http://";
            }

        };
        d = (new d[] {
            a, b, c
        });
    }

    private _cls3(String s, int i)
    {
        super(s, i);
    }

    _cls3(String s, int i, _cls3 _pcls3)
    {
        this(s, i);
    }
}
