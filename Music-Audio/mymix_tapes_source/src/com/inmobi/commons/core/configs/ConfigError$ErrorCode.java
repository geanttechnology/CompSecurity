// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.configs;


// Referenced classes of package com.inmobi.commons.core.configs:
//            ConfigError

public static final class  extends Enum
{

    private static final PARSING_ERROR $VALUES[];
    public static final PARSING_ERROR CONFIG_SERVER_INTERNAL_ERROR;
    public static final PARSING_ERROR NETWORK_ERROR;
    public static final PARSING_ERROR PARSING_ERROR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/commons/core/configs/ConfigError$ErrorCode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NETWORK_ERROR = new <init>("NETWORK_ERROR", 0);
        CONFIG_SERVER_INTERNAL_ERROR = new <init>("CONFIG_SERVER_INTERNAL_ERROR", 1);
        PARSING_ERROR = new <init>("PARSING_ERROR", 2);
        $VALUES = (new .VALUES[] {
            NETWORK_ERROR, CONFIG_SERVER_INTERNAL_ERROR, PARSING_ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
