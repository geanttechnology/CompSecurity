// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.sqlite.SQLiteDatabase;

public final class bix
    implements bjd
{

    private final String a;

    public bix(String s)
    {
        a = s;
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        String s = String.valueOf(a);
        if (s.length() != 0)
        {
            s = "DROP TABLE IF EXISTS ".concat(s);
        } else
        {
            s = new String("DROP TABLE IF EXISTS ");
        }
        sqlitedatabase.execSQL(s);
    }
}
