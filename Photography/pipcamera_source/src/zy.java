// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

class zy extends ContextWrapper
{

    private final String a;
    private final String b;

    public zy(Context context, String s, String s1)
    {
        super(context);
        b = s;
        a = s1;
    }

    public File getCacheDir()
    {
        return new File(super.getCacheDir(), a);
    }

    public File getDatabasePath(String s)
    {
        File file = new File(super.getDatabasePath(s).getParentFile(), a);
        file.mkdirs();
        return new File(file, s);
    }

    public File getExternalCacheDir()
    {
        return new File(super.getExternalCacheDir(), a);
    }

    public File getExternalFilesDir(String s)
    {
        return new File(super.getExternalFilesDir(s), a);
    }

    public File getFilesDir()
    {
        return new File(super.getFilesDir(), a);
    }

    public SharedPreferences getSharedPreferences(String s, int i)
    {
        return super.getSharedPreferences((new StringBuilder()).append(b).append(":").append(s).toString(), i);
    }

    public SQLiteDatabase openOrCreateDatabase(String s, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory)
    {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(s), cursorfactory);
    }

    public SQLiteDatabase openOrCreateDatabase(String s, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, DatabaseErrorHandler databaseerrorhandler)
    {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(s).getPath(), cursorfactory, databaseerrorhandler);
    }
}
