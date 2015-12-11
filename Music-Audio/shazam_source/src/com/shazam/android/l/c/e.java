// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.c;

import android.content.ContentValues;
import com.shazam.b.a.a;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import com.shazam.model.location.SimpleLocation;
import com.shazam.o.d;
import java.util.Date;

public final class e
    implements a
{

    public e()
    {
    }

    public final Object a(Object obj)
    {
        obj = (Tag)obj;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("request_id", ((Tag) (obj)).requestId);
        contentvalues.put("track_id", ((Tag) (obj)).track.id);
        contentvalues.put("track_key", ((Tag) (obj)).track.key);
        contentvalues.put("datetime", ((Tag) (obj)).dateTime);
        contentvalues.put("short_datetime", d.b(new Date(((Tag) (obj)).timestamp)));
        contentvalues.put("timestamp", Long.valueOf(((Tag) (obj)).timestamp));
        contentvalues.put("sig", ((Tag) (obj)).sig);
        contentvalues.put("json", ((Tag) (obj)).json);
        contentvalues.put("status", ((Tag) (obj)).status.getDbString());
        SimpleLocation simplelocation = ((Tag) (obj)).location;
        if (simplelocation != null)
        {
            contentvalues.put("lat", Double.valueOf(simplelocation.latitude));
            contentvalues.put("lon", Double.valueOf(simplelocation.longitude));
            contentvalues.put("alt", Double.valueOf(simplelocation.a()));
            contentvalues.put("location_name", ((Tag) (obj)).locationName);
        }
        contentvalues.put("offset", ((Tag) (obj)).lyricOffset);
        contentvalues.put("skew", ((Tag) (obj)).lyricSkew);
        contentvalues.put("frequency_skew", ((Tag) (obj)).frequencySkew);
        contentvalues.put("event_id", ((Tag) (obj)).eventId);
        contentvalues.put("unread", Boolean.valueOf(((Tag) (obj)).unread));
        return contentvalues;
    }
}
