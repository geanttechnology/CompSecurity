// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;

public class TwitterUser
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TwitterUser createFromParcel(Parcel parcel)
        {
            return new TwitterUser(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public TwitterUser[] newArray(int i)
        {
            return new TwitterUser[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public boolean defaultProfileImage;
    public String description;
    public String location;
    public String name;
    public String profileUrl;
    public String screenName;
    public String url;
    public long userId;

    public TwitterUser(Parcel parcel)
    {
        boolean flag = true;
        super();
        name = parcel.readString();
        screenName = parcel.readString();
        location = parcel.readString();
        description = parcel.readString();
        url = parcel.readString();
        profileUrl = parcel.readString();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        defaultProfileImage = flag;
        userId = parcel.readLong();
    }

    public TwitterUser(String s, String s1, String s2, String s3, String s4, String s5, boolean flag, 
            long l)
    {
        name = s;
        screenName = s1;
        location = s2;
        description = s3;
        url = s4;
        profileUrl = s5;
        defaultProfileImage = flag;
        userId = l;
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
            obj = (TwitterUser)obj;
            if (defaultProfileImage != ((TwitterUser) (obj)).defaultProfileImage)
            {
                return false;
            }
            if (userId != ((TwitterUser) (obj)).userId)
            {
                return false;
            }
            if (description == null ? ((TwitterUser) (obj)).description != null : !description.equals(((TwitterUser) (obj)).description))
            {
                return false;
            }
            if (location == null ? ((TwitterUser) (obj)).location != null : !location.equals(((TwitterUser) (obj)).location))
            {
                return false;
            }
            if (name == null ? ((TwitterUser) (obj)).name != null : !name.equals(((TwitterUser) (obj)).name))
            {
                return false;
            }
            if (profileUrl == null ? ((TwitterUser) (obj)).profileUrl != null : !profileUrl.equals(((TwitterUser) (obj)).profileUrl))
            {
                return false;
            }
            if (screenName == null ? ((TwitterUser) (obj)).screenName != null : !screenName.equals(((TwitterUser) (obj)).screenName))
            {
                return false;
            }
            if (url == null ? ((TwitterUser) (obj)).url != null : !url.equals(((TwitterUser) (obj)).url))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int k1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        if (name != null)
        {
            i = name.hashCode();
        } else
        {
            i = 0;
        }
        if (screenName != null)
        {
            j = screenName.hashCode();
        } else
        {
            j = 0;
        }
        if (location != null)
        {
            k = location.hashCode();
        } else
        {
            k = 0;
        }
        if (description != null)
        {
            l = description.hashCode();
        } else
        {
            l = 0;
        }
        if (url != null)
        {
            i1 = url.hashCode();
        } else
        {
            i1 = 0;
        }
        if (profileUrl != null)
        {
            j1 = profileUrl.hashCode();
        } else
        {
            j1 = 0;
        }
        if (defaultProfileImage)
        {
            k1 = 1;
        }
        return ((((((i * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + (int)(userId ^ userId >>> 32);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeString(screenName);
        parcel.writeString(location);
        parcel.writeString(description);
        parcel.writeString(url);
        parcel.writeString(profileUrl);
        if (defaultProfileImage)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeLong(userId);
    }

}
