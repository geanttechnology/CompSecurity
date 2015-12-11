// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            Configuration

public static final class configService extends Enum
{

    private static final PRODUCTION $VALUES[];
    public static final PRODUCTION PRODUCTION;
    public static final PRODUCTION QA;
    String configService;

    public static configService valueOf(String s)
    {
        return (configService)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/Configuration$Environment, s);
    }

    public static configService[] values()
    {
        return (configService[])$VALUES.clone();
    }

    public String getService()
    {
        return configService;
    }

    static 
    {
        QA = new <init>("QA", 0, "http://api.abc.com/vp2/watch/v4/config/%BRAND%/%PARTNER%/?ak=%APIKEY%");
        PRODUCTION = new <init>("PRODUCTION", 1, "http://api.abc.com/vp2/watch/v4/config/%BRAND%/%PARTNER%/?ak=%APIKEY%");
        $VALUES = (new .VALUES[] {
            QA, PRODUCTION
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        configService = s1;
    }
}
