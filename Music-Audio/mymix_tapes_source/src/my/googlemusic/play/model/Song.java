// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.model;

import java.io.File;
import my.googlemusic.play.servers.LinkBuilder;

// Referenced classes of package my.googlemusic.play.model:
//            Album, Artist

public class Song
{

    private boolean active;
    private Album album;
    private boolean bit160;
    private boolean bit96;
    private long hits;
    private long id;
    private String name;
    private String url;

    public Song()
    {
    }

    public Song(long l, String s, Album album1, String s1, boolean flag, boolean flag1, 
            long l1, boolean flag2)
    {
        id = l;
        name = s;
        album = album1;
        bit96 = flag;
        bit160 = flag1;
        hits = l1;
        active = flag2;
        url = s1;
    }

    public Album getAlbum()
    {
        return album;
    }

    public long getHits()
    {
        return hits;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getUrl()
    {
        return LinkBuilder.get().mountSong(id, name, album.getId(), album.getName(), album.getArtist().getName(), bit96, bit160);
    }

    public boolean isActive()
    {
        return active;
    }

    public boolean isBit160()
    {
        return bit160;
    }

    public boolean isBit96()
    {
        return bit96;
    }

    public boolean isDownloaded()
    {
        return (new File(getUrl())).exists();
    }

    public void setActive(boolean flag)
    {
        active = flag;
    }

    public void setAlbum(Album album1)
    {
        album = album1;
    }

    public void setBit160(boolean flag)
    {
        bit160 = flag;
    }

    public void setBit96(boolean flag)
    {
        bit96 = flag;
    }

    public void setHits(long l)
    {
        hits = l;
    }

    public void setId(long l)
    {
        id = l;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
