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
import java.util.UUID;

// Referenced classes of package com.shazam.android.persistence.s:
//            i

public class j extends i
{

    public j(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase);
    }

    protected com.shazam.model.Tag.Builder a(Cursor cursor)
    {
        com.shazam.model.Tag.Builder builder;
        String s2;
        builder = super.a(cursor);
        s2 = com.shazam.android.util.d.a.a(cursor, "ts");
        if (!com.shazam.b.e.a.c(s2)) goto _L2; else goto _L1
_L1:
        Object obj;
        String s;
        Object obj1;
        Long long1;
        String s1;
        obj = new Date();
        obj1 = com.shazam.o.d.a(((Date) (obj)));
        s1 = com.shazam.o.d.b(((Date) (obj)));
        long1 = null;
        obj = obj1;
        s = s1;
        long l = Long.parseLong(s2);
        obj = obj1;
        s = s1;
        obj1 = com.shazam.o.d.a(new Date(l));
        obj = obj1;
        s = s1;
        s1 = com.shazam.o.d.b(new Date(l));
        long1 = Long.valueOf(l);
        s = s1;
        obj = obj1;
        obj1 = long1;
_L4:
        builder.dateTime = ((String) (obj));
        builder.timestamp = ((Long) (obj1)).longValue();
        builder.shortDateTime = s;
_L2:
        if (com.shazam.b.e.a.a(builder.b().requestId))
        {
            builder.requestId = UUID.randomUUID().toString();
        }
        cursor = com.shazam.android.util.d.a.d(cursor, "sig");
        if (cursor != null && cursor.length > 0)
        {
            builder.sig = cursor;
            builder.status = com.shazam.model.Tag.Status.UNSUBMITTED;
        }
        return builder;
        NumberFormatException numberformatexception;
        numberformatexception;
        numberformatexception = long1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected String c()
    {
        return String.format("SELECT track.title as title, track.art_id as art_id, tag.track_id as tag_track_id, tag.datetime as datetime, tag.request_id as request_id, tag.short_datetime as short_datetime, artist.name as artistName, NULL as ts, NULL as sig FROM tag,track,artist,artist_track WHERE tag.track_id=%s AND tag.track_id=artist_track.track_id AND artist_track.artist_id=artist.id GROUP BY tag.datetime UNION SELECT NULL as title, NULL as art_id, NULL as track_id, NULL as datetime, NULL as short_datetime, NULL as artistName, NULL as request_id, ts as ts, sig as sig FROM unsubmitted", new Object[] {
            d()
        });
    }

    protected String d()
    {
        return "track.id";
    }
}
