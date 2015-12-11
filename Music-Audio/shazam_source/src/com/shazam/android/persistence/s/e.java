// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.s;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.util.d.a;
import java.util.List;

// Referenced classes of package com.shazam.android.persistence.s:
//            k, a

public class e extends k
{

    public e(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase);
    }

    protected com.shazam.model.Tag.Builder a(Cursor cursor)
    {
        com.shazam.model.Tag.Builder builder = super.a(cursor);
        builder.json = com.shazam.android.util.d.a.a(cursor, "json");
        return builder;
    }

    public final List b()
    {
        return com.shazam.i.b.ah.e.a.a(super.a).b();
    }

    protected String c()
    {
        return "SELECT track.title as title, track.art_id as art_id, tag.track_key as track_key, tag.track_id as tag_track_id, tag.timestamp as timestamp, tag.datetime as datetime, tag.sig as tag_sig, tag.serialized_tag_context as serialized_tag_context, tag.json asjson, '0' as unread, tag.status as status, tag.lat as lat, tag.lon as lon, tag.alt as alt, tag.location_name as location_name, tag.short_datetime as short_datetime, tag.request_id as request_id, tag.event_id as event_id, artist.name as artistName, NULL as ts, NULL as sig FROM tag LEFT JOIN track ON tag.track_id=track._id LEFT JOIN artist_track ON tag.track_id=artist_track.track_id LEFT JOIN artist ON artist_track.artist_id=artist.id GROUP BY tag.datetime";
    }
}
