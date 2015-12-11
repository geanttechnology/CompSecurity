// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            Feed

public class FollowingContent
{
    public static final class FollowedCollection extends FollowedEntity
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public FollowedCollection createFromParcel(Parcel parcel)
            {
                return (FollowedCollection)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/FollowingContent$FollowedCollection);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public FollowedCollection[] newArray(int i)
            {
                return new FollowedCollection[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final String collectionId;
        public final List imageUrls;
        public final String name;
        public final User owner;
        public final int size;
        public final String url;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            DataMapperFactory.writeParcelJson(parcel, this);
        }


        public FollowedCollection(Feed.Entities.Collection collection, User user, boolean flag)
        {
            super(flag);
            collectionId = collection.collectionId;
            owner = user;
            name = collection.name;
            url = collection.url;
            size = collection.size;
            imageUrls = collection.imageUrls;
        }

        public FollowedCollection(FollowedCollection followedcollection)
        {
            super(followedcollection.hiddenFeedEvents);
            collectionId = followedcollection.collectionId;
            owner = new User(followedcollection.owner);
            name = followedcollection.name;
            url = followedcollection.url;
            size = followedcollection.size;
            imageUrls = followedcollection.imageUrls;
        }
    }

    public static final class FollowedEntities
    {

        public final List collections = new ArrayList();
        public final List interests = new ArrayList();
        public final List users = new ArrayList();

        public FollowedEntities()
        {
        }
    }

    public static abstract class FollowedEntity
    {

        public boolean hiddenFeedEvents;

        public FollowedEntity(boolean flag)
        {
            hiddenFeedEvents = flag;
        }
    }

    public static final class FollowedInterest extends FollowedEntity
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public FollowedInterest createFromParcel(Parcel parcel)
            {
                return (FollowedInterest)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/FollowingContent$FollowedInterest);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public FollowedInterest[] newArray(int i)
            {
                return new FollowedInterest[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final String customTitle;
        public final String imageUrl;
        public final String interestId;
        public final Feed.Entities.Interest.SearchRequest searchRequest;
        public final String title;

        public int describeContents()
        {
            return 0;
        }

        public String getDisplayTitle()
        {
            if (customTitle != null)
            {
                return customTitle;
            } else
            {
                return title;
            }
        }

        public String toString()
        {
            return title;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            DataMapperFactory.writeParcelJson(parcel, this);
        }


        public FollowedInterest(Feed.Entities.Interest interest, boolean flag)
        {
            super(flag);
            interestId = interest.interestId;
            title = interest.title;
            customTitle = interest.customTitle;
            searchRequest = interest.searchRequest;
            imageUrl = interest.imageUrl.url;
        }

        public FollowedInterest(FollowedInterest followedinterest)
        {
            super(followedinterest.hiddenFeedEvents);
            interestId = followedinterest.interestId;
            title = followedinterest.title;
            customTitle = followedinterest.customTitle;
            searchRequest = followedinterest.searchRequest;
            imageUrl = followedinterest.imageUrl;
        }
    }

    public static final class FollowedUser extends FollowedEntity
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public FollowedUser createFromParcel(Parcel parcel)
            {
                return (FollowedUser)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/FollowingContent$FollowedUser);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public FollowedUser[] newArray(int i)
            {
                return new FollowedUser[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final String profileImageUrl;
        public final String userId;
        public final String username;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            DataMapperFactory.writeParcelJson(parcel, this);
        }


        public FollowedUser(Feed.Entities.User user, boolean flag)
        {
            super(flag);
            userId = user.userId;
            username = user.username;
            profileImageUrl = user.profileImageUrl;
        }

        public FollowedUser(FollowedUser followeduser)
        {
            super(followeduser.hiddenFeedEvents);
            userId = followeduser.userId;
            username = followeduser.username;
            profileImageUrl = followeduser.profileImageUrl;
        }
    }

    public static final class User
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public FollowedUser createFromParcel(Parcel parcel)
            {
                return (FollowedUser)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/FollowingContent$FollowedUser);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public FollowedUser[] newArray(int i)
            {
                return new FollowedUser[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final String profileImageUrl;
        public final String userId;
        public final String username;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            DataMapperFactory.writeParcelJson(parcel, this);
        }


        public User(Feed.Entities.User user)
        {
            userId = user.userId;
            username = user.username;
            profileImageUrl = user.profileImageUrl;
        }

        public User(User user)
        {
            userId = user.userId;
            username = user.username;
            profileImageUrl = user.profileImageUrl;
        }
    }


    public final FollowedEntities followedEntities = new FollowedEntities();

    public FollowingContent(Feed feed)
    {
        if (feed != null && feed.followedEntities != null && feed.entities != null)
        {
            if (feed.followedEntities.interests != null && feed.entities.interests != null)
            {
                Iterator iterator = feed.followedEntities.interests.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Feed.FollowedEntities.InterestInfo interestinfo = (Feed.FollowedEntities.InterestInfo)iterator.next();
                    Feed.Entities.Interest interest = (Feed.Entities.Interest)feed.entities.interests.get(interestinfo.interestId);
                    if (interest != null)
                    {
                        followedEntities.interests.add(new FollowedInterest(interest, interestinfo.hiddenFeedEvents));
                    }
                } while (true);
            }
            if (feed.followedEntities.users != null && feed.entities.users != null)
            {
                Iterator iterator1 = feed.followedEntities.users.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    Feed.FollowedEntities.UserInfo userinfo = (Feed.FollowedEntities.UserInfo)iterator1.next();
                    Feed.Entities.User user = (Feed.Entities.User)feed.entities.users.get(userinfo.userId);
                    if (user != null)
                    {
                        followedEntities.users.add(new FollowedUser(user, userinfo.hiddenFeedEvents));
                    }
                } while (true);
            }
            if (feed.followedEntities.collections != null && feed.entities.collections != null)
            {
                Iterator iterator2 = feed.followedEntities.collections.iterator();
                do
                {
                    if (!iterator2.hasNext())
                    {
                        break;
                    }
                    Feed.FollowedEntities.CollectionInfo collectioninfo = (Feed.FollowedEntities.CollectionInfo)iterator2.next();
                    Feed.Entities.Collection collection = (Feed.Entities.Collection)feed.entities.collections.get(collectioninfo.collectionId);
                    if (collection != null)
                    {
                        Feed.Entities.User user1 = (Feed.Entities.User)feed.entities.users.get(collection.ownerUserId);
                        followedEntities.collections.add(new FollowedCollection(collection, new User(user1), collectioninfo.hiddenFeedEvents));
                    }
                } while (true);
            }
        }
    }
}
