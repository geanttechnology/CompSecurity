// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.network;


public class NetworkError
{
    public static final class ErrorCode extends Enum
    {

        private static final ErrorCode $VALUES[];
        public static final ErrorCode HTTP_BAD_GATEWAY;
        public static final ErrorCode HTTP_BAD_REQUEST;
        public static final ErrorCode HTTP_GATEWAY_TIMEOUT;
        public static final ErrorCode HTTP_INTERNAL_SERVER_ERROR;
        public static final ErrorCode HTTP_MOVED_TEMP;
        public static final ErrorCode HTTP_NOT_IMPLEMENTED;
        public static final ErrorCode HTTP_NOT_MODIFIED;
        public static final ErrorCode HTTP_NO_CONTENT;
        public static final ErrorCode HTTP_SEE_OTHER;
        public static final ErrorCode HTTP_SERVER_NOT_AVAILABLE;
        public static final ErrorCode HTTP_SERVER_NOT_FOUND;
        public static final ErrorCode HTTP_VERSION_NOT_SUPPORTED;
        public static final ErrorCode INVALID_ENCRYPTED_RESPONSE_RECEIVED;
        public static final ErrorCode NETWORK_IO_ERROR;
        public static final ErrorCode NETWORK_UNAVAILABLE_ERROR;
        public static final ErrorCode OUT_OF_MEMORY_ERROR;
        public static final ErrorCode RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT;
        public static final ErrorCode UNKNOWN_ERROR;
        private int a;

        public static ErrorCode fromValue(int i)
        {
            ErrorCode aerrorcode[] = values();
            int k = aerrorcode.length;
            for (int j = 0; j < k; j++)
            {
                ErrorCode errorcode = aerrorcode[j];
                if (errorcode.a == i)
                {
                    return errorcode;
                }
            }

            return null;
        }

        public static ErrorCode valueOf(String s)
        {
            return (ErrorCode)Enum.valueOf(com/inmobi/commons/core/network/NetworkError$ErrorCode, s);
        }

        public static ErrorCode[] values()
        {
            return (ErrorCode[])$VALUES.clone();
        }

        public int getValue()
        {
            return a;
        }

        static 
        {
            NETWORK_UNAVAILABLE_ERROR = new ErrorCode("NETWORK_UNAVAILABLE_ERROR", 0, 0);
            UNKNOWN_ERROR = new ErrorCode("UNKNOWN_ERROR", 1, -1);
            NETWORK_IO_ERROR = new ErrorCode("NETWORK_IO_ERROR", 2, -2);
            OUT_OF_MEMORY_ERROR = new ErrorCode("OUT_OF_MEMORY_ERROR", 3, -3);
            INVALID_ENCRYPTED_RESPONSE_RECEIVED = new ErrorCode("INVALID_ENCRYPTED_RESPONSE_RECEIVED", 4, -4);
            RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT = new ErrorCode("RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT", 5, -5);
            HTTP_NO_CONTENT = new ErrorCode("HTTP_NO_CONTENT", 6, 204);
            HTTP_NOT_MODIFIED = new ErrorCode("HTTP_NOT_MODIFIED", 7, 304);
            HTTP_BAD_REQUEST = new ErrorCode("HTTP_BAD_REQUEST", 8, 400);
            HTTP_SEE_OTHER = new ErrorCode("HTTP_SEE_OTHER", 9, 303);
            HTTP_SERVER_NOT_FOUND = new ErrorCode("HTTP_SERVER_NOT_FOUND", 10, 404);
            HTTP_MOVED_TEMP = new ErrorCode("HTTP_MOVED_TEMP", 11, 302);
            HTTP_INTERNAL_SERVER_ERROR = new ErrorCode("HTTP_INTERNAL_SERVER_ERROR", 12, 500);
            HTTP_NOT_IMPLEMENTED = new ErrorCode("HTTP_NOT_IMPLEMENTED", 13, 501);
            HTTP_BAD_GATEWAY = new ErrorCode("HTTP_BAD_GATEWAY", 14, 502);
            HTTP_SERVER_NOT_AVAILABLE = new ErrorCode("HTTP_SERVER_NOT_AVAILABLE", 15, 503);
            HTTP_GATEWAY_TIMEOUT = new ErrorCode("HTTP_GATEWAY_TIMEOUT", 16, 504);
            HTTP_VERSION_NOT_SUPPORTED = new ErrorCode("HTTP_VERSION_NOT_SUPPORTED", 17, 505);
            $VALUES = (new ErrorCode[] {
                NETWORK_UNAVAILABLE_ERROR, UNKNOWN_ERROR, NETWORK_IO_ERROR, OUT_OF_MEMORY_ERROR, INVALID_ENCRYPTED_RESPONSE_RECEIVED, RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT, HTTP_NO_CONTENT, HTTP_NOT_MODIFIED, HTTP_BAD_REQUEST, HTTP_SEE_OTHER, 
                HTTP_SERVER_NOT_FOUND, HTTP_MOVED_TEMP, HTTP_INTERNAL_SERVER_ERROR, HTTP_NOT_IMPLEMENTED, HTTP_BAD_GATEWAY, HTTP_SERVER_NOT_AVAILABLE, HTTP_GATEWAY_TIMEOUT, HTTP_VERSION_NOT_SUPPORTED
            });
        }

        private ErrorCode(String s, int i, int j)
        {
            super(s, i);
            a = j;
        }
    }


    private ErrorCode a;
    private String b;

    public NetworkError(ErrorCode errorcode, String s)
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
