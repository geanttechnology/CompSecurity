// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.net.Uri;
import com.perfectcorp.model.Model;
import java.util.ArrayList;
import java.util.Date;

public class UserInfo extends Model
{

    public static final String TAB_TYPE_CIRCLE = "CIRCLE";
    public static final String TAB_TYPE_FOLLOWER = "FOLLOWER";
    public static final String TAB_TYPE_FOLLOWING = "FOLLOWING";
    public static final String TAB_TYPE_LIKE = "LIKE";
    public static final String TAB_TYPE_POST = "POST";
    public static final String TAB_TYPE_PRODUCT = "PRODUCT";
    public String address;
    public String attribute;
    public Uri avatarUrl;
    public Uri bgImageUrl;
    public String birthDay;
    public Integer circleCount;
    public Uri coverUrl;
    public String description;
    public String displayName;
    public String email;
    public ArrayList eventImageList;
    public Integer followerCount;
    public Integer followingCount;
    public String gender;
    public long id;
    public Boolean isBlocked;
    public Boolean isFollowed;
    public Date lastModified;
    public Integer likedTargetCount;
    public String name;
    public String phone;
    public Integer postCount;
    public Integer productFeatureCount;
    public String receiveEmail;
    public String region;
    public ArrayList tab;
    public String userSubType;
    public String userType;
    public transient boolean visible;
    public String websiteUrl;

    public UserInfo()
    {
        visible = true;
    }

    public Boolean b()
    {
        return isFollowed;
    }

    public Long b_()
    {
        return Long.valueOf(id);
    }

    public boolean c()
    {
        return userType != null && (userType.equals("Expert") || userType.equals("Master") || userType.equals("Brand") || userType.equals("Publisher") || userType.equals("CL"));
    }
}
