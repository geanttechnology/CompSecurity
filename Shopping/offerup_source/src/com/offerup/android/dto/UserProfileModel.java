// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.net.Uri;
import b.a.a;

// Referenced classes of package com.offerup.android.dto:
//            User, UserProfile, BackgroundImage, Image, 
//            Rating

public class UserProfileModel
{

    private String backgroundPictureUrl;
    private long id;
    private boolean isUsingDefaultAvatar;
    private boolean isVerifiedUser;
    private a joinedDate;
    private String locationName;
    private String name;
    private String profilePictureUrl;
    private Rating rating;

    public UserProfileModel(User user)
    {
        id = user.getUserId();
        name = user.getFirstName();
        joinedDate = user.getDateJoined();
        rating = user.getRating();
        locationName = user.getPublicLocationName();
        profilePictureUrl = user.getAvatarLarge();
        isUsingDefaultAvatar = user.isUsingDefaultAvatar();
        isVerifiedUser = user.isVerifiedUser();
        setBackgroundImage(user.getBackgroundImage());
    }

    public UserProfileModel(UserProfile userprofile)
    {
        id = userprofile.getUserId();
        name = userprofile.getName();
        joinedDate = userprofile.getJoinedDate();
        rating = userprofile.getRating();
        locationName = userprofile.getPublicLocationName();
        profilePictureUrl = userprofile.getAvatarLarge();
        isUsingDefaultAvatar = userprofile.isUsingDefaultAvatar();
        isVerifiedUser = userprofile.isVerifiedUser();
        setBackgroundImage(userprofile.getBackgroundImage());
    }

    private void setBackgroundImage(BackgroundImage backgroundimage)
    {
        if (backgroundimage != null && backgroundimage.getSmall() != null && backgroundimage.getSmall().getUri() != null)
        {
            backgroundPictureUrl = backgroundimage.getSmall().getUri().toString();
        }
    }

    public String getBackgroundPictureUrl()
    {
        return backgroundPictureUrl;
    }

    public long getId()
    {
        return id;
    }

    public a getJoinedDate()
    {
        return joinedDate;
    }

    public String getLocationName()
    {
        return locationName;
    }

    public String getName()
    {
        return name;
    }

    public String getProfilePictureUrl()
    {
        return profilePictureUrl;
    }

    public Rating getRating()
    {
        return rating;
    }

    public boolean isUsingDefaultAvatar()
    {
        return isUsingDefaultAvatar;
    }

    public boolean isVerifiedUser()
    {
        return isVerifiedUser;
    }
}
