// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.user;

import com.poshmark.data_model.models.ExternalServiceInfo;
import com.poshmark.data_model.models.inner_models.CoverShot;
import com.poshmark.data_model.models.inner_models.Profile;
import com.poshmark.data_model.models.inner_models.UserAggregates;
import com.poshmark.utils.FBUtils;

public class UserInfoDetails
{
    public class AB_Segment
    {

        String sign_up;
        final UserInfoDetails this$0;

        public AB_Segment()
        {
            this$0 = UserInfoDetails.this;
            super();
        }
    }

    class EmailSettings
    {

        boolean announcement;
        boolean comment;
        boolean event_invite;
        boolean follow;
        boolean like;
        final UserInfoDetails this$0;

        EmailSettings()
        {
            this$0 = UserInfoDetails.this;
            super();
        }
    }

    class Notifications
    {

        boolean comment;
        boolean event_invite;
        boolean event_reminder;
        boolean follow;
        boolean like;
        final UserInfoDetails this$0;

        Notifications()
        {
            this$0 = UserInfoDetails.this;
            super();
        }
    }

    public class PasswordStatus
    {

        public boolean password_set;
        final UserInfoDetails this$0;

        public PasswordStatus()
        {
            this$0 = UserInfoDetails.this;
            super();
        }
    }

    public class Settings
    {

        public EmailSettings email;
        public Notifications notifications;
        public boolean search_visibility;
        final UserInfoDetails this$0;
        public boolean timeline;

        public Settings()
        {
            this$0 = UserInfoDetails.this;
            super();
        }
    }


    public static final String USER_ROLE_ADMIN = "admin";
    public static final String USER_ROLE_EVENT_CREATOR = "event_creator";
    public static final String USER_ROLE_EVENT_HOST = "event_host";
    public static final String USER_ROLE_MODERATOR = "moderator";
    private AB_Segment ab_segment;
    private UserAggregates aggregates;
    private boolean blocked;
    private boolean caller_is_following;
    private CoverShot cover_shot;
    private String created_at;
    private String devices[];
    private String display_handle;
    private String display_status;
    private String email;
    private ExternalServiceInfo fb_info;
    private String fb_user_id;
    private String first_name;
    private String full_name;
    private String gp_user_id;
    private String id;
    private String last_name;
    private String last_viewed_notification;
    private int last_viewed_notification_number;
    private String last_viewed_notification_time;
    private ExternalServiceInfo pn_info;
    private Profile profile;
    private String reg_app;
    private String reg_method;
    private String roles[];
    private boolean search_visibility;
    private Settings settings;
    private String status;
    private ExternalServiceInfo tm_info;
    private ExternalServiceInfo tw_info;
    private String username;

    public UserInfoDetails()
    {
        blocked = false;
    }

    public boolean canPerformActionForRole(String s)
    {
        if (roles != null)
        {
            int j = roles.length;
            int i = 0;
            while (i < j) 
            {
                if (roles[i].equalsIgnoreCase(s))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public String getABSegment()
    {
        if (ab_segment != null)
        {
            return ab_segment.sign_up;
        } else
        {
            return null;
        }
    }

    public String getClosetTitle()
    {
        return (new StringBuilder()).append(first_name).append("'s Closet").toString();
    }

    public String getClosetURL()
    {
        return String.format("%s/closet/%s", new Object[] {
            "https://www.poshmark.com", id
        });
    }

    public CoverShot getCoverShot()
    {
        return cover_shot;
    }

    public String getDisplayHandle()
    {
        return display_handle;
    }

    public String getDisplayStatus()
    {
        return display_status;
    }

    public ExternalServiceInfo getFbInfo()
    {
        return fb_info;
    }

    public String getFbUserId()
    {
        return fb_user_id;
    }

    public int getFollowersCount()
    {
        return aggregates.followers;
    }

    public int getFollowingCount()
    {
        return aggregates.following;
    }

    public ExternalServiceInfo getGPInfo()
    {
        return null;
    }

    public String getGoogleUserId()
    {
        return gp_user_id;
    }

    public int getListingCount()
    {
        return aggregates.posts;
    }

    public String getPMUserId()
    {
        return id;
    }

    public ExternalServiceInfo getPnInfo()
    {
        return pn_info;
    }

    public boolean getPostToTimelineFlag()
    {
        if (settings != null)
        {
            return settings.timeline;
        } else
        {
            return false;
        }
    }

    public Profile getProfile()
    {
        return profile;
    }

    public String[] getRoles()
    {
        return roles;
    }

    public boolean getSearchVisibilityFlag()
    {
        return search_visibility;
    }

    public int getShareCount()
    {
        return aggregates.shares;
    }

    public ExternalServiceInfo getTumblrInfo()
    {
        return tm_info;
    }

    public ExternalServiceInfo getTwitterInfo()
    {
        return tw_info;
    }

    public String getUserCity()
    {
        return profile.city;
    }

    public String getUserDisplayHandle()
    {
        return display_handle;
    }

    public String getUserDressSize()
    {
        return profile.dress_size;
    }

    public String getUserEmail()
    {
        return email;
    }

    public String getUserFirstName()
    {
        return first_name;
    }

    public String getUserLastName()
    {
        return last_name;
    }

    public String getUserLoginConnectionType()
    {
        return reg_method;
    }

    public String getUserName()
    {
        return username;
    }

    public String getUserShoeSize()
    {
        return profile.shoe_size;
    }

    public String getUserSmallPicUrl()
    {
        if (cover_shot != null)
        {
            return cover_shot.url_small;
        }
        if (fb_user_id != null && fb_user_id.length() > 0)
        {
            return FBUtils.getUserFBImageURL(fb_user_id);
        }
        if (gp_user_id != null && gp_user_id.length() > 0)
        {
            return FBUtils.getUserFBImageURL(fb_user_id);
        } else
        {
            return null;
        }
    }

    public String getUserState()
    {
        return profile.state;
    }

    public String getUserWebsite()
    {
        return profile.website;
    }

    public boolean isCallerFollowing()
    {
        return caller_is_following;
    }

    public boolean isUserBlocked()
    {
        return blocked;
    }

    public void setBlockedFlag(boolean flag)
    {
        blocked = flag;
    }

    public void setCallerIsFollowing(boolean flag)
    {
        caller_is_following = flag;
    }

    public void setFollowersCount(int i)
    {
        aggregates.followers = i;
    }
}
