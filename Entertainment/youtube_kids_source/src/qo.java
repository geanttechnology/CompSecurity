// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.sqlite.SQLiteDatabase;

final class qo
    implements bjd
{

    qo()
    {
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE identity (account TEXT,gaia_id TEXT,profile_display_name TEXT,profile_display_email TEXT,profile_thumbnail_uri TEXT, PRIMARY KEY (account,gaia_id) ON CONFLICT REPLACE)");
    }
}
