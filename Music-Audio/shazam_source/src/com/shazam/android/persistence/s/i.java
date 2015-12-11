// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.s;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.util.d.a;
import com.shazam.model.Art;
import com.shazam.o.d;
import java.util.Date;

// Referenced classes of package com.shazam.android.persistence.s:
//            b

public class i extends b
{

    public i(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase);
    }

    protected com.shazam.model.Tag.Builder a(Cursor cursor)
    {
        com.shazam.model.Tag.Builder builder = com.shazam.model.Tag.Builder.a();
        com.shazam.model.Track.Builder builder1 = com.shazam.model.Track.Builder.a();
        Object obj = new Art();
        builder1.id = com.shazam.android.util.d.a.a(cursor, "tag_track_id");
        builder1.title = com.shazam.android.util.d.a.a(cursor, "title");
        obj.url = com.shazam.android.util.d.a.a(cursor, "art_id");
        builder1.art = ((Art) (obj));
        builder1.artistName = com.shazam.android.util.d.a.a(cursor, "artistName");
        builder1.isFull = false;
        obj = com.shazam.android.util.d.a.a(cursor, "datetime");
        String s = com.shazam.android.util.d.a.a(cursor, "request_id");
        cursor = com.shazam.android.util.d.a.a(cursor, "short_datetime");
        builder.track = builder1.b();
        builder.status = com.shazam.model.Tag.Status.SUCCESSFUL;
        builder.dateTime = ((String) (obj));
        builder.requestId = s;
        builder.shortDateTime = cursor;
        cursor = d.a(((String) (obj)));
        if (cursor != null)
        {
            builder.timestamp = cursor.getTime();
        }
        return builder;
    }

    protected String c()
    {
        return "SELECT track.title as title, track.art_id as art_id, tag.track_id as tag_track_id, tag.datetime as datetime, tag.request_id as request_id, tag.short_datetime as short_datetime, artist.name as artistName, NULL as ts, NULL as sig FROM tag,track,artist,artist_track WHERE tag.track_id=track.id AND tag.track_id=artist_track.track_id AND artist_track.artist_id=artist.id GROUP BY tag.datetime";
    }
}
