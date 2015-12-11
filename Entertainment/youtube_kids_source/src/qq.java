// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.sqlite.SQLiteDatabase;

final class qq
    implements bjd
{

    qq()
    {
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("ALTER TABLE identity ADD COLUMN profile_account_name_proto BLOB");
        sqlitedatabase.execSQL("ALTER TABLE identity ADD COLUMN profile_account_photo_thumbnails_proto BLOB");
        sqlitedatabase.execSQL("ALTER TABLE identity ADD COLUMN profile_mobile_banner_thumbnails_proto BLOB");
    }
}
