// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;


public final class TumblrConsts extends Enum
{

    private static final TumblrConsts $VALUES[];
    public static final TumblrConsts AccessTokenUrl;
    public static final TumblrConsts AuthorizeUrl;
    public static final TumblrConsts ConsumerKey;
    public static final TumblrConsts ConsumerSecret;
    public static final TumblrConsts RequestUrl;
    private final String value;

    private TumblrConsts(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static TumblrConsts valueOf(String s)
    {
        return (TumblrConsts)Enum.valueOf(com/poshmark/fb_tmblr_twitter/TumblrConsts, s);
    }

    public static TumblrConsts[] values()
    {
        return (TumblrConsts[])$VALUES.clone();
    }

    public String getValue()
    {
        return value;
    }

    public String toString()
    {
        return getValue();
    }

    static 
    {
        ConsumerKey = new TumblrConsts("ConsumerKey", 0, "DjPW0QuHLfatyEJs5ss8NzgaIhcgB1uHv27mvfl4wsOQ3HBnqb");
        ConsumerSecret = new TumblrConsts("ConsumerSecret", 1, "v00N3KJBNwnYFVKvWtPBBT75IWkitMpFSB7SBrgoOgNdHJeDcI");
        RequestUrl = new TumblrConsts("RequestUrl", 2, "https://www.tumblr.com/oauth/request_token");
        AccessTokenUrl = new TumblrConsts("AccessTokenUrl", 3, "https://www.tumblr.com/oauth/access_token");
        AuthorizeUrl = new TumblrConsts("AuthorizeUrl", 4, "https://www.tumblr.com/oauth/authorize");
        $VALUES = (new TumblrConsts[] {
            ConsumerKey, ConsumerSecret, RequestUrl, AccessTokenUrl, AuthorizeUrl
        });
    }
}
