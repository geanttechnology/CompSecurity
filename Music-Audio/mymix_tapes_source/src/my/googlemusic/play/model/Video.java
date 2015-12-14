// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.model;

import android.os.Parcel;
import android.os.Parcelable;
import my.googlemusic.play.servers.LinkBuilder;

public class Video
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    String artist;
    String image;
    String name;
    String url;
    long views;

    public Video(Parcel parcel)
    {
        name = parcel.readString();
        artist = parcel.readString();
        image = parcel.readString();
        url = parcel.readString();
        views = parcel.readLong();
    }

    public Video(String s, String s1, String s2, long l)
    {
        name = s1;
        artist = s2;
        image = LinkBuilder.get().mountVideoImage(s);
        url = LinkBuilder.get().mountVideoStream(s);
        views = l;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getImage()
    {
        return image;
    }

    public String getName()
    {
        return name;
    }

    public String getUrl()
    {
        return url;
    }

    public long getViews()
    {
        return views;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeString(artist);
        parcel.writeString(image);
        parcel.writeString(url);
        parcel.writeLong(views);
    }


    /* member class not found */
    class _cls1 {}

}
