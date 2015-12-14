// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;


public final class  extends Enum
{

    private static final SHARE_QQZONE $VALUES[];
    public static final SHARE_QQZONE SHARE_FB;
    public static final SHARE_QQZONE SHARE_INSTAGRAM;
    public static final SHARE_QQZONE SHARE_LINE;
    public static final SHARE_QQZONE SHARE_MOMENT;
    public static final SHARE_QQZONE SHARE_QQ;
    public static final SHARE_QQZONE SHARE_QQZONE;
    public static final SHARE_QQZONE SHARE_SINA;
    public static final SHARE_QQZONE SHARE_TWITTER;
    public static final SHARE_QQZONE SHARE_WECHAT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/beautyui/gpuimage/sample/activity/CustomShareUtil$EnumRecentShare, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SHARE_WECHAT = new <init>("SHARE_WECHAT", 0);
        SHARE_QQ = new <init>("SHARE_QQ", 1);
        SHARE_LINE = new <init>("SHARE_LINE", 2);
        SHARE_FB = new <init>("SHARE_FB", 3);
        SHARE_INSTAGRAM = new <init>("SHARE_INSTAGRAM", 4);
        SHARE_SINA = new <init>("SHARE_SINA", 5);
        SHARE_TWITTER = new <init>("SHARE_TWITTER", 6);
        SHARE_MOMENT = new <init>("SHARE_MOMENT", 7);
        SHARE_QQZONE = new <init>("SHARE_QQZONE", 8);
        $VALUES = (new .VALUES[] {
            SHARE_WECHAT, SHARE_QQ, SHARE_LINE, SHARE_FB, SHARE_INSTAGRAM, SHARE_SINA, SHARE_TWITTER, SHARE_MOMENT, SHARE_QQZONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
