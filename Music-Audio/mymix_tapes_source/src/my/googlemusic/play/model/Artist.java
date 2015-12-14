// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.model;

import android.os.Parcel;
import android.os.Parcelable;
import my.googlemusic.play.servers.LinkBuilder;

public class Artist
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    String description;
    long id;
    String image;
    String instagram;
    String name;
    String twitter;

    public Artist(long l, String s, String s1, String s2, String s3)
    {
        image = LinkBuilder.get().mountImageArtist(l);
        id = l;
        name = s;
        twitter = s1;
        instagram = s2;
        description = s3;
    }

    private Artist(Parcel parcel)
    {
        id = parcel.readLong();
        name = parcel.readString();
        image = parcel.readString();
        twitter = parcel.readString();
        instagram = parcel.readString();
        description = parcel.readString();
    }

    Artist(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public static Artist newTestInstance()
    {
        return new Artist(1L, "King Los", "@kinglos", "", "");
    }

    public int describeContents()
    {
        return 0;
    }

    public String getDescription()
    {
        return description;
    }

    public long getId()
    {
        return id;
    }

    public String getImage()
    {
        return image;
    }

    public String getInstagram()
    {
        return instagram;
    }

    public String getName()
    {
        return name;
    }

    public String getTwitter()
    {
        return twitter;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeString(image);
        parcel.writeString(twitter);
        parcel.writeString(instagram);
        parcel.writeString(description);
    }


    /* member class not found */
    class _cls1 {}

}
