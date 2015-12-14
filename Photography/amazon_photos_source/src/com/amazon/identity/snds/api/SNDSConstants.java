// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;


public final class SNDSConstants
{
    public static final class SocialNetworkType extends Enum
    {

        private static final SocialNetworkType $VALUES[];
        public static final SocialNetworkType FACEBOOK;
        public static final SocialNetworkType GOOGLE;
        public static final SocialNetworkType LINKED_IN;
        public static final SocialNetworkType PICASA;
        public static final SocialNetworkType SINA_WEIBO;
        public static final SocialNetworkType TWITTER;
        public static final SocialNetworkType WECHAT;
        public static final SocialNetworkType YAHOO;
        private final String mName;
        private final int mValue;

        public static SocialNetworkType valueOf(String s)
        {
            return (SocialNetworkType)Enum.valueOf(com/amazon/identity/snds/api/SNDSConstants$SocialNetworkType, s);
        }

        public static SocialNetworkType[] values()
        {
            return (SocialNetworkType[])$VALUES.clone();
        }

        public int value()
        {
            return mValue;
        }

        static 
        {
            FACEBOOK = new SocialNetworkType("FACEBOOK", 0, 0, "Facebook");
            TWITTER = new SocialNetworkType("TWITTER", 1, 1, "Twitter");
            SINA_WEIBO = new SocialNetworkType("SINA_WEIBO", 2, 2, "SinaWeibo");
            PICASA = new SocialNetworkType("PICASA", 3, 3, "Picasa");
            GOOGLE = new SocialNetworkType("GOOGLE", 4, 4, "Google");
            YAHOO = new SocialNetworkType("YAHOO", 5, 5, "Yahoo");
            LINKED_IN = new SocialNetworkType("LINKED_IN", 6, 6, "LinkedIn");
            WECHAT = new SocialNetworkType("WECHAT", 7, 7, "WeChat");
            $VALUES = (new SocialNetworkType[] {
                FACEBOOK, TWITTER, SINA_WEIBO, PICASA, GOOGLE, YAHOO, LINKED_IN, WECHAT
            });
        }

        private SocialNetworkType(String s, int i, int j, String s1)
        {
            super(s, i);
            mValue = j;
            mName = s1;
        }
    }

}
