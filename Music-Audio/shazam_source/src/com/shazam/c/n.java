// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c;

import com.shazam.b.a.a;
import com.shazam.model.TrackCategory;
import com.shazam.server.response.product.Track;

public final class n
    implements a
{

    public n()
    {
    }

    public final Object a(Object obj)
    {
        obj = (Track)obj;
        com.shazam.model.Track.Builder builder = com.shazam.model.Track.Builder.a();
        builder.id = ((Track) (obj)).trackId;
        builder.title = ((Track) (obj)).title;
        builder.subtitle = ((Track) (obj)).subtitle;
        builder.category = TrackCategory.fromString(((Track) (obj)).type);
        return builder.b();
    }
}
