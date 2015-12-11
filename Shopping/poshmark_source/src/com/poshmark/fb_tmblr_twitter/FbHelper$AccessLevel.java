// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;


// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            FbHelper

public static final class  extends Enum
{

    private static final ACCESS_LEVEL_PUBLISH $VALUES[];
    public static final ACCESS_LEVEL_PUBLISH ACCESS_LEVEL_PUBLISH;
    public static final ACCESS_LEVEL_PUBLISH ACCESS_LEVEL_READ;
    public static final ACCESS_LEVEL_PUBLISH ACCESS_LEVEL_READ_PLUS_EMAIL;
    public static final ACCESS_LEVEL_PUBLISH ACCESS_LEVEL_READ_PLUS_EMAIL_PLUS_FRIENDS;
    public static final ACCESS_LEVEL_PUBLISH ACCESS_LEVEL_READ_PLUS_FRIENDS;
    public static final ACCESS_LEVEL_PUBLISH ACCESS_LEVEL_UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ACCESS_LEVEL_UNKNOWN = new <init>("ACCESS_LEVEL_UNKNOWN", 0);
        ACCESS_LEVEL_READ = new <init>("ACCESS_LEVEL_READ", 1);
        ACCESS_LEVEL_READ_PLUS_EMAIL = new <init>("ACCESS_LEVEL_READ_PLUS_EMAIL", 2);
        ACCESS_LEVEL_READ_PLUS_EMAIL_PLUS_FRIENDS = new <init>("ACCESS_LEVEL_READ_PLUS_EMAIL_PLUS_FRIENDS", 3);
        ACCESS_LEVEL_READ_PLUS_FRIENDS = new <init>("ACCESS_LEVEL_READ_PLUS_FRIENDS", 4);
        ACCESS_LEVEL_PUBLISH = new <init>("ACCESS_LEVEL_PUBLISH", 5);
        $VALUES = (new .VALUES[] {
            ACCESS_LEVEL_UNKNOWN, ACCESS_LEVEL_READ, ACCESS_LEVEL_READ_PLUS_EMAIL, ACCESS_LEVEL_READ_PLUS_EMAIL_PLUS_FRIENDS, ACCESS_LEVEL_READ_PLUS_FRIENDS, ACCESS_LEVEL_PUBLISH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
