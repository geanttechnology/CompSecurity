// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.model;

import java.util.ArrayList;
import java.util.Date;
import my.googlemusic.play.servers.LinkBuilder;

// Referenced classes of package my.googlemusic.play.model:
//            Artist

public class Album
    implements Comparable
{

    public static String THUMB_500x500 = "500x500.jpg";
    boolean active;
    Artist artist;
    boolean biggerFeatures;
    boolean biggerJustAdded;
    boolean biggerSingles;
    long commentsCount;
    boolean deleted;
    boolean download;
    boolean feature;
    long featureOrder;
    boolean hidden;
    long hits;
    long id;
    private String image;
    long imageVersion;
    boolean justAdded;
    long likes;
    String link;
    String name;
    Date releaseDate;
    boolean restricted;
    boolean single;
    long singleOrder;
    ArrayList songs;

    public Album()
    {
    }

    public Album(long l, String s, Artist artist1, long l1, long l2, long l3, boolean flag, boolean flag1, boolean flag2, boolean flag3, 
            long l4, String s1, String s2, boolean flag4, boolean flag5, boolean flag6, 
            boolean flag7, long l5, long l6, boolean flag8, boolean flag9, 
            boolean flag10)
    {
        id = l;
        name = s;
        artist = artist1;
        hits = l1;
        likes = l2;
        commentsCount = l3;
        biggerFeatures = flag;
        biggerJustAdded = flag1;
        biggerSingles = flag2;
        restricted = flag3;
        imageVersion = l4;
        s = s1;
        if (s1 == null)
        {
            s = LinkBuilder.get().mountImage(l, l4);
        }
        image = s;
        link = s2;
        hidden = flag4;
        single = flag7;
        feature = flag5;
        justAdded = flag6;
        singleOrder = l6;
        featureOrder = l5;
        active = flag8;
        deleted = flag9;
        download = flag10;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Album)obj);
    }

    public int compareTo(Album album)
    {
        return name.compareTo(album.getName());
    }

    public Artist getArtist()
    {
        return artist;
    }

    public long getCommentsCount()
    {
        return commentsCount;
    }

    public long getFeatureOrder()
    {
        return featureOrder;
    }

    public long getHits()
    {
        return hits;
    }

    public long getId()
    {
        return id;
    }

    public String getImage()
    {
        return LinkBuilder.get().mountAlbumImage(id, imageVersion, THUMB_500x500);
    }

    public long getLikes()
    {
        return likes;
    }

    public String getLink()
    {
        return link;
    }

    public String getName()
    {
        return name;
    }

    public Date getReleaseDate()
    {
        return releaseDate;
    }

    public long getSingleOrder()
    {
        return singleOrder;
    }

    public ArrayList getSongs()
    {
        return songs;
    }

    public boolean isActive()
    {
        return active;
    }

    public boolean isBiggerFeatures()
    {
        return biggerFeatures;
    }

    public boolean isBiggerJustAdded()
    {
        return biggerJustAdded;
    }

    public boolean isBiggerSingles()
    {
        return biggerSingles;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public boolean isDownload()
    {
        return download;
    }

    public boolean isFeature()
    {
        return feature;
    }

    public boolean isHidden()
    {
        return hidden;
    }

    public boolean isJustAdded()
    {
        return justAdded;
    }

    public boolean isRestricted()
    {
        return restricted;
    }

    public boolean isSingle()
    {
        return single;
    }

    public void setArtist(Artist artist1)
    {
        artist = artist1;
    }

    public void setDownload(boolean flag)
    {
        download = flag;
    }

    public void setReleaseDate(Date date)
    {
        releaseDate = date;
    }

    public void setSongs(ArrayList arraylist)
    {
        songs = arraylist;
    }

}
