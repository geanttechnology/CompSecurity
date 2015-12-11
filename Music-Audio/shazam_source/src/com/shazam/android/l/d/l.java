// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.d;

import android.database.Cursor;
import com.shazam.b.a.a;
import com.shazam.j.b;
import com.shazam.j.c;
import com.shazam.model.Art;
import com.shazam.model.Genre;
import com.shazam.model.Track;
import com.shazam.model.TrackCategory;
import com.shazam.model.TrackLayoutType;
import com.shazam.model.TrackStyle;
import com.shazam.model.advert.AdvertisingInfo;
import com.shazam.model.store.Stores;
import com.shazam.server.response.play.Streams;
import java.util.Map;

public final class l
    implements a
{

    private final b a;

    public l(b b1)
    {
        a = b1;
    }

    private Object a(String s, Class class1)
    {
        if (!com.shazam.b.e.a.b(s))
        {
            break MISSING_BLOCK_LABEL_22;
        }
        s = ((String) (a.a(s, class1)));
        return s;
        s;
        return null;
    }

    public final Object a(Object obj)
    {
        obj = (Cursor)obj;
        com.shazam.model.Track.Builder builder = com.shazam.model.Track.Builder.a();
        Object obj1 = com.shazam.android.util.d.a.g(((Cursor) (obj)), "id_track_type");
        String s = com.shazam.android.util.d.a.a(((Cursor) (obj)), "play_with");
        builder.id = com.shazam.android.util.d.a.a(((Cursor) (obj)), "_id");
        builder.key = com.shazam.android.util.d.a.a(((Cursor) (obj)), "key");
        builder.beaconKey = com.shazam.android.util.d.a.a(((Cursor) (obj)), "beacon_key");
        builder.campaign = com.shazam.android.util.d.a.a(((Cursor) (obj)), "campaign");
        builder.title = com.shazam.android.util.d.a.a(((Cursor) (obj)), "title");
        builder.subtitle = com.shazam.android.util.d.a.a(((Cursor) (obj)), "subtitle");
        builder.category = TrackCategory.fromString(com.shazam.android.util.d.a.a(((Cursor) (obj)), "category"));
        builder.album = com.shazam.android.util.d.a.a(((Cursor) (obj)), "album");
        builder.trackLayoutType = TrackLayoutType.getByDatabaseId(((Integer) (obj1)), Track.a());
        builder.released = com.shazam.android.util.d.a.a(((Cursor) (obj)), "released");
        builder.promoFullScreenUrl = com.shazam.android.util.d.a.a(((Cursor) (obj)), "full_screen_promo_url");
        builder.trackStyle = TrackStyle.from(com.shazam.android.util.d.a.a(((Cursor) (obj)), "style"));
        builder.json = com.shazam.android.util.d.a.a(((Cursor) (obj)), "json");
        builder.playWith = s;
        builder.streams = (Streams)a(s, com/shazam/server/response/play/Streams);
        builder.isFull = com.shazam.android.util.d.a.i(((Cursor) (obj)), "full");
        obj1 = com.shazam.android.util.d.a.a(((Cursor) (obj)), "label_id");
        s = com.shazam.android.util.d.a.a(((Cursor) (obj)), "label_name");
        if (obj1 != null && s != null)
        {
            com.shazam.model.Label.Builder builder1 = com.shazam.model.Label.Builder.a();
            builder1.id = ((String) (obj1));
            builder1.name = s;
            builder.label = builder1.b();
        }
        obj1 = com.shazam.android.util.d.a.a(((Cursor) (obj)), "genre_id");
        s = com.shazam.android.util.d.a.a(((Cursor) (obj)), "genre_name");
        if (obj1 != null && s != null)
        {
            builder.genre = new Genre(((String) (obj1)), s);
        }
        obj1 = com.shazam.android.util.d.a.a(((Cursor) (obj)), "subgenre_id");
        s = com.shazam.android.util.d.a.a(((Cursor) (obj)), "subgenre_name");
        if (obj1 != null && s != null)
        {
            builder.subgenre = new Genre(((String) (obj1)), s);
        }
        builder.advertisingInfo = (AdvertisingInfo)a(com.shazam.android.util.d.a.a(((Cursor) (obj)), "advertising_info"), com/shazam/model/advert/AdvertisingInfo);
        builder.stores = (Stores)a(com.shazam.android.util.d.a.a(((Cursor) (obj)), "stores"), com/shazam/model/store/Stores);
        builder.urlParams = (Map)a(com.shazam.android.util.d.a.a(((Cursor) (obj)), "url_params"), java/util/Map);
        obj1 = com.shazam.android.util.d.a.a(((Cursor) (obj)), "art_id");
        if (com.shazam.b.e.a.c(((String) (obj1))))
        {
            Art art = new Art();
            art.url = ((String) (obj1));
            builder.art = art;
        }
        builder.artistName = com.shazam.android.util.d.a.a(((Cursor) (obj)), "artist_name");
        return builder.b();
    }
}
