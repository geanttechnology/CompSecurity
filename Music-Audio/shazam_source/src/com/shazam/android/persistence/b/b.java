// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.c;
import com.shazam.b.a.a;
import com.shazam.f.f;
import java.util.List;

// Referenced classes of package com.shazam.android.persistence.b:
//            a

public final class b
    implements com.shazam.android.persistence.b.a
{

    private final com.shazam.android.m.b b;
    private final a c;
    private final com.shazam.j.b d;

    public b(com.shazam.android.m.b b1, a a1, com.shazam.j.b b2)
    {
        b = b1;
        c = a1;
        d = b2;
    }

    static void a(b b1, SQLiteDatabase sqlitedatabase, List list, String s)
    {
        if (list == null || list.isEmpty())
        {
            return;
        }
        sqlitedatabase.delete("addon", (new StringBuilder("track_id=")).append(s).toString(), null);
        try
        {
            b1 = b1.d.a(list);
            list = new ContentValues();
            list.put("track_id", s);
            list.put("serialized_addons", b1);
            sqlitedatabase.replace("addon", null, list);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            throw new f("Could not serialize add ons for persistance.", b1);
        }
    }

    public final List a(String as[])
    {
        return (List)b.a(new com.shazam.android.m.a(as) {

            final String a[];
            final b b;

            public final Cursor a(SQLiteDatabase sqlitedatabase)
            {
                String s = (new StringBuilder("track_id IN (")).append(com.shazam.android.util.d.b.a(a.length)).append(")").toString();
                String as1[] = a;
                return sqlitedatabase.query("addon", new String[] {
                    "track_id", "serialized_addons"
                }, s, as1, null, null, null);
            }

            
            {
                b = b.this;
                a = as;
                super();
            }
        }, c);
    }

    public final void a(List list, String s)
    {
        b.a(new c(list, s) {

            final List a;
            final String b;
            final b c;

            public final void a(SQLiteDatabase sqlitedatabase)
            {
                com.shazam.android.persistence.b.b.a(c, sqlitedatabase, a, b);
            }

            
            {
                c = b.this;
                a = list;
                b = s;
                super();
            }
        });
    }
}
