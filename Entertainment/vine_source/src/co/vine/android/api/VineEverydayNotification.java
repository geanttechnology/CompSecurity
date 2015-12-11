// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.api:
//            VineNotification, VinePost, VineUser, VineMilestone

public class VineEverydayNotification extends VineNotification
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineEverydayNotification createFromParcel(Parcel parcel)
        {
            return new VineEverydayNotification(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineEverydayNotification[] newArray(int i)
        {
            return new VineEverydayNotification[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int FOLLOWING = 1;
    public static final int FOLLOW_REQUESTED = 2;
    public static final int PRIVATE = 4;
    public static final String TYPE_ADDRESS_BOOK_FRIEND_JOINED = "address book friend joined";
    public static final String TYPE_COMMENTED = "commented";
    public static final String TYPE_COMMENT_MENTION = "mentioned comment";
    public static final String TYPE_COUNT = "count";
    public static final String TYPE_FOLLOWED = "followed";
    public static final String TYPE_FOLLOW_APPROVED = "follow approved";
    public static final String TYPE_GROUP_COMMENTED = "grouped comment";
    public static final String TYPE_LIKED = "liked";
    public static final String TYPE_MENTION = "mentioned";
    public static final String TYPE_POST_MENTION = "mentioned post";
    public static final String TYPE_REVINED = "reposted";
    public static final String TYPE_TWITTER_FRIEND_JOINED = "twitter friend joined";
    public long anchor;
    public int followStatus;
    public boolean isNew;
    public VineMilestone milestone;
    public VinePost post;
    public String type;
    public VineUser user;

    public VineEverydayNotification(Parcel parcel)
    {
        ClassLoader classloader = getClass().getClassLoader();
        comment = parcel.readString();
        notificationId = parcel.readLong();
        type = parcel.readString();
        post = (VinePost)parcel.readParcelable(classloader);
        user = (VineUser)parcel.readParcelable(classloader);
        entities = (ArrayList)parcel.readSerializable();
        followStatus = parcel.readInt();
        milestone = (VineMilestone)parcel.readParcelable(classloader);
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isNew = flag;
        anchor = parcel.readLong();
    }

    public VineEverydayNotification(String s, long l, String s1, VinePost vinepost, VineUser vineuser, ArrayList arraylist, 
            VineMilestone vinemilestone, long l1, boolean flag, long l2)
    {
        comment = s;
        notificationId = l;
        type = s1;
        entities = arraylist;
        user = vineuser;
        post = vinepost;
        milestone = vinemilestone;
        createdAt = l1;
        isNew = flag;
        anchor = l2;
    }

    public static boolean isLocked(int i)
    {
        return (i & 4) >= 1 && ((i & 2) >= 1 || (i & 1) < 1);
    }

    public int describeContents()
    {
        return 0;
    }

    public void setFollowRequested()
    {
        followStatus = followStatus | 2;
    }

    public void setFollowing()
    {
        followStatus = followStatus | 1;
    }

    public void setPrivate()
    {
        followStatus = followStatus | 4;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(comment);
        parcel.writeLong(notificationId);
        parcel.writeString(type);
        parcel.writeParcelable(post, i);
        parcel.writeParcelable(user, i);
        parcel.writeSerializable(entities);
        parcel.writeInt(followStatus);
        parcel.writeParcelable(milestone, i);
        if (isNew)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeLong(anchor);
    }

}
