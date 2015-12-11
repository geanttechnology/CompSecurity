// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;


// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            TumblrHelper

public static final class  extends Enum
{

    private static final TUMBLR $VALUES[];
    public static final TUMBLR TUMBLR;
    public static final TUMBLR TWITTER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TWITTER = new <init>("TWITTER", 0);
        TUMBLR = new <init>("TUMBLR", 1);
        $VALUES = (new .VALUES[] {
            TWITTER, TUMBLR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
