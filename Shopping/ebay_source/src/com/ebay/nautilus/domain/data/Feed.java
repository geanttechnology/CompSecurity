// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.HashMap;
import java.util.List;

public class Feed extends BaseApiResponse
    implements Parcelable
{
    public static final class Entities
    {

        public HashMap collections;
        public HashMap interests;
        public HashMap users;

        public Entities()
        {
        }
    }

    public static final class Entities.Collection
    {

        public String collectionId;
        public List imageUrls;
        public String name;
        public String ownerUserId;
        public int size;
        public String url;

        public Entities.Collection()
        {
        }
    }

    public static final class Entities.Interest
    {

        public String customTitle;
        public ImageUrl imageUrl;
        public String interestId;
        public SearchRequest searchRequest;
        public String title;

        public Entities.Interest()
        {
        }
    }

    public static class Entities.Interest.AspectConstraint
    {

        public String name;
        public List value;

        public Entities.Interest.AspectConstraint()
        {
        }
    }

    public static class Entities.Interest.AspectScope
    {

        public String type;
        public String value;

        public Entities.Interest.AspectScope()
        {
        }
    }

    public static class Entities.Interest.Constraints
    {

        public List scopedAspect;

        public Entities.Interest.Constraints()
        {
        }
    }

    public static final class Entities.Interest.ImageUrl
    {

        public String url;

        public Entities.Interest.ImageUrl()
        {
        }
    }

    public static class Entities.Interest.ScopedAspect
    {

        public List aspect;
        public Entities.Interest.AspectScope scope;

        public Entities.Interest.ScopedAspect()
        {
        }
    }

    public static final class Entities.Interest.SearchRequest
    {

        public List categoryId;
        public Entities.Interest.Constraints constraints;
        public String keyword;

        public Entities.Interest.SearchRequest()
        {
        }
    }

    public static final class Entities.User
    {

        public String profileImageUrl;
        public String userId;
        public String username;

        public Entities.User()
        {
        }
    }

    public static final class FollowedEntities
    {

        public List collections;
        public List interests;
        public List users;

        public FollowedEntities()
        {
        }
    }

    public static final class FollowedEntities.CollectionInfo
    {

        public String collectionId;
        public boolean hiddenFeedEvents;

        public FollowedEntities.CollectionInfo()
        {
        }
    }

    public static final class FollowedEntities.InterestInfo
    {

        public boolean hiddenFeedEvents;
        public String interestId;

        public FollowedEntities.InterestInfo()
        {
        }
    }

    public static final class FollowedEntities.UserInfo
    {

        public boolean hiddenFeedEvents;
        public String userId;

        public FollowedEntities.UserInfo()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Feed createFromParcel(Parcel parcel)
        {
            return (Feed)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/Feed);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Feed[] newArray(int i)
        {
            return new Feed[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Entities entities;
    public FollowedEntities followedEntities;

    public Feed()
    {
    }

}
