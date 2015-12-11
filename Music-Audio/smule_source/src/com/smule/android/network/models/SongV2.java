// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.smule.android.network.models:
//            PartnerArtistV2, ResourceV2

public class SongV2
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SongV2 a(Parcel parcel)
        {
            return new SongV2(parcel);
        }

        public SongV2[] a(int i)
        {
            return new SongV2[i];
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
    public String artist;
    public String artistGender;
    public String artistTwitter;
    public int difficulty;
    public String eTag;
    public boolean enabled;
    public String extraData;
    public String genre;
    public boolean globe;
    public String googleCoverArtUrl;
    public String newEtag;
    public PartnerArtistV2 partnerArtist;
    public String performanceKey;
    public String previewUrl;
    public int releaseYear;
    public HashMap resourceFilePaths;
    public List resources;
    public String songId;
    public List tags;
    public String title;
    public long ts;
    public String webUrl;

    public SongV2()
    {
        resources = new ArrayList();
        resourceFilePaths = new HashMap();
    }

    public SongV2(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        resources = new ArrayList();
        resourceFilePaths = new HashMap();
        songId = parcel.readString();
        ts = parcel.readLong();
        title = parcel.readString();
        artist = parcel.readString();
        artistGender = parcel.readString();
        releaseYear = parcel.readInt();
        previewUrl = parcel.readString();
        performanceKey = parcel.readString();
        genre = parcel.readString();
        extraData = parcel.readString();
        boolean flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        globe = flag;
        difficulty = parcel.readInt();
        if (parcel.readByte() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        enabled = flag;
        partnerArtist = (PartnerArtistV2)parcel.readParcelable(com/smule/android/network/models/PartnerArtistV2.getClassLoader());
        webUrl = parcel.readString();
        eTag = parcel.readString();
        newEtag = parcel.readString();
        googleCoverArtUrl = parcel.readString();
        resourceFilePaths = (HashMap)parcel.readSerializable();
        artistTwitter = parcel.readString();
        tags = new ArrayList();
        parcel.readStringList(tags);
        parcel.readTypedList(resources, ResourceV2.CREATOR);
    }

    public String a(String s)
    {
        if (resourceFilePaths == null)
        {
            return null;
        } else
        {
            return (String)resourceFilePaths.get(s);
        }
    }

    public void a(SongV2 songv2)
    {
        artist = songv2.artist;
        artistGender = songv2.artistGender;
        releaseYear = songv2.releaseYear;
        title = songv2.title;
        genre = songv2.genre;
        webUrl = songv2.webUrl;
        eTag = songv2.eTag;
        extraData = songv2.extraData;
        performanceKey = songv2.performanceKey;
        artistTwitter = songv2.artistTwitter;
        tags = songv2.tags;
        resources = songv2.resources;
    }

    public boolean a()
    {
        if (newEtag != null)
        {
            if (eTag == null)
            {
                return true;
            }
            if (newEtag.compareTo(eTag) != 0)
            {
                return true;
            }
        }
        return false;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(songId);
        parcel.writeLong(ts);
        parcel.writeString(title);
        parcel.writeString(artist);
        parcel.writeString(artistGender);
        parcel.writeInt(releaseYear);
        String s;
        if (previewUrl == null)
        {
            s = "";
        } else
        {
            s = previewUrl;
        }
        parcel.writeString(s);
        if (performanceKey == null)
        {
            s = "";
        } else
        {
            s = performanceKey;
        }
        parcel.writeString(s);
        if (genre == null)
        {
            s = "";
        } else
        {
            s = genre;
        }
        parcel.writeString(s);
        if (extraData == null)
        {
            s = "";
        } else
        {
            s = extraData;
        }
        parcel.writeString(s);
        if (globe)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeInt(difficulty);
        if (enabled)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeParcelable(partnerArtist, 0);
        if (webUrl == null)
        {
            s = "";
        } else
        {
            s = webUrl;
        }
        parcel.writeString(s);
        if (eTag == null)
        {
            s = "";
        } else
        {
            s = eTag;
        }
        parcel.writeString(s);
        if (newEtag == null)
        {
            s = "";
        } else
        {
            s = newEtag;
        }
        parcel.writeString(s);
        if (googleCoverArtUrl == null)
        {
            s = "";
        } else
        {
            s = googleCoverArtUrl;
        }
        parcel.writeString(s);
        parcel.writeSerializable(resourceFilePaths);
        parcel.writeString(artistTwitter);
        parcel.writeStringList(tags);
        parcel.writeTypedList(resources);
    }

}
