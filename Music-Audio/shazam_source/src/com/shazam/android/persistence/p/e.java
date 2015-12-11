// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.c;
import com.shazam.android.persistence.q.a;
import com.shazam.android.persistence.q.b;
import com.shazam.f.g;
import com.shazam.k.s;
import com.shazam.model.Cache;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

public final class e
    implements a, s
{

    private static final String a = null;
    private static final Semaphore b = new Semaphore(1);
    private final com.shazam.android.m.b c;
    private final com.shazam.android.persistence.r.b d;
    private final com.shazam.b.a.a e;
    private final com.shazam.b.a.a f;
    private final b g = new b();
    private final Cache h;

    public e(com.shazam.android.m.b b1, com.shazam.android.persistence.r.b b2, com.shazam.b.a.a a1, com.shazam.b.a.a a2, Cache cache)
    {
        c = b1;
        d = b2;
        e = a1;
        f = a2;
        h = cache;
    }

    static com.shazam.android.persistence.r.b a(e e1)
    {
        return e1.d;
    }

    private List a(String s1, String as[], String s2, String s3)
    {
        return a(new String[] {
            "request_id", "track_id", "track_key", "datetime", "short_datetime", "timestamp", "status", "location_name", "json", "lat", 
            "lon", "alt", "offset", "skew", "frequency_skew", "event_id", "unread"
        }, s1, as, s2, s3);
    }

    private static List a(List list, List list1)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
label0:
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = (com.shazam.k.e)list.next();
            String s1 = ((com.shazam.k.e) (obj)).a;
            obj = (Tag)((com.shazam.k.e) (obj)).b;
            Iterator iterator = list1.iterator();
            Track track;
            do
            {
                if (!iterator.hasNext())
                {
                    continue label0;
                }
                track = (Track)iterator.next();
            } while (!s1.equals(track.id));
            obj.track = track;
            arraylist.add(obj);
        } while (true);
        return arraylist;
    }

    private List a(String as[], String s1, String as1[], String s2, String s3)
    {
        b.acquire();
        as = (List)c.a(new com.shazam.android.m.a(as, s1, as1, s2, s3) {

            final String a[];
            final String b;
            final String c[];
            final String d;
            final String e;
            final e f;

            public final Cursor a(SQLiteDatabase sqlitedatabase)
            {
                return sqlitedatabase.query("tag", a, e.d(b), c, null, null, d, e);
            }

            
            {
                f = e.this;
                a = as;
                b = s1;
                c = as1;
                d = s2;
                e = s3;
                super();
            }
        }, f);
        b.release();
        return as;
        as;
        throw new g("Unable to get lock for db write", as);
        as;
        b.release();
        throw as;
    }

    static com.shazam.b.a.a b(e e1)
    {
        return e1.e;
    }

    private static Tag b(List list)
    {
        if (list.isEmpty())
        {
            return null;
        } else
        {
            return (Tag)list.get(0);
        }
    }

    private List c(List list)
    {
        list = new ArrayList(com.shazam.b.b.b.a(list, new com.shazam.b.a.e() {

            final e a;

            public final boolean apply(Object obj)
            {
                return !com.shazam.b.e.a.a(((com.shazam.k.e)obj).a);
            }

            
            {
                a = e.this;
                super();
            }
        }));
        java.util.Collection collection = com.shazam.b.b.b.a(list, new com.shazam.b.a.c() {

            final e a;

            public final volatile Object a(Object obj)
            {
                return ((com.shazam.k.e)obj).a;
            }

            
            {
                a = e.this;
                super();
            }
        });
        return a(list, d.b(new ArrayList(collection)));
    }

    static String d(String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (s1 != null)
        {
            stringbuilder.append(s1).append(" AND ");
        }
        stringbuilder.append("status != '").append(com.shazam.model.Tag.Status.UNSUBMITTED.getDbString()).append("'");
        return stringbuilder.toString();
    }

    static Semaphore f()
    {
        return b;
    }

    public final Tag a(String s1)
    {
        Tag tag = (Tag)h.a(s1);
        if (tag != null)
        {
            return tag;
        } else
        {
            return b(c(com.shazam.android.persistence.q.b.a(this, Collections.singletonList(s1))));
        }
    }

    public final List a()
    {
        return c(a(null, null, "datetime DESC", null));
    }

    public final List a(List list)
    {
        list = (String[])list.toArray(new String[list.size()]);
        return a((new StringBuilder("request_id IN (")).append(com.shazam.android.util.d.b.a(list.length)).append(")").toString(), ((String []) (list)), a, null);
    }

    public final void a(Tag tag)
    {
        c.a(new c(tag) {

            final Tag a;
            final e b;

            public final void a(SQLiteDatabase sqlitedatabase)
            {
                Object obj = a.track;
                com.shazam.android.persistence.p.e.a(b).a(((Track) (obj)));
                obj = (ContentValues)com.shazam.android.persistence.p.e.b(b).a(a);
                if (sqlitedatabase.update("tag", ((ContentValues) (obj)), (new StringBuilder("request_id='")).append(a.requestId).append("'").toString(), null) == 0)
                {
                    sqlitedatabase.replace("tag", null, ((ContentValues) (obj)));
                }
            }

            
            {
                b = e.this;
                a = tag;
                super();
            }
        });
    }

    public final Tag b()
    {
        return b(c(a(null, null, "datetime DESC", "1")));
    }

    public final void b(Tag tag)
    {
        h.a(tag.requestId, tag);
        try
        {
            b.acquire();
        }
        // Misplaced declaration of an exception variable
        catch (Tag tag)
        {
            b.release();
            throw new g("Error acquiring lock for DB save");
        }
        (new Thread(new Runnable(tag) {

            final Tag a;
            final e b;

            public final void run()
            {
                b.a(a);
                e.f().release();
                return;
                Exception exception;
                exception;
                e.f().release();
                throw exception;
            }

            
            {
                b = e.this;
                a = tag;
                super();
            }
        }, "DbTagRepository_addTag")).start();
    }

    public final void b(String s1)
    {
        h.b(s1);
        c.a(new c(s1) {

            final String a;
            final e b;

            public final void a(SQLiteDatabase sqlitedatabase)
            {
                sqlitedatabase.delete("tag", "request_id= ?", new String[] {
                    a
                });
            }

            
            {
                b = e.this;
                a = s1;
                super();
            }
        });
    }

    public final List c()
    {
        return c(a("unread is 1", null, "datetime DESC", null));
    }

    public final boolean c(String s1)
    {
        if (com.shazam.b.e.a.a(s1))
        {
            return false;
        }
        s1 = c.a(new com.shazam.android.m.a(s1) {

            final String a;
            final e b;

            public final Cursor a(SQLiteDatabase sqlitedatabase)
            {
                return sqlitedatabase.rawQuery("select count(_id) from tag where track_key = ?", new String[] {
                    a
                });
            }

            
            {
                b = e.this;
                a = s1;
                super();
            }
        });
        s1.moveToFirst();
        if (s1.getCount() > 0 && s1.getColumnCount() > 0 && s1.getInt(0) > 0)
        {
            return true;
        } else
        {
            s1.close();
            return false;
        }
    }

    public final int d()
    {
        boolean flag = false;
        Cursor cursor;
        b.acquire();
        cursor = c.a(new com.shazam.android.m.a() {

            final e a;

            public final Cursor a(SQLiteDatabase sqlitedatabase)
            {
                return sqlitedatabase.rawQuery("select count(_id) from tag", null);
            }

            
            {
                a = e.this;
                super();
            }
        });
        cursor.moveToFirst();
        int i = ((flag) ? 1 : 0);
        if (cursor.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        i = ((flag) ? 1 : 0);
        if (cursor.getColumnCount() > 0)
        {
            i = cursor.getInt(0);
        }
        cursor.close();
        b.release();
        return i;
        Object obj;
        obj;
        throw new g("Unable to get lock for db write", ((Throwable) (obj)));
        obj;
        b.release();
        throw obj;
    }

    public final int e()
    {
        boolean flag = false;
        Cursor cursor;
        b.acquire();
        cursor = c.a(new com.shazam.android.m.a() {

            final e a;

            public final Cursor a(SQLiteDatabase sqlitedatabase)
            {
                return sqlitedatabase.rawQuery("select count(_id) from tag WHERE status = ?", new String[] {
                    com.shazam.model.Tag.Status.SUCCESSFUL.getDbString()
                });
            }

            
            {
                a = e.this;
                super();
            }
        });
        cursor.moveToFirst();
        int i = ((flag) ? 1 : 0);
        if (cursor.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        i = ((flag) ? 1 : 0);
        if (cursor.getColumnCount() > 0)
        {
            i = cursor.getInt(0);
        }
        cursor.close();
        b.release();
        return i;
        Object obj;
        obj;
        throw new g("Unable to get lock for db write", ((Throwable) (obj)));
        obj;
        b.release();
        throw obj;
    }

}
