// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.followinterest;

import android.text.TextUtils;
import com.ebay.common.net.api.followinterest.InterestDescriptor;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.common.model.followinterest:
//            FollowType

public class FollowDescriptor
{
    public static final class NotificationEnum extends Enum
    {

        private static final NotificationEnum $VALUES[];
        public static final NotificationEnum EMAIL;
        public static final NotificationEnum PUSH;
        public static final NotificationEnum SMS;

        public static NotificationEnum valueOf(String s)
        {
            return (NotificationEnum)Enum.valueOf(com/ebay/common/model/followinterest/FollowDescriptor$NotificationEnum, s);
        }

        public static NotificationEnum[] values()
        {
            return (NotificationEnum[])$VALUES.clone();
        }

        static 
        {
            EMAIL = new NotificationEnum("EMAIL", 0);
            SMS = new NotificationEnum("SMS", 1);
            PUSH = new NotificationEnum("PUSH", 2);
            $VALUES = (new NotificationEnum[] {
                EMAIL, SMS, PUSH
            });
        }

        private NotificationEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Visibility extends Enum
    {

        private static final Visibility $VALUES[];
        public static final Visibility PRIVATE;
        public static final Visibility PUBLIC;

        public static Visibility valueOf(String s)
        {
            return (Visibility)Enum.valueOf(com/ebay/common/model/followinterest/FollowDescriptor$Visibility, s);
        }

        public static Visibility[] values()
        {
            return (Visibility[])$VALUES.clone();
        }

        static 
        {
            PUBLIC = new Visibility("PUBLIC", 0);
            PRIVATE = new Visibility("PRIVATE", 1);
            $VALUES = (new Visibility[] {
                PUBLIC, PRIVATE
            });
        }

        private Visibility(String s, int i)
        {
            super(s, i);
        }
    }


    public String collectionId;
    public String customTitle;
    public String followDate;
    public String id;
    public transient InterestDescriptor interest;
    public String interestId;
    public List notifications;
    public FollowType type;
    public String username;
    public Visibility visibility;

    public FollowDescriptor()
    {
        type = FollowType.INTEREST;
        visibility = Visibility.PRIVATE;
        notifications = new ArrayList();
    }

    public static FollowDescriptor create(FollowDescriptor followdescriptor)
    {
        if (followdescriptor == null)
        {
            return null;
        } else
        {
            Gson gson = DataMapperFactory.getDefaultMapper();
            return (FollowDescriptor)gson.fromJson(gson.toJson(followdescriptor), com/ebay/common/model/followinterest/FollowDescriptor);
        }
    }

    public String getInterestId()
    {
        if (TextUtils.isEmpty(interestId) && interest != null)
        {
            interestId = Long.toString(interest.interestId);
        }
        return interestId;
    }

    public String getInterestTitle()
    {
        if (!TextUtils.isEmpty(customTitle))
        {
            return customTitle;
        } else
        {
            return interest.title;
        }
    }
}
