// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.sqlite.SQLiteDatabase;

public final class biy
    implements bjd
{

    private final String a;

    public biy(String s)
    {
        a = s;
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        String s = a;
        String s1 = String.valueOf("insertionOrder");
        String s2 = String.valueOf("key");
        String s3 = String.valueOf("value");
        String s4 = String.valueOf("sortingValue");
        sqlitedatabase.execSQL((new StringBuilder(String.valueOf(s).length() + 93 + String.valueOf(s1).length() + String.valueOf(s2).length() + String.valueOf(s3).length() + String.valueOf(s4).length())).append("CREATE TABLE ").append(s).append(" (").append(s1).append(" INTEGER PRIMARY KEY AUTOINCREMENT,").append(s2).append(" TEXT KEY,").append(s3).append(" BLOB NOT NULL,").append(s4).append(" INTEGER NOT NULL)").toString());
    }
}
