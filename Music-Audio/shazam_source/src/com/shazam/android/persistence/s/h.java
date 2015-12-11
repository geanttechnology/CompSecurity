// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.s;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.util.d.a;
import com.shazam.model.Tag;
import com.shazam.o.d;
import java.util.Date;

// Referenced classes of package com.shazam.android.persistence.s:
//            g

public class h extends g
{

    public h(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase);
    }

    protected com.shazam.model.Tag.Builder a(Cursor cursor)
    {
        com.shazam.model.Tag.Builder builder;
        String s;
        builder = super.a(cursor);
        s = com.shazam.android.util.d.a.a(cursor, "timestamp");
        if ("".equals(s)) goto _L2; else goto _L1
_L1:
        Long long1 = null;
        long l = Long.parseLong(s);
        long1 = Long.valueOf(l);
_L4:
        if (long1 != null)
        {
            builder.timestamp = long1.longValue();
        }
_L2:
        builder.sig = com.shazam.android.util.d.a.d(cursor, "tag_sig");
        builder.status = com.shazam.model.Tag.Status.getStatusForName(com.shazam.android.util.d.a.a(cursor, "status"), com.shazam.model.Tag.Status.MANUALLY_ADDED);
        return builder;
        NumberFormatException numberformatexception;
        numberformatexception;
        Date date = d.a(builder.b().dateTime);
        if (date != null)
        {
            long1 = Long.valueOf(date.getTime());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected String c()
    {
        return "SELECT track.title as title, track.art_id as art_id, tag.track_id as tag_track_id, tag.timestamp as timestamp, tag.datetime as datetime, tag.sig as tag_sig, tag.status as status, tag.lat as lat, tag.lon as lon, tag.alt as alt, tag.location_name as location_name, tag.short_datetime as short_datetime, tag.request_id as request_id, artist.name as artistName, NULL as ts, NULL as sig FROM tag LEFT JOIN track ON tag.track_id=track._id LEFT JOIN artist_track ON tag.track_id=artist_track.track_id LEFT JOIN artist ON artist_track.artist_id=artist.id GROUP BY tag.datetime";
    }
}
