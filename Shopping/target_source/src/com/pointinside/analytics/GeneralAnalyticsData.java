// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.analytics;


// Referenced classes of package com.pointinside.analytics:
//            BaseAnalyticsData

public final class GeneralAnalyticsData extends BaseAnalyticsData
{
    public static final class Builder extends BaseAnalyticsData.Builder
    {

        private String genericType;
        private String storeId;
        private String venue;

        public GeneralAnalyticsData build()
        {
            return new GeneralAnalyticsData(this);
        }

        public Builder genericType(String s)
        {
            genericType = s;
            return this;
        }

        protected volatile BaseAnalyticsData.Builder getThis()
        {
            return getThis();
        }

        protected Builder getThis()
        {
            return this;
        }

        public Builder storeId(String s)
        {
            storeId = s;
            return this;
        }

        public Builder venue(String s)
        {
            venue = s;
            return this;
        }




        public Builder()
        {
            genericType = null;
            venue = null;
            storeId = null;
        }
    }


    public final String genericType;
    public final String storeId;
    public final String venue;

    private GeneralAnalyticsData(Builder builder)
    {
        super(builder);
        genericType = builder.genericType;
        venue = builder.venue;
        storeId = builder.storeId;
    }

}
