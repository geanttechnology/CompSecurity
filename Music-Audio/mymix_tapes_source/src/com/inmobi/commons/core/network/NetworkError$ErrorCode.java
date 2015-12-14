// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.network;


// Referenced classes of package com.inmobi.commons.core.network:
//            NetworkError

public static final class a extends Enum
{

    private static final HTTP_VERSION_NOT_SUPPORTED $VALUES[];
    public static final HTTP_VERSION_NOT_SUPPORTED HTTP_BAD_GATEWAY;
    public static final HTTP_VERSION_NOT_SUPPORTED HTTP_BAD_REQUEST;
    public static final HTTP_VERSION_NOT_SUPPORTED HTTP_GATEWAY_TIMEOUT;
    public static final HTTP_VERSION_NOT_SUPPORTED HTTP_INTERNAL_SERVER_ERROR;
    public static final HTTP_VERSION_NOT_SUPPORTED HTTP_MOVED_TEMP;
    public static final HTTP_VERSION_NOT_SUPPORTED HTTP_NOT_IMPLEMENTED;
    public static final HTTP_VERSION_NOT_SUPPORTED HTTP_NOT_MODIFIED;
    public static final HTTP_VERSION_NOT_SUPPORTED HTTP_NO_CONTENT;
    public static final HTTP_VERSION_NOT_SUPPORTED HTTP_SEE_OTHER;
    public static final HTTP_VERSION_NOT_SUPPORTED HTTP_SERVER_NOT_AVAILABLE;
    public static final HTTP_VERSION_NOT_SUPPORTED HTTP_SERVER_NOT_FOUND;
    public static final HTTP_VERSION_NOT_SUPPORTED HTTP_VERSION_NOT_SUPPORTED;
    public static final HTTP_VERSION_NOT_SUPPORTED INVALID_ENCRYPTED_RESPONSE_RECEIVED;
    public static final HTTP_VERSION_NOT_SUPPORTED NETWORK_IO_ERROR;
    public static final HTTP_VERSION_NOT_SUPPORTED NETWORK_UNAVAILABLE_ERROR;
    public static final HTTP_VERSION_NOT_SUPPORTED OUT_OF_MEMORY_ERROR;
    public static final HTTP_VERSION_NOT_SUPPORTED RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT;
    public static final HTTP_VERSION_NOT_SUPPORTED UNKNOWN_ERROR;
    private int a;

    public static a fromValue(int i)
    {
        a aa[] = values();
        int k = aa.length;
        for (int j = 0; j < k; j++)
        {
            a a1 = aa[j];
            if (a1.a == i)
            {
                return a1;
            }
        }

        return null;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/commons/core/network/NetworkError$ErrorCode, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public int getValue()
    {
        return a;
    }

    static 
    {
        NETWORK_UNAVAILABLE_ERROR = new <init>("NETWORK_UNAVAILABLE_ERROR", 0, 0);
        UNKNOWN_ERROR = new <init>("UNKNOWN_ERROR", 1, -1);
        NETWORK_IO_ERROR = new <init>("NETWORK_IO_ERROR", 2, -2);
        OUT_OF_MEMORY_ERROR = new <init>("OUT_OF_MEMORY_ERROR", 3, -3);
        INVALID_ENCRYPTED_RESPONSE_RECEIVED = new <init>("INVALID_ENCRYPTED_RESPONSE_RECEIVED", 4, -4);
        RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT = new <init>("RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT", 5, -5);
        HTTP_NO_CONTENT = new <init>("HTTP_NO_CONTENT", 6, 204);
        HTTP_NOT_MODIFIED = new <init>("HTTP_NOT_MODIFIED", 7, 304);
        HTTP_BAD_REQUEST = new <init>("HTTP_BAD_REQUEST", 8, 400);
        HTTP_SEE_OTHER = new <init>("HTTP_SEE_OTHER", 9, 303);
        HTTP_SERVER_NOT_FOUND = new <init>("HTTP_SERVER_NOT_FOUND", 10, 404);
        HTTP_MOVED_TEMP = new <init>("HTTP_MOVED_TEMP", 11, 302);
        HTTP_INTERNAL_SERVER_ERROR = new <init>("HTTP_INTERNAL_SERVER_ERROR", 12, 500);
        HTTP_NOT_IMPLEMENTED = new <init>("HTTP_NOT_IMPLEMENTED", 13, 501);
        HTTP_BAD_GATEWAY = new <init>("HTTP_BAD_GATEWAY", 14, 502);
        HTTP_SERVER_NOT_AVAILABLE = new <init>("HTTP_SERVER_NOT_AVAILABLE", 15, 503);
        HTTP_GATEWAY_TIMEOUT = new <init>("HTTP_GATEWAY_TIMEOUT", 16, 504);
        HTTP_VERSION_NOT_SUPPORTED = new <init>("HTTP_VERSION_NOT_SUPPORTED", 17, 505);
        $VALUES = (new .VALUES[] {
            NETWORK_UNAVAILABLE_ERROR, UNKNOWN_ERROR, NETWORK_IO_ERROR, OUT_OF_MEMORY_ERROR, INVALID_ENCRYPTED_RESPONSE_RECEIVED, RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT, HTTP_NO_CONTENT, HTTP_NOT_MODIFIED, HTTP_BAD_REQUEST, HTTP_SEE_OTHER, 
            HTTP_SERVER_NOT_FOUND, HTTP_MOVED_TEMP, HTTP_INTERNAL_SERVER_ERROR, HTTP_NOT_IMPLEMENTED, HTTP_BAD_GATEWAY, HTTP_SERVER_NOT_AVAILABLE, HTTP_GATEWAY_TIMEOUT, HTTP_VERSION_NOT_SUPPORTED
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
