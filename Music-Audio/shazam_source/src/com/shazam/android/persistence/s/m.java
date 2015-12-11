// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.s;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.visual.a.c;
import com.shazam.i.b.aw.a.a;
import com.shazam.model.TrackLayoutType;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// Referenced classes of package com.shazam.android.persistence.s:
//            e

public class m extends e
{

    private final c b = com.shazam.i.b.aw.a.a.a();

    public m(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase);
    }

    protected final com.shazam.model.Tag.Builder a(Cursor cursor)
    {
        com.shazam.model.Tag.Builder builder = super.a(cursor);
        Integer integer = com.shazam.android.util.d.a.g(cursor, "id_track_type");
        cursor = com.shazam.android.util.d.a.a(cursor, "tag_track_id");
        if (integer != null && TrackLayoutType.LOCAL_WEB.getDatabaseID() == integer.intValue())
        {
            try
            {
                String s = URLDecoder.decode(cursor, "UTF-8");
                b.a(builder, cursor, s);
            }
            // Misplaced declaration of an exception variable
            catch (Cursor cursor)
            {
                return builder;
            }
        }
        return builder;
    }

    protected String c()
    {
        return "SELECT track.title as title, track.art_id as art_id, track.id_track_type as id_track_type, tag.track_key as track_key, tag.track_id as tag_track_id, tag.timestamp as timestamp, tag.datetime as datetime, tag.sig as tag_sig, tag.serialized_tag_context as serialized_tag_context, tag.json asjson, '0' as unread, tag.status as status, tag.lat as lat, tag.lon as lon, tag.alt as alt, tag.location_name as location_name, tag.short_datetime as short_datetime, tag.request_id as request_id, tag.event_id as event_id, NULL as ts, artist.name as artistName, NULL as sig FROM tag LEFT JOIN track ON tag.track_id=track._id LEFT JOIN artist_track ON tag.track_id=artist_track.track_id LEFT JOIN artist ON artist_track.artist_id=artist.id GROUP BY tag.datetime";
    }
}
