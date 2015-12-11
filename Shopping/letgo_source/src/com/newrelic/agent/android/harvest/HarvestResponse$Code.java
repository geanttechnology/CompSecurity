// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;


// Referenced classes of package com.newrelic.agent.android.harvest:
//            HarvestResponse

public static final class statusCode extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN ENTITY_TOO_LARGE;
    public static final UNKNOWN FORBIDDEN;
    public static final UNKNOWN INTERNAL_SERVER_ERROR;
    public static final UNKNOWN INVALID_AGENT_ID;
    public static final UNKNOWN OK;
    public static final UNKNOWN UNAUTHORIZED;
    public static final UNKNOWN UNKNOWN;
    public static final UNKNOWN UNSUPPORTED_MEDIA_TYPE;
    int statusCode;

    public static statusCode valueOf(String s)
    {
        return (statusCode)Enum.valueOf(com/newrelic/agent/android/harvest/HarvestResponse$Code, s);
    }

    public static statusCode[] values()
    {
        return (statusCode[])$VALUES.clone();
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public boolean isError()
    {
        return this != OK;
    }

    public boolean isOK()
    {
        return !isError();
    }

    static 
    {
        OK = new <init>("OK", 0, 200);
        UNAUTHORIZED = new <init>("UNAUTHORIZED", 1, 401);
        FORBIDDEN = new <init>("FORBIDDEN", 2, 403);
        ENTITY_TOO_LARGE = new <init>("ENTITY_TOO_LARGE", 3, 413);
        INVALID_AGENT_ID = new <init>("INVALID_AGENT_ID", 4, 450);
        UNSUPPORTED_MEDIA_TYPE = new <init>("UNSUPPORTED_MEDIA_TYPE", 5, 415);
        INTERNAL_SERVER_ERROR = new <init>("INTERNAL_SERVER_ERROR", 6, 500);
        UNKNOWN = new <init>("UNKNOWN", 7, -1);
        $VALUES = (new .VALUES[] {
            OK, UNAUTHORIZED, FORBIDDEN, ENTITY_TOO_LARGE, INVALID_AGENT_ID, UNSUPPORTED_MEDIA_TYPE, INTERNAL_SERVER_ERROR, UNKNOWN
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        statusCode = j;
    }
}
