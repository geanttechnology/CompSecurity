// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;


// Referenced classes of package com.amazon.geo.mapsv2:
//            AmazonMapsStrictMode

public static class Builder
{
    public static class Builder
    {

        private boolean mDetectAll;
        private boolean mDetectUnimplemented;
        private boolean mPenaltyLog;
        private boolean mPenaltyThrow;

        public AmazonMapsStrictMode.ApiPolicy build()
        {
            return new AmazonMapsStrictMode.ApiPolicy(this, null);
        }

        public Builder detectAll()
        {
            mDetectAll = true;
            return this;
        }

        public Builder detectUnimplemented()
        {
            mDetectUnimplemented = true;
            return this;
        }

        public Builder penaltyLog()
        {
            mPenaltyLog = true;
            return this;
        }

        public Builder penaltyThrow()
        {
            mPenaltyThrow = true;
            return this;
        }





        public Builder()
        {
            mDetectAll = false;
            mDetectUnimplemented = false;
            mPenaltyLog = false;
            mPenaltyThrow = false;
        }
    }


    public static final String API_POLICY_METADATA_TAG = "amazon.maps.strictmode.ApiPolicy";
    public static final Builder.mPenaltyThrow LAX = (new Builder()).detectUnimplemented().penaltyLog().build();
    public static final Builder.build NOOP = (new Builder()).build();
    public final boolean detectAll;
    public final boolean detectUnimplemented;
    public final boolean penaltyLog;
    public final boolean penaltyThrow;


    private Builder(Builder builder)
    {
        detectAll = builder.mDetectAll;
        detectUnimplemented = builder.mDetectUnimplemented | builder.mDetectAll;
        penaltyLog = builder.mPenaltyLog;
        penaltyThrow = builder.mPenaltyThrow;
    }

    Builder(Builder builder, Builder builder1)
    {
        this(builder);
    }
}
