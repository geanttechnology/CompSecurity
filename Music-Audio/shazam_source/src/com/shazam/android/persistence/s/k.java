// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.s;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.util.d.a;
import com.shazam.model.Tag;

// Referenced classes of package com.shazam.android.persistence.s:
//            l

public class k extends l
{

    public k(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase);
    }

    protected com.shazam.model.Tag.Builder a(Cursor cursor)
    {
        com.shazam.model.Tag.Builder builder = super.a(cursor);
        com.shazam.model.Track.Builder builder1 = com.shazam.model.Track.Builder.a(builder.b().track);
        builder1.key = com.shazam.android.util.d.a.a(cursor, "track_key");
        builder.track = builder1.b();
        return builder;
    }

    protected String c()
    {
        return "SELECT track.title as title, track.art_id as art_id, tag.track_key as track_key, tag.track_id as tag_track_id, tag.timestamp as timestamp, tag.datetime as datetime, tag.sig as tag_sig, tag.serialized_tag_context as serialized_tag_context, '0' as unread, tag.status as status, tag.lat as lat, tag.lon as lon, tag.alt as alt, tag.location_name as location_name, tag.short_datetime as short_datetime, tag.request_id as request_id, tag.event_id as event_id, NULL as ts, artist.name as artistName, NULL as sig FROM tag LEFT JOIN track ON tag.track_id=track._id LEFT JOIN artist_track ON tag.track_id=artist_track.track_id LEFT JOIN artist ON artist_track.artist_id=artist.id GROUP BY tag.datetime";
    }
}
