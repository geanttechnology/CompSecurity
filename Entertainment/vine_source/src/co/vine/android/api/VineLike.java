// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package co.vine.android.api:
//            VineUser

public class VineLike
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineLike createFromParcel(Parcel parcel)
        {
            return new VineLike(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineLike[] newArray(int i)
        {
            return new VineLike[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String avatarUrl;
    public long created;
    public long likeId;
    public String location;
    public long postId;
    public VineUser user;
    public long userId;
    public String username;
    public int verified;

    public VineLike()
    {
    }

    public VineLike(Parcel parcel)
    {
        postId = parcel.readLong();
        avatarUrl = parcel.readString();
        location = parcel.readString();
        username = parcel.readString();
        created = parcel.readLong();
        likeId = parcel.readLong();
        userId = parcel.readLong();
        verified = parcel.readInt();
        user = (VineUser)parcel.readParcelable(co/vine/android/api/VineUser.getClassLoader());
    }

    public static VineLike from(Cursor cursor)
    {
        VineLike vinelike = new VineLike();
        vinelike.postId = cursor.getInt(1);
        vinelike.avatarUrl = cursor.getString(28);
        vinelike.location = cursor.getString(31);
        vinelike.username = cursor.getString(32);
        vinelike.created = cursor.getLong(30);
        vinelike.likeId = cursor.getLong(27);
        vinelike.userId = cursor.getLong(29);
        vinelike.verified = cursor.getInt(33);
        return vinelike;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (VineLike)obj;
            if (created != ((VineLike) (obj)).created)
            {
                return false;
            }
            if (likeId != ((VineLike) (obj)).likeId)
            {
                return false;
            }
            if (postId != ((VineLike) (obj)).postId)
            {
                return false;
            }
            if (userId != ((VineLike) (obj)).userId)
            {
                return false;
            }
            if (verified != ((VineLike) (obj)).verified)
            {
                return false;
            }
            if (avatarUrl == null ? ((VineLike) (obj)).avatarUrl != null : !avatarUrl.equals(((VineLike) (obj)).avatarUrl))
            {
                return false;
            }
            if (location == null ? ((VineLike) (obj)).location != null : !location.equals(((VineLike) (obj)).location))
            {
                return false;
            }
            if (user == null ? ((VineLike) (obj)).user != null : !user.equals(((VineLike) (obj)).user))
            {
                return false;
            }
            if (username == null ? ((VineLike) (obj)).username != null : !username.equals(((VineLike) (obj)).username))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int l = 0;
        int i1 = (int)(postId ^ postId >>> 32);
        int i;
        int j;
        int k;
        int j1;
        int k1;
        int l1;
        int i2;
        if (avatarUrl != null)
        {
            i = avatarUrl.hashCode();
        } else
        {
            i = 0;
        }
        if (location != null)
        {
            j = location.hashCode();
        } else
        {
            j = 0;
        }
        if (username != null)
        {
            k = username.hashCode();
        } else
        {
            k = 0;
        }
        j1 = (int)(created ^ created >>> 32);
        k1 = (int)(likeId ^ likeId >>> 32);
        l1 = (int)(userId ^ userId >>> 32);
        i2 = verified;
        if (user != null)
        {
            l = user.hashCode();
        }
        return (((((((i1 * 31 + i) * 31 + j) * 31 + k) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + l;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(postId);
        parcel.writeString(avatarUrl);
        parcel.writeString(location);
        parcel.writeString(username);
        parcel.writeLong(created);
        parcel.writeLong(likeId);
        parcel.writeLong(userId);
        parcel.writeInt(verified);
        parcel.writeParcelable(user, i);
    }

}
