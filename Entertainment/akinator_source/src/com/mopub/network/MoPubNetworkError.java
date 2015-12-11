// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;

public class MoPubNetworkError extends VolleyError
{
    public static final class Reason extends Enum
    {

        private static final Reason $VALUES[];
        public static final Reason BAD_BODY;
        public static final Reason BAD_HEADER_DATA;
        public static final Reason NO_FILL;
        public static final Reason TRACKING_FAILURE;
        public static final Reason UNSPECIFIED;
        public static final Reason WARMING_UP;

        public static Reason valueOf(String s)
        {
            return (Reason)Enum.valueOf(com/mopub/network/MoPubNetworkError$Reason, s);
        }

        public static Reason[] values()
        {
            return (Reason[])$VALUES.clone();
        }

        static 
        {
            WARMING_UP = new Reason("WARMING_UP", 0);
            NO_FILL = new Reason("NO_FILL", 1);
            BAD_HEADER_DATA = new Reason("BAD_HEADER_DATA", 2);
            BAD_BODY = new Reason("BAD_BODY", 3);
            TRACKING_FAILURE = new Reason("TRACKING_FAILURE", 4);
            UNSPECIFIED = new Reason("UNSPECIFIED", 5);
            $VALUES = (new Reason[] {
                WARMING_UP, NO_FILL, BAD_HEADER_DATA, BAD_BODY, TRACKING_FAILURE, UNSPECIFIED
            });
        }

        private Reason(String s, int i)
        {
            super(s, i);
        }
    }


    private final Reason mReason;
    private final Integer mRefreshTimeMillis;

    public MoPubNetworkError(Reason reason)
    {
        mReason = reason;
        mRefreshTimeMillis = null;
    }

    public MoPubNetworkError(NetworkResponse networkresponse, Reason reason)
    {
        super(networkresponse);
        mReason = reason;
        mRefreshTimeMillis = null;
    }

    public MoPubNetworkError(String s, Reason reason)
    {
        this(s, reason, ((Integer) (null)));
    }

    public MoPubNetworkError(String s, Reason reason, Integer integer)
    {
        super(s);
        mReason = reason;
        mRefreshTimeMillis = integer;
    }

    public MoPubNetworkError(String s, Throwable throwable, Reason reason)
    {
        super(s, throwable);
        mReason = reason;
        mRefreshTimeMillis = null;
    }

    public MoPubNetworkError(Throwable throwable, Reason reason)
    {
        super(throwable);
        mReason = reason;
        mRefreshTimeMillis = null;
    }

    public Reason getReason()
    {
        return mReason;
    }

    public Integer getRefreshTimeMillis()
    {
        return mRefreshTimeMillis;
    }
}
