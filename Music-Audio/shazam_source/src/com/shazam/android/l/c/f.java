// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.c;

import android.content.ContentValues;
import com.shazam.b.a.a;
import com.shazam.f.g;
import com.shazam.j.b;
import com.shazam.model.Art;
import com.shazam.model.Genre;
import com.shazam.model.Label;
import com.shazam.model.Track;
import com.shazam.model.TrackCategory;
import com.shazam.model.TrackLayoutType;
import com.shazam.model.TrackStyle;

public final class f
    implements a
{

    private final int a;
    private final b b;

    public f(int i, b b1)
    {
        a = i;
        b = b1;
    }

    private ContentValues a(Track track)
    {
        ContentValues contentvalues = new ContentValues();
        Genre genre = track.genre;
        Genre genre1 = track.subgenre;
        Label label = track.label;
        Object obj = track.trackLayoutType;
        String s = track.promoFullScreenUrl;
        String s1 = track.id;
        String s2 = track.released;
        String s3 = track.playWith;
        com.shazam.model.store.Stores stores = track.stores;
        java.util.Map map = track.urlParams;
        a(contentvalues, "advertising_info", track.advertisingInfo);
        if (obj != null)
        {
            contentvalues.put("id_track_type", Integer.valueOf(((TrackLayoutType) (obj)).getDatabaseID()));
            contentvalues.put("_id", s1);
            contentvalues.put("key", track.key);
            contentvalues.put("beacon_key", track.beaconKey);
            contentvalues.put("campaign", track.campaign);
            contentvalues.put("title", track.title);
            contentvalues.put("subtitle", track.subtitle);
            contentvalues.put("category", track.category.toString());
            contentvalues.put("json", track.json);
            contentvalues.put("artist_name", track.artistName);
            TrackStyle trackstyle = track.trackStyle;
            obj = trackstyle;
            if (trackstyle == null)
            {
                obj = TrackStyle.getDefaultStyle();
            }
            contentvalues.put("style", ((TrackStyle) (obj)).getStyle());
            if (label != null)
            {
                contentvalues.put("label_id", label.id);
                contentvalues.put("label_name", label.name);
            }
            a(contentvalues, "album", track.album);
            if (genre != null)
            {
                contentvalues.put("genre_id", genre.id);
                contentvalues.put("genre_name", genre.name);
            }
            if (genre1 != null)
            {
                contentvalues.put("subgenre_id", genre1.id);
                contentvalues.put("subgenre_name", genre1.name);
            }
            int i;
            if (track.isFull)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            contentvalues.put("full", Integer.valueOf(i));
            trackstyle = null;
            obj = trackstyle;
            if (track.art != null)
            {
                obj = trackstyle;
                if (track.art.url != null)
                {
                    obj = track.art.url;
                }
            }
            if (com.shazam.b.e.a.c(((String) (obj))))
            {
                contentvalues.put("art_id", ((String) (obj)));
            } else
            {
                contentvalues.put("art_id", (new StringBuilder("http://images.shazam.com/webtid/")).append(s1).append("?size=").append(a).toString());
            }
            a(contentvalues, "released", s2);
            a(contentvalues, "full_screen_promo_url", s);
            a(contentvalues, "play_with", s3);
            a(contentvalues, "stores", stores);
            a(contentvalues, "url_params", map);
            return contentvalues;
        } else
        {
            throw new g("Track type required, but attempting to save track without it!");
        }
    }

    private void a(ContentValues contentvalues, String s, Object obj)
    {
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        contentvalues.put(s, b.a(obj));
        return;
        contentvalues;
        throw new g((new StringBuilder("Could not write JSON string from ")).append(obj.toString()).toString());
    }

    private static void a(ContentValues contentvalues, String s, String s1)
    {
        if (s1 != null)
        {
            contentvalues.put(s, s1);
        }
    }

    public final volatile Object a(Object obj)
    {
        return a((Track)obj);
    }
}
