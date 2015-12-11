// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.smule.android.network.models:
//            AccountIcon

public class Arrangement
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Arrangement a(Parcel parcel)
        {
            return new Arrangement(parcel);
        }

        public Arrangement[] a(int i)
        {
            return new Arrangement[i];
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
    public boolean coprDisable;
    public long createdAt;
    public boolean highlyRated;
    public String key;
    public int lastPublishedVer;
    public String name;
    public AccountIcon ownerAccountIcon;
    public Float rating;
    public String songId;
    public List tags;
    public int totalVotes;

    public Arrangement()
    {
        tags = new ArrayList();
    }

    private Arrangement(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        tags = new ArrayList();
        key = parcel.readString();
        ownerAccountIcon = (AccountIcon)parcel.readParcelable(com/smule/android/network/models/AccountIcon.getClassLoader());
        name = parcel.readString();
        songId = parcel.readString();
        tags = new ArrayList();
        parcel.readList(tags, java/util/List.getClassLoader());
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
        coprDisable = flag;
        lastPublishedVer = parcel.readInt();
        createdAt = parcel.readLong();
    }


    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Arrangement))
            {
                return false;
            }
            obj = (Arrangement)obj;
            if (coprDisable != ((Arrangement) (obj)).coprDisable)
            {
                return false;
            }
            if (createdAt != ((Arrangement) (obj)).createdAt)
            {
                return false;
            }
            if (highlyRated != ((Arrangement) (obj)).highlyRated)
            {
                return false;
            }
            if (lastPublishedVer != ((Arrangement) (obj)).lastPublishedVer)
            {
                return false;
            }
            if (totalVotes != ((Arrangement) (obj)).totalVotes)
            {
                return false;
            }
            if (key == null ? ((Arrangement) (obj)).key != null : !key.equals(((Arrangement) (obj)).key))
            {
                return false;
            }
            if (name == null ? ((Arrangement) (obj)).name != null : !name.equals(((Arrangement) (obj)).name))
            {
                return false;
            }
            if (ownerAccountIcon == null ? ((Arrangement) (obj)).ownerAccountIcon != null : !ownerAccountIcon.equals(((Arrangement) (obj)).ownerAccountIcon))
            {
                return false;
            }
            if (rating == null ? ((Arrangement) (obj)).rating != null : !rating.equals(((Arrangement) (obj)).rating))
            {
                return false;
            }
            if (songId == null ? ((Arrangement) (obj)).songId != null : !songId.equals(((Arrangement) (obj)).songId))
            {
                return false;
            }
            if (tags == null ? ((Arrangement) (obj)).tags != null : !tags.equals(((Arrangement) (obj)).tags))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int l1 = 1;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int i2;
        if (key != null)
        {
            i = key.hashCode();
        } else
        {
            i = 0;
        }
        if (ownerAccountIcon != null)
        {
            j = ownerAccountIcon.hashCode();
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
        if (tags != null)
        {
            i1 = tags.hashCode();
        } else
        {
            i1 = 0;
        }
        if (rating != null)
        {
            j1 = rating.hashCode();
        } else
        {
            j1 = 0;
        }
        if (highlyRated)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        i2 = totalVotes;
        if (!coprDisable)
        {
            l1 = 0;
        }
        return ((((k1 + (j1 + (i1 + (l + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i2) * 31 + l1) * 31 + lastPublishedVer) * 31 + (int)(createdAt ^ createdAt >>> 32);
    }

    public String toString()
    {
        return (new StringBuilder()).append("Arrangement{key='").append(key).append('\'').append(", ownerAccountIcon=").append(ownerAccountIcon).append(", name='").append(name).append('\'').append(", songId='").append(songId).append('\'').append(", tags=").append(tags).append(", rating=").append(rating).append(", highlyRated=").append(highlyRated).append(", totalVotes=").append(totalVotes).append(", coprDisable=").append(coprDisable).append(", lastPublishedVer=").append(lastPublishedVer).append(", createdAt=").append(createdAt).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(key);
        parcel.writeParcelable(ownerAccountIcon, 0);
        parcel.writeString(name);
        parcel.writeString(songId);
        parcel.writeList(tags);
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
        if (coprDisable)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        parcel.writeInt(lastPublishedVer);
        parcel.writeLong(createdAt);
    }

}
