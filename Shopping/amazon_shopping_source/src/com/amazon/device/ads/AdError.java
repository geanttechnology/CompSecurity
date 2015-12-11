// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


public final class AdError
{
    public static final class ErrorCode extends Enum
    {

        private static final ErrorCode $VALUES[];
        public static final ErrorCode INTERNAL_ERROR;
        public static final ErrorCode NETWORK_ERROR;
        public static final ErrorCode NETWORK_TIMEOUT;
        public static final ErrorCode NO_FILL;
        public static final ErrorCode REQUEST_ERROR;

        public static ErrorCode valueOf(String s)
        {
            return (ErrorCode)Enum.valueOf(com/amazon/device/ads/AdError$ErrorCode, s);
        }

        public static ErrorCode[] values()
        {
            return (ErrorCode[])$VALUES.clone();
        }

        static 
        {
            NETWORK_ERROR = new ErrorCode("NETWORK_ERROR", 0);
            NETWORK_TIMEOUT = new ErrorCode("NETWORK_TIMEOUT", 1);
            NO_FILL = new ErrorCode("NO_FILL", 2);
            INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 3);
            REQUEST_ERROR = new ErrorCode("REQUEST_ERROR", 4);
            $VALUES = (new ErrorCode[] {
                NETWORK_ERROR, NETWORK_TIMEOUT, NO_FILL, INTERNAL_ERROR, REQUEST_ERROR
            });
        }

        private ErrorCode(String s, int i)
        {
            super(s, i);
        }
    }


    private final ErrorCode code;
    private final String message;

    AdError(ErrorCode errorcode, String s)
    {
        code = errorcode;
        message = s;
    }

    public ErrorCode getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }
}
