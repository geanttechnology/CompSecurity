// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.configs;


class ConfigError
{
    public static final class ErrorCode extends Enum
    {

        private static final ErrorCode $VALUES[];
        public static final ErrorCode CONFIG_SERVER_INTERNAL_ERROR;
        public static final ErrorCode NETWORK_ERROR;
        public static final ErrorCode PARSING_ERROR;

        public static ErrorCode valueOf(String s)
        {
            return (ErrorCode)Enum.valueOf(com/inmobi/commons/core/configs/ConfigError$ErrorCode, s);
        }

        public static ErrorCode[] values()
        {
            return (ErrorCode[])$VALUES.clone();
        }

        static 
        {
            NETWORK_ERROR = new ErrorCode("NETWORK_ERROR", 0);
            CONFIG_SERVER_INTERNAL_ERROR = new ErrorCode("CONFIG_SERVER_INTERNAL_ERROR", 1);
            PARSING_ERROR = new ErrorCode("PARSING_ERROR", 2);
            $VALUES = (new ErrorCode[] {
                NETWORK_ERROR, CONFIG_SERVER_INTERNAL_ERROR, PARSING_ERROR
            });
        }

        private ErrorCode(String s, int i)
        {
            super(s, i);
        }
    }


    private ErrorCode a;
    private String b;

    public ConfigError(ErrorCode errorcode, String s)
    {
        a = errorcode;
        b = s;
    }

    public ErrorCode a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }
}
