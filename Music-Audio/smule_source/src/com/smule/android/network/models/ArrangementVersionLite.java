// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.smule.android.network.models:
//            AccountIcon, ArrangementVersion

public class ArrangementVersionLite
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ArrangementVersionLite a(Parcel parcel)
        {
            return new ArrangementVersionLite(parcel);
        }

        public ArrangementVersionLite[] a(int i)
        {
            return new ArrangementVersionLite[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    public static final int VOTES_THRESHOLD = 3;
    public AccountIcon accountIcon;
    public long arrCreatedAt;
    public ArrangementVersion arrangementVersion;
    public String coverUrl;
    public boolean highlyRated;
    public String key;
    public boolean lyrics;
    public String name;
    public Float rating;
    public String songId;
    public int totalVotes;
    public int version;

    public ArrangementVersionLite()
    {
    }

    private ArrangementVersionLite(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        key = parcel.readString();
        version = parcel.readInt();
        accountIcon = (AccountIcon)parcel.readParcelable(com/smule/android/network/models/AccountIcon.getClassLoader());
        name = parcel.readString();
        songId = parcel.readString();
        rating = (Float)parcel.readValue(java/lang/Float.getClassLoader());
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        highlyRated = flag;
        totalVotes = parcel.readInt();
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        lyrics = flag;
        coverUrl = parcel.readString();
        arrCreatedAt = parcel.readLong();
        arrangementVersion = (ArrangementVersion)parcel.readParcelable(com/smule/android/network/models/ArrangementVersion.getClassLoader());
    }


    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof ArrangementVersionLite))
            {
                return false;
            }
            obj = (ArrangementVersionLite)obj;
            if (arrCreatedAt != ((ArrangementVersionLite) (obj)).arrCreatedAt)
            {
                return false;
            }
            if (highlyRated != ((ArrangementVersionLite) (obj)).highlyRated)
            {
                return false;
            }
            if (lyrics != ((ArrangementVersionLite) (obj)).lyrics)
            {
                return false;
            }
            if (totalVotes != ((ArrangementVersionLite) (obj)).totalVotes)
            {
                return false;
            }
            if (version != ((ArrangementVersionLite) (obj)).version)
            {
                return false;
            }
            if (accountIcon == null ? ((ArrangementVersionLite) (obj)).accountIcon != null : !accountIcon.equals(((ArrangementVersionLite) (obj)).accountIcon))
            {
                return false;
            }
            if (arrangementVersion == null ? ((ArrangementVersionLite) (obj)).arrangementVersion != null : !arrangementVersion.equals(((ArrangementVersionLite) (obj)).arrangementVersion))
            {
                return false;
            }
            if (coverUrl == null ? ((ArrangementVersionLite) (obj)).coverUrl != null : !coverUrl.equals(((ArrangementVersionLite) (obj)).coverUrl))
            {
                return false;
            }
            if (key == null ? ((ArrangementVersionLite) (obj)).key != null : !key.equals(((ArrangementVersionLite) (obj)).key))
            {
                return false;
            }
            if (name == null ? ((ArrangementVersionLite) (obj)).name != null : !name.equals(((ArrangementVersionLite) (obj)).name))
            {
                return false;
            }
            if (rating == null ? ((ArrangementVersionLite) (obj)).rating != null : !rating.equals(((ArrangementVersionLite) (obj)).rating))
            {
                return false;
            }
            if (songId == null ? ((ArrangementVersionLite) (obj)).songId != null : !songId.equals(((ArrangementVersionLite) (obj)).songId))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int k1 = 1;
        int i2 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int l1;
        int j2;
        int k2;
        int l2;
        if (key != null)
        {
            i = key.hashCode();
        } else
        {
            i = 0;
        }
        j2 = version;
        if (accountIcon != null)
        {
            j = accountIcon.hashCode();
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
        if (songId != null)
        {
            l = songId.hashCode();
        } else
        {
            l = 0;
        }
        if (rating != null)
        {
            i1 = rating.hashCode();
        } else
        {
            i1 = 0;
        }
        if (highlyRated)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        k2 = totalVotes;
        if (!lyrics)
        {
            k1 = 0;
        }
        if (coverUrl != null)
        {
            l1 = coverUrl.hashCode();
        } else
        {
            l1 = 0;
        }
        l2 = (int)(arrCreatedAt ^ arrCreatedAt >>> 32);
        if (arrangementVersion != null)
        {
            i2 = arrangementVersion.hashCode();
        }
        return ((l1 + (((j1 + (i1 + (l + (k + (j + (i * 31 + j2) * 31) * 31) * 31) * 31) * 31) * 31 + k2) * 31 + k1) * 31) * 31 + l2) * 31 + i2;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ArrangementVersionLite{key='").append(key).append('\'').append(", version=").append(version).append(", accountIcon=").append(accountIcon).append(", name='").append(name).append('\'').append(", songId='").append(songId).append('\'').append(", rating=").append(rating).append(", highlyRated=").append(highlyRated).append(", totalVotes=").append(totalVotes).append(", lyrics=").append(lyrics).append(", coverUrl='").append(coverUrl).append('\'').append(", arrCreatedAt=").append(arrCreatedAt).append(", arrangementVersion=").append(arrangementVersion).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(key);
        parcel.writeInt(version);
        parcel.writeParcelable(accountIcon, 0);
        parcel.writeString(name);
        parcel.writeString(songId);
        parcel.writeValue(rating);
        byte byte0;
        if (highlyRated)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeInt(totalVotes);
        if (lyrics)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeString(coverUrl);
        parcel.writeLong(arrCreatedAt);
        parcel.writeParcelable(arrangementVersion, 0);
    }

}
