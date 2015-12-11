// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;


public class AmazonMapsStrictMode
{
    public static class ApiPolicy
    {

        public static final String API_POLICY_METADATA_TAG = "amazon.maps.strictmode.ApiPolicy";
        public static final ApiPolicy LAX = (new Builder()).detectUnimplemented().penaltyLog().build();
        public static final ApiPolicy NOOP = (new Builder()).build();
        public final boolean detectAll;
        public final boolean detectUnimplemented;
        public final boolean penaltyLog;
        public final boolean penaltyThrow;


        private ApiPolicy(Builder builder)
        {
            detectAll = builder.mDetectAll;
            detectUnimplemented = builder.mDetectUnimplemented | builder.mDetectAll;
            penaltyLog = builder.mPenaltyLog;
            penaltyThrow = builder.mPenaltyThrow;
        }

    }

    public static class ApiPolicy.Builder
    {

        private boolean mDetectAll;
        private boolean mDetectUnimplemented;
        private boolean mPenaltyLog;
        private boolean mPenaltyThrow;

        public ApiPolicy build()
        {
            return new ApiPolicy(this);
        }

        public ApiPolicy.Builder detectAll()
        {
            mDetectAll = true;
            return this;
        }

        public ApiPolicy.Builder detectUnimplemented()
        {
            mDetectUnimplemented = true;
            return this;
        }

        public ApiPolicy.Builder penaltyLog()
        {
            mPenaltyLog = true;
            return this;
        }

        public ApiPolicy.Builder penaltyThrow()
        {
            mPenaltyThrow = true;
            return this;
        }





        public ApiPolicy.Builder()
        {
            mDetectAll = false;
            mDetectUnimplemented = false;
            mPenaltyLog = false;
            mPenaltyThrow = false;
        }
    }

    public static class StrictModeException extends RuntimeException
    {

        private static final long serialVersionUID = 0xb859cff1e518eb4eL;

        public StrictModeException()
        {
        }

        public StrictModeException(String s)
        {
            super(s);
        }

        public StrictModeException(String s, Throwable throwable)
        {
            super(s, throwable);
        }

        public StrictModeException(Throwable throwable)
        {
            super(throwable);
        }
    }


    private static ApiPolicy sApiPolicy;

    public AmazonMapsStrictMode()
    {
    }

    public static void enableDefaults()
    {
        sApiPolicy = ApiPolicy.LAX;
    }

    public static ApiPolicy getApiPolicy()
    {
        return sApiPolicy;
    }

    public static void setApiPolicy(ApiPolicy apipolicy)
    {
        sApiPolicy = apipolicy;
    }

    static 
    {
        sApiPolicy = ApiPolicy.NOOP;
    }
}
