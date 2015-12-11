// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.s;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.util.d.a;
import com.shazam.model.location.SimpleLocation;

// Referenced classes of package com.shazam.android.persistence.s:
//            f

public class g extends f
{

    public g(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase);
    }

    protected com.shazam.model.Tag.Builder a(Cursor cursor)
    {
        com.shazam.model.Tag.Builder builder = super.a(cursor);
        builder.locationName = com.shazam.android.util.d.a.a(cursor, "location_name");
        builder.location = new SimpleLocation(null, com.shazam.android.util.d.a.e(cursor, "lat"), com.shazam.android.util.d.a.e(cursor, "lon"), Double.valueOf(com.shazam.android.util.d.a.e(cursor, "alt")));
        return builder;
    }

    protected String c()
    {
        return "SELECT track.title as title, track.art_id as art_id, tag.track_id as tag_track_id, tag.datetime as datetime, tag.lat as lat, tag.lon as lon, tag.alt as alt, tag.location_name as location_name, tag.short_datetime as short_datetime, tag.request_id as request_id, artist.name as artistName, NULL as ts, NULL as sig FROM tag,track,artist,artist_track WHERE tag.track_id=track._id AND tag.track_id=artist_track.track_id AND artist_track.artist_id=artist.id GROUP BY tag.datetime UNION SELECT NULL as title, NULL as art_id, NULL as track_id, NULL as datetime, lat as lat, lon as lon, alt as alt, NULL as location_name, NULL as short_datetime, NULL as request_id, NULL as artistName, ts as ts, sig as sig FROM unsubmitted";
    }
}
