// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner;


public class <init> extends Enum
{

    public static final a a;
    private static final a b[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/banner/BannerRequest$Type, s);
    }

    public static <init>[] values()
    {
        return (<init>[])b.clone();
    }

    static 
    {
        a = new BannerRequest.Type("WEEK_STAR_BANNER", 0) {

            public String toString()
            {
                return "WEEK_STAR_BANNER";
            }

        };
        b = (new b[] {
            a
        });
    }

    private _cls1(String s, int i)
    {
        super(s, i);
    }

    _cls1(String s, int i, _cls1 _pcls1)
    {
        this(s, i);
    }
}
