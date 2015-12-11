// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;


public class NewsCardAnalyticsInfo
{
    public static class Builder
    {

        private int itemCount;
        private int position;

        static int a(Builder builder)
        {
            return builder.position;
        }

        static int b(Builder builder)
        {
            return builder.itemCount;
        }

        public static Builder newsCardAnalyticsInfo()
        {
            return new Builder();
        }

        public NewsCardAnalyticsInfo build()
        {
            return new NewsCardAnalyticsInfo(this, (byte)0);
        }

        public Builder withItemCount(int i)
        {
            itemCount = i;
            return this;
        }

        public Builder withPosition(int i)
        {
            position = i;
            return this;
        }

        public Builder()
        {
        }
    }


    private final int itemCount;
    private final int position;

    private NewsCardAnalyticsInfo(Builder builder)
    {
        position = Builder.a(builder);
        itemCount = Builder.b(builder);
    }

    NewsCardAnalyticsInfo(Builder builder, byte byte0)
    {
        this(builder);
    }

    public int getItemCount()
    {
        return itemCount;
    }

    public int getPosition()
    {
        return position;
    }
}
