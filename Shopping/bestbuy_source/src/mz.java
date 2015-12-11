// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bestbuy.android.providers.SuggestionProvider;

public class mz extends SQLiteOpenHelper
{

    public mz(Context context, int i)
    {
        super(context, "suggestions.db", null, i);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("CREATE TABLE suggestions (_id INTEGER PRIMARY KEY, display1 TEXT UNIQUE ON CONFLICT REPLACE, query TEXT, icon TEXT, date LONG);");
        sqlitedatabase.execSQL(stringbuilder.toString());
        SuggestionProvider.a(sqlitedatabase);
        stringbuilder.delete(0, stringbuilder.length());
        stringbuilder.append("CREATE TABLE storesearchsuggestions (_id INTEGER PRIMARY KEY, display1 TEXT UNIQUE ON CONFLICT REPLACE, query TEXT, icon TEXT, date LONG);");
        sqlitedatabase.execSQL(stringbuilder.toString());
        stringbuilder.delete(0, stringbuilder.length());
        stringbuilder.append("CREATE TABLE dnmsearchsuggestions (_id INTEGER PRIMARY KEY, display1 TEXT UNIQUE ON CONFLICT REPLACE, query TEXT, icon TEXT, date LONG);");
        sqlitedatabase.execSQL(stringbuilder.toString());
        stringbuilder.delete(0, stringbuilder.length());
        stringbuilder.append("CREATE TABLE listidsearchsuggestions (_id INTEGER PRIMARY KEY, display1 TEXT UNIQUE ON CONFLICT REPLACE, query TEXT, icon TEXT, date LONG);");
        sqlitedatabase.execSQL(stringbuilder.toString());
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS suggestions");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS storesearchsuggestions");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS dnmsearchsuggestions");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS listidsearchsuggestions");
        onCreate(sqlitedatabase);
    }
}
