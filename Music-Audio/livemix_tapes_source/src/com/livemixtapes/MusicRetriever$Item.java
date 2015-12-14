// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.ContentUris;
import android.net.Uri;

// Referenced classes of package com.livemixtapes:
//            MusicRetriever

public static class duration
{

    String album;
    String artist;
    long duration;
    long id;
    String title;

    public String getAlbum()
    {
        return album;
    }

    public String getArtist()
    {
        return artist;
    }

    public long getDuration()
    {
        return duration;
    }

    public long getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public Uri getURI()
    {
        return ContentUris.withAppendedId(android.provider.ia.EXTERNAL_CONTENT_URI, id);
    }

    public ia(long l, String s, String s1, String s2, long l1)
    {
        id = l;
        artist = s;
        title = s1;
        album = s2;
        duration = l1;
    }
}
