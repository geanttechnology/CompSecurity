// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c;

import com.shazam.b.a.a;
import com.shazam.model.AddOn;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import com.shazam.model.details.UriIdentifiedTag;
import java.util.Iterator;
import java.util.List;

public final class p
    implements a
{

    public p()
    {
    }

    public final Object a(Object obj)
    {
        Tag tag;
        com.shazam.model.lyrics.DynamicLyricsData.Builder builder;
        Iterator iterator;
        tag = ((UriIdentifiedTag)obj).tag;
        obj = tag.track;
        builder = com.shazam.model.lyrics.DynamicLyricsData.Builder.a();
        iterator = ((Track) (obj)).addOns.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        obj = (AddOn)iterator.next();
        if (!"Lyrics".equals(((AddOn) (obj)).providerName)) goto _L4; else goto _L3
_L3:
        if (obj != null)
        {
            builder.tagTimestamp = tag.timestamp;
            builder.coverArt = tag.b();
            builder.title = tag.track.title;
            builder.lyricPlay = ((AddOn) (obj)).lyricPlay;
            builder.copyright = ((AddOn) (obj)).copyright;
            builder.writers = ((AddOn) (obj)).writers;
        }
        return builder.b();
_L2:
        obj = null;
        if (true) goto _L3; else goto _L5
_L5:
    }
}
