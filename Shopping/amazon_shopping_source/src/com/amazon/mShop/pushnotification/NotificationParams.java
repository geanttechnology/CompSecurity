// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;


public class NotificationParams
{
    public static class CoinsNotificationParams extends NotificationParams
    {

        private String mTitle;
        private String mUrl;
        private boolean mUseCoinsIcon;

        public String getTitle()
        {
            return mTitle;
        }

        public String getUrl()
        {
            return mUrl;
        }

        public boolean useCoinsIcon()
        {
            return mUseCoinsIcon;
        }

        public CoinsNotificationParams(String s, String s1, String s2, String s3, boolean flag, String s4, String s5)
        {
            super(s, s1, s3, s4);
            mUrl = s5;
            mTitle = s2;
            mUseCoinsIcon = flag;
        }
    }

    public static class DealNotificationParams extends ProductDetailNotificationParams
    {

        private String mCategory;
        private String mCategoryDisplayName;

        public String getCategory()
        {
            return mCategory;
        }

        public String getCategoryDisplayName()
        {
            return mCategoryDisplayName;
        }

        public DealNotificationParams(String s, String s1, String s2, String s3, String s4, String s5, String s6)
        {
            super(s, s1, s2, s3, s6);
            mCategory = s4;
            mCategoryDisplayName = s5;
        }
    }

    public static class DeepLinkNotificationParams extends NotificationParams
    {

        private String mUrl;

        public String getUrl()
        {
            return mUrl;
        }

        public DeepLinkNotificationParams(String s, String s1, String s2, String s3, String s4)
        {
            super(s, s1, s2, s3);
            mUrl = s4;
        }
    }

    public static class OrderNotificationParams extends NotificationParams
    {

        private String mOrderId;

        public String getOrderId()
        {
            return mOrderId;
        }

        public OrderNotificationParams(String s, String s1, String s2, String s3, String s4)
        {
            super(s, s1, s2, s4);
            mOrderId = s3;
        }
    }

    public static class ProductDetailNotificationParams extends NotificationParams
    {

        private String mAsin;

        public String getAsin()
        {
            return mAsin;
        }

        public ProductDetailNotificationParams(String s, String s1, String s2, String s3, String s4)
        {
            super(s, s1, s2, s4);
            mAsin = s3;
        }
    }

    public static class SmartLinkNotificationParams extends NotificationParams
    {

        private String mUrl;

        public String getUrl()
        {
            return mUrl;
        }

        public SmartLinkNotificationParams(String s, String s1, String s2, String s3, String s4)
        {
            super(s, s1, s2, s3);
            mUrl = s4;
        }
    }

    public static class SnsNotificationParams extends NotificationParams
    {

        private String mToken;

        public String getToken()
        {
            return mToken;
        }

        public SnsNotificationParams(String s, String s1, String s2, String s3, String s4)
        {
            super(s, s1, s2, s3);
            mToken = s4;
        }
    }


    private String mMarketPlace;
    private String mMessage;
    private String mNotificationType;
    private String mRefMarker;

    public NotificationParams(String s, String s1, String s2, String s3)
    {
        mNotificationType = s;
        mMarketPlace = s1;
        mMessage = s2;
        mRefMarker = s3;
    }

    public String getMarketPlace()
    {
        return mMarketPlace;
    }

    public String getMessage()
    {
        return mMessage;
    }

    public String getNotificationType()
    {
        return mNotificationType;
    }

    public String getRefMarker()
    {
        return mRefMarker;
    }
}
