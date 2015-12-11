// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.o;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.b;
import com.shazam.k.c;

public final class a
    implements c
{

    private final b a;

    public a(b b1)
    {
        a = b1;
    }

    public final void a(String s)
    {
        if (com.shazam.b.e.a.c(s))
        {
            a.a(new com.shazam.android.m.c(s) {

                final String a;
                final a b;

                public final void a(SQLiteDatabase sqlitedatabase)
                {
                    ContentValues contentvalues = new ContentValues();
                    contentvalues.put("key", a);
                    sqlitedatabase.insert("disliked", null, contentvalues);
                }

            
            {
                b = a.this;
                a = s;
                super();
            }
            });
        }
    }

    public final void b(String s)
    {
        if (com.shazam.b.e.a.c(s))
        {
            a.a(new com.shazam.android.m.c(s) {

                final String a;
                final a b;

                public final void a(SQLiteDatabase sqlitedatabase)
                {
                    sqlitedatabase.delete("disliked", "key= ?", new String[] {
                        a
                    });
                }

            
            {
                b = a.this;
                a = s;
                super();
            }
            });
        }
    }

    public final boolean c(String s)
    {
        boolean flag = true;
        if (com.shazam.b.e.a.a(s))
        {
            return false;
        }
        s = a.a(new com.shazam.android.m.a(s) {

            final String a;
            final a b;

            public final Cursor a(SQLiteDatabase sqlitedatabase)
            {
                return sqlitedatabase.rawQuery("select count(key) from disliked where key = ?", new String[] {
                    a
                });
            }

            
            {
                b = a.this;
                a = s;
                super();
            }
        });
        s.moveToFirst();
        if (s.getCount() <= 0 || s.getColumnCount() <= 0 || s.getInt(0) != 1)
        {
            flag = false;
        }
        s.close();
        return flag;
    }
}
