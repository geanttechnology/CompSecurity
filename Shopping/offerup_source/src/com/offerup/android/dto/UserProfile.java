// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import b.a.a;

// Referenced classes of package com.offerup.android.dto:
//            OfferUpBoolean, BackgroundImage, Rating

public class UserProfile
{

    String avatarLarge;
    String avatarNormal;
    String avatarSquare;
    BackgroundImage backgroundImage;
    long id;
    a joined;
    String name;
    String publicLocationName;
    Rating rating;
    boolean usesDefaultAvatar;
    int verified;

    public UserProfile()
    {
    }

    public String getAvatarLarge()
    {
        return avatarLarge;
    }

    public String getAvatarNormal()
    {
        return avatarNormal;
    }

    public String getAvatarSquare()
    {
        return avatarSquare;
    }

    public BackgroundImage getBackgroundImage()
    {
        return backgroundImage;
    }

    public a getJoinedDate()
    {
        return joined;
    }

    public String getName()
    {
        return name;
    }

    public String getPublicLocationName()
    {
        return publicLocationName;
    }

    public Rating getRating()
    {
        return rating;
    }

    public long getUserId()
    {
        return id;
    }

    public boolean isUsingDefaultAvatar()
    {
        return usesDefaultAvatar;
    }

    public boolean isVerifiedUser()
    {
        return (new OfferUpBoolean(verified)).value;
    }
}
