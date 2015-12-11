// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.r;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.k.f.ab;
import com.shazam.android.m.c;
import com.shazam.android.persistence.q.b;
import com.shazam.k.e;
import com.shazam.model.AddOn;
import com.shazam.model.ArbitraryMetadata;
import com.shazam.model.Track;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.shazam.android.persistence.r:
//            b

public final class a
    implements com.shazam.android.persistence.q.a, com.shazam.android.persistence.r.b
{

    final com.shazam.b.a.a a;
    final com.shazam.android.persistence.b.a b;
    private final com.shazam.android.m.b c;
    private final ab d;
    private final com.shazam.b.a.a e;
    private final com.shazam.b.a.a f;
    private final b g = new b();

    public a(com.shazam.android.m.b b1, ab ab1, com.shazam.android.persistence.b.a a1, com.shazam.b.a.a a2, com.shazam.b.a.a a3, com.shazam.b.a.a a4)
    {
        c = b1;
        d = ab1;
        b = a1;
        a = a2;
        e = a3;
        f = a4;
    }

    static void a(SQLiteDatabase sqlitedatabase, Map map, String s, ContentValues contentvalues)
    {
        if (map != null)
        {
            sqlitedatabase.delete("track_metadata", (new StringBuilder("track_id = '")).append(s).append("'").toString(), null);
            for (map = map.entrySet().iterator(); map.hasNext(); sqlitedatabase.replace("track_metadata", null, contentvalues))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                contentvalues.clear();
                contentvalues.put("track_id", s);
                contentvalues.put("entry_key", (String)entry.getKey());
                contentvalues.put("entry_value", (String)entry.getValue());
            }

        }
    }

    public final int a(ContentValues contentvalues, String s, String as[])
    {
        AtomicInteger atomicinteger = new AtomicInteger(0);
        c.a(new c(contentvalues, s, as, atomicinteger) {

            final ContentValues a;
            final String b;
            final String c[];
            final AtomicInteger d;
            final a e;

            public final void a(SQLiteDatabase sqlitedatabase)
            {
                int i = sqlitedatabase.update("track", a, b, c);
                d.set(i);
            }

            
            {
                e = a.this;
                a = contentvalues;
                b = s;
                c = as;
                d = atomicinteger;
                super();
            }
        });
        return atomicinteger.intValue();
    }

    public final Track a(String s)
    {
        s = b(Collections.singletonList(s));
        if (s.isEmpty())
        {
            return null;
        } else
        {
            return (Track)s.get(0);
        }
    }

    public final List a(List list)
    {
        String as[] = (String[])list.toArray(new String[list.size()]);
        list = (List)c.a(new com.shazam.android.m.a(as, new String[] {
            "_id", "key", "beacon_key", "campaign", "title", "subtitle", "category", "album", "label_id", "label_name", 
            "genre_id", "genre_name", "subgenre_id", "subgenre_name", "id_track_type", "full", "json", "art_id", "full_screen_promo_url", "released", 
            "style", "advertising_info", "play_with", "stores", "url_params", "artist_name"
        }) {

            final String a[];
            final String b[];
            final a c;

            public final Cursor a(SQLiteDatabase sqlitedatabase)
            {
                String s1 = (new StringBuilder("_id IN (")).append(com.shazam.android.util.d.b.a(a.length)).append(")").toString();
                return sqlitedatabase.query("track", b, s1, a, null, null, null);
            }

            
            {
                c = a.this;
                a = as;
                b = as1;
                super();
            }
        }, e);
        List list1 = b.a(as);
        List list2 = (List)c.a(new com.shazam.android.m.a(as) {

            final String a[];
            final a b;

            public final Cursor a(SQLiteDatabase sqlitedatabase)
            {
                String s1 = (new StringBuilder("track_id IN (")).append(com.shazam.android.util.d.b.a(a.length)).append(")").toString();
                String as1[] = a;
                return sqlitedatabase.query("track_metadata", new String[] {
                    "track_id", "entry_key", "entry_value"
                }, s1, as1, null, null, null);
            }

            
            {
                b = a.this;
                a = as;
                super();
            }
        }, f);
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Track track = (Track)iterator.next();
            String s = track.id;
            Iterator iterator1 = list1.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                Object obj = (e)iterator1.next();
                if (((e) (obj)).a.equals(s))
                {
                    obj = (AddOn)((e) (obj)).b;
                    track.addOns.add(obj);
                }
            } while (true);
            iterator1 = list2.iterator();
            while (iterator1.hasNext()) 
            {
                Object obj1 = (e)iterator1.next();
                if (((e) (obj1)).a.equals(s))
                {
                    obj1 = (ArbitraryMetadata)((e) (obj1)).b;
                    track.metadata.put(((ArbitraryMetadata) (obj1)).key, ((ArbitraryMetadata) (obj1)).value);
                }
            }
        }

        return list;
    }

    public final void a(Track track)
    {
        track = Collections.singletonList(track);
        c.a(new c(track) {

            final List a;
            final a b;

            public final void a(SQLiteDatabase sqlitedatabase)
            {
                String s;
                Object obj;
                for (Iterator iterator = a.iterator(); iterator.hasNext(); b.b.a(((List) (obj)), s))
                {
                    obj = (Track)iterator.next();
                    sqlitedatabase.replace("track", null, (ContentValues)b.a.a(obj));
                    s = ((Track) (obj)).id;
                    ContentValues contentvalues = new ContentValues();
                    a.a(sqlitedatabase, ((Track) (obj)).metadata, s, contentvalues);
                    obj = ((Track) (obj)).addOns;
                }

            }

            
            {
                b = a.this;
                a = list;
                super();
            }
        });
        Track track1;
        for (track = track.iterator(); track.hasNext(); d.a(track1.id))
        {
            track1 = (Track)track.next();
        }

    }

    public final void a(String s, String s1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("title", s1);
        a(contentvalues, "_id==?", new String[] {
            s
        });
    }

    public final List b(List list)
    {
        if (list.isEmpty())
        {
            return Collections.emptyList();
        } else
        {
            return com.shazam.android.persistence.q.b.a(this, list);
        }
    }
}
