// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;

public class VineLogin
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineLogin createFromParcel(Parcel parcel)
        {
            return new VineLogin(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineLogin[] newArray(int i)
        {
            return new VineLogin[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int LOGIN_TYPE_EMAIL = 1;
    public static final int LOGIN_TYPE_TWITTER = 2;
    public String edition;
    public String key;
    public int loginType;
    public String name;
    public String twitterSecret;
    public String twitterToken;
    public long twitterUserId;
    public String twitterUsername;
    public long userId;
    public String username;

    public VineLogin(Parcel parcel)
    {
        key = parcel.readString();
        username = parcel.readString();
        name = parcel.readString();
        twitterUsername = parcel.readString();
        twitterToken = parcel.readString();
        twitterSecret = parcel.readString();
        userId = parcel.readLong();
        twitterUserId = parcel.readLong();
        loginType = parcel.readInt();
        edition = parcel.readString();
    }

    public VineLogin(String s, String s1, long l, String s2)
    {
        key = s;
        username = s1;
        userId = l;
        loginType = 1;
        edition = s2;
    }

    public VineLogin(String s, String s1, String s2, String s3, long l, String s4)
    {
        key = s;
        twitterUsername = s1;
        twitterToken = s2;
        twitterSecret = s3;
        twitterUserId = l;
        loginType = 2;
        edition = s4;
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
            obj = (VineLogin)obj;
            if (loginType != ((VineLogin) (obj)).loginType)
            {
                return false;
            }
            if (twitterUserId != ((VineLogin) (obj)).twitterUserId)
            {
                return false;
            }
            if (userId != ((VineLogin) (obj)).userId)
            {
                return false;
            }
            if (key == null ? ((VineLogin) (obj)).key != null : !key.equals(((VineLogin) (obj)).key))
            {
                return false;
            }
            if (name == null ? ((VineLogin) (obj)).name != null : !name.equals(((VineLogin) (obj)).name))
            {
                return false;
            }
            if (twitterSecret == null ? ((VineLogin) (obj)).twitterSecret != null : !twitterSecret.equals(((VineLogin) (obj)).twitterSecret))
            {
                return false;
            }
            if (twitterToken == null ? ((VineLogin) (obj)).twitterToken != null : !twitterToken.equals(((VineLogin) (obj)).twitterToken))
            {
                return false;
            }
            if (twitterUsername == null ? ((VineLogin) (obj)).twitterUsername != null : !twitterUsername.equals(((VineLogin) (obj)).twitterUsername))
            {
                return false;
            }
            if (username == null ? ((VineLogin) (obj)).username != null : !username.equals(((VineLogin) (obj)).username))
            {
                return false;
            }
            if (edition == null ? ((VineLogin) (obj)).edition != null : !edition.equals(((VineLogin) (obj)).edition))
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
        int l1;
        int i2;
        int j2;
        if (key != null)
        {
            i = key.hashCode();
        } else
        {
            i = 0;
        }
        if (username != null)
        {
            j = username.hashCode();
        } else
        {
            j = 0;
        }
        if (name != null)
        {
            k = name.hashCode();
        } else
        {
            k = 0;
        }
        if (twitterToken != null)
        {
            l = twitterToken.hashCode();
        } else
        {
            l = 0;
        }
        if (twitterSecret != null)
        {
            i1 = twitterSecret.hashCode();
        } else
        {
            i1 = 0;
        }
        if (twitterUsername != null)
        {
            j1 = twitterUsername.hashCode();
        } else
        {
            j1 = 0;
        }
        l1 = (int)(userId ^ userId >>> 32);
        i2 = (int)(twitterUserId ^ twitterUserId >>> 32);
        j2 = loginType;
        if (edition != null)
        {
            k1 = edition.hashCode();
        }
        return ((((((((i * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(key);
        parcel.writeString(username);
        parcel.writeString(name);
        parcel.writeString(twitterUsername);
        parcel.writeString(twitterToken);
        parcel.writeString(twitterSecret);
        parcel.writeLong(userId);
        parcel.writeLong(twitterUserId);
        parcel.writeInt(loginType);
        parcel.writeString(edition);
    }

}
