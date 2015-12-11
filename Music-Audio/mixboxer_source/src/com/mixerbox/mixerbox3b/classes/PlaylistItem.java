// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;


public class PlaylistItem
{

    String cover;
    String id;
    Boolean isAlbum;
    String itemCount;
    String name;
    String ownerId;
    String ownerName;
    String subsCount;
    int type;

    public PlaylistItem(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            int i, boolean flag)
    {
        id = s;
        name = s1;
        ownerId = s2;
        ownerName = s3;
        itemCount = s4;
        subsCount = s5;
        cover = s6;
        type = i;
        isAlbum = Boolean.valueOf(flag);
    }

    public boolean getIsAlbum()
    {
        return isAlbum.booleanValue();
    }

    public String getPlaylistCover()
    {
        return cover;
    }

    public String getPlaylistId()
    {
        return id;
    }

    public String getPlaylistItemCount()
    {
        return itemCount;
    }

    public String getPlaylistName()
    {
        return name;
    }

    public String getPlaylistOwnerId()
    {
        return ownerId;
    }

    public String getPlaylistOwnerName()
    {
        return ownerName;
    }

    public String getPlaylistSubsCount()
    {
        return subsCount;
    }

    public int getPlaylistType()
    {
        return type;
    }

    public void putSubsCount(String s)
    {
        subsCount = s;
    }

    public void renamePlaylist(String s)
    {
        name = s;
    }
}
