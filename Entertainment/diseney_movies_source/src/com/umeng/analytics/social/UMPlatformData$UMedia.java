// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;


// Referenced classes of package com.umeng.analytics.social:
//            UMPlatformData

public static class <init> extends Enum
{

    public static final DOUBAN DOUBAN;
    public static final DOUBAN RENREN;
    public static final DOUBAN SINA_WEIBO;
    public static final DOUBAN TENCENT_QQ;
    public static final DOUBAN TENCENT_QZONE;
    public static final DOUBAN TENCENT_WEIBO;
    public static final DOUBAN WEIXIN_CIRCLE;
    public static final DOUBAN WEIXIN_FRIENDS;
    private static final DOUBAN a[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/umeng/analytics/social/UMPlatformData$UMedia, s);
    }

    public static <init>[] values()
    {
        <init> a_3C_init>[] = a;
        int i = a_3C_init>.length;
        <init> a_3C_init>1[] = new a[i];
        System.arraycopy(a_3C_init>, 0, a_3C_init>1, 0, i);
        return a_3C_init>1;
    }

    static 
    {
        SINA_WEIBO = new UMPlatformData.UMedia("SINA_WEIBO", 0) {

            public String toString()
            {
                return "sina";
            }

        };
        TENCENT_WEIBO = new UMPlatformData.UMedia("TENCENT_WEIBO", 1) {

            public String toString()
            {
                return "tencent";
            }

        };
        TENCENT_QZONE = new UMPlatformData.UMedia("TENCENT_QZONE", 2) {

            public String toString()
            {
                return "qzone";
            }

        };
        TENCENT_QQ = new UMPlatformData.UMedia("TENCENT_QQ", 3) {

            public String toString()
            {
                return "qq";
            }

        };
        WEIXIN_FRIENDS = new UMPlatformData.UMedia("WEIXIN_FRIENDS", 4) {

            public String toString()
            {
                return "wxsesion";
            }

        };
        WEIXIN_CIRCLE = new UMPlatformData.UMedia("WEIXIN_CIRCLE", 5) {

            public String toString()
            {
                return "wxtimeline";
            }

        };
        RENREN = new UMPlatformData.UMedia("RENREN", 6) {

            public String toString()
            {
                return "renren";
            }

        };
        DOUBAN = new UMPlatformData.UMedia("DOUBAN", 7) {

            public String toString()
            {
                return "douban";
            }

        };
        a = (new a[] {
            SINA_WEIBO, TENCENT_WEIBO, TENCENT_QZONE, TENCENT_QQ, WEIXIN_FRIENDS, WEIXIN_CIRCLE, RENREN, DOUBAN
        });
    }

    private _cls8(String s, int i)
    {
        super(s, i);
    }

    _cls8(String s, int i, _cls8 _pcls8)
    {
        this(s, i);
    }
}
