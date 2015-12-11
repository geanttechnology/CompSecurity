// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.l;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.shazam.android.k.f.ab;
import com.shazam.android.p.d;
import com.shazam.android.persistence.s.b;
import com.shazam.android.persistence.s.c;
import com.shazam.android.persistence.s.f;
import com.shazam.android.persistence.s.g;
import com.shazam.android.persistence.s.h;
import com.shazam.android.persistence.s.i;
import com.shazam.android.persistence.s.j;
import com.shazam.android.persistence.s.k;
import com.shazam.android.persistence.s.l;
import com.shazam.android.persistence.s.m;
import com.shazam.i.b.ah.f.e;
import com.shazam.k.s;
import com.shazam.model.AutoTag;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import com.shazam.model.TrackLayoutType;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.persistence.l:
//            b

public final class a extends SQLiteOpenHelper
{

    private final Context a;

    public a(Context context)
    {
        this(context, "library.db");
    }

    private a(Context context, String s1)
    {
        super(context, s1, new com.shazam.android.persistence.l.b(), d.a().Q);
        a = context;
    }

    private static void a(SQLiteDatabase sqlitedatabase, List list)
    {
        sqlitedatabase = com.shazam.i.b.ah.e.a.a(sqlitedatabase);
        for (list = list.iterator(); list.hasNext(); sqlitedatabase.a((AutoTag)list.next())) { }
    }

    private static void a(SQLiteDatabase sqlitedatabase, boolean flag)
    {
        int i1;
        i1 = 0;
        if (!flag)
        {
            sqlitedatabase.beginTransaction();
        }
_L2:
        if (i1 >= 10)
        {
            break; /* Loop/switch isn't completed */
        }
        sqlitedatabase.execSQL((new String[] {
            "CREATE TABLE IF NOT EXISTS disliked (key STRING PRIMARY KEY)", "CREATE TABLE track (\n    _id TEXT PRIMARY KEY,\n    key TEXT,\n    beacon_key TEXT,\n    campaign TEXT,\n    title TEXT,\n    subtitle TEXT,\n    category TEXT,\n    album TEXT,\n    label_id TEXT,\n    label_name TEXT,\n    genre_id TEXT,\n    genre_name TEXT,\n    subgenre_id TEXT,\n    subgenre_name TEXT,\n    full INTEGER,\n    art_id TEXT,\n    id_track_type INTEGER NOT NULL,\n    full_screen_promo_url TEXT,\n    released TEXT,\n    style TEXT,\n    advertising_info TEXT,\n    stores TEXT,\n    play_with TEXT,\n    json TEXT,\n    url_params TEXT,\n    artist_name TEXT)", "CREATE TABLE track_metadata (\n    track_id TEXT NOT NULL REFERENCES track(_id),\n    entry_key TEXT NOT NULL,\n    entry_value TEXT NOT NULL,\n    sort_order INTEGER,\n    PRIMARY KEY(track_id, entry_key)\n)", "CREATE TABLE tag (\n_id INTEGER PRIMARY KEY AUTOINCREMENT,\ntrack_id TEXT REFERENCES track(_id),\ntrack_key TEXT,\ndatetime DATETIME,\nshort_datetime TEXT,\ntimestamp INTEGER,\nrequest_id TEXT NOT NULL,\nsig BLOB,\nstatus TEXT,\nlocation_name TEXT,\nlat REAL,\nlon REAL,\nalt REAL,\noffset REAL,\nskew REAL,\nfrequency_skew REAL,\nserialized_tag_context STRING,\nevent_id STRING,\nunread BOOL,\njson STRING)", "CREATE TABLE addon(_id INTEGER PRIMARY KEY AUTOINCREMENT,track_id STRING REFERENCES track(_id),serialized_addons STRING NOT NULL)", "CREATE TABLE auto_tag(_id INTEGER PRIMARY KEY AUTOINCREMENT,uuid STRING NOT NULL,\ntimestamp INTEGER NOT NULL,\nserialized_match STRING NOT NULL)", "CREATE TABLE IF NOT EXISTS post(_ID TEXT PRIMARY KEY, tag_id TEXT, track_id TEXT, caption TEXT,like_key)", "CREATE TABLE IF NOT EXISTS search_result_artist (_id TEXT PRIMARY KEY NOT NULL, name TEXT, avatar_url TEXT, verified INTEGER, follow_key TEXT, follow_artist_id TEXT, actions_json TEXT, timestamp INTEGER NOT NULL)", "CREATE TABLE IF NOT EXISTS search_result_track(_id TEXT PRIMARY KEY NOT NULL, title TEXT, artist TEXT, image TEXT, actions_json TEXT, timestamp INTEGER NOT NULL)", "CREATE VIEW IF NOT EXISTS view_myshazam AS SELECT tag.timestamp as timestamp, tag.request_id as requestId, tag.status as tagStatus, tag.event_id as eventId, track._id as trackId, track.key as trackKey, track.beacon_key as beaconKey, track.id_track_type as trackType, track.campaign as campaign, track.title as title, track.full as full, track.art_id as artUrl, track.play_with as playWith, track.stores as stores, track.url_params as urlParams, track.category as category, track.style as trackStyle, track.artist_name as artist, post.caption as caption, post.like_key as likeKey, post._ID as postId FROM tag tag  LEFT JOIN track track ON tag.track_id =  track._id LEFT JOIN post post ON post.track_id = track.key"
        })[i1]);
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        sqlitedatabase.setTransactionSuccessful();
        if (!flag)
        {
            sqlitedatabase.endTransaction();
        }
        return;
        Object obj;
        obj;
        (new StringBuilder("Error while creating the database: ")).append(((Exception) (obj)).toString());
        throw new RuntimeException("Error while creating the database!", ((Throwable) (obj)));
        obj;
        if (!flag)
        {
            sqlitedatabase.endTransaction();
        }
        throw obj;
    }

