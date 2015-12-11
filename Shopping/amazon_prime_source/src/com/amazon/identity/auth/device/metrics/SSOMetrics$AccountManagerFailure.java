// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.metrics;


// Referenced classes of package com.amazon.identity.auth.device.metrics:
//            SSOMetrics

public static final class mName extends Enum
{

    private static final UNRECOGNIZED $VALUES[];
    public static final UNRECOGNIZED BAD_ARGUMENTS;
    public static final UNRECOGNIZED BAD_REQUEST;
    public static final UNRECOGNIZED CANCELED;
    public static final UNRECOGNIZED INVALID_RESPONSE;
    public static final UNRECOGNIZED NETWORK_ERROR;
    public static final UNRECOGNIZED REMOTE_EXCEPTION;
    public static final UNRECOGNIZED UNRECOGNIZED;
    public static final UNRECOGNIZED UNSUPPORTED_OPERATION;
    private final int mErrorCode;
    private final String mName;

    public static mName getFromAccountManagerErrorCode(int i)
    {
        mName amname[] = values();
        int k = amname.length;
        for (int j = 0; j < k; j++)
        {
            mName mname = amname[j];
            if (mname.getAccountManagerErrorCode() == i)
            {
                return mname;
            }
        }

        return UNRECOGNIZED;
    }

    public static UNRECOGNIZED valueOf(String s)
    {
        return (UNRECOGNIZED)Enum.valueOf(com/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure, s);
    }

    public static UNRECOGNIZED[] values()
    {
        return (UNRECOGNIZED[])$VALUES.clone();
    }

    public int getAccountManagerErrorCode()
    {
        return mErrorCode;
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        BAD_ARGUMENTS = new <init>("BAD_ARGUMENTS", 0, 7, "BadArguments");
        BAD_REQUEST = new <init>("BAD_REQUEST", 1, 8, "BadRequest");
        CANCELED = new <init>("CANCELED", 2, 4, "Cancelled");
        INVALID_RESPONSE = new <init>("INVALID_RESPONSE", 3, 5, "InvalidResponse");
        NETWORK_ERROR = new <init>("NETWORK_ERROR", 4, 3, "NetworkError");
        REMOTE_EXCEPTION = new <init>("REMOTE_EXCEPTION", 5, 1, "RemoteException");
        UNSUPPORTED_OPERATION = new <init>("UNSUPPORTED_OPERATION", 6, 6, "UnsupportedOperation");
        UNRECOGNIZED = new <init>("UNRECOGNIZED", 7, 9, "UnrecognizedExternalError");
        $VALUES = (new .VALUES[] {
            BAD_ARGUMENTS, BAD_REQUEST, CANCELED, INVALID_RESPONSE, NETWORK_ERROR, REMOTE_EXCEPTION, UNSUPPORTED_OPERATION, UNRECOGNIZED
        });
    }

    private (String s, int i, int j, String s1)
    {
        super(s, i);
        mErrorCode = j;
        mName = s1;
    }
}
