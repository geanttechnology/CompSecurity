// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents

public static final class User
{
    public static final class User
    {

        public String profileImageURL;
        public UserId userIdentifier;

        public User()
        {
        }
    }

    public static final class User.UserId
    {

        public String userId;
        public String username;

        public User.UserId()
        {
        }
    }


    public String collectionId;
    public User creator;
    public String description;
    public int entryCount;
    public com.ebay.nautilus.domain.data.rd.Collection.User highestAmount;
    public String imageUrl;
    public List images;
    public String longDescription;
    public com.ebay.nautilus.domain.data.rd.Collection.User lowestAmount;
    public String name;
    public String placementId;
    public String summary;
    public String url;
    public String videoId;

    public User()
    {
    }
}
