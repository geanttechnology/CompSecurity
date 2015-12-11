// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;


public class HarvestResponse
{
    public static final class Code extends Enum
    {

        private static final Code $VALUES[];
        public static final Code ENTITY_TOO_LARGE;
        public static final Code FORBIDDEN;
        public static final Code INTERNAL_SERVER_ERROR;
        public static final Code INVALID_AGENT_ID;
        public static final Code OK;
        public static final Code UNAUTHORIZED;
        public static final Code UNKNOWN;
        public static final Code UNSUPPORTED_MEDIA_TYPE;
        int statusCode;

        public static Code valueOf(String s)
        {
            return (Code)Enum.valueOf(com/newrelic/agent/android/harvest/HarvestResponse$Code, s);
        }

        public static Code[] values()
        {
            return (Code[])$VALUES.clone();
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
            OK = new Code("OK", 0, 200);
            UNAUTHORIZED = new Code("UNAUTHORIZED", 1, 401);
            FORBIDDEN = new Code("FORBIDDEN", 2, 403);
            ENTITY_TOO_LARGE = new Code("ENTITY_TOO_LARGE", 3, 413);
            INVALID_AGENT_ID = new Code("INVALID_AGENT_ID", 4, 450);
            UNSUPPORTED_MEDIA_TYPE = new Code("UNSUPPORTED_MEDIA_TYPE", 5, 415);
            INTERNAL_SERVER_ERROR = new Code("INTERNAL_SERVER_ERROR", 6, 500);
            UNKNOWN = new Code("UNKNOWN", 7, -1);
            $VALUES = (new Code[] {
                OK, UNAUTHORIZED, FORBIDDEN, ENTITY_TOO_LARGE, INVALID_AGENT_ID, UNSUPPORTED_MEDIA_TYPE, INTERNAL_SERVER_ERROR, UNKNOWN
            });
        }

        private Code(String s, int i, int j)
        {
            super(s, i);
            statusCode = j;
        }
    }


    private static final String DISABLE_STRING = "DISABLE_NEW_RELIC";
    private String responseBody;
    private long responseTime;
    private int statusCode;

    public HarvestResponse()
    {
    }

    public String getResponseBody()
    {
        return responseBody;
    }

    public Code getResponseCode()
    {
        if (!isOK()) goto _L2; else goto _L1
_L1:
        Code code = Code.OK;
_L4:
        return code;
_L2:
        Code acode[] = Code.values();
        int j = acode.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                Code code1 = acode[i];
                code = code1;
                if (code1.getStatusCode() == statusCode)
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return Code.UNKNOWN;
    }

    public long getResponseTime()
    {
        return responseTime;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public boolean isDisableCommand()
    {
        return Code.FORBIDDEN == getResponseCode() && "DISABLE_NEW_RELIC".equals(getResponseBody());
    }

    public boolean isError()
    {
        return statusCode >= 400;
    }

    public boolean isOK()
    {
        return !isError();
    }

    public boolean isUnknown()
    {
        return getResponseCode() == Code.UNKNOWN;
    }

    public void setResponseBody(String s)
    {
        responseBody = s;
    }

    public void setResponseTime(long l)
    {
        responseTime = l;
    }

    public void setStatusCode(int i)
    {
        statusCode = i;
    }
}
