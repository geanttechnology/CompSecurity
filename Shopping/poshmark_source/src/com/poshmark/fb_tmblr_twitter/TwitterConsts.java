// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;


public final class TwitterConsts extends Enum
{

    private static final TwitterConsts $VALUES[];
    public static final TwitterConsts AccessTokenUrl;
    public static final TwitterConsts AuthorizeUrl;
    public static final TwitterConsts ConsumerKey;
    public static final TwitterConsts ConsumerSecret;
    public static final TwitterConsts RequestUrl;
    private final String value;

    private TwitterConsts(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static TwitterConsts valueOf(String s)
    {
        return (TwitterConsts)Enum.valueOf(com/poshmark/fb_tmblr_twitter/TwitterConsts, s);
    }

    public static TwitterConsts[] values()
    {
        return (TwitterConsts[])$VALUES.clone();
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
        ConsumerKey = new TwitterConsts("ConsumerKey", 0, "kTbA6j5Zi0yX8LS6wT3yHg");
        ConsumerSecret = new TwitterConsts("ConsumerSecret", 1, "koq93pMZSIBsG5U3zOsinGzPU0moy8nt8sbMaGvL68");
        RequestUrl = new TwitterConsts("RequestUrl", 2, "https://api.twitter.com/oauth/request_token");
        AccessTokenUrl = new TwitterConsts("AccessTokenUrl", 3, "https://api.twitter.com/oauth/access_token");
        AuthorizeUrl = new TwitterConsts("AuthorizeUrl", 4, "https://api.twitter.com/oauth/authorize");
        $VALUES = (new TwitterConsts[] {
            ConsumerKey, ConsumerSecret, RequestUrl, AccessTokenUrl, AuthorizeUrl
        });
    }
}
