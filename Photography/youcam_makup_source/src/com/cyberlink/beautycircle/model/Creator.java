// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.net.Uri;
import com.perfectcorp.model.Model;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            UserInfo

public class Creator extends Model
{

    public Uri avatar;
    public Uri cover;
    public String description;
    public String displayName;
    public Boolean isFollowed;
    public long userId;
    public String userType;

    public Creator()
    {
    }

    public UserInfo b()
    {
        UserInfo userinfo = new UserInfo();
        userinfo.id = userId;
        userinfo.isFollowed = isFollowed;
        userinfo.displayName = displayName;
        userinfo.avatarUrl = avatar;
        userinfo.coverUrl = cover;
        userinfo.userType = userType;
        userinfo.description = description;
        return userinfo;
    }
}
