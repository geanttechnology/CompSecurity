// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.s;

import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.shazam.android.persistence.s:
//            m

public final class d extends m
{

    public d(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase);
    }

    protected final String c()
    {
        return "SELECT track.title as title, track.art_id as art_id, track.id_track_type as id_track_type, tag.track_key as track_key, tag.track_id as tag_track_id, tag.timestamp as timestamp, tag.datetime as datetime, tag.sig as tag_sig, tag.serialized_tag_context as serialized_tag_context, tag.json asjson, '0' as unread, tag.status as status, tag.lat as lat, tag.lon as lon, tag.alt as alt, tag.location_name as location_name, tag.short_datetime as short_datetime, tag.request_id as request_id, tag.event_id as event_id, NULL as ts, track.artist_name as artistName, NULL as sig FROM tag LEFT JOIN track ON tag.track_id=track._id GROUP BY tag.datetime";
    }
}
