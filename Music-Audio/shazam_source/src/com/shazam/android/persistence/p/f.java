// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.shazam.android.l.d.d;
import com.shazam.android.m.a;
import com.shazam.android.m.b;
import com.shazam.j.c;
import com.shazam.model.Tag;
import com.shazam.model.location.SimpleLocation;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.shazam.android.persistence.p:
//            n

public final class f
    implements n
{

    private final d a;
    private final com.shazam.j.b b;
    private final b c;

    public f(b b1, d d1, com.shazam.j.b b2)
    {
        c = b1;
        a = d1;
        b = b2;
        (new SQLiteQueryBuilder()).setTables(null);
    }

    public final List a()
    {
        Cursor cursor = c.a(new a() {

            final f a;

            public final Cursor a(SQLiteDatabase sqlitedatabase)
            {
                return sqlitedatabase.query("tag", null, "status = ?", new String[] {
                    com.shazam.model.Tag.Status.UNSUBMITTED.getDbString()
                }, null, null, null);
            }

            
            {
                a = f.this;
                super();
            }
        });
        return a.a(cursor);
    }

    public final void a(long l)
    {
        c.a(new com.shazam.android.m.c(l) {

            final long a;
            final f b;

            public final void a(SQLiteDatabase sqlitedatabase)
            {
                sqlitedatabase.delete("tag", "timestamp = ? AND status= ?", new String[] {
                    String.valueOf(a), com.shazam.model.Tag.Status.UNSUBMITTED.getDbString()
                });
            }

            
            {
                b = f.this;
                a = l;
                super();
            }
        });
    }

    public final void a(Tag tag)
    {
        long l = tag.timestamp;
        byte abyte0[] = tag.sig;
        SimpleLocation simplelocation = tag.location;
        String s = tag.requestId;
        tag = tag.tagContext;
        Date date = new Date(l);
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("request_id", s);
        contentvalues.put("status", com.shazam.model.Tag.Status.UNSUBMITTED.getDbString());
        contentvalues.put("datetime", com.shazam.o.d.a(date));
        contentvalues.put("short_datetime", com.shazam.o.d.b(date));
        contentvalues.put("timestamp", Long.valueOf(l));
        contentvalues.put("sig", abyte0);
        try
        {
            contentvalues.put("serialized_tag_context", b.a(tag));
        }
        // Misplaced declaration of an exception variable
        catch (Tag tag)
        {
            throw new RuntimeException(tag);
        }
        if (simplelocation != null)
        {
            contentvalues.put("lat", Double.valueOf(simplelocation.latitude));
            contentvalues.put("lon", Double.valueOf(simplelocation.longitude));
            contentvalues.put("alt", Double.valueOf(simplelocation.a()));
        }
        c.a(new com.shazam.android.m.c(contentvalues) {

            final ContentValues a;
            final f b;

            public final void a(SQLiteDatabase sqlitedatabase)
            {
                sqlitedatabase.replace("tag", null, a);
            }

            
            {
                b = f.this;
                a = contentvalues;
                super();
            }
        });
    }
}
