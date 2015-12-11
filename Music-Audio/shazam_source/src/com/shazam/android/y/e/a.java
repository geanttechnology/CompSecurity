// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.y.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.y.c.b;
import com.shazam.b.a.d;
import com.shazam.h.l;
import com.shazam.j.c;
import java.util.List;

// Referenced classes of package com.shazam.android.y.e:
//            d

public final class a
    implements com.shazam.android.y.e.d
{

    private static final String a[] = {
        "_id", "request"
    };
    private final com.shazam.android.m.b b;
    private final com.shazam.j.b c;

    public a(com.shazam.android.m.b b1, com.shazam.j.b b2)
    {
        b = b1;
        c = b2;
    }

    private String b(com.shazam.android.y.d.a a1)
    {
        l l1;
        try
        {
            l1 = a1.b;
        }
        // Misplaced declaration of an exception variable
        catch (com.shazam.android.y.d.a a1)
        {
            throw new b("Could not serialize request", a1);
        }
        if (l1 != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        throw new b("There was no HTTP request in the guaranteed request");
        if (l1.a == null)
        {
            throw new b("There was no URL in the HTTP request");
        }
        a1 = c.a(a1);
        return a1;
    }

    static String[] c()
    {
        return a;
    }

    public final List a()
    {
        Object obj = new com.shazam.android.y.b.a(c);
        List list = (List)b.a(new com.shazam.android.m.a() {

            final a a;

            public final Cursor a(SQLiteDatabase sqlitedatabase)
            {
                return sqlitedatabase.query("guaranteed_requests", com.shazam.android.y.e.a.c(), null, null, null, null, null);
            }

            
            {
                a = a.this;
                super();
            }
        }, ((com.shazam.b.a.a) (obj)));
        obj = ((com.shazam.android.y.b.a) (obj)).a;
        if (((List) (obj)).isEmpty())
        {
            return list;
        } else
        {
            throw new com.shazam.android.y.c.a("Failed to load requests. Results potentially contain unparseable payload", ((java.util.Collection) (obj)));
        }
    }

    public final void a(com.shazam.android.y.d.a a1)
    {
        d.a(a1, "Request cannot be null");
        a1 = b(a1);
        b.a(new com.shazam.android.m.c(a1) {

            final String a;
            final a b;

            public final void a(SQLiteDatabase sqlitedatabase)
            {
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("request", a);
                sqlitedatabase.insert("guaranteed_requests", null, contentvalues);
            }

            
            {
                b = a.this;
                a = s;
                super();
            }
        });
    }

    public final void a(String s)
    {
        d.a(s, "Passed ID cannot be null");
        b.a(new com.shazam.android.m.c(s) {

            final String a;
            final a b;

            public final void a(SQLiteDatabase sqlitedatabase)
            {
                sqlitedatabase.delete("guaranteed_requests", (new StringBuilder("_id=")).append(a).toString(), null);
            }

            
            {
                b = a.this;
                a = s;
                super();
            }
        });
    }

    public final void b()
    {
        b.a(new com.shazam.android.m.c() {

            final a a;

            public final void a(SQLiteDatabase sqlitedatabase)
            {
                sqlitedatabase.delete("guaranteed_requests", null, null);
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

}