    private static void b(SQLiteDatabase sqlitedatabase, List list)
    {
        sqlitedatabase = e.a(com.shazam.i.b.ah.g.a.a(sqlitedatabase, sqlitedatabase), new com.shazam.android.persistence.r.a(com.shazam.i.b.ah.g.a.a(sqlitedatabase, sqlitedatabase), ab.a, com.shazam.i.b.ah.a.a.a(com.shazam.i.b.ah.g.a.a(sqlitedatabase, sqlitedatabase)), com.shazam.i.b.p.a.a.a(0), com.shazam.i.b.p.b.a.a(), com.shazam.i.b.p.b.a.b()));
        Tag tag;
        for (list = list.iterator(); list.hasNext(); sqlitedatabase.a(tag))
        {
            tag = (Tag)list.next();
            Track track = tag.track;
            if (track.trackLayoutType == null)
            {
                track.trackLayoutType = TrackLayoutType.MUSIC;
            }
        }

    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        a(sqlitedatabase, false);
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i1, int j1)
    {
        SQLiteDatabase sqlitedatabase1;
        SQLiteDatabase sqlitedatabase2;
        SQLiteDatabase sqlitedatabase3;
        (new StringBuilder("onUpgrade(): upgrading database from version ")).append(i1).append(" to ").append(j1);
        sqlitedatabase1 = sqlitedatabase;
        sqlitedatabase2 = sqlitedatabase;
        sqlitedatabase3 = sqlitedatabase;
        if (sqlitedatabase.isOpen())
        {
            break MISSING_BLOCK_LABEL_84;
        }
        sqlitedatabase1 = sqlitedatabase;
        sqlitedatabase2 = sqlitedatabase;
        sqlitedatabase3 = sqlitedatabase;
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        sqlitedatabase2 = sqlitedatabase;
        sqlitedatabase3 = sqlitedatabase;
        List list;
        try
        {
            sqlitedatabase.close();
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            sqlitedatabase2.endTransaction();
            return;
        }
        finally
        {
            sqlitedatabase3.endTransaction();
        }
        sqlitedatabase2 = sqlitedatabase;
        sqlitedatabase3 = sqlitedatabase;
        sqlitedatabase1 = a.openOrCreateDatabase("library.db", 0, null);
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        if (i1 >= d.K.Q) goto _L2; else goto _L1
_L1:
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase = new i(sqlitedatabase1);
_L3:
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        list = sqlitedatabase.a();
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase = sqlitedatabase.b();
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        com.shazam.android.util.d.b.a(sqlitedatabase1, new String[] {
            "disliked", "post", "search_result_artist", "search_result_track"
        });
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        com.shazam.android.util.d.b.b(sqlitedatabase1, new String[0]);
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        a(sqlitedatabase1, true);
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        b(sqlitedatabase1, list);
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        if (sqlitedatabase.isEmpty())
        {
            break MISSING_BLOCK_LABEL_283;
        }
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        a(sqlitedatabase1, sqlitedatabase);
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        sqlitedatabase1.endTransaction();
        return;
_L2:
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        if (i1 >= d.I.Q)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase = new j(sqlitedatabase1);
          goto _L3
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        if (i1 >= d.D.Q)
        {
            break MISSING_BLOCK_LABEL_395;
        }
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase = new f(sqlitedatabase1);
          goto _L3
        throw sqlitedatabase;
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        if (i1 >= d.C.Q)
        {
            break MISSING_BLOCK_LABEL_434;
        }
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase = new g(sqlitedatabase1);
          goto _L3
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        if (i1 >= d.p.Q)
        {
            break MISSING_BLOCK_LABEL_473;
        }
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase = new h(sqlitedatabase1);
          goto _L3
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        if (i1 >= d.o.Q)
        {
            break MISSING_BLOCK_LABEL_512;
        }
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase = new c(sqlitedatabase1);
          goto _L3
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        if (i1 >= d.i.Q)
        {
            break MISSING_BLOCK_LABEL_551;
        }
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase = new l(sqlitedatabase1);
          goto _L3
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        if (i1 >= d.h.Q)
        {
            break MISSING_BLOCK_LABEL_590;
        }
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase = new k(sqlitedatabase1);
          goto _L3
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        if (i1 >= d.d.Q)
        {
            break MISSING_BLOCK_LABEL_629;
        }
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase = new com.shazam.android.persistence.s.e(sqlitedatabase1);
          goto _L3
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        if (i1 >= d.b.Q)
        {
            break MISSING_BLOCK_LABEL_668;
        }
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase = new m(sqlitedatabase1);
          goto _L3
        sqlitedatabase2 = sqlitedatabase1;
        sqlitedatabase3 = sqlitedatabase1;
        sqlitedatabase = new com.shazam.android.persistence.s.d(sqlitedatabase1);
          goto _L3
    }
}
