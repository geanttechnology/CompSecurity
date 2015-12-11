// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            Feed

public static final class User
{
    public static final class Collection
    {

        public String collectionId;
        public List imageUrls;
        public String name;
        public String ownerUserId;
        public int size;
        public String url;

        public Collection()
        {
        }
    }

    public static final class Interest
    {

        public String customTitle;
        public ImageUrl imageUrl;
        public String interestId;
        public SearchRequest searchRequest;
        public String title;

        public Interest()
        {
        }
    }

    public static class Interest.AspectConstraint
    {

        public String name;
        public List value;

        public Interest.AspectConstraint()
        {
        }
    }

    public static class Interest.AspectScope
    {

        public String type;
        public String value;

        public Interest.AspectScope()
        {
        }
    }

    public static class Interest.Constraints
    {

        public List scopedAspect;

        public Interest.Constraints()
        {
        }
    }

    public static final class Interest.ImageUrl
    {

        public String url;

        public Interest.ImageUrl()
        {
        }
    }

    public static class Interest.ScopedAspect
    {

        public List aspect;
        public Interest.AspectScope scope;

        public Interest.ScopedAspect()
        {
        }
    }

    public static final class Interest.SearchRequest
    {

        public List categoryId;
        public Interest.Constraints constraints;
        public String keyword;

        public Interest.SearchRequest()
        {
        }
    }

    public static final class User
    {

        public String profileImageUrl;
        public String userId;
        public String username;

        public User()
        {
        }
    }


    public HashMap collections;
    public HashMap interests;
    public HashMap users;

    public User()
    {
    }
}
