// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.analytics;


public class MapAnalyticData
{
    public static class Builder
    {

        private String mCustData;
        private String mReferrer;

        public MapAnalyticData build()
        {
            return new MapAnalyticData(this);
        }

        public Builder custData(String s)
        {
            mCustData = s;
            return this;
        }

        public Builder referrer(String s)
        {
            mReferrer = s;
            return this;
        }



/*
        static String access$002(Builder builder, String s)
        {
            builder.mReferrer = s;
            return s;
        }

*/



/*
        static String access$102(Builder builder, String s)
        {
            builder.mCustData = s;
            return s;
        }

*/

        public Builder()
        {
        }
    }


    public final String custData;
    public final String referrer;

    protected MapAnalyticData(Builder builder)
    {
        referrer = builder.mReferrer;
        custData = builder.mCustData;
    }

    public static Builder newBuilder(MapAnalyticData mapanalyticdata)
    {
        Builder builder = new Builder();
        builder.mReferrer = mapanalyticdata.referrer;
        builder.mCustData = mapanalyticdata.custData;
        return builder;
    }
}
