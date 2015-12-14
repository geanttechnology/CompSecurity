// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;


// Referenced classes of package com.amazon.identity.snds.api:
//            SNDSConstants

public static final class mName extends Enum
{

    private static final WECHAT $VALUES[];
    public static final WECHAT FACEBOOK;
    public static final WECHAT GOOGLE;
    public static final WECHAT LINKED_IN;
    public static final WECHAT PICASA;
    public static final WECHAT SINA_WEIBO;
    public static final WECHAT TWITTER;
    public static final WECHAT WECHAT;
    public static final WECHAT YAHOO;
    private final String mName;
    private final int mValue;

    public static mName valueOf(String s)
    {
        return (mName)Enum.valueOf(com/amazon/identity/snds/api/SNDSConstants$SocialNetworkType, s);
    }

    public static mName[] values()
    {
        return (mName[])$VALUES.clone();
    }

    public int value()
    {
        return mValue;
    }

    static 
    {
        FACEBOOK = new <init>("FACEBOOK", 0, 0, "Facebook");
        TWITTER = new <init>("TWITTER", 1, 1, "Twitter");
        SINA_WEIBO = new <init>("SINA_WEIBO", 2, 2, "SinaWeibo");
        PICASA = new <init>("PICASA", 3, 3, "Picasa");
        GOOGLE = new <init>("GOOGLE", 4, 4, "Google");
        YAHOO = new <init>("YAHOO", 5, 5, "Yahoo");
        LINKED_IN = new <init>("LINKED_IN", 6, 6, "LinkedIn");
        WECHAT = new <init>("WECHAT", 7, 7, "WeChat");
        $VALUES = (new .VALUES[] {
            FACEBOOK, TWITTER, SINA_WEIBO, PICASA, GOOGLE, YAHOO, LINKED_IN, WECHAT
        });
    }

    private (String s, int i, int j, String s1)
    {
        super(s, i);
        mValue = j;
        mName = s1;
    }
}
