// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.j;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.l.d.d;
import com.shazam.android.m.b;
import com.shazam.android.persistence.f.e;
import com.shazam.k.n;
import java.util.List;

public final class a
    implements n
{

    private final b a;
    private final d b;

    public a(b b1, d d)
    {
        a = b1;
        b = d;
    }

    public final List a()
    {
        return (List)a.a(new com.shazam.android.m.a() {

            final a a;

            public final Cursor a(SQLiteDatabase sqlitedatabase)
            {
                return sqlitedatabase.query("view_myshazam", e.a, "tagStatus != ?", new String[] {
                    com.shazam.model.Tag.Status.UNSUBMITTED.getDbString()
                }, null, null, "timestamp DESC");
            }

            
            {
                a = a.this;
                super();
            }
        }, b);
    }
}
