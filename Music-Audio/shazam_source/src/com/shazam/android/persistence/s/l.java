// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.s;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.util.d.a;
import java.util.ArrayList;

// Referenced classes of package com.shazam.android.persistence.s:
//            c

public class l extends c
{

    public l(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase);
    }

    protected com.shazam.model.Tag.Builder a(Cursor cursor)
    {
        com.shazam.model.Tag.Builder builder = super.a(cursor);
        cursor = com.shazam.android.util.d.a.a(cursor, "watermark_list");
        if (com.shazam.b.e.a.c(cursor))
        {
            String as[] = cursor.split(",");
            cursor = new ArrayList();
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                com.shazam.model.audio.Messages.Builder builder3 = com.shazam.model.audio.Messages.Builder.a();
                builder3.id = s;
                cursor.add(builder3.b());
            }

            com.shazam.model.TagContext.Builder builder1 = com.shazam.model.TagContext.Builder.a();
            com.shazam.model.audio.Watermark.Builder builder2 = com.shazam.model.audio.Watermark.Builder.a();
            com.shazam.model.audio.Mood.Builder builder4 = com.shazam.model.audio.Mood.Builder.a();
            builder4.messages = cursor;
            builder2.mood = builder4.b();
            builder1.watermark = builder2.b();
            builder.tagContext = builder1.b();
        }
        return builder;
    }

    protected String c()
    {
        return "SELECT track.title as title, track.art_id as art_id, tag.track_id as tag_track_id, tag.timestamp as timestamp, tag.datetime as datetime, tag.sig as tag_sig, tag.watermark_list as watermark_list, '0' as unread, tag.status as status, tag.lat as lat, tag.lon as lon, tag.alt as alt, tag.location_name as location_name, tag.short_datetime as short_datetime, tag.request_id as request_id, tag.event_id as event_id, NULL as ts, artist.name as artistName, NULL as sig FROM tag LEFT JOIN track ON tag.track_id=track._id LEFT JOIN artist_track ON tag.track_id=artist_track.track_id LEFT JOIN artist ON artist_track.artist_id=artist.id GROUP BY tag.datetime";
    }
}
