// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.api:
//            VineNotification

public class VineSingleNotification extends VineNotification
    implements Parcelable
{

    public static final int BaseConversationMessageNotification = 18;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineSingleNotification createFromParcel(Parcel parcel)
        {
            return new VineSingleNotification(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineSingleNotification[] newArray(int i)
        {
            return new VineSingleNotification[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int ConversationMessageTextNotification = 25;
    public static final int FOLLOWING = 1;
    public static final int FOLLOW_REQUESTED = 2;
    public static final int PRIVATE = 4;
    public String avatarUrl;
    public long conversationId;
    public long conversationRowId;
    public int followStatus;
    public final ArrayList imageKeys;
    public int messageCount;
    public int notificationType;
    public long postId;
    public long recipientUserId;
    public String thumbnailUrl;
    public long unreadMessageCount;
    public long userId;
    public String username;
    public boolean verified;
    public final ArrayList videoKeys;

    public VineSingleNotification(Cursor cursor)
    {
        imageKeys = new ArrayList();
        videoKeys = new ArrayList();
        avatarUrl = cursor.getString(6);
        comment = cursor.getString(3);
        notificationId = cursor.getLong(1);
        conversationRowId = cursor.getLong(5);
        notificationType = cursor.getInt(2);
    }

    public VineSingleNotification(Parcel parcel)
    {
        boolean flag = true;
        super();
        imageKeys = new ArrayList();
        videoKeys = new ArrayList();
        avatarUrl = parcel.readString();
        username = parcel.readString();
        thumbnailUrl = parcel.readString();
        comment = parcel.readString();
        notificationId = parcel.readLong();
        userId = parcel.readLong();
        postId = parcel.readLong();
        createdAt = parcel.readLong();
        conversationId = parcel.readLong();
        unreadMessageCount = parcel.readLong();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        verified = flag;
        notificationType = parcel.readInt();
        entities = (ArrayList)parcel.readSerializable();
        followStatus = parcel.readInt();
        conversationRowId = parcel.readLong();
        messageCount = parcel.readInt();
        parcel.readList(imageKeys, co/vine/android/api/VineSingleNotification.getClassLoader());
        parcel.readList(videoKeys, co/vine/android/api/VineSingleNotification.getClassLoader());
    }

    public VineSingleNotification(String s, String s1, String s2, String s3, long l, long l1, long l2, long l3, boolean flag, int i, 
            long l4, ArrayList arraylist, long l5, long l6)
    {
        imageKeys = new ArrayList();
        videoKeys = new ArrayList();
        avatarUrl = s;
        username = s1;
        thumbnailUrl = s2;
        comment = s3;
        notificationId = l;
        userId = l1;
        postId = l2;
        createdAt = l3;
        conversationId = l4;
        unreadMessageCount = l5;
        verified = flag;
        notificationType = i;
        entities = arraylist;
        recipientUserId = l6;
    }

    public static boolean isLocked(int i)
    {
        return (i & 4) >= 1 && ((i & 2) >= 1 || (i & 1) < 1);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean isMessaging()
    {
        return notificationType == 18 || notificationType == 25;
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
        parcel.writeString(avatarUrl);
        parcel.writeString(username);
        parcel.writeString(thumbnailUrl);
        parcel.writeString(comment);
        parcel.writeLong(notificationId);
        parcel.writeLong(userId);
        parcel.writeLong(postId);
        parcel.writeLong(createdAt);
        parcel.writeLong(conversationId);
        parcel.writeLong(unreadMessageCount);
        if (verified)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(notificationType);
        parcel.writeSerializable(entities);
        parcel.writeInt(followStatus);
        parcel.writeLong(conversationRowId);
        parcel.writeInt(messageCount);
        parcel.writeList(imageKeys);
        parcel.writeList(videoKeys);
    }

}
