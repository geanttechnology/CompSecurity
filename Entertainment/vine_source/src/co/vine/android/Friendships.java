// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public class Friendships
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Friendships createFromParcel(Parcel parcel)
        {
            return new Friendships(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Friendships[] newArray(int i)
        {
            return new Friendships[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int FRIEND_FOLLOWING = 1;
    public static final int FRIEND_NONE = 0;
    public static final int FRIEND_UNDEFINED = -1;
    private HashMap mCache;

    public Friendships()
    {
        mCache = new HashMap();
    }

    public Friendships(Parcel parcel)
    {
        mCache = (HashMap)parcel.readSerializable();
    }

    public static int setFriendship(int i, int j)
    {
        return i | j;
    }

    public static int unsetFriendship(int i, int j)
    {
        return ~j & i;
    }

    public void addFollowing(long l)
    {
        Integer integer = (Integer)mCache.get(Long.valueOf(l));
        if (integer == null)
        {
            mCache.put(Long.valueOf(l), Integer.valueOf(setFriendship(0, 1)));
            return;
        } else
        {
            mCache.put(Long.valueOf(l), Integer.valueOf(setFriendship(integer.intValue(), 1)));
            return;
        }
    }

    public void clear()
    {
        mCache.clear();
    }

    public boolean contains(long l)
    {
        return mCache.containsKey(Long.valueOf(l));
    }

    public boolean contains(long l, int i)
    {
        Integer integer = (Integer)mCache.get(Long.valueOf(l));
        return integer != null && integer.intValue() == i;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean isEmpty()
    {
        return mCache.isEmpty();
    }

    public boolean isFollowing(long l)
    {
        Integer integer = (Integer)mCache.get(Long.valueOf(l));
        return integer != null && (integer.intValue() & 1) != 0;
    }

    public void removeFollowing(long l)
    {
        Integer integer = (Integer)mCache.get(Long.valueOf(l));
        if (integer == null)
        {
            mCache.put(Long.valueOf(l), Integer.valueOf(unsetFriendship(0, 1)));
            return;
        } else
        {
            mCache.put(Long.valueOf(l), Integer.valueOf(unsetFriendship(integer.intValue(), 1)));
            return;
        }
    }

    public int size()
    {
        return mCache.size();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mCache);
    }

}
