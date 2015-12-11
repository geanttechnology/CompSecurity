// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


public class UserStateSummary
{
    public class Brands
    {

        public UpdatedAt all;
        public UpdatedAt following;
        final UserStateSummary this$0;

        public Brands()
        {
            this$0 = UserStateSummary.this;
            super();
        }
    }

    public class Catalog
    {

        final UserStateSummary this$0;
        public String updated_at;

        public Catalog()
        {
            this$0 = UserStateSummary.this;
            super();
        }
    }

    public class Collections
    {

        public Posts posts;
        final UserStateSummary this$0;

        public Collections()
        {
            this$0 = UserStateSummary.this;
            super();
        }
    }

    public class EventInvites
    {

        final UserStateSummary this$0;
        public String updated_at;

        public EventInvites()
        {
            this$0 = UserStateSummary.this;
            super();
        }
    }

    public class FeatureSettings
    {

        final UserStateSummary this$0;
        public String updated_at;

        public FeatureSettings()
        {
            this$0 = UserStateSummary.this;
            super();
        }
    }

    class Info
    {

        public String posh_protect;
        public String returns;
        public String shipping;
        public String shipping_returns;
        final UserStateSummary this$0;

        Info()
        {
            this$0 = UserStateSummary.this;
            super();
        }
    }

    public class NotificationsObject
    {

        public int comments;
        public int follows;
        public int likes;
        public int purchases;
        final UserStateSummary this$0;
        public int total;

        public NotificationsObject()
        {
            this$0 = UserStateSummary.this;
            super();
        }
    }

    public class Posts
    {

        final UserStateSummary this$0;
        public String updated_at;

        public Posts()
        {
            this$0 = UserStateSummary.this;
            super();
        }
    }

    class Segment
    {

        public String sign_up;
        final UserStateSummary this$0;

        Segment()
        {
            this$0 = UserStateSummary.this;
            super();
        }
    }

    public class UpdatedAt
    {

        final UserStateSummary this$0;
        public String updated_at;

        public UpdatedAt()
        {
            this$0 = UserStateSummary.this;
            super();
        }
    }

    public class UserInfo
    {

        public Segment ab_segment;
        public String size_available;
        final UserStateSummary this$0;

        public String getAbSegment()
        {
            if (ab_segment != null)
            {
                return ab_segment.sign_up;
            } else
            {
                return null;
            }
        }

        public boolean isMySizeAvailable()
        {
            return size_available != null && !size_available.equals("none");
        }

        public UserInfo()
        {
            this$0 = UserStateSummary.this;
            super();
        }
    }


    public Brands brands;
    public Catalog catalog;
    public Collections collections;
    public EventInvites event_invites;
    public FeatureSettings feature_settings;
    public Info info;
    public NotificationsObject notifications;
    public UserInfo user_info;

    public UserStateSummary()
    {
    }

    public String getPoshProtectText()
    {
        if (info == null || info.posh_protect == null)
        {
            return "";
        } else
        {
            return info.posh_protect;
        }
    }

    public String getShippingReturnText()
    {
        if (info == null || info.shipping_returns == null)
        {
            return "";
        } else
        {
            return info.shipping_returns;
        }
    }

    public boolean isMySizeSet()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (user_info != null)
        {
            flag = flag1;
            if (user_info.size_available != null)
            {
                flag = flag1;
                if (user_info.equals("complete"))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }
}
