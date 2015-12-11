// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.digidust.elokence.akinator.db:
//            AkDBAdapter

private static class  extends SQLiteOpenHelper
{

    private static final String CHARACTER_ALREADY_PLAYED_TABLE_CREATE = "create table if not exists characters_already_played( language char(3), id integer(11), award integer(2), name varchar(100), desc varchar(255), baselogiqueid integer(10));";
    private static final String CHARACTER_ALREADY_PLAYED_TABLE_DROP = "DROP table if exists characters_already_played";
    private static final String CHARACTER_ALREADY_PLAYED_TABLE_UPDATE_BASE_LOGIQUE = "ALTER TABLE characters_already_played ADD baselogiqueid integer(10);";
    private static final String CHARACTER_TABLE_CREATE = "create table if not exists character ( id_base integer(11) not null, name text not null, originalName text ,url_photo text not null, original_url_photo text, code_lang text not null);";
    private static final String CHARACTER_TABLE_DROP = "DROP TABLE IF EXISTS character";
    private static final String LANGUAGE_TABLE_DROP = "DROP TABLE IF EXISTS language";
    private static final String MB_CHARACTER_TABLE_DROP = "DROP TABLE IF EXISTS mbcharac";
    private static final String TRADUCTION_TABLE_DROP = "DROP TABLE IF EXISTS traduction";

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("create table if not exists character ( id_base integer(11) not null, name text not null, originalName text ,url_photo text not null, original_url_photo text, code_lang text not null);");
        sqlitedatabase.execSQL("create table if not exists characters_already_played( language char(3), id integer(11), award integer(2), name varchar(100), desc varchar(255), baselogiqueid integer(10));");
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS character");
        sqlitedatabase.execSQL("DROP table if exists characters_already_played");
        onCreate(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (i <= 6)
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS traduction");
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS language");
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS mbcharac");
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS character");
        }
        if (i <= 6 && j >= 7)
        {
            sqlitedatabase.execSQL("create table if not exists character ( id_base integer(11) not null, name text not null, originalName text ,url_photo text not null, original_url_photo text, code_lang text not null);");
            sqlitedatabase.execSQL("ALTER TABLE characters_already_played ADD baselogiqueid integer(10);");
        }
    }

    public (Context context, String s, android.database.sqlite.y y, int i)
    {
        super(context, s, y, i);
    }
}
